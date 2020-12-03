package com.forward.system.vo;

import lombok.Data;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/12/4
 */
@Data
public class UserVo {

    private String username;    //用户名
    private String nickname;    //昵称
    private String email;       //邮箱
    private Integer sex;        //性别
    private Long departmentId;  //部门
}
