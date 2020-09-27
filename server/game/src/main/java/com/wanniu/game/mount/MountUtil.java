package com.wanniu.game.mount;

import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.RideListExt;
import com.wanniu.game.data.ext.SkinListExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.poes.MountPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.Common;


public class MountUtil {
    public static final List<Common.Avatar> getCurMountAvatarInfo(MountPO mountData) {
        ArrayList<Common.Avatar> avatarData = new ArrayList<>();
        if (mountData != null && mountData.rideFlag == Const.MOUNT_RIDING_STATE.on.getValue()) {
            int avatarPoint = 16;


            if (mountData.usingSkinId > 0) {
                SkinListExt skinProp = MountConfig.getInstance().getMountSkinPropByID(mountData.usingSkinId);
                Common.Avatar.Builder builder = Common.Avatar.newBuilder();
                builder.setTag(avatarPoint);
                builder.setFileName(skinProp.modelFile);
                builder.setEffectType(0);
                avatarData.add(builder.build());
            }
        }


        return avatarData;
    }

    public static final Map<Const.PlayerBtlData, Integer> getMountBaseProp(int rideLevel, int starLv) {
        Map<Const.PlayerBtlData, Integer> baseMap = new HashMap<>();
        RideListExt prop = (RideListExt) GameData.RideLists.get(Integer.valueOf(rideLevel));
        if (prop == null) {
            return baseMap;
        }
        AttributeUtil.addData2AllData(prop.levelAttrs, baseMap);
        Map<Const.PlayerBtlData, Integer> map = prop.starAttrs;
        Map<Const.PlayerBtlData, Integer> map_star = new HashMap<>();
        for (Const.PlayerBtlData pbd : map.keySet()) {
            int value = ((Integer) map.get(pbd)).intValue();
            value *= starLv;
            value += ((Integer) prop.totalPreStarAttrs.get(pbd)).intValue();
            map_star.put(pbd, Integer.valueOf(value));
        }
        AttributeUtil.addData2AllData(map_star, baseMap);
        return baseMap;
    }
}


