package com.wanniu.game.guild;

import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guildTech.GuildTechData;
import com.wanniu.game.guild.po.GuildBlessPO;

import java.util.ArrayList;

import pomelo.area.GuildDepotHandler;
import pomelo.area.GuildHandler;


public class GuildMsg {
    public int notifyType;
    public GuildMsgData data;

    public GuildMsg(int notifyType, GuildMsgData data) {
        this.notifyType = notifyType;
        this.data = data;
    }


    public static abstract class GuildMsgData {
    }


    public static class RefreshGuildMsg
            extends GuildMsgData {
        public int isIn;

        public int isOut;

        public int job;

        public String jobName = "";
        public String guildName = "";
        public ArrayList<GuildHandler.ContributeTimesInfo> timesList = new ArrayList<>();
    }


    public static class JoinGuildBlessMsg
            extends RefreshGuildMsg {
        public GuildBlessPO blessData = new GuildBlessPO();
    }


    public static class DepotRefreshGuildMsg
            extends GuildMsgData {
        public int type;

        public int bagIndex;

        public GuildDepotHandler.DepotLevelInfo levelInfo = GuildDepotHandler.DepotLevelInfo.newBuilder().build();
        public GuildDepotCondition condition = new GuildDepotCondition();
    }


    public static class BlessRefreshGuildMsg
            extends GuildMsgData {
        public int type;

        public int blessValue;
        public int[] finishStateArr = new int[3];
    }


    public static class ShopRefreshGuildMsg
            extends GuildMsgData {
    }


    public static class TechRefreshGuildMsg
            extends GuildMsgData {
        public GuildTechData techData = new GuildTechData();
    }

    public static class DungeonPassGuildMsg extends GuildMsgData {
        public int dungeonCount;
    }

    public static class DungeonPlayerNumGuildMsg extends GuildMsgData {
        public int playerNum;
    }

    public static class OnChatGuildMsg extends GuildMsgData {
        public String playerId;
    }
}


