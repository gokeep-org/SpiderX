package com.spiderx.web.action.factory;

import com.spiderx.web.action.task.AddTaskAction;
import com.spiderx.task.SpiderTask;

public class TaskActionFactory extends BaseActionFactory{
    public static AddTaskAction getAddTaskAction(SpiderTask task){
        return new AddTaskAction(task);
    }
}
