package com.springboot.demo.repository;

import com.springboot.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Administrator
 * @Title: UserRepository
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/619:40
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    //根据用户年龄查询用户
    public List<User> findByAge(Integer age);
}
