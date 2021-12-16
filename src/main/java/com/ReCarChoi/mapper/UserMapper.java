package com.ReCarChoi.mapper;


import com.ReCarChoi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryAllUser();
    User queryUserById(@Param("id") int id);
    void addUser(User user);
    void deleteUserById(@Param("id") int id);
    void updateUser(User user);
}
