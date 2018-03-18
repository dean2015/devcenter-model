package cn.devcenter.model.authentication.dao;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.authentication.FindCondition;
import cn.devcenter.model.repository.BaseConditionRepository;
import cn.devcenter.model.repository.CurdRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface AuthenticationFindDAO<T> extends BaseConditionRepository<T> {

    Page<Authentication> find(T condition, Pageable pageable);

}
