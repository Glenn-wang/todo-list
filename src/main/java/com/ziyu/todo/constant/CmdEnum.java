package com.ziyu.todo.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 17:30
 */
public enum CmdEnum {

    /**
     * 程序退出
     */
    EXIT("exit"),
    /**
     * 帮助
     */
    HELP("help"),
    /**
     * 空命令
     */
    BANK("bank"),

    /**
     * 添加命令
     */
    ADD("add"),

    /**
     * 待办列表
     */
    LIST("list"),

    /**
     * 所有todo
     */
    LIST_ALL("--all"),

    /**
     * 完成
     */
    DONE("done");

    public String cmd;

    public static List<String> cmdList;

    static {
        cmdList = new ArrayList<>();
        for (CmdEnum cmdEnum : CmdEnum.values()) {
            cmdList.add(cmdEnum.getCmd());
        }
    }

    CmdEnum(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }
}
