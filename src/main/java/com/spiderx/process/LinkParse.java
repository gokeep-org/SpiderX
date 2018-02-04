package com.spiderx.process;

import com.spiderx.config.RuleType;
import us.codecraft.webmagic.selector.CssSelector;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public interface LinkParse extends Parse{
    public List<String> parseLink();

    public String parseNextLink();

    /**
     * 默认根据规则的解析方法
     * @param doc
     * @param rule
     * @param ruleType
     * @return
     */
    default List<String> getByRule(Html doc, String rule, RuleType ruleType){
        if (ruleType.getName().equals(RuleType.XPATH.getName())) {
            return doc.links().xpath(rule).all();
        }else if (ruleType.getName().equals(RuleType.SELECTOR.getName())){
            return doc.links().select(new CssSelector(rule)).all();
        }
        return doc.links().xpath(rule).all();
    }
}
