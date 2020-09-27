package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.GConfig;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.redis.Redis;
import com.wanniu.game.GWorld;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@GMEvent
public class BackupRedisHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String redisHost = GConfig.getInstance().get("server.redis.host", "127.0.0.1");
        int redisPort = GConfig.getInstance().getInt("server.redis.port", 6379);
        String pwd = GConfig.getInstance().get("server.redis.password");
        int db = GConfig.getInstance().getInt("server.redis.db", 0);
        Redis redis = new Redis(redisHost, redisPort, 6000000, (pwd != null) ? pwd.trim() : null, db);
        redis.save();
        redis.close();

        makeDir();

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        File source = new File("/data/redis/dump_" + redisPort + ".rdb");
        File dest = new File("/data/backup/temp/dump_" + GWorld.__SERVER_ID + ".rdb." + date);
        try {
            Files.copy(source.toPath(), dest.toPath(), new java.nio.file.CopyOption[0]);
            return (GMResponse) new GMStateResponse(1);
        } catch (IOException e) {
            Out.error(new Object[]{e});
            return (GMResponse) new GMStateResponse(0);
        }
    }

    private void makeDir() {
        File dest = new File("/data/backup/temp/");
        if (!dest.exists()) {
            dest.mkdirs();
        }
    }


    public short getType() {
        return 4;
    }
}


