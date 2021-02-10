package com.ziyu.todo.interpreter;

import com.ziyu.todo.command.Command;
import com.ziyu.todo.command.CommandAdapter;
import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.domain.TodoItem;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ziyu
 */
public class CommandInterpreter {

    public void interpreter(String input) {
        if (StringUtils.isBlank(input)) {
            throw new RuntimeException("命令不能为空!");
        }

        List<String> argsList = Arrays.asList(input.split("\\s+"));
        if (argsList.size() < 1) {
            throw new RuntimeException("命令不能为空!");
        }

        if (!CmdEnum.TODO.getCmd().equals(argsList.get(0))) {
            throw new RuntimeException("命令不支持!");
        }

        List<String> cmdList = CmdEnum.getCmdList();
        if (!cmdList.contains(argsList.get(1))) {
            throw new RuntimeException("命令不支持!");
        }

        // 适配命令并执行
        String cmd = argsList.get(1);
        List<String> args = new ArrayList<String>();

        if (!CmdEnum.LIST.getCmd().equals(cmd)) {
            for (int i = 2; i < argsList.size(); i++) {
                args.add(argsList.get(i));
            }
        }

        Command command = CommandAdapter.getCmd(cmd);
        command.execute(args);
    }

    /**
     * 帮助菜单
     */
    public void showCmdMenu() {
        System.out.println("---------------------todo命令列表--------------------");
        System.out.println("*   1. 添加todo项:       todo add <item>            *");
        System.out.println("*   2. 完成todo项:       todo done <itemIndex>      *");
        System.out.println("*   3. 查看todo列表:      todo list                 *");
        System.out.println("*   4. 查看所有的todo项:   todo list --all           *");
        System.out.println("*   5. 帮助:             help                      *");
        System.out.println("*   6. 清屏:             clear                     *");
        System.out.println("*   7. 退出:             exit                      *");
        System.out.println("-------------------copyright@2021------------------");
        System.out.println();
    }

    /**
     * 命令解析单例内部类
     */
    static class InterpreterHelper {
        private static final CommandInterpreter INSTANCE;

        static {
            INSTANCE = new CommandInterpreter();
        }

        public static CommandInterpreter getInstance() {
            return INSTANCE;
        }
    }

    public static CommandInterpreter getInstance() {
        return InterpreterHelper.getInstance();
    }
}
