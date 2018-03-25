package cn.devcenter.model.authority.api.impl;

import cn.devcenter.model.authority.Uri;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.authority.api.UriApi;
import cn.devcenter.model.authority.api.UriRoleApi;
import cn.devcenter.model.authority.dao.UriDAO;
import cn.devcenter.model.authority.dao.UriRoleDAO;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultUriApi implements UriApi {

    private final UriDAO uriDAO;

    @Autowired
    public DefaultUriApi(UriDAO uriDAO) {
        this.uriDAO = uriDAO;
    }

    @Override
    public ExecutionResult<Uri> create(Uri uri) {
        Uri savedUri = uriDAO.save(uri);
        return ExecutionResult.newInstance(Uri.class).success(savedUri);
    }

    @Override
    public ExecutionResult<String> delete(String id) {
        Serializable deletedId = uriDAO.deleteById(id);
        if (null == deletedId) {
            return ExecutionResult.newInstance(String.class).fail("Delete uri failed");
        }
        return ExecutionResult.newInstance(String.class).success("URI [" + id + "] deleted", id);
    }

    @Override
    public ExecutionResult<String> update(Uri uri) {
        Serializable updatedId = uriDAO.update(uri);
        if (null == updatedId) {
            return ExecutionResult.newInstance(String.class).fail("Update uri failed");
        }
        return ExecutionResult.newInstance(String.class).success("URI [" + uri.getId() + "] updated", uri.getId());
    }

    @Override
    public ExecutionResult<Uri> findById(String id) {
        Uri uri = uriDAO.findById(id);
        return ExecutionResult.newInstance(Uri.class).success(uri);
    }

    @Override
    public ExecutionResult<Page<Uri>> findAll(Pageable pageable) {
        Page<Uri> pagedUri = uriDAO.findAll(pageable);
        ExecutionResult<Page<Uri>> result = new ExecutionResult<>();
        return result.success("Find roles", pagedUri);
    }
}
