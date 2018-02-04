package com.spider.pipline;

import com.spider.config.TargetCode;
import com.spider.config.TargetName;

public enum TargetEnum {
    ES(TargetName.ES, TargetCode.ES),
    MONGODB(TargetName.MONGODB, TargetCode.MONGODB),
    MYSQL(TargetName.MYSQL, TargetCode.MYSQL),
    REDIS(TargetName.REDIS, TargetCode.REDIS);

    private String name;
    private Integer code;
    private String address;
    private String username;
    private String password;
    private String auth;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    TargetEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    TargetEnum(String name, Integer code, String address) {
        this.name = name;
        this.code = code;
        this.address = address;
    }

    TargetEnum(String name, Integer code, String address, String username, String password) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    TargetEnum(String name, Integer code, String address, String username, String password, String auth) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.username = username;
        this.password = password;
        this.auth = auth;
    }
}
