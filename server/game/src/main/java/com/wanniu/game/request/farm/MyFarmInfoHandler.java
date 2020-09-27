package com.wanniu.game.request.farm;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.data.MiscCO;
import com.wanniu.game.farm.FarmMgr;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.FarmPO;

import java.io.IOException;
import java.util.Date;

import pomelo.farm.Farm;
import pomelo.farm.FarmHandler;


@GClientEvent("farm.farmHandler.myFarmInfoRequest")
public class MyFarmInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FarmHandler.MyFarmInfoRequest msg = FarmHandler.MyFarmInfoRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                FarmHandler.MyFarmInfoResponse.Builder res = FarmHandler.MyFarmInfoResponse.newBuilder();
                FarmMgr farmMgr = player.getFarmMgr();
                FarmPO farmPO = farmMgr.myPO;


                Farm.PlayerInfo.Builder playerInfoBuilder = Farm.PlayerInfo.newBuilder();


                playerInfoBuilder.setPlayerId(player.getId());


                Farm.PlayerSummary.Builder playerSummaryBuilder = Farm.PlayerSummary.newBuilder();
                playerSummaryBuilder.setPlayerId(player.getId());
                playerSummaryBuilder.setRoleName(player.getName());
                playerSummaryBuilder.setLv(player.getLevel());
                playerSummaryBuilder.setFarmLv(farmPO.lv);
                playerSummaryBuilder.setCanSow(farmMgr.getPlayerCultivatable(player.getId()));
                playerSummaryBuilder.setCanSteal(farmMgr.getPlayerStealable(player.getId()));
                playerInfoBuilder.setPlayerSummary(playerSummaryBuilder.build());


                for (FarmMgr.Block farmMgrBlock : farmPO.blockMap.values()) {
                    Farm.Block.Builder blockBuilder = Farm.Block.newBuilder();
                    blockBuilder.setBlockId(farmMgrBlock.blockId);
                    blockBuilder.setBlockState(farmMgrBlock.blockState.value);
                    blockBuilder.setSeedCode(farmMgrBlock.seedCode);
                    blockBuilder.setSeedState(farmMgrBlock.seedState.value);
                    blockBuilder.setCultivateType(farmMgrBlock.cultivateType.value);
                    blockBuilder.setHarvestTime(FarmMgr.evaluateHarvestTime(farmPO.playerId, farmMgrBlock.blockId).getTime());
                    Date protectionEndTime = FarmMgr.getProtectEndTime(farmPO.playerId, farmMgrBlock.blockId);
                    if (protectionEndTime != null)
                        blockBuilder.setProtectEndTime(protectionEndTime.getTime());
                    playerInfoBuilder.addBlockLs(blockBuilder.build());
                }


                Farm.PlayerInfo playerInfo = playerInfoBuilder.build();
                res.setPlayerInfo(playerInfo);


                for (MiscCO miscCO : ItemConfig.seedMiscMap.values()) {

                    int seedNum = player.bag.findItemNumByCode(miscCO.code);
                    Farm.Seed.Builder seedBuilder = Farm.Seed.newBuilder();
                    seedBuilder.setSeedCode(miscCO.code);
                    seedBuilder.setNum(seedNum);

                    Farm.Seed handlerSeed = seedBuilder.build();

                    res.addSeedLs(handlerSeed);
                }


                for (MiscCO miscCO : ItemConfig.productMiscMap.values()) {
                    int seedNum = player.bag.findItemNumByCode(miscCO.code);

                    Farm.Product.Builder productBuilder = Farm.Product.newBuilder();
                    productBuilder.setProductCode(miscCO.code);
                    productBuilder.setNum(seedNum);

                    Farm.Product handlerProduct = productBuilder.build();

                    res.addProductLs(handlerProduct);
                }


                res.setExp(farmPO.exp);


                for (FarmMgr.RecordInfo recordInfo : farmPO.recordLs) {
                    Farm.RecordInfo.Builder recordInfoBuilder = Farm.RecordInfo.newBuilder();
                    recordInfoBuilder.setRecordTimeStamp(recordInfo.recordTime.getTime());
                    recordInfoBuilder.setRecordType(recordInfo.recordType.value);
                    for (String recordParam : recordInfo.recordParams) {
                        recordInfoBuilder.addRecordParams(recordParam);
                    }
                    res.addRecordInfoLs(recordInfoBuilder.build());
                }

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


