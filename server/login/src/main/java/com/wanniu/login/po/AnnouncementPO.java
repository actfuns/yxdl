package com.wanniu.login.po;

import java.util.UUID;


public class AnnouncementPO {
    public String id = UUID.randomUUID().toString();

    public String name;

    public String orgContent;

    public String content;
    public boolean isUse;

    public AnnouncementPO() {
    }

    public AnnouncementPO(String name, String orgContent, String content, boolean isUse) {
        this.name = name;
        this.orgContent = orgContent;
        this.content = content;
        this.isUse = isUse;
    }
}


