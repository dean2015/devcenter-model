package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.AuthenticationRole;
import cn.devcenter.model.authority.Role;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthenticationRoleApi {

    ExecutionResult<AuthenticationRole> bind(AuthenticationRole authenticationRole);

    ExecutionResult<String> unbind(String id);

    ExecutionResult<AuthenticationRole> findById(String id);

    ExecutionResult<Page<AuthenticationRole>> findAll(Pageable pageable);

    ExecutionResult<Page<Role>> findRoleByAuthenticationId(String authenticationId, Pageable pageable);

}
