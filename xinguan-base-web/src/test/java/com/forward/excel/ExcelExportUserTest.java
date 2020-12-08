package com.forward.excel;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.forward.XinGuanApplication;
import com.forward.system.entity.User;
import com.forward.system.utils.EasyPoiUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/12/8
 */
@SpringBootTest(classes = XinGuanApplication.class)
public class ExcelExportUserTest {

    @Test
    public void testExportExcel() throws IOException {
        ExportParams exportParams = new ExportParams("用户信息数据", "用户信息");

        Object entity = User.class;
        List<Map<String,Object>> list = new ArrayList<>();

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setEmail("123123@qq.com");
        user.setModifiedTime(new Date());
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setType(1);
        user.setDeleted(false);
        user.setBirth(new Date());
        user.setNickname("王俊");
        user.setSex(1);
        user.setUsername("王俊");
        user.setPhoneNumber("15639655123");
        user.setDepartmentId(1L);
        users.add(user);

        Map<String,Object> map = new HashMap<>();
        map.put("title",exportParams);
        map.put("entity",entity);
        map.put("data",users);

        list.add(map);

        EasyPoiUtils.exportExcel(list,"E:/Excel/","userInfo.xls");

    }

}
