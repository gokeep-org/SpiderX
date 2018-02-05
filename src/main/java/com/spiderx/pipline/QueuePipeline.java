package com.spiderx.pipline;

import com.spiderx.config.PageKey;
import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

public class QueuePipeline implements Pipeline{
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> contentLinks = (List<String>) resultItems.getAll().get(PageKey.CONTENT_LINKS);
        if (CollectionUtils.isEmpty(contentLinks)){
            return;
        }
        uploadContentToTarget(contentLinks);
    }

    private Boolean uploadContentToTarget(List<String> contentLink){
        // 上传内容任务到消息队列
        return false;
    }
}
