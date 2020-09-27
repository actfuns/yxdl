package com.wanniu.game.redpacket;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.player.GlobalConfig;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class RedPacket {
    public String id;
    public String providerId;
    public String providerName;
    public String providerGuildId;
    public Date dispatchDate;
    public int totalNum;
    public int count;
    public int fetchType;
    public int benifitType;
    public String msg;
    public List<RedPacketFetchInfo> redPacketFetchInfoList = new LinkedList<>();

    public RedPacket() {
    }

    public RedPacket(String providerId, String providerName, String providerGuildId, int totalNum, int count, int fetchType, int benifitType, String msg) {
        this();
        if (totalNum <= 0 || count <= 0) {
            Out.error(new Object[]{"参数错误！"});

            return;
        }
        this.id = UUID.randomUUID().toString();
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerGuildId = providerGuildId;
        this.dispatchDate = new Date();
        this.totalNum = totalNum;
        this.count = count;

        this.fetchType = fetchType;
        this.benifitType = benifitType;
        this.msg = msg;

        int scale = (benifitType == 0) ? 1 : GlobalConfig.Red_HongbaoRatio;
        int per = totalNum * scale / count;
        int left = totalNum * scale % count;


        int i;


        for (i = 0; i < count; i++) {
            RedPacketFetchInfo redPacketFetchInfo = new RedPacketFetchInfo(per + ((left-- > 0) ? 1 : 0));
            this.redPacketFetchInfoList.add(redPacketFetchInfo);
        }
        for (i = 0; i < count; i++) {
            RedPacketFetchInfo redPacketFetchInfo1 = this.redPacketFetchInfoList.get(i);
            RedPacketFetchInfo redPacketFetchInfo2 = this.redPacketFetchInfoList.get((i + 1) % count);
            int randomValue = RandomUtil.random(per);
            redPacketFetchInfo1.num += randomValue;
            redPacketFetchInfo2.num -= randomValue;
        }
    }
}


