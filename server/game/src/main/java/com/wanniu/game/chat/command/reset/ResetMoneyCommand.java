package com.wanniu.game.chat.command.reset;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm reset money"})
public class ResetMoneyCommand
        extends AbsCommand {
    public String help() {
        return "@gm reset money <value> 重置绑定元宝命令";
    }


    protected String exec(WNPlayer player, String... args) {
        Integer value = Integer.valueOf(0);
        if (args.length > 3) {
            value = Integer.valueOf(Integer.parseInt(args[3]));
        }
        int ticket = player.moneyManager.getTicket();
        if (ticket > value.intValue()) {
            player.moneyManager.costTicket(ticket - value.intValue(), Const.GOODS_CHANGE_TYPE.gm);
        } else {
            player.moneyManager.addTicket(value.intValue() - ticket, Const.GOODS_CHANGE_TYPE.gm);
        }
        return "已成功重置" + value + "绑定元宝";
    }
}


