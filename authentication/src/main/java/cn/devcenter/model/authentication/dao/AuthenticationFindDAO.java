package cn.devcenter.model.authentication.dao;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.repository.BaseConditionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthenticationFindDAO<T> extends BaseConditionRepository<T> {

    Page<Authentication> find(T condition, Pageable pageable);

}
