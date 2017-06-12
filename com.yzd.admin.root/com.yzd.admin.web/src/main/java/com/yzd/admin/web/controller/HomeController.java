package com.yzd.admin.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.yzd.admin.web.model.request.ShortcutForm;
import com.yzd.admin.web.model.request.ShortcutMapForm;
import com.yzd.admin.web.mybatis.entity.Shortcut;
import com.yzd.admin.web.mybatis.entity.User;
import com.yzd.admin.web.mybatis.mapper.ShortcutMapper;
import com.yzd.admin.web.mybatis.mapper.UserMapper;
import com.yzd.admin.web.utils.exe.ExeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    public String index(Model model) {
        //
        List<ShortcutMapForm> shortcutMapFormList=new ArrayList<>();
        List<Shortcut> shortcutList= shortcutMapper.queryShortcutList();
        Multimap<Integer, Shortcut> shortcutMultimap =listToMultimap(shortcutList);
        for(Map.Entry<Integer, Collection<Shortcut>> e : shortcutMultimap.asMap().entrySet()){
            List<Shortcut> itemList=new ArrayList<>(e.getValue()) ;
            Collections.sort(itemList,new Comparator<Shortcut>(){
                public int compare(Shortcut arg0, Shortcut arg1) {
                    return arg1.getId().compareTo(arg0.getId());
                }
            });
            List<ShortcutForm> shortcutFormList=new ArrayList<>();
            itemList.forEach(item->shortcutFormList.add(ShortcutForm.toForm(item)));
            ShortcutMapForm shortcutMapForm=new ShortcutMapForm();
            shortcutMapForm.setColorId(e.getKey());
            shortcutMapForm.setShortcutFormList(shortcutFormList);
            shortcutMapFormList.add(shortcutMapForm);
        }
        Collections.sort(shortcutMapFormList,new Comparator<ShortcutMapForm>(){
            @Override
            public int compare(ShortcutMapForm o1, ShortcutMapForm o2) {
                return o1.getColorId().compareTo(o2.getColorId());
            }
        } );
        model.addAttribute("shortcutMapFormList",shortcutMapFormList);
        return "home/index";
    }
    public static Multimap<Integer, Shortcut> listToMultimap(List<Shortcut> list) {
        return Multimaps.index(list, keyFunction());
    }
    public static Function<Shortcut, Integer> keyFunction() {
        return new Function<Shortcut, Integer>() {
            @Override
            public Integer apply(Shortcut input) {
                return input.getColor();
            }
        };
    }
    @GetMapping("openExe/{id}")
    public void openExe(@PathVariable("id")Integer id){
        Shortcut entity=shortcutMapper.getById(id);
        String filePath=entity.getFilePath()==null?"":entity.getFilePath();
        ExeUtil.openWindowsExe(filePath);
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
    @RequestMapping("listToMultimap")
    @ResponseBody
    public List<ShortcutMapForm> listToMultimap(){
        List<ShortcutMapForm> shortcutMapFormList=new ArrayList<>();
        List<Shortcut> shortcutList= shortcutMapper.queryShortcutList();
        Multimap<Integer, Shortcut> shortcutMultimap =listToMultimap(shortcutList);
        for(Map.Entry<Integer, Collection<Shortcut>> e : shortcutMultimap.asMap().entrySet()){
            List<Shortcut> itemList=new ArrayList<>(e.getValue()) ;
            Collections.sort(itemList,new Comparator<Shortcut>(){
                public int compare(Shortcut arg0, Shortcut arg1) {
                    return arg1.getId().compareTo(arg0.getId());
                }
            });
            List<ShortcutForm> shortcutFormList=new ArrayList<>();
            itemList.forEach(item->shortcutFormList.add(ShortcutForm.toForm(item)));
            ShortcutMapForm shortcutMapForm=new ShortcutMapForm();
            shortcutMapForm.setColorId(e.getKey());
            shortcutMapForm.setShortcutFormList(shortcutFormList);
            shortcutMapFormList.add(shortcutMapForm);
        }
        Collections.sort(shortcutMapFormList,new Comparator<ShortcutMapForm>(){
            @Override
            public int compare(ShortcutMapForm o1, ShortcutMapForm o2) {
                return o1.getColorId().compareTo(o2.getColorId());
            }
        } );
        return shortcutMapFormList;
    }
    //endregion
}
