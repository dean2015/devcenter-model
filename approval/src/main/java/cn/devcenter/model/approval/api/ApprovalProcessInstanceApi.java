package cn.devcenter.model.approval.api;

import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface ApprovalProcessInstanceApi {

    void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState);

    void createApprovalProcessInstance(ApprovalProcessInstance approvalProcessInstance);

    <T> Page<ApprovalProcessInstance> getApprovalProcessInstances(T condition, Pageable pageable);

    ApprovalProcessInstance getApprovalProcessInstanceById(Serializable approvalProcessInstanceId);

    void deleteApprovalProcessInstance(Serializable approvalProcessInstanceId);

}
