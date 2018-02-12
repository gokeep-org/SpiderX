package com.spiderx.cache;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;
import com.spiderx.task.SpiderTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class HazelcastConfig implements MessageListener<SpiderTask>{

    @Bean
    public HazelcastInstance hazelcastClientBean(){
        Config config = new Config();
        HazelcastInstance client = Hazelcast.newHazelcastInstance(config);
        ITopic<SpiderTask> topic = client.getTopic("spider-task");
        topic.addMessageListener(new HazelcastConfig());
        return client;
    }

    @Override
    public void onMessage(Message<SpiderTask> message) {
        if (Objects.isNull(message)){
            return;
        }
        SpiderTask receiveMessage = message.getMessageObject();
        if (Objects.isNull(receiveMessage)){
            return;
        }
        CacheMessageHanlder.get().process(receiveMessage);
    }
}
