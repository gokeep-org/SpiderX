package com.spiderx.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Config {
    @SerializedName("node_id")
    private int nodeId;
    private int type;
    private String desc;
    private String version;

    private List<TaskConfig> resources;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<TaskConfig> getResources() {
        return resources;
    }

    public void setResources(List<TaskConfig> resources) {
        this.resources = resources;
    }
}
