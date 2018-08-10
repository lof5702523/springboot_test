package com.springboot.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Administrator
 * @Title: HttpAspect
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/714:21
 */
@Aspect
@Component
public class HttpAspect {

    //日志
    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    //具体的切点
    @Pointcut("execution(public * com.springboot.demo.controller.UserController.*(..))")
    public void pointcutcontroller(){
    }

    /**
     * 执行方法前调用
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("pointcutcontroller()")
    public void beforelog(JoinPoint joinPoint){
        //System.out.println("-----------before--------------");
        //log.info("-----------before-------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录HTTP请求数据
        //url
        log.info("url={}",request.getRequestURL());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRemoteAddr());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());

    }

    /**
     * 执行方法后调用
     */
    @After("pointcutcontroller()")
    public void afterlog(){
       // System.out.println("------------after----------------");
        log.info("-----------after-------------");
    }


    /**
     * 程序返回给用户的参数
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "pointcutcontroller()")
    public void doAfterReturning(Object object){
        log.info("response={}",object.toString());
    }

}
