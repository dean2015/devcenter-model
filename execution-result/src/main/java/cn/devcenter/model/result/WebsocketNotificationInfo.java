package cn.devcenter.model.result;

import lombok.Data;

/**
 * WebSocket通知信息描述类
 */
@Data
public class WebsocketNotificationInfo {

    /**
     * 要通知的用户标识
     */
    private String user;
    /**
     * 通知的具体内容数据
     */
    private Object data;

}
