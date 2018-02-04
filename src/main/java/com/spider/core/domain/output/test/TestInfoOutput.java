package com.spider.core.domain.output.test;


import com.spider.core.domain.output.BaseOutput;

public class TestInfoOutput extends BaseOutput {
    private boolean flag;
    private String msg;
    
    public TestInfoOutput(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
        setSuccess(true);
    }
}
