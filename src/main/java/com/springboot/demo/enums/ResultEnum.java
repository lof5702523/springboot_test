package com.springboot.demo.enums;

/**
 * @author longfei li
 * @Title: ResultEnum
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/722:45
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    UNDER_AGE(100,"未成年"),
    YOUTH(101,"青年")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
