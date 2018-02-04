package com.spider.core.action;

import com.spider.core.domain.output.BaseOutput;
import com.spider.core.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseAction<T extends BaseOutput> {
    
    private final static Logger logger = LoggerFactory.getLogger(BaseAction.class);
    
    public final T execute() throws Exception {
        try {
            // 用户参数格式校验
            inputValidate();
            // 权限校验
            permissionValidate();
            // 附加验证,外加参数组装
            additionalValidate();
            // 业务逻辑
            start();
            // 格式化输出
            T res = formatOutput();
            // 推送 sync 变化
            logSyncAction();
            return res;
        } catch (Exception e) {
            /**
             * 这里对事件做统一异常处理,
             * 接住所有的异常信息并处理
             */
            throw new AppException(e.getMessage());
        }
    }
    
    
    private void inputValidate() throws Exception {
        
    }
    
    private void processInputException() throws Exception {
        
    }
    
    /**
     * 权限校验
     * @throws Exception
     */
    protected abstract void permissionValidate() throws Exception;
    
    /**
     * 一些额外的验证逻辑,也可以做一些参数的组装
     * @throws Exception
     */
    protected abstract void additionalValidate() throws Exception;
    
    /**
     * 主业务逻辑, 装配其他参数如 logSyncAction
     */
    protected abstract void start() throws Exception;
    
    /**
     * 格式化最终的输出结果
     */
    protected abstract T formatOutput() throws Exception;
    
    /**
     * sync 推送整理sync-log消息到队列，也可Async
     */
    protected abstract void logSyncAction() throws Exception;
}
