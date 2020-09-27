package com.wanniu.game.guild;

import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guildTech.GuildTechData;
import com.wanniu.game.item.po.PlayerItemPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.GuildHandler;
import pomelo.item.ItemOuterClass;


public class GuildResult {
    public int result;
    public String des;
    public GuildResultData data;
    public String id;
    public boolean joined;
    public String memberId;
    public ItemOuterClass.Grid bagGrid;
    public String name;
    public int leftKickNum;
    public int needLevel;
    public int isNew;
    public PlayerItemPO itemData;
    public int deleteCount;
    public int addReadFund;
    public int addRealExp;
    public GuildDepotCondition newCondition;
    public GuildTechData techData;
    public int depositCount;
    public ArrayList<Integer> goods;
    public String newNotice;
    public int state;
    public String cdInfo;

    public static abstract class GuildResultData {
    }

    public static class UpgradeGuildLvData
            extends GuildResultData {
        public int preLevel;
        public long preExp;
        public long exp;
        public int level;
        public int costExp;
    }

    public static class TransferGuildPresidentData
            extends GuildResultData {
        public String preId = "";
        public String preName = "";
        public String nowId = "";
        public String nowName = "";

        public int newJob;
    }


    public static class DepotUpgradeLevelData
            extends GuildResultData {
        public int costGoldNum;

        public int newLevel;

        public long fund;
        public String nowName = "";
        public String id = "";
        public String name = "";


        public int preLevel;
    }


    public static class PlayerOnlineRefreshGuild
            extends GuildResultData {
        public int isInGuild;

        public ArrayList<Integer> goods = new ArrayList<>();
        public GuildTechData techData = new GuildTechData();
        public Date refreshTime = new Date(0L);
        public int[] finishStateArr = new int[3];


        public int throwAwardState;
    }


    public static class GuildBlessActionData
            extends GuildResultData {
        public int[] finishState = new int[3];
        public List<Integer> receiveState = new ArrayList<>();
        public List<Integer> buffIds = new ArrayList<>();
        public int blessValue;
        public int id;
        public int finishNum;
        public int buffTime;
        public int blessCount;
    }

    public static class GuildGiftAndBuffData
            extends GuildResultData {
        public Map<String, Integer> itemCode = new HashMap<>();
        public ArrayList<Integer> buffIds = new ArrayList<>();
        public List<Integer> receiveState = new ArrayList<>();
    }


    public static class UpgradeLevel
            extends GuildResultData {
        public int level;

        public int needGold;

        public long fund;

        public String id = "";
        public String name = "";
        public int preLevel;
        public int buffLevel;
    }

    public static class JoinGuild
            extends GuildResultData {
        public int needUpLevel;
        public int needLevel;
        public String cdInfo = "";
    }


    public static class MyGuildMember
            extends GuildResultData {
        public int leftKickNum;

        public List<GuildHandler.MemberInfo> list = new ArrayList<>();
    }

    public static class GuildExchangeGoods extends GuildResultData {
        public int id;
        public int state;
        public int moneyType;
        public int condType;
    }
}


