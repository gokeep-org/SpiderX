package com.spiderx.config;

public enum RuleType {
    XPATH("xpath", 1),
    SELECTOR("selector", 2),
    DEFAULT(SELECTOR.name, SELECTOR.code);

    private String name;
    private int code;

    RuleType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
