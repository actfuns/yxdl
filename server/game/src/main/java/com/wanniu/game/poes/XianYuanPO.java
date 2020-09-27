package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;
import java.util.Map;

@DBTable("player_xianyuan")
public class XianYuanPO extends GEntity {
    public Map<Integer, Integer> reviceNumbers;

    public int xianYuanNum;

    public int sumXianYuan;

    public Date createTime;

    public Date updateTime;
}


