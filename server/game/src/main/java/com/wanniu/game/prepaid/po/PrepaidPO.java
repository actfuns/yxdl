package com.wanniu.game.prepaid.po;

import com.wanniu.core.game.entity.GEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PrepaidPO
        extends GEntity {
    public String playerId;
    public Map<Integer, Integer> first_buy_record = new HashMap<>();


    public int firstCharge;


    public int total_charge;


    public int total_consume;


    public int dailyChargeDiamond;


    public int dailyPayRmb;


    public List<PrepaidRecord> chargeRecord = new ArrayList<>();
    public Date dailyDate;
}


