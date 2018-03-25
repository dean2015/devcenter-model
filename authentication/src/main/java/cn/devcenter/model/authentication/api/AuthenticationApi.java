package cn.devcenter.model.authentication.api;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.repository.Page;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface AuthenticationApi {

    /**
     * Authentication with id and secret.
     *
     * @param id
     * @param secret
     * @return
     */
    ExecutionResult<Authentication> authenticate(String id, String secret);

    /**
     * Authentication with id only, this interface should be authoritied to sepecific system.
     *
     * @param id
     * @return
     */
    ExecutionResult<Authentication> authenticate(String id);

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
    ExecutionResult<Serializable> resetSecret(String id);

    /**
     * Find the paged list of authentications
     *
     * @param condition
     * @param pageable
     * @return
     */
    <T> ExecutionResult<Page<Authentication>> find(T condition, Pageable pageable);

}
