package cn.devcenter.model.approval.api;

import cn.devcenter.model.approval.ApprovalProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface ApprovalProcessApi {

    void createApprovalProcess(ApprovalProcess approvalProcess);

    <T> Page<ApprovalProcess> getApprovalProcesses(T condition, Pageable pageable);

    ApprovalProcess getApprovalProcessById(Serializable approvalProcessId);

    void deleteApprovalProcess(Serializable approvalProcessId);
}
