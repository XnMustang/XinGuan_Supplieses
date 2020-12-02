package com.forward;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: 启动类
 * @Author : 王俊
 * @date :  2020/12/2
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.forward.system.mapper")
public class XinGuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinGuanApplication.class,args);
    }

}
