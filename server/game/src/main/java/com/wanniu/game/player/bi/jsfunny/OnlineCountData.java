package com.wanniu.game.player.bi.jsfunny;


public class OnlineCountData
        extends AnsycPublisher {
    protected String channel() {
        return "data.OnlineCount";
    }


    public OnlineCountData(int pcount, int rcount) {
        this.data.put("minute", Integer.valueOf(this.now.getHour() * 60 + this.now.getMinute()));
        this.data.put("pcount", Integer.valueOf(pcount));
        this.data.put("rcount", Integer.valueOf(rcount));
    }
}


