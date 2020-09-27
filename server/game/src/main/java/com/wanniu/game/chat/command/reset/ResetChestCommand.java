package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset chest"})
public class ResetChestCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset chest [value]\t重置宝箱计数命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(0);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }
        player.illusionManager.illusionPO.putBox(1, value.intValue());
        return "已成功重置当前" + value + "宝箱计数";
    }
}


