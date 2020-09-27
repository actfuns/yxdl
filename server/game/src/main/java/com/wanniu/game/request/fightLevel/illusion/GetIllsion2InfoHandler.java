package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.IllusionPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.getLllsion2InfoRequest")
public class GetIllsion2InfoHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        final FightLevelHandler.GetLllsion2InfoResponse.Builder res = FightLevelHandler.GetLllsion2InfoResponse.newBuilder();
        IllusionPO illusion = player.illusionManager.illusionPO;
        Map<Integer, Integer> boxs = illusion.boxs;
        Integer lv1 = null;
        Integer lv2 = null;
        Integer lv3 = null;
        if (boxs != null) {
            lv1 = boxs.get(Integer.valueOf(1));
            lv2 = boxs.get(Integer.valueOf(2));
            lv3 = boxs.get(Integer.valueOf(3));
        }
        res.setS2CTodayLv1((lv1 == null) ? 0 : lv1.intValue());
        res.setS2CTodayLv2((lv2 == null) ? 0 : lv2.intValue());
        res.setS2CTodayLv3((lv3 == null) ? 0 : lv3.intValue());
        res.setS2CMaxNum(GlobalConfig.Mysterious_MaxNumEveryday);

        Map<String, Integer> items = illusion.items;
        Set<Map.Entry<String, Integer>> sets = GlobalConfig.mysteriousMaxNumVcardInfo.entrySet();
        for (Map.Entry<String, Integer> s : sets) {
            String code = s.getKey();
            int vl = ((Integer) s.getValue()).intValue();
            int today = 0;
            if (items != null && !items.isEmpty()) {
                Integer it = items.get(code);
                today = (it == null) ? 0 : it.intValue();
            }
            FightLevelHandler.MJItemMax.Builder bd = FightLevelHandler.MJItemMax.newBuilder();
            bd.setItemCode(code);
            bd.setS2CMaxMl(vl);
            bd.setS2CTodayMl(today);
            res.addItemInfo(bd);
        }
        res.setS2CCode(200);
        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


