package com.forward.system.enums;

/**
 * @Description: 用户状态
 * @Author : 王俊
 * @date :  2020/12/7
 */
public enum UserStatusEnum {

    //锁定状态
    DISABLE(0),
    //有效状态
    AVAILABLE(1);

    private int statusCode;

    UserStatusEnum(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }
    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

}
