package com.yzd.admin.web.mybatis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zd.yao on 2017/6/9.
 */
@Data
@NoArgsConstructor
public class Shortcut {
    private Integer id;
    private String name;
    private String filePath;
    private Integer color;
}
