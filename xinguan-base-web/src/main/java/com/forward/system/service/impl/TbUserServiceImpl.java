package com.forward.system.service.impl;

import com.forward.system.entity.TbUser;
import com.forward.system.mapper.TbUserMapper;
import com.forward.system.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-02
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
