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
/*       */ import com.google.protobuf.Message;
/*       */ import com.google.protobuf.MessageLite;
/*       */ import com.google.protobuf.MessageOrBuilder;
/*       */ import com.google.protobuf.Parser;
/*       */ import com.google.protobuf.RepeatedFieldBuilder;
/*       */ import com.google.protobuf.UnknownFieldSet;
/*       */ import java.io.IOException;
/*       */ import java.io.InputStream;
/*       */ import java.io.ObjectStreamException;
/*       */ import java.util.ArrayList;
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
/*       */ public final class FleeHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class FleeInfoRequest
/*       */     extends GeneratedMessage
/*       */     implements FleeInfoRequestOrBuilder
/*       */   {
/*   325 */     private static final FleeInfoRequest defaultInstance = new FleeInfoRequest(true); private final UnknownFieldSet unknownFields; private FleeInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FleeInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FleeInfoRequest getDefaultInstance() { return defaultInstance; } public FleeInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FleeInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeInfoRequest.class, Builder.class); } public static Parser<FleeInfoRequest> PARSER = (Parser<FleeInfoRequest>)new AbstractParser<FleeInfoRequest>() { public FleeHandler.FleeInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.FleeInfoRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FleeInfoRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FleeInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FleeInfoRequest)PARSER.parseFrom(data); } public static FleeInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static FleeInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FleeInfoRequest)PARSER.parseFrom(data); } public static FleeInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static FleeInfoRequest parseFrom(InputStream input) throws IOException { return (FleeInfoRequest)PARSER.parseFrom(input); } public static FleeInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static FleeInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (FleeInfoRequest)PARSER.parseDelimitedFrom(input); } public static FleeInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static FleeInfoRequest parseFrom(CodedInputStream input) throws IOException { return (FleeInfoRequest)PARSER.parseFrom(input); } public static FleeInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(FleeInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.FleeInfoRequestOrBuilder {
/*   326 */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.FleeInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_FleeInfoRequest_descriptor; } public FleeHandler.FleeInfoRequest getDefaultInstanceForType() { return FleeHandler.FleeInfoRequest.getDefaultInstance(); } public FleeHandler.FleeInfoRequest build() { FleeHandler.FleeInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.FleeInfoRequest buildPartial() { FleeHandler.FleeInfoRequest result = new FleeHandler.FleeInfoRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.FleeInfoRequest) return mergeFrom((FleeHandler.FleeInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.FleeInfoRequest other) { if (other == FleeHandler.FleeInfoRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.FleeInfoRequest parsedMessage = null; try { parsedMessage = (FleeHandler.FleeInfoRequest)FleeHandler.FleeInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.FleeInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class GradeReward
/*       */     extends GeneratedMessage
/*       */     implements GradeRewardOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private GradeReward(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private GradeReward(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GradeReward getDefaultInstance() {
/*       */       return defaultInstance;
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public GradeReward getDefaultInstanceForType() {
/*       */       return defaultInstance;
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private GradeReward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       initFields();
/*       */       int mutable_bitField0_ = 0;
/*       */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*       */       try {
/*       */         boolean done = false;
/*       */         while (!done) {
/*       */           int tag = input.readTag();
/*       */           switch (tag) {
/*       */             case 0:
/*       */               done = true;
/*       */               break;
/*       */             case 8:
/*       */               this.bitField0_ |= 0x1;
/*       */               this.gradeId_ = input.readInt32();
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.status_ = input.readInt32();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return FleeHandler.internal_static_pomelo_area_GradeReward_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return FleeHandler.internal_static_pomelo_area_GradeReward_fieldAccessorTable.ensureFieldAccessorsInitialized(GradeReward.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<GradeReward> PARSER = (Parser<GradeReward>)new AbstractParser<GradeReward>()
/*       */       {
/*       */         public FleeHandler.GradeReward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new FleeHandler.GradeReward(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int GRADEID_FIELD_NUMBER = 1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int gradeId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int STATUS_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int status_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Parser<GradeReward> getParserForType() {
/*       */       return PARSER;
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
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGradeId() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGradeId() {
/*       */       return this.gradeId_;
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
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasStatus() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
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
/*       */ 
/*       */ 
/*       */     
/*   888 */     private static final GradeReward defaultInstance = new GradeReward(true); public int getStatus() { return this.status_; } private void initFields() { this.gradeId_ = 0; this.status_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasGradeId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasStatus()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.gradeId_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.status_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.gradeId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.status_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GradeReward parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GradeReward)PARSER.parseFrom(data); } public static GradeReward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GradeReward)PARSER.parseFrom(data, extensionRegistry); } public static GradeReward parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GradeReward)PARSER.parseFrom(data); } public static GradeReward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GradeReward)PARSER.parseFrom(data, extensionRegistry); } public static GradeReward parseFrom(InputStream input) throws IOException { return (GradeReward)PARSER.parseFrom(input); } public static GradeReward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GradeReward)PARSER.parseFrom(input, extensionRegistry); } public static GradeReward parseDelimitedFrom(InputStream input) throws IOException { return (GradeReward)PARSER.parseDelimitedFrom(input); } public static GradeReward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GradeReward)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GradeReward parseFrom(CodedInputStream input) throws IOException { return (GradeReward)PARSER.parseFrom(input); } public static GradeReward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GradeReward)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GradeReward prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.GradeRewardOrBuilder {
/*   889 */       private int bitField0_; private int gradeId_; private int status_; public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_GradeReward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_GradeReward_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.GradeReward.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.GradeReward.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.gradeId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.status_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_GradeReward_descriptor; } public FleeHandler.GradeReward getDefaultInstanceForType() { return FleeHandler.GradeReward.getDefaultInstance(); } public FleeHandler.GradeReward build() { FleeHandler.GradeReward result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.GradeReward buildPartial() { FleeHandler.GradeReward result = new FleeHandler.GradeReward(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.gradeId_ = this.gradeId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.status_ = this.status_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.GradeReward) return mergeFrom((FleeHandler.GradeReward)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.GradeReward other) { if (other == FleeHandler.GradeReward.getDefaultInstance()) return this;  if (other.hasGradeId()) setGradeId(other.getGradeId());  if (other.hasStatus()) setStatus(other.getStatus());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasGradeId()) return false;  if (!hasStatus()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.GradeReward parsedMessage = null; try { parsedMessage = (FleeHandler.GradeReward)FleeHandler.GradeReward.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.GradeReward)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasGradeId() { return ((this.bitField0_ & 0x1) == 1); } public int getGradeId() { return this.gradeId_; } public Builder setGradeId(int value) { this.bitField0_ |= 0x1; this.gradeId_ = value; onChanged(); return this; } public Builder clearGradeId() { this.bitField0_ &= 0xFFFFFFFE; this.gradeId_ = 0; onChanged(); return this; } public boolean hasStatus() { return ((this.bitField0_ & 0x2) == 2); } public int getStatus() { return this.status_; } public Builder setStatus(int value) { this.bitField0_ |= 0x2; this.status_ = value; onChanged(); return this; } public Builder clearStatus() { this.bitField0_ &= 0xFFFFFFFD; this.status_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class FleeInfoResponse
/*       */     extends GeneratedMessage
/*       */     implements FleeInfoResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private FleeInfoResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private FleeInfoResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static FleeInfoResponse getDefaultInstance() {
/*       */       return defaultInstance;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public FleeInfoResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private FleeInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */             case 24:
/*       */               this.bitField0_ |= 0x4;
/*       */               this.currentRank_ = input.readInt32();
/*       */               break;
/*       */             case 32:
/*       */               this.bitField0_ |= 0x8;
/*       */               this.maxRank_ = input.readInt32();
/*       */               break;
/*       */             case 40:
/*       */               this.bitField0_ |= 0x10;
/*       */               this.grade_ = input.readInt32();
/*       */               break;
/*       */             case 48:
/*       */               this.bitField0_ |= 0x20;
/*       */               this.maxGrade_ = input.readInt32();
/*       */               break;
/*       */             case 56:
/*       */               this.bitField0_ |= 0x40;
/*       */               this.seasonEndTime_ = input.readInt64();
/*       */               break;
/*       */             case 64:
/*       */               this.bitField0_ |= 0x80;
/*       */               this.score_ = input.readInt32();
/*       */               break;
/*       */             case 74:
/*       */               if ((mutable_bitField0_ & 0x100) != 256) {
/*       */                 this.gradeRewards_ = new ArrayList<>();
/*       */                 mutable_bitField0_ |= 0x100;
/*       */               } 
/*       */               this.gradeRewards_.add(input.readMessage(FleeHandler.GradeReward.PARSER, extensionRegistry));
/*       */               break;
/*       */             case 80:
/*       */               this.bitField0_ |= 0x100;
/*       */               this.joinTime_ = input.readInt32();
/*       */               break;
/*       */             case 88:
/*       */               this.bitField0_ |= 0x200;
/*       */               this.avgMatchTime_ = input.readInt32();
/*       */               break;
/*       */           } 
/*       */         } 
/*       */       } catch (InvalidProtocolBufferException e) {
/*       */         throw e.setUnfinishedMessage(this);
/*       */       } catch (IOException e) {
/*       */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*       */       } finally {
/*       */         if ((mutable_bitField0_ & 0x100) == 256) {
/*       */           this.gradeRewards_ = Collections.unmodifiableList(this.gradeRewards_);
/*       */         }
/*       */         this.unknownFields = unknownFields.build();
/*       */         makeExtensionsImmutable();
/*       */       } 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return FleeHandler.internal_static_pomelo_area_FleeInfoResponse_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return FleeHandler.internal_static_pomelo_area_FleeInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeInfoResponse.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<FleeInfoResponse> PARSER = (Parser<FleeInfoResponse>)new AbstractParser<FleeInfoResponse>()
/*       */       {
/*       */         public FleeHandler.FleeInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new FleeHandler.FleeInfoResponse(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int CURRENTRANK_FIELD_NUMBER = 3;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int currentRank_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int MAXRANK_FIELD_NUMBER = 4;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int maxRank_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int GRADE_FIELD_NUMBER = 5;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int grade_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int MAXGRADE_FIELD_NUMBER = 6;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int maxGrade_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int SEASONENDTIME_FIELD_NUMBER = 7;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private long seasonEndTime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int SCORE_FIELD_NUMBER = 8;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int score_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int GRADEREWARDS_FIELD_NUMBER = 9;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private List<FleeHandler.GradeReward> gradeRewards_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int JOINTIME_FIELD_NUMBER = 10;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int joinTime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int AVGMATCHTIME_FIELD_NUMBER = 11;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int avgMatchTime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Parser<FleeInfoResponse> getParserForType() {
/*       */       return PARSER;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  2790 */     private static final FleeInfoResponse defaultInstance = new FleeInfoResponse(true); public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasCurrentRank() { return ((this.bitField0_ & 0x4) == 4); } public int getCurrentRank() { return this.currentRank_; } public boolean hasMaxRank() { return ((this.bitField0_ & 0x8) == 8); } public int getMaxRank() { return this.maxRank_; } public boolean hasGrade() { return ((this.bitField0_ & 0x10) == 16); } public int getGrade() { return this.grade_; } public boolean hasMaxGrade() { return ((this.bitField0_ & 0x20) == 32); } public int getMaxGrade() { return this.maxGrade_; } public boolean hasSeasonEndTime() { return ((this.bitField0_ & 0x40) == 64); } public long getSeasonEndTime() { return this.seasonEndTime_; } public boolean hasScore() { return ((this.bitField0_ & 0x80) == 128); } public int getScore() { return this.score_; } public List<FleeHandler.GradeReward> getGradeRewardsList() { return this.gradeRewards_; } public List<? extends FleeHandler.GradeRewardOrBuilder> getGradeRewardsOrBuilderList() { return (List)this.gradeRewards_; } public int getGradeRewardsCount() { return this.gradeRewards_.size(); } public FleeHandler.GradeReward getGradeRewards(int index) { return this.gradeRewards_.get(index); } public FleeHandler.GradeRewardOrBuilder getGradeRewardsOrBuilder(int index) { return this.gradeRewards_.get(index); } public boolean hasJoinTime() { return ((this.bitField0_ & 0x100) == 256); } public int getJoinTime() { return this.joinTime_; } public boolean hasAvgMatchTime() { return ((this.bitField0_ & 0x200) == 512); } public int getAvgMatchTime() { return this.avgMatchTime_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.currentRank_ = 0; this.maxRank_ = 0; this.grade_ = 0; this.maxGrade_ = 0; this.seasonEndTime_ = 0L; this.score_ = 0; this.gradeRewards_ = Collections.emptyList(); this.joinTime_ = 0; this.avgMatchTime_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getGradeRewardsCount(); i++) { if (!getGradeRewards(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.currentRank_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.maxRank_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.grade_);  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.maxGrade_);  if ((this.bitField0_ & 0x40) == 64) output.writeInt64(7, this.seasonEndTime_);  if ((this.bitField0_ & 0x80) == 128) output.writeInt32(8, this.score_);  for (int i = 0; i < this.gradeRewards_.size(); i++) output.writeMessage(9, (MessageLite)this.gradeRewards_.get(i));  if ((this.bitField0_ & 0x100) == 256) output.writeInt32(10, this.joinTime_);  if ((this.bitField0_ & 0x200) == 512) output.writeInt32(11, this.avgMatchTime_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.currentRank_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.maxRank_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.grade_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.maxGrade_);  if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt64Size(7, this.seasonEndTime_);  if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeInt32Size(8, this.score_);  for (int i = 0; i < this.gradeRewards_.size(); i++) size += CodedOutputStream.computeMessageSize(9, (MessageLite)this.gradeRewards_.get(i));  if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeInt32Size(10, this.joinTime_);  if ((this.bitField0_ & 0x200) == 512) size += CodedOutputStream.computeInt32Size(11, this.avgMatchTime_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FleeInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FleeInfoResponse)PARSER.parseFrom(data); } public static FleeInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeInfoResponse)PARSER.parseFrom(data, extensionRegistry); } public static FleeInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FleeInfoResponse)PARSER.parseFrom(data); } public static FleeInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeInfoResponse)PARSER.parseFrom(data, extensionRegistry); } public static FleeInfoResponse parseFrom(InputStream input) throws IOException { return (FleeInfoResponse)PARSER.parseFrom(input); } public static FleeInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*  2791 */     static { defaultInstance.initFields(); } public static FleeInfoResponse parseDelimitedFrom(InputStream input) throws IOException { return (FleeInfoResponse)PARSER.parseDelimitedFrom(input); } public static FleeInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static FleeInfoResponse parseFrom(CodedInputStream input) throws IOException { return (FleeInfoResponse)PARSER.parseFrom(input); } public static FleeInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeInfoResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(FleeInfoResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.FleeInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int currentRank_; private int maxRank_; private int grade_; private int maxGrade_; private long seasonEndTime_; private int score_; private List<FleeHandler.GradeReward> gradeRewards_; private RepeatedFieldBuilder<FleeHandler.GradeReward, FleeHandler.GradeReward.Builder, FleeHandler.GradeRewardOrBuilder> gradeRewardsBuilder_; private int joinTime_; private int avgMatchTime_; public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeInfoResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = "";
/*       */         this.gradeRewards_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.gradeRewards_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.FleeInfoResponse.alwaysUseFieldBuilders)
/*       */           getGradeRewardsFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.currentRank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.maxRank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.grade_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.maxGrade_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.seasonEndTime_ = 0L;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.score_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           this.gradeRewards_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.clear();
/*       */         } 
/*       */         this.joinTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.avgMatchTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_FleeInfoResponse_descriptor; } public FleeHandler.FleeInfoResponse getDefaultInstanceForType() { return FleeHandler.FleeInfoResponse.getDefaultInstance(); } public FleeHandler.FleeInfoResponse build() { FleeHandler.FleeInfoResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; } public FleeHandler.FleeInfoResponse buildPartial() { FleeHandler.FleeInfoResponse result = new FleeHandler.FleeInfoResponse(this);
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
/*       */         result.currentRank_ = this.currentRank_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.maxRank_ = this.maxRank_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.grade_ = this.grade_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.maxGrade_ = this.maxGrade_;
/*       */         if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40; 
/*       */         result.seasonEndTime_ = this.seasonEndTime_;
/*       */         if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x80; 
/*       */         result.score_ = this.score_;
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x100) == 256) {
/*       */             this.gradeRewards_ = Collections.unmodifiableList(this.gradeRewards_);
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */           } 
/*       */           result.gradeRewards_ = this.gradeRewards_;
/*       */         } else {
/*       */           result.gradeRewards_ = this.gradeRewardsBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x200) == 512)
/*       */           to_bitField0_ |= 0x100; 
/*       */         result.joinTime_ = this.joinTime_;
/*       */         if ((from_bitField0_ & 0x400) == 1024)
/*       */           to_bitField0_ |= 0x200; 
/*       */         result.avgMatchTime_ = this.avgMatchTime_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.FleeInfoResponse)
/*       */           return mergeFrom((FleeHandler.FleeInfoResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; } public Builder mergeFrom(FleeHandler.FleeInfoResponse other) { if (other == FleeHandler.FleeInfoResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCurrentRank())
/*       */           setCurrentRank(other.getCurrentRank()); 
/*       */         if (other.hasMaxRank())
/*       */           setMaxRank(other.getMaxRank()); 
/*       */         if (other.hasGrade())
/*       */           setGrade(other.getGrade()); 
/*       */         if (other.hasMaxGrade())
/*       */           setMaxGrade(other.getMaxGrade()); 
/*       */         if (other.hasSeasonEndTime())
/*       */           setSeasonEndTime(other.getSeasonEndTime()); 
/*       */         if (other.hasScore())
/*       */           setScore(other.getScore()); 
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           if (!other.gradeRewards_.isEmpty()) {
/*       */             if (this.gradeRewards_.isEmpty()) {
/*       */               this.gradeRewards_ = other.gradeRewards_;
/*       */               this.bitField0_ &= 0xFFFFFEFF;
/*       */             } else {
/*       */               ensureGradeRewardsIsMutable();
/*       */               this.gradeRewards_.addAll(other.gradeRewards_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.gradeRewards_.isEmpty()) {
/*       */           if (this.gradeRewardsBuilder_.isEmpty()) {
/*       */             this.gradeRewardsBuilder_.dispose();
/*       */             this.gradeRewardsBuilder_ = null;
/*       */             this.gradeRewards_ = other.gradeRewards_;
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */             this.gradeRewardsBuilder_ = FleeHandler.FleeInfoResponse.alwaysUseFieldBuilders ? getGradeRewardsFieldBuilder() : null;
/*       */           } else {
/*       */             this.gradeRewardsBuilder_.addAllMessages(other.gradeRewards_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasJoinTime())
/*       */           setJoinTime(other.getJoinTime()); 
/*       */         if (other.hasAvgMatchTime())
/*       */           setAvgMatchTime(other.getAvgMatchTime()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; } public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getGradeRewardsCount(); i++) {
/*       */           if (!getGradeRewards(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.FleeInfoResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.FleeInfoResponse)FleeHandler.FleeInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.FleeInfoResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = FleeHandler.FleeInfoResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; } public boolean hasCurrentRank() { return ((this.bitField0_ & 0x4) == 4); } public int getCurrentRank() { return this.currentRank_; } public Builder setCurrentRank(int value) { this.bitField0_ |= 0x4;
/*       */         this.currentRank_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearCurrentRank() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.currentRank_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasMaxRank() { return ((this.bitField0_ & 0x8) == 8); } public int getMaxRank() { return this.maxRank_; }
/*       */       public Builder setMaxRank(int value) { this.bitField0_ |= 0x8;
/*       */         this.maxRank_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearMaxRank() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.maxRank_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasGrade() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public int getGrade() { return this.grade_; }
/*       */       public Builder setGrade(int value) { this.bitField0_ |= 0x10;
/*       */         this.grade_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearGrade() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.grade_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxGrade() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       public int getMaxGrade() {
/*       */         return this.maxGrade_;
/*       */       }
/*       */       public Builder setMaxGrade(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.maxGrade_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxGrade() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.maxGrade_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasSeasonEndTime() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */       public long getSeasonEndTime() {
/*       */         return this.seasonEndTime_;
/*       */       }
/*       */       public Builder setSeasonEndTime(long value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.seasonEndTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearSeasonEndTime() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.seasonEndTime_ = 0L;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasScore() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */       public int getScore() {
/*       */         return this.score_;
/*       */       }
/*       */       public Builder setScore(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.score_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearScore() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.score_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       private void ensureGradeRewardsIsMutable() {
/*       */         if ((this.bitField0_ & 0x100) != 256) {
/*       */           this.gradeRewards_ = new ArrayList<>(this.gradeRewards_);
/*       */           this.bitField0_ |= 0x100;
/*       */         } 
/*       */       }
/*       */       public List<FleeHandler.GradeReward> getGradeRewardsList() {
/*       */         if (this.gradeRewardsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.gradeRewards_); 
/*       */         return this.gradeRewardsBuilder_.getMessageList();
/*       */       }
/*       */       public int getGradeRewardsCount() {
/*       */         if (this.gradeRewardsBuilder_ == null)
/*       */           return this.gradeRewards_.size(); 
/*       */         return this.gradeRewardsBuilder_.getCount();
/*       */       }
/*       */       public FleeHandler.GradeReward getGradeRewards(int index) {
/*       */         if (this.gradeRewardsBuilder_ == null)
/*       */           return this.gradeRewards_.get(index); 
/*       */         return (FleeHandler.GradeReward)this.gradeRewardsBuilder_.getMessage(index);
/*       */       }
/*       */       public Builder setGradeRewards(int index, FleeHandler.GradeReward value) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder setGradeRewards(int index, FleeHandler.GradeReward.Builder builderForValue) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addGradeRewards(FleeHandler.GradeReward value) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addGradeRewards(int index, FleeHandler.GradeReward value) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addGradeRewards(FleeHandler.GradeReward.Builder builderForValue) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addGradeRewards(int index, FleeHandler.GradeReward.Builder builderForValue) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAllGradeRewards(Iterable<? extends FleeHandler.GradeReward> values) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           ensureGradeRewardsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.gradeRewards_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearGradeRewards() {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           this.gradeRewards_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeGradeRewards(int index) {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           ensureGradeRewardsIsMutable();
/*       */           this.gradeRewards_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gradeRewardsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public FleeHandler.GradeReward.Builder getGradeRewardsBuilder(int index) {
/*       */         return (FleeHandler.GradeReward.Builder)getGradeRewardsFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public FleeHandler.GradeRewardOrBuilder getGradeRewardsOrBuilder(int index) {
/*       */         if (this.gradeRewardsBuilder_ == null)
/*       */           return this.gradeRewards_.get(index); 
/*       */         return (FleeHandler.GradeRewardOrBuilder)this.gradeRewardsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends FleeHandler.GradeRewardOrBuilder> getGradeRewardsOrBuilderList() {
/*       */         if (this.gradeRewardsBuilder_ != null)
/*       */           return this.gradeRewardsBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.gradeRewards_);
/*       */       }
/*       */       public FleeHandler.GradeReward.Builder addGradeRewardsBuilder() {
/*       */         return (FleeHandler.GradeReward.Builder)getGradeRewardsFieldBuilder().addBuilder(FleeHandler.GradeReward.getDefaultInstance());
/*       */       }
/*       */       public FleeHandler.GradeReward.Builder addGradeRewardsBuilder(int index) {
/*       */         return (FleeHandler.GradeReward.Builder)getGradeRewardsFieldBuilder().addBuilder(index, FleeHandler.GradeReward.getDefaultInstance());
/*       */       }
/*       */       public List<FleeHandler.GradeReward.Builder> getGradeRewardsBuilderList() {
/*       */         return getGradeRewardsFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<FleeHandler.GradeReward, FleeHandler.GradeReward.Builder, FleeHandler.GradeRewardOrBuilder> getGradeRewardsFieldBuilder() {
/*       */         if (this.gradeRewardsBuilder_ == null) {
/*       */           this.gradeRewardsBuilder_ = new RepeatedFieldBuilder(this.gradeRewards_, ((this.bitField0_ & 0x100) == 256), getParentForChildren(), isClean());
/*       */           this.gradeRewards_ = null;
/*       */         } 
/*       */         return this.gradeRewardsBuilder_;
/*       */       }
/*       */       public boolean hasJoinTime() {
/*       */         return ((this.bitField0_ & 0x200) == 512);
/*       */       }
/*       */       public int getJoinTime() {
/*       */         return this.joinTime_;
/*       */       }
/*       */       public Builder setJoinTime(int value) {
/*       */         this.bitField0_ |= 0x200;
/*       */         this.joinTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearJoinTime() {
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.joinTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasAvgMatchTime() {
/*       */         return ((this.bitField0_ & 0x400) == 1024);
/*       */       }
/*       */       public int getAvgMatchTime() {
/*       */         return this.avgMatchTime_;
/*       */       }
/*       */       public Builder setAvgMatchTime(int value) {
/*       */         this.bitField0_ |= 0x400;
/*       */         this.avgMatchTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearAvgMatchTime() {
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.avgMatchTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  3235 */   public static final class GetRewardRequest extends GeneratedMessage implements GetRewardRequestOrBuilder { private static final GetRewardRequest defaultInstance = new GetRewardRequest(true); private final UnknownFieldSet unknownFields; private GetRewardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRewardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRewardRequest getDefaultInstance() { return defaultInstance; } public GetRewardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.gradeId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_GetRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_GetRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRewardRequest.class, Builder.class); } public static Parser<GetRewardRequest> PARSER = (Parser<GetRewardRequest>)new AbstractParser<GetRewardRequest>() { public FleeHandler.GetRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.GetRewardRequest(input, extensionRegistry); } }
/*  3236 */     ; private int bitField0_; public static final int GRADEID_FIELD_NUMBER = 1; private int gradeId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRewardRequest> getParserForType() { return PARSER; } public boolean hasGradeId() { return ((this.bitField0_ & 0x1) == 1); } public int getGradeId() { return this.gradeId_; } private void initFields() { this.gradeId_ = 0; } static { defaultInstance.initFields(); }
/*       */ 
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
/*       */       if (!hasGradeId()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.gradeId_);
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.gradeId_);
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
/*       */     public static GetRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(data);
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
/*       */     public static GetRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static GetRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(data);
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
/*       */     public static GetRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static GetRewardRequest parseFrom(InputStream input) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(input);
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
/*       */     public static GetRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static GetRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseDelimitedFrom(input);
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
/*       */     public static GetRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static GetRewardRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(input);
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
/*       */     public static GetRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(GetRewardRequest prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements FleeHandler.GetRewardRequestOrBuilder
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
/*       */       private int gradeId_;
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
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardRequest_descriptor;
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
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.GetRewardRequest.class, Builder.class);
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
/*       */       private Builder() {
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (FleeHandler.GetRewardRequest.alwaysUseFieldBuilders);
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.gradeId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FleeHandler.GetRewardRequest getDefaultInstanceForType() {
/*       */         return FleeHandler.GetRewardRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public FleeHandler.GetRewardRequest build() {
/*       */         FleeHandler.GetRewardRequest result = buildPartial();
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
/*       */       public FleeHandler.GetRewardRequest buildPartial() {
/*       */         FleeHandler.GetRewardRequest result = new FleeHandler.GetRewardRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.gradeId_ = this.gradeId_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.GetRewardRequest) {
/*       */           return mergeFrom((FleeHandler.GetRewardRequest)other);
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
/*       */       public Builder mergeFrom(FleeHandler.GetRewardRequest other) {
/*       */         if (other == FleeHandler.GetRewardRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasGradeId()) {
/*       */           setGradeId(other.getGradeId());
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasGradeId()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.GetRewardRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.GetRewardRequest)FleeHandler.GetRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.GetRewardRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasGradeId() {
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
/*       */       public int getGradeId() {
/*       */         return this.gradeId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGradeId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.gradeId_ = value;
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
/*       */       public Builder clearGradeId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.gradeId_ = 0;
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
/*       */   public static final class GetRewardResponse
/*       */     extends GeneratedMessage
/*       */     implements GetRewardResponseOrBuilder
/*       */   {
/*  3805 */     private static final GetRewardResponse defaultInstance = new GetRewardResponse(true); private final UnknownFieldSet unknownFields; private GetRewardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRewardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRewardResponse getDefaultInstance() { return defaultInstance; } public GetRewardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_GetRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_GetRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRewardResponse.class, Builder.class); } public static Parser<GetRewardResponse> PARSER = (Parser<GetRewardResponse>)new AbstractParser<GetRewardResponse>() { public FleeHandler.GetRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.GetRewardResponse(input, extensionRegistry); } }
/*  3806 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRewardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
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
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
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
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(InputStream input) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static GetRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetRewardResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(GetRewardResponse prototype) {
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
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.GetRewardResponseOrBuilder { private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.GetRewardResponse.class, Builder.class);
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
/*       */         if (FleeHandler.GetRewardResponse.alwaysUseFieldBuilders);
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
/*       */         return FleeHandler.internal_static_pomelo_area_GetRewardResponse_descriptor;
/*       */       }
/*       */       
/*       */       public FleeHandler.GetRewardResponse getDefaultInstanceForType() {
/*       */         return FleeHandler.GetRewardResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public FleeHandler.GetRewardResponse build() {
/*       */         FleeHandler.GetRewardResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public FleeHandler.GetRewardResponse buildPartial() {
/*       */         FleeHandler.GetRewardResponse result = new FleeHandler.GetRewardResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.GetRewardResponse)
/*       */           return mergeFrom((FleeHandler.GetRewardResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(FleeHandler.GetRewardResponse other) {
/*       */         if (other == FleeHandler.GetRewardResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
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
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.GetRewardResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.GetRewardResponse)FleeHandler.GetRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.GetRewardResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = FleeHandler.GetRewardResponse.getDefaultInstance().getS2CMsg();
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
/*       */       } }
/*       */   }
/*       */   
/*  4126 */   public static final class FleeLookBtlReportRequest extends GeneratedMessage implements FleeLookBtlReportRequestOrBuilder { private static final FleeLookBtlReportRequest defaultInstance = new FleeLookBtlReportRequest(true); private final UnknownFieldSet unknownFields; private FleeLookBtlReportRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FleeLookBtlReportRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FleeLookBtlReportRequest getDefaultInstance() { return defaultInstance; } public FleeLookBtlReportRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FleeLookBtlReportRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeLookBtlReportRequest.class, Builder.class); } public static Parser<FleeLookBtlReportRequest> PARSER = (Parser<FleeLookBtlReportRequest>)new AbstractParser<FleeLookBtlReportRequest>() { public FleeHandler.FleeLookBtlReportRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.FleeLookBtlReportRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FleeLookBtlReportRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FleeLookBtlReportRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FleeLookBtlReportRequest)PARSER.parseFrom(data); } public static FleeLookBtlReportRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeLookBtlReportRequest)PARSER.parseFrom(data, extensionRegistry); } public static FleeLookBtlReportRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FleeLookBtlReportRequest)PARSER.parseFrom(data); } public static FleeLookBtlReportRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeLookBtlReportRequest)PARSER.parseFrom(data, extensionRegistry); } public static FleeLookBtlReportRequest parseFrom(InputStream input) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseFrom(input); } public static FleeLookBtlReportRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseFrom(input, extensionRegistry); } public static FleeLookBtlReportRequest parseDelimitedFrom(InputStream input) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseDelimitedFrom(input); } public static FleeLookBtlReportRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static FleeLookBtlReportRequest parseFrom(CodedInputStream input) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseFrom(input); } public static FleeLookBtlReportRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(FleeLookBtlReportRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.FleeLookBtlReportRequestOrBuilder {
/*  4127 */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeLookBtlReportRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.FleeLookBtlReportRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportRequest_descriptor; } public FleeHandler.FleeLookBtlReportRequest getDefaultInstanceForType() { return FleeHandler.FleeLookBtlReportRequest.getDefaultInstance(); } public FleeHandler.FleeLookBtlReportRequest build() { FleeHandler.FleeLookBtlReportRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.FleeLookBtlReportRequest buildPartial() { FleeHandler.FleeLookBtlReportRequest result = new FleeHandler.FleeLookBtlReportRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.FleeLookBtlReportRequest) return mergeFrom((FleeHandler.FleeLookBtlReportRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.FleeLookBtlReportRequest other) { if (other == FleeHandler.FleeLookBtlReportRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.FleeLookBtlReportRequest parsedMessage = null; try { parsedMessage = (FleeHandler.FleeLookBtlReportRequest)FleeHandler.FleeLookBtlReportRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.FleeLookBtlReportRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*       */      }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class FleeBtlReport
/*       */     extends GeneratedMessage
/*       */     implements FleeBtlReportOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private FleeBtlReport(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
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
/*       */     private FleeBtlReport(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
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
/*       */     public static FleeBtlReport getDefaultInstance() {
/*       */       return defaultInstance;
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
/*       */     public FleeBtlReport getDefaultInstanceForType() {
/*       */       return defaultInstance;
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
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
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
/*       */     private FleeBtlReport(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */               this.rank_ = input.readInt32();
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.scoreChange_ = input.readInt32();
/*       */               break;
/*       */             case 26:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x4;
/*       */               this.createTime_ = bs;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return FleeHandler.internal_static_pomelo_area_FleeBtlReport_descriptor;
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
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return FleeHandler.internal_static_pomelo_area_FleeBtlReport_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeBtlReport.class, Builder.class);
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
/*       */     public static Parser<FleeBtlReport> PARSER = (Parser<FleeBtlReport>)new AbstractParser<FleeBtlReport>()
/*       */       {
/*       */         public FleeHandler.FleeBtlReport parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new FleeHandler.FleeBtlReport(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int RANK_FIELD_NUMBER = 1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int rank_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int SCORECHANGE_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int scoreChange_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int CREATETIME_FIELD_NUMBER = 3;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object createTime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Parser<FleeBtlReport> getParserForType() {
/*       */       return PARSER;
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
/*       */     public boolean hasRank() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
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
/*       */     public int getRank() {
/*       */       return this.rank_;
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
/*       */     public boolean hasScoreChange() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
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
/*       */     public int getScoreChange() {
/*       */       return this.scoreChange_;
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
/*       */     public boolean hasCreateTime() {
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
/*       */     public String getCreateTime() {
/*       */       Object ref = this.createTime_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.createTime_ = s;
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
/*       */     public ByteString getCreateTimeBytes() {
/*       */       Object ref = this.createTime_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.createTime_ = b;
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
/*       */     private void initFields() {
/*       */       this.rank_ = 0;
/*       */       this.scoreChange_ = 0;
/*       */       this.createTime_ = "";
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
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.rank_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.scoreChange_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getCreateTimeBytes());
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.rank_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.scoreChange_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getCreateTimeBytes());
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
/*       */     public static FleeBtlReport parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (FleeBtlReport)PARSER.parseFrom(data);
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
/*       */     public static FleeBtlReport parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (FleeBtlReport)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static FleeBtlReport parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (FleeBtlReport)PARSER.parseFrom(data);
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
/*       */     public static FleeBtlReport parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (FleeBtlReport)PARSER.parseFrom(data, extensionRegistry);
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
/*  4878 */     private static final FleeBtlReport defaultInstance = new FleeBtlReport(true); public static FleeBtlReport parseFrom(InputStream input) throws IOException { return (FleeBtlReport)PARSER.parseFrom(input); } public static FleeBtlReport parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeBtlReport)PARSER.parseFrom(input, extensionRegistry); } public static FleeBtlReport parseDelimitedFrom(InputStream input) throws IOException { return (FleeBtlReport)PARSER.parseDelimitedFrom(input); } public static FleeBtlReport parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeBtlReport)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static FleeBtlReport parseFrom(CodedInputStream input) throws IOException { return (FleeBtlReport)PARSER.parseFrom(input); } public static FleeBtlReport parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeBtlReport)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(FleeBtlReport prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.FleeBtlReportOrBuilder {
/*  4879 */       private int bitField0_; private int rank_; private int scoreChange_; private Object createTime_; public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeBtlReport_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeBtlReport_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeBtlReport.class, Builder.class); } private Builder() { this.createTime_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.createTime_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.FleeBtlReport.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.rank_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.scoreChange_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.createTime_ = ""; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_FleeBtlReport_descriptor; } public FleeHandler.FleeBtlReport getDefaultInstanceForType() { return FleeHandler.FleeBtlReport.getDefaultInstance(); } public FleeHandler.FleeBtlReport build() { FleeHandler.FleeBtlReport result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.FleeBtlReport buildPartial() { FleeHandler.FleeBtlReport result = new FleeHandler.FleeBtlReport(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.rank_ = this.rank_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.scoreChange_ = this.scoreChange_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.createTime_ = this.createTime_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.FleeBtlReport) return mergeFrom((FleeHandler.FleeBtlReport)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.FleeBtlReport other) { if (other == FleeHandler.FleeBtlReport.getDefaultInstance()) return this;  if (other.hasRank()) setRank(other.getRank());  if (other.hasScoreChange()) setScoreChange(other.getScoreChange());  if (other.hasCreateTime()) { this.bitField0_ |= 0x4; this.createTime_ = other.createTime_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.FleeBtlReport parsedMessage = null; try { parsedMessage = (FleeHandler.FleeBtlReport)FleeHandler.FleeBtlReport.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.FleeBtlReport)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasRank() { return ((this.bitField0_ & 0x1) == 1); } public int getRank() { return this.rank_; } public Builder setRank(int value) { this.bitField0_ |= 0x1; this.rank_ = value; onChanged(); return this; } public Builder clearRank() { this.bitField0_ &= 0xFFFFFFFE; this.rank_ = 0; onChanged(); return this; } public boolean hasScoreChange() { return ((this.bitField0_ & 0x2) == 2); } public int getScoreChange() { return this.scoreChange_; } public Builder setScoreChange(int value) { this.bitField0_ |= 0x2; this.scoreChange_ = value; onChanged(); return this; } public Builder clearScoreChange() { this.bitField0_ &= 0xFFFFFFFD; this.scoreChange_ = 0; onChanged(); return this; } public boolean hasCreateTime() { return ((this.bitField0_ & 0x4) == 4); } public String getCreateTime() { Object ref = this.createTime_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.createTime_ = s;  return s; }  return (String)ref; } public ByteString getCreateTimeBytes() { Object ref = this.createTime_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.createTime_ = b; return b; }  return (ByteString)ref; } public Builder setCreateTime(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.createTime_ = value; onChanged(); return this; } public Builder clearCreateTime() { this.bitField0_ &= 0xFFFFFFFB; this.createTime_ = FleeHandler.FleeBtlReport.getDefaultInstance().getCreateTime(); onChanged(); return this; } public Builder setCreateTimeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.createTime_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class FleeLookBtlReportResponse
/*       */     extends GeneratedMessage
/*       */     implements FleeLookBtlReportResponseOrBuilder
/*       */   {
/*  5920 */     private static final FleeLookBtlReportResponse defaultInstance = new FleeLookBtlReportResponse(true); private final UnknownFieldSet unknownFields; private FleeLookBtlReportResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FleeLookBtlReportResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FleeLookBtlReportResponse getDefaultInstance() { return defaultInstance; } public FleeLookBtlReportResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FleeLookBtlReportResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.br_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.br_.add(input.readMessage(FleeHandler.FleeBtlReport.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.br_ = Collections.unmodifiableList(this.br_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeLookBtlReportResponse.class, Builder.class); } public static Parser<FleeLookBtlReportResponse> PARSER = (Parser<FleeLookBtlReportResponse>)new AbstractParser<FleeLookBtlReportResponse>() { public FleeHandler.FleeLookBtlReportResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.FleeLookBtlReportResponse(input, extensionRegistry); } }
/*  5921 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int BR_FIELD_NUMBER = 3; private List<FleeHandler.FleeBtlReport> br_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FleeLookBtlReportResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public List<FleeHandler.FleeBtlReport> getBrList() { return this.br_; } public List<? extends FleeHandler.FleeBtlReportOrBuilder> getBrOrBuilderList() { return (List)this.br_; } public int getBrCount() { return this.br_.size(); } public FleeHandler.FleeBtlReport getBr(int index) { return this.br_.get(index); } public FleeHandler.FleeBtlReportOrBuilder getBrOrBuilder(int index) { return this.br_.get(index); } private void initFields() { this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.br_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.br_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.br_.get(i)); 
/*       */       getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.br_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.br_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FleeLookBtlReportResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FleeLookBtlReportResponse)PARSER.parseFrom(data); }
/*       */     public static FleeLookBtlReportResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeLookBtlReportResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static FleeLookBtlReportResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FleeLookBtlReportResponse)PARSER.parseFrom(data); }
/*       */     public static FleeLookBtlReportResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FleeLookBtlReportResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static FleeLookBtlReportResponse parseFrom(InputStream input) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseFrom(input); }
/*       */     public static FleeLookBtlReportResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static FleeLookBtlReportResponse parseDelimitedFrom(InputStream input) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static FleeLookBtlReportResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static FleeLookBtlReportResponse parseFrom(CodedInputStream input) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseFrom(input); }
/*       */     public static FleeLookBtlReportResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FleeLookBtlReportResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(FleeLookBtlReportResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.FleeLookBtlReportResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<FleeHandler.FleeBtlReport> br_; private RepeatedFieldBuilder<FleeHandler.FleeBtlReport, FleeHandler.FleeBtlReport.Builder, FleeHandler.FleeBtlReportOrBuilder> brBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeLookBtlReportResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = "";
/*       */         this.br_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.br_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (FleeHandler.FleeLookBtlReportResponse.alwaysUseFieldBuilders)
/*       */           getBrFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.brBuilder_ == null) {
/*       */           this.br_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.brBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_FleeLookBtlReportResponse_descriptor; }
/*       */       public FleeHandler.FleeLookBtlReportResponse getDefaultInstanceForType() { return FleeHandler.FleeLookBtlReportResponse.getDefaultInstance(); }
/*       */       public FleeHandler.FleeLookBtlReportResponse build() { FleeHandler.FleeLookBtlReportResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public FleeHandler.FleeLookBtlReportResponse buildPartial() { FleeHandler.FleeLookBtlReportResponse result = new FleeHandler.FleeLookBtlReportResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.brBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.br_ = Collections.unmodifiableList(this.br_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.br_ = this.br_;
/*       */         } else {
/*       */           result.br_ = this.brBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.FleeLookBtlReportResponse)
/*       */           return mergeFrom((FleeHandler.FleeLookBtlReportResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(FleeHandler.FleeLookBtlReportResponse other) { if (other == FleeHandler.FleeLookBtlReportResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.brBuilder_ == null) {
/*       */           if (!other.br_.isEmpty()) {
/*       */             if (this.br_.isEmpty()) {
/*       */               this.br_ = other.br_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureBrIsMutable();
/*       */               this.br_.addAll(other.br_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.br_.isEmpty()) {
/*       */           if (this.brBuilder_.isEmpty()) {
/*       */             this.brBuilder_.dispose();
/*       */             this.brBuilder_ = null;
/*       */             this.br_ = other.br_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.brBuilder_ = FleeHandler.FleeLookBtlReportResponse.alwaysUseFieldBuilders ? getBrFieldBuilder() : null;
/*       */           } else {
/*       */             this.brBuilder_.addAllMessages(other.br_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.FleeLookBtlReportResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.FleeLookBtlReportResponse)FleeHandler.FleeLookBtlReportResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.FleeLookBtlReportResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getS2CMsg() { Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setS2CMsg(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = FleeHandler.FleeLookBtlReportResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureBrIsMutable() { if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.br_ = new ArrayList<>(this.br_);
/*       */           this.bitField0_ |= 0x4;
/*       */         }  }
/*       */       public List<FleeHandler.FleeBtlReport> getBrList() { if (this.brBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.br_); 
/*       */         return this.brBuilder_.getMessageList(); }
/*       */       public int getBrCount() { if (this.brBuilder_ == null)
/*       */           return this.br_.size(); 
/*       */         return this.brBuilder_.getCount(); }
/*       */       public FleeHandler.FleeBtlReport getBr(int index) { if (this.brBuilder_ == null)
/*       */           return this.br_.get(index); 
/*       */         return (FleeHandler.FleeBtlReport)this.brBuilder_.getMessage(index); }
/*       */       public Builder setBr(int index, FleeHandler.FleeBtlReport value) { if (this.brBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureBrIsMutable();
/*       */           this.br_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setBr(int index, FleeHandler.FleeBtlReport.Builder builderForValue) { if (this.brBuilder_ == null) {
/*       */           ensureBrIsMutable();
/*       */           this.br_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addBr(FleeHandler.FleeBtlReport value) { if (this.brBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureBrIsMutable();
/*       */           this.br_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addBr(int index, FleeHandler.FleeBtlReport value) { if (this.brBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureBrIsMutable();
/*       */           this.br_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addBr(FleeHandler.FleeBtlReport.Builder builderForValue) { if (this.brBuilder_ == null) {
/*       */           ensureBrIsMutable();
/*       */           this.br_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addBr(int index, FleeHandler.FleeBtlReport.Builder builderForValue) { if (this.brBuilder_ == null) {
/*       */           ensureBrIsMutable();
/*       */           this.br_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllBr(Iterable<? extends FleeHandler.FleeBtlReport> values) {
/*       */         if (this.brBuilder_ == null) {
/*       */           ensureBrIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.br_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearBr() {
/*       */         if (this.brBuilder_ == null) {
/*       */           this.br_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeBr(int index) {
/*       */         if (this.brBuilder_ == null) {
/*       */           ensureBrIsMutable();
/*       */           this.br_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.brBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public FleeHandler.FleeBtlReport.Builder getBrBuilder(int index) {
/*       */         return (FleeHandler.FleeBtlReport.Builder)getBrFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public FleeHandler.FleeBtlReportOrBuilder getBrOrBuilder(int index) {
/*       */         if (this.brBuilder_ == null)
/*       */           return this.br_.get(index); 
/*       */         return (FleeHandler.FleeBtlReportOrBuilder)this.brBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends FleeHandler.FleeBtlReportOrBuilder> getBrOrBuilderList() {
/*       */         if (this.brBuilder_ != null)
/*       */           return this.brBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.br_);
/*       */       }
/*       */       public FleeHandler.FleeBtlReport.Builder addBrBuilder() {
/*       */         return (FleeHandler.FleeBtlReport.Builder)getBrFieldBuilder().addBuilder(FleeHandler.FleeBtlReport.getDefaultInstance());
/*       */       }
/*       */       public FleeHandler.FleeBtlReport.Builder addBrBuilder(int index) {
/*       */         return (FleeHandler.FleeBtlReport.Builder)getBrFieldBuilder().addBuilder(index, FleeHandler.FleeBtlReport.getDefaultInstance());
/*       */       }
/*       */       public List<FleeHandler.FleeBtlReport.Builder> getBrBuilderList() {
/*       */         return getBrFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<FleeHandler.FleeBtlReport, FleeHandler.FleeBtlReport.Builder, FleeHandler.FleeBtlReportOrBuilder> getBrFieldBuilder() {
/*       */         if (this.brBuilder_ == null) {
/*       */           this.brBuilder_ = new RepeatedFieldBuilder(this.br_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.br_ = null;
/*       */         } 
/*       */         return this.brBuilder_;
/*       */       } } }
/*  6241 */   public static final class EnterFleeRequest extends GeneratedMessage implements EnterFleeRequestOrBuilder { private static final EnterFleeRequest defaultInstance = new EnterFleeRequest(true); private final UnknownFieldSet unknownFields; private EnterFleeRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EnterFleeRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EnterFleeRequest getDefaultInstance() { return defaultInstance; } public EnterFleeRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EnterFleeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_EnterFleeRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_EnterFleeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterFleeRequest.class, Builder.class); } public static Parser<EnterFleeRequest> PARSER = (Parser<EnterFleeRequest>)new AbstractParser<EnterFleeRequest>() { public FleeHandler.EnterFleeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.EnterFleeRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EnterFleeRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static EnterFleeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (EnterFleeRequest)PARSER.parseFrom(data); } public static EnterFleeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterFleeRequest)PARSER.parseFrom(data, extensionRegistry); } public static EnterFleeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (EnterFleeRequest)PARSER.parseFrom(data); } public static EnterFleeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EnterFleeRequest)PARSER.parseFrom(data, extensionRegistry); } public static EnterFleeRequest parseFrom(InputStream input) throws IOException { return (EnterFleeRequest)PARSER.parseFrom(input); } public static EnterFleeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterFleeRequest)PARSER.parseFrom(input, extensionRegistry); } public static EnterFleeRequest parseDelimitedFrom(InputStream input) throws IOException { return (EnterFleeRequest)PARSER.parseDelimitedFrom(input); } public static EnterFleeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterFleeRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static EnterFleeRequest parseFrom(CodedInputStream input) throws IOException { return (EnterFleeRequest)PARSER.parseFrom(input); } public static EnterFleeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EnterFleeRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(EnterFleeRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.EnterFleeRequestOrBuilder {
/*  6242 */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_EnterFleeRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_EnterFleeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.EnterFleeRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.EnterFleeRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_EnterFleeRequest_descriptor; } public FleeHandler.EnterFleeRequest getDefaultInstanceForType() { return FleeHandler.EnterFleeRequest.getDefaultInstance(); } public FleeHandler.EnterFleeRequest build() { FleeHandler.EnterFleeRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.EnterFleeRequest buildPartial() { FleeHandler.EnterFleeRequest result = new FleeHandler.EnterFleeRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.EnterFleeRequest) return mergeFrom((FleeHandler.EnterFleeRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.EnterFleeRequest other) { if (other == FleeHandler.EnterFleeRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.EnterFleeRequest parsedMessage = null; try { parsedMessage = (FleeHandler.EnterFleeRequest)FleeHandler.EnterFleeRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.EnterFleeRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*       */      }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class EnterFleeResponse
/*       */     extends GeneratedMessage
/*       */     implements EnterFleeResponseOrBuilder
/*       */   {
/*  7031 */     private static final EnterFleeResponse defaultInstance = new EnterFleeResponse(true); private final UnknownFieldSet unknownFields; private EnterFleeResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EnterFleeResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EnterFleeResponse getDefaultInstance() { return defaultInstance; } public EnterFleeResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EnterFleeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.avgMatchTime_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.joinTime_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_EnterFleeResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_EnterFleeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterFleeResponse.class, Builder.class); } public static Parser<EnterFleeResponse> PARSER = (Parser<EnterFleeResponse>)new AbstractParser<EnterFleeResponse>() { public FleeHandler.EnterFleeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.EnterFleeResponse(input, extensionRegistry); } }
/*  7032 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int AVGMATCHTIME_FIELD_NUMBER = 3; private int avgMatchTime_; public static final int JOINTIME_FIELD_NUMBER = 4; private int joinTime_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EnterFleeResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */      public String getS2CMsg() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.s2CMsg_ = s; 
/*       */       return s;
/*       */     } public ByteString getS2CMsgBytes() {
/*       */       Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     } public boolean hasAvgMatchTime() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public int getAvgMatchTime() {
/*       */       return this.avgMatchTime_;
/*       */     } public boolean hasJoinTime() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     } public int getJoinTime() {
/*       */       return this.joinTime_;
/*       */     } private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.avgMatchTime_ = 0;
/*       */       this.joinTime_ = 0;
/*       */     } public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     } public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(3, this.avgMatchTime_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.joinTime_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     } public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.avgMatchTime_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.joinTime_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static EnterFleeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(data);
/*       */     } public static EnterFleeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static EnterFleeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(data);
/*       */     } public static EnterFleeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static EnterFleeResponse parseFrom(InputStream input) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(input);
/*       */     } public static EnterFleeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static EnterFleeResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseDelimitedFrom(input);
/*       */     } public static EnterFleeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static EnterFleeResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static EnterFleeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (EnterFleeResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(EnterFleeResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.EnterFleeResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int avgMatchTime_; private int joinTime_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return FleeHandler.internal_static_pomelo_area_EnterFleeResponse_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_EnterFleeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.EnterFleeResponse.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (FleeHandler.EnterFleeResponse.alwaysUseFieldBuilders);
/*       */       }
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.avgMatchTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.joinTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return FleeHandler.internal_static_pomelo_area_EnterFleeResponse_descriptor;
/*       */       }
/*       */       public FleeHandler.EnterFleeResponse getDefaultInstanceForType() {
/*       */         return FleeHandler.EnterFleeResponse.getDefaultInstance();
/*       */       }
/*       */       public FleeHandler.EnterFleeResponse build() {
/*       */         FleeHandler.EnterFleeResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public FleeHandler.EnterFleeResponse buildPartial() {
/*       */         FleeHandler.EnterFleeResponse result = new FleeHandler.EnterFleeResponse(this);
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
/*       */         result.avgMatchTime_ = this.avgMatchTime_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.joinTime_ = this.joinTime_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.EnterFleeResponse)
/*       */           return mergeFrom((FleeHandler.EnterFleeResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(FleeHandler.EnterFleeResponse other) {
/*       */         if (other == FleeHandler.EnterFleeResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasAvgMatchTime())
/*       */           setAvgMatchTime(other.getAvgMatchTime()); 
/*       */         if (other.hasJoinTime())
/*       */           setJoinTime(other.getJoinTime()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.EnterFleeResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.EnterFleeResponse)FleeHandler.EnterFleeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.EnterFleeResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
/*       */       public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       public Builder setS2CMsg(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = FleeHandler.EnterFleeResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasAvgMatchTime() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       public int getAvgMatchTime() {
/*       */         return this.avgMatchTime_;
/*       */       }
/*       */       public Builder setAvgMatchTime(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.avgMatchTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearAvgMatchTime() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.avgMatchTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasJoinTime() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public int getJoinTime() {
/*       */         return this.joinTime_;
/*       */       }
/*       */       public Builder setJoinTime(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.joinTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearJoinTime() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.joinTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  7352 */   public static final class CancelMatchRequest extends GeneratedMessage implements CancelMatchRequestOrBuilder { private static final CancelMatchRequest defaultInstance = new CancelMatchRequest(true); private final UnknownFieldSet unknownFields; private CancelMatchRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CancelMatchRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CancelMatchRequest getDefaultInstance() { return defaultInstance; } public CancelMatchRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CancelMatchRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_CancelMatchRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_CancelMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CancelMatchRequest.class, Builder.class); } public static Parser<CancelMatchRequest> PARSER = (Parser<CancelMatchRequest>)new AbstractParser<CancelMatchRequest>() { public FleeHandler.CancelMatchRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.CancelMatchRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CancelMatchRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CancelMatchRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CancelMatchRequest)PARSER.parseFrom(data); } public static CancelMatchRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CancelMatchRequest)PARSER.parseFrom(data, extensionRegistry); } public static CancelMatchRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CancelMatchRequest)PARSER.parseFrom(data); } public static CancelMatchRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CancelMatchRequest)PARSER.parseFrom(data, extensionRegistry); } public static CancelMatchRequest parseFrom(InputStream input) throws IOException { return (CancelMatchRequest)PARSER.parseFrom(input); } public static CancelMatchRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CancelMatchRequest)PARSER.parseFrom(input, extensionRegistry); } public static CancelMatchRequest parseDelimitedFrom(InputStream input) throws IOException { return (CancelMatchRequest)PARSER.parseDelimitedFrom(input); } public static CancelMatchRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CancelMatchRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CancelMatchRequest parseFrom(CodedInputStream input) throws IOException { return (CancelMatchRequest)PARSER.parseFrom(input); } public static CancelMatchRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CancelMatchRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CancelMatchRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.CancelMatchRequestOrBuilder {
/*  7353 */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_CancelMatchRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_CancelMatchRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.CancelMatchRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FleeHandler.CancelMatchRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_CancelMatchRequest_descriptor; } public FleeHandler.CancelMatchRequest getDefaultInstanceForType() { return FleeHandler.CancelMatchRequest.getDefaultInstance(); } public FleeHandler.CancelMatchRequest build() { FleeHandler.CancelMatchRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FleeHandler.CancelMatchRequest buildPartial() { FleeHandler.CancelMatchRequest result = new FleeHandler.CancelMatchRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.CancelMatchRequest) return mergeFrom((FleeHandler.CancelMatchRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FleeHandler.CancelMatchRequest other) { if (other == FleeHandler.CancelMatchRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.CancelMatchRequest parsedMessage = null; try { parsedMessage = (FleeHandler.CancelMatchRequest)FleeHandler.CancelMatchRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.CancelMatchRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
/*       */      }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class CancelMatchResponse
/*       */     extends GeneratedMessage
/*       */     implements CancelMatchResponseOrBuilder
/*       */   {
/*  7922 */     private static final CancelMatchResponse defaultInstance = new CancelMatchResponse(true); private final UnknownFieldSet unknownFields; private CancelMatchResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CancelMatchResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CancelMatchResponse getDefaultInstance() { return defaultInstance; } public CancelMatchResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CancelMatchResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_CancelMatchResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_CancelMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CancelMatchResponse.class, Builder.class); } public static Parser<CancelMatchResponse> PARSER = (Parser<CancelMatchResponse>)new AbstractParser<CancelMatchResponse>() { public FleeHandler.CancelMatchResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.CancelMatchResponse(input, extensionRegistry); } }
/*  7923 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CancelMatchResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */     public static CancelMatchResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(data);
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
/*       */     public static CancelMatchResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static CancelMatchResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(data);
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
/*       */     public static CancelMatchResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static CancelMatchResponse parseFrom(InputStream input) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(input);
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
/*       */     public static CancelMatchResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static CancelMatchResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static CancelMatchResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static CancelMatchResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(input);
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
/*       */     public static CancelMatchResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CancelMatchResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(CancelMatchResponse prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements FleeHandler.CancelMatchResponseOrBuilder
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
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return FleeHandler.internal_static_pomelo_area_CancelMatchResponse_descriptor;
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
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_CancelMatchResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.CancelMatchResponse.class, Builder.class);
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
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (FleeHandler.CancelMatchResponse.alwaysUseFieldBuilders);
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return FleeHandler.internal_static_pomelo_area_CancelMatchResponse_descriptor;
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
/*       */       public FleeHandler.CancelMatchResponse getDefaultInstanceForType() {
/*       */         return FleeHandler.CancelMatchResponse.getDefaultInstance();
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
/*       */       public FleeHandler.CancelMatchResponse build() {
/*       */         FleeHandler.CancelMatchResponse result = buildPartial();
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
/*       */       public FleeHandler.CancelMatchResponse buildPartial() {
/*       */         FleeHandler.CancelMatchResponse result = new FleeHandler.CancelMatchResponse(this);
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
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.CancelMatchResponse) {
/*       */           return mergeFrom((FleeHandler.CancelMatchResponse)other);
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
/*       */       public Builder mergeFrom(FleeHandler.CancelMatchResponse other) {
/*       */         if (other == FleeHandler.CancelMatchResponse.getDefaultInstance()) {
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
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.CancelMatchResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.CancelMatchResponse)FleeHandler.CancelMatchResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.CancelMatchResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = FleeHandler.CancelMatchResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
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
/*       */   public static final class FleeMatchMemberInfo
/*       */     extends GeneratedMessage
/*       */     implements FleeMatchMemberInfoOrBuilder
/*       */   {
/*  8955 */     private static final FleeMatchMemberInfo defaultInstance = new FleeMatchMemberInfo(true); private final UnknownFieldSet unknownFields; private FleeMatchMemberInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FleeMatchMemberInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FleeMatchMemberInfo getDefaultInstance() { return defaultInstance; } public FleeMatchMemberInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FleeMatchMemberInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.playerId_ = bs; break;case 16: this.bitField0_ |= 0x2; this.playerPro_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.playerLvl_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.playerName_ = bs; break;case 40: this.bitField0_ |= 0x10; this.scoreChange_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.killCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_FleeMatchMemberInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_FleeMatchMemberInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeMatchMemberInfo.class, Builder.class); } public static Parser<FleeMatchMemberInfo> PARSER = (Parser<FleeMatchMemberInfo>)new AbstractParser<FleeMatchMemberInfo>() { public FleeHandler.FleeMatchMemberInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.FleeMatchMemberInfo(input, extensionRegistry); } }
/*  8956 */     ; private int bitField0_; public static final int PLAYERID_FIELD_NUMBER = 1; private Object playerId_; public static final int PLAYERPRO_FIELD_NUMBER = 2; private int playerPro_; public static final int PLAYERLVL_FIELD_NUMBER = 3; private int playerLvl_; public static final int PLAYERNAME_FIELD_NUMBER = 4; private Object playerName_; public static final int SCORECHANGE_FIELD_NUMBER = 5; private int scoreChange_; public static final int KILLCOUNT_FIELD_NUMBER = 6; private int killCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FleeMatchMemberInfo> getParserForType() { return PARSER; } public boolean hasPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getPlayerId() { Object ref = this.playerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.playerId_ = s;  return s; } public ByteString getPlayerIdBytes() { Object ref = this.playerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.playerId_ = b; return b; }  return (ByteString)ref; } public boolean hasPlayerPro() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getPlayerPro() {
/*       */       return this.playerPro_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasPlayerLvl() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getPlayerLvl() {
/*       */       return this.playerLvl_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasPlayerName() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public String getPlayerName() {
/*       */       Object ref = this.playerName_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.playerName_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getPlayerNameBytes() {
/*       */       Object ref = this.playerName_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.playerName_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasScoreChange() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getScoreChange() {
/*       */       return this.scoreChange_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasKillCount() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getKillCount() {
/*       */       return this.killCount_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.playerId_ = "";
/*       */       this.playerPro_ = 0;
/*       */       this.playerLvl_ = 0;
/*       */       this.playerName_ = "";
/*       */       this.scoreChange_ = 0;
/*       */       this.killCount_ = 0;
/*       */     }
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
/*       */       if (!hasPlayerId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPlayerPro()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPlayerLvl()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPlayerName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasScoreChange()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasKillCount()) {
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
/*       */         output.writeBytes(1, getPlayerIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.playerPro_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.playerLvl_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getPlayerNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.scoreChange_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.killCount_);
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.playerPro_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.playerLvl_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getPlayerNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.scoreChange_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.killCount_);
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
/*       */     public static FleeMatchMemberInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(InputStream input) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static FleeMatchMemberInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (FleeMatchMemberInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(FleeMatchMemberInfo prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements FleeHandler.FleeMatchMemberInfoOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private Object playerId_;
/*       */       
/*       */       private int playerPro_;
/*       */       
/*       */       private int playerLvl_;
/*       */       
/*       */       private Object playerName_;
/*       */       
/*       */       private int scoreChange_;
/*       */       
/*       */       private int killCount_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return FleeHandler.internal_static_pomelo_area_FleeMatchMemberInfo_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_FleeMatchMemberInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.FleeMatchMemberInfo.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.playerId_ = "";
/*       */         this.playerName_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.playerId_ = "";
/*       */         this.playerName_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (FleeHandler.FleeMatchMemberInfo.alwaysUseFieldBuilders);
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
/*       */         this.playerId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.playerPro_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.playerLvl_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.playerName_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.scoreChange_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.killCount_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
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
/*       */         return FleeHandler.internal_static_pomelo_area_FleeMatchMemberInfo_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public FleeHandler.FleeMatchMemberInfo getDefaultInstanceForType() {
/*       */         return FleeHandler.FleeMatchMemberInfo.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public FleeHandler.FleeMatchMemberInfo build() {
/*       */         FleeHandler.FleeMatchMemberInfo result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public FleeHandler.FleeMatchMemberInfo buildPartial() {
/*       */         FleeHandler.FleeMatchMemberInfo result = new FleeHandler.FleeMatchMemberInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.playerId_ = this.playerId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.playerPro_ = this.playerPro_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.playerLvl_ = this.playerLvl_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.playerName_ = this.playerName_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.scoreChange_ = this.scoreChange_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.killCount_ = this.killCount_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.FleeMatchMemberInfo) {
/*       */           return mergeFrom((FleeHandler.FleeMatchMemberInfo)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(FleeHandler.FleeMatchMemberInfo other) {
/*       */         if (other == FleeHandler.FleeMatchMemberInfo.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasPlayerId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.playerId_ = other.playerId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPlayerPro()) {
/*       */           setPlayerPro(other.getPlayerPro());
/*       */         }
/*       */         if (other.hasPlayerLvl()) {
/*       */           setPlayerLvl(other.getPlayerLvl());
/*       */         }
/*       */         if (other.hasPlayerName()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.playerName_ = other.playerName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasScoreChange()) {
/*       */           setScoreChange(other.getScoreChange());
/*       */         }
/*       */         if (other.hasKillCount()) {
/*       */           setKillCount(other.getKillCount());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasPlayerId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPlayerPro()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPlayerLvl()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPlayerName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasScoreChange()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasKillCount()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.FleeMatchMemberInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.FleeMatchMemberInfo)FleeHandler.FleeMatchMemberInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.FleeMatchMemberInfo)e.getUnfinishedMessage();
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
/*       */       public boolean hasPlayerId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public String getPlayerId() {
/*       */         Object ref = this.playerId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.playerId_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public ByteString getPlayerIdBytes() {
/*       */         Object ref = this.playerId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.playerId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.playerId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearPlayerId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.playerId_ = FleeHandler.FleeMatchMemberInfo.getDefaultInstance().getPlayerId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.playerId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasPlayerPro() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getPlayerPro() {
/*       */         return this.playerPro_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerPro(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.playerPro_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearPlayerPro() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.playerPro_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasPlayerLvl() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getPlayerLvl() {
/*       */         return this.playerLvl_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerLvl(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.playerLvl_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearPlayerLvl() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.playerLvl_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasPlayerName() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */       
/*       */       public String getPlayerName() {
/*       */         Object ref = this.playerName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.playerName_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public ByteString getPlayerNameBytes() {
/*       */         Object ref = this.playerName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.playerName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.playerName_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearPlayerName() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.playerName_ = FleeHandler.FleeMatchMemberInfo.getDefaultInstance().getPlayerName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setPlayerNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.playerName_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasScoreChange() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getScoreChange() {
/*       */         return this.scoreChange_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setScoreChange(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.scoreChange_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearScoreChange() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.scoreChange_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasKillCount() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getKillCount() {
/*       */         return this.killCount_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setKillCount(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.killCount_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearKillCount() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.killCount_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class OnFleeDeathPush
/*       */     extends GeneratedMessage
/*       */     implements OnFleeDeathPushOrBuilder
/*       */   {
/*  9658 */     private static final OnFleeDeathPush defaultInstance = new OnFleeDeathPush(true); private final UnknownFieldSet unknownFields; private OnFleeDeathPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OnFleeDeathPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OnFleeDeathPush getDefaultInstance() { return defaultInstance; } public OnFleeDeathPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OnFleeDeathPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.outtime_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.rank_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.scoreChange_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_OnFleeDeathPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_OnFleeDeathPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnFleeDeathPush.class, Builder.class); } public static Parser<OnFleeDeathPush> PARSER = (Parser<OnFleeDeathPush>)new AbstractParser<OnFleeDeathPush>() { public FleeHandler.OnFleeDeathPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.OnFleeDeathPush(input, extensionRegistry); } }
/*  9659 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int OUTTIME_FIELD_NUMBER = 2; private int outtime_; public static final int RANK_FIELD_NUMBER = 3; private int rank_; public static final int SCORECHANGE_FIELD_NUMBER = 4; private int scoreChange_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OnFleeDeathPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasOuttime() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getOuttime() {
/*       */       return this.outtime_;
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
/*       */     public boolean hasRank() {
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
/*       */     public int getRank() {
/*       */       return this.rank_;
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
/*       */     public boolean hasScoreChange() {
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
/*       */     public int getScoreChange() {
/*       */       return this.scoreChange_;
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
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.outtime_ = 0;
/*       */       this.rank_ = 0;
/*       */       this.scoreChange_ = 0;
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
/*       */       if (!hasOuttime()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasRank()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasScoreChange()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.outtime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.rank_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.scoreChange_);
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
/*       */         size += CodedOutputStream.computeInt32Size(2, this.outtime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.rank_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.scoreChange_);
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
/*       */     public static OnFleeDeathPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(data);
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
/*       */     public static OnFleeDeathPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static OnFleeDeathPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(data);
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
/*       */     public static OnFleeDeathPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static OnFleeDeathPush parseFrom(InputStream input) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(input);
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
/*       */     public static OnFleeDeathPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static OnFleeDeathPush parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseDelimitedFrom(input);
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
/*       */     public static OnFleeDeathPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static OnFleeDeathPush parseFrom(CodedInputStream input) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(input);
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
/*       */     public static OnFleeDeathPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OnFleeDeathPush)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(OnFleeDeathPush prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements FleeHandler.OnFleeDeathPushOrBuilder
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
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int outtime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int rank_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int scoreChange_;
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
/*       */         return FleeHandler.internal_static_pomelo_area_OnFleeDeathPush_descriptor;
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
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return FleeHandler.internal_static_pomelo_area_OnFleeDeathPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.OnFleeDeathPush.class, Builder.class);
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
/*       */       private Builder() {
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (FleeHandler.OnFleeDeathPush.alwaysUseFieldBuilders);
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.outtime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.rank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.scoreChange_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return FleeHandler.internal_static_pomelo_area_OnFleeDeathPush_descriptor;
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
/*       */       public FleeHandler.OnFleeDeathPush getDefaultInstanceForType() {
/*       */         return FleeHandler.OnFleeDeathPush.getDefaultInstance();
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
/*       */       public FleeHandler.OnFleeDeathPush build() {
/*       */         FleeHandler.OnFleeDeathPush result = buildPartial();
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
/*       */       public FleeHandler.OnFleeDeathPush buildPartial() {
/*       */         FleeHandler.OnFleeDeathPush result = new FleeHandler.OnFleeDeathPush(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.outtime_ = this.outtime_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.rank_ = this.rank_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.scoreChange_ = this.scoreChange_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof FleeHandler.OnFleeDeathPush) {
/*       */           return mergeFrom((FleeHandler.OnFleeDeathPush)other);
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
/*       */       public Builder mergeFrom(FleeHandler.OnFleeDeathPush other) {
/*       */         if (other == FleeHandler.OnFleeDeathPush.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasOuttime()) {
/*       */           setOuttime(other.getOuttime());
/*       */         }
/*       */         if (other.hasRank()) {
/*       */           setRank(other.getRank());
/*       */         }
/*       */         if (other.hasScoreChange()) {
/*       */           setScoreChange(other.getScoreChange());
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasOuttime()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasRank()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasScoreChange()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         FleeHandler.OnFleeDeathPush parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (FleeHandler.OnFleeDeathPush)FleeHandler.OnFleeDeathPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (FleeHandler.OnFleeDeathPush)e.getUnfinishedMessage();
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
/*       */       public boolean hasOuttime() {
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
/*       */       public int getOuttime() {
/*       */         return this.outtime_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOuttime(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.outtime_ = value;
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
/*       */       public Builder clearOuttime() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.outtime_ = 0;
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
/*       */       public boolean hasRank() {
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
/*       */       public int getRank() {
/*       */         return this.rank_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setRank(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.rank_ = value;
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
/*       */       public Builder clearRank() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.rank_ = 0;
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
/*       */       public boolean hasScoreChange() {
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
/*       */       public int getScoreChange() {
/*       */         return this.scoreChange_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setScoreChange(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.scoreChange_ = value;
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
/*       */       public Builder clearScoreChange() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.scoreChange_ = 0;
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
/*       */   public static final class OnFleeEndPush
/*       */     extends GeneratedMessage
/*       */     implements OnFleeEndPushOrBuilder
/*       */   {
/* 10561 */     private static final OnFleeEndPush defaultInstance = new OnFleeEndPush(true); private final UnknownFieldSet unknownFields; private OnFleeEndPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OnFleeEndPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OnFleeEndPush getDefaultInstance() { return defaultInstance; } public OnFleeEndPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OnFleeEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.outtime_ = input.readInt32(); break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.ranks_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.ranks_.add(input.readMessage(FleeHandler.FleeMatchMemberInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.ranks_ = Collections.unmodifiableList(this.ranks_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_OnFleeEndPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_OnFleeEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnFleeEndPush.class, Builder.class); } public static Parser<OnFleeEndPush> PARSER = (Parser<OnFleeEndPush>)new AbstractParser<OnFleeEndPush>() { public FleeHandler.OnFleeEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FleeHandler.OnFleeEndPush(input, extensionRegistry); } }
/* 10562 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int OUTTIME_FIELD_NUMBER = 2; private int outtime_; public static final int RANKS_FIELD_NUMBER = 3; private List<FleeHandler.FleeMatchMemberInfo> ranks_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OnFleeEndPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasOuttime() { return ((this.bitField0_ & 0x2) == 2); } public int getOuttime() { return this.outtime_; } public List<FleeHandler.FleeMatchMemberInfo> getRanksList() { return this.ranks_; } public List<? extends FleeHandler.FleeMatchMemberInfoOrBuilder> getRanksOrBuilderList() { return (List)this.ranks_; } public int getRanksCount() { return this.ranks_.size(); } public FleeHandler.FleeMatchMemberInfo getRanks(int index) { return this.ranks_.get(index); } public FleeHandler.FleeMatchMemberInfoOrBuilder getRanksOrBuilder(int index) { return this.ranks_.get(index); } private void initFields() { this.s2CCode_ = 0; this.outtime_ = 0; this.ranks_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasOuttime()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getRanksCount(); i++) { if (!getRanks(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.outtime_);  for (int i = 0; i < this.ranks_.size(); i++) output.writeMessage(3, (MessageLite)this.ranks_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.outtime_);  for (int i = 0; i < this.ranks_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.ranks_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static OnFleeEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (OnFleeEndPush)PARSER.parseFrom(data); } public static OnFleeEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OnFleeEndPush)PARSER.parseFrom(data, extensionRegistry); } public static OnFleeEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (OnFleeEndPush)PARSER.parseFrom(data); } public static OnFleeEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OnFleeEndPush)PARSER.parseFrom(data, extensionRegistry); } public static OnFleeEndPush parseFrom(InputStream input) throws IOException { return (OnFleeEndPush)PARSER.parseFrom(input); } public static OnFleeEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OnFleeEndPush)PARSER.parseFrom(input, extensionRegistry); } public static OnFleeEndPush parseDelimitedFrom(InputStream input) throws IOException { return (OnFleeEndPush)PARSER.parseDelimitedFrom(input); } public static OnFleeEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OnFleeEndPush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static OnFleeEndPush parseFrom(CodedInputStream input) throws IOException { return (OnFleeEndPush)PARSER.parseFrom(input); } public static OnFleeEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OnFleeEndPush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(OnFleeEndPush prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } static { defaultInstance.initFields(); }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FleeHandler.OnFleeEndPushOrBuilder {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private int outtime_;
/*       */       private List<FleeHandler.FleeMatchMemberInfo> ranks_;
/*       */       private RepeatedFieldBuilder<FleeHandler.FleeMatchMemberInfo, FleeHandler.FleeMatchMemberInfo.Builder, FleeHandler.FleeMatchMemberInfoOrBuilder> ranksBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return FleeHandler.internal_static_pomelo_area_OnFleeEndPush_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FleeHandler.internal_static_pomelo_area_OnFleeEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FleeHandler.OnFleeEndPush.class, Builder.class); }
/*       */       private Builder() { this.ranks_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.ranks_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (FleeHandler.OnFleeEndPush.alwaysUseFieldBuilders)
/*       */           getRanksFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.outtime_ = 0; this.bitField0_ &= 0xFFFFFFFD; if (this.ranksBuilder_ == null) { this.ranks_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.ranksBuilder_.clear(); }  return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return FleeHandler.internal_static_pomelo_area_OnFleeEndPush_descriptor; }
/*       */       public FleeHandler.OnFleeEndPush getDefaultInstanceForType() { return FleeHandler.OnFleeEndPush.getDefaultInstance(); }
/*       */       public FleeHandler.OnFleeEndPush build() { FleeHandler.OnFleeEndPush result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public FleeHandler.OnFleeEndPush buildPartial() { FleeHandler.OnFleeEndPush result = new FleeHandler.OnFleeEndPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.outtime_ = this.outtime_; if (this.ranksBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.ranks_ = Collections.unmodifiableList(this.ranks_); this.bitField0_ &= 0xFFFFFFFB; }  result.ranks_ = this.ranks_; } else { result.ranks_ = this.ranksBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof FleeHandler.OnFleeEndPush)
/*       */           return mergeFrom((FleeHandler.OnFleeEndPush)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(FleeHandler.OnFleeEndPush other) { if (other == FleeHandler.OnFleeEndPush.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (other.hasOuttime())
/*       */           setOuttime(other.getOuttime());  if (this.ranksBuilder_ == null) { if (!other.ranks_.isEmpty()) { if (this.ranks_.isEmpty()) { this.ranks_ = other.ranks_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureRanksIsMutable(); this.ranks_.addAll(other.ranks_); }  onChanged(); }  } else if (!other.ranks_.isEmpty()) { if (this.ranksBuilder_.isEmpty()) { this.ranksBuilder_.dispose(); this.ranksBuilder_ = null; this.ranks_ = other.ranks_; this.bitField0_ &= 0xFFFFFFFB; this.ranksBuilder_ = FleeHandler.OnFleeEndPush.alwaysUseFieldBuilders ? getRanksFieldBuilder() : null; } else { this.ranksBuilder_.addAllMessages(other.ranks_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false;  if (!hasOuttime())
/*       */           return false;  for (int i = 0; i < getRanksCount(); i++) { if (!getRanks(i).isInitialized())
/*       */             return false;  }  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FleeHandler.OnFleeEndPush parsedMessage = null; try { parsedMessage = (FleeHandler.OnFleeEndPush)FleeHandler.OnFleeEndPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FleeHandler.OnFleeEndPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage);  }  return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*       */       public boolean hasOuttime() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public int getOuttime() { return this.outtime_; }
/*       */       public Builder setOuttime(int value) { this.bitField0_ |= 0x2; this.outtime_ = value; onChanged(); return this; }
/*       */       public Builder clearOuttime() { this.bitField0_ &= 0xFFFFFFFD; this.outtime_ = 0; onChanged(); return this; }
/*       */       private void ensureRanksIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.ranks_ = new ArrayList<>(this.ranks_); this.bitField0_ |= 0x4; }  }
/*       */       public List<FleeHandler.FleeMatchMemberInfo> getRanksList() { if (this.ranksBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.ranks_);  return this.ranksBuilder_.getMessageList(); }
/*       */       public int getRanksCount() { if (this.ranksBuilder_ == null)
/*       */           return this.ranks_.size();  return this.ranksBuilder_.getCount(); }
/*       */       public FleeHandler.FleeMatchMemberInfo getRanks(int index) { if (this.ranksBuilder_ == null)
/*       */           return this.ranks_.get(index);  return (FleeHandler.FleeMatchMemberInfo)this.ranksBuilder_.getMessage(index); }
/*       */       public Builder setRanks(int index, FleeHandler.FleeMatchMemberInfo value) { if (this.ranksBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureRanksIsMutable(); this.ranks_.set(index, value); onChanged(); }
/*       */         else { this.ranksBuilder_.setMessage(index, value); }
/*       */          return this; }
/*       */       public Builder setRanks(int index, FleeHandler.FleeMatchMemberInfo.Builder builderForValue) { if (this.ranksBuilder_ == null) { ensureRanksIsMutable(); this.ranks_.set(index, builderForValue.build()); onChanged(); }
/*       */         else { this.ranksBuilder_.setMessage(index, builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addRanks(FleeHandler.FleeMatchMemberInfo value) { if (this.ranksBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureRanksIsMutable(); this.ranks_.add(value); onChanged(); }
/*       */         else { this.ranksBuilder_.addMessage(value); }
/*       */          return this; }
/*       */       public Builder addRanks(int index, FleeHandler.FleeMatchMemberInfo value) { if (this.ranksBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureRanksIsMutable(); this.ranks_.add(index, value); onChanged(); }
/*       */         else { this.ranksBuilder_.addMessage(index, value); }
/*       */          return this; }
/*       */       public Builder addRanks(FleeHandler.FleeMatchMemberInfo.Builder builderForValue) { if (this.ranksBuilder_ == null) { ensureRanksIsMutable(); this.ranks_.add(builderForValue.build()); onChanged(); }
/*       */         else { this.ranksBuilder_.addMessage(builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addRanks(int index, FleeHandler.FleeMatchMemberInfo.Builder builderForValue) { if (this.ranksBuilder_ == null) { ensureRanksIsMutable(); this.ranks_.add(index, builderForValue.build()); onChanged(); }
/*       */         else { this.ranksBuilder_.addMessage(index, builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addAllRanks(Iterable<? extends FleeHandler.FleeMatchMemberInfo> values) { if (this.ranksBuilder_ == null) { ensureRanksIsMutable(); AbstractMessageLite.Builder.addAll(values, this.ranks_); onChanged(); }
/*       */         else { this.ranksBuilder_.addAllMessages(values); }
/*       */          return this; }
/*       */       public Builder clearRanks() { if (this.ranksBuilder_ == null) { this.ranks_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); }
/*       */         else { this.ranksBuilder_.clear(); }
/*       */          return this; }
/*       */       public Builder removeRanks(int index) { if (this.ranksBuilder_ == null) { ensureRanksIsMutable(); this.ranks_.remove(index); onChanged(); }
/*       */         else { this.ranksBuilder_.remove(index); }
/*       */          return this; }
/*       */       public FleeHandler.FleeMatchMemberInfo.Builder getRanksBuilder(int index) { return (FleeHandler.FleeMatchMemberInfo.Builder)getRanksFieldBuilder().getBuilder(index); } public FleeHandler.FleeMatchMemberInfoOrBuilder getRanksOrBuilder(int index) { if (this.ranksBuilder_ == null)
/*       */           return this.ranks_.get(index);  return (FleeHandler.FleeMatchMemberInfoOrBuilder)this.ranksBuilder_.getMessageOrBuilder(index); } public List<? extends FleeHandler.FleeMatchMemberInfoOrBuilder> getRanksOrBuilderList() { if (this.ranksBuilder_ != null)
/*       */           return this.ranksBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.ranks_); } public FleeHandler.FleeMatchMemberInfo.Builder addRanksBuilder() { return (FleeHandler.FleeMatchMemberInfo.Builder)getRanksFieldBuilder().addBuilder(FleeHandler.FleeMatchMemberInfo.getDefaultInstance()); } public FleeHandler.FleeMatchMemberInfo.Builder addRanksBuilder(int index) { return (FleeHandler.FleeMatchMemberInfo.Builder)getRanksFieldBuilder().addBuilder(index, FleeHandler.FleeMatchMemberInfo.getDefaultInstance()); } public List<FleeHandler.FleeMatchMemberInfo.Builder> getRanksBuilderList() { return getRanksFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<FleeHandler.FleeMatchMemberInfo, FleeHandler.FleeMatchMemberInfo.Builder, FleeHandler.FleeMatchMemberInfoOrBuilder> getRanksFieldBuilder() { if (this.ranksBuilder_ == null) { this.ranksBuilder_ = new RepeatedFieldBuilder(this.ranks_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.ranks_ = null; }
/*       */          return this.ranksBuilder_; } }
/* 10646 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 10651 */     String[] descriptorData = { "\n\021fleeHandler.proto\022\013pomelo.area\032\fcommon.proto\"\021\n\017FleeInfoRequest\".\n\013GradeReward\022\017\n\007gradeId\030\001 \002(\005\022\016\n\006status\030\002 \002(\005\"ú\001\n\020FleeInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013currentRank\030\003 \001(\005\022\017\n\007maxRank\030\004 \001(\005\022\r\n\005grade\030\005 \001(\005\022\020\n\bmaxGrade\030\006 \001(\005\022\025\n\rseasonEndTime\030\007 \001(\003\022\r\n\005score\030\b \001(\005\022.\n\fgradeRewards\030\t \003(\0132\030.pomelo.area.GradeReward\022\020\n\bjoinTime\030\n \001(\005\022\024\n\favgMatchTime\030\013 \001(\005\"#\n\020GetRewardRequest\022\017\n\007gradeId\030\001 ", "\002(\005\"6\n\021GetRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\032\n\030FleeLookBtlReportRequest\"F\n\rFleeBtlReport\022\f\n\004rank\030\001 \001(\005\022\023\n\013scoreChange\030\002 \001(\005\022\022\n\ncreateTime\030\003 \001(\t\"f\n\031FleeLookBtlReportResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022&\n\002br\030\003 \003(\0132\032.pomelo.area.FleeBtlReport\"\022\n\020EnterFleeRequest\"^\n\021EnterFleeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\024\n\favgMatchTime\030\003 \001(\005\022\020\n\bjoinTime\030\004 \001(\005\"\024\n\022CancelMatchReques", "t\"8\n\023CancelMatchResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\001\n\023FleeMatchMemberInfo\022\020\n\bplayerId\030\001 \002(\t\022\021\n\tplayerPro\030\002 \002(\005\022\021\n\tplayerLvl\030\003 \002(\005\022\022\n\nplayerName\030\004 \002(\t\022\023\n\013scoreChange\030\005 \002(\005\022\021\n\tkillCount\030\006 \002(\005\"W\n\017OnFleeDeathPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007outtime\030\002 \002(\005\022\f\n\004rank\030\003 \002(\005\022\023\n\013scoreChange\030\004 \002(\005\"c\n\rOnFleeEndPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007outtime\030\002 \002(\005\022/\n\005ranks\030\003 \003(\0132 .pomelo.area.FleeMatchMemberInfo2Ç\003\n\013fleeHa", "ndler\022N\n\017fleeInfoRequest\022\034.pomelo.area.FleeInfoRequest\032\035.pomelo.area.FleeInfoResponse\022Q\n\020getRewardRequest\022\035.pomelo.area.GetRewardRequest\032\036.pomelo.area.GetRewardResponse\022i\n\030fleeLookBtlReportRequest\022%.pomelo.area.FleeLookBtlReportRequest\032&.pomelo.area.FleeLookBtlReportResponse\022Q\n\020enterFleeRequest\022\035.pomelo.area.EnterFleeRequest\032\036.pomelo.area.EnterFleeResponse\022W\n\022cancelMatchRequest\022\037.pomelo.area.Cance", "lMatchRequest\032 .pomelo.area.CancelMatchResponse2\001\n\bfleePush\022=\n\017onFleeDeathPush\022\034.pomelo.area.OnFleeDeathPush\032\f.pomelo.Void\0229\n\ronFleeEndPush\022\032.pomelo.area.OnFleeEndPush\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10698 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 10702 */           FleeHandler.descriptor = root;
/* 10703 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 10707 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 10709 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 10712 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 10713 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeInfoRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10718 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GradeReward_descriptor = getDescriptor().getMessageTypes().get(1);
/* 10719 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GradeReward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GradeReward_descriptor, new String[] { "GradeId", "Status" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10724 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 10725 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "CurrentRank", "MaxRank", "Grade", "MaxGrade", "SeasonEndTime", "Score", "GradeRewards", "JoinTime", "AvgMatchTime" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10730 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetRewardRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 10731 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRewardRequest_descriptor, new String[] { "GradeId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10736 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetRewardResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 10737 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRewardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10742 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeLookBtlReportRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 10743 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeLookBtlReportRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeLookBtlReportRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10748 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeBtlReport_descriptor = getDescriptor().getMessageTypes().get(6);
/* 10749 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeBtlReport_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeBtlReport_descriptor, new String[] { "Rank", "ScoreChange", "CreateTime" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10754 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeLookBtlReportResponse_descriptor = getDescriptor().getMessageTypes().get(7);
/* 10755 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeLookBtlReportResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeLookBtlReportResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Br" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10760 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EnterFleeRequest_descriptor = getDescriptor().getMessageTypes().get(8);
/* 10761 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterFleeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterFleeRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10766 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EnterFleeResponse_descriptor = getDescriptor().getMessageTypes().get(9);
/* 10767 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterFleeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterFleeResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "AvgMatchTime", "JoinTime" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10772 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CancelMatchRequest_descriptor = getDescriptor().getMessageTypes().get(10);
/* 10773 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CancelMatchRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CancelMatchRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10778 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CancelMatchResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 10779 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CancelMatchResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CancelMatchResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10784 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FleeMatchMemberInfo_descriptor = getDescriptor().getMessageTypes().get(12);
/* 10785 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FleeMatchMemberInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FleeMatchMemberInfo_descriptor, new String[] { "PlayerId", "PlayerPro", "PlayerLvl", "PlayerName", "ScoreChange", "KillCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10790 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OnFleeDeathPush_descriptor = getDescriptor().getMessageTypes().get(13);
/* 10791 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnFleeDeathPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnFleeDeathPush_descriptor, new String[] { "S2CCode", "Outtime", "Rank", "ScoreChange" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10796 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OnFleeEndPush_descriptor = getDescriptor().getMessageTypes().get(14);
/* 10797 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnFleeEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnFleeEndPush_descriptor, new String[] { "S2CCode", "Outtime", "Ranks" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 10801 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface OnFleeEndPushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasOuttime();
/*       */     
/*       */     int getOuttime();
/*       */     
/*       */     List<FleeHandler.FleeMatchMemberInfo> getRanksList();
/*       */     
/*       */     FleeHandler.FleeMatchMemberInfo getRanks(int param1Int);
/*       */     
/*       */     int getRanksCount();
/*       */     
/*       */     List<? extends FleeHandler.FleeMatchMemberInfoOrBuilder> getRanksOrBuilderList();
/*       */     
/*       */     FleeHandler.FleeMatchMemberInfoOrBuilder getRanksOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface OnFleeDeathPushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasOuttime();
/*       */     
/*       */     int getOuttime();
/*       */     
/*       */     boolean hasRank();
/*       */     
/*       */     int getRank();
/*       */     
/*       */     boolean hasScoreChange();
/*       */     
/*       */     int getScoreChange();
/*       */   }
/*       */   
/*       */   public static interface FleeMatchMemberInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasPlayerId();
/*       */     
/*       */     String getPlayerId();
/*       */     
/*       */     ByteString getPlayerIdBytes();
/*       */     
/*       */     boolean hasPlayerPro();
/*       */     
/*       */     int getPlayerPro();
/*       */     
/*       */     boolean hasPlayerLvl();
/*       */     
/*       */     int getPlayerLvl();
/*       */     
/*       */     boolean hasPlayerName();
/*       */     
/*       */     String getPlayerName();
/*       */     
/*       */     ByteString getPlayerNameBytes();
/*       */     
/*       */     boolean hasScoreChange();
/*       */     
/*       */     int getScoreChange();
/*       */     
/*       */     boolean hasKillCount();
/*       */     
/*       */     int getKillCount();
/*       */   }
/*       */   
/*       */   public static interface CancelMatchResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface CancelMatchRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface EnterFleeResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasAvgMatchTime();
/*       */     
/*       */     int getAvgMatchTime();
/*       */     
/*       */     boolean hasJoinTime();
/*       */     
/*       */     int getJoinTime();
/*       */   }
/*       */   
/*       */   public static interface EnterFleeRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface FleeLookBtlReportResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<FleeHandler.FleeBtlReport> getBrList();
/*       */     
/*       */     FleeHandler.FleeBtlReport getBr(int param1Int);
/*       */     
/*       */     int getBrCount();
/*       */     
/*       */     List<? extends FleeHandler.FleeBtlReportOrBuilder> getBrOrBuilderList();
/*       */     
/*       */     FleeHandler.FleeBtlReportOrBuilder getBrOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface FleeBtlReportOrBuilder extends MessageOrBuilder {
/*       */     boolean hasRank();
/*       */     
/*       */     int getRank();
/*       */     
/*       */     boolean hasScoreChange();
/*       */     
/*       */     int getScoreChange();
/*       */     
/*       */     boolean hasCreateTime();
/*       */     
/*       */     String getCreateTime();
/*       */     
/*       */     ByteString getCreateTimeBytes();
/*       */   }
/*       */   
/*       */   public static interface FleeLookBtlReportRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface GetRewardResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface GetRewardRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasGradeId();
/*       */     
/*       */     int getGradeId();
/*       */   }
/*       */   
/*       */   public static interface FleeInfoResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasCurrentRank();
/*       */     
/*       */     int getCurrentRank();
/*       */     
/*       */     boolean hasMaxRank();
/*       */     
/*       */     int getMaxRank();
/*       */     
/*       */     boolean hasGrade();
/*       */     
/*       */     int getGrade();
/*       */     
/*       */     boolean hasMaxGrade();
/*       */     
/*       */     int getMaxGrade();
/*       */     
/*       */     boolean hasSeasonEndTime();
/*       */     
/*       */     long getSeasonEndTime();
/*       */     
/*       */     boolean hasScore();
/*       */     
/*       */     int getScore();
/*       */     
/*       */     List<FleeHandler.GradeReward> getGradeRewardsList();
/*       */     
/*       */     FleeHandler.GradeReward getGradeRewards(int param1Int);
/*       */     
/*       */     int getGradeRewardsCount();
/*       */     
/*       */     List<? extends FleeHandler.GradeRewardOrBuilder> getGradeRewardsOrBuilderList();
/*       */     
/*       */     FleeHandler.GradeRewardOrBuilder getGradeRewardsOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasJoinTime();
/*       */     
/*       */     int getJoinTime();
/*       */     
/*       */     boolean hasAvgMatchTime();
/*       */     
/*       */     int getAvgMatchTime();
/*       */   }
/*       */   
/*       */   public static interface GradeRewardOrBuilder extends MessageOrBuilder {
/*       */     boolean hasGradeId();
/*       */     
/*       */     int getGradeId();
/*       */     
/*       */     boolean hasStatus();
/*       */     
/*       */     int getStatus();
/*       */   }
/*       */   
/*       */   public static interface FleeInfoRequestOrBuilder extends MessageOrBuilder {}
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\FleeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */