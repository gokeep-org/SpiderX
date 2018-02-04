package com.spiderx.api;

import com.spiderx.library.SpiderContainer;
import com.spiderx.pipline.TargetEnum;
import com.spiderx.spider.SpiderManager;
import com.spiderx.task.SpiderTask;
import us.codecraft.webmagic.Spider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/task")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TaskRest {

    @POST
    public Map addSpiderTask(@QueryParam("url") String url, @QueryParam("name") String name){
        SpiderTask task = new SpiderTask();
        task.setUrl(url);
        task.setSpiderName(name);
        task.setTarget(TargetEnum.ES);
        SpiderManager.generate().enableDefaultSpider(task);
        return null;
    }

    @GET
    public Map<String, Spider> getSpiderList(){
        return SpiderContainer.getSpiders();
    }
}
