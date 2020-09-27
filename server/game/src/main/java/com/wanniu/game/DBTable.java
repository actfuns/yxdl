package com.wanniu.game;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DBTable {
  String value() default "";
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\DBTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */