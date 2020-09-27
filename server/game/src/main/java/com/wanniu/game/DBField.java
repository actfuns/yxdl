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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\DBField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */