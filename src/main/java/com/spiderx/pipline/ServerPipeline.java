package com.spiderx.pipline;

import com.spiderx.config.PageKey;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class ServerPipeline implements Pipeline{
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> contentLinks = (List<String>) resultItems.getAll().get(PageKey.CONTENT_LINKS);

    }
}
