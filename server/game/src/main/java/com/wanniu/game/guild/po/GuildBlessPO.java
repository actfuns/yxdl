package com.wanniu.game.guild.po;

import com.wanniu.game.guild.guidDepot.GuildRecordData;
import com.wanniu.game.guild.guildTech.GuildTechData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GuildBlessPO {
    public static class GuildBlessItem {
        public int id;
        public int finishNum;
        public int needNum;
    }

    public static class GuildBlessAllBlob {
        public int blessValue;
        public int blessValueMax;
        public ArrayList<GuildRecordData> news = new ArrayList<>();
        public Date refreshTime = new Date(0L);
        public Map<Integer, GuildBlessPO.GuildBlessItem> blessItems = new HashMap<>();
        public int blessLevel;
        public ArrayList<Integer> goods = new ArrayList<>();
        public GuildTechData techData = new GuildTechData();
        public int[] finishStateArr = new int[3];

        public GuildBlessAllBlob() {
            for (int i = 0; i < this.finishStateArr.length; i++) {
                this.finishStateArr[i] = 0;
            }
        }


        public int throwAwardState;
    }


    public String id = "";
    public Date createTime = new Date(0L);
    public GuildBlessAllBlob allBlobData = new GuildBlessAllBlob();
    public List<Map<String, Integer>> gifts = new ArrayList<>();
    public int logicServerId;
    public int level;
}


