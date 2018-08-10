package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longfei li
 * @Title: HelloController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/612:26
 */
@RestController
public class HelloController {


    @Value("${size}")
    private int size;

    @RequestMapping(value={"/hello","/hi"},method = RequestMethod.GET)
    public String say() {
        return "Hello Spring Boot"+size;
    }
}
