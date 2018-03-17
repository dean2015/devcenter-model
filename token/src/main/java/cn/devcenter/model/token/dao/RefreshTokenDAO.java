package cn.devcenter.model.token.dao;

import cn.devcenter.model.repository.CurdRepository;
import cn.devcenter.model.token.RefreshToken;

import java.io.Serializable;

public interface RefreshTokenDAO extends CurdRepository<RefreshToken, Serializable> {
}
