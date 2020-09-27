package com.wanniu.game;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.GConfig;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ParamMain {
    public static final String START = "//================================ParamMain auto generate start================================//";
    public static final String END = "//================================ParamMain auto generate end================================//";

    public static void main(String[] args) {
        GConfig.getInstance().init(false);
        Out.setting();

        File parameters = new File(GConfig.getInstance().get("dir.game.data") + "/config/GameConfig/Parameters.json");
        JSONArray doc = JSONArray.parseArray(FileUtil.readText(parameters));
        StringBuilder builder = new StringBuilder("//================================ParamMain auto generate start================================//");
        for (int i = 3; i < doc.size(); i++) {
            JSONArray values = (JSONArray) doc.get(i);
            String type = values.getString(1);
            builder.append("\n\tpublic static ").append("NUMBER".equals(type) ? "int " : ("FLOAT".equals(type) ? "float " : "String ")).append(values.get(0).toString().replace(".", "_")).append(";");
        }

        builder.append("\n//================================ParamMain auto generate end================================//");

        File globalFile = new File("src/main/java/com/wanniu/game/player/GlobalConfig.java");
        System.out.println(globalFile.getAbsolutePath());
        StringBuilder globalContent = new StringBuilder(FileUtil.readText(globalFile));
        int start = globalContent.indexOf("//================================ParamMain auto generate start================================//");
        int end = globalContent.indexOf("//================================ParamMain auto generate end================================//") + "//================================ParamMain auto generate end================================//".length();
        globalContent.replace(start, end, builder.toString());
        System.out.println(globalContent.toString());
        try {
            FileWriter newGlobalFile = new FileWriter(globalFile);
            newGlobalFile.write(globalContent.toString());
            newGlobalFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


