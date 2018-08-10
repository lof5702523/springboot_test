package com.springboot.demo.service;

import com.springboot.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @Title: UserServiceTest
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/816:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void findOne(){
        User user = userService.findOne(1);
        Assert.assertEquals(new Integer(11),user.getAge());
    }


}
