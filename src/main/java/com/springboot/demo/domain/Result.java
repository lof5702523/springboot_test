package com.springboot.demo.domain;

/**
 * @author longfei li
 * @Title: Result
 * @ProjectName springboot
 * @Description: HTTP请求返回的最外层对象
 * @date 2018/8/719:18
 */
public class Result<T> {

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体的类容
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
