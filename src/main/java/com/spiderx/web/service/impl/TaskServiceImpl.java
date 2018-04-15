package com.spiderx.web.service.impl;

import com.spiderx.web.service.BaseService;
import com.spiderx.web.service.ServiceBeanNames;
import com.spiderx.web.service.TaskService;
import com.spiderx.exception.SpiderException;
import com.spiderx.spider.SpiderManager;
import com.spiderx.task.SpiderTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(ServiceBeanNames.TASK_SERVICE)
public class TaskServiceImpl extends BaseService implements TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Override
    public void addTask(SpiderTask task) {
        try{
            SpiderManager.generate().enableDefaultSpider(task);
        }catch (SpiderException e){
            logger.error("add list task is fail, message: {}, uuid: {}", e.getMessage(), e.getUuid());
        }
    }
}
