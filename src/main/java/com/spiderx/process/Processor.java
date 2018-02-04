package com.spiderx.process;

import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Processor 接口
 * 所有的processor处理类均需要实现这个接口，同意的处理实现方法在这里编写
 */
public interface Processor extends PageProcessor{
    default void asyncLog(String logMsg, String target){

    }
}
