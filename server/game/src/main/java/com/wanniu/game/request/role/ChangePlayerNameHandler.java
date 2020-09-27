package com.wanniu.game.request.role;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.util.BlackWordUtil;
import com.wanniu.redis.GameDao;

import java.io.IOException;

import pomelo.connector.RoleHandler;


@GClientEvent("connector.roleHandler.changePlayerNameRequest")
public class ChangePlayerNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        RoleHandler.ChangePlayerNameRequest req = RoleHandler.ChangePlayerNameRequest.parseFrom(this.pak.getRemaingBytes());
        String uid = this.pak.getUid();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        final String name = req.getC2SName();
        if (StringUtil.isEmpty(uid)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_UID_NULL"));
        }

        if (StringUtil.isEmpty(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_NULL"));
        }

        if (name.length() > 6) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_LONG"));
        }


        if (BlackWordUtil.isIncludeBlackString(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_ID_SENSITIVE"));
        }

        if (BlackWordUtil.isIncludeSpecialChar(name)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_ID_CHARACTER"));
        }
        if (player != null) {
            int hasCount = player.bag.findItemNumByCode(Const.ITEM_CODE.Changename.value);

            if (hasCount <= 0) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("NOT_ENOUGH_ITEM"));
            }
        }

        boolean isPutSuccess = PlayerDao.putName(name, player.getId());
        if (!isPutSuccess) {
            Out.warn(new Object[]{"发现有玩家重名,改名失败,要改的名字为:", name, "playerId=", player.getId()});
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NAME_HAS_USED"));
        }


        if (!GameDao.putName(name, player.getId())) {
            Out.warn(new Object[]{"建立本服角色列表时异常啦!", name});
        }

        String oldName = player.getName();
        PlayerDao.freeName(oldName);
        GameDao.freeName(oldName);

        player.player.name = name;
        player.bag.discardItem(Const.ITEM_CODE.Changename.value, 1, Const.GOODS_CHANGE_TYPE.use, null, false, false);
        PlayerService.getInstance().afterPlayerChangeName(player);

        return new PomeloResponse() {
            protected void write() throws IOException {
                RoleHandler.ChangePlayerNameResponse.Builder res = RoleHandler.ChangePlayerNameResponse.newBuilder();
                res.setS2CCode(200);
                res.setS2CName(name);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


