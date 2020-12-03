package com.forward.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 解决跨域除了添加注解的另一种方案
 * @Author : 王俊
 * @date :  2020/12/3
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {
    /**
     * 解决跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                //允许请求方法
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","HEAD")
                .allowCredentials(true)
                .maxAge(3600)
                //允许任何头
                .allowedHeaders("*");
    }
}
