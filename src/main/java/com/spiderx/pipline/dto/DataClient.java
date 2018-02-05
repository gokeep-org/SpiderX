package com.spiderx.pipline.dto;

import com.spiderx.config.TargetName;
import com.spiderx.pipline.dto.es.EsClient;
import com.spiderx.pipline.dto.mongo.MongoClient;
import com.spiderx.pipline.dto.mysql.MysqlClient;
import com.spiderx.pipline.dto.redis.RedisClient;

import java.util.List;
import java.util.Map;

/**
 * 客户端dto接口
 */
public interface DataClient {
    public Map<String, Boolean> insert(Map<String, Object> content);
    public Map<String, Boolean> inserts(List<Map<String, Object>> content);
    public Map<String, Boolean> delete(Map<String, Object> content);
    public Map<String, Boolean> update(Map<String, Object> content);
    public Map<String, Boolean> search(Map<String, Object> content);
    public void close();

    /**
     * 获取制定的客户端
     * @param clientType
     * @return
     */
    default DataClient get(String clientType){
        switch (clientType){
            case TargetName.ES : return new EsClient();
            case TargetName.MONGODB : return new MongoClient();
            case TargetName.MYSQL : return new MysqlClient();
            case TargetName.REDIS : return new RedisClient();
            default: return new EsClient();
        }
    }


    default EsClient es(){
        return new EsClient();
    }

    default MongoClient mongo(){
        return new MongoClient();
    }

    default MysqlClient mysql(){
        return new MysqlClient();
    }

    default RedisClient redis(){
        return new RedisClient();
    }
}
