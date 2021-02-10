package com.ziyu.todo.executor.impl;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.domain.TodoDO;
import com.ziyu.todo.domain.TodoDTO;
import com.ziyu.todo.executor.CmdExecuteResult;
import com.ziyu.todo.executor.CmdExecutor;
import com.ziyu.todo.repository.RepositoryManager;
import com.ziyu.todo.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyu
 * @date 2021/2/10 22:25
 */
public class DoneCmdExecutor implements CmdExecutor {

    @Override
    public CmdExecuteResult execute(CmdEntity entity) {
        TodoRepository repository = RepositoryManager.getInstance();
        String indexStr = entity.getArgs().get(0);
        TodoDO todoDO = repository.done(Integer.parseInt(indexStr));
        TodoDTO todoDTO = new TodoDTO(todoDO.getId(), todoDO.getContent(), todoDO.getStatus());

        List<TodoDTO> todoDTOList = new ArrayList<>();
        todoDTOList.add(todoDTO);
        return new CmdExecuteResult(entity.getCmd(), todoDTO.getId(), todoDTOList);
    }

    @Override
    public String getCmdKey() {
        return CmdEnum.DONE.getCmd();
    }
}
