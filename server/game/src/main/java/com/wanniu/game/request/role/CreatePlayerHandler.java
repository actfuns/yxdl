package com.wanniu.game.request.role;

import cn.qeng.common.login.TokenInfo;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.PlayerRemote;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.CharacterExt;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.RebateService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.util.BlackWordUtil;

import java.io.IOException;
import java.util.List;

import pomelo.connector.RoleHandler;


@GClientEvent("connector.roleHandler.createPlayerRequest")
public class CreatePlayerHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        RoleHandler.CreatePlayerRequest req = RoleHandler.CreatePlayerRequest.parseFrom(this.pak.getRemaingBytes());
        String uid = this.pak.getUid();
        int pro = req.getC2SPro();
        if (pro == Const.PlayerPro.YU_JIAN.value || pro == Const.PlayerPro.SHEN_JIAN.value) {
            return (PomeloResponse) new ErrorResponse("该职业暂未开放！");
        }
        String name = req.getC2SName();
        if (StringUtil.isEmpty(uid)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
        }

        if (StringUtil.isEmpty(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_NULL"));
        }

        if (name.length() > GWorld.__SERVER_LANG.getNameLimit()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_LONG"));
        }

        if (pro == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_PRO_ILLEGALITY"));
        }

        Integer count = (Integer) this.pak.getAttr(GGlobal.__KEY_ROLE_COUNT);
        if (count != null && count.intValue() >= 5) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ROLE_NUM_UPPER_LIMIT"));
        }


        if (BlackWordUtil.isIncludeBlackString(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
        }

        if (BlackWordUtil.isIncludeSpecialChar(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_ID_CHARACTER"));
        }

        List<CharacterExt> charData = GameData.findCharacters(t -> (t.pro == pro));
        if (charData.size() == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_PRO_ILLEGALITY"));
        }


        final WNPlayer player = PlayerRemote.createPlayer(uid, name, pro, ((Integer) this.pak.getAttr(GGlobal.__KEY_LOGIC_SERVERID)).intValue());
        if (player == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_HAS_USED"));
        }


        TokenInfo token = (TokenInfo) this.pak.getAttr(GGlobal.__KEY_TOKEN_INFO);
        if (token != null) {
            (player.getPlayer()).channel = token.getChannel();
            (player.getPlayer()).subchannel = token.getSubchannel();
            (player.getPlayer()).subchannelUID = token.getSubchannelUid();
            (player.getPlayer()).mac = token.getMac();
            (player.getPlayer()).os = token.getOs();
            (player.getPlayer()).ip = this.pak.getIp();
        }

        Out.info(new Object[]{"创建角色 playerId=", player.getId(), ",name=", player.getName(), ",uid=", uid});
        BILogService.getInstance().ansycReportPlayerData(this.pak.getSession(), player.getPlayer(), true);
        RebateService.getInstance().ansycCheckRebate(player);
        LogReportService.getInstance().ansycReportCreatePlayer(player);

        this.pak.setAttr(GGlobal.__KEY_ROLE_COUNT, Integer.valueOf(count.intValue() + 1));
        return new PomeloResponse() {
            protected void write() throws IOException {
                RoleHandler.CreatePlayerResponse.Builder res = RoleHandler.CreatePlayerResponse.newBuilder();

                res.setS2CPlayer(PlayerUtil.transToJson4Basic(player));

                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


