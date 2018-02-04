package com.spiderx.process;

import com.spiderx.config.PageKey;
import com.spiderx.config.SpiderConfig;
import com.spiderx.task.SpiderTask;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Html;

import java.util.List;
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
            processList(page);
        } else {
            processContent(page);
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
    private void processList(Page page) {
        Html doc = page.getHtml();
        if (Objects.isNull(doc)) {
            return;
        }
        List<String> contentLink = LinkParser.build(doc, this.task).parseLink();
        String nextListLink = LinkParser.build(doc, this.task).parseNextLink();
        if (CollectionUtils.isEmpty(contentLink) || StringUtils.isEmpty(nextListLink)) {
            page.setSkip(true);
        }
        page.putField(PageKey.CONTENT_LINKS, contentLink);
        page.addTargetRequest(nextListLink);
    }

    /**
     * 处理详情任务
     */
    public void processContent(Page page) {
        Html doc = page.getHtml();
        if (Objects.isNull(doc)) {
            return;
        }
        CommonContent commonContent = ContentParser.build(doc, this.task).parseContent();
        if (Objects.isNull(commonContent) || MapUtils.isEmpty(commonContent.getResult())) {
            page.setSkip(true);
        }
        page.putField(PageKey.CONTENT_RESULT, commonContent);
    }
}
