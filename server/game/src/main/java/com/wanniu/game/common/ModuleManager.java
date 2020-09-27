package com.wanniu.game.common;

import java.util.List;

import pomelo.area.PlayerHandler;


public abstract class ModuleManager {
    public abstract void onPlayerEvent(Const.PlayerEventType paramPlayerEventType);

    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        return null;
    }

    public abstract Const.ManagerType getManagerType();
}


