package cn.devcenter.model.authentication.api.impl;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.authentication.FindCondition;
import cn.devcenter.model.authentication.api.AuthenticationApi;
import cn.devcenter.model.authentication.dao.AuthenticationDAO;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

@Service
public class DefaultAuthenticationApi implements AuthenticationApi {

    private static final int PAGE_INDEX = 0;

    private static final int PAGE_SIZE = Integer.MAX_VALUE;

    private static final int SECRET_LENGTH = 11;

    private static final char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 't', 'u', 'v', 'w', 'x', 'y',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'T', 'U', 'V', 'W', 'X', 'Y',
            '2', '3', '4', '6', '7', '8', '9'};


    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Override
    public ExecutionResult<Authentication> authenticate(String id, String secret) {
        Pageable pageable = PageRequest.of(PAGE_INDEX, PAGE_SIZE);
        Page<Authentication> pagedAuthentication = authenticationDAO.find(new FindCondition(id, secret), pageable);
        if (pagedAuthentication.getSize() > 0) {
            return ExecutionResult.newInstance(Authentication.class).success(pagedAuthentication.getContent().get(0));
        }
        return ExecutionResult.newInstance(Authentication.class).fail("Failed to get authentication with id[" + id + "] and secret[" + secret + "]");
    }

    @Override
    public ExecutionResult<Authentication> authenticate(String id) {
        Authentication authentication = authenticationDAO.findById(id);
        if (null != authentication) {
            return ExecutionResult.newInstance(Authentication.class).success(authentication);
        } else {
            return ExecutionResult.newInstance(Authentication.class).fail("Failed to get authentication with id[" + id + "]");
        }
    }

    @Override
    public ExecutionResult<Authentication> register(Authentication authentication) {
        Authentication savedAuthentication = authenticationDAO.save(authentication);
        return ExecutionResult.newInstance(Authentication.class).success(savedAuthentication);
    }

    @Override
    public ExecutionResult<Void> changeSecret(Authentication authentication) {
        Serializable id = authenticationDAO.update(authentication);
        if (id == null) {
            return ExecutionResult.newInstance(Void.class).fail("Secret not updated");
        } else {
            return ExecutionResult.newInstance(Void.class).success("Secret updated");
        }
    }

    @Override
    public ExecutionResult<Serializable> resetSecret(String id) {
        String secret = RandomStringUtils.random(SECRET_LENGTH, 0, chars.length, true, true, chars);
        Authentication authentication = new Authentication();
        authentication.setId(id);
        authentication.setSecret(secret);
        ExecutionResult<Void> result = changeSecret(authentication);
        if (result.isSuccessful()) {
            return ExecutionResult.newInstance(Serializable.class).success("Secret updated", secret);
        } else {
            return ExecutionResult.newInstance(Serializable.class).fail("Secret updated failed.");
        }
    }

    @Override
    public ExecutionResult<Page<Authentication>> find(Object condition, Pageable pageable) {
        Page<Authentication> pagedAuthentication = authenticationDAO.find((Authentication) condition, pageable);
        ExecutionResult<Page<Authentication>> result = new ExecutionResult<>();
        return result.success(pagedAuthentication);
    }

}
