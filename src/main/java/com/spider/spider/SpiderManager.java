package com.spider.spider;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.List;
import java.util.Objects;

/**
 * 用于构建spider的核心类
 * 这个是一个单例的形式，但是不能让它成为真正的单例
 * 每个采集点的spider应当由独立的采集域来创建
 * 使用的Template:
 * -----------------------------------code------
   spiderManager.generate()
     .setProcessor(new GithubRepoPageProcessor())
     .setThreadSize(5)
     .addUrl("https://github.com/code4craft")
     .run();
 * ----------------------------------------------
 */

public class SpiderManager {
    private static final Logger logger = LoggerFactory.getLogger(SpiderManager.class);
    private Spider spider;

    private SpiderManager() {

    }

    public static SpiderManager generate() {
        logger.info("Spider Manager start generate spider thread");
        return new SpiderManager();
    }

    public <P extends PageProcessor> SpiderManager getSimpleSpider(String url, P processor) {
        return setProcessor(processor).addUrl(url);
    }

    public <P extends PageProcessor, T extends Pipeline> SpiderManager getSimpleSpider(String url, P processor, List<T> pipelines) {
        return setProcessor(processor).setPipelines(pipelines).addUrl(url);
    }

    public <P extends PageProcessor, T extends Pipeline> SpiderManager getSimpleSpider(String url, P processor, T pipeline) {
        return setProcessor(processor).addPipeline(pipeline).addUrl(url);
    }

    /**
     * 通用获取SpiderManager的方法，支持全部的采集策略
     *
     * @param requests
     * @param downloader
     * @param processor
     * @param scheduler
     * @param pipelines
     * @param emptyTime
     * @param threadSize
     * @param <P>
     * @param <T>
     * @param <D>
     * @param <S>
     * @return
     */
    public <P extends PageProcessor, T extends Pipeline, D extends Downloader, S extends Scheduler> SpiderManager getCommonSpider(
            List<Request> requests,
            D downloader,
            P processor,
            S scheduler,
            List<T> pipelines,
            int emptyTime,

            int threadSize
    ) {
        return setProcessor(processor)
                .setDownloader(downloader)
                .setSchedule(scheduler)
                .setPipelines(pipelines)
                .setEmptySleepTime(emptyTime)
                .setThreadSize(threadSize)
                .addRequest(requests);
    }

    /**
     * 设置spider的process
     *
     * @param processor
     * @param <P>
     * @return
     */
    public <P extends PageProcessor> SpiderManager setProcessor(P processor) {
        this.spider = Spider.create(processor);
        return this;
    }

    /**
     * 设置spider的download，目前每个spider是一个独立唯一的download
     *
     * @param downloader
     * @param <D>
     * @return
     */
    public <D extends Downloader> SpiderManager setDownloader(D downloader) {
        this.spider = spider.setDownloader(downloader);
        return this;
    }

    /**
     * 设置spider的pipline，支持批量设置， 主要用于处理后的上传等操作
     *
     * @param pipelines
     * @param <T>
     * @return
     */
    public <T extends Pipeline> SpiderManager setPipelines(List<T> pipelines) {
        if (CollectionUtils.isEmpty(pipelines)) {
            return this;
        }
        pipelines.stream().forEach(pipeline -> {
            this.spider.addPipeline(pipeline);
        });
        return this;
    }

    public <T extends Pipeline> SpiderManager addPipeline(T pipeline) {
        if (Objects.equals(null, pipeline)) {
            return this;
        }
        this.spider.addPipeline(pipeline);
        return this;
    }

    /**
     * spider的自定义调度设置， 默认一般是不需要
     *
     * @param schedule
     * @param <S>
     * @return
     */
    public <S extends Scheduler> SpiderManager setSchedule(S schedule) {
        if (Objects.equals(null, schedule)) {
            return this;
        }
        this.spider.setScheduler(schedule);
        return this;
    }

    /**
     * 添加采集网站的start_url
     *
     * @param url
     * @return
     */
    public SpiderManager addUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return this;
        }
        this.spider.addUrl(url);
        return this;
    }

    /**
     * 设置spider线程采集时间间隔
     *
     * @param emptySleepTime
     * @return
     */
    public SpiderManager setEmptySleepTime(int emptySleepTime) {
        this.spider.setEmptySleepTime(emptySleepTime);
        return this;
    }

    /**
     * 设置spider采集的线程数目
     *
     * @param threadSize
     * @return
     */
    public SpiderManager setThreadSize(int threadSize) {
        this.spider.thread(threadSize);
        return this;
    }

    /**
     * 批量添加采集网站的url
     *
     * @param urls
     * @return
     */
    public SpiderManager addUrl(List<String> urls) {
        if (CollectionUtils.isEmpty(urls)) {
            return this;
        }
        urls.stream().forEach(url -> {
            this.spider.addUrl(url);
        });
        return this;
    }

    /**
     * 特殊情况下，需要自定义请求采集， 默认不需要
     *
     * @param requests
     * @return
     */
    public SpiderManager addRequest(List<Request> requests) {
        if (CollectionUtils.isEmpty(requests)) {
            return this;
        }
        requests.stream().forEach(request -> {
            this.spider.addRequest(request);
        });
        return this;
    }

    /**
     * 最终获取Spider线程
     *
     * @return
     */
    public Spider get() {
        return this.spider;
    }

    /**
     * 运行spider线程采集
     */
    public void run() {
        logger.info("Spider Manager start run spider thread: {}", this.spider);
        this.spider.run();
    }

    /**
     * 停止Spider线程采集
     */
    public void stop() {
        logger.info("Spider Manager stop spider thread {}, spider is {}", this.spider.getStatus().name(), this.spider);
        this.spider.stop();
    }

    /**
     * 获取Spider对象, 目前对外可见，会存到map中， spiderName->spider
     *
     * @return
     */
    public Spider getSpider() {
        return this.spider;
    }

    /**
     * 外部自定义的spider对象注入
     *
     * @param spider
     */
    public void setSpider(Spider spider) {
        this.spider = spider;
    }
}
