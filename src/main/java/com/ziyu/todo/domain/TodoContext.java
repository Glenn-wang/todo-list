package com.ziyu.todo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyu
 */
public class TodoContext {

    private Map<Integer, TodoItem> itemList;

    public TodoContext() {
        this.itemList = new HashMap<Integer, TodoItem>();
    }

    public Map<Integer, TodoItem> getItemList() {
        return itemList;
    }

    public void setItemList(Map<Integer, TodoItem> itemList) {
        this.itemList = itemList;
    }
}
