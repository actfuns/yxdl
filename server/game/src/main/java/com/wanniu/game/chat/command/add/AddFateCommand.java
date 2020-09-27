package com.wanniu.game.chat.command.add;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm add fate"})
public class AddFateCommand
        extends AbsCommand {
    public String help() {
        return "@gm add fate <value>\t添加仙缘值命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(1);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }
        player.moneyManager.addXianYuan(value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
        return "已成功添加" + value + "仙缘";
    }
}


