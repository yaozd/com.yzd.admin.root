package com.yzd.admin.web.mybatis.mapper;

import com.yzd.admin.web.mybatis.entity.Shortcut;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zd.yao on 2017/6/10.
 */
public interface ShortcutMapper {
    @Select("select * from shortcuts")
    public List<Shortcut> queryShortcutList();
}
