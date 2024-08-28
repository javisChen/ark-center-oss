package com.ark.center.foundation;

import com.ark.component.web.config.ArkWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableFeignClients()
@EnableDiscoveryClient
public class Application extends ArkWebConfig {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}