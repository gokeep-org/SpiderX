package com.spiderx.queue;

public class ListenTakQueueImpl implements TaskQueueOperation {
    @Override
    public void receiverTask(String message) {
        // 转化成任务
        // 取出spider name， 检查启动过滤列表是否被启动
        // 没有启动，return， 启动就判断是否已经在采集中
        // 如果已经启动，return， 没有的话， 根据任务创建spider线程采集
    }

    @Override
    public void sendResult(String message) {
        // 转化成内容，取出target解析
        // 发送到指定的target中， 取到返回结果
        // 如果失败，重新发送，10次之后，取消还失败，取消发送，并记录下来到redis
    }

    @Override
    public void stopListenTaskQueue(String queueName) {

    }

    @Override
    public void startListenTaskQueue(String queueName) {

    }
}
