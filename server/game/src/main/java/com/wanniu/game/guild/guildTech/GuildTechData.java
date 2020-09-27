package com.wanniu.game.guild.guildTech;

import java.util.HashMap;
import java.util.Map;

public class GuildTechData {
    public String id;

    public static class GuildTechBlob {
        public int level;
        public int buffLevel;
        public int refreshLevel;
        public Map<String, Integer> products = new HashMap<>();
    }


    public GuildTechBlob blobData = new GuildTechBlob();
}


