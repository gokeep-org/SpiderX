package com.spiderx.web.service;


import com.spiderx.web.util.ApplicationContextHolder;

public abstract class BaseService {
    public static <T extends BaseService> T getService(Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(clazz);
    }

    public static <T extends BaseService> T getService(String serviceName, Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(serviceName, clazz);
    }
}