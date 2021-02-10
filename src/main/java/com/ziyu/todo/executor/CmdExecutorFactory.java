package com.ziyu.todo.executor;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.executor.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyu
 * @date 2021/2/10 18:55
 */
public class CmdExecutorFactory {

    private static final Map<String, CmdExecutor> CMD_EXECUTOR_MAP = new HashMap<>();

    /**
     * 初始化
     */
    public static void init() {
        CMD_EXECUTOR_MAP.put(CmdEnum.BANK.getCmd(), new DefaultCmdExecutor());
        CMD_EXECUTOR_MAP.put(CmdEnum.ADD.getCmd(), new AddCmdExecutor());
        CMD_EXECUTOR_MAP.put(CmdEnum.LIST.getCmd(), new ListCmdExecutor());
        CMD_EXECUTOR_MAP.put(CmdEnum.DONE.getCmd(), new DoneCmdExecutor());
        CMD_EXECUTOR_MAP.put(CmdEnum.LIST_ALL.getCmd(), new ListAllCmdExecutor());
    }

    /**
     * 获取命令执行器
     * @param cmd 命令
     * @return 命令执行器
     */
    public static CmdExecutor get(String cmd) {
        return CMD_EXECUTOR_MAP.get(cmd);
    }
}
