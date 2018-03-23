package cn.devcenter.model.token.api;

import cn.devcenter.model.repository.CurdRepository;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.token.AccessToken;

import java.io.Serializable;

public interface AccessTokenApi {

    ExecutionResult<AccessToken> create(AccessToken accessToken);

    ExecutionResult<AccessToken> update(AccessToken accessToken);

    ExecutionResult<AccessToken> findByToken(String accessToken);

    ExecutionResult<AccessToken> refresh(String accessToken, String freshToken);

}
