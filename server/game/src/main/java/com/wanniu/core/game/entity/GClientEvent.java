package com.wanniu.core.game.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface GClientEvent {
  String value();
  
  short type() default 0;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\entity\GClientEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */