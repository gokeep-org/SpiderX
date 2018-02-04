package com.spiderx.pipline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MysqlPipeline implements Pipeline{
    private static final Logger logger = LoggerFactory.getLogger(MysqlPipeline.class);
    @Override
    public void process(ResultItems resultItems, Task task) {

    }
}
