package com.springboot.demo.util;

import com.springboot.demo.domain.Result;

/**
 * @author Administrator
 * @Title: ResultUtil
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/719:23
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }




}
