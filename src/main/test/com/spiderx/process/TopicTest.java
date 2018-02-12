package com.spiderx.process;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.spiderx.Bootstracp;
import com.spiderx.task.SpiderTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Bootstracp.class)
public class TopicTest {

    @Autowired
    HazelcastInstance hazelcastInstance;

    @Test
    public void testAddTopic(){
        ITopic<SpiderTask> topic = hazelcastInstance.getTopic("spider-task");
        SpiderTask task = new SpiderTask();
        topic.publish(task);
    }
}
