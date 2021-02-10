package com.ziyu.todo.executor;

import com.ziyu.todo.domain.CmdEntity;

/**
 * @author ziyu
 * @date 2021/2/10 16:54
 */
public interface CmdExecutor {

    /**
     * 命令执行
     * @param entity 命令信息
     * @return 命令执行结果
     */
    CmdExecuteResult execute(CmdEntity entity);

    /**
     * 获取命令key
     * @return 命令key
     */
    String getCmdKey();
}
