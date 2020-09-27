package com.wanniu.game.chat.command.add;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.auction.AuctionService;
import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.List;


@Command({"@gm add auction"})
public class AddAuctionCommand
        extends AbsCommand {
    public String help() {
        return "@gm add auction \t添加竞拍物品命令";
    }


    protected String exec(WNPlayer player, String... args) {
        List<NormalItem> items = new ArrayList<>();
        items.addAll(ItemUtil.createItemsByItemCode("pet3003-p", 1));
        AuctionService.getInstance().addAuctionItem(items, player.guildManager.getGuildId(), "GM命令");
        if (StringUtil.isEmpty(player.guildManager.getGuildId())) {
            AuctionService.getInstance().processWorldAuctionsPoint();
        } else {
            AuctionService.getInstance().processGuildAuctionsPoint(player.guildManager.getGuildId());
        }
        return "";
    }
}


