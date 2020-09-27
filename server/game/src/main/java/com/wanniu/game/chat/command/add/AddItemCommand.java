package com.wanniu.game.chat.command.add;

import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm add item"})
public class AddItemCommand
        extends AbsCommand {
    public String help() {
        return "@gm add item <code> [num]\t添加道具命令";
    }


    protected String exec(WNPlayer player, String... args) {
        String itemCode = args[3];
        Integer value = Integer.valueOf(1);
        if (args.length > 4) {
            value = Integer.valueOf(Integer.parseInt(args[4]));
        }


        if (ItemConfig.getInstance().getItemProp(itemCode) == null) {
            DItemEquipBase t = ItemConfig.getInstance().getItemPropByName(itemCode);
            if (t == null) {
                return "你输入的道具编号【" + itemCode + "】不存在";
            }
            itemCode = t.code;
        }


        if (!player.bag.testAddCodeItem(itemCode, value.intValue())) {
            return "您的背包装不下啊...";
        }

        player.bag.addCodeItem(itemCode, value.intValue(), Const.ForceType.UN_BIND, Const.GOODS_CHANGE_TYPE.gm);
        return "OK";
    }
}


