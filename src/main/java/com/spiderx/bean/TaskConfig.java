package com.spiderx.bean;

import com.google.gson.annotations.SerializedName;

public class TaskConfig {
    private String name;
    private String type;
    private String site;
    @SerializedName("reg_list_url")
    private String regListUrl;
    @SerializedName("reg_content_url")
    private String regContentUrl;
    @SerializedName("page_now")
    private Integer pageNow;
    @SerializedName("page_size")
    private Integer pageSize;
    @SerializedName("is_enable_web_client")
    private Boolean isEnableWebClient;
    @SerializedName("is_use_proxy")
    private Boolean isUseProxy;
}
