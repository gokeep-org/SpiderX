package com.spiderx.core.service.impl;


import com.spiderx.core.service.BaseService;
import com.spiderx.core.service.ServiceBeanNames;
import com.spiderx.core.service.TestService;
import org.springframework.stereotype.Service;

@Service(ServiceBeanNames.TEST_SERVICE)
public class TestServiceImpl extends BaseService implements TestService {
    @Override
    public String start() {
        return "This is a rest test interface";
    }
}
