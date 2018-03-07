package cn.devcenter.model.approval;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class ApprovalProcessInstance {

    private Map<String, ApprovalState> approvalState;

    private Integer currentLevel;

    private ApprovalProcess approvalProcess;

    private Object approvalItem;

    private String approvalId;

}
