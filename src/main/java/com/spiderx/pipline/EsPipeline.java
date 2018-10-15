package com.spiderx.pipline;

import cn.networklab.requests.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

public class EsPipeline implements Pipeline{
    private static final Logger logger = LoggerFactory.getLogger(EsPipeline.class);

    @Autowired
    Requests requests;
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> res= resultItems.getAll();
        requests.post("http://122.114.103.85:9200/log/s", null);
    }
}
