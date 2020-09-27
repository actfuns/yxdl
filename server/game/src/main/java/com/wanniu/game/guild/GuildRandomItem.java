package com.wanniu.game.guild;

public class GuildRandomItem {
    public int id;
    public int weight;
    public int minNum;
    public int maxNum;

    public int getPropertyValue(String key) {
        if (key.equals("id"))
            return this.id;
        if (key.equals("weight"))
            return this.weight;
        if (key.equals("minNum"))
            return this.minNum;
        if (key.equals("maxNum")) {
            return this.maxNum;
        }
        return 0;
    }
}


