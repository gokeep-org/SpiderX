package com.spiderx.config;

import com.spiderx.exception.SpiderException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public final class ApplicationConfigLoad {
    private static final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfigLoad.class);
    private static final String DEFAULT_APPLICATION_CONFIG_FILE_NAME = "application-spider.properties";

    static {
        load();
    }

    // 默认加载， 会有一份默认的配置文件
    public static Properties load() {
        return load(DEFAULT_APPLICATION_CONFIG_FILE_NAME);
    }

    /**
     * 加载应用配置文件
     * @param path
     * @return
     */
    public static Properties load(String path) {
        path = StringUtils.isEmpty(path) ? DEFAULT_APPLICATION_CONFIG_FILE_NAME : path;
        try (InputStream configStream = loadConfigToInputStream(path)) {
            properties.load(configStream);
        } catch (IOException e) {
            logger.error("Load application file '{}' fail", path);
            throw new SpiderException(e.getMessage());
        }
        return properties;
    }

    private static InputStream loadConfigToInputStream(String filePath) {
        return ApplicationConfigLoad.class.getClassLoader().getResourceAsStream(filePath);
    }

    public static Properties getConfigForProperties() {
        return properties;
    }

    public static String getValue(String key){
        try {
            return new String(properties.get(key).toString().getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Get value by properties find error, {}", e.getMessage());
            throw new SpiderException(e.getMessage());
        }
    }
}
