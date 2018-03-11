package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.api.RoleApi;
import cn.devcenter.model.authority.dao.RoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public class DefaultRoleApi implements RoleApi {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public ExecutionResult<Role> register(Role role) {
        Role savedRole = roleDAO.save(role);
        return ExecutionResult.newInstance(Role.class).success(savedRole);
    }

    @Override
    public ExecutionResult<Void> unableRole(Serializable id) {
        Role role = new Role();
        role.setId(id);
        role.setEnabled(false);
        roleDAO.update(role);
        return ExecutionResult.newInstance(Void.class).success("Role unabled.");
    }

    @Override
    public ExecutionResult<Void> enableRole(Serializable id) {
        Role role = new Role();
        role.setId(id);
        role.setEnabled(true);
        roleDAO.update(role);
        return ExecutionResult.newInstance(Void.class).success("Role enabled.");
    }

    @Override
    public ExecutionResult<Role> findById(Serializable id) {
        Role role = roleDAO.findById(id);
        return ExecutionResult.newInstance(Role.class).success(role);
    }

    @Override
    public <E> ExecutionResult<Page<Role>> find(E condition, Pageable pageable) {
        Page<Role> pagedRole = roleDAO.find(condition, pageable);
        ExecutionResult<Page<Role>> result = new ExecutionResult<>();
        return result.success(pagedRole);
    }
}
