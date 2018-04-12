package cn.devcenter.model.authentication.api;

import cn.devcenter.model.authentication.AppModel;
import cn.devcenter.model.result.ExecutionResult;

public interface AppApi {

    /**
     * App authenticate
     *
     * @param appId
     * @param appSecret
     * @param redirectUri
     * @return
     */
    ExecutionResult<AppModel> authenticate(String appId, String appSecret, String redirectUri);

    /**
     * App authenticate
     *
     * @param appId
     * @param redirectUri
     * @return
     */
    ExecutionResult<AppModel> authenticate(String appId, String redirectUri);

}
