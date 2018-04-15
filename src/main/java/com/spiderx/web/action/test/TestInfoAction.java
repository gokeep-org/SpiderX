package com.spiderx.web.action.test;

import com.spiderx.web.action.item.ItemAction;
import com.spiderx.web.domain.output.test.TestInfoOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class TestInfoAction extends ItemAction<TestInfoOutput> {
    private boolean flag;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestInfoAction.class);
    private String res;
    
    public TestInfoAction(boolean flag) {
        this.flag = flag;
    }
    
    @Override
    protected void permissionValidate() throws Exception {
        LOGGER.info("Test action  permission validate is null");
    }
    
    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, flag))
            flag = false;
        LOGGER.info("Test action additional validate flag is " + flag);
    
    }
    
    @Override
    protected void start() throws Exception {
        res = testService.start();
    }
    
    @Override
    protected TestInfoOutput formatOutput() throws Exception {
        TestInfoOutput output = new TestInfoOutput(this.flag, this.res);
        return output;
    }
    
    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("Test info action log sync success");
    }
}
