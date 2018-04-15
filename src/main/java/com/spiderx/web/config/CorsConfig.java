package com.spiderx.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Cors跨域请求允许设置
 * 本配置主要用于对前段进行跨域请求后端要进行的配置，
 * 对代码本身是没有影响的。
 */
@Configuration
@PropertySource("classpath:application.yml")
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Value("${server.connection-timeout}")
    private String connectionTimeout;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH")
                .allowCredentials(true)
                .maxAge(Integer.parseInt(connectionTimeout));
    }
}
