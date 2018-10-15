package com.spiderx;

import com.spiderx.pipline.TargetEnum;
import com.spiderx.spider.SpiderManager;
import com.spiderx.task.SpiderTask;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Bootstracp.class)
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
                .addUrl("http://github.com/code4craft")
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