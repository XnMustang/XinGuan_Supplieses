package com.forward.oss;

import com.forward.XinGuanApplication;
import com.forward.system.entity.OssEntity;
import com.forward.system.service.AliOssService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/12/5
 */
@SpringBootTest(classes = XinGuanApplication.class)
public class TestOss {

    @Autowired
    private OssEntity ossEntity;

    @Autowired
    private AliOssService aliOssService;

    @Test
    void contextLoads() {
        System.out.println(ossEntity);
    }

    @Test
    void testCreateBucket(){
        aliOssService.createBucket();
    }


}
