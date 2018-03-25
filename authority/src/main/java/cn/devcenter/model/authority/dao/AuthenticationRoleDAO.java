package cn.devcenter.model.authority.dao;

import cn.devcenter.model.authority.AuthenticationRole;
import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.repository.CurdRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface AuthenticationRoleDAO extends CurdRepository<AuthenticationRole, Serializable> {

    Page<AuthenticationRole> findByAuthenticationId(String authenticationId, Pageable pageable);

}
