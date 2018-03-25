package cn.devcenter.model.authority.dao;

import cn.devcenter.model.authority.UriRole;
import cn.devcenter.model.repository.CurdRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface UriRoleDAO extends CurdRepository<UriRole, Serializable> {

    Page<UriRole> findByUri(String uriId, Pageable pageable);

    Page<UriRole> findByRole(String roleId, Pageable pageable);

}
