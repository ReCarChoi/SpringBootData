package com.ReCarChoi.service;

import com.ReCarChoi.mapper.UserMapper;
import com.ReCarChoi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 蔡江楠
 * @version 1.0
 * @date 2021/12/16 10:25
 * @description TODO
 */

@Service
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
