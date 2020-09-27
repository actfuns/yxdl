package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.player.GlobalConfig;

import java.util.ArrayList;
import java.util.List;


@DBTable("player_hookset")
public class HookSetPO
        extends GEntity {
    public int hpPercent;
    public int mpPercent;
    public String hpItemCode;
    public String mpItemCode;
    public int pkSet;
    public List<Integer> meltQcolor;
    public int autoBuyHpItem;
    public int autoBuyMpItem;
    public int fieldMaphook;
    public int areaMaphook;

    public HookSetPO() {
    }

    public HookSetPO(String playerId) {
        this.hpPercent = GlobalConfig.Auto_HP_Percent;
        this.hpItemCode = GlobalConfig.Auto_HP_Item;
        this.pkSet = GlobalConfig.Auto_PK_Reaction;
        this.meltQcolor = new ArrayList<>();
        this.meltQcolor.add(Integer.valueOf(GlobalConfig.Auto_Eqip_Qcolor));
        this.autoBuyHpItem = 1;
        this.fieldMaphook = 0;
        this.areaMaphook = 0;
    }
}


