package com.spider.library;

import us.codecraft.webmagic.Spider;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SpiderContainer {
    private static final Map<String, Spider> spiders = new ConcurrentHashMap<>();

    public static Spider getSpiderByName(String name){
        return spiders.get(name);
    }

    public void stopSpiderByName(String name){
        if (Objects.isNull(spiders.get(name))){
            return;
        }
        spiders.get(name).stop();
    }

    public static Map<String, Spider> getSpiders() {
        return spiders;
    }
}
