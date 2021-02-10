package com.ziyu.todo.command;

import com.ziyu.todo.domain.TodoItem;
import com.ziyu.todo.repository.TodoRepository;

import java.util.List;

/**
 * @author ziyu
 */
public class ListCommand implements Command {

    public boolean execute(List<String> args) {
        List<TodoItem> list = TodoRepository.list();

        for (TodoItem todoItem : list) {
            System.out.println(todoItem.getIndex() + ". " + todoItem.getContent());
        }

        System.out.println("Total: " + list.size() + " items");

        return true;
    }
}
