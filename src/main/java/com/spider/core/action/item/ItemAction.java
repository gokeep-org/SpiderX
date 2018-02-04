package com.spider.core.action.item;


import com.spider.core.action.BaseAction;
import com.spider.core.domain.output.BaseOutput;
import com.spider.core.service.BaseService;
import com.spider.core.service.ServiceBeanNames;
import com.spider.core.service.TestService;
import com.spider.core.service.impl.TestServiceImpl;

public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static TestService testService = BaseService.getService(ServiceBeanNames.TEST_SERVICE, TestServiceImpl.class);
}