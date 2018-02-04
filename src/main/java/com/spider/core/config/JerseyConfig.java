package com.spider.core.config;


import com.spider.core.filter.RequestFilter;
import com.spider.core.filter.ResponseFilter;
import com.spider.core.library.handle.RequestExceptionHandler;
import com.spider.core.library.provide.GsonMessageBodyHandler;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


@Configuration
@ApplicationPath(CommonConfig.BASE_PATH)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        setJerseyComponentsLocation();
        registerJerseyFilter();
		registerExceptionProcessProvode();
        registerJsonProvider();
        registerCompressionEncoder();
        registerSwagger();
    }

    private void setJerseyComponentsLocation() {
        packages(CommonConfig.SCAN_REST_PACKAGE);
    }
    
    /**
     * 注册jersey请求响应过滤
     */
    private void registerJerseyFilter() {
        register(RequestFilter.class);
        register(ResponseFilter.class);
    }
    
    /**
     * 注册Json处理
     */
    private void registerJsonProvider() {
        register(GsonMessageBodyHandler.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, false);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    }
    
    /**
     * 注册请求异常处理
     */
    public void registerExceptionProcessProvode() {
        register(RequestExceptionHandler.class);
    }

    /**
     * 注册Response body压缩时用到的encoder
     */
    private void registerCompressionEncoder() {
        registerClasses(EncodingFilter.class, GZipEncoder.class, DeflateEncoder.class);
    }

    /**
     * 注册Swagger,用于生成api文档
     */
    private void registerSwagger() {
        /**
         * 由于对代码存在一定的侵入性，这里不选择实现，
         * 建议使用postman测试驱动开发，自动生成文档
         * 从而无关于代码。
         */
    }
}