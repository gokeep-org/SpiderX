package com.spider.core.service.impl;


import com.spider.core.service.BaseService;
import com.spider.core.service.ServiceBeanNames;
import com.spider.core.service.TestService;
import org.springframework.stereotype.Service;

@Service(ServiceBeanNames.TEST_SERVICE)
public class TestServiceImpl extends BaseService implements TestService {
    @Override
    public String start() {
        return "This is a rest test interface";
    }
}
