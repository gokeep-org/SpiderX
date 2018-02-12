package com.spiderx.config;

public enum SpiderType {
    SIMPLE("SIMPLE", 0), SIMPLE_CACHE("SIMPLE_CACHE", 1), CACHE("CACHE", 2), DISTRIBUTED("IDSTRIBUTED", 3), PLUGIN("PLUGIN", 4);

    private String key;
    private int value;

    SpiderType(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
