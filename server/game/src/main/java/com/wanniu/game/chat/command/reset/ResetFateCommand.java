package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset fate"})
public class ResetFateCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset fate <value>\t重置仙缘命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(0);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }

        int xianyuan = player.moneyManager.getXianYuan();
        if (xianyuan > value.intValue()) {
            player.moneyManager.costXianYuan(xianyuan - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
        } else {
            player.moneyManager.addXianYuan(value.intValue() - xianyuan, Const.GOODS_CHANGE_TYPE.gm);
        }
        return "已成功重置" + value + "仙缘";
    }
}


