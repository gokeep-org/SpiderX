package com.spider.core.config;

import com.spider.core.util.PropertiesUtil;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JettyConfig extends JettyEmbeddedServletContainerFactory {

    private static PropertiesUtil propertiesUtil = new PropertiesUtil("jetty-config.properties");
    private static final String maxThread = PropertiesUtil.getValue("server.jetty.maxthread.size");
    private static final String minThread = PropertiesUtil.getValue("server.jetty.minthread.size");
    private static final String timout = PropertiesUtil.getValue("server.jetty.timeout");
    private static final String queueSize = PropertiesUtil.getValue("server.jetty.queue.size");
    private static QueuedThreadPool threadPool = new QueuedThreadPool();

    public JettyConfig() {
        setMaxThread();
        setMinThread();
        setTimout();
        setQueueSize();
        setThreadPool(threadPool);
    }

    public void setMaxThread() {
        threadPool.setMaxThreads(Integer.parseInt(maxThread));
    }

    public void setMinThread() {
        threadPool.setMinThreads(Integer.parseInt(minThread));
    }

    public void setTimout() {
        threadPool.setIdleTimeout(Integer.parseInt(timout));
    }

    public void setQueueSize() {
        
    }
}