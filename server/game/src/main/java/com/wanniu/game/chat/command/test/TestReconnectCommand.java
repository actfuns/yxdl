package com.wanniu.game.chat.command.test;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm test reconnect"})
public class TestReconnectCommand
        extends AbsCommand {
    public String help() {
        return "@gm test reconnect\t测试重连命令";
    }


    protected String exec(WNPlayer player, String... args) {
        player.getSession().close();
        return "";
    }
}


