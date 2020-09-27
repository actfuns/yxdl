package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset gold"})
public class ResetGoldCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset gold <value>\t重置银两命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(0);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }

        int gold = player.moneyManager.getGold();
        if (gold > value.intValue()) {
            player.moneyManager.costGold(gold - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
        } else {
            player.moneyManager.addGold(value.intValue() - gold, Const.GOODS_CHANGE_TYPE.gm);
        }
        return "已成功重置到" + value + "银两";
    }
}


