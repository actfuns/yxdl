/*     */ package com.wanniu.game.player;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.protocol.Body;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.achievement.AchievementManager;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaData;
/*     */ import com.wanniu.game.bag.WNBag;
/*     */ import com.wanniu.game.buffer.BufferManager;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.common.msg.MessagePush;
/*     */ import com.wanniu.game.daily.DailyActivityMgr;
/*     */ import com.wanniu.game.illusion.IllusionManager;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.message.MessageData;
/*     */ import com.wanniu.game.petNew.PetNew;
/*     */ import com.wanniu.game.poes.IllusionPO;
/*     */ import com.wanniu.game.poes.PetNewPO;
/*     */ import com.wanniu.game.poes.PlayerAttachPO;
/*     */ import com.wanniu.game.poes.VipPO;
/*     */ import com.wanniu.game.poes.XianYuanPO;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.vip.VipManager;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class WNProxy
/*     */   extends WNPlayer
/*     */ {
/*     */   public String playerId;
/*     */   public String name;
/*     */   public int sid;
/*     */   public int level;
/*     */   public int pro;
/*     */   public int guildExdExp;
/*     */   public int guildExdGold;
/*     */   public int btlExdGold;
/*     */   public PetNew pet;
/*     */   public float vipExpRatio;
/*     */   public float vipGoldRatio;
/*     */   public boolean robot;
/*     */   public XianYuanPO xianYuan;
/*     */   
/*     */   class BufferManagerProxy
/*     */     extends BufferManager {
/*     */     public int getBuffAttrValue(String key) {
/*  55 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   class IllusionManagerProxy
/*     */     extends IllusionManager
/*     */   {
/*     */     public IllusionManagerProxy(WNPlayer player, IllusionPO illusionPO) {
/*  63 */       super(player, illusionPO);
/*     */     }
/*     */     
/*     */     public int addAward(String code, int value) {
/*  67 */       WNProxy.this.onProxyEvent(4, body -> {
/*     */             body.writeString(code);
/*     */             body.writeInt(value);
/*     */           });
/*  71 */       return value;
/*     */     }
/*     */   }
/*     */   
/*     */   class VipManagerProxy
/*     */     extends VipManager
/*     */   {
/*     */     public VipManagerProxy(WNPlayer player, VipPO po) {
/*  79 */       super(player, po);
/*     */     }
/*     */     
/*     */     public float getVipExpRatio() {
/*  83 */       return WNProxy.this.vipExpRatio;
/*     */     }
/*     */     
/*     */     public float getExtGoldRatio() {
/*  87 */       return WNProxy.this.vipGoldRatio;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class WNBagProxy
/*     */     extends WNBag
/*     */   {
/*     */     public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes) {
/*  99 */       WNProxy.this.onProxyEvent(2, body -> {
/*     */             body.writeInt(fromDes.value);
/*     */             body.writeString(Utils.serialize(item.itemDb));
/*     */           });
/*     */     }
/*     */     
/*     */     public boolean addCodeItemMail(String itemCode, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
/* 106 */       WNProxy.this.onProxyEvent(14, body -> {
/*     */             body.writeString(itemCode);
/*     */             body.writeInt(number);
/*     */             body.writeInt((forceType == null) ? 0 : forceType.getValue());
/*     */             body.writeInt((fromDes == null) ? 0 : fromDes.getValue());
/*     */             body.writeString(mailKey);
/*     */           });
/* 113 */       return true;
/*     */     }
/*     */     
/*     */     public boolean testAddCodeItem(String itemCode, int itemNum) {
/* 117 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class PetNewProxy
/*     */     extends PetNew
/*     */   {
/*     */     public PetNewProxy(WNPlayer master, PetNewPO po) {
/* 125 */       super(po, master);
/*     */     }
/*     */     
/*     */     public int addExp(int exp, boolean synchBattleServer) {
/* 129 */       WNProxy.this.onProxyEvent(5, body -> body.writeInt(exp));
/*     */ 
/*     */       
/* 132 */       return exp;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class AchievementManagerProxy
/*     */     extends AchievementManager
/*     */   {
/*     */     public void onPassedDungeon(int id) {
/* 144 */       WNProxy.this.onProxyEvent(8, body -> body.writeInt(id));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class DailyActivityMgrProxy
/*     */     extends DailyActivityMgr
/*     */   {
/*     */     public void onEvent(Const.DailyType type, String target, int num) {
/* 158 */       WNProxy.this.onProxyEvent(9, body -> {
/*     */             body.writeString(type.toString());
/*     */             body.writeString(target);
/*     */             body.writeInt(num);
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class PlayerAttachPOProxy
/*     */     extends PlayerAttachPO
/*     */   {
/*     */     public void addFirstMonsterId(int monsterId) {
/* 171 */       WNProxy.this.onProxyEvent(6, body -> body.writeInt(monsterId));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WNProxy(String playerId, int sid) {
/* 179 */     this.playerId = playerId;
/* 180 */     this.sid = sid;
/* 181 */     this.bag = new WNBagProxy();
/* 182 */     this.dailyActivityMgr = new DailyActivityMgrProxy();
/* 183 */     this.achievementManager = new AchievementManagerProxy();
/* 184 */     this.bufferManager = new BufferManagerProxy();
/*     */   }
/*     */   
/*     */   public void from(Packet pak) {
/* 188 */     this.robot = pak.getBoolean();
/* 189 */     this.vipExpRatio = pak.getFloat();
/* 190 */     this.guildExdExp = pak.getInt();
/* 191 */     this.guildExdGold = pak.getInt();
/* 192 */     this.btlExdGold = pak.getInt();
/* 193 */     this.playerAttachPO = new PlayerAttachPOProxy();
/* 194 */     String petPo = pak.getString();
/* 195 */     String illusionPO = pak.getString();
/* 196 */     String vipPO = pak.getString();
/* 197 */     String xianYuan = pak.getString();
/* 198 */     int count = pak.getShort();
/* 199 */     this.playerAttachPO.firstKillMonsterIds = new ArrayList(count);
/* 200 */     for (int i = 0; i < count; i++) {
/* 201 */       this.playerAttachPO.firstKillMonsterIds.add(Integer.valueOf(pak.getInt()));
/*     */     }
/* 203 */     if (StringUtil.isNotEmpty(petPo)) {
/* 204 */       this.pet = new PetNewProxy(this, (PetNewPO)JSON.parseObject(petPo, PetNewPO.class));
/*     */     }
/* 206 */     this.illusionManager = new IllusionManagerProxy(this, (IllusionPO)JSON.parseObject(illusionPO, IllusionPO.class));
/* 207 */     this.vipManager = new VipManagerProxy(this, (VipPO)JSON.parseObject(vipPO, VipPO.class));
/* 208 */     if (StringUtil.isNotEmpty(xianYuan)) {
/* 209 */       this.xianYuan = (XianYuanPO)Utils.deserialize(xianYuan, XianYuanPO.class);
/*     */     }
/*     */     
/* 212 */     Out.info(new Object[] { "set proxy data." });
/*     */   }
/*     */ 
/*     */   
/*     */   public WNBag getWnBag() {
/* 217 */     return this.bag;
/*     */   }
/*     */   
/*     */   public boolean isRemote() {
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isProxy() {
/* 225 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isRobot() {
/* 229 */     return this.robot;
/*     */   }
/*     */   
/*     */   public void changeArea(final AreaData areaData) {
/* 233 */     Out.debug(new Object[] { "proxy change area : ", areaData });
/* 234 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/* 237 */             this.body.writeString(WNProxy.this.playerId);
/* 238 */             this.body.writeInt(areaData.areaId);
/* 239 */             this.body.writeString(areaData.instanceId);
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/* 244 */             return 1266;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/* 251 */     return this.playerId;
/*     */   }
/*     */   
/*     */   public int getSid() {
/* 255 */     return this.sid;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 259 */     return this.name;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/* 263 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getPro() {
/* 267 */     return this.pro;
/*     */   }
/*     */ 
/*     */   
/*     */   public void sync() {
/* 272 */     Out.info(new Object[] { "proxy sync................" });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onMessage(int operate, MessageData message) {
/* 277 */     Out.info(new Object[] { "proxy onMessage................", Integer.valueOf(message.messageType) });
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 283 */     Out.warn(new Object[] { "proxy update................" });
/*     */   }
/*     */   
/*     */   public void free() {
/* 287 */     free(false);
/*     */   }
/*     */   
/*     */   public void free(boolean keepObject) {
/* 291 */     Out.info(new Object[] { "free proxy >> ", getName(), " - ", Boolean.valueOf(keepObject) });
/* 292 */     if (!keepObject) {
/* 293 */       GWorld.Proxys.remove(this.playerId);
/*     */     }
/* 295 */     Area area = getArea();
/* 296 */     if (area != null) {
/* 297 */       area.removePlayer(this, keepObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void receive(Message msg) {
/* 303 */     processMessage(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Message msg) {
/* 308 */     processMessage(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void receive(String route, GeneratedMessage msg) {
/* 313 */     processMessage((Message)new MessagePush(route, msg));
/*     */   }
/*     */   
/*     */   private void processMessage(final Message msg) {
/* 317 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/* 320 */             this.body.writeString(WNProxy.this.playerId);
/* 321 */             this.body.writeBuffer(msg.getContent());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/* 326 */             return 1267;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEvent(TaskEvent event) {
/* 333 */     onProxyEvent(1, body -> {
/*     */           body.writeInt(event.type);
/*     */           body.writeString(Utils.serialize(event.params));
/*     */         });
/*     */   }
/*     */   
/*     */   public PetNew getFightingPet() {
/* 340 */     return this.pet;
/*     */   }
/*     */   
/*     */   public void finishFightLevel(int currHard, int templateID) {
/* 344 */     onProxyEvent(7, body -> {
/*     */           body.writeInt(currHard);
/*     */           body.writeInt(templateID);
/*     */         });
/*     */   }
/*     */   
/*     */   public void onProxyEvent(final int type, final ProxyEventCB cb) {
/* 351 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/* 354 */             this.body.writeString(WNProxy.this.getId());
/* 355 */             this.body.writeByte(type);
/* 356 */             cb.put(this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/* 361 */             return 1026;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public int getGuildExdExp() {
/* 367 */     return this.guildExdExp;
/*     */   }
/*     */   
/*     */   public int getGuildExdGold() {
/* 371 */     return this.guildExdGold;
/*     */   }
/*     */   
/*     */   public int getBtlExdGold() {
/* 375 */     return this.btlExdGold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int processXianYuanGet(int from) {
/* 387 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\player\WNProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */