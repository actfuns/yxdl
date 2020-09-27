package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;

import java.util.Date;


public class FleeSystemPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String id;
    public Date seasonEndTime = new Date();

    public FleeSystemPO(String logicServerId) {
        this.id = logicServerId;
    }

    public FleeSystemPO() {
    }
}


