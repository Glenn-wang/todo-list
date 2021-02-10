package com.ziyu.todo.repository;

import com.ziyu.todo.domain.TodoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu
 */
public class TodoRepository {

    private static final Map<Integer, TodoItem> itemMap = new HashMap<Integer, TodoItem>();

    static class Helper {
        private static final TodoRepository INSTANCE;

        static {
            INSTANCE = new TodoRepository();
        }
    }

    public TodoRepository getInstance() {
        return Helper.INSTANCE;
    }

    public static boolean addTodo(TodoItem item) {
        itemMap.put(item.getIndex(), item);
        return true;
    }

    public static boolean updateTodo(TodoItem newItem) {
        TodoItem oldItem = itemMap.get(newItem.getIndex());
        oldItem.setContent(newItem.getContent());
        return true;
    }

    public static List<TodoItem> list() {
        return new ArrayList<TodoItem>(itemMap.values());
    }

    public static Integer size() {
        return itemMap.size();
    }
}
