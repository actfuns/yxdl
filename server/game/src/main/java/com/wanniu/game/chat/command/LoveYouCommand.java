package com.wanniu.game.chat.command;

import com.wanniu.game.chat.GMChatUtil;
import com.wanniu.game.player.WNPlayer;


@Command({"@gm love you"})
public class LoveYouCommand
        extends AbsCommand {
    public String help() {
        return "@gm love you 嘿嘿，你懂的...";
    }


    protected String exec(WNPlayer player, String... args) {
        player.baseDataManager.upgrade(60, 0L);


        GMChatUtil.checkContent(player, "@gm add rmb 88888888");

        GMChatUtil.checkContent(player, "@gm add money 88888888");

        GMChatUtil.checkContent(player, "@gm add gold 88888888");

        GMChatUtil.checkContent(player, "@gm openFunc");

        GMChatUtil.checkContent(player, "@gm add gr10 10");

        GMChatUtil.checkContent(player, "@gm add gg10 10");

        GMChatUtil.checkContent(player, "@gm add gb10 10");

        GMChatUtil.checkContent(player, "@gm add gp10 10");

        GMChatUtil.checkContent(player, "@gm add gy10 10");


        GMChatUtil.checkContent(player, "@gm add 无敌屠龙刀 1");
        GMChatUtil.checkContent(player, "@gm add 伪原始圣甲 1");


        return "爱我就对了...";
    }
}


