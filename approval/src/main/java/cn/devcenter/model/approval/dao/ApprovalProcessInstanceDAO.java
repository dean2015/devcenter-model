package cn.devcenter.model.approval.dao;

import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.repository.CurdRepository;

import java.io.Serializable;
import java.util.List;

public interface ApprovalProcessInstanceDAO extends CurdRepository<ApprovalProcessInstance, Serializable> {

    List<ApprovalProcessInstance> findByApprovalProcessId(Serializable id);

}
