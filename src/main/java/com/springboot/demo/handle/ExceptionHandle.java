package com.springboot.demo.handle;

import com.springboot.demo.domain.Result;
import com.springboot.demo.exception.UserException;
import com.springboot.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author longfei li
 * @Title: ExceptionHandle
 * @ProjectName springboot
 * @Description: 获取异常信息转化为对应的格式输出
 * @date 2018/8/721:41
 */
@ControllerAdvice
public class ExceptionHandle {

    //将未知错误写到日志中捕抓下来
    Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //判断异常是否为自定义异常
        if (e instanceof UserException){
            UserException userException = (UserException)e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());

        }else{
            //把未知异常捕抓下来
            logger.info("[系统未知异常] {}",e);
            return ResultUtil.error(-1,"未知错误");
        }


    }

}
