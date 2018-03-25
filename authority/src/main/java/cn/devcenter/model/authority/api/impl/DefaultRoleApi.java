package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.api.RoleApi;
import cn.devcenter.model.authority.dao.RoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultRoleApi implements RoleApi {

    private final RoleDAO roleDAO;

    @Autowired
    public DefaultRoleApi(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public ExecutionResult<Role> create(Role role) {
        Role savedRole = roleDAO.save(role);
        return ExecutionResult.newInstance(Role.class).success(savedRole);
    }

    @Override
    public ExecutionResult<Void> unableRole(String id) {
        Role role = new Role();
        role.setId(id);
        role.setEnabled(false);
        roleDAO.update(role);
        return ExecutionResult.newInstance(Void.class).success("Role unabled.");
    }

    @Override
    public ExecutionResult<Void> enableRole(String id) {
        Role role = new Role();
        role.setId(id);
        role.setEnabled(true);
        roleDAO.update(role);
        return ExecutionResult.newInstance(Void.class).success("Role enabled.");
    }

    @Override
    public ExecutionResult<Role> findById(String id) {
        Role role = roleDAO.findById(id);
        return ExecutionResult.newInstance(Role.class).success(role);
    }

    @Override
    public ExecutionResult<Page<Role>> findAll(Pageable pageable) {
        Page<Role> pagedRole = roleDAO.findAll(pageable);
        ExecutionResult<Page<Role>> result = new ExecutionResult<>();
        return result.success("Find roles", pagedRole);
    }

}
