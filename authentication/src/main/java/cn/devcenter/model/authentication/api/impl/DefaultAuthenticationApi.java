package cn.devcenter.model.authentication.api.impl;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.authentication.api.AuthenticationApi;
import cn.devcenter.model.authentication.dao.AuthenticationDAO;
import cn.devcenter.model.stereotype.Service;
import cn.devcenter.model.template.api.exception.NotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultAuthenticationApi implements AuthenticationApi {

    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Override
    public Authentication save(Authentication object) {
        return authenticationDAO.save(object);
    }

    @Override
    public <E> Page<Authentication> find(E condition, Pageable pageable) {
        return authenticationDAO.find(condition, pageable);
    }

    @Override
    public Authentication findById(Serializable id) {
        return authenticationDAO.findById(id);
    }

    @Override
    public Serializable delete(Serializable id) {
        throw new NotSupportedException();
    }

    @Override
    public Serializable update(Authentication object) {
        return authenticationDAO.update(object);
    }
}
