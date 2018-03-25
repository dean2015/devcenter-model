package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.Uri;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.authority.api.UriRoleApi;
import cn.devcenter.model.authority.dao.RoleDAO;
import cn.devcenter.model.authority.dao.UriDAO;
import cn.devcenter.model.authority.dao.UriRoleDAO;
import cn.devcenter.model.repository.Page;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUriRoleApi implements UriRoleApi {

    private final UriRoleDAO uriRoleDAO;

    private final RoleDAO roleDAO;

    private final UriDAO uriDAO;

    @Autowired
    public DefaultUriRoleApi(UriRoleDAO uriRoleDAO, RoleDAO roleDAO, UriDAO uriDAO) {
        this.uriRoleDAO = uriRoleDAO;
        this.roleDAO = roleDAO;
        this.uriDAO = uriDAO;
    }

    @Override
    public ExecutionResult<UriRole> bind(UriRole uriRole) {
        UriRole savedUriRole = uriRoleDAO.save(uriRole);
        return ExecutionResult.newInstance(UriRole.class).success(savedUriRole);
    }

    @Override
    public ExecutionResult<String> unbind(String id) {
        Serializable deletedId = uriRoleDAO.deleteById(id);
        if (null == deletedId) {
            return ExecutionResult.newInstance(String.class).fail("Unbind UriRole failed");
        }
        return ExecutionResult.newInstance(String.class).success("Unbind UriRole", id);
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

    @Override
    public ExecutionResult<Page<Role>> findRolesByUri(String uriId, Pageable pageable) {
        Page<UriRole> pagedUriRole = uriRoleDAO.findByUri(uriId, pageable);
        final List<Role> collection = new ArrayList<>();
        pagedUriRole.getContent().forEach(uriRole -> {
            Role role = roleDAO.findById(uriRole.getRoleId());
            if (null != role) {
                collection.add(role);
            }
        });
        Page<Role> pagedRole = new Page<>(collection, pagedUriRole.getTotal(), pagedUriRole.getPage(), pagedUriRole.getSize());
        ExecutionResult<Page<Role>> result = new ExecutionResult<>();
        return result.success("Find roles", pagedRole);
    }

    @Override
    public ExecutionResult<Page<Uri>> findUrisByRole(String roleId, Pageable pageable) {
        Page<UriRole> pagedUriRole = uriRoleDAO.findByRole(roleId, pageable);
        final List<Uri> collection = new ArrayList<>();
        pagedUriRole.getContent().forEach(uriRole -> {
            Uri uri = uriDAO.findById(uriRole.getUriId());
            if (null != uri) {
                collection.add(uri);
            }
        });
        Page<Uri> pagedUri = new Page<>(collection, pagedUriRole.getTotal(), pagedUriRole.getPage(), pagedUriRole.getSize());
        ExecutionResult<Page<Uri>> result = new ExecutionResult<>();
        return result.success("Find uris", pagedUri);
    }

}
