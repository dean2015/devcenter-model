package cn.devcenter.model.approval.api;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import org.springframework.data.domain.Page;

public interface ApprovalProcessInstanceApi {

    void approve(String approvalProcessInstanceId, String approverId, ApprovalState approvalState);

    void createApprovalProcessInstance(ApprovalProcessInstance approvalProcessInstance);

    <T> Page<ApprovalProcessInstance> getApprovalProcessInstances(T condition);

    ApprovalProcessInstance getApprovalProcessInstanceById(String approvalProcessInstanceId);

    void deleteApprovalProcessInstance(String approvalProcessInstanceId);

}
