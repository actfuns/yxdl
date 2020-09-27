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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class BloodHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetEquipedBloodsRequest
/*      */     extends GeneratedMessage
/*      */     implements GetEquipedBloodsRequestOrBuilder
/*      */   {
/*  496 */     private static final GetEquipedBloodsRequest defaultInstance = new GetEquipedBloodsRequest(true); private final UnknownFieldSet unknownFields; private GetEquipedBloodsRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetEquipedBloodsRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetEquipedBloodsRequest getDefaultInstance() { return defaultInstance; } public GetEquipedBloodsRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetEquipedBloodsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.playerId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetEquipedBloodsRequest.class, Builder.class); } public static Parser<GetEquipedBloodsRequest> PARSER = (Parser<GetEquipedBloodsRequest>)new AbstractParser<GetEquipedBloodsRequest>() { public BloodHandler.GetEquipedBloodsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.GetEquipedBloodsRequest(input, extensionRegistry); } }
/*  497 */     ; private int bitField0_; public static final int PLAYERID_FIELD_NUMBER = 1; private Object playerId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetEquipedBloodsRequest> getParserForType() { return PARSER; } public boolean hasPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getPlayerId() { Object ref = this.playerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.playerId_ = s;  return s; } public ByteString getPlayerIdBytes() { Object ref = this.playerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.playerId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
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
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getPlayerIdBytes());
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(data);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(data);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(InputStream input) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(input);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseDelimitedFrom(input);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(input);
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
/*      */     
/*      */     public static GetEquipedBloodsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     
/*      */     public static Builder newBuilder(GetEquipedBloodsRequest prototype) {
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
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements BloodHandler.GetEquipedBloodsRequestOrBuilder
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
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsRequest_descriptor;
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
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.GetEquipedBloodsRequest.class, Builder.class);
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
/*      */         if (BloodHandler.GetEquipedBloodsRequest.alwaysUseFieldBuilders);
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
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsRequest_descriptor;
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
/*      */       public BloodHandler.GetEquipedBloodsRequest getDefaultInstanceForType() {
/*      */         return BloodHandler.GetEquipedBloodsRequest.getDefaultInstance();
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
/*      */       public BloodHandler.GetEquipedBloodsRequest build() {
/*      */         BloodHandler.GetEquipedBloodsRequest result = buildPartial();
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
/*      */       
/*      */       public BloodHandler.GetEquipedBloodsRequest buildPartial() {
/*      */         BloodHandler.GetEquipedBloodsRequest result = new BloodHandler.GetEquipedBloodsRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.playerId_ = this.playerId_;
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
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.GetEquipedBloodsRequest) {
/*      */           return mergeFrom((BloodHandler.GetEquipedBloodsRequest)other);
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
/*      */       
/*      */       public Builder mergeFrom(BloodHandler.GetEquipedBloodsRequest other) {
/*      */         if (other == BloodHandler.GetEquipedBloodsRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasPlayerId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.playerId_ = other.playerId_;
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
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasPlayerId()) {
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
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.GetEquipedBloodsRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.GetEquipedBloodsRequest)BloodHandler.GetEquipedBloodsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.GetEquipedBloodsRequest)e.getUnfinishedMessage();
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
/*      */       
/*      */       public Builder clearPlayerId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.playerId_ = BloodHandler.GetEquipedBloodsRequest.getDefaultInstance().getPlayerId();
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
/*      */   
/*      */   public static final class GetEquipedBloodsResponse
/*      */     extends GeneratedMessage
/*      */     implements GetEquipedBloodsResponseOrBuilder
/*      */   {
/* 1213 */     private static final GetEquipedBloodsResponse defaultInstance = new GetEquipedBloodsResponse(true); private final UnknownFieldSet unknownFields; private GetEquipedBloodsResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetEquipedBloodsResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetEquipedBloodsResponse getDefaultInstance() { return defaultInstance; } public GetEquipedBloodsResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetEquipedBloodsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int length, limit, tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: if ((mutable_bitField0_ & 0x4) != 4) { this.bloodIds_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.bloodIds_.add(Integer.valueOf(input.readInt32())); break;case 26: length = input.readRawVarint32(); limit = input.pushLimit(length); if ((mutable_bitField0_ & 0x4) != 4 && input.getBytesUntilLimit() > 0) { this.bloodIds_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  while (input.getBytesUntilLimit() > 0) this.bloodIds_.add(Integer.valueOf(input.readInt32()));  input.popLimit(limit); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.bloodIds_ = Collections.unmodifiableList(this.bloodIds_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetEquipedBloodsResponse.class, Builder.class); } public static Parser<GetEquipedBloodsResponse> PARSER = (Parser<GetEquipedBloodsResponse>)new AbstractParser<GetEquipedBloodsResponse>() { public BloodHandler.GetEquipedBloodsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.GetEquipedBloodsResponse(input, extensionRegistry); } }
/* 1214 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int BLOODIDS_FIELD_NUMBER = 3; private List<Integer> bloodIds_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetEquipedBloodsResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*      */     public List<Integer> getBloodIdsList() {
/*      */       return this.bloodIds_;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getBloodIdsCount() {
/*      */       return this.bloodIds_.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public int getBloodIds(int index) {
/*      */       return ((Integer)this.bloodIds_.get(index)).intValue();
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.bloodIds_ = Collections.emptyList();
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
/*      */       for (int i = 0; i < this.bloodIds_.size(); i++) {
/*      */         output.writeInt32(3, ((Integer)this.bloodIds_.get(i)).intValue());
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
/*      */       int dataSize = 0;
/*      */       for (int i = 0; i < this.bloodIds_.size(); i++) {
/*      */         dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.bloodIds_.get(i)).intValue());
/*      */       }
/*      */       size += dataSize;
/*      */       size += 1 * getBloodIdsList().size();
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
/*      */     public static GetEquipedBloodsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(InputStream input) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetEquipedBloodsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetEquipedBloodsResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(GetEquipedBloodsResponse prototype) {
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
/*      */       implements BloodHandler.GetEquipedBloodsResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       
/*      */       private int s2CCode_;
/*      */       
/*      */       private Object s2CMsg_;
/*      */       
/*      */       private List<Integer> bloodIds_;
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.GetEquipedBloodsResponse.class, Builder.class);
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.bloodIds_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.bloodIds_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (BloodHandler.GetEquipedBloodsResponse.alwaysUseFieldBuilders);
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
/*      */         this.bloodIds_ = Collections.emptyList();
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
/*      */         return BloodHandler.internal_static_pomelo_area_GetEquipedBloodsResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.GetEquipedBloodsResponse getDefaultInstanceForType() {
/*      */         return BloodHandler.GetEquipedBloodsResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.GetEquipedBloodsResponse build() {
/*      */         BloodHandler.GetEquipedBloodsResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.GetEquipedBloodsResponse buildPartial() {
/*      */         BloodHandler.GetEquipedBloodsResponse result = new BloodHandler.GetEquipedBloodsResponse(this);
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
/*      */         if ((this.bitField0_ & 0x4) == 4) {
/*      */           this.bloodIds_ = Collections.unmodifiableList(this.bloodIds_);
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } 
/*      */         result.bloodIds_ = this.bloodIds_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.GetEquipedBloodsResponse) {
/*      */           return mergeFrom((BloodHandler.GetEquipedBloodsResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(BloodHandler.GetEquipedBloodsResponse other) {
/*      */         if (other == BloodHandler.GetEquipedBloodsResponse.getDefaultInstance()) {
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
/*      */         if (!other.bloodIds_.isEmpty()) {
/*      */           if (this.bloodIds_.isEmpty()) {
/*      */             this.bloodIds_ = other.bloodIds_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } else {
/*      */             ensureBloodIdsIsMutable();
/*      */             this.bloodIds_.addAll(other.bloodIds_);
/*      */           } 
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.GetEquipedBloodsResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.GetEquipedBloodsResponse)BloodHandler.GetEquipedBloodsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.GetEquipedBloodsResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
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
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
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
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = BloodHandler.GetEquipedBloodsResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
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
/*      */ 
/*      */       
/*      */       private void ensureBloodIdsIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.bloodIds_ = new ArrayList<>(this.bloodIds_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public List<Integer> getBloodIdsList() {
/*      */         return Collections.unmodifiableList(this.bloodIds_);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getBloodIdsCount() {
/*      */         return this.bloodIds_.size();
/*      */       }
/*      */ 
/*      */       
/*      */       public int getBloodIds(int index) {
/*      */         return ((Integer)this.bloodIds_.get(index)).intValue();
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setBloodIds(int index, int value) {
/*      */         ensureBloodIdsIsMutable();
/*      */         this.bloodIds_.set(index, Integer.valueOf(value));
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder addBloodIds(int value) {
/*      */         ensureBloodIdsIsMutable();
/*      */         this.bloodIds_.add(Integer.valueOf(value));
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder addAllBloodIds(Iterable<? extends Integer> values) {
/*      */         ensureBloodIdsIsMutable();
/*      */         AbstractMessageLite.Builder.addAll(values, this.bloodIds_);
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearBloodIds() {
/*      */         this.bloodIds_ = Collections.emptyList();
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static final class EquipBloodRequest
/*      */     extends GeneratedMessage
/*      */     implements EquipBloodRequestOrBuilder
/*      */   {
/* 1705 */     private static final EquipBloodRequest defaultInstance = new EquipBloodRequest(true); private final UnknownFieldSet unknownFields; private EquipBloodRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipBloodRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipBloodRequest getDefaultInstance() { return defaultInstance; } public EquipBloodRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipBloodRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.itemId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_EquipBloodRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_EquipBloodRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipBloodRequest.class, Builder.class); } public static Parser<EquipBloodRequest> PARSER = (Parser<EquipBloodRequest>)new AbstractParser<EquipBloodRequest>() { public BloodHandler.EquipBloodRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.EquipBloodRequest(input, extensionRegistry); } }
/* 1706 */     ; private int bitField0_; public static final int ITEMID_FIELD_NUMBER = 1; private Object itemId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipBloodRequest> getParserForType() { return PARSER; } public boolean hasItemId() { return ((this.bitField0_ & 0x1) == 1); } public String getItemId() { Object ref = this.itemId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.itemId_ = s;  return s; } public ByteString getItemIdBytes() { Object ref = this.itemId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.itemId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
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
/*      */       this.itemId_ = "";
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
/*      */       if (!hasItemId()) {
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
/*      */         output.writeBytes(1, getItemIdBytes());
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
/*      */         size += CodedOutputStream.computeBytesSize(1, getItemIdBytes());
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
/*      */     public static EquipBloodRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(InputStream input) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public static Builder newBuilder(EquipBloodRequest prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements BloodHandler.EquipBloodRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object itemId_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.EquipBloodRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.itemId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.itemId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (BloodHandler.EquipBloodRequest.alwaysUseFieldBuilders);
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.itemId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         return this;
/*      */       }
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public BloodHandler.EquipBloodRequest getDefaultInstanceForType() {
/*      */         return BloodHandler.EquipBloodRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public BloodHandler.EquipBloodRequest build() {
/*      */         BloodHandler.EquipBloodRequest result = buildPartial();
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
/*      */       public BloodHandler.EquipBloodRequest buildPartial() {
/*      */         BloodHandler.EquipBloodRequest result = new BloodHandler.EquipBloodRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.itemId_ = this.itemId_;
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.EquipBloodRequest) {
/*      */           return mergeFrom((BloodHandler.EquipBloodRequest)other);
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
/*      */       public Builder mergeFrom(BloodHandler.EquipBloodRequest other) {
/*      */         if (other == BloodHandler.EquipBloodRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasItemId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.itemId_ = other.itemId_;
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasItemId()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.EquipBloodRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.EquipBloodRequest)BloodHandler.EquipBloodRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.EquipBloodRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasItemId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getItemId() {
/*      */         Object ref = this.itemId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.itemId_ = s;
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
/*      */       public ByteString getItemIdBytes() {
/*      */         Object ref = this.itemId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.itemId_ = b;
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
/*      */       public Builder setItemId(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.itemId_ = value;
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
/*      */       public Builder clearItemId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.itemId_ = BloodHandler.EquipBloodRequest.getDefaultInstance().getItemId();
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
/*      */       public Builder setItemIdBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.itemId_ = value;
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
/*      */   public static final class EquipBloodResponse
/*      */     extends GeneratedMessage
/*      */     implements EquipBloodResponseOrBuilder
/*      */   {
/* 2267 */     private static final EquipBloodResponse defaultInstance = new EquipBloodResponse(true); private final UnknownFieldSet unknownFields; private EquipBloodResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipBloodResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipBloodResponse getDefaultInstance() { return defaultInstance; } public EquipBloodResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipBloodResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_EquipBloodResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_EquipBloodResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipBloodResponse.class, Builder.class); } public static Parser<EquipBloodResponse> PARSER = (Parser<EquipBloodResponse>)new AbstractParser<EquipBloodResponse>() { public BloodHandler.EquipBloodResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.EquipBloodResponse(input, extensionRegistry); } }
/* 2268 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipBloodResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(InputStream input) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static EquipBloodResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipBloodResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(EquipBloodResponse prototype) {
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
/*      */       implements BloodHandler.EquipBloodResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       
/*      */       private int s2CCode_;
/*      */       
/*      */       private Object s2CMsg_;
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.EquipBloodResponse.class, Builder.class);
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
/*      */         if (BloodHandler.EquipBloodResponse.alwaysUseFieldBuilders);
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
/*      */         return BloodHandler.internal_static_pomelo_area_EquipBloodResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.EquipBloodResponse getDefaultInstanceForType() {
/*      */         return BloodHandler.EquipBloodResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.EquipBloodResponse build() {
/*      */         BloodHandler.EquipBloodResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public BloodHandler.EquipBloodResponse buildPartial() {
/*      */         BloodHandler.EquipBloodResponse result = new BloodHandler.EquipBloodResponse(this);
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.EquipBloodResponse) {
/*      */           return mergeFrom((BloodHandler.EquipBloodResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(BloodHandler.EquipBloodResponse other) {
/*      */         if (other == BloodHandler.EquipBloodResponse.getDefaultInstance()) {
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.EquipBloodResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.EquipBloodResponse)BloodHandler.EquipBloodResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.EquipBloodResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
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
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
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
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = BloodHandler.EquipBloodResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
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
/*      */   public static final class UnequipBloodRequest
/*      */     extends GeneratedMessage
/*      */     implements UnequipBloodRequestOrBuilder
/*      */   {
/* 2680 */     private static final UnequipBloodRequest defaultInstance = new UnequipBloodRequest(true); private final UnknownFieldSet unknownFields; private UnequipBloodRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnequipBloodRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnequipBloodRequest getDefaultInstance() { return defaultInstance; } public UnequipBloodRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnequipBloodRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.sortId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_UnequipBloodRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_UnequipBloodRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UnequipBloodRequest.class, Builder.class); } public static Parser<UnequipBloodRequest> PARSER = (Parser<UnequipBloodRequest>)new AbstractParser<UnequipBloodRequest>() { public BloodHandler.UnequipBloodRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.UnequipBloodRequest(input, extensionRegistry); } }; private int bitField0_; public static final int SORTID_FIELD_NUMBER = 1; private int sortId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnequipBloodRequest> getParserForType() { return PARSER; } public boolean hasSortId() { return ((this.bitField0_ & 0x1) == 1); } public int getSortId() { return this.sortId_; } private void initFields() { this.sortId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasSortId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.sortId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.sortId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UnequipBloodRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UnequipBloodRequest)PARSER.parseFrom(data); } public static UnequipBloodRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnequipBloodRequest)PARSER.parseFrom(data, extensionRegistry); } public static UnequipBloodRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UnequipBloodRequest)PARSER.parseFrom(data); } public static UnequipBloodRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnequipBloodRequest)PARSER.parseFrom(data, extensionRegistry); } public static UnequipBloodRequest parseFrom(InputStream input) throws IOException { return (UnequipBloodRequest)PARSER.parseFrom(input); } public static UnequipBloodRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnequipBloodRequest)PARSER.parseFrom(input, extensionRegistry); } public static UnequipBloodRequest parseDelimitedFrom(InputStream input) throws IOException { return (UnequipBloodRequest)PARSER.parseDelimitedFrom(input); } public static UnequipBloodRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnequipBloodRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnequipBloodRequest parseFrom(CodedInputStream input) throws IOException { return (UnequipBloodRequest)PARSER.parseFrom(input); } public static UnequipBloodRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnequipBloodRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnequipBloodRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements BloodHandler.UnequipBloodRequestOrBuilder {
/* 2681 */       private int bitField0_; private int sortId_; public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_UnequipBloodRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_UnequipBloodRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.UnequipBloodRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (BloodHandler.UnequipBloodRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.sortId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return BloodHandler.internal_static_pomelo_area_UnequipBloodRequest_descriptor; } public BloodHandler.UnequipBloodRequest getDefaultInstanceForType() { return BloodHandler.UnequipBloodRequest.getDefaultInstance(); } public BloodHandler.UnequipBloodRequest build() { BloodHandler.UnequipBloodRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public BloodHandler.UnequipBloodRequest buildPartial() { BloodHandler.UnequipBloodRequest result = new BloodHandler.UnequipBloodRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.sortId_ = this.sortId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof BloodHandler.UnequipBloodRequest) return mergeFrom((BloodHandler.UnequipBloodRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(BloodHandler.UnequipBloodRequest other) { if (other == BloodHandler.UnequipBloodRequest.getDefaultInstance()) return this;  if (other.hasSortId()) setSortId(other.getSortId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasSortId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { BloodHandler.UnequipBloodRequest parsedMessage = null; try { parsedMessage = (BloodHandler.UnequipBloodRequest)BloodHandler.UnequipBloodRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (BloodHandler.UnequipBloodRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasSortId() { return ((this.bitField0_ & 0x1) == 1); } public int getSortId() { return this.sortId_; } public Builder setSortId(int value) { this.bitField0_ |= 0x1; this.sortId_ = value; onChanged(); return this; } public Builder clearSortId() { this.bitField0_ &= 0xFFFFFFFE; this.sortId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class UnequipBloodResponse
/*      */     extends GeneratedMessage
/*      */     implements UnequipBloodResponseOrBuilder
/*      */   {
/* 3242 */     private static final UnequipBloodResponse defaultInstance = new UnequipBloodResponse(true); private final UnknownFieldSet unknownFields; private UnequipBloodResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnequipBloodResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnequipBloodResponse getDefaultInstance() { return defaultInstance; } public UnequipBloodResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnequipBloodResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_UnequipBloodResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_UnequipBloodResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UnequipBloodResponse.class, Builder.class); } public static Parser<UnequipBloodResponse> PARSER = (Parser<UnequipBloodResponse>)new AbstractParser<UnequipBloodResponse>() { public BloodHandler.UnequipBloodResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.UnequipBloodResponse(input, extensionRegistry); } }
/* 3243 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnequipBloodResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(InputStream input) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static UnequipBloodResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UnequipBloodResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(UnequipBloodResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements BloodHandler.UnequipBloodResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int s2CCode_;
/*      */ 
/*      */ 
/*      */       
/*      */       private Object s2CMsg_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_UnequipBloodResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_UnequipBloodResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.UnequipBloodResponse.class, Builder.class);
/*      */       }
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
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (BloodHandler.UnequipBloodResponse.alwaysUseFieldBuilders);
/*      */       }
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
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return BloodHandler.internal_static_pomelo_area_UnequipBloodResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public BloodHandler.UnequipBloodResponse getDefaultInstanceForType() {
/*      */         return BloodHandler.UnequipBloodResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public BloodHandler.UnequipBloodResponse build() {
/*      */         BloodHandler.UnequipBloodResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public BloodHandler.UnequipBloodResponse buildPartial() {
/*      */         BloodHandler.UnequipBloodResponse result = new BloodHandler.UnequipBloodResponse(this);
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.UnequipBloodResponse) {
/*      */           return mergeFrom((BloodHandler.UnequipBloodResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(BloodHandler.UnequipBloodResponse other) {
/*      */         if (other == BloodHandler.UnequipBloodResponse.getDefaultInstance()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.UnequipBloodResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.UnequipBloodResponse)BloodHandler.UnequipBloodResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.UnequipBloodResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
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
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
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
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = BloodHandler.UnequipBloodResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
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
/*      */   public static final class BloodAttr
/*      */     extends GeneratedMessage
/*      */     implements BloodAttrOrBuilder
/*      */   {
/* 3741 */     private static final BloodAttr defaultInstance = new BloodAttr(true); private final UnknownFieldSet unknownFields; private BloodAttr(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private BloodAttr(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static BloodAttr getDefaultInstance() { return defaultInstance; } public BloodAttr getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private BloodAttr(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.value_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_BloodAttr_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_BloodAttr_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodAttr.class, Builder.class); } public static Parser<BloodAttr> PARSER = (Parser<BloodAttr>)new AbstractParser<BloodAttr>() { public BloodHandler.BloodAttr parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.BloodAttr(input, extensionRegistry); } }
/* 3742 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int VALUE_FIELD_NUMBER = 2; private int value_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<BloodAttr> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasValue() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getValue() {
/*      */       return this.value_;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.id_ = 0;
/*      */       this.value_ = 0;
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
/*      */       if (!hasId()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.id_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.value_);
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.id_);
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (BloodAttr)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (BloodAttr)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (BloodAttr)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (BloodAttr)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(InputStream input) throws IOException {
/*      */       return (BloodAttr)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (BloodAttr)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (BloodAttr)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (BloodAttr)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(CodedInputStream input) throws IOException {
/*      */       return (BloodAttr)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static BloodAttr parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (BloodAttr)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(BloodAttr prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements BloodHandler.BloodAttrOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       private int id_;
/*      */       private int value_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return BloodHandler.internal_static_pomelo_area_BloodAttr_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return BloodHandler.internal_static_pomelo_area_BloodAttr_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.BloodAttr.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (BloodHandler.BloodAttr.alwaysUseFieldBuilders);
/*      */       }
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.id_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.value_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return BloodHandler.internal_static_pomelo_area_BloodAttr_descriptor;
/*      */       }
/*      */       
/*      */       public BloodHandler.BloodAttr getDefaultInstanceForType() {
/*      */         return BloodHandler.BloodAttr.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public BloodHandler.BloodAttr build() {
/*      */         BloodHandler.BloodAttr result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */       
/*      */       public BloodHandler.BloodAttr buildPartial() {
/*      */         BloodHandler.BloodAttr result = new BloodHandler.BloodAttr(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.id_ = this.id_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.value_ = this.value_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof BloodHandler.BloodAttr) {
/*      */           return mergeFrom((BloodHandler.BloodAttr)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(BloodHandler.BloodAttr other) {
/*      */         if (other == BloodHandler.BloodAttr.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasId()) {
/*      */           setId(other.getId());
/*      */         }
/*      */         if (other.hasValue()) {
/*      */           setValue(other.getValue());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasValue()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         BloodHandler.BloodAttr parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (BloodHandler.BloodAttr)BloodHandler.BloodAttr.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (BloodHandler.BloodAttr)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public int getId() {
/*      */         return this.id_;
/*      */       }
/*      */       
/*      */       public Builder setId(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.id_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.id_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasValue() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
/*      */       public int getValue() {
/*      */         return this.value_;
/*      */       }
/*      */       
/*      */       public Builder setValue(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.value_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
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
/*      */   public static final class GetBloodAttrsRequest
/*      */     extends GeneratedMessage
/*      */     implements GetBloodAttrsRequestOrBuilder
/*      */   {
/* 4062 */     private static final GetBloodAttrsRequest defaultInstance = new GetBloodAttrsRequest(true); private final UnknownFieldSet unknownFields; private GetBloodAttrsRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetBloodAttrsRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetBloodAttrsRequest getDefaultInstance() { return defaultInstance; } public GetBloodAttrsRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetBloodAttrsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBloodAttrsRequest.class, Builder.class); } public static Parser<GetBloodAttrsRequest> PARSER = (Parser<GetBloodAttrsRequest>)new AbstractParser<GetBloodAttrsRequest>() { public BloodHandler.GetBloodAttrsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.GetBloodAttrsRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetBloodAttrsRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetBloodAttrsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetBloodAttrsRequest)PARSER.parseFrom(data); } public static GetBloodAttrsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetBloodAttrsRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetBloodAttrsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetBloodAttrsRequest)PARSER.parseFrom(data); } public static GetBloodAttrsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetBloodAttrsRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetBloodAttrsRequest parseFrom(InputStream input) throws IOException { return (GetBloodAttrsRequest)PARSER.parseFrom(input); } public static GetBloodAttrsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetBloodAttrsRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetBloodAttrsRequest)PARSER.parseDelimitedFrom(input); } public static GetBloodAttrsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetBloodAttrsRequest parseFrom(CodedInputStream input) throws IOException { return (GetBloodAttrsRequest)PARSER.parseFrom(input); } public static GetBloodAttrsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetBloodAttrsRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements BloodHandler.GetBloodAttrsRequestOrBuilder {
/* 4063 */       public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.GetBloodAttrsRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (BloodHandler.GetBloodAttrsRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsRequest_descriptor; } public BloodHandler.GetBloodAttrsRequest getDefaultInstanceForType() { return BloodHandler.GetBloodAttrsRequest.getDefaultInstance(); } public BloodHandler.GetBloodAttrsRequest build() { BloodHandler.GetBloodAttrsRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public BloodHandler.GetBloodAttrsRequest buildPartial() { BloodHandler.GetBloodAttrsRequest result = new BloodHandler.GetBloodAttrsRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof BloodHandler.GetBloodAttrsRequest) return mergeFrom((BloodHandler.GetBloodAttrsRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(BloodHandler.GetBloodAttrsRequest other) { if (other == BloodHandler.GetBloodAttrsRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { BloodHandler.GetBloodAttrsRequest parsedMessage = null; try { parsedMessage = (BloodHandler.GetBloodAttrsRequest)BloodHandler.GetBloodAttrsRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (BloodHandler.GetBloodAttrsRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetBloodAttrsResponse
/*      */     extends GeneratedMessage
/*      */     implements GetBloodAttrsResponseOrBuilder
/*      */   {
/* 4996 */     private static final GetBloodAttrsResponse defaultInstance = new GetBloodAttrsResponse(true); private final UnknownFieldSet unknownFields; private GetBloodAttrsResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetBloodAttrsResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetBloodAttrsResponse getDefaultInstance() { return defaultInstance; } public GetBloodAttrsResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetBloodAttrsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.bloodAttrs_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.bloodAttrs_.add(input.readMessage(BloodHandler.BloodAttr.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.bloodAttrs_ = Collections.unmodifiableList(this.bloodAttrs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBloodAttrsResponse.class, Builder.class); } public static Parser<GetBloodAttrsResponse> PARSER = (Parser<GetBloodAttrsResponse>)new AbstractParser<GetBloodAttrsResponse>() { public BloodHandler.GetBloodAttrsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new BloodHandler.GetBloodAttrsResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int BLOODATTRS_FIELD_NUMBER = 3; private List<BloodHandler.BloodAttr> bloodAttrs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetBloodAttrsResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<BloodHandler.BloodAttr> getBloodAttrsList() { return this.bloodAttrs_; } public List<? extends BloodHandler.BloodAttrOrBuilder> getBloodAttrsOrBuilderList() { return (List)this.bloodAttrs_; } public int getBloodAttrsCount() { return this.bloodAttrs_.size(); } public BloodHandler.BloodAttr getBloodAttrs(int index) { return this.bloodAttrs_.get(index); } public BloodHandler.BloodAttrOrBuilder getBloodAttrsOrBuilder(int index) { return this.bloodAttrs_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.bloodAttrs_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getBloodAttrsCount(); i++) { if (!getBloodAttrs(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  for (int i = 0; i < this.bloodAttrs_.size(); i++) output.writeMessage(3, (MessageLite)this.bloodAttrs_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  for (int i = 0; i < this.bloodAttrs_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.bloodAttrs_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetBloodAttrsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetBloodAttrsResponse)PARSER.parseFrom(data); } public static GetBloodAttrsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetBloodAttrsResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetBloodAttrsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetBloodAttrsResponse)PARSER.parseFrom(data); } public static GetBloodAttrsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetBloodAttrsResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetBloodAttrsResponse parseFrom(InputStream input) throws IOException { return (GetBloodAttrsResponse)PARSER.parseFrom(input); } public static GetBloodAttrsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetBloodAttrsResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetBloodAttrsResponse)PARSER.parseDelimitedFrom(input); } public static GetBloodAttrsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetBloodAttrsResponse parseFrom(CodedInputStream input) throws IOException { return (GetBloodAttrsResponse)PARSER.parseFrom(input); } public static GetBloodAttrsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetBloodAttrsResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetBloodAttrsResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements BloodHandler.GetBloodAttrsResponseOrBuilder {
/* 4997 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<BloodHandler.BloodAttr> bloodAttrs_; private RepeatedFieldBuilder<BloodHandler.BloodAttr, BloodHandler.BloodAttr.Builder, BloodHandler.BloodAttrOrBuilder> bloodAttrsBuilder_; public static final Descriptors.Descriptor getDescriptor() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BloodHandler.GetBloodAttrsResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.bloodAttrs_ = Collections.emptyList(); maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.bloodAttrs_ = Collections.emptyList(); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (BloodHandler.GetBloodAttrsResponse.alwaysUseFieldBuilders) getBloodAttrsFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.bloodAttrsBuilder_ == null) { this.bloodAttrs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.bloodAttrsBuilder_.clear(); }  return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return BloodHandler.internal_static_pomelo_area_GetBloodAttrsResponse_descriptor; } public BloodHandler.GetBloodAttrsResponse getDefaultInstanceForType() { return BloodHandler.GetBloodAttrsResponse.getDefaultInstance(); } public BloodHandler.GetBloodAttrsResponse build() { BloodHandler.GetBloodAttrsResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public BloodHandler.GetBloodAttrsResponse buildPartial() { BloodHandler.GetBloodAttrsResponse result = new BloodHandler.GetBloodAttrsResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.bloodAttrsBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.bloodAttrs_ = Collections.unmodifiableList(this.bloodAttrs_); this.bitField0_ &= 0xFFFFFFFB; }  result.bloodAttrs_ = this.bloodAttrs_; } else { result.bloodAttrs_ = this.bloodAttrsBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof BloodHandler.GetBloodAttrsResponse) return mergeFrom((BloodHandler.GetBloodAttrsResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(BloodHandler.GetBloodAttrsResponse other) { if (other == BloodHandler.GetBloodAttrsResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (this.bloodAttrsBuilder_ == null) { if (!other.bloodAttrs_.isEmpty()) { if (this.bloodAttrs_.isEmpty()) { this.bloodAttrs_ = other.bloodAttrs_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureBloodAttrsIsMutable(); this.bloodAttrs_.addAll(other.bloodAttrs_); }  onChanged(); }  } else if (!other.bloodAttrs_.isEmpty()) { if (this.bloodAttrsBuilder_.isEmpty()) { this.bloodAttrsBuilder_.dispose(); this.bloodAttrsBuilder_ = null; this.bloodAttrs_ = other.bloodAttrs_; this.bitField0_ &= 0xFFFFFFFB; this.bloodAttrsBuilder_ = BloodHandler.GetBloodAttrsResponse.alwaysUseFieldBuilders ? getBloodAttrsFieldBuilder() : null; } else { this.bloodAttrsBuilder_.addAllMessages(other.bloodAttrs_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  for (int i = 0; i < getBloodAttrsCount(); i++) { if (!getBloodAttrs(i).isInitialized()) return false;  }  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { BloodHandler.GetBloodAttrsResponse parsedMessage = null; try { parsedMessage = (BloodHandler.GetBloodAttrsResponse)BloodHandler.GetBloodAttrsResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (BloodHandler.GetBloodAttrsResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = BloodHandler.GetBloodAttrsResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } private void ensureBloodAttrsIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.bloodAttrs_ = new ArrayList<>(this.bloodAttrs_); this.bitField0_ |= 0x4; }  } public List<BloodHandler.BloodAttr> getBloodAttrsList() { if (this.bloodAttrsBuilder_ == null) return Collections.unmodifiableList(this.bloodAttrs_);  return this.bloodAttrsBuilder_.getMessageList(); } public int getBloodAttrsCount() { if (this.bloodAttrsBuilder_ == null) return this.bloodAttrs_.size();  return this.bloodAttrsBuilder_.getCount(); } public BloodHandler.BloodAttr getBloodAttrs(int index) { if (this.bloodAttrsBuilder_ == null) return this.bloodAttrs_.get(index);  return (BloodHandler.BloodAttr)this.bloodAttrsBuilder_.getMessage(index); } public Builder setBloodAttrs(int index, BloodHandler.BloodAttr value) { if (this.bloodAttrsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureBloodAttrsIsMutable(); this.bloodAttrs_.set(index, value); onChanged(); } else { this.bloodAttrsBuilder_.setMessage(index, value); }  return this; } public Builder setBloodAttrs(int index, BloodHandler.BloodAttr.Builder builderForValue) { if (this.bloodAttrsBuilder_ == null) { ensureBloodAttrsIsMutable(); this.bloodAttrs_.set(index, builderForValue.build()); onChanged(); } else { this.bloodAttrsBuilder_.setMessage(index, builderForValue.build()); }  return this; } public Builder addBloodAttrs(BloodHandler.BloodAttr value) { if (this.bloodAttrsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureBloodAttrsIsMutable(); this.bloodAttrs_.add(value); onChanged(); } else { this.bloodAttrsBuilder_.addMessage(value); }  return this; } public Builder addBloodAttrs(int index, BloodHandler.BloodAttr value) { if (this.bloodAttrsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureBloodAttrsIsMutable(); this.bloodAttrs_.add(index, value); onChanged(); } else { this.bloodAttrsBuilder_.addMessage(index, value); }  return this; } public Builder addBloodAttrs(BloodHandler.BloodAttr.Builder builderForValue) { if (this.bloodAttrsBuilder_ == null) { ensureBloodAttrsIsMutable(); this.bloodAttrs_.add(builderForValue.build()); onChanged(); } else { this.bloodAttrsBuilder_.addMessage(builderForValue.build()); }  return this; } public Builder addBloodAttrs(int index, BloodHandler.BloodAttr.Builder builderForValue) { if (this.bloodAttrsBuilder_ == null) { ensureBloodAttrsIsMutable(); this.bloodAttrs_.add(index, builderForValue.build()); onChanged(); } else { this.bloodAttrsBuilder_.addMessage(index, builderForValue.build()); }  return this; } public Builder addAllBloodAttrs(Iterable<? extends BloodHandler.BloodAttr> values) { if (this.bloodAttrsBuilder_ == null) { ensureBloodAttrsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.bloodAttrs_); onChanged(); } else { this.bloodAttrsBuilder_.addAllMessages(values); }  return this; } public Builder clearBloodAttrs() { if (this.bloodAttrsBuilder_ == null) { this.bloodAttrs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); } else { this.bloodAttrsBuilder_.clear(); }  return this; } public Builder removeBloodAttrs(int index) { if (this.bloodAttrsBuilder_ == null) { ensureBloodAttrsIsMutable(); this.bloodAttrs_.remove(index); onChanged(); } else { this.bloodAttrsBuilder_.remove(index); }  return this; } public BloodHandler.BloodAttr.Builder getBloodAttrsBuilder(int index) { return (BloodHandler.BloodAttr.Builder)getBloodAttrsFieldBuilder().getBuilder(index); } public BloodHandler.BloodAttrOrBuilder getBloodAttrsOrBuilder(int index) { if (this.bloodAttrsBuilder_ == null) return this.bloodAttrs_.get(index);  return (BloodHandler.BloodAttrOrBuilder)this.bloodAttrsBuilder_.getMessageOrBuilder(index); } public List<? extends BloodHandler.BloodAttrOrBuilder> getBloodAttrsOrBuilderList() { if (this.bloodAttrsBuilder_ != null) return this.bloodAttrsBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.bloodAttrs_); } public BloodHandler.BloodAttr.Builder addBloodAttrsBuilder() { return (BloodHandler.BloodAttr.Builder)getBloodAttrsFieldBuilder().addBuilder(BloodHandler.BloodAttr.getDefaultInstance()); } public BloodHandler.BloodAttr.Builder addBloodAttrsBuilder(int index) { return (BloodHandler.BloodAttr.Builder)getBloodAttrsFieldBuilder().addBuilder(index, BloodHandler.BloodAttr.getDefaultInstance()); } public List<BloodHandler.BloodAttr.Builder> getBloodAttrsBuilderList() { return getBloodAttrsFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<BloodHandler.BloodAttr, BloodHandler.BloodAttr.Builder, BloodHandler.BloodAttrOrBuilder> getBloodAttrsFieldBuilder() { if (this.bloodAttrsBuilder_ == null) { this.bloodAttrsBuilder_ = new RepeatedFieldBuilder(this.bloodAttrs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.bloodAttrs_ = null; }  return this.bloodAttrsBuilder_; } } static { defaultInstance.initFields(); }
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
/*      */   public static Descriptors.FileDescriptor getDescriptor() {
/* 5051 */     return descriptor;
/*      */   }
/*      */ 
/*      */   
/*      */   static {
/* 5056 */     String[] descriptorData = { "\n\022bloodHandler.proto\022\013pomelo.area\"+\n\027GetEquipedBloodsRequest\022\020\n\bplayerId\030\001 \002(\t\"O\n\030GetEquipedBloodsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bbloodIds\030\003 \003(\005\"#\n\021EquipBloodRequest\022\016\n\006itemId\030\001 \002(\t\"7\n\022EquipBloodResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"%\n\023UnequipBloodRequest\022\016\n\006sortId\030\001 \002(\005\"9\n\024UnequipBloodResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"&\n\tBloodAttr\022\n\n\002id\030\001 \002(\005\022\r\n\005value\030\002 \002(\005\"\026\n\024GetBl", "oodAttrsRequest\"f\n\025GetBloodAttrsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\nbloodAttrs\030\003 \003(\0132\026.pomelo.area.BloodAttr2\003\n\fbloodHandler\022f\n\027getEquipedBloodsRequest\022$.pomelo.area.GetEquipedBloodsRequest\032%.pomelo.area.GetEquipedBloodsResponse\022T\n\021equipBloodRequest\022\036.pomelo.area.EquipBloodRequest\032\037.pomelo.area.EquipBloodResponse\022Z\n\023unequipBloodRequest\022 .pomelo.area.UnequipBloodRequest\032!.pomelo.area.Un", "equipBloodResponse\022]\n\024getBloodAttrsRequest\022!.pomelo.area.GetBloodAttrsRequest\032\".pomelo.area.GetBloodAttrsResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5081 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 5085 */           BloodHandler.descriptor = root;
/* 5086 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 5090 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*      */   }
/*      */ 
/*      */   
/* 5094 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetEquipedBloodsRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 5095 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetEquipedBloodsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetEquipedBloodsRequest_descriptor, new String[] { "PlayerId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5100 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetEquipedBloodsResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 5101 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetEquipedBloodsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetEquipedBloodsResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "BloodIds" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5106 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipBloodRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 5107 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipBloodRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipBloodRequest_descriptor, new String[] { "ItemId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5112 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipBloodResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 5113 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipBloodResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipBloodResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5118 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnequipBloodRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 5119 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnequipBloodRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnequipBloodRequest_descriptor, new String[] { "SortId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5124 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnequipBloodResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 5125 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnequipBloodResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnequipBloodResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5130 */   private static final Descriptors.Descriptor internal_static_pomelo_area_BloodAttr_descriptor = getDescriptor().getMessageTypes().get(6);
/* 5131 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BloodAttr_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BloodAttr_descriptor, new String[] { "Id", "Value" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5136 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetBloodAttrsRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 5137 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetBloodAttrsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetBloodAttrsRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5142 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetBloodAttrsResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 5143 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetBloodAttrsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetBloodAttrsResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "BloodAttrs" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   public static interface GetBloodAttrsResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<BloodHandler.BloodAttr> getBloodAttrsList();
/*      */     
/*      */     BloodHandler.BloodAttr getBloodAttrs(int param1Int);
/*      */     
/*      */     int getBloodAttrsCount();
/*      */     
/*      */     List<? extends BloodHandler.BloodAttrOrBuilder> getBloodAttrsOrBuilderList();
/*      */     
/*      */     BloodHandler.BloodAttrOrBuilder getBloodAttrsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GetBloodAttrsRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface BloodAttrOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasValue();
/*      */     
/*      */     int getValue();
/*      */   }
/*      */   
/*      */   public static interface UnequipBloodResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface UnequipBloodRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasSortId();
/*      */     
/*      */     int getSortId();
/*      */   }
/*      */   
/*      */   public static interface EquipBloodResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface EquipBloodRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasItemId();
/*      */     
/*      */     String getItemId();
/*      */     
/*      */     ByteString getItemIdBytes();
/*      */   }
/*      */   
/*      */   public static interface GetEquipedBloodsResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<Integer> getBloodIdsList();
/*      */     
/*      */     int getBloodIdsCount();
/*      */     
/*      */     int getBloodIds(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GetEquipedBloodsRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasPlayerId();
/*      */     
/*      */     String getPlayerId();
/*      */     
/*      */     ByteString getPlayerIdBytes();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\BloodHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */