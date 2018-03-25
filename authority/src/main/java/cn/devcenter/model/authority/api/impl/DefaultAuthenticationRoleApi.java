package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.AuthenticationRole;
import cn.devcenter.model.authority.api.AuthenticationRoleApi;
import cn.devcenter.model.authority.dao.AuthenticationRoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultAuthenticationRoleApi implements AuthenticationRoleApi {

    private final AuthenticationRoleDAO authenticationRoleDAO;

    @Autowired
    public DefaultAuthenticationRoleApi(AuthenticationRoleDAO authenticationRoleDAO) {
        this.authenticationRoleDAO = authenticationRoleDAO;
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

}
