package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;

import java.util.Map;

public class RechargeActivityPO extends GEntity {
    public ContinuousRechargePO continuousRecharge;

    public SingleRechargePO singleRecharge;

    public TotalRechargePO totalRecharge;

    public TotalConsumePO totalConsume;

    public Map<Integer, RevelryRechargePO> revelryRecharge;
}


