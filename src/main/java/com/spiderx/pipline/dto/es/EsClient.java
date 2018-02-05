package com.spiderx.pipline.dto.es;

import com.spiderx.pipline.dto.DataClient;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class EsClient implements DataClient{

    private static final JestClient client = JestClientBuild.get();
    private static final Logger logger = LoggerFactory.getLogger(EsClient.class);

    @Override
    public Map<String, Boolean> insert(Map<String, Object> content) {
        Map<String, Boolean> res = new HashMap<>();
        String indexName = content.get("target_index_name").toString();
        String indexType = content.get("target_index_type").toString();
        String indexId = Objects.isNull(content.get("target_index_id")) ? UUID.randomUUID().toString() : content.get("target_index_id").toString();
        Index indexer = new Index
                .Builder(content)
                .index(indexName)
                .type(indexType)
                .id(indexId)
                .build();
        try {
            String successIndexId = client.execute(indexer).getId();
            res.put(successIndexId, true);
        } catch (IOException e) {

        }
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
