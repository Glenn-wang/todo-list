package com.ziyu.todo.domain;

/**
 * @author ziyu
 * @date 2021/2/10 15:52
 */
public class TodoDTO {
    /**
     * id
     */
    private final Integer id;
    /**
     * 内容
     */
    private final String content;
    /**
     * 状态, 0 - 待办；1 - 已完成
     */
    private final Integer status;

    public TodoDTO(Integer id, String content, Integer status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
