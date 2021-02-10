package com.ziyu.todo.constant;

/**
 * @author ziyu
 * @date 2021/2/10 17:43
 */
public enum CmdTypeEnum {

    /**
     * todo命令
     */
    TODO("todo"),
    /**
     * 辅助命令
     */
    ASSIST("assist");

    public String type;

    CmdTypeEnum(String cmd) {
        this.type = cmd;
    }

    public String getType() {
        return type;
    }
}
