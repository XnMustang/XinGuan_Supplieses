package com.forward.system.service;

import com.forward.system.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
public interface DepartmentService extends IService<Department> {

    List<Department> findDeptAndCount();

}
