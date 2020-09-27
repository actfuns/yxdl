package com.wanniu.game.hotupdate;

import java.lang.instrument.Instrumentation;


public class JavaAgent {
    public static Instrumentation INST = null;

    public static void premain(String agentArgs, Instrumentation inst) {
        INST = inst;
    }
}


