package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.po.AllBlobPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;


@GMEvent
public class MovePlayerHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        String id = arr.getString(0);
        int areaId = arr.getIntValue(1);
        WNPlayer player = PlayerUtil.getOnlinePlayer(id);
        if (player == null) {
            AllBlobPO allBlobData = PlayerDao.getAllBlobData(id);
            player = new WNPlayer(allBlobData);
        }
        AreaUtil.dispatchByAreaId(player, areaId, null);
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 12292;
    }
}


