package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.api.ApprovalProcessApi;
import cn.devcenter.model.approval.event.AfterCreateApprovalProcessEvent;
import cn.devcenter.model.approval.event.AfterDeleteApprovalProcessEvent;
import cn.devcenter.model.approval.dao.ApprovalProcessDAO;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import cn.housecenter.dlfc.framework.event.DefaultEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultApprovalProcessApi implements ApprovalProcessApi {

    @Autowired
    private ApprovalProcessDAO approvalProcessService;

    @Autowired
    private DefaultEventBus defaultEventBus;

    @Override
    public void createApprovalProcess(ApprovalProcess approvalProcess) {
        approvalProcessService.save(approvalProcess);
        defaultEventBus.publish(new AfterCreateApprovalProcessEvent(approvalProcess));
    }

    @Override
    public <T> Page<ApprovalProcess> getApprovalProcesses(T condition, Pageable pageable) {
        return approvalProcessService.find(condition, pageable);
    }

    @Override
    public ApprovalProcess getApprovalProcessById(Serializable approvalProcessId) {
        return approvalProcessService.findById(approvalProcessId);
    }

    @Override
    public void deleteApprovalProcess(Serializable approvalProcessId) {
        ApprovalProcess approvalProcess = getApprovalProcessById(approvalProcessId);
        approvalProcessService.delete(approvalProcessId);
        defaultEventBus.publish(new AfterDeleteApprovalProcessEvent(approvalProcess));
    }
}
