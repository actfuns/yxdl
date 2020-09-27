package com.wanniu.game.request.equip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.EquipHandler;


@GClientEvent("area.equipHandler.openEquipHandlerRequest")
public class OpenEquipHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        EquipManager equipManager = player.equipManager;

        EquipHandler.OpenEquipHandlerRequest req = EquipHandler.OpenEquipHandlerRequest.parseFrom(this.pak.getRemaingBytes());
        int code = req.getCode();


        Out.debug(new Object[]{"opennnnnnnnnnnnnn  ", Integer.valueOf(code)});
        Const.SUPERSCRIPT_TYPE type = Const.SUPERSCRIPT_TYPE.getType(code);
        if (type == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAMETER ERROR"));
        }
        switch (type) {
            case REBORN:
                if (player.equipManager.getRebornPoint() > 0) {
                    player.playerBasePO.openRebornToday = true;
                }


                equipManager.pushScripts();

                return new PomeloResponse() {
                    protected void write() throws IOException {
                        EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                    }
                };
            case REBUILD:
                if (player.equipManager.getRebuildPoint() > 0) player.playerBasePO.openRebuildToday = true;
                equipManager.pushScripts();
                return new PomeloResponse() {
                    protected void write() throws IOException {
                        EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                    }
                };
            case KAIGUANG:
                if (player.equipManager.getKaiguangPoint() > 0) player.playerBasePO.openKaiguangToday = true;
                equipManager.pushScripts();
                return new PomeloResponse() {
                    protected void write() throws IOException {
                        EquipHandler.OpenEquipHandlerResponse.Builder res = EquipHandler.OpenEquipHandlerResponse.newBuilder();
                        res.setS2CCode(200);
                        this.body.writeBytes(res.build().toByteArray());
                    }
                }
                        ;
        }
        return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAMETER ERROR"));
    }
}


