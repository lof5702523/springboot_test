package com.springboot.demo.exception;

import com.springboot.demo.enums.ResultEnum;

/**
 * @author Administrator
 * @Title: UserException
 * @ProjectName springboot
 * @Description: 自定义异常，注意spring要继承runtimeexception只有这个才能进行事务的回滚
 * @date 2018/8/722:07
 */
public class UserException extends RuntimeException {

    //定义错误代码
    private Integer code;

    /**
    public UserException(Integer code,String message){
        super(message);
        this.code = code;
    }*/
    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
