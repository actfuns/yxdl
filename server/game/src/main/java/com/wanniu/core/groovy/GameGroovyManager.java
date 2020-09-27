package com.wanniu.core.groovy;

import com.wanniu.core.logfs.Out;
import groovy.lang.GroovyClassLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class GameGroovyManager {
    private GameGroovyManager() {
    }

    public String sendGroovyCodeText(String codeText) {
        GroovyClassLoader loader = new GroovyClassLoader(GameGroovyManager.class.getClassLoader());
        Class<?> clz = loader.parseClass(codeText);
        try {
            IGameGroovy object = (IGameGroovy) clz.newInstance();
            return object.execute();
        } catch (Exception e) {
            Out.error(new Object[]{"GameGroovyManager sendGroovyCodeText", e});
            try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                e.printStackTrace(pw);
                return sw.toString();
            } catch (IOException iOException) {
                return "请求助研发人员...";
            }
        }
    }

    private static class GameGroovyManagerHolder {
        public static final GameGroovyManager INSTANCE = new GameGroovyManager();
    }

    public static GameGroovyManager getInstance() {
        return GameGroovyManagerHolder.INSTANCE;
    }
}


