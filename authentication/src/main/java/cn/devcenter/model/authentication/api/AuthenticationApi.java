package cn.devcenter.model.authentication.api;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.template.api.CurdTemplate;

import java.io.Serializable;

public interface AuthenticationApi {

    /**
     * Authentication with id and secret.
     *
     * @param id
     * @param secret
     * @return
     */
    ExecutionResult<Authentication> authenticate(Serializable id, Serializable secret);

    /**
     * Authentication with id only, this interface should be authoritied to sepecific system.
     *
     * @param id
     * @return
     */
    ExecutionResult<Authentication> authenticate(Serializable id);

    /**
     * Register a new authentication.
     *
     * @param authentication
     * @return
     */
    ExecutionResult<Authentication> register(Authentication authentication);

    /**
     * Change the secret of an authentication.
     *
     * @param authentication
     * @return
     */
    ExecutionResult<Void> changeSecret(Authentication authentication);

    /**
     * Reset the secret of an authentication.
     *
     * @param id
     * @return
     */
    ExecutionResult<Serializable> resetSecret(Serializable id);
}
