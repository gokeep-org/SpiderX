package com.spiderx.pipline.dto.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.http.JestHttpClient;

import java.util.Objects;

public class JestClientBuild{
    private static JestClient jestClient;

    static {
        synchronized (jestClient){
            jestClient = Objects.isNull(jestClient) ? new JestHttpClient() : jestClient;
        }
    }

    public static JestClient get() {
        return EsClientFactory.getEsClient();
    }

    public static void setJestClient(JestClient jestClient) {
        JestClientBuild.jestClient = jestClient;
    }
}
