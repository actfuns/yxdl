package com.wanniu.game.onlineGift;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.OlGiftExt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OlGiftConfig {
    private static OlGiftConfig instance;
    private Map<Integer, OlGiftExt> olgTable;

    public static OlGiftConfig getInstance() {
        if (instance == null) {
            instance = new OlGiftConfig();
        }
        return instance;
    }

    private OlGiftConfig() {
        this.olgTable = GameData.OlGifts;
    }


    public List<OlGiftExt> getPropList() {
        return new ArrayList<>(this.olgTable.values());
    }


    public OlGiftExt getPropById(int olgId) {
        if (this.olgTable.containsKey(Integer.valueOf(olgId))) {
            return this.olgTable.get(Integer.valueOf(olgId));
        }
        return null;
    }

    public List<OlGiftExt> getPropListByLevel(int giftType, int upLevel, int level) {
        List<OlGiftExt> lstOlg = new ArrayList<>();
        for (OlGiftExt gift : this.olgTable.values()) {
            if (giftType != gift.type) {
                continue;
            }

            if ((upLevel > 0) ? (
                    upLevel < gift.downOrder || upLevel > gift.upOrder) : (


                    level < gift.lvDown || level > gift.lvUp)) {
                continue;
            }

            lstOlg.add(gift);
        }
        return lstOlg;
    }


    public OlGiftExt getPropByLevelAndTime(int upLevel, int level, int time) {
        for (OlGiftExt gift : this.olgTable.values()) {
            if (gift.upOrder == upLevel && gift.time == time) {
                if (upLevel == 0 &&
                        gift.lvDown <= level && gift.lvUp >= level) {
                    return gift;
                }

                return gift;
            }
        }


        return null;
    }
}


