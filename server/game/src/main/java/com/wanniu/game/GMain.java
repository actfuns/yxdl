package com.wanniu.game;

import com.wanniu.core.GConfig;
import com.wanniu.core.GSystem;
import com.wanniu.core.game.GServerBootstrap;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DataUtil;
import com.wanniu.game.achievement.AchievementServiceNew;
import com.wanniu.game.activity.DemonTowerService;
import com.wanniu.game.arena.ArenaService;
import com.wanniu.game.auction.AuctionDataManager;
import com.wanniu.game.autoChat.AutoChat;
import com.wanniu.game.autoChat.ClearChatLog;
import com.wanniu.game.chat.GmCommandManager;
import com.wanniu.game.common.ScheduleManager;
import com.wanniu.game.consignmentShop.ConsignmentLineService;
import com.wanniu.game.daoyou.DaoYouCenter;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ServerConfigCO;
import com.wanniu.game.fightLevel.DungeonService;
import com.wanniu.game.five2Five.Five2FiveService;
import com.wanniu.game.flee.FleeService;
import com.wanniu.game.friend.FriendsCenter;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.guidDepot.GuildDepotCenter;
import com.wanniu.game.guild.guildBless.GuildBlessCenter;
import com.wanniu.game.guild.guildBoss.GuildBossService;
import com.wanniu.game.guild.guildFort.GuildFortCenter;
import com.wanniu.game.guild.guildFort.GuildFortService;
import com.wanniu.game.guild.guildImpeach.GuildImpeachCenter;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PathService;
import com.wanniu.game.rank.RankCenter;
import com.wanniu.game.recent.RecentChatCenter;
import com.wanniu.game.redpacket.RedPacketService;
import com.wanniu.game.shopMall.ShopMallService;
import com.wanniu.game.solo.SoloService;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;


public class GMain {
    private static int TableCount = 0;

    public static void main(String[] args) {
        GConfig.getInstance().init(false);
        if (args.length > 0) {
            String ip = args[0].trim();
            GConfig.getInstance().put("game.pubhost", ip);
            if (!GConfig.getInstance().exists("game.id")) {
                String gameId = ip.substring(ip.lastIndexOf(".") + 1);
                GConfig.getInstance().put("game.id", gameId);
            }
            GWorld.__SERVER_ID = GConfig.getInstance().getGameID();
            Out.info(new Object[]{ip, " game id : ", Integer.valueOf(GWorld.__SERVER_ID)});
        }

        Out.info(new Object[]{Boolean.valueOf(GWorld.DEBUG)});

        if (GWorld.DEBUG && GSystem.OS_NAME.startsWith("WINDOWS")) {
            Out.info(new Object[]{Integer.valueOf(111)});
            (new Thread(() -> {
                try {
                    System.in.read();
                } catch (IOException e) {
                    Out.error(new Object[]{e}, );
                }
                System.exit(0);
            }"安全停服：测试启用")).start();
        }


        initData();

        GWorld.getInstance().start();


        ScheduleManager.getInstance();


        PathService.getInstance();

        DungeonService.getInstance();

        ConsignmentLineService.getInstance();

        AuctionDataManager.getInstance();

        MailCenter.getInstance().loadServerMails();

        FriendsCenter.getInstance();

        RecentChatCenter.getInstance();

        GuildServiceCenter.getInstance().init();
        GuildImpeachCenter.getInstance();
        GuildDepotCenter.getInstance();
        GuildBlessCenter.getInstance();

        DaoYouService.getInstance();
        DaoYouCenter.getInstance();

        ArenaService.getInstance();

        SoloService.getInstance();

        Five2FiveService.getInstance();
        FleeService.getInstance();

        AchievementServiceNew.getInstance();

        ShopMallService.getInstance();

        RankCenter.getInstance().init();

        GuildBossService.getInstance().init();
        GmCommandManager.init();

        GuildFortService.getInstance();
        GuildFortCenter.getInstance();

        RedPacketService.getInstance().init();

        DemonTowerService.getInstance().init();

        AutoChat.getInstance().init(GWorld.__SERVER_ID);

        ClearChatLog.getInstance().init();


        GServerBootstrap.getInstance().start();
        GSystem.free();
        Out.info(new Object[]{"SID-> ", Integer.valueOf(GWorld.__SERVER_ID), "    ENV -> ", GWorld.__SERVER_LANG, "    DEBUG -> ", Boolean.valueOf(GWorld.DEBUG), "    MONITOR -> ", Boolean.valueOf(GWorld.MONITOR)});
        Out.info(new Object[]{"游戏已成功启动运行喽，O(∩_∩)O~"});
        System.out.println("游戏已成功启动运行喽，O(∩_∩)O~");
    }


    private static void loadData(File parent) {
        File[] tables = parent.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    GMain.loadData(file);
                }
                if (file.getName().endsWith(".json")) {
                    DataUtil.loadData(file);
                    return true;
                }
                return false;
            }
        });
        TableCount += tables.length;
    }


    public static void initData() {
        DataUtil.addExtClass("com.wanniu.game.data");

        File dataDir = new File("json");
        loadData(dataDir);

        Out.info(new Object[]{"Load table count:", Integer.valueOf(TableCount)});


        for (ServerConfigCO t : GameData.ServerConfigs.values()) {
            LangService.put(t.paramNameS, t.showTxt);
        }

        DataUtil.initProperty();

        GlobalConfig.init();
    }
}


