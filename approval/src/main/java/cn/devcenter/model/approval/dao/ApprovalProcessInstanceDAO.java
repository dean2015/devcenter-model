package cn.devcenter.model.approval.dao;

import cn.devcenter.model.approval.ApprovalProcessInstance;
import cn.devcenter.model.repository.BaseRepository;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface ApprovalProcessInstanceDAO extends BaseRepository<ApprovalProcessInstance> {

    List<ApprovalProcessInstance> findByApprovalProcessId(Serializable id);

}
