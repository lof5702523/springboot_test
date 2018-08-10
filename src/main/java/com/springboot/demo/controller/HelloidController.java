package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author longfei li
 * @Title: HelloController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/612:26
 */
@RestController
@RequestMapping(value="/helid")
public class HelloidController {


    @Value("${size}")
    private int size;

    //@RequestMapping(value="/say/{id}",method = RequestMethod.GET)
    @GetMapping(value="/say/{id}")
    public String say(@PathVariable("id")Integer id) {
        return "id="+id;
    }

    @RequestMapping(value="/gsay",method = RequestMethod.GET)
    public String gsay(@RequestParam(value="id",required = false,defaultValue = "0")Integer myid) {
        return "id="+myid;
    }

}
