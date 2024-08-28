package com.ark.center.foundation.infra.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = {
        "com.ark.center.foundation.infra.*.dao",
})
@Configuration
public class MyBatisConfig {

}
