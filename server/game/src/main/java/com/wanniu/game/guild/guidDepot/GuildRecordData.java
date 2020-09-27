package com.wanniu.game.guild.guidDepot;

import com.wanniu.game.guild.ItemRecordInfo;
import com.wanniu.game.guild.RoleInfo;
import com.wanniu.game.poes.GuildMemberPO;

import java.util.Date;


public class GuildRecordData {
    public int type;

    public static class GuildRecordResult {
        public int v1;
        public String v2;

        public GuildRecordResult() {
            this.v2 = "";
        }

        public GuildRecordResult(int v1, String v2) {
            this.v1 = v1;
            if (null != v2) {
                this.v2 = v2;
            } else {
                this.v2 = "";
            }
        }
    }


    public RoleInfo role1 = new RoleInfo();
    public RoleInfo role2 = new RoleInfo();
    public ItemRecordInfo item = new ItemRecordInfo();
    public GuildRecordResult result = new GuildRecordResult();
    public Date time = new Date();
    public String build;

    public GuildRecordData(int type, GuildMemberPO role1, GuildMemberPO role2) {
        this();
        this.type = type;
        if (null != role1) {
            this.role1.pro = role1.pro;
            this.role1.name = role1.name;
        }

        if (null != role2) {
            this.role2.pro = role2.pro;
            this.role2.name = role2.name;
        }
    }

    public GuildRecordData() {
    }

    public GuildRecordData(int type, GuildMemberPO role1, GuildMemberPO role2, GuildRecordResult result) {
        this();
        this.type = type;
        if (null != role1) {
            this.role1.pro = role1.pro;
            this.role1.name = role1.name;
        }

        if (null != role2) {
            this.role2.pro = role2.pro;
            this.role2.name = role2.name;
        }

        if (null != result)
            this.result = result;
    }
}


