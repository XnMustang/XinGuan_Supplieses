package com.forward.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 公共返回结果
 * @Author : 王俊
 * @date :  2020/12/3
 */
@Data
public class Result {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "响应码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<>();

    /**
     * 构造方法私有化，里面的方法都是静态方法，达到保护的作用
     */
    private Result(){

    }

    /**
     * 链式编程
     */
    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());

        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMessage());

        return result;
    }

    /**
     * 自定义返回成功与否
     * @param success
     * @return
     */
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    /**
     * 自定义返回信息
     * @param message
     * @return
     */
    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义返回响应码
     * @param code
     * @return
     */
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回数据
     * @param key
     * @param value
     * @return
     */
    public Result data(String key,Object value){
        //这里注意，不是.put的话，就是自己调自己，死循环
        this.data.put(key,value);
        return this;
    }

    /**
     * 自定义返回Map数据
     * @param map
     * @return
     */
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

}
