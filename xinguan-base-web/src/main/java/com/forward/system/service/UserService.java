package com.forward.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forward.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
public interface UserService extends IService<User> {

    IPage<User> findUserPage(Page<User> page,QueryWrapper<User> wrapper);

}
