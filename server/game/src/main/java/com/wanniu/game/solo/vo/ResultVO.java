package com.wanniu.game.solo.vo;

public class ResultVO {
    private Map<KEY, Integer> otherResult;
    public boolean result;
    public String info;

    public enum KEY {
        HAS_REWARD("hasReward"), AVG_MATCHTIME("avgMatchTime"), START_JOINTIME("startJoinTime");
        private String key;

        KEY(String key) {
            this.key = key;
        }

        public String getValue() {
            return this.key;
        }
    }

    public ResultVO() {
        this(true);
    }

    public ResultVO(boolean defResult) {
        this(defResult, "");
    }

    public ResultVO(boolean defResult, String defInfo) {
        this.result = defResult;
        this.info = defInfo;
        this.otherResult = new HashMap<>();
    }


    public void set(KEY key, Integer value) {
        this.otherResult.put(key, value);
    }

    public Integer get(KEY key) {
        return this.otherResult.get(key);
    }
}


