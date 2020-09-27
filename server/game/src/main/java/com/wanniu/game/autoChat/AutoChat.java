package com.wanniu.game.autoChat;

import com.wanniu.core.game.protocol.PomeloPush;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.GWorld;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pomelo.chat.ChatHandler;


public class AutoChat
        extends Thread {
    private static AutoChat autoChat;
    private int serverId;

    public static AutoChat getInstance() {
        if (autoChat != null) {
            return autoChat;
        }
        autoChat = new AutoChat();
        return autoChat;
    }

    public void init(int serverId) {
        this.serverId = serverId;
        start();
    }


    public void run() {
        String playerId = "-1";
        int scope = 1;
        String uid = "-1";
        String[] textArr = {""};
        String[] nameArr = {"樱娆,1,34", "绾颜,3,31", "旖旎,5,37", "挽衾,1,25", "書生,3,21", "謫仙,5,20", "茗蜃,1,31", "墨渊惊鸿戚,3,23", "素绣绵绵忆,1,24", "絮锦岁岁梦,3,20"};
        String baseMsg = "|<q {\"index\":}></q>|";
        while (true) {
            String[] nameSplit = nameArr[(int) (Math.random() * nameArr.length)].split(",");
            String serverData = "{\"acceptRoleId\":\"\",\"s2c_level\":" + nameSplit[2] + ",\"s2c_isAtAll\":0,\"s2c_titleMsg\":\"\",\"s2c_name\":\"" + nameSplit[0] + "\",\"s2c_pro\":" + nameSplit[1] + ",\"s2c_vip\":2,\"s2c_zoneId\":" + this.serverId + ",\"s2c_color\":3723689983}";
            final ChatHandler.OnChatPush.Builder push = ChatHandler.OnChatPush.newBuilder();
            push.setS2CContent(getMsg());
            push.setS2CPlayerId(playerId);
            push.setS2CServerData(serverData);
            push.setS2CScope(scope);
            push.setS2CUid(uid);
            push.setS2CTime(getNowDate());
            push.setS2CIndex(0);
            push.setS2CSys(0);


            PomeloPush chatPush = new PomeloPush() {
                protected void write() throws IOException {
                    this.body.writeBytes(push.build().toByteArray());
                }


                public String getRoute() {
                    return "chat.chatPush.onChatPush";
                }
            };
            GWorld.getInstance().broadcast((Message) chatPush, this.serverId);
            try {
                Thread.sleep(((int) (300.0D + Math.random() * 301.0D) * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }

    public String getMsg() {
        String baseMsg = "|<q {\"index\":" + (int) (0.0D + Math.random() * 48.0D) + "}></q>|";
        StringBuffer base = new StringBuffer(baseMsg);
        int num = (int) (1.0D + Math.random() * 3.0D);
        for (int i = 1; i < num; i++) {
            base.append(baseMsg);
        }
        return base.toString();
    }
}


