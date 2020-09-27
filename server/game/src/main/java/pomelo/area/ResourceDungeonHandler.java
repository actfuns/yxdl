/*      */ package pomelo.area;
/*      */ 
/*      */ import com.google.protobuf.AbstractMessage;
/*      */ import com.google.protobuf.AbstractMessageLite;
/*      */ import com.google.protobuf.AbstractParser;
/*      */ import com.google.protobuf.ByteString;
/*      */ import com.google.protobuf.CodedInputStream;
/*      */ import com.google.protobuf.CodedOutputStream;
/*      */ import com.google.protobuf.Descriptors;
/*      */ import com.google.protobuf.ExtensionRegistry;
/*      */ import com.google.protobuf.ExtensionRegistryLite;
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.google.protobuf.InvalidProtocolBufferException;
/*      */ import com.google.protobuf.Message;
/*      */ import com.google.protobuf.MessageLite;
/*      */ import com.google.protobuf.MessageOrBuilder;
/*      */ import com.google.protobuf.Parser;
/*      */ import com.google.protobuf.RepeatedFieldBuilder;
/*      */ import com.google.protobuf.UnknownFieldSet;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ResourceDungeonHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class ResourceDungeonInfo
/*      */     extends GeneratedMessage
/*      */     implements ResourceDungeonInfoOrBuilder
/*      */   {
/* 1258 */     private static final ResourceDungeonInfo defaultInstance = new ResourceDungeonInfo(true); private final UnknownFieldSet unknownFields; private ResourceDungeonInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ResourceDungeonInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ResourceDungeonInfo getDefaultInstance() { return defaultInstance; } public ResourceDungeonInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ResourceDungeonInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.lastTimes_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.buyTimes_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.canBuyTimes_ = input.readInt32(); break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.awardItems_ = bs; break;case 48: this.bitField0_ |= 0x20; this.canSweep_ = input.readBool(); break;case 56: this.bitField0_ |= 0x40; this.playType_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.enterLevel_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceDungeonInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonInfo.class, Builder.class); } public static Parser<ResourceDungeonInfo> PARSER = (Parser<ResourceDungeonInfo>)new AbstractParser<ResourceDungeonInfo>() { public ResourceDungeonHandler.ResourceDungeonInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ResourceDungeonInfo(input, extensionRegistry); } }
/* 1259 */     ; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; public static final int LASTTIMES_FIELD_NUMBER = 2; private int lastTimes_; public static final int BUYTIMES_FIELD_NUMBER = 3; private int buyTimes_; public static final int CANBUYTIMES_FIELD_NUMBER = 4; private int canBuyTimes_; public static final int AWARDITEMS_FIELD_NUMBER = 5; private Object awardItems_; public static final int CANSWEEP_FIELD_NUMBER = 6; private boolean canSweep_; public static final int PLAYTYPE_FIELD_NUMBER = 7; private int playType_; public static final int ENTERLEVEL_FIELD_NUMBER = 8; private int enterLevel_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ResourceDungeonInfo> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public boolean hasLastTimes() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); } public int getLastTimes() { return this.lastTimes_; } public boolean hasBuyTimes() { return ((this.bitField0_ & 0x4) == 4); }
/*      */     public int getBuyTimes() { return this.buyTimes_; }
/*      */     public boolean hasCanBuyTimes() { return ((this.bitField0_ & 0x8) == 8); }
/*      */     public int getCanBuyTimes() { return this.canBuyTimes_; }
/*      */     public boolean hasAwardItems() { return ((this.bitField0_ & 0x10) == 16); }
/*      */     public String getAwardItems() { Object ref = this.awardItems_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.awardItems_ = s; 
/*      */       return s; }
/*      */     public ByteString getAwardItemsBytes() { Object ref = this.awardItems_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.awardItems_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref; }
/*      */     public boolean hasCanSweep() { return ((this.bitField0_ & 0x20) == 32); }
/*      */     public boolean getCanSweep() { return this.canSweep_; }
/*      */     public boolean hasPlayType() { return ((this.bitField0_ & 0x40) == 64); }
/*      */     public int getPlayType() { return this.playType_; }
/*      */     public boolean hasEnterLevel() { return ((this.bitField0_ & 0x80) == 128); }
/*      */     public int getEnterLevel() { return this.enterLevel_; }
/*      */     private void initFields() { this.dungeonId_ = 0;
/*      */       this.lastTimes_ = 0;
/*      */       this.buyTimes_ = 0;
/*      */       this.canBuyTimes_ = 0;
/*      */       this.awardItems_ = "";
/*      */       this.canSweep_ = false;
/*      */       this.playType_ = 0;
/*      */       this.enterLevel_ = 0; }
/*      */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasDungeonId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasLastTimes()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true; }
/*      */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.dungeonId_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeInt32(2, this.lastTimes_); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(3, this.buyTimes_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeInt32(4, this.canBuyTimes_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeBytes(5, getAwardItemsBytes()); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         output.writeBool(6, this.canSweep_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         output.writeInt32(7, this.playType_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         output.writeInt32(8, this.enterLevel_); 
/*      */       getUnknownFields().writeTo(output); }
/*      */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.dungeonId_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeInt32Size(2, this.lastTimes_); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(3, this.buyTimes_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeInt32Size(4, this.canBuyTimes_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeBytesSize(5, getAwardItemsBytes()); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         size += CodedOutputStream.computeBoolSize(6, this.canSweep_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         size += CodedOutputStream.computeInt32Size(7, this.playType_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         size += CodedOutputStream.computeInt32Size(8, this.enterLevel_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size; }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static ResourceDungeonInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ResourceDungeonInfo)PARSER.parseFrom(data); }
/*      */     public static ResourceDungeonInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceDungeonInfo)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static ResourceDungeonInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ResourceDungeonInfo)PARSER.parseFrom(data); }
/*      */     public static ResourceDungeonInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceDungeonInfo)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static ResourceDungeonInfo parseFrom(InputStream input) throws IOException { return (ResourceDungeonInfo)PARSER.parseFrom(input); }
/*      */     public static ResourceDungeonInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceDungeonInfo)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static ResourceDungeonInfo parseDelimitedFrom(InputStream input) throws IOException { return (ResourceDungeonInfo)PARSER.parseDelimitedFrom(input); }
/*      */     public static ResourceDungeonInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceDungeonInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static ResourceDungeonInfo parseFrom(CodedInputStream input) throws IOException { return (ResourceDungeonInfo)PARSER.parseFrom(input); }
/*      */     public static ResourceDungeonInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceDungeonInfo)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(ResourceDungeonInfo prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*      */       return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ResourceDungeonInfoOrBuilder { private int bitField0_; private int dungeonId_; private int lastTimes_; private int buyTimes_; private int canBuyTimes_; private Object awardItems_; private boolean canSweep_; private int playType_; private int enterLevel_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceDungeonInfo_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ResourceDungeonInfo.class, Builder.class); }
/*      */       private Builder() { this.awardItems_ = "";
/*      */         maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*      */         this.awardItems_ = "";
/*      */         maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ResourceDungeonInfo.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear();
/*      */         this.dungeonId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.lastTimes_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.buyTimes_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.canBuyTimes_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.awardItems_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.canSweep_ = false;
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.playType_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.enterLevel_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceDungeonInfo_descriptor; }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo getDefaultInstanceForType() { return ResourceDungeonHandler.ResourceDungeonInfo.getDefaultInstance(); }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo build() { ResourceDungeonHandler.ResourceDungeonInfo result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result; }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo buildPartial() { ResourceDungeonHandler.ResourceDungeonInfo result = new ResourceDungeonHandler.ResourceDungeonInfo(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.dungeonId_ = this.dungeonId_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.lastTimes_ = this.lastTimes_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.buyTimes_ = this.buyTimes_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.canBuyTimes_ = this.canBuyTimes_;
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.awardItems_ = this.awardItems_;
/*      */         if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x20; 
/*      */         result.canSweep_ = this.canSweep_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x40; 
/*      */         result.playType_ = this.playType_;
/*      */         if ((from_bitField0_ & 0x80) == 128)
/*      */           to_bitField0_ |= 0x80; 
/*      */         result.enterLevel_ = this.enterLevel_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ResourceDungeonInfo)
/*      */           return mergeFrom((ResourceDungeonHandler.ResourceDungeonInfo)other); 
/*      */         super.mergeFrom(other);
/*      */         return this; }
/*      */       public Builder mergeFrom(ResourceDungeonHandler.ResourceDungeonInfo other) { if (other == ResourceDungeonHandler.ResourceDungeonInfo.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasDungeonId())
/*      */           setDungeonId(other.getDungeonId()); 
/*      */         if (other.hasLastTimes())
/*      */           setLastTimes(other.getLastTimes()); 
/*      */         if (other.hasBuyTimes())
/*      */           setBuyTimes(other.getBuyTimes()); 
/*      */         if (other.hasCanBuyTimes())
/*      */           setCanBuyTimes(other.getCanBuyTimes()); 
/*      */         if (other.hasAwardItems()) {
/*      */           this.bitField0_ |= 0x10;
/*      */           this.awardItems_ = other.awardItems_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasCanSweep())
/*      */           setCanSweep(other.getCanSweep()); 
/*      */         if (other.hasPlayType())
/*      */           setPlayType(other.getPlayType()); 
/*      */         if (other.hasEnterLevel())
/*      */           setEnterLevel(other.getEnterLevel()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasDungeonId())
/*      */           return false; 
/*      */         if (!hasLastTimes())
/*      */           return false; 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ResourceDungeonInfo parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ResourceDungeonHandler.ResourceDungeonInfo)ResourceDungeonHandler.ResourceDungeonInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ResourceDungeonHandler.ResourceDungeonInfo)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getDungeonId() { return this.dungeonId_; }
/*      */       public Builder setDungeonId(int value) { this.bitField0_ |= 0x1;
/*      */         this.dungeonId_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.dungeonId_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasLastTimes() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public int getLastTimes() { return this.lastTimes_; }
/*      */       public Builder setLastTimes(int value) { this.bitField0_ |= 0x2;
/*      */         this.lastTimes_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearLastTimes() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.lastTimes_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasBuyTimes() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getBuyTimes() { return this.buyTimes_; }
/*      */       public Builder setBuyTimes(int value) { this.bitField0_ |= 0x4;
/*      */         this.buyTimes_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearBuyTimes() { this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.buyTimes_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasCanBuyTimes() { return ((this.bitField0_ & 0x8) == 8); }
/*      */       public int getCanBuyTimes() { return this.canBuyTimes_; }
/*      */       public Builder setCanBuyTimes(int value) { this.bitField0_ |= 0x8;
/*      */         this.canBuyTimes_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearCanBuyTimes() { this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.canBuyTimes_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasAwardItems() { return ((this.bitField0_ & 0x10) == 16); }
/*      */       public String getAwardItems() { Object ref = this.awardItems_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.awardItems_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref; }
/*      */       public ByteString getAwardItemsBytes() { Object ref = this.awardItems_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.awardItems_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref; }
/*      */       public Builder setAwardItems(String value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x10;
/*      */         this.awardItems_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearAwardItems() { this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.awardItems_ = ResourceDungeonHandler.ResourceDungeonInfo.getDefaultInstance().getAwardItems();
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder setAwardItemsBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x10;
/*      */         this.awardItems_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasCanSweep() { return ((this.bitField0_ & 0x20) == 32); }
/*      */       public boolean getCanSweep() { return this.canSweep_; }
/*      */       public Builder setCanSweep(boolean value) { this.bitField0_ |= 0x20;
/*      */         this.canSweep_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearCanSweep() { this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.canSweep_ = false;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasPlayType() { return ((this.bitField0_ & 0x40) == 64); }
/*      */       public int getPlayType() { return this.playType_; }
/*      */       public Builder setPlayType(int value) { this.bitField0_ |= 0x40;
/*      */         this.playType_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearPlayType() { this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.playType_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasEnterLevel() { return ((this.bitField0_ & 0x80) == 128); }
/*      */       public int getEnterLevel() { return this.enterLevel_; }
/*      */       public Builder setEnterLevel(int value) { this.bitField0_ |= 0x80;
/*      */         this.enterLevel_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearEnterLevel() {
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.enterLevel_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } } }
/* 1579 */   public static final class QueryResourceDugeonInfoRequest extends GeneratedMessage implements QueryResourceDugeonInfoRequestOrBuilder { private static final QueryResourceDugeonInfoRequest defaultInstance = new QueryResourceDugeonInfoRequest(true); private final UnknownFieldSet unknownFields; private QueryResourceDugeonInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryResourceDugeonInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryResourceDugeonInfoRequest getDefaultInstance() { return defaultInstance; } public QueryResourceDugeonInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryResourceDugeonInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryResourceDugeonInfoRequest.class, Builder.class); } public static Parser<QueryResourceDugeonInfoRequest> PARSER = (Parser<QueryResourceDugeonInfoRequest>)new AbstractParser<QueryResourceDugeonInfoRequest>() { public ResourceDungeonHandler.QueryResourceDugeonInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.QueryResourceDugeonInfoRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryResourceDugeonInfoRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QueryResourceDugeonInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(data); } public static QueryResourceDugeonInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryResourceDugeonInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(data); } public static QueryResourceDugeonInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryResourceDugeonInfoRequest parseFrom(InputStream input) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(input); } public static QueryResourceDugeonInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static QueryResourceDugeonInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseDelimitedFrom(input); } public static QueryResourceDugeonInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static QueryResourceDugeonInfoRequest parseFrom(CodedInputStream input) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(input); } public static QueryResourceDugeonInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryResourceDugeonInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(QueryResourceDugeonInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.QueryResourceDugeonInfoRequestOrBuilder {
/* 1580 */       public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.QueryResourceDugeonInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.QueryResourceDugeonInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoRequest_descriptor; } public ResourceDungeonHandler.QueryResourceDugeonInfoRequest getDefaultInstanceForType() { return ResourceDungeonHandler.QueryResourceDugeonInfoRequest.getDefaultInstance(); } public ResourceDungeonHandler.QueryResourceDugeonInfoRequest build() { ResourceDungeonHandler.QueryResourceDugeonInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.QueryResourceDugeonInfoRequest buildPartial() { ResourceDungeonHandler.QueryResourceDugeonInfoRequest result = new ResourceDungeonHandler.QueryResourceDugeonInfoRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.QueryResourceDugeonInfoRequest) return mergeFrom((ResourceDungeonHandler.QueryResourceDugeonInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.QueryResourceDugeonInfoRequest other) { if (other == ResourceDungeonHandler.QueryResourceDugeonInfoRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.QueryResourceDugeonInfoRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.QueryResourceDugeonInfoRequest)ResourceDungeonHandler.QueryResourceDugeonInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.QueryResourceDugeonInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class QueryResourceDugeonInfoResponse
/*      */     extends GeneratedMessage
/*      */     implements QueryResourceDugeonInfoResponseOrBuilder
/*      */   {
/* 2625 */     private static final QueryResourceDugeonInfoResponse defaultInstance = new QueryResourceDugeonInfoResponse(true); private final UnknownFieldSet unknownFields; private QueryResourceDugeonInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryResourceDugeonInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryResourceDugeonInfoResponse getDefaultInstance() { return defaultInstance; } public QueryResourceDugeonInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryResourceDugeonInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.dungeons_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.dungeons_.add(input.readMessage(ResourceDungeonHandler.ResourceDungeonInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.dungeons_ = Collections.unmodifiableList(this.dungeons_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryResourceDugeonInfoResponse.class, Builder.class); } public static Parser<QueryResourceDugeonInfoResponse> PARSER = (Parser<QueryResourceDugeonInfoResponse>)new AbstractParser<QueryResourceDugeonInfoResponse>() { public ResourceDungeonHandler.QueryResourceDugeonInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.QueryResourceDugeonInfoResponse(input, extensionRegistry); } }
/* 2626 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int DUNGEONS_FIELD_NUMBER = 3; private List<ResourceDungeonHandler.ResourceDungeonInfo> dungeons_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryResourceDugeonInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */      public List<ResourceDungeonHandler.ResourceDungeonInfo> getDungeonsList() {
/*      */       return this.dungeons_;
/*      */     } public List<? extends ResourceDungeonHandler.ResourceDungeonInfoOrBuilder> getDungeonsOrBuilderList() {
/*      */       return (List)this.dungeons_;
/*      */     } public int getDungeonsCount() {
/*      */       return this.dungeons_.size();
/*      */     } public ResourceDungeonHandler.ResourceDungeonInfo getDungeons(int index) {
/*      */       return this.dungeons_.get(index);
/*      */     } public ResourceDungeonHandler.ResourceDungeonInfoOrBuilder getDungeonsOrBuilder(int index) {
/*      */       return this.dungeons_.get(index);
/*      */     } private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.dungeons_ = Collections.emptyList();
/*      */     } public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       for (int i = 0; i < getDungeonsCount(); i++) {
/*      */         if (!getDungeons(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     } public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       for (int i = 0; i < this.dungeons_.size(); i++)
/*      */         output.writeMessage(3, (MessageLite)this.dungeons_.get(i)); 
/*      */       getUnknownFields().writeTo(output);
/*      */     } public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       for (int i = 0; i < this.dungeons_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.dungeons_.get(i)); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     } protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(data);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(data);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(InputStream input) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(input);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static QueryResourceDugeonInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseDelimitedFrom(input);
/*      */     } public static QueryResourceDugeonInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(input);
/*      */     } public static QueryResourceDugeonInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryResourceDugeonInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     public static Builder newBuilder(QueryResourceDugeonInfoResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.QueryResourceDugeonInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<ResourceDungeonHandler.ResourceDungeonInfo> dungeons_; private RepeatedFieldBuilder<ResourceDungeonHandler.ResourceDungeonInfo, ResourceDungeonHandler.ResourceDungeonInfo.Builder, ResourceDungeonHandler.ResourceDungeonInfoOrBuilder> dungeonsBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoResponse_descriptor;
/*      */       }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.QueryResourceDugeonInfoResponse.class, Builder.class);
/*      */       }
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.dungeons_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.dungeons_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (ResourceDungeonHandler.QueryResourceDugeonInfoResponse.alwaysUseFieldBuilders)
/*      */           getDungeonsFieldBuilder(); 
/*      */       }
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           this.dungeons_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.dungeonsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return ResourceDungeonHandler.internal_static_pomelo_area_QueryResourceDugeonInfoResponse_descriptor;
/*      */       }
/*      */       public ResourceDungeonHandler.QueryResourceDugeonInfoResponse getDefaultInstanceForType() {
/*      */         return ResourceDungeonHandler.QueryResourceDugeonInfoResponse.getDefaultInstance();
/*      */       }
/*      */       public ResourceDungeonHandler.QueryResourceDugeonInfoResponse build() {
/*      */         ResourceDungeonHandler.QueryResourceDugeonInfoResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       public ResourceDungeonHandler.QueryResourceDugeonInfoResponse buildPartial() {
/*      */         ResourceDungeonHandler.QueryResourceDugeonInfoResponse result = new ResourceDungeonHandler.QueryResourceDugeonInfoResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.dungeons_ = Collections.unmodifiableList(this.dungeons_);
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } 
/*      */           result.dungeons_ = this.dungeons_;
/*      */         } else {
/*      */           result.dungeons_ = this.dungeonsBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ResourceDungeonHandler.QueryResourceDugeonInfoResponse)
/*      */           return mergeFrom((ResourceDungeonHandler.QueryResourceDugeonInfoResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       public Builder mergeFrom(ResourceDungeonHandler.QueryResourceDugeonInfoResponse other) {
/*      */         if (other == ResourceDungeonHandler.QueryResourceDugeonInfoResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           if (!other.dungeons_.isEmpty()) {
/*      */             if (this.dungeons_.isEmpty()) {
/*      */               this.dungeons_ = other.dungeons_;
/*      */               this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureDungeonsIsMutable();
/*      */               this.dungeons_.addAll(other.dungeons_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.dungeons_.isEmpty()) {
/*      */           if (this.dungeonsBuilder_.isEmpty()) {
/*      */             this.dungeonsBuilder_.dispose();
/*      */             this.dungeonsBuilder_ = null;
/*      */             this.dungeons_ = other.dungeons_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */             this.dungeonsBuilder_ = ResourceDungeonHandler.QueryResourceDugeonInfoResponse.alwaysUseFieldBuilders ? getDungeonsFieldBuilder() : null;
/*      */           } else {
/*      */             this.dungeonsBuilder_.addAllMessages(other.dungeons_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         for (int i = 0; i < getDungeonsCount(); i++) {
/*      */           if (!getDungeons(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true;
/*      */       }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ResourceDungeonHandler.QueryResourceDugeonInfoResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ResourceDungeonHandler.QueryResourceDugeonInfoResponse)ResourceDungeonHandler.QueryResourceDugeonInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ResourceDungeonHandler.QueryResourceDugeonInfoResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       public String getS2CMsg() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = ResourceDungeonHandler.QueryResourceDugeonInfoResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       private void ensureDungeonsIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.dungeons_ = new ArrayList<>(this.dungeons_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */       public List<ResourceDungeonHandler.ResourceDungeonInfo> getDungeonsList() {
/*      */         if (this.dungeonsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.dungeons_); 
/*      */         return this.dungeonsBuilder_.getMessageList();
/*      */       }
/*      */       public int getDungeonsCount() {
/*      */         if (this.dungeonsBuilder_ == null)
/*      */           return this.dungeons_.size(); 
/*      */         return this.dungeonsBuilder_.getCount();
/*      */       }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo getDungeons(int index) {
/*      */         if (this.dungeonsBuilder_ == null)
/*      */           return this.dungeons_.get(index); 
/*      */         return (ResourceDungeonHandler.ResourceDungeonInfo)this.dungeonsBuilder_.getMessage(index);
/*      */       }
/*      */       public Builder setDungeons(int index, ResourceDungeonHandler.ResourceDungeonInfo value) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder setDungeons(int index, ResourceDungeonHandler.ResourceDungeonInfo.Builder builderForValue) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addDungeons(ResourceDungeonHandler.ResourceDungeonInfo value) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.addMessage(value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addDungeons(int index, ResourceDungeonHandler.ResourceDungeonInfo value) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addDungeons(ResourceDungeonHandler.ResourceDungeonInfo.Builder builderForValue) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addDungeons(int index, ResourceDungeonHandler.ResourceDungeonInfo.Builder builderForValue) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addAllDungeons(Iterable<? extends ResourceDungeonHandler.ResourceDungeonInfo> values) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           ensureDungeonsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.dungeons_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clearDungeons() {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           this.dungeons_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder removeDungeons(int index) {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           ensureDungeonsIsMutable();
/*      */           this.dungeons_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.dungeonsBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo.Builder getDungeonsBuilder(int index) {
/*      */         return (ResourceDungeonHandler.ResourceDungeonInfo.Builder)getDungeonsFieldBuilder().getBuilder(index);
/*      */       }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfoOrBuilder getDungeonsOrBuilder(int index) {
/*      */         if (this.dungeonsBuilder_ == null)
/*      */           return this.dungeons_.get(index); 
/*      */         return (ResourceDungeonHandler.ResourceDungeonInfoOrBuilder)this.dungeonsBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       public List<? extends ResourceDungeonHandler.ResourceDungeonInfoOrBuilder> getDungeonsOrBuilderList() {
/*      */         if (this.dungeonsBuilder_ != null)
/*      */           return this.dungeonsBuilder_.getMessageOrBuilderList(); 
/*      */         return Collections.unmodifiableList((List)this.dungeons_);
/*      */       }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo.Builder addDungeonsBuilder() {
/*      */         return (ResourceDungeonHandler.ResourceDungeonInfo.Builder)getDungeonsFieldBuilder().addBuilder(ResourceDungeonHandler.ResourceDungeonInfo.getDefaultInstance());
/*      */       }
/*      */       public ResourceDungeonHandler.ResourceDungeonInfo.Builder addDungeonsBuilder(int index) {
/*      */         return (ResourceDungeonHandler.ResourceDungeonInfo.Builder)getDungeonsFieldBuilder().addBuilder(index, ResourceDungeonHandler.ResourceDungeonInfo.getDefaultInstance());
/*      */       }
/*      */       public List<ResourceDungeonHandler.ResourceDungeonInfo.Builder> getDungeonsBuilderList() {
/*      */         return getDungeonsFieldBuilder().getBuilderList();
/*      */       }
/*      */       private RepeatedFieldBuilder<ResourceDungeonHandler.ResourceDungeonInfo, ResourceDungeonHandler.ResourceDungeonInfo.Builder, ResourceDungeonHandler.ResourceDungeonInfoOrBuilder> getDungeonsFieldBuilder() {
/*      */         if (this.dungeonsBuilder_ == null) {
/*      */           this.dungeonsBuilder_ = new RepeatedFieldBuilder(this.dungeons_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.dungeons_ = null;
/*      */         } 
/*      */         return this.dungeonsBuilder_;
/*      */       } } }
/* 3070 */   public static final class BuyTimesRequest extends GeneratedMessage implements BuyTimesRequestOrBuilder { private static final BuyTimesRequest defaultInstance = new BuyTimesRequest(true); private final UnknownFieldSet unknownFields; private BuyTimesRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private BuyTimesRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static BuyTimesRequest getDefaultInstance() { return defaultInstance; } public BuyTimesRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private BuyTimesRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyTimesRequest.class, Builder.class); } public static Parser<BuyTimesRequest> PARSER = (Parser<BuyTimesRequest>)new AbstractParser<BuyTimesRequest>() { public ResourceDungeonHandler.BuyTimesRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.BuyTimesRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<BuyTimesRequest> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } private void initFields() { this.dungeonId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDungeonId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.dungeonId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static BuyTimesRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (BuyTimesRequest)PARSER.parseFrom(data); } public static BuyTimesRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (BuyTimesRequest)PARSER.parseFrom(data, extensionRegistry); } public static BuyTimesRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (BuyTimesRequest)PARSER.parseFrom(data); } public static BuyTimesRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (BuyTimesRequest)PARSER.parseFrom(data, extensionRegistry); } public static BuyTimesRequest parseFrom(InputStream input) throws IOException { return (BuyTimesRequest)PARSER.parseFrom(input); } public static BuyTimesRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesRequest)PARSER.parseFrom(input, extensionRegistry); } public static BuyTimesRequest parseDelimitedFrom(InputStream input) throws IOException { return (BuyTimesRequest)PARSER.parseDelimitedFrom(input); } public static BuyTimesRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static BuyTimesRequest parseFrom(CodedInputStream input) throws IOException { return (BuyTimesRequest)PARSER.parseFrom(input); } public static BuyTimesRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(BuyTimesRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.BuyTimesRequestOrBuilder {
/* 3071 */       private int bitField0_; private int dungeonId_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.BuyTimesRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.BuyTimesRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.dungeonId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesRequest_descriptor; } public ResourceDungeonHandler.BuyTimesRequest getDefaultInstanceForType() { return ResourceDungeonHandler.BuyTimesRequest.getDefaultInstance(); } public ResourceDungeonHandler.BuyTimesRequest build() { ResourceDungeonHandler.BuyTimesRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.BuyTimesRequest buildPartial() { ResourceDungeonHandler.BuyTimesRequest result = new ResourceDungeonHandler.BuyTimesRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.dungeonId_ = this.dungeonId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.BuyTimesRequest) return mergeFrom((ResourceDungeonHandler.BuyTimesRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.BuyTimesRequest other) { if (other == ResourceDungeonHandler.BuyTimesRequest.getDefaultInstance()) return this;  if (other.hasDungeonId()) setDungeonId(other.getDungeonId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDungeonId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.BuyTimesRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.BuyTimesRequest)ResourceDungeonHandler.BuyTimesRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.BuyTimesRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public Builder setDungeonId(int value) { this.bitField0_ |= 0x1; this.dungeonId_ = value; onChanged(); return this; } public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE; this.dungeonId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BuyTimesResponse
/*      */     extends GeneratedMessage
/*      */     implements BuyTimesResponseOrBuilder
/*      */   {
/* 3640 */     private static final BuyTimesResponse defaultInstance = new BuyTimesResponse(true); private final UnknownFieldSet unknownFields; private BuyTimesResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private BuyTimesResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static BuyTimesResponse getDefaultInstance() { return defaultInstance; } public BuyTimesResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private BuyTimesResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyTimesResponse.class, Builder.class); } public static Parser<BuyTimesResponse> PARSER = (Parser<BuyTimesResponse>)new AbstractParser<BuyTimesResponse>() { public ResourceDungeonHandler.BuyTimesResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.BuyTimesResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<BuyTimesResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static BuyTimesResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (BuyTimesResponse)PARSER.parseFrom(data); } public static BuyTimesResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (BuyTimesResponse)PARSER.parseFrom(data, extensionRegistry); } public static BuyTimesResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (BuyTimesResponse)PARSER.parseFrom(data); } public static BuyTimesResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (BuyTimesResponse)PARSER.parseFrom(data, extensionRegistry); } public static BuyTimesResponse parseFrom(InputStream input) throws IOException { return (BuyTimesResponse)PARSER.parseFrom(input); } public static BuyTimesResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesResponse)PARSER.parseFrom(input, extensionRegistry); } public static BuyTimesResponse parseDelimitedFrom(InputStream input) throws IOException { return (BuyTimesResponse)PARSER.parseDelimitedFrom(input); } public static BuyTimesResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static BuyTimesResponse parseFrom(CodedInputStream input) throws IOException { return (BuyTimesResponse)PARSER.parseFrom(input); } public static BuyTimesResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (BuyTimesResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(BuyTimesResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.BuyTimesResponseOrBuilder {
/* 3641 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.BuyTimesResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.BuyTimesResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_BuyTimesResponse_descriptor; } public ResourceDungeonHandler.BuyTimesResponse getDefaultInstanceForType() { return ResourceDungeonHandler.BuyTimesResponse.getDefaultInstance(); } public ResourceDungeonHandler.BuyTimesResponse build() { ResourceDungeonHandler.BuyTimesResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.BuyTimesResponse buildPartial() { ResourceDungeonHandler.BuyTimesResponse result = new ResourceDungeonHandler.BuyTimesResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.BuyTimesResponse) return mergeFrom((ResourceDungeonHandler.BuyTimesResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.BuyTimesResponse other) { if (other == ResourceDungeonHandler.BuyTimesResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.BuyTimesResponse parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.BuyTimesResponse)ResourceDungeonHandler.BuyTimesResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.BuyTimesResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ResourceDungeonHandler.BuyTimesResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class EnterResourceDugeonInfoRequest
/*      */     extends GeneratedMessage
/*      */     implements EnterResourceDugeonInfoRequestOrBuilder
/*      */   {
/* 4085 */     private static final EnterResourceDugeonInfoRequest defaultInstance = new EnterResourceDugeonInfoRequest(true); private final UnknownFieldSet unknownFields; private EnterResourceDugeonInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EnterResourceDugeonInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EnterResourceDugeonInfoRequest getDefaultInstance() { return defaultInstance; } public EnterResourceDugeonInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EnterResourceDugeonInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterResourceDugeonInfoRequest.class, Builder.class); } public static Parser<EnterResourceDugeonInfoRequest> PARSER = (Parser<EnterResourceDugeonInfoRequest>)new AbstractParser<EnterResourceDugeonInfoRequest>() { public ResourceDungeonHandler.EnterResourceDugeonInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.EnterResourceDugeonInfoRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EnterResourceDugeonInfoRequest> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } private void initFields() { this.dungeonId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDungeonId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.dungeonId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static EnterResourceDugeonInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(data); } public static EnterResourceDugeonInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static EnterResourceDugeonInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(data); } public static EnterResourceDugeonInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static EnterResourceDugeonInfoRequest parseFrom(InputStream input) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(input); } public static EnterResourceDugeonInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static EnterResourceDugeonInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseDelimitedFrom(input); } public static EnterResourceDugeonInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static EnterResourceDugeonInfoRequest parseFrom(CodedInputStream input) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(input); } public static EnterResourceDugeonInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(EnterResourceDugeonInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.EnterResourceDugeonInfoRequestOrBuilder {
/* 4086 */       private int bitField0_; private int dungeonId_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.EnterResourceDugeonInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.EnterResourceDugeonInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.dungeonId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoRequest_descriptor; } public ResourceDungeonHandler.EnterResourceDugeonInfoRequest getDefaultInstanceForType() { return ResourceDungeonHandler.EnterResourceDugeonInfoRequest.getDefaultInstance(); } public ResourceDungeonHandler.EnterResourceDugeonInfoRequest build() { ResourceDungeonHandler.EnterResourceDugeonInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.EnterResourceDugeonInfoRequest buildPartial() { ResourceDungeonHandler.EnterResourceDugeonInfoRequest result = new ResourceDungeonHandler.EnterResourceDugeonInfoRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.dungeonId_ = this.dungeonId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.EnterResourceDugeonInfoRequest) return mergeFrom((ResourceDungeonHandler.EnterResourceDugeonInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.EnterResourceDugeonInfoRequest other) { if (other == ResourceDungeonHandler.EnterResourceDugeonInfoRequest.getDefaultInstance()) return this;  if (other.hasDungeonId()) setDungeonId(other.getDungeonId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDungeonId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.EnterResourceDugeonInfoRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.EnterResourceDugeonInfoRequest)ResourceDungeonHandler.EnterResourceDugeonInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.EnterResourceDugeonInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public Builder setDungeonId(int value) { this.bitField0_ |= 0x1; this.dungeonId_ = value; onChanged(); return this; } public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE; this.dungeonId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class EnterResourceDugeonInfoResponse
/*      */     extends GeneratedMessage
/*      */     implements EnterResourceDugeonInfoResponseOrBuilder
/*      */   {
/* 4647 */     private static final EnterResourceDugeonInfoResponse defaultInstance = new EnterResourceDugeonInfoResponse(true); private final UnknownFieldSet unknownFields; private EnterResourceDugeonInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EnterResourceDugeonInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EnterResourceDugeonInfoResponse getDefaultInstance() { return defaultInstance; } public EnterResourceDugeonInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EnterResourceDugeonInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterResourceDugeonInfoResponse.class, Builder.class); } public static Parser<EnterResourceDugeonInfoResponse> PARSER = (Parser<EnterResourceDugeonInfoResponse>)new AbstractParser<EnterResourceDugeonInfoResponse>() { public ResourceDungeonHandler.EnterResourceDugeonInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.EnterResourceDugeonInfoResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EnterResourceDugeonInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static EnterResourceDugeonInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(data); } public static EnterResourceDugeonInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(data, extensionRegistry); } public static EnterResourceDugeonInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(data); } public static EnterResourceDugeonInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(data, extensionRegistry); } public static EnterResourceDugeonInfoResponse parseFrom(InputStream input) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(input); } public static EnterResourceDugeonInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(input, extensionRegistry); } public static EnterResourceDugeonInfoResponse parseDelimitedFrom(InputStream input) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseDelimitedFrom(input); } public static EnterResourceDugeonInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static EnterResourceDugeonInfoResponse parseFrom(CodedInputStream input) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(input); } public static EnterResourceDugeonInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterResourceDugeonInfoResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(EnterResourceDugeonInfoResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.EnterResourceDugeonInfoResponseOrBuilder {
/* 4648 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.EnterResourceDugeonInfoResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.EnterResourceDugeonInfoResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_EnterResourceDugeonInfoResponse_descriptor; } public ResourceDungeonHandler.EnterResourceDugeonInfoResponse getDefaultInstanceForType() { return ResourceDungeonHandler.EnterResourceDugeonInfoResponse.getDefaultInstance(); } public ResourceDungeonHandler.EnterResourceDugeonInfoResponse build() { ResourceDungeonHandler.EnterResourceDugeonInfoResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.EnterResourceDugeonInfoResponse buildPartial() { ResourceDungeonHandler.EnterResourceDugeonInfoResponse result = new ResourceDungeonHandler.EnterResourceDugeonInfoResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.EnterResourceDugeonInfoResponse) return mergeFrom((ResourceDungeonHandler.EnterResourceDugeonInfoResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.EnterResourceDugeonInfoResponse other) { if (other == ResourceDungeonHandler.EnterResourceDugeonInfoResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.EnterResourceDugeonInfoResponse parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.EnterResourceDugeonInfoResponse)ResourceDungeonHandler.EnterResourceDugeonInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.EnterResourceDugeonInfoResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ResourceDungeonHandler.EnterResourceDugeonInfoResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ReceiveDoubleRewardRequest
/*      */     extends GeneratedMessage
/*      */     implements ReceiveDoubleRewardRequestOrBuilder
/*      */   {
/* 5092 */     private static final ReceiveDoubleRewardRequest defaultInstance = new ReceiveDoubleRewardRequest(true); private final UnknownFieldSet unknownFields; private ReceiveDoubleRewardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ReceiveDoubleRewardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ReceiveDoubleRewardRequest getDefaultInstance() { return defaultInstance; } public ReceiveDoubleRewardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ReceiveDoubleRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveDoubleRewardRequest.class, Builder.class); } public static Parser<ReceiveDoubleRewardRequest> PARSER = (Parser<ReceiveDoubleRewardRequest>)new AbstractParser<ReceiveDoubleRewardRequest>() { public ResourceDungeonHandler.ReceiveDoubleRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ReceiveDoubleRewardRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ReceiveDoubleRewardRequest> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } private void initFields() { this.dungeonId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDungeonId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.dungeonId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ReceiveDoubleRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(data); } public static ReceiveDoubleRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static ReceiveDoubleRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(data); } public static ReceiveDoubleRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static ReceiveDoubleRewardRequest parseFrom(InputStream input) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(input); } public static ReceiveDoubleRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static ReceiveDoubleRewardRequest parseDelimitedFrom(InputStream input) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseDelimitedFrom(input); } public static ReceiveDoubleRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ReceiveDoubleRewardRequest parseFrom(CodedInputStream input) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(input); } public static ReceiveDoubleRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ReceiveDoubleRewardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ReceiveDoubleRewardRequestOrBuilder {
/* 5093 */       private int bitField0_; private int dungeonId_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ReceiveDoubleRewardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ReceiveDoubleRewardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.dungeonId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardRequest_descriptor; } public ResourceDungeonHandler.ReceiveDoubleRewardRequest getDefaultInstanceForType() { return ResourceDungeonHandler.ReceiveDoubleRewardRequest.getDefaultInstance(); } public ResourceDungeonHandler.ReceiveDoubleRewardRequest build() { ResourceDungeonHandler.ReceiveDoubleRewardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.ReceiveDoubleRewardRequest buildPartial() { ResourceDungeonHandler.ReceiveDoubleRewardRequest result = new ResourceDungeonHandler.ReceiveDoubleRewardRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.dungeonId_ = this.dungeonId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ReceiveDoubleRewardRequest) return mergeFrom((ResourceDungeonHandler.ReceiveDoubleRewardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.ReceiveDoubleRewardRequest other) { if (other == ResourceDungeonHandler.ReceiveDoubleRewardRequest.getDefaultInstance()) return this;  if (other.hasDungeonId()) setDungeonId(other.getDungeonId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDungeonId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ReceiveDoubleRewardRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ReceiveDoubleRewardRequest)ResourceDungeonHandler.ReceiveDoubleRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ReceiveDoubleRewardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public Builder setDungeonId(int value) { this.bitField0_ |= 0x1; this.dungeonId_ = value; onChanged(); return this; } public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE; this.dungeonId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ReceiveDoubleRewardResponse
/*      */     extends GeneratedMessage
/*      */     implements ReceiveDoubleRewardResponseOrBuilder
/*      */   {
/* 5654 */     private static final ReceiveDoubleRewardResponse defaultInstance = new ReceiveDoubleRewardResponse(true); private final UnknownFieldSet unknownFields; private ReceiveDoubleRewardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ReceiveDoubleRewardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ReceiveDoubleRewardResponse getDefaultInstance() { return defaultInstance; } public ReceiveDoubleRewardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ReceiveDoubleRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveDoubleRewardResponse.class, Builder.class); } public static Parser<ReceiveDoubleRewardResponse> PARSER = (Parser<ReceiveDoubleRewardResponse>)new AbstractParser<ReceiveDoubleRewardResponse>() { public ResourceDungeonHandler.ReceiveDoubleRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ReceiveDoubleRewardResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ReceiveDoubleRewardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ReceiveDoubleRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(data); } public static ReceiveDoubleRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static ReceiveDoubleRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(data); } public static ReceiveDoubleRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static ReceiveDoubleRewardResponse parseFrom(InputStream input) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(input); } public static ReceiveDoubleRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static ReceiveDoubleRewardResponse parseDelimitedFrom(InputStream input) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseDelimitedFrom(input); } public static ReceiveDoubleRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ReceiveDoubleRewardResponse parseFrom(CodedInputStream input) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(input); } public static ReceiveDoubleRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ReceiveDoubleRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ReceiveDoubleRewardResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ReceiveDoubleRewardResponseOrBuilder {
/* 5655 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ReceiveDoubleRewardResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ReceiveDoubleRewardResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ReceiveDoubleRewardResponse_descriptor; } public ResourceDungeonHandler.ReceiveDoubleRewardResponse getDefaultInstanceForType() { return ResourceDungeonHandler.ReceiveDoubleRewardResponse.getDefaultInstance(); } public ResourceDungeonHandler.ReceiveDoubleRewardResponse build() { ResourceDungeonHandler.ReceiveDoubleRewardResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.ReceiveDoubleRewardResponse buildPartial() { ResourceDungeonHandler.ReceiveDoubleRewardResponse result = new ResourceDungeonHandler.ReceiveDoubleRewardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ReceiveDoubleRewardResponse) return mergeFrom((ResourceDungeonHandler.ReceiveDoubleRewardResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.ReceiveDoubleRewardResponse other) { if (other == ResourceDungeonHandler.ReceiveDoubleRewardResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ReceiveDoubleRewardResponse parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ReceiveDoubleRewardResponse)ResourceDungeonHandler.ReceiveDoubleRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ReceiveDoubleRewardResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ResourceDungeonHandler.ReceiveDoubleRewardResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ResourceCountDownRequest
/*      */     extends GeneratedMessage
/*      */     implements ResourceCountDownRequestOrBuilder
/*      */   {
/* 6091 */     private static final ResourceCountDownRequest defaultInstance = new ResourceCountDownRequest(true); private final UnknownFieldSet unknownFields; private ResourceCountDownRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ResourceCountDownRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ResourceCountDownRequest getDefaultInstance() { return defaultInstance; } public ResourceCountDownRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ResourceCountDownRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceCountDownRequest.class, Builder.class); } public static Parser<ResourceCountDownRequest> PARSER = (Parser<ResourceCountDownRequest>)new AbstractParser<ResourceCountDownRequest>() { public ResourceDungeonHandler.ResourceCountDownRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ResourceCountDownRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ResourceCountDownRequest> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } private void initFields() { this.dungeonId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.dungeonId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ResourceCountDownRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ResourceCountDownRequest)PARSER.parseFrom(data); } public static ResourceCountDownRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceCountDownRequest)PARSER.parseFrom(data, extensionRegistry); } public static ResourceCountDownRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ResourceCountDownRequest)PARSER.parseFrom(data); } public static ResourceCountDownRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceCountDownRequest)PARSER.parseFrom(data, extensionRegistry); } public static ResourceCountDownRequest parseFrom(InputStream input) throws IOException { return (ResourceCountDownRequest)PARSER.parseFrom(input); } public static ResourceCountDownRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownRequest)PARSER.parseFrom(input, extensionRegistry); } public static ResourceCountDownRequest parseDelimitedFrom(InputStream input) throws IOException { return (ResourceCountDownRequest)PARSER.parseDelimitedFrom(input); } public static ResourceCountDownRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ResourceCountDownRequest parseFrom(CodedInputStream input) throws IOException { return (ResourceCountDownRequest)PARSER.parseFrom(input); } public static ResourceCountDownRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ResourceCountDownRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ResourceCountDownRequestOrBuilder {
/* 6092 */       private int bitField0_; private int dungeonId_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ResourceCountDownRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ResourceCountDownRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.dungeonId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownRequest_descriptor; } public ResourceDungeonHandler.ResourceCountDownRequest getDefaultInstanceForType() { return ResourceDungeonHandler.ResourceCountDownRequest.getDefaultInstance(); } public ResourceDungeonHandler.ResourceCountDownRequest build() { ResourceDungeonHandler.ResourceCountDownRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.ResourceCountDownRequest buildPartial() { ResourceDungeonHandler.ResourceCountDownRequest result = new ResourceDungeonHandler.ResourceCountDownRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.dungeonId_ = this.dungeonId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ResourceCountDownRequest) return mergeFrom((ResourceDungeonHandler.ResourceCountDownRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.ResourceCountDownRequest other) { if (other == ResourceDungeonHandler.ResourceCountDownRequest.getDefaultInstance()) return this;  if (other.hasDungeonId()) setDungeonId(other.getDungeonId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ResourceCountDownRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ResourceCountDownRequest)ResourceDungeonHandler.ResourceCountDownRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ResourceCountDownRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public Builder setDungeonId(int value) { this.bitField0_ |= 0x1; this.dungeonId_ = value; onChanged(); return this; } public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE; this.dungeonId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ResourceCountDownResponse
/*      */     extends GeneratedMessage
/*      */     implements ResourceCountDownResponseOrBuilder
/*      */   {
/* 6763 */     private static final ResourceCountDownResponse defaultInstance = new ResourceCountDownResponse(true); private final UnknownFieldSet unknownFields; private ResourceCountDownResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ResourceCountDownResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ResourceCountDownResponse getDefaultInstance() { return defaultInstance; } public ResourceCountDownResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ResourceCountDownResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.countDown_ = input.readInt64(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceCountDownResponse.class, Builder.class); } public static Parser<ResourceCountDownResponse> PARSER = (Parser<ResourceCountDownResponse>)new AbstractParser<ResourceCountDownResponse>() { public ResourceDungeonHandler.ResourceCountDownResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ResourceCountDownResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int COUNTDOWN_FIELD_NUMBER = 3; private long countDown_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ResourceCountDownResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasCountDown() { return ((this.bitField0_ & 0x4) == 4); } public long getCountDown() { return this.countDown_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.countDown_ = 0L; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt64(3, this.countDown_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt64Size(3, this.countDown_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ResourceCountDownResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ResourceCountDownResponse)PARSER.parseFrom(data); } public static ResourceCountDownResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceCountDownResponse)PARSER.parseFrom(data, extensionRegistry); } public static ResourceCountDownResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ResourceCountDownResponse)PARSER.parseFrom(data); } public static ResourceCountDownResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceCountDownResponse)PARSER.parseFrom(data, extensionRegistry); } public static ResourceCountDownResponse parseFrom(InputStream input) throws IOException { return (ResourceCountDownResponse)PARSER.parseFrom(input); } public static ResourceCountDownResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownResponse)PARSER.parseFrom(input, extensionRegistry); } public static ResourceCountDownResponse parseDelimitedFrom(InputStream input) throws IOException { return (ResourceCountDownResponse)PARSER.parseDelimitedFrom(input); } public static ResourceCountDownResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ResourceCountDownResponse parseFrom(CodedInputStream input) throws IOException { return (ResourceCountDownResponse)PARSER.parseFrom(input); } public static ResourceCountDownResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceCountDownResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ResourceCountDownResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ResourceCountDownResponseOrBuilder {
/* 6764 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private long countDown_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ResourceCountDownResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ResourceCountDownResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.countDown_ = 0L; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceCountDownResponse_descriptor; } public ResourceDungeonHandler.ResourceCountDownResponse getDefaultInstanceForType() { return ResourceDungeonHandler.ResourceCountDownResponse.getDefaultInstance(); } public ResourceDungeonHandler.ResourceCountDownResponse build() { ResourceDungeonHandler.ResourceCountDownResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.ResourceCountDownResponse buildPartial() { ResourceDungeonHandler.ResourceCountDownResponse result = new ResourceDungeonHandler.ResourceCountDownResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.countDown_ = this.countDown_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ResourceCountDownResponse) return mergeFrom((ResourceDungeonHandler.ResourceCountDownResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.ResourceCountDownResponse other) { if (other == ResourceDungeonHandler.ResourceCountDownResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasCountDown()) setCountDown(other.getCountDown());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ResourceCountDownResponse parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ResourceCountDownResponse)ResourceDungeonHandler.ResourceCountDownResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ResourceCountDownResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ResourceDungeonHandler.ResourceCountDownResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasCountDown() { return ((this.bitField0_ & 0x4) == 4); } public long getCountDown() { return this.countDown_; } public Builder setCountDown(long value) { this.bitField0_ |= 0x4; this.countDown_ = value; onChanged(); return this; } public Builder clearCountDown() { this.bitField0_ &= 0xFFFFFFFB; this.countDown_ = 0L; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ResourceSweepRequest
/*      */     extends GeneratedMessage
/*      */     implements ResourceSweepRequestOrBuilder
/*      */   {
/* 7208 */     private static final ResourceSweepRequest defaultInstance = new ResourceSweepRequest(true); private final UnknownFieldSet unknownFields; private ResourceSweepRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ResourceSweepRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ResourceSweepRequest getDefaultInstance() { return defaultInstance; } public ResourceSweepRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ResourceSweepRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.dungeonId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceSweepRequest.class, Builder.class); } public static Parser<ResourceSweepRequest> PARSER = (Parser<ResourceSweepRequest>)new AbstractParser<ResourceSweepRequest>() { public ResourceDungeonHandler.ResourceSweepRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ResourceSweepRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DUNGEONID_FIELD_NUMBER = 1; private int dungeonId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ResourceSweepRequest> getParserForType() { return PARSER; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } private void initFields() { this.dungeonId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDungeonId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.dungeonId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ResourceSweepRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ResourceSweepRequest)PARSER.parseFrom(data); } public static ResourceSweepRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceSweepRequest)PARSER.parseFrom(data, extensionRegistry); } public static ResourceSweepRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ResourceSweepRequest)PARSER.parseFrom(data); } public static ResourceSweepRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceSweepRequest)PARSER.parseFrom(data, extensionRegistry); } public static ResourceSweepRequest parseFrom(InputStream input) throws IOException { return (ResourceSweepRequest)PARSER.parseFrom(input); } public static ResourceSweepRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepRequest)PARSER.parseFrom(input, extensionRegistry); } public static ResourceSweepRequest parseDelimitedFrom(InputStream input) throws IOException { return (ResourceSweepRequest)PARSER.parseDelimitedFrom(input); } public static ResourceSweepRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ResourceSweepRequest parseFrom(CodedInputStream input) throws IOException { return (ResourceSweepRequest)PARSER.parseFrom(input); } public static ResourceSweepRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ResourceSweepRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ResourceSweepRequestOrBuilder {
/* 7209 */       private int bitField0_; private int dungeonId_; public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ResourceSweepRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ResourceSweepRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.dungeonId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepRequest_descriptor; } public ResourceDungeonHandler.ResourceSweepRequest getDefaultInstanceForType() { return ResourceDungeonHandler.ResourceSweepRequest.getDefaultInstance(); } public ResourceDungeonHandler.ResourceSweepRequest build() { ResourceDungeonHandler.ResourceSweepRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ResourceDungeonHandler.ResourceSweepRequest buildPartial() { ResourceDungeonHandler.ResourceSweepRequest result = new ResourceDungeonHandler.ResourceSweepRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.dungeonId_ = this.dungeonId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ResourceSweepRequest) return mergeFrom((ResourceDungeonHandler.ResourceSweepRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ResourceDungeonHandler.ResourceSweepRequest other) { if (other == ResourceDungeonHandler.ResourceSweepRequest.getDefaultInstance()) return this;  if (other.hasDungeonId()) setDungeonId(other.getDungeonId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDungeonId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ResourceSweepRequest parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ResourceSweepRequest)ResourceDungeonHandler.ResourceSweepRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ResourceSweepRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDungeonId() { return ((this.bitField0_ & 0x1) == 1); } public int getDungeonId() { return this.dungeonId_; } public Builder setDungeonId(int value) { this.bitField0_ |= 0x1; this.dungeonId_ = value; onChanged(); return this; } public Builder clearDungeonId() { this.bitField0_ &= 0xFFFFFFFE; this.dungeonId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ResourceSweepResponse
/*      */     extends GeneratedMessage
/*      */     implements ResourceSweepResponseOrBuilder
/*      */   {
/* 8262 */     private static final ResourceSweepResponse defaultInstance = new ResourceSweepResponse(true); private final UnknownFieldSet unknownFields; private ResourceSweepResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ResourceSweepResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ResourceSweepResponse getDefaultInstance() { return defaultInstance; } public ResourceSweepResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ResourceSweepResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.awardItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.awardItems_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.awardItems_ = Collections.unmodifiableList(this.awardItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceSweepResponse.class, Builder.class); } public static Parser<ResourceSweepResponse> PARSER = (Parser<ResourceSweepResponse>)new AbstractParser<ResourceSweepResponse>() { public ResourceDungeonHandler.ResourceSweepResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ResourceDungeonHandler.ResourceSweepResponse(input, extensionRegistry); } }
/* 8263 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int AWARDITEMS_FIELD_NUMBER = 3; private List<ItemOuterClass.MiniItem> awardItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ResourceSweepResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<ItemOuterClass.MiniItem> getAwardItemsList() { return this.awardItems_; } public List<? extends ItemOuterClass.MiniItemOrBuilder> getAwardItemsOrBuilderList() { return (List)this.awardItems_; } public int getAwardItemsCount() { return this.awardItems_.size(); } public ItemOuterClass.MiniItem getAwardItems(int index) { return this.awardItems_.get(index); } public ItemOuterClass.MiniItemOrBuilder getAwardItemsOrBuilder(int index) { return (ItemOuterClass.MiniItemOrBuilder)this.awardItems_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.awardItems_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getAwardItemsCount(); i++) { if (!getAwardItems(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  for (int i = 0; i < this.awardItems_.size(); i++) output.writeMessage(3, (MessageLite)this.awardItems_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  for (int i = 0; i < this.awardItems_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.awardItems_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ResourceSweepResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ResourceSweepResponse)PARSER.parseFrom(data); } public static ResourceSweepResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceSweepResponse)PARSER.parseFrom(data, extensionRegistry); } public static ResourceSweepResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ResourceSweepResponse)PARSER.parseFrom(data); } static { defaultInstance.initFields(); }
/*      */     public static ResourceSweepResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ResourceSweepResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static ResourceSweepResponse parseFrom(InputStream input) throws IOException { return (ResourceSweepResponse)PARSER.parseFrom(input); }
/*      */     public static ResourceSweepResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static ResourceSweepResponse parseDelimitedFrom(InputStream input) throws IOException { return (ResourceSweepResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static ResourceSweepResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static ResourceSweepResponse parseFrom(CodedInputStream input) throws IOException { return (ResourceSweepResponse)PARSER.parseFrom(input); }
/*      */     public static ResourceSweepResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ResourceSweepResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(ResourceSweepResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceDungeonHandler.ResourceSweepResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private List<ItemOuterClass.MiniItem> awardItems_;
/*      */       private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> awardItemsBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonHandler.ResourceSweepResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.awardItems_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.awardItems_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (ResourceDungeonHandler.ResourceSweepResponse.alwaysUseFieldBuilders) getAwardItemsFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.awardItemsBuilder_ == null) { this.awardItems_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.awardItemsBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return ResourceDungeonHandler.internal_static_pomelo_area_ResourceSweepResponse_descriptor; }
/*      */       public ResourceDungeonHandler.ResourceSweepResponse getDefaultInstanceForType() { return ResourceDungeonHandler.ResourceSweepResponse.getDefaultInstance(); }
/*      */       public ResourceDungeonHandler.ResourceSweepResponse build() { ResourceDungeonHandler.ResourceSweepResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public ResourceDungeonHandler.ResourceSweepResponse buildPartial() { ResourceDungeonHandler.ResourceSweepResponse result = new ResourceDungeonHandler.ResourceSweepResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.awardItemsBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.awardItems_ = Collections.unmodifiableList(this.awardItems_); this.bitField0_ &= 0xFFFFFFFB; }  result.awardItems_ = this.awardItems_; } else { result.awardItems_ = this.awardItemsBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof ResourceDungeonHandler.ResourceSweepResponse) return mergeFrom((ResourceDungeonHandler.ResourceSweepResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(ResourceDungeonHandler.ResourceSweepResponse other) { if (other == ResourceDungeonHandler.ResourceSweepResponse.getDefaultInstance()) return this;  if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (this.awardItemsBuilder_ == null) { if (!other.awardItems_.isEmpty()) { if (this.awardItems_.isEmpty()) { this.awardItems_ = other.awardItems_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureAwardItemsIsMutable(); this.awardItems_.addAll(other.awardItems_); }  onChanged(); }  } else if (!other.awardItems_.isEmpty()) { if (this.awardItemsBuilder_.isEmpty()) { this.awardItemsBuilder_.dispose(); this.awardItemsBuilder_ = null; this.awardItems_ = other.awardItems_; this.bitField0_ &= 0xFFFFFFFB; this.awardItemsBuilder_ = ResourceDungeonHandler.ResourceSweepResponse.alwaysUseFieldBuilders ? getAwardItemsFieldBuilder() : null; } else { this.awardItemsBuilder_.addAllMessages(other.awardItems_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false;  for (int i = 0; i < getAwardItemsCount(); i++) { if (!getAwardItems(i).isInitialized())
/*      */             return false;  }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ResourceDungeonHandler.ResourceSweepResponse parsedMessage = null; try { parsedMessage = (ResourceDungeonHandler.ResourceSweepResponse)ResourceDungeonHandler.ResourceSweepResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ResourceDungeonHandler.ResourceSweepResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ResourceDungeonHandler.ResourceSweepResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       private void ensureAwardItemsIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.awardItems_ = new ArrayList<>(this.awardItems_); this.bitField0_ |= 0x4; }  }
/*      */       public List<ItemOuterClass.MiniItem> getAwardItemsList() { if (this.awardItemsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.awardItems_);  return this.awardItemsBuilder_.getMessageList(); }
/*      */       public int getAwardItemsCount() { if (this.awardItemsBuilder_ == null)
/*      */           return this.awardItems_.size();  return this.awardItemsBuilder_.getCount(); }
/*      */       public ItemOuterClass.MiniItem getAwardItems(int index) { if (this.awardItemsBuilder_ == null)
/*      */           return this.awardItems_.get(index);  return (ItemOuterClass.MiniItem)this.awardItemsBuilder_.getMessage(index); }
/*      */       public Builder setAwardItems(int index, ItemOuterClass.MiniItem value) { if (this.awardItemsBuilder_ == null) { if (value == null)
/*      */             throw new NullPointerException();  ensureAwardItemsIsMutable(); this.awardItems_.set(index, value); onChanged(); } else { this.awardItemsBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; }
/*      */       public Builder setAwardItems(int index, ItemOuterClass.MiniItem.Builder builderForValue) { if (this.awardItemsBuilder_ == null) { ensureAwardItemsIsMutable(); this.awardItems_.set(index, builderForValue.build()); onChanged(); } else { this.awardItemsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; }
/*      */       public Builder addAwardItems(ItemOuterClass.MiniItem value) { if (this.awardItemsBuilder_ == null) { if (value == null)
/*      */             throw new NullPointerException();  ensureAwardItemsIsMutable(); this.awardItems_.add(value); onChanged(); } else { this.awardItemsBuilder_.addMessage((GeneratedMessage)value); }  return this; }
/*      */       public Builder addAwardItems(int index, ItemOuterClass.MiniItem value) { if (this.awardItemsBuilder_ == null) { if (value == null)
/*      */             throw new NullPointerException();  ensureAwardItemsIsMutable(); this.awardItems_.add(index, value); onChanged(); } else { this.awardItemsBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; }
/*      */       public Builder addAwardItems(ItemOuterClass.MiniItem.Builder builderForValue) { if (this.awardItemsBuilder_ == null) { ensureAwardItemsIsMutable(); this.awardItems_.add(builderForValue.build()); onChanged(); } else { this.awardItemsBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; }
/*      */       public Builder addAwardItems(int index, ItemOuterClass.MiniItem.Builder builderForValue) { if (this.awardItemsBuilder_ == null) { ensureAwardItemsIsMutable(); this.awardItems_.add(index, builderForValue.build()); onChanged(); } else { this.awardItemsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; }
/*      */       public Builder addAllAwardItems(Iterable<? extends ItemOuterClass.MiniItem> values) { if (this.awardItemsBuilder_ == null) { ensureAwardItemsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.awardItems_); onChanged(); } else { this.awardItemsBuilder_.addAllMessages(values); }  return this; }
/*      */       public Builder clearAwardItems() { if (this.awardItemsBuilder_ == null) { this.awardItems_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); } else { this.awardItemsBuilder_.clear(); }  return this; }
/*      */       public Builder removeAwardItems(int index) { if (this.awardItemsBuilder_ == null) { ensureAwardItemsIsMutable(); this.awardItems_.remove(index); onChanged(); } else { this.awardItemsBuilder_.remove(index); }  return this; }
/*      */       public ItemOuterClass.MiniItem.Builder getAwardItemsBuilder(int index) { return (ItemOuterClass.MiniItem.Builder)getAwardItemsFieldBuilder().getBuilder(index); } public ItemOuterClass.MiniItemOrBuilder getAwardItemsOrBuilder(int index) { if (this.awardItemsBuilder_ == null)
/*      */           return (ItemOuterClass.MiniItemOrBuilder)this.awardItems_.get(index);  return (ItemOuterClass.MiniItemOrBuilder)this.awardItemsBuilder_.getMessageOrBuilder(index); } public List<? extends ItemOuterClass.MiniItemOrBuilder> getAwardItemsOrBuilderList() { if (this.awardItemsBuilder_ != null)
/*      */           return this.awardItemsBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.awardItems_); } public ItemOuterClass.MiniItem.Builder addAwardItemsBuilder() { return (ItemOuterClass.MiniItem.Builder)getAwardItemsFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.MiniItem.getDefaultInstance()); } public ItemOuterClass.MiniItem.Builder addAwardItemsBuilder(int index) { return (ItemOuterClass.MiniItem.Builder)getAwardItemsFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.MiniItem.getDefaultInstance()); } public List<ItemOuterClass.MiniItem.Builder> getAwardItemsBuilderList() { return getAwardItemsFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getAwardItemsFieldBuilder() { if (this.awardItemsBuilder_ == null) { this.awardItemsBuilder_ = new RepeatedFieldBuilder(this.awardItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.awardItems_ = null; }  return this.awardItemsBuilder_; } }
/* 8337 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 8342 */     String[] descriptorData = { "\n\034resourceDungeonHandler.proto\022\013pomelo.area\032\nitem.proto\"®\001\n\023ResourceDungeonInfo\022\021\n\tdungeonId\030\001 \002(\005\022\021\n\tlastTimes\030\002 \002(\005\022\020\n\bbuyTimes\030\003 \001(\005\022\023\n\013canBuyTimes\030\004 \001(\005\022\022\n\nawardItems\030\005 \001(\t\022\020\n\bcanSweep\030\006 \001(\b\022\020\n\bplayType\030\007 \001(\005\022\022\n\nenterLevel\030\b \001(\005\" \n\036QueryResourceDugeonInfoRequest\"x\n\037QueryResourceDugeonInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0222\n\bdungeons\030\003 \003(\0132 .pomelo.area.ResourceDungeonInfo\"$\n\017BuyTimes", "Request\022\021\n\tdungeonId\030\001 \002(\005\"5\n\020BuyTimesResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"3\n\036EnterResourceDugeonInfoRequest\022\021\n\tdungeonId\030\001 \002(\005\"D\n\037EnterResourceDugeonInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"/\n\032ReceiveDoubleRewardRequest\022\021\n\tdungeonId\030\001 \002(\005\"@\n\033ReceiveDoubleRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"-\n\030ResourceCountDownRequest\022\021\n\tdungeonId\030\001 \001(\005\"Q\n\031ResourceCountDownResponse\022\020\n\bs", "2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\tcountDown\030\003 \001(\003\")\n\024ResourceSweepRequest\022\021\n\tdungeonId\030\001 \002(\005\"e\n\025ResourceSweepResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\nawardItems\030\003 \003(\0132\025.pomelo.item.MiniItem2\005\n\026resourceDungeonHandler\022{\n\036queryResourceDugeonInfoRequest\022+.pomelo.area.QueryResourceDugeonInfoRequest\032,.pomelo.area.QueryResourceDugeonInfoResponse\022N\n\017buyTimesRequest\022\034.pomelo.area.BuyTimesRequest\032\035.p", "omelo.area.BuyTimesResponse\022{\n\036enterResourceDugeonInfoRequest\022+.pomelo.area.EnterResourceDugeonInfoRequest\032,.pomelo.area.EnterResourceDugeonInfoResponse\022o\n\032receiveDoubleRewardRequest\022'.pomelo.area.ReceiveDoubleRewardRequest\032(.pomelo.area.ReceiveDoubleRewardResponse\022i\n\030resourceCountDownRequest\022%.pomelo.area.ResourceCountDownRequest\032&.pomelo.area.ResourceCountDownResponse\022]\n\024resourceSweepRequest\022!.p", "omelo.area.ResourceSweepRequest\032\".pomelo.area.ResourceSweepResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 8386 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 8390 */           ResourceDungeonHandler.descriptor = root;
/* 8391 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 8395 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 8397 */           ItemOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 8400 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceDungeonInfo_descriptor = getDescriptor().getMessageTypes().get(0);
/* 8401 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceDungeonInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceDungeonInfo_descriptor, new String[] { "DungeonId", "LastTimes", "BuyTimes", "CanBuyTimes", "AwardItems", "CanSweep", "PlayType", "EnterLevel" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8406 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryResourceDugeonInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 8407 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryResourceDugeonInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryResourceDugeonInfoRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8412 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryResourceDugeonInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 8413 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryResourceDugeonInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryResourceDugeonInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Dungeons" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8418 */   private static final Descriptors.Descriptor internal_static_pomelo_area_BuyTimesRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 8419 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyTimesRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyTimesRequest_descriptor, new String[] { "DungeonId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8424 */   private static final Descriptors.Descriptor internal_static_pomelo_area_BuyTimesResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 8425 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyTimesResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyTimesResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8430 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EnterResourceDugeonInfoRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 8431 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterResourceDugeonInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterResourceDugeonInfoRequest_descriptor, new String[] { "DungeonId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8436 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EnterResourceDugeonInfoResponse_descriptor = getDescriptor().getMessageTypes().get(6);
/* 8437 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterResourceDugeonInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterResourceDugeonInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8442 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveDoubleRewardRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 8443 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveDoubleRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveDoubleRewardRequest_descriptor, new String[] { "DungeonId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8448 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveDoubleRewardResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 8449 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveDoubleRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveDoubleRewardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8454 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceCountDownRequest_descriptor = getDescriptor().getMessageTypes().get(9);
/* 8455 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceCountDownRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceCountDownRequest_descriptor, new String[] { "DungeonId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8460 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceCountDownResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 8461 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceCountDownResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceCountDownResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "CountDown" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8466 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceSweepRequest_descriptor = getDescriptor().getMessageTypes().get(11);
/* 8467 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceSweepRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceSweepRequest_descriptor, new String[] { "DungeonId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 8472 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceSweepResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 8473 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceSweepResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceSweepResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "AwardItems" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 8477 */     ItemOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface ResourceSweepResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */     
/*      */     List<ItemOuterClass.MiniItem> getAwardItemsList();
/*      */     
/*      */     ItemOuterClass.MiniItem getAwardItems(int param1Int);
/*      */     
/*      */     int getAwardItemsCount();
/*      */     
/*      */     List<? extends ItemOuterClass.MiniItemOrBuilder> getAwardItemsOrBuilderList();
/*      */     
/*      */     ItemOuterClass.MiniItemOrBuilder getAwardItemsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface ResourceSweepRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */   }
/*      */   
/*      */   public static interface ResourceCountDownResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */     
/*      */     boolean hasCountDown();
/*      */     
/*      */     long getCountDown();
/*      */   }
/*      */   
/*      */   public static interface ResourceCountDownRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */   }
/*      */   
/*      */   public static interface ReceiveDoubleRewardResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */   }
/*      */   
/*      */   public static interface ReceiveDoubleRewardRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */   }
/*      */   
/*      */   public static interface EnterResourceDugeonInfoResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */   }
/*      */   
/*      */   public static interface EnterResourceDugeonInfoRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */   }
/*      */   
/*      */   public static interface BuyTimesResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */   }
/*      */   
/*      */   public static interface BuyTimesRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */   }
/*      */   
/*      */   public static interface QueryResourceDugeonInfoResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */     
/*      */     List<ResourceDungeonHandler.ResourceDungeonInfo> getDungeonsList();
/*      */     
/*      */     ResourceDungeonHandler.ResourceDungeonInfo getDungeons(int param1Int);
/*      */     
/*      */     int getDungeonsCount();
/*      */     
/*      */     List<? extends ResourceDungeonHandler.ResourceDungeonInfoOrBuilder> getDungeonsOrBuilderList();
/*      */     
/*      */     ResourceDungeonHandler.ResourceDungeonInfoOrBuilder getDungeonsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface QueryResourceDugeonInfoRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface ResourceDungeonInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasDungeonId();
/*      */     
/*      */     int getDungeonId();
/*      */     
/*      */     boolean hasLastTimes();
/*      */     
/*      */     int getLastTimes();
/*      */     
/*      */     boolean hasBuyTimes();
/*      */     
/*      */     int getBuyTimes();
/*      */     
/*      */     boolean hasCanBuyTimes();
/*      */     
/*      */     int getCanBuyTimes();
/*      */     
/*      */     boolean hasAwardItems();
/*      */     
/*      */     String getAwardItems();
/*      */     
/*      */     ByteString getAwardItemsBytes();
/*      */     
/*      */     boolean hasCanSweep();
/*      */     
/*      */     boolean getCanSweep();
/*      */     
/*      */     boolean hasPlayType();
/*      */     
/*      */     int getPlayType();
/*      */     
/*      */     boolean hasEnterLevel();
/*      */     
/*      */     int getEnterLevel();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\ResourceDungeonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */