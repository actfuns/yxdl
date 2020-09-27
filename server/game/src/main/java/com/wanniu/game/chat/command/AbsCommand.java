package com.wanniu.game.chat.command;

import com.wanniu.game.chat.GMChatUtil;
import com.wanniu.game.player.WNPlayer;


public abstract class AbsCommand
        implements GmCommand {
    public GMChatUtil.GMChatResult call(WNPlayer player, String... args) {
        if (args.length > 3 && ("?".equals(args[3]) || "help".equalsIgnoreCase(args[3]))) {
            return new GMChatUtil.GMChatResult(true, help());
        }
        String result = null;
        try {
            result = exec(player, args);
        } catch (Exception e) {
            result = help() + "执行时发生了异常情况\n异常信息：" + e.getMessage() + "\n";
        }
        return new GMChatUtil.GMChatResult(true, result);
    }

    protected String exec(WNPlayer player, String... args) {
        return help();
    }
}


