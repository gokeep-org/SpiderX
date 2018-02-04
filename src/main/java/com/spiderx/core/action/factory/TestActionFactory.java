package com.spiderx.core.action.factory;


import com.spiderx.core.action.test.TestInfoAction;

public class TestActionFactory extends BaseActionFactory {
    public static TestInfoAction getTestInfoAction(boolean flag){
        return new TestInfoAction(flag);
    }
}
