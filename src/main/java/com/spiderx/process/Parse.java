package com.spiderx.process;

import com.spiderx.config.RuleType;
import us.codecraft.webmagic.selector.CssSelector;
import us.codecraft.webmagic.selector.Html;

public interface Parse {
    /**
     * 通用根据规则匹配值
     * @param doc
     * @param rule
     * @param ruleType
     * @return
     */
    default Object getValueByRule(Html doc, String rule, RuleType ruleType){
        if (ruleType.getName().equals(RuleType.XPATH.getName())) {
            return doc.links().xpath(rule);
        }else if (ruleType.getName().equals(RuleType.SELECTOR.getName())){
            return doc.links().select(new CssSelector(rule));
        }
        return doc.links().xpath(rule);
    }
}
