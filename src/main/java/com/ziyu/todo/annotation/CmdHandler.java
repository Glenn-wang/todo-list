package com.ziyu.todo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ziyu
 * @date 2021/2/10 16:46
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface CmdHandler {

    String value();
}
