package com.spiderx.pipline.dto.mysql;

import com.spiderx.pipline.dto.DataClient;

import java.util.List;
import java.util.Map;

public class MysqlClient implements DataClient{
    @Override
    public Map<String, Boolean> insert(Map<String, Object> content) {
        return null;
    }

    @Override
    public Map<String, Boolean> inserts(List<Map<String, Object>> content) {
        return null;
    }

    @Override
    public Map<String, Boolean> delete(Map<String, Object> content) {
        return null;
    }

    @Override
    public Map<String, Boolean> update(Map<String, Object> content) {
        return null;
    }

    @Override
    public Map<String, Boolean> search(Map<String, Object> content) {
        return null;
    }

    @Override
    public void close() {

    }
}
