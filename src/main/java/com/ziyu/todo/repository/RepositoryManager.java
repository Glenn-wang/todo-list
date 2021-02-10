package com.ziyu.todo.repository;

import com.ziyu.todo.repository.impl.TodoRepositoryImpl;

/**
 * @author ziyu
 * @date 2021/2/10 21:54
 */
public class RepositoryManager {

    static class Singleton {

        private static final TodoRepository INSTANCE;

        static {
            INSTANCE = new TodoRepositoryImpl();
        }

        public static TodoRepository getInstance() {
            return Singleton.INSTANCE;
        }
    }

    public static TodoRepository getInstance() {
        return Singleton.getInstance();
    }


}
