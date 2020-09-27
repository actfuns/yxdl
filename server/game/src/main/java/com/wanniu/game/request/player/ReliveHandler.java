package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ResurrectionCO;
import com.wanniu.game.player.ReliveManager;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerPO;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.reliveRequest")
public class ReliveHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.ReliveRequest req = PlayerHandler.ReliveRequest.parseFrom(this.pak.getRemaingBytes());
        int c2s_type = req.getType();
        int payConfirm = req.getAutoPay();
        Out.debug(new Object[]{"reliveRequest :: ", Integer.valueOf(c2s_type), " && ", Integer.valueOf(payConfirm)});
        Area area = player.getArea();
        ReliveManager reliveManager = player.getReliveManager();
        int total = reliveManager.getReliveTotal(area.areaId);

        Area.ReliveType reliveType = area.getReliveType();
        int cost = Math.max(5, reliveManager.payCost);
        int reliveNum = 3 + player.vipManager.getReliveNum();
        ResurrectionCO resurrection = (ResurrectionCO) GameData.Resurrections.get(Integer.valueOf(area.areaId));
        if (resurrection != null &&
                resurrection.freeResurrect > 0) {
            reliveNum = 0;
        }

        if (c2s_type == 1) {
            reliveType = Area.ReliveType.NOW;
            if (reliveManager.nowReliveNum >= reliveNum) {
                if (payConfirm == 1) {
                    reliveManager.payConfirm = 0;
                }
                PlayerPO po = player.player;
                int diamond = po.diamond + po.ticket;
                if (cost > diamond) {
                    return (PomeloResponse) new ErrorResponse(LangService.getValue("NOT_ENOUGH_DIAMOND"));
                }
                if (po.ticket > cost) {
                    player.moneyManager.costTicket(cost, Const.GOODS_CHANGE_TYPE.relive);
                } else {
                    int ticket = po.ticket;
                    if (ticket > 0) {
                        player.moneyManager.costTicket(ticket, Const.GOODS_CHANGE_TYPE.relive);
                    }
                    player.moneyManager.costDiamond(cost, Const.GOODS_CHANGE_TYPE.relive);
                }
            }

            reliveManager.nowReliveNum++;
        } else {
            Area.Actor actor = area.getActor(player.getId());
            if (actor != null) {
                if (System.currentTimeMillis() < actor.reliveCoolTime) {
                    return (PomeloResponse) new ErrorResponse(LangService.format("RELIVE_COOL_TIME", new Object[]{Long.valueOf(Math.max(1L, (actor.reliveCoolTime - System.currentTimeMillis()) / 1000L))}));
                }
            } else {
                return (PomeloResponse) new ErrorResponse("");
            }
        }
        if (!area.isNormal() && total > 0) {
            int count = reliveManager.getReliveCount(area.areaId);
            if (count >= total) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("RELIVE_FULL"));
            }
            reliveManager.addRelive(area.areaId);
        }

        final PlayerHandler.ReliveResponse.Builder res = area.relive(player.getId(), reliveType);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


