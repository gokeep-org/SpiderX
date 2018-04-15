package com.spiderx.task;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

public class BasicSpiderTask implements Serializable {
    @SerializedName("spider_name")
    private String spiderName;

    @SerializedName("spider_uuid")
    private String spiderUuid = UUID.randomUUID().toString();

    private String site;

    private String channel;

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
}
