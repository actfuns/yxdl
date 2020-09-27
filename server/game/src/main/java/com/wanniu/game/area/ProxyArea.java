package com.wanniu.game.area;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;

import java.util.concurrent.ConcurrentHashMap;

public class ProxyArea
        extends Area {
    public ProxyArea(JSONObject opts) {
        super(opts);
    }


    public void bindBattleServer(WNPlayer player) {
        Out.warn(new Object[]{"proxy bindBattleServer!!!"});
    }

    public void setBattleServerId(String battleServerId) {
        this.serverId = battleServerId;
        Out.debug(new Object[]{"bindBattleServer ", this.serverId});
    }

    protected void init() {
        this.hasPlayerEntered = false;
        this.actors = new ConcurrentHashMap<>();
        this.emptyTime = GWorld.APP_TIME;
        this.sceneType = this.prop.type;
        this.lifeTime = this.prop.lifeTime * 1000;
    }


    public void dispose() {
        super.dispose();
    }


    public void addPlayer(WNPlayer player) {
        super.addPlayer(player);
    }


    public void removePlayer(WNPlayer player, boolean keepObject) {
        super.removePlayer(player, keepObject);
    }

    public boolean hasHighQualityItem() {
        return false;
    }
}


