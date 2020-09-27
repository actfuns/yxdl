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
/*      */ import com.google.protobuf.SingleFieldBuilder;
/*      */ import com.google.protobuf.UnknownFieldSet;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ import java.util.ArrayList;
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
/*      */ public final class DemonTowerHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class DemontTowerRewardItem
/*      */     extends GeneratedMessage
/*      */     implements DemontTowerRewardItemOrBuilder
/*      */   {
/*  574 */     private static final DemontTowerRewardItem defaultInstance = new DemontTowerRewardItem(true); private final UnknownFieldSet unknownFields; private DemontTowerRewardItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DemontTowerRewardItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DemontTowerRewardItem getDefaultInstance() { return defaultInstance; } public DemontTowerRewardItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DemontTowerRewardItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.code_ = bs; break;case 16: this.bitField0_ |= 0x2; this.value_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_DemontTowerRewardItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_DemontTowerRewardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(DemontTowerRewardItem.class, Builder.class); } public static Parser<DemontTowerRewardItem> PARSER = (Parser<DemontTowerRewardItem>)new AbstractParser<DemontTowerRewardItem>() { public DemonTowerHandler.DemontTowerRewardItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.DemontTowerRewardItem(input, extensionRegistry); } }
/*  575 */     ; private int bitField0_; public static final int CODE_FIELD_NUMBER = 1; private Object code_; public static final int VALUE_FIELD_NUMBER = 2; private int value_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DemontTowerRewardItem> getParserForType() { return PARSER; } public boolean hasCode() { return ((this.bitField0_ & 0x1) == 1); } public String getCode() { Object ref = this.code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasValue() {
/*      */       return ((this.bitField0_ & 0x2) == 2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/*      */       return this.value_;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.code_ = "";
/*      */       this.value_ = 0;
/*      */     }
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
/*      */       if (!hasCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasValue()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.value_);
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeBytesSize(1, getCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.value_);
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(InputStream input) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(CodedInputStream input) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DemontTowerRewardItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DemontTowerRewardItem)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(DemontTowerRewardItem prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements DemonTowerHandler.DemontTowerRewardItemOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */       
/*      */       private Object code_;
/*      */ 
/*      */       
/*      */       private int value_;
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_DemontTowerRewardItem_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_DemontTowerRewardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.DemontTowerRewardItem.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.code_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.code_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (DemonTowerHandler.DemontTowerRewardItem.alwaysUseFieldBuilders);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.code_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.value_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_DemontTowerRewardItem_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.DemontTowerRewardItem getDefaultInstanceForType() {
/*      */         return DemonTowerHandler.DemontTowerRewardItem.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.DemontTowerRewardItem build() {
/*      */         DemonTowerHandler.DemontTowerRewardItem result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.DemontTowerRewardItem buildPartial() {
/*      */         DemonTowerHandler.DemontTowerRewardItem result = new DemonTowerHandler.DemontTowerRewardItem(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.code_ = this.code_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.value_ = this.value_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof DemonTowerHandler.DemontTowerRewardItem) {
/*      */           return mergeFrom((DemonTowerHandler.DemontTowerRewardItem)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(DemonTowerHandler.DemontTowerRewardItem other) {
/*      */         if (other == DemonTowerHandler.DemontTowerRewardItem.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasCode()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.code_ = other.code_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasValue()) {
/*      */           setValue(other.getValue());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasCode()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasValue()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         DemonTowerHandler.DemontTowerRewardItem parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.DemontTowerRewardItem)DemonTowerHandler.DemontTowerRewardItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.DemontTowerRewardItem)e.getUnfinishedMessage();
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
/*      */       public boolean hasCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public String getCode() {
/*      */         Object ref = this.code_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.code_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */       
/*      */       public ByteString getCodeBytes() {
/*      */         Object ref = this.code_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.code_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setCode(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.code_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.code_ = DemonTowerHandler.DemontTowerRewardItem.getDefaultInstance().getCode();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setCodeBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.code_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasValue() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getValue() {
/*      */         return this.value_;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setValue(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.value_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearValue() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.value_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static final class GetDemonTowerInfoRequest
/*      */     extends GeneratedMessage
/*      */     implements GetDemonTowerInfoRequestOrBuilder
/*      */   {
/* 1011 */     private static final GetDemonTowerInfoRequest defaultInstance = new GetDemonTowerInfoRequest(true); private final UnknownFieldSet unknownFields; private GetDemonTowerInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDemonTowerInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDemonTowerInfoRequest getDefaultInstance() { return defaultInstance; } public GetDemonTowerInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDemonTowerInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.floorId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDemonTowerInfoRequest.class, Builder.class); } public static Parser<GetDemonTowerInfoRequest> PARSER = (Parser<GetDemonTowerInfoRequest>)new AbstractParser<GetDemonTowerInfoRequest>() { public DemonTowerHandler.GetDemonTowerInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.GetDemonTowerInfoRequest(input, extensionRegistry); } }; private int bitField0_; public static final int FLOORID_FIELD_NUMBER = 1; private int floorId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDemonTowerInfoRequest> getParserForType() { return PARSER; } public boolean hasFloorId() { return ((this.bitField0_ & 0x1) == 1); } public int getFloorId() { return this.floorId_; } private void initFields() { this.floorId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.floorId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.floorId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetDemonTowerInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(data); } public static GetDemonTowerInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDemonTowerInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(data); } public static GetDemonTowerInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDemonTowerInfoRequest parseFrom(InputStream input) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(input); } public static GetDemonTowerInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetDemonTowerInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseDelimitedFrom(input); } public static GetDemonTowerInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetDemonTowerInfoRequest parseFrom(CodedInputStream input) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(input); } public static GetDemonTowerInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetDemonTowerInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.GetDemonTowerInfoRequestOrBuilder {
/* 1012 */       private int bitField0_; private int floorId_; public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.GetDemonTowerInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DemonTowerHandler.GetDemonTowerInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.floorId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoRequest_descriptor; } public DemonTowerHandler.GetDemonTowerInfoRequest getDefaultInstanceForType() { return DemonTowerHandler.GetDemonTowerInfoRequest.getDefaultInstance(); } public DemonTowerHandler.GetDemonTowerInfoRequest build() { DemonTowerHandler.GetDemonTowerInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DemonTowerHandler.GetDemonTowerInfoRequest buildPartial() { DemonTowerHandler.GetDemonTowerInfoRequest result = new DemonTowerHandler.GetDemonTowerInfoRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.floorId_ = this.floorId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.GetDemonTowerInfoRequest) return mergeFrom((DemonTowerHandler.GetDemonTowerInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DemonTowerHandler.GetDemonTowerInfoRequest other) { if (other == DemonTowerHandler.GetDemonTowerInfoRequest.getDefaultInstance()) return this;  if (other.hasFloorId()) setFloorId(other.getFloorId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.GetDemonTowerInfoRequest parsedMessage = null; try { parsedMessage = (DemonTowerHandler.GetDemonTowerInfoRequest)DemonTowerHandler.GetDemonTowerInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.GetDemonTowerInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasFloorId() { return ((this.bitField0_ & 0x1) == 1); } public int getFloorId() { return this.floorId_; } public Builder setFloorId(int value) { this.bitField0_ |= 0x1; this.floorId_ = value; onChanged(); return this; } public Builder clearFloorId() { this.bitField0_ &= 0xFFFFFFFE; this.floorId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetDemonTowerInfoResponse
/*      */     extends GeneratedMessage
/*      */     implements GetDemonTowerInfoResponseOrBuilder
/*      */   {
/* 2178 */     private static final GetDemonTowerInfoResponse defaultInstance = new GetDemonTowerInfoResponse(true); private final UnknownFieldSet unknownFields; private GetDemonTowerInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDemonTowerInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDemonTowerInfoResponse getDefaultInstance() { return defaultInstance; } public GetDemonTowerInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDemonTowerInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; Common.DemonTowerFloorInfo.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.maxFloor_ = input.readInt32(); break;case 34: subBuilder = null; if ((this.bitField0_ & 0x8) == 8) subBuilder = this.demonTowerFloorInfo_.toBuilder();  this.demonTowerFloorInfo_ = (Common.DemonTowerFloorInfo)input.readMessage(Common.DemonTowerFloorInfo.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.demonTowerFloorInfo_); this.demonTowerFloorInfo_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x8; break;case 40: this.bitField0_ |= 0x10; this.fcValue_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.sweepCountLeft_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.sweepCountMax_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDemonTowerInfoResponse.class, Builder.class); } public static Parser<GetDemonTowerInfoResponse> PARSER = (Parser<GetDemonTowerInfoResponse>)new AbstractParser<GetDemonTowerInfoResponse>() { public DemonTowerHandler.GetDemonTowerInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.GetDemonTowerInfoResponse(input, extensionRegistry); } }
/* 2179 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int MAXFLOOR_FIELD_NUMBER = 3; private int maxFloor_; public static final int DEMONTOWERFLOORINFO_FIELD_NUMBER = 4; private Common.DemonTowerFloorInfo demonTowerFloorInfo_; public static final int FCVALUE_FIELD_NUMBER = 5; private int fcValue_; public static final int SWEEPCOUNTLEFT_FIELD_NUMBER = 6; private int sweepCountLeft_; public static final int SWEEPCOUNTMAX_FIELD_NUMBER = 7; private int sweepCountMax_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDemonTowerInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b;
/*      */       }  return (ByteString)ref; }
/*      */     public boolean hasMaxFloor() { return ((this.bitField0_ & 0x4) == 4); }
/*      */     public int getMaxFloor() { return this.maxFloor_; }
/*      */     public boolean hasDemonTowerFloorInfo() { return ((this.bitField0_ & 0x8) == 8); }
/*      */     public Common.DemonTowerFloorInfo getDemonTowerFloorInfo() { return this.demonTowerFloorInfo_; }
/*      */     public Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder() { return (Common.DemonTowerFloorInfoOrBuilder)this.demonTowerFloorInfo_; }
/*      */     public boolean hasFcValue() { return ((this.bitField0_ & 0x10) == 16); }
/*      */     public int getFcValue() { return this.fcValue_; }
/*      */     public boolean hasSweepCountLeft() { return ((this.bitField0_ & 0x20) == 32); }
/*      */     public int getSweepCountLeft() { return this.sweepCountLeft_; }
/*      */     public boolean hasSweepCountMax() { return ((this.bitField0_ & 0x40) == 64); }
/*      */     public int getSweepCountMax() { return this.sweepCountMax_; }
/*      */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.maxFloor_ = 0; this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance(); this.fcValue_ = 0; this.sweepCountLeft_ = 0; this.sweepCountMax_ = 0; }
/*      */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*      */         return true;  if (isInitialized == 0)
/*      */         return false;  if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  if (hasDemonTowerFloorInfo() && !getDemonTowerFloorInfo().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  this.memoizedIsInitialized = 1; return true; }
/*      */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(3, this.maxFloor_);  if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeMessage(4, (MessageLite)this.demonTowerFloorInfo_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeInt32(5, this.fcValue_); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         output.writeInt32(6, this.sweepCountLeft_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         output.writeInt32(7, this.sweepCountMax_); 
/*      */       getUnknownFields().writeTo(output); }
/*      */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(3, this.maxFloor_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.demonTowerFloorInfo_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeInt32Size(5, this.fcValue_); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         size += CodedOutputStream.computeInt32Size(6, this.sweepCountLeft_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         size += CodedOutputStream.computeInt32Size(7, this.sweepCountMax_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size; }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(data); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(data); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(InputStream input) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(input); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static GetDemonTowerInfoResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static GetDemonTowerInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(CodedInputStream input) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(input); }
/*      */     public static GetDemonTowerInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(GetDemonTowerInfoResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*      */       return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.GetDemonTowerInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int maxFloor_; private Common.DemonTowerFloorInfo demonTowerFloorInfo_; private SingleFieldBuilder<Common.DemonTowerFloorInfo, Common.DemonTowerFloorInfo.Builder, Common.DemonTowerFloorInfoOrBuilder> demonTowerFloorInfoBuilder_; private int fcValue_; private int sweepCountLeft_; private int sweepCountMax_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.GetDemonTowerInfoResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = "";
/*      */         this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
/*      */         maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
/*      */         maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (DemonTowerHandler.GetDemonTowerInfoResponse.alwaysUseFieldBuilders)
/*      */           getDemonTowerFloorInfoFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.maxFloor_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
/*      */         } else {
/*      */           this.demonTowerFloorInfoBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.fcValue_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.sweepCountLeft_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.sweepCountMax_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerInfoResponse_descriptor; }
/*      */       public DemonTowerHandler.GetDemonTowerInfoResponse getDefaultInstanceForType() { return DemonTowerHandler.GetDemonTowerInfoResponse.getDefaultInstance(); }
/*      */       public DemonTowerHandler.GetDemonTowerInfoResponse build() { DemonTowerHandler.GetDemonTowerInfoResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result; }
/*      */       public DemonTowerHandler.GetDemonTowerInfoResponse buildPartial() { DemonTowerHandler.GetDemonTowerInfoResponse result = new DemonTowerHandler.GetDemonTowerInfoResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.maxFloor_ = this.maxFloor_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           result.demonTowerFloorInfo_ = this.demonTowerFloorInfo_;
/*      */         } else {
/*      */           result.demonTowerFloorInfo_ = (Common.DemonTowerFloorInfo)this.demonTowerFloorInfoBuilder_.build();
/*      */         } 
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.fcValue_ = this.fcValue_;
/*      */         if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x20; 
/*      */         result.sweepCountLeft_ = this.sweepCountLeft_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x40; 
/*      */         result.sweepCountMax_ = this.sweepCountMax_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.GetDemonTowerInfoResponse)
/*      */           return mergeFrom((DemonTowerHandler.GetDemonTowerInfoResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this; }
/*      */       public Builder mergeFrom(DemonTowerHandler.GetDemonTowerInfoResponse other) { if (other == DemonTowerHandler.GetDemonTowerInfoResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasMaxFloor())
/*      */           setMaxFloor(other.getMaxFloor()); 
/*      */         if (other.hasDemonTowerFloorInfo())
/*      */           mergeDemonTowerFloorInfo(other.getDemonTowerFloorInfo()); 
/*      */         if (other.hasFcValue())
/*      */           setFcValue(other.getFcValue()); 
/*      */         if (other.hasSweepCountLeft())
/*      */           setSweepCountLeft(other.getSweepCountLeft()); 
/*      */         if (other.hasSweepCountMax())
/*      */           setSweepCountMax(other.getSweepCountMax()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false; 
/*      */         if (hasDemonTowerFloorInfo() && !getDemonTowerFloorInfo().isInitialized())
/*      */           return false; 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.GetDemonTowerInfoResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.GetDemonTowerInfoResponse)DemonTowerHandler.GetDemonTowerInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.GetDemonTowerInfoResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DemonTowerHandler.GetDemonTowerInfoResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasMaxFloor() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getMaxFloor() { return this.maxFloor_; }
/*      */       public Builder setMaxFloor(int value) { this.bitField0_ |= 0x4;
/*      */         this.maxFloor_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearMaxFloor() { this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.maxFloor_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasDemonTowerFloorInfo() { return ((this.bitField0_ & 0x8) == 8); }
/*      */       public Common.DemonTowerFloorInfo getDemonTowerFloorInfo() { if (this.demonTowerFloorInfoBuilder_ == null)
/*      */           return this.demonTowerFloorInfo_; 
/*      */         return (Common.DemonTowerFloorInfo)this.demonTowerFloorInfoBuilder_.getMessage(); }
/*      */       public Builder setDemonTowerFloorInfo(Common.DemonTowerFloorInfo value) { if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.demonTowerFloorInfo_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.demonTowerFloorInfoBuilder_.setMessage((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this; }
/*      */       public Builder setDemonTowerFloorInfo(Common.DemonTowerFloorInfo.Builder builderForValue) { if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           this.demonTowerFloorInfo_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.demonTowerFloorInfoBuilder_.setMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this; }
/*      */       public Builder mergeDemonTowerFloorInfo(Common.DemonTowerFloorInfo value) { if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x8) == 8 && this.demonTowerFloorInfo_ != Common.DemonTowerFloorInfo.getDefaultInstance()) {
/*      */             this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.newBuilder(this.demonTowerFloorInfo_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.demonTowerFloorInfo_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.demonTowerFloorInfoBuilder_.mergeFrom((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this; }
/*      */       public Builder clearDemonTowerFloorInfo() { if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.demonTowerFloorInfoBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         return this; }
/*      */       public Common.DemonTowerFloorInfo.Builder getDemonTowerFloorInfoBuilder() { this.bitField0_ |= 0x8;
/*      */         onChanged();
/*      */         return (Common.DemonTowerFloorInfo.Builder)getDemonTowerFloorInfoFieldBuilder().getBuilder(); }
/*      */       public Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder() { if (this.demonTowerFloorInfoBuilder_ != null)
/*      */           return (Common.DemonTowerFloorInfoOrBuilder)this.demonTowerFloorInfoBuilder_.getMessageOrBuilder(); 
/*      */         return (Common.DemonTowerFloorInfoOrBuilder)this.demonTowerFloorInfo_; }
/*      */       private SingleFieldBuilder<Common.DemonTowerFloorInfo, Common.DemonTowerFloorInfo.Builder, Common.DemonTowerFloorInfoOrBuilder> getDemonTowerFloorInfoFieldBuilder() { if (this.demonTowerFloorInfoBuilder_ == null) {
/*      */           this.demonTowerFloorInfoBuilder_ = new SingleFieldBuilder((GeneratedMessage)getDemonTowerFloorInfo(), getParentForChildren(), isClean());
/*      */           this.demonTowerFloorInfo_ = null;
/*      */         } 
/*      */         return this.demonTowerFloorInfoBuilder_; }
/*      */       public boolean hasFcValue() { return ((this.bitField0_ & 0x10) == 16); }
/*      */       public int getFcValue() { return this.fcValue_; }
/*      */       public Builder setFcValue(int value) { this.bitField0_ |= 0x10;
/*      */         this.fcValue_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearFcValue() { this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.fcValue_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasSweepCountLeft() { return ((this.bitField0_ & 0x20) == 32); }
/*      */       public int getSweepCountLeft() { return this.sweepCountLeft_; }
/*      */       public Builder setSweepCountLeft(int value) { this.bitField0_ |= 0x20;
/*      */         this.sweepCountLeft_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearSweepCountLeft() { this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.sweepCountLeft_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasSweepCountMax() { return ((this.bitField0_ & 0x40) == 64); }
/*      */       public int getSweepCountMax() { return this.sweepCountMax_; }
/*      */       public Builder setSweepCountMax(int value) { this.bitField0_ |= 0x40;
/*      */         this.sweepCountMax_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearSweepCountMax() { this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.sweepCountMax_ = 0;
/*      */         onChanged();
/*      */         return this; } } }
/* 2499 */   public static final class GetDemonTowerSweepInfoRequest extends GeneratedMessage implements GetDemonTowerSweepInfoRequestOrBuilder { private static final GetDemonTowerSweepInfoRequest defaultInstance = new GetDemonTowerSweepInfoRequest(true); private final UnknownFieldSet unknownFields; private GetDemonTowerSweepInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDemonTowerSweepInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDemonTowerSweepInfoRequest getDefaultInstance() { return defaultInstance; } public GetDemonTowerSweepInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDemonTowerSweepInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDemonTowerSweepInfoRequest.class, Builder.class); } public static Parser<GetDemonTowerSweepInfoRequest> PARSER = (Parser<GetDemonTowerSweepInfoRequest>)new AbstractParser<GetDemonTowerSweepInfoRequest>() { public DemonTowerHandler.GetDemonTowerSweepInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.GetDemonTowerSweepInfoRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDemonTowerSweepInfoRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetDemonTowerSweepInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(data); } public static GetDemonTowerSweepInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDemonTowerSweepInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(data); } public static GetDemonTowerSweepInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDemonTowerSweepInfoRequest parseFrom(InputStream input) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(input); } public static GetDemonTowerSweepInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetDemonTowerSweepInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseDelimitedFrom(input); } public static GetDemonTowerSweepInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetDemonTowerSweepInfoRequest parseFrom(CodedInputStream input) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(input); } public static GetDemonTowerSweepInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetDemonTowerSweepInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.GetDemonTowerSweepInfoRequestOrBuilder {
/* 2500 */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.GetDemonTowerSweepInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DemonTowerHandler.GetDemonTowerSweepInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_descriptor; } public DemonTowerHandler.GetDemonTowerSweepInfoRequest getDefaultInstanceForType() { return DemonTowerHandler.GetDemonTowerSweepInfoRequest.getDefaultInstance(); } public DemonTowerHandler.GetDemonTowerSweepInfoRequest build() { DemonTowerHandler.GetDemonTowerSweepInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DemonTowerHandler.GetDemonTowerSweepInfoRequest buildPartial() { DemonTowerHandler.GetDemonTowerSweepInfoRequest result = new DemonTowerHandler.GetDemonTowerSweepInfoRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.GetDemonTowerSweepInfoRequest) return mergeFrom((DemonTowerHandler.GetDemonTowerSweepInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DemonTowerHandler.GetDemonTowerSweepInfoRequest other) { if (other == DemonTowerHandler.GetDemonTowerSweepInfoRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.GetDemonTowerSweepInfoRequest parsedMessage = null; try { parsedMessage = (DemonTowerHandler.GetDemonTowerSweepInfoRequest)DemonTowerHandler.GetDemonTowerSweepInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.GetDemonTowerSweepInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GetDemonTowerSweepInfoResponse
/*      */     extends GeneratedMessage
/*      */     implements GetDemonTowerSweepInfoResponseOrBuilder
/*      */   {
/* 3809 */     private static final GetDemonTowerSweepInfoResponse defaultInstance = new GetDemonTowerSweepInfoResponse(true); private final UnknownFieldSet unknownFields; private GetDemonTowerSweepInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDemonTowerSweepInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDemonTowerSweepInfoResponse getDefaultInstance() { return defaultInstance; } public GetDemonTowerSweepInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDemonTowerSweepInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.sweepTime_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.itemView_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.itemView_.add(input.readMessage(DemonTowerHandler.DemontTowerRewardItem.PARSER, extensionRegistry)); break;case 40: this.bitField0_ |= 0x8; this.diamondCost_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x10; this.floor_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x20; this.isSweeping_ = input.readBool(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.itemView_ = Collections.unmodifiableList(this.itemView_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDemonTowerSweepInfoResponse.class, Builder.class); } public static Parser<GetDemonTowerSweepInfoResponse> PARSER = (Parser<GetDemonTowerSweepInfoResponse>)new AbstractParser<GetDemonTowerSweepInfoResponse>() { public DemonTowerHandler.GetDemonTowerSweepInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.GetDemonTowerSweepInfoResponse(input, extensionRegistry); } }
/* 3810 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int SWEEPTIME_FIELD_NUMBER = 3; private int sweepTime_; public static final int ITEMVIEW_FIELD_NUMBER = 4; private List<DemonTowerHandler.DemontTowerRewardItem> itemView_; public static final int DIAMONDCOST_FIELD_NUMBER = 5; private int diamondCost_; public static final int FLOOR_FIELD_NUMBER = 6; private int floor_; public static final int ISSWEEPING_FIELD_NUMBER = 7; private boolean isSweeping_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDemonTowerSweepInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasSweepTime() { return ((this.bitField0_ & 0x4) == 4); } public int getSweepTime() { return this.sweepTime_; } public List<DemonTowerHandler.DemontTowerRewardItem> getItemViewList() { return this.itemView_; } public List<? extends DemonTowerHandler.DemontTowerRewardItemOrBuilder> getItemViewOrBuilderList() { return (List)this.itemView_; } public int getItemViewCount() { return this.itemView_.size(); } public DemonTowerHandler.DemontTowerRewardItem getItemView(int index) { return this.itemView_.get(index); } public DemonTowerHandler.DemontTowerRewardItemOrBuilder getItemViewOrBuilder(int index) { return this.itemView_.get(index); } public boolean hasDiamondCost() { return ((this.bitField0_ & 0x8) == 8); } public int getDiamondCost() { return this.diamondCost_; } public boolean hasFloor() { return ((this.bitField0_ & 0x10) == 16); } public int getFloor() { return this.floor_; } public boolean hasIsSweeping() { return ((this.bitField0_ & 0x20) == 32); } public boolean getIsSweeping() { return this.isSweeping_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.sweepTime_ = 0; this.itemView_ = Collections.emptyList(); this.diamondCost_ = 0; this.floor_ = 0; this.isSweeping_ = false; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getItemViewCount(); i++) { if (!getItemView(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.sweepTime_);  for (int i = 0; i < this.itemView_.size(); i++) output.writeMessage(4, (MessageLite)this.itemView_.get(i));  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(5, this.diamondCost_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(6, this.floor_);  if ((this.bitField0_ & 0x20) == 32) output.writeBool(7, this.isSweeping_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.sweepTime_);  for (int i = 0; i < this.itemView_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.itemView_.get(i));  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(5, this.diamondCost_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(6, this.floor_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeBoolSize(7, this.isSweeping_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } static { defaultInstance.initFields(); }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(data); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(data); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(InputStream input) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(input); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static GetDemonTowerSweepInfoResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static GetDemonTowerSweepInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(CodedInputStream input) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(input); }
/*      */     public static GetDemonTowerSweepInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDemonTowerSweepInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(GetDemonTowerSweepInfoResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.GetDemonTowerSweepInfoResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private int sweepTime_;
/*      */       private List<DemonTowerHandler.DemontTowerRewardItem> itemView_;
/*      */       private RepeatedFieldBuilder<DemonTowerHandler.DemontTowerRewardItem, DemonTowerHandler.DemontTowerRewardItem.Builder, DemonTowerHandler.DemontTowerRewardItemOrBuilder> itemViewBuilder_;
/*      */       private int diamondCost_;
/*      */       private int floor_;
/*      */       private boolean isSweeping_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.GetDemonTowerSweepInfoResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.itemView_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.itemView_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (DemonTowerHandler.GetDemonTowerSweepInfoResponse.alwaysUseFieldBuilders)
/*      */           getItemViewFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.sweepTime_ = 0; this.bitField0_ &= 0xFFFFFFFB; if (this.itemViewBuilder_ == null) {
/*      */           this.itemView_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7;
/*      */         } else {
/*      */           this.itemViewBuilder_.clear();
/*      */         }  this.diamondCost_ = 0; this.bitField0_ &= 0xFFFFFFEF; this.floor_ = 0; this.bitField0_ &= 0xFFFFFFDF; this.isSweeping_ = false; this.bitField0_ &= 0xFFFFFFBF; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_descriptor; }
/*      */       public DemonTowerHandler.GetDemonTowerSweepInfoResponse getDefaultInstanceForType() { return DemonTowerHandler.GetDemonTowerSweepInfoResponse.getDefaultInstance(); }
/*      */       public DemonTowerHandler.GetDemonTowerSweepInfoResponse build() { DemonTowerHandler.GetDemonTowerSweepInfoResponse result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result; }
/*      */       public DemonTowerHandler.GetDemonTowerSweepInfoResponse buildPartial() { DemonTowerHandler.GetDemonTowerSweepInfoResponse result = new DemonTowerHandler.GetDemonTowerSweepInfoResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.sweepTime_ = this.sweepTime_;
/*      */         if (this.itemViewBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x8) == 8) {
/*      */             this.itemView_ = Collections.unmodifiableList(this.itemView_);
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */           } 
/*      */           result.itemView_ = this.itemView_;
/*      */         } else {
/*      */           result.itemView_ = this.itemViewBuilder_.build();
/*      */         } 
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.diamondCost_ = this.diamondCost_;
/*      */         if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.floor_ = this.floor_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x20; 
/*      */         result.isSweeping_ = this.isSweeping_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.GetDemonTowerSweepInfoResponse)
/*      */           return mergeFrom((DemonTowerHandler.GetDemonTowerSweepInfoResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this; }
/*      */       public Builder mergeFrom(DemonTowerHandler.GetDemonTowerSweepInfoResponse other) { if (other == DemonTowerHandler.GetDemonTowerSweepInfoResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasSweepTime())
/*      */           setSweepTime(other.getSweepTime()); 
/*      */         if (this.itemViewBuilder_ == null) {
/*      */           if (!other.itemView_.isEmpty()) {
/*      */             if (this.itemView_.isEmpty()) {
/*      */               this.itemView_ = other.itemView_;
/*      */               this.bitField0_ &= 0xFFFFFFF7;
/*      */             } else {
/*      */               ensureItemViewIsMutable();
/*      */               this.itemView_.addAll(other.itemView_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.itemView_.isEmpty()) {
/*      */           if (this.itemViewBuilder_.isEmpty()) {
/*      */             this.itemViewBuilder_.dispose();
/*      */             this.itemViewBuilder_ = null;
/*      */             this.itemView_ = other.itemView_;
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */             this.itemViewBuilder_ = DemonTowerHandler.GetDemonTowerSweepInfoResponse.alwaysUseFieldBuilders ? getItemViewFieldBuilder() : null;
/*      */           } else {
/*      */             this.itemViewBuilder_.addAllMessages(other.itemView_);
/*      */           } 
/*      */         } 
/*      */         if (other.hasDiamondCost())
/*      */           setDiamondCost(other.getDiamondCost()); 
/*      */         if (other.hasFloor())
/*      */           setFloor(other.getFloor()); 
/*      */         if (other.hasIsSweeping())
/*      */           setIsSweeping(other.getIsSweeping()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false; 
/*      */         for (int i = 0; i < getItemViewCount(); i++) {
/*      */           if (!getItemView(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.GetDemonTowerSweepInfoResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.GetDemonTowerSweepInfoResponse)DemonTowerHandler.GetDemonTowerSweepInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.GetDemonTowerSweepInfoResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DemonTowerHandler.GetDemonTowerSweepInfoResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasSweepTime() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getSweepTime() { return this.sweepTime_; }
/*      */       public Builder setSweepTime(int value) { this.bitField0_ |= 0x4;
/*      */         this.sweepTime_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearSweepTime() { this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.sweepTime_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       private void ensureItemViewIsMutable() { if ((this.bitField0_ & 0x8) != 8) {
/*      */           this.itemView_ = new ArrayList<>(this.itemView_);
/*      */           this.bitField0_ |= 0x8;
/*      */         }  }
/*      */       public List<DemonTowerHandler.DemontTowerRewardItem> getItemViewList() { if (this.itemViewBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.itemView_); 
/*      */         return this.itemViewBuilder_.getMessageList(); }
/*      */       public int getItemViewCount() { if (this.itemViewBuilder_ == null)
/*      */           return this.itemView_.size(); 
/*      */         return this.itemViewBuilder_.getCount(); }
/*      */       public DemonTowerHandler.DemontTowerRewardItem getItemView(int index) { if (this.itemViewBuilder_ == null)
/*      */           return this.itemView_.get(index); 
/*      */         return (DemonTowerHandler.DemontTowerRewardItem)this.itemViewBuilder_.getMessage(index); }
/*      */       public Builder setItemView(int index, DemonTowerHandler.DemontTowerRewardItem value) { if (this.itemViewBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setItemView(int index, DemonTowerHandler.DemontTowerRewardItem.Builder builderForValue) { if (this.itemViewBuilder_ == null) {
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addItemView(DemonTowerHandler.DemontTowerRewardItem value) { if (this.itemViewBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.addMessage(value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addItemView(int index, DemonTowerHandler.DemontTowerRewardItem value) { if (this.itemViewBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addItemView(DemonTowerHandler.DemontTowerRewardItem.Builder builderForValue) { if (this.itemViewBuilder_ == null) {
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addItemView(int index, DemonTowerHandler.DemontTowerRewardItem.Builder builderForValue) { if (this.itemViewBuilder_ == null) {
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAllItemView(Iterable<? extends DemonTowerHandler.DemontTowerRewardItem> values) { if (this.itemViewBuilder_ == null) {
/*      */           ensureItemViewIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.itemView_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; }
/*      */       public Builder clearItemView() { if (this.itemViewBuilder_ == null) {
/*      */           this.itemView_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder removeItemView(int index) { if (this.itemViewBuilder_ == null) {
/*      */           ensureItemViewIsMutable();
/*      */           this.itemView_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.itemViewBuilder_.remove(index);
/*      */         } 
/*      */         return this; }
/*      */       public DemonTowerHandler.DemontTowerRewardItem.Builder getItemViewBuilder(int index) { return (DemonTowerHandler.DemontTowerRewardItem.Builder)getItemViewFieldBuilder().getBuilder(index); }
/*      */       public DemonTowerHandler.DemontTowerRewardItemOrBuilder getItemViewOrBuilder(int index) { if (this.itemViewBuilder_ == null)
/*      */           return this.itemView_.get(index); 
/*      */         return (DemonTowerHandler.DemontTowerRewardItemOrBuilder)this.itemViewBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends DemonTowerHandler.DemontTowerRewardItemOrBuilder> getItemViewOrBuilderList() { if (this.itemViewBuilder_ != null)
/*      */           return this.itemViewBuilder_.getMessageOrBuilderList(); 
/*      */         return Collections.unmodifiableList((List)this.itemView_); }
/*      */       public DemonTowerHandler.DemontTowerRewardItem.Builder addItemViewBuilder() { return (DemonTowerHandler.DemontTowerRewardItem.Builder)getItemViewFieldBuilder().addBuilder(DemonTowerHandler.DemontTowerRewardItem.getDefaultInstance()); }
/*      */       public DemonTowerHandler.DemontTowerRewardItem.Builder addItemViewBuilder(int index) { return (DemonTowerHandler.DemontTowerRewardItem.Builder)getItemViewFieldBuilder().addBuilder(index, DemonTowerHandler.DemontTowerRewardItem.getDefaultInstance()); }
/*      */       public List<DemonTowerHandler.DemontTowerRewardItem.Builder> getItemViewBuilderList() { return getItemViewFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<DemonTowerHandler.DemontTowerRewardItem, DemonTowerHandler.DemontTowerRewardItem.Builder, DemonTowerHandler.DemontTowerRewardItemOrBuilder> getItemViewFieldBuilder() { if (this.itemViewBuilder_ == null) {
/*      */           this.itemViewBuilder_ = new RepeatedFieldBuilder(this.itemView_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*      */           this.itemView_ = null;
/*      */         } 
/*      */         return this.itemViewBuilder_; } public boolean hasDiamondCost() { return ((this.bitField0_ & 0x10) == 16); } public int getDiamondCost() { return this.diamondCost_; } public Builder setDiamondCost(int value) { this.bitField0_ |= 0x10;
/*      */         this.diamondCost_ = value;
/*      */         onChanged();
/*      */         return this; } public Builder clearDiamondCost() { this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.diamondCost_ = 0;
/*      */         onChanged();
/*      */         return this; } public boolean hasFloor() { return ((this.bitField0_ & 0x20) == 32); } public int getFloor() { return this.floor_; } public Builder setFloor(int value) { this.bitField0_ |= 0x20;
/*      */         this.floor_ = value;
/*      */         onChanged();
/*      */         return this; } public Builder clearFloor() { this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.floor_ = 0;
/*      */         onChanged();
/*      */         return this; } public boolean hasIsSweeping() { return ((this.bitField0_ & 0x40) == 64); } public boolean getIsSweeping() { return this.isSweeping_; } public Builder setIsSweeping(boolean value) { this.bitField0_ |= 0x40;
/*      */         this.isSweeping_ = value;
/*      */         onChanged();
/*      */         return this; } public Builder clearIsSweeping() { this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.isSweeping_ = false;
/*      */         onChanged();
/*      */         return this; }
/*      */     }
/*      */   } public static final class StartToSweepDemonTowerRequest extends GeneratedMessage implements StartToSweepDemonTowerRequestOrBuilder {
/* 4130 */     private static final StartToSweepDemonTowerRequest defaultInstance = new StartToSweepDemonTowerRequest(true); private final UnknownFieldSet unknownFields; private StartToSweepDemonTowerRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StartToSweepDemonTowerRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StartToSweepDemonTowerRequest getDefaultInstance() { return defaultInstance; } public StartToSweepDemonTowerRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StartToSweepDemonTowerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(StartToSweepDemonTowerRequest.class, Builder.class); } public static Parser<StartToSweepDemonTowerRequest> PARSER = (Parser<StartToSweepDemonTowerRequest>)new AbstractParser<StartToSweepDemonTowerRequest>() { public DemonTowerHandler.StartToSweepDemonTowerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.StartToSweepDemonTowerRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StartToSweepDemonTowerRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static StartToSweepDemonTowerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(data); } public static StartToSweepDemonTowerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static StartToSweepDemonTowerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(data); } public static StartToSweepDemonTowerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static StartToSweepDemonTowerRequest parseFrom(InputStream input) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(input); } public static StartToSweepDemonTowerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static StartToSweepDemonTowerRequest parseDelimitedFrom(InputStream input) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseDelimitedFrom(input); } public static StartToSweepDemonTowerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static StartToSweepDemonTowerRequest parseFrom(CodedInputStream input) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(input); } public static StartToSweepDemonTowerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartToSweepDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(StartToSweepDemonTowerRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.StartToSweepDemonTowerRequestOrBuilder {
/* 4131 */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.StartToSweepDemonTowerRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DemonTowerHandler.StartToSweepDemonTowerRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerRequest_descriptor; } public DemonTowerHandler.StartToSweepDemonTowerRequest getDefaultInstanceForType() { return DemonTowerHandler.StartToSweepDemonTowerRequest.getDefaultInstance(); } public DemonTowerHandler.StartToSweepDemonTowerRequest build() { DemonTowerHandler.StartToSweepDemonTowerRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DemonTowerHandler.StartToSweepDemonTowerRequest buildPartial() { DemonTowerHandler.StartToSweepDemonTowerRequest result = new DemonTowerHandler.StartToSweepDemonTowerRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.StartToSweepDemonTowerRequest) return mergeFrom((DemonTowerHandler.StartToSweepDemonTowerRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DemonTowerHandler.StartToSweepDemonTowerRequest other) { if (other == DemonTowerHandler.StartToSweepDemonTowerRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.StartToSweepDemonTowerRequest parsedMessage = null; try { parsedMessage = (DemonTowerHandler.StartToSweepDemonTowerRequest)DemonTowerHandler.StartToSweepDemonTowerRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.StartToSweepDemonTowerRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class StartToSweepDemonTowerResponse
/*      */     extends GeneratedMessage
/*      */     implements StartToSweepDemonTowerResponseOrBuilder
/*      */   {
/* 4770 */     private static final StartToSweepDemonTowerResponse defaultInstance = new StartToSweepDemonTowerResponse(true); private final UnknownFieldSet unknownFields; private StartToSweepDemonTowerResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StartToSweepDemonTowerResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StartToSweepDemonTowerResponse getDefaultInstance() { return defaultInstance; } public StartToSweepDemonTowerResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StartToSweepDemonTowerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.endTimeStamp_ = input.readInt64(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(StartToSweepDemonTowerResponse.class, Builder.class); } public static Parser<StartToSweepDemonTowerResponse> PARSER = (Parser<StartToSweepDemonTowerResponse>)new AbstractParser<StartToSweepDemonTowerResponse>() { public DemonTowerHandler.StartToSweepDemonTowerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.StartToSweepDemonTowerResponse(input, extensionRegistry); } }
/* 4771 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int ENDTIMESTAMP_FIELD_NUMBER = 3; private long endTimeStamp_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StartToSweepDemonTowerResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getS2CMsg() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.s2CMsg_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */     
/*      */     public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasEndTimeStamp() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public long getEndTimeStamp() {
/*      */       return this.endTimeStamp_;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.endTimeStamp_ = 0L;
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
/*      */       if (!hasS2CCode()) {
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
/*      */         output.writeInt32(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getS2CMsgBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeInt64(3, this.endTimeStamp_);
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeInt64Size(3, this.endTimeStamp_);
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
/*      */     public static StartToSweepDemonTowerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(InputStream input) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static StartToSweepDemonTowerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartToSweepDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(StartToSweepDemonTowerResponse prototype) {
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
/*      */       implements DemonTowerHandler.StartToSweepDemonTowerResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       
/*      */       private int s2CCode_;
/*      */       
/*      */       private Object s2CMsg_;
/*      */       
/*      */       private long endTimeStamp_;
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.StartToSweepDemonTowerResponse.class, Builder.class);
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (DemonTowerHandler.StartToSweepDemonTowerResponse.alwaysUseFieldBuilders);
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
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.endTimeStamp_ = 0L;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
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
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartToSweepDemonTowerResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.StartToSweepDemonTowerResponse getDefaultInstanceForType() {
/*      */         return DemonTowerHandler.StartToSweepDemonTowerResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.StartToSweepDemonTowerResponse build() {
/*      */         DemonTowerHandler.StartToSweepDemonTowerResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.StartToSweepDemonTowerResponse buildPartial() {
/*      */         DemonTowerHandler.StartToSweepDemonTowerResponse result = new DemonTowerHandler.StartToSweepDemonTowerResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.endTimeStamp_ = this.endTimeStamp_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof DemonTowerHandler.StartToSweepDemonTowerResponse) {
/*      */           return mergeFrom((DemonTowerHandler.StartToSweepDemonTowerResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(DemonTowerHandler.StartToSweepDemonTowerResponse other) {
/*      */         if (other == DemonTowerHandler.StartToSweepDemonTowerResponse.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasS2CCode()) {
/*      */           setS2CCode(other.getS2CCode());
/*      */         }
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasEndTimeStamp()) {
/*      */           setEndTimeStamp(other.getEndTimeStamp());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         DemonTowerHandler.StartToSweepDemonTowerResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.StartToSweepDemonTowerResponse)DemonTowerHandler.StartToSweepDemonTowerResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.StartToSweepDemonTowerResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
/*      */       
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
/*      */       public String getS2CMsg() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.s2CMsg_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DemonTowerHandler.StartToSweepDemonTowerResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasEndTimeStamp() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public long getEndTimeStamp() {
/*      */         return this.endTimeStamp_;
/*      */       }
/*      */       
/*      */       public Builder setEndTimeStamp(long value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.endTimeStamp_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearEndTimeStamp() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.endTimeStamp_ = 0L;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class StartDemonTowerRequest
/*      */     extends GeneratedMessage
/*      */     implements StartDemonTowerRequestOrBuilder
/*      */   {
/* 5207 */     private static final StartDemonTowerRequest defaultInstance = new StartDemonTowerRequest(true); private final UnknownFieldSet unknownFields; private StartDemonTowerRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StartDemonTowerRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StartDemonTowerRequest getDefaultInstance() { return defaultInstance; } public StartDemonTowerRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StartDemonTowerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.floorId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(StartDemonTowerRequest.class, Builder.class); } public static Parser<StartDemonTowerRequest> PARSER = (Parser<StartDemonTowerRequest>)new AbstractParser<StartDemonTowerRequest>() { public DemonTowerHandler.StartDemonTowerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.StartDemonTowerRequest(input, extensionRegistry); } }; private int bitField0_; public static final int FLOORID_FIELD_NUMBER = 1; private int floorId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StartDemonTowerRequest> getParserForType() { return PARSER; } public boolean hasFloorId() { return ((this.bitField0_ & 0x1) == 1); } public int getFloorId() { return this.floorId_; } private void initFields() { this.floorId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.floorId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.floorId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static StartDemonTowerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (StartDemonTowerRequest)PARSER.parseFrom(data); } public static StartDemonTowerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StartDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static StartDemonTowerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (StartDemonTowerRequest)PARSER.parseFrom(data); } public static StartDemonTowerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StartDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static StartDemonTowerRequest parseFrom(InputStream input) throws IOException { return (StartDemonTowerRequest)PARSER.parseFrom(input); } public static StartDemonTowerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static StartDemonTowerRequest parseDelimitedFrom(InputStream input) throws IOException { return (StartDemonTowerRequest)PARSER.parseDelimitedFrom(input); } public static StartDemonTowerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartDemonTowerRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static StartDemonTowerRequest parseFrom(CodedInputStream input) throws IOException { return (StartDemonTowerRequest)PARSER.parseFrom(input); } public static StartDemonTowerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StartDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(StartDemonTowerRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.StartDemonTowerRequestOrBuilder {
/* 5208 */       private int bitField0_; private int floorId_; public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.StartDemonTowerRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DemonTowerHandler.StartDemonTowerRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.floorId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerRequest_descriptor; } public DemonTowerHandler.StartDemonTowerRequest getDefaultInstanceForType() { return DemonTowerHandler.StartDemonTowerRequest.getDefaultInstance(); } public DemonTowerHandler.StartDemonTowerRequest build() { DemonTowerHandler.StartDemonTowerRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DemonTowerHandler.StartDemonTowerRequest buildPartial() { DemonTowerHandler.StartDemonTowerRequest result = new DemonTowerHandler.StartDemonTowerRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.floorId_ = this.floorId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.StartDemonTowerRequest) return mergeFrom((DemonTowerHandler.StartDemonTowerRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DemonTowerHandler.StartDemonTowerRequest other) { if (other == DemonTowerHandler.StartDemonTowerRequest.getDefaultInstance()) return this;  if (other.hasFloorId()) setFloorId(other.getFloorId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.StartDemonTowerRequest parsedMessage = null; try { parsedMessage = (DemonTowerHandler.StartDemonTowerRequest)DemonTowerHandler.StartDemonTowerRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.StartDemonTowerRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasFloorId() { return ((this.bitField0_ & 0x1) == 1); } public int getFloorId() { return this.floorId_; } public Builder setFloorId(int value) { this.bitField0_ |= 0x1; this.floorId_ = value; onChanged(); return this; } public Builder clearFloorId() { this.bitField0_ &= 0xFFFFFFFE; this.floorId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class StartDemonTowerResponse
/*      */     extends GeneratedMessage
/*      */     implements StartDemonTowerResponseOrBuilder
/*      */   {
/* 5769 */     private static final StartDemonTowerResponse defaultInstance = new StartDemonTowerResponse(true); private final UnknownFieldSet unknownFields; private StartDemonTowerResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StartDemonTowerResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StartDemonTowerResponse getDefaultInstance() { return defaultInstance; } public StartDemonTowerResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StartDemonTowerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(StartDemonTowerResponse.class, Builder.class); } public static Parser<StartDemonTowerResponse> PARSER = (Parser<StartDemonTowerResponse>)new AbstractParser<StartDemonTowerResponse>() { public DemonTowerHandler.StartDemonTowerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.StartDemonTowerResponse(input, extensionRegistry); } }
/* 5770 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StartDemonTowerResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */     
/*      */     public String getS2CMsg() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CMsg_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */     }
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(InputStream input) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static StartDemonTowerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StartDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     
/*      */     public static Builder newBuilder(StartDemonTowerResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.StartDemonTowerResponseOrBuilder { private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerResponse_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.StartDemonTowerResponse.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (DemonTowerHandler.StartDemonTowerResponse.alwaysUseFieldBuilders);
/*      */       }
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_StartDemonTowerResponse_descriptor;
/*      */       }
/*      */       
/*      */       public DemonTowerHandler.StartDemonTowerResponse getDefaultInstanceForType() {
/*      */         return DemonTowerHandler.StartDemonTowerResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public DemonTowerHandler.StartDemonTowerResponse build() {
/*      */         DemonTowerHandler.StartDemonTowerResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public DemonTowerHandler.StartDemonTowerResponse buildPartial() {
/*      */         DemonTowerHandler.StartDemonTowerResponse result = new DemonTowerHandler.StartDemonTowerResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof DemonTowerHandler.StartDemonTowerResponse)
/*      */           return mergeFrom((DemonTowerHandler.StartDemonTowerResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(DemonTowerHandler.StartDemonTowerResponse other) {
/*      */         if (other == DemonTowerHandler.StartDemonTowerResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         DemonTowerHandler.StartDemonTowerResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.StartDemonTowerResponse)DemonTowerHandler.StartDemonTowerResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.StartDemonTowerResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
/*      */       
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
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
/*      */       
/*      */       public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DemonTowerHandler.StartDemonTowerResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } }
/*      */   }
/*      */   
/* 6090 */   public static final class FinishSweepDemonTowerRequest extends GeneratedMessage implements FinishSweepDemonTowerRequestOrBuilder { private static final FinishSweepDemonTowerRequest defaultInstance = new FinishSweepDemonTowerRequest(true); private final UnknownFieldSet unknownFields; private FinishSweepDemonTowerRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FinishSweepDemonTowerRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FinishSweepDemonTowerRequest getDefaultInstance() { return defaultInstance; } public FinishSweepDemonTowerRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FinishSweepDemonTowerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishSweepDemonTowerRequest.class, Builder.class); } public static Parser<FinishSweepDemonTowerRequest> PARSER = (Parser<FinishSweepDemonTowerRequest>)new AbstractParser<FinishSweepDemonTowerRequest>() { public DemonTowerHandler.FinishSweepDemonTowerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.FinishSweepDemonTowerRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FinishSweepDemonTowerRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FinishSweepDemonTowerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(data); } public static FinishSweepDemonTowerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static FinishSweepDemonTowerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(data); } public static FinishSweepDemonTowerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(data, extensionRegistry); } public static FinishSweepDemonTowerRequest parseFrom(InputStream input) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(input); } public static FinishSweepDemonTowerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static FinishSweepDemonTowerRequest parseDelimitedFrom(InputStream input) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseDelimitedFrom(input); } public static FinishSweepDemonTowerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static FinishSweepDemonTowerRequest parseFrom(CodedInputStream input) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(input); } public static FinishSweepDemonTowerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FinishSweepDemonTowerRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(FinishSweepDemonTowerRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.FinishSweepDemonTowerRequestOrBuilder {
/* 6091 */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.FinishSweepDemonTowerRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DemonTowerHandler.FinishSweepDemonTowerRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerRequest_descriptor; } public DemonTowerHandler.FinishSweepDemonTowerRequest getDefaultInstanceForType() { return DemonTowerHandler.FinishSweepDemonTowerRequest.getDefaultInstance(); } public DemonTowerHandler.FinishSweepDemonTowerRequest build() { DemonTowerHandler.FinishSweepDemonTowerRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DemonTowerHandler.FinishSweepDemonTowerRequest buildPartial() { DemonTowerHandler.FinishSweepDemonTowerRequest result = new DemonTowerHandler.FinishSweepDemonTowerRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.FinishSweepDemonTowerRequest) return mergeFrom((DemonTowerHandler.FinishSweepDemonTowerRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DemonTowerHandler.FinishSweepDemonTowerRequest other) { if (other == DemonTowerHandler.FinishSweepDemonTowerRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.FinishSweepDemonTowerRequest parsedMessage = null; try { parsedMessage = (DemonTowerHandler.FinishSweepDemonTowerRequest)DemonTowerHandler.FinishSweepDemonTowerRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.FinishSweepDemonTowerRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class FinishSweepDemonTowerResponse
/*      */     extends GeneratedMessage
/*      */     implements FinishSweepDemonTowerResponseOrBuilder
/*      */   {
/* 6652 */     private static final FinishSweepDemonTowerResponse defaultInstance = new FinishSweepDemonTowerResponse(true); private final UnknownFieldSet unknownFields; private FinishSweepDemonTowerResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FinishSweepDemonTowerResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FinishSweepDemonTowerResponse getDefaultInstance() { return defaultInstance; } public FinishSweepDemonTowerResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FinishSweepDemonTowerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishSweepDemonTowerResponse.class, Builder.class); } public static Parser<FinishSweepDemonTowerResponse> PARSER = (Parser<FinishSweepDemonTowerResponse>)new AbstractParser<FinishSweepDemonTowerResponse>() { public DemonTowerHandler.FinishSweepDemonTowerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.FinishSweepDemonTowerResponse(input, extensionRegistry); } }
/* 6653 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FinishSweepDemonTowerResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getS2CMsg() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.s2CMsg_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
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
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */     }
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
/*      */       if (!hasS2CCode()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getS2CMsgBytes());
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(InputStream input) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static FinishSweepDemonTowerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FinishSweepDemonTowerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(FinishSweepDemonTowerResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements DemonTowerHandler.FinishSweepDemonTowerResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int s2CCode_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object s2CMsg_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.FinishSweepDemonTowerResponse.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (DemonTowerHandler.FinishSweepDemonTowerResponse.alwaysUseFieldBuilders);
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return DemonTowerHandler.internal_static_pomelo_area_FinishSweepDemonTowerResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.FinishSweepDemonTowerResponse getDefaultInstanceForType() {
/*      */         return DemonTowerHandler.FinishSweepDemonTowerResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DemonTowerHandler.FinishSweepDemonTowerResponse build() {
/*      */         DemonTowerHandler.FinishSweepDemonTowerResponse result = buildPartial();
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
/*      */       public DemonTowerHandler.FinishSweepDemonTowerResponse buildPartial() {
/*      */         DemonTowerHandler.FinishSweepDemonTowerResponse result = new DemonTowerHandler.FinishSweepDemonTowerResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof DemonTowerHandler.FinishSweepDemonTowerResponse) {
/*      */           return mergeFrom((DemonTowerHandler.FinishSweepDemonTowerResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(DemonTowerHandler.FinishSweepDemonTowerResponse other) {
/*      */         if (other == DemonTowerHandler.FinishSweepDemonTowerResponse.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasS2CCode()) {
/*      */           setS2CCode(other.getS2CCode());
/*      */         }
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         DemonTowerHandler.FinishSweepDemonTowerResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DemonTowerHandler.FinishSweepDemonTowerResponse)DemonTowerHandler.FinishSweepDemonTowerResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DemonTowerHandler.FinishSweepDemonTowerResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getS2CMsg() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.s2CMsg_ = s;
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
/*      */       public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DemonTowerHandler.FinishSweepDemonTowerResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
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
/*      */   public static final class SweepDemonTowerEndPush
/*      */     extends GeneratedMessage
/*      */     implements SweepDemonTowerEndPushOrBuilder
/*      */   {
/* 7222 */     private static final SweepDemonTowerEndPush defaultInstance = new SweepDemonTowerEndPush(true); private final UnknownFieldSet unknownFields; private SweepDemonTowerEndPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SweepDemonTowerEndPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SweepDemonTowerEndPush getDefaultInstance() { return defaultInstance; } public SweepDemonTowerEndPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SweepDemonTowerEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_SweepDemonTowerEndPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_SweepDemonTowerEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SweepDemonTowerEndPush.class, Builder.class); } public static Parser<SweepDemonTowerEndPush> PARSER = (Parser<SweepDemonTowerEndPush>)new AbstractParser<SweepDemonTowerEndPush>() { public DemonTowerHandler.SweepDemonTowerEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DemonTowerHandler.SweepDemonTowerEndPush(input, extensionRegistry); } }
/* 7223 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SweepDemonTowerEndPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String)
/*      */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*      */         this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*      */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; }
/*      */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*      */         return true;  if (isInitialized == 0)
/*      */         return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; }
/*      */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); }
/*      */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*      */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static SweepDemonTowerEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SweepDemonTowerEndPush)PARSER.parseFrom(data); }
/*      */     public static SweepDemonTowerEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SweepDemonTowerEndPush)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static SweepDemonTowerEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SweepDemonTowerEndPush)PARSER.parseFrom(data); }
/*      */     public static SweepDemonTowerEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SweepDemonTowerEndPush)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static SweepDemonTowerEndPush parseFrom(InputStream input) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseFrom(input); }
/*      */     public static SweepDemonTowerEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static SweepDemonTowerEndPush parseDelimitedFrom(InputStream input) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseDelimitedFrom(input); }
/*      */     public static SweepDemonTowerEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static SweepDemonTowerEndPush parseFrom(CodedInputStream input) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseFrom(input); }
/*      */     public static SweepDemonTowerEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SweepDemonTowerEndPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(SweepDemonTowerEndPush prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DemonTowerHandler.SweepDemonTowerEndPushOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return DemonTowerHandler.internal_static_pomelo_area_SweepDemonTowerEndPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DemonTowerHandler.internal_static_pomelo_area_SweepDemonTowerEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(DemonTowerHandler.SweepDemonTowerEndPush.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (DemonTowerHandler.SweepDemonTowerEndPush.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return DemonTowerHandler.internal_static_pomelo_area_SweepDemonTowerEndPush_descriptor; }
/*      */       public DemonTowerHandler.SweepDemonTowerEndPush getDefaultInstanceForType() { return DemonTowerHandler.SweepDemonTowerEndPush.getDefaultInstance(); }
/*      */       public DemonTowerHandler.SweepDemonTowerEndPush build() { DemonTowerHandler.SweepDemonTowerEndPush result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public DemonTowerHandler.SweepDemonTowerEndPush buildPartial() { DemonTowerHandler.SweepDemonTowerEndPush result = new DemonTowerHandler.SweepDemonTowerEndPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof DemonTowerHandler.SweepDemonTowerEndPush)
/*      */           return mergeFrom((DemonTowerHandler.SweepDemonTowerEndPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(DemonTowerHandler.SweepDemonTowerEndPush other) { if (other == DemonTowerHandler.SweepDemonTowerEndPush.getDefaultInstance())
/*      */           return this;  if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false;  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DemonTowerHandler.SweepDemonTowerEndPush parsedMessage = null; try { parsedMessage = (DemonTowerHandler.SweepDemonTowerEndPush)DemonTowerHandler.SweepDemonTowerEndPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DemonTowerHandler.SweepDemonTowerEndPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
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
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = DemonTowerHandler.SweepDemonTowerEndPush.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } }
/*      */   }
/* 7292 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 7297 */     String[] descriptorData = { "\n\027demonTowerHandler.proto\022\013pomelo.area\032\fcommon.proto\"4\n\025DemontTowerRewardItem\022\f\n\004code\030\001 \002(\t\022\r\n\005value\030\002 \002(\005\"+\n\030GetDemonTowerInfoRequest\022\017\n\007floorId\030\001 \001(\005\"Ê\001\n\031GetDemonTowerInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bmaxFloor\030\003 \001(\005\0228\n\023DemonTowerFloorInfo\030\004 \001(\0132\033.pomelo.DemonTowerFloorInfo\022\017\n\007fcValue\030\005 \001(\005\022\026\n\016sweepCountLeft\030\006 \001(\005\022\025\n\rsweepCountMax\030\007 \001(\005\"\037\n\035GetDemonTowerSweepInfoRequest\"Ä\001\n\036GetDem", "onTowerSweepInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\tsweepTime\030\003 \001(\005\0224\n\bitemView\030\004 \003(\0132\".pomelo.area.DemontTowerRewardItem\022\023\n\013diamondCost\030\005 \001(\005\022\r\n\005floor\030\006 \001(\005\022\022\n\nisSweeping\030\007 \001(\b\"\037\n\035StartToSweepDemonTowerRequest\"Y\n\036StartToSweepDemonTowerResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\024\n\fendTimeStamp\030\003 \001(\003\")\n\026StartDemonTowerRequest\022\017\n\007floorId\030\001 \001(\005\"<\n\027StartDemonTowerResponse\022\020\n\bs2c_code\030\001 \002(\005", "\022\017\n\007s2c_msg\030\002 \001(\t\"\036\n\034FinishSweepDemonTowerRequest\"B\n\035FinishSweepDemonTowerResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\";\n\026SweepDemonTowerEndPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2Î\004\n\021demonTowerHandler\022i\n\030getDemonTowerInfoRequest\022%.pomelo.area.GetDemonTowerInfoRequest\032&.pomelo.area.GetDemonTowerInfoResponse\022x\n\035getDemonTowerSweepInfoRequest\022*.pomelo.area.GetDemonTowerSweepInfoRequest\032+.pomelo.area.G", "etDemonTowerSweepInfoResponse\022x\n\035startToSweepDemonTowerRequest\022*.pomelo.area.StartToSweepDemonTowerRequest\032+.pomelo.area.StartToSweepDemonTowerResponse\022c\n\026startDemonTowerRequest\022#.pomelo.area.StartDemonTowerRequest\032$.pomelo.area.StartDemonTowerResponse\022u\n\034finishSweepDemonTowerRequest\022).pomelo.area.FinishSweepDemonTowerRequest\032*.pomelo.area.FinishSweepDemonTowerResponse2]\n\016demonTowerPush\022K\n\026sweepDe", "monTowerEndPush\022#.pomelo.area.SweepDemonTowerEndPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 7341 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 7345 */           DemonTowerHandler.descriptor = root;
/* 7346 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 7350 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 7352 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 7355 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DemontTowerRewardItem_descriptor = getDescriptor().getMessageTypes().get(0);
/* 7356 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DemontTowerRewardItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DemontTowerRewardItem_descriptor, new String[] { "Code", "Value" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7361 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDemonTowerInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 7362 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDemonTowerInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDemonTowerInfoRequest_descriptor, new String[] { "FloorId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7367 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDemonTowerInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 7368 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDemonTowerInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDemonTowerInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "MaxFloor", "DemonTowerFloorInfo", "FcValue", "SweepCountLeft", "SweepCountMax" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7373 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 7374 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDemonTowerSweepInfoRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7379 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 7380 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDemonTowerSweepInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "SweepTime", "ItemView", "DiamondCost", "Floor", "IsSweeping" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7385 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StartToSweepDemonTowerRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 7386 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StartToSweepDemonTowerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StartToSweepDemonTowerRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7391 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StartToSweepDemonTowerResponse_descriptor = getDescriptor().getMessageTypes().get(6);
/* 7392 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StartToSweepDemonTowerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StartToSweepDemonTowerResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "EndTimeStamp" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7397 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StartDemonTowerRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 7398 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StartDemonTowerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StartDemonTowerRequest_descriptor, new String[] { "FloorId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7403 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StartDemonTowerResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 7404 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StartDemonTowerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StartDemonTowerResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7409 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FinishSweepDemonTowerRequest_descriptor = getDescriptor().getMessageTypes().get(9);
/* 7410 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FinishSweepDemonTowerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FinishSweepDemonTowerRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7415 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FinishSweepDemonTowerResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 7416 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FinishSweepDemonTowerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FinishSweepDemonTowerResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 7421 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SweepDemonTowerEndPush_descriptor = getDescriptor().getMessageTypes().get(11);
/* 7422 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SweepDemonTowerEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SweepDemonTowerEndPush_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 7426 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface SweepDemonTowerEndPushOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface FinishSweepDemonTowerResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface FinishSweepDemonTowerRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface StartDemonTowerResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface StartDemonTowerRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasFloorId();
/*      */     
/*      */     int getFloorId();
/*      */   }
/*      */   
/*      */   public static interface StartToSweepDemonTowerResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasEndTimeStamp();
/*      */     
/*      */     long getEndTimeStamp();
/*      */   }
/*      */   
/*      */   public static interface StartToSweepDemonTowerRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface GetDemonTowerSweepInfoResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasSweepTime();
/*      */     
/*      */     int getSweepTime();
/*      */     
/*      */     List<DemonTowerHandler.DemontTowerRewardItem> getItemViewList();
/*      */     
/*      */     DemonTowerHandler.DemontTowerRewardItem getItemView(int param1Int);
/*      */     
/*      */     int getItemViewCount();
/*      */     
/*      */     List<? extends DemonTowerHandler.DemontTowerRewardItemOrBuilder> getItemViewOrBuilderList();
/*      */     
/*      */     DemonTowerHandler.DemontTowerRewardItemOrBuilder getItemViewOrBuilder(int param1Int);
/*      */     
/*      */     boolean hasDiamondCost();
/*      */     
/*      */     int getDiamondCost();
/*      */     
/*      */     boolean hasFloor();
/*      */     
/*      */     int getFloor();
/*      */     
/*      */     boolean hasIsSweeping();
/*      */     
/*      */     boolean getIsSweeping();
/*      */   }
/*      */   
/*      */   public static interface GetDemonTowerSweepInfoRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface GetDemonTowerInfoResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasMaxFloor();
/*      */     
/*      */     int getMaxFloor();
/*      */     
/*      */     boolean hasDemonTowerFloorInfo();
/*      */     
/*      */     Common.DemonTowerFloorInfo getDemonTowerFloorInfo();
/*      */     
/*      */     Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder();
/*      */     
/*      */     boolean hasFcValue();
/*      */     
/*      */     int getFcValue();
/*      */     
/*      */     boolean hasSweepCountLeft();
/*      */     
/*      */     int getSweepCountLeft();
/*      */     
/*      */     boolean hasSweepCountMax();
/*      */     
/*      */     int getSweepCountMax();
/*      */   }
/*      */   
/*      */   public static interface GetDemonTowerInfoRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasFloorId();
/*      */     
/*      */     int getFloorId();
/*      */   }
/*      */   
/*      */   public static interface DemontTowerRewardItemOrBuilder extends MessageOrBuilder {
/*      */     boolean hasCode();
/*      */     
/*      */     String getCode();
/*      */     
/*      */     ByteString getCodeBytes();
/*      */     
/*      */     boolean hasValue();
/*      */     
/*      */     int getValue();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\DemonTowerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */