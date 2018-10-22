package com.sun.permission.common.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 	配置扫描，也可以在启动类配置
 * @author Administrator
 *
 */
@Configuration
@MapperScan("com.sun.permission.*.dao")
public class MybatisConfig {

}
