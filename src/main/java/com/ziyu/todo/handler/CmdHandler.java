package com.ziyu.todo.handler;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.constant.CmdTypeEnum;
import com.ziyu.todo.domain.CmdEntity;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 16:53
 */
public class CmdHandler {

    /**
     * 命令解析
     * @param input 用户输入
     * todo 糟糕的代码
     */
    public CmdEntity cmdParse(String input) {
        if (StringUtils.isNotBlank(input)) {
            input = input.toLowerCase();
            if (CmdEnum.EXIT.getCmd().equals(input.trim())) {
                return buildAssistCmdEntity(CmdEnum.EXIT.getCmd());
            } else if (CmdEnum.HELP.getCmd().equals(input.trim())) {
                return buildAssistCmdEntity(CmdEnum.HELP.getCmd());
            } else {
                return cmdTodoParse(input);
            }
        } else {
            return buildAssistCmdEntity(CmdEnum.BANK.getCmd());
        }
    }

    public CmdEntity buildAssistCmdEntity(String cmd) {
        return new CmdEntity.Builder()
                .setType(CmdTypeEnum.ASSIST.getType())
                .setCmd(cmd)
                .build();
    }

    public CmdEntity cmdTodoParse(String input) {
        List<String> splitList = Arrays.asList(input.split("\\s+"));
        if (!CmdTypeEnum.TODO.getType().equals(splitList.get(0))
                || !CmdEnum.cmdList.contains(splitList.get(1))) {
            throw new RuntimeException("命令不支持！");
        }

        List<String> subList = splitList.subList(2, splitList.size());
        if (subList.size() != 0 && CmdEnum.cmdList.contains(subList.get(0))) {
            String subCmd = subList.get(0);
            List<String> args = subList.subList(1, subList.size());
            return buildTodoCmdEntity(subCmd, args);
        } else {
            return buildTodoCmdEntity(splitList.get(1), subList);
        }
    }

    public CmdEntity buildTodoCmdEntity(String cmd, List<String> args) {
        return new CmdEntity.Builder()
                .setType(CmdTypeEnum.TODO.getType())
                .setCmd(cmd)
                .setArgs(args)
                .build();
    }
}
