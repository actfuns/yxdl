package com.wanniu.game.revelry;

import java.util.ArrayList;
import java.util.List;


public class RevelryToday {
    private final String name;
    private final List<RevelryColumn> columns = new ArrayList<>();
    private long timeleft = 2147483647L;

    public RevelryToday(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<RevelryColumn> getColumns() {
        return this.columns;
    }

    public long getTimeleft() {
        return this.timeleft;
    }

    public void setTimeleft(long timeleft) {
        this.timeleft = timeleft;
    }
}


