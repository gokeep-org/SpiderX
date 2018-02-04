package com.spider.core.service;


import com.spider.core.util.ApplicationContextHolder;

public abstract class BaseService {
    public static <T extends BaseService> T getService(Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(clazz);
    }

    public static <T extends BaseService> T getService(String serviceName, Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(serviceName, clazz);
    }
}