package com.spiderx.web.service.impl;


import com.spiderx.web.service.BaseService;
import com.spiderx.web.service.ServiceBeanNames;
import com.spiderx.web.service.TestService;
import org.springframework.stereotype.Service;

@Service(ServiceBeanNames.TEST_SERVICE)
public class TestServiceImpl extends BaseService implements TestService {
    @Override
    public String start() {
        return "This is a rest test interface";
    }
}
