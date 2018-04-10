package cn.devcenter.model.authentication.dao;

import cn.devcenter.model.authentication.AppModel;
import cn.devcenter.model.repository.CurdRepository;

import java.io.Serializable;

public interface AppDAO extends CurdRepository<AppModel, Serializable> {
}
