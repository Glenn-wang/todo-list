package com.ziyu.todo.domain;

import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 17:40
 */
public class CmdEntity {

    /**
     * 命令类型
     */
    private String type;
    /**
     * 命令
     */
    private String cmd;
    /**
     * 命令参数
     */
    private List<String> args;

    private CmdEntity() {}

    public String getType() {
        return type;
    }

    public String getCmd() {
        return cmd;
    }

    public List<String> getArgs() {
        return args;
    }

    /**
     * 命令构建内部类
     */
    public static class Builder {

        private final CmdEntity entity = new CmdEntity();

        public Builder builder() {
            return new Builder();
        }

        public Builder setType(String type) {
            this.entity.type = type;
            return this;
        }

        public Builder setCmd(String cmd) {
            this.entity.cmd = cmd;
            return this;
        }

        public Builder setArgs(List<String> args) {
            this.entity.args = args;
            return this;
        }

        public CmdEntity build() {
            return entity;
        }
    }
}
