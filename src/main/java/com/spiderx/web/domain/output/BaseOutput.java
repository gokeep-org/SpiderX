package com.spiderx.web.domain.output;

public class BaseOutput {
    public BaseOutput() {
    }
    
    private boolean success = false;
    
    private String uuid;
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
