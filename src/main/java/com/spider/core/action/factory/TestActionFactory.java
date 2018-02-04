package com.spider.core.action.factory;


import com.spider.core.action.test.TestInfoAction;

public class TestActionFactory extends BaseActionFactory {
    public static TestInfoAction getTestInfoAction(boolean flag){
        return new TestInfoAction(flag);
    }
}
