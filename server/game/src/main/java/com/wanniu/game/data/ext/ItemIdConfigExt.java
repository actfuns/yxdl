package com.wanniu.game.data.ext;

import com.wanniu.game.data.ItemIdConfigCO;

import java.util.List;


public class ItemIdConfigExt
        extends ItemIdConfigCO {
    private List<OrderRule> orderRules;

    public void initProperty() {
    }

    public static class OrderRule {
        public String orderKey;
        public int orderType;

        public OrderRule(String orderKey, int orderType) {
            this.orderKey = orderKey;
            this.orderType = orderType;
        }
    }


    public String getKey() {
        return super.getKey();
    }
}


