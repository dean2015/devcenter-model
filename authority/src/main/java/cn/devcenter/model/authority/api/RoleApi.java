package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.result.ExecutionResult;

import java.io.Serializable;

public interface RoleApi {

    ExecutionResult<Role> register(Role role);

    ExecutionResult<Void> unableRole(Serializable id);

    ExecutionResult<Void> enableRole(Serializable id);

    ExecutionResult<Role> findById(Serializable id);

}
