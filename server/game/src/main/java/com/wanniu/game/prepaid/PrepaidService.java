package com.wanniu.game.prepaid;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.core.util.http.HttpRequester;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PayCO;
import com.wanniu.game.data.SuperPackageCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.FeeOrderPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.PlayerPOManager;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import pomelo.area.PrepaidHandler;


public class PrepaidService {
    private static PrepaidService instance;
    private static String createOrderUrl = GConfig.getInstance().get("server.pay.orderUrl");
    private static String notifyOrderUrl = GConfig.getInstance().get("server.pay.notifyUrl");
    private static String payNotifyUrl = "http://127.0.0.1:8100/paycenter/to/PayNotify.jsp";

    public static synchronized PrepaidService getInstance() {
        if (instance == null)
            instance = new PrepaidService();
        return instance;
    }


    private HashMap<String, String> prepaidConfig;


    public void init(HashMap<String, String> prepaidConfig) {
        this.prepaidConfig = prepaidConfig;
    }

    public Object getConfig(String configName) {
        return this.prepaidConfig.get(configName);
    }


    public void onPaySuccess(String orderId) {
        String orderKey = ConstsTR.feeOrder.value + "/" + orderId;
        String order = GCache.get(orderKey);
        if (StringUtil.isEmpty(order)) {
            Out.warn(new Object[]{"充值回调，重复通知... orderId=", orderId});
            return;
        }
        FeeOrderPO po = (FeeOrderPO) JSON.parseObject(order, FeeOrderPO.class);

        GCache.remove(orderKey);
        String playerId = po.playerId;
        int productId = po.productId;
        boolean isCard = po.isCard;
        boolean isSuperPackage = po.isSuperPackage;
        Out.info(new Object[]{"充值回调 orderId=", orderId, ",playerId=", playerId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage)});

        PrepaidManager manager = PrepaidCenter.getInstance().findPrepaid(playerId);
        manager.onCharge(productId, isCard, isSuperPackage, true);
        PrepaidCenter.getInstance().update(playerId, manager);


        try {
            int type = 0;
            int money = 0;
            if (isCard) {
                type = 1;
                money = ((CardCO) GameData.Cards.get(Integer.valueOf(productId))).payMoneyAmount;
            } else if (!isSuperPackage) {
                type = 0;
                money = ((PayCO) GameData.Pays.get(Integer.valueOf(productId))).payMoneyAmount;
            } else {
                type = 2;
                money = ((SuperPackageCO) GameData.SuperPackages.get(Integer.valueOf(productId))).packagePrice;
            }

            PlayerPO player = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
            LogReportService.getInstance().ansycReportRecharge(player, productId, type, money);
        } catch (Exception e) {
            Out.warn(new Object[]{"上报充值异常啦...", e});
        }
    }

    public int getResponseType(HashMap<String, String> dataMap) {
        if (dataMap.containsKey("pm_id") &&
                Integer.parseInt(dataMap.get("pm_id")) == 30) {
            return Const.PrepaidType.WP_PREPAID_REQUEST.getValue();
        }

        return Const.PrepaidType.PREPAID_REQUEST.getValue();
    }


    public PomeloResponse createOrderId(int productId, int channelId, WNPlayer player, boolean isCard, boolean isSuperPackage, String imei, int os) {
        float money = 0.0F;
        if (isCard) {
            money = ((CardCO) GameData.Cards.get(Integer.valueOf(productId))).payMoneyAmount;
        } else if (!isSuperPackage) {
            money = ((PayCO) GameData.Pays.get(Integer.valueOf(productId))).payMoneyAmount;
        } else {
            money = ((SuperPackageCO) GameData.SuperPackages.get(Integer.valueOf(productId))).packagePrice;
        }
        Map<String, String> params = new HashMap<>();
        params.put("appid", String.valueOf(GGame.__APP_ID));
        params.put("channel", String.valueOf(channelId));
        params.put("money", String.valueOf(money));
        params.put("username", player.getUid());
        params.put("serverid", String.valueOf(GGame.__SERVER_ID));
        params.put("roleid", player.getId());
        params.put("subchannel", (player.getPlayer()).subchannel);

        String orderId = null;

        if (GConfig.getInstance().isEnablePay()) {
            try {
                orderId = (new HttpRequester()).sendPost(createOrderUrl, params).getContent();
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
        final PrepaidHandler.PrepaidOrderIdResponse.Builder res = PrepaidHandler.PrepaidOrderIdResponse.newBuilder();
        if (!StringUtil.isNotEmpty(orderId)) {
            res.setS2CCode(500);
        } else {
            res.setS2CCode(200);
            res.setS2COrderId(orderId);

            FeeOrderPO po = new FeeOrderPO();
            po.orderId = orderId;
            po.createtime = new Date();
            po.playerId = player.getId();
            po.productId = productId;
            po.isCard = isCard;
            po.isSuperPackage = isSuperPackage;


            GCache.put(ConstsTR.feeOrder.value + "/" + po.orderId, Utils.serialize(po), 432000);

            Out.info(new Object[]{"创建订单 playerId=", player.getId(), ",name=", player.getName(), ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(isCard), ",isSuperPackage=", Boolean.valueOf(isSuperPackage)});


            if (StringUtils.isNotEmpty(notifyOrderUrl)) {
                res.setAppNotifyUrl(notifyOrderUrl);
            }
        }


        PomeloResponse me = new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
        return me;
    }

    public PomeloResponse createOrderId(int productId, int channelId, WNPlayer player, boolean isCard, String imei, int os) {
        return createOrderId(productId, channelId, player, isCard, false, imei, os);
    }

    public void onSimulationOrder(String orderId, String playerId, int productId) {
        String orderKey = ConstsTR.feeOrder.value + "/" + orderId;
        if (!GCache.exists(orderKey)) {
            FeeOrderPO po = new FeeOrderPO();
            po.orderId = orderId;
            po.createtime = new Date();
            po.playerId = playerId;
            po.productId = productId;

            if (productId < 100) {
                po.isCard = true;

            } else if (productId > 300) {
                po.isSuperPackage = true;
            }


            GCache.put(orderKey, Utils.serialize(po), 86400);
            Out.info(new Object[]{"创建虚拟订单 playerId=", playerId, ",productId=", Integer.valueOf(productId), ",isCard=", Boolean.valueOf(po.isCard), ",isSuperPackage=", Boolean.valueOf(po.isSuperPackage)});
        }
    }
}


