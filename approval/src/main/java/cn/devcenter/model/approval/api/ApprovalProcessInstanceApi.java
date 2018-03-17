package cn.devcenter.model.approval.api;

import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import cn.devcenter.model.repository.CurdRepository;

import java.io.Serializable;

public interface ApprovalProcessInstanceApi extends CurdRepository<ApprovalProcessInstance, Serializable> {

    void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState);

}
