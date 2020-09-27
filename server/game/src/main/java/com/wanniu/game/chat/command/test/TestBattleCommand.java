package com.wanniu.game.chat.command.test;

import com.wanniu.csharp.CSharpClient;
import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm test battle"})
public class TestBattleCommand
        extends AbsCommand {
    public String help() {
        return "@gm test battle\t 测试断开战斗服命令";
    }


    protected String exec(WNPlayer player, String... args) {
        CSharpClient.getInstance().gmTestClose();
        return "";
    }
}


