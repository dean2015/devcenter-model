package cn.devcenter.model.authentication.api;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.result.ExecutionResult;

public interface AuthenticationApi {

    /**
     * Authentication with id and secret.
     *
     * @param id
     * @param secret
     * @return
     */
    ExecutionResult<Authentication> authenticate(String id, String secret);

}
