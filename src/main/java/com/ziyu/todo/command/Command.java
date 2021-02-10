package com.ziyu.todo.command;

import java.util.List;

/**
 * @author ziyu
 */
public interface Command {

    /**
     * 执行命令
     * @param args
     * @return 执行结果
     */
    boolean execute(List<String> args);
}
