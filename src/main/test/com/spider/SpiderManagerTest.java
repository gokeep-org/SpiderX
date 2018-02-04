package com.spider;

import com.spider.pipline.TargetEnum;
import com.spider.spider.SpiderManager;
import com.spider.task.SpiderTask;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

public class SpiderManagerTest {
    private SpiderManager spiderManager;
    private static final Logger logger = LoggerFactory.getLogger(SpiderManagerTest.class);
    @Before
    public void init(){
        spiderManager = spiderManager.generate();
    }

    @Test
    public void testSpiderDownloadPage(){
        spiderManager
                .setProcessor(new GithubRepoPageProcessor())
                .setThreadSize(5)
                .addUrl("https://github.com/code4craft")
                .run();
    }

    @Test
    public void testEnableDefaultTask(){
        SpiderTask task = new SpiderTask();
        task.setUrl("https://github.com/code4craft");
        task.setSpiderName("test");
        task.setTarget(TargetEnum.ES);
        SpiderManager.generate().enableDefaultSpider(task);
    }
//    @After
    public void destory(){
        spiderManager.stop();
    }
}
