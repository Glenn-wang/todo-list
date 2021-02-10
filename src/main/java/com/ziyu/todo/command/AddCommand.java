package com.ziyu.todo.command;

import com.ziyu.todo.domain.TodoItem;
import com.ziyu.todo.repository.TodoRepository;

import java.util.List;

/**
 * @author ziyu
 */
public class AddCommand implements Command {

    public boolean execute(List<String> args) {
        int count = TodoRepository.size();

        System.out.println("Item <" + ++count + "> added.");

        TodoItem item = new TodoItem(count, args.get(0));
        return TodoRepository.addTodo(item);
    }
}
