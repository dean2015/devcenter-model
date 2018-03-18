package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.authority.api.UriRoleApi;
import cn.devcenter.model.authority.dao.UriRoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultUriRoleApi implements UriRoleApi {

    @Autowired
    private UriRoleDAO uriRoleDAO;

    @Override
    public ExecutionResult<UriRole> register(UriRole uriRole) {
        UriRole savedUriRole = uriRoleDAO.save(uriRole);
        return ExecutionResult.newInstance(UriRole.class).success(savedUriRole);
    }

    @Override
    public ExecutionResult<Void> unableUriRole(String id) {
        UriRole uriRole = new UriRole();
        uriRole.setId(id);
        uriRole.setEnabled(false);
        uriRoleDAO.update(uriRole);
        return ExecutionResult.newInstance(Void.class).success("UriRole unabled.");
    }

    @Override
    public ExecutionResult<Void> enableUriRole(String id) {
        UriRole uriRole = new UriRole();
        uriRole.setId(id);
        uriRole.setEnabled(true);
        uriRoleDAO.update(uriRole);
        return ExecutionResult.newInstance(Void.class).success("UriRole unabled.");
    }

    @Override
    public ExecutionResult<UriRole> findById(String id) {
        UriRole uriRole = uriRoleDAO.findById(id);
        return ExecutionResult.newInstance(UriRole.class).success(uriRole);
    }

    @Override
    public ExecutionResult<Page<UriRole>> findAll(Pageable pageable) {
        Page<UriRole> pagedUriRole = uriRoleDAO.findAll(pageable);
        ExecutionResult<Page<UriRole>> result = new ExecutionResult<>();
        return result.success("Find uri roles", pagedUriRole);
    }

}
