package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.ChangePkModelRequest")
public class ChangePkModelHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.ChangPkModelRequest req = PlayerHandler.ChangPkModelRequest.parseFrom(this.pak.getRemaingBytes());
        final int reqModel = req.getC2SModel();


        MapBase sceneProp = (player.getArea()).prop;
        if (sceneProp.changePKtype == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("AREA_CANNOT_CHANG_PKMODE"));
        }

        int levelReq = GlobalConfig.PK_LevelReq;

        if (levelReq > 0 && player.getLevel() < levelReq) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PK_LEVEL_REQ").replace("{0}", String.valueOf(levelReq)));
        }

        if (reqModel == Const.PkModel.Team.value && !player.getTeamManager().isInTeam()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("TEAM_NO_TEAM"));
        }
        if (reqModel == Const.PkModel.Guild.value && player.guildManager.guild == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("NOTHAVE_GUILD"));
        }

        if (reqModel != player.pkRuleManager.pkData.pkModel) {
            player.pkRuleManager.pkData.pkModel = reqModel;
            Out.debug(new Object[]{"ChangePkModelRequest: ", Integer.valueOf(reqModel)});
            player.getXmdsManager().refreshPlayerPKMode(player.getId(), reqModel);
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.ChangPkModelRespone.Builder res = PlayerHandler.ChangPkModelRespone.newBuilder();
                res.setS2CCode(200);
                res.setS2CCurrentModel(reqModel);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


