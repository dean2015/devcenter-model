package cn.devcenter.model.approval.service;

import cn.devcenter.model.approval.ApprovalProcessInstance;
import org.springframework.data.domain.Page;

public interface ApprovalProcessInstanceService {

    void create(ApprovalProcessInstance approvalProcessInstance);

    <T> Page<ApprovalProcessInstance> select(T condition);

    void remove(String approvalProcessInstanceId);

    void update(ApprovalProcessInstance approvalProcessInstance);

}
