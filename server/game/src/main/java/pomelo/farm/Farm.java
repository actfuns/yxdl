/*      */ package pomelo.farm;
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
/*      */ import com.google.protobuf.LazyStringArrayList;
/*      */ import com.google.protobuf.LazyStringList;
/*      */ import com.google.protobuf.Message;
/*      */ import com.google.protobuf.MessageLite;
/*      */ import com.google.protobuf.MessageOrBuilder;
/*      */ import com.google.protobuf.Parser;
/*      */ import com.google.protobuf.ProtocolStringList;
/*      */ import com.google.protobuf.RepeatedFieldBuilder;
/*      */ import com.google.protobuf.SingleFieldBuilder;
/*      */ import com.google.protobuf.UnknownFieldSet;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import pomelo.Common;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Farm
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class Block
/*      */     extends GeneratedMessage
/*      */     implements BlockOrBuilder
/*      */   {
/* 1212 */     private static final Block defaultInstance = new Block(true); private final UnknownFieldSet unknownFields; private Block(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private Block(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static Block getDefaultInstance() { return defaultInstance; } public Block getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private Block(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.blockId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.blockState_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.seedCode_ = bs; break;case 32: this.bitField0_ |= 0x8; this.seedState_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.cultivateType_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.harvestTime_ = input.readInt64(); break;case 56: this.bitField0_ |= 0x40; this.protectEndTime_ = input.readInt64(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_Block_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_Block_fieldAccessorTable.ensureFieldAccessorsInitialized(Block.class, Builder.class); } public static Parser<Block> PARSER = (Parser<Block>)new AbstractParser<Block>() { public Farm.Block parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.Block(input, extensionRegistry); } }
/* 1213 */     ; private int bitField0_; public static final int BLOCKID_FIELD_NUMBER = 1; private int blockId_; public static final int BLOCKSTATE_FIELD_NUMBER = 2; private int blockState_; public static final int SEEDCODE_FIELD_NUMBER = 3; private Object seedCode_; public static final int SEEDSTATE_FIELD_NUMBER = 4; private int seedState_; public static final int CULTIVATETYPE_FIELD_NUMBER = 5; private int cultivateType_; public static final int HARVESTTIME_FIELD_NUMBER = 6; private long harvestTime_; public static final int PROTECTENDTIME_FIELD_NUMBER = 7; private long protectEndTime_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<Block> getParserForType() { return PARSER; } public boolean hasBlockId() { return ((this.bitField0_ & 0x1) == 1); } public int getBlockId() { return this.blockId_; } public boolean hasBlockState() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getBlockState() {
/*      */       return this.blockState_;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasSeedCode() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getSeedCode() {
/*      */       Object ref = this.seedCode_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.seedCode_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */     
/*      */     public ByteString getSeedCodeBytes() {
/*      */       Object ref = this.seedCode_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.seedCode_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasSeedState() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getSeedState() {
/*      */       return this.seedState_;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasCultivateType() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getCultivateType() {
/*      */       return this.cultivateType_;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasHarvestTime() {
/*      */       return ((this.bitField0_ & 0x20) == 32);
/*      */     }
/*      */ 
/*      */     
/*      */     public long getHarvestTime() {
/*      */       return this.harvestTime_;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasProtectEndTime() {
/*      */       return ((this.bitField0_ & 0x40) == 64);
/*      */     }
/*      */ 
/*      */     
/*      */     public long getProtectEndTime() {
/*      */       return this.protectEndTime_;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.blockId_ = 0;
/*      */       this.blockState_ = 0;
/*      */       this.seedCode_ = "";
/*      */       this.seedState_ = 0;
/*      */       this.cultivateType_ = 0;
/*      */       this.harvestTime_ = 0L;
/*      */       this.protectEndTime_ = 0L;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasBlockId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasBlockState()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.blockId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.blockState_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeBytes(3, getSeedCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeInt32(4, this.seedState_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         output.writeInt32(5, this.cultivateType_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         output.writeInt64(6, this.harvestTime_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x40) == 64) {
/*      */         output.writeInt64(7, this.protectEndTime_);
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeInt32Size(1, this.blockId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.blockState_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeBytesSize(3, getSeedCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeInt32Size(4, this.seedState_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         size += CodedOutputStream.computeInt32Size(5, this.cultivateType_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         size += CodedOutputStream.computeInt64Size(6, this.harvestTime_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x40) == 64) {
/*      */         size += CodedOutputStream.computeInt64Size(7, this.protectEndTime_);
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (Block)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (Block)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (Block)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (Block)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(InputStream input) throws IOException {
/*      */       return (Block)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (Block)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (Block)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (Block)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(CodedInputStream input) throws IOException {
/*      */       return (Block)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Block parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (Block)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(Block prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements Farm.BlockOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       
/*      */       private int blockId_;
/*      */       
/*      */       private int blockState_;
/*      */       
/*      */       private Object seedCode_;
/*      */       
/*      */       private int seedState_;
/*      */       
/*      */       private int cultivateType_;
/*      */       
/*      */       private long harvestTime_;
/*      */       
/*      */       private long protectEndTime_;
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return Farm.internal_static_pomelo_farm_Block_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return Farm.internal_static_pomelo_farm_Block_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.Block.class, Builder.class);
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.seedCode_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.seedCode_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (Farm.Block.alwaysUseFieldBuilders);
/*      */       }
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.blockId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.blockState_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.seedCode_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.seedState_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.cultivateType_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.harvestTime_ = 0L;
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.protectEndTime_ = 0L;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return Farm.internal_static_pomelo_farm_Block_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       public Farm.Block getDefaultInstanceForType() {
/*      */         return Farm.Block.getDefaultInstance();
/*      */       }
/*      */ 
/*      */       
/*      */       public Farm.Block build() {
/*      */         Farm.Block result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public Farm.Block buildPartial() {
/*      */         Farm.Block result = new Farm.Block(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.blockId_ = this.blockId_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.blockState_ = this.blockState_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.seedCode_ = this.seedCode_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.seedState_ = this.seedState_;
/*      */         if ((from_bitField0_ & 0x10) == 16) {
/*      */           to_bitField0_ |= 0x10;
/*      */         }
/*      */         result.cultivateType_ = this.cultivateType_;
/*      */         if ((from_bitField0_ & 0x20) == 32) {
/*      */           to_bitField0_ |= 0x20;
/*      */         }
/*      */         result.harvestTime_ = this.harvestTime_;
/*      */         if ((from_bitField0_ & 0x40) == 64) {
/*      */           to_bitField0_ |= 0x40;
/*      */         }
/*      */         result.protectEndTime_ = this.protectEndTime_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof Farm.Block) {
/*      */           return mergeFrom((Farm.Block)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Farm.Block other) {
/*      */         if (other == Farm.Block.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasBlockId()) {
/*      */           setBlockId(other.getBlockId());
/*      */         }
/*      */         if (other.hasBlockState()) {
/*      */           setBlockState(other.getBlockState());
/*      */         }
/*      */         if (other.hasSeedCode()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.seedCode_ = other.seedCode_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasSeedState()) {
/*      */           setSeedState(other.getSeedState());
/*      */         }
/*      */         if (other.hasCultivateType()) {
/*      */           setCultivateType(other.getCultivateType());
/*      */         }
/*      */         if (other.hasHarvestTime()) {
/*      */           setHarvestTime(other.getHarvestTime());
/*      */         }
/*      */         if (other.hasProtectEndTime()) {
/*      */           setProtectEndTime(other.getProtectEndTime());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasBlockId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasBlockState()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         Farm.Block parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (Farm.Block)Farm.Block.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (Farm.Block)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasBlockId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getBlockId() {
/*      */         return this.blockId_;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setBlockId(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.blockId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearBlockId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.blockId_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasBlockState() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getBlockState() {
/*      */         return this.blockState_;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setBlockState(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.blockState_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearBlockState() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.blockState_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasSeedCode() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */ 
/*      */       
/*      */       public String getSeedCode() {
/*      */         Object ref = this.seedCode_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.seedCode_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getSeedCodeBytes() {
/*      */         Object ref = this.seedCode_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.seedCode_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setSeedCode(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.seedCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearSeedCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.seedCode_ = Farm.Block.getDefaultInstance().getSeedCode();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setSeedCodeBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.seedCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasSeedState() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       
/*      */       public int getSeedState() {
/*      */         return this.seedState_;
/*      */       }
/*      */       
/*      */       public Builder setSeedState(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.seedState_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearSeedState() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.seedState_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasCultivateType() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */       
/*      */       public int getCultivateType() {
/*      */         return this.cultivateType_;
/*      */       }
/*      */       
/*      */       public Builder setCultivateType(int value) {
/*      */         this.bitField0_ |= 0x10;
/*      */         this.cultivateType_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearCultivateType() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.cultivateType_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasHarvestTime() {
/*      */         return ((this.bitField0_ & 0x20) == 32);
/*      */       }
/*      */       
/*      */       public long getHarvestTime() {
/*      */         return this.harvestTime_;
/*      */       }
/*      */       
/*      */       public Builder setHarvestTime(long value) {
/*      */         this.bitField0_ |= 0x20;
/*      */         this.harvestTime_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearHarvestTime() {
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.harvestTime_ = 0L;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasProtectEndTime() {
/*      */         return ((this.bitField0_ & 0x40) == 64);
/*      */       }
/*      */       
/*      */       public long getProtectEndTime() {
/*      */         return this.protectEndTime_;
/*      */       }
/*      */       
/*      */       public Builder setProtectEndTime(long value) {
/*      */         this.bitField0_ |= 0x40;
/*      */         this.protectEndTime_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearProtectEndTime() {
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.protectEndTime_ = 0L;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class Seed
/*      */     extends GeneratedMessage
/*      */     implements SeedOrBuilder
/*      */   {
/* 1870 */     private static final Seed defaultInstance = new Seed(true); private final UnknownFieldSet unknownFields; private Seed(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private Seed(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static Seed getDefaultInstance() { return defaultInstance; } public Seed getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private Seed(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.seedCode_ = bs; break;case 16: this.bitField0_ |= 0x2; this.num_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_Seed_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_Seed_fieldAccessorTable.ensureFieldAccessorsInitialized(Seed.class, Builder.class); } public static Parser<Seed> PARSER = (Parser<Seed>)new AbstractParser<Seed>() { public Farm.Seed parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.Seed(input, extensionRegistry); } }; private int bitField0_; public static final int SEEDCODE_FIELD_NUMBER = 1; private Object seedCode_; public static final int NUM_FIELD_NUMBER = 2; private int num_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<Seed> getParserForType() { return PARSER; } public boolean hasSeedCode() { return ((this.bitField0_ & 0x1) == 1); } public String getSeedCode() { Object ref = this.seedCode_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.seedCode_ = s;  return s; } public ByteString getSeedCodeBytes() { Object ref = this.seedCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.seedCode_ = b; return b; }  return (ByteString)ref; } public boolean hasNum() { return ((this.bitField0_ & 0x2) == 2); } public int getNum() { return this.num_; } private void initFields() { this.seedCode_ = ""; this.num_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasSeedCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasNum()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getSeedCodeBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.num_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getSeedCodeBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.num_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static Seed parseFrom(ByteString data) throws InvalidProtocolBufferException { return (Seed)PARSER.parseFrom(data); } public static Seed parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Seed)PARSER.parseFrom(data, extensionRegistry); } public static Seed parseFrom(byte[] data) throws InvalidProtocolBufferException { return (Seed)PARSER.parseFrom(data); } public static Seed parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Seed)PARSER.parseFrom(data, extensionRegistry); } public static Seed parseFrom(InputStream input) throws IOException { return (Seed)PARSER.parseFrom(input); } public static Seed parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Seed)PARSER.parseFrom(input, extensionRegistry); } public static Seed parseDelimitedFrom(InputStream input) throws IOException { return (Seed)PARSER.parseDelimitedFrom(input); } public static Seed parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Seed)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static Seed parseFrom(CodedInputStream input) throws IOException { return (Seed)PARSER.parseFrom(input); } public static Seed parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Seed)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(Seed prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements Farm.SeedOrBuilder {
/* 1871 */       private int bitField0_; private Object seedCode_; private int num_; public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_Seed_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_Seed_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.Seed.class, Builder.class); } private Builder() { this.seedCode_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.seedCode_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (Farm.Seed.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.seedCode_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.num_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return Farm.internal_static_pomelo_farm_Seed_descriptor; } public Farm.Seed getDefaultInstanceForType() { return Farm.Seed.getDefaultInstance(); } public Farm.Seed build() { Farm.Seed result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public Farm.Seed buildPartial() { Farm.Seed result = new Farm.Seed(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.seedCode_ = this.seedCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.num_ = this.num_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof Farm.Seed) return mergeFrom((Farm.Seed)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(Farm.Seed other) { if (other == Farm.Seed.getDefaultInstance()) return this;  if (other.hasSeedCode()) { this.bitField0_ |= 0x1; this.seedCode_ = other.seedCode_; onChanged(); }  if (other.hasNum()) setNum(other.getNum());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasSeedCode()) return false;  if (!hasNum()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { Farm.Seed parsedMessage = null; try { parsedMessage = (Farm.Seed)Farm.Seed.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (Farm.Seed)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasSeedCode() { return ((this.bitField0_ & 0x1) == 1); } public String getSeedCode() { Object ref = this.seedCode_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.seedCode_ = s;  return s; }  return (String)ref; } public ByteString getSeedCodeBytes() { Object ref = this.seedCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.seedCode_ = b; return b; }  return (ByteString)ref; } public Builder setSeedCode(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.seedCode_ = value; onChanged(); return this; } public Builder clearSeedCode() { this.bitField0_ &= 0xFFFFFFFE; this.seedCode_ = Farm.Seed.getDefaultInstance().getSeedCode(); onChanged(); return this; } public Builder setSeedCodeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.seedCode_ = value; onChanged(); return this; } public boolean hasNum() { return ((this.bitField0_ & 0x2) == 2); } public int getNum() { return this.num_; } public Builder setNum(int value) { this.bitField0_ |= 0x2; this.num_ = value; onChanged(); return this; } public Builder clearNum() { this.bitField0_ &= 0xFFFFFFFD; this.num_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class Product
/*      */     extends GeneratedMessage
/*      */     implements ProductOrBuilder
/*      */   {
/* 2528 */     private static final Product defaultInstance = new Product(true); private final UnknownFieldSet unknownFields; private Product(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private Product(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static Product getDefaultInstance() { return defaultInstance; } public Product getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private Product(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.productCode_ = bs; break;case 16: this.bitField0_ |= 0x2; this.num_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_Product_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_Product_fieldAccessorTable.ensureFieldAccessorsInitialized(Product.class, Builder.class); } public static Parser<Product> PARSER = (Parser<Product>)new AbstractParser<Product>() { public Farm.Product parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.Product(input, extensionRegistry); } }; private int bitField0_; public static final int PRODUCTCODE_FIELD_NUMBER = 1; private Object productCode_; public static final int NUM_FIELD_NUMBER = 2; private int num_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<Product> getParserForType() { return PARSER; } public boolean hasProductCode() { return ((this.bitField0_ & 0x1) == 1); } public String getProductCode() { Object ref = this.productCode_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.productCode_ = s;  return s; } public ByteString getProductCodeBytes() { Object ref = this.productCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.productCode_ = b; return b; }  return (ByteString)ref; } public boolean hasNum() { return ((this.bitField0_ & 0x2) == 2); } public int getNum() { return this.num_; } private void initFields() { this.productCode_ = ""; this.num_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasProductCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasNum()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getProductCodeBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.num_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getProductCodeBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.num_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static Product parseFrom(ByteString data) throws InvalidProtocolBufferException { return (Product)PARSER.parseFrom(data); } public static Product parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Product)PARSER.parseFrom(data, extensionRegistry); } public static Product parseFrom(byte[] data) throws InvalidProtocolBufferException { return (Product)PARSER.parseFrom(data); } public static Product parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Product)PARSER.parseFrom(data, extensionRegistry); } public static Product parseFrom(InputStream input) throws IOException { return (Product)PARSER.parseFrom(input); } public static Product parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Product)PARSER.parseFrom(input, extensionRegistry); } public static Product parseDelimitedFrom(InputStream input) throws IOException { return (Product)PARSER.parseDelimitedFrom(input); } public static Product parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Product)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static Product parseFrom(CodedInputStream input) throws IOException { return (Product)PARSER.parseFrom(input); } public static Product parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Product)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(Product prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements Farm.ProductOrBuilder {
/* 2529 */       private int bitField0_; private Object productCode_; private int num_; public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_Product_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_Product_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.Product.class, Builder.class); } private Builder() { this.productCode_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.productCode_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (Farm.Product.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.productCode_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.num_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return Farm.internal_static_pomelo_farm_Product_descriptor; } public Farm.Product getDefaultInstanceForType() { return Farm.Product.getDefaultInstance(); } public Farm.Product build() { Farm.Product result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public Farm.Product buildPartial() { Farm.Product result = new Farm.Product(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.productCode_ = this.productCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.num_ = this.num_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof Farm.Product) return mergeFrom((Farm.Product)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(Farm.Product other) { if (other == Farm.Product.getDefaultInstance()) return this;  if (other.hasProductCode()) { this.bitField0_ |= 0x1; this.productCode_ = other.productCode_; onChanged(); }  if (other.hasNum()) setNum(other.getNum());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasProductCode()) return false;  if (!hasNum()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { Farm.Product parsedMessage = null; try { parsedMessage = (Farm.Product)Farm.Product.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (Farm.Product)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasProductCode() { return ((this.bitField0_ & 0x1) == 1); } public String getProductCode() { Object ref = this.productCode_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.productCode_ = s;  return s; }  return (String)ref; } public ByteString getProductCodeBytes() { Object ref = this.productCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.productCode_ = b; return b; }  return (ByteString)ref; } public Builder setProductCode(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.productCode_ = value; onChanged(); return this; } public Builder clearProductCode() { this.bitField0_ &= 0xFFFFFFFE; this.productCode_ = Farm.Product.getDefaultInstance().getProductCode(); onChanged(); return this; } public Builder setProductCodeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.productCode_ = value; onChanged(); return this; } public boolean hasNum() { return ((this.bitField0_ & 0x2) == 2); } public int getNum() { return this.num_; } public Builder setNum(int value) { this.bitField0_ |= 0x2; this.num_ = value; onChanged(); return this; } public Builder clearNum() { this.bitField0_ &= 0xFFFFFFFD; this.num_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class RecordInfo
/*      */     extends GeneratedMessage
/*      */     implements RecordInfoOrBuilder
/*      */   {
/* 3342 */     private static final RecordInfo defaultInstance = new RecordInfo(true); private final UnknownFieldSet unknownFields; private RecordInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RecordInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RecordInfo getDefaultInstance() { return defaultInstance; } public RecordInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RecordInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.recordType_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.recordTimeStamp_ = input.readInt64(); break;case 26: bs = input.readBytes(); if ((mutable_bitField0_ & 0x4) != 4) { this.recordParams_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x4; }  this.recordParams_.add(bs); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.recordParams_ = this.recordParams_.getUnmodifiableView();  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_RecordInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_RecordInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RecordInfo.class, Builder.class); } public static Parser<RecordInfo> PARSER = (Parser<RecordInfo>)new AbstractParser<RecordInfo>() { public Farm.RecordInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.RecordInfo(input, extensionRegistry); } }; private int bitField0_; public static final int RECORDTYPE_FIELD_NUMBER = 1; private int recordType_; public static final int RECORDTIMESTAMP_FIELD_NUMBER = 2; private long recordTimeStamp_; public static final int RECORDPARAMS_FIELD_NUMBER = 3; private LazyStringList recordParams_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RecordInfo> getParserForType() { return PARSER; } public boolean hasRecordType() { return ((this.bitField0_ & 0x1) == 1); } public int getRecordType() { return this.recordType_; } public boolean hasRecordTimeStamp() { return ((this.bitField0_ & 0x2) == 2); } public long getRecordTimeStamp() { return this.recordTimeStamp_; } public ProtocolStringList getRecordParamsList() { return (ProtocolStringList)this.recordParams_; } public int getRecordParamsCount() { return this.recordParams_.size(); } public String getRecordParams(int index) { return (String)this.recordParams_.get(index); } public ByteString getRecordParamsBytes(int index) { return this.recordParams_.getByteString(index); } private void initFields() { this.recordType_ = 0; this.recordTimeStamp_ = 0L; this.recordParams_ = LazyStringArrayList.EMPTY; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasRecordType()) { this.memoizedIsInitialized = 0; return false; }  if (!hasRecordTimeStamp()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.recordType_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt64(2, this.recordTimeStamp_);  for (int i = 0; i < this.recordParams_.size(); i++) output.writeBytes(3, this.recordParams_.getByteString(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.recordType_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt64Size(2, this.recordTimeStamp_);  int dataSize = 0; for (int i = 0; i < this.recordParams_.size(); i++) dataSize += CodedOutputStream.computeBytesSizeNoTag(this.recordParams_.getByteString(i));  size += dataSize; size += 1 * getRecordParamsList().size(); size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RecordInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RecordInfo)PARSER.parseFrom(data); } public static RecordInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RecordInfo)PARSER.parseFrom(data, extensionRegistry); } public static RecordInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RecordInfo)PARSER.parseFrom(data); } public static RecordInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RecordInfo)PARSER.parseFrom(data, extensionRegistry); } public static RecordInfo parseFrom(InputStream input) throws IOException { return (RecordInfo)PARSER.parseFrom(input); } public static RecordInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecordInfo)PARSER.parseFrom(input, extensionRegistry); } public static RecordInfo parseDelimitedFrom(InputStream input) throws IOException { return (RecordInfo)PARSER.parseDelimitedFrom(input); } public static RecordInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecordInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RecordInfo parseFrom(CodedInputStream input) throws IOException { return (RecordInfo)PARSER.parseFrom(input); } public static RecordInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecordInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RecordInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements Farm.RecordInfoOrBuilder {
/* 3343 */       private int bitField0_; private int recordType_; private long recordTimeStamp_; private LazyStringList recordParams_; public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_RecordInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_RecordInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.RecordInfo.class, Builder.class); } private Builder() { this.recordParams_ = LazyStringArrayList.EMPTY; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.recordParams_ = LazyStringArrayList.EMPTY; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (Farm.RecordInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.recordType_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.recordTimeStamp_ = 0L; this.bitField0_ &= 0xFFFFFFFD; this.recordParams_ = LazyStringArrayList.EMPTY; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return Farm.internal_static_pomelo_farm_RecordInfo_descriptor; } public Farm.RecordInfo getDefaultInstanceForType() { return Farm.RecordInfo.getDefaultInstance(); } public Farm.RecordInfo build() { Farm.RecordInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public Farm.RecordInfo buildPartial() { Farm.RecordInfo result = new Farm.RecordInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.recordType_ = this.recordType_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.recordTimeStamp_ = this.recordTimeStamp_; if ((this.bitField0_ & 0x4) == 4) { this.recordParams_ = this.recordParams_.getUnmodifiableView(); this.bitField0_ &= 0xFFFFFFFB; }  result.recordParams_ = this.recordParams_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof Farm.RecordInfo) return mergeFrom((Farm.RecordInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(Farm.RecordInfo other) { if (other == Farm.RecordInfo.getDefaultInstance()) return this;  if (other.hasRecordType()) setRecordType(other.getRecordType());  if (other.hasRecordTimeStamp()) setRecordTimeStamp(other.getRecordTimeStamp());  if (!other.recordParams_.isEmpty()) { if (this.recordParams_.isEmpty()) { this.recordParams_ = other.recordParams_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureRecordParamsIsMutable(); this.recordParams_.addAll((Collection)other.recordParams_); }  onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasRecordType()) return false;  if (!hasRecordTimeStamp()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { Farm.RecordInfo parsedMessage = null; try { parsedMessage = (Farm.RecordInfo)Farm.RecordInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (Farm.RecordInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasRecordType() { return ((this.bitField0_ & 0x1) == 1); } public int getRecordType() { return this.recordType_; } public Builder setRecordType(int value) { this.bitField0_ |= 0x1; this.recordType_ = value; onChanged(); return this; } public Builder clearRecordType() { this.bitField0_ &= 0xFFFFFFFE; this.recordType_ = 0; onChanged(); return this; } public boolean hasRecordTimeStamp() { return ((this.bitField0_ & 0x2) == 2); } public long getRecordTimeStamp() { return this.recordTimeStamp_; } public Builder setRecordTimeStamp(long value) { this.bitField0_ |= 0x2; this.recordTimeStamp_ = value; onChanged(); return this; } public Builder clearRecordTimeStamp() { this.bitField0_ &= 0xFFFFFFFD; this.recordTimeStamp_ = 0L; onChanged(); return this; } private void ensureRecordParamsIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.recordParams_ = (LazyStringList)new LazyStringArrayList(this.recordParams_); this.bitField0_ |= 0x4; }  } public ProtocolStringList getRecordParamsList() { return (ProtocolStringList)this.recordParams_.getUnmodifiableView(); } public int getRecordParamsCount() { return this.recordParams_.size(); } public String getRecordParams(int index) { return (String)this.recordParams_.get(index); } public ByteString getRecordParamsBytes(int index) { return this.recordParams_.getByteString(index); } public Builder setRecordParams(int index, String value) { if (value == null) throw new NullPointerException();  ensureRecordParamsIsMutable(); this.recordParams_.set(index, value); onChanged(); return this; } public Builder addRecordParams(String value) { if (value == null) throw new NullPointerException();  ensureRecordParamsIsMutable(); this.recordParams_.add(value); onChanged(); return this; } public Builder addAllRecordParams(Iterable<String> values) { ensureRecordParamsIsMutable(); AbstractMessageLite.Builder.addAll(values, (Collection)this.recordParams_); onChanged(); return this; } public Builder clearRecordParams() { this.recordParams_ = LazyStringArrayList.EMPTY; this.bitField0_ &= 0xFFFFFFFB; onChanged(); return this; } public Builder addRecordParamsBytes(ByteString value) { if (value == null) throw new NullPointerException();  ensureRecordParamsIsMutable(); this.recordParams_.add(value); onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class PlayerSummary
/*      */     extends GeneratedMessage
/*      */     implements PlayerSummaryOrBuilder
/*      */   {
/* 4567 */     private static final PlayerSummary defaultInstance = new PlayerSummary(true); private final UnknownFieldSet unknownFields; private PlayerSummary(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PlayerSummary(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PlayerSummary getDefaultInstance() { return defaultInstance; } public PlayerSummary getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PlayerSummary(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.playerId_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.roleName_ = bs; break;case 24: this.bitField0_ |= 0x4; this.lv_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.farmLv_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.canSow_ = input.readBool(); break;case 48: this.bitField0_ |= 0x20; this.canSteal_ = input.readBool(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_PlayerSummary_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_PlayerSummary_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerSummary.class, Builder.class); } public static Parser<PlayerSummary> PARSER = (Parser<PlayerSummary>)new AbstractParser<PlayerSummary>() { public Farm.PlayerSummary parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.PlayerSummary(input, extensionRegistry); } }
/* 4568 */     ; private int bitField0_; public static final int PLAYERID_FIELD_NUMBER = 1; private Object playerId_; public static final int ROLENAME_FIELD_NUMBER = 2; private Object roleName_; public static final int LV_FIELD_NUMBER = 3; private int lv_; public static final int FARMLV_FIELD_NUMBER = 4; private int farmLv_; public static final int CANSOW_FIELD_NUMBER = 5; private boolean canSow_; public static final int CANSTEAL_FIELD_NUMBER = 6; private boolean canSteal_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PlayerSummary> getParserForType() { return PARSER; } public boolean hasPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getPlayerId() { Object ref = this.playerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.playerId_ = s;  return s; } public ByteString getPlayerIdBytes() { Object ref = this.playerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.playerId_ = b; return b; }  return (ByteString)ref; } public boolean hasRoleName() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getRoleName() {
/*      */       Object ref = this.roleName_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.roleName_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getRoleNameBytes() {
/*      */       Object ref = this.roleName_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.roleName_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasLv() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLv() {
/*      */       return this.lv_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasFarmLv() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getFarmLv() {
/*      */       return this.farmLv_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasCanSow() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean getCanSow() {
/*      */       return this.canSow_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasCanSteal() {
/*      */       return ((this.bitField0_ & 0x20) == 32);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean getCanSteal() {
/*      */       return this.canSteal_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.playerId_ = "";
/*      */       this.roleName_ = "";
/*      */       this.lv_ = 0;
/*      */       this.farmLv_ = 0;
/*      */       this.canSow_ = false;
/*      */       this.canSteal_ = false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasPlayerId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasRoleName()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasLv()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasFarmLv()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasCanSow()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasCanSteal()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getPlayerIdBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getRoleNameBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeInt32(3, this.lv_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeInt32(4, this.farmLv_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         output.writeBool(5, this.canSow_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         output.writeBool(6, this.canSteal_);
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getRoleNameBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeInt32Size(3, this.lv_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeInt32Size(4, this.farmLv_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         size += CodedOutputStream.computeBoolSize(5, this.canSow_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         size += CodedOutputStream.computeBoolSize(6, this.canSteal_);
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (PlayerSummary)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (PlayerSummary)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (PlayerSummary)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (PlayerSummary)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(InputStream input) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(CodedInputStream input) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerSummary parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerSummary)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(PlayerSummary prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements Farm.PlayerSummaryOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object playerId_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object roleName_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int lv_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int farmLv_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private boolean canSow_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private boolean canSteal_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerSummary_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerSummary_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.PlayerSummary.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.playerId_ = "";
/*      */         this.roleName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.playerId_ = "";
/*      */         this.roleName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (Farm.PlayerSummary.alwaysUseFieldBuilders);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.playerId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.roleName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.lv_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.farmLv_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.canSow_ = false;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.canSteal_ = false;
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerSummary_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummary getDefaultInstanceForType() {
/*      */         return Farm.PlayerSummary.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummary build() {
/*      */         Farm.PlayerSummary result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummary buildPartial() {
/*      */         Farm.PlayerSummary result = new Farm.PlayerSummary(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.playerId_ = this.playerId_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.roleName_ = this.roleName_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.lv_ = this.lv_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.farmLv_ = this.farmLv_;
/*      */         if ((from_bitField0_ & 0x10) == 16) {
/*      */           to_bitField0_ |= 0x10;
/*      */         }
/*      */         result.canSow_ = this.canSow_;
/*      */         if ((from_bitField0_ & 0x20) == 32) {
/*      */           to_bitField0_ |= 0x20;
/*      */         }
/*      */         result.canSteal_ = this.canSteal_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof Farm.PlayerSummary) {
/*      */           return mergeFrom((Farm.PlayerSummary)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Farm.PlayerSummary other) {
/*      */         if (other == Farm.PlayerSummary.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasPlayerId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.playerId_ = other.playerId_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasRoleName()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.roleName_ = other.roleName_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasLv()) {
/*      */           setLv(other.getLv());
/*      */         }
/*      */         if (other.hasFarmLv()) {
/*      */           setFarmLv(other.getFarmLv());
/*      */         }
/*      */         if (other.hasCanSow()) {
/*      */           setCanSow(other.getCanSow());
/*      */         }
/*      */         if (other.hasCanSteal()) {
/*      */           setCanSteal(other.getCanSteal());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasPlayerId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasRoleName()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasLv()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasFarmLv()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasCanSow()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasCanSteal()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         Farm.PlayerSummary parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (Farm.PlayerSummary)Farm.PlayerSummary.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (Farm.PlayerSummary)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasPlayerId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getPlayerId() {
/*      */         Object ref = this.playerId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.playerId_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getPlayerIdBytes() {
/*      */         Object ref = this.playerId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.playerId_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerId(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.playerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearPlayerId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.playerId_ = Farm.PlayerSummary.getDefaultInstance().getPlayerId();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerIdBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.playerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasRoleName() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getRoleName() {
/*      */         Object ref = this.roleName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.roleName_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getRoleNameBytes() {
/*      */         Object ref = this.roleName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.roleName_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setRoleName(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.roleName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearRoleName() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.roleName_ = Farm.PlayerSummary.getDefaultInstance().getRoleName();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setRoleNameBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.roleName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasLv() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getLv() {
/*      */         return this.lv_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setLv(int value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.lv_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearLv() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.lv_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasFarmLv() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getFarmLv() {
/*      */         return this.farmLv_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setFarmLv(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.farmLv_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearFarmLv() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.farmLv_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasCanSow() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean getCanSow() {
/*      */         return this.canSow_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setCanSow(boolean value) {
/*      */         this.bitField0_ |= 0x10;
/*      */         this.canSow_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearCanSow() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.canSow_ = false;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasCanSteal() {
/*      */         return ((this.bitField0_ & 0x20) == 32);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean getCanSteal() {
/*      */         return this.canSteal_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setCanSteal(boolean value) {
/*      */         this.bitField0_ |= 0x20;
/*      */         this.canSteal_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearCanSteal() {
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.canSteal_ = false;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class PlayerInfo
/*      */     extends GeneratedMessage
/*      */     implements PlayerInfoOrBuilder
/*      */   {
/* 5744 */     private static final PlayerInfo defaultInstance = new PlayerInfo(true); private final UnknownFieldSet unknownFields; private PlayerInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PlayerInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PlayerInfo getDefaultInstance() { return defaultInstance; } public PlayerInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; Farm.PlayerSummary.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.playerId_ = bs; break;case 18: subBuilder = null; if ((this.bitField0_ & 0x2) == 2) subBuilder = this.playerSummary_.toBuilder();  this.playerSummary_ = (Farm.PlayerSummary)input.readMessage(Farm.PlayerSummary.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.playerSummary_); this.playerSummary_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x2; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.blockLs_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.blockLs_.add(input.readMessage(Farm.Block.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.blockLs_ = Collections.unmodifiableList(this.blockLs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_PlayerInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_PlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerInfo.class, Builder.class); } public static Parser<PlayerInfo> PARSER = (Parser<PlayerInfo>)new AbstractParser<PlayerInfo>() { public Farm.PlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.PlayerInfo(input, extensionRegistry); } }
/* 5745 */     ; private int bitField0_; public static final int PLAYERID_FIELD_NUMBER = 1; private Object playerId_; public static final int PLAYERSUMMARY_FIELD_NUMBER = 2; private Farm.PlayerSummary playerSummary_; public static final int BLOCKLS_FIELD_NUMBER = 3; private List<Farm.Block> blockLs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PlayerInfo> getParserForType() { return PARSER; } public boolean hasPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getPlayerId() { Object ref = this.playerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.playerId_ = s;  return s; } public ByteString getPlayerIdBytes() { Object ref = this.playerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.playerId_ = b; return b; }  return (ByteString)ref; } public boolean hasPlayerSummary() { return ((this.bitField0_ & 0x2) == 2); } public Farm.PlayerSummary getPlayerSummary() { return this.playerSummary_; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder() {
/*      */       return this.playerSummary_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<Farm.Block> getBlockLsList() {
/*      */       return this.blockLs_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<? extends Farm.BlockOrBuilder> getBlockLsOrBuilderList() {
/*      */       return (List)this.blockLs_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getBlockLsCount() {
/*      */       return this.blockLs_.size();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Farm.Block getBlockLs(int index) {
/*      */       return this.blockLs_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Farm.BlockOrBuilder getBlockLsOrBuilder(int index) {
/*      */       return this.blockLs_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.playerId_ = "";
/*      */       this.playerSummary_ = Farm.PlayerSummary.getDefaultInstance();
/*      */       this.blockLs_ = Collections.emptyList();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasPlayerId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasPlayerSummary()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!getPlayerSummary().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       for (int i = 0; i < getBlockLsCount(); i++) {
/*      */         if (!getBlockLs(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getPlayerIdBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeMessage(2, (MessageLite)this.playerSummary_);
/*      */       }
/*      */       for (int i = 0; i < this.blockLs_.size(); i++) {
/*      */         output.writeMessage(3, (MessageLite)this.blockLs_.get(i));
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.playerSummary_);
/*      */       }
/*      */       for (int i = 0; i < this.blockLs_.size(); i++) {
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.blockLs_.get(i));
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (PlayerInfo)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (PlayerInfo)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (PlayerInfo)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (PlayerInfo)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(InputStream input) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(CodedInputStream input) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static PlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (PlayerInfo)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(PlayerInfo prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements Farm.PlayerInfoOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object playerId_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Farm.PlayerSummary playerSummary_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private SingleFieldBuilder<Farm.PlayerSummary, Farm.PlayerSummary.Builder, Farm.PlayerSummaryOrBuilder> playerSummaryBuilder_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private List<Farm.Block> blockLs_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<Farm.Block, Farm.Block.Builder, Farm.BlockOrBuilder> blockLsBuilder_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerInfo_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.PlayerInfo.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.playerId_ = "";
/*      */         this.playerSummary_ = Farm.PlayerSummary.getDefaultInstance();
/*      */         this.blockLs_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.playerId_ = "";
/*      */         this.playerSummary_ = Farm.PlayerSummary.getDefaultInstance();
/*      */         this.blockLs_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (Farm.PlayerInfo.alwaysUseFieldBuilders) {
/*      */           getPlayerSummaryFieldBuilder();
/*      */           getBlockLsFieldBuilder();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.playerId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           this.playerSummary_ = Farm.PlayerSummary.getDefaultInstance();
/*      */         } else {
/*      */           this.playerSummaryBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           this.blockLs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.blockLsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return Farm.internal_static_pomelo_farm_PlayerInfo_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerInfo getDefaultInstanceForType() {
/*      */         return Farm.PlayerInfo.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerInfo build() {
/*      */         Farm.PlayerInfo result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerInfo buildPartial() {
/*      */         Farm.PlayerInfo result = new Farm.PlayerInfo(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.playerId_ = this.playerId_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           result.playerSummary_ = this.playerSummary_;
/*      */         } else {
/*      */           result.playerSummary_ = (Farm.PlayerSummary)this.playerSummaryBuilder_.build();
/*      */         } 
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.blockLs_ = Collections.unmodifiableList(this.blockLs_);
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } 
/*      */           result.blockLs_ = this.blockLs_;
/*      */         } else {
/*      */           result.blockLs_ = this.blockLsBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof Farm.PlayerInfo) {
/*      */           return mergeFrom((Farm.PlayerInfo)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Farm.PlayerInfo other) {
/*      */         if (other == Farm.PlayerInfo.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasPlayerId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.playerId_ = other.playerId_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasPlayerSummary()) {
/*      */           mergePlayerSummary(other.getPlayerSummary());
/*      */         }
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           if (!other.blockLs_.isEmpty()) {
/*      */             if (this.blockLs_.isEmpty()) {
/*      */               this.blockLs_ = other.blockLs_;
/*      */               this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureBlockLsIsMutable();
/*      */               this.blockLs_.addAll(other.blockLs_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.blockLs_.isEmpty()) {
/*      */           if (this.blockLsBuilder_.isEmpty()) {
/*      */             this.blockLsBuilder_.dispose();
/*      */             this.blockLsBuilder_ = null;
/*      */             this.blockLs_ = other.blockLs_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */             this.blockLsBuilder_ = Farm.PlayerInfo.alwaysUseFieldBuilders ? getBlockLsFieldBuilder() : null;
/*      */           } else {
/*      */             this.blockLsBuilder_.addAllMessages(other.blockLs_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasPlayerId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasPlayerSummary()) {
/*      */           return false;
/*      */         }
/*      */         if (!getPlayerSummary().isInitialized()) {
/*      */           return false;
/*      */         }
/*      */         for (int i = 0; i < getBlockLsCount(); i++) {
/*      */           if (!getBlockLs(i).isInitialized()) {
/*      */             return false;
/*      */           }
/*      */         } 
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         Farm.PlayerInfo parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (Farm.PlayerInfo)Farm.PlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (Farm.PlayerInfo)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasPlayerId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getPlayerId() {
/*      */         Object ref = this.playerId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.playerId_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getPlayerIdBytes() {
/*      */         Object ref = this.playerId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.playerId_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerId(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.playerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearPlayerId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.playerId_ = Farm.PlayerInfo.getDefaultInstance().getPlayerId();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerIdBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.playerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasPlayerSummary() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummary getPlayerSummary() {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           return this.playerSummary_;
/*      */         }
/*      */         return (Farm.PlayerSummary)this.playerSummaryBuilder_.getMessage();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerSummary(Farm.PlayerSummary value) {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           this.playerSummary_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.playerSummaryBuilder_.setMessage(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x2;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPlayerSummary(Farm.PlayerSummary.Builder builderForValue) {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           this.playerSummary_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.playerSummaryBuilder_.setMessage(builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x2;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergePlayerSummary(Farm.PlayerSummary value) {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x2) == 2 && this.playerSummary_ != Farm.PlayerSummary.getDefaultInstance()) {
/*      */             this.playerSummary_ = Farm.PlayerSummary.newBuilder(this.playerSummary_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.playerSummary_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.playerSummaryBuilder_.mergeFrom(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x2;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearPlayerSummary() {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           this.playerSummary_ = Farm.PlayerSummary.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.playerSummaryBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummary.Builder getPlayerSummaryBuilder() {
/*      */         this.bitField0_ |= 0x2;
/*      */         onChanged();
/*      */         return (Farm.PlayerSummary.Builder)getPlayerSummaryFieldBuilder().getBuilder();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder() {
/*      */         if (this.playerSummaryBuilder_ != null) {
/*      */           return (Farm.PlayerSummaryOrBuilder)this.playerSummaryBuilder_.getMessageOrBuilder();
/*      */         }
/*      */         return this.playerSummary_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private SingleFieldBuilder<Farm.PlayerSummary, Farm.PlayerSummary.Builder, Farm.PlayerSummaryOrBuilder> getPlayerSummaryFieldBuilder() {
/*      */         if (this.playerSummaryBuilder_ == null) {
/*      */           this.playerSummaryBuilder_ = new SingleFieldBuilder(getPlayerSummary(), getParentForChildren(), isClean());
/*      */           this.playerSummary_ = null;
/*      */         } 
/*      */         return this.playerSummaryBuilder_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void ensureBlockLsIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.blockLs_ = new ArrayList<>(this.blockLs_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<Farm.Block> getBlockLsList() {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           return Collections.unmodifiableList(this.blockLs_);
/*      */         }
/*      */         return this.blockLsBuilder_.getMessageList();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getBlockLsCount() {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           return this.blockLs_.size();
/*      */         }
/*      */         return this.blockLsBuilder_.getCount();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.Block getBlockLs(int index) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           return this.blockLs_.get(index);
/*      */         }
/*      */         return (Farm.Block)this.blockLsBuilder_.getMessage(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setBlockLs(int index, Farm.Block value) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setBlockLs(int index, Farm.Block.Builder builderForValue) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addBlockLs(Farm.Block value) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.addMessage(value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addBlockLs(int index, Farm.Block value) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addBlockLs(Farm.Block.Builder builderForValue) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addBlockLs(int index, Farm.Block.Builder builderForValue) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAllBlockLs(Iterable<? extends Farm.Block> values) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           ensureBlockLsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.blockLs_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearBlockLs() {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           this.blockLs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder removeBlockLs(int index) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           ensureBlockLsIsMutable();
/*      */           this.blockLs_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.blockLsBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.Block.Builder getBlockLsBuilder(int index) {
/*      */         return (Farm.Block.Builder)getBlockLsFieldBuilder().getBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.BlockOrBuilder getBlockLsOrBuilder(int index) {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           return this.blockLs_.get(index);
/*      */         }
/*      */         return (Farm.BlockOrBuilder)this.blockLsBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<? extends Farm.BlockOrBuilder> getBlockLsOrBuilderList() {
/*      */         if (this.blockLsBuilder_ != null) {
/*      */           return this.blockLsBuilder_.getMessageOrBuilderList();
/*      */         }
/*      */         return Collections.unmodifiableList((List)this.blockLs_);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.Block.Builder addBlockLsBuilder() {
/*      */         return (Farm.Block.Builder)getBlockLsFieldBuilder().addBuilder(Farm.Block.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Farm.Block.Builder addBlockLsBuilder(int index) {
/*      */         return (Farm.Block.Builder)getBlockLsFieldBuilder().addBuilder(index, Farm.Block.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<Farm.Block.Builder> getBlockLsBuilderList() {
/*      */         return getBlockLsFieldBuilder().getBuilderList();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<Farm.Block, Farm.Block.Builder, Farm.BlockOrBuilder> getBlockLsFieldBuilder() {
/*      */         if (this.blockLsBuilder_ == null) {
/*      */           this.blockLsBuilder_ = new RepeatedFieldBuilder(this.blockLs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.blockLs_ = null;
/*      */         } 
/*      */         return this.blockLsBuilder_;
/*      */       }
/*      */     }
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
/*      */   public static final class ShopItemInfo
/*      */     extends GeneratedMessage
/*      */     implements ShopItemInfoOrBuilder
/*      */   {
/* 7129 */     private static final ShopItemInfo defaultInstance = new ShopItemInfo(true); private final UnknownFieldSet unknownFields; private ShopItemInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ShopItemInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ShopItemInfo getDefaultInstance() { return defaultInstance; } public ShopItemInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ShopItemInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.itemId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.changeNumCurrent_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.changeNumMax_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.need_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.need_.add(input.readMessage(Common.KeyValueStruct.PARSER, extensionRegistry)); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.award_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.award_.add(input.readMessage(Common.KeyValueStruct.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.need_ = Collections.unmodifiableList(this.need_);  if ((mutable_bitField0_ & 0x10) == 16) this.award_ = Collections.unmodifiableList(this.award_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_ShopItemInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_ShopItemInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopItemInfo.class, Builder.class); } public static Parser<ShopItemInfo> PARSER = (Parser<ShopItemInfo>)new AbstractParser<ShopItemInfo>() { public Farm.ShopItemInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new Farm.ShopItemInfo(input, extensionRegistry); } }
/* 7130 */     ; private int bitField0_; public static final int ITEMID_FIELD_NUMBER = 1; private int itemId_; public static final int CHANGENUMCURRENT_FIELD_NUMBER = 2; private int changeNumCurrent_; public static final int CHANGENUMMAX_FIELD_NUMBER = 3; private int changeNumMax_; public static final int NEED_FIELD_NUMBER = 4; private List<Common.KeyValueStruct> need_; public static final int AWARD_FIELD_NUMBER = 5; private List<Common.KeyValueStruct> award_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ShopItemInfo> getParserForType() { return PARSER; } public boolean hasItemId() { return ((this.bitField0_ & 0x1) == 1); } public int getItemId() { return this.itemId_; } public boolean hasChangeNumCurrent() { return ((this.bitField0_ & 0x2) == 2); } public int getChangeNumCurrent() { return this.changeNumCurrent_; } public boolean hasChangeNumMax() { return ((this.bitField0_ & 0x4) == 4); } public int getChangeNumMax() { return this.changeNumMax_; } public List<Common.KeyValueStruct> getNeedList() { return this.need_; } public List<? extends Common.KeyValueStructOrBuilder> getNeedOrBuilderList() { return (List)this.need_; } public int getNeedCount() { return this.need_.size(); } public Common.KeyValueStruct getNeed(int index) { return this.need_.get(index); } public Common.KeyValueStructOrBuilder getNeedOrBuilder(int index) { return (Common.KeyValueStructOrBuilder)this.need_.get(index); } public List<Common.KeyValueStruct> getAwardList() { return this.award_; } public List<? extends Common.KeyValueStructOrBuilder> getAwardOrBuilderList() { return (List)this.award_; } public int getAwardCount() { return this.award_.size(); } public Common.KeyValueStruct getAward(int index) { return this.award_.get(index); } public Common.KeyValueStructOrBuilder getAwardOrBuilder(int index) { return (Common.KeyValueStructOrBuilder)this.award_.get(index); } private void initFields() { this.itemId_ = 0; this.changeNumCurrent_ = 0; this.changeNumMax_ = 0; this.need_ = Collections.emptyList(); this.award_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasItemId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasChangeNumCurrent()) { this.memoizedIsInitialized = 0; return false; }  if (!hasChangeNumMax()) { this.memoizedIsInitialized = 0; return false; }  int i; for (i = 0; i < getNeedCount(); i++) { if (!getNeed(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getAwardCount(); i++) { if (!getAward(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.itemId_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.changeNumCurrent_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.changeNumMax_);  int i; for (i = 0; i < this.need_.size(); i++) output.writeMessage(4, (MessageLite)this.need_.get(i));  for (i = 0; i < this.award_.size(); i++) output.writeMessage(5, (MessageLite)this.award_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.itemId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.changeNumCurrent_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.changeNumMax_);  int i; for (i = 0; i < this.need_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.need_.get(i));  for (i = 0; i < this.award_.size(); i++) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.award_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ShopItemInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ShopItemInfo)PARSER.parseFrom(data); } public static ShopItemInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ShopItemInfo)PARSER.parseFrom(data, extensionRegistry); } public static ShopItemInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ShopItemInfo)PARSER.parseFrom(data); } public static ShopItemInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ShopItemInfo)PARSER.parseFrom(data, extensionRegistry); } public static ShopItemInfo parseFrom(InputStream input) throws IOException { return (ShopItemInfo)PARSER.parseFrom(input); } public static ShopItemInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ShopItemInfo)PARSER.parseFrom(input, extensionRegistry); } public static ShopItemInfo parseDelimitedFrom(InputStream input) throws IOException { return (ShopItemInfo)PARSER.parseDelimitedFrom(input); } public static ShopItemInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ShopItemInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ShopItemInfo parseFrom(CodedInputStream input) throws IOException { return (ShopItemInfo)PARSER.parseFrom(input); } public static ShopItemInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ShopItemInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ShopItemInfo prototype) { return newBuilder().mergeFrom(prototype); } static { defaultInstance.initFields(); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements Farm.ShopItemInfoOrBuilder {
/*      */       private int bitField0_;
/*      */       private int itemId_;
/*      */       private int changeNumCurrent_;
/*      */       private int changeNumMax_;
/*      */       private List<Common.KeyValueStruct> need_;
/*      */       private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> needBuilder_;
/*      */       private List<Common.KeyValueStruct> award_;
/*      */       private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> awardBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return Farm.internal_static_pomelo_farm_ShopItemInfo_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return Farm.internal_static_pomelo_farm_ShopItemInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(Farm.ShopItemInfo.class, Builder.class); }
/*      */       private Builder() { this.need_ = Collections.emptyList(); this.award_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.need_ = Collections.emptyList(); this.award_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (Farm.ShopItemInfo.alwaysUseFieldBuilders) { getNeedFieldBuilder(); getAwardFieldBuilder(); }  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.itemId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.changeNumCurrent_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.changeNumMax_ = 0; this.bitField0_ &= 0xFFFFFFFB; if (this.needBuilder_ == null) { this.need_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; } else { this.needBuilder_.clear(); }  if (this.awardBuilder_ == null) { this.award_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; } else { this.awardBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return Farm.internal_static_pomelo_farm_ShopItemInfo_descriptor; }
/*      */       public Farm.ShopItemInfo getDefaultInstanceForType() { return Farm.ShopItemInfo.getDefaultInstance(); }
/*      */       public Farm.ShopItemInfo build() { Farm.ShopItemInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public Farm.ShopItemInfo buildPartial() { Farm.ShopItemInfo result = new Farm.ShopItemInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.itemId_ = this.itemId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.changeNumCurrent_ = this.changeNumCurrent_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.changeNumMax_ = this.changeNumMax_; if (this.needBuilder_ == null) { if ((this.bitField0_ & 0x8) == 8) { this.need_ = Collections.unmodifiableList(this.need_); this.bitField0_ &= 0xFFFFFFF7; }  result.need_ = this.need_; } else { result.need_ = this.needBuilder_.build(); }  if (this.awardBuilder_ == null) { if ((this.bitField0_ & 0x10) == 16) { this.award_ = Collections.unmodifiableList(this.award_); this.bitField0_ &= 0xFFFFFFEF; }  result.award_ = this.award_; } else { result.award_ = this.awardBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof Farm.ShopItemInfo) return mergeFrom((Farm.ShopItemInfo)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(Farm.ShopItemInfo other) { if (other == Farm.ShopItemInfo.getDefaultInstance()) return this;  if (other.hasItemId()) setItemId(other.getItemId());  if (other.hasChangeNumCurrent()) setChangeNumCurrent(other.getChangeNumCurrent());  if (other.hasChangeNumMax()) setChangeNumMax(other.getChangeNumMax());  if (this.needBuilder_ == null) { if (!other.need_.isEmpty()) { if (this.need_.isEmpty()) { this.need_ = other.need_; this.bitField0_ &= 0xFFFFFFF7; } else { ensureNeedIsMutable(); this.need_.addAll(other.need_); }  onChanged(); }  } else if (!other.need_.isEmpty()) { if (this.needBuilder_.isEmpty()) { this.needBuilder_.dispose(); this.needBuilder_ = null; this.need_ = other.need_; this.bitField0_ &= 0xFFFFFFF7; this.needBuilder_ = Farm.ShopItemInfo.alwaysUseFieldBuilders ? getNeedFieldBuilder() : null; } else { this.needBuilder_.addAllMessages(other.need_); }  }  if (this.awardBuilder_ == null) { if (!other.award_.isEmpty()) { if (this.award_.isEmpty()) { this.award_ = other.award_; this.bitField0_ &= 0xFFFFFFEF; } else { ensureAwardIsMutable(); this.award_.addAll(other.award_); }  onChanged(); }  } else if (!other.award_.isEmpty()) { if (this.awardBuilder_.isEmpty()) { this.awardBuilder_.dispose(); this.awardBuilder_ = null; this.award_ = other.award_; this.bitField0_ &= 0xFFFFFFEF; this.awardBuilder_ = Farm.ShopItemInfo.alwaysUseFieldBuilders ? getAwardFieldBuilder() : null; } else { this.awardBuilder_.addAllMessages(other.award_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasItemId()) return false;  if (!hasChangeNumCurrent()) return false;  if (!hasChangeNumMax()) return false;  int i; for (i = 0; i < getNeedCount(); i++) { if (!getNeed(i).isInitialized()) return false;  }  for (i = 0; i < getAwardCount(); i++) { if (!getAward(i).isInitialized()) return false;  }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { Farm.ShopItemInfo parsedMessage = null; try { parsedMessage = (Farm.ShopItemInfo)Farm.ShopItemInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (Farm.ShopItemInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasItemId() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getItemId() { return this.itemId_; }
/*      */       public Builder setItemId(int value) { this.bitField0_ |= 0x1; this.itemId_ = value; onChanged(); return this; }
/*      */       public Builder clearItemId() { this.bitField0_ &= 0xFFFFFFFE; this.itemId_ = 0; onChanged(); return this; }
/*      */       public boolean hasChangeNumCurrent() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public int getChangeNumCurrent() { return this.changeNumCurrent_; }
/*      */       public Builder setChangeNumCurrent(int value) { this.bitField0_ |= 0x2; this.changeNumCurrent_ = value; onChanged(); return this; }
/*      */       public Builder clearChangeNumCurrent() { this.bitField0_ &= 0xFFFFFFFD; this.changeNumCurrent_ = 0; onChanged(); return this; }
/*      */       public boolean hasChangeNumMax() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getChangeNumMax() { return this.changeNumMax_; }
/*      */       public Builder setChangeNumMax(int value) { this.bitField0_ |= 0x4; this.changeNumMax_ = value; onChanged(); return this; }
/*      */       public Builder clearChangeNumMax() { this.bitField0_ &= 0xFFFFFFFB; this.changeNumMax_ = 0; onChanged(); return this; }
/*      */       private void ensureNeedIsMutable() { if ((this.bitField0_ & 0x8) != 8) { this.need_ = new ArrayList<>(this.need_); this.bitField0_ |= 0x8; }  }
/*      */       public List<Common.KeyValueStruct> getNeedList() { if (this.needBuilder_ == null) return Collections.unmodifiableList(this.need_);  return this.needBuilder_.getMessageList(); }
/*      */       public int getNeedCount() { if (this.needBuilder_ == null) return this.need_.size();  return this.needBuilder_.getCount(); }
/*      */       public Common.KeyValueStruct getNeed(int index) { if (this.needBuilder_ == null) return this.need_.get(index);  return (Common.KeyValueStruct)this.needBuilder_.getMessage(index); } public Builder setNeed(int index, Common.KeyValueStruct value) { if (this.needBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureNeedIsMutable(); this.need_.set(index, value); onChanged(); } else { this.needBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setNeed(int index, Common.KeyValueStruct.Builder builderForValue) { if (this.needBuilder_ == null) { ensureNeedIsMutable(); this.need_.set(index, builderForValue.build()); onChanged(); } else { this.needBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addNeed(Common.KeyValueStruct value) { if (this.needBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureNeedIsMutable(); this.need_.add(value); onChanged(); } else { this.needBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addNeed(int index, Common.KeyValueStruct value) { if (this.needBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureNeedIsMutable(); this.need_.add(index, value); onChanged(); } else { this.needBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addNeed(Common.KeyValueStruct.Builder builderForValue) { if (this.needBuilder_ == null) { ensureNeedIsMutable(); this.need_.add(builderForValue.build()); onChanged(); } else { this.needBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addNeed(int index, Common.KeyValueStruct.Builder builderForValue) { if (this.needBuilder_ == null) { ensureNeedIsMutable(); this.need_.add(index, builderForValue.build()); onChanged(); } else { this.needBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllNeed(Iterable<? extends Common.KeyValueStruct> values) { if (this.needBuilder_ == null) { ensureNeedIsMutable(); AbstractMessageLite.Builder.addAll(values, this.need_); onChanged(); } else { this.needBuilder_.addAllMessages(values); }  return this; } public Builder clearNeed() { if (this.needBuilder_ == null) { this.need_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; onChanged(); } else { this.needBuilder_.clear(); }  return this; } public Builder removeNeed(int index) { if (this.needBuilder_ == null) { ensureNeedIsMutable(); this.need_.remove(index); onChanged(); } else { this.needBuilder_.remove(index); }  return this; } public Common.KeyValueStruct.Builder getNeedBuilder(int index) { return (Common.KeyValueStruct.Builder)getNeedFieldBuilder().getBuilder(index); } public Common.KeyValueStructOrBuilder getNeedOrBuilder(int index) { if (this.needBuilder_ == null) return (Common.KeyValueStructOrBuilder)this.need_.get(index);  return (Common.KeyValueStructOrBuilder)this.needBuilder_.getMessageOrBuilder(index); } public List<? extends Common.KeyValueStructOrBuilder> getNeedOrBuilderList() { if (this.needBuilder_ != null) return this.needBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.need_); } public Common.KeyValueStruct.Builder addNeedBuilder() { return (Common.KeyValueStruct.Builder)getNeedFieldBuilder().addBuilder((GeneratedMessage)Common.KeyValueStruct.getDefaultInstance()); } public Common.KeyValueStruct.Builder addNeedBuilder(int index) { return (Common.KeyValueStruct.Builder)getNeedFieldBuilder().addBuilder(index, (GeneratedMessage)Common.KeyValueStruct.getDefaultInstance()); } public List<Common.KeyValueStruct.Builder> getNeedBuilderList() { return getNeedFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> getNeedFieldBuilder() { if (this.needBuilder_ == null) { this.needBuilder_ = new RepeatedFieldBuilder(this.need_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean()); this.need_ = null; }  return this.needBuilder_; } private void ensureAwardIsMutable() { if ((this.bitField0_ & 0x10) != 16) { this.award_ = new ArrayList<>(this.award_); this.bitField0_ |= 0x10; }  } public List<Common.KeyValueStruct> getAwardList() { if (this.awardBuilder_ == null) return Collections.unmodifiableList(this.award_);  return this.awardBuilder_.getMessageList(); } public int getAwardCount() { if (this.awardBuilder_ == null) return this.award_.size();  return this.awardBuilder_.getCount(); } public Common.KeyValueStruct getAward(int index) { if (this.awardBuilder_ == null) return this.award_.get(index);  return (Common.KeyValueStruct)this.awardBuilder_.getMessage(index); } public Builder setAward(int index, Common.KeyValueStruct value) { if (this.awardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardIsMutable(); this.award_.set(index, value); onChanged(); } else { this.awardBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setAward(int index, Common.KeyValueStruct.Builder builderForValue) { if (this.awardBuilder_ == null) { ensureAwardIsMutable(); this.award_.set(index, builderForValue.build()); onChanged(); } else { this.awardBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAward(Common.KeyValueStruct value) { if (this.awardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardIsMutable(); this.award_.add(value); onChanged(); } else { this.awardBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addAward(int index, Common.KeyValueStruct value) { if (this.awardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardIsMutable(); this.award_.add(index, value); onChanged(); } else { this.awardBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addAward(Common.KeyValueStruct.Builder builderForValue) { if (this.awardBuilder_ == null) { ensureAwardIsMutable(); this.award_.add(builderForValue.build()); onChanged(); } else { this.awardBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAward(int index, Common.KeyValueStruct.Builder builderForValue) { if (this.awardBuilder_ == null) { ensureAwardIsMutable(); this.award_.add(index, builderForValue.build()); onChanged(); } else { this.awardBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllAward(Iterable<? extends Common.KeyValueStruct> values) { if (this.awardBuilder_ == null) { ensureAwardIsMutable(); AbstractMessageLite.Builder.addAll(values, this.award_); onChanged(); } else { this.awardBuilder_.addAllMessages(values); }  return this; } public Builder clearAward() { if (this.awardBuilder_ == null) { this.award_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; onChanged(); } else { this.awardBuilder_.clear(); }  return this; } public Builder removeAward(int index) { if (this.awardBuilder_ == null) { ensureAwardIsMutable(); this.award_.remove(index); onChanged(); } else { this.awardBuilder_.remove(index); }  return this; } public Common.KeyValueStruct.Builder getAwardBuilder(int index) { return (Common.KeyValueStruct.Builder)getAwardFieldBuilder().getBuilder(index); } public Common.KeyValueStructOrBuilder getAwardOrBuilder(int index) { if (this.awardBuilder_ == null) return (Common.KeyValueStructOrBuilder)this.award_.get(index);  return (Common.KeyValueStructOrBuilder)this.awardBuilder_.getMessageOrBuilder(index); } public List<? extends Common.KeyValueStructOrBuilder> getAwardOrBuilderList() { if (this.awardBuilder_ != null) return this.awardBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.award_); } public Common.KeyValueStruct.Builder addAwardBuilder() { return (Common.KeyValueStruct.Builder)getAwardFieldBuilder().addBuilder((GeneratedMessage)Common.KeyValueStruct.getDefaultInstance()); } public Common.KeyValueStruct.Builder addAwardBuilder(int index) { return (Common.KeyValueStruct.Builder)getAwardFieldBuilder().addBuilder(index, (GeneratedMessage)Common.KeyValueStruct.getDefaultInstance()); } public List<Common.KeyValueStruct.Builder> getAwardBuilderList() { return getAwardFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> getAwardFieldBuilder() { if (this.awardBuilder_ == null) { this.awardBuilder_ = new RepeatedFieldBuilder(this.award_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean()); this.award_ = null; }  return this.awardBuilder_; } }
/* 7174 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 7179 */     String[] descriptorData = { "\n\nfarm.proto\022\013pomelo.farm\032\fcommon.proto\"\001\n\005Block\022\017\n\007blockId\030\001 \002(\005\022\022\n\nblockState\030\002 \002(\005\022\020\n\bseedCode\030\003 \001(\t\022\021\n\tseedState\030\004 \001(\005\022\025\n\rcultivateType\030\005 \001(\005\022\023\n\013harvestTime\030\006 \001(\003\022\026\n\016protectEndTime\030\007 \001(\003\"%\n\004Seed\022\020\n\bseedCode\030\001 \002(\t\022\013\n\003num\030\002 \002(\005\"+\n\007Product\022\023\n\013productCode\030\001 \002(\t\022\013\n\003num\030\002 \002(\005\"O\n\nRecordInfo\022\022\n\nrecordType\030\001 \002(\005\022\027\n\017recordTimeStamp\030\002 \002(\003\022\024\n\frecordParams\030\003 \003(\t\"q\n\rPlayerSummary\022\020\n\bplayerId\030\001 \002(\t\022\020\n\broleN", "ame\030\002 \002(\t\022\n\n\002lv\030\003 \002(\005\022\016\n\006farmLv\030\004 \002(\005\022\016\n\006canSow\030\005 \002(\b\022\020\n\bcanSteal\030\006 \002(\b\"v\n\nPlayerInfo\022\020\n\bplayerId\030\001 \002(\t\0221\n\rplayerSummary\030\002 \002(\0132\032.pomelo.farm.PlayerSummary\022#\n\007blockLs\030\003 \003(\0132\022.pomelo.farm.Block\"\001\n\fShopItemInfo\022\016\n\006itemId\030\001 \002(\005\022\030\n\020changeNumCurrent\030\002 \002(\005\022\024\n\fchangeNumMax\030\003 \002(\005\022$\n\004need\030\004 \003(\0132\026.pomelo.KeyValueStruct\022%\n\005award\030\005 \003(\0132\026.pomelo.KeyValueStruct" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7200 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 7204 */           Farm.descriptor = root;
/* 7205 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 7209 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 7211 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 7214 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_Block_descriptor = getDescriptor().getMessageTypes().get(0);
/* 7215 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_Block_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_Block_descriptor, new String[] { "BlockId", "BlockState", "SeedCode", "SeedState", "CultivateType", "HarvestTime", "ProtectEndTime" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7220 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_Seed_descriptor = getDescriptor().getMessageTypes().get(1);
/* 7221 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_Seed_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_Seed_descriptor, new String[] { "SeedCode", "Num" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7226 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_Product_descriptor = getDescriptor().getMessageTypes().get(2);
/* 7227 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_Product_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_Product_descriptor, new String[] { "ProductCode", "Num" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7232 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_RecordInfo_descriptor = getDescriptor().getMessageTypes().get(3);
/* 7233 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_RecordInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_RecordInfo_descriptor, new String[] { "RecordType", "RecordTimeStamp", "RecordParams" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7238 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_PlayerSummary_descriptor = getDescriptor().getMessageTypes().get(4);
/* 7239 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_PlayerSummary_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_PlayerSummary_descriptor, new String[] { "PlayerId", "RoleName", "Lv", "FarmLv", "CanSow", "CanSteal" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7244 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_PlayerInfo_descriptor = getDescriptor().getMessageTypes().get(5);
/* 7245 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_PlayerInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_PlayerInfo_descriptor, new String[] { "PlayerId", "PlayerSummary", "BlockLs" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7250 */   private static final Descriptors.Descriptor internal_static_pomelo_farm_ShopItemInfo_descriptor = getDescriptor().getMessageTypes().get(6);
/* 7251 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_ShopItemInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_ShopItemInfo_descriptor, new String[] { "ItemId", "ChangeNumCurrent", "ChangeNumMax", "Need", "Award" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 7255 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface ShopItemInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasItemId();
/*      */     
/*      */     int getItemId();
/*      */     
/*      */     boolean hasChangeNumCurrent();
/*      */     
/*      */     int getChangeNumCurrent();
/*      */     
/*      */     boolean hasChangeNumMax();
/*      */     
/*      */     int getChangeNumMax();
/*      */     
/*      */     List<Common.KeyValueStruct> getNeedList();
/*      */     
/*      */     Common.KeyValueStruct getNeed(int param1Int);
/*      */     
/*      */     int getNeedCount();
/*      */     
/*      */     List<? extends Common.KeyValueStructOrBuilder> getNeedOrBuilderList();
/*      */     
/*      */     Common.KeyValueStructOrBuilder getNeedOrBuilder(int param1Int);
/*      */     
/*      */     List<Common.KeyValueStruct> getAwardList();
/*      */     
/*      */     Common.KeyValueStruct getAward(int param1Int);
/*      */     
/*      */     int getAwardCount();
/*      */     
/*      */     List<? extends Common.KeyValueStructOrBuilder> getAwardOrBuilderList();
/*      */     
/*      */     Common.KeyValueStructOrBuilder getAwardOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface PlayerInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasPlayerId();
/*      */     
/*      */     String getPlayerId();
/*      */     
/*      */     ByteString getPlayerIdBytes();
/*      */     
/*      */     boolean hasPlayerSummary();
/*      */     
/*      */     Farm.PlayerSummary getPlayerSummary();
/*      */     
/*      */     Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder();
/*      */     
/*      */     List<Farm.Block> getBlockLsList();
/*      */     
/*      */     Farm.Block getBlockLs(int param1Int);
/*      */     
/*      */     int getBlockLsCount();
/*      */     
/*      */     List<? extends Farm.BlockOrBuilder> getBlockLsOrBuilderList();
/*      */     
/*      */     Farm.BlockOrBuilder getBlockLsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface PlayerSummaryOrBuilder extends MessageOrBuilder {
/*      */     boolean hasPlayerId();
/*      */     
/*      */     String getPlayerId();
/*      */     
/*      */     ByteString getPlayerIdBytes();
/*      */     
/*      */     boolean hasRoleName();
/*      */     
/*      */     String getRoleName();
/*      */     
/*      */     ByteString getRoleNameBytes();
/*      */     
/*      */     boolean hasLv();
/*      */     
/*      */     int getLv();
/*      */     
/*      */     boolean hasFarmLv();
/*      */     
/*      */     int getFarmLv();
/*      */     
/*      */     boolean hasCanSow();
/*      */     
/*      */     boolean getCanSow();
/*      */     
/*      */     boolean hasCanSteal();
/*      */     
/*      */     boolean getCanSteal();
/*      */   }
/*      */   
/*      */   public static interface RecordInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasRecordType();
/*      */     
/*      */     int getRecordType();
/*      */     
/*      */     boolean hasRecordTimeStamp();
/*      */     
/*      */     long getRecordTimeStamp();
/*      */     
/*      */     ProtocolStringList getRecordParamsList();
/*      */     
/*      */     int getRecordParamsCount();
/*      */     
/*      */     String getRecordParams(int param1Int);
/*      */     
/*      */     ByteString getRecordParamsBytes(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface ProductOrBuilder extends MessageOrBuilder {
/*      */     boolean hasProductCode();
/*      */     
/*      */     String getProductCode();
/*      */     
/*      */     ByteString getProductCodeBytes();
/*      */     
/*      */     boolean hasNum();
/*      */     
/*      */     int getNum();
/*      */   }
/*      */   
/*      */   public static interface SeedOrBuilder extends MessageOrBuilder {
/*      */     boolean hasSeedCode();
/*      */     
/*      */     String getSeedCode();
/*      */     
/*      */     ByteString getSeedCodeBytes();
/*      */     
/*      */     boolean hasNum();
/*      */     
/*      */     int getNum();
/*      */   }
/*      */   
/*      */   public static interface BlockOrBuilder extends MessageOrBuilder {
/*      */     boolean hasBlockId();
/*      */     
/*      */     int getBlockId();
/*      */     
/*      */     boolean hasBlockState();
/*      */     
/*      */     int getBlockState();
/*      */     
/*      */     boolean hasSeedCode();
/*      */     
/*      */     String getSeedCode();
/*      */     
/*      */     ByteString getSeedCodeBytes();
/*      */     
/*      */     boolean hasSeedState();
/*      */     
/*      */     int getSeedState();
/*      */     
/*      */     boolean hasCultivateType();
/*      */     
/*      */     int getCultivateType();
/*      */     
/*      */     boolean hasHarvestTime();
/*      */     
/*      */     long getHarvestTime();
/*      */     
/*      */     boolean hasProtectEndTime();
/*      */     
/*      */     long getProtectEndTime();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\farm\Farm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */