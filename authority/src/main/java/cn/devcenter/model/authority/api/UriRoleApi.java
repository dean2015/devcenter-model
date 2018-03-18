package cn.devcenter.model.authority.api;

import cn.devcenter.model.authority.Role;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.result.ExecutionResult;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface UriRoleApi {

    ExecutionResult<UriRole> register(UriRole uriRole);

    ExecutionResult<Void> unableUriRole(String id);

    ExecutionResult<Void> enableUriRole(String id);

    ExecutionResult<UriRole> findById(String id);

    ExecutionResult<Page<UriRole>> findAll(Pageable pageable);

}
