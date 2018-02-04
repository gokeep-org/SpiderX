package com.spiderx.queue;

public interface TaskQueueOperation {
    /**
     * 监听接受任务消息
     * @param message
     */
    public void receiverTask(String message);

    /**
     * 发送解析结果到队列
     * @param message
     */
    public void sendResult(String message);


    /**
     * 停止监听任务采集
     * @param queueName
     */
    public void stopListenTaskQueue(String queueName);

    /**
     * 开始监听任务队列采集
     * @param queueName
     */
    public void startListenTaskQueue(String queueName);
}
