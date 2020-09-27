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
/*      */ public final class SkillKeysHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class SkillKey
/*      */     extends GeneratedMessage
/*      */     implements SkillKeyOrBuilder
/*      */   {
/*  495 */     private static final SkillKey defaultInstance = new SkillKey(true); private final UnknownFieldSet unknownFields; private SkillKey(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkillKey(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkillKey getDefaultInstance() { return defaultInstance; } public SkillKey getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkillKey(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.keyPos_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.skillId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillKeysHandler.internal_static_pomelo_area_SkillKey_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillKeysHandler.internal_static_pomelo_area_SkillKey_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKey.class, Builder.class); } public static Parser<SkillKey> PARSER = (Parser<SkillKey>)new AbstractParser<SkillKey>() { public SkillKeysHandler.SkillKey parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillKeysHandler.SkillKey(input, extensionRegistry); } }
/*  496 */     ; private int bitField0_; public static final int KEYPOS_FIELD_NUMBER = 1; private int keyPos_; public static final int SKILLID_FIELD_NUMBER = 2; private int skillId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkillKey> getParserForType() { return PARSER; } public boolean hasKeyPos() { return ((this.bitField0_ & 0x1) == 1); } public int getKeyPos() { return this.keyPos_; } public boolean hasSkillId() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getSkillId() {
/*      */       return this.skillId_;
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
/*      */     private void initFields() {
/*      */       this.keyPos_ = 0;
/*      */       this.skillId_ = 0;
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
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasKeyPos()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasSkillId()) {
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
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.keyPos_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.skillId_);
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
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeInt32Size(1, this.keyPos_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.skillId_);
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
/*      */     public static SkillKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SkillKey)PARSER.parseFrom(data);
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
/*      */     public static SkillKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SkillKey)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static SkillKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SkillKey)PARSER.parseFrom(data);
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
/*      */     public static SkillKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SkillKey)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static SkillKey parseFrom(InputStream input) throws IOException {
/*      */       return (SkillKey)PARSER.parseFrom(input);
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
/*      */     public static SkillKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SkillKey)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static SkillKey parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SkillKey)PARSER.parseDelimitedFrom(input);
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
/*      */     public static SkillKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SkillKey)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     public static SkillKey parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SkillKey)PARSER.parseFrom(input);
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
/*      */     public static SkillKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SkillKey)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(SkillKey prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements SkillKeysHandler.SkillKeyOrBuilder
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
/*      */       private int keyPos_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int skillId_;
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
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SkillKey_descriptor;
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
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SkillKey_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeysHandler.SkillKey.class, Builder.class);
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
/*      */       private Builder() {
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
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
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
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (SkillKeysHandler.SkillKey.alwaysUseFieldBuilders);
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.keyPos_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.skillId_ = 0;
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
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SkillKey_descriptor;
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
/*      */       public SkillKeysHandler.SkillKey getDefaultInstanceForType() {
/*      */         return SkillKeysHandler.SkillKey.getDefaultInstance();
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
/*      */       public SkillKeysHandler.SkillKey build() {
/*      */         SkillKeysHandler.SkillKey result = buildPartial();
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
/*      */       public SkillKeysHandler.SkillKey buildPartial() {
/*      */         SkillKeysHandler.SkillKey result = new SkillKeysHandler.SkillKey(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.keyPos_ = this.keyPos_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.skillId_ = this.skillId_;
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
/*      */         if (other instanceof SkillKeysHandler.SkillKey) {
/*      */           return mergeFrom((SkillKeysHandler.SkillKey)other);
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
/*      */       public Builder mergeFrom(SkillKeysHandler.SkillKey other) {
/*      */         if (other == SkillKeysHandler.SkillKey.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasKeyPos()) {
/*      */           setKeyPos(other.getKeyPos());
/*      */         }
/*      */         if (other.hasSkillId()) {
/*      */           setSkillId(other.getSkillId());
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
/*      */         if (!hasKeyPos()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasSkillId()) {
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
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         SkillKeysHandler.SkillKey parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (SkillKeysHandler.SkillKey)SkillKeysHandler.SkillKey.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (SkillKeysHandler.SkillKey)e.getUnfinishedMessage();
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
/*      */       public boolean hasKeyPos() {
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
/*      */       public int getKeyPos() {
/*      */         return this.keyPos_;
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
/*      */       public Builder setKeyPos(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.keyPos_ = value;
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
/*      */       public Builder clearKeyPos() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.keyPos_ = 0;
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
/*      */       public boolean hasSkillId() {
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
/*      */       public int getSkillId() {
/*      */         return this.skillId_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setSkillId(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.skillId_ = value;
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
/*      */       public Builder clearSkillId() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.skillId_ = 0;
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
/*      */   
/*      */   public static final class SaveSkillKeysRequest
/*      */     extends GeneratedMessage
/*      */     implements SaveSkillKeysRequestOrBuilder
/*      */   {
/* 1183 */     private static final SaveSkillKeysRequest defaultInstance = new SaveSkillKeysRequest(true); private final UnknownFieldSet unknownFields; private SaveSkillKeysRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SaveSkillKeysRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SaveSkillKeysRequest getDefaultInstance() { return defaultInstance; } public SaveSkillKeysRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SaveSkillKeysRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: if ((mutable_bitField0_ & 0x1) != 1) { this.s2CSkillKeys_ = new ArrayList<>(); mutable_bitField0_ |= 0x1; }  this.s2CSkillKeys_.add(input.readMessage(SkillKeysHandler.SkillKey.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x1) == 1) this.s2CSkillKeys_ = Collections.unmodifiableList(this.s2CSkillKeys_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveSkillKeysRequest.class, Builder.class); } public static Parser<SaveSkillKeysRequest> PARSER = (Parser<SaveSkillKeysRequest>)new AbstractParser<SaveSkillKeysRequest>() { public SkillKeysHandler.SaveSkillKeysRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillKeysHandler.SaveSkillKeysRequest(input, extensionRegistry); } }
/* 1184 */     ; public static final int S2C_SKILLKEYS_FIELD_NUMBER = 1; private List<SkillKeysHandler.SkillKey> s2CSkillKeys_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SaveSkillKeysRequest> getParserForType() { return PARSER; } public List<SkillKeysHandler.SkillKey> getS2CSkillKeysList() { return this.s2CSkillKeys_; } public List<? extends SkillKeysHandler.SkillKeyOrBuilder> getS2CSkillKeysOrBuilderList() { return (List)this.s2CSkillKeys_; } public int getS2CSkillKeysCount() { return this.s2CSkillKeys_.size(); } public SkillKeysHandler.SkillKey getS2CSkillKeys(int index) { return this.s2CSkillKeys_.get(index); } public SkillKeysHandler.SkillKeyOrBuilder getS2CSkillKeysOrBuilder(int index) { return this.s2CSkillKeys_.get(index); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CSkillKeys_ = Collections.emptyList();
/*      */     }
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
/*      */       for (int i = 0; i < getS2CSkillKeysCount(); i++) {
/*      */         if (!getS2CSkillKeys(i).isInitialized()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       for (int i = 0; i < this.s2CSkillKeys_.size(); i++) {
/*      */         output.writeMessage(1, (MessageLite)this.s2CSkillKeys_.get(i));
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
/*      */       for (int i = 0; i < this.s2CSkillKeys_.size(); i++) {
/*      */         size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.s2CSkillKeys_.get(i));
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
/*      */     public static SaveSkillKeysRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(InputStream input) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SaveSkillKeysRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(SaveSkillKeysRequest prototype) {
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
/*      */       implements SkillKeysHandler.SaveSkillKeysRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */       
/*      */       private List<SkillKeysHandler.SkillKey> s2CSkillKeys_;
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<SkillKeysHandler.SkillKey, SkillKeysHandler.SkillKey.Builder, SkillKeysHandler.SkillKeyOrBuilder> s2CSkillKeysBuilder_;
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeysHandler.SaveSkillKeysRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CSkillKeys_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CSkillKeys_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (SkillKeysHandler.SaveSkillKeysRequest.alwaysUseFieldBuilders) {
/*      */           getS2CSkillKeysFieldBuilder();
/*      */         }
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
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           this.s2CSkillKeys_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFE;
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.clear();
/*      */         } 
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
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SaveSkillKeysRequest getDefaultInstanceForType() {
/*      */         return SkillKeysHandler.SaveSkillKeysRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SaveSkillKeysRequest build() {
/*      */         SkillKeysHandler.SaveSkillKeysRequest result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SaveSkillKeysRequest buildPartial() {
/*      */         SkillKeysHandler.SaveSkillKeysRequest result = new SkillKeysHandler.SaveSkillKeysRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x1) == 1) {
/*      */             this.s2CSkillKeys_ = Collections.unmodifiableList(this.s2CSkillKeys_);
/*      */             this.bitField0_ &= 0xFFFFFFFE;
/*      */           } 
/*      */           result.s2CSkillKeys_ = this.s2CSkillKeys_;
/*      */         } else {
/*      */           result.s2CSkillKeys_ = this.s2CSkillKeysBuilder_.build();
/*      */         } 
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof SkillKeysHandler.SaveSkillKeysRequest) {
/*      */           return mergeFrom((SkillKeysHandler.SaveSkillKeysRequest)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(SkillKeysHandler.SaveSkillKeysRequest other) {
/*      */         if (other == SkillKeysHandler.SaveSkillKeysRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           if (!other.s2CSkillKeys_.isEmpty()) {
/*      */             if (this.s2CSkillKeys_.isEmpty()) {
/*      */               this.s2CSkillKeys_ = other.s2CSkillKeys_;
/*      */               this.bitField0_ &= 0xFFFFFFFE;
/*      */             } else {
/*      */               ensureS2CSkillKeysIsMutable();
/*      */               this.s2CSkillKeys_.addAll(other.s2CSkillKeys_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CSkillKeys_.isEmpty()) {
/*      */           if (this.s2CSkillKeysBuilder_.isEmpty()) {
/*      */             this.s2CSkillKeysBuilder_.dispose();
/*      */             this.s2CSkillKeysBuilder_ = null;
/*      */             this.s2CSkillKeys_ = other.s2CSkillKeys_;
/*      */             this.bitField0_ &= 0xFFFFFFFE;
/*      */             this.s2CSkillKeysBuilder_ = SkillKeysHandler.SaveSkillKeysRequest.alwaysUseFieldBuilders ? getS2CSkillKeysFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CSkillKeysBuilder_.addAllMessages(other.s2CSkillKeys_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         for (int i = 0; i < getS2CSkillKeysCount(); i++) {
/*      */           if (!getS2CSkillKeys(i).isInitialized()) {
/*      */             return false;
/*      */           }
/*      */         } 
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         SkillKeysHandler.SaveSkillKeysRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (SkillKeysHandler.SaveSkillKeysRequest)SkillKeysHandler.SaveSkillKeysRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (SkillKeysHandler.SaveSkillKeysRequest)e.getUnfinishedMessage();
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
/*      */       private void ensureS2CSkillKeysIsMutable() {
/*      */         if ((this.bitField0_ & 0x1) != 1) {
/*      */           this.s2CSkillKeys_ = new ArrayList<>(this.s2CSkillKeys_);
/*      */           this.bitField0_ |= 0x1;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<SkillKeysHandler.SkillKey> getS2CSkillKeysList() {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           return Collections.unmodifiableList(this.s2CSkillKeys_);
/*      */         }
/*      */         return this.s2CSkillKeysBuilder_.getMessageList();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CSkillKeysCount() {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           return this.s2CSkillKeys_.size();
/*      */         }
/*      */         return this.s2CSkillKeysBuilder_.getCount();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SkillKey getS2CSkillKeys(int index) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           return this.s2CSkillKeys_.get(index);
/*      */         }
/*      */         return (SkillKeysHandler.SkillKey)this.s2CSkillKeysBuilder_.getMessage(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CSkillKeys(int index, SkillKeysHandler.SkillKey value) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CSkillKeys(int index, SkillKeysHandler.SkillKey.Builder builderForValue) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CSkillKeys(SkillKeysHandler.SkillKey value) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.addMessage(value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CSkillKeys(int index, SkillKeysHandler.SkillKey value) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CSkillKeys(SkillKeysHandler.SkillKey.Builder builderForValue) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CSkillKeys(int index, SkillKeysHandler.SkillKey.Builder builderForValue) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAllS2CSkillKeys(Iterable<? extends SkillKeysHandler.SkillKey> values) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CSkillKeys_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CSkillKeys() {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           this.s2CSkillKeys_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFE;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder removeS2CSkillKeys(int index) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           ensureS2CSkillKeysIsMutable();
/*      */           this.s2CSkillKeys_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CSkillKeysBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SkillKey.Builder getS2CSkillKeysBuilder(int index) {
/*      */         return (SkillKeysHandler.SkillKey.Builder)getS2CSkillKeysFieldBuilder().getBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SkillKeyOrBuilder getS2CSkillKeysOrBuilder(int index) {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           return this.s2CSkillKeys_.get(index);
/*      */         }
/*      */         return (SkillKeysHandler.SkillKeyOrBuilder)this.s2CSkillKeysBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<? extends SkillKeysHandler.SkillKeyOrBuilder> getS2CSkillKeysOrBuilderList() {
/*      */         if (this.s2CSkillKeysBuilder_ != null) {
/*      */           return this.s2CSkillKeysBuilder_.getMessageOrBuilderList();
/*      */         }
/*      */         return Collections.unmodifiableList((List)this.s2CSkillKeys_);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SkillKey.Builder addS2CSkillKeysBuilder() {
/*      */         return (SkillKeysHandler.SkillKey.Builder)getS2CSkillKeysFieldBuilder().addBuilder(SkillKeysHandler.SkillKey.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public SkillKeysHandler.SkillKey.Builder addS2CSkillKeysBuilder(int index) {
/*      */         return (SkillKeysHandler.SkillKey.Builder)getS2CSkillKeysFieldBuilder().addBuilder(index, SkillKeysHandler.SkillKey.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<SkillKeysHandler.SkillKey.Builder> getS2CSkillKeysBuilderList() {
/*      */         return getS2CSkillKeysFieldBuilder().getBuilderList();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<SkillKeysHandler.SkillKey, SkillKeysHandler.SkillKey.Builder, SkillKeysHandler.SkillKeyOrBuilder> getS2CSkillKeysFieldBuilder() {
/*      */         if (this.s2CSkillKeysBuilder_ == null) {
/*      */           this.s2CSkillKeysBuilder_ = new RepeatedFieldBuilder(this.s2CSkillKeys_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
/*      */           this.s2CSkillKeys_ = null;
/*      */         } 
/*      */         return this.s2CSkillKeysBuilder_;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class SaveSkillKeysResponse
/*      */     extends GeneratedMessage
/*      */     implements SaveSkillKeysResponseOrBuilder
/*      */   {
/* 1745 */     private static final SaveSkillKeysResponse defaultInstance = new SaveSkillKeysResponse(true); private final UnknownFieldSet unknownFields; private SaveSkillKeysResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SaveSkillKeysResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SaveSkillKeysResponse getDefaultInstance() { return defaultInstance; } public SaveSkillKeysResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SaveSkillKeysResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveSkillKeysResponse.class, Builder.class); } public static Parser<SaveSkillKeysResponse> PARSER = (Parser<SaveSkillKeysResponse>)new AbstractParser<SaveSkillKeysResponse>() { public SkillKeysHandler.SaveSkillKeysResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillKeysHandler.SaveSkillKeysResponse(input, extensionRegistry); } }
/* 1746 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SaveSkillKeysResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     public static SaveSkillKeysResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(data);
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
/*      */     public static SaveSkillKeysResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static SaveSkillKeysResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(data);
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
/*      */     public static SaveSkillKeysResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static SaveSkillKeysResponse parseFrom(InputStream input) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(input);
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
/*      */     public static SaveSkillKeysResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static SaveSkillKeysResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseDelimitedFrom(input);
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
/*      */     public static SaveSkillKeysResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     public static SaveSkillKeysResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(input);
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
/*      */     public static SaveSkillKeysResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SaveSkillKeysResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(SaveSkillKeysResponse prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements SkillKeysHandler.SaveSkillKeysResponseOrBuilder
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
/*      */       private int s2CCode_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysResponse_descriptor;
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
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeysHandler.SaveSkillKeysResponse.class, Builder.class);
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
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (SkillKeysHandler.SaveSkillKeysResponse.alwaysUseFieldBuilders);
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
/*      */         return SkillKeysHandler.internal_static_pomelo_area_SaveSkillKeysResponse_descriptor;
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
/*      */       public SkillKeysHandler.SaveSkillKeysResponse getDefaultInstanceForType() {
/*      */         return SkillKeysHandler.SaveSkillKeysResponse.getDefaultInstance();
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
/*      */       public SkillKeysHandler.SaveSkillKeysResponse build() {
/*      */         SkillKeysHandler.SaveSkillKeysResponse result = buildPartial();
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
/*      */       public SkillKeysHandler.SaveSkillKeysResponse buildPartial() {
/*      */         SkillKeysHandler.SaveSkillKeysResponse result = new SkillKeysHandler.SaveSkillKeysResponse(this);
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof SkillKeysHandler.SaveSkillKeysResponse) {
/*      */           return mergeFrom((SkillKeysHandler.SaveSkillKeysResponse)other);
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
/*      */       public Builder mergeFrom(SkillKeysHandler.SaveSkillKeysResponse other) {
/*      */         if (other == SkillKeysHandler.SaveSkillKeysResponse.getDefaultInstance()) {
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         SkillKeysHandler.SaveSkillKeysResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (SkillKeysHandler.SaveSkillKeysResponse)SkillKeysHandler.SaveSkillKeysResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (SkillKeysHandler.SaveSkillKeysResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
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
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = SkillKeysHandler.SaveSkillKeysResponse.getDefaultInstance().getS2CMsg();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class SkillKeyUpdatePush
/*      */     extends GeneratedMessage
/*      */     implements SkillKeyUpdatePushOrBuilder
/*      */   {
/* 2522 */     private static final SkillKeyUpdatePush defaultInstance = new SkillKeyUpdatePush(true); private final UnknownFieldSet unknownFields; private SkillKeyUpdatePush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkillKeyUpdatePush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkillKeyUpdatePush getDefaultInstance() { return defaultInstance; } public SkillKeyUpdatePush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkillKeyUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.s2CData_.add(input.readMessage(Common.SkillKeyStruct.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillKeysHandler.internal_static_pomelo_area_SkillKeyUpdatePush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillKeysHandler.internal_static_pomelo_area_SkillKeyUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeyUpdatePush.class, Builder.class); } public static Parser<SkillKeyUpdatePush> PARSER = (Parser<SkillKeyUpdatePush>)new AbstractParser<SkillKeyUpdatePush>() { public SkillKeysHandler.SkillKeyUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillKeysHandler.SkillKeyUpdatePush(input, extensionRegistry); } }
/* 2523 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_DATA_FIELD_NUMBER = 2; private List<Common.SkillKeyStruct> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkillKeyUpdatePush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public List<Common.SkillKeyStruct> getS2CDataList() { return this.s2CData_; } public List<? extends Common.SkillKeyStructOrBuilder> getS2CDataOrBuilderList() { return (List)this.s2CData_; } public int getS2CDataCount() { return this.s2CData_.size(); } public Common.SkillKeyStruct getS2CData(int index) { return this.s2CData_.get(index); } public Common.SkillKeyStructOrBuilder getS2CDataOrBuilder(int index) { return (Common.SkillKeyStructOrBuilder)this.s2CData_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CData_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(2, (MessageLite)this.s2CData_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  for (int i = 0; i < this.s2CData_.size(); i++) size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.s2CData_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SkillKeyUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SkillKeyUpdatePush)PARSER.parseFrom(data); } public static SkillKeyUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SkillKeyUpdatePush)PARSER.parseFrom(data, extensionRegistry); } public static SkillKeyUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SkillKeyUpdatePush)PARSER.parseFrom(data); } public static SkillKeyUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SkillKeyUpdatePush)PARSER.parseFrom(data, extensionRegistry); } public static SkillKeyUpdatePush parseFrom(InputStream input) throws IOException { return (SkillKeyUpdatePush)PARSER.parseFrom(input); } public static SkillKeyUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillKeyUpdatePush)PARSER.parseFrom(input, extensionRegistry); } public static SkillKeyUpdatePush parseDelimitedFrom(InputStream input) throws IOException { return (SkillKeyUpdatePush)PARSER.parseDelimitedFrom(input); } public static SkillKeyUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillKeyUpdatePush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static SkillKeyUpdatePush parseFrom(CodedInputStream input) throws IOException { return (SkillKeyUpdatePush)PARSER.parseFrom(input); } public static SkillKeyUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillKeyUpdatePush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(SkillKeyUpdatePush prototype) { return newBuilder().mergeFrom(prototype); } static { defaultInstance.initFields(); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillKeysHandler.SkillKeyUpdatePushOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private List<Common.SkillKeyStruct> s2CData_;
/*      */       private RepeatedFieldBuilder<Common.SkillKeyStruct, Common.SkillKeyStruct.Builder, Common.SkillKeyStructOrBuilder> s2CDataBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return SkillKeysHandler.internal_static_pomelo_area_SkillKeyUpdatePush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillKeysHandler.internal_static_pomelo_area_SkillKeyUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillKeysHandler.SkillKeyUpdatePush.class, Builder.class); }
/*      */       private Builder() { this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (SkillKeysHandler.SkillKeyUpdatePush.alwaysUseFieldBuilders) getS2CDataFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFD; } else { this.s2CDataBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return SkillKeysHandler.internal_static_pomelo_area_SkillKeyUpdatePush_descriptor; }
/*      */       public SkillKeysHandler.SkillKeyUpdatePush getDefaultInstanceForType() { return SkillKeysHandler.SkillKeyUpdatePush.getDefaultInstance(); }
/*      */       public SkillKeysHandler.SkillKeyUpdatePush build() { SkillKeysHandler.SkillKeyUpdatePush result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public SkillKeysHandler.SkillKeyUpdatePush buildPartial() { SkillKeysHandler.SkillKeyUpdatePush result = new SkillKeysHandler.SkillKeyUpdatePush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if (this.s2CDataBuilder_ == null) { if ((this.bitField0_ & 0x2) == 2) { this.s2CData_ = Collections.unmodifiableList(this.s2CData_); this.bitField0_ &= 0xFFFFFFFD; }  result.s2CData_ = this.s2CData_; } else { result.s2CData_ = this.s2CDataBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof SkillKeysHandler.SkillKeyUpdatePush) return mergeFrom((SkillKeysHandler.SkillKeyUpdatePush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(SkillKeysHandler.SkillKeyUpdatePush other) { if (other == SkillKeysHandler.SkillKeyUpdatePush.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (this.s2CDataBuilder_ == null) { if (!other.s2CData_.isEmpty()) { if (this.s2CData_.isEmpty()) { this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFFD; } else { ensureS2CDataIsMutable(); this.s2CData_.addAll(other.s2CData_); }  onChanged(); }  } else if (!other.s2CData_.isEmpty()) { if (this.s2CDataBuilder_.isEmpty()) { this.s2CDataBuilder_.dispose(); this.s2CDataBuilder_ = null; this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFFD; this.s2CDataBuilder_ = SkillKeysHandler.SkillKeyUpdatePush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null; } else { this.s2CDataBuilder_.addAllMessages(other.s2CData_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized()) return false;  }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { SkillKeysHandler.SkillKeyUpdatePush parsedMessage = null; try { parsedMessage = (SkillKeysHandler.SkillKeyUpdatePush)SkillKeysHandler.SkillKeyUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (SkillKeysHandler.SkillKeyUpdatePush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       private void ensureS2CDataIsMutable() { if ((this.bitField0_ & 0x2) != 2) { this.s2CData_ = new ArrayList<>(this.s2CData_); this.bitField0_ |= 0x2; }  } public List<Common.SkillKeyStruct> getS2CDataList() { if (this.s2CDataBuilder_ == null) return Collections.unmodifiableList(this.s2CData_);  return this.s2CDataBuilder_.getMessageList(); } public int getS2CDataCount() { if (this.s2CDataBuilder_ == null) return this.s2CData_.size();  return this.s2CDataBuilder_.getCount(); } public Common.SkillKeyStruct getS2CData(int index) { if (this.s2CDataBuilder_ == null) return this.s2CData_.get(index);  return (Common.SkillKeyStruct)this.s2CDataBuilder_.getMessage(index); } public Builder setS2CData(int index, Common.SkillKeyStruct value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.set(index, value); onChanged(); } else { this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setS2CData(int index, Common.SkillKeyStruct.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.set(index, builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CData(Common.SkillKeyStruct value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(value); onChanged(); } else { this.s2CDataBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addS2CData(int index, Common.SkillKeyStruct value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(index, value); onChanged(); } else { this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addS2CData(Common.SkillKeyStruct.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CData(int index, Common.SkillKeyStruct.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(index, builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllS2CData(Iterable<? extends Common.SkillKeyStruct> values) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CData_); onChanged(); } else { this.s2CDataBuilder_.addAllMessages(values); }  return this; } public Builder clearS2CData() { if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFD; onChanged(); } else { this.s2CDataBuilder_.clear(); }  return this; } public Builder removeS2CData(int index) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.remove(index); onChanged(); } else { this.s2CDataBuilder_.remove(index); }  return this; } public Common.SkillKeyStruct.Builder getS2CDataBuilder(int index) { return (Common.SkillKeyStruct.Builder)getS2CDataFieldBuilder().getBuilder(index); } public Common.SkillKeyStructOrBuilder getS2CDataOrBuilder(int index) { if (this.s2CDataBuilder_ == null) return (Common.SkillKeyStructOrBuilder)this.s2CData_.get(index);  return (Common.SkillKeyStructOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index); } public List<? extends Common.SkillKeyStructOrBuilder> getS2CDataOrBuilderList() { if (this.s2CDataBuilder_ != null) return this.s2CDataBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.s2CData_); } public Common.SkillKeyStruct.Builder addS2CDataBuilder() { return (Common.SkillKeyStruct.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)Common.SkillKeyStruct.getDefaultInstance()); } public Common.SkillKeyStruct.Builder addS2CDataBuilder(int index) { return (Common.SkillKeyStruct.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)Common.SkillKeyStruct.getDefaultInstance()); } public List<Common.SkillKeyStruct.Builder> getS2CDataBuilderList() { return getS2CDataFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<Common.SkillKeyStruct, Common.SkillKeyStruct.Builder, Common.SkillKeyStructOrBuilder> getS2CDataFieldBuilder() { if (this.s2CDataBuilder_ == null) { this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean()); this.s2CData_ = null; }  return this.s2CDataBuilder_; } }
/* 2552 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 2557 */     String[] descriptorData = { "\n\026skillKeysHandler.proto\022\013pomelo.area\032\fcommon.proto\"+\n\bSkillKey\022\016\n\006keyPos\030\001 \002(\005\022\017\n\007skillId\030\002 \002(\005\"D\n\024SaveSkillKeysRequest\022,\n\rs2c_skillKeys\030\001 \003(\0132\025.pomelo.area.SkillKey\":\n\025SaveSkillKeysResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"P\n\022SkillKeyUpdatePush\022\020\n\bs2c_code\030\001 \002(\005\022(\n\bs2c_data\030\002 \003(\0132\026.pomelo.SkillKeyStruct2q\n\020skillKeysHandler\022]\n\024saveSkillKeysRequest\022!.pomelo.area.SaveSkillKeysRequest\032\".pomelo.are", "a.SaveSkillKeysResponse2T\n\rskillKeysPush\022C\n\022skillKeyUpdatePush\022\037.pomelo.area.SkillKeyUpdatePush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2572 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 2576 */           SkillKeysHandler.descriptor = root;
/* 2577 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 2581 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 2583 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 2586 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkillKey_descriptor = getDescriptor().getMessageTypes().get(0);
/* 2587 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillKey_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillKey_descriptor, new String[] { "KeyPos", "SkillId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2592 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SaveSkillKeysRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 2593 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveSkillKeysRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveSkillKeysRequest_descriptor, new String[] { "S2CSkillKeys" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2598 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SaveSkillKeysResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 2599 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveSkillKeysResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveSkillKeysResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2604 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkillKeyUpdatePush_descriptor = getDescriptor().getMessageTypes().get(3);
/* 2605 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillKeyUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillKeyUpdatePush_descriptor, new String[] { "S2CCode", "S2CData" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 2609 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface SkillKeyUpdatePushOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     List<Common.SkillKeyStruct> getS2CDataList();
/*      */     
/*      */     Common.SkillKeyStruct getS2CData(int param1Int);
/*      */     
/*      */     int getS2CDataCount();
/*      */     
/*      */     List<? extends Common.SkillKeyStructOrBuilder> getS2CDataOrBuilderList();
/*      */     
/*      */     Common.SkillKeyStructOrBuilder getS2CDataOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface SaveSkillKeysResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface SaveSkillKeysRequestOrBuilder extends MessageOrBuilder {
/*      */     List<SkillKeysHandler.SkillKey> getS2CSkillKeysList();
/*      */     
/*      */     SkillKeysHandler.SkillKey getS2CSkillKeys(int param1Int);
/*      */     
/*      */     int getS2CSkillKeysCount();
/*      */     
/*      */     List<? extends SkillKeysHandler.SkillKeyOrBuilder> getS2CSkillKeysOrBuilderList();
/*      */     
/*      */     SkillKeysHandler.SkillKeyOrBuilder getS2CSkillKeysOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface SkillKeyOrBuilder extends MessageOrBuilder {
/*      */     boolean hasKeyPos();
/*      */     
/*      */     int getKeyPos();
/*      */     
/*      */     boolean hasSkillId();
/*      */     
/*      */     int getSkillId();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\SkillKeysHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */