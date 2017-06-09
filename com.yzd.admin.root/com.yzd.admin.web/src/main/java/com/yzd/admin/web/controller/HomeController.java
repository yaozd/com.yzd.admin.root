package com.yzd.admin.web.controller;

import com.yzd.admin.web.mybatis.entity.User;
import com.yzd.admin.web.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zd.yao on 2017/6/8.
 */
@Controller
public class HomeController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = {"", "/index"})
    public String index() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        return "home/index";
    }
    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(){
       return userMapper.queryUserList();
    }
}
