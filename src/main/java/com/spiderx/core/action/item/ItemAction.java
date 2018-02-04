package com.spiderx.core.action.item;


import com.spiderx.core.action.BaseAction;
import com.spiderx.core.domain.output.BaseOutput;
import com.spiderx.core.service.BaseService;
import com.spiderx.core.service.ServiceBeanNames;
import com.spiderx.core.service.TestService;
import com.spiderx.core.service.impl.TestServiceImpl;

public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static TestService testService = BaseService.getService(ServiceBeanNames.TEST_SERVICE, TestServiceImpl.class);
}