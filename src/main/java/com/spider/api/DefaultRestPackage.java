package com.spider.api;

public final class DefaultRestPackage {
    private DefaultRestPackage() {
    }
    
    public static final String name = DefaultRestPackage.class.getPackage().getName();
}
