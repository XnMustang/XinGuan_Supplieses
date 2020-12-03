package com.forward.system.service.impl;

import com.forward.system.entity.Log;
import com.forward.system.mapper.LogMapper;
import com.forward.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
