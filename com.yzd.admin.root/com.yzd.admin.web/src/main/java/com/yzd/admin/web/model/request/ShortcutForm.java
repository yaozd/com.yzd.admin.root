package com.yzd.admin.web.model.request;

import com.yzd.admin.web.mybatis.entity.Shortcut;
import com.yzd.admin.web.utils.color.ColorEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zd.yao on 2017/6/9.
 */
@Data
@NoArgsConstructor
public class ShortcutForm {
    private Integer id;
    private String name;
    private String filePath;
    private String color;
    public static ShortcutForm toForm(Shortcut entity){
        ShortcutForm form=new ShortcutForm();
        form.setId(entity.getId());
        form.setName(entity.getName());
        form.setColor(ColorEnum.getName(entity.getColor()));
        return form;
    }
}