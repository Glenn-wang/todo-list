package com.ziyu.todo.executor.impl;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.executor.CmdExecuteResult;
import com.ziyu.todo.executor.CmdExecutor;

/**
 * @author ziyu
 * @date 2021/2/10 19:09
 */
public class DefaultCmdExecutor implements CmdExecutor {

    @Override
    public CmdExecuteResult execute(CmdEntity entity) {
        return null;
    }

    @Override
    public String getCmdKey() {
        return CmdEnum.BANK.getCmd();
    }
}
