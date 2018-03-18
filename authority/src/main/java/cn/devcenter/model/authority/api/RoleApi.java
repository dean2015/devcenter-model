package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface RoleApi {

    ExecutionResult<Role> register(Role role);

    ExecutionResult<Void> unableRole(String id);

    ExecutionResult<Void> enableRole(String id);

    ExecutionResult<Role> findById(String id);

    ExecutionResult<Page<Role>> findAll(Pageable pageable);
}
