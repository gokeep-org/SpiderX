package com.spiderx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfigBean {
    private Map<String, String> configs = new HashMap<>();

    public Map<String, String> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, String> configs) {
        this.configs = configs;
    }

    @Bean
    public ApplicationConfigBean configBean(){
        ApplicationConfigLoad.getConfigForProperties().stringPropertyNames().stream().forEach(key->{
            configs.put(key, ApplicationConfigLoad.getValue(key));
        });
        return this;
    }

    public String getValueInCache(String key){
        return configs.get(key);
    }
}