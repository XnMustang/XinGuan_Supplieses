package com.forward.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
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
@ExcelTarget("UserInfo")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "ID",width = 10)
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Excel(name = "用户名")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Excel(name = "昵称")
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @Excel(name = "邮箱",width = 20)
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @Excel(name = "联系电话",width = 15)
    @ApiModelProperty(value = "联系电话")
    private String phoneNumber;

    @Excel(name = "状态",replace = {"锁定_0","有效_1"})
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private Integer status;

    /**
     * 创建时间  和 修改时间字段，有多个类都含有，可以做成一个公共类，其他类继承实现即可
     */
    @Excel(name = "创建时间",format = "yyyy-MM-dd",width = 15)
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Excel(name = "修改时间",format = "yyyy-MM-dd",width = 15)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    @Excel(name = "性别",replace = {"男_0","女_1"})
    @ApiModelProperty(value = "性别 0男 1女 2保密")
    private Integer sex;

    @ApiModelProperty(value = "盐")
    private String salt;

    @Excel(name = "权限",replace = {"超级管理员_0","系统用户_1"})
    @ApiModelProperty(value = "0:超级管理员，1：系统用户")
    private Integer type;

    @ApiModelProperty(value = "密码")
    private String password;

    @Excel(name = "生日",format = "yyyy-MM-dd",width = 15)
    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birth;

    @Excel(name = "部门")
    @ApiModelProperty(value = "部门id")
    private Long departmentId;

    @Excel(name = "删除状态",replace = {"未删除_false","已删除_true"})
    @ApiModelProperty(value = "0:未删除，1:已删除")
    private Boolean deleted;

    /**
     * 这里是虚拟字段，由UserMapper.xml中查询字段起的别名
     */
//    @Excel(name = "部门名称")
    @ApiModelProperty(value = "部门名称")
    @TableField(exist = false)
    private String name;
}
