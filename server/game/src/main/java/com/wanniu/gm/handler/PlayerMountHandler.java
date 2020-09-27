package com.wanniu.gm.handler;

import cn.qeng.common.gm.vo.GmMountVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.SkinListExt;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.game.poes.MountPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMJsonResponse;
import com.wanniu.gm.GMResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@GMEvent
public class PlayerMountHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        WNPlayer wnPlayer = PlayerUtil.getOnlinePlayer(id);
        if (wnPlayer == null) {
            AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
            wnPlayer = new WNPlayer(allBlobData);
        }
        List<GmMountVO> list = new ArrayList<>();
        MountPO mount = wnPlayer.mountManager.mount;
        StringBuilder attr = new StringBuilder();
        for (Map.Entry<Const.PlayerBtlData, Integer> entry : (Iterable<Map.Entry<Const.PlayerBtlData, Integer>>) wnPlayer.mountManager.data_mount_final.entrySet()) {
            attr.append(((Const.PlayerBtlData) entry.getKey()).chName + "+" + entry.getValue() + "<br />");
        }
        if (mount != null) {
            list.add(new GmMountVO(((SkinListExt) GameData.SkinLists.get(Integer.valueOf(mount.usingSkinId))).skinName, String.valueOf(mount.rideLevel), mount.starLv, attr.toString()));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("total", Integer.valueOf(1));
        data.put("rows", list);
        JSONObject jo = new JSONObject(data);

        return (GMResponse) new GMJsonResponse(jo);
    }

    public short getType() {
        return 12327;
    }
}


