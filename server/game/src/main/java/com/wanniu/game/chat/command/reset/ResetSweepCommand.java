package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset sweep"})
public class ResetSweepCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset sweep \t重置扫荡次数命令";
    }


    protected String exec(WNPlayer player, String... args) {
        player.demonTowerManager.UpdateSweepCount();
        return "已成功重置扫荡次数";
    }
}


