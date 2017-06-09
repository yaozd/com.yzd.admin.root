package com.yzd.admin.web.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zd.yao on 2017/6/9.
 */
@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer status;

    public User(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
