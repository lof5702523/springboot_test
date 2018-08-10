package com.springboot.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author longfei li
 * @Title: User
 * @ProjectName springboot
 * @Description: TODO
 * @date 2018/8/619:01
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 18,message = "未成年人禁止注册")
    private Integer age;

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
