package cn.devcenter.model.authentication.dao;

import cn.devcenter.model.authentication.Authentication;
import cn.devcenter.model.repository.CurdRepository;

import java.io.Serializable;

public interface AuthenticationDAO extends CurdRepository<Authentication, Serializable> {
}
