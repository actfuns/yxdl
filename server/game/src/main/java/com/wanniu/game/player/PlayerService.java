package com.wanniu.game.player;

public class PlayerService {
    public void afterPlayerChangeName(WNPlayer player) {
        player.consignmentManager.afterPlayerChangeName();
        player.refreshBattlerServerBasic();
        player.rankManager.onChangeName();
        player.guildManager.onChangeName();
    }

    private PlayerService() {
    }

    private static class PlayerManagerHolder {
        public static final PlayerService INSTANCE = new PlayerService();
    }

    public static PlayerService getInstance() {
        return PlayerManagerHolder.INSTANCE;
    }
}


