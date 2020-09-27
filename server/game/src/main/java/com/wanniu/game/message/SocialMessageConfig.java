package com.wanniu.game.message;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SocialMessageCO;

import java.util.ArrayList;

public class SocialMessageConfig {
    private static SocialMessageConfig instance;
    private ArrayList<SocialMessageCO> listMessage;

    public static SocialMessageConfig getInstance() {
        if (instance == null) {
            instance = new SocialMessageConfig();
        }
        return instance;
    }


    private SocialMessageConfig() {
        this.listMessage = new ArrayList<>();
        for (SocialMessageCO data : GameData.SocialMessages.values())
            this.listMessage.add(data);
    }

    public final SocialMessageCO findMessageById(int id) {
        for (SocialMessageCO data : this.listMessage) {
            if (data.iD == id) {
                return data;
            }
        }
        return null;
    }

    public final SocialMessageCO findMessageByMessageType(int type) {
        for (SocialMessageCO data : this.listMessage) {
            if (data.messageType == type) {
                return data;
            }
        }
        return null;
    }
}


