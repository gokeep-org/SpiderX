package com.spider.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spider.task.SpiderTask;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class SerializeUtil {
    private SerializeUtil() {
    }

    private static Gson gson = new GsonBuilder().create();

    private static SerializeUtil serializeUtil = new SerializeUtil();

    private static SerializeUtil getInstance() {
        if (Objects.equals(serializeUtil, null)) {
            serializeUtil = new SerializeUtil();
        }
        return serializeUtil;
    }

    private static Gson getGson(){
        if (Objects.equals(gson, null)){
            gson = new GsonBuilder().create();
        }
        return gson;
    }

    public static  <T> T fromJson(String json, Class<T> classes){
        return StringUtils.isEmpty(json) || classes == null ? null : getGson().fromJson(json, classes);
    }

    public static SpiderTask fromJsonToSpiderTask(String json){
        return fromJson(json, SpiderTask.class);
    }

    public static <T> String toJsonString(T obj){
        return Objects.isNull(obj) ? null : getGson().toJson(obj);
    }

    public static String spiderTaskToJsonString(SpiderTask task){
        return toJsonString(task);
    }


}
