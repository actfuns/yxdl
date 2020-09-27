package com.wanniu.game.guild.guildImpeach;

import java.util.ArrayList;
import java.util.Date;


public class GuildImpeachData {
    public String id;
    public int logicServerId;

    public static class Sponsor {
        public String id;
        public int pro;
        public String name;
    }

    public Date logoutTime = new Date(0L);
    public Date createTime = new Date(0L);
    public ArrayList<String> playerIds = new ArrayList<>();
    public Sponsor sponsor = new Sponsor();
}


