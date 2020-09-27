package com.wanniu.game.auction;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildBossPo;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.PlayerHandler;


public class AuctionManager
        extends ModuleManager {
    private WNPlayer player;

    public AuctionManager(WNPlayer player) {
        this.player = player;
    }


    public void pushScript() {
        PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
        List<PlayerHandler.SuperScriptType> list = getSuperScript();
        if (list != null && !list.isEmpty()) {
            data.addAllS2CData(list);
            this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage) data.build());
        }
        this.player.guildManager.pushRedPoint();
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        list.add(getGuildScript().build());
        list.add(getWorldScript().build());
        return list;
    }

    private PlayerHandler.SuperScriptType.Builder getGuildScript() {
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.GUILD_AUCTION.getValue());
        String guildId = this.player.guildManager.getGuildId();
        if (StringUtil.isEmpty(guildId)) {
            data.setNumber(0);
            return data;
        }
        boolean hasGuildAuction = AuctionDataManager.getInstance().hasGuildItem(guildId);
        if (hasGuildAuction) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }
        return data;
    }

    public boolean canGuildPush() {
        String guildId = this.player.guildManager.getGuildId();
        if (StringUtil.isEmpty(guildId)) {
            return false;
        }
        boolean hasGuildAuction = AuctionDataManager.getInstance().hasGuildItem(guildId);
        return hasGuildAuction;
    }

    public boolean needUpdateRedPoint() {
        GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
        boolean hasWorldAuction = AuctionDataManager.getInstance().hasWorldItem();
        return (hasWorldAuction && guildBossPO.aucpoint == 0);
    }

    private PlayerHandler.SuperScriptType.Builder getWorldScript() {
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.WORLD_AUCTION.getValue());
        if (needUpdateRedPoint()) {
            data.setNumber(1);
        } else {
            data.setNumber(0);
        }
        return data;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.AUCTION;
    }
}


