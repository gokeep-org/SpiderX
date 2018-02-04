package com.spider.process;

import com.spider.config.SpiderConfig;
import com.spider.task.SpiderTask;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CommonTaskProcessor implements Processor {

    private SpiderTask task;

    public CommonTaskProcessor(SpiderTask task) {
        this.task = task;
        buildSite();
    }

    private Site site;

    @Override
    public void process(Page page) {
        if (this.task.getListTask()) {
            processListTask(page);
        } else {
            processContentTask(page);
        }
    }


    @Override
    public Site getSite() {
        if (Objects.isNull(this.site)) {
            return new Site();
        }
        return this.site;
    }

    private Site buildSite() {
        this.site = new Site();
        this.site.setDomain(this.task.getUrl());
        this.site.setSleepTime(SpiderConfig.DEFAULT_EMPTY_TIME);
        this.site.setRetryTimes(SpiderConfig.DEFAULT_RETRY_TIMES);
        this.site.setTimeOut(SpiderConfig.DEFAULT_TIMEOUT);
        return this.site;
    }

    /**
     * 处理列表任务
     */
    private void processListTask(Page page) {
        Map<String, Object> listRules = this.task.getListRule();
        List<String> urls = new ArrayList<>();
        listRules.entrySet().stream().forEach(rule -> {
            String url = page.getHtml().links().xpath(rule.getValue().toString()).toString();
            urls.add(url);
        });
        page.putField("content_link_url", urls);
        // 添加下一页的url
        page.addTargetRequest(page.getHtml().links().xpath(this.task.getNextLinkRule().trim()).toString());
        // 解析列表url
        // 发送到队列
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    /**
     * 处理详情任务
     */
    public void processContentTask(Page page) {
        // 解析内容url
        // 发送到队列
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }
}
