package com.ziyu.todo;

import com.ziyu.todo.constant.CmdEnum;
import com.ziyu.todo.constant.CmdTypeEnum;
import com.ziyu.todo.domain.CmdEntity;
import com.ziyu.todo.executor.CmdExecuteResult;
import com.ziyu.todo.executor.CmdExecutor;
import com.ziyu.todo.executor.CmdExecutorFactory;
import com.ziyu.todo.handler.CmdHandler;
import com.ziyu.todo.view.ViewRenderer;

/**
 * todo应用启动类
 * @author ziyu
 */
public class TodoApp {

    /**
     * 试图渲染器
     */
    private ViewRenderer renderer;
    /**
     * 命令处理器
     */
    private CmdHandler handler;

    private void initialize() {
        renderer = new ViewRenderer();
        handler = new CmdHandler();

        CmdExecutorFactory.init();
    }

    public void run() {
        renderer.welcomeMenu();

        while (true) {
            String input = renderer.inputLabel("ziyu");
            CmdEntity entity = handler.cmdParse(input);

            System.out.println("type=" + entity.getType() +
                    " cmd=" + entity.getCmd() + " args=" + entity.getArgs());

            if (CmdTypeEnum.TODO.getType().equals(entity.getType())) {
                todoCmdExecute(entity);
            } else {
                assistCmdExecute(entity);
            }
        }
    }

    /**
     * 执行todo命令
     */
    private void todoCmdExecute(CmdEntity entity) {
        CmdExecutor executor = CmdExecutorFactory.get(entity.getCmd());
        CmdExecuteResult result = executor.execute(entity);
        renderer.showCmdExecuteResult(result);
    }

    /**
     * 执行辅助命令
     * @param entity 命令信息
     */
    private void assistCmdExecute(CmdEntity entity) {
        if (CmdEnum.EXIT.getCmd().equals(entity.getCmd())) {
            System.exit(0);
        } else if (CmdEnum.HELP.getCmd().equals(entity.getCmd())) {
            renderer.helpMenu();
        } else {
            // 空命令，什么也不执行
        }
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.initialize();
        app.run();
    }
}
