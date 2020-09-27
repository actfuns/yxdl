package com.wanniu.game.redpacket;

import java.util.Date;


public class RedPacketFetchInfo {
    public int num;
    public String fetcherId;
    public String fetcherName;
    public Date fetchDate;

    public RedPacketFetchInfo() {
        this.num = 0;
        this.fetcherId = null;
        this.fetcherName = null;
        this.fetchDate = null;
    }

    public RedPacketFetchInfo(int num) {
        this.num = num;
    }

    public void SetFetcher(String fetcherId, String fetcherName) {
        this.fetcherId = fetcherId;
        this.fetcherName = fetcherName;
        this.fetchDate = new Date();
    }
}


