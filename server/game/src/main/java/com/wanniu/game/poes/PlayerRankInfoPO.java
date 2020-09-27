package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.guild.GuildServiceCenter;


@DBTable("player_rank_info")
public class PlayerRankInfoPO
        extends GEntity {
    private String id;
    private String name;
    private int pro;
    private int level;
    private int fightPower;
    private int upOrder;
    private int hp;
    private int phy;
    private int mag;
    private int xianyuan;
    private int demonTower;
    private int mountFightPower;
    private int mountSkinId;
    private int petId;
    private String petName;
    private int petFightPower;

    public void setId(String id) {
        this.id = id;
    }

    public String getGuildName() {
        GuildPO guildPO = GuildServiceCenter.getInstance().getGuildByMemberId(this.id);
        if (guildPO != null) {
            return guildPO.name;
        }

        return "";
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPro() {
        return this.pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFightPower() {
        return this.fightPower;
    }

    public void setFightPower(int fightPower) {
        this.fightPower = fightPower;
    }

    public int getUpOrder() {
        return this.upOrder;
    }

    public void setUpOrder(int upOrder) {
        this.upOrder = upOrder;
    }

    public String getId() {
        return this.id;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPhy() {
        return this.phy;
    }

    public void setPhy(int phy) {
        this.phy = phy;
    }

    public int getMag() {
        return this.mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getXianyuan() {
        return this.xianyuan;
    }

    public void setXianyuan(int xianyuan) {
        this.xianyuan = xianyuan;
    }

    public int getDemonTower() {
        return this.demonTower;
    }

    public void setDemonTower(int demonTower) {
        this.demonTower = demonTower;
    }

    public int getMountFightPower() {
        return this.mountFightPower;
    }

    public void setMountFightPower(int mountFightPower) {
        this.mountFightPower = mountFightPower;
    }

    public int getMountSkinId() {
        return this.mountSkinId;
    }

    public void setMountSkinId(int mountSkinId) {
        this.mountSkinId = mountSkinId;
    }

    public int getPetId() {
        return this.petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetFightPower() {
        return this.petFightPower;
    }

    public void setPetFightPower(int petFightPower) {
        this.petFightPower = petFightPower;
    }
}


