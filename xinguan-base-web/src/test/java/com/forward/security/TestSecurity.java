package com.forward.security;

import com.forward.XinGuanApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: 测试spring security自带方法的加密
 * @Author : 王俊
 * @date :  2020/12/7
 */
@SpringBootTest(classes = XinGuanApplication.class)
public class TestSecurity {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 相同的密码，每次运行的加密后的密码是不同的。因为每次生成的salt不一样
     */
    @Test
    public void test(){
        //加密
        String encode = passwordEncoder.encode("123456");
        //解密
        boolean matches = passwordEncoder.matches("123456",encode);
        System.out.println(encode);
        System.out.println(matches);
    }

}
