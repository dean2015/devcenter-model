package cn.devcenter.model.approval;

import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ApprovalProcessInstance {

    private Serializable id;

    private ApprovalState approvalState;

    private Serializable approver;

    private Serializable approvalItem;

    private Serializable approvedUser;

    private Serializable approvalProcessId;

    private Serializable nextProcessId;

}
