package com.ReCarChoi.controller;

import com.ReCarChoi.mapper.UserMapper;
import com.ReCarChoi.pojo.User;
import com.ReCarChoi.service.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 蔡江楠
 * @version 1.0
 * @date 2021/12/16 10:00
 * @description TODO
 */

@RestController
public class UserController {

    @Autowired
    private UserMapperImpl userMapperImpl;

    @GetMapping("/queryAllUser")
    public List<User> queryAllUser(){
        return userMapperImpl.queryAllUser();
    }

    @GetMapping("/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        return userMapperImpl.queryUserById(id);
    }

    @GetMapping("/addUser/{id}/{name}/{password}")
    public void addUser(@PathVariable("id") int id,
                        @PathVariable("name") String name,
                        @PathVariable("password") String password){
        userMapperImpl.addUser(new User(id,name,password));
    }

    @GetMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userMapperImpl.deleteUserById(id);
    }

    @GetMapping("/updateUser/{id}/{name}/{password}")
    public void updateUser(@PathVariable("id") int id,
                           @PathVariable("name") String name,
                           @PathVariable("password") String password){
        userMapperImpl.updateUser(new User(id,name,password));
    }

}
