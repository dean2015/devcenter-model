package cn.devcenter.model.approval.service;

import cn.devcenter.model.approval.ApprovalProcess;
import org.springframework.data.domain.Page;

public interface ApprovalProcessService {

    void create(ApprovalProcess approvalProcess);

    <T> Page<ApprovalProcess> select(T condition);

    void remove(String approvalProcessId);

    void update(ApprovalProcess approvalProcess);

}
