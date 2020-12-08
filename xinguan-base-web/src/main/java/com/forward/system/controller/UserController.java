package com.forward.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forward.response.Result;
import com.forward.response.ResultCode;
import com.forward.system.entity.User;
import com.forward.system.service.UserService;
import com.forward.system.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理",tags = "用户管理接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiModelProperty(value = "用户列表",notes = "分页查询用户信息")
    @PostMapping("/findUserPage")
    public Result findUserPage(@RequestParam(required = true,defaultValue = "1") Integer current,
                               @RequestParam(required = true,defaultValue = "6") Integer size,
                               @RequestBody UserVo userVo){
        //对用户进行分页，注入用户
        Page<User> page = new Page<>(current,size);
        QueryWrapper<User> wrapper = getWrapper(userVo);
        IPage<User> userPage = userService.findUserPage(page,wrapper);
        //总记录数
        long total = userPage.getTotal();
        //分页查询出的信息
        List<User> records = userPage.getRecords();
        return Result.ok().data("total",total).data("records",records);
    }

    @ApiModelProperty(value = "添加用户",notes = "添加用户信息")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        try {
            userService.addUser(user);
            return Result.ok();
        }catch (Exception e){
            //打印日志信息
            return Result.error();
        }
    }

    @ApiModelProperty(value = "查询所有用户",notes = "查询所有用户信息")
    @GetMapping("/findAllUser")
    public Result findAllUser(){
        try {
            List<User> users = userService.findAllUser();
            return Result.ok().data("users",users);
        }catch (Exception e){
            return Result.error();
        }
    }

    private QueryWrapper<User> getWrapper(UserVo userVo){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(userVo != null){
            if(!StringUtils.isEmpty(userVo.getDepartmentId())){
                queryWrapper.eq("department_id",userVo.getDepartmentId());
            }
            if(!StringUtils.isEmpty(userVo.getEmail())){
                queryWrapper.eq("email",userVo.getEmail());
            }
            if(!StringUtils.isEmpty(userVo.getNickname())){
                queryWrapper.eq("nickname",userVo.getNickname());
            }
            if(!StringUtils.isEmpty(userVo.getSex())){
                queryWrapper.eq("sex",userVo.getSex());
            }
            if(!StringUtils.isEmpty(userVo.getUsername())){
                queryWrapper.eq("username",userVo.getUsername());
            }
        }
        return queryWrapper;
    }

}

