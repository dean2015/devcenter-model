package cn.devcenter.model.authentication;

import java.io.Serializable;

public class FindCondition extends Authentication {

    public FindCondition(String id, String secret) {
        setId(id);
        setSecret(secret);
    }
}
