package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import cn.devcenter.model.approval.api.ApprovalProcessInstanceApi;
import cn.devcenter.model.approval.dao.ApprovalProcessDAO;
import cn.devcenter.model.approval.dao.ApprovalProcessInstanceDAO;
import cn.devcenter.model.approval.event.AfterApprovedApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterCreateApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterDeleteApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterRejectedApprovalProcessInstanceEvent;
import cn.devcenter.model.eventbus.EventPublisher;
import cn.devcenter.model.repository.exception.NotSupportedException;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultApprovalProcessInstanceApi implements ApprovalProcessInstanceApi {

    @Autowired
    private ApprovalProcessInstanceDAO approvalProcessInstanceDAO;

    @Autowired
    private ApprovalProcessDAO approvalProcessDAO;

    @Autowired
    private EventPublisher eventPublisher;

    private void moveNextProcess(ApprovalProcessInstance approvalProcessInstance) {
        List<ApprovalProcessInstance> approvalProcessInstanceList = approvalProcessInstanceDAO.findByApprovalProcessId(approvalProcessInstance.getApprovalProcessId());
        boolean isApproved = true;
        for (ApprovalProcessInstance instance : approvalProcessInstanceList) {
            if (!ApprovalState.APPROVED.equals(instance.getApprovalState())) {
                isApproved = false;
            }
        }
        if (!isApproved) {
            return;
        }
        ApprovalProcess nextApprovalProcess = approvalProcessDAO.findById(approvalProcessInstance.getNextProcessId());
        for (Serializable approver : nextApprovalProcess.getApprovers()) {
            ApprovalProcessInstance newInstance = new ApprovalProcessInstance();
            newInstance.setId(UUID.randomUUID().toString());
            newInstance.setApprover(approver);
            newInstance.setApprovalState(ApprovalState.INIT);
            newInstance.setApprovalItem(approvalProcessInstance.getApprovalItem());
            newInstance.setApprovalProcessId(nextApprovalProcess.getId());
            newInstance.setNextProcessId(nextApprovalProcess.getNextProcessId());
            newInstance.setApprovedUser(approvalProcessInstance.getApprovedUser());
            approvalProcessInstanceDAO.save(newInstance);
        }
    }

    @Override
    public void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState) {
        ApprovalProcessInstance approvalProcessInstance = findById(approvalProcessInstanceId);
        approvalProcessInstance.setApprovalState(approvalState);
        approvalProcessInstanceDAO.update(approvalProcessInstance);
        if (ApprovalState.APPROVED.equals(approvalState)) {
            eventPublisher.publish(new AfterApprovedApprovalProcessInstanceEvent(approvalProcessInstance));
            moveNextProcess(approvalProcessInstance);
        } else if (ApprovalState.REJECTED.equals(approvalState)) {
            eventPublisher.publish(new AfterRejectedApprovalProcessInstanceEvent(approvalProcessInstance));
        } else {
            // do nothing
        }
    }

    @Override
    public ApprovalProcessInstance save(ApprovalProcessInstance approvalProcessInstance) {
        ApprovalProcessInstance api = approvalProcessInstanceDAO.save(approvalProcessInstance);
        eventPublisher.publish(new AfterCreateApprovalProcessInstanceEvent(api));
        return api;
    }

    @Override
    public <T> Page<ApprovalProcessInstance> find(T condition, Pageable pageable) {
        return approvalProcessInstanceDAO.find(condition, pageable);
    }

    @Override
    public ApprovalProcessInstance findById(Serializable approvalProcessInstanceId) {
        return approvalProcessInstanceDAO.findById(approvalProcessInstanceId);
    }

    @Override
    public Serializable delete(Serializable approvalProcessInstanceId) {
        ApprovalProcessInstance approvalProcessInstance = findById(approvalProcessInstanceId);
        approvalProcessInstanceDAO.delete(approvalProcessInstanceId);
        eventPublisher.publish(new AfterDeleteApprovalProcessInstanceEvent(approvalProcessInstance));
        return approvalProcessInstance.getId();
    }

    @Override
    public Serializable update(ApprovalProcessInstance object) {
        throw new NotSupportedException();
    }

}
