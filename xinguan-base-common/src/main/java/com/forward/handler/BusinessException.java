package com.forward.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 自定义业务异常
 * @Author : 王俊
 * @date :  2020/12/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    @ApiModelProperty(value = "响应码")
    private Integer code;

    @ApiModelProperty(value = "错误信息")
    private String errorMsg;
}
