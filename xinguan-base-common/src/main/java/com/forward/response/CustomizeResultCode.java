package com.forward.response;

/**
 * @Description: 响应状态接口
 * @Author : 王俊
 * @date :  2020/12/3
 */
public interface CustomizeResultCode {

    /**
     * 获取错误状态码
     * @return 错误状态码
     */
    Integer getCode();

    /**
     * 获取错误消息
     * @return 错误消息
     */
    String getMessage();

}
