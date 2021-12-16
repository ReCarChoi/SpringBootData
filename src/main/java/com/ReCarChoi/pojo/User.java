package com.ReCarChoi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 蔡江楠
 * @version 1.0
 * @date 2021/12/16 9:36
 * @description TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String name;
    String password;
}
