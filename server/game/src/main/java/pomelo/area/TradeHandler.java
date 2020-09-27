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
/*       */ import com.google.protobuf.SingleFieldBuilder;
/*       */ import com.google.protobuf.UnknownFieldSet;
/*       */ import java.io.IOException;
/*       */ import java.io.InputStream;
/*       */ import java.io.ObjectStreamException;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Collections;
/*       */ import java.util.List;
/*       */ import pomelo.Common;
/*       */ import pomelo.item.ItemOuterClass;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class TradeHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class InviteRequest
/*       */     extends GeneratedMessage
/*       */     implements InviteRequestOrBuilder
/*       */   {
/*   544 */     private static final InviteRequest defaultInstance = new InviteRequest(true); private final UnknownFieldSet unknownFields; private InviteRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private InviteRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static InviteRequest getDefaultInstance() { return defaultInstance; } public InviteRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private InviteRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SPlayerId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_InviteRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_InviteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InviteRequest.class, Builder.class); } public static Parser<InviteRequest> PARSER = (Parser<InviteRequest>)new AbstractParser<InviteRequest>() { public TradeHandler.InviteRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.InviteRequest(input, extensionRegistry); } }
/*   545 */     ; private int bitField0_; public static final int C2S_PLAYERID_FIELD_NUMBER = 1; private Object c2SPlayerId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<InviteRequest> getParserForType() { return PARSER; } public boolean hasC2SPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SPlayerId() { Object ref = this.c2SPlayerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SPlayerId_ = s;  return s; } public ByteString getC2SPlayerIdBytes() { Object ref = this.c2SPlayerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SPlayerId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
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
/*       */       this.c2SPlayerId_ = "";
/*       */     }
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
/*       */       if (!hasC2SPlayerId()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getC2SPlayerIdBytes());
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeBytesSize(1, getC2SPlayerIdBytes());
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
/*       */     public static InviteRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (InviteRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (InviteRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (InviteRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (InviteRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(InputStream input) throws IOException {
/*       */       return (InviteRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (InviteRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (InviteRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static InviteRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public static Builder newBuilder(InviteRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements TradeHandler.InviteRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SPlayerId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_InviteRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_InviteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.InviteRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SPlayerId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SPlayerId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.InviteRequest.alwaysUseFieldBuilders);
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SPlayerId_ = "";
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_InviteRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.InviteRequest getDefaultInstanceForType() {
/*       */         return TradeHandler.InviteRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.InviteRequest build() {
/*       */         TradeHandler.InviteRequest result = buildPartial();
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
/*       */       public TradeHandler.InviteRequest buildPartial() {
/*       */         TradeHandler.InviteRequest result = new TradeHandler.InviteRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SPlayerId_ = this.c2SPlayerId_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.InviteRequest) {
/*       */           return mergeFrom((TradeHandler.InviteRequest)other);
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
/*       */       public Builder mergeFrom(TradeHandler.InviteRequest other) {
/*       */         if (other == TradeHandler.InviteRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SPlayerId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.c2SPlayerId_ = other.c2SPlayerId_;
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SPlayerId()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.InviteRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.InviteRequest)TradeHandler.InviteRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.InviteRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SPlayerId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SPlayerId() {
/*       */         Object ref = this.c2SPlayerId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SPlayerId_ = s;
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
/*       */       public ByteString getC2SPlayerIdBytes() {
/*       */         Object ref = this.c2SPlayerId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SPlayerId_ = b;
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
/*       */       public Builder setC2SPlayerId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SPlayerId_ = value;
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
/*       */       public Builder clearC2SPlayerId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SPlayerId_ = TradeHandler.InviteRequest.getDefaultInstance().getC2SPlayerId();
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
/*       */       public Builder setC2SPlayerIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SPlayerId_ = value;
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
/*       */   public static final class InviteResponse
/*       */     extends GeneratedMessage
/*       */     implements InviteResponseOrBuilder
/*       */   {
/*  1106 */     private static final InviteResponse defaultInstance = new InviteResponse(true); private final UnknownFieldSet unknownFields; private InviteResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private InviteResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static InviteResponse getDefaultInstance() { return defaultInstance; } public InviteResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private InviteResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_InviteResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_InviteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InviteResponse.class, Builder.class); } public static Parser<InviteResponse> PARSER = (Parser<InviteResponse>)new AbstractParser<InviteResponse>() { public TradeHandler.InviteResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.InviteResponse(input, extensionRegistry); } }
/*  1107 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<InviteResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
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
/*       */     public static InviteResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (InviteResponse)PARSER.parseFrom(data);
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
/*       */     public static InviteResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (InviteResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static InviteResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (InviteResponse)PARSER.parseFrom(data);
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
/*       */     public static InviteResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (InviteResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static InviteResponse parseFrom(InputStream input) throws IOException {
/*       */       return (InviteResponse)PARSER.parseFrom(input);
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
/*       */     public static InviteResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static InviteResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (InviteResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static InviteResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static InviteResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (InviteResponse)PARSER.parseFrom(input);
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
/*       */     public static InviteResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (InviteResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(InviteResponse prototype) {
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
/*       */       implements TradeHandler.InviteResponseOrBuilder
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
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_InviteResponse_descriptor;
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
/*       */         return TradeHandler.internal_static_pomelo_area_InviteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.InviteResponse.class, Builder.class);
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.InviteResponse.alwaysUseFieldBuilders);
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
/*       */         return TradeHandler.internal_static_pomelo_area_InviteResponse_descriptor;
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
/*       */       public TradeHandler.InviteResponse getDefaultInstanceForType() {
/*       */         return TradeHandler.InviteResponse.getDefaultInstance();
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
/*       */       public TradeHandler.InviteResponse build() {
/*       */         TradeHandler.InviteResponse result = buildPartial();
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
/*       */       public TradeHandler.InviteResponse buildPartial() {
/*       */         TradeHandler.InviteResponse result = new TradeHandler.InviteResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.InviteResponse) {
/*       */           return mergeFrom((TradeHandler.InviteResponse)other);
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
/*       */       public Builder mergeFrom(TradeHandler.InviteResponse other) {
/*       */         if (other == TradeHandler.InviteResponse.getDefaultInstance()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.InviteResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.InviteResponse)TradeHandler.InviteResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.InviteResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = TradeHandler.InviteResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class TradeItem
/*       */     extends GeneratedMessage
/*       */     implements TradeItemOrBuilder
/*       */   {
/*  1874 */     private static final TradeItem defaultInstance = new TradeItem(true); private final UnknownFieldSet unknownFields; private TradeItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeItem getDefaultInstance() { return defaultInstance; } public TradeItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.index_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.id_ = bs; break;case 24: this.bitField0_ |= 0x4; this.num_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeItem.class, Builder.class); } public static Parser<TradeItem> PARSER = (Parser<TradeItem>)new AbstractParser<TradeItem>() { public TradeHandler.TradeItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeItem(input, extensionRegistry); } }
/*  1875 */     ; private int bitField0_; public static final int INDEX_FIELD_NUMBER = 1; private int index_; public static final int ID_FIELD_NUMBER = 2; private Object id_; public static final int NUM_FIELD_NUMBER = 3; private int num_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeItem> getParserForType() { return PARSER; } public boolean hasIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getIndex() { return this.index_; } public boolean hasId() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getId() {
/*       */       Object ref = this.id_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.id_ = s;
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
/*       */     public ByteString getIdBytes() {
/*       */       Object ref = this.id_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.id_ = b;
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
/*       */     public boolean hasNum() {
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
/*       */     public int getNum() {
/*       */       return this.num_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.index_ = 0;
/*       */       this.id_ = "";
/*       */       this.num_ = 0;
/*       */     }
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
/*       */       if (!hasIndex()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasNum()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.index_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.num_);
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.index_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.num_);
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
/*       */     public static TradeItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(InputStream input) throws IOException {
/*       */       return (TradeItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeItem)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public static Builder newBuilder(TradeItem prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements TradeHandler.TradeItemOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int index_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object id_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int num_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeItem.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.id_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.id_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeItem.alwaysUseFieldBuilders);
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.index_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.num_ = 0;
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeItem.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem build() {
/*       */         TradeHandler.TradeItem result = buildPartial();
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
/*       */       public TradeHandler.TradeItem buildPartial() {
/*       */         TradeHandler.TradeItem result = new TradeHandler.TradeItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.index_ = this.index_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.num_ = this.num_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeItem) {
/*       */           return mergeFrom((TradeHandler.TradeItem)other);
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
/*       */       public Builder mergeFrom(TradeHandler.TradeItem other) {
/*       */         if (other == TradeHandler.TradeItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasIndex()) {
/*       */           setIndex(other.getIndex());
/*       */         }
/*       */         if (other.hasId()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.id_ = other.id_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasNum()) {
/*       */           setNum(other.getNum());
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasIndex()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasNum()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradeItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeItem)TradeHandler.TradeItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeItem)e.getUnfinishedMessage();
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
/*       */       public boolean hasIndex() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getIndex() {
/*       */         return this.index_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIndex(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.index_ = value;
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
/*       */       public Builder clearIndex() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.index_ = 0;
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getId() {
/*       */         Object ref = this.id_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.id_ = s;
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
/*       */       public ByteString getIdBytes() {
/*       */         Object ref = this.id_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.id_ = b;
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
/*       */       public Builder setId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.id_ = value;
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
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.id_ = TradeHandler.TradeItem.getDefaultInstance().getId();
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
/*       */       public Builder setIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.id_ = value;
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
/*       */       public boolean hasNum() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getNum() {
/*       */         return this.num_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNum(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.num_ = value;
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
/*       */       public Builder clearNum() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.num_ = 0;
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
/*       */   public static final class AddItemRequest
/*       */     extends GeneratedMessage
/*       */     implements AddItemRequestOrBuilder
/*       */   {
/*  2651 */     private static final AddItemRequest defaultInstance = new AddItemRequest(true); private final UnknownFieldSet unknownFields; private AddItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AddItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AddItemRequest getDefaultInstance() { return defaultInstance; } public AddItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AddItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SDiamond_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.c2SItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.c2SItems_.add(input.readMessage(TradeHandler.TradeItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.c2SItems_ = Collections.unmodifiableList(this.c2SItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_AddItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_AddItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AddItemRequest.class, Builder.class); } public static Parser<AddItemRequest> PARSER = (Parser<AddItemRequest>)new AbstractParser<AddItemRequest>() { public TradeHandler.AddItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.AddItemRequest(input, extensionRegistry); } }
/*  2652 */     ; private int bitField0_; public static final int C2S_DIAMOND_FIELD_NUMBER = 1; private int c2SDiamond_; public static final int C2S_ITEMS_FIELD_NUMBER = 2; private List<TradeHandler.TradeItem> c2SItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AddItemRequest> getParserForType() { return PARSER; } public boolean hasC2SDiamond() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SDiamond() { return this.c2SDiamond_; } public List<TradeHandler.TradeItem> getC2SItemsList() { return this.c2SItems_; } public List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList() { return (List)this.c2SItems_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SItemsCount() {
/*       */       return this.c2SItems_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeItem getC2SItems(int index) {
/*       */       return this.c2SItems_.get(index);
/*       */     }
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int index) {
/*       */       return this.c2SItems_.get(index);
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SDiamond_ = 0;
/*       */       this.c2SItems_ = Collections.emptyList();
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
/*       */       for (int i = 0; i < getC2SItemsCount(); i++) {
/*       */         if (!getC2SItems(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.c2SDiamond_);
/*       */       }
/*       */       for (int i = 0; i < this.c2SItems_.size(); i++) {
/*       */         output.writeMessage(2, (MessageLite)this.c2SItems_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.c2SDiamond_);
/*       */       }
/*       */       for (int i = 0; i < this.c2SItems_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.c2SItems_.get(i));
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
/*       */     public static AddItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (AddItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (AddItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(InputStream input) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static AddItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(AddItemRequest prototype) {
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
/*       */       implements TradeHandler.AddItemRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private int c2SDiamond_;
/*       */       
/*       */       private List<TradeHandler.TradeItem> c2SItems_;
/*       */       
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeItem, TradeHandler.TradeItem.Builder, TradeHandler.TradeItemOrBuilder> c2SItemsBuilder_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.AddItemRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.AddItemRequest.alwaysUseFieldBuilders) {
/*       */           getC2SItemsFieldBuilder();
/*       */         }
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
/*       */         this.c2SDiamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.c2SItemsBuilder_.clear();
/*       */         } 
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
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemRequest getDefaultInstanceForType() {
/*       */         return TradeHandler.AddItemRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemRequest build() {
/*       */         TradeHandler.AddItemRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemRequest buildPartial() {
/*       */         TradeHandler.AddItemRequest result = new TradeHandler.AddItemRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SDiamond_ = this.c2SDiamond_;
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.c2SItems_ = Collections.unmodifiableList(this.c2SItems_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.c2SItems_ = this.c2SItems_;
/*       */         } else {
/*       */           result.c2SItems_ = this.c2SItemsBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.AddItemRequest) {
/*       */           return mergeFrom((TradeHandler.AddItemRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.AddItemRequest other) {
/*       */         if (other == TradeHandler.AddItemRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SDiamond()) {
/*       */           setC2SDiamond(other.getC2SDiamond());
/*       */         }
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (!other.c2SItems_.isEmpty()) {
/*       */             if (this.c2SItems_.isEmpty()) {
/*       */               this.c2SItems_ = other.c2SItems_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureC2SItemsIsMutable();
/*       */               this.c2SItems_.addAll(other.c2SItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.c2SItems_.isEmpty()) {
/*       */           if (this.c2SItemsBuilder_.isEmpty()) {
/*       */             this.c2SItemsBuilder_.dispose();
/*       */             this.c2SItemsBuilder_ = null;
/*       */             this.c2SItems_ = other.c2SItems_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.c2SItemsBuilder_ = TradeHandler.AddItemRequest.alwaysUseFieldBuilders ? getC2SItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.c2SItemsBuilder_.addAllMessages(other.c2SItems_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         for (int i = 0; i < getC2SItemsCount(); i++) {
/*       */           if (!getC2SItems(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.AddItemRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.AddItemRequest)TradeHandler.AddItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.AddItemRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SDiamond() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getC2SDiamond() {
/*       */         return this.c2SDiamond_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setC2SDiamond(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SDiamond_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearC2SDiamond() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SDiamond_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       private void ensureC2SItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.c2SItems_ = new ArrayList<>(this.c2SItems_);
/*       */           this.bitField0_ |= 0x2;
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       public List<TradeHandler.TradeItem> getC2SItemsList() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.c2SItems_);
/*       */         }
/*       */         return this.c2SItemsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */       
/*       */       public int getC2SItemsCount() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.size();
/*       */         }
/*       */         return this.c2SItemsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem getC2SItems(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeItem)this.c2SItemsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setC2SItems(int index, TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setC2SItems(int index, TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addC2SItems(TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addC2SItems(int index, TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addC2SItems(TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addC2SItems(int index, TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addAllC2SItems(Iterable<? extends TradeHandler.TradeItem> values) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.c2SItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearC2SItems() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder removeC2SItems(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem.Builder getC2SItemsBuilder(int index) {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeItemOrBuilder)this.c2SItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList() {
/*       */         if (this.c2SItemsBuilder_ != null) {
/*       */           return this.c2SItemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.c2SItems_);
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem.Builder addC2SItemsBuilder() {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().addBuilder(TradeHandler.TradeItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItem.Builder addC2SItemsBuilder(int index) {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().addBuilder(index, TradeHandler.TradeItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public List<TradeHandler.TradeItem.Builder> getC2SItemsBuilderList() {
/*       */         return getC2SItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeItem, TradeHandler.TradeItem.Builder, TradeHandler.TradeItemOrBuilder> getC2SItemsFieldBuilder() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItemsBuilder_ = new RepeatedFieldBuilder(this.c2SItems_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.c2SItems_ = null;
/*       */         } 
/*       */         return this.c2SItemsBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class AddItemResponse
/*       */     extends GeneratedMessage
/*       */     implements AddItemResponseOrBuilder
/*       */   {
/*  3213 */     private static final AddItemResponse defaultInstance = new AddItemResponse(true); private final UnknownFieldSet unknownFields; private AddItemResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AddItemResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AddItemResponse getDefaultInstance() { return defaultInstance; } public AddItemResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AddItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_AddItemResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_AddItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AddItemResponse.class, Builder.class); } public static Parser<AddItemResponse> PARSER = (Parser<AddItemResponse>)new AbstractParser<AddItemResponse>() { public TradeHandler.AddItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.AddItemResponse(input, extensionRegistry); } }
/*  3214 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AddItemResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */     }
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
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (AddItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (AddItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddItemResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(AddItemResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements TradeHandler.AddItemResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.AddItemResponse.class, Builder.class);
/*       */       }
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.AddItemResponse.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
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
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_AddItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemResponse getDefaultInstanceForType() {
/*       */         return TradeHandler.AddItemResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemResponse build() {
/*       */         TradeHandler.AddItemResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.AddItemResponse buildPartial() {
/*       */         TradeHandler.AddItemResponse result = new TradeHandler.AddItemResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.AddItemResponse) {
/*       */           return mergeFrom((TradeHandler.AddItemResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.AddItemResponse other) {
/*       */         if (other == TradeHandler.AddItemResponse.getDefaultInstance()) {
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.AddItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.AddItemResponse)TradeHandler.AddItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.AddItemResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
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
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = TradeHandler.AddItemResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */   public static final class RemoveItemRequest
/*       */     extends GeneratedMessage
/*       */     implements RemoveItemRequestOrBuilder
/*       */   {
/*  3692 */     private static final RemoveItemRequest defaultInstance = new RemoveItemRequest(true); private final UnknownFieldSet unknownFields; private RemoveItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RemoveItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RemoveItemRequest getDefaultInstance() { return defaultInstance; } public RemoveItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RemoveItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int length, limit, tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: if ((mutable_bitField0_ & 0x1) != 1) { this.c2SIndexs_ = new ArrayList<>(); mutable_bitField0_ |= 0x1; }  this.c2SIndexs_.add(Integer.valueOf(input.readInt32())); break;case 10: length = input.readRawVarint32(); limit = input.pushLimit(length); if ((mutable_bitField0_ & 0x1) != 1 && input.getBytesUntilLimit() > 0) { this.c2SIndexs_ = new ArrayList<>(); mutable_bitField0_ |= 0x1; }  while (input.getBytesUntilLimit() > 0) this.c2SIndexs_.add(Integer.valueOf(input.readInt32()));  input.popLimit(limit); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x1) == 1) this.c2SIndexs_ = Collections.unmodifiableList(this.c2SIndexs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_RemoveItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_RemoveItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RemoveItemRequest.class, Builder.class); } public static Parser<RemoveItemRequest> PARSER = (Parser<RemoveItemRequest>)new AbstractParser<RemoveItemRequest>() { public TradeHandler.RemoveItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.RemoveItemRequest(input, extensionRegistry); } }
/*  3693 */     ; public static final int C2S_INDEXS_FIELD_NUMBER = 1; private List<Integer> c2SIndexs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RemoveItemRequest> getParserForType() { return PARSER; } public List<Integer> getC2SIndexsList() { return this.c2SIndexs_; } public int getC2SIndexsCount() { return this.c2SIndexs_.size(); } public int getC2SIndexs(int index) { return ((Integer)this.c2SIndexs_.get(index)).intValue(); } private void initFields() { this.c2SIndexs_ = Collections.emptyList(); } static { defaultInstance.initFields(); }
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       for (int i = 0; i < this.c2SIndexs_.size(); i++) {
/*       */         output.writeInt32(1, ((Integer)this.c2SIndexs_.get(i)).intValue());
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       int dataSize = 0;
/*       */       for (int i = 0; i < this.c2SIndexs_.size(); i++) {
/*       */         dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.c2SIndexs_.get(i)).intValue());
/*       */       }
/*       */       size += dataSize;
/*       */       size += 1 * getC2SIndexsList().size();
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
/*       */     public static RemoveItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(InputStream input) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public static Builder newBuilder(RemoveItemRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements TradeHandler.RemoveItemRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<Integer> c2SIndexs_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.RemoveItemRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SIndexs_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SIndexs_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.RemoveItemRequest.alwaysUseFieldBuilders);
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SIndexs_ = Collections.emptyList();
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.RemoveItemRequest getDefaultInstanceForType() {
/*       */         return TradeHandler.RemoveItemRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.RemoveItemRequest build() {
/*       */         TradeHandler.RemoveItemRequest result = buildPartial();
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
/*       */       public TradeHandler.RemoveItemRequest buildPartial() {
/*       */         TradeHandler.RemoveItemRequest result = new TradeHandler.RemoveItemRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         if ((this.bitField0_ & 0x1) == 1) {
/*       */           this.c2SIndexs_ = Collections.unmodifiableList(this.c2SIndexs_);
/*       */           this.bitField0_ &= 0xFFFFFFFE;
/*       */         } 
/*       */         result.c2SIndexs_ = this.c2SIndexs_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.RemoveItemRequest) {
/*       */           return mergeFrom((TradeHandler.RemoveItemRequest)other);
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
/*       */       public Builder mergeFrom(TradeHandler.RemoveItemRequest other) {
/*       */         if (other == TradeHandler.RemoveItemRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (!other.c2SIndexs_.isEmpty()) {
/*       */           if (this.c2SIndexs_.isEmpty()) {
/*       */             this.c2SIndexs_ = other.c2SIndexs_;
/*       */             this.bitField0_ &= 0xFFFFFFFE;
/*       */           } else {
/*       */             ensureC2SIndexsIsMutable();
/*       */             this.c2SIndexs_.addAll(other.c2SIndexs_);
/*       */           } 
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
/*       */       public final boolean isInitialized() {
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.RemoveItemRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.RemoveItemRequest)TradeHandler.RemoveItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.RemoveItemRequest)e.getUnfinishedMessage();
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
/*       */       private void ensureC2SIndexsIsMutable() {
/*       */         if ((this.bitField0_ & 0x1) != 1) {
/*       */           this.c2SIndexs_ = new ArrayList<>(this.c2SIndexs_);
/*       */           this.bitField0_ |= 0x1;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Integer> getC2SIndexsList() {
/*       */         return Collections.unmodifiableList(this.c2SIndexs_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SIndexsCount() {
/*       */         return this.c2SIndexs_.size();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SIndexs(int index) {
/*       */         return ((Integer)this.c2SIndexs_.get(index)).intValue();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SIndexs(int index, int value) {
/*       */         ensureC2SIndexsIsMutable();
/*       */         this.c2SIndexs_.set(index, Integer.valueOf(value));
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
/*       */       public Builder addC2SIndexs(int value) {
/*       */         ensureC2SIndexsIsMutable();
/*       */         this.c2SIndexs_.add(Integer.valueOf(value));
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
/*       */       public Builder addAllC2SIndexs(Iterable<? extends Integer> values) {
/*       */         ensureC2SIndexsIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, this.c2SIndexs_);
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
/*       */       public Builder clearC2SIndexs() {
/*       */         this.c2SIndexs_ = Collections.emptyList();
/*       */         this.bitField0_ &= 0xFFFFFFFE;
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
/*       */   public static final class RemoveItemResponse
/*       */     extends GeneratedMessage
/*       */     implements RemoveItemResponseOrBuilder
/*       */   {
/*  4254 */     private static final RemoveItemResponse defaultInstance = new RemoveItemResponse(true); private final UnknownFieldSet unknownFields; private RemoveItemResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RemoveItemResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RemoveItemResponse getDefaultInstance() { return defaultInstance; } public RemoveItemResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RemoveItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_RemoveItemResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_RemoveItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RemoveItemResponse.class, Builder.class); } public static Parser<RemoveItemResponse> PARSER = (Parser<RemoveItemResponse>)new AbstractParser<RemoveItemResponse>() { public TradeHandler.RemoveItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.RemoveItemResponse(input, extensionRegistry); } }
/*  4255 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RemoveItemResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */     public static RemoveItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(data);
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
/*       */     public static RemoveItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static RemoveItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(data);
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
/*       */     public static RemoveItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static RemoveItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(input);
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
/*       */     public static RemoveItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static RemoveItemResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static RemoveItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static RemoveItemResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(input);
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
/*       */     public static RemoveItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveItemResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RemoveItemResponse prototype) {
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
/*       */       implements TradeHandler.RemoveItemResponseOrBuilder
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
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemResponse_descriptor;
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
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.RemoveItemResponse.class, Builder.class);
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
/*       */         if (TradeHandler.RemoveItemResponse.alwaysUseFieldBuilders);
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
/*       */         return TradeHandler.internal_static_pomelo_area_RemoveItemResponse_descriptor;
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
/*       */       public TradeHandler.RemoveItemResponse getDefaultInstanceForType() {
/*       */         return TradeHandler.RemoveItemResponse.getDefaultInstance();
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
/*       */       public TradeHandler.RemoveItemResponse build() {
/*       */         TradeHandler.RemoveItemResponse result = buildPartial();
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
/*       */       public TradeHandler.RemoveItemResponse buildPartial() {
/*       */         TradeHandler.RemoveItemResponse result = new TradeHandler.RemoveItemResponse(this);
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
/*       */         if (other instanceof TradeHandler.RemoveItemResponse) {
/*       */           return mergeFrom((TradeHandler.RemoveItemResponse)other);
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
/*       */       public Builder mergeFrom(TradeHandler.RemoveItemResponse other) {
/*       */         if (other == TradeHandler.RemoveItemResponse.getDefaultInstance()) {
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
/*       */         TradeHandler.RemoveItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.RemoveItemResponse)TradeHandler.RemoveItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.RemoveItemResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = TradeHandler.RemoveItemResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class TradeOperateRequest
/*       */     extends GeneratedMessage
/*       */     implements TradeOperateRequestOrBuilder
/*       */   {
/*  5181 */     private static final TradeOperateRequest defaultInstance = new TradeOperateRequest(true); private final UnknownFieldSet unknownFields; private TradeOperateRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeOperateRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeOperateRequest getDefaultInstance() { return defaultInstance; } public TradeOperateRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeOperateRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SOperate_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SDiamond_ = input.readInt32(); break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.c2SItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.c2SItems_.add(input.readMessage(TradeHandler.TradeItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.c2SItems_ = Collections.unmodifiableList(this.c2SItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeOperateRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeOperateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeOperateRequest.class, Builder.class); } public static Parser<TradeOperateRequest> PARSER = (Parser<TradeOperateRequest>)new AbstractParser<TradeOperateRequest>() { public TradeHandler.TradeOperateRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeOperateRequest(input, extensionRegistry); } }
/*  5182 */     ; private int bitField0_; public static final int C2S_OPERATE_FIELD_NUMBER = 1; private int c2SOperate_; public static final int C2S_DIAMOND_FIELD_NUMBER = 2; private int c2SDiamond_; public static final int C2S_ITEMS_FIELD_NUMBER = 3; private List<TradeHandler.TradeItem> c2SItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeOperateRequest> getParserForType() { return PARSER; } public boolean hasC2SOperate() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SOperate() { return this.c2SOperate_; } public boolean hasC2SDiamond() { return ((this.bitField0_ & 0x2) == 2); } public int getC2SDiamond() { return this.c2SDiamond_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     public List<TradeHandler.TradeItem> getC2SItemsList() {
/*       */       return this.c2SItems_;
/*       */     }
/*       */ 
/*       */     
/*       */     public List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList() {
/*       */       return (List)this.c2SItems_;
/*       */     }
/*       */ 
/*       */     
/*       */     public int getC2SItemsCount() {
/*       */       return this.c2SItems_.size();
/*       */     }
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeItem getC2SItems(int index) {
/*       */       return this.c2SItems_.get(index);
/*       */     }
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int index) {
/*       */       return this.c2SItems_.get(index);
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SOperate_ = 0;
/*       */       this.c2SDiamond_ = 0;
/*       */       this.c2SItems_ = Collections.emptyList();
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
/*       */       if (!hasC2SOperate()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getC2SItemsCount(); i++) {
/*       */         if (!getC2SItems(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.c2SOperate_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SDiamond_);
/*       */       }
/*       */       for (int i = 0; i < this.c2SItems_.size(); i++) {
/*       */         output.writeMessage(3, (MessageLite)this.c2SItems_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.c2SOperate_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SDiamond_);
/*       */       }
/*       */       for (int i = 0; i < this.c2SItems_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.c2SItems_.get(i));
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
/*       */     public static TradeOperateRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeOperateRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeOperateRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeOperateRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeOperateRequest parseFrom(InputStream input) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeOperateRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradeOperateRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static TradeOperateRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradeOperateRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static TradeOperateRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeOperateRequest prototype) {
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
/*       */       implements TradeHandler.TradeOperateRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int c2SOperate_;
/*       */       private int c2SDiamond_;
/*       */       private List<TradeHandler.TradeItem> c2SItems_;
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeItem, TradeHandler.TradeItem.Builder, TradeHandler.TradeItemOrBuilder> c2SItemsBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateRequest_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeOperateRequest.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.c2SItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeOperateRequest.alwaysUseFieldBuilders) {
/*       */           getC2SItemsFieldBuilder();
/*       */         }
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SOperate_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SDiamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.c2SItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateRequest_descriptor;
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeOperateRequest getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeOperateRequest.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeOperateRequest build() {
/*       */         TradeHandler.TradeOperateRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeOperateRequest buildPartial() {
/*       */         TradeHandler.TradeOperateRequest result = new TradeHandler.TradeOperateRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SOperate_ = this.c2SOperate_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SDiamond_ = this.c2SDiamond_;
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.c2SItems_ = Collections.unmodifiableList(this.c2SItems_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.c2SItems_ = this.c2SItems_;
/*       */         } else {
/*       */           result.c2SItems_ = this.c2SItemsBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeOperateRequest) {
/*       */           return mergeFrom((TradeHandler.TradeOperateRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.TradeOperateRequest other) {
/*       */         if (other == TradeHandler.TradeOperateRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SOperate()) {
/*       */           setC2SOperate(other.getC2SOperate());
/*       */         }
/*       */         if (other.hasC2SDiamond()) {
/*       */           setC2SDiamond(other.getC2SDiamond());
/*       */         }
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (!other.c2SItems_.isEmpty()) {
/*       */             if (this.c2SItems_.isEmpty()) {
/*       */               this.c2SItems_ = other.c2SItems_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureC2SItemsIsMutable();
/*       */               this.c2SItems_.addAll(other.c2SItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.c2SItems_.isEmpty()) {
/*       */           if (this.c2SItemsBuilder_.isEmpty()) {
/*       */             this.c2SItemsBuilder_.dispose();
/*       */             this.c2SItemsBuilder_ = null;
/*       */             this.c2SItems_ = other.c2SItems_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.c2SItemsBuilder_ = TradeHandler.TradeOperateRequest.alwaysUseFieldBuilders ? getC2SItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.c2SItemsBuilder_.addAllMessages(other.c2SItems_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SOperate()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getC2SItemsCount(); i++) {
/*       */           if (!getC2SItems(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradeOperateRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeOperateRequest)TradeHandler.TradeOperateRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeOperateRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SOperate() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getC2SOperate() {
/*       */         return this.c2SOperate_;
/*       */       }
/*       */       
/*       */       public Builder setC2SOperate(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SOperate_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SOperate() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SOperate_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SDiamond() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public int getC2SDiamond() {
/*       */         return this.c2SDiamond_;
/*       */       }
/*       */       
/*       */       public Builder setC2SDiamond(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SDiamond_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SDiamond() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SDiamond_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       private void ensureC2SItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.c2SItems_ = new ArrayList<>(this.c2SItems_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       
/*       */       public List<TradeHandler.TradeItem> getC2SItemsList() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.c2SItems_);
/*       */         }
/*       */         return this.c2SItemsBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getC2SItemsCount() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.size();
/*       */         }
/*       */         return this.c2SItemsBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeItem getC2SItems(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeItem)this.c2SItemsBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setC2SItems(int index, TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setC2SItems(int index, TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addC2SItems(TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addC2SItems(int index, TradeHandler.TradeItem value) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addC2SItems(TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addC2SItems(int index, TradeHandler.TradeItem.Builder builderForValue) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllC2SItems(Iterable<? extends TradeHandler.TradeItem> values) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.c2SItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SItems() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeC2SItems(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           ensureC2SItemsIsMutable();
/*       */           this.c2SItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.c2SItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeItem.Builder getC2SItemsBuilder(int index) {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int index) {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           return this.c2SItems_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeItemOrBuilder)this.c2SItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList() {
/*       */         if (this.c2SItemsBuilder_ != null) {
/*       */           return this.c2SItemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.c2SItems_);
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeItem.Builder addC2SItemsBuilder() {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().addBuilder(TradeHandler.TradeItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeItem.Builder addC2SItemsBuilder(int index) {
/*       */         return (TradeHandler.TradeItem.Builder)getC2SItemsFieldBuilder().addBuilder(index, TradeHandler.TradeItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<TradeHandler.TradeItem.Builder> getC2SItemsBuilderList() {
/*       */         return getC2SItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeItem, TradeHandler.TradeItem.Builder, TradeHandler.TradeItemOrBuilder> getC2SItemsFieldBuilder() {
/*       */         if (this.c2SItemsBuilder_ == null) {
/*       */           this.c2SItemsBuilder_ = new RepeatedFieldBuilder(this.c2SItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.c2SItems_ = null;
/*       */         } 
/*       */         return this.c2SItemsBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class TradeOperateResponse
/*       */     extends GeneratedMessage
/*       */     implements TradeOperateResponseOrBuilder
/*       */   {
/*  5743 */     private static final TradeOperateResponse defaultInstance = new TradeOperateResponse(true); private final UnknownFieldSet unknownFields; private TradeOperateResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeOperateResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeOperateResponse getDefaultInstance() { return defaultInstance; } public TradeOperateResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeOperateResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeOperateResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeOperateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeOperateResponse.class, Builder.class); } public static Parser<TradeOperateResponse> PARSER = (Parser<TradeOperateResponse>)new AbstractParser<TradeOperateResponse>() { public TradeHandler.TradeOperateResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeOperateResponse(input, extensionRegistry); } }
/*  5744 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeOperateResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */     public static TradeOperateResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(data);
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
/*       */     public static TradeOperateResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TradeOperateResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(data);
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
/*       */     public static TradeOperateResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TradeOperateResponse parseFrom(InputStream input) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(input);
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
/*       */     public static TradeOperateResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static TradeOperateResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static TradeOperateResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static TradeOperateResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(input);
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
/*       */     public static TradeOperateResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeOperateResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeOperateResponse prototype) {
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
/*       */       implements TradeHandler.TradeOperateResponseOrBuilder
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateResponse_descriptor;
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeOperateResponse.class, Builder.class);
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
/*       */         if (TradeHandler.TradeOperateResponse.alwaysUseFieldBuilders);
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperateResponse_descriptor;
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
/*       */       public TradeHandler.TradeOperateResponse getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeOperateResponse.getDefaultInstance();
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
/*       */       public TradeHandler.TradeOperateResponse build() {
/*       */         TradeHandler.TradeOperateResponse result = buildPartial();
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
/*       */       public TradeHandler.TradeOperateResponse buildPartial() {
/*       */         TradeHandler.TradeOperateResponse result = new TradeHandler.TradeOperateResponse(this);
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
/*       */         if (other instanceof TradeHandler.TradeOperateResponse) {
/*       */           return mergeFrom((TradeHandler.TradeOperateResponse)other);
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
/*       */       public Builder mergeFrom(TradeHandler.TradeOperateResponse other) {
/*       */         if (other == TradeHandler.TradeOperateResponse.getDefaultInstance()) {
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
/*       */         TradeHandler.TradeOperateResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeOperateResponse)TradeHandler.TradeOperateResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeOperateResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = TradeHandler.TradeOperateResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class TradePlayer
/*       */     extends GeneratedMessage
/*       */     implements TradePlayerOrBuilder
/*       */   {
/*  6768 */     private static final TradePlayer defaultInstance = new TradePlayer(true); private final UnknownFieldSet unknownFields; private TradePlayer(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradePlayer(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradePlayer getDefaultInstance() { return defaultInstance; } public TradePlayer getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradePlayer(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.id_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = bs; break;case 24: this.bitField0_ |= 0x4; this.level_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.upLevel_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.pro_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.relation_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradePlayer_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradePlayer_fieldAccessorTable.ensureFieldAccessorsInitialized(TradePlayer.class, Builder.class); } public static Parser<TradePlayer> PARSER = (Parser<TradePlayer>)new AbstractParser<TradePlayer>() { public TradeHandler.TradePlayer parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradePlayer(input, extensionRegistry); } }
/*  6769 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private Object id_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; static { defaultInstance.initFields(); }
/*       */ 
/*       */     
/*       */     public static final int LEVEL_FIELD_NUMBER = 3;
/*       */     private int level_;
/*       */     public static final int UPLEVEL_FIELD_NUMBER = 4;
/*       */     private int upLevel_;
/*       */     public static final int PRO_FIELD_NUMBER = 5;
/*       */     private int pro_;
/*       */     public static final int RELATION_FIELD_NUMBER = 6;
/*       */     private int relation_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<TradePlayer> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasId() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public String getId() {
/*       */       Object ref = this.id_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.id_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getIdBytes() {
/*       */       Object ref = this.id_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.id_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     public boolean hasName() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
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
/*       */     public boolean hasLevel() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public int getLevel() {
/*       */       return this.level_;
/*       */     }
/*       */     
/*       */     public boolean hasUpLevel() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */     
/*       */     public int getUpLevel() {
/*       */       return this.upLevel_;
/*       */     }
/*       */     
/*       */     public boolean hasPro() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */     
/*       */     public int getPro() {
/*       */       return this.pro_;
/*       */     }
/*       */     
/*       */     public boolean hasRelation() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */     
/*       */     public int getRelation() {
/*       */       return this.relation_;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = "";
/*       */       this.name_ = "";
/*       */       this.level_ = 0;
/*       */       this.upLevel_ = 0;
/*       */       this.pro_ = 0;
/*       */       this.relation_ = 0;
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
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasUpLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPro()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasRelation()) {
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
/*       */         output.writeBytes(1, getIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getNameBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(3, this.level_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.upLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeInt32(5, this.pro_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeInt32(6, this.relation_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeBytesSize(1, getIdBytes()); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.level_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.upLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.pro_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.relation_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradePlayer)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradePlayer)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradePlayer)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradePlayer)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(InputStream input) throws IOException {
/*       */       return (TradePlayer)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradePlayer)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradePlayer)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradePlayer)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradePlayer)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static TradePlayer parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradePlayer)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradePlayer prototype) {
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
/*       */       implements TradeHandler.TradePlayerOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private Object id_;
/*       */       private Object name_;
/*       */       private int level_;
/*       */       private int upLevel_;
/*       */       private int pro_;
/*       */       private int relation_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradePlayer_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradePlayer_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradePlayer.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.id_ = "";
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.id_ = "";
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradePlayer.alwaysUseFieldBuilders);
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.id_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.level_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.upLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.pro_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.relation_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradePlayer_descriptor;
/*       */       }
/*       */       
/*       */       public TradeHandler.TradePlayer getDefaultInstanceForType() {
/*       */         return TradeHandler.TradePlayer.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public TradeHandler.TradePlayer build() {
/*       */         TradeHandler.TradePlayer result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public TradeHandler.TradePlayer buildPartial() {
/*       */         TradeHandler.TradePlayer result = new TradeHandler.TradePlayer(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.level_ = this.level_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.upLevel_ = this.upLevel_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.pro_ = this.pro_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.relation_ = this.relation_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradePlayer)
/*       */           return mergeFrom((TradeHandler.TradePlayer)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.TradePlayer other) {
/*       */         if (other == TradeHandler.TradePlayer.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.id_ = other.id_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasLevel())
/*       */           setLevel(other.getLevel()); 
/*       */         if (other.hasUpLevel())
/*       */           setUpLevel(other.getUpLevel()); 
/*       */         if (other.hasPro())
/*       */           setPro(other.getPro()); 
/*       */         if (other.hasRelation())
/*       */           setRelation(other.getRelation()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasId())
/*       */           return false; 
/*       */         if (!hasName())
/*       */           return false; 
/*       */         if (!hasLevel())
/*       */           return false; 
/*       */         if (!hasUpLevel())
/*       */           return false; 
/*       */         if (!hasPro())
/*       */           return false; 
/*       */         if (!hasRelation())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradePlayer parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradePlayer)TradeHandler.TradePlayer.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradePlayer)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public String getId() {
/*       */         Object ref = this.id_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.id_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getIdBytes() {
/*       */         Object ref = this.id_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.id_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setId(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = TradeHandler.TradePlayer.getDefaultInstance().getId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setIdBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public String getName() {
/*       */         Object ref = this.name_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.name_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
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
/*       */       public Builder setName(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = TradeHandler.TradePlayer.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasLevel() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public int getLevel() {
/*       */         return this.level_;
/*       */       }
/*       */       
/*       */       public Builder setLevel(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasUpLevel() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       
/*       */       public int getUpLevel() {
/*       */         return this.upLevel_;
/*       */       }
/*       */       
/*       */       public Builder setUpLevel(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.upLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearUpLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.upLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasPro() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       
/*       */       public int getPro() {
/*       */         return this.pro_;
/*       */       }
/*       */       
/*       */       public Builder setPro(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.pro_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearPro() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.pro_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasRelation() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       
/*       */       public int getRelation() {
/*       */         return this.relation_;
/*       */       }
/*       */       
/*       */       public Builder setRelation(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.relation_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearRelation() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.relation_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class TradeBeginPush
/*       */     extends GeneratedMessage
/*       */     implements TradeBeginPushOrBuilder
/*       */   {
/*  7386 */     private static final TradeBeginPush defaultInstance = new TradeBeginPush(true); private final UnknownFieldSet unknownFields; private TradeBeginPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeBeginPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeBeginPush getDefaultInstance() { return defaultInstance; } public TradeBeginPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeBeginPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { TradeHandler.TradePlayer.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: subBuilder = null; if ((this.bitField0_ & 0x2) == 2) subBuilder = this.tradePlayer_.toBuilder();  this.tradePlayer_ = (TradeHandler.TradePlayer)input.readMessage(TradeHandler.TradePlayer.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.tradePlayer_); this.tradePlayer_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x2; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeBeginPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeBeginPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeBeginPush.class, Builder.class); } public static Parser<TradeBeginPush> PARSER = (Parser<TradeBeginPush>)new AbstractParser<TradeBeginPush>() { public TradeHandler.TradeBeginPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeBeginPush(input, extensionRegistry); } }
/*  7387 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int TRADEPLAYER_FIELD_NUMBER = 2; private TradeHandler.TradePlayer tradePlayer_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeBeginPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasTradePlayer() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public TradeHandler.TradePlayer getTradePlayer() {
/*       */       return this.tradePlayer_;
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
/*       */     public TradeHandler.TradePlayerOrBuilder getTradePlayerOrBuilder() {
/*       */       return this.tradePlayer_;
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
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.tradePlayer_ = TradeHandler.TradePlayer.getDefaultInstance();
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
/*       */       if (!hasTradePlayer()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!getTradePlayer().isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeMessage(2, (MessageLite)this.tradePlayer_);
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
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.tradePlayer_);
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
/*       */     public static TradeBeginPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(data);
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
/*       */     public static TradeBeginPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TradeBeginPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(data);
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
/*       */     public static TradeBeginPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TradeBeginPush parseFrom(InputStream input) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(input);
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
/*       */     public static TradeBeginPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static TradeBeginPush parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseDelimitedFrom(input);
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
/*       */     public static TradeBeginPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static TradeBeginPush parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(input);
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
/*       */     public static TradeBeginPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeBeginPush)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeBeginPush prototype) {
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
/*       */       implements TradeHandler.TradeBeginPushOrBuilder
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
/*       */       private TradeHandler.TradePlayer tradePlayer_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<TradeHandler.TradePlayer, TradeHandler.TradePlayer.Builder, TradeHandler.TradePlayerOrBuilder> tradePlayerBuilder_;
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeBeginPush_descriptor;
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeBeginPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeBeginPush.class, Builder.class);
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
/*       */         this.tradePlayer_ = TradeHandler.TradePlayer.getDefaultInstance();
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
/*       */         this.tradePlayer_ = TradeHandler.TradePlayer.getDefaultInstance();
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
/*       */         if (TradeHandler.TradeBeginPush.alwaysUseFieldBuilders) {
/*       */           getTradePlayerFieldBuilder();
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
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           this.tradePlayer_ = TradeHandler.TradePlayer.getDefaultInstance();
/*       */         } else {
/*       */           this.tradePlayerBuilder_.clear();
/*       */         } 
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeBeginPush_descriptor;
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
/*       */       public TradeHandler.TradeBeginPush getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeBeginPush.getDefaultInstance();
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
/*       */       public TradeHandler.TradeBeginPush build() {
/*       */         TradeHandler.TradeBeginPush result = buildPartial();
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
/*       */       public TradeHandler.TradeBeginPush buildPartial() {
/*       */         TradeHandler.TradeBeginPush result = new TradeHandler.TradeBeginPush(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           result.tradePlayer_ = this.tradePlayer_;
/*       */         } else {
/*       */           result.tradePlayer_ = (TradeHandler.TradePlayer)this.tradePlayerBuilder_.build();
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeBeginPush) {
/*       */           return mergeFrom((TradeHandler.TradeBeginPush)other);
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
/*       */       public Builder mergeFrom(TradeHandler.TradeBeginPush other) {
/*       */         if (other == TradeHandler.TradeBeginPush.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasTradePlayer()) {
/*       */           mergeTradePlayer(other.getTradePlayer());
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
/*       */         if (!hasTradePlayer()) {
/*       */           return false;
/*       */         }
/*       */         if (!getTradePlayer().isInitialized()) {
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
/*       */         TradeHandler.TradeBeginPush parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeBeginPush)TradeHandler.TradeBeginPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeBeginPush)e.getUnfinishedMessage();
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
/*       */       public boolean hasTradePlayer() {
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
/*       */       public TradeHandler.TradePlayer getTradePlayer() {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           return this.tradePlayer_;
/*       */         }
/*       */         return (TradeHandler.TradePlayer)this.tradePlayerBuilder_.getMessage();
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
/*       */       public Builder setTradePlayer(TradeHandler.TradePlayer value) {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.tradePlayer_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.tradePlayerBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
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
/*       */       public Builder setTradePlayer(TradeHandler.TradePlayer.Builder builderForValue) {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           this.tradePlayer_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.tradePlayerBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
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
/*       */       public Builder mergeTradePlayer(TradeHandler.TradePlayer value) {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2 && this.tradePlayer_ != TradeHandler.TradePlayer.getDefaultInstance()) {
/*       */             this.tradePlayer_ = TradeHandler.TradePlayer.newBuilder(this.tradePlayer_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.tradePlayer_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.tradePlayerBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
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
/*       */       public Builder clearTradePlayer() {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           this.tradePlayer_ = TradeHandler.TradePlayer.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.tradePlayerBuilder_.clear();
/*       */         } 
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
/*       */       public TradeHandler.TradePlayer.Builder getTradePlayerBuilder() {
/*       */         this.bitField0_ |= 0x2;
/*       */         onChanged();
/*       */         return (TradeHandler.TradePlayer.Builder)getTradePlayerFieldBuilder().getBuilder();
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
/*       */       public TradeHandler.TradePlayerOrBuilder getTradePlayerOrBuilder() {
/*       */         if (this.tradePlayerBuilder_ != null) {
/*       */           return (TradeHandler.TradePlayerOrBuilder)this.tradePlayerBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.tradePlayer_;
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
/*       */       private SingleFieldBuilder<TradeHandler.TradePlayer, TradeHandler.TradePlayer.Builder, TradeHandler.TradePlayerOrBuilder> getTradePlayerFieldBuilder() {
/*       */         if (this.tradePlayerBuilder_ == null) {
/*       */           this.tradePlayerBuilder_ = new SingleFieldBuilder(getTradePlayer(), getParentForChildren(), isClean());
/*       */           this.tradePlayer_ = null;
/*       */         } 
/*       */         return this.tradePlayerBuilder_;
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
/*       */   public static final class TradeGrid
/*       */     extends GeneratedMessage
/*       */     implements TradeGridOrBuilder
/*       */   {
/*  8231 */     private static final TradeGrid defaultInstance = new TradeGrid(true); private final UnknownFieldSet unknownFields; private TradeGrid(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeGrid(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeGrid getDefaultInstance() { return defaultInstance; } public TradeGrid getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeGrid(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ItemOuterClass.Grid.Builder builder; ItemOuterClass.ItemDetail.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: builder = null; if ((this.bitField0_ & 0x1) == 1) builder = this.grid_.toBuilder();  this.grid_ = (ItemOuterClass.Grid)input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry); if (builder != null) { builder.mergeFrom(this.grid_); this.grid_ = builder.buildPartial(); }  this.bitField0_ |= 0x1; break;case 18: subBuilder = null; if ((this.bitField0_ & 0x2) == 2) subBuilder = this.detail_.toBuilder();  this.detail_ = (ItemOuterClass.ItemDetail)input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.detail_); this.detail_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x2; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeGrid_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeGrid_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeGrid.class, Builder.class); } public static Parser<TradeGrid> PARSER = (Parser<TradeGrid>)new AbstractParser<TradeGrid>() { public TradeHandler.TradeGrid parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeGrid(input, extensionRegistry); } }
/*  8232 */     ; private int bitField0_; static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int GRID_FIELD_NUMBER = 1;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private ItemOuterClass.Grid grid_;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int DETAIL_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private ItemOuterClass.ItemDetail detail_;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
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
/*       */     public Parser<TradeGrid> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGrid() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ItemOuterClass.Grid getGrid() {
/*       */       return this.grid_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ItemOuterClass.GridOrBuilder getGridOrBuilder() {
/*       */       return (ItemOuterClass.GridOrBuilder)this.grid_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasDetail() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ItemOuterClass.ItemDetail getDetail() {
/*       */       return this.detail_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder() {
/*       */       return (ItemOuterClass.ItemDetailOrBuilder)this.detail_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.grid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */       this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
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
/*       */       if (!hasGrid()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!getGrid().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (hasDetail() && !getDetail().isInitialized()) {
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
/*       */         output.writeMessage(1, (MessageLite)this.grid_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeMessage(2, (MessageLite)this.detail_);
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
/*       */         size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.grid_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.detail_);
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
/*       */     public static TradeGrid parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeGrid)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeGrid)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeGrid)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeGrid)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(InputStream input) throws IOException {
/*       */       return (TradeGrid)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeGrid)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeGrid)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeGrid)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeGrid)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeGrid parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeGrid)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeGrid prototype) {
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
/*       */       implements TradeHandler.TradeGridOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private ItemOuterClass.Grid grid_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> gridBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private ItemOuterClass.ItemDetail detail_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> detailBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeGrid_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeGrid_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeGrid.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.grid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.grid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeGrid.alwaysUseFieldBuilders) {
/*       */           getGridFieldBuilder();
/*       */           getDetailFieldBuilder();
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
/*       */         if (this.gridBuilder_ == null) {
/*       */           this.grid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         } else {
/*       */           this.gridBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.detailBuilder_ == null) {
/*       */           this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
/*       */         } else {
/*       */           this.detailBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeGrid_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeGrid.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid build() {
/*       */         TradeHandler.TradeGrid result = buildPartial();
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
/*       */       public TradeHandler.TradeGrid buildPartial() {
/*       */         TradeHandler.TradeGrid result = new TradeHandler.TradeGrid(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         if (this.gridBuilder_ == null) {
/*       */           result.grid_ = this.grid_;
/*       */         } else {
/*       */           result.grid_ = (ItemOuterClass.Grid)this.gridBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         if (this.detailBuilder_ == null) {
/*       */           result.detail_ = this.detail_;
/*       */         } else {
/*       */           result.detail_ = (ItemOuterClass.ItemDetail)this.detailBuilder_.build();
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeGrid) {
/*       */           return mergeFrom((TradeHandler.TradeGrid)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.TradeGrid other) {
/*       */         if (other == TradeHandler.TradeGrid.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasGrid()) {
/*       */           mergeGrid(other.getGrid());
/*       */         }
/*       */         if (other.hasDetail()) {
/*       */           mergeDetail(other.getDetail());
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
/*       */         if (!hasGrid()) {
/*       */           return false;
/*       */         }
/*       */         if (!getGrid().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         if (hasDetail() && !getDetail().isInitialized()) {
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
/*       */         TradeHandler.TradeGrid parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeGrid)TradeHandler.TradeGrid.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeGrid)e.getUnfinishedMessage();
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
/*       */       public boolean hasGrid() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.Grid getGrid() {
/*       */         if (this.gridBuilder_ == null) {
/*       */           return this.grid_;
/*       */         }
/*       */         return (ItemOuterClass.Grid)this.gridBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGrid(ItemOuterClass.Grid value) {
/*       */         if (this.gridBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.grid_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridBuilder_.setMessage((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGrid(ItemOuterClass.Grid.Builder builderForValue) {
/*       */         if (this.gridBuilder_ == null) {
/*       */           this.grid_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridBuilder_.setMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeGrid(ItemOuterClass.Grid value) {
/*       */         if (this.gridBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x1) == 1 && this.grid_ != ItemOuterClass.Grid.getDefaultInstance()) {
/*       */             this.grid_ = ItemOuterClass.Grid.newBuilder(this.grid_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.grid_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridBuilder_.mergeFrom((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearGrid() {
/*       */         if (this.gridBuilder_ == null) {
/*       */           this.grid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.Grid.Builder getGridBuilder() {
/*       */         this.bitField0_ |= 0x1;
/*       */         onChanged();
/*       */         return (ItemOuterClass.Grid.Builder)getGridFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.GridOrBuilder getGridOrBuilder() {
/*       */         if (this.gridBuilder_ != null) {
/*       */           return (ItemOuterClass.GridOrBuilder)this.gridBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return (ItemOuterClass.GridOrBuilder)this.grid_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getGridFieldBuilder() {
/*       */         if (this.gridBuilder_ == null) {
/*       */           this.gridBuilder_ = new SingleFieldBuilder((GeneratedMessage)getGrid(), getParentForChildren(), isClean());
/*       */           this.grid_ = null;
/*       */         } 
/*       */         return this.gridBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasDetail() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.ItemDetail getDetail() {
/*       */         if (this.detailBuilder_ == null) {
/*       */           return this.detail_;
/*       */         }
/*       */         return (ItemOuterClass.ItemDetail)this.detailBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDetail(ItemOuterClass.ItemDetail value) {
/*       */         if (this.detailBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.detail_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.detailBuilder_.setMessage((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDetail(ItemOuterClass.ItemDetail.Builder builderForValue) {
/*       */         if (this.detailBuilder_ == null) {
/*       */           this.detail_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.detailBuilder_.setMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeDetail(ItemOuterClass.ItemDetail value) {
/*       */         if (this.detailBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2 && this.detail_ != ItemOuterClass.ItemDetail.getDefaultInstance()) {
/*       */             this.detail_ = ItemOuterClass.ItemDetail.newBuilder(this.detail_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.detail_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.detailBuilder_.mergeFrom((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDetail() {
/*       */         if (this.detailBuilder_ == null) {
/*       */           this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.detailBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.ItemDetail.Builder getDetailBuilder() {
/*       */         this.bitField0_ |= 0x2;
/*       */         onChanged();
/*       */         return (ItemOuterClass.ItemDetail.Builder)getDetailFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder() {
/*       */         if (this.detailBuilder_ != null) {
/*       */           return (ItemOuterClass.ItemDetailOrBuilder)this.detailBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return (ItemOuterClass.ItemDetailOrBuilder)this.detail_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getDetailFieldBuilder() {
/*       */         if (this.detailBuilder_ == null) {
/*       */           this.detailBuilder_ = new SingleFieldBuilder((GeneratedMessage)getDetail(), getParentForChildren(), isClean());
/*       */           this.detail_ = null;
/*       */         } 
/*       */         return this.detailBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class TradeData
/*       */     extends GeneratedMessage
/*       */     implements TradeDataOrBuilder
/*       */   {
/*  9000 */     private static final TradeData defaultInstance = new TradeData(true); private final UnknownFieldSet unknownFields; private TradeData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeData getDefaultInstance() { return defaultInstance; } public TradeData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.diamond_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.grids_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.grids_.add(input.readMessage(TradeHandler.TradeGrid.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.grids_ = Collections.unmodifiableList(this.grids_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeData_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeData.class, Builder.class); } public static Parser<TradeData> PARSER = (Parser<TradeData>)new AbstractParser<TradeData>() { public TradeHandler.TradeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeData(input, extensionRegistry); } }
/*  9001 */     ; private int bitField0_; public static final int DIAMOND_FIELD_NUMBER = 1; private int diamond_; public static final int GRIDS_FIELD_NUMBER = 2; private List<TradeHandler.TradeGrid> grids_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeData> getParserForType() { return PARSER; } public boolean hasDiamond() { return ((this.bitField0_ & 0x1) == 1); } public int getDiamond() { return this.diamond_; } public List<TradeHandler.TradeGrid> getGridsList() { return this.grids_; } public List<? extends TradeHandler.TradeGridOrBuilder> getGridsOrBuilderList() { return (List)this.grids_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGridsCount() {
/*       */       return this.grids_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeGrid getGrids(int index) {
/*       */       return this.grids_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeGridOrBuilder getGridsOrBuilder(int index) {
/*       */       return this.grids_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.diamond_ = 0;
/*       */       this.grids_ = Collections.emptyList();
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
/*       */       for (int i = 0; i < getGridsCount(); i++) {
/*       */         if (!getGrids(i).isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.diamond_);
/*       */       }
/*       */       for (int i = 0; i < this.grids_.size(); i++) {
/*       */         output.writeMessage(2, (MessageLite)this.grids_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.diamond_);
/*       */       }
/*       */       for (int i = 0; i < this.grids_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.grids_.get(i));
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
/*       */     public static TradeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(InputStream input) throws IOException {
/*       */       return (TradeData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeData)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeData)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeData)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static TradeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeData)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeData prototype) {
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
/*       */       implements TradeHandler.TradeDataOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int diamond_;
/*       */ 
/*       */       
/*       */       private List<TradeHandler.TradeGrid> grids_;
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeGrid, TradeHandler.TradeGrid.Builder, TradeHandler.TradeGridOrBuilder> gridsBuilder_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeData_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeData.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.grids_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.grids_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeData.alwaysUseFieldBuilders) {
/*       */           getGridsFieldBuilder();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.diamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.gridsBuilder_ == null) {
/*       */           this.grids_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.gridsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeData getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeData.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeData build() {
/*       */         TradeHandler.TradeData result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeData buildPartial() {
/*       */         TradeHandler.TradeData result = new TradeHandler.TradeData(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.diamond_ = this.diamond_;
/*       */         if (this.gridsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.grids_ = Collections.unmodifiableList(this.grids_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.grids_ = this.grids_;
/*       */         } else {
/*       */           result.grids_ = this.gridsBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeData) {
/*       */           return mergeFrom((TradeHandler.TradeData)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.TradeData other) {
/*       */         if (other == TradeHandler.TradeData.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasDiamond()) {
/*       */           setDiamond(other.getDiamond());
/*       */         }
/*       */         if (this.gridsBuilder_ == null) {
/*       */           if (!other.grids_.isEmpty()) {
/*       */             if (this.grids_.isEmpty()) {
/*       */               this.grids_ = other.grids_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureGridsIsMutable();
/*       */               this.grids_.addAll(other.grids_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.grids_.isEmpty()) {
/*       */           if (this.gridsBuilder_.isEmpty()) {
/*       */             this.gridsBuilder_.dispose();
/*       */             this.gridsBuilder_ = null;
/*       */             this.grids_ = other.grids_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.gridsBuilder_ = TradeHandler.TradeData.alwaysUseFieldBuilders ? getGridsFieldBuilder() : null;
/*       */           } else {
/*       */             this.gridsBuilder_.addAllMessages(other.grids_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         for (int i = 0; i < getGridsCount(); i++) {
/*       */           if (!getGrids(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradeData parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeData)TradeHandler.TradeData.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeData)e.getUnfinishedMessage();
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
/*       */       public boolean hasDiamond() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getDiamond() {
/*       */         return this.diamond_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDiamond(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.diamond_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDiamond() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.diamond_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureGridsIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.grids_ = new ArrayList<>(this.grids_);
/*       */           this.bitField0_ |= 0x2;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<TradeHandler.TradeGrid> getGridsList() {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.grids_);
/*       */         }
/*       */         return this.gridsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getGridsCount() {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           return this.grids_.size();
/*       */         }
/*       */         return this.gridsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid getGrids(int index) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           return this.grids_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeGrid)this.gridsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setGrids(int index, TradeHandler.TradeGrid value) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setGrids(int index, TradeHandler.TradeGrid.Builder builderForValue) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addGrids(TradeHandler.TradeGrid value) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addGrids(int index, TradeHandler.TradeGrid value) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addGrids(TradeHandler.TradeGrid.Builder builderForValue) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addGrids(int index, TradeHandler.TradeGrid.Builder builderForValue) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addAllGrids(Iterable<? extends TradeHandler.TradeGrid> values) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           ensureGridsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.grids_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearGrids() {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           this.grids_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder removeGrids(int index) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           ensureGridsIsMutable();
/*       */           this.grids_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.gridsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid.Builder getGridsBuilder(int index) {
/*       */         return (TradeHandler.TradeGrid.Builder)getGridsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGridOrBuilder getGridsOrBuilder(int index) {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           return this.grids_.get(index);
/*       */         }
/*       */         return (TradeHandler.TradeGridOrBuilder)this.gridsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public List<? extends TradeHandler.TradeGridOrBuilder> getGridsOrBuilderList() {
/*       */         if (this.gridsBuilder_ != null) {
/*       */           return this.gridsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.grids_);
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid.Builder addGridsBuilder() {
/*       */         return (TradeHandler.TradeGrid.Builder)getGridsFieldBuilder().addBuilder(TradeHandler.TradeGrid.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeGrid.Builder addGridsBuilder(int index) {
/*       */         return (TradeHandler.TradeGrid.Builder)getGridsFieldBuilder().addBuilder(index, TradeHandler.TradeGrid.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public List<TradeHandler.TradeGrid.Builder> getGridsBuilderList() {
/*       */         return getGridsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<TradeHandler.TradeGrid, TradeHandler.TradeGrid.Builder, TradeHandler.TradeGridOrBuilder> getGridsFieldBuilder() {
/*       */         if (this.gridsBuilder_ == null) {
/*       */           this.gridsBuilder_ = new RepeatedFieldBuilder(this.grids_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.grids_ = null;
/*       */         } 
/*       */         return this.gridsBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class TradeItemChangePush
/*       */     extends GeneratedMessage
/*       */     implements TradeItemChangePushOrBuilder
/*       */   {
/*  9610 */     private static final TradeItemChangePush defaultInstance = new TradeItemChangePush(true); private final UnknownFieldSet unknownFields; private TradeItemChangePush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TradeItemChangePush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TradeItemChangePush getDefaultInstance() { return defaultInstance; } public TradeItemChangePush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TradeItemChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { TradeHandler.TradeData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: subBuilder = null; if ((this.bitField0_ & 0x2) == 2) subBuilder = this.data_.toBuilder();  this.data_ = (TradeHandler.TradeData)input.readMessage(TradeHandler.TradeData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.data_); this.data_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x2; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return TradeHandler.internal_static_pomelo_area_TradeItemChangePush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return TradeHandler.internal_static_pomelo_area_TradeItemChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeItemChangePush.class, Builder.class); } public static Parser<TradeItemChangePush> PARSER = (Parser<TradeItemChangePush>)new AbstractParser<TradeItemChangePush>() { public TradeHandler.TradeItemChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new TradeHandler.TradeItemChangePush(input, extensionRegistry); } }
/*  9611 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int DATA_FIELD_NUMBER = 2; private TradeHandler.TradeData data_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TradeItemChangePush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasData() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeData getData() {
/*       */       return this.data_;
/*       */     }
/*       */ 
/*       */     
/*       */     public TradeHandler.TradeDataOrBuilder getDataOrBuilder() {
/*       */       return this.data_;
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.data_ = TradeHandler.TradeData.getDefaultInstance();
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
/*       */       if (!hasData()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!getData().isInitialized()) {
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
/*       */         output.writeMessage(2, (MessageLite)this.data_);
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
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.data_);
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
/*       */     public static TradeItemChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(InputStream input) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static TradeItemChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TradeItemChangePush)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TradeItemChangePush prototype) {
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
/*       */       implements TradeHandler.TradeItemChangePushOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private int s2CCode_;
/*       */       
/*       */       private TradeHandler.TradeData data_;
/*       */       
/*       */       private SingleFieldBuilder<TradeHandler.TradeData, TradeHandler.TradeData.Builder, TradeHandler.TradeDataOrBuilder> dataBuilder_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItemChangePush_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItemChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeItemChangePush.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.data_ = TradeHandler.TradeData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.data_ = TradeHandler.TradeData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeItemChangePush.alwaysUseFieldBuilders) {
/*       */           getDataFieldBuilder();
/*       */         }
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
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.dataBuilder_ == null) {
/*       */           this.data_ = TradeHandler.TradeData.getDefaultInstance();
/*       */         } else {
/*       */           this.dataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
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
/*       */         return TradeHandler.internal_static_pomelo_area_TradeItemChangePush_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItemChangePush getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeItemChangePush.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItemChangePush build() {
/*       */         TradeHandler.TradeItemChangePush result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeItemChangePush buildPartial() {
/*       */         TradeHandler.TradeItemChangePush result = new TradeHandler.TradeItemChangePush(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         if (this.dataBuilder_ == null) {
/*       */           result.data_ = this.data_;
/*       */         } else {
/*       */           result.data_ = (TradeHandler.TradeData)this.dataBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeItemChangePush) {
/*       */           return mergeFrom((TradeHandler.TradeItemChangePush)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(TradeHandler.TradeItemChangePush other) {
/*       */         if (other == TradeHandler.TradeItemChangePush.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasS2CCode()) {
/*       */           setS2CCode(other.getS2CCode());
/*       */         }
/*       */         if (other.hasData()) {
/*       */           mergeData(other.getData());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasData()) {
/*       */           return false;
/*       */         }
/*       */         if (!getData().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradeItemChangePush parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeItemChangePush)TradeHandler.TradeItemChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeItemChangePush)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
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
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasData() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeData getData() {
/*       */         if (this.dataBuilder_ == null) {
/*       */           return this.data_;
/*       */         }
/*       */         return (TradeHandler.TradeData)this.dataBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setData(TradeHandler.TradeData value) {
/*       */         if (this.dataBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.data_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.dataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setData(TradeHandler.TradeData.Builder builderForValue) {
/*       */         if (this.dataBuilder_ == null) {
/*       */           this.data_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.dataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeData(TradeHandler.TradeData value) {
/*       */         if (this.dataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2 && this.data_ != TradeHandler.TradeData.getDefaultInstance()) {
/*       */             this.data_ = TradeHandler.TradeData.newBuilder(this.data_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.data_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.dataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearData() {
/*       */         if (this.dataBuilder_ == null) {
/*       */           this.data_ = TradeHandler.TradeData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.dataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public TradeHandler.TradeData.Builder getDataBuilder() {
/*       */         this.bitField0_ |= 0x2;
/*       */         onChanged();
/*       */         return (TradeHandler.TradeData.Builder)getDataFieldBuilder().getBuilder();
/*       */       }
/*       */       
/*       */       public TradeHandler.TradeDataOrBuilder getDataOrBuilder() {
/*       */         if (this.dataBuilder_ != null) {
/*       */           return (TradeHandler.TradeDataOrBuilder)this.dataBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.data_;
/*       */       }
/*       */       
/*       */       private SingleFieldBuilder<TradeHandler.TradeData, TradeHandler.TradeData.Builder, TradeHandler.TradeDataOrBuilder> getDataFieldBuilder() {
/*       */         if (this.dataBuilder_ == null) {
/*       */           this.dataBuilder_ = new SingleFieldBuilder(getData(), getParentForChildren(), isClean());
/*       */           this.data_ = null;
/*       */         } 
/*       */         return this.dataBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class TradeOperatePush
/*       */     extends GeneratedMessage
/*       */     implements TradeOperatePushOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private TradeOperatePush(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private TradeOperatePush(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static TradeOperatePush getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public TradeOperatePush getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private TradeOperatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */               this.s2CCode_ = input.readInt32();
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.operate_ = input.readInt32();
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
/*       */       return TradeHandler.internal_static_pomelo_area_TradeOperatePush_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return TradeHandler.internal_static_pomelo_area_TradeOperatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeOperatePush.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<TradeOperatePush> PARSER = (Parser<TradeOperatePush>)new AbstractParser<TradeOperatePush>()
/*       */       {
/*       */         public TradeHandler.TradeOperatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new TradeHandler.TradeOperatePush(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */     private int s2CCode_;
/*       */     public static final int OPERATE_FIELD_NUMBER = 2;
/*       */     private int operate_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/* 10133 */     private static final TradeOperatePush defaultInstance = new TradeOperatePush(true); private static final long serialVersionUID = 0L; public Parser<TradeOperatePush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasOperate() { return ((this.bitField0_ & 0x2) == 2); } public int getOperate() { return this.operate_; } private void initFields() { this.s2CCode_ = 0; this.operate_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasOperate()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.operate_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/* 10134 */         size += CodedOutputStream.computeInt32Size(2, this.operate_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static TradeOperatePush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (TradeOperatePush)PARSER.parseFrom(data); } public static TradeOperatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TradeOperatePush)PARSER.parseFrom(data, extensionRegistry); } public static TradeOperatePush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (TradeOperatePush)PARSER.parseFrom(data); } public static TradeOperatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TradeOperatePush)PARSER.parseFrom(data, extensionRegistry); } public static TradeOperatePush parseFrom(InputStream input) throws IOException { return (TradeOperatePush)PARSER.parseFrom(input); } public static TradeOperatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TradeOperatePush)PARSER.parseFrom(input, extensionRegistry); } public static TradeOperatePush parseDelimitedFrom(InputStream input) throws IOException { return (TradeOperatePush)PARSER.parseDelimitedFrom(input); } public static TradeOperatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TradeOperatePush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static TradeOperatePush parseFrom(CodedInputStream input) throws IOException { return (TradeOperatePush)PARSER.parseFrom(input); } public static TradeOperatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TradeOperatePush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } static { defaultInstance.initFields(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(TradeOperatePush prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() {
/*       */       return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements TradeHandler.TradeOperatePushOrBuilder { private int bitField0_; private int s2CCode_; private int operate_; public static final Descriptors.Descriptor getDescriptor() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperatePush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TradeHandler.TradeOperatePush.class, Builder.class); } private Builder() {
/*       */         maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() {
/*       */         if (TradeHandler.TradeOperatePush.alwaysUseFieldBuilders); } private static Builder create() {
/*       */         return new Builder(); } public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.operate_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this; } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return TradeHandler.internal_static_pomelo_area_TradeOperatePush_descriptor; } public TradeHandler.TradeOperatePush getDefaultInstanceForType() {
/*       */         return TradeHandler.TradeOperatePush.getDefaultInstance(); } public TradeHandler.TradeOperatePush build() {
/*       */         TradeHandler.TradeOperatePush result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; } public TradeHandler.TradeOperatePush buildPartial() {
/*       */         TradeHandler.TradeOperatePush result = new TradeHandler.TradeOperatePush(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.operate_ = this.operate_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; } public Builder mergeFrom(Message other) {
/*       */         if (other instanceof TradeHandler.TradeOperatePush)
/*       */           return mergeFrom((TradeHandler.TradeOperatePush)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; } public Builder mergeFrom(TradeHandler.TradeOperatePush other) {
/*       */         if (other == TradeHandler.TradeOperatePush.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasOperate())
/*       */           setOperate(other.getOperate()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; } public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (!hasOperate())
/*       */           return false; 
/*       */         return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         TradeHandler.TradeOperatePush parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (TradeHandler.TradeOperatePush)TradeHandler.TradeOperatePush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (TradeHandler.TradeOperatePush)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; } public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() {
/*       */         return this.s2CCode_; } public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasOperate() {
/*       */         return ((this.bitField0_ & 0x2) == 2); } public int getOperate() {
/*       */         return this.operate_; } public Builder setOperate(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.operate_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearOperate() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.operate_ = 0;
/*       */         onChanged();
/*       */         return this; } } } public static Descriptors.FileDescriptor getDescriptor() {
/* 10218 */     return descriptor;
/*       */   }
/*       */ 
/*       */   
/*       */   static {
/* 10223 */     String[] descriptorData = { "\n\022tradeHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"%\n\rInviteRequest\022\024\n\fc2s_playerId\030\001 \002(\t\"3\n\016InviteResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"3\n\tTradeItem\022\r\n\005index\030\001 \002(\005\022\n\n\002id\030\002 \002(\t\022\013\n\003num\030\003 \002(\005\"P\n\016AddItemRequest\022\023\n\013c2s_diamond\030\001 \001(\005\022)\n\tc2s_items\030\002 \003(\0132\026.pomelo.area.TradeItem\"4\n\017AddItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"'\n\021RemoveItemRequest\022\022\n\nc2s_indexs\030\001 \003(\005\"7\n\022RemoveItemRespo", "nse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"j\n\023TradeOperateRequest\022\023\n\013c2s_operate\030\001 \002(\005\022\023\n\013c2s_diamond\030\002 \001(\005\022)\n\tc2s_items\030\003 \003(\0132\026.pomelo.area.TradeItem\"9\n\024TradeOperateResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"f\n\013TradePlayer\022\n\n\002id\030\001 \002(\t\022\f\n\004name\030\002 \002(\t\022\r\n\005level\030\003 \002(\005\022\017\n\007upLevel\030\004 \002(\005\022\013\n\003pro\030\005 \002(\005\022\020\n\brelation\030\006 \002(\005\"Q\n\016TradeBeginPush\022\020\n\bs2c_code\030\001 \002(\005\022-\n\013tradePlayer\030\002 \002(\0132\030.pomelo.area.TradePlayer\"U\n\tTrad", "eGrid\022\037\n\004grid\030\001 \002(\0132\021.pomelo.item.Grid\022'\n\006detail\030\002 \001(\0132\027.pomelo.item.ItemDetail\"C\n\tTradeData\022\017\n\007diamond\030\001 \001(\005\022%\n\005grids\030\002 \003(\0132\026.pomelo.area.TradeGrid\"M\n\023TradeItemChangePush\022\020\n\bs2c_code\030\001 \002(\005\022$\n\004data\030\002 \002(\0132\026.pomelo.area.TradeData\"5\n\020TradeOperatePush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007operate\030\002 \002(\0052×\002\n\ftradeHandler\022H\n\rinviteRequest\022\032.pomelo.area.InviteRequest\032\033.pomelo.area.InviteResponse\022K\n\016addItemRequest\022\033.pomelo", ".area.AddItemRequest\032\034.pomelo.area.AddItemResponse\022T\n\021removeItemRequest\022\036.pomelo.area.RemoveItemRequest\032\037.pomelo.area.RemoveItemResponse\022Z\n\023tradeOperateRequest\022 .pomelo.area.TradeOperateRequest\032!.pomelo.area.TradeOperateResponse2Ð\001\n\ttradePush\022;\n\016tradeBeginPush\022\033.pomelo.area.TradeBeginPush\032\f.pomelo.Void\022E\n\023tradeItemChangePush\022 .pomelo.area.TradeItemChangePush\032\f.pomelo.Void\022?\n\020tradeOperatePush\022\035.pom", "elo.area.TradeOperatePush\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10266 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 10270 */           TradeHandler.descriptor = root;
/* 10271 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 10275 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 10277 */           Common.getDescriptor(), 
/* 10278 */           ItemOuterClass.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 10281 */   private static final Descriptors.Descriptor internal_static_pomelo_area_InviteRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 10282 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InviteRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InviteRequest_descriptor, new String[] { "C2SPlayerId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10287 */   private static final Descriptors.Descriptor internal_static_pomelo_area_InviteResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 10288 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InviteResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InviteResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10293 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeItem_descriptor = getDescriptor().getMessageTypes().get(2);
/* 10294 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeItem_descriptor, new String[] { "Index", "Id", "Num" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10299 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AddItemRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 10300 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddItemRequest_descriptor, new String[] { "C2SDiamond", "C2SItems" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10305 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AddItemResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 10306 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10311 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RemoveItemRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 10312 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RemoveItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RemoveItemRequest_descriptor, new String[] { "C2SIndexs" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10317 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RemoveItemResponse_descriptor = getDescriptor().getMessageTypes().get(6);
/* 10318 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RemoveItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RemoveItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10323 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeOperateRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 10324 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeOperateRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeOperateRequest_descriptor, new String[] { "C2SOperate", "C2SDiamond", "C2SItems" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10329 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeOperateResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 10330 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeOperateResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeOperateResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10335 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradePlayer_descriptor = getDescriptor().getMessageTypes().get(9);
/* 10336 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradePlayer_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradePlayer_descriptor, new String[] { "Id", "Name", "Level", "UpLevel", "Pro", "Relation" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10341 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeBeginPush_descriptor = getDescriptor().getMessageTypes().get(10);
/* 10342 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeBeginPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeBeginPush_descriptor, new String[] { "S2CCode", "TradePlayer" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10347 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeGrid_descriptor = getDescriptor().getMessageTypes().get(11);
/* 10348 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeGrid_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeGrid_descriptor, new String[] { "Grid", "Detail" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10353 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeData_descriptor = getDescriptor().getMessageTypes().get(12);
/* 10354 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeData_descriptor, new String[] { "Diamond", "Grids" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10359 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeItemChangePush_descriptor = getDescriptor().getMessageTypes().get(13);
/* 10360 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeItemChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeItemChangePush_descriptor, new String[] { "S2CCode", "Data" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10365 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TradeOperatePush_descriptor = getDescriptor().getMessageTypes().get(14);
/* 10366 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TradeOperatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TradeOperatePush_descriptor, new String[] { "S2CCode", "Operate" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 10370 */     Common.getDescriptor();
/* 10371 */     ItemOuterClass.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface TradeOperatePushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasOperate();
/*       */     
/*       */     int getOperate();
/*       */   }
/*       */   
/*       */   public static interface TradeItemChangePushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasData();
/*       */     
/*       */     TradeHandler.TradeData getData();
/*       */     
/*       */     TradeHandler.TradeDataOrBuilder getDataOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface TradeDataOrBuilder extends MessageOrBuilder {
/*       */     boolean hasDiamond();
/*       */     
/*       */     int getDiamond();
/*       */     
/*       */     List<TradeHandler.TradeGrid> getGridsList();
/*       */     
/*       */     TradeHandler.TradeGrid getGrids(int param1Int);
/*       */     
/*       */     int getGridsCount();
/*       */     
/*       */     List<? extends TradeHandler.TradeGridOrBuilder> getGridsOrBuilderList();
/*       */     
/*       */     TradeHandler.TradeGridOrBuilder getGridsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface TradeGridOrBuilder extends MessageOrBuilder {
/*       */     boolean hasGrid();
/*       */     
/*       */     ItemOuterClass.Grid getGrid();
/*       */     
/*       */     ItemOuterClass.GridOrBuilder getGridOrBuilder();
/*       */     
/*       */     boolean hasDetail();
/*       */     
/*       */     ItemOuterClass.ItemDetail getDetail();
/*       */     
/*       */     ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface TradeBeginPushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasTradePlayer();
/*       */     
/*       */     TradeHandler.TradePlayer getTradePlayer();
/*       */     
/*       */     TradeHandler.TradePlayerOrBuilder getTradePlayerOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface TradePlayerOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     String getId();
/*       */     
/*       */     ByteString getIdBytes();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasUpLevel();
/*       */     
/*       */     int getUpLevel();
/*       */     
/*       */     boolean hasPro();
/*       */     
/*       */     int getPro();
/*       */     
/*       */     boolean hasRelation();
/*       */     
/*       */     int getRelation();
/*       */   }
/*       */   
/*       */   public static interface TradeOperateResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface TradeOperateRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SOperate();
/*       */     
/*       */     int getC2SOperate();
/*       */     
/*       */     boolean hasC2SDiamond();
/*       */     
/*       */     int getC2SDiamond();
/*       */     
/*       */     List<TradeHandler.TradeItem> getC2SItemsList();
/*       */     
/*       */     TradeHandler.TradeItem getC2SItems(int param1Int);
/*       */     
/*       */     int getC2SItemsCount();
/*       */     
/*       */     List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList();
/*       */     
/*       */     TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RemoveItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface RemoveItemRequestOrBuilder extends MessageOrBuilder {
/*       */     List<Integer> getC2SIndexsList();
/*       */     
/*       */     int getC2SIndexsCount();
/*       */     
/*       */     int getC2SIndexs(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface AddItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface AddItemRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SDiamond();
/*       */     
/*       */     int getC2SDiamond();
/*       */     
/*       */     List<TradeHandler.TradeItem> getC2SItemsList();
/*       */     
/*       */     TradeHandler.TradeItem getC2SItems(int param1Int);
/*       */     
/*       */     int getC2SItemsCount();
/*       */     
/*       */     List<? extends TradeHandler.TradeItemOrBuilder> getC2SItemsOrBuilderList();
/*       */     
/*       */     TradeHandler.TradeItemOrBuilder getC2SItemsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface TradeItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasIndex();
/*       */     
/*       */     int getIndex();
/*       */     
/*       */     boolean hasId();
/*       */     
/*       */     String getId();
/*       */     
/*       */     ByteString getIdBytes();
/*       */     
/*       */     boolean hasNum();
/*       */     
/*       */     int getNum();
/*       */   }
/*       */   
/*       */   public static interface InviteResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface InviteRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SPlayerId();
/*       */     
/*       */     String getC2SPlayerId();
/*       */     
/*       */     ByteString getC2SPlayerIdBytes();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\TradeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */