package cn.devcenter.model.approval.api;

import cn.devcenter.model.template.api.CurdTemplate;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;

import java.io.Serializable;

public interface ApprovalProcessInstanceApi extends CurdTemplate<ApprovalProcessInstance> {

    void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState);

}
