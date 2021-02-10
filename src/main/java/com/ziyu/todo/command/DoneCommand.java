package com.ziyu.todo.command;

import com.ziyu.todo.domain.TodoItem;
import com.ziyu.todo.repository.TodoRepository;

import java.util.List;

/**
 * @author ziyu
 */
public class DoneCommand implements Command {

    public boolean execute(List<String> args) {
        int index = Integer.parseInt(args.get(0));

        System.out.println("Item <" + index + "> done.");

        TodoItem item = new TodoItem(index, args.get(1));
        return TodoRepository.updateTodo(item);
    }
}
