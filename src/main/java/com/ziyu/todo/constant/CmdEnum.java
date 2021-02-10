package com.ziyu.todo.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyu
 */
public enum CmdEnum {

    /**
     * 命令
     */
    TODO("todo"),
    /**
     * 参数：添加
     */
    ADD("add"),
    /**
     * 参数：完成
     */
    DONE("done"),
    /**
     * 参数：查看未完成
     */
    LIST("list"),
    /**
     * 参数：查看所有
     */
    LIST_ALL("--all"),
    /**
     * 帮助
     */
    HELP("help"),
    /**
     * 退出
     */
    EXIT("exit"),
    /**
     * 清屏
     */
    CLEAR("clear");

    CmdEnum(String cmd) {
        this.cmd = cmd;
    }

    private final String cmd;

    private static final List<String> CMD_LIST = new ArrayList<String>();

    public String getCmd() {
        return cmd;
    }

    static {
        for (CmdEnum value : CmdEnum.values()) {
            CMD_LIST.add(value.getCmd());
        }
    }

    public static List<String> getCmdList() {
        return CMD_LIST;
    }
}
