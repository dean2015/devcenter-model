package cn.devcenter.model.authentication.api.impl;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.authentication.api.AuthenticationApi;
import cn.devcenter.model.authentication.dao.AuthenticationDAO;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultAuthenticationApi implements AuthenticationApi {

    private final AuthenticationDAO authenticationDAO;

    @Autowired
    public DefaultAuthenticationApi(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }

    @Override
    public ExecutionResult<Boolean> authenticate(String id, String secret) {
        Authentication authentication = authenticationDAO.findById(id);
        if (null != authentication && authentication.getId().equals(id) && authentication.getSecret().equals(secret)) {
            return ExecutionResult.newInstance(Boolean.class).success("", true);
        }
        return ExecutionResult.newInstance(Boolean.class).fail("", false);
    }

}
