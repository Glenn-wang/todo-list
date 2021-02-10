package com.ziyu.todo.repository;

import com.ziyu.todo.domain.TodoDO;

import java.util.List;

/**
 * @author ziyu
 */
public interface TodoRepository {

    /**
     * 存储一条todo
     * @param content todo信息
     * @return 处理结果
     */
    TodoDO save(String content);

    /**
     * 完成一条todo
     * @param index 索引
     * @return 处理结果
     */
    TodoDO done(Integer index);

    /**
     * 查询待办的todo
     * @return 查询结果
     */
    List<TodoDO> list();

    /**
     * 查询所有todo
     * @return 查询结果
     */
    List<TodoDO> listAll();
}
