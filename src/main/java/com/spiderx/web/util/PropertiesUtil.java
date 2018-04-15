package com.spiderx.web.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Properties;

@Component
public class PropertiesUtil {

    private static String userConfigFile = "jetty.properties";
    private static PropertiesUtil propertiesUtil = new PropertiesUtil();
    private static final Properties properties = new Properties();

    public PropertiesUtil() {
    }

    public PropertiesUtil(String userConfigFile) {
        PropertiesUtil.userConfigFile = userConfigFile;
    }

    public static PropertiesUtil setConfigFileName(String configFile) {
        userConfigFile = configFile;
        return propertiesUtil;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getValue(String key) {
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(userConfigFile);
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.equals(null, in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String value = null;
        try {
            value = new String(properties.get(key).toString().getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("charset error,please use utf-8 charset code!");
        }
        if (null == value) {
            System.out.println("notice: you get value is null!");
        }
        return value;
    }

    public static String getUserConfigFile() {
        return userConfigFile;
    }

    public static void setUserConfigFile(String userConfigFile) {
        PropertiesUtil.userConfigFile = userConfigFile;
    }
}
