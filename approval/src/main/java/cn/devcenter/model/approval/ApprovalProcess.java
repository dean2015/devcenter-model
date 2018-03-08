package cn.devcenter.model.approval;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ApprovalProcess {

    private Serializable id;

    private Set<Serializable> approvers;

    private Serializable nextProcessId;

}
