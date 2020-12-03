package com.forward.system.mapper;

import com.forward.system.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> findDeptAndCount();

}
