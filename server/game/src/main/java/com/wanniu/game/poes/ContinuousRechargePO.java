package com.wanniu.game.poes;

import java.util.Date;
import java.util.Map;


public class ContinuousRechargePO {
    private Date date;
    private Map<Integer, Integer> state;
    private int day;

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

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}


