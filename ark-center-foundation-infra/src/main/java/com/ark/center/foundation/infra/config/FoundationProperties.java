package com.ark.center.foundation.infra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 认证配置，支持Nacos动态热更新
 *
 * @author Javis
 */
@ConfigurationProperties(prefix = "ark.center.foundation")
@Data
@Configuration
@RefreshScope
public class FoundationProperties {

    /**
     * 文件统一端点
     */
    private FileProperties file;

}
