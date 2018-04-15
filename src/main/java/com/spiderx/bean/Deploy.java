package com.spiderx.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 项目发布
 */
public class Deploy implements Serializable {
    // 发布名称，缺省
    private String name;
    // 发布版本，必要
    private String version;
    // 发布描述，缺省
    private String desc;
    // 部署目标ip，缺省
    private List<String> ip;
    // 发布模式，必要
    private Integer model = 0;
    // 发布分支，默认master， 如果以tag或者commitId也是支持的
    private String branch = "master";
    private String tag;
    private String commitId;
}