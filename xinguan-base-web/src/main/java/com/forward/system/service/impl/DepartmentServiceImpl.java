package com.forward.system.service.impl;

import com.forward.system.entity.Department;
import com.forward.system.mapper.DepartmentMapper;
import com.forward.system.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public List<Department> findDeptAndCount() {
        return this.baseMapper.findDeptAndCount();
    }
}
