package com.forward.handler;

import com.forward.response.Result;
import com.forward.response.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 * @Author : 王俊
 * @date :  2020/12/3
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理，没有指定异常的类型，不管什么异常都可以捕获
     * @param e
     * @return
     */
    //因为controller是以json返回数据，所以这里需要加此注解@ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error();
    }

    /**
     * 更为详细的异常信息提示。直接定位到某个异常
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().code(ResultCode.ARITHENTIC_EXCEPTION.getCode())
                .message(ResultCode.ARITHENTIC_EXCEPTION.getMessage());
    }

    /**
     * 更为详细的异常信息提示。直接定位到某个异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e){
        e.printStackTrace();
        return Result.error().code(e.getCode())
                .message(e.getErrorMsg());
    }



}
