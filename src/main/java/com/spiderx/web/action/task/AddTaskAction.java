package com.spiderx.web.action.task;

import com.spiderx.web.action.item.ItemAction;
import com.spiderx.web.domain.output.task.TaskOperatiobOutput;
import com.spiderx.exception.SpiderException;
import com.spiderx.task.SpiderTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AddTaskAction extends ItemAction<TaskOperatiobOutput> {
    private SpiderTask task;

    private static final Logger logger = LoggerFactory.getLogger(AddTaskAction.class);
    public AddTaskAction(SpiderTask task) {
        this.task = task;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.isNull(this.task)){
            throw new SpiderException("add task fail, task is null");
        }
    }

    @Override
    protected void start() throws Exception {
        taskService.addTask(this.task);
    }

    @Override
    protected TaskOperatiobOutput formatOutput() throws Exception {
        TaskOperatiobOutput output = new TaskOperatiobOutput();
        output.setSuccess(true);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        logger.info("add task is successs , task: {}", this.task);
    }
}