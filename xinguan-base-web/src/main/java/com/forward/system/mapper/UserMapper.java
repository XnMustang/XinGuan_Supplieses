package com.forward.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.forward.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> findUserPage(Page<User> page,
                             @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);

}
