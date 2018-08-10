package com.springboot.demo.service;

import com.springboot.demo.domain.User;
import com.springboot.demo.enums.ResultEnum;
import com.springboot.demo.exception.UserException;
import com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @Title: UserService
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/620:49
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertTwo(){
        User usera = new User();
        usera.setAge(111);
        usera.setName("test111");
        userRepository.save(usera);


        User userb = new User();
        userb.setAge(222);
        userb.setName("test222");
        userRepository.save(userb);


    }

    public void getAge(Integer id) throws Exception{
        User user = userRepository.findOne(id);
        Integer age = user.getAge();
        if(age<18){
            //未成年   100
            throw new UserException(ResultEnum.UNDER_AGE);
        }else if(age >18 && age < 26){
           //青年     101
            throw new UserException(ResultEnum.YOUTH);
        }

    }

    /**
     * 查询一个用户数据
     * @param id
     * @return
     */
    public User findOne(Integer id){

        return userRepository.findOne(id);
    }

}
