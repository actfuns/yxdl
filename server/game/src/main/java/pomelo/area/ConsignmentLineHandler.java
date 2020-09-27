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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class ConsignmentLineHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class AddConsignmentRequest
/*       */     extends GeneratedMessage
/*       */     implements AddConsignmentRequestOrBuilder
/*       */   {
/*  1126 */     private static final AddConsignmentRequest defaultInstance = new AddConsignmentRequest(true); private final UnknownFieldSet unknownFields; private AddConsignmentRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AddConsignmentRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AddConsignmentRequest getDefaultInstance() { return defaultInstance; } public AddConsignmentRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AddConsignmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SIndex_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SNumber_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.c2SPrice_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.c2SGlobal_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.c2SIsAnonymous_ = input.readInt32(); break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.c2SId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AddConsignmentRequest.class, Builder.class); } public static Parser<AddConsignmentRequest> PARSER = (Parser<AddConsignmentRequest>)new AbstractParser<AddConsignmentRequest>() { public ConsignmentLineHandler.AddConsignmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.AddConsignmentRequest(input, extensionRegistry); } }
/*  1127 */     ; private int bitField0_; public static final int C2S_INDEX_FIELD_NUMBER = 1; private int c2SIndex_; public static final int C2S_NUMBER_FIELD_NUMBER = 2; private int c2SNumber_; public static final int C2S_PRICE_FIELD_NUMBER = 3; private int c2SPrice_; public static final int C2S_GLOBAL_FIELD_NUMBER = 4; private int c2SGlobal_; public static final int C2S_ISANONYMOUS_FIELD_NUMBER = 5; private int c2SIsAnonymous_; public static final int C2S_ID_FIELD_NUMBER = 6; private Object c2SId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AddConsignmentRequest> getParserForType() { return PARSER; } public boolean hasC2SIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SIndex() { return this.c2SIndex_; } public boolean hasC2SNumber() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */     
/*       */     public int getC2SNumber() {
/*       */       return this.c2SNumber_;
/*       */     }
/*       */     
/*       */     public boolean hasC2SPrice() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public int getC2SPrice() {
/*       */       return this.c2SPrice_;
/*       */     }
/*       */     
/*       */     public boolean hasC2SGlobal() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */     
/*       */     public int getC2SGlobal() {
/*       */       return this.c2SGlobal_;
/*       */     }
/*       */     
/*       */     public boolean hasC2SIsAnonymous() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */     
/*       */     public int getC2SIsAnonymous() {
/*       */       return this.c2SIsAnonymous_;
/*       */     }
/*       */     
/*       */     public boolean hasC2SId() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */     
/*       */     public String getC2SId() {
/*       */       Object ref = this.c2SId_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.c2SId_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getC2SIdBytes() {
/*       */       Object ref = this.c2SId_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.c2SId_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SIndex_ = 0;
/*       */       this.c2SNumber_ = 0;
/*       */       this.c2SPrice_ = 0;
/*       */       this.c2SGlobal_ = 0;
/*       */       this.c2SIsAnonymous_ = 0;
/*       */       this.c2SId_ = "";
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
/*       */       if (!hasC2SIndex()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SNumber()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SPrice()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SGlobal()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SIsAnonymous()) {
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
/*       */         output.writeInt32(1, this.c2SIndex_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SNumber_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.c2SPrice_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.c2SGlobal_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.c2SIsAnonymous_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeBytes(6, getC2SIdBytes());
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.c2SIndex_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SNumber_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.c2SPrice_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.c2SGlobal_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.c2SIsAnonymous_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeBytesSize(6, getC2SIdBytes());
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
/*       */     public static AddConsignmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(InputStream input) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static AddConsignmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(AddConsignmentRequest prototype) {
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
/*       */       implements ConsignmentLineHandler.AddConsignmentRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int c2SIndex_;
/*       */       private int c2SNumber_;
/*       */       private int c2SPrice_;
/*       */       private int c2SGlobal_;
/*       */       private int c2SIsAnonymous_;
/*       */       private Object c2SId_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentRequest_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.AddConsignmentRequest.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.AddConsignmentRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SIndex_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SNumber_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SPrice_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SGlobal_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SIsAnonymous_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.c2SId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentRequest_descriptor;
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.AddConsignmentRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.AddConsignmentRequest.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.AddConsignmentRequest build() {
/*       */         ConsignmentLineHandler.AddConsignmentRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.AddConsignmentRequest buildPartial() {
/*       */         ConsignmentLineHandler.AddConsignmentRequest result = new ConsignmentLineHandler.AddConsignmentRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SIndex_ = this.c2SIndex_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SNumber_ = this.c2SNumber_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.c2SPrice_ = this.c2SPrice_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.c2SIsAnonymous_ = this.c2SIsAnonymous_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.c2SId_ = this.c2SId_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.AddConsignmentRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.AddConsignmentRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.AddConsignmentRequest other) {
/*       */         if (other == ConsignmentLineHandler.AddConsignmentRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SIndex()) {
/*       */           setC2SIndex(other.getC2SIndex());
/*       */         }
/*       */         if (other.hasC2SNumber()) {
/*       */           setC2SNumber(other.getC2SNumber());
/*       */         }
/*       */         if (other.hasC2SPrice()) {
/*       */           setC2SPrice(other.getC2SPrice());
/*       */         }
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
/*       */         }
/*       */         if (other.hasC2SIsAnonymous()) {
/*       */           setC2SIsAnonymous(other.getC2SIsAnonymous());
/*       */         }
/*       */         if (other.hasC2SId()) {
/*       */           this.bitField0_ |= 0x20;
/*       */           this.c2SId_ = other.c2SId_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SIndex()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SNumber()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SPrice()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SGlobal()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SIsAnonymous()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.AddConsignmentRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.AddConsignmentRequest)ConsignmentLineHandler.AddConsignmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.AddConsignmentRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SIndex() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getC2SIndex() {
/*       */         return this.c2SIndex_;
/*       */       }
/*       */       
/*       */       public Builder setC2SIndex(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SIndex_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SIndex() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SIndex_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SNumber() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public int getC2SNumber() {
/*       */         return this.c2SNumber_;
/*       */       }
/*       */       
/*       */       public Builder setC2SNumber(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SNumber_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SNumber() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SNumber_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SPrice() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public int getC2SPrice() {
/*       */         return this.c2SPrice_;
/*       */       }
/*       */       
/*       */       public Builder setC2SPrice(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.c2SPrice_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SPrice() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SPrice_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SGlobal() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
/*       */       }
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.c2SGlobal_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SGlobal_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SIsAnonymous() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       
/*       */       public int getC2SIsAnonymous() {
/*       */         return this.c2SIsAnonymous_;
/*       */       }
/*       */       
/*       */       public Builder setC2SIsAnonymous(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.c2SIsAnonymous_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SIsAnonymous() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.c2SIsAnonymous_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SId() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       
/*       */       public String getC2SId() {
/*       */         Object ref = this.c2SId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.c2SId_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getC2SIdBytes() {
/*       */         Object ref = this.c2SId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setC2SId(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x20;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SId() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.c2SId_ = ConsignmentLineHandler.AddConsignmentRequest.getDefaultInstance().getC2SId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setC2SIdBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x20;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class AddConsignmentResponse
/*       */     extends GeneratedMessage
/*       */     implements AddConsignmentResponseOrBuilder
/*       */   {
/*  1688 */     private static final AddConsignmentResponse defaultInstance = new AddConsignmentResponse(true); private final UnknownFieldSet unknownFields; private AddConsignmentResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AddConsignmentResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AddConsignmentResponse getDefaultInstance() { return defaultInstance; } public AddConsignmentResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AddConsignmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AddConsignmentResponse.class, Builder.class); } public static Parser<AddConsignmentResponse> PARSER = (Parser<AddConsignmentResponse>)new AbstractParser<AddConsignmentResponse>() { public ConsignmentLineHandler.AddConsignmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.AddConsignmentResponse(input, extensionRegistry); } }
/*  1689 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AddConsignmentResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     public static AddConsignmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(InputStream input) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static AddConsignmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (AddConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(AddConsignmentResponse prototype) {
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
/*       */       implements ConsignmentLineHandler.AddConsignmentResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
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
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.AddConsignmentResponse.class, Builder.class);
/*       */       }
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.AddConsignmentResponse.alwaysUseFieldBuilders);
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_AddConsignmentResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.AddConsignmentResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.AddConsignmentResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.AddConsignmentResponse build() {
/*       */         ConsignmentLineHandler.AddConsignmentResponse result = buildPartial();
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
/*       */       public ConsignmentLineHandler.AddConsignmentResponse buildPartial() {
/*       */         ConsignmentLineHandler.AddConsignmentResponse result = new ConsignmentLineHandler.AddConsignmentResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.AddConsignmentResponse) {
/*       */           return mergeFrom((ConsignmentLineHandler.AddConsignmentResponse)other);
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
/*       */       public Builder mergeFrom(ConsignmentLineHandler.AddConsignmentResponse other) {
/*       */         if (other == ConsignmentLineHandler.AddConsignmentResponse.getDefaultInstance()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.AddConsignmentResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.AddConsignmentResponse)ConsignmentLineHandler.AddConsignmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.AddConsignmentResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ConsignmentLineHandler.AddConsignmentResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */   public static final class RemoveConsignmentRequest
/*       */     extends GeneratedMessage
/*       */     implements RemoveConsignmentRequestOrBuilder
/*       */   {
/*  2346 */     private static final RemoveConsignmentRequest defaultInstance = new RemoveConsignmentRequest(true); private final UnknownFieldSet unknownFields; private RemoveConsignmentRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RemoveConsignmentRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RemoveConsignmentRequest getDefaultInstance() { return defaultInstance; } public RemoveConsignmentRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RemoveConsignmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SId_ = bs; break;case 16: this.bitField0_ |= 0x2; this.c2SGlobal_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RemoveConsignmentRequest.class, Builder.class); } public static Parser<RemoveConsignmentRequest> PARSER = (Parser<RemoveConsignmentRequest>)new AbstractParser<RemoveConsignmentRequest>() { public ConsignmentLineHandler.RemoveConsignmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.RemoveConsignmentRequest(input, extensionRegistry); } }
/*  2347 */     ; private int bitField0_; public static final int C2S_ID_FIELD_NUMBER = 1; private Object c2SId_; public static final int C2S_GLOBAL_FIELD_NUMBER = 2; private int c2SGlobal_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RemoveConsignmentRequest> getParserForType() { return PARSER; } public boolean hasC2SId() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SId() { Object ref = this.c2SId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SId_ = s;  return s; } public ByteString getC2SIdBytes() { Object ref = this.c2SId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SGlobal() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SGlobal() {
/*       */       return this.c2SGlobal_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SId_ = "";
/*       */       this.c2SGlobal_ = 0;
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
/*       */       if (!hasC2SId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SGlobal()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getC2SIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SGlobal_);
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SGlobal_);
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
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(InputStream input) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RemoveConsignmentRequest prototype) {
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
/*       */       implements ConsignmentLineHandler.RemoveConsignmentRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SId_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SGlobal_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.RemoveConsignmentRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.RemoveConsignmentRequest.alwaysUseFieldBuilders);
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
/*       */         this.c2SId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SGlobal_ = 0;
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.RemoveConsignmentRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.RemoveConsignmentRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.RemoveConsignmentRequest build() {
/*       */         ConsignmentLineHandler.RemoveConsignmentRequest result = buildPartial();
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
/*       */       public ConsignmentLineHandler.RemoveConsignmentRequest buildPartial() {
/*       */         ConsignmentLineHandler.RemoveConsignmentRequest result = new ConsignmentLineHandler.RemoveConsignmentRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SId_ = this.c2SId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
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
/*       */         if (other instanceof ConsignmentLineHandler.RemoveConsignmentRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.RemoveConsignmentRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.RemoveConsignmentRequest other) {
/*       */         if (other == ConsignmentLineHandler.RemoveConsignmentRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.c2SId_ = other.c2SId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
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
/*       */         if (!hasC2SId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SGlobal()) {
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
/*       */         ConsignmentLineHandler.RemoveConsignmentRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.RemoveConsignmentRequest)ConsignmentLineHandler.RemoveConsignmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.RemoveConsignmentRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SId() {
/*       */         Object ref = this.c2SId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SId_ = s;
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
/*       */       public ByteString getC2SIdBytes() {
/*       */         Object ref = this.c2SId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SId_ = ConsignmentLineHandler.RemoveConsignmentRequest.getDefaultInstance().getC2SId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SGlobal() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SGlobal_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SGlobal_ = 0;
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
/*       */   public static final class RemoveConsignmentResponse
/*       */     extends GeneratedMessage
/*       */     implements RemoveConsignmentResponseOrBuilder
/*       */   {
/*  2908 */     private static final RemoveConsignmentResponse defaultInstance = new RemoveConsignmentResponse(true); private final UnknownFieldSet unknownFields; private RemoveConsignmentResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RemoveConsignmentResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RemoveConsignmentResponse getDefaultInstance() { return defaultInstance; } public RemoveConsignmentResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RemoveConsignmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RemoveConsignmentResponse.class, Builder.class); } public static Parser<RemoveConsignmentResponse> PARSER = (Parser<RemoveConsignmentResponse>)new AbstractParser<RemoveConsignmentResponse>() { public ConsignmentLineHandler.RemoveConsignmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.RemoveConsignmentResponse(input, extensionRegistry); } }
/*  2909 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RemoveConsignmentResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     public static RemoveConsignmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(InputStream input) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RemoveConsignmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RemoveConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RemoveConsignmentResponse prototype) {
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
/*       */       implements ConsignmentLineHandler.RemoveConsignmentResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
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
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.RemoveConsignmentResponse.class, Builder.class);
/*       */       }
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.RemoveConsignmentResponse.alwaysUseFieldBuilders);
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_RemoveConsignmentResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.RemoveConsignmentResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.RemoveConsignmentResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.RemoveConsignmentResponse build() {
/*       */         ConsignmentLineHandler.RemoveConsignmentResponse result = buildPartial();
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
/*       */       public ConsignmentLineHandler.RemoveConsignmentResponse buildPartial() {
/*       */         ConsignmentLineHandler.RemoveConsignmentResponse result = new ConsignmentLineHandler.RemoveConsignmentResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.RemoveConsignmentResponse) {
/*       */           return mergeFrom((ConsignmentLineHandler.RemoveConsignmentResponse)other);
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
/*       */       public Builder mergeFrom(ConsignmentLineHandler.RemoveConsignmentResponse other) {
/*       */         if (other == ConsignmentLineHandler.RemoveConsignmentResponse.getDefaultInstance()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.RemoveConsignmentResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.RemoveConsignmentResponse)ConsignmentLineHandler.RemoveConsignmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.RemoveConsignmentResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ConsignmentLineHandler.RemoveConsignmentResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */   public static final class BuyConsignmentRequest
/*       */     extends GeneratedMessage
/*       */     implements BuyConsignmentRequestOrBuilder
/*       */   {
/*  3566 */     private static final BuyConsignmentRequest defaultInstance = new BuyConsignmentRequest(true); private final UnknownFieldSet unknownFields; private BuyConsignmentRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private BuyConsignmentRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static BuyConsignmentRequest getDefaultInstance() { return defaultInstance; } public BuyConsignmentRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private BuyConsignmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SId_ = bs; break;case 16: this.bitField0_ |= 0x2; this.c2SGlobal_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyConsignmentRequest.class, Builder.class); } public static Parser<BuyConsignmentRequest> PARSER = (Parser<BuyConsignmentRequest>)new AbstractParser<BuyConsignmentRequest>() { public ConsignmentLineHandler.BuyConsignmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.BuyConsignmentRequest(input, extensionRegistry); } }
/*  3567 */     ; private int bitField0_; public static final int C2S_ID_FIELD_NUMBER = 1; private Object c2SId_; public static final int C2S_GLOBAL_FIELD_NUMBER = 2; private int c2SGlobal_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<BuyConsignmentRequest> getParserForType() { return PARSER; } public boolean hasC2SId() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SId() { Object ref = this.c2SId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SId_ = s;  return s; } public ByteString getC2SIdBytes() { Object ref = this.c2SId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SGlobal() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SGlobal() {
/*       */       return this.c2SGlobal_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SId_ = "";
/*       */       this.c2SGlobal_ = 0;
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
/*       */       if (!hasC2SId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SGlobal()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getC2SIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SGlobal_);
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SGlobal_);
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
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(InputStream input) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(BuyConsignmentRequest prototype) {
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
/*       */       implements ConsignmentLineHandler.BuyConsignmentRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SId_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SGlobal_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.BuyConsignmentRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SId_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.BuyConsignmentRequest.alwaysUseFieldBuilders);
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
/*       */         this.c2SId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SGlobal_ = 0;
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.BuyConsignmentRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.BuyConsignmentRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.BuyConsignmentRequest build() {
/*       */         ConsignmentLineHandler.BuyConsignmentRequest result = buildPartial();
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
/*       */       public ConsignmentLineHandler.BuyConsignmentRequest buildPartial() {
/*       */         ConsignmentLineHandler.BuyConsignmentRequest result = new ConsignmentLineHandler.BuyConsignmentRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SId_ = this.c2SId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
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
/*       */         if (other instanceof ConsignmentLineHandler.BuyConsignmentRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.BuyConsignmentRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.BuyConsignmentRequest other) {
/*       */         if (other == ConsignmentLineHandler.BuyConsignmentRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.c2SId_ = other.c2SId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
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
/*       */         if (!hasC2SId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SGlobal()) {
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
/*       */         ConsignmentLineHandler.BuyConsignmentRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.BuyConsignmentRequest)ConsignmentLineHandler.BuyConsignmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.BuyConsignmentRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SId() {
/*       */         Object ref = this.c2SId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SId_ = s;
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
/*       */       public ByteString getC2SIdBytes() {
/*       */         Object ref = this.c2SId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SId_ = ConsignmentLineHandler.BuyConsignmentRequest.getDefaultInstance().getC2SId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SGlobal() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SGlobal_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SGlobal_ = 0;
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
/*       */   public static final class BuyConsignmentResponse
/*       */     extends GeneratedMessage
/*       */     implements BuyConsignmentResponseOrBuilder
/*       */   {
/*  4128 */     private static final BuyConsignmentResponse defaultInstance = new BuyConsignmentResponse(true); private final UnknownFieldSet unknownFields; private BuyConsignmentResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private BuyConsignmentResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static BuyConsignmentResponse getDefaultInstance() { return defaultInstance; } public BuyConsignmentResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private BuyConsignmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyConsignmentResponse.class, Builder.class); } public static Parser<BuyConsignmentResponse> PARSER = (Parser<BuyConsignmentResponse>)new AbstractParser<BuyConsignmentResponse>() { public ConsignmentLineHandler.BuyConsignmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.BuyConsignmentResponse(input, extensionRegistry); } }
/*  4129 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<BuyConsignmentResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static BuyConsignmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(data);
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
/*       */     public static BuyConsignmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static BuyConsignmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(data);
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
/*       */     public static BuyConsignmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static BuyConsignmentResponse parseFrom(InputStream input) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(input);
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
/*       */     public static BuyConsignmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static BuyConsignmentResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static BuyConsignmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static BuyConsignmentResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(input);
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
/*       */     public static BuyConsignmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (BuyConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(BuyConsignmentResponse prototype) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements ConsignmentLineHandler.BuyConsignmentResponseOrBuilder
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentResponse_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.BuyConsignmentResponse.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.BuyConsignmentResponse.alwaysUseFieldBuilders);
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_BuyConsignmentResponse_descriptor;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.BuyConsignmentResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.BuyConsignmentResponse.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.BuyConsignmentResponse build() {
/*       */         ConsignmentLineHandler.BuyConsignmentResponse result = buildPartial();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.BuyConsignmentResponse buildPartial() {
/*       */         ConsignmentLineHandler.BuyConsignmentResponse result = new ConsignmentLineHandler.BuyConsignmentResponse(this);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.BuyConsignmentResponse) {
/*       */           return mergeFrom((ConsignmentLineHandler.BuyConsignmentResponse)other);
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.BuyConsignmentResponse other) {
/*       */         if (other == ConsignmentLineHandler.BuyConsignmentResponse.getDefaultInstance()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.BuyConsignmentResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.BuyConsignmentResponse)ConsignmentLineHandler.BuyConsignmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.BuyConsignmentResponse)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ConsignmentLineHandler.BuyConsignmentResponse.getDefaultInstance().getS2CMsg();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class ConsignmentListRequest
/*       */     extends GeneratedMessage
/*       */     implements ConsignmentListRequestOrBuilder
/*       */   {
/*  5494 */     private static final ConsignmentListRequest defaultInstance = new ConsignmentListRequest(true); private final UnknownFieldSet unknownFields; private ConsignmentListRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ConsignmentListRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ConsignmentListRequest getDefaultInstance() { return defaultInstance; } public ConsignmentListRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ConsignmentListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SPro_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SQcolor_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.c2SOrder_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.c2SItemSecondType_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.c2SPage_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.c2SGlobal_ = input.readInt32(); break;case 58: bs = input.readBytes(); this.bitField0_ |= 0x40; this.c2SItemType_ = bs; break;case 64: this.bitField0_ |= 0x80; this.c2SLevel_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentListRequest.class, Builder.class); } public static Parser<ConsignmentListRequest> PARSER = (Parser<ConsignmentListRequest>)new AbstractParser<ConsignmentListRequest>() { public ConsignmentLineHandler.ConsignmentListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.ConsignmentListRequest(input, extensionRegistry); } }
/*  5495 */     ; private int bitField0_; public static final int C2S_PRO_FIELD_NUMBER = 1; private int c2SPro_; public static final int C2S_QCOLOR_FIELD_NUMBER = 2; private int c2SQcolor_; public static final int C2S_ORDER_FIELD_NUMBER = 3; private int c2SOrder_; public static final int C2S_ITEMSECONDTYPE_FIELD_NUMBER = 4; private int c2SItemSecondType_; public static final int C2S_PAGE_FIELD_NUMBER = 5; private int c2SPage_; public static final int C2S_GLOBAL_FIELD_NUMBER = 6; private int c2SGlobal_; public static final int C2S_ITEMTYPE_FIELD_NUMBER = 7; private Object c2SItemType_; public static final int C2S_LEVEL_FIELD_NUMBER = 8; private int c2SLevel_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ConsignmentListRequest> getParserForType() { return PARSER; } public boolean hasC2SPro() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SPro() { return this.c2SPro_; } public boolean hasC2SQcolor() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SQcolor() {
/*       */       return this.c2SQcolor_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SOrder() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SOrder() {
/*       */       return this.c2SOrder_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SItemSecondType() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SItemSecondType() {
/*       */       return this.c2SItemSecondType_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SPage() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SPage() {
/*       */       return this.c2SPage_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SGlobal() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SGlobal() {
/*       */       return this.c2SGlobal_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SItemType() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getC2SItemType() {
/*       */       Object ref = this.c2SItemType_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.c2SItemType_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getC2SItemTypeBytes() {
/*       */       Object ref = this.c2SItemType_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.c2SItemType_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SLevel() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SLevel() {
/*       */       return this.c2SLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SPro_ = 0;
/*       */       this.c2SQcolor_ = 0;
/*       */       this.c2SOrder_ = 0;
/*       */       this.c2SItemSecondType_ = 0;
/*       */       this.c2SPage_ = 0;
/*       */       this.c2SGlobal_ = 0;
/*       */       this.c2SItemType_ = "";
/*       */       this.c2SLevel_ = 0;
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
/*       */       if (!hasC2SPro()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SQcolor()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SOrder()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SItemSecondType()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SPage()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SGlobal()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SItemType()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SLevel()) {
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
/*       */         output.writeInt32(1, this.c2SPro_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SQcolor_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.c2SOrder_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.c2SItemSecondType_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.c2SPage_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.c2SGlobal_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeBytes(7, getC2SItemTypeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(8, this.c2SLevel_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.c2SPro_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SQcolor_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.c2SOrder_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.c2SItemSecondType_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.c2SPage_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.c2SGlobal_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeBytesSize(7, getC2SItemTypeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.c2SLevel_);
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
/*       */     public static ConsignmentListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(InputStream input) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ConsignmentListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(ConsignmentListRequest prototype) {
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
/*       */       implements ConsignmentLineHandler.ConsignmentListRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SPro_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SQcolor_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SOrder_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SItemSecondType_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SPage_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SGlobal_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SItemType_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SLevel_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.ConsignmentListRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SItemType_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SItemType_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.ConsignmentListRequest.alwaysUseFieldBuilders);
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
/*       */         this.c2SPro_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SQcolor_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SOrder_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SItemSecondType_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SPage_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.c2SGlobal_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.c2SItemType_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.c2SLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.ConsignmentListRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.ConsignmentListRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.ConsignmentListRequest build() {
/*       */         ConsignmentLineHandler.ConsignmentListRequest result = buildPartial();
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
/*       */       public ConsignmentLineHandler.ConsignmentListRequest buildPartial() {
/*       */         ConsignmentLineHandler.ConsignmentListRequest result = new ConsignmentLineHandler.ConsignmentListRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SPro_ = this.c2SPro_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SQcolor_ = this.c2SQcolor_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.c2SOrder_ = this.c2SOrder_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.c2SItemSecondType_ = this.c2SItemSecondType_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.c2SPage_ = this.c2SPage_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.c2SItemType_ = this.c2SItemType_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.c2SLevel_ = this.c2SLevel_;
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
/*       */         if (other instanceof ConsignmentLineHandler.ConsignmentListRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.ConsignmentListRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.ConsignmentListRequest other) {
/*       */         if (other == ConsignmentLineHandler.ConsignmentListRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SPro()) {
/*       */           setC2SPro(other.getC2SPro());
/*       */         }
/*       */         if (other.hasC2SQcolor()) {
/*       */           setC2SQcolor(other.getC2SQcolor());
/*       */         }
/*       */         if (other.hasC2SOrder()) {
/*       */           setC2SOrder(other.getC2SOrder());
/*       */         }
/*       */         if (other.hasC2SItemSecondType()) {
/*       */           setC2SItemSecondType(other.getC2SItemSecondType());
/*       */         }
/*       */         if (other.hasC2SPage()) {
/*       */           setC2SPage(other.getC2SPage());
/*       */         }
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
/*       */         }
/*       */         if (other.hasC2SItemType()) {
/*       */           this.bitField0_ |= 0x40;
/*       */           this.c2SItemType_ = other.c2SItemType_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasC2SLevel()) {
/*       */           setC2SLevel(other.getC2SLevel());
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
/*       */         if (!hasC2SPro()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SQcolor()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SOrder()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SItemSecondType()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SPage()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SGlobal()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SItemType()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SLevel()) {
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
/*       */         ConsignmentLineHandler.ConsignmentListRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentListRequest)ConsignmentLineHandler.ConsignmentListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentListRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SPro() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SPro() {
/*       */         return this.c2SPro_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SPro(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SPro_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SPro() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SPro_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SQcolor() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SQcolor() {
/*       */         return this.c2SQcolor_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SQcolor(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SQcolor_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SQcolor() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SQcolor_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SOrder() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SOrder() {
/*       */         return this.c2SOrder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SOrder(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.c2SOrder_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SOrder() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SOrder_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SItemSecondType() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SItemSecondType() {
/*       */         return this.c2SItemSecondType_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SItemSecondType(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.c2SItemSecondType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SItemSecondType() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SItemSecondType_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SPage() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SPage() {
/*       */         return this.c2SPage_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SPage(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.c2SPage_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SPage() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.c2SPage_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SGlobal() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.c2SGlobal_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.c2SGlobal_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SItemType() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SItemType() {
/*       */         Object ref = this.c2SItemType_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SItemType_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getC2SItemTypeBytes() {
/*       */         Object ref = this.c2SItemType_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SItemType_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SItemType(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x40;
/*       */         this.c2SItemType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SItemType() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.c2SItemType_ = ConsignmentLineHandler.ConsignmentListRequest.getDefaultInstance().getC2SItemType();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SItemTypeBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x40;
/*       */         this.c2SItemType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SLevel() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SLevel() {
/*       */         return this.c2SLevel_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SLevel(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.c2SLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SLevel() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.c2SLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class ConsignmentListResponse
/*       */     extends GeneratedMessage
/*       */     implements ConsignmentListResponseOrBuilder
/*       */   {
/*  6538 */     private static final ConsignmentListResponse defaultInstance = new ConsignmentListResponse(true); private final UnknownFieldSet unknownFields; private ConsignmentListResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ConsignmentListResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ConsignmentListResponse getDefaultInstance() { return defaultInstance; } public ConsignmentListResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ConsignmentListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalPage_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CData_.add(input.readMessage(ItemOuterClass.ConsignmentItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentListResponse.class, Builder.class); } public static Parser<ConsignmentListResponse> PARSER = (Parser<ConsignmentListResponse>)new AbstractParser<ConsignmentListResponse>() { public ConsignmentLineHandler.ConsignmentListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.ConsignmentListResponse(input, extensionRegistry); } }
/*  6539 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALPAGE_FIELD_NUMBER = 3; private int s2CTotalPage_; public static final int S2C_DATA_FIELD_NUMBER = 4; private List<ItemOuterClass.ConsignmentItem> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ConsignmentListResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */      public boolean hasS2CTotalPage() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public int getS2CTotalPage() {
/*       */       return this.s2CTotalPage_;
/*       */     } public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */       return this.s2CData_;
/*       */     } public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */       return (List)this.s2CData_;
/*       */     } public int getS2CDataCount() {
/*       */       return this.s2CData_.size();
/*       */     } public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */       return this.s2CData_.get(index);
/*       */     } public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */       return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index);
/*       */     } private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CTotalPage_ = 0;
/*       */       this.s2CData_ = Collections.emptyList();
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
/*       */       for (int i = 0; i < getS2CDataCount(); i++) {
/*       */         if (!getS2CData(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
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
/*       */         output.writeInt32(3, this.s2CTotalPage_); 
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         output.writeMessage(4, (MessageLite)this.s2CData_.get(i)); 
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
/*       */         size += CodedOutputStream.computeInt32Size(3, this.s2CTotalPage_); 
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CData_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static ConsignmentListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(data);
/*       */     } public static ConsignmentListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static ConsignmentListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(data);
/*       */     } public static ConsignmentListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static ConsignmentListResponse parseFrom(InputStream input) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(input);
/*       */     } public static ConsignmentListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static ConsignmentListResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseDelimitedFrom(input);
/*       */     } public static ConsignmentListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     } public static ConsignmentListResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(input);
/*       */     } public static ConsignmentListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ConsignmentListResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     } public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     } public static Builder newBuilder(ConsignmentListResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     } public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ConsignmentLineHandler.ConsignmentListResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CTotalPage_; private List<ItemOuterClass.ConsignmentItem> s2CData_; private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> s2CDataBuilder_; public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListResponse_descriptor;
/*       */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.ConsignmentListResponse.class, Builder.class);
/*       */       } private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.ConsignmentListResponse.alwaysUseFieldBuilders)
/*       */           getS2CDataFieldBuilder(); 
/*       */       } private static Builder create() {
/*       */         return new Builder();
/*       */       } public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CTotalPage_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentListResponse_descriptor;
/*       */       } public ConsignmentLineHandler.ConsignmentListResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.ConsignmentListResponse.getDefaultInstance();
/*       */       } public ConsignmentLineHandler.ConsignmentListResponse build() {
/*       */         ConsignmentLineHandler.ConsignmentListResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       } public ConsignmentLineHandler.ConsignmentListResponse buildPartial() {
/*       */         ConsignmentLineHandler.ConsignmentListResponse result = new ConsignmentLineHandler.ConsignmentListResponse(this);
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
/*       */         result.s2CTotalPage_ = this.s2CTotalPage_;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = this.s2CDataBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       } public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.ConsignmentListResponse)
/*       */           return mergeFrom((ConsignmentLineHandler.ConsignmentListResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       } public Builder mergeFrom(ConsignmentLineHandler.ConsignmentListResponse other) {
/*       */         if (other == ConsignmentLineHandler.ConsignmentListResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasS2CTotalPage())
/*       */           setS2CTotalPage(other.getS2CTotalPage()); 
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (!other.s2CData_.isEmpty()) {
/*       */             if (this.s2CData_.isEmpty()) {
/*       */               this.s2CData_ = other.s2CData_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureS2CDataIsMutable();
/*       */               this.s2CData_.addAll(other.s2CData_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CData_.isEmpty()) {
/*       */           if (this.s2CDataBuilder_.isEmpty()) {
/*       */             this.s2CDataBuilder_.dispose();
/*       */             this.s2CDataBuilder_ = null;
/*       */             this.s2CData_ = other.s2CData_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.s2CDataBuilder_ = ConsignmentLineHandler.ConsignmentListResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CDataBuilder_.addAllMessages(other.s2CData_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       } public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getS2CDataCount(); i++) {
/*       */           if (!getS2CData(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.ConsignmentListResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentListResponse)ConsignmentLineHandler.ConsignmentListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentListResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       } public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       } public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       } public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       } public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       } public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       } public Builder setS2CMsg(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ConsignmentLineHandler.ConsignmentListResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasS2CTotalPage() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       } public int getS2CTotalPage() {
/*       */         return this.s2CTotalPage_;
/*       */       }
/*       */       public Builder setS2CTotalPage(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.s2CTotalPage_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CTotalPage() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.s2CTotalPage_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       private void ensureS2CDataIsMutable() {
/*       */         if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.s2CData_ = new ArrayList<>(this.s2CData_);
/*       */           this.bitField0_ |= 0x8;
/*       */         } 
/*       */       }
/*       */       public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CData_); 
/*       */         return this.s2CDataBuilder_.getMessageList();
/*       */       }
/*       */       public int getS2CDataCount() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.size(); 
/*       */         return this.s2CDataBuilder_.getCount();
/*       */       }
/*       */       public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItem)this.s2CDataBuilder_.getMessage(index);
/*       */       }
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ConsignmentItem> values) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CData_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public ItemOuterClass.ConsignmentItem.Builder getS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */         if (this.s2CDataBuilder_ != null)
/*       */           return this.s2CDataBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.s2CData_);
/*       */       }
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder() {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       public List<ItemOuterClass.ConsignmentItem.Builder> getS2CDataBuilderList() {
/*       */         return getS2CDataFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       } } }
/*  6983 */   public static final class MyConsignmentRequest extends GeneratedMessage implements MyConsignmentRequestOrBuilder { private static final MyConsignmentRequest defaultInstance = new MyConsignmentRequest(true); private final UnknownFieldSet unknownFields; private MyConsignmentRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MyConsignmentRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MyConsignmentRequest getDefaultInstance() { return defaultInstance; } public MyConsignmentRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MyConsignmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 32: this.bitField0_ |= 0x1; this.c2SGlobal_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MyConsignmentRequest.class, Builder.class); } public static Parser<MyConsignmentRequest> PARSER = (Parser<MyConsignmentRequest>)new AbstractParser<MyConsignmentRequest>() { public ConsignmentLineHandler.MyConsignmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.MyConsignmentRequest(input, extensionRegistry); } }
/*  6984 */     ; private int bitField0_; public static final int C2S_GLOBAL_FIELD_NUMBER = 4; private int c2SGlobal_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MyConsignmentRequest> getParserForType() { return PARSER; } public boolean hasC2SGlobal() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SGlobal() { return this.c2SGlobal_; } private void initFields() { this.c2SGlobal_ = 0; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       if (!hasC2SGlobal()) {
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
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(4, this.c2SGlobal_);
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
/*       */         size += CodedOutputStream.computeInt32Size(4, this.c2SGlobal_);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static MyConsignmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(data);
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
/*       */     public static MyConsignmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static MyConsignmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(data);
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
/*       */     public static MyConsignmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static MyConsignmentRequest parseFrom(InputStream input) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(input);
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
/*       */     public static MyConsignmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static MyConsignmentRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseDelimitedFrom(input);
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
/*       */     public static MyConsignmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static MyConsignmentRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(input);
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
/*       */     public static MyConsignmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(MyConsignmentRequest prototype) {
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements ConsignmentLineHandler.MyConsignmentRequestOrBuilder
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
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SGlobal_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.MyConsignmentRequest.class, Builder.class);
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */         if (ConsignmentLineHandler.MyConsignmentRequest.alwaysUseFieldBuilders);
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SGlobal_ = 0;
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
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.MyConsignmentRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.MyConsignmentRequest.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.MyConsignmentRequest build() {
/*       */         ConsignmentLineHandler.MyConsignmentRequest result = buildPartial();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.MyConsignmentRequest buildPartial() {
/*       */         ConsignmentLineHandler.MyConsignmentRequest result = new ConsignmentLineHandler.MyConsignmentRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.MyConsignmentRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.MyConsignmentRequest)other);
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.MyConsignmentRequest other) {
/*       */         if (other == ConsignmentLineHandler.MyConsignmentRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
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
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SGlobal()) {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.MyConsignmentRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.MyConsignmentRequest)ConsignmentLineHandler.MyConsignmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.MyConsignmentRequest)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SGlobal() {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SGlobal_ = value;
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
/*       */ 
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SGlobal_ = 0;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class MyConsignmentResponse
/*       */     extends GeneratedMessage
/*       */     implements MyConsignmentResponseOrBuilder
/*       */   {
/*  8027 */     private static final MyConsignmentResponse defaultInstance = new MyConsignmentResponse(true); private final UnknownFieldSet unknownFields; private MyConsignmentResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MyConsignmentResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MyConsignmentResponse getDefaultInstance() { return defaultInstance; } public MyConsignmentResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MyConsignmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CData_.add(input.readMessage(ItemOuterClass.ConsignmentItem.PARSER, extensionRegistry)); break;case 32: this.bitField0_ |= 0x4; this.s2CCanSellNum_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MyConsignmentResponse.class, Builder.class); } public static Parser<MyConsignmentResponse> PARSER = (Parser<MyConsignmentResponse>)new AbstractParser<MyConsignmentResponse>() { public ConsignmentLineHandler.MyConsignmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.MyConsignmentResponse(input, extensionRegistry); } }
/*  8028 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private List<ItemOuterClass.ConsignmentItem> s2CData_; public static final int S2C_CAN_SELL_NUM_FIELD_NUMBER = 4; private int s2CCanSellNum_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MyConsignmentResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */     
/*       */     public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */       return (List)this.s2CData_;
/*       */     }
/*       */     public int getS2CDataCount() {
/*       */       return this.s2CData_.size();
/*       */     }
/*       */     public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */       return this.s2CData_.get(index);
/*       */     }
/*       */     public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */       return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index);
/*       */     }
/*       */     public boolean hasS2CCanSellNum() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     public int getS2CCanSellNum() {
/*       */       return this.s2CCanSellNum_;
/*       */     }
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CData_ = Collections.emptyList();
/*       */       this.s2CCanSellNum_ = 0;
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
/*       */       for (int i = 0; i < getS2CDataCount(); i++) {
/*       */         if (!getS2CData(i).isInitialized()) {
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
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(4, this.s2CCanSellNum_); 
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
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.s2CCanSellNum_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(InputStream input) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static MyConsignmentResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static MyConsignmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static MyConsignmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MyConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(MyConsignmentResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ConsignmentLineHandler.MyConsignmentResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<ItemOuterClass.ConsignmentItem> s2CData_; private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> s2CDataBuilder_; private int s2CCanSellNum_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentResponse_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.MyConsignmentResponse.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.MyConsignmentResponse.alwaysUseFieldBuilders)
/*       */           getS2CDataFieldBuilder(); 
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
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.s2CCanSellNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_MyConsignmentResponse_descriptor;
/*       */       }
/*       */       public ConsignmentLineHandler.MyConsignmentResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.MyConsignmentResponse.getDefaultInstance();
/*       */       }
/*       */       public ConsignmentLineHandler.MyConsignmentResponse build() {
/*       */         ConsignmentLineHandler.MyConsignmentResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public ConsignmentLineHandler.MyConsignmentResponse buildPartial() {
/*       */         ConsignmentLineHandler.MyConsignmentResponse result = new ConsignmentLineHandler.MyConsignmentResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = this.s2CDataBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.s2CCanSellNum_ = this.s2CCanSellNum_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.MyConsignmentResponse)
/*       */           return mergeFrom((ConsignmentLineHandler.MyConsignmentResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.MyConsignmentResponse other) {
/*       */         if (other == ConsignmentLineHandler.MyConsignmentResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (!other.s2CData_.isEmpty()) {
/*       */             if (this.s2CData_.isEmpty()) {
/*       */               this.s2CData_ = other.s2CData_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CDataIsMutable();
/*       */               this.s2CData_.addAll(other.s2CData_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CData_.isEmpty()) {
/*       */           if (this.s2CDataBuilder_.isEmpty()) {
/*       */             this.s2CDataBuilder_.dispose();
/*       */             this.s2CDataBuilder_ = null;
/*       */             this.s2CData_ = other.s2CData_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CDataBuilder_ = ConsignmentLineHandler.MyConsignmentResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CDataBuilder_.addAllMessages(other.s2CData_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasS2CCanSellNum())
/*       */           setS2CCanSellNum(other.getS2CCanSellNum()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getS2CDataCount(); i++) {
/*       */           if (!getS2CData(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.MyConsignmentResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.MyConsignmentResponse)ConsignmentLineHandler.MyConsignmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.MyConsignmentResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ConsignmentLineHandler.MyConsignmentResponse.getDefaultInstance().getS2CMsg();
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
/*       */       private void ensureS2CDataIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CData_ = new ArrayList<>(this.s2CData_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       
/*       */       public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CData_); 
/*       */         return this.s2CDataBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getS2CDataCount() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.size(); 
/*       */         return this.s2CDataBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItem)this.s2CDataBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ConsignmentItem> values) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CData_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder getS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */         if (this.s2CDataBuilder_ != null)
/*       */           return this.s2CDataBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.s2CData_);
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder() {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<ItemOuterClass.ConsignmentItem.Builder> getS2CDataBuilderList() {
/*       */         return getS2CDataFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       }
/*       */       
/*       */       public boolean hasS2CCanSellNum() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       
/*       */       public int getS2CCanSellNum() {
/*       */         return this.s2CCanSellNum_;
/*       */       }
/*       */       
/*       */       public Builder setS2CCanSellNum(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.s2CCanSellNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CCanSellNum() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.s2CCanSellNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*       */   
/*       */   public static final class SearchConsignmentRequest extends GeneratedMessage implements SearchConsignmentRequestOrBuilder { private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private SearchConsignmentRequest(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private SearchConsignmentRequest(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static SearchConsignmentRequest getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public SearchConsignmentRequest getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private SearchConsignmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */             case 10:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x1;
/*       */               this.c2SCondition_ = bs;
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.c2SGlobal_ = input.readInt32();
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
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentRequest_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchConsignmentRequest.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<SearchConsignmentRequest> PARSER = (Parser<SearchConsignmentRequest>)new AbstractParser<SearchConsignmentRequest>() { public ConsignmentLineHandler.SearchConsignmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ConsignmentLineHandler.SearchConsignmentRequest(input, extensionRegistry);
/*       */         } }
/*       */     ;
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int C2S_CONDITION_FIELD_NUMBER = 1;
/*       */     private Object c2SCondition_;
/*       */     public static final int C2S_GLOBAL_FIELD_NUMBER = 2;
/*       */     private int c2SGlobal_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<SearchConsignmentRequest> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasC2SCondition() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public String getC2SCondition() {
/*       */       Object ref = this.c2SCondition_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.c2SCondition_ = s; 
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getC2SConditionBytes() {
/*       */       Object ref = this.c2SCondition_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.c2SCondition_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     public boolean hasC2SGlobal() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */     
/*  8685 */     private static final SearchConsignmentRequest defaultInstance = new SearchConsignmentRequest(true); public int getC2SGlobal() { return this.c2SGlobal_; } private void initFields() { this.c2SCondition_ = ""; this.c2SGlobal_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SCondition()) { this.memoizedIsInitialized = 0; return false; }  if (!hasC2SGlobal()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SConditionBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2SGlobal_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SConditionBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SGlobal_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SearchConsignmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SearchConsignmentRequest)PARSER.parseFrom(data); } public static SearchConsignmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SearchConsignmentRequest)PARSER.parseFrom(data, extensionRegistry); } public static SearchConsignmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SearchConsignmentRequest)PARSER.parseFrom(data); } public static SearchConsignmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SearchConsignmentRequest)PARSER.parseFrom(data, extensionRegistry); } public static SearchConsignmentRequest parseFrom(InputStream input) throws IOException { return (SearchConsignmentRequest)PARSER.parseFrom(input); }
/*  8686 */     static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SearchConsignmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static SearchConsignmentRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SearchConsignmentRequest)PARSER.parseDelimitedFrom(input);
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
/*       */     public static SearchConsignmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static SearchConsignmentRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SearchConsignmentRequest)PARSER.parseFrom(input);
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
/*       */     public static SearchConsignmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(SearchConsignmentRequest prototype) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements ConsignmentLineHandler.SearchConsignmentRequestOrBuilder
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SCondition_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SGlobal_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.SearchConsignmentRequest.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SCondition_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SCondition_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.SearchConsignmentRequest.alwaysUseFieldBuilders);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SCondition_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SGlobal_ = 0;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.SearchConsignmentRequest.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentRequest build() {
/*       */         ConsignmentLineHandler.SearchConsignmentRequest result = buildPartial();
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentRequest buildPartial() {
/*       */         ConsignmentLineHandler.SearchConsignmentRequest result = new ConsignmentLineHandler.SearchConsignmentRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SCondition_ = this.c2SCondition_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SGlobal_ = this.c2SGlobal_;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.SearchConsignmentRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.SearchConsignmentRequest)other);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.SearchConsignmentRequest other) {
/*       */         if (other == ConsignmentLineHandler.SearchConsignmentRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SCondition()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.c2SCondition_ = other.c2SCondition_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasC2SGlobal()) {
/*       */           setC2SGlobal(other.getC2SGlobal());
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SCondition()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SGlobal()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.SearchConsignmentRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.SearchConsignmentRequest)ConsignmentLineHandler.SearchConsignmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.SearchConsignmentRequest)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SCondition() {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SCondition() {
/*       */         Object ref = this.c2SCondition_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SCondition_ = s;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getC2SConditionBytes() {
/*       */         Object ref = this.c2SCondition_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SCondition_ = b;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SCondition(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SCondition_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SCondition() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SCondition_ = ConsignmentLineHandler.SearchConsignmentRequest.getDefaultInstance().getC2SCondition();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SConditionBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SCondition_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SGlobal() {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SGlobal() {
/*       */         return this.c2SGlobal_;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SGlobal(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SGlobal_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SGlobal() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SGlobal_ = 0;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class SearchConsignmentResponse
/*       */     extends GeneratedMessage
/*       */     implements SearchConsignmentResponseOrBuilder
/*       */   {
/*  9731 */     private static final SearchConsignmentResponse defaultInstance = new SearchConsignmentResponse(true); private final UnknownFieldSet unknownFields; private SearchConsignmentResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SearchConsignmentResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SearchConsignmentResponse getDefaultInstance() { return defaultInstance; } public SearchConsignmentResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SearchConsignmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CData_.add(input.readMessage(ItemOuterClass.ConsignmentItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SearchConsignmentResponse.class, Builder.class); } public static Parser<SearchConsignmentResponse> PARSER = (Parser<SearchConsignmentResponse>)new AbstractParser<SearchConsignmentResponse>() { public ConsignmentLineHandler.SearchConsignmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.SearchConsignmentResponse(input, extensionRegistry); } }
/*  9732 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private List<ItemOuterClass.ConsignmentItem> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SearchConsignmentResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */     
/*       */     public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */       return (List)this.s2CData_;
/*       */     }
/*       */     
/*       */     public int getS2CDataCount() {
/*       */       return this.s2CData_.size();
/*       */     }
/*       */     
/*       */     public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */       return this.s2CData_.get(index);
/*       */     }
/*       */     
/*       */     public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */       return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index);
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CData_ = Collections.emptyList();
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
/*       */       for (int i = 0; i < getS2CDataCount(); i++) {
/*       */         if (!getS2CData(i).isInitialized()) {
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
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_.get(i)); 
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
/*       */       for (int i = 0; i < this.s2CData_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(InputStream input) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static SearchConsignmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SearchConsignmentResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(SearchConsignmentResponse prototype) {
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
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ConsignmentLineHandler.SearchConsignmentResponseOrBuilder { private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private List<ItemOuterClass.ConsignmentItem> s2CData_;
/*       */       private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> s2CDataBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.SearchConsignmentResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.SearchConsignmentResponse.alwaysUseFieldBuilders)
/*       */           getS2CDataFieldBuilder(); 
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
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_SearchConsignmentResponse_descriptor;
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.SearchConsignmentResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentResponse build() {
/*       */         ConsignmentLineHandler.SearchConsignmentResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public ConsignmentLineHandler.SearchConsignmentResponse buildPartial() {
/*       */         ConsignmentLineHandler.SearchConsignmentResponse result = new ConsignmentLineHandler.SearchConsignmentResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = this.s2CDataBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.SearchConsignmentResponse)
/*       */           return mergeFrom((ConsignmentLineHandler.SearchConsignmentResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.SearchConsignmentResponse other) {
/*       */         if (other == ConsignmentLineHandler.SearchConsignmentResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (!other.s2CData_.isEmpty()) {
/*       */             if (this.s2CData_.isEmpty()) {
/*       */               this.s2CData_ = other.s2CData_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CDataIsMutable();
/*       */               this.s2CData_.addAll(other.s2CData_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CData_.isEmpty()) {
/*       */           if (this.s2CDataBuilder_.isEmpty()) {
/*       */             this.s2CDataBuilder_.dispose();
/*       */             this.s2CDataBuilder_ = null;
/*       */             this.s2CData_ = other.s2CData_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CDataBuilder_ = ConsignmentLineHandler.SearchConsignmentResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CDataBuilder_.addAllMessages(other.s2CData_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getS2CDataCount(); i++) {
/*       */           if (!getS2CData(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.SearchConsignmentResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.SearchConsignmentResponse)ConsignmentLineHandler.SearchConsignmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.SearchConsignmentResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ConsignmentLineHandler.SearchConsignmentResponse.getDefaultInstance().getS2CMsg();
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
/*       */       private void ensureS2CDataIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CData_ = new ArrayList<>(this.s2CData_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       
/*       */       public List<ItemOuterClass.ConsignmentItem> getS2CDataList() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CData_); 
/*       */         return this.s2CDataBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getS2CDataCount() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.size(); 
/*       */         return this.s2CDataBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem getS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItem)this.s2CDataBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addS2CData(int index, ItemOuterClass.ConsignmentItem.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ConsignmentItem> values) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CData_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeS2CData(int index) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           ensureS2CDataIsMutable();
/*       */           this.s2CData_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder getS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int index) {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CData_.get(index); 
/*       */         return (ItemOuterClass.ConsignmentItemOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList() {
/*       */         if (this.s2CDataBuilder_ != null)
/*       */           return this.s2CDataBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.s2CData_);
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder() {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public ItemOuterClass.ConsignmentItem.Builder addS2CDataBuilder(int index) {
/*       */         return (ItemOuterClass.ConsignmentItem.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ConsignmentItem.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<ItemOuterClass.ConsignmentItem.Builder> getS2CDataBuilderList() {
/*       */         return getS2CDataFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<ItemOuterClass.ConsignmentItem, ItemOuterClass.ConsignmentItem.Builder, ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       } } }
/*       */   
/* 10271 */   public static final class PublicItemRequest extends GeneratedMessage implements PublicItemRequestOrBuilder { private static final PublicItemRequest defaultInstance = new PublicItemRequest(true); private final UnknownFieldSet unknownFields; private PublicItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PublicItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PublicItemRequest getDefaultInstance() { return defaultInstance; } public PublicItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PublicItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.id_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PublicItemRequest.class, Builder.class); } public static Parser<PublicItemRequest> PARSER = (Parser<PublicItemRequest>)new AbstractParser<PublicItemRequest>() { public ConsignmentLineHandler.PublicItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ConsignmentLineHandler.PublicItemRequest(input, extensionRegistry); } }
/* 10272 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private Object id_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PublicItemRequest> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public String getId() { Object ref = this.id_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.id_ = s;  return s; } public ByteString getIdBytes() { Object ref = this.id_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.id_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = "";
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
/*       */       if (!hasId()) {
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
/*       */         output.writeBytes(1, getIdBytes());
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getIdBytes());
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
/*       */     public static PublicItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(InputStream input) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PublicItemRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(PublicItemRequest prototype) {
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
/*       */       implements ConsignmentLineHandler.PublicItemRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private Object id_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.PublicItemRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.id_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.id_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.PublicItemRequest.alwaysUseFieldBuilders);
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
/*       */         this.id_ = "";
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.PublicItemRequest getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.PublicItemRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.PublicItemRequest build() {
/*       */         ConsignmentLineHandler.PublicItemRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.PublicItemRequest buildPartial() {
/*       */         ConsignmentLineHandler.PublicItemRequest result = new ConsignmentLineHandler.PublicItemRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.id_ = this.id_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.PublicItemRequest) {
/*       */           return mergeFrom((ConsignmentLineHandler.PublicItemRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ConsignmentLineHandler.PublicItemRequest other) {
/*       */         if (other == ConsignmentLineHandler.PublicItemRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.id_ = other.id_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.PublicItemRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.PublicItemRequest)ConsignmentLineHandler.PublicItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.PublicItemRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public Builder setId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = ConsignmentLineHandler.PublicItemRequest.getDefaultInstance().getId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class PublicItemResponse
/*       */     extends GeneratedMessage
/*       */     implements PublicItemResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */     
/*       */     private PublicItemResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */ 
/*       */     
/*       */     private PublicItemResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */     
/*       */     public PublicItemResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */ 
/*       */     
/*       */     private PublicItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemResponse_descriptor;
/*       */     }
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PublicItemResponse.class, Builder.class);
/*       */     }
/*       */ 
/*       */     
/*       */     public static Parser<PublicItemResponse> PARSER = (Parser<PublicItemResponse>)new AbstractParser<PublicItemResponse>()
/*       */       {
/*       */         public ConsignmentLineHandler.PublicItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ConsignmentLineHandler.PublicItemResponse(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */     
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */     
/*       */     private int s2CCode_;
/*       */     
/*       */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*       */     
/*       */     private Object s2CMsg_;
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */     
/*       */     public Parser<PublicItemResponse> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasS2CCode() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getS2CCode() {
/*       */       return this.s2CCode_;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasS2CMsg() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
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
/*       */     public static PublicItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PublicItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static PublicItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PublicItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static PublicItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PublicItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static PublicItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PublicItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static PublicItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (PublicItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/* 10833 */     private static final PublicItemResponse defaultInstance = new PublicItemResponse(true);
/* 10834 */     public static PublicItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PublicItemResponse)PARSER.parseFrom(input, extensionRegistry); } public static PublicItemResponse parseDelimitedFrom(InputStream input) throws IOException { return (PublicItemResponse)PARSER.parseDelimitedFrom(input); } public static PublicItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PublicItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PublicItemResponse parseFrom(CodedInputStream input) throws IOException { return (PublicItemResponse)PARSER.parseFrom(input); } public static PublicItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PublicItemResponse)PARSER.parseFrom(input, extensionRegistry); } static { defaultInstance.initFields(); }
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
/*       */     public static Builder newBuilder(PublicItemResponse prototype) {
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
/*       */       implements ConsignmentLineHandler.PublicItemResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
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
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.PublicItemResponse.class, Builder.class);
/*       */       }
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ConsignmentLineHandler.PublicItemResponse.alwaysUseFieldBuilders);
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
/*       */         return ConsignmentLineHandler.internal_static_pomelo_area_PublicItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.PublicItemResponse getDefaultInstanceForType() {
/*       */         return ConsignmentLineHandler.PublicItemResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ConsignmentLineHandler.PublicItemResponse build() {
/*       */         ConsignmentLineHandler.PublicItemResponse result = buildPartial();
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
/*       */       public ConsignmentLineHandler.PublicItemResponse buildPartial() {
/*       */         ConsignmentLineHandler.PublicItemResponse result = new ConsignmentLineHandler.PublicItemResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ConsignmentLineHandler.PublicItemResponse) {
/*       */           return mergeFrom((ConsignmentLineHandler.PublicItemResponse)other);
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
/*       */       public Builder mergeFrom(ConsignmentLineHandler.PublicItemResponse other) {
/*       */         if (other == ConsignmentLineHandler.PublicItemResponse.getDefaultInstance()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ConsignmentLineHandler.PublicItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ConsignmentLineHandler.PublicItemResponse)ConsignmentLineHandler.PublicItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.PublicItemResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ConsignmentLineHandler.PublicItemResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class ConsignmentRemovePush
/*       */     extends GeneratedMessage
/*       */     implements ConsignmentRemovePushOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private ConsignmentRemovePush(GeneratedMessage.Builder<?> builder) {
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
/*       */     private ConsignmentRemovePush(boolean noInit) {
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
/*       */     public static ConsignmentRemovePush getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ConsignmentRemovePush getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
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
/*       */     private ConsignmentRemovePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */               this.s2CId_ = bs;
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
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentRemovePush_descriptor;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentRemovePush_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentRemovePush.class, Builder.class);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<ConsignmentRemovePush> PARSER = (Parser<ConsignmentRemovePush>)new AbstractParser<ConsignmentRemovePush>()
/*       */       {
/*       */         public ConsignmentLineHandler.ConsignmentRemovePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ConsignmentLineHandler.ConsignmentRemovePush(input, extensionRegistry);
/*       */         }
/*       */       };
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
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
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
/*       */     public static final int S2C_ID_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object s2CId_;
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
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 11451 */     private static final ConsignmentRemovePush defaultInstance = new ConsignmentRemovePush(true); private static final long serialVersionUID = 0L; public Parser<ConsignmentRemovePush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CId() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CId() { Object ref = this.s2CId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CId_ = s;  return s; } public ByteString getS2CIdBytes() { Object ref = this.s2CId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CId_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CId_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CIdBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/* 11452 */         size += CodedOutputStream.computeBytesSize(2, getS2CIdBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ConsignmentRemovePush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ConsignmentRemovePush)PARSER.parseFrom(data); } public static ConsignmentRemovePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ConsignmentRemovePush)PARSER.parseFrom(data, extensionRegistry); } public static ConsignmentRemovePush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ConsignmentRemovePush)PARSER.parseFrom(data); } public static ConsignmentRemovePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ConsignmentRemovePush)PARSER.parseFrom(data, extensionRegistry); } public static ConsignmentRemovePush parseFrom(InputStream input) throws IOException { return (ConsignmentRemovePush)PARSER.parseFrom(input); } static { defaultInstance.initFields(); } public static ConsignmentRemovePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ConsignmentRemovePush)PARSER.parseFrom(input, extensionRegistry); } public static ConsignmentRemovePush parseDelimitedFrom(InputStream input) throws IOException { return (ConsignmentRemovePush)PARSER.parseDelimitedFrom(input); }
/*       */     public static ConsignmentRemovePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ConsignmentRemovePush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static ConsignmentRemovePush parseFrom(CodedInputStream input) throws IOException { return (ConsignmentRemovePush)PARSER.parseFrom(input); }
/*       */     public static ConsignmentRemovePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ConsignmentRemovePush)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(ConsignmentRemovePush prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ConsignmentLineHandler.ConsignmentRemovePushOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CId_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentRemovePush_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentRemovePush_fieldAccessorTable.ensureFieldAccessorsInitialized(ConsignmentLineHandler.ConsignmentRemovePush.class, Builder.class); }
/*       */       private Builder() { this.s2CId_ = ""; maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CId_ = ""; maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (ConsignmentLineHandler.ConsignmentRemovePush.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CId_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return ConsignmentLineHandler.internal_static_pomelo_area_ConsignmentRemovePush_descriptor; }
/*       */       public ConsignmentLineHandler.ConsignmentRemovePush getDefaultInstanceForType() { return ConsignmentLineHandler.ConsignmentRemovePush.getDefaultInstance(); }
/*       */       public ConsignmentLineHandler.ConsignmentRemovePush build() { ConsignmentLineHandler.ConsignmentRemovePush result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public ConsignmentLineHandler.ConsignmentRemovePush buildPartial() { ConsignmentLineHandler.ConsignmentRemovePush result = new ConsignmentLineHandler.ConsignmentRemovePush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.s2CId_ = this.s2CId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof ConsignmentLineHandler.ConsignmentRemovePush)
/*       */           return mergeFrom((ConsignmentLineHandler.ConsignmentRemovePush)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(ConsignmentLineHandler.ConsignmentRemovePush other) { if (other == ConsignmentLineHandler.ConsignmentRemovePush.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (other.hasS2CId()) {
/*       */           this.bitField0_ |= 0x2; this.s2CId_ = other.s2CId_; onChanged();
/*       */         }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false;  if (!hasS2CId())
/*       */           return false;  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ConsignmentLineHandler.ConsignmentRemovePush parsedMessage = null; try {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentRemovePush)ConsignmentLineHandler.ConsignmentRemovePush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ConsignmentLineHandler.ConsignmentRemovePush)e.getUnfinishedMessage(); throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         }  return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasS2CId() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getS2CId() { Object ref = this.s2CId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CId_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getS2CIdBytes() { Object ref = this.s2CId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setS2CId(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearS2CId() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CId_ = ConsignmentLineHandler.ConsignmentRemovePush.getDefaultInstance().getS2CId();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CIdBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CId_ = value;
/*       */         onChanged();
/*       */         return this; } }
/*       */   }
/* 11536 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 11541 */     String[] descriptorData = { "\n\034consignmentLineHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"\001\n\025AddConsignmentRequest\022\021\n\tc2s_index\030\001 \002(\005\022\022\n\nc2s_number\030\002 \002(\005\022\021\n\tc2s_price\030\003 \002(\005\022\022\n\nc2s_global\030\004 \002(\005\022\027\n\017c2s_isAnonymous\030\005 \002(\005\022\016\n\006c2s_id\030\006 \001(\t\";\n\026AddConsignmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\">\n\030RemoveConsignmentRequest\022\016\n\006c2s_id\030\001 \002(\t\022\022\n\nc2s_global\030\002 \002(\005\">\n\031RemoveConsignmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 ", "\001(\t\";\n\025BuyConsignmentRequest\022\016\n\006c2s_id\030\001 \002(\t\022\022\n\nc2s_global\030\002 \002(\005\";\n\026BuyConsignmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"»\001\n\026ConsignmentListRequest\022\017\n\007c2s_pro\030\001 \002(\005\022\022\n\nc2s_qcolor\030\002 \002(\005\022\021\n\tc2s_order\030\003 \002(\005\022\032\n\022c2s_itemSecondType\030\004 \002(\005\022\020\n\bc2s_page\030\005 \002(\005\022\022\n\nc2s_global\030\006 \002(\005\022\024\n\fc2s_itemType\030\007 \002(\t\022\021\n\tc2s_level\030\b \002(\005\"\001\n\027ConsignmentListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\025\n\rs2c_totalPage\030\003 \001(", "\005\022.\n\bs2c_data\030\004 \003(\0132\034.pomelo.item.ConsignmentItem\"*\n\024MyConsignmentRequest\022\022\n\nc2s_global\030\004 \002(\005\"\001\n\025MyConsignmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\bs2c_data\030\003 \003(\0132\034.pomelo.item.ConsignmentItem\022\030\n\020s2c_can_sell_num\030\004 \001(\005\"E\n\030SearchConsignmentRequest\022\025\n\rc2s_condition\030\001 \002(\t\022\022\n\nc2s_global\030\002 \002(\005\"n\n\031SearchConsignmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\bs2c_data\030\003 \003(\0132\034.pomelo.item.Cons", "ignmentItem\"\037\n\021PublicItemRequest\022\n\n\002id\030\001 \002(\t\"7\n\022PublicItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"9\n\025ConsignmentRemovePush\022\020\n\bs2c_code\030\001 \002(\005\022\016\n\006s2c_id\030\002 \002(\t2Ì\005\n\026consignmentLineHandler\022`\n\025addConsignmentRequest\022\".pomelo.area.AddConsignmentRequest\032#.pomelo.area.AddConsignmentResponse\022i\n\030removeConsignmentRequest\022%.pomelo.area.RemoveConsignmentRequest\032&.pomelo.area.RemoveConsignmentResponse\022`\n\025buyC", "onsignmentRequest\022\".pomelo.area.BuyConsignmentRequest\032#.pomelo.area.BuyConsignmentResponse\022c\n\026consignmentListRequest\022#.pomelo.area.ConsignmentListRequest\032$.pomelo.area.ConsignmentListResponse\022]\n\024myConsignmentRequest\022!.pomelo.area.MyConsignmentRequest\032\".pomelo.area.MyConsignmentResponse\022i\n\030searchConsignmentRequest\022%.pomelo.area.SearchConsignmentRequest\032&.pomelo.area.SearchConsignmentResponse\022T\n\021pub", "licItemRequest\022\036.pomelo.area.PublicItemRequest\032\037.pomelo.area.PublicItemResponse2`\n\023consignmentLinePush\022I\n\025consignmentRemovePush\022\".pomelo.area.ConsignmentRemovePush\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 11598 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 11602 */           ConsignmentLineHandler.descriptor = root;
/* 11603 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 11607 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 11609 */           Common.getDescriptor(), 
/* 11610 */           ItemOuterClass.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 11613 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AddConsignmentRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 11614 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddConsignmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddConsignmentRequest_descriptor, new String[] { "C2SIndex", "C2SNumber", "C2SPrice", "C2SGlobal", "C2SIsAnonymous", "C2SId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11619 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AddConsignmentResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 11620 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddConsignmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddConsignmentResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11625 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RemoveConsignmentRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 11626 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RemoveConsignmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RemoveConsignmentRequest_descriptor, new String[] { "C2SId", "C2SGlobal" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11631 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RemoveConsignmentResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 11632 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RemoveConsignmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RemoveConsignmentResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11637 */   private static final Descriptors.Descriptor internal_static_pomelo_area_BuyConsignmentRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 11638 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyConsignmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyConsignmentRequest_descriptor, new String[] { "C2SId", "C2SGlobal" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11643 */   private static final Descriptors.Descriptor internal_static_pomelo_area_BuyConsignmentResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 11644 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyConsignmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyConsignmentResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11649 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ConsignmentListRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 11650 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ConsignmentListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ConsignmentListRequest_descriptor, new String[] { "C2SPro", "C2SQcolor", "C2SOrder", "C2SItemSecondType", "C2SPage", "C2SGlobal", "C2SItemType", "C2SLevel" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11655 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ConsignmentListResponse_descriptor = getDescriptor().getMessageTypes().get(7);
/* 11656 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ConsignmentListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ConsignmentListResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalPage", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11661 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MyConsignmentRequest_descriptor = getDescriptor().getMessageTypes().get(8);
/* 11662 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MyConsignmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MyConsignmentRequest_descriptor, new String[] { "C2SGlobal" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11667 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MyConsignmentResponse_descriptor = getDescriptor().getMessageTypes().get(9);
/* 11668 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MyConsignmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MyConsignmentResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData", "S2CCanSellNum" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11673 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SearchConsignmentRequest_descriptor = getDescriptor().getMessageTypes().get(10);
/* 11674 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SearchConsignmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SearchConsignmentRequest_descriptor, new String[] { "C2SCondition", "C2SGlobal" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11679 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SearchConsignmentResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 11680 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SearchConsignmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SearchConsignmentResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11685 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PublicItemRequest_descriptor = getDescriptor().getMessageTypes().get(12);
/* 11686 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PublicItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PublicItemRequest_descriptor, new String[] { "Id" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11691 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PublicItemResponse_descriptor = getDescriptor().getMessageTypes().get(13);
/* 11692 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PublicItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PublicItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11697 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ConsignmentRemovePush_descriptor = getDescriptor().getMessageTypes().get(14);
/* 11698 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ConsignmentRemovePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ConsignmentRemovePush_descriptor, new String[] { "S2CCode", "S2CId" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 11702 */     Common.getDescriptor();
/* 11703 */     ItemOuterClass.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface ConsignmentRemovePushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CCode();
/*       */     
/*       */     int getS2CCode();
/*       */     
/*       */     boolean hasS2CId();
/*       */     
/*       */     String getS2CId();
/*       */     
/*       */     ByteString getS2CIdBytes();
/*       */   }
/*       */   
/*       */   public static interface PublicItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface PublicItemRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     String getId();
/*       */     
/*       */     ByteString getIdBytes();
/*       */   }
/*       */   
/*       */   public static interface SearchConsignmentResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<ItemOuterClass.ConsignmentItem> getS2CDataList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItem getS2CData(int param1Int);
/*       */     
/*       */     int getS2CDataCount();
/*       */     
/*       */     List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface SearchConsignmentRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SCondition();
/*       */     
/*       */     String getC2SCondition();
/*       */     
/*       */     ByteString getC2SConditionBytes();
/*       */     
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */   }
/*       */   
/*       */   public static interface MyConsignmentResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<ItemOuterClass.ConsignmentItem> getS2CDataList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItem getS2CData(int param1Int);
/*       */     
/*       */     int getS2CDataCount();
/*       */     
/*       */     List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasS2CCanSellNum();
/*       */     
/*       */     int getS2CCanSellNum();
/*       */   }
/*       */   
/*       */   public static interface MyConsignmentRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */   }
/*       */   
/*       */   public static interface ConsignmentListResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CTotalPage();
/*       */     
/*       */     int getS2CTotalPage();
/*       */     
/*       */     List<ItemOuterClass.ConsignmentItem> getS2CDataList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItem getS2CData(int param1Int);
/*       */     
/*       */     int getS2CDataCount();
/*       */     
/*       */     List<? extends ItemOuterClass.ConsignmentItemOrBuilder> getS2CDataOrBuilderList();
/*       */     
/*       */     ItemOuterClass.ConsignmentItemOrBuilder getS2CDataOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface ConsignmentListRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SPro();
/*       */     
/*       */     int getC2SPro();
/*       */     
/*       */     boolean hasC2SQcolor();
/*       */     
/*       */     int getC2SQcolor();
/*       */     
/*       */     boolean hasC2SOrder();
/*       */     
/*       */     int getC2SOrder();
/*       */     
/*       */     boolean hasC2SItemSecondType();
/*       */     
/*       */     int getC2SItemSecondType();
/*       */     
/*       */     boolean hasC2SPage();
/*       */     
/*       */     int getC2SPage();
/*       */     
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */     
/*       */     boolean hasC2SItemType();
/*       */     
/*       */     String getC2SItemType();
/*       */     
/*       */     ByteString getC2SItemTypeBytes();
/*       */     
/*       */     boolean hasC2SLevel();
/*       */     
/*       */     int getC2SLevel();
/*       */   }
/*       */   
/*       */   public static interface BuyConsignmentResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface BuyConsignmentRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SId();
/*       */     
/*       */     String getC2SId();
/*       */     
/*       */     ByteString getC2SIdBytes();
/*       */     
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */   }
/*       */   
/*       */   public static interface RemoveConsignmentResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface RemoveConsignmentRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SId();
/*       */     
/*       */     String getC2SId();
/*       */     
/*       */     ByteString getC2SIdBytes();
/*       */     
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */   }
/*       */   
/*       */   public static interface AddConsignmentResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface AddConsignmentRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SIndex();
/*       */     
/*       */     int getC2SIndex();
/*       */     
/*       */     boolean hasC2SNumber();
/*       */     
/*       */     int getC2SNumber();
/*       */     
/*       */     boolean hasC2SPrice();
/*       */     
/*       */     int getC2SPrice();
/*       */     
/*       */     boolean hasC2SGlobal();
/*       */     
/*       */     int getC2SGlobal();
/*       */     
/*       */     boolean hasC2SIsAnonymous();
/*       */     
/*       */     int getC2SIsAnonymous();
/*       */     
/*       */     boolean hasC2SId();
/*       */     
/*       */     String getC2SId();
/*       */     
/*       */     ByteString getC2SIdBytes();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\ConsignmentLineHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */