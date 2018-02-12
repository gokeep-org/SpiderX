package com.spiderx.task;

import com.google.gson.annotations.SerializedName;
import com.spiderx.config.RuleType;
import com.spiderx.pipline.TargetEnum;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public class BasicSpiderTask implements Serializable {
    @SerializedName("spider_name")
    private String spiderName;

    @SerializedName("spider_uuid")
    private String spiderUuid = UUID.randomUUID().toString();

    private String site;

    private String channel;

    private String url;

    @SerializedName("is_list_task")
    private Boolean isListTask = false;

    String s = "//*[@id=\"wgt-ask\"]/h1/span";

    @SerializedName("rule_type")
    private RuleType ruleType = RuleType.DEFAULT;

    @SerializedName("list_rule")
    private String listRule;

    @SerializedName("content_rule")
    private Map<String, String> contentRule;

    @SerializedName("next_link_rule")
    private String nextLinkRule;

    private TargetEnum target = TargetEnum.ES;

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

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public String getListRule() {
        return listRule;
    }

    public void setListRule(String listRule) {
        this.listRule = listRule;
    }

    public Map<String, String> getContentRule() {
        return contentRule;
    }

    public void setContentRule(Map<String, String> contentRule) {
        this.contentRule = contentRule;
    }

    public TargetEnum getTarget() {
        return target;
    }

    public void setTarget(TargetEnum target) {
        this.target = target;
    }

    public Boolean getListTask() {
        return isListTask;
    }

    public void setListTask(Boolean listTask) {
        isListTask = listTask;
    }

    public String getNextLinkRule() {
        return nextLinkRule;
    }

    public void setNextLinkRule(String nextLinkRule) {
        this.nextLinkRule = nextLinkRule;
    }
}
