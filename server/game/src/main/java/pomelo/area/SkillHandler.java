/*       */ package pomelo.area;
/*       */ 
/*       */ import com.google.protobuf.AbstractMessage;
/*       */ import com.google.protobuf.AbstractMessageLite;
/*       */ import com.google.protobuf.AbstractParser;
/*       */ import com.google.protobuf.ByteString;
/*       */ import com.google.protobuf.CodedInputStream;
/*       */ import com.google.protobuf.CodedOutputStream;
/*       */ import com.google.protobuf.Descriptors;
/*       */ import com.google.protobuf.ExtensionRegistry;
/*       */ import com.google.protobuf.ExtensionRegistryLite;
/*       */ import com.google.protobuf.GeneratedMessage;
/*       */ import com.google.protobuf.InvalidProtocolBufferException;
/*       */ import com.google.protobuf.LazyStringArrayList;
/*       */ import com.google.protobuf.LazyStringList;
/*       */ import com.google.protobuf.Message;
/*       */ import com.google.protobuf.MessageLite;
/*       */ import com.google.protobuf.MessageOrBuilder;
/*       */ import com.google.protobuf.Parser;
/*       */ import com.google.protobuf.ProtocolStringList;
/*       */ import com.google.protobuf.RepeatedFieldBuilder;
/*       */ import com.google.protobuf.SingleFieldBuilder;
/*       */ import com.google.protobuf.UnknownFieldSet;
/*       */ import java.io.IOException;
/*       */ import java.io.InputStream;
/*       */ import java.io.ObjectStreamException;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Collection;
/*       */ import java.util.Collections;
/*       */ import java.util.List;
/*       */ import pomelo.Common;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class SkillHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class UpgradeSkillRequest
/*       */     extends GeneratedMessage
/*       */     implements UpgradeSkillRequestOrBuilder
/*       */   {
/*   409 */     private static final UpgradeSkillRequest defaultInstance = new UpgradeSkillRequest(true); private final UnknownFieldSet unknownFields; private UpgradeSkillRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeSkillRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeSkillRequest getDefaultInstance() { return defaultInstance; } public UpgradeSkillRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeSkillRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CSkillId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeSkillRequest.class, Builder.class); } public static Parser<UpgradeSkillRequest> PARSER = (Parser<UpgradeSkillRequest>)new AbstractParser<UpgradeSkillRequest>() { public SkillHandler.UpgradeSkillRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UpgradeSkillRequest(input, extensionRegistry); } }
/*   410 */     ; private int bitField0_; public static final int S2C_SKILLID_FIELD_NUMBER = 1; private int s2CSkillId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeSkillRequest> getParserForType() { return PARSER; } public boolean hasS2CSkillId() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CSkillId() { return this.s2CSkillId_; } private void initFields() { this.s2CSkillId_ = 0; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CSkillId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CSkillId_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CSkillId_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(UpgradeSkillRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.UpgradeSkillRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int s2CSkillId_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UpgradeSkillRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.UpgradeSkillRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CSkillId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillRequest getDefaultInstanceForType() {
/*       */         return SkillHandler.UpgradeSkillRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillRequest build() {
/*       */         SkillHandler.UpgradeSkillRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillRequest buildPartial() {
/*       */         SkillHandler.UpgradeSkillRequest result = new SkillHandler.UpgradeSkillRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CSkillId_ = this.s2CSkillId_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.UpgradeSkillRequest) {
/*       */           return mergeFrom((SkillHandler.UpgradeSkillRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.UpgradeSkillRequest other) {
/*       */         if (other == SkillHandler.UpgradeSkillRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CSkillId()) {
/*       */           setS2CSkillId(other.getS2CSkillId());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CSkillId()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.UpgradeSkillRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillRequest)SkillHandler.UpgradeSkillRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasS2CSkillId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getS2CSkillId() {
/*       */         return this.s2CSkillId_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setS2CSkillId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CSkillId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearS2CSkillId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CSkillId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class UpgradeSkillOneKeyRequest
/*       */     extends GeneratedMessage
/*       */     implements UpgradeSkillOneKeyRequestOrBuilder
/*       */   {
/*   722 */     private static final UpgradeSkillOneKeyRequest defaultInstance = new UpgradeSkillOneKeyRequest(true); private final UnknownFieldSet unknownFields; private UpgradeSkillOneKeyRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeSkillOneKeyRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeSkillOneKeyRequest getDefaultInstance() { return defaultInstance; } public UpgradeSkillOneKeyRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeSkillOneKeyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeSkillOneKeyRequest.class, Builder.class); } public static Parser<UpgradeSkillOneKeyRequest> PARSER = (Parser<UpgradeSkillOneKeyRequest>)new AbstractParser<UpgradeSkillOneKeyRequest>() { public SkillHandler.UpgradeSkillOneKeyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UpgradeSkillOneKeyRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeSkillOneKeyRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpgradeSkillOneKeyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(data); } public static UpgradeSkillOneKeyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpgradeSkillOneKeyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(data); } public static UpgradeSkillOneKeyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpgradeSkillOneKeyRequest parseFrom(InputStream input) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(input); } public static UpgradeSkillOneKeyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(input, extensionRegistry); } public static UpgradeSkillOneKeyRequest parseDelimitedFrom(InputStream input) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseDelimitedFrom(input); } public static UpgradeSkillOneKeyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UpgradeSkillOneKeyRequest parseFrom(CodedInputStream input) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(input); } public static UpgradeSkillOneKeyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeSkillOneKeyRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UpgradeSkillOneKeyRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.UpgradeSkillOneKeyRequestOrBuilder {
/*   723 */       public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UpgradeSkillOneKeyRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (SkillHandler.UpgradeSkillOneKeyRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyRequest_descriptor; } public SkillHandler.UpgradeSkillOneKeyRequest getDefaultInstanceForType() { return SkillHandler.UpgradeSkillOneKeyRequest.getDefaultInstance(); } public SkillHandler.UpgradeSkillOneKeyRequest build() { SkillHandler.UpgradeSkillOneKeyRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public SkillHandler.UpgradeSkillOneKeyRequest buildPartial() { SkillHandler.UpgradeSkillOneKeyRequest result = new SkillHandler.UpgradeSkillOneKeyRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof SkillHandler.UpgradeSkillOneKeyRequest) return mergeFrom((SkillHandler.UpgradeSkillOneKeyRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(SkillHandler.UpgradeSkillOneKeyRequest other) { if (other == SkillHandler.UpgradeSkillOneKeyRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { SkillHandler.UpgradeSkillOneKeyRequest parsedMessage = null; try { parsedMessage = (SkillHandler.UpgradeSkillOneKeyRequest)SkillHandler.UpgradeSkillOneKeyRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (SkillHandler.UpgradeSkillOneKeyRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*       */   
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class UnlockSkillRequest
/*       */     extends GeneratedMessage
/*       */     implements UnlockSkillRequestOrBuilder
/*       */   {
/*  1127 */     private static final UnlockSkillRequest defaultInstance = new UnlockSkillRequest(true); private final UnknownFieldSet unknownFields; private UnlockSkillRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnlockSkillRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnlockSkillRequest getDefaultInstance() { return defaultInstance; } public UnlockSkillRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnlockSkillRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CSkillId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UnlockSkillRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UnlockSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockSkillRequest.class, Builder.class); } public static Parser<UnlockSkillRequest> PARSER = (Parser<UnlockSkillRequest>)new AbstractParser<UnlockSkillRequest>() { public SkillHandler.UnlockSkillRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UnlockSkillRequest(input, extensionRegistry); } }
/*  1128 */     ; private int bitField0_; public static final int S2C_SKILLID_FIELD_NUMBER = 1; private int s2CSkillId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnlockSkillRequest> getParserForType() { return PARSER; } public boolean hasS2CSkillId() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CSkillId() { return this.s2CSkillId_; } private void initFields() { this.s2CSkillId_ = 0; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CSkillId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CSkillId_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CSkillId_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(InputStream input) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UnlockSkillRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UnlockSkillRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(UnlockSkillRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.UnlockSkillRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CSkillId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_UnlockSkillRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_UnlockSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UnlockSkillRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.UnlockSkillRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CSkillId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_UnlockSkillRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UnlockSkillRequest getDefaultInstanceForType() {
/*       */         return SkillHandler.UnlockSkillRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UnlockSkillRequest build() {
/*       */         SkillHandler.UnlockSkillRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UnlockSkillRequest buildPartial() {
/*       */         SkillHandler.UnlockSkillRequest result = new SkillHandler.UnlockSkillRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CSkillId_ = this.s2CSkillId_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.UnlockSkillRequest) {
/*       */           return mergeFrom((SkillHandler.UnlockSkillRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.UnlockSkillRequest other) {
/*       */         if (other == SkillHandler.UnlockSkillRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CSkillId()) {
/*       */           setS2CSkillId(other.getS2CSkillId());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CSkillId()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.UnlockSkillRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.UnlockSkillRequest)SkillHandler.UnlockSkillRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.UnlockSkillRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CSkillId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CSkillId() {
/*       */         return this.s2CSkillId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CSkillId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CSkillId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CSkillId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CSkillId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class GetSkillDetailRequest
/*       */     extends GeneratedMessage
/*       */     implements GetSkillDetailRequestOrBuilder
/*       */   {
/*  1532 */     private static final GetSkillDetailRequest defaultInstance = new GetSkillDetailRequest(true); private final UnknownFieldSet unknownFields; private GetSkillDetailRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetSkillDetailRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetSkillDetailRequest getDefaultInstance() { return defaultInstance; } public GetSkillDetailRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetSkillDetailRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CSkillId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_GetSkillDetailRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_GetSkillDetailRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSkillDetailRequest.class, Builder.class); } public static Parser<GetSkillDetailRequest> PARSER = (Parser<GetSkillDetailRequest>)new AbstractParser<GetSkillDetailRequest>() { public SkillHandler.GetSkillDetailRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.GetSkillDetailRequest(input, extensionRegistry); } }
/*  1533 */     ; private int bitField0_; public static final int S2C_SKILLID_FIELD_NUMBER = 1; private int s2CSkillId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetSkillDetailRequest> getParserForType() { return PARSER; } public boolean hasS2CSkillId() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CSkillId() { return this.s2CSkillId_; } private void initFields() { this.s2CSkillId_ = 0; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CSkillId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CSkillId_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CSkillId_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(InputStream input) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetSkillDetailRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetSkillDetailRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(GetSkillDetailRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.GetSkillDetailRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int s2CSkillId_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.GetSkillDetailRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.GetSkillDetailRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CSkillId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailRequest getDefaultInstanceForType() {
/*       */         return SkillHandler.GetSkillDetailRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailRequest build() {
/*       */         SkillHandler.GetSkillDetailRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailRequest buildPartial() {
/*       */         SkillHandler.GetSkillDetailRequest result = new SkillHandler.GetSkillDetailRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CSkillId_ = this.s2CSkillId_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.GetSkillDetailRequest) {
/*       */           return mergeFrom((SkillHandler.GetSkillDetailRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.GetSkillDetailRequest other) {
/*       */         if (other == SkillHandler.GetSkillDetailRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CSkillId()) {
/*       */           setS2CSkillId(other.getS2CSkillId());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CSkillId()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.GetSkillDetailRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.GetSkillDetailRequest)SkillHandler.GetSkillDetailRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.GetSkillDetailRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasS2CSkillId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getS2CSkillId() {
/*       */         return this.s2CSkillId_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setS2CSkillId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CSkillId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearS2CSkillId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CSkillId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class GetAllSkillRequest
/*       */     extends GeneratedMessage
/*       */     implements GetAllSkillRequestOrBuilder
/*       */   {
/*  1845 */     private static final GetAllSkillRequest defaultInstance = new GetAllSkillRequest(true); private final UnknownFieldSet unknownFields; private GetAllSkillRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetAllSkillRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetAllSkillRequest getDefaultInstance() { return defaultInstance; } public GetAllSkillRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetAllSkillRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_GetAllSkillRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_GetAllSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllSkillRequest.class, Builder.class); } public static Parser<GetAllSkillRequest> PARSER = (Parser<GetAllSkillRequest>)new AbstractParser<GetAllSkillRequest>() { public SkillHandler.GetAllSkillRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.GetAllSkillRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetAllSkillRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetAllSkillRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetAllSkillRequest)PARSER.parseFrom(data); } public static GetAllSkillRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllSkillRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetAllSkillRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetAllSkillRequest)PARSER.parseFrom(data); } public static GetAllSkillRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllSkillRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetAllSkillRequest parseFrom(InputStream input) throws IOException { return (GetAllSkillRequest)PARSER.parseFrom(input); } public static GetAllSkillRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllSkillRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetAllSkillRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetAllSkillRequest)PARSER.parseDelimitedFrom(input); } public static GetAllSkillRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllSkillRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetAllSkillRequest parseFrom(CodedInputStream input) throws IOException { return (GetAllSkillRequest)PARSER.parseFrom(input); } public static GetAllSkillRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllSkillRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetAllSkillRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.GetAllSkillRequestOrBuilder {
/*  1846 */       public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_GetAllSkillRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_GetAllSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.GetAllSkillRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (SkillHandler.GetAllSkillRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return SkillHandler.internal_static_pomelo_area_GetAllSkillRequest_descriptor; } public SkillHandler.GetAllSkillRequest getDefaultInstanceForType() { return SkillHandler.GetAllSkillRequest.getDefaultInstance(); } public SkillHandler.GetAllSkillRequest build() { SkillHandler.GetAllSkillRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public SkillHandler.GetAllSkillRequest buildPartial() { SkillHandler.GetAllSkillRequest result = new SkillHandler.GetAllSkillRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof SkillHandler.GetAllSkillRequest) return mergeFrom((SkillHandler.GetAllSkillRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(SkillHandler.GetAllSkillRequest other) { if (other == SkillHandler.GetAllSkillRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { SkillHandler.GetAllSkillRequest parsedMessage = null; try { parsedMessage = (SkillHandler.GetAllSkillRequest)SkillHandler.GetAllSkillRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (SkillHandler.GetAllSkillRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*       */   
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class ReqItem
/*       */     extends GeneratedMessage
/*       */     implements ReqItemOrBuilder
/*       */   {
/*  2752 */     private static final ReqItem defaultInstance = new ReqItem(true); private final UnknownFieldSet unknownFields; private ReqItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ReqItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ReqItem getDefaultInstance() { return defaultInstance; } public ReqItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ReqItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.itemCode_ = bs; break;case 16: this.bitField0_ |= 0x2; this.itemQua_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.itemIcon_ = bs; break;case 32: this.bitField0_ |= 0x8; this.itemReqNum_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.itemCurNum_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_ReqItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_ReqItem_fieldAccessorTable.ensureFieldAccessorsInitialized(ReqItem.class, Builder.class); } public static Parser<ReqItem> PARSER = (Parser<ReqItem>)new AbstractParser<ReqItem>() { public SkillHandler.ReqItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.ReqItem(input, extensionRegistry); } }
/*  2753 */     ; private int bitField0_; public static final int ITEMCODE_FIELD_NUMBER = 1; private Object itemCode_; public static final int ITEMQUA_FIELD_NUMBER = 2; private int itemQua_; public static final int ITEMICON_FIELD_NUMBER = 3; private Object itemIcon_; public static final int ITEMREQNUM_FIELD_NUMBER = 4; private int itemReqNum_; public static final int ITEMCURNUM_FIELD_NUMBER = 5; private int itemCurNum_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ReqItem> getParserForType() { return PARSER; } public boolean hasItemCode() { return ((this.bitField0_ & 0x1) == 1); } public String getItemCode() { Object ref = this.itemCode_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.itemCode_ = s;  return s; } public ByteString getItemCodeBytes() { Object ref = this.itemCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.itemCode_ = b; return b; }  return (ByteString)ref; } public boolean hasItemQua() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getItemQua() {
/*       */       return this.itemQua_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasItemIcon() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getItemIcon() {
/*       */       Object ref = this.itemIcon_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.itemIcon_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getItemIconBytes() {
/*       */       Object ref = this.itemIcon_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.itemIcon_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasItemReqNum() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getItemReqNum() {
/*       */       return this.itemReqNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasItemCurNum() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getItemCurNum() {
/*       */       return this.itemCurNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.itemCode_ = "";
/*       */       this.itemQua_ = 0;
/*       */       this.itemIcon_ = "";
/*       */       this.itemReqNum_ = 0;
/*       */       this.itemCurNum_ = 0;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasItemCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemQua()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemIcon()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemReqNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemCurNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getItemCodeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.itemQua_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getItemIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.itemReqNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.itemCurNum_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeBytesSize(1, getItemCodeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.itemQua_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getItemIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.itemReqNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.itemCurNum_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ReqItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ReqItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ReqItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ReqItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(InputStream input) throws IOException {
/*       */       return (ReqItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ReqItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ReqItem)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ReqItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ReqItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ReqItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ReqItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(ReqItem prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.ReqItemOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object itemCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int itemQua_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object itemIcon_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int itemReqNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int itemCurNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_ReqItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_ReqItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.ReqItem.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.itemCode_ = "";
/*       */         this.itemIcon_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.itemCode_ = "";
/*       */         this.itemIcon_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.ReqItem.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.itemCode_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.itemQua_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.itemIcon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.itemReqNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.itemCurNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_ReqItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem getDefaultInstanceForType() {
/*       */         return SkillHandler.ReqItem.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem build() {
/*       */         SkillHandler.ReqItem result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem buildPartial() {
/*       */         SkillHandler.ReqItem result = new SkillHandler.ReqItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.itemCode_ = this.itemCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.itemQua_ = this.itemQua_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.itemIcon_ = this.itemIcon_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.itemReqNum_ = this.itemReqNum_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.itemCurNum_ = this.itemCurNum_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.ReqItem) {
/*       */           return mergeFrom((SkillHandler.ReqItem)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.ReqItem other) {
/*       */         if (other == SkillHandler.ReqItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasItemCode()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.itemCode_ = other.itemCode_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasItemQua()) {
/*       */           setItemQua(other.getItemQua());
/*       */         }
/*       */         if (other.hasItemIcon()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.itemIcon_ = other.itemIcon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasItemReqNum()) {
/*       */           setItemReqNum(other.getItemReqNum());
/*       */         }
/*       */         if (other.hasItemCurNum()) {
/*       */           setItemCurNum(other.getItemCurNum());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasItemCode()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemQua()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemIcon()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemReqNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemCurNum()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.ReqItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.ReqItem)SkillHandler.ReqItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.ReqItem)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasItemCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getItemCode() {
/*       */         Object ref = this.itemCode_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.itemCode_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getItemCodeBytes() {
/*       */         Object ref = this.itemCode_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.itemCode_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemCode(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.itemCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearItemCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.itemCode_ = SkillHandler.ReqItem.getDefaultInstance().getItemCode();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemCodeBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.itemCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasItemQua() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getItemQua() {
/*       */         return this.itemQua_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemQua(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.itemQua_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearItemQua() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.itemQua_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasItemIcon() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getItemIcon() {
/*       */         Object ref = this.itemIcon_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.itemIcon_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getItemIconBytes() {
/*       */         Object ref = this.itemIcon_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.itemIcon_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemIcon(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.itemIcon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearItemIcon() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.itemIcon_ = SkillHandler.ReqItem.getDefaultInstance().getItemIcon();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemIconBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.itemIcon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasItemReqNum() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getItemReqNum() {
/*       */         return this.itemReqNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemReqNum(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.itemReqNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearItemReqNum() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.itemReqNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasItemCurNum() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getItemCurNum() {
/*       */         return this.itemCurNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItemCurNum(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.itemCurNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearItemCurNum() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.itemCurNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class SkillBasic
/*       */     extends GeneratedMessage
/*       */     implements SkillBasicOrBuilder
/*       */   {
/*  4496 */     private static final SkillBasic defaultInstance = new SkillBasic(true); private final UnknownFieldSet unknownFields; private SkillBasic(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkillBasic(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkillBasic getDefaultInstance() { return defaultInstance; } public SkillBasic getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkillBasic(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int length, limit, tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.level_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.pos_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.extlv_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.name_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.pic_ = bs; break;case 48: this.bitField0_ |= 0x20; this.type_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.flag_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.skillId_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x100; this.maxLevel_ = input.readInt32(); break;case 80: this.bitField0_ |= 0x200; this.upgradeNeedLevel_ = input.readInt32(); break;case 88: this.bitField0_ |= 0x400; this.detailNeedRefresh_ = input.readBool(); break;case 96: if ((mutable_bitField0_ & 0x800) != 2048) { this.canUpgrade_ = new ArrayList<>(); mutable_bitField0_ |= 0x800; }  this.canUpgrade_.add(Integer.valueOf(input.readInt32())); break;case 98: length = input.readRawVarint32(); limit = input.pushLimit(length); if ((mutable_bitField0_ & 0x800) != 2048 && input.getBytesUntilLimit() > 0) { this.canUpgrade_ = new ArrayList<>(); mutable_bitField0_ |= 0x800; }  while (input.getBytesUntilLimit() > 0) this.canUpgrade_.add(Integer.valueOf(input.readInt32()));  input.popLimit(limit); break;case 104: this.bitField0_ |= 0x800; this.cost_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x800) == 2048) this.canUpgrade_ = Collections.unmodifiableList(this.canUpgrade_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_SkillBasic_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_SkillBasic_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillBasic.class, Builder.class); } public static Parser<SkillBasic> PARSER = (Parser<SkillBasic>)new AbstractParser<SkillBasic>() { public SkillHandler.SkillBasic parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.SkillBasic(input, extensionRegistry); } }
/*  4497 */     ; private int bitField0_; public static final int LEVEL_FIELD_NUMBER = 1; private int level_; public static final int POS_FIELD_NUMBER = 2; private int pos_; public static final int EXTLV_FIELD_NUMBER = 3; private int extlv_; public static final int NAME_FIELD_NUMBER = 4; private Object name_; public static final int PIC_FIELD_NUMBER = 5; private Object pic_; public static final int TYPE_FIELD_NUMBER = 6; private int type_; public static final int FLAG_FIELD_NUMBER = 7; private int flag_; public static final int SKILLID_FIELD_NUMBER = 8; private int skillId_; public static final int MAXLEVEL_FIELD_NUMBER = 9; private int maxLevel_; public static final int UPGRADENEEDLEVEL_FIELD_NUMBER = 10; private int upgradeNeedLevel_; public static final int DETAILNEEDREFRESH_FIELD_NUMBER = 11; private boolean detailNeedRefresh_; public static final int CANUPGRADE_FIELD_NUMBER = 12; private List<Integer> canUpgrade_; public static final int COST_FIELD_NUMBER = 13; private int cost_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkillBasic> getParserForType() { return PARSER; } public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getLevel() { return this.level_; } public boolean hasPos() { return ((this.bitField0_ & 0x2) == 2); } public int getPos() { return this.pos_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasExtlv() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getExtlv() {
/*       */       return this.extlv_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasName() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.name_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getNameBytes() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.name_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasPic() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getPic() {
/*       */       Object ref = this.pic_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.pic_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getPicBytes() {
/*       */       Object ref = this.pic_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.pic_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasType() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getType() {
/*       */       return this.type_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasFlag() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getFlag() {
/*       */       return this.flag_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasSkillId() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSkillId() {
/*       */       return this.skillId_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasMaxLevel() {
/*       */       return ((this.bitField0_ & 0x100) == 256);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getMaxLevel() {
/*       */       return this.maxLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasUpgradeNeedLevel() {
/*       */       return ((this.bitField0_ & 0x200) == 512);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getUpgradeNeedLevel() {
/*       */       return this.upgradeNeedLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasDetailNeedRefresh() {
/*       */       return ((this.bitField0_ & 0x400) == 1024);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean getDetailNeedRefresh() {
/*       */       return this.detailNeedRefresh_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<Integer> getCanUpgradeList() {
/*       */       return this.canUpgrade_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getCanUpgradeCount() {
/*       */       return this.canUpgrade_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getCanUpgrade(int index) {
/*       */       return ((Integer)this.canUpgrade_.get(index)).intValue();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasCost() {
/*       */       return ((this.bitField0_ & 0x800) == 2048);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getCost() {
/*       */       return this.cost_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.level_ = 0;
/*       */       this.pos_ = 0;
/*       */       this.extlv_ = 0;
/*       */       this.name_ = "";
/*       */       this.pic_ = "";
/*       */       this.type_ = 0;
/*       */       this.flag_ = 0;
/*       */       this.skillId_ = 0;
/*       */       this.maxLevel_ = 0;
/*       */       this.upgradeNeedLevel_ = 0;
/*       */       this.detailNeedRefresh_ = false;
/*       */       this.canUpgrade_ = Collections.emptyList();
/*       */       this.cost_ = 0;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPic()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasType()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasFlag()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasSkillId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasMaxLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasUpgradeNeedLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDetailNeedRefresh()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCost()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.pos_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.extlv_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeBytes(5, getPicBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.type_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(7, this.flag_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(8, this.skillId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         output.writeInt32(9, this.maxLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x200) == 512) {
/*       */         output.writeInt32(10, this.upgradeNeedLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x400) == 1024) {
/*       */         output.writeBool(11, this.detailNeedRefresh_);
/*       */       }
/*       */       for (int i = 0; i < this.canUpgrade_.size(); i++) {
/*       */         output.writeInt32(12, ((Integer)this.canUpgrade_.get(i)).intValue());
/*       */       }
/*       */       if ((this.bitField0_ & 0x800) == 2048) {
/*       */         output.writeInt32(13, this.cost_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.pos_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.extlv_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeBytesSize(5, getPicBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.type_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(7, this.flag_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.skillId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         size += CodedOutputStream.computeInt32Size(9, this.maxLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x200) == 512) {
/*       */         size += CodedOutputStream.computeInt32Size(10, this.upgradeNeedLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x400) == 1024) {
/*       */         size += CodedOutputStream.computeBoolSize(11, this.detailNeedRefresh_);
/*       */       }
/*       */       int dataSize = 0;
/*       */       for (int i = 0; i < this.canUpgrade_.size(); i++) {
/*       */         dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.canUpgrade_.get(i)).intValue());
/*       */       }
/*       */       size += dataSize;
/*       */       size += 1 * getCanUpgradeList().size();
/*       */       if ((this.bitField0_ & 0x800) == 2048) {
/*       */         size += CodedOutputStream.computeInt32Size(13, this.cost_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SkillBasic)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SkillBasic)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SkillBasic)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SkillBasic)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(InputStream input) throws IOException {
/*       */       return (SkillBasic)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillBasic)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SkillBasic)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillBasic)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SkillBasic)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkillBasic parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillBasic)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(SkillBasic prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.SkillBasicOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int level_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int pos_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int extlv_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object name_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object pic_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int type_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int flag_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int skillId_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int maxLevel_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int upgradeNeedLevel_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private boolean detailNeedRefresh_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<Integer> canUpgrade_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int cost_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillBasic_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillBasic_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.SkillBasic.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         this.pic_ = "";
/*       */         this.canUpgrade_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.name_ = "";
/*       */         this.pic_ = "";
/*       */         this.canUpgrade_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.SkillBasic.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.level_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.pos_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.extlv_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.pic_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.type_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.flag_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.skillId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.maxLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.upgradeNeedLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.detailNeedRefresh_ = false;
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.canUpgrade_ = Collections.emptyList();
/*       */         this.bitField0_ &= 0xFFFFF7FF;
/*       */         this.cost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFEFFF;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillBasic_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillBasic getDefaultInstanceForType() {
/*       */         return SkillHandler.SkillBasic.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillBasic build() {
/*       */         SkillHandler.SkillBasic result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillBasic buildPartial() {
/*       */         SkillHandler.SkillBasic result = new SkillHandler.SkillBasic(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.level_ = this.level_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.pos_ = this.pos_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.extlv_ = this.extlv_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.pic_ = this.pic_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.type_ = this.type_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.flag_ = this.flag_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.skillId_ = this.skillId_;
/*       */         if ((from_bitField0_ & 0x100) == 256) {
/*       */           to_bitField0_ |= 0x100;
/*       */         }
/*       */         result.maxLevel_ = this.maxLevel_;
/*       */         if ((from_bitField0_ & 0x200) == 512) {
/*       */           to_bitField0_ |= 0x200;
/*       */         }
/*       */         result.upgradeNeedLevel_ = this.upgradeNeedLevel_;
/*       */         if ((from_bitField0_ & 0x400) == 1024) {
/*       */           to_bitField0_ |= 0x400;
/*       */         }
/*       */         result.detailNeedRefresh_ = this.detailNeedRefresh_;
/*       */         if ((this.bitField0_ & 0x800) == 2048) {
/*       */           this.canUpgrade_ = Collections.unmodifiableList(this.canUpgrade_);
/*       */           this.bitField0_ &= 0xFFFFF7FF;
/*       */         } 
/*       */         result.canUpgrade_ = this.canUpgrade_;
/*       */         if ((from_bitField0_ & 0x1000) == 4096) {
/*       */           to_bitField0_ |= 0x800;
/*       */         }
/*       */         result.cost_ = this.cost_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.SkillBasic) {
/*       */           return mergeFrom((SkillHandler.SkillBasic)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.SkillBasic other) {
/*       */         if (other == SkillHandler.SkillBasic.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasLevel()) {
/*       */           setLevel(other.getLevel());
/*       */         }
/*       */         if (other.hasPos()) {
/*       */           setPos(other.getPos());
/*       */         }
/*       */         if (other.hasExtlv()) {
/*       */           setExtlv(other.getExtlv());
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPic()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.pic_ = other.pic_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasType()) {
/*       */           setType(other.getType());
/*       */         }
/*       */         if (other.hasFlag()) {
/*       */           setFlag(other.getFlag());
/*       */         }
/*       */         if (other.hasSkillId()) {
/*       */           setSkillId(other.getSkillId());
/*       */         }
/*       */         if (other.hasMaxLevel()) {
/*       */           setMaxLevel(other.getMaxLevel());
/*       */         }
/*       */         if (other.hasUpgradeNeedLevel()) {
/*       */           setUpgradeNeedLevel(other.getUpgradeNeedLevel());
/*       */         }
/*       */         if (other.hasDetailNeedRefresh()) {
/*       */           setDetailNeedRefresh(other.getDetailNeedRefresh());
/*       */         }
/*       */         if (!other.canUpgrade_.isEmpty()) {
/*       */           if (this.canUpgrade_.isEmpty()) {
/*       */             this.canUpgrade_ = other.canUpgrade_;
/*       */             this.bitField0_ &= 0xFFFFF7FF;
/*       */           } else {
/*       */             ensureCanUpgradeIsMutable();
/*       */             this.canUpgrade_.addAll(other.canUpgrade_);
/*       */           } 
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCost()) {
/*       */           setCost(other.getCost());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPic()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasType()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasFlag()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasSkillId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasMaxLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasUpgradeNeedLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasDetailNeedRefresh()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCost()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.SkillBasic parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.SkillBasic)SkillHandler.SkillBasic.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.SkillBasic)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasLevel() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getLevel() {
/*       */         return this.level_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setLevel(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasPos() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getPos() {
/*       */         return this.pos_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setPos(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.pos_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearPos() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.pos_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasExtlv() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getExtlv() {
/*       */         return this.extlv_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setExtlv(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.extlv_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearExtlv() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.extlv_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getName() {
/*       */         Object ref = this.name_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.name_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getNameBytes() {
/*       */         Object ref = this.name_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.name_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.name_ = SkillHandler.SkillBasic.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasPic() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getPic() {
/*       */         Object ref = this.pic_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.pic_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getPicBytes() {
/*       */         Object ref = this.pic_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.pic_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setPic(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.pic_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearPic() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.pic_ = SkillHandler.SkillBasic.getDefaultInstance().getPic();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setPicBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.pic_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasType() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getType() {
/*       */         return this.type_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setType(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.type_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearType() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.type_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasFlag() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getFlag() {
/*       */         return this.flag_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setFlag(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.flag_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearFlag() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.flag_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasSkillId() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getSkillId() {
/*       */         return this.skillId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkillId(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.skillId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearSkillId() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.skillId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasMaxLevel() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getMaxLevel() {
/*       */         return this.maxLevel_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setMaxLevel(int value) {
/*       */         this.bitField0_ |= 0x100;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearMaxLevel() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasUpgradeNeedLevel() {
/*       */         return ((this.bitField0_ & 0x200) == 512);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getUpgradeNeedLevel() {
/*       */         return this.upgradeNeedLevel_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setUpgradeNeedLevel(int value) {
/*       */         this.bitField0_ |= 0x200;
/*       */         this.upgradeNeedLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearUpgradeNeedLevel() {
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.upgradeNeedLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasDetailNeedRefresh() {
/*       */         return ((this.bitField0_ & 0x400) == 1024);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean getDetailNeedRefresh() {
/*       */         return this.detailNeedRefresh_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDetailNeedRefresh(boolean value) {
/*       */         this.bitField0_ |= 0x400;
/*       */         this.detailNeedRefresh_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDetailNeedRefresh() {
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.detailNeedRefresh_ = false;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureCanUpgradeIsMutable() {
/*       */         if ((this.bitField0_ & 0x800) != 2048) {
/*       */           this.canUpgrade_ = new ArrayList<>(this.canUpgrade_);
/*       */           this.bitField0_ |= 0x800;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Integer> getCanUpgradeList() {
/*       */         return Collections.unmodifiableList(this.canUpgrade_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getCanUpgradeCount() {
/*       */         return this.canUpgrade_.size();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getCanUpgrade(int index) {
/*       */         return ((Integer)this.canUpgrade_.get(index)).intValue();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCanUpgrade(int index, int value) {
/*       */         ensureCanUpgradeIsMutable();
/*       */         this.canUpgrade_.set(index, Integer.valueOf(value));
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addCanUpgrade(int value) {
/*       */         ensureCanUpgradeIsMutable();
/*       */         this.canUpgrade_.add(Integer.valueOf(value));
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllCanUpgrade(Iterable<? extends Integer> values) {
/*       */         ensureCanUpgradeIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, this.canUpgrade_);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearCanUpgrade() {
/*       */         this.canUpgrade_ = Collections.emptyList();
/*       */         this.bitField0_ &= 0xFFFFF7FF;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasCost() {
/*       */         return ((this.bitField0_ & 0x1000) == 4096);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getCost() {
/*       */         return this.cost_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCost(int value) {
/*       */         this.bitField0_ |= 0x1000;
/*       */         this.cost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearCost() {
/*       */         this.bitField0_ &= 0xFFFFEFFF;
/*       */         this.cost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class TalentDetail
/*       */     extends GeneratedMessage
/*       */     implements TalentDetailOrBuilder
/*       */   {
/*  6035 */     private static final TalentDetail defaultInstance = new TalentDetail(true); private final UnknownFieldSet unknownFields; private TalentDetail(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TalentDetail(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TalentDetail getDefaultInstance() { return defaultInstance; } public TalentDetail getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TalentDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.skillId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.level_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.extlv_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.name_ = bs; break;case 40: this.bitField0_ |= 0x10; this.maxLevel_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.flag_ = input.readInt32(); break;case 58: bs = input.readBytes(); if ((mutable_bitField0_ & 0x40) != 64) { this.curDesData_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x40; }  this.curDesData_.add(bs); break;case 66: if ((mutable_bitField0_ & 0x80) != 128) { this.reqItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x80; }  this.reqItems_.add(input.readMessage(SkillHandler.ReqItem.PARSER, extensionRegistry)); break;case 72: this.bitField0_ |= 0x40; this.canUpgrade_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x40) == 64) this.curDesData_ = this.curDesData_.getUnmodifiableView();  if ((mutable_bitField0_ & 0x80) == 128) this.reqItems_ = Collections.unmodifiableList(this.reqItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_TalentDetail_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_TalentDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(TalentDetail.class, Builder.class); } public static Parser<TalentDetail> PARSER = (Parser<TalentDetail>)new AbstractParser<TalentDetail>() { public SkillHandler.TalentDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.TalentDetail(input, extensionRegistry); } }
/*  6036 */     ; private int bitField0_; public static final int SKILLID_FIELD_NUMBER = 1; private int skillId_; public static final int LEVEL_FIELD_NUMBER = 2; private int level_; public static final int EXTLV_FIELD_NUMBER = 3; private int extlv_; public static final int NAME_FIELD_NUMBER = 4; private Object name_; public static final int MAXLEVEL_FIELD_NUMBER = 5; private int maxLevel_; public static final int FLAG_FIELD_NUMBER = 6; private int flag_; public static final int CURDESDATA_FIELD_NUMBER = 7; private LazyStringList curDesData_; public static final int REQITEMS_FIELD_NUMBER = 8; private List<SkillHandler.ReqItem> reqItems_; public static final int CANUPGRADE_FIELD_NUMBER = 9; private int canUpgrade_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TalentDetail> getParserForType() { return PARSER; } public boolean hasSkillId() { return ((this.bitField0_ & 0x1) == 1); } public int getSkillId() { return this.skillId_; } public boolean hasLevel() { return ((this.bitField0_ & 0x2) == 2); } public int getLevel() { return this.level_; } public boolean hasExtlv() { return ((this.bitField0_ & 0x4) == 4); } public int getExtlv() { return this.extlv_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasName() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.name_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getNameBytes() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.name_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasMaxLevel() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getMaxLevel() {
/*       */       return this.maxLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasFlag() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getFlag() {
/*       */       return this.flag_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ProtocolStringList getCurDesDataList() {
/*       */       return (ProtocolStringList)this.curDesData_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getCurDesDataCount() {
/*       */       return this.curDesData_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getCurDesData(int index) {
/*       */       return (String)this.curDesData_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getCurDesDataBytes(int index) {
/*       */       return this.curDesData_.getByteString(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<SkillHandler.ReqItem> getReqItemsList() {
/*       */       return this.reqItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList() {
/*       */       return (List)this.reqItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getReqItemsCount() {
/*       */       return this.reqItems_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public SkillHandler.ReqItem getReqItems(int index) {
/*       */       return this.reqItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int index) {
/*       */       return this.reqItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasCanUpgrade() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getCanUpgrade() {
/*       */       return this.canUpgrade_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.skillId_ = 0;
/*       */       this.level_ = 0;
/*       */       this.extlv_ = 0;
/*       */       this.name_ = "";
/*       */       this.maxLevel_ = 0;
/*       */       this.flag_ = 0;
/*       */       this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */       this.reqItems_ = Collections.emptyList();
/*       */       this.canUpgrade_ = 0;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasSkillId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasMaxLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasFlag()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getReqItemsCount(); i++) {
/*       */         if (!getReqItems(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.skillId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.extlv_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.maxLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.flag_);
/*       */       }
/*       */       int i;
/*       */       for (i = 0; i < this.curDesData_.size(); i++) {
/*       */         output.writeBytes(7, this.curDesData_.getByteString(i));
/*       */       }
/*       */       for (i = 0; i < this.reqItems_.size(); i++) {
/*       */         output.writeMessage(8, (MessageLite)this.reqItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(9, this.canUpgrade_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.skillId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.extlv_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.maxLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.flag_);
/*       */       }
/*       */       int dataSize = 0;
/*       */       for (int j = 0; j < this.curDesData_.size(); j++) {
/*       */         dataSize += CodedOutputStream.computeBytesSizeNoTag(this.curDesData_.getByteString(j));
/*       */       }
/*       */       size += dataSize;
/*       */       size += 1 * getCurDesDataList().size();
/*       */       for (int i = 0; i < this.reqItems_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(8, (MessageLite)this.reqItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(9, this.canUpgrade_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TalentDetail)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TalentDetail)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TalentDetail)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TalentDetail)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(InputStream input) throws IOException {
/*       */       return (TalentDetail)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TalentDetail)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TalentDetail)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TalentDetail)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TalentDetail)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TalentDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TalentDetail)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(TalentDetail prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.TalentDetailOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int skillId_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int level_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int extlv_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object name_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int maxLevel_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int flag_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private LazyStringList curDesData_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<SkillHandler.ReqItem> reqItems_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<SkillHandler.ReqItem, SkillHandler.ReqItem.Builder, SkillHandler.ReqItemOrBuilder> reqItemsBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int canUpgrade_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_TalentDetail_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_TalentDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.TalentDetail.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.reqItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.name_ = "";
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.reqItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.TalentDetail.alwaysUseFieldBuilders) {
/*       */           getReqItemsFieldBuilder();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.skillId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.level_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.extlv_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.maxLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.flag_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFF7F;
/*       */         } else {
/*       */           this.reqItemsBuilder_.clear();
/*       */         } 
/*       */         this.canUpgrade_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_TalentDetail_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.TalentDetail getDefaultInstanceForType() {
/*       */         return SkillHandler.TalentDetail.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.TalentDetail build() {
/*       */         SkillHandler.TalentDetail result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.TalentDetail buildPartial() {
/*       */         SkillHandler.TalentDetail result = new SkillHandler.TalentDetail(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.skillId_ = this.skillId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.level_ = this.level_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.extlv_ = this.extlv_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.maxLevel_ = this.maxLevel_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.flag_ = this.flag_;
/*       */         if ((this.bitField0_ & 0x40) == 64) {
/*       */           this.curDesData_ = this.curDesData_.getUnmodifiableView();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */         } 
/*       */         result.curDesData_ = this.curDesData_;
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x80) == 128) {
/*       */             this.reqItems_ = Collections.unmodifiableList(this.reqItems_);
/*       */             this.bitField0_ &= 0xFFFFFF7F;
/*       */           } 
/*       */           result.reqItems_ = this.reqItems_;
/*       */         } else {
/*       */           result.reqItems_ = this.reqItemsBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x100) == 256) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.canUpgrade_ = this.canUpgrade_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.TalentDetail) {
/*       */           return mergeFrom((SkillHandler.TalentDetail)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.TalentDetail other) {
/*       */         if (other == SkillHandler.TalentDetail.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasSkillId()) {
/*       */           setSkillId(other.getSkillId());
/*       */         }
/*       */         if (other.hasLevel()) {
/*       */           setLevel(other.getLevel());
/*       */         }
/*       */         if (other.hasExtlv()) {
/*       */           setExtlv(other.getExtlv());
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasMaxLevel()) {
/*       */           setMaxLevel(other.getMaxLevel());
/*       */         }
/*       */         if (other.hasFlag()) {
/*       */           setFlag(other.getFlag());
/*       */         }
/*       */         if (!other.curDesData_.isEmpty()) {
/*       */           if (this.curDesData_.isEmpty()) {
/*       */             this.curDesData_ = other.curDesData_;
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */           } else {
/*       */             ensureCurDesDataIsMutable();
/*       */             this.curDesData_.addAll((Collection)other.curDesData_);
/*       */           } 
/*       */           onChanged();
/*       */         } 
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (!other.reqItems_.isEmpty()) {
/*       */             if (this.reqItems_.isEmpty()) {
/*       */               this.reqItems_ = other.reqItems_;
/*       */               this.bitField0_ &= 0xFFFFFF7F;
/*       */             } else {
/*       */               ensureReqItemsIsMutable();
/*       */               this.reqItems_.addAll(other.reqItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.reqItems_.isEmpty()) {
/*       */           if (this.reqItemsBuilder_.isEmpty()) {
/*       */             this.reqItemsBuilder_.dispose();
/*       */             this.reqItemsBuilder_ = null;
/*       */             this.reqItems_ = other.reqItems_;
/*       */             this.bitField0_ &= 0xFFFFFF7F;
/*       */             this.reqItemsBuilder_ = SkillHandler.TalentDetail.alwaysUseFieldBuilders ? getReqItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.reqItemsBuilder_.addAllMessages(other.reqItems_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasCanUpgrade()) {
/*       */           setCanUpgrade(other.getCanUpgrade());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasSkillId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasMaxLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasFlag()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getReqItemsCount(); i++) {
/*       */           if (!getReqItems(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.TalentDetail parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.TalentDetail)SkillHandler.TalentDetail.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.TalentDetail)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasSkillId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getSkillId() {
/*       */         return this.skillId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkillId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.skillId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearSkillId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.skillId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasLevel() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getLevel() {
/*       */         return this.level_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setLevel(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasExtlv() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getExtlv() {
/*       */         return this.extlv_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setExtlv(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.extlv_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearExtlv() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.extlv_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getName() {
/*       */         Object ref = this.name_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.name_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getNameBytes() {
/*       */         Object ref = this.name_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.name_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.name_ = SkillHandler.TalentDetail.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasMaxLevel() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getMaxLevel() {
/*       */         return this.maxLevel_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setMaxLevel(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearMaxLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasFlag() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getFlag() {
/*       */         return this.flag_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setFlag(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.flag_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearFlag() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.flag_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureCurDesDataIsMutable() {
/*       */         if ((this.bitField0_ & 0x40) != 64) {
/*       */           this.curDesData_ = (LazyStringList)new LazyStringArrayList(this.curDesData_);
/*       */           this.bitField0_ |= 0x40;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ProtocolStringList getCurDesDataList() {
/*       */         return (ProtocolStringList)this.curDesData_.getUnmodifiableView();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getCurDesDataCount() {
/*       */         return this.curDesData_.size();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getCurDesData(int index) {
/*       */         return (String)this.curDesData_.get(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getCurDesDataBytes(int index) {
/*       */         return this.curDesData_.getByteString(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCurDesData(int index, String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.set(index, value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addCurDesData(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllCurDesData(Iterable<String> values) {
/*       */         ensureCurDesDataIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, (Collection)this.curDesData_);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearCurDesData() {
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addCurDesDataBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureReqItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x80) != 128) {
/*       */           this.reqItems_ = new ArrayList<>(this.reqItems_);
/*       */           this.bitField0_ |= 0x80;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<SkillHandler.ReqItem> getReqItemsList() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.reqItems_);
/*       */         }
/*       */         return this.reqItemsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getReqItemsCount() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           return this.reqItems_.size();
/*       */         }
/*       */         return this.reqItemsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem getReqItems(int index) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           return this.reqItems_.get(index);
/*       */         }
/*       */         return (SkillHandler.ReqItem)this.reqItemsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setReqItems(int index, SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setReqItems(int index, SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addReqItems(SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addReqItems(int index, SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addReqItems(SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addReqItems(int index, SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllReqItems(Iterable<? extends SkillHandler.ReqItem> values) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.reqItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearReqItems() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFF7F;
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeReqItems(int index) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem.Builder getReqItemsBuilder(int index) {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int index) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           return this.reqItems_.get(index);
/*       */         }
/*       */         return (SkillHandler.ReqItemOrBuilder)this.reqItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList() {
/*       */         if (this.reqItemsBuilder_ != null) {
/*       */           return this.reqItemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.reqItems_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem.Builder addReqItemsBuilder() {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().addBuilder(SkillHandler.ReqItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.ReqItem.Builder addReqItemsBuilder(int index) {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().addBuilder(index, SkillHandler.ReqItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<SkillHandler.ReqItem.Builder> getReqItemsBuilderList() {
/*       */         return getReqItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<SkillHandler.ReqItem, SkillHandler.ReqItem.Builder, SkillHandler.ReqItemOrBuilder> getReqItemsFieldBuilder() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItemsBuilder_ = new RepeatedFieldBuilder(this.reqItems_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
/*       */           this.reqItems_ = null;
/*       */         } 
/*       */         return this.reqItemsBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasCanUpgrade() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getCanUpgrade() {
/*       */         return this.canUpgrade_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCanUpgrade(int value) {
/*       */         this.bitField0_ |= 0x100;
/*       */         this.canUpgrade_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearCanUpgrade() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.canUpgrade_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class SkillDetail
/*       */     extends GeneratedMessage
/*       */     implements SkillDetailOrBuilder
/*       */   {
/*  7531 */     private static final SkillDetail defaultInstance = new SkillDetail(true); private final UnknownFieldSet unknownFields; private SkillDetail(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkillDetail(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkillDetail getDefaultInstance() { return defaultInstance; } public SkillDetail getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkillDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.colddown_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.curManaCost_ = input.readInt32(); break;case 26: bs = input.readBytes(); if ((mutable_bitField0_ & 0x4) != 4) { this.curDesData_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x4; }  this.curDesData_.add(bs); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.reqItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.reqItems_.add(input.readMessage(SkillHandler.ReqItem.PARSER, extensionRegistry)); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.talentList_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.talentList_.add(input.readMessage(SkillHandler.TalentDetail.PARSER, extensionRegistry)); break;case 48: this.bitField0_ |= 0x4; this.canUpgrade_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.curDesData_ = this.curDesData_.getUnmodifiableView();  if ((mutable_bitField0_ & 0x8) == 8) this.reqItems_ = Collections.unmodifiableList(this.reqItems_);  if ((mutable_bitField0_ & 0x10) == 16) this.talentList_ = Collections.unmodifiableList(this.talentList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_SkillDetail_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_SkillDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillDetail.class, Builder.class); } public static Parser<SkillDetail> PARSER = (Parser<SkillDetail>)new AbstractParser<SkillDetail>() { public SkillHandler.SkillDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.SkillDetail(input, extensionRegistry); } }
/*  7532 */     ; private int bitField0_; public static final int COLDDOWN_FIELD_NUMBER = 1; private int colddown_; public static final int CURMANACOST_FIELD_NUMBER = 2; private int curManaCost_; public static final int CURDESDATA_FIELD_NUMBER = 3; private LazyStringList curDesData_; public static final int REQITEMS_FIELD_NUMBER = 4; private List<SkillHandler.ReqItem> reqItems_; public static final int TALENTLIST_FIELD_NUMBER = 5; private List<SkillHandler.TalentDetail> talentList_; public static final int CANUPGRADE_FIELD_NUMBER = 6; private int canUpgrade_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkillDetail> getParserForType() { return PARSER; } public boolean hasColddown() { return ((this.bitField0_ & 0x1) == 1); } public int getColddown() { return this.colddown_; } public boolean hasCurManaCost() { return ((this.bitField0_ & 0x2) == 2); } public int getCurManaCost() { return this.curManaCost_; } public ProtocolStringList getCurDesDataList() { return (ProtocolStringList)this.curDesData_; } public int getCurDesDataCount() { return this.curDesData_.size(); } public String getCurDesData(int index) { return (String)this.curDesData_.get(index); } public ByteString getCurDesDataBytes(int index) { return this.curDesData_.getByteString(index); } public List<SkillHandler.ReqItem> getReqItemsList() { return this.reqItems_; } public List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList() { return (List)this.reqItems_; } public int getReqItemsCount() { return this.reqItems_.size(); } public SkillHandler.ReqItem getReqItems(int index) { return this.reqItems_.get(index); } public SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int index) { return this.reqItems_.get(index); } public List<SkillHandler.TalentDetail> getTalentListList() { return this.talentList_; } public List<? extends SkillHandler.TalentDetailOrBuilder> getTalentListOrBuilderList() { return (List)this.talentList_; } public int getTalentListCount() { return this.talentList_.size(); } public SkillHandler.TalentDetail getTalentList(int index) { return this.talentList_.get(index); } public SkillHandler.TalentDetailOrBuilder getTalentListOrBuilder(int index) { return this.talentList_.get(index); } public boolean hasCanUpgrade() { return ((this.bitField0_ & 0x4) == 4); } public int getCanUpgrade() { return this.canUpgrade_; } private void initFields() { this.colddown_ = 0; this.curManaCost_ = 0; this.curDesData_ = LazyStringArrayList.EMPTY; this.reqItems_ = Collections.emptyList(); this.talentList_ = Collections.emptyList(); this.canUpgrade_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasColddown()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCurManaCost()) { this.memoizedIsInitialized = 0; return false; }  int i; for (i = 0; i < getReqItemsCount(); i++) { if (!getReqItems(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getTalentListCount(); i++) { if (!getTalentList(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.colddown_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.curManaCost_);  int i; for (i = 0; i < this.curDesData_.size(); i++) output.writeBytes(3, this.curDesData_.getByteString(i));  for (i = 0; i < this.reqItems_.size(); i++) output.writeMessage(4, (MessageLite)this.reqItems_.get(i));  for (i = 0; i < this.talentList_.size(); i++) output.writeMessage(5, (MessageLite)this.talentList_.get(i));  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(6, this.canUpgrade_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.colddown_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.curManaCost_);  int dataSize = 0; for (int j = 0; j < this.curDesData_.size(); j++) dataSize += CodedOutputStream.computeBytesSizeNoTag(this.curDesData_.getByteString(j));  size += dataSize; size += 1 * getCurDesDataList().size(); int i; for (i = 0; i < this.reqItems_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.reqItems_.get(i));  for (i = 0; i < this.talentList_.size(); i++) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.talentList_.get(i));  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(6, this.canUpgrade_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } static { defaultInstance.initFields(); } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SkillDetail parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SkillDetail)PARSER.parseFrom(data); } public static SkillDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SkillDetail)PARSER.parseFrom(data, extensionRegistry); } public static SkillDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SkillDetail)PARSER.parseFrom(data);
/*       */     } public static SkillDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SkillDetail)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static SkillDetail parseFrom(InputStream input) throws IOException {
/*       */       return (SkillDetail)PARSER.parseFrom(input);
/*       */     } public static SkillDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillDetail)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static SkillDetail parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SkillDetail)PARSER.parseDelimitedFrom(input);
/*       */     } public static SkillDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillDetail)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     } public static SkillDetail parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SkillDetail)PARSER.parseFrom(input);
/*       */     } public static SkillDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkillDetail)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     } public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     } public static Builder newBuilder(SkillDetail prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     } public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.SkillDetailOrBuilder { private int bitField0_; private int colddown_; private int curManaCost_; private LazyStringList curDesData_; private List<SkillHandler.ReqItem> reqItems_; private RepeatedFieldBuilder<SkillHandler.ReqItem, SkillHandler.ReqItem.Builder, SkillHandler.ReqItemOrBuilder> reqItemsBuilder_; private List<SkillHandler.TalentDetail> talentList_; private RepeatedFieldBuilder<SkillHandler.TalentDetail, SkillHandler.TalentDetail.Builder, SkillHandler.TalentDetailOrBuilder> talentListBuilder_; private int canUpgrade_; public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillDetail_descriptor;
/*       */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.SkillDetail.class, Builder.class);
/*       */       } private Builder() {
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.reqItems_ = Collections.emptyList();
/*       */         this.talentList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.reqItems_ = Collections.emptyList();
/*       */         this.talentList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.SkillDetail.alwaysUseFieldBuilders) {
/*       */           getReqItemsFieldBuilder();
/*       */           getTalentListFieldBuilder();
/*       */         } 
/*       */       } private static Builder create() {
/*       */         return new Builder();
/*       */       } public Builder clear() {
/*       */         super.clear();
/*       */         this.colddown_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.curManaCost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.reqItemsBuilder_.clear();
/*       */         } 
/*       */         if (this.talentListBuilder_ == null) {
/*       */           this.talentList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */         } else {
/*       */           this.talentListBuilder_.clear();
/*       */         } 
/*       */         this.canUpgrade_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         return this;
/*       */       } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_SkillDetail_descriptor;
/*       */       } public SkillHandler.SkillDetail getDefaultInstanceForType() {
/*       */         return SkillHandler.SkillDetail.getDefaultInstance();
/*       */       } public SkillHandler.SkillDetail build() {
/*       */         SkillHandler.SkillDetail result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       } public SkillHandler.SkillDetail buildPartial() {
/*       */         SkillHandler.SkillDetail result = new SkillHandler.SkillDetail(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.colddown_ = this.colddown_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.curManaCost_ = this.curManaCost_;
/*       */         if ((this.bitField0_ & 0x4) == 4) {
/*       */           this.curDesData_ = this.curDesData_.getUnmodifiableView();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } 
/*       */         result.curDesData_ = this.curDesData_;
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.reqItems_ = Collections.unmodifiableList(this.reqItems_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.reqItems_ = this.reqItems_;
/*       */         } else {
/*       */           result.reqItems_ = this.reqItemsBuilder_.build();
/*       */         } 
/*       */         if (this.talentListBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x10) == 16) {
/*       */             this.talentList_ = Collections.unmodifiableList(this.talentList_);
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */           } 
/*       */           result.talentList_ = this.talentList_;
/*       */         } else {
/*       */           result.talentList_ = this.talentListBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.canUpgrade_ = this.canUpgrade_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       } public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.SkillDetail)
/*       */           return mergeFrom((SkillHandler.SkillDetail)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       } public Builder mergeFrom(SkillHandler.SkillDetail other) {
/*       */         if (other == SkillHandler.SkillDetail.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasColddown())
/*       */           setColddown(other.getColddown()); 
/*       */         if (other.hasCurManaCost())
/*       */           setCurManaCost(other.getCurManaCost()); 
/*       */         if (!other.curDesData_.isEmpty()) {
/*       */           if (this.curDesData_.isEmpty()) {
/*       */             this.curDesData_ = other.curDesData_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } else {
/*       */             ensureCurDesDataIsMutable();
/*       */             this.curDesData_.addAll((Collection)other.curDesData_);
/*       */           } 
/*       */           onChanged();
/*       */         } 
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (!other.reqItems_.isEmpty()) {
/*       */             if (this.reqItems_.isEmpty()) {
/*       */               this.reqItems_ = other.reqItems_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureReqItemsIsMutable();
/*       */               this.reqItems_.addAll(other.reqItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.reqItems_.isEmpty()) {
/*       */           if (this.reqItemsBuilder_.isEmpty()) {
/*       */             this.reqItemsBuilder_.dispose();
/*       */             this.reqItemsBuilder_ = null;
/*       */             this.reqItems_ = other.reqItems_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.reqItemsBuilder_ = SkillHandler.SkillDetail.alwaysUseFieldBuilders ? getReqItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.reqItemsBuilder_.addAllMessages(other.reqItems_);
/*       */           } 
/*       */         } 
/*       */         if (this.talentListBuilder_ == null) {
/*       */           if (!other.talentList_.isEmpty()) {
/*       */             if (this.talentList_.isEmpty()) {
/*       */               this.talentList_ = other.talentList_;
/*       */               this.bitField0_ &= 0xFFFFFFEF;
/*       */             } else {
/*       */               ensureTalentListIsMutable();
/*       */               this.talentList_.addAll(other.talentList_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.talentList_.isEmpty()) {
/*       */           if (this.talentListBuilder_.isEmpty()) {
/*       */             this.talentListBuilder_.dispose();
/*       */             this.talentListBuilder_ = null;
/*       */             this.talentList_ = other.talentList_;
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */             this.talentListBuilder_ = SkillHandler.SkillDetail.alwaysUseFieldBuilders ? getTalentListFieldBuilder() : null;
/*       */           } else {
/*       */             this.talentListBuilder_.addAllMessages(other.talentList_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasCanUpgrade())
/*       */           setCanUpgrade(other.getCanUpgrade()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       } public final boolean isInitialized() {
/*       */         if (!hasColddown())
/*       */           return false; 
/*       */         if (!hasCurManaCost())
/*       */           return false; 
/*       */         int i;
/*       */         for (i = 0; i < getReqItemsCount(); i++) {
/*       */           if (!getReqItems(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         for (i = 0; i < getTalentListCount(); i++) {
/*       */           if (!getTalentList(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.SkillDetail parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.SkillDetail)SkillHandler.SkillDetail.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.SkillDetail)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       } public boolean hasColddown() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       } public int getColddown() {
/*       */         return this.colddown_;
/*       */       } public Builder setColddown(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.colddown_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearColddown() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.colddown_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasCurManaCost() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       } public int getCurManaCost() {
/*       */         return this.curManaCost_;
/*       */       } public Builder setCurManaCost(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.curManaCost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearCurManaCost() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.curManaCost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } private void ensureCurDesDataIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.curDesData_ = (LazyStringList)new LazyStringArrayList(this.curDesData_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       } public ProtocolStringList getCurDesDataList() {
/*       */         return (ProtocolStringList)this.curDesData_.getUnmodifiableView();
/*       */       } public int getCurDesDataCount() {
/*       */         return this.curDesData_.size();
/*       */       } public String getCurDesData(int index) {
/*       */         return (String)this.curDesData_.get(index);
/*       */       } public ByteString getCurDesDataBytes(int index) {
/*       */         return this.curDesData_.getByteString(index);
/*       */       } public Builder setCurDesData(int index, String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.set(index, value);
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder addCurDesData(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder addAllCurDesData(Iterable<String> values) {
/*       */         ensureCurDesDataIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, (Collection)this.curDesData_);
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearCurDesData() {
/*       */         this.curDesData_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder addCurDesDataBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureCurDesDataIsMutable();
/*       */         this.curDesData_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       } private void ensureReqItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.reqItems_ = new ArrayList<>(this.reqItems_);
/*       */           this.bitField0_ |= 0x8;
/*       */         } 
/*       */       } public List<SkillHandler.ReqItem> getReqItemsList() {
/*       */         if (this.reqItemsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.reqItems_); 
/*       */         return this.reqItemsBuilder_.getMessageList();
/*       */       } public int getReqItemsCount() {
/*       */         if (this.reqItemsBuilder_ == null)
/*       */           return this.reqItems_.size(); 
/*       */         return this.reqItemsBuilder_.getCount();
/*       */       } public SkillHandler.ReqItem getReqItems(int index) {
/*       */         if (this.reqItemsBuilder_ == null)
/*       */           return this.reqItems_.get(index); 
/*       */         return (SkillHandler.ReqItem)this.reqItemsBuilder_.getMessage(index);
/*       */       } public Builder setReqItems(int index, SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder setReqItems(int index, SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addReqItems(SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addReqItems(int index, SkillHandler.ReqItem value) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addReqItems(SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addReqItems(int index, SkillHandler.ReqItem.Builder builderForValue) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addAllReqItems(Iterable<? extends SkillHandler.ReqItem> values) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.reqItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       } public Builder clearReqItems() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder removeReqItems(int index) {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           ensureReqItemsIsMutable();
/*       */           this.reqItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.reqItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       } public SkillHandler.ReqItem.Builder getReqItemsBuilder(int index) {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().getBuilder(index);
/*       */       } public SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int index) {
/*       */         if (this.reqItemsBuilder_ == null)
/*       */           return this.reqItems_.get(index); 
/*       */         return (SkillHandler.ReqItemOrBuilder)this.reqItemsBuilder_.getMessageOrBuilder(index);
/*       */       } public List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList() {
/*       */         if (this.reqItemsBuilder_ != null)
/*       */           return this.reqItemsBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.reqItems_);
/*       */       } public SkillHandler.ReqItem.Builder addReqItemsBuilder() {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().addBuilder(SkillHandler.ReqItem.getDefaultInstance());
/*       */       } public SkillHandler.ReqItem.Builder addReqItemsBuilder(int index) {
/*       */         return (SkillHandler.ReqItem.Builder)getReqItemsFieldBuilder().addBuilder(index, SkillHandler.ReqItem.getDefaultInstance());
/*       */       } public List<SkillHandler.ReqItem.Builder> getReqItemsBuilderList() {
/*       */         return getReqItemsFieldBuilder().getBuilderList();
/*       */       } private RepeatedFieldBuilder<SkillHandler.ReqItem, SkillHandler.ReqItem.Builder, SkillHandler.ReqItemOrBuilder> getReqItemsFieldBuilder() {
/*       */         if (this.reqItemsBuilder_ == null) {
/*       */           this.reqItemsBuilder_ = new RepeatedFieldBuilder(this.reqItems_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.reqItems_ = null;
/*       */         } 
/*       */         return this.reqItemsBuilder_;
/*       */       } private void ensureTalentListIsMutable() {
/*       */         if ((this.bitField0_ & 0x10) != 16) {
/*       */           this.talentList_ = new ArrayList<>(this.talentList_);
/*       */           this.bitField0_ |= 0x10;
/*       */         } 
/*       */       } public List<SkillHandler.TalentDetail> getTalentListList() {
/*       */         if (this.talentListBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.talentList_); 
/*       */         return this.talentListBuilder_.getMessageList();
/*       */       } public int getTalentListCount() {
/*       */         if (this.talentListBuilder_ == null)
/*       */           return this.talentList_.size(); 
/*       */         return this.talentListBuilder_.getCount();
/*       */       } public SkillHandler.TalentDetail getTalentList(int index) {
/*       */         if (this.talentListBuilder_ == null)
/*       */           return this.talentList_.get(index); 
/*       */         return (SkillHandler.TalentDetail)this.talentListBuilder_.getMessage(index);
/*       */       } public Builder setTalentList(int index, SkillHandler.TalentDetail value) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder setTalentList(int index, SkillHandler.TalentDetail.Builder builderForValue) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addTalentList(SkillHandler.TalentDetail value) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addTalentList(int index, SkillHandler.TalentDetail value) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addTalentList(SkillHandler.TalentDetail.Builder builderForValue) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addTalentList(int index, SkillHandler.TalentDetail.Builder builderForValue) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addAllTalentList(Iterable<? extends SkillHandler.TalentDetail> values) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           ensureTalentListIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.talentList_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       } public Builder clearTalentList() {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           this.talentList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder removeTalentList(int index) {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           ensureTalentListIsMutable();
/*       */           this.talentList_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.talentListBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       } public SkillHandler.TalentDetail.Builder getTalentListBuilder(int index) {
/*       */         return (SkillHandler.TalentDetail.Builder)getTalentListFieldBuilder().getBuilder(index);
/*       */       } public SkillHandler.TalentDetailOrBuilder getTalentListOrBuilder(int index) {
/*       */         if (this.talentListBuilder_ == null)
/*       */           return this.talentList_.get(index); 
/*       */         return (SkillHandler.TalentDetailOrBuilder)this.talentListBuilder_.getMessageOrBuilder(index);
/*       */       } public List<? extends SkillHandler.TalentDetailOrBuilder> getTalentListOrBuilderList() {
/*       */         if (this.talentListBuilder_ != null)
/*       */           return this.talentListBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.talentList_);
/*       */       } public SkillHandler.TalentDetail.Builder addTalentListBuilder() {
/*       */         return (SkillHandler.TalentDetail.Builder)getTalentListFieldBuilder().addBuilder(SkillHandler.TalentDetail.getDefaultInstance());
/*       */       } public SkillHandler.TalentDetail.Builder addTalentListBuilder(int index) {
/*       */         return (SkillHandler.TalentDetail.Builder)getTalentListFieldBuilder().addBuilder(index, SkillHandler.TalentDetail.getDefaultInstance());
/*       */       } public List<SkillHandler.TalentDetail.Builder> getTalentListBuilderList() {
/*       */         return getTalentListFieldBuilder().getBuilderList();
/*       */       } private RepeatedFieldBuilder<SkillHandler.TalentDetail, SkillHandler.TalentDetail.Builder, SkillHandler.TalentDetailOrBuilder> getTalentListFieldBuilder() {
/*       */         if (this.talentListBuilder_ == null) {
/*       */           this.talentListBuilder_ = new RepeatedFieldBuilder(this.talentList_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*       */           this.talentList_ = null;
/*       */         } 
/*       */         return this.talentListBuilder_;
/*       */       } public boolean hasCanUpgrade() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       public int getCanUpgrade() {
/*       */         return this.canUpgrade_;
/*       */       }
/*       */       public Builder setCanUpgrade(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.canUpgrade_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearCanUpgrade() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.canUpgrade_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  8093 */   public static final class UpgradeSkillResponse extends GeneratedMessage implements UpgradeSkillResponseOrBuilder { private static final UpgradeSkillResponse defaultInstance = new UpgradeSkillResponse(true); private final UnknownFieldSet unknownFields; private UpgradeSkillResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeSkillResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeSkillResponse getDefaultInstance() { return defaultInstance; } public UpgradeSkillResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeSkillResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeSkillResponse.class, Builder.class); } public static Parser<UpgradeSkillResponse> PARSER = (Parser<UpgradeSkillResponse>)new AbstractParser<UpgradeSkillResponse>() { public SkillHandler.UpgradeSkillResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UpgradeSkillResponse(input, extensionRegistry); } }
/*  8094 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeSkillResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getS2CMsg() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.s2CMsg_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getS2CMsgBytes() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpgradeSkillResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(UpgradeSkillResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.UpgradeSkillResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UpgradeSkillResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.UpgradeSkillResponse.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillResponse getDefaultInstanceForType() {
/*       */         return SkillHandler.UpgradeSkillResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillResponse build() {
/*       */         SkillHandler.UpgradeSkillResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.UpgradeSkillResponse buildPartial() {
/*       */         SkillHandler.UpgradeSkillResponse result = new SkillHandler.UpgradeSkillResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.UpgradeSkillResponse) {
/*       */           return mergeFrom((SkillHandler.UpgradeSkillResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.UpgradeSkillResponse other) {
/*       */         if (other == SkillHandler.UpgradeSkillResponse.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.UpgradeSkillResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillResponse)SkillHandler.UpgradeSkillResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.s2CMsg_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = SkillHandler.UpgradeSkillResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class UpgradeSkillOneKeyResponse
/*       */     extends GeneratedMessage
/*       */     implements UpgradeSkillOneKeyResponseOrBuilder
/*       */   {
/*  9027 */     private static final UpgradeSkillOneKeyResponse defaultInstance = new UpgradeSkillOneKeyResponse(true); private final UnknownFieldSet unknownFields; private UpgradeSkillOneKeyResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeSkillOneKeyResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeSkillOneKeyResponse getDefaultInstance() { return defaultInstance; } public UpgradeSkillOneKeyResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeSkillOneKeyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.skillList_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.skillList_.add(input.readMessage(SkillHandler.SkillBasic.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.skillList_ = Collections.unmodifiableList(this.skillList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeSkillOneKeyResponse.class, Builder.class); } public static Parser<UpgradeSkillOneKeyResponse> PARSER = (Parser<UpgradeSkillOneKeyResponse>)new AbstractParser<UpgradeSkillOneKeyResponse>() { public SkillHandler.UpgradeSkillOneKeyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UpgradeSkillOneKeyResponse(input, extensionRegistry); } }
/*  9028 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int SKILLLIST_FIELD_NUMBER = 3; private List<SkillHandler.SkillBasic> skillList_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeSkillOneKeyResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */     
/*       */     public List<SkillHandler.SkillBasic> getSkillListList() {
/*       */       return this.skillList_;
/*       */     }
/*       */     
/*       */     public List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList() {
/*       */       return (List)this.skillList_;
/*       */     }
/*       */     
/*       */     public int getSkillListCount() {
/*       */       return this.skillList_.size();
/*       */     }
/*       */     
/*       */     public SkillHandler.SkillBasic getSkillList(int index) {
/*       */       return this.skillList_.get(index);
/*       */     }
/*       */     
/*       */     public SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int index) {
/*       */       return this.skillList_.get(index);
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.skillList_ = Collections.emptyList();
/*       */     }
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getSkillListCount(); i++) {
/*       */         if (!getSkillList(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.skillList_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.skillList_.get(i)); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.skillList_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.skillList_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeSkillOneKeyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeSkillOneKeyResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     
/*       */     public static Builder newBuilder(UpgradeSkillOneKeyResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.UpgradeSkillOneKeyResponseOrBuilder { private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private List<SkillHandler.SkillBasic> skillList_;
/*       */       private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> skillListBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UpgradeSkillOneKeyResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.skillList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.skillList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.UpgradeSkillOneKeyResponse.alwaysUseFieldBuilders)
/*       */           getSkillListFieldBuilder(); 
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.skillListBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_UpgradeSkillOneKeyResponse_descriptor;
/*       */       }
/*       */       
/*       */       public SkillHandler.UpgradeSkillOneKeyResponse getDefaultInstanceForType() {
/*       */         return SkillHandler.UpgradeSkillOneKeyResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public SkillHandler.UpgradeSkillOneKeyResponse build() {
/*       */         SkillHandler.UpgradeSkillOneKeyResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public SkillHandler.UpgradeSkillOneKeyResponse buildPartial() {
/*       */         SkillHandler.UpgradeSkillOneKeyResponse result = new SkillHandler.UpgradeSkillOneKeyResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.skillList_ = Collections.unmodifiableList(this.skillList_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.skillList_ = this.skillList_;
/*       */         } else {
/*       */           result.skillList_ = this.skillListBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.UpgradeSkillOneKeyResponse)
/*       */           return mergeFrom((SkillHandler.UpgradeSkillOneKeyResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.UpgradeSkillOneKeyResponse other) {
/*       */         if (other == SkillHandler.UpgradeSkillOneKeyResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (!other.skillList_.isEmpty()) {
/*       */             if (this.skillList_.isEmpty()) {
/*       */               this.skillList_ = other.skillList_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureSkillListIsMutable();
/*       */               this.skillList_.addAll(other.skillList_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.skillList_.isEmpty()) {
/*       */           if (this.skillListBuilder_.isEmpty()) {
/*       */             this.skillListBuilder_.dispose();
/*       */             this.skillListBuilder_ = null;
/*       */             this.skillList_ = other.skillList_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.skillListBuilder_ = SkillHandler.UpgradeSkillOneKeyResponse.alwaysUseFieldBuilders ? getSkillListFieldBuilder() : null;
/*       */           } else {
/*       */             this.skillListBuilder_.addAllMessages(other.skillList_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getSkillListCount(); i++) {
/*       */           if (!getSkillList(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.UpgradeSkillOneKeyResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillOneKeyResponse)SkillHandler.UpgradeSkillOneKeyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.UpgradeSkillOneKeyResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */       
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = SkillHandler.UpgradeSkillOneKeyResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       private void ensureSkillListIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.skillList_ = new ArrayList<>(this.skillList_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       
/*       */       public List<SkillHandler.SkillBasic> getSkillListList() {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.skillList_); 
/*       */         return this.skillListBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getSkillListCount() {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.size(); 
/*       */         return this.skillListBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic getSkillList(int index) {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.get(index); 
/*       */         return (SkillHandler.SkillBasic)this.skillListBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setSkillList(int index, SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setSkillList(int index, SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(int index, SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(int index, SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllSkillList(Iterable<? extends SkillHandler.SkillBasic> values) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.skillList_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearSkillList() {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeSkillList(int index) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder getSkillListBuilder(int index) {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int index) {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.get(index); 
/*       */         return (SkillHandler.SkillBasicOrBuilder)this.skillListBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList() {
/*       */         if (this.skillListBuilder_ != null)
/*       */           return this.skillListBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.skillList_);
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder addSkillListBuilder() {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().addBuilder(SkillHandler.SkillBasic.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder addSkillListBuilder(int index) {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().addBuilder(index, SkillHandler.SkillBasic.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<SkillHandler.SkillBasic.Builder> getSkillListBuilderList() {
/*       */         return getSkillListFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> getSkillListFieldBuilder() {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillListBuilder_ = new RepeatedFieldBuilder(this.skillList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.skillList_ = null;
/*       */         } 
/*       */         return this.skillListBuilder_;
/*       */       } }
/*       */   }
/*       */   
/*       */   public static final class GetSkillDetailResponse extends GeneratedMessage implements GetSkillDetailResponseOrBuilder { private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private GetSkillDetailResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private GetSkillDetailResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static GetSkillDetailResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public GetSkillDetailResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private GetSkillDetailResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       initFields();
/*       */       int mutable_bitField0_ = 0;
/*       */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*       */       try {
/*       */         boolean done = false;
/*       */         while (!done) {
/*       */           ByteString bs;
/*       */           SkillHandler.SkillDetail.Builder subBuilder;
/*       */           int tag = input.readTag();
/*       */           switch (tag) {
/*       */             case 0:
/*       */               done = true;
/*       */               break;
/*       */             case 8:
/*       */               this.bitField0_ |= 0x1;
/*       */               this.s2CCode_ = input.readInt32();
/*       */               break;
/*       */             case 18:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x2;
/*       */               this.s2CMsg_ = bs;
/*       */               break;
/*       */             case 26:
/*       */               subBuilder = null;
/*       */               if ((this.bitField0_ & 0x4) == 4)
/*       */                 subBuilder = this.s2CSkill_.toBuilder(); 
/*       */               this.s2CSkill_ = (SkillHandler.SkillDetail)input.readMessage(SkillHandler.SkillDetail.PARSER, extensionRegistry);
/*       */               if (subBuilder != null) {
/*       */                 subBuilder.mergeFrom(this.s2CSkill_);
/*       */                 this.s2CSkill_ = subBuilder.buildPartial();
/*       */               } 
/*       */               this.bitField0_ |= 0x4;
/*       */               break;
/*       */           } 
/*       */         } 
/*       */       } catch (InvalidProtocolBufferException e) {
/*       */         throw e.setUnfinishedMessage(this);
/*       */       } catch (IOException e) {
/*       */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*       */       } finally {
/*       */         this.unknownFields = unknownFields.build();
/*       */         makeExtensionsImmutable();
/*       */       } 
/*       */     }
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return SkillHandler.internal_static_pomelo_area_GetSkillDetailResponse_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return SkillHandler.internal_static_pomelo_area_GetSkillDetailResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSkillDetailResponse.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<GetSkillDetailResponse> PARSER = (Parser<GetSkillDetailResponse>)new AbstractParser<GetSkillDetailResponse>() {
/*       */         public SkillHandler.GetSkillDetailResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new SkillHandler.GetSkillDetailResponse(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */     private int s2CCode_;
/*       */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*       */     private Object s2CMsg_;
/*       */     public static final int S2C_SKILL_FIELD_NUMBER = 3;
/*       */     private SkillHandler.SkillDetail s2CSkill_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<GetSkillDetailResponse> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasS2CCode() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public int getS2CCode() {
/*       */       return this.s2CCode_;
/*       */     }
/*       */     
/*       */     public boolean hasS2CMsg() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */     
/*       */     public String getS2CMsg() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.s2CMsg_ = s; 
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getS2CMsgBytes() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     public boolean hasS2CSkill() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public SkillHandler.SkillDetail getS2CSkill() {
/*       */       return this.s2CSkill_;
/*       */     }
/*       */     
/*       */     public SkillHandler.SkillDetailOrBuilder getS2CSkillOrBuilder() {
/*       */       return this.s2CSkill_;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CSkill_ = SkillHandler.SkillDetail.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (hasS2CSkill() && !getS2CSkill().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeMessage(3, (MessageLite)this.s2CSkill_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CSkill_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static GetSkillDetailResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static GetSkillDetailResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static GetSkillDetailResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static GetSkillDetailResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetSkillDetailResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*  9790 */     private static final GetSkillDetailResponse defaultInstance = new GetSkillDetailResponse(true); public static GetSkillDetailResponse parseFrom(InputStream input) throws IOException { return (GetSkillDetailResponse)PARSER.parseFrom(input); } public static GetSkillDetailResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetSkillDetailResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetSkillDetailResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetSkillDetailResponse)PARSER.parseDelimitedFrom(input); } public static GetSkillDetailResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetSkillDetailResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetSkillDetailResponse parseFrom(CodedInputStream input) throws IOException { return (GetSkillDetailResponse)PARSER.parseFrom(input); } public static GetSkillDetailResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetSkillDetailResponse)PARSER.parseFrom(input, extensionRegistry); }
/*  9791 */     static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(GetSkillDetailResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.GetSkillDetailResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SkillHandler.SkillDetail s2CSkill_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<SkillHandler.SkillDetail, SkillHandler.SkillDetail.Builder, SkillHandler.SkillDetailOrBuilder> s2CSkillBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.GetSkillDetailResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CSkill_ = SkillHandler.SkillDetail.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CSkill_ = SkillHandler.SkillDetail.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.GetSkillDetailResponse.alwaysUseFieldBuilders) {
/*       */           getS2CSkillFieldBuilder();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           this.s2CSkill_ = SkillHandler.SkillDetail.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CSkillBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetSkillDetailResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailResponse getDefaultInstanceForType() {
/*       */         return SkillHandler.GetSkillDetailResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailResponse build() {
/*       */         SkillHandler.GetSkillDetailResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.GetSkillDetailResponse buildPartial() {
/*       */         SkillHandler.GetSkillDetailResponse result = new SkillHandler.GetSkillDetailResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           result.s2CSkill_ = this.s2CSkill_;
/*       */         } else {
/*       */           result.s2CSkill_ = (SkillHandler.SkillDetail)this.s2CSkillBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.GetSkillDetailResponse) {
/*       */           return mergeFrom((SkillHandler.GetSkillDetailResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.GetSkillDetailResponse other) {
/*       */         if (other == SkillHandler.GetSkillDetailResponse.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasS2CSkill()) {
/*       */           mergeS2CSkill(other.getS2CSkill());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (hasS2CSkill() && !getS2CSkill().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.GetSkillDetailResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.GetSkillDetailResponse)SkillHandler.GetSkillDetailResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.GetSkillDetailResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.s2CMsg_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = SkillHandler.GetSkillDetailResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CSkill() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillDetail getS2CSkill() {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           return this.s2CSkill_;
/*       */         }
/*       */         return (SkillHandler.SkillDetail)this.s2CSkillBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CSkill(SkillHandler.SkillDetail value) {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CSkill_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CSkillBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CSkill(SkillHandler.SkillDetail.Builder builderForValue) {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           this.s2CSkill_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CSkillBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeS2CSkill(SkillHandler.SkillDetail value) {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CSkill_ != SkillHandler.SkillDetail.getDefaultInstance()) {
/*       */             this.s2CSkill_ = SkillHandler.SkillDetail.newBuilder(this.s2CSkill_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CSkill_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CSkillBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CSkill() {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           this.s2CSkill_ = SkillHandler.SkillDetail.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CSkillBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillDetail.Builder getS2CSkillBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (SkillHandler.SkillDetail.Builder)getS2CSkillFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public SkillHandler.SkillDetailOrBuilder getS2CSkillOrBuilder() {
/*       */         if (this.s2CSkillBuilder_ != null) {
/*       */           return (SkillHandler.SkillDetailOrBuilder)this.s2CSkillBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.s2CSkill_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<SkillHandler.SkillDetail, SkillHandler.SkillDetail.Builder, SkillHandler.SkillDetailOrBuilder> getS2CSkillFieldBuilder() {
/*       */         if (this.s2CSkillBuilder_ == null) {
/*       */           this.s2CSkillBuilder_ = new SingleFieldBuilder(getS2CSkill(), getParentForChildren(), isClean());
/*       */           this.s2CSkill_ = null;
/*       */         } 
/*       */         return this.s2CSkillBuilder_;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class GetAllSkillResponse
/*       */     extends GeneratedMessage
/*       */     implements GetAllSkillResponseOrBuilder
/*       */   {
/* 10842 */     private static final GetAllSkillResponse defaultInstance = new GetAllSkillResponse(true); private final UnknownFieldSet unknownFields; private GetAllSkillResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetAllSkillResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetAllSkillResponse getDefaultInstance() { return defaultInstance; } public GetAllSkillResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetAllSkillResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.hubLock_ = input.readBool(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.skillList_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.skillList_.add(input.readMessage(SkillHandler.SkillBasic.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.skillList_ = Collections.unmodifiableList(this.skillList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_GetAllSkillResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_GetAllSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllSkillResponse.class, Builder.class); } public static Parser<GetAllSkillResponse> PARSER = (Parser<GetAllSkillResponse>)new AbstractParser<GetAllSkillResponse>() { public SkillHandler.GetAllSkillResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.GetAllSkillResponse(input, extensionRegistry); } }
/* 10843 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int HUBLOCK_FIELD_NUMBER = 3; private boolean hubLock_; public static final int SKILLLIST_FIELD_NUMBER = 4; private List<SkillHandler.SkillBasic> skillList_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetAllSkillResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */     
/*       */     public boolean hasHubLock() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     public boolean getHubLock() {
/*       */       return this.hubLock_;
/*       */     }
/*       */     public List<SkillHandler.SkillBasic> getSkillListList() {
/*       */       return this.skillList_;
/*       */     }
/*       */     public List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList() {
/*       */       return (List)this.skillList_;
/*       */     }
/*       */     public int getSkillListCount() {
/*       */       return this.skillList_.size();
/*       */     }
/*       */     public SkillHandler.SkillBasic getSkillList(int index) {
/*       */       return this.skillList_.get(index);
/*       */     }
/*       */     public SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int index) {
/*       */       return this.skillList_.get(index);
/*       */     }
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.hubLock_ = false;
/*       */       this.skillList_ = Collections.emptyList();
/*       */     }
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasHubLock()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getSkillListCount(); i++) {
/*       */         if (!getSkillList(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeBool(3, this.hubLock_); 
/*       */       for (int i = 0; i < this.skillList_.size(); i++)
/*       */         output.writeMessage(4, (MessageLite)this.skillList_.get(i)); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBoolSize(3, this.hubLock_); 
/*       */       for (int i = 0; i < this.skillList_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.skillList_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(InputStream input) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static GetAllSkillResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static GetAllSkillResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static GetAllSkillResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetAllSkillResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(GetAllSkillResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.GetAllSkillResponseOrBuilder { private int bitField0_; private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private boolean hubLock_;
/*       */       private List<SkillHandler.SkillBasic> skillList_;
/*       */       private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> skillListBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetAllSkillResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetAllSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.GetAllSkillResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.skillList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.skillList_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.GetAllSkillResponse.alwaysUseFieldBuilders)
/*       */           getSkillListFieldBuilder(); 
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.hubLock_ = false;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.skillListBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_GetAllSkillResponse_descriptor;
/*       */       }
/*       */       
/*       */       public SkillHandler.GetAllSkillResponse getDefaultInstanceForType() {
/*       */         return SkillHandler.GetAllSkillResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public SkillHandler.GetAllSkillResponse build() {
/*       */         SkillHandler.GetAllSkillResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public SkillHandler.GetAllSkillResponse buildPartial() {
/*       */         SkillHandler.GetAllSkillResponse result = new SkillHandler.GetAllSkillResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.hubLock_ = this.hubLock_;
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.skillList_ = Collections.unmodifiableList(this.skillList_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.skillList_ = this.skillList_;
/*       */         } else {
/*       */           result.skillList_ = this.skillListBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.GetAllSkillResponse)
/*       */           return mergeFrom((SkillHandler.GetAllSkillResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.GetAllSkillResponse other) {
/*       */         if (other == SkillHandler.GetAllSkillResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasHubLock())
/*       */           setHubLock(other.getHubLock()); 
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (!other.skillList_.isEmpty()) {
/*       */             if (this.skillList_.isEmpty()) {
/*       */               this.skillList_ = other.skillList_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureSkillListIsMutable();
/*       */               this.skillList_.addAll(other.skillList_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.skillList_.isEmpty()) {
/*       */           if (this.skillListBuilder_.isEmpty()) {
/*       */             this.skillListBuilder_.dispose();
/*       */             this.skillListBuilder_ = null;
/*       */             this.skillList_ = other.skillList_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.skillListBuilder_ = SkillHandler.GetAllSkillResponse.alwaysUseFieldBuilders ? getSkillListFieldBuilder() : null;
/*       */           } else {
/*       */             this.skillListBuilder_.addAllMessages(other.skillList_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (!hasHubLock())
/*       */           return false; 
/*       */         for (int i = 0; i < getSkillListCount(); i++) {
/*       */           if (!getSkillList(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.GetAllSkillResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.GetAllSkillResponse)SkillHandler.GetAllSkillResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.GetAllSkillResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */       
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = SkillHandler.GetAllSkillResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasHubLock() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public boolean getHubLock() {
/*       */         return this.hubLock_;
/*       */       }
/*       */       
/*       */       public Builder setHubLock(boolean value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.hubLock_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearHubLock() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.hubLock_ = false;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       private void ensureSkillListIsMutable() {
/*       */         if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.skillList_ = new ArrayList<>(this.skillList_);
/*       */           this.bitField0_ |= 0x8;
/*       */         } 
/*       */       }
/*       */       
/*       */       public List<SkillHandler.SkillBasic> getSkillListList() {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.skillList_); 
/*       */         return this.skillListBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getSkillListCount() {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.size(); 
/*       */         return this.skillListBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic getSkillList(int index) {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.get(index); 
/*       */         return (SkillHandler.SkillBasic)this.skillListBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setSkillList(int index, SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setSkillList(int index, SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(int index, SkillHandler.SkillBasic value) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addSkillList(int index, SkillHandler.SkillBasic.Builder builderForValue) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllSkillList(Iterable<? extends SkillHandler.SkillBasic> values) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.skillList_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearSkillList() {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillList_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeSkillList(int index) {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           ensureSkillListIsMutable();
/*       */           this.skillList_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skillListBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder getSkillListBuilder(int index) {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int index) {
/*       */         if (this.skillListBuilder_ == null)
/*       */           return this.skillList_.get(index); 
/*       */         return (SkillHandler.SkillBasicOrBuilder)this.skillListBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList() {
/*       */         if (this.skillListBuilder_ != null)
/*       */           return this.skillListBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.skillList_);
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder addSkillListBuilder() {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().addBuilder(SkillHandler.SkillBasic.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public SkillHandler.SkillBasic.Builder addSkillListBuilder(int index) {
/*       */         return (SkillHandler.SkillBasic.Builder)getSkillListFieldBuilder().addBuilder(index, SkillHandler.SkillBasic.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<SkillHandler.SkillBasic.Builder> getSkillListBuilderList() {
/*       */         return getSkillListFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> getSkillListFieldBuilder() {
/*       */         if (this.skillListBuilder_ == null) {
/*       */           this.skillListBuilder_ = new RepeatedFieldBuilder(this.skillList_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.skillList_ = null;
/*       */         } 
/*       */         return this.skillListBuilder_;
/*       */       } } }
/*       */   
/* 11404 */   public static final class UseSkillTabResponse extends GeneratedMessage implements UseSkillTabResponseOrBuilder { private static final UseSkillTabResponse defaultInstance = new UseSkillTabResponse(true); private final UnknownFieldSet unknownFields; private UseSkillTabResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UseSkillTabResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UseSkillTabResponse getDefaultInstance() { return defaultInstance; } public UseSkillTabResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UseSkillTabResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UseSkillTabResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UseSkillTabResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UseSkillTabResponse.class, Builder.class); } public static Parser<UseSkillTabResponse> PARSER = (Parser<UseSkillTabResponse>)new AbstractParser<UseSkillTabResponse>() { public SkillHandler.UseSkillTabResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.UseSkillTabResponse(input, extensionRegistry); } }
/* 11405 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UseSkillTabResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     public String getS2CMsg() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.s2CMsg_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */     
/*       */     public ByteString getS2CMsgBytes() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */     }
/*       */ 
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UseSkillTabResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static UseSkillTabResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static UseSkillTabResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseSkillTabResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     
/*       */     public static Builder newBuilder(UseSkillTabResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements SkillHandler.UseSkillTabResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return SkillHandler.internal_static_pomelo_area_UseSkillTabResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return SkillHandler.internal_static_pomelo_area_UseSkillTabResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UseSkillTabResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (SkillHandler.UseSkillTabResponse.alwaysUseFieldBuilders);
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return SkillHandler.internal_static_pomelo_area_UseSkillTabResponse_descriptor;
/*       */       }
/*       */       
/*       */       public SkillHandler.UseSkillTabResponse getDefaultInstanceForType() {
/*       */         return SkillHandler.UseSkillTabResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public SkillHandler.UseSkillTabResponse build() {
/*       */         SkillHandler.UseSkillTabResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */       
/*       */       public SkillHandler.UseSkillTabResponse buildPartial() {
/*       */         SkillHandler.UseSkillTabResponse result = new SkillHandler.UseSkillTabResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof SkillHandler.UseSkillTabResponse) {
/*       */           return mergeFrom((SkillHandler.UseSkillTabResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(SkillHandler.UseSkillTabResponse other) {
/*       */         if (other == SkillHandler.UseSkillTabResponse.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         SkillHandler.UseSkillTabResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (SkillHandler.UseSkillTabResponse)SkillHandler.UseSkillTabResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (SkillHandler.UseSkillTabResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */       
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.s2CMsg_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = SkillHandler.UseSkillTabResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */   
/*       */   public static final class UnlockSkillResponse
/*       */     extends GeneratedMessage
/*       */     implements UnlockSkillResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private UnlockSkillResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private UnlockSkillResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public UnlockSkillResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private UnlockSkillResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       initFields();
/*       */       int mutable_bitField0_ = 0;
/*       */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*       */       try {
/*       */         boolean done = false;
/*       */         while (!done) {
/*       */           ByteString bs;
/*       */           int tag = input.readTag();
/*       */           switch (tag) {
/*       */             case 0:
/*       */               done = true;
/*       */               break;
/*       */             case 8:
/*       */               this.bitField0_ |= 0x1;
/*       */               this.s2CCode_ = input.readInt32();
/*       */               break;
/*       */             case 18:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x2;
/*       */               this.s2CMsg_ = bs;
/*       */               break;
/*       */           } 
/*       */         } 
/*       */       } catch (InvalidProtocolBufferException e) {
/*       */         throw e.setUnfinishedMessage(this);
/*       */       } catch (IOException e) {
/*       */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*       */       } finally {
/*       */         this.unknownFields = unknownFields.build();
/*       */         makeExtensionsImmutable();
/*       */       } 
/*       */     }
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return SkillHandler.internal_static_pomelo_area_UnlockSkillResponse_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return SkillHandler.internal_static_pomelo_area_UnlockSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockSkillResponse.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<UnlockSkillResponse> PARSER = (Parser<UnlockSkillResponse>)new AbstractParser<UnlockSkillResponse>()
/*       */       {
/*       */         public SkillHandler.UnlockSkillResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new SkillHandler.UnlockSkillResponse(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */     private int s2CCode_;
/*       */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*       */     private Object s2CMsg_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<UnlockSkillResponse> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasS2CCode() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public int getS2CCode() {
/*       */       return this.s2CCode_;
/*       */     }
/*       */     
/*       */     public boolean hasS2CMsg() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */     
/*       */     public String getS2CMsg() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.s2CMsg_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getS2CMsgBytes() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */     }
/*       */     
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UnlockSkillResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UnlockSkillResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UnlockSkillResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/* 11966 */     private static final UnlockSkillResponse defaultInstance = new UnlockSkillResponse(true); public static UnlockSkillResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnlockSkillResponse)PARSER.parseFrom(input, extensionRegistry); } public static UnlockSkillResponse parseDelimitedFrom(InputStream input) throws IOException { return (UnlockSkillResponse)PARSER.parseDelimitedFrom(input); } public static UnlockSkillResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnlockSkillResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnlockSkillResponse parseFrom(CodedInputStream input) throws IOException { return (UnlockSkillResponse)PARSER.parseFrom(input); } public static UnlockSkillResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnlockSkillResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnlockSkillResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.UnlockSkillResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_UnlockSkillResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_UnlockSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.UnlockSkillResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (SkillHandler.UnlockSkillResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return SkillHandler.internal_static_pomelo_area_UnlockSkillResponse_descriptor; } public SkillHandler.UnlockSkillResponse getDefaultInstanceForType() { return SkillHandler.UnlockSkillResponse.getDefaultInstance(); } public SkillHandler.UnlockSkillResponse build() { SkillHandler.UnlockSkillResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public SkillHandler.UnlockSkillResponse buildPartial() { SkillHandler.UnlockSkillResponse result = new SkillHandler.UnlockSkillResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof SkillHandler.UnlockSkillResponse) return mergeFrom((SkillHandler.UnlockSkillResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(SkillHandler.UnlockSkillResponse other) { if (other == SkillHandler.UnlockSkillResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { SkillHandler.UnlockSkillResponse parsedMessage = null; try { parsedMessage = (SkillHandler.UnlockSkillResponse)SkillHandler.UnlockSkillResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (SkillHandler.UnlockSkillResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = SkillHandler.UnlockSkillResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/* 11967 */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*       */   
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class SkillUpdatePush
/*       */     extends GeneratedMessage
/*       */     implements SkillUpdatePushOrBuilder
/*       */   {
/* 12861 */     private static final SkillUpdatePush defaultInstance = new SkillUpdatePush(true); private final UnknownFieldSet unknownFields; private SkillUpdatePush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkillUpdatePush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkillUpdatePush getDefaultInstance() { return defaultInstance; } public SkillUpdatePush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkillUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.s2CData_.add(input.readMessage(SkillHandler.SkillBasic.PARSER, extensionRegistry)); break;case 24: this.bitField0_ |= 0x2; this.hubLock_ = input.readBool(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_SkillUpdatePush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_SkillUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillUpdatePush.class, Builder.class); } public static Parser<SkillUpdatePush> PARSER = (Parser<SkillUpdatePush>)new AbstractParser<SkillUpdatePush>() { public SkillHandler.SkillUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new SkillHandler.SkillUpdatePush(input, extensionRegistry); } }
/* 12862 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_DATA_FIELD_NUMBER = 2; private List<SkillHandler.SkillBasic> s2CData_; public static final int HUBLOCK_FIELD_NUMBER = 3; private boolean hubLock_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkillUpdatePush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public List<SkillHandler.SkillBasic> getS2CDataList() { return this.s2CData_; } public List<? extends SkillHandler.SkillBasicOrBuilder> getS2CDataOrBuilderList() { return (List)this.s2CData_; } public int getS2CDataCount() { return this.s2CData_.size(); } public SkillHandler.SkillBasic getS2CData(int index) { return this.s2CData_.get(index); } public SkillHandler.SkillBasicOrBuilder getS2CDataOrBuilder(int index) { return this.s2CData_.get(index); } public boolean hasHubLock() { return ((this.bitField0_ & 0x2) == 2); } public boolean getHubLock() { return this.hubLock_; } private void initFields() { this.s2CCode_ = 0; this.s2CData_ = Collections.emptyList(); this.hubLock_ = false; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasHubLock()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(2, (MessageLite)this.s2CData_.get(i));  if ((this.bitField0_ & 0x2) == 2) output.writeBool(3, this.hubLock_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  for (int i = 0; i < this.s2CData_.size(); i++) size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.s2CData_.get(i));  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBoolSize(3, this.hubLock_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SkillUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SkillUpdatePush)PARSER.parseFrom(data); } public static SkillUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SkillUpdatePush)PARSER.parseFrom(data, extensionRegistry); } public static SkillUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SkillUpdatePush)PARSER.parseFrom(data); } public static SkillUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SkillUpdatePush)PARSER.parseFrom(data, extensionRegistry); } public static SkillUpdatePush parseFrom(InputStream input) throws IOException { return (SkillUpdatePush)PARSER.parseFrom(input); } public static SkillUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillUpdatePush)PARSER.parseFrom(input, extensionRegistry); } public static SkillUpdatePush parseDelimitedFrom(InputStream input) throws IOException { return (SkillUpdatePush)PARSER.parseDelimitedFrom(input); } public static SkillUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillUpdatePush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static SkillUpdatePush parseFrom(CodedInputStream input) throws IOException { return (SkillUpdatePush)PARSER.parseFrom(input); } public static SkillUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SkillUpdatePush)PARSER.parseFrom(input, extensionRegistry); } static { defaultInstance.initFields(); } public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(SkillUpdatePush prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements SkillHandler.SkillUpdatePushOrBuilder { private int bitField0_; private int s2CCode_; private List<SkillHandler.SkillBasic> s2CData_; private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> s2CDataBuilder_; private boolean hubLock_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return SkillHandler.internal_static_pomelo_area_SkillUpdatePush_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return SkillHandler.internal_static_pomelo_area_SkillUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillHandler.SkillUpdatePush.class, Builder.class); }
/*       */       private Builder() { this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (SkillHandler.SkillUpdatePush.alwaysUseFieldBuilders)
/*       */           getS2CDataFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFD; } else { this.s2CDataBuilder_.clear(); }  this.hubLock_ = false; this.bitField0_ &= 0xFFFFFFFB; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return SkillHandler.internal_static_pomelo_area_SkillUpdatePush_descriptor; }
/*       */       public SkillHandler.SkillUpdatePush getDefaultInstanceForType() { return SkillHandler.SkillUpdatePush.getDefaultInstance(); }
/*       */       public SkillHandler.SkillUpdatePush build() { SkillHandler.SkillUpdatePush result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public SkillHandler.SkillUpdatePush buildPartial() { SkillHandler.SkillUpdatePush result = new SkillHandler.SkillUpdatePush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if (this.s2CDataBuilder_ == null) { if ((this.bitField0_ & 0x2) == 2) { this.s2CData_ = Collections.unmodifiableList(this.s2CData_); this.bitField0_ &= 0xFFFFFFFD; }  result.s2CData_ = this.s2CData_; } else { result.s2CData_ = this.s2CDataBuilder_.build(); }  if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x2;  result.hubLock_ = this.hubLock_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof SkillHandler.SkillUpdatePush)
/*       */           return mergeFrom((SkillHandler.SkillUpdatePush)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(SkillHandler.SkillUpdatePush other) { if (other == SkillHandler.SkillUpdatePush.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (this.s2CDataBuilder_ == null) { if (!other.s2CData_.isEmpty()) { if (this.s2CData_.isEmpty()) { this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFFD; } else { ensureS2CDataIsMutable(); this.s2CData_.addAll(other.s2CData_); }  onChanged(); }  } else if (!other.s2CData_.isEmpty()) { if (this.s2CDataBuilder_.isEmpty()) { this.s2CDataBuilder_.dispose(); this.s2CDataBuilder_ = null; this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFFD; this.s2CDataBuilder_ = SkillHandler.SkillUpdatePush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null; } else { this.s2CDataBuilder_.addAllMessages(other.s2CData_); }  }  if (other.hasHubLock())
/*       */           setHubLock(other.getHubLock());  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false;  if (!hasHubLock())
/*       */           return false;  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized())
/*       */             return false;  }  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { SkillHandler.SkillUpdatePush parsedMessage = null; try { parsedMessage = (SkillHandler.SkillUpdatePush)SkillHandler.SkillUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (SkillHandler.SkillUpdatePush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage);  }  return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*       */       private void ensureS2CDataIsMutable() { if ((this.bitField0_ & 0x2) != 2) { this.s2CData_ = new ArrayList<>(this.s2CData_); this.bitField0_ |= 0x2; }  }
/*       */       public List<SkillHandler.SkillBasic> getS2CDataList() { if (this.s2CDataBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CData_);  return this.s2CDataBuilder_.getMessageList(); }
/*       */       public int getS2CDataCount() { if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.size();  return this.s2CDataBuilder_.getCount(); }
/*       */       public SkillHandler.SkillBasic getS2CData(int index) { if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.get(index);  return (SkillHandler.SkillBasic)this.s2CDataBuilder_.getMessage(index); }
/*       */       public Builder setS2CData(int index, SkillHandler.SkillBasic value) { if (this.s2CDataBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.set(index, value); onChanged(); }
/*       */         else { this.s2CDataBuilder_.setMessage(index, value); }
/*       */          return this; }
/*       */       public Builder setS2CData(int index, SkillHandler.SkillBasic.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.set(index, builderForValue.build()); onChanged(); }
/*       */         else { this.s2CDataBuilder_.setMessage(index, builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addS2CData(SkillHandler.SkillBasic value) { if (this.s2CDataBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(value); onChanged(); }
/*       */         else { this.s2CDataBuilder_.addMessage(value); }
/*       */          return this; }
/*       */       public Builder addS2CData(int index, SkillHandler.SkillBasic value) { if (this.s2CDataBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(index, value); onChanged(); }
/*       */         else { this.s2CDataBuilder_.addMessage(index, value); }
/*       */          return this; }
/*       */       public Builder addS2CData(SkillHandler.SkillBasic.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(builderForValue.build()); onChanged(); }
/*       */         else { this.s2CDataBuilder_.addMessage(builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addS2CData(int index, SkillHandler.SkillBasic.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(index, builderForValue.build()); onChanged(); }
/*       */         else { this.s2CDataBuilder_.addMessage(index, builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addAllS2CData(Iterable<? extends SkillHandler.SkillBasic> values) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CData_); onChanged(); }
/*       */         else { this.s2CDataBuilder_.addAllMessages(values); }
/*       */          return this; }
/*       */       public Builder clearS2CData() { if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFD; onChanged(); }
/*       */         else { this.s2CDataBuilder_.clear(); }
/*       */          return this; }
/*       */       public Builder removeS2CData(int index) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.remove(index); onChanged(); }
/*       */         else { this.s2CDataBuilder_.remove(index); }
/*       */          return this; }
/*       */       public SkillHandler.SkillBasic.Builder getS2CDataBuilder(int index) { return (SkillHandler.SkillBasic.Builder)getS2CDataFieldBuilder().getBuilder(index); }
/*       */       public SkillHandler.SkillBasicOrBuilder getS2CDataOrBuilder(int index) { if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.get(index);  return (SkillHandler.SkillBasicOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends SkillHandler.SkillBasicOrBuilder> getS2CDataOrBuilderList() { if (this.s2CDataBuilder_ != null)
/*       */           return this.s2CDataBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CData_); }
/*       */       public SkillHandler.SkillBasic.Builder addS2CDataBuilder() { return (SkillHandler.SkillBasic.Builder)getS2CDataFieldBuilder().addBuilder(SkillHandler.SkillBasic.getDefaultInstance()); }
/*       */       public SkillHandler.SkillBasic.Builder addS2CDataBuilder(int index) { return (SkillHandler.SkillBasic.Builder)getS2CDataFieldBuilder().addBuilder(index, SkillHandler.SkillBasic.getDefaultInstance()); }
/*       */       public List<SkillHandler.SkillBasic.Builder> getS2CDataBuilderList() { return getS2CDataFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<SkillHandler.SkillBasic, SkillHandler.SkillBasic.Builder, SkillHandler.SkillBasicOrBuilder> getS2CDataFieldBuilder() { if (this.s2CDataBuilder_ == null) { this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean()); this.s2CData_ = null; }
/*       */          return this.s2CDataBuilder_; }
/*       */       public boolean hasHubLock() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public boolean getHubLock() { return this.hubLock_; }
/*       */       public Builder setHubLock(boolean value) { this.bitField0_ |= 0x4; this.hubLock_ = value; onChanged(); return this; }
/*       */       public Builder clearHubLock() { this.bitField0_ &= 0xFFFFFFFB; this.hubLock_ = false; onChanged(); return this; } } }
/* 12951 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 12956 */     String[] descriptorData = { "\n\022skillHandler.proto\022\013pomelo.area\032\fcommon.proto\"*\n\023UpgradeSkillRequest\022\023\n\013s2c_skillId\030\001 \002(\005\"\033\n\031UpgradeSkillOneKeyRequest\")\n\022UnlockSkillRequest\022\023\n\013s2c_skillId\030\001 \002(\005\",\n\025GetSkillDetailRequest\022\023\n\013s2c_skillId\030\001 \002(\005\"\024\n\022GetAllSkillRequest\"f\n\007ReqItem\022\020\n\bitemCode\030\001 \002(\t\022\017\n\007itemQua\030\002 \002(\005\022\020\n\bitemIcon\030\003 \002(\t\022\022\n\nitemReqNum\030\004 \002(\005\022\022\n\nitemCurNum\030\005 \002(\005\"è\001\n\nSkillBasic\022\r\n\005level\030\001 \002(\005\022\013\n\003pos\030\002 \001(\005\022\r\n\005extlv\030\003 \001(\005\022\f\n\004nam", "e\030\004 \002(\t\022\013\n\003pic\030\005 \002(\t\022\f\n\004type\030\006 \002(\005\022\f\n\004flag\030\007 \002(\005\022\017\n\007skillId\030\b \002(\005\022\020\n\bmaxLevel\030\t \002(\005\022\030\n\020upgradeNeedLevel\030\n \002(\005\022\031\n\021detailNeedRefresh\030\013 \002(\b\022\022\n\ncanUpgrade\030\f \003(\005\022\f\n\004cost\030\r \002(\005\"»\001\n\fTalentDetail\022\017\n\007skillId\030\001 \002(\005\022\r\n\005level\030\002 \002(\005\022\r\n\005extlv\030\003 \001(\005\022\f\n\004name\030\004 \002(\t\022\020\n\bmaxLevel\030\005 \002(\005\022\f\n\004flag\030\006 \002(\005\022\022\n\ncurDesData\030\007 \003(\t\022&\n\breqItems\030\b \003(\0132\024.pomelo.area.ReqItem\022\022\n\ncanUpgrade\030\t \001(\005\"³\001\n\013SkillDetail\022\020\n\bcolddown\030\001 \002(\005\022\023\n\013cu", "rManaCost\030\002 \002(\005\022\022\n\ncurDesData\030\003 \003(\t\022&\n\breqItems\030\004 \003(\0132\024.pomelo.area.ReqItem\022-\n\nTalentList\030\005 \003(\0132\031.pomelo.area.TalentDetail\022\022\n\ncanUpgrade\030\006 \001(\005\"9\n\024UpgradeSkillResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"k\n\032UpgradeSkillOneKeyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\tskillList\030\003 \003(\0132\027.pomelo.area.SkillBasic\"h\n\026GetSkillDetailResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\ts2c_skill\030\003 \001(\0132\030.pomelo.", "area.SkillDetail\"u\n\023GetAllSkillResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\017\n\007hubLock\030\003 \002(\b\022*\n\tskillList\030\004 \003(\0132\027.pomelo.area.SkillBasic\"8\n\023UseSkillTabResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"8\n\023UnlockSkillResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"_\n\017SkillUpdatePush\022\020\n\bs2c_code\030\001 \002(\005\022)\n\bs2c_data\030\002 \003(\0132\027.pomelo.area.SkillBasic\022\017\n\007hubLock\030\003 \002(\b2ì\003\n\fskillHandler\022W\n\022unlockSkillRequest\022\037.pomelo.are", "a.UnlockSkillRequest\032 .pomelo.area.UnlockSkillResponse\022Z\n\023upgradeSkillRequest\022 .pomelo.area.UpgradeSkillRequest\032!.pomelo.area.UpgradeSkillResponse\022l\n\031upgradeSkillOneKeyRequest\022&.pomelo.area.UpgradeSkillOneKeyRequest\032'.pomelo.area.UpgradeSkillOneKeyResponse\022`\n\025getSkillDetailRequest\022\".pomelo.area.GetSkillDetailRequest\032#.pomelo.area.GetSkillDetailResponse\022W\n\022getAllSkillRequest\022\037.pomelo.area.GetAllSki", "llRequest\032 .pomelo.area.GetAllSkillResponse2J\n\tskillPush\022=\n\017skillUpdatePush\022\034.pomelo.area.SkillUpdatePush\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 13011 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 13015 */           SkillHandler.descriptor = root;
/* 13016 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 13020 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 13022 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 13025 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeSkillRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 13026 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeSkillRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeSkillRequest_descriptor, new String[] { "S2CSkillId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13031 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeSkillOneKeyRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 13032 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeSkillOneKeyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeSkillOneKeyRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13037 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnlockSkillRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 13038 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnlockSkillRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnlockSkillRequest_descriptor, new String[] { "S2CSkillId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13043 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetSkillDetailRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 13044 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetSkillDetailRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetSkillDetailRequest_descriptor, new String[] { "S2CSkillId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13049 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllSkillRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 13050 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllSkillRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllSkillRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13055 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ReqItem_descriptor = getDescriptor().getMessageTypes().get(5);
/* 13056 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReqItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReqItem_descriptor, new String[] { "ItemCode", "ItemQua", "ItemIcon", "ItemReqNum", "ItemCurNum" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13061 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkillBasic_descriptor = getDescriptor().getMessageTypes().get(6);
/* 13062 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillBasic_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillBasic_descriptor, new String[] { "Level", "Pos", "Extlv", "Name", "Pic", "Type", "Flag", "SkillId", "MaxLevel", "UpgradeNeedLevel", "DetailNeedRefresh", "CanUpgrade", "Cost" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13067 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TalentDetail_descriptor = getDescriptor().getMessageTypes().get(7);
/* 13068 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TalentDetail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TalentDetail_descriptor, new String[] { "SkillId", "Level", "Extlv", "Name", "MaxLevel", "Flag", "CurDesData", "ReqItems", "CanUpgrade" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13073 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkillDetail_descriptor = getDescriptor().getMessageTypes().get(8);
/* 13074 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillDetail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillDetail_descriptor, new String[] { "Colddown", "CurManaCost", "CurDesData", "ReqItems", "TalentList", "CanUpgrade" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13079 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeSkillResponse_descriptor = getDescriptor().getMessageTypes().get(9);
/* 13080 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeSkillResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeSkillResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13085 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeSkillOneKeyResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 13086 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeSkillOneKeyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeSkillOneKeyResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "SkillList" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13091 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetSkillDetailResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 13092 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetSkillDetailResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetSkillDetailResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CSkill" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13097 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllSkillResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 13098 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllSkillResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllSkillResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "HubLock", "SkillList" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13103 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UseSkillTabResponse_descriptor = getDescriptor().getMessageTypes().get(13);
/* 13104 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UseSkillTabResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UseSkillTabResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13109 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnlockSkillResponse_descriptor = getDescriptor().getMessageTypes().get(14);
/* 13110 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnlockSkillResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnlockSkillResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13115 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkillUpdatePush_descriptor = getDescriptor().getMessageTypes().get(15);
/* 13116 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillUpdatePush_descriptor, new String[] { "S2CCode", "S2CData", "HubLock" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 13120 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface SkillUpdatePushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     List<SkillHandler.SkillBasic> getS2CDataList();
/*       */     
/*       */     SkillHandler.SkillBasic getS2CData(int param1Int);
/*       */     
/*       */     int getS2CDataCount();
/*       */     
/*       */     List<? extends SkillHandler.SkillBasicOrBuilder> getS2CDataOrBuilderList();
/*       */     
/*       */     SkillHandler.SkillBasicOrBuilder getS2CDataOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasHubLock();
/*       */     
/*       */     boolean getHubLock();
/*       */   }
/*       */   
/*       */   public static interface UnlockSkillResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */   }
/*       */   
/*       */   public static interface UseSkillTabResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */   }
/*       */   
/*       */   public static interface GetAllSkillResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */     
/*       */     boolean hasHubLock();
/*       */     
/*       */     boolean getHubLock();
/*       */     
/*       */     List<SkillHandler.SkillBasic> getSkillListList();
/*       */     
/*       */     SkillHandler.SkillBasic getSkillList(int param1Int);
/*       */     
/*       */     int getSkillListCount();
/*       */     
/*       */     List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList();
/*       */     
/*       */     SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface GetSkillDetailResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */     
/*       */     boolean hasS2CSkill();
/*       */     
/*       */     SkillHandler.SkillDetail getS2CSkill();
/*       */     
/*       */     SkillHandler.SkillDetailOrBuilder getS2CSkillOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface UpgradeSkillOneKeyResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */     
/*       */     List<SkillHandler.SkillBasic> getSkillListList();
/*       */     
/*       */     SkillHandler.SkillBasic getSkillList(int param1Int);
/*       */     
/*       */     int getSkillListCount();
/*       */     
/*       */     List<? extends SkillHandler.SkillBasicOrBuilder> getSkillListOrBuilderList();
/*       */     
/*       */     SkillHandler.SkillBasicOrBuilder getSkillListOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface UpgradeSkillResponseOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CMsg();
/*       */     
/*       */     String getS2CMsg();
/*       */     
/*       */     ByteString getS2CMsgBytes();
/*       */   }
/*       */   
/*       */   public static interface SkillDetailOrBuilder extends MessageOrBuilder {
/*       */     boolean hasColddown();
/*       */     
/*       */     int getColddown();
/*       */     
/*       */     boolean hasCurManaCost();
/*       */     
/*       */     int getCurManaCost();
/*       */     
/*       */     ProtocolStringList getCurDesDataList();
/*       */     
/*       */     int getCurDesDataCount();
/*       */     
/*       */     String getCurDesData(int param1Int);
/*       */     
/*       */     ByteString getCurDesDataBytes(int param1Int);
/*       */     
/*       */     List<SkillHandler.ReqItem> getReqItemsList();
/*       */     
/*       */     SkillHandler.ReqItem getReqItems(int param1Int);
/*       */     
/*       */     int getReqItemsCount();
/*       */     
/*       */     List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList();
/*       */     
/*       */     SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int param1Int);
/*       */     
/*       */     List<SkillHandler.TalentDetail> getTalentListList();
/*       */     
/*       */     SkillHandler.TalentDetail getTalentList(int param1Int);
/*       */     
/*       */     int getTalentListCount();
/*       */     
/*       */     List<? extends SkillHandler.TalentDetailOrBuilder> getTalentListOrBuilderList();
/*       */     
/*       */     SkillHandler.TalentDetailOrBuilder getTalentListOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasCanUpgrade();
/*       */     
/*       */     int getCanUpgrade();
/*       */   }
/*       */   
/*       */   public static interface TalentDetailOrBuilder extends MessageOrBuilder {
/*       */     boolean hasSkillId();
/*       */     
/*       */     int getSkillId();
/*       */     
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasExtlv();
/*       */     
/*       */     int getExtlv();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */     
/*       */     boolean hasFlag();
/*       */     
/*       */     int getFlag();
/*       */     
/*       */     ProtocolStringList getCurDesDataList();
/*       */     
/*       */     int getCurDesDataCount();
/*       */     
/*       */     String getCurDesData(int param1Int);
/*       */     
/*       */     ByteString getCurDesDataBytes(int param1Int);
/*       */     
/*       */     List<SkillHandler.ReqItem> getReqItemsList();
/*       */     
/*       */     SkillHandler.ReqItem getReqItems(int param1Int);
/*       */     
/*       */     int getReqItemsCount();
/*       */     
/*       */     List<? extends SkillHandler.ReqItemOrBuilder> getReqItemsOrBuilderList();
/*       */     
/*       */     SkillHandler.ReqItemOrBuilder getReqItemsOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasCanUpgrade();
/*       */     
/*       */     int getCanUpgrade();
/*       */   }
/*       */   
/*       */   public static interface SkillBasicOrBuilder extends MessageOrBuilder {
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasPos();
/*       */     
/*       */     int getPos();
/*       */     
/*       */     boolean hasExtlv();
/*       */     
/*       */     int getExtlv();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasPic();
/*       */     
/*       */     String getPic();
/*       */     
/*       */     ByteString getPicBytes();
/*       */     
/*       */     boolean hasType();
/*       */     
/*       */     int getType();
/*       */     
/*       */     boolean hasFlag();
/*       */     
/*       */     int getFlag();
/*       */     
/*       */     boolean hasSkillId();
/*       */     
/*       */     int getSkillId();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */     
/*       */     boolean hasUpgradeNeedLevel();
/*       */     
/*       */     int getUpgradeNeedLevel();
/*       */     
/*       */     boolean hasDetailNeedRefresh();
/*       */     
/*       */     boolean getDetailNeedRefresh();
/*       */     
/*       */     List<Integer> getCanUpgradeList();
/*       */     
/*       */     int getCanUpgradeCount();
/*       */     
/*       */     int getCanUpgrade(int param1Int);
/*       */     
/*       */     boolean hasCost();
/*       */     
/*       */     int getCost();
/*       */   }
/*       */   
/*       */   public static interface ReqItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasItemCode();
/*       */     
/*       */     String getItemCode();
/*       */     
/*       */     ByteString getItemCodeBytes();
/*       */     
/*       */     boolean hasItemQua();
/*       */     
/*       */     int getItemQua();
/*       */     
/*       */     boolean hasItemIcon();
/*       */     
/*       */     String getItemIcon();
/*       */     
/*       */     ByteString getItemIconBytes();
/*       */     
/*       */     boolean hasItemReqNum();
/*       */     
/*       */     int getItemReqNum();
/*       */     
/*       */     boolean hasItemCurNum();
/*       */     
/*       */     int getItemCurNum();
/*       */   }
/*       */   
/*       */   public static interface GetAllSkillRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface GetSkillDetailRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CSkillId();
/*       */     
/*       */     int getS2CSkillId();
/*       */   }
/*       */   
/*       */   public static interface UnlockSkillRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CSkillId();
/*       */     
/*       */     int getS2CSkillId();
/*       */   }
/*       */   
/*       */   public static interface UpgradeSkillOneKeyRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface UpgradeSkillRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CSkillId();
/*       */     
/*       */     int getS2CSkillId();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\SkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */