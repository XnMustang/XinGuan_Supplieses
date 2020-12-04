package com.forward.system.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 阿里云OSS配置
 * @Author : 王俊
 * @date :  2020/12/5
 */
@ConfigurationProperties(prefix = "alioss")
@Component
@Data
@ToString
public class OssEntity {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
