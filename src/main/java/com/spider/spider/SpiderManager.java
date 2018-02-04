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
 * 用于构建spider的类
 */

public class SpiderManager {
    private static final Logger logger = LoggerFactory.getLogger(SpiderManager.class);
    private Spider spider;

    private SpiderManager(){

    }

    public static SpiderManager generate(){
        logger.info("Spider Manager start generate spider thread");
        return new SpiderManager();
    }

    /**
     * 设置spider的process
     * @param processor
     * @param <P>
     * @return
     */
    public <P extends PageProcessor> SpiderManager setProcessor(P processor){
        this.spider =  Spider.create(processor);
        return this;
    }

    /**
     * 设置spider的download，目前每个spider是一个独立唯一的download
     * @param downloader
     * @param <D>
     * @return
     */
    public <D extends Downloader> SpiderManager setDownloader(D downloader){
        this.spider = spider.setDownloader(downloader);
        return this;
    }

    /**
     * 设置spider的pipline，支持批量设置， 主要用于处理后的上传等操作
     * @param pipelines
     * @param <T>
     * @return
     */
    public <T extends Pipeline> SpiderManager setPipeline(List<T> pipelines){
        if (CollectionUtils.isEmpty(pipelines)){
            return this;
        }
        pipelines.stream().forEach(pipeline->{
            this.spider.addPipeline(pipeline);
        });
        return this;
    }

    /**
     * spider的自定义调度设置， 默认一般是不需要
     * @param schedule
     * @param <S>
     * @return
     */
    public <S extends Scheduler> SpiderManager setSchedule(S schedule){
        if (Objects.equals(null, schedule)){
            return this;
        }
        this.spider.setScheduler(schedule);
        return this;
    }

    /**
     * 添加采集网站的start_url
     * @param url
     * @return
     */
    public SpiderManager addUrl(String url){
        if (StringUtils.isEmpty(url)){
            return this;
        }
        this.spider.addUrl(url);
        return this;
    }

    /**
     * 设置spider线程采集时间间隔
     * @param emptySleepTime
     * @return
     */
    public SpiderManager setEmptySleepTime(int emptySleepTime){
        this.spider.setEmptySleepTime(emptySleepTime);
        return this;
    }

    /**
     * 设置spider采集的线程数目
     * @param threadSize
     * @return
     */
    public SpiderManager setThreadSize(int threadSize){
        this.spider.thread(threadSize);
        return this;
    }

    /**
     * 批量添加采集网站的url
     * @param urls
     * @return
     */
    public SpiderManager addUrl(List<String> urls){
        if (CollectionUtils.isEmpty(urls)){
            return this;
        }
        urls.stream().forEach(url->{
            this.spider.addUrl(url);
        });
        return this;
    }

    /**
     * 特殊情况下，需要自定义请求采集， 默认不需要
     * @param requests
     * @return
     */
    public Spider addRequest(List<Request> requests){
        if (CollectionUtils.isEmpty(requests)){
            return this.spider;
        }
        requests.stream().forEach(request -> {
            this.spider.addRequest(request);
        });
        return this.spider;
    }

    /**
     * 最终获取Spider线程
     * @return
     */
    public Spider get(){
        return this.spider;
    }

    /**
     * 运行spider线程采集
     */
    public void run(){
        logger.info("Spider Manager start run spider thread: {}", this.spider);
        this.spider.run();
    }

    /**
     * 停止Spider线程采集
     */
    public void stop(){
        logger.info("Spider Manager stop spider thread {}, spider is {}",  this.spider.getStatus().name(), this.spider);
        this.spider.stop();
    }

    /**
     * 获取Spider对象, 目前对外可见，会存到map中， spiderName->spider
     * @return
     */
    public Spider getSpider() {
        return this.spider;
    }

    /**
     * 外部自定义的spider对象注入
     * @param spider
     */
    public void setSpider(Spider spider) {
        this.spider = spider;
    }
}
