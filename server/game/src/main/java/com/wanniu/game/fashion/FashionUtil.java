package com.wanniu.game.fashion;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.FashionExt;
import com.wanniu.game.poes.PlayerBasePO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pomelo.Common;


public class FashionUtil {
    public static List<Common.Avatar> getAvatarData(PlayerBasePO playerBasePO) {
        List<Common.Avatar> data = new ArrayList<>();


        for (Map.Entry<Integer, String> entry : (Iterable<Map.Entry<Integer, String>>) playerBasePO.fashions_equiped.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            String itemcode = entry.getValue();

            FashionExt fashion = (FashionExt) GameData.Fashions.get(itemcode);
            Common.Avatar.Builder avatar = Common.Avatar.newBuilder();
            avatar.setEffectType(0);

            avatar.setTag(fashion.avatarTag);
            avatar.setFileName(fashion.avatarId);
            data.add(avatar.build());
        }
        return data;
    }
}


