package cn.devcenter.model.approval;

import lombok.Data;

import java.util.Set;

@Data
public class ApprovalProcess {

    private String id;

    private Set<String> approvers;

    private Integer level;

    private String nextProcessId;

}
