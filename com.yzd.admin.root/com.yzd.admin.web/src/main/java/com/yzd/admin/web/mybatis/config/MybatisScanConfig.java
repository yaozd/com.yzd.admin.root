package com.yzd.admin.web.mybatis.config;

/**
 * Created by zd.yao on 2017/6/9.
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mapper的扫描包路径
 */
@Configuration
@MapperScan("com.yzd.admin.web.mybatis.mapper")
public class MybatisScanConfig {

}
