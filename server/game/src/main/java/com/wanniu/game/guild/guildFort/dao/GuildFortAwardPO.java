package com.wanniu.game.guild.guildFort.dao;

import java.util.HashMap;
import java.util.Map;

public class GuildFortAwardPO {
    public enum AwardFlag {
        NO_AWARD(0),
        HAS_AWARD(1),
        AWARDED(2);
        public int value;

        AwardFlag(int value) {
            this.value = value;
        }
    }

    public Map<Integer, AwardFlag> awardStatus = new HashMap<>();
    public long updateDate = 0L;
}


