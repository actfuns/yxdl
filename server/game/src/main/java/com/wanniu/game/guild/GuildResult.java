/*     */ package com.wanniu.game.guild;
/*     */ 
/*     */ import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
/*     */ import com.wanniu.game.guild.guildTech.GuildTechData;
/*     */ import com.wanniu.game.item.po.PlayerItemPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import pomelo.area.GuildHandler;
/*     */ import pomelo.item.ItemOuterClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildResult
/*     */ {
/*     */   public int result;
/*     */   public String des;
/*     */   public GuildResultData data;
/*     */   public String id;
/*     */   public boolean joined;
/*     */   public String memberId;
/*     */   public ItemOuterClass.Grid bagGrid;
/*     */   public String name;
/*     */   public int leftKickNum;
/*     */   public int needLevel;
/*     */   public int isNew;
/*     */   public PlayerItemPO itemData;
/*     */   public int deleteCount;
/*     */   public int addReadFund;
/*     */   public int addRealExp;
/*     */   public GuildDepotCondition newCondition;
/*     */   public GuildTechData techData;
/*     */   public int depositCount;
/*     */   public ArrayList<Integer> goods;
/*     */   public String newNotice;
/*     */   public int state;
/*     */   public String cdInfo;
/*     */   
/*     */   public static abstract class GuildResultData {}
/*     */   
/*     */   public static class UpgradeGuildLvData
/*     */     extends GuildResultData
/*     */   {
/*     */     public int preLevel;
/*     */     public long preExp;
/*     */     public long exp;
/*     */     public int level;
/*     */     public int costExp;
/*     */   }
/*     */   
/*     */   public static class TransferGuildPresidentData
/*     */     extends GuildResultData
/*     */   {
/*  66 */     public String preId = "";
/*  67 */     public String preName = "";
/*  68 */     public String nowId = "";
/*  69 */     public String nowName = "";
/*     */     
/*     */     public int newJob;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class DepotUpgradeLevelData
/*     */     extends GuildResultData
/*     */   {
/*     */     public int costGoldNum;
/*     */     
/*     */     public int newLevel;
/*     */     
/*     */     public long fund;
/*  83 */     public String nowName = "";
/*  84 */     public String id = "";
/*  85 */     public String name = "";
/*     */ 
/*     */     
/*     */     public int preLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PlayerOnlineRefreshGuild
/*     */     extends GuildResultData
/*     */   {
/*     */     public int isInGuild;
/*     */     
/*  98 */     public ArrayList<Integer> goods = new ArrayList<>();
/*  99 */     public GuildTechData techData = new GuildTechData();
/* 100 */     public Date refreshTime = new Date(0L);
/* 101 */     public int[] finishStateArr = new int[3];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int throwAwardState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GuildBlessActionData
/*     */     extends GuildResultData
/*     */   {
/* 116 */     public int[] finishState = new int[3];
/* 117 */     public List<Integer> receiveState = new ArrayList<>();
/* 118 */     public List<Integer> buffIds = new ArrayList<>();
/*     */     public int blessValue;
/*     */     public int id;
/*     */     public int finishNum;
/*     */     public int buffTime;
/*     */     public int blessCount;
/*     */   }
/*     */   
/*     */   public static class GuildGiftAndBuffData
/*     */     extends GuildResultData {
/* 128 */     public Map<String, Integer> itemCode = new HashMap<>();
/* 129 */     public ArrayList<Integer> buffIds = new ArrayList<>();
/* 130 */     public List<Integer> receiveState = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class UpgradeLevel
/*     */     extends GuildResultData
/*     */   {
/*     */     public int level;
/*     */     
/*     */     public int needGold;
/*     */     
/*     */     public long fund;
/*     */     
/* 144 */     public String id = "";
/* 145 */     public String name = "";
/*     */     public int preLevel;
/*     */     public int buffLevel;
/*     */   }
/*     */   
/*     */   public static class JoinGuild
/*     */     extends GuildResultData
/*     */   {
/*     */     public int needUpLevel;
/*     */     public int needLevel;
/* 155 */     public String cdInfo = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class MyGuildMember
/*     */     extends GuildResultData
/*     */   {
/*     */     public int leftKickNum;
/*     */     
/* 164 */     public List<GuildHandler.MemberInfo> list = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public static class GuildExchangeGoods extends GuildResultData {
/*     */     public int id;
/*     */     public int state;
/*     */     public int moneyType;
/*     */     public int condType;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\GuildResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */