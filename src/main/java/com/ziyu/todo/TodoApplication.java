package com.ziyu.todo;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.interpreter.CommandInterpreter;

import java.util.Scanner;

/**
 * @author ziyu
 */
public class TodoApplication {

    /**
     * run方法
     * @param user 登录用户
     */
    public static void run(String user) {
        Scanner sc = new Scanner(System.in);

        CommandInterpreter cmdInterpreter = CommandInterpreter.getInstance();
        cmdInterpreter.showCmdMenu();

        while (true) {
            System.out.print("["+ user +"&todo-list]>> ");
            String input = sc.nextLine();

            if (CmdEnum.HELP.getCmd().equals(input)) {
                cmdInterpreter.showCmdMenu();
            } else if (CmdEnum.EXIT.getCmd().equals(input)) {
                System.out.println("todo-list 退出！");
                System.exit(0);
            } else {
                cmdInterpreter.interpreter(input);
            }
        }
    }

    public static void main(String[] args) {
        run("root");
    }
}
