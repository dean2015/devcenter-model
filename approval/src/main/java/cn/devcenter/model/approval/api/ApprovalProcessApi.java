package cn.devcenter.model.approval.api;

import cn.devcenter.model.approval.ApprovalProcess;
import cn.devcenter.model.approval.ApprovalProcessInstance;
import org.springframework.data.domain.Page;

public interface ApprovalProcessApi {

    void createApprovalProcess(ApprovalProcess approvalProcess);

    <T> Page<ApprovalProcess> getApprovalProcesses(T condition);

    ApprovalProcess getApprovalProcessById(String approvalProcessId);

    void deleteApprovalProcess(String approvalProcessId);
}
