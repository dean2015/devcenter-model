package cn.devcenter.model.approval.api.impl;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import cn.devcenter.model.approval.api.ApprovalProcessInstanceApi;
import cn.devcenter.model.approval.event.*;
import cn.devcenter.model.approval.service.ApprovalProcessInstanceService;
import cn.devcenter.model.approval.service.ApprovalProcessService;
import cn.housecenter.dlfc.framework.boot.stereotype.Service;
import cn.housecenter.dlfc.framework.data.sync.DistributedLock;
import cn.housecenter.dlfc.framework.event.DefaultEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Map;

@Service
public class DefaultApprovalProcessInstanceApi implements ApprovalProcessInstanceApi {

    @Autowired
    private ApprovalProcessInstanceService approvalProcessInstanceService;

    @Autowired
    private DefaultEventBus defaultEventBus;

    @DistributedLock
    @Override
    public void approve(String approvalProcessInstanceId, String approverId, ApprovalState approvalState) {
        ApprovalProcessInstance approvalProcessInstance = getApprovalProcessInstanceById(approvalProcessInstanceId);
        Map<String, ApprovalState> approvalStateMap = approvalProcessInstance.getApprovalState();
        if (approvalStateMap.containsKey(approverId)) {
            approvalStateMap.put(approverId, approvalState);
        }
        approvalProcessInstanceService.update(approvalProcessInstance);
        if (approvalState.equals(ApprovalState.APPROVED)) {
            defaultEventBus.publish(new AfterApprovedApprovalProcessInstanceEvent(approvalProcessInstance));
        } else if (approvalState.equals(ApprovalState.REJECTED)) {
            defaultEventBus.publish(new AfterRejectedApprovalProcessInstanceEvent(approvalProcessInstance));
        } else {
            // do nothing
        }
    }

    @Override
    public void createApprovalProcessInstance(ApprovalProcessInstance approvalProcessInstance) {
        approvalProcessInstanceService.create(approvalProcessInstance);
        defaultEventBus.publish(new AfterCreateApprovalProcessInstanceEvent(approvalProcessInstance));
    }

    @Override
    public <T> Page<ApprovalProcessInstance> getApprovalProcessInstances(T condition) {
        return approvalProcessInstanceService.select(condition);
    }

    @Override
    public ApprovalProcessInstance getApprovalProcessInstanceById(String approvalProcessInstanceId) {
        Page<ApprovalProcessInstance> approvalProcessInstances = approvalProcessInstanceService.select(approvalProcessInstanceId);
        if (approvalProcessInstances.getSize() > 0) {
            return approvalProcessInstances.getContent().get(0);
        }
        return null;
    }

    @Override
    public void deleteApprovalProcessInstance(String approvalProcessInstanceId) {
        ApprovalProcessInstance approvalProcessInstance = getApprovalProcessInstanceById(approvalProcessInstanceId);
        approvalProcessInstanceService.remove(approvalProcessInstanceId);
        defaultEventBus.publish(new AfterDeleteApprovalProcessInstanceEvent(approvalProcessInstance));
    }

}
