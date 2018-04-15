package com.spiderx.web.action.item;


import com.spiderx.web.action.BaseAction;
import com.spiderx.web.domain.output.BaseOutput;
import com.spiderx.web.service.BaseService;
import com.spiderx.web.service.ServiceBeanNames;
import com.spiderx.web.service.TaskService;
import com.spiderx.web.service.TestService;
import com.spiderx.web.service.impl.TaskServiceImpl;
import com.spiderx.web.service.impl.TestServiceImpl;

public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static TestService testService = BaseService.getService(ServiceBeanNames.TEST_SERVICE, TestServiceImpl.class);
    public static TaskService taskService = BaseService.getService(ServiceBeanNames.TASK_SERVICE, TaskServiceImpl.class);
}