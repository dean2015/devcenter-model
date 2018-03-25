package cn.devcenter.model.token.dao;

import cn.devcenter.model.repository.CurdRepository;
import cn.devcenter.model.token.AccessToken;

import java.io.Serializable;

public interface AccessTokenDAO extends CurdRepository<AccessToken, Serializable> {

    AccessToken findByToken(String token);

    void clear();

}
