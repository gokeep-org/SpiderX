package com.spiderx.process;

import java.util.Map;

public class CommonContent {
    private Map<String, Object> result;
    private Long time;

    public CommonContent() {
    }

    public CommonContent(Map<String, Object> result, Long time) {
        this.result = result;
        this.time = time;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
