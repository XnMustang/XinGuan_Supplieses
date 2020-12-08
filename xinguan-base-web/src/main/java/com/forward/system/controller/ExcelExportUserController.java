package com.forward.system.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.forward.response.Result;
import com.forward.system.entity.User;
import com.forward.system.utils.EasyPoiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户信息导出excel表格
 * @Author : 王俊
 * @date :  2020/12/8
 */
@RestController
@RequestMapping("/excel")
@Api(value = "导出用户",tags = "导出用户接口")
public class ExcelExportUserController {

    @Autowired
    private EasyPoiUtils easyPoiUtils;

    @GetMapping("/exportUserInfo")
    @ApiModelProperty(value = "导出用户",notes = "导出用户信息")
    public Result exportUserInfo(List<User> userList){
        ExportParams exportParams = new ExportParams("新冠物资系统用户信息", "用户信息");

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("title",exportParams);
        map.put("entity",User.class);
        map.put("data",userList);

        list.add(map);
        try {
            easyPoiUtils.exportExcel(list,"E:/Excel/","新冠物资系统用户信息.xls");
            return Result.ok();
        } catch (IOException e) {
            return Result.error();
        }
    }

}
