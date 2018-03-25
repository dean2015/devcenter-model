package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.Uri;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.repository.Page;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.data.domain.Pageable;

public interface UriRoleApi {

    ExecutionResult<UriRole> bind(UriRole uriRole);

    ExecutionResult<String> unbind(String id);

    ExecutionResult<Void> unableUriRole(String id);

    ExecutionResult<Void> enableUriRole(String id);

    ExecutionResult<UriRole> findById(String id);

    ExecutionResult<Page<UriRole>> findAll(Pageable pageable);

    ExecutionResult<Page<Role>> findRolesByUri(String uriId, Pageable pageable);

    ExecutionResult<Page<Uri>> findUrisByRole(String roleId, Pageable pageable);

}
