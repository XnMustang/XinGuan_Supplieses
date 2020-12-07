package com.forward.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forward.handler.BusinessException;
import com.forward.response.ResultCode;
import com.forward.system.entity.Department;
import com.forward.system.entity.User;
import com.forward.system.enums.UserStatusEnum;
import com.forward.system.enums.UserTypeEnum;
import com.forward.system.mapper.DepartmentMapper;
import com.forward.system.mapper.UserMapper;
import com.forward.system.service.DepartmentService;
import com.forward.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 分页查询用户信息
     * @param page
     * @param wrapper
     * @return
     */
    @Override
    public IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper) {
        return this.baseMapper.findUserPage(page,wrapper);
    }

    /**
     * 添加用户
     * @param user 用户对象
     */
    @Override
    public void addUser(User user) {
        //因为用户名不允许重复，所以需要判断
        String username = user.getUsername();
        //获取部门  ，判断部门是否存在。因为前端存在伪造不存在部门添加的情况，所以加以避免
        Long departmentId = user.getDepartmentId();

        //创建wrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper();
        //使用wrapper对象添加判断条件
        wrapper.eq("username",username);
        //判断该姓名在数据库中存在几个
        Integer selectCount = baseMapper.selectCount(wrapper);
        //如果不是等于0个，那就代表已存在
        if(selectCount != 0){
            throw new BusinessException(ResultCode.USER_ACCOUNT_ALREADY_EXIST.getCode(),
                    ResultCode.USER_ACCOUNT_ALREADY_EXIST.getMessage());
        }
        //根据传递的部门id查询该部门是否存在
        Department department = departmentMapper.selectById(departmentId);
        //如果该部门不存在 就抛出异常
        if(department == null){
            throw new BusinessException(ResultCode.DEPARTMENT_NOT_EXIST.getCode(),
                    ResultCode.DEPARTMENT_NOT_EXIST.getMessage());
        }
//        user.setCreateTime(new Date());
//        user.setModifiedTime(new Date());
        //盐值
        String salt = UUID.randomUUID().toString().substring(0, 32);
        user.setSalt(salt);
        //创建时间和修改时间使用MyBatisPlus自动填充

        //使用spring security自带的密码加密策略
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //设置用户类型 超级管理员0 普通用户1
        user.setType(UserTypeEnum.SYSTEM_USER.getTypeCode());
        //设置用户状态 0锁定 1有效
        user.setStatus(UserStatusEnum.AVAILABLE.getStatusCode());
        //设置逻辑删除
        user.setDeleted(false);
        this.baseMapper.insert(user);
    }

}
