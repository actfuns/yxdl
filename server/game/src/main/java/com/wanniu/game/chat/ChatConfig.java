package com.wanniu.game.chat;

import com.wanniu.game.data.ChatSettingCO;
import com.wanniu.game.data.GameData;

public class ChatConfig {
    private static ChatConfig instance;

    public static ChatConfig getInstance() {
        if (instance == null) {
            instance = new ChatConfig();
        }
        return instance;
    }


    public ChatSettingCO getChatSettingProp(int channelId) {
        for (ChatSettingCO setting : GameData.ChatSettings.values()) {
            if (setting.channelID == channelId) {
                return setting;
            }
        }
        return null;
    }
}


