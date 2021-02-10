package com.ziyu.todo.view;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.constant.TodoState;
import com.ziyu.todo.domain.TodoDTO;
import com.ziyu.todo.executor.CmdExecuteResult;

import java.util.List;
import java.util.Scanner;

/**
 * @author ziyu
 * @date 2021/2/10 16:52
 */
public class ViewRenderer {

    private static final Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public void welcomeMenu() {
        System.out.println();
        System.out.println("---------- todo list v0.1 ----------");
        System.out.println();
        System.out.println();
        System.out.println("------ Copyright 2021 by ziyu ------");
        System.out.println();
    }

    public String inputLabel(String user) {
        System.out.print("[" + "todo@" + user + " ~]# ");
        return sc.nextLine();
    }

    public void helpMenu() {
        System.out.println("帮助菜单！！！");
    }

    public void showCmdExecuteResult(CmdExecuteResult result) {
        if (CmdEnum.ADD.getCmd().equals(result.getCmd())) {
            System.out.println("Item <" + result.getCount() + "> added");
        } else if (CmdEnum.LIST.getCmd().equals(result.getCmd())) {
            List<TodoDTO> todoDTOList = result.getTodoDTOList();
            for (TodoDTO todoDTO : todoDTOList) {
                System.out.println(todoDTO.getId() + ". <" + todoDTO.getContent() + ">");
            }

            System.out.println("Total: " + result.getTodoDTOList().size() + " items");
        } else if (CmdEnum.DONE.getCmd().equals(result.getCmd())) {
            System.out.println("Item <" + result.getCount() + "> done.");
        } else if (CmdEnum.LIST_ALL.getCmd().equals(result.getCmd())) {
            List<TodoDTO> todoDTOList = result.getTodoDTOList();
            int doneCount = 0;
            for (TodoDTO todoDTO : todoDTOList) {
                if (TodoState.DONE.equals(todoDTO.getStatus())) {
                    doneCount++;
                    System.out.println(todoDTO.getId() + ". [Done] <" + todoDTO.getContent() + ">");
                } else {
                    System.out.println(todoDTO.getId() + ". <" + todoDTO.getContent() + ">");
                }
            }

            System.out.println("Total: " + result.getTodoDTOList().size() + " items, " + doneCount + " item done");
        }
    }
}
