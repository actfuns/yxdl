package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset recovery"})
public class ResetRecoveryCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset recovery [day]\t重置资源找回命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer day = Integer.valueOf(1);
        if (args.length > 3) {
            day = Integer.valueOf(Math.min(Integer.parseInt(args[3]), 3));
        }
        player.activityManager.gmRecovered(day.intValue());
        return "资源找回已修正到" + day + "天前...";
    }
}


