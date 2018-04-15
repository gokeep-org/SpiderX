package com.spiderx.api;

import com.spiderx.web.action.factory.TaskActionFactory;
import com.spiderx.web.domain.output.task.TaskOperatiobOutput;
import com.spiderx.library.SpiderContainer;
import com.spiderx.task.SpiderTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/task")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TaskRest {
    private static final Logger logger = LoggerFactory.getLogger(TaskRest.class);
    /**
     * 该接口主要针对以Channel为级别的任务添加，初始任务
     * @param task
     * @return
     */
    @POST
    public TaskOperatiobOutput addSpiderTask(SpiderTask task) throws Exception{
        return TaskActionFactory.getAddTaskAction(task).execute();
    }

    @GET
    public Map<String, Spider> getSpiderList(){
        return SpiderContainer.getSpiders();
    }
}
