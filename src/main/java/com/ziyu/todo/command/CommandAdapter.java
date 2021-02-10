package com.ziyu.todo.command;

import com.ziyu.todo.constant.CmdEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyu
 */
public class CommandAdapter {

    private final static Map<String, Command> CMD_MAP;

    static {
        CMD_MAP = new HashMap<String, Command>();
        CMD_MAP.put(CmdEnum.ADD.getCmd(), new AddCommand());
        CMD_MAP.put(CmdEnum.LIST.getCmd(), new ListCommand());
    }

    public static Command getCmd(String cmd) {
        return CMD_MAP.get(cmd);
    }


}
