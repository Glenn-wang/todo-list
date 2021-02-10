package com.ziyu.todo.repository.impl;

import com.ziyu.todo.constant.TodoState;
import com.ziyu.todo.domain.TodoDO;
import com.ziyu.todo.repository.TodoRepository;
import org.apache.commons.lang.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ziyu
 */
public class TodoRepositoryImpl implements TodoRepository {

    /**
     * 第一阶段，存储内存中
     */
    private static final Map<Integer, TodoDO> todoMap = new HashMap<>();

    @Override
    public TodoDO save(String content) {
        int count = todoMap.size();
        TodoDO todoDO = createTodoDO(++count, content);
        todoMap.put(todoDO.getId(), todoDO);

        return todoDO;
    }

    @Override
    public TodoDO done(Integer index) {
        TodoDO todoDO = todoMap.get(index);
        todoDO.setStatus(TodoState.DONE);
        todoMap.put(index, todoDO);

        return todoDO;
    }

    @Override
    public List<TodoDO> list() {
        return todoMap.values().stream()
                .filter(t -> ObjectUtils.equals(t.getStatus(), TodoState.TODO))
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDO> listAll() {
        return new ArrayList<>(todoMap.values());
    }

    public TodoDO createTodoDO(int index, String content) {
        TodoDO todoDO = new TodoDO();
        todoDO.setId(index);
        todoDO.setContent(content);
        todoDO.setStatus(TodoState.TODO);
        todoDO.setCreatedAt(new Date());
        todoDO.setUpdatedAt(new Date());
        return todoDO;
    }
}
