package com.spiderx.cache;

import com.spiderx.spider.SpiderManager;
import com.spiderx.task.SpiderTask;

import java.util.Objects;

public class CacheMessageHanlder implements Hanlder{

    public static CacheMessageHanlder get(){
        return new CacheMessageHanlder();
    }

    @Override
    public void process(SpiderTask task) {
        if (Objects.isNull(task)){
            return;
        }
        SpiderManager.generate().enableDefaultSpider(task);
    }
}