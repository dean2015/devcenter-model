package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import cn.devcenter.model.approval.api.ApprovalProcessInstanceApi;
import cn.devcenter.model.approval.dao.ApprovalProcessDAO;
import cn.devcenter.model.approval.event.AfterApprovedApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterCreateApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterDeleteApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.event.AfterRejectedApprovalProcessInstanceEvent;
import cn.devcenter.model.approval.dao.ApprovalProcessInstanceDAO;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import cn.housecenter.dlfc.framework.data.sync.DistributedLock;
import cn.housecenter.dlfc.framework.event.DefaultEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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
    private DefaultEventBus defaultEventBus;

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
            newInstance.setApprovedUserId(approvalProcessInstance.getApprovedUserId());
            approvalProcessInstanceDAO.save(newInstance);
        }
    }

    @DistributedLock
    @Override
    @Transactional
    public void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState) {
        ApprovalProcessInstance approvalProcessInstance = getApprovalProcessInstanceById(approvalProcessInstanceId);
        approvalProcessInstance.setApprovalState(approvalState);
        approvalProcessInstanceDAO.update(approvalProcessInstance);
        if (ApprovalState.APPROVED.equals(approvalState)) {
            defaultEventBus.publish(new AfterApprovedApprovalProcessInstanceEvent(approvalProcessInstance));
            moveNextProcess(approvalProcessInstance);
        } else if (ApprovalState.REJECTED.equals(approvalState)) {
            defaultEventBus.publish(new AfterRejectedApprovalProcessInstanceEvent(approvalProcessInstance));
        } else {
            // do nothing
        }
    }

    @Override
    public void createApprovalProcessInstance(ApprovalProcessInstance approvalProcessInstance) {
        approvalProcessInstanceDAO.save(approvalProcessInstance);
        defaultEventBus.publish(new AfterCreateApprovalProcessInstanceEvent(approvalProcessInstance));
    }

    @Override
    public <T> Page<ApprovalProcessInstance> getApprovalProcessInstances(T condition, Pageable pageable) {
        return approvalProcessInstanceDAO.find(condition, pageable);
    }

    @Override
    public ApprovalProcessInstance getApprovalProcessInstanceById(Serializable approvalProcessInstanceId) {
        return approvalProcessInstanceDAO.findById(approvalProcessInstanceId);
    }

    @Override
    public void deleteApprovalProcessInstance(Serializable approvalProcessInstanceId) {
        ApprovalProcessInstance approvalProcessInstance = getApprovalProcessInstanceById(approvalProcessInstanceId);
        approvalProcessInstanceDAO.delete(approvalProcessInstanceId);
        defaultEventBus.publish(new AfterDeleteApprovalProcessInstanceEvent(approvalProcessInstance));
    }

}
