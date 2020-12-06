package com.forward.system.enums;

/**
 * @Description: 用户类型
 * @Author : 王俊
 * @date :  2020/12/7
 */
public enum UserTypeEnum {

    //系统管理员admin
    SYSTEM_ADMIN(0),

    //系统普通用户
    SYSTEM_USER(1);

    private int typeCode;

    UserTypeEnum(int typeCode){
        this.typeCode = typeCode;
    }

    public int getTypeCode(){
        return typeCode;
    }

    public void setTypeCode(){
        this.typeCode = typeCode;
    }

}
