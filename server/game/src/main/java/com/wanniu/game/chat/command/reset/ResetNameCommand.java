package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset name"})
public class ResetNameCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset name <pname>\t 重置角色名字命令";
    }


    protected String exec(WNPlayer player, String... args) {
        return "已成功重置角色名字...";
    }
}


