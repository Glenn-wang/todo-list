package com.ziyu.todo.executor.impl;

import com.ziyu.todo.constant.TodoState;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.domain.TodoDO;
import com.ziyu.todo.domain.TodoDTO;
import com.ziyu.todo.executor.CmdExecuteResult;
import com.ziyu.todo.executor.CmdExecutor;
import com.ziyu.todo.repository.RepositoryManager;
import com.ziyu.todo.repository.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ziyu
 * @date 2021/2/10 21:52
 */
public class ListCmdExecutor implements CmdExecutor {

    @Override
    public CmdExecuteResult execute(CmdEntity entity) {
        TodoRepository repository = RepositoryManager.getInstance();
        List<TodoDO> todoDOList = repository.list();

        List<TodoDTO> todoDTOList = todoDOList.stream()
                .map(this::createTodoDTO)
                .collect(Collectors.toList());
         CmdExecuteResult result = new CmdExecuteResult(
                 entity.getCmd(), todoDOList.size(), todoDTOList);

        return result;
    }

    @Override
    public String getCmdKey() {
        return null;
    }

    private TodoDTO createTodoDTO(TodoDO todoDO) {
        return new TodoDTO(todoDO.getId(), todoDO.getContent(), TodoState.DONE);
    }
}
