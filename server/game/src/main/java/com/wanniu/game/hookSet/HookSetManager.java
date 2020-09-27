package com.wanniu.game.hookSet;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.HookSetPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.List;

import pomelo.area.HookSetHandler;
import pomelo.player.PlayerOuterClass;


public class HookSetManager {
    private final HookSetPO po;

    public HookSetManager(WNPlayer player, HookSetPO data) {
        if (data == null) {
            player.allBlobData.hookSetData = data = PlayerUtil.createHookSetManager(player.getId());
            PlayerPOManager.put(ConstsTR.hookSetTR, player.getId(), (GEntity) data);
        }
        this.po = data;
    }

    public void changeHookSet(HookSetHandler.HookSetData hsd) {
        this.po.hpPercent = hsd.getHpPercent();
        this.po.mpPercent = hsd.getMpPercent();
        this.po.hpItemCode = hsd.getHpItemCode();
        this.po.mpItemCode = hsd.getMpItemCode();
        this.po.pkSet = hsd.getPkSet();
        this.po.meltQcolor = hsd.getMeltQcolorList();
        this.po.autoBuyHpItem = hsd.getAutoBuyHpItem();
        this.po.autoBuyMpItem = hsd.getAutoBuyMpItem();
        this.po.fieldMaphook = hsd.getFieldMaphook();
        this.po.areaMaphook = hsd.getAreaMaphook();
    }

    public PlayerOuterClass.HookSetData.Builder toJson4Payload() {
        PlayerOuterClass.HookSetData.Builder data = PlayerOuterClass.HookSetData.newBuilder();
        data.setHpPercent(this.po.hpPercent);
        data.setMpPercent(this.po.mpPercent);
        if (StringUtil.isNotEmpty(this.po.hpItemCode)) {
            data.setHpItemCode(this.po.hpItemCode);
        }

        if (StringUtil.isNotEmpty(this.po.mpItemCode)) {
            data.setMpItemCode(this.po.mpItemCode);
        } else {
            data.setMpItemCode("");
        }

        data.setPkSet(this.po.pkSet);
        data.addAllMeltQcolor(this.po.meltQcolor);
        data.setAutoBuyHpItem(this.po.autoBuyHpItem);
        data.setAutoBuyMpItem(this.po.autoBuyMpItem);
        data.setFieldMaphook(this.po.fieldMaphook);
        data.setAreaMaphook(this.po.areaMaphook);
        return data;
    }


    public List<Integer> getMeltQcolor() {
        return this.po.meltQcolor;
    }
}


