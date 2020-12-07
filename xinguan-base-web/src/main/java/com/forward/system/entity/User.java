package com.forward.system.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    @ApiModelProperty(value = "状态 0锁定 1有效")
    private Integer status;

    /**
     * 创建时间  和 修改时间字段，有多个类都含有，可以做成一个公共类，其他类继承实现即可
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private Integer sex;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "0:超级管理员，1：系统用户")
    private Integer type;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birth;

    @ApiModelProperty(value = "部门id")
    private Long departmentId;

    @ApiModelProperty(value = "0:未删除，1:已删除")
    private Boolean deleted;

    /**
     * 这里是虚拟字段，由UserMapper.xml中查询字段起的别名
     */
    @ApiModelProperty(value = "部门名称")
    @TableField(exist = false)
    private String name;
}
