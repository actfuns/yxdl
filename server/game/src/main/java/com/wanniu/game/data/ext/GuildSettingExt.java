package com.wanniu.game.data.ext;

import com.wanniu.core.util.StringUtil;
import com.wanniu.game.data.GuildSettingCO;


public class GuildSettingExt
        extends GuildSettingCO {
    public long selfOutMs;
    public long kickOutMs;
    public long fireOutMs;
    public long impeachMs;
    public long impeachTimeMs;
    public int guildBossBeginHours;
    public int guildBossBeginMinutes;
    public int guildBossEndHours;
    public int guildBossEndMinutes;

    public void initProperty() {
        this.selfOutMs = (this.selfOut * 60 * 1000);
        this.kickOutMs = (this.kickOut * 60 * 1000);
        this.fireOutMs = (this.fireOut * 60 * 1000);
        this.impeachMs = (this.impeach * 24 * 60 * 60 * 1000);
        this.impeachTimeMs = (this.impeachTime * 60 * 1000);

        if (!StringUtil.isEmpty(this.gBossOpenTime)) {
            String[] beginStrs = this.gBossOpenTime.split(":");
            this.guildBossBeginHours = Integer.parseInt(beginStrs[0]);
            this.guildBossBeginMinutes = Integer.parseInt(beginStrs[1]);
        }

        if (!StringUtil.isEmpty(this.gBossCloseTime)) {
            String[] endStrs = this.gBossCloseTime.split(":");
            this.guildBossEndHours = Integer.parseInt(endStrs[0]);
            this.guildBossEndMinutes = Integer.parseInt(endStrs[1]);
        }
    }
}


