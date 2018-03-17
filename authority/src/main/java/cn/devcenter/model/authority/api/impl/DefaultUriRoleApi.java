package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.authority.api.UriRoleApi;
import cn.devcenter.model.authority.dao.UriRoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public class DefaultUriRoleApi implements UriRoleApi {

    @Autowired
    private UriRoleDAO uriRoleDAO;

    @Override
    public ExecutionResult<UriRole> register(UriRole uriRole) {
        UriRole savedUriRole = uriRoleDAO.save(uriRole);
        return ExecutionResult.newInstance(UriRole.class).success(savedUriRole);
    }

    @Override
    public ExecutionResult<Void> unableUriRole(Serializable id) {
        UriRole uriRole = new UriRole();
        uriRole.setId(id);
        uriRole.setEnabled(false);
        uriRoleDAO.update(uriRole);
        return ExecutionResult.newInstance(Void.class).success("UriRole unabled.");
    }

    @Override
    public ExecutionResult<Void> enableUriRole(Serializable id) {
        UriRole uriRole = new UriRole();
        uriRole.setId(id);
        uriRole.setEnabled(true);
        uriRoleDAO.update(uriRole);
        return ExecutionResult.newInstance(Void.class).success("UriRole unabled.");
    }

    @Override
    public ExecutionResult<UriRole> findById(Serializable id) {
        UriRole uriRole = uriRoleDAO.findById(id);
        return ExecutionResult.newInstance(UriRole.class).success(uriRole);
    }

    @Override
    public <E extends UriRole> ExecutionResult<Page<UriRole>> find(E condition, Pageable pageable) {
        Page<UriRole> pagedUriRole = uriRoleDAO.find(condition, pageable);
        ExecutionResult<Page<UriRole>> result = new ExecutionResult<>();
        return result.success(pagedUriRole);
    }
}
