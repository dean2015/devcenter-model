package cn.devcenter.model.token.dao;

import cn.devcenter.model.repository.CurdRepository;
import cn.devcenter.model.token.UserIdentity;

import java.io.Serializable;

public interface UserIdentityDAO extends CurdRepository<UserIdentity, Serializable> {
}
