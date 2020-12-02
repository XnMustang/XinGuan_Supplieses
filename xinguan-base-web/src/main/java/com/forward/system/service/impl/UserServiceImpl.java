package com.forward.system.service.impl;

import com.forward.system.entity.User;
import com.forward.system.mapper.UserMapper;
import com.forward.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
