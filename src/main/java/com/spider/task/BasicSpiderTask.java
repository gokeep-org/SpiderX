package com.spider.task;

import com.google.gson.annotations.SerializedName;
import com.spider.pipline.TargetEnum;

import java.util.Map;

public class BasicSpiderTask {
    @SerializedName("spider_name")
    private String spiderName;

    @SerializedName("spider_uuid")
    private String spiderUuid;

    private String site;

    private String channel;

    private String url;

    @SerializedName("rule_type")
    private String ruleType;

    @SerializedName("list_rule")
    private Map<String, Object> listRule;

    @SerializedName("content_rule")
    private Map<String, Object> contentRule;

    private TargetEnum target;

    public String getSpiderName() {
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    public String getSpiderUuid() {
        return spiderUuid;
    }

    public void setSpiderUuid(String spiderUuid) {
        this.spiderUuid = spiderUuid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Map<String, Object> getListRule() {
        return listRule;
    }

    public void setListRule(Map<String, Object> listRule) {
        this.listRule = listRule;
    }

    public Map<String, Object> getContentRule() {
        return contentRule;
    }

    public void setContentRule(Map<String, Object> contentRule) {
        this.contentRule = contentRule;
    }

    public TargetEnum getTarget() {
        return target;
    }

    public void setTarget(TargetEnum target) {
        this.target = target;
    }
}
