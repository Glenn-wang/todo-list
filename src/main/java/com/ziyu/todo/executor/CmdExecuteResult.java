package com.ziyu.todo.executor;

import com.ziyu.todo.domain.TodoDTO;

import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 18:58
 */
public class CmdExecuteResult {

    private final String cmd;
    private final Integer count;
    private final List<TodoDTO> todoDTOList;

    public CmdExecuteResult(String cmd, Integer count, List<TodoDTO> todoDTOList) {
        this.cmd = cmd;
        this.count = count;
        this.todoDTOList = todoDTOList;
    }

    public Integer getCount() {
        return count;
    }

    public String getCmd() {
        return cmd;
    }

    public List<TodoDTO> getTodoDTOList() {
        return todoDTOList;
    }
}
