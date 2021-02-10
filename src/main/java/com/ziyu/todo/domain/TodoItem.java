package com.ziyu.todo.domain;

/**
 * @author ziyu
 */
public class TodoItem {

    private final Integer index;
    private final String content;

    public TodoItem(Integer index, String content) {
        this.index = index;
        this.content = content;
    }

    public Integer getIndex() {
        return index;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "content='" + content + '\'' +
                '}';
    }
}
