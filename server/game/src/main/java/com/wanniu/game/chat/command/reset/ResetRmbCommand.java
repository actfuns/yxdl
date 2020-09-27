package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset rmb"})
public class ResetRmbCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset rmb <value>\t重置充值元宝命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(0);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }

        int diamond = player.moneyManager.getDiamond();
        if (diamond > value.intValue()) {
            player.moneyManager.costDiamond(diamond - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
        } else {
            player.moneyManager.addDiamond(value.intValue() - diamond, Const.GOODS_CHANGE_TYPE.gm);
        }
        return "已成功重置" + value + "充值元宝";
    }
}


