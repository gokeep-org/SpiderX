package com.spiderx.download;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

/**
 * 下载处理类
 * 1： 对对一般页面的下载
 * 2： 动态页面生成的下载
 * 这里主要应对不同的任务下的特殊需求，如模拟浏览器执行js，cookie校验，验证码识别等
 */
public class DefaultHttpDownload extends HttpClientDownloader{
    @Override
    public Page download(Request request, Task task) {
        return super.download(request, task);
    }
}