package cn.devcenter.model.approval;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Data
public class ApprovalProcessInstance {

    private Serializable id;

    private ApprovalState approvalState;

    private Serializable approver;

    private Object approvalItem;

    private Serializable approvedUserId;

    private Serializable approvalProcessId;

    private Serializable nextProcessId;

}
