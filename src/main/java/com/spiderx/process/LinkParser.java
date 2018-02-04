package com.spiderx.process;

import com.spiderx.task.SpiderTask;
import us.codecraft.webmagic.selector.Html;

import java.util.List;
import java.util.Objects;

public class LinkParser implements LinkParse {

    private Html doc;

    private SpiderTask task;

    public static LinkParse build(Html doc, SpiderTask task) {
        return new LinkParser(doc, task);
    }


    private LinkParser(Html doc, SpiderTask task) {
        this.doc = doc;
        this.task = task;
    }

    @Override
    public List<String> parseLink() {
        return Objects.isNull(task.getRuleType()) ? null : getByRule(doc, this.task.getListRule(), this.task.getRuleType());
    }

    @Override
    public String parseNextLink() {
        Object nextLink = getValueByRule(doc, this.task.getNextLinkRule(), this.task.getRuleType());
        return Objects.isNull(nextLink) ? null : nextLink.toString();
    }
}
