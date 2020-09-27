package com.wanniu.game.request.role;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.daoyou.DaoYouCenter;
import com.wanniu.game.guild.GuildService;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.rank.RankCenter;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.GlobalDao;
import com.wanniu.redis.PlayerPOManager;

import java.io.IOException;

import pomelo.connector.RoleHandler;


@GClientEvent("connector.roleHandler.deletePlayerRequest")
public class DeletePlayerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        RoleHandler.DeletePlayerRequest req = RoleHandler.DeletePlayerRequest.parseFrom(this.pak.getRemaingBytes());
        String playerId = req.getC2SPlayerId();

        PlayerPO player = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, playerId, PlayerPO.class);
        if (!player.uid.equals(this.pak.getUid())) {
            Out.warn(new Object[]{"玩家竟然尝试删除不是自己的角色 uid=", this.pak.getUid(), ",playerId=", playerId, ",name=", player.name});
            return new PomeloResponse() {
                protected void write() throws IOException {
                    RoleHandler.DeletePlayerResponse.Builder res = RoleHandler.DeletePlayerResponse.newBuilder();
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
        }

        player.isDelete = 1;
        Out.info(new Object[]{"玩家删除角色 uid=", this.pak.getUid(), ",playerId=", playerId, ",name=", player.name});

        Integer count = (Integer) this.pak.getAttr(GGlobal.__KEY_ROLE_COUNT);
        if (count != null && count.intValue() > 0) {
            this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(count.intValue() - 1));
        }


        GuildService.delRole(playerId);


        RankCenter.delRoleClear(playerId);


        DaoYouCenter.getInstance().removeDaoYouMember(playerId);

        String s_players = GlobalDao.hget(String.valueOf(player.logicServerId), player.uid);
        if (StringUtil.isNotEmpty(s_players)) {
            JSONObject players = JSON.parseObject(s_players);
            players.remove(player.id);
            GlobalDao.hset(String.valueOf(player.logicServerId), player.uid, players.toJSONString());
            PlayerUtil.addLoginServer(player.uid, player.logicServerId, players.size());
        }

        PlayerDao.freeName(player.name);
        GameDao.freeName(player.name);

        PlayerPOManager.clearOfflinePO(playerId);

        return new PomeloResponse() {
            protected void write() throws IOException {
                RoleHandler.DeletePlayerResponse.Builder res = RoleHandler.DeletePlayerResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


