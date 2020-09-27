package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.prepaid.PrepaidService;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.sendGMCmdRequest")
public class SendGMCmdHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        if (GWorld.ROBOT) {
            String code;
            int stackNum, taskId, num;
            String orderId;
            WNPlayer player = (WNPlayer) this.pak.getPlayer();

            PlayerHandler.SendGMCmdRequest req = PlayerHandler.SendGMCmdRequest.parseFrom(this.pak.getRemaingBytes());
            String cmd = req.getC2SMsg();
            if (StringUtil.isEmpty(cmd)) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
            }
            String[] strs = cmd.trim().split(" ");
            if (strs.length <= 0) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
            }

            String op = strs[1];
            Out.debug(new Object[]{"sendGMCmdRequest cmd:", op});
            switch (op) {
                case "add":
                    code = strs[2];
                    stackNum = Integer.parseInt(strs[3]);
                    player.bag.addCodeItemMail(code, stackNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.gm, "test_1");


                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
                case "finishTask":
                    taskId = Integer.parseInt(strs[2]);
                    player.taskManager.gmFinishTask(taskId);
                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
                case "openFunc":
                    player.functionOpenManager.gmOpenFunction(0);
                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
                case "allSkin":
                    player.mountManager.addAllSkin();
                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
                case "unlock":
                    num = Integer.parseInt(strs[2]);
                    player.getWnBag().addBagGridCount(num);
                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
                case "paySuccess":
                    orderId = strs[2];
                    PrepaidService.getInstance().onPaySuccess(orderId);
                    return new PomeloResponse() {
                        protected void write() throws IOException {
                            PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                            res.setS2CCode(200);
                            this.body.writeBytes(res.build().toByteArray());
                        }
                    };
            }
            Out.error(new Object[]{"not exists cmd : ", cmd});
        }
        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.SendGMCmdResponse.Builder res = PlayerHandler.SendGMCmdResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        }
                ;
    }
}


