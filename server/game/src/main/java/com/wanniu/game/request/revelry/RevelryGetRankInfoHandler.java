package com.wanniu.game.request.revelry;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RevelryCO;
import com.wanniu.game.data.RevelryConfigCO;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.rank.SimpleRankData;
import com.wanniu.game.revelry.RevelryManager;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import pomelo.revelry.ActivityRevelryHandler;


@GClientEvent("revelry.activityRevelryHandler.revelryGetRankInfoRequest")
public class RevelryGetRankInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        ActivityRevelryHandler.RevelryGetRankInfoRequest req = ActivityRevelryHandler.RevelryGetRankInfoRequest.parseFrom(this.pak.getRemaingBytes());

        final RevelryCO template = (RevelryCO) GameData.Revelrys.get(req.getId());
        if (template == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        final List<RevelryConfigCO> configs = GameData.findRevelryConfigs(v -> template.tabID.equals(v.type));

        int maxRank = 1;
        for (RevelryConfigCO co : configs) {
            if (co.parameter1 == co.parameter2 && co.parameter1 > maxRank) {
                maxRank = co.parameter1;
            }
        }

        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime endTime = GWorld.OPEN_SERVER_DATE.plusDays(template.endDays1).atTime(0, 0, 0, 0);
        final boolean isGameOver = now.isAfter(endTime);

        final RankType rankType = RevelryManager.getInstance().toRankType(template.activityKey);
        final Map<Integer, SimpleRankData> rankMap = rankType.getHandler().getSimpleRankData(isGameOver, template.tabID, 0, maxRank);

        return new PomeloResponse() {
            protected void write() throws IOException {
                ActivityRevelryHandler.RevelryGetRankInfoResponse.Builder res = ActivityRevelryHandler.RevelryGetRankInfoResponse.newBuilder();
                res.setRankKey(template.activityKey);

                ActivityRevelryHandler.RevelryRankInfo.Builder selfInfo = null;
                int selfRank = 0;

                for (RevelryConfigCO co : configs) {
                    ActivityRevelryHandler.RevelryConfigInfo.Builder info = ActivityRevelryHandler.RevelryConfigInfo.newBuilder();
                    info.setMinRank(co.parameter1);
                    info.setMaxRank(co.parameter2);

                    buildItem(info, co.item1code, co.num1);
                    buildItem(info, co.item2code, co.num2);
                    buildItem(info, co.item3code, co.num3);
                    buildItem(info, co.item4code, co.num4);


                    if (co.parameter1 == co.parameter2) {
                        SimpleRankData rankData = (SimpleRankData) rankMap.get(Integer.valueOf(co.parameter1));
                        if (rankData != null) {
                            ActivityRevelryHandler.RevelryRankInfo.Builder playerInfo = ActivityRevelryHandler.RevelryRankInfo.newBuilder();

                            rankType.getHandler().buildRevelryRankInfo(playerInfo, rankData);
                            info.setPlayer(playerInfo);

                            if (rankData.getId().equals(player.getId())) {
                                selfInfo = playerInfo;
                                selfRank = rankData.getRank();
                            }
                        }
                    }

                    res.addConfig(info);
                }


                if (selfInfo == null) {
                    SimpleRankData rankData = rankType.getHandler().getSelfRankInfo(isGameOver, template.tabID, player);
                    ActivityRevelryHandler.RevelryRankInfo.Builder playerInfo = ActivityRevelryHandler.RevelryRankInfo.newBuilder();
                    rankType.getHandler().buildRevelryRankInfo(playerInfo, rankData);
                    selfInfo = playerInfo;
                    selfRank = rankData.getRank();
                }

                res.setSelf(selfInfo);
                res.setSelfRank(selfRank);

                res.setTitle(template.icon);

                if (isGameOver) {
                    res.setTimeleft(0);
                } else {
                    res.setTimeleft((int) Duration.between(now, endTime).getSeconds());
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }

            private void buildItem(ActivityRevelryHandler.RevelryConfigInfo.Builder info, String itemcode, int num) {
                if (StringUtils.isNotEmpty(itemcode)) {
                    ActivityRevelryHandler.RevelryAwardInfo.Builder item = ActivityRevelryHandler.RevelryAwardInfo.newBuilder();
                    item.setItemcode(itemcode);
                    item.setItemcount(num);
                    info.addAward(item);
                }
            }
        };
    }
}


