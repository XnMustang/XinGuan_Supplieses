package com.forward.response;

/**
 * @Description: 响应状态实现
 * @Author : 王俊
 * @date :  2020/12/3
 */
public enum ResultCode implements CustomizeResultCode{
    /**
     * 200成功
     * 201失败
     * 305密码不正确
     * 306尚未登录
     * 307算数异常
     * 308用户不存在
     * 309部门不存在
     * 205没有找到这条历史消息！有人入侵数据库强制删除了！
     * 404没有找到对应的请求路径
     * 500服务器异常,停止处理
     * 601未知异常
     */
    SUCCESS(200,"成功"),
    ERROR(201,"失败"),
    PASS_NOT_CORRECT(305,"密码不正确！请重新尝试！"),
    NOT_LOGIN(306,"尚未登录！"),
    ARITHENTIC_EXCEPTION(307,"算数异常！"),
    USER_NOT_EXIST_EXCEPTION(308,"用户不存在！"),
    DEPT_NOT_EXIST_EXCEPTION(309,"未查询到部门信息！"),
    INTRODUCTION_NOT_FOUND(205,"没有找到这条历史消息！有人入侵数据库强制删除了！"),
    PAGE_NOT_FOUND(404,"没有找到对应的请求路径!"),
    INTERNAL_SERVER_ERROR(500,"服务器异常！停止处理！"),
    UNKNOW_SERVERERROR(601,"未知异常！");

    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
