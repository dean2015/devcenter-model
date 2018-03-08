package cn.devcenter.model.approval.api;

import cn.devcenter.model.apitemplate.CurdTemplate;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.approval.ApprovalState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface ApprovalProcessInstanceApi extends CurdTemplate<ApprovalProcessInstance> {

    void approve(Serializable approvalProcessInstanceId, Serializable approverId, ApprovalState approvalState);

}
