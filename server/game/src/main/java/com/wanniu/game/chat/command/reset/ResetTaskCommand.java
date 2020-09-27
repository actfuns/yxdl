package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset task"})
public class ResetTaskCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset task\t重置今日任务";
    }


    protected String exec(WNPlayer player, String... args) {
        player.taskManager.refreshNewDay();
        return "已成功重置今日任务";
    }
}


