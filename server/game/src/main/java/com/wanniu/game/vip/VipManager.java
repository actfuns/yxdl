package com.wanniu.game.vip;

import com.wanniu.game.common.Const;
import com.wanniu.game.common.DateUtils;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.VipPO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pomelo.area.PlayerHandler;


public class VipManager
        extends ModuleManager {
    private static final float Tenthousand = 10000.0F;
    private final WNPlayer player;
    public VipPO po;

    public VipManager(WNPlayer player, VipPO po) {
        this.player = player;
        if (po == null) {
            player.playerAttachPO.vipData = po = new VipPO();
        }
        this.po = po;
    }


    public int takeDailyReward(int type) {
        CardCO cardProp = (CardCO) GameData.Cards.get(Integer.valueOf(type));
        if (cardProp == null) {
            return -4;
        }
        Const.VipType vt = Const.VipType.getE(type);
        if (vt == Const.VipType.month) {
            if (this.player.baseDataManager.getVip() != Const.VipType.month.value && this.player.baseDataManager.getVip() != Const.VipType.sb_double.value) {
                return -1;
            }
            if (this.po.lastMonthRewardDate != null && DateUtils.isToday(this.po.lastMonthRewardDate)) {
                return -3;
            }
            this.po.lastMonthRewardDate = Calendar.getInstance().getTime();
        } else if (vt == Const.VipType.forever) {
            if (this.player.baseDataManager.getVip() != Const.VipType.forever.value && this.player.baseDataManager.getVip() != Const.VipType.sb_double.value) {
                return -2;
            }
            if (this.po.lastForeverRewardDate != null && DateUtils.isToday(this.po.lastForeverRewardDate)) {
                return -3;
            }
            this.po.lastForeverRewardDate = Calendar.getInstance().getTime();
        }
        this.player.moneyManager.addTicket(cardProp.dailyDW, Const.GOODS_CHANGE_TYPE.dailypay_gift);

        updateSuperScript();
        return 0;
    }

    public float getVipExpRatio() {
        if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
            CardCO card = (CardCO) GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
            return card.prv2 / 10000.0F;
        }
        return 0.0F;
    }

    public float getExtGoldRatio() {
        if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
            CardCO card = (CardCO) GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
            return card.prv3 / 10000.0F;
        }
        return 0.0F;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        if (eventType == Const.PlayerEventType.AFTER_LOGIN) {
            updateSuperScript();
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.VIP;
    }

    public long getVipRemainTime() {
        long remain = 0L;
        if (this.player.baseDataManager.getVip() == Const.VipType.none.value || this.player.baseDataManager.getVip() == Const.VipType.forever.value) {
            return 0L;
        }
        Calendar c_end = Calendar.getInstance();
        c_end.setTime(this.player.player.vipEndTime);
        remain = (c_end.getTimeInMillis() - System.currentTimeMillis()) / 1000L;
        if (remain < 0L) {
            remain = 0L;
        }
        return remain;
    }


    public final List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
        script.setType(Const.SUPERSCRIPT_TYPE.VIP.getValue());

        int vipType = this.player.baseDataManager.getVip();
        int num = 0;
        if ((vipType == Const.VipType.month.value || vipType == Const.VipType.sb_double.value) && (
                this.po.lastMonthRewardDate == null || !DateUtils.isToday(this.po.lastMonthRewardDate))) {
            num++;
        }

        if ((vipType == Const.VipType.forever.value || vipType == Const.VipType.sb_double.value) && (
                this.po.lastForeverRewardDate == null || !DateUtils.isToday(this.po.lastForeverRewardDate))) {
            num++;
        }

        script.setNumber(num);

        list.add(script.build());
        return list;
    }

    public final void updateSuperScript() {
        this.player.updateSuperScriptList(getSuperScript());
    }


    public int getReliveNum() {
        if (this.player.baseDataManager.getVip() != Const.VipType.none.value) {
            CardCO card = (CardCO) GameData.Cards.get(Integer.valueOf(this.player.baseDataManager.getVip()));
            if (card != null) {
                return card.prv10;
            }
        }
        return 0;
    }
}


