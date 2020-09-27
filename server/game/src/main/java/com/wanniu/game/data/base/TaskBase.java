package com.wanniu.game.data.base;

public abstract class TaskBase {
    public int iD;
    public String name;
    public int kind;
    public int show;
    public int type;
    public int isFail;
    public int failRelation;
    public int failCondition;
    public int upOrder;
    public int level;
    public int upLimit;
    public int levelLimit;
    public String difficulty;
    public String job;
    public int taskCycle;
    public int beforeRelations;
    public String before;
    public String next;
    public int limitTime;
    public String targetID;
    public String targetName;
    public int quantity;
    public String targetFromID;
    public String sourceRemark;
    public String questTC;
    public int minLevel;
    public int maxLevel;
    public int diff;
    public int openWay;
    public String open;
    public String festivalStart;
    public String festivalEnd;
    public String openTime;
    public String endTime;
    public int count;
    public int finishTimes;
    public int isFastComplete;
    public int fastCompleteCost;
    public int isDouble;
    public int doubleCost;
    public String acceptItem;
    public String beforePrompt;
    public String goToBefore;
    public String des;
    public String prompt;
    public int giveNpc;
    public String giveNpcName;
    public String acceptDialogue;
    public int exp;
    public int upExp;

    public Integer getKey() {
        return Integer.valueOf(this.iD);
    }

    public int expRatio;
    public int gold;
    public String tcReward;
    public String warriorReward;
    public String assassinReward;
    public String magicianReward;
    public String hunterReward;
    public String ministerReward;
    public String rewardName;
    public String soulItem;
    public int startScene;
    public int startPoint;
    public int doScene;
    public int doPoint;
    public int isTransfer;
    public String funID;
    public String taskFunID;
    public String specialTips;
    public int submitScene;
    public int submitPoint;
    public String secretTransfer;
    public String acceptBtn;
    public String rejectBtn;
    public String acceptContent;
    public String goToAccept;
    public String goToComplete;
    public String afterPrompt;
    public String afterPromptBtn;
    public String reward;
    public String rewardBtn;
    public int completeNpc;
    public String completeNpcName;
    public String changePrompt;
    public String acceptSys;
    public String rewardSys;
    public int nPCchat;
    public int showItem;
    public int notEffected;
    public String needNpcID;
    public String needNpcName;
    public int needState;
    public String createPos;
    public int overState;
    public String overPos;
    public int isAuto;
    public String circleOutPOS;
    public int circleDungeonID;
    public int[] loopOutPos;
    public String modID;
    public int overState2;
    public int pro;

    public int getId() {
        return this.iD;
    }

    public int getKind() {
        return this.kind;
    }

    public int getType() {
        return this.type;
    }


    public List<Integer> needNpcs = new ArrayList<>();

    public Map<Integer, List<ItemNode>> rewards = new HashMap<>(0);
    public List<ItemNode> accepTaskRewards = new ArrayList<>(0);
    public String[] beforeTask = new String[0];
    public String[] nextTask = new String[0];
    public List<String> targets = new ArrayList<>();
    public String[] targetFromIds = new String[0];
    public String[] openDay = new String[0];

    public static class ItemNode {
        public String itemCode;
        public int itemNum;
        public int isBind;

        public ItemNode(String itemCode, int itemNum) {
            this.itemCode = itemCode;
            this.itemNum = itemNum;
        }

        public ItemNode(String itemCode, int itemNum, int isBind) {
            this(itemCode, itemNum);
            this.isBind = isBind;
        }
    }

    public final boolean isTarget(String id) {
        if (this.targets != null) {
            for (int i = 0; i < this.targets.size(); i++) {
                if (((String) this.targets.get(i)).equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isTargetFormId(String id) {
        if (this.targetFromIds != null) {
            for (int i = 0; i < this.targetFromIds.length; i++) {
                if (id.equals(this.targetFromIds[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    public void beforeProperty() {
    }

    public void initProperty() {
        this.pro = Const.PlayerPro.Value(this.job);

        this.rewards = new HashMap<>();
        List<ItemNode> nodes = new ArrayList<>();
        nodes.add(new ItemNode("gold", this.gold));
        nodes.add(new ItemNode("exp", this.exp));
        nodes.add(new ItemNode("upexp", this.upExp));
        this.rewards.put(Integer.valueOf(Const.PlayerPro.COMMON.value), nodes);
        this.rewards.put(Integer.valueOf(Const.PlayerPro.CANG_LANG.value), getReward(this.warriorReward));
        this.rewards.put(Integer.valueOf(Const.PlayerPro.YU_JIAN.value), getReward(this.assassinReward));
        this.rewards.put(Integer.valueOf(Const.PlayerPro.YI_XIAN.value), getReward(this.magicianReward));
        this.rewards.put(Integer.valueOf(Const.PlayerPro.SHEN_JIAN.value), getReward(this.hunterReward));
        this.rewards.put(Integer.valueOf(Const.PlayerPro.LI_NHU.value), getReward(this.ministerReward));


        this.accepTaskRewards = getReward(this.acceptItem.split(","));

        if (StringUtil.isNotEmpty(this.before)) {
            this.beforeTask = this.before.split(":");
        }
        if (StringUtil.isNotEmpty(this.next)) {
            this.nextTask = this.next.split(":");
        }
        this.targets = Arrays.asList(this.targetID.split(":"));
        this.targetFromIds = this.targetFromID.split(":");

        if (this.quantity <= 0) {
            Out.warn(new Object[]{"策划数据有问题!!! 任务表, id:", Integer.valueOf(this.iD), ",任务目标需求数量:", Integer.valueOf(this.quantity), ",这样会导致任务直接完成!!!!!!"});
        }
        this.openDay = this.open.split(",");


        if (StringUtil.isNotEmpty(this.needNpcID)) {
            String[] npcs = this.needNpcID.split("\\|");
            for (int i = 0; i < npcs.length; i++) {
                this.needNpcs.add(Integer.valueOf(Integer.parseInt(npcs[i])));
            }
        }

        if (StringUtil.isNotEmpty(this.circleOutPOS)) {
            this.loopOutPos = new int[2];
            String[] circlePOSes = this.circleOutPOS.split(",");
            int index = 0;
            for (String pos : circlePOSes) {
                this.loopOutPos[index] = (int) Float.parseFloat(pos);
                index++;
            }
        }
    }

    private List<ItemNode> getReward(String reward) {
        return getReward(reward.split("\\|"));
    }

    private List<ItemNode> getReward(String[] rewards) {
        List<ItemNode> data = new ArrayList<>();
        for (String v : rewards) {
            if (v.trim().length() > 0) {
                String[] str = v.split(":");
                String itemCode = str[0];
                int itemNum = Integer.parseInt(str[1]);
                int isBind = 1;
                if (str.length >= 3) {
                    isBind = Integer.parseInt(str[2]);
                }
                data.add(new ItemNode(itemCode, itemNum, isBind));
            }
        }
        return data;
    }
}


