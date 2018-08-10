package com.springboot.demo.controller;

import com.springboot.demo.domain.Result;
import com.springboot.demo.domain.User;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.service.UserService;
import com.springboot.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Administrator
 * @Title: UserController
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/619:38
 */
@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户数据
     * @return
     */
    @GetMapping(value="/users")
    public List<User> getUsers(){

        return userRepository.findAll();
    }

    /**
     * 添加一个用户
     * @param user
     * @param bindingResult 存储验证不通过的字段提示
     * @return
     */
    @PostMapping(value="/adduser")
    public Result<User> addUser(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }

        user.setName(user.getName());
        user.setAge(user.getAge());

        return ResultUtil.success(userRepository.save(user));
    }


    /**
     * 查询一个用户
     * @param id
     * @return
     */
    @GetMapping(value="/getuser/{id}")
    public User getUser(@PathVariable("id")int id){
        return userRepository.findOne(id);
    }

    /**
     * 根据用户年龄查询用户
     * @param age
     * @return
     */
    @GetMapping(value="/getbyage/{age}")
    public List<User> getByAge(@PathVariable("age")int age){return userRepository.findByAge(age);}

    /**
     * 更新一个用户
     * @param id
     * @param name
     * @param age
     */
    @PutMapping(value="/updateuser/{id}")
    public User updateUser(@PathVariable("id")int id,@RequestParam("name")String name,@RequestParam("age")int age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }


    /**
     * 删除一个用户
     * @param id
     */
    @DeleteMapping(value="/deleteuser/{id}")
    public void deleteUser(@PathVariable("id")int id){
        userRepository.delete(id);
    }


    @GetMapping(value="/savetwo")
    public void savetwo(){
        userService.insertTwo();
    }

    /**
     * 判断用户的年龄端属于哪个层次
     * @param id
     */
    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id)throws Exception{
        userService.getAge(id);
    }

}
