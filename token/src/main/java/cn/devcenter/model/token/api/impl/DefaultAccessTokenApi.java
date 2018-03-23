package cn.devcenter.model.token.api.impl;

import cn.devcenter.model.repository.model.Record;
import cn.devcenter.model.result.ExecutionResult;
import cn.devcenter.model.stereotype.Service;
import cn.devcenter.model.token.AccessToken;
import cn.devcenter.model.token.RefreshToken;
import cn.devcenter.model.token.api.AccessTokenApi;
import cn.devcenter.model.token.dao.AccessTokenDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.UUID;

@Service
public class DefaultAccessTokenApi implements AccessTokenApi {

    private static final Long ACCESS_TOKEN_EXPIRED_PERIOD = 1000L * 60 * 60 * 24 * 3;

    private static final Long REFRESH_TOKEN_EXPIRED_PERIOD = 1000L * 60 * 60 * 24 * 30;

    private final AccessTokenDAO accessTokenDAO;

    @Autowired
    public DefaultAccessTokenApi(AccessTokenDAO accessTokenDAO) {
        this.accessTokenDAO = accessTokenDAO;
    }

    @Override
    public ExecutionResult<AccessToken> create(AccessToken accessToken) {
        // check client identifier
        if (accessToken.getClientIdentity() == null || StringUtils.isBlank(accessToken.getClientIdentity().getClientIdentifier())) {
            return ExecutionResult.newInstance(AccessToken.class).fail("Client identifier not found");
        }
        // set expired period
        accessToken.setExpiredPeriod(ACCESS_TOKEN_EXPIRED_PERIOD);
        // check token
        if (StringUtils.isBlank(accessToken.getToken())) {
            accessToken.setToken(UUID.randomUUID().toString().replace("-", ""));
        }
        // set refresh token
        Long createTime = System.currentTimeMillis();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(createTime);
        refreshToken.setExpiredPeriod(REFRESH_TOKEN_EXPIRED_PERIOD);
        refreshToken.setRefreshToken(UUID.randomUUID().toString().replace("-", ""));
        refreshToken.setLastUsedAt(createTime);
        accessToken.setRefreshToken(refreshToken);
        // set record
        Record record = new Record(createTime, createTime);
        accessToken.setRecord(record);
        // set enabled
        accessToken.setEnabled(true);
        AccessToken savedAccessToken = accessTokenDAO.save(accessToken);
        return ExecutionResult.newInstance(AccessToken.class).success("AccessToken saved", savedAccessToken);
    }

    @Override
    public ExecutionResult<AccessToken> update(AccessToken accessToken) {
        AccessToken accessTokenIndb = accessTokenDAO.findById(accessToken.getId());
        accessToken.setRecord(accessTokenIndb.getRecord());
        accessToken.getRecord().setLastModifiedTime(System.currentTimeMillis());
        Serializable id = accessTokenDAO.update(accessToken);
        if (id == null || StringUtils.isBlank((String) id)) {
            return ExecutionResult.newInstance(AccessToken.class).fail("update accesstoken: " + accessToken.getToken() + " failed");
        }
        return ExecutionResult.newInstance(AccessToken.class).success("AccessToken updated", accessToken);
    }

    @Override
    public ExecutionResult<AccessToken> findByToken(String accessToken) {
        AccessToken accessTokenObject = accessTokenDAO.findByToken(accessToken);
        if (null == accessTokenObject) {
            return ExecutionResult.newInstance(AccessToken.class).fail("AccessToken [" + accessToken + "] not found");
        }
        if (accessTokenObject.isExpired()) {
            return ExecutionResult.newInstance(AccessToken.class).fail("AccessToken [" + accessToken + "] expired");
        }
        if (!accessTokenObject.isEnabled()) {
            return ExecutionResult.newInstance(AccessToken.class).fail("AccessToken [" + accessToken + "] not available");
        }
        return ExecutionResult.newInstance(AccessToken.class).success("AccessToken found", accessTokenObject);
    }

    @Override
    public ExecutionResult<AccessToken> refresh(String accessToken, String freshToken) {
        ExecutionResult<AccessToken> findResult = findByToken(accessToken);
        if (!findResult.isSuccessful()) {
            return findResult;
        }
        AccessToken accessTokenObject = findResult.getData();
        if (freshToken.equals(accessTokenObject.getRefreshToken().getRefreshToken()) &&
                !accessTokenObject.getRefreshToken().isExpired()) {
            accessTokenObject.setToken(UUID.randomUUID().toString().replace("-", ""));
            accessTokenObject.getRefreshToken().setLastUsedAt(System.currentTimeMillis());
        }
        ExecutionResult<AccessToken> updateResult = update(accessTokenObject);
        if (!findResult.isSuccessful()) {
            return ExecutionResult.newInstance(AccessToken.class).fail("Refresh accessToken failed");
        }
        return ExecutionResult.newInstance(AccessToken.class).success("AccessToken refreshed", updateResult.getData());
    }
}
