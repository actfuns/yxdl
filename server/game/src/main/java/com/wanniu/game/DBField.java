package com.wanniu.game;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DBField {
    boolean include() default true;

    boolean isPKey() default false;

    String fieldType() default "";

    int size() default 0;

    String comment() default "";
}


