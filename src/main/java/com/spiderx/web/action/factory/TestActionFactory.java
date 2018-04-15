package com.spiderx.web.action.factory;


import com.spiderx.web.action.test.TestInfoAction;

public class TestActionFactory extends BaseActionFactory {
    public static TestInfoAction getTestInfoAction(boolean flag){
        return new TestInfoAction(flag);
    }
}
