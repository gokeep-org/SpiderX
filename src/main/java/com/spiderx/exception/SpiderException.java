package com.spiderx.exception;

import java.util.UUID;

public class SpiderException extends RuntimeException{
    /**
     * 请求事件状态码
     */
    private String code;
    /**
     * 请求事件抛出之后生成的UUID
     * 在全局铺货异常会用到，这个UUID会跟踪整个事件的声明周期
     * 仅当只有错误发生的时候,这里是默认生成的UUID
     * 支持传入UUID串
     */
    private String uuid = UUID.randomUUID().toString();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
