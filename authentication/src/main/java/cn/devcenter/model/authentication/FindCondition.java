package cn.devcenter.model.authentication;

import java.io.Serializable;

public class FindCondition extends Authentication {

    public FindCondition(Serializable id, Serializable secret) {
        setId(id);
        setSecret(secret);
    }
}
