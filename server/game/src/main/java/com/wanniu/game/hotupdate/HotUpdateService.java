package com.wanniu.game.hotupdate;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.UnmodifiableClassException;


public class HotUpdateService {
    public static String changeClass(String className, byte[] classBt) {
        try {
            Class<?> cls = Class.forName(className);
            if (JavaAgent.INST == null) {
                return "启动命令行没有写上正确的格式:java -javaagent:agent.jar -jar xx.jar,或者没有找到agent.jar";
            }
            JavaAgent.INST.redefineClasses(new ClassDefinition[]{new ClassDefinition(cls, classBt)});
        } catch (ClassNotFoundException e) {
            return "请写上完整的类名.例如com.wanniu.game.hotupdate.HotUpdateService";
        } catch (UnmodifiableClassException e) {
            return "热更的时候发生未知错误,请检查:" + e.getMessage();
        }
        return "OK";
    }
}


