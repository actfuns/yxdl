package com.wanniu.game.item;


public enum VirtualItemType {
    GOLD("gold", "银两"),
    DIAMOND("diamond", "元宝"),
    CASH("cash", "绑元"),
    EXP("exp", "经验"),
    UPEXP("upexp", "修为"),
    SP("sp", "技能点"),
    PRESTIGE("prestige", "声望"),
    RINGPRES("ringpres", "魔界威望"),
    REMAIN("remain", "计数道具"),
    FRIENDLY("friendly", "友情点"),
    ACHIPOINT("achipoint", "成就点数"),
    SOLOPOINT("solopoint", "单挑积分"),
    GUILDPOINT("guildpoint", "仙盟副本积分"),
    CONSUMEPOINT("consumepoint", "商城积分"),
    WINGEXP("wingexp", "灵气"),
    TREASURESPOINT("treasurespoint", "君王宝藏积分"),
    PEQUIP("pequip", "紫色装备"),
    OEQUIP("oequip", "橙色装备"),
    GEMS("gems", "宝石"),
    VEXP("vexp", "大量经验"),
    FATE("fate", "轩辕值");

    private final String itemcode;
    private final String desc;

    VirtualItemType(String itemcode, String desc) {
        this.itemcode = itemcode;
        this.desc = desc;
    }

    public String getItemcode() {
        return this.itemcode;
    }

    public String getDesc() {
        return this.desc;
    }
}


