package com.wanniu.game.chat.command.test;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.chat.command.AbsCommand;
import com.wanniu.game.chat.command.Command;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;
import pomelo.area.PlayerHandler;


@Command({"@gm test login"})
public class TestLoginCommand
        extends AbsCommand {
    public String help() {
        return "@gm test login <name> 测试登录任何角色";
    }


    protected String exec(WNPlayer player, String... args) {
        String name = args[3];
        String id = GameDao.getIdByName(name);
        if (!StringUtil.isEmpty(id)) {
            Out.info(new Object[]{"拉取目标角色 name=", name, ",id=", id});
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, id, PlayerPO.class);
            PlayerDao.insertPlayerId(baseData, player.allBlobData);


            PlayerHandler.KickPlayerPush.Builder data = PlayerHandler.KickPlayerPush.newBuilder();
            data.setS2CReasonType(Const.KickReason.GM_KICK.value);
            try {
                player.getSession().write((new MessagePush("area.playerPush.kickPlayerPush", (GeneratedMessage) data.build())).getContent()).await(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return "目标角色名称未找到...";
        }
        return "OK";
    }
}


