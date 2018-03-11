package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.api.ApprovalProcessApi;
import cn.devcenter.model.approval.dao.ApprovalProcessDAO;
import cn.devcenter.model.approval.event.AfterCreateApprovalProcessEvent;
import cn.devcenter.model.approval.event.AfterDeleteApprovalProcessEvent;
import cn.devcenter.model.eventbus.EventPublisher;
import cn.devcenter.model.repository.exception.NotSupportedException;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultApprovalProcessApi implements ApprovalProcessApi {

    @Autowired
    private ApprovalProcessDAO approvalProcessService;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public ApprovalProcess save(ApprovalProcess approvalProcess) {
        ApprovalProcess ap = approvalProcessService.save(approvalProcess);
        eventPublisher.publish(new AfterCreateApprovalProcessEvent(ap));
        return ap;
    }

    @Override
    public <T> Page<ApprovalProcess> find(T condition, Pageable pageable) {
        return approvalProcessService.find(condition, pageable);
    }

    @Override
    public ApprovalProcess findById(Serializable approvalProcessId) {
        return approvalProcessService.findById(approvalProcessId);
    }

    @Override
    public Serializable delete(Serializable approvalProcessId) {
        ApprovalProcess approvalProcess = findById(approvalProcessId);
        approvalProcessService.delete(approvalProcessId);
        eventPublisher.publish(new AfterDeleteApprovalProcessEvent(approvalProcess));
        return approvalProcess.getId();
    }

    @Override
    public Serializable update(ApprovalProcess object) {
        throw new NotSupportedException();
    }

}
