package com.spider.process;

import com.spider.config.SpiderConfig;
import com.spider.task.SpiderTask;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

import java.util.Objects;

public class CommonTaskProcessor implements Processor{

    private SpiderTask task;

    public CommonTaskProcessor(SpiderTask task) {
        this.task = task;
        buildSiteByTask(task);
    }

    private Site site;
    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }


    @Override
    public Site getSite() {
        if (Objects.isNull(this.site)){
            return new Site();
        }
        return this.site;
    }

    private Site buildSiteByTask(SpiderTask task){
        this.site = new Site();
        this.site.setDomain(task.getUrl());
        this.site.setSleepTime(SpiderConfig.DEFAULT_EMPTY_TIME);
        this.site.setRetryTimes(SpiderConfig.DEFAULT_RETRY_TIMES);
        this.site.setTimeOut(SpiderConfig.DEFAULT_TIMEOUT);
        return this.site;
    }

    /**
     * 处理列表任务
     * @param task
     */
    private void processListTask(SpiderTask task){

    }

    /**
     * 处理详情任务
     * @param task
     */
    public void processContentTask(SpiderTask task){

    }
}
