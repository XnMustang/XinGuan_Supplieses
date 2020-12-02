package com.forward.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forward.response.Result;
import com.forward.system.entity.User;
import com.forward.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserList")
    public Result findUserList(@RequestParam(required = true,defaultValue = "1") Integer currentPage,
                               @RequestParam(required = true,defaultValue = "7") Integer size){
        //对用户进行分页，注入用户
        Page<User> page = new Page<>(currentPage,size);
        Page<User> userPage = userService.page(page);
        //总记录数
        long total = userPage.getTotal();
        //分页查询出的信息
        List<User> records = userPage.getRecords();
        return Result.ok().data("total",total).data("records",records);
    }

}

