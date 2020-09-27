package com.wanniu.game.chat.command.add;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm add level"})
public class AddLevelCommand
        extends AbsCommand {
    public String help() {
        return "@gm add level <value>\t添加等级命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(1);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }
        player.baseDataManager.upgrade(Math.min(GlobalConfig.Role_LevelLimit, player.getLevel() + value.intValue()), 0L);
        return "升级成功";
    }
}


