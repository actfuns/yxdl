package com.wanniu.game.chat.command;

import com.wanniu.game.chat.GMChatUtil;
import com.wanniu.game.player.WNPlayer;

public interface GmCommand {
  String help();
  
  GMChatUtil.GMChatResult call(WNPlayer paramWNPlayer, String... paramVarArgs);
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\chat\command\GmCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */