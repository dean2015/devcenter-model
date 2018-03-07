package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import cn.devcenter.model.approval.api.ApprovalProcessApi;
import cn.devcenter.model.approval.api.ApprovalProcessInstanceApi;
import cn.devcenter.model.approval.event.AfterCreateApprovalProcessEvent;
import cn.devcenter.model.approval.event.AfterDeleteApprovalProcessEvent;
import cn.devcenter.model.approval.service.ApprovalProcessService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import cn.housecenter.dlfc.framework.event.DefaultEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class DefaultApprovalProcessApi implements ApprovalProcessApi {

    @Autowired
    private ApprovalProcessService approvalProcessService;

    @Autowired
    private DefaultEventBus defaultEventBus;

    @Override
    public void createApprovalProcess(ApprovalProcess approvalProcess) {
        approvalProcessService.create(approvalProcess);
        defaultEventBus.publish(new AfterCreateApprovalProcessEvent(approvalProcess));
    }

    @Override
    public <T> Page<ApprovalProcess> getApprovalProcesses(T condition) {
        return approvalProcessService.select(condition);
    }

    @Override
    public ApprovalProcess getApprovalProcessById(String approvalProcessId) {
        Page<ApprovalProcess> approvalProcesses = approvalProcessService.select(approvalProcessId);
        if (approvalProcesses.getSize() > 0) {
            return approvalProcesses.getContent().get(0);
        }
        return null;
    }

    @Override
    public void deleteApprovalProcess(String approvalProcessId) {
        ApprovalProcess approvalProcess = getApprovalProcessById(approvalProcessId);
        approvalProcessService.remove(approvalProcessId);
        defaultEventBus.publish(new AfterDeleteApprovalProcessEvent(approvalProcess));
    }
}
