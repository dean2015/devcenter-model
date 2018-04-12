package cn.devcenter.model.authentication.api.impl;

import cn.devcenter.model.authentication.AppModel;
import cn.devcenter.model.authentication.api.AppApi;
import cn.devcenter.model.authentication.dao.AppDAO;
import cn.devcenter.model.result.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gaosong
 */
public class DefaultAppApi implements AppApi {

    private final AppDAO appDAO;

    @Autowired
    public DefaultAppApi(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @Override
    public ExecutionResult<AppModel> authenticate(String appId, String appSecret, String redirectUri) {
        AppModel appModel = appDAO.findById(appId);
        if (appModel != null && appModel.getAppId().equals(appId) && appModel.getAppSecret().equals(appSecret) && appModel.getRedirectUri().equals(redirectUri)) {
            return ExecutionResult.newInstance(AppModel.class).success("Authenticated successfully", appModel);
        }
        return ExecutionResult.newInstance(AppModel.class).fail("Fail to authenticate");
    }

    @Override
    public ExecutionResult<AppModel> authenticate(String appId, String redirectUri) {
        AppModel appModel = appDAO.findById(appId);
        if (appModel != null && appModel.getAppId().equals(appId) && appModel.getRedirectUri().equals(redirectUri)) {
            return ExecutionResult.newInstance(AppModel.class).success("Authenticated successfully", appModel);
        }
        return ExecutionResult.newInstance(AppModel.class).fail("Fail to authenticate");
    }


}
