package com.yzd.admin.web.controller;

import com.yzd.admin.web.mybatis.entity.Shortcut;
import com.yzd.admin.web.mybatis.entity.User;
import com.yzd.admin.web.mybatis.mapper.ShortcutMapper;
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
    @Autowired
    private ShortcutMapper shortcutMapper;
    @RequestMapping(value = {"", "/index"})
    public String index() {
        return "home/index";
    }
    //region --测试数据
    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(){
        //add
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        //find
       return userMapper.queryUserList();
    }
    @RequestMapping("findAll2")
    @ResponseBody
    public List<Shortcut> findAll2(){
        return shortcutMapper.queryShortcutList();
    }
    //endregion
}
