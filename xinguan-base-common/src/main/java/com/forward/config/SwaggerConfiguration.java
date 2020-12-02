package com.forward.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger配置类
 * @Author : 王俊
 * @date :  2020/12/3
 */

/**
 * 通过此路径访问：http://localhost:8082/doc.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket webApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("XinGuanWebApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("新冠物资管理系统-API文档")
                .description("使用Springboot+Vue前后端分离的方式实现这个新冠物资管理系统")
                .version("1.0")
                .contact(new Contact("MisterWang", "http://www.forward.cool", "forward_xn@163.com"))
                .build();
    }

}
