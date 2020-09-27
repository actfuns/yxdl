package com.wanniu.game.chat.command.open;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm open 月卡", "@gm open 尊享卡"})
public class OpenCardCommand
        extends AbsCommand {
    public String help() {
        return "@gm open [月卡|尊享卡]\t开启月卡功能";
    }


    protected String exec(WNPlayer player, String... args) {
        String type = args[2];
        player.prepaidManager.onChargeCardByOpen(type);
        return type + " 已开通...";
    }
}


