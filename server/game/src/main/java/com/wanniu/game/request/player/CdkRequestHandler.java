package com.wanniu.game.request.player;

import cn.qeng.common.gm.po.CdkCode;
import cn.qeng.common.gm.po.CdkItem;
import cn.qeng.common.gm.po.CdkPO;
import com.wanniu.core.db.GCache;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.CdksUsePO;
import com.wanniu.redis.GlobalDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.cdkRequest")
public class CdkRequestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        PlayerHandler.CDKRequest cdk = PlayerHandler.CDKRequest.parseFrom(this.pak.getRemaingBytes());
        String useCode = cdk.getC2SCdk().toUpperCase();
        if (useCode.length() < 12) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
        }
        CdksUsePO cdksUsePo = null;
        List<CdkItem> items = null;
        String codeStr = null;
        try {
            boolean canGetCDK = canOperatorCDK();
            if (!canGetCDK) {
                Out.warn(new Object[]{"在获取cdk的时候发现有人在操作！playerId=", player.getId(), ",发送的cdk=", useCode});
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_ISUSE"));
            }
            String str = GlobalDao.hget(ConstsTR.CDK.value, useCode.substring(0, useCode.indexOf("X")));

            CdkPO cdkPo = (CdkPO) Utils.deserialize(str, CdkPO.class);
            if (cdkPo == null) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
            }
            CdkCode code = null;
            for (CdkCode c : cdkPo.getCdkCodes()) {
                if (c.getCode().equals(useCode)) {
                    code = c;
                    break;
                }
            }
            if (code == null) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_NOTEXIST"));
            }
            if (cdkPo.getCdkType() == 0 && code.getUseNum() > 0) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_ISUSE"));
            }
            if (cdkPo.getBeginDate() != null && cdkPo.getEndDate() != null &&
                    DateUtil.isOutDate(cdkPo.getBeginDate().getTime(), cdkPo.getEndDate().getTime()) != 1) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_TIMEOUT"));
            }

            if (cdkPo.getChannel() != -1 && cdkPo.getChannel() != cdk.getC2SChannel()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_CHANNELUSE"));
            }
            if (player.getLevel() < cdkPo.getMinLevel()) {
                return (PomeloResponse) new ErrorResponse(LangService.format("ACTIVITY_CKD_USELEVEL", new Object[]{Integer.valueOf(cdkPo.getMinLevel())}));
            }
            if (!cdkPo.getServerIds().isEmpty() && !cdkPo.getServerIds().contains(Integer.valueOf(GWorld.__SERVER_ID))) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_SERVERUSE"));
            }
            cdksUsePo = getCdksUsePO(player);
            int useCount = getCDKUseCount(cdksUsePo, cdkPo.getCode());
            if (useCount >= cdkPo.getMaxUseCount()) {
                return (PomeloResponse) new ErrorResponse(LangService.getValue("ACTIVITY_CKD_FULLUSE"));
            }
            items = cdkPo.getItems();
            codeStr = code.getCode();


            WNBag wnBag = player.getWnBag();
            int itemsize = items.size();
            if (itemsize > wnBag.emptyGridNum()) {


                return new PomeloResponse() {
                    protected void write() throws IOException {
                        PlayerHandler.CDKResponse.Builder res = PlayerHandler.CDKResponse.newBuilder();
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("背包已满，请先清理背包"));
                        this.body.writeBytes(res.build().toByteArray());
                    }
                };
            }


            code.setUseNum(code.getUseNum() + 1);

            if (cdkPo.getCdkType() == 0) {
                code.useCdk(new Date(), player.getId(), cdk.getC2SChannel());
            }
            GlobalDao.hset(ConstsTR.CDK.value, cdkPo.getCode(), Utils.serialize(cdkPo));
        } finally {

            delCDKLock();
        }


        return afterOperatorCDK(player, cdk, cdksUsePo, items, codeStr);
    }


    private boolean canOperatorCDK() {
        long flag = GlobalDao.setnx(ConstsTR.CDK_LOCK.value, "1");
        GlobalDao.expire(ConstsTR.CDK_LOCK.value, 60000);
        boolean isSuccess = (flag > 0L);
        return isSuccess;
    }

    public PomeloResponse afterOperatorCDK(WNPlayer player, PlayerHandler.CDKRequest cdk, CdksUsePO cdksUsePo, List<CdkItem> items, String codeStr) {
        cdksUsePo.listCdk.add(new CdksUsePO.CdkUse(codeStr, new Date(), cdk.getC2SChannel()));
        GCache.hset("player_use_cdk", player.getId(), Utils.serialize(cdksUsePo));
        List<PlayerItemPO> notAddItems = new ArrayList<>();


        for (CdkItem i : items) {
            player.bag.addCodeItem(i.itemId, i.num, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.CDK);
        }


        BILogService.getInstance().recordNum(player, Const.BiLogType.Gift, 1L, Const.GOODS_CHANGE_TYPE.CDK);

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.CDKResponse.Builder res = PlayerHandler.CDKResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    private void delCDKLock() {
        GlobalDao.remove(ConstsTR.CDK_LOCK.value);
    }

    private int getCDKUseCount(CdksUsePO cdksUsePo, String code) {
        int useCount = 0;
        for (CdksUsePO.CdkUse p : cdksUsePo.listCdk) {
            if (p.cdk.startsWith(code)) {
                useCount++;
            }
        }
        return useCount;
    }

    private CdksUsePO getCdksUsePO(WNPlayer player) {
        CdksUsePO cdksUsePo = player.allBlobData.cdksUserPo;
        if (cdksUsePo == null) {
            String data = GCache.hget("player_use_cdk", player.getId());
            cdksUsePo = StringUtil.isNotEmpty(data) ? (CdksUsePO) Utils.deserialize(data, CdksUsePO.class) : new CdksUsePO();
            player.allBlobData.cdksUserPo = cdksUsePo;
        }
        return cdksUsePo;
    }
}


