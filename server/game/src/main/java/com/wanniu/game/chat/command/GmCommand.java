package com.wanniu.game.chat.command;

import com.wanniu.game.chat.GMChatUtil;
import com.wanniu.game.player.WNPlayer;

public interface GmCommand {
    String help();

    GMChatUtil.GMChatResult call(WNPlayer paramWNPlayer, String... paramVarArgs);
}


