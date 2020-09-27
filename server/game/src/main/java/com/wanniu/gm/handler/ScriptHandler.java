package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.logfs.Level;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.util.RobotUtil;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;

@GMEvent
public class ScriptHandler extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String[] pros;
        int proes[], i;
        String[] cmd = arr.getString(0).split(" ");
        switch (cmd[0]) {
            case "debug":
                GWorld.DEBUG = Boolean.parseBoolean(cmd[1]);
                break;

            case "robot":
                GWorld.ROBOT = Boolean.parseBoolean(cmd[1]);
                break;

            case "robot_level":
                GWorld.ROBOT_MAX_LEVEL = Integer.parseInt(cmd[1]);
                break;

            case "monitor":
                GWorld.MONITOR = Boolean.parseBoolean(cmd[1]);
                break;

            case "robots":
                GWorld.ROBOTS = Boolean.parseBoolean(cmd[1]);
                break;

            case "out":
                Out.setLevel(Level.valueOf(cmd[1].toUpperCase()));
                break;

            case "pros":
                pros = cmd[1].split(",");
                proes = new int[pros.length];
                for (i = 0; i < proes.length; i++) {
                    proes[i] = Integer.valueOf(pros[i]).intValue();
                }
                RobotUtil.PROS = proes;
                break;
        }

        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 4556;
    }
}


