package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.AuthenticationRole;
import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.api.AuthenticationRoleApi;
import cn.devcenter.model.authority.dao.AuthenticationRoleDAO;
import cn.devcenter.model.authority.dao.RoleDAO;
import cn.devcenter.model.repository.Page;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultAuthenticationRoleApi implements AuthenticationRoleApi {

    private final AuthenticationRoleDAO authenticationRoleDAO;

    private final RoleDAO roleDAO;

    @Autowired
    public DefaultAuthenticationRoleApi(AuthenticationRoleDAO authenticationRoleDAO, RoleDAO roleDAO) {
        this.authenticationRoleDAO = authenticationRoleDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public ExecutionResult<AuthenticationRole> bind(AuthenticationRole authenticationRole) {
        AuthenticationRole savedAuthenticationRole = authenticationRoleDAO.save(authenticationRole);
        return ExecutionResult.newInstance(AuthenticationRole.class).success(savedAuthenticationRole);
    }

    @Override
    public ExecutionResult<String> unbind(String id) {
        Serializable deletedId = authenticationRoleDAO.deleteById(id);
        if (null == deletedId) {
            return ExecutionResult.newInstance(String.class).fail("Unbind AuthenticationRole failed");
        }
        return ExecutionResult.newInstance(String.class).success("Unbind AuthenticationRole", id);
    }

    @Override
    public ExecutionResult<AuthenticationRole> findById(String id) {
        AuthenticationRole authenticationRole = authenticationRoleDAO.findById(id);
        return ExecutionResult.newInstance(AuthenticationRole.class).success(authenticationRole);
    }

    @Override
    public ExecutionResult<Page<AuthenticationRole>> findAll(Pageable pageable) {
        Page<AuthenticationRole> pagedAuthenticationRole = authenticationRoleDAO.findAll(pageable);
        ExecutionResult<Page<AuthenticationRole>> result = new ExecutionResult<>();
        return result.success("Find AuthenticationRoles", pagedAuthenticationRole);
    }

    @Override
    public ExecutionResult<Page<Role>> findRoleByAuthenticationId(String authenticationId, Pageable pageable) {
        Page<AuthenticationRole> pagedAuthenticationRole = authenticationRoleDAO.findByAuthenticationId(authenticationId, pageable);
        final List<Role> collection = new ArrayList<>();
        pagedAuthenticationRole.getContent().forEach(authenticationRole -> {
            Role role = roleDAO.findById(authenticationRole.getRoleId());
            if (null != role) {
                collection.add(role);
            }
        });
        Page<Role> pagedRoles = new Page<>(collection, pagedAuthenticationRole.getTotal(), pagedAuthenticationRole.getPage(), pagedAuthenticationRole.getSize());
        ExecutionResult<Page<Role>> result = new ExecutionResult<>();
        return result.success("Find roles", pagedRoles);
    }

}
