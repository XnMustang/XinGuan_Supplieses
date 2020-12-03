package com.forward.system.controller;


import com.forward.handler.BusinessException;
import com.forward.response.Result;
import com.forward.response.ResultCode;
import com.forward.system.entity.Department;
import com.forward.system.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangjun
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/department")
@Api(value = "部门管理",tags = "部门管理接口")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiModelProperty(value = "查询部门及人数",notes = "从部门表中分组查询用户人数")
    @GetMapping("/findDeptAndCount")
    public Result findDeptAndCount(){
        List<Department> departments = departmentService.findDeptAndCount();
        if(departments.size() == 0){
            throw new BusinessException(ResultCode.DEPT_NOT_EXIST_EXCEPTION.getCode(),
                    ResultCode.DEPT_NOT_EXIST_EXCEPTION.getMessage());
        }else{
            return Result.ok().data("departments",departments);
        }
    }

}

