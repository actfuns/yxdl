package com.wanniu.game.item;

import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.po.PlayerItemPO;


public class VirtualItem
        extends NormalItem {
    public VirtualItem(PlayerItemPO itemDb, DItemEquipBase prop) {
        super(itemDb, prop);
    }


    public int getWorth() {
        return this.itemDb.speData.worth;
    }

    public void addWorth(int num) {
        this.itemDb.speData.worth += num;
    }

    public void setWorth(int num) {
        this.itemDb.speData.worth = num;
    }


    public void dropResetWorth(int args0, int args1, int args2) {
        int oldWorth = this.itemDb.speData.worth;
        int newWorth = this.itemDb.speData.worth;
        if (this.itemDb.code.equals("gold")) {
            int monsterLevel = args0;
            int goldPerMonLv = args1;
            int playerNum = (args2 > 1) ? args2 : 1;


            newWorth = (oldWorth + (monsterLevel - 1) * goldPerMonLv) / playerNum;

        } else if (this.itemDb.code.equals("exp")) {
            int monsterLevel = args0;
            int expRatio = args1;
            int playerLevelUpExp = args2;

            newWorth = oldWorth + playerLevelUpExp * expRatio / 10000;
        }


        setWorth(newWorth);
    }
}


