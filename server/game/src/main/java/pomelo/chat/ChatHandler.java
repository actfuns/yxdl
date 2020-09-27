/*      */ package pomelo.chat;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ChatHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class SendChatRequest
/*      */     extends GeneratedMessage
/*      */     implements SendChatRequestOrBuilder
/*      */   {
/*  888 */     private static final SendChatRequest defaultInstance = new SendChatRequest(true); private final UnknownFieldSet unknownFields; private SendChatRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SendChatRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SendChatRequest getDefaultInstance() { return defaultInstance; } public SendChatRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SendChatRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SScope_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.c2SContent_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.c2SServerData_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.c2SAcceptRoleId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_SendChatRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_SendChatRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SendChatRequest.class, Builder.class); } public static Parser<SendChatRequest> PARSER = (Parser<SendChatRequest>)new AbstractParser<SendChatRequest>() { public ChatHandler.SendChatRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.SendChatRequest(input, extensionRegistry); } }
/*  889 */     ; private int bitField0_; public static final int C2S_SCOPE_FIELD_NUMBER = 1; private int c2SScope_; public static final int C2S_CONTENT_FIELD_NUMBER = 2; private Object c2SContent_; public static final int C2S_SERVERDATA_FIELD_NUMBER = 3; private Object c2SServerData_; public static final int C2S_ACCEPTROLEID_FIELD_NUMBER = 4; private Object c2SAcceptRoleId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SendChatRequest> getParserForType() { return PARSER; } public boolean hasC2SScope() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SScope() { return this.c2SScope_; } public boolean hasC2SContent() { return ((this.bitField0_ & 0x2) == 2); } public String getC2SContent() { Object ref = this.c2SContent_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SContent_ = s;  return s; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getC2SContentBytes() {
/*      */       Object ref = this.c2SContent_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SContent_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasC2SServerData() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getC2SServerData() {
/*      */       Object ref = this.c2SServerData_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.c2SServerData_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */     
/*      */     public ByteString getC2SServerDataBytes() {
/*      */       Object ref = this.c2SServerData_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SServerData_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasC2SAcceptRoleId() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getC2SAcceptRoleId() {
/*      */       Object ref = this.c2SAcceptRoleId_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.c2SAcceptRoleId_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */     
/*      */     public ByteString getC2SAcceptRoleIdBytes() {
/*      */       Object ref = this.c2SAcceptRoleId_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SAcceptRoleId_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.c2SScope_ = 0;
/*      */       this.c2SContent_ = "";
/*      */       this.c2SServerData_ = "";
/*      */       this.c2SAcceptRoleId_ = "";
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
/*      */       if (!hasC2SScope()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasC2SContent()) {
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
/*      */         output.writeInt32(1, this.c2SScope_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getC2SContentBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeBytes(3, getC2SServerDataBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeBytes(4, getC2SAcceptRoleIdBytes());
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.c2SScope_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getC2SContentBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeBytesSize(3, getC2SServerDataBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeBytesSize(4, getC2SAcceptRoleIdBytes());
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
/*      */     public static SendChatRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SendChatRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static SendChatRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SendChatRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SendChatRequest)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SendChatRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(InputStream input) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static SendChatRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(SendChatRequest prototype) {
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
/*      */       implements ChatHandler.SendChatRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       private int c2SScope_;
/*      */       private Object c2SContent_;
/*      */       private Object c2SServerData_;
/*      */       private Object c2SAcceptRoleId_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatRequest_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.SendChatRequest.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.c2SContent_ = "";
/*      */         this.c2SServerData_ = "";
/*      */         this.c2SAcceptRoleId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.c2SContent_ = "";
/*      */         this.c2SServerData_ = "";
/*      */         this.c2SAcceptRoleId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (ChatHandler.SendChatRequest.alwaysUseFieldBuilders);
/*      */       }
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.c2SScope_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SContent_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SServerData_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.c2SAcceptRoleId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatRequest_descriptor;
/*      */       }
/*      */       
/*      */       public ChatHandler.SendChatRequest getDefaultInstanceForType() {
/*      */         return ChatHandler.SendChatRequest.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public ChatHandler.SendChatRequest build() {
/*      */         ChatHandler.SendChatRequest result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */       
/*      */       public ChatHandler.SendChatRequest buildPartial() {
/*      */         ChatHandler.SendChatRequest result = new ChatHandler.SendChatRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SScope_ = this.c2SScope_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.c2SContent_ = this.c2SContent_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.c2SServerData_ = this.c2SServerData_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.c2SAcceptRoleId_ = this.c2SAcceptRoleId_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ChatHandler.SendChatRequest) {
/*      */           return mergeFrom((ChatHandler.SendChatRequest)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(ChatHandler.SendChatRequest other) {
/*      */         if (other == ChatHandler.SendChatRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SScope()) {
/*      */           setC2SScope(other.getC2SScope());
/*      */         }
/*      */         if (other.hasC2SContent()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.c2SContent_ = other.c2SContent_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasC2SServerData()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.c2SServerData_ = other.c2SServerData_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasC2SAcceptRoleId()) {
/*      */           this.bitField0_ |= 0x8;
/*      */           this.c2SAcceptRoleId_ = other.c2SAcceptRoleId_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasC2SScope()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasC2SContent()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ChatHandler.SendChatRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.SendChatRequest)ChatHandler.SendChatRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.SendChatRequest)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SScope() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public int getC2SScope() {
/*      */         return this.c2SScope_;
/*      */       }
/*      */       
/*      */       public Builder setC2SScope(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SScope_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SScope() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SScope_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SContent() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
/*      */       public String getC2SContent() {
/*      */         Object ref = this.c2SContent_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SContent_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getC2SContentBytes() {
/*      */         Object ref = this.c2SContent_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SContent_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setC2SContent(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SContent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SContent() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SContent_ = ChatHandler.SendChatRequest.getDefaultInstance().getC2SContent();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setC2SContentBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SContent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SServerData() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public String getC2SServerData() {
/*      */         Object ref = this.c2SServerData_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SServerData_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getC2SServerDataBytes() {
/*      */         Object ref = this.c2SServerData_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SServerData_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setC2SServerData(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2SServerData_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SServerData() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.c2SServerData_ = ChatHandler.SendChatRequest.getDefaultInstance().getC2SServerData();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setC2SServerDataBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2SServerData_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SAcceptRoleId() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       
/*      */       public String getC2SAcceptRoleId() {
/*      */         Object ref = this.c2SAcceptRoleId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SAcceptRoleId_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getC2SAcceptRoleIdBytes() {
/*      */         Object ref = this.c2SAcceptRoleId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SAcceptRoleId_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setC2SAcceptRoleId(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x8;
/*      */         this.c2SAcceptRoleId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SAcceptRoleId() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.c2SAcceptRoleId_ = ChatHandler.SendChatRequest.getDefaultInstance().getC2SAcceptRoleId();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setC2SAcceptRoleIdBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x8;
/*      */         this.c2SAcceptRoleId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class SendChatResponse
/*      */     extends GeneratedMessage
/*      */     implements SendChatResponseOrBuilder
/*      */   {
/* 1450 */     private static final SendChatResponse defaultInstance = new SendChatResponse(true); private final UnknownFieldSet unknownFields; private SendChatResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SendChatResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SendChatResponse getDefaultInstance() { return defaultInstance; } public SendChatResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SendChatResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_SendChatResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_SendChatResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SendChatResponse.class, Builder.class); } public static Parser<SendChatResponse> PARSER = (Parser<SendChatResponse>)new AbstractParser<SendChatResponse>() { public ChatHandler.SendChatResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.SendChatResponse(input, extensionRegistry); } }
/* 1451 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SendChatResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
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
/*      */     public static SendChatResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SendChatResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SendChatResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SendChatResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SendChatResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(InputStream input) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SendChatResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SendChatResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(SendChatResponse prototype) {
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
/*      */       implements ChatHandler.SendChatResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
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
/*      */       private Object s2CMsg_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatResponse_descriptor;
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
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.SendChatResponse.class, Builder.class);
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
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (ChatHandler.SendChatResponse.alwaysUseFieldBuilders);
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
/*      */         return ChatHandler.internal_static_pomelo_chat_SendChatResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.SendChatResponse getDefaultInstanceForType() {
/*      */         return ChatHandler.SendChatResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.SendChatResponse build() {
/*      */         ChatHandler.SendChatResponse result = buildPartial();
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
/*      */       public ChatHandler.SendChatResponse buildPartial() {
/*      */         ChatHandler.SendChatResponse result = new ChatHandler.SendChatResponse(this);
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ChatHandler.SendChatResponse) {
/*      */           return mergeFrom((ChatHandler.SendChatResponse)other);
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
/*      */       public Builder mergeFrom(ChatHandler.SendChatResponse other) {
/*      */         if (other == ChatHandler.SendChatResponse.getDefaultInstance()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ChatHandler.SendChatResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.SendChatResponse)ChatHandler.SendChatResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.SendChatResponse)e.getUnfinishedMessage();
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
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = ChatHandler.SendChatResponse.getDefaultInstance().getS2CMsg();
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
/*      */   public static final class GetSaveChatMsgRequest
/*      */     extends GeneratedMessage
/*      */     implements GetSaveChatMsgRequestOrBuilder
/*      */   {
/* 2170 */     private static final GetSaveChatMsgRequest defaultInstance = new GetSaveChatMsgRequest(true); private final UnknownFieldSet unknownFields; private GetSaveChatMsgRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetSaveChatMsgRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetSaveChatMsgRequest getDefaultInstance() { return defaultInstance; } public GetSaveChatMsgRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetSaveChatMsgRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SScope_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SIndex_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.c2SUid_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSaveChatMsgRequest.class, Builder.class); } public static Parser<GetSaveChatMsgRequest> PARSER = (Parser<GetSaveChatMsgRequest>)new AbstractParser<GetSaveChatMsgRequest>() { public ChatHandler.GetSaveChatMsgRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.GetSaveChatMsgRequest(input, extensionRegistry); } }
/* 2171 */     ; private int bitField0_; public static final int C2S_SCOPE_FIELD_NUMBER = 1; private int c2SScope_; public static final int C2S_INDEX_FIELD_NUMBER = 2; private int c2SIndex_; public static final int C2S_UID_FIELD_NUMBER = 3; private Object c2SUid_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetSaveChatMsgRequest> getParserForType() { return PARSER; } public boolean hasC2SScope() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SScope() { return this.c2SScope_; } public boolean hasC2SIndex() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getC2SIndex() {
/*      */       return this.c2SIndex_;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasC2SUid() {
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getC2SUid() {
/*      */       Object ref = this.c2SUid_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.c2SUid_ = s;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getC2SUidBytes() {
/*      */       Object ref = this.c2SUid_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SUid_ = b;
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */       this.c2SScope_ = 0;
/*      */       this.c2SIndex_ = 0;
/*      */       this.c2SUid_ = "";
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
/*      */ 
/*      */ 
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
/*      */       if (!hasC2SScope()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasC2SIndex()) {
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
/*      */ 
/*      */ 
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
/*      */         output.writeInt32(1, this.c2SScope_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.c2SIndex_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeBytes(3, getC2SUidBytes());
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
/*      */ 
/*      */ 
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.c2SScope_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.c2SIndex_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeBytesSize(3, getC2SUidBytes());
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(data);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(data);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(InputStream input) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(input);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseDelimitedFrom(input);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(input);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GetSaveChatMsgRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(GetSaveChatMsgRequest prototype) {
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
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
/*      */       implements ChatHandler.GetSaveChatMsgRequestOrBuilder
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int c2SScope_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int c2SIndex_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object c2SUid_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgRequest_descriptor;
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
/*      */ 
/*      */ 
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
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.GetSaveChatMsgRequest.class, Builder.class);
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
/*      */ 
/*      */ 
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
/*      */         this.c2SUid_ = "";
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         this.c2SUid_ = "";
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         if (ChatHandler.GetSaveChatMsgRequest.alwaysUseFieldBuilders);
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
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         this.c2SScope_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SIndex_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SUid_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgRequest_descriptor;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgRequest getDefaultInstanceForType() {
/*      */         return ChatHandler.GetSaveChatMsgRequest.getDefaultInstance();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgRequest build() {
/*      */         ChatHandler.GetSaveChatMsgRequest result = buildPartial();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgRequest buildPartial() {
/*      */         ChatHandler.GetSaveChatMsgRequest result = new ChatHandler.GetSaveChatMsgRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SScope_ = this.c2SScope_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.c2SIndex_ = this.c2SIndex_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.c2SUid_ = this.c2SUid_;
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         if (other instanceof ChatHandler.GetSaveChatMsgRequest) {
/*      */           return mergeFrom((ChatHandler.GetSaveChatMsgRequest)other);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(ChatHandler.GetSaveChatMsgRequest other) {
/*      */         if (other == ChatHandler.GetSaveChatMsgRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SScope()) {
/*      */           setC2SScope(other.getC2SScope());
/*      */         }
/*      */         if (other.hasC2SIndex()) {
/*      */           setC2SIndex(other.getC2SIndex());
/*      */         }
/*      */         if (other.hasC2SUid()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.c2SUid_ = other.c2SUid_;
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         if (!hasC2SScope()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasC2SIndex()) {
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */         ChatHandler.GetSaveChatMsgRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.GetSaveChatMsgRequest)ChatHandler.GetSaveChatMsgRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.GetSaveChatMsgRequest)e.getUnfinishedMessage();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasC2SScope() {
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getC2SScope() {
/*      */         return this.c2SScope_;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SScope(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SScope_ = value;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearC2SScope() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SScope_ = 0;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasC2SIndex() {
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getC2SIndex() {
/*      */         return this.c2SIndex_;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SIndex(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SIndex_ = value;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearC2SIndex() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SIndex_ = 0;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasC2SUid() {
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getC2SUid() {
/*      */         Object ref = this.c2SUid_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SUid_ = s;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getC2SUidBytes() {
/*      */         Object ref = this.c2SUid_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SUid_ = b;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SUid(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2SUid_ = value;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearC2SUid() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.c2SUid_ = ChatHandler.GetSaveChatMsgRequest.getDefaultInstance().getC2SUid();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SUidBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2SUid_ = value;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class OnChatPush
/*      */     extends GeneratedMessage
/*      */     implements OnChatPushOrBuilder
/*      */   {
/* 3809 */     private static final OnChatPush defaultInstance = new OnChatPush(true); private final UnknownFieldSet unknownFields; private OnChatPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OnChatPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OnChatPush getDefaultInstance() { return defaultInstance; } public OnChatPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OnChatPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x1; this.s2CPlayerId_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CUid_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CContent_ = bs; break;case 40: this.bitField0_ |= 0x8; this.s2CScope_ = input.readInt32(); break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x10; this.s2CTime_ = bs; break;case 56: this.bitField0_ |= 0x20; this.s2CSys_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x40; this.s2CIndex_ = input.readInt32(); break;case 74: bs = input.readBytes(); this.bitField0_ |= 0x80; this.s2CServerData_ = bs; break;case 82: bs = input.readBytes(); this.bitField0_ |= 0x100; this.s2CAcceptRid_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_OnChatPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_OnChatPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnChatPush.class, Builder.class); } public static Parser<OnChatPush> PARSER = (Parser<OnChatPush>)new AbstractParser<OnChatPush>() { public ChatHandler.OnChatPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.OnChatPush(input, extensionRegistry); } }
/* 3810 */     ; private int bitField0_; public static final int S2C_PLAYERID_FIELD_NUMBER = 2; private Object s2CPlayerId_; public static final int S2C_UID_FIELD_NUMBER = 3; private Object s2CUid_; public static final int S2C_CONTENT_FIELD_NUMBER = 4; private Object s2CContent_; public static final int S2C_SCOPE_FIELD_NUMBER = 5; private int s2CScope_; static { defaultInstance.initFields(); }
/*      */ 
/*      */     
/*      */     public static final int S2C_TIME_FIELD_NUMBER = 6;
/*      */     private Object s2CTime_;
/*      */     public static final int S2C_SYS_FIELD_NUMBER = 7;
/*      */     private int s2CSys_;
/*      */     public static final int S2C_INDEX_FIELD_NUMBER = 8;
/*      */     private int s2CIndex_;
/*      */     public static final int S2C_SERVERDATA_FIELD_NUMBER = 9;
/*      */     private Object s2CServerData_;
/*      */     public static final int S2C_ACCEPTRID_FIELD_NUMBER = 10;
/*      */     private Object s2CAcceptRid_;
/*      */     private byte memoizedIsInitialized;
/*      */     private int memoizedSerializedSize;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     public Parser<OnChatPush> getParserForType() {
/*      */       return PARSER;
/*      */     }
/*      */     
/*      */     public boolean hasS2CPlayerId() {
/*      */       return ((this.bitField0_ & 0x1) == 1);
/*      */     }
/*      */     
/*      */     public String getS2CPlayerId() {
/*      */       Object ref = this.s2CPlayerId_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CPlayerId_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CPlayerIdBytes() {
/*      */       Object ref = this.s2CPlayerId_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CPlayerId_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     public boolean hasS2CUid() {
/*      */       return ((this.bitField0_ & 0x2) == 2);
/*      */     }
/*      */     
/*      */     public String getS2CUid() {
/*      */       Object ref = this.s2CUid_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CUid_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CUidBytes() {
/*      */       Object ref = this.s2CUid_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CUid_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     public boolean hasS2CContent() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */     
/*      */     public String getS2CContent() {
/*      */       Object ref = this.s2CContent_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CContent_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CContentBytes() {
/*      */       Object ref = this.s2CContent_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CContent_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     public boolean hasS2CScope() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */     
/*      */     public int getS2CScope() {
/*      */       return this.s2CScope_;
/*      */     }
/*      */     
/*      */     public boolean hasS2CTime() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */     
/*      */     public String getS2CTime() {
/*      */       Object ref = this.s2CTime_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CTime_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CTimeBytes() {
/*      */       Object ref = this.s2CTime_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CTime_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     public boolean hasS2CSys() {
/*      */       return ((this.bitField0_ & 0x20) == 32);
/*      */     }
/*      */     
/*      */     public int getS2CSys() {
/*      */       return this.s2CSys_;
/*      */     }
/*      */     
/*      */     public boolean hasS2CIndex() {
/*      */       return ((this.bitField0_ & 0x40) == 64);
/*      */     }
/*      */     
/*      */     public int getS2CIndex() {
/*      */       return this.s2CIndex_;
/*      */     }
/*      */     
/*      */     public boolean hasS2CServerData() {
/*      */       return ((this.bitField0_ & 0x80) == 128);
/*      */     }
/*      */     
/*      */     public String getS2CServerData() {
/*      */       Object ref = this.s2CServerData_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CServerData_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CServerDataBytes() {
/*      */       Object ref = this.s2CServerData_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CServerData_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     public boolean hasS2CAcceptRid() {
/*      */       return ((this.bitField0_ & 0x100) == 256);
/*      */     }
/*      */     
/*      */     public String getS2CAcceptRid() {
/*      */       Object ref = this.s2CAcceptRid_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CAcceptRid_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CAcceptRidBytes() {
/*      */       Object ref = this.s2CAcceptRid_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CAcceptRid_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CPlayerId_ = "";
/*      */       this.s2CUid_ = "";
/*      */       this.s2CContent_ = "";
/*      */       this.s2CScope_ = 0;
/*      */       this.s2CTime_ = "";
/*      */       this.s2CSys_ = 0;
/*      */       this.s2CIndex_ = 0;
/*      */       this.s2CServerData_ = "";
/*      */       this.s2CAcceptRid_ = "";
/*      */     }
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CPlayerId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasS2CUid()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasS2CContent()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasS2CScope()) {
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
/*      */         output.writeBytes(2, getS2CPlayerIdBytes()); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(3, getS2CUidBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeBytes(4, getS2CContentBytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeInt32(5, this.s2CScope_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeBytes(6, getS2CTimeBytes()); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         output.writeInt32(7, this.s2CSys_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         output.writeInt32(8, this.s2CIndex_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         output.writeBytes(9, getS2CServerDataBytes()); 
/*      */       if ((this.bitField0_ & 0x100) == 256)
/*      */         output.writeBytes(10, getS2CAcceptRidBytes()); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CPlayerIdBytes()); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(3, getS2CUidBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeBytesSize(4, getS2CContentBytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeInt32Size(5, this.s2CScope_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeBytesSize(6, getS2CTimeBytes()); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         size += CodedOutputStream.computeInt32Size(7, this.s2CSys_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         size += CodedOutputStream.computeInt32Size(8, this.s2CIndex_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         size += CodedOutputStream.computeBytesSize(9, getS2CServerDataBytes()); 
/*      */       if ((this.bitField0_ & 0x100) == 256)
/*      */         size += CodedOutputStream.computeBytesSize(10, getS2CAcceptRidBytes()); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (OnChatPush)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (OnChatPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (OnChatPush)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (OnChatPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(InputStream input) throws IOException {
/*      */       return (OnChatPush)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatPush)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (OnChatPush)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatPush)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(CodedInputStream input) throws IOException {
/*      */       return (OnChatPush)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static OnChatPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatPush)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(OnChatPush prototype) {
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
/*      */       implements ChatHandler.OnChatPushOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       private Object s2CPlayerId_;
/*      */       private Object s2CUid_;
/*      */       private Object s2CContent_;
/*      */       private int s2CScope_;
/*      */       private Object s2CTime_;
/*      */       private int s2CSys_;
/*      */       private int s2CIndex_;
/*      */       private Object s2CServerData_;
/*      */       private Object s2CAcceptRid_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatPush_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.OnChatPush.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CPlayerId_ = "";
/*      */         this.s2CUid_ = "";
/*      */         this.s2CContent_ = "";
/*      */         this.s2CTime_ = "";
/*      */         this.s2CServerData_ = "";
/*      */         this.s2CAcceptRid_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CPlayerId_ = "";
/*      */         this.s2CUid_ = "";
/*      */         this.s2CContent_ = "";
/*      */         this.s2CTime_ = "";
/*      */         this.s2CServerData_ = "";
/*      */         this.s2CAcceptRid_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (ChatHandler.OnChatPush.alwaysUseFieldBuilders);
/*      */       }
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CPlayerId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CUid_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CContent_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CScope_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CTime_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.s2CSys_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.s2CIndex_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.s2CServerData_ = "";
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.s2CAcceptRid_ = "";
/*      */         this.bitField0_ &= 0xFFFFFEFF;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatPush_descriptor;
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush getDefaultInstanceForType() {
/*      */         return ChatHandler.OnChatPush.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush build() {
/*      */         ChatHandler.OnChatPush result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush buildPartial() {
/*      */         ChatHandler.OnChatPush result = new ChatHandler.OnChatPush(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CPlayerId_ = this.s2CPlayerId_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CUid_ = this.s2CUid_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.s2CContent_ = this.s2CContent_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.s2CScope_ = this.s2CScope_;
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.s2CTime_ = this.s2CTime_;
/*      */         if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x20; 
/*      */         result.s2CSys_ = this.s2CSys_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x40; 
/*      */         result.s2CIndex_ = this.s2CIndex_;
/*      */         if ((from_bitField0_ & 0x80) == 128)
/*      */           to_bitField0_ |= 0x80; 
/*      */         result.s2CServerData_ = this.s2CServerData_;
/*      */         if ((from_bitField0_ & 0x100) == 256)
/*      */           to_bitField0_ |= 0x100; 
/*      */         result.s2CAcceptRid_ = this.s2CAcceptRid_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ChatHandler.OnChatPush)
/*      */           return mergeFrom((ChatHandler.OnChatPush)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(ChatHandler.OnChatPush other) {
/*      */         if (other == ChatHandler.OnChatPush.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CPlayerId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.s2CPlayerId_ = other.s2CPlayerId_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CUid()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CUid_ = other.s2CUid_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CContent()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.s2CContent_ = other.s2CContent_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CScope())
/*      */           setS2CScope(other.getS2CScope()); 
/*      */         if (other.hasS2CTime()) {
/*      */           this.bitField0_ |= 0x10;
/*      */           this.s2CTime_ = other.s2CTime_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CSys())
/*      */           setS2CSys(other.getS2CSys()); 
/*      */         if (other.hasS2CIndex())
/*      */           setS2CIndex(other.getS2CIndex()); 
/*      */         if (other.hasS2CServerData()) {
/*      */           this.bitField0_ |= 0x80;
/*      */           this.s2CServerData_ = other.s2CServerData_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CAcceptRid()) {
/*      */           this.bitField0_ |= 0x100;
/*      */           this.s2CAcceptRid_ = other.s2CAcceptRid_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CPlayerId())
/*      */           return false; 
/*      */         if (!hasS2CUid())
/*      */           return false; 
/*      */         if (!hasS2CContent())
/*      */           return false; 
/*      */         if (!hasS2CScope())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ChatHandler.OnChatPush parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.OnChatPush)ChatHandler.OnChatPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.OnChatPush)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CPlayerId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public String getS2CPlayerId() {
/*      */         Object ref = this.s2CPlayerId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CPlayerId_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CPlayerIdBytes() {
/*      */         Object ref = this.s2CPlayerId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CPlayerId_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CPlayerId(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CPlayerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CPlayerId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CPlayerId_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CPlayerId();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CPlayerIdBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CPlayerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CUid() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
/*      */       public String getS2CUid() {
/*      */         Object ref = this.s2CUid_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CUid_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CUidBytes() {
/*      */         Object ref = this.s2CUid_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CUid_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CUid(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CUid_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CUid() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CUid_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CUid();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CUidBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CUid_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CContent() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public String getS2CContent() {
/*      */         Object ref = this.s2CContent_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CContent_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CContentBytes() {
/*      */         Object ref = this.s2CContent_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CContent_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CContent(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CContent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CContent() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CContent_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CContent();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CContentBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CContent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CScope() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       
/*      */       public int getS2CScope() {
/*      */         return this.s2CScope_;
/*      */       }
/*      */       
/*      */       public Builder setS2CScope(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.s2CScope_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CScope() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CScope_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CTime() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */       
/*      */       public String getS2CTime() {
/*      */         Object ref = this.s2CTime_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CTime_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CTimeBytes() {
/*      */         Object ref = this.s2CTime_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CTime_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CTime(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x10;
/*      */         this.s2CTime_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CTime() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.s2CTime_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CTime();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CTimeBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x10;
/*      */         this.s2CTime_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CSys() {
/*      */         return ((this.bitField0_ & 0x20) == 32);
/*      */       }
/*      */       
/*      */       public int getS2CSys() {
/*      */         return this.s2CSys_;
/*      */       }
/*      */       
/*      */       public Builder setS2CSys(int value) {
/*      */         this.bitField0_ |= 0x20;
/*      */         this.s2CSys_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CSys() {
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.s2CSys_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CIndex() {
/*      */         return ((this.bitField0_ & 0x40) == 64);
/*      */       }
/*      */       
/*      */       public int getS2CIndex() {
/*      */         return this.s2CIndex_;
/*      */       }
/*      */       
/*      */       public Builder setS2CIndex(int value) {
/*      */         this.bitField0_ |= 0x40;
/*      */         this.s2CIndex_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CIndex() {
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.s2CIndex_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CServerData() {
/*      */         return ((this.bitField0_ & 0x80) == 128);
/*      */       }
/*      */       
/*      */       public String getS2CServerData() {
/*      */         Object ref = this.s2CServerData_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CServerData_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CServerDataBytes() {
/*      */         Object ref = this.s2CServerData_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CServerData_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CServerData(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x80;
/*      */         this.s2CServerData_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CServerData() {
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.s2CServerData_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CServerData();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CServerDataBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x80;
/*      */         this.s2CServerData_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasS2CAcceptRid() {
/*      */         return ((this.bitField0_ & 0x100) == 256);
/*      */       }
/*      */       
/*      */       public String getS2CAcceptRid() {
/*      */         Object ref = this.s2CAcceptRid_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CAcceptRid_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CAcceptRidBytes() {
/*      */         Object ref = this.s2CAcceptRid_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CAcceptRid_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CAcceptRid(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x100;
/*      */         this.s2CAcceptRid_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CAcceptRid() {
/*      */         this.bitField0_ &= 0xFFFFFEFF;
/*      */         this.s2CAcceptRid_ = ChatHandler.OnChatPush.getDefaultInstance().getS2CAcceptRid();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CAcceptRidBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x100;
/*      */         this.s2CAcceptRid_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class GetSaveChatMsgResponse
/*      */     extends GeneratedMessage
/*      */     implements GetSaveChatMsgResponseOrBuilder
/*      */   {
/* 4743 */     private static final GetSaveChatMsgResponse defaultInstance = new GetSaveChatMsgResponse(true); private final UnknownFieldSet unknownFields; private GetSaveChatMsgResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetSaveChatMsgResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetSaveChatMsgResponse getDefaultInstance() { return defaultInstance; } public GetSaveChatMsgResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetSaveChatMsgResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CData_.add(input.readMessage(ChatHandler.OnChatPush.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSaveChatMsgResponse.class, Builder.class); } public static Parser<GetSaveChatMsgResponse> PARSER = (Parser<GetSaveChatMsgResponse>)new AbstractParser<GetSaveChatMsgResponse>() { public ChatHandler.GetSaveChatMsgResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.GetSaveChatMsgResponse(input, extensionRegistry); } }
/* 4744 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private List<ChatHandler.OnChatPush> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetSaveChatMsgResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */     
/*      */     public List<ChatHandler.OnChatPush> getS2CDataList() {
/*      */       return this.s2CData_;
/*      */     }
/*      */     
/*      */     public List<? extends ChatHandler.OnChatPushOrBuilder> getS2CDataOrBuilderList() {
/*      */       return (List)this.s2CData_;
/*      */     }
/*      */     
/*      */     public int getS2CDataCount() {
/*      */       return this.s2CData_.size();
/*      */     }
/*      */     
/*      */     public ChatHandler.OnChatPush getS2CData(int index) {
/*      */       return this.s2CData_.get(index);
/*      */     }
/*      */     
/*      */     public ChatHandler.OnChatPushOrBuilder getS2CDataOrBuilder(int index) {
/*      */       return this.s2CData_.get(index);
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CData_ = Collections.emptyList();
/*      */     }
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
/*      */       for (int i = 0; i < getS2CDataCount(); i++) {
/*      */         if (!getS2CData(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getS2CMsgBytes());
/*      */       }
/*      */       for (int i = 0; i < this.s2CData_.size(); i++) {
/*      */         output.writeMessage(3, (MessageLite)this.s2CData_.get(i));
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */       for (int i = 0; i < this.s2CData_.size(); i++) {
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_.get(i));
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(InputStream input) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static GetSaveChatMsgResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetSaveChatMsgResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(GetSaveChatMsgResponse prototype) {
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
/*      */       implements ChatHandler.GetSaveChatMsgResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private List<ChatHandler.OnChatPush> s2CData_;
/*      */       private RepeatedFieldBuilder<ChatHandler.OnChatPush, ChatHandler.OnChatPush.Builder, ChatHandler.OnChatPushOrBuilder> s2CDataBuilder_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgResponse_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.GetSaveChatMsgResponse.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CData_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CData_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (ChatHandler.GetSaveChatMsgResponse.alwaysUseFieldBuilders) {
/*      */           getS2CDataFieldBuilder();
/*      */         }
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
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CData_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.s2CDataBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return ChatHandler.internal_static_pomelo_chat_GetSaveChatMsgResponse_descriptor;
/*      */       }
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgResponse getDefaultInstanceForType() {
/*      */         return ChatHandler.GetSaveChatMsgResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgResponse build() {
/*      */         ChatHandler.GetSaveChatMsgResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */       
/*      */       public ChatHandler.GetSaveChatMsgResponse buildPartial() {
/*      */         ChatHandler.GetSaveChatMsgResponse result = new ChatHandler.GetSaveChatMsgResponse(this);
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
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } 
/*      */           result.s2CData_ = this.s2CData_;
/*      */         } else {
/*      */           result.s2CData_ = this.s2CDataBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ChatHandler.GetSaveChatMsgResponse) {
/*      */           return mergeFrom((ChatHandler.GetSaveChatMsgResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(ChatHandler.GetSaveChatMsgResponse other) {
/*      */         if (other == ChatHandler.GetSaveChatMsgResponse.getDefaultInstance()) {
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
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (!other.s2CData_.isEmpty()) {
/*      */             if (this.s2CData_.isEmpty()) {
/*      */               this.s2CData_ = other.s2CData_;
/*      */               this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureS2CDataIsMutable();
/*      */               this.s2CData_.addAll(other.s2CData_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CData_.isEmpty()) {
/*      */           if (this.s2CDataBuilder_.isEmpty()) {
/*      */             this.s2CDataBuilder_.dispose();
/*      */             this.s2CDataBuilder_ = null;
/*      */             this.s2CData_ = other.s2CData_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */             this.s2CDataBuilder_ = ChatHandler.GetSaveChatMsgResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CDataBuilder_.addAllMessages(other.s2CData_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         for (int i = 0; i < getS2CDataCount(); i++) {
/*      */           if (!getS2CData(i).isInitialized()) {
/*      */             return false;
/*      */           }
/*      */         } 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ChatHandler.GetSaveChatMsgResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.GetSaveChatMsgResponse)ChatHandler.GetSaveChatMsgResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.GetSaveChatMsgResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = ChatHandler.GetSaveChatMsgResponse.getDefaultInstance().getS2CMsg();
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
/*      */       }
/*      */       
/*      */       private void ensureS2CDataIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.s2CData_ = new ArrayList<>(this.s2CData_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */       
/*      */       public List<ChatHandler.OnChatPush> getS2CDataList() {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CData_); 
/*      */         return this.s2CDataBuilder_.getMessageList();
/*      */       }
/*      */       
/*      */       public int getS2CDataCount() {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return this.s2CData_.size(); 
/*      */         return this.s2CDataBuilder_.getCount();
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush getS2CData(int index) {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return this.s2CData_.get(index); 
/*      */         return (ChatHandler.OnChatPush)this.s2CDataBuilder_.getMessage(index);
/*      */       }
/*      */       
/*      */       public Builder setS2CData(int index, ChatHandler.OnChatPush value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CData(int index, ChatHandler.OnChatPush.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CData(ChatHandler.OnChatPush value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CData(int index, ChatHandler.OnChatPush value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CData(ChatHandler.OnChatPush.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CData(int index, ChatHandler.OnChatPush.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addAllS2CData(Iterable<? extends ChatHandler.OnChatPush> values) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CData_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CData() {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CData_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder removeS2CData(int index) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush.Builder getS2CDataBuilder(int index) {
/*      */         return (ChatHandler.OnChatPush.Builder)getS2CDataFieldBuilder().getBuilder(index);
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPushOrBuilder getS2CDataOrBuilder(int index) {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return this.s2CData_.get(index); 
/*      */         return (ChatHandler.OnChatPushOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       
/*      */       public List<? extends ChatHandler.OnChatPushOrBuilder> getS2CDataOrBuilderList() {
/*      */         if (this.s2CDataBuilder_ != null)
/*      */           return this.s2CDataBuilder_.getMessageOrBuilderList(); 
/*      */         return Collections.unmodifiableList((List)this.s2CData_);
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush.Builder addS2CDataBuilder() {
/*      */         return (ChatHandler.OnChatPush.Builder)getS2CDataFieldBuilder().addBuilder(ChatHandler.OnChatPush.getDefaultInstance());
/*      */       }
/*      */       
/*      */       public ChatHandler.OnChatPush.Builder addS2CDataBuilder(int index) {
/*      */         return (ChatHandler.OnChatPush.Builder)getS2CDataFieldBuilder().addBuilder(index, ChatHandler.OnChatPush.getDefaultInstance());
/*      */       }
/*      */       
/*      */       public List<ChatHandler.OnChatPush.Builder> getS2CDataBuilderList() {
/*      */         return getS2CDataFieldBuilder().getBuilderList();
/*      */       }
/*      */       
/*      */       private RepeatedFieldBuilder<ChatHandler.OnChatPush, ChatHandler.OnChatPush.Builder, ChatHandler.OnChatPushOrBuilder> getS2CDataFieldBuilder() {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.s2CData_ = null;
/*      */         } 
/*      */         return this.s2CDataBuilder_;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class OnChatErrorPush
/*      */     extends GeneratedMessage
/*      */     implements OnChatErrorPushOrBuilder
/*      */   {
/* 5313 */     private static final OnChatErrorPush defaultInstance = new OnChatErrorPush(true); private final UnknownFieldSet unknownFields; private OnChatErrorPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OnChatErrorPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OnChatErrorPush getDefaultInstance() { return defaultInstance; } public OnChatErrorPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OnChatErrorPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_OnChatErrorPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_OnChatErrorPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnChatErrorPush.class, Builder.class); } public static Parser<OnChatErrorPush> PARSER = (Parser<OnChatErrorPush>)new AbstractParser<OnChatErrorPush>() { public ChatHandler.OnChatErrorPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ChatHandler.OnChatErrorPush(input, extensionRegistry); } }
/* 5314 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OnChatErrorPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*      */       if (!hasS2CMsg()) {
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
/*      */     public static OnChatErrorPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(InputStream input) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(CodedInputStream input) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static OnChatErrorPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (OnChatErrorPush)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(OnChatErrorPush prototype) {
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
/*      */       implements ChatHandler.OnChatErrorPushOrBuilder
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
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatErrorPush_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatErrorPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.OnChatErrorPush.class, Builder.class);
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
/*      */         if (ChatHandler.OnChatErrorPush.alwaysUseFieldBuilders);
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
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
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
/*      */         return ChatHandler.internal_static_pomelo_chat_OnChatErrorPush_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.OnChatErrorPush getDefaultInstanceForType() {
/*      */         return ChatHandler.OnChatErrorPush.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.OnChatErrorPush build() {
/*      */         ChatHandler.OnChatErrorPush result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ChatHandler.OnChatErrorPush buildPartial() {
/*      */         ChatHandler.OnChatErrorPush result = new ChatHandler.OnChatErrorPush(this);
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof ChatHandler.OnChatErrorPush) {
/*      */           return mergeFrom((ChatHandler.OnChatErrorPush)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(ChatHandler.OnChatErrorPush other) {
/*      */         if (other == ChatHandler.OnChatErrorPush.getDefaultInstance()) {
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasS2CMsg()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         ChatHandler.OnChatErrorPush parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (ChatHandler.OnChatErrorPush)ChatHandler.OnChatErrorPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (ChatHandler.OnChatErrorPush)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
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
/*      */         this.s2CMsg_ = ChatHandler.OnChatErrorPush.getDefaultInstance().getS2CMsg();
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
/*      */   public static final class TipPush
/*      */     extends GeneratedMessage
/*      */     implements TipPushOrBuilder
/*      */   {
/*      */     private final UnknownFieldSet unknownFields;
/*      */ 
/*      */ 
/*      */     
/*      */     private TipPush(GeneratedMessage.Builder<?> builder) {
/*      */       super(builder);
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = builder.getUnknownFields();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private TipPush(boolean noInit) {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static TipPush getDefaultInstance() {
/*      */       return defaultInstance;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public TipPush getDefaultInstanceForType() {
/*      */       return defaultInstance;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final UnknownFieldSet getUnknownFields() {
/*      */       return this.unknownFields;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private TipPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       initFields();
/*      */       int mutable_bitField0_ = 0;
/*      */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*      */       try {
/*      */         boolean done = false;
/*      */         while (!done) {
/*      */           ByteString bs;
/*      */           int tag = input.readTag();
/*      */           switch (tag) {
/*      */             case 0:
/*      */               done = true;
/*      */               break;
/*      */             case 18:
/*      */               bs = input.readBytes();
/*      */               this.bitField0_ |= 0x1;
/*      */               this.s2CMsg_ = bs;
/*      */               break;
/*      */             case 24:
/*      */               this.bitField0_ |= 0x2;
/*      */               this.s2CType_ = input.readInt32();
/*      */               break;
/*      */           } 
/*      */         } 
/*      */       } catch (InvalidProtocolBufferException e) {
/*      */         throw e.setUnfinishedMessage(this);
/*      */       } catch (IOException e) {
/*      */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*      */       } finally {
/*      */         this.unknownFields = unknownFields.build();
/*      */         makeExtensionsImmutable();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static final Descriptors.Descriptor getDescriptor() {
/*      */       return ChatHandler.internal_static_pomelo_chat_TipPush_descriptor;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */       return ChatHandler.internal_static_pomelo_chat_TipPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TipPush.class, Builder.class);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Parser<TipPush> PARSER = (Parser<TipPush>)new AbstractParser<TipPush>()
/*      */       {
/*      */         public ChatHandler.TipPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */           return new ChatHandler.TipPush(input, extensionRegistry);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/*      */     private int bitField0_;
/*      */ 
/*      */     
/*      */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*      */ 
/*      */     
/*      */     private Object s2CMsg_;
/*      */ 
/*      */     
/*      */     public static final int S2C_TYPE_FIELD_NUMBER = 3;
/*      */ 
/*      */     
/*      */     private int s2CType_;
/*      */ 
/*      */     
/*      */     private byte memoizedIsInitialized;
/*      */ 
/*      */     
/*      */     private int memoizedSerializedSize;
/*      */ 
/*      */     
/* 5923 */     private static final TipPush defaultInstance = new TipPush(true);
/* 5924 */     private static final long serialVersionUID = 0L; public Parser<TipPush> getParserForType() { return PARSER; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x1) == 1); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CType() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CType() { return this.s2CType_; } private void initFields() { this.s2CMsg_ = ""; this.s2CType_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CMsg()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CType()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(3, this.s2CType_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(3, this.s2CType_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static TipPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (TipPush)PARSER.parseFrom(data); } public static TipPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TipPush)PARSER.parseFrom(data, extensionRegistry); } public static TipPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (TipPush)PARSER.parseFrom(data); } public static TipPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TipPush)PARSER.parseFrom(data, extensionRegistry); } public static TipPush parseFrom(InputStream input) throws IOException { return (TipPush)PARSER.parseFrom(input); } public static TipPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TipPush)PARSER.parseFrom(input, extensionRegistry); } public static TipPush parseDelimitedFrom(InputStream input) throws IOException { return (TipPush)PARSER.parseDelimitedFrom(input); } public static TipPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TipPush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static TipPush parseFrom(CodedInputStream input) throws IOException { return (TipPush)PARSER.parseFrom(input); } public static TipPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TipPush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(TipPush prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } static { defaultInstance.initFields(); }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ChatHandler.TipPushOrBuilder {
/*      */       private int bitField0_;
/*      */       private Object s2CMsg_;
/*      */       private int s2CType_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return ChatHandler.internal_static_pomelo_chat_TipPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ChatHandler.internal_static_pomelo_chat_TipPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatHandler.TipPush.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (ChatHandler.TipPush.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.s2CType_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return ChatHandler.internal_static_pomelo_chat_TipPush_descriptor; }
/*      */       public ChatHandler.TipPush getDefaultInstanceForType() { return ChatHandler.TipPush.getDefaultInstance(); }
/*      */       public ChatHandler.TipPush build() { ChatHandler.TipPush result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public ChatHandler.TipPush buildPartial() { ChatHandler.TipPush result = new ChatHandler.TipPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2;  result.s2CType_ = this.s2CType_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof ChatHandler.TipPush)
/*      */           return mergeFrom((ChatHandler.TipPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(ChatHandler.TipPush other) { if (other == ChatHandler.TipPush.getDefaultInstance())
/*      */           return this;  if (other.hasS2CMsg()) { this.bitField0_ |= 0x1; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CType())
/*      */           setS2CType(other.getS2CType());  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CMsg())
/*      */           return false;  if (!hasS2CType())
/*      */           return false;  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ChatHandler.TipPush parsedMessage = null; try { parsedMessage = (ChatHandler.TipPush)ChatHandler.TipPush.PARSER.parsePartialFrom(input, extensionRegistry); }
/*      */         catch (InvalidProtocolBufferException e) { parsedMessage = (ChatHandler.TipPush)e.getUnfinishedMessage(); throw e; }
/*      */         finally { if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage);  }
/*      */          return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s;  return s; }
/*      */          return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }
/*      */          return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ChatHandler.TipPush.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CType() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CType() { return this.s2CType_; } public Builder setS2CType(int value) { this.bitField0_ |= 0x2; this.s2CType_ = value; onChanged(); return this; } public Builder clearS2CType() { this.bitField0_ &= 0xFFFFFFFD; this.s2CType_ = 0; onChanged(); return this; } }
/* 5968 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 5973 */     String[] descriptorData = { "\n\021chatHandler.proto\022\013pomelo.chat\032\fcommon.proto\"k\n\017SendChatRequest\022\021\n\tc2s_scope\030\001 \002(\005\022\023\n\013c2s_content\030\002 \002(\t\022\026\n\016c2s_serverData\030\003 \001(\t\022\030\n\020c2s_acceptRoleId\030\004 \001(\t\"5\n\020SendChatResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"N\n\025GetSaveChatMsgRequest\022\021\n\tc2s_scope\030\001 \002(\005\022\021\n\tc2s_index\030\002 \002(\005\022\017\n\007c2s_uid\030\003 \001(\t\"À\001\n\nOnChatPush\022\024\n\fs2c_playerId\030\002 \002(\t\022\017\n\007s2c_uid\030\003 \002(\t\022\023\n\013s2c_content\030\004 \002(\t\022\021\n\ts2c_scope\030\005 \002(\005\022\020\n\bs2c_time\030\006 \001", "(\t\022\017\n\007s2c_sys\030\007 \001(\005\022\021\n\ts2c_index\030\b \001(\005\022\026\n\016s2c_serverData\030\t \001(\t\022\025\n\rs2c_acceptRid\030\n \001(\t\"f\n\026GetSaveChatMsgResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_data\030\003 \003(\0132\027.pomelo.chat.OnChatPush\"4\n\017OnChatErrorPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \002(\t\",\n\007TipPush\022\017\n\007s2c_msg\030\002 \002(\t\022\020\n\bs2c_type\030\003 \002(\0052¿\001\n\013chatHandler\022N\n\017sendChatRequest\022\034.pomelo.chat.SendChatRequest\032\035.pomelo.chat.SendChatResponse\022`\n\025getSaveChat", "MsgRequest\022\".pomelo.chat.GetSaveChatMsgRequest\032#.pomelo.chat.GetSaveChatMsgResponse2­\001\n\bchatPush\0223\n\nonChatPush\022\027.pomelo.chat.OnChatPush\032\f.pomelo.Void\022=\n\017onChatErrorPush\022\034.pomelo.chat.OnChatErrorPush\032\f.pomelo.Void\022-\n\007tipPush\022\024.pomelo.chat.TipPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6002 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 6006 */           ChatHandler.descriptor = root;
/* 6007 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 6011 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 6013 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 6016 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_SendChatRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 6017 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_SendChatRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_SendChatRequest_descriptor, new String[] { "C2SScope", "C2SContent", "C2SServerData", "C2SAcceptRoleId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6022 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_SendChatResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 6023 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_SendChatResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_SendChatResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6028 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_GetSaveChatMsgRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 6029 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_GetSaveChatMsgRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_GetSaveChatMsgRequest_descriptor, new String[] { "C2SScope", "C2SIndex", "C2SUid" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6034 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_OnChatPush_descriptor = getDescriptor().getMessageTypes().get(3);
/* 6035 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_OnChatPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_OnChatPush_descriptor, new String[] { "S2CPlayerId", "S2CUid", "S2CContent", "S2CScope", "S2CTime", "S2CSys", "S2CIndex", "S2CServerData", "S2CAcceptRid" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6040 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_GetSaveChatMsgResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 6041 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_GetSaveChatMsgResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_GetSaveChatMsgResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6046 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_OnChatErrorPush_descriptor = getDescriptor().getMessageTypes().get(5);
/* 6047 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_OnChatErrorPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_OnChatErrorPush_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6052 */   private static final Descriptors.Descriptor internal_static_pomelo_chat_TipPush_descriptor = getDescriptor().getMessageTypes().get(6);
/* 6053 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_chat_TipPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_chat_TipPush_descriptor, new String[] { "S2CMsg", "S2CType" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 6057 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface TipPushOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */     
/*      */     boolean hasS2CType();
/*      */     
/*      */     int getS2CType();
/*      */   }
/*      */   
/*      */   public static interface OnChatErrorPushOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface GetSaveChatMsgResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<ChatHandler.OnChatPush> getS2CDataList();
/*      */     
/*      */     ChatHandler.OnChatPush getS2CData(int param1Int);
/*      */     
/*      */     int getS2CDataCount();
/*      */     
/*      */     List<? extends ChatHandler.OnChatPushOrBuilder> getS2CDataOrBuilderList();
/*      */     
/*      */     ChatHandler.OnChatPushOrBuilder getS2CDataOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface OnChatPushOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CPlayerId();
/*      */     
/*      */     String getS2CPlayerId();
/*      */     
/*      */     ByteString getS2CPlayerIdBytes();
/*      */     
/*      */     boolean hasS2CUid();
/*      */     
/*      */     String getS2CUid();
/*      */     
/*      */     ByteString getS2CUidBytes();
/*      */     
/*      */     boolean hasS2CContent();
/*      */     
/*      */     String getS2CContent();
/*      */     
/*      */     ByteString getS2CContentBytes();
/*      */     
/*      */     boolean hasS2CScope();
/*      */     
/*      */     int getS2CScope();
/*      */     
/*      */     boolean hasS2CTime();
/*      */     
/*      */     String getS2CTime();
/*      */     
/*      */     ByteString getS2CTimeBytes();
/*      */     
/*      */     boolean hasS2CSys();
/*      */     
/*      */     int getS2CSys();
/*      */     
/*      */     boolean hasS2CIndex();
/*      */     
/*      */     int getS2CIndex();
/*      */     
/*      */     boolean hasS2CServerData();
/*      */     
/*      */     String getS2CServerData();
/*      */     
/*      */     ByteString getS2CServerDataBytes();
/*      */     
/*      */     boolean hasS2CAcceptRid();
/*      */     
/*      */     String getS2CAcceptRid();
/*      */     
/*      */     ByteString getS2CAcceptRidBytes();
/*      */   }
/*      */   
/*      */   public static interface GetSaveChatMsgRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SScope();
/*      */     
/*      */     int getC2SScope();
/*      */     
/*      */     boolean hasC2SIndex();
/*      */     
/*      */     int getC2SIndex();
/*      */     
/*      */     boolean hasC2SUid();
/*      */     
/*      */     String getC2SUid();
/*      */     
/*      */     ByteString getC2SUidBytes();
/*      */   }
/*      */   
/*      */   public static interface SendChatResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface SendChatRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SScope();
/*      */     
/*      */     int getC2SScope();
/*      */     
/*      */     boolean hasC2SContent();
/*      */     
/*      */     String getC2SContent();
/*      */     
/*      */     ByteString getC2SContentBytes();
/*      */     
/*      */     boolean hasC2SServerData();
/*      */     
/*      */     String getC2SServerData();
/*      */     
/*      */     ByteString getC2SServerDataBytes();
/*      */     
/*      */     boolean hasC2SAcceptRoleId();
/*      */     
/*      */     String getC2SAcceptRoleId();
/*      */     
/*      */     ByteString getC2SAcceptRoleIdBytes();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\chat\ChatHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */