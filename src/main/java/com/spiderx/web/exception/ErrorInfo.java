package com.spiderx.web.exception;

import com.google.gson.annotations.SerializedName;

public class ErrorInfo extends BaseInfo {
    private String code;
    @SerializedName("msg")
    private String messsage;
    private String uuid;

    public ErrorInfo() {
        setSuccess("false");
    }

    public ErrorInfo(String code, String messsage) {
        this.code = code;
        this.messsage = messsage;
        setSuccess("false");
    }

    public ErrorInfo(String code, String messsage, String uuid) {
        this.code = code;
        this.messsage = messsage;
        this.uuid = uuid;
        setSuccess("false");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
