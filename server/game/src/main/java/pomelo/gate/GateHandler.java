/*      */ package pomelo.gate;
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
/*      */ import com.google.protobuf.UnknownFieldSet;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class GateHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class QueryEntryRequest
/*      */     extends GeneratedMessage
/*      */     implements QueryEntryRequestOrBuilder
/*      */   {
/*  896 */     private static final QueryEntryRequest defaultInstance = new QueryEntryRequest(true); private final UnknownFieldSet unknownFields; private QueryEntryRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryEntryRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryEntryRequest getDefaultInstance() { return defaultInstance; } public QueryEntryRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryEntryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SUid_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.c2SSign_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.c2STime_ = bs; break;case 32: this.bitField0_ |= 0x8; this.c2SLogicServerId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GateHandler.internal_static_pomelo_gate_QueryEntryRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GateHandler.internal_static_pomelo_gate_QueryEntryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryEntryRequest.class, Builder.class); } public static Parser<QueryEntryRequest> PARSER = (Parser<QueryEntryRequest>)new AbstractParser<QueryEntryRequest>() { public GateHandler.QueryEntryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GateHandler.QueryEntryRequest(input, extensionRegistry); } }
/*  897 */     ; private int bitField0_; public static final int C2S_UID_FIELD_NUMBER = 1; private Object c2SUid_; public static final int C2S_SIGN_FIELD_NUMBER = 2; private Object c2SSign_; public static final int C2S_TIME_FIELD_NUMBER = 3; private Object c2STime_; public static final int C2S_LOGICSERVERID_FIELD_NUMBER = 4; private int c2SLogicServerId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryEntryRequest> getParserForType() { return PARSER; } public boolean hasC2SUid() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SUid() { Object ref = this.c2SUid_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SUid_ = s;  return s; } public ByteString getC2SUidBytes() { Object ref = this.c2SUid_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SUid_ = b; return b; }  return (ByteString)ref; } public boolean hasC2SSign() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getC2SSign() {
/*      */       Object ref = this.c2SSign_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.c2SSign_ = s;
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
/*      */     public ByteString getC2SSignBytes() {
/*      */       Object ref = this.c2SSign_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SSign_ = b;
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
/*      */     public boolean hasC2STime() {
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
/*      */     public String getC2STime() {
/*      */       Object ref = this.c2STime_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.c2STime_ = s;
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
/*      */     public ByteString getC2STimeBytes() {
/*      */       Object ref = this.c2STime_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2STime_ = b;
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
/*      */     public boolean hasC2SLogicServerId() {
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
/*      */ 
/*      */     
/*      */     public int getC2SLogicServerId() {
/*      */       return this.c2SLogicServerId_;
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
/*      */       this.c2SUid_ = "";
/*      */       this.c2SSign_ = "";
/*      */       this.c2STime_ = "";
/*      */       this.c2SLogicServerId_ = 0;
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
/*      */       if (!hasC2SUid()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasC2SSign()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasC2STime()) {
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
/*      */         output.writeBytes(1, getC2SUidBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getC2SSignBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeBytes(3, getC2STimeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeInt32(4, this.c2SLogicServerId_);
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
/*      */         size += CodedOutputStream.computeBytesSize(1, getC2SUidBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getC2SSignBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeBytesSize(3, getC2STimeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeInt32Size(4, this.c2SLogicServerId_);
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
/*      */     public static QueryEntryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(data);
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
/*      */     public static QueryEntryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static QueryEntryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(data);
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
/*      */     public static QueryEntryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static QueryEntryRequest parseFrom(InputStream input) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(input);
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
/*      */     public static QueryEntryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static QueryEntryRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseDelimitedFrom(input);
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
/*      */     public static QueryEntryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     public static QueryEntryRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(input);
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
/*      */     public static QueryEntryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (QueryEntryRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(QueryEntryRequest prototype) {
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
/*      */       implements GateHandler.QueryEntryRequestOrBuilder
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
/*      */       private Object c2SSign_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object c2STime_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int c2SLogicServerId_;
/*      */ 
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
/*      */         return GateHandler.internal_static_pomelo_gate_QueryEntryRequest_descriptor;
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
/*      */         return GateHandler.internal_static_pomelo_gate_QueryEntryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GateHandler.QueryEntryRequest.class, Builder.class);
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
/*      */         this.c2SUid_ = "";
/*      */         this.c2SSign_ = "";
/*      */         this.c2STime_ = "";
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
/*      */         this.c2SUid_ = "";
/*      */         this.c2SSign_ = "";
/*      */         this.c2STime_ = "";
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
/*      */         if (GateHandler.QueryEntryRequest.alwaysUseFieldBuilders);
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
/*      */         this.c2SUid_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SSign_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2STime_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.c2SLogicServerId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
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
/*      */         return GateHandler.internal_static_pomelo_gate_QueryEntryRequest_descriptor;
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
/*      */       public GateHandler.QueryEntryRequest getDefaultInstanceForType() {
/*      */         return GateHandler.QueryEntryRequest.getDefaultInstance();
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
/*      */       public GateHandler.QueryEntryRequest build() {
/*      */         GateHandler.QueryEntryRequest result = buildPartial();
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
/*      */       public GateHandler.QueryEntryRequest buildPartial() {
/*      */         GateHandler.QueryEntryRequest result = new GateHandler.QueryEntryRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SUid_ = this.c2SUid_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.c2SSign_ = this.c2SSign_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.c2STime_ = this.c2STime_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.c2SLogicServerId_ = this.c2SLogicServerId_;
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
/*      */         if (other instanceof GateHandler.QueryEntryRequest) {
/*      */           return mergeFrom((GateHandler.QueryEntryRequest)other);
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
/*      */       public Builder mergeFrom(GateHandler.QueryEntryRequest other) {
/*      */         if (other == GateHandler.QueryEntryRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SUid()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.c2SUid_ = other.c2SUid_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasC2SSign()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.c2SSign_ = other.c2SSign_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasC2STime()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.c2STime_ = other.c2STime_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasC2SLogicServerId()) {
/*      */           setC2SLogicServerId(other.getC2SLogicServerId());
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
/*      */         if (!hasC2SUid()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasC2SSign()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasC2STime()) {
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
/*      */         GateHandler.QueryEntryRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (GateHandler.QueryEntryRequest)GateHandler.QueryEntryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (GateHandler.QueryEntryRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasC2SUid() {
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
/*      */       public Builder setC2SUid(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
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
/*      */       public Builder clearC2SUid() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SUid_ = GateHandler.QueryEntryRequest.getDefaultInstance().getC2SUid();
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
/*      */       public Builder setC2SUidBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
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
/*      */       public boolean hasC2SSign() {
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
/*      */       public String getC2SSign() {
/*      */         Object ref = this.c2SSign_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SSign_ = s;
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
/*      */       public ByteString getC2SSignBytes() {
/*      */         Object ref = this.c2SSign_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SSign_ = b;
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
/*      */       public Builder setC2SSign(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SSign_ = value;
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
/*      */       public Builder clearC2SSign() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SSign_ = GateHandler.QueryEntryRequest.getDefaultInstance().getC2SSign();
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
/*      */       public Builder setC2SSignBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SSign_ = value;
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
/*      */       public boolean hasC2STime() {
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
/*      */       public String getC2STime() {
/*      */         Object ref = this.c2STime_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2STime_ = s;
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
/*      */       public ByteString getC2STimeBytes() {
/*      */         Object ref = this.c2STime_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2STime_ = b;
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
/*      */       public Builder setC2STime(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2STime_ = value;
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
/*      */       public Builder clearC2STime() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.c2STime_ = GateHandler.QueryEntryRequest.getDefaultInstance().getC2STime();
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
/*      */       public Builder setC2STimeBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.c2STime_ = value;
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
/*      */       public boolean hasC2SLogicServerId() {
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
/*      */       
/*      */       public int getC2SLogicServerId() {
/*      */         return this.c2SLogicServerId_;
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
/*      */       public Builder setC2SLogicServerId(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.c2SLogicServerId_ = value;
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
/*      */       public Builder clearC2SLogicServerId() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.c2SLogicServerId_ = 0;
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
/*      */   public static final class QueryEntryResponse
/*      */     extends GeneratedMessage
/*      */     implements QueryEntryResponseOrBuilder
/*      */   {
/* 2054 */     private static final QueryEntryResponse defaultInstance = new QueryEntryResponse(true); private final UnknownFieldSet unknownFields; private QueryEntryResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryEntryResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryEntryResponse getDefaultInstance() { return defaultInstance; } public QueryEntryResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryEntryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CPubHost_ = bs; break;case 40: this.bitField0_ |= 0x8; this.s2CPort_ = input.readInt32(); break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x10; this.s2CToken_ = bs; break;case 56: this.bitField0_ |= 0x20; this.s2CAverageTime_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x40; this.s2CPos_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GateHandler.internal_static_pomelo_gate_QueryEntryResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GateHandler.internal_static_pomelo_gate_QueryEntryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryEntryResponse.class, Builder.class); } public static Parser<QueryEntryResponse> PARSER = (Parser<QueryEntryResponse>)new AbstractParser<QueryEntryResponse>() { public GateHandler.QueryEntryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GateHandler.QueryEntryResponse(input, extensionRegistry); } }
/* 2055 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_PUBHOST_FIELD_NUMBER = 3; private Object s2CPubHost_; public static final int S2C_PORT_FIELD_NUMBER = 5; private int s2CPort_; public static final int S2C_TOKEN_FIELD_NUMBER = 6; private Object s2CToken_; public static final int S2C_AVERAGETIME_FIELD_NUMBER = 7; private int s2CAverageTime_; public static final int S2C_POS_FIELD_NUMBER = 8; private int s2CPos_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryEntryResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CPubHost() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CPubHost() { Object ref = this.s2CPubHost_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CPubHost_ = s;  return s; } public ByteString getS2CPubHostBytes() { Object ref = this.s2CPubHost_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CPubHost_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CPort() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CPort() { return this.s2CPort_; } public boolean hasS2CToken() { return ((this.bitField0_ & 0x10) == 16); } public String getS2CToken() { Object ref = this.s2CToken_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CToken_ = s;  return s; } public ByteString getS2CTokenBytes() { Object ref = this.s2CToken_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CToken_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CAverageTime() { return ((this.bitField0_ & 0x20) == 32); } public int getS2CAverageTime() { return this.s2CAverageTime_; } public boolean hasS2CPos() { return ((this.bitField0_ & 0x40) == 64); } public int getS2CPos() { return this.s2CPos_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CPubHost_ = ""; this.s2CPort_ = 0; this.s2CToken_ = ""; this.s2CAverageTime_ = 0; this.s2CPos_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getS2CPubHostBytes());  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(5, this.s2CPort_);  if ((this.bitField0_ & 0x10) == 16) output.writeBytes(6, getS2CTokenBytes());  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(7, this.s2CAverageTime_);  if ((this.bitField0_ & 0x40) == 64) output.writeInt32(8, this.s2CPos_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getS2CPubHostBytes());  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(5, this.s2CPort_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeBytesSize(6, getS2CTokenBytes());  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(7, this.s2CAverageTime_);  if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(8, this.s2CPos_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QueryEntryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QueryEntryResponse)PARSER.parseFrom(data); } public static QueryEntryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryEntryResponse)PARSER.parseFrom(data, extensionRegistry); } public static QueryEntryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QueryEntryResponse)PARSER.parseFrom(data); } public static QueryEntryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryEntryResponse)PARSER.parseFrom(data, extensionRegistry); } public static QueryEntryResponse parseFrom(InputStream input) throws IOException { return (QueryEntryResponse)PARSER.parseFrom(input); } public static QueryEntryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryEntryResponse)PARSER.parseFrom(input, extensionRegistry); } public static QueryEntryResponse parseDelimitedFrom(InputStream input) throws IOException { return (QueryEntryResponse)PARSER.parseDelimitedFrom(input); } public static QueryEntryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryEntryResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } static { defaultInstance.initFields(); }
/*      */     public static QueryEntryResponse parseFrom(CodedInputStream input) throws IOException { return (QueryEntryResponse)PARSER.parseFrom(input); }
/*      */     public static QueryEntryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryEntryResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(QueryEntryResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements GateHandler.QueryEntryResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private Object s2CPubHost_;
/*      */       private int s2CPort_;
/*      */       private Object s2CToken_;
/*      */       private int s2CAverageTime_;
/*      */       private int s2CPos_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return GateHandler.internal_static_pomelo_gate_QueryEntryResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GateHandler.internal_static_pomelo_gate_QueryEntryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GateHandler.QueryEntryResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.s2CPubHost_ = ""; this.s2CToken_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CPubHost_ = ""; this.s2CToken_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GateHandler.QueryEntryResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CPubHost_ = ""; this.bitField0_ &= 0xFFFFFFFB; this.s2CPort_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.s2CToken_ = ""; this.bitField0_ &= 0xFFFFFFEF; this.s2CAverageTime_ = 0; this.bitField0_ &= 0xFFFFFFDF; this.s2CPos_ = 0; this.bitField0_ &= 0xFFFFFFBF; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GateHandler.internal_static_pomelo_gate_QueryEntryResponse_descriptor; } public GateHandler.QueryEntryResponse getDefaultInstanceForType() { return GateHandler.QueryEntryResponse.getDefaultInstance(); } public GateHandler.QueryEntryResponse build() { GateHandler.QueryEntryResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GateHandler.QueryEntryResponse buildPartial() { GateHandler.QueryEntryResponse result = new GateHandler.QueryEntryResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CPubHost_ = this.s2CPubHost_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CPort_ = this.s2CPort_; if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;  result.s2CToken_ = this.s2CToken_; if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;  result.s2CAverageTime_ = this.s2CAverageTime_; if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x40;  result.s2CPos_ = this.s2CPos_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GateHandler.QueryEntryResponse) return mergeFrom((GateHandler.QueryEntryResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GateHandler.QueryEntryResponse other) { if (other == GateHandler.QueryEntryResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CPubHost()) { this.bitField0_ |= 0x4; this.s2CPubHost_ = other.s2CPubHost_; onChanged(); }  if (other.hasS2CPort()) setS2CPort(other.getS2CPort());  if (other.hasS2CToken()) { this.bitField0_ |= 0x10; this.s2CToken_ = other.s2CToken_; onChanged(); }  if (other.hasS2CAverageTime()) setS2CAverageTime(other.getS2CAverageTime());  if (other.hasS2CPos()) setS2CPos(other.getS2CPos());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GateHandler.QueryEntryResponse parsedMessage = null; try { parsedMessage = (GateHandler.QueryEntryResponse)GateHandler.QueryEntryResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GateHandler.QueryEntryResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = GateHandler.QueryEntryResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CPubHost() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CPubHost() { Object ref = this.s2CPubHost_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CPubHost_ = s;  return s; }  return (String)ref; } public ByteString getS2CPubHostBytes() { Object ref = this.s2CPubHost_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CPubHost_ = b; return b; }  return (ByteString)ref; } public Builder setS2CPubHost(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CPubHost_ = value; onChanged(); return this; } public Builder clearS2CPubHost() { this.bitField0_ &= 0xFFFFFFFB; this.s2CPubHost_ = GateHandler.QueryEntryResponse.getDefaultInstance().getS2CPubHost(); onChanged(); return this; } public Builder setS2CPubHostBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CPubHost_ = value; onChanged(); return this; } public boolean hasS2CPort() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CPort() { return this.s2CPort_; } public Builder setS2CPort(int value) { this.bitField0_ |= 0x8; this.s2CPort_ = value; onChanged(); return this; } public Builder clearS2CPort() { this.bitField0_ &= 0xFFFFFFF7; this.s2CPort_ = 0; onChanged(); return this; } public boolean hasS2CToken() { return ((this.bitField0_ & 0x10) == 16); } public String getS2CToken() { Object ref = this.s2CToken_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CToken_ = s;  return s; }  return (String)ref; } public ByteString getS2CTokenBytes() { Object ref = this.s2CToken_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CToken_ = b; return b; }  return (ByteString)ref; } public Builder setS2CToken(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x10; this.s2CToken_ = value; onChanged(); return this; } public Builder clearS2CToken() { this.bitField0_ &= 0xFFFFFFEF; this.s2CToken_ = GateHandler.QueryEntryResponse.getDefaultInstance().getS2CToken(); onChanged(); return this; } public Builder setS2CTokenBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x10; this.s2CToken_ = value; onChanged(); return this; } public boolean hasS2CAverageTime() { return ((this.bitField0_ & 0x20) == 32); } public int getS2CAverageTime() { return this.s2CAverageTime_; } public Builder setS2CAverageTime(int value) { this.bitField0_ |= 0x20; this.s2CAverageTime_ = value; onChanged(); return this; } public Builder clearS2CAverageTime() { this.bitField0_ &= 0xFFFFFFDF; this.s2CAverageTime_ = 0; onChanged(); return this; } public boolean hasS2CPos() { return ((this.bitField0_ & 0x40) == 64); } public int getS2CPos() { return this.s2CPos_; } public Builder setS2CPos(int value) { this.bitField0_ |= 0x40; this.s2CPos_ = value; onChanged(); return this; } public Builder clearS2CPos() { this.bitField0_ &= 0xFFFFFFBF; this.s2CPos_ = 0; onChanged(); return this; } }
/* 2074 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 2079 */     String[] descriptorData = { "\n\021gateHandler.proto\022\013pomelo.gate\"c\n\021QueryEntryRequest\022\017\n\007c2s_uid\030\001 \002(\t\022\020\n\bc2s_sign\030\002 \002(\t\022\020\n\bc2s_time\030\003 \002(\t\022\031\n\021c2s_logicServerId\030\004 \001(\005\"\001\n\022QueryEntryResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013s2c_pubHost\030\003 \001(\t\022\020\n\bs2c_port\030\005 \001(\005\022\021\n\ts2c_token\030\006 \001(\t\022\027\n\017s2c_averageTime\030\007 \001(\005\022\017\n\007s2c_pos\030\b \001(\0052c\n\013gateHandler\022T\n\021queryEntryRequest\022\036.pomelo.gate.QueryEntryRequest\032\037.pomelo.gate.QueryEntryResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2091 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 2095 */           GateHandler.descriptor = root;
/* 2096 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 2100 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*      */   }
/*      */ 
/*      */   
/* 2104 */   private static final Descriptors.Descriptor internal_static_pomelo_gate_QueryEntryRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 2105 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_gate_QueryEntryRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_gate_QueryEntryRequest_descriptor, new String[] { "C2SUid", "C2SSign", "C2STime", "C2SLogicServerId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2110 */   private static final Descriptors.Descriptor internal_static_pomelo_gate_QueryEntryResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 2111 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_gate_QueryEntryResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_gate_QueryEntryResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CPubHost", "S2CPort", "S2CToken", "S2CAverageTime", "S2CPos" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   public static interface QueryEntryResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CPubHost();
/*      */     
/*      */     String getS2CPubHost();
/*      */     
/*      */     ByteString getS2CPubHostBytes();
/*      */     
/*      */     boolean hasS2CPort();
/*      */     
/*      */     int getS2CPort();
/*      */     
/*      */     boolean hasS2CToken();
/*      */     
/*      */     String getS2CToken();
/*      */     
/*      */     ByteString getS2CTokenBytes();
/*      */     
/*      */     boolean hasS2CAverageTime();
/*      */     
/*      */     int getS2CAverageTime();
/*      */     
/*      */     boolean hasS2CPos();
/*      */     
/*      */     int getS2CPos();
/*      */   }
/*      */   
/*      */   public static interface QueryEntryRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SUid();
/*      */     
/*      */     String getC2SUid();
/*      */     
/*      */     ByteString getC2SUidBytes();
/*      */     
/*      */     boolean hasC2SSign();
/*      */     
/*      */     String getC2SSign();
/*      */     
/*      */     ByteString getC2SSignBytes();
/*      */     
/*      */     boolean hasC2STime();
/*      */     
/*      */     String getC2STime();
/*      */     
/*      */     ByteString getC2STimeBytes();
/*      */     
/*      */     boolean hasC2SLogicServerId();
/*      */     
/*      */     int getC2SLogicServerId();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\gate\GateHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */