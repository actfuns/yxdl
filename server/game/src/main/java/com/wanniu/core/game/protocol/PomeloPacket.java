/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Header;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import io.netty.channel.Channel;
/*    */ import io.netty.util.AttributeKey;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PomeloPacket
/*    */   extends Packet
/*    */ {
/* 18 */   public static final AttributeKey<Short> AUTO_INDEX = AttributeKey.valueOf("auto_index");
/* 19 */   public static final AttributeKey<Integer> ERROR_COUNT = AttributeKey.valueOf("error_count");
/*    */   
/*    */   public PomeloPacket(Channel session) {
/* 22 */     this.header = new PomeloHeader();
/* 23 */     this.session = session;
/*    */   }
/*    */   
/*    */   public short getPacketType() {
/* 27 */     return this.header.getType();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PomeloHeader getHeader() {
/* 36 */     return (PomeloHeader)this.header;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 45 */     return this.header.getTypeHexString();
/*    */   }
/*    */   
/*    */   public int getU8() {
/* 49 */     return this.body.readByte() & 0xFF;
/*    */   }
/*    */   
/*    */   public void readyBody() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual getByte : ()B
/*    */     //   4: istore_1
/*    */     //   5: aload_0
/*    */     //   6: invokevirtual getHeader : ()Lcom/wanniu/core/game/protocol/PomeloHeader;
/*    */     //   9: astore_2
/*    */     //   10: aload_2
/*    */     //   11: iload_1
/*    */     //   12: iconst_1
/*    */     //   13: iand
/*    */     //   14: ifeq -> 21
/*    */     //   17: iconst_1
/*    */     //   18: goto -> 22
/*    */     //   21: iconst_0
/*    */     //   22: putfield compressRoute : Z
/*    */     //   25: iload_1
/*    */     //   26: iconst_1
/*    */     //   27: ishr
/*    */     //   28: bipush #7
/*    */     //   30: iand
/*    */     //   31: i2b
/*    */     //   32: istore_3
/*    */     //   33: iconst_0
/*    */     //   34: istore #4
/*    */     //   36: iconst_0
/*    */     //   37: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   40: astore #5
/*    */     //   42: iload_3
/*    */     //   43: invokestatic msgHasId : (B)Z
/*    */     //   46: ifeq -> 309
/*    */     //   49: iconst_0
/*    */     //   50: istore #6
/*    */     //   52: iconst_0
/*    */     //   53: istore #7
/*    */     //   55: iconst_0
/*    */     //   56: istore #8
/*    */     //   58: aload_0
/*    */     //   59: invokevirtual getU8 : ()I
/*    */     //   62: istore #7
/*    */     //   64: iload #6
/*    */     //   66: iload #7
/*    */     //   68: bipush #127
/*    */     //   70: iand
/*    */     //   71: iconst_1
/*    */     //   72: bipush #7
/*    */     //   74: iload #8
/*    */     //   76: imul
/*    */     //   77: ishl
/*    */     //   78: imul
/*    */     //   79: iadd
/*    */     //   80: istore #6
/*    */     //   82: iinc #8, 1
/*    */     //   85: iload #7
/*    */     //   87: sipush #128
/*    */     //   90: if_icmpge -> 58
/*    */     //   93: aload_2
/*    */     //   94: iload #6
/*    */     //   96: i2s
/*    */     //   97: invokevirtual setType : (S)V
/*    */     //   100: aload_0
/*    */     //   101: getfield session : Lio/netty/channel/Channel;
/*    */     //   104: getstatic com/wanniu/core/game/protocol/PomeloPacket.AUTO_INDEX : Lio/netty/util/AttributeKey;
/*    */     //   107: invokeinterface attr : (Lio/netty/util/AttributeKey;)Lio/netty/util/Attribute;
/*    */     //   112: astore #9
/*    */     //   114: aload #9
/*    */     //   116: invokeinterface get : ()Ljava/lang/Object;
/*    */     //   121: checkcast java/lang/Short
/*    */     //   124: astore #10
/*    */     //   126: aload #10
/*    */     //   128: ifnull -> 156
/*    */     //   131: aload #10
/*    */     //   133: invokevirtual shortValue : ()S
/*    */     //   136: aload_2
/*    */     //   137: invokevirtual getType : ()S
/*    */     //   140: iconst_1
/*    */     //   141: isub
/*    */     //   142: if_icmpeq -> 156
/*    */     //   145: aload #10
/*    */     //   147: invokevirtual shortValue : ()S
/*    */     //   150: sipush #32767
/*    */     //   153: if_icmpne -> 173
/*    */     //   156: aload #9
/*    */     //   158: aload_2
/*    */     //   159: invokevirtual getType : ()S
/*    */     //   162: invokestatic valueOf : (S)Ljava/lang/Short;
/*    */     //   165: invokeinterface set : (Ljava/lang/Object;)V
/*    */     //   170: goto -> 309
/*    */     //   173: bipush #8
/*    */     //   175: anewarray java/lang/Object
/*    */     //   178: dup
/*    */     //   179: iconst_0
/*    */     //   180: ldc '复制封包 autoIndex:'
/*    */     //   182: aastore
/*    */     //   183: dup
/*    */     //   184: iconst_1
/*    */     //   185: aload #10
/*    */     //   187: aastore
/*    */     //   188: dup
/*    */     //   189: iconst_2
/*    */     //   190: ldc ' header:'
/*    */     //   192: aastore
/*    */     //   193: dup
/*    */     //   194: iconst_3
/*    */     //   195: aload_2
/*    */     //   196: invokevirtual getType : ()S
/*    */     //   199: invokestatic valueOf : (S)Ljava/lang/Short;
/*    */     //   202: aastore
/*    */     //   203: dup
/*    */     //   204: iconst_4
/*    */     //   205: ldc ' Id:'
/*    */     //   207: aastore
/*    */     //   208: dup
/*    */     //   209: iconst_5
/*    */     //   210: aload_0
/*    */     //   211: invokevirtual getPlayer : ()Lcom/wanniu/core/game/entity/GPlayer;
/*    */     //   214: invokevirtual getId : ()Ljava/lang/String;
/*    */     //   217: aastore
/*    */     //   218: dup
/*    */     //   219: bipush #6
/*    */     //   221: ldc ' Name:'
/*    */     //   223: aastore
/*    */     //   224: dup
/*    */     //   225: bipush #7
/*    */     //   227: aload_0
/*    */     //   228: invokevirtual getPlayer : ()Lcom/wanniu/core/game/entity/GPlayer;
/*    */     //   231: invokevirtual getName : ()Ljava/lang/String;
/*    */     //   234: aastore
/*    */     //   235: invokestatic error : ([Ljava/lang/Object;)V
/*    */     //   238: aload_0
/*    */     //   239: getfield session : Lio/netty/channel/Channel;
/*    */     //   242: getstatic com/wanniu/core/game/protocol/PomeloPacket.ERROR_COUNT : Lio/netty/util/AttributeKey;
/*    */     //   245: invokeinterface attr : (Lio/netty/util/AttributeKey;)Lio/netty/util/Attribute;
/*    */     //   250: astore #11
/*    */     //   252: aload #11
/*    */     //   254: invokeinterface get : ()Ljava/lang/Object;
/*    */     //   259: checkcast java/lang/Integer
/*    */     //   262: astore #5
/*    */     //   264: aload #5
/*    */     //   266: ifnonnull -> 289
/*    */     //   269: iconst_1
/*    */     //   270: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   273: astore #5
/*    */     //   275: aload #11
/*    */     //   277: iconst_1
/*    */     //   278: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   281: invokeinterface set : (Ljava/lang/Object;)V
/*    */     //   286: goto -> 309
/*    */     //   289: aload #11
/*    */     //   291: aload #5
/*    */     //   293: invokevirtual intValue : ()I
/*    */     //   296: iconst_1
/*    */     //   297: iadd
/*    */     //   298: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   301: invokeinterface set : (Ljava/lang/Object;)V
/*    */     //   306: iconst_1
/*    */     //   307: istore #4
/*    */     //   309: iload_3
/*    */     //   310: invokestatic msgHasRoute : (I)Z
/*    */     //   313: ifeq -> 370
/*    */     //   316: aload_2
/*    */     //   317: getfield compressRoute : Z
/*    */     //   320: ifeq -> 343
/*    */     //   323: aload_2
/*    */     //   324: aload_0
/*    */     //   325: invokevirtual getU8 : ()I
/*    */     //   328: bipush #8
/*    */     //   330: ishl
/*    */     //   331: aload_0
/*    */     //   332: invokevirtual getU8 : ()I
/*    */     //   335: ior
/*    */     //   336: i2s
/*    */     //   337: putfield route_n : S
/*    */     //   340: goto -> 370
/*    */     //   343: aload_0
/*    */     //   344: invokevirtual getU8 : ()I
/*    */     //   347: istore #6
/*    */     //   349: iload #6
/*    */     //   351: newarray byte
/*    */     //   353: astore #7
/*    */     //   355: aload_0
/*    */     //   356: aload #7
/*    */     //   358: invokevirtual getBytes : ([B)V
/*    */     //   361: aload_2
/*    */     //   362: aload #7
/*    */     //   364: invokestatic strdecode : ([B)Ljava/lang/String;
/*    */     //   367: putfield route_s : Ljava/lang/String;
/*    */     //   370: iload #4
/*    */     //   372: ifeq -> 388
/*    */     //   375: invokestatic getInstance : ()Lcom/wanniu/core/GGame;
/*    */     //   378: aload_0
/*    */     //   379: invokevirtual getPlayer : ()Lcom/wanniu/core/game/entity/GPlayer;
/*    */     //   382: aload #5
/*    */     //   384: aload_2
/*    */     //   385: invokevirtual handleCopyPacket : (Lcom/wanniu/core/game/entity/GPlayer;Ljava/lang/Integer;Lcom/wanniu/core/game/protocol/PomeloHeader;)V
/*    */     //   388: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #53	-> 0
/*    */     //   #54	-> 5
/*    */     //   #55	-> 10
/*    */     //   #56	-> 25
/*    */     //   #58	-> 33
/*    */     //   #59	-> 36
/*    */     //   #61	-> 42
/*    */     //   #62	-> 49
/*    */     //   #63	-> 52
/*    */     //   #64	-> 55
/*    */     //   #66	-> 58
/*    */     //   #67	-> 64
/*    */     //   #68	-> 82
/*    */     //   #69	-> 85
/*    */     //   #70	-> 93
/*    */     //   #73	-> 100
/*    */     //   #74	-> 114
/*    */     //   #75	-> 126
/*    */     //   #76	-> 156
/*    */     //   #78	-> 173
/*    */     //   #79	-> 238
/*    */     //   #80	-> 252
/*    */     //   #81	-> 264
/*    */     //   #82	-> 269
/*    */     //   #83	-> 275
/*    */     //   #85	-> 289
/*    */     //   #86	-> 306
/*    */     //   #90	-> 309
/*    */     //   #91	-> 316
/*    */     //   #92	-> 323
/*    */     //   #94	-> 343
/*    */     //   #95	-> 349
/*    */     //   #96	-> 355
/*    */     //   #97	-> 361
/*    */     //   #102	-> 370
/*    */     //   #103	-> 375
/*    */     //   #105	-> 388
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   252	57	11	errorAttr	Lio/netty/util/Attribute;
/*    */     //   52	257	6	id	I
/*    */     //   55	254	7	m	I
/*    */     //   58	251	8	i	I
/*    */     //   114	195	9	attr	Lio/netty/util/Attribute;
/*    */     //   126	183	10	autoIndex	Ljava/lang/Short;
/*    */     //   349	21	6	routeLen	I
/*    */     //   355	15	7	dst	[B
/*    */     //   0	389	0	this	Lcom/wanniu/core/game/protocol/PomeloPacket;
/*    */     //   5	384	1	flag	B
/*    */     //   10	379	2	header	Lcom/wanniu/core/game/protocol/PomeloHeader;
/*    */     //   33	356	3	type	B
/*    */     //   36	353	4	copy	Z
/*    */     //   42	347	5	count	Ljava/lang/Integer;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   252	57	11	errorAttr	Lio/netty/util/Attribute<Ljava/lang/Integer;>;
/*    */     //   114	195	9	attr	Lio/netty/util/Attribute<Ljava/lang/Short;>;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\protocol\PomeloPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */