package com.ziyu.todo.executor.impl;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.constant.TodoState;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.domain.TodoDO;
import com.ziyu.todo.domain.TodoDTO;
import com.ziyu.todo.executor.CmdExecuteResult;
import com.ziyu.todo.executor.CmdExecutor;
import com.ziyu.todo.repository.RepositoryManager;
import com.ziyu.todo.repository.TodoRepository;
import com.ziyu.todo.repository.impl.TodoRepositoryImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 18:53
 */
public class AddCmdExecutor implements CmdExecutor {

    @Override
    public CmdExecuteResult execute(CmdEntity entity) {
        TodoRepository repository = RepositoryManager.getInstance();
        TodoDO todoDO = repository.save(entity.getArgs().get(0));
        TodoDTO todoDTO = new TodoDTO(todoDO.getId(), todoDO.getContent(), TodoState.DONE);

        List<TodoDTO> todoDTOList = new LinkedList<>();
        todoDTOList.add(todoDTO);
        return new CmdExecuteResult(entity.getCmd(), todoDTO.getId(), todoDTOList);
    }

    @Override
    public String getCmdKey() {
        return CmdEnum.ADD.getCmd();
    }
}
