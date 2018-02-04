package com.spiderx.process;

import com.spiderx.task.SpiderTask;
import com.spiderx.util.DateUtil;
import org.apache.commons.collections.MapUtils;
import us.codecraft.webmagic.selector.Html;

import java.util.HashMap;
import java.util.Map;

public class ContentParser implements ContentParse{
    private Html doc;

    private SpiderTask task;

    public static ContentParser build(Html doc, SpiderTask task) {
        return new ContentParser(doc, task);
    }

    private ContentParser(Html doc, SpiderTask task) {
        this.doc = doc;
        this.task = task;
    }

    @Override
    public CommonContent parseContent() {
        CommonContent content = new CommonContent();
        if (MapUtils.isEmpty(this.task.getContentRule())){
            return content;
        }
        Map<String, Object> result = new HashMap<>();
        this.task.getContentRule().entrySet().stream().forEach(rule->{
            Object value = getValueByRule(doc, this.task.getNextLinkRule(), this.task.getRuleType());
            result.put(rule.getKey(), value);
        });
        content.setResult(result);
        content.setTime(DateUtil.getCurrentDateTimeValue());
        return content;
    }
}
