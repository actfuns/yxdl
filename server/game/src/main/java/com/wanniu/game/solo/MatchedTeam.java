package com.wanniu.game.solo;

import com.wanniu.game.area.Area;
import com.wanniu.game.player.WNPlayer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatchedTeam {
    private Map<String, WNPlayer> members = new ConcurrentHashMap<>(2);
    private Area battleArea = null;

    public MatchedTeam(WNPlayer a, WNPlayer b) {
        this.members.put("A", a);
        this.members.put("B", b);
    }

    public Area getBattleArea() {
        return this.battleArea;
    }

    public void setBattleArea(Area battleArea) {
        this.battleArea = battleArea;
    }

    public Collection<WNPlayer> getAllPlayers() {
        return this.members.values();
    }

    public WNPlayer getPlayerA() {
        return this.members.get("A");
    }

    public WNPlayer getPlayerB() {
        return this.members.get("B");
    }

    public WNPlayer getPlayer(String playerId) {
        return find(playerId);
    }

    public boolean isIn(WNPlayer player) {
        return (find(player.getId()) != null);
    }

    public void remove(String playerId) {
        Iterator<WNPlayer> iter = this.members.values().iterator();
        while (iter.hasNext()) {
            WNPlayer p = iter.next();
            if (p.getId().equals(playerId)) {
                iter.remove();
                return;
            }
        }
    }

    private WNPlayer find(String playerId) {
        for (WNPlayer p : this.members.values()) {
            if (playerId.equals(p.getId())) {
                return p;
            }
        }

        return null;
    }

    public int memberSize() {
        return this.members.size();
    }

    public void clear() {
        this.members.clear();
    }
}


