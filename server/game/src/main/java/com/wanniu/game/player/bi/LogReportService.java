package com.wanniu.game.player.bi;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.jsfunny.ConsignmentData;
import com.wanniu.game.player.bi.jsfunny.CreatePlayerData;
import com.wanniu.game.player.bi.jsfunny.FashionData;
import com.wanniu.game.player.bi.jsfunny.ItemFlowData;
import com.wanniu.game.player.bi.jsfunny.LoginData;
import com.wanniu.game.player.bi.jsfunny.LuckDrawData;
import com.wanniu.game.player.bi.jsfunny.MoneyFlowData;
import com.wanniu.game.player.bi.jsfunny.MoneyMonitorData;
import com.wanniu.game.player.bi.jsfunny.MountSkinData;
import com.wanniu.game.player.bi.jsfunny.MountUpgradeData;
import com.wanniu.game.player.bi.jsfunny.OnlineCountData;
import com.wanniu.game.player.bi.jsfunny.PacketMonitorData;
import com.wanniu.game.player.bi.jsfunny.PetSkinData;
import com.wanniu.game.player.bi.jsfunny.PetUpgradeData;
import com.wanniu.game.player.bi.jsfunny.RechargeData;
import com.wanniu.game.player.bi.jsfunny.RoleUpgradeData;
import com.wanniu.game.player.bi.jsfunny.ShopData;
import com.wanniu.game.poes.PlayerPO;


public class LogReportService {
    private static final LogReportService instance = new LogReportService();

    public static final int OPERATE_ADD = 1;
    public static final int OPERATE_COST = 2;

    public static LogReportService getInstance() {
        return instance;
    }


    public void ansycReportOnline(int onlineCount, int robotOnlineCount) {
        try {
            (new OnlineCountData(onlineCount, robotOnlineCount)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportOnline Exception", e});
        }
    }


    public void ansycReportUpgrade(WNPlayer player) {
        try {
            (new RoleUpgradeData(player)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportUpgrade Exception", e});
        }
    }


    public void ansycReportMoneyFlow(PlayerPO player, VirtualItemType type, int before, int operate, int value, int after, int origin) {
        try {
            (new MoneyFlowData(player, type, before, operate, value, after, origin)).publishing();


            switch (type) {
                case DIAMOND:
                    BILogService.getInstance().ansycReportEconomy(player, "yb", (operate == 1), value, origin);
                    break;
                case CASH:
                    BILogService.getInstance().ansycReportEconomy(player, "bdyb", (operate == 1), value, origin);
                    break;
                case GOLD:
                    BILogService.getInstance().ansycReportEconomy(player, "yl", (operate == 1), value, origin);
                    break;
            }


        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportMoneyFlow Exception", e});
        }
    }


    public void ansycReportItemFlow(PlayerPO player, int operate, String itemcode, int count, boolean bind, Const.GOODS_CHANGE_TYPE origin, String name) {
        if (origin == null) {
            origin = Const.GOODS_CHANGE_TYPE.def;
        }
        try {
            (new ItemFlowData(player, operate, itemcode, count, bind, origin.value)).publishing();


            BILogService.getInstance().ansycReportItem(player, (operate == 1), itemcode, count, origin, name);
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportItemFlow Exception", e});
        }
    }


    public void ansycReportMountUpgrade(WNPlayer player, int rideLevel, int starLv) {
        try {
            (new MountUpgradeData(player.getPlayer(), rideLevel, starLv)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportMount Exception", e});
        }
    }


    public void ansycReportPetUpgrade(WNPlayer player, int petId, String petName, int upLevel, int level, long exp) {
        try {
            (new PetUpgradeData(player.getPlayer(), petId, petName, upLevel, level, exp)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportMount Exception", e});
        }
    }


    public void ansycReportRecharge(PlayerPO player, int productId, int type, int money) {
        try {
            (new RechargeData(player, productId, type, money)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportRecharge Exception", e});
        }
    }


    public void ansycReportShop(WNPlayer player, String itemcode, int itemnum, int consumeType, int costMoney) {
        try {
            (new ShopData(player.getPlayer(), itemcode, itemnum, consumeType, costMoney)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportShop Exception", e});
        }
    }


    public void ansycReportCreatePlayer(WNPlayer player) {
        try {
            (new CreatePlayerData(player.getPlayer())).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportCreatePlayer Exception", e});
        }
    }

    public void ansycReportMountSkin(WNPlayer player, int skinId) {
        try {
            (new MountSkinData(player.getPlayer(), skinId)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportMountSkin Exception", e});
        }
    }


    public void ansycReportPetSkin(WNPlayer player, int petId) {
        try {
            (new PetSkinData(player.getPlayer(), petId)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportPetSkin Exception", e});
        }
    }


    public void ansycReportFashion(WNPlayer player, String code) {
        try {
            (new FashionData(player.getPlayer(), code)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportFashion Exception", e});
        }
    }


    public void ansycReportLuckDraw(WNPlayer player, int type, int count, int money, int itemcount) {
        try {
            (new LuckDrawData(player.getPlayer(), type, count, money, itemcount)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportLuckDraw Exception", e});
        }
    }


    public void ansycReportConsignment(WNPlayer player, String buyerId, String buyerName, String itemcode, int itemcount) {
        try {
            (new ConsignmentData(player.getPlayer(), buyerId, buyerName, itemcode, itemcount)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportConsignment Exception", e});
        }
    }


    public void ansycReportMoneyMonitor(WNPlayer player, VirtualItemType type, int today, int threshold) {
        try {
            (new MoneyMonitorData(player.getPlayer(), type, today, threshold)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportMoneyMonitor Exception", e});
        }
    }


    public void ansycReportPacketMonitor(PlayerPO player, Integer count, short type, String route) {
        try {
            (new PacketMonitorData(player, count, type, route)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportPacketMonitor Exception", e});
        }
    }


    public void ansycReportLogin(PlayerPO player) {
        try {
            (new LoginData(player)).publishing();
        } catch (Exception e) {
            Out.warn(new Object[]{"ansycReportLogin Exception", e});
        }
    }
}


