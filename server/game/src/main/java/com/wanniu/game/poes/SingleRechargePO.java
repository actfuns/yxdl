package com.wanniu.game.poes;

import java.util.Date;
import java.util.Map;


public class SingleRechargePO {
    private Date date;
    private Map<Integer, Integer> state;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Integer, Integer> getState() {
        return this.state;
    }

    public void setState(Map<Integer, Integer> state) {
        this.state = state;
    }
}


