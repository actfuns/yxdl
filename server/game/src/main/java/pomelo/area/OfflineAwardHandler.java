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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class OfflineAwardHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class OfflineAwardItem
/*       */     extends GeneratedMessage
/*       */     implements OfflineAwardItemOrBuilder
/*       */   {
/*   832 */     private static final OfflineAwardItem defaultInstance = new OfflineAwardItem(true); private final UnknownFieldSet unknownFields; private OfflineAwardItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OfflineAwardItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OfflineAwardItem getDefaultInstance() { return defaultInstance; } public OfflineAwardItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OfflineAwardItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.templateId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.picId_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.name_ = bs; break;case 32: this.bitField0_ |= 0x8; this.num_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.quality_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardItem.class, Builder.class); } public static Parser<OfflineAwardItem> PARSER = (Parser<OfflineAwardItem>)new AbstractParser<OfflineAwardItem>() { public OfflineAwardHandler.OfflineAwardItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.OfflineAwardItem(input, extensionRegistry); } }
/*   833 */     ; private int bitField0_; public static final int TEMPLATEID_FIELD_NUMBER = 1; private int templateId_; public static final int PICID_FIELD_NUMBER = 2; private int picId_; public static final int NAME_FIELD_NUMBER = 3; private Object name_; public static final int NUM_FIELD_NUMBER = 4; private int num_; public static final int QUALITY_FIELD_NUMBER = 5; private int quality_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OfflineAwardItem> getParserForType() { return PARSER; } public boolean hasTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getTemplateId() { return this.templateId_; } public boolean hasPicId() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getPicId() {
/*       */       return this.picId_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasName() {
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasNum() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasQuality() {
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
/*       */     public int getQuality() {
/*       */       return this.quality_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       this.templateId_ = 0;
/*       */       this.picId_ = 0;
/*       */       this.name_ = "";
/*       */       this.num_ = 0;
/*       */       this.quality_ = 0;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       if (!hasTemplateId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPicId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasQuality()) {
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
/*       */         output.writeInt32(1, this.templateId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.picId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.num_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.quality_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.templateId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.picId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.num_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.quality_);
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
/*       */     public static OfflineAwardItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(InputStream input) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */     public static Builder newBuilder(OfflineAwardItem prototype) {
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
/*       */       implements OfflineAwardHandler.OfflineAwardItemOrBuilder
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
/*       */       private int templateId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int picId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object name_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int quality_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.OfflineAwardItem.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.name_ = "";
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
/*       */         this.name_ = "";
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
/*       */         if (OfflineAwardHandler.OfflineAwardItem.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.templateId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.picId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.num_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.quality_ = 0;
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.OfflineAwardItem.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem build() {
/*       */         OfflineAwardHandler.OfflineAwardItem result = buildPartial();
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
/*       */       public OfflineAwardHandler.OfflineAwardItem buildPartial() {
/*       */         OfflineAwardHandler.OfflineAwardItem result = new OfflineAwardHandler.OfflineAwardItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.templateId_ = this.templateId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.picId_ = this.picId_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.num_ = this.num_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.quality_ = this.quality_;
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
/*       */         if (other instanceof OfflineAwardHandler.OfflineAwardItem) {
/*       */           return mergeFrom((OfflineAwardHandler.OfflineAwardItem)other);
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
/*       */       public Builder mergeFrom(OfflineAwardHandler.OfflineAwardItem other) {
/*       */         if (other == OfflineAwardHandler.OfflineAwardItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasTemplateId()) {
/*       */           setTemplateId(other.getTemplateId());
/*       */         }
/*       */         if (other.hasPicId()) {
/*       */           setPicId(other.getPicId());
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasNum()) {
/*       */           setNum(other.getNum());
/*       */         }
/*       */         if (other.hasQuality()) {
/*       */           setQuality(other.getQuality());
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
/*       */         if (!hasTemplateId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPicId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasQuality()) {
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
/*       */         OfflineAwardHandler.OfflineAwardItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAwardItem)OfflineAwardHandler.OfflineAwardItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAwardItem)e.getUnfinishedMessage();
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
/*       */       public boolean hasTemplateId() {
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
/*       */       public int getTemplateId() {
/*       */         return this.templateId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setTemplateId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.templateId_ = value;
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
/*       */       public Builder clearTemplateId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.templateId_ = 0;
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
/*       */       public boolean hasPicId() {
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
/*       */       public int getPicId() {
/*       */         return this.picId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setPicId(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.picId_ = value;
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
/*       */       public Builder clearPicId() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.picId_ = 0;
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
/*       */       public boolean hasName() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.name_ = value;
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
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.name_ = OfflineAwardHandler.OfflineAwardItem.getDefaultInstance().getName();
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
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.name_ = value;
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
/*       */       public boolean hasNum() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNum(int value) {
/*       */         this.bitField0_ |= 0x8;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearNum() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.num_ = 0;
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
/*       */       public boolean hasQuality() {
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
/*       */       public int getQuality() {
/*       */         return this.quality_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setQuality(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.quality_ = value;
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
/*       */       public Builder clearQuality() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.quality_ = 0;
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
/*       */   public static final class OfflineAward
/*       */     extends GeneratedMessage
/*       */     implements OfflineAwardOrBuilder
/*       */   {
/*  2297 */     private static final OfflineAward defaultInstance = new OfflineAward(true); private final UnknownFieldSet unknownFields; private OfflineAward(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OfflineAward(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OfflineAward getDefaultInstance() { return defaultInstance; } public OfflineAward getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OfflineAward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.flag_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.areaId_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.gold_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.exp_ = input.readInt32(); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.offlineAwardItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.offlineAwardItems_.add(input.readMessage(OfflineAwardHandler.OfflineAwardItem.PARSER, extensionRegistry)); break;case 48: this.bitField0_ |= 0x10; this.offlineTime_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x20; this.v1Cost_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x40; this.v1BoxNum_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x80; this.v5Cost_ = input.readInt32(); break;case 80: this.bitField0_ |= 0x100; this.v5BoxNum_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAward_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAward.class, Builder.class); } public static Parser<OfflineAward> PARSER = (Parser<OfflineAward>)new AbstractParser<OfflineAward>() { public OfflineAwardHandler.OfflineAward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.OfflineAward(input, extensionRegistry); } }
/*  2298 */     ; private int bitField0_; public static final int FLAG_FIELD_NUMBER = 1; private int flag_; public static final int AREAID_FIELD_NUMBER = 2; private int areaId_; public static final int GOLD_FIELD_NUMBER = 3; private int gold_; public static final int EXP_FIELD_NUMBER = 4; private int exp_; public static final int OFFLINEAWARDITEMS_FIELD_NUMBER = 5; private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_; public static final int OFFLINETIME_FIELD_NUMBER = 6; private int offlineTime_; public static final int V1COST_FIELD_NUMBER = 7; private int v1Cost_; public static final int V1BOXNUM_FIELD_NUMBER = 8; private int v1BoxNum_; public static final int V5COST_FIELD_NUMBER = 9; private int v5Cost_; public static final int V5BOXNUM_FIELD_NUMBER = 10; private int v5BoxNum_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OfflineAward> getParserForType() { return PARSER; } public boolean hasFlag() { return ((this.bitField0_ & 0x1) == 1); } public int getFlag() { return this.flag_; } public boolean hasAreaId() { return ((this.bitField0_ & 0x2) == 2); } public int getAreaId() { return this.areaId_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGold() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGold() {
/*       */       return this.gold_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasExp() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getExp() {
/*       */       return this.exp_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() {
/*       */       return this.offlineAwardItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() {
/*       */       return (List)this.offlineAwardItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getOfflineAwardItemsCount() {
/*       */       return this.offlineAwardItems_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) {
/*       */       return this.offlineAwardItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) {
/*       */       return this.offlineAwardItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasOfflineTime() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getOfflineTime() {
/*       */       return this.offlineTime_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV1Cost() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV1Cost() {
/*       */       return this.v1Cost_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV1BoxNum() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV1BoxNum() {
/*       */       return this.v1BoxNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV5Cost() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV5Cost() {
/*       */       return this.v5Cost_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV5BoxNum() {
/*       */       return ((this.bitField0_ & 0x100) == 256);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV5BoxNum() {
/*       */       return this.v5BoxNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.flag_ = 0;
/*       */       this.areaId_ = 0;
/*       */       this.gold_ = 0;
/*       */       this.exp_ = 0;
/*       */       this.offlineAwardItems_ = Collections.emptyList();
/*       */       this.offlineTime_ = 0;
/*       */       this.v1Cost_ = 0;
/*       */       this.v1BoxNum_ = 0;
/*       */       this.v5Cost_ = 0;
/*       */       this.v5BoxNum_ = 0;
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
/*       */       if (!hasFlag()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasAreaId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasGold()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasExp()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasOfflineTime()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV1Cost()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV1BoxNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV5Cost()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV5BoxNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getOfflineAwardItemsCount(); i++) {
/*       */         if (!getOfflineAwardItems(i).isInitialized()) {
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
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.flag_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.areaId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.gold_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.exp_);
/*       */       }
/*       */       for (int i = 0; i < this.offlineAwardItems_.size(); i++) {
/*       */         output.writeMessage(5, (MessageLite)this.offlineAwardItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(6, this.offlineTime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(7, this.v1Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(8, this.v1BoxNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(9, this.v5Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         output.writeInt32(10, this.v5BoxNum_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.flag_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.areaId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.gold_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.exp_);
/*       */       }
/*       */       for (int i = 0; i < this.offlineAwardItems_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.offlineAwardItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.offlineTime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(7, this.v1Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.v1BoxNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(9, this.v5Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         size += CodedOutputStream.computeInt32Size(10, this.v5BoxNum_);
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
/*       */     public static OfflineAward parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAward)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAward)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAward)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAward)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(InputStream input) throws IOException {
/*       */       return (OfflineAward)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAward)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (OfflineAward)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAward)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(CodedInputStream input) throws IOException {
/*       */       return (OfflineAward)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAward)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(OfflineAward prototype) {
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
/*       */       implements OfflineAwardHandler.OfflineAwardOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int flag_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int areaId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int gold_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int exp_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> offlineAwardItemsBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int offlineTime_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int v1Cost_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int v1BoxNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int v5Cost_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int v5BoxNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAward_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAward_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.OfflineAward.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.offlineAwardItems_ = Collections.emptyList();
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
/*       */         this.offlineAwardItems_ = Collections.emptyList();
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
/*       */         if (OfflineAwardHandler.OfflineAward.alwaysUseFieldBuilders) {
/*       */           getOfflineAwardItemsFieldBuilder();
/*       */         }
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
/*       */         this.flag_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.areaId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.gold_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.exp_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         this.offlineTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.v1Cost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.v1BoxNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.v5Cost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.v5BoxNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFDFF;
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAward_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAward getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.OfflineAward.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAward build() {
/*       */         OfflineAwardHandler.OfflineAward result = buildPartial();
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
/*       */       public OfflineAwardHandler.OfflineAward buildPartial() {
/*       */         OfflineAwardHandler.OfflineAward result = new OfflineAwardHandler.OfflineAward(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.flag_ = this.flag_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.areaId_ = this.areaId_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.gold_ = this.gold_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.exp_ = this.exp_;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x10) == 16) {
/*       */             this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */           } 
/*       */           result.offlineAwardItems_ = this.offlineAwardItems_;
/*       */         } else {
/*       */           result.offlineAwardItems_ = this.offlineAwardItemsBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.offlineTime_ = this.offlineTime_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.v1Cost_ = this.v1Cost_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.v1BoxNum_ = this.v1BoxNum_;
/*       */         if ((from_bitField0_ & 0x100) == 256) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.v5Cost_ = this.v5Cost_;
/*       */         if ((from_bitField0_ & 0x200) == 512) {
/*       */           to_bitField0_ |= 0x100;
/*       */         }
/*       */         result.v5BoxNum_ = this.v5BoxNum_;
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
/*       */         if (other instanceof OfflineAwardHandler.OfflineAward) {
/*       */           return mergeFrom((OfflineAwardHandler.OfflineAward)other);
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
/*       */       public Builder mergeFrom(OfflineAwardHandler.OfflineAward other) {
/*       */         if (other == OfflineAwardHandler.OfflineAward.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasFlag()) {
/*       */           setFlag(other.getFlag());
/*       */         }
/*       */         if (other.hasAreaId()) {
/*       */           setAreaId(other.getAreaId());
/*       */         }
/*       */         if (other.hasGold()) {
/*       */           setGold(other.getGold());
/*       */         }
/*       */         if (other.hasExp()) {
/*       */           setExp(other.getExp());
/*       */         }
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (!other.offlineAwardItems_.isEmpty()) {
/*       */             if (this.offlineAwardItems_.isEmpty()) {
/*       */               this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */               this.bitField0_ &= 0xFFFFFFEF;
/*       */             } else {
/*       */               ensureOfflineAwardItemsIsMutable();
/*       */               this.offlineAwardItems_.addAll(other.offlineAwardItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.offlineAwardItems_.isEmpty()) {
/*       */           if (this.offlineAwardItemsBuilder_.isEmpty()) {
/*       */             this.offlineAwardItemsBuilder_.dispose();
/*       */             this.offlineAwardItemsBuilder_ = null;
/*       */             this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */             this.offlineAwardItemsBuilder_ = OfflineAwardHandler.OfflineAward.alwaysUseFieldBuilders ? getOfflineAwardItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.offlineAwardItemsBuilder_.addAllMessages(other.offlineAwardItems_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasOfflineTime()) {
/*       */           setOfflineTime(other.getOfflineTime());
/*       */         }
/*       */         if (other.hasV1Cost()) {
/*       */           setV1Cost(other.getV1Cost());
/*       */         }
/*       */         if (other.hasV1BoxNum()) {
/*       */           setV1BoxNum(other.getV1BoxNum());
/*       */         }
/*       */         if (other.hasV5Cost()) {
/*       */           setV5Cost(other.getV5Cost());
/*       */         }
/*       */         if (other.hasV5BoxNum()) {
/*       */           setV5BoxNum(other.getV5BoxNum());
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
/*       */         if (!hasFlag()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasAreaId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasGold()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasExp()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasOfflineTime()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV1Cost()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV1BoxNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV5Cost()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV5BoxNum()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getOfflineAwardItemsCount(); i++) {
/*       */           if (!getOfflineAwardItems(i).isInitialized()) {
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
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         OfflineAwardHandler.OfflineAward parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAward)OfflineAwardHandler.OfflineAward.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAward)e.getUnfinishedMessage();
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
/*       */       public boolean hasFlag() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
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
/*       */ 
/*       */       
/*       */       public Builder setFlag(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.flag_ = value;
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
/*       */       public Builder clearFlag() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.flag_ = 0;
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
/*       */       public boolean hasAreaId() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getAreaId() {
/*       */         return this.areaId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setAreaId(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.areaId_ = value;
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
/*       */       public Builder clearAreaId() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.areaId_ = 0;
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
/*       */       public boolean hasGold() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getGold() {
/*       */         return this.gold_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGold(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.gold_ = value;
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
/*       */       public Builder clearGold() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.gold_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasExp() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getExp() {
/*       */         return this.exp_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setExp(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.exp_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearExp() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.exp_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureOfflineAwardItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x10) != 16) {
/*       */           this.offlineAwardItems_ = new ArrayList<>(this.offlineAwardItems_);
/*       */           this.bitField0_ |= 0x10;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.offlineAwardItems_);
/*       */         }
/*       */         return this.offlineAwardItemsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getOfflineAwardItemsCount() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.size();
/*       */         }
/*       */         return this.offlineAwardItemsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.get(index);
/*       */         }
/*       */         return (OfflineAwardHandler.OfflineAwardItem)this.offlineAwardItemsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllOfflineAwardItems(Iterable<? extends OfflineAwardHandler.OfflineAwardItem> values) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.offlineAwardItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearOfflineAwardItems() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeOfflineAwardItems(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder getOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.get(index);
/*       */         }
/*       */         return (OfflineAwardHandler.OfflineAwardItemOrBuilder)this.offlineAwardItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() {
/*       */         if (this.offlineAwardItemsBuilder_ != null) {
/*       */           return this.offlineAwardItemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.offlineAwardItems_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder() {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(index, OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<OfflineAwardHandler.OfflineAwardItem.Builder> getOfflineAwardItemsBuilderList() {
/*       */         return getOfflineAwardItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsFieldBuilder() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItemsBuilder_ = new RepeatedFieldBuilder(this.offlineAwardItems_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*       */           this.offlineAwardItems_ = null;
/*       */         } 
/*       */         return this.offlineAwardItemsBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasOfflineTime() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getOfflineTime() {
/*       */         return this.offlineTime_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineTime(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.offlineTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearOfflineTime() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.offlineTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV1Cost() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV1Cost() {
/*       */         return this.v1Cost_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV1Cost(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.v1Cost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV1Cost() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.v1Cost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV1BoxNum() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV1BoxNum() {
/*       */         return this.v1BoxNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV1BoxNum(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.v1BoxNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV1BoxNum() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.v1BoxNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV5Cost() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV5Cost() {
/*       */         return this.v5Cost_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV5Cost(int value) {
/*       */         this.bitField0_ |= 0x100;
/*       */         this.v5Cost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV5Cost() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.v5Cost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV5BoxNum() {
/*       */         return ((this.bitField0_ & 0x200) == 512);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV5BoxNum() {
/*       */         return this.v5BoxNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV5BoxNum(int value) {
/*       */         this.bitField0_ |= 0x200;
/*       */         this.v5BoxNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV5BoxNum() {
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.v5BoxNum_ = 0;
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
/*       */   public static final class OfflineAwardDetail
/*       */     extends GeneratedMessage
/*       */     implements OfflineAwardDetailOrBuilder
/*       */   {
/*  3927 */     private static final OfflineAwardDetail defaultInstance = new OfflineAwardDetail(true); private final UnknownFieldSet unknownFields; private OfflineAwardDetail(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OfflineAwardDetail(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OfflineAwardDetail getDefaultInstance() { return defaultInstance; } public OfflineAwardDetail getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OfflineAwardDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.areaName_ = bs; break;case 16: this.bitField0_ |= 0x2; this.offlineTime_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.gold_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.exp_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.goldPerHour_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.expPerHour_ = input.readInt32(); break;case 58: if ((mutable_bitField0_ & 0x40) != 64) { this.offlineAwardItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x40; }  this.offlineAwardItems_.add(input.readMessage(OfflineAwardHandler.OfflineAwardItem.PARSER, extensionRegistry)); break;case 64: this.bitField0_ |= 0x40; this.v1Cost_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x80; this.v1BoxNum_ = input.readInt32(); break;case 80: this.bitField0_ |= 0x100; this.v5Cost_ = input.readInt32(); break;case 88: this.bitField0_ |= 0x200; this.v5BoxNum_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x40) == 64) this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardDetail_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardDetail.class, Builder.class); } public static Parser<OfflineAwardDetail> PARSER = (Parser<OfflineAwardDetail>)new AbstractParser<OfflineAwardDetail>() { public OfflineAwardHandler.OfflineAwardDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.OfflineAwardDetail(input, extensionRegistry); } }
/*  3928 */     ; private int bitField0_; public static final int AREANAME_FIELD_NUMBER = 1; private Object areaName_; public static final int OFFLINETIME_FIELD_NUMBER = 2; private int offlineTime_; public static final int GOLD_FIELD_NUMBER = 3; private int gold_; public static final int EXP_FIELD_NUMBER = 4; private int exp_; public static final int GOLDPERHOUR_FIELD_NUMBER = 5; private int goldPerHour_; public static final int EXPPERHOUR_FIELD_NUMBER = 6; private int expPerHour_; public static final int OFFLINEAWARDITEMS_FIELD_NUMBER = 7; private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_; public static final int V1COST_FIELD_NUMBER = 8; private int v1Cost_; public static final int V1BOXNUM_FIELD_NUMBER = 9; private int v1BoxNum_; public static final int V5COST_FIELD_NUMBER = 10; private int v5Cost_; public static final int V5BOXNUM_FIELD_NUMBER = 11; private int v5BoxNum_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OfflineAwardDetail> getParserForType() { return PARSER; } public boolean hasAreaName() { return ((this.bitField0_ & 0x1) == 1); } public String getAreaName() { Object ref = this.areaName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.areaName_ = s;  return s; } public ByteString getAreaNameBytes() { Object ref = this.areaName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.areaName_ = b; return b; }  return (ByteString)ref; } public boolean hasOfflineTime() { return ((this.bitField0_ & 0x2) == 2); } public int getOfflineTime() { return this.offlineTime_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGold() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGold() {
/*       */       return this.gold_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasExp() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getExp() {
/*       */       return this.exp_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGoldPerHour() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGoldPerHour() {
/*       */       return this.goldPerHour_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasExpPerHour() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getExpPerHour() {
/*       */       return this.expPerHour_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() {
/*       */       return this.offlineAwardItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() {
/*       */       return (List)this.offlineAwardItems_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getOfflineAwardItemsCount() {
/*       */       return this.offlineAwardItems_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) {
/*       */       return this.offlineAwardItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) {
/*       */       return this.offlineAwardItems_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV1Cost() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV1Cost() {
/*       */       return this.v1Cost_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV1BoxNum() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV1BoxNum() {
/*       */       return this.v1BoxNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV5Cost() {
/*       */       return ((this.bitField0_ & 0x100) == 256);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV5Cost() {
/*       */       return this.v5Cost_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasV5BoxNum() {
/*       */       return ((this.bitField0_ & 0x200) == 512);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getV5BoxNum() {
/*       */       return this.v5BoxNum_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.areaName_ = "";
/*       */       this.offlineTime_ = 0;
/*       */       this.gold_ = 0;
/*       */       this.exp_ = 0;
/*       */       this.goldPerHour_ = 0;
/*       */       this.expPerHour_ = 0;
/*       */       this.offlineAwardItems_ = Collections.emptyList();
/*       */       this.v1Cost_ = 0;
/*       */       this.v1BoxNum_ = 0;
/*       */       this.v5Cost_ = 0;
/*       */       this.v5BoxNum_ = 0;
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
/*       */       if (!hasAreaName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasOfflineTime()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasGold()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasExp()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasGoldPerHour()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasExpPerHour()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV1Cost()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV1BoxNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV5Cost()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasV5BoxNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getOfflineAwardItemsCount(); i++) {
/*       */         if (!getOfflineAwardItems(i).isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getAreaNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.offlineTime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.gold_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.exp_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.goldPerHour_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.expPerHour_);
/*       */       }
/*       */       for (int i = 0; i < this.offlineAwardItems_.size(); i++) {
/*       */         output.writeMessage(7, (MessageLite)this.offlineAwardItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(8, this.v1Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(9, this.v1BoxNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         output.writeInt32(10, this.v5Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x200) == 512) {
/*       */         output.writeInt32(11, this.v5BoxNum_);
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getAreaNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.offlineTime_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.gold_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.exp_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.goldPerHour_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.expPerHour_);
/*       */       }
/*       */       for (int i = 0; i < this.offlineAwardItems_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(7, (MessageLite)this.offlineAwardItems_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.v1Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(9, this.v1BoxNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         size += CodedOutputStream.computeInt32Size(10, this.v5Cost_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x200) == 512) {
/*       */         size += CodedOutputStream.computeInt32Size(11, this.v5BoxNum_);
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
/*       */     public static OfflineAwardDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(InputStream input) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(CodedInputStream input) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static OfflineAwardDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OfflineAwardDetail)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(OfflineAwardDetail prototype) {
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
/*       */       implements OfflineAwardHandler.OfflineAwardDetailOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */       
/*       */       private Object areaName_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int offlineTime_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int gold_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int exp_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int goldPerHour_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int expPerHour_;
/*       */ 
/*       */ 
/*       */       
/*       */       private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_;
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> offlineAwardItemsBuilder_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int v1Cost_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int v1BoxNum_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int v5Cost_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int v5BoxNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardDetail_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.OfflineAwardDetail.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.areaName_ = "";
/*       */         this.offlineAwardItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.areaName_ = "";
/*       */         this.offlineAwardItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (OfflineAwardHandler.OfflineAwardDetail.alwaysUseFieldBuilders) {
/*       */           getOfflineAwardItemsFieldBuilder();
/*       */         }
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.areaName_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.offlineTime_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.gold_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.exp_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.goldPerHour_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.expPerHour_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         this.v1Cost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.v1BoxNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.v5Cost_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.v5BoxNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         return this;
/*       */       }
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_OfflineAwardDetail_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardDetail getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.OfflineAwardDetail.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardDetail build() {
/*       */         OfflineAwardHandler.OfflineAwardDetail result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardDetail buildPartial() {
/*       */         OfflineAwardHandler.OfflineAwardDetail result = new OfflineAwardHandler.OfflineAwardDetail(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.areaName_ = this.areaName_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.offlineTime_ = this.offlineTime_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.gold_ = this.gold_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.exp_ = this.exp_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.goldPerHour_ = this.goldPerHour_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.expPerHour_ = this.expPerHour_;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x40) == 64) {
/*       */             this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */           } 
/*       */           result.offlineAwardItems_ = this.offlineAwardItems_;
/*       */         } else {
/*       */           result.offlineAwardItems_ = this.offlineAwardItemsBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.v1Cost_ = this.v1Cost_;
/*       */         if ((from_bitField0_ & 0x100) == 256) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.v1BoxNum_ = this.v1BoxNum_;
/*       */         if ((from_bitField0_ & 0x200) == 512) {
/*       */           to_bitField0_ |= 0x100;
/*       */         }
/*       */         result.v5Cost_ = this.v5Cost_;
/*       */         if ((from_bitField0_ & 0x400) == 1024) {
/*       */           to_bitField0_ |= 0x200;
/*       */         }
/*       */         result.v5BoxNum_ = this.v5BoxNum_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof OfflineAwardHandler.OfflineAwardDetail) {
/*       */           return mergeFrom((OfflineAwardHandler.OfflineAwardDetail)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(OfflineAwardHandler.OfflineAwardDetail other) {
/*       */         if (other == OfflineAwardHandler.OfflineAwardDetail.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasAreaName()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.areaName_ = other.areaName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasOfflineTime()) {
/*       */           setOfflineTime(other.getOfflineTime());
/*       */         }
/*       */         if (other.hasGold()) {
/*       */           setGold(other.getGold());
/*       */         }
/*       */         if (other.hasExp()) {
/*       */           setExp(other.getExp());
/*       */         }
/*       */         if (other.hasGoldPerHour()) {
/*       */           setGoldPerHour(other.getGoldPerHour());
/*       */         }
/*       */         if (other.hasExpPerHour()) {
/*       */           setExpPerHour(other.getExpPerHour());
/*       */         }
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (!other.offlineAwardItems_.isEmpty()) {
/*       */             if (this.offlineAwardItems_.isEmpty()) {
/*       */               this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */               this.bitField0_ &= 0xFFFFFFBF;
/*       */             } else {
/*       */               ensureOfflineAwardItemsIsMutable();
/*       */               this.offlineAwardItems_.addAll(other.offlineAwardItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.offlineAwardItems_.isEmpty()) {
/*       */           if (this.offlineAwardItemsBuilder_.isEmpty()) {
/*       */             this.offlineAwardItemsBuilder_.dispose();
/*       */             this.offlineAwardItemsBuilder_ = null;
/*       */             this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */             this.offlineAwardItemsBuilder_ = OfflineAwardHandler.OfflineAwardDetail.alwaysUseFieldBuilders ? getOfflineAwardItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.offlineAwardItemsBuilder_.addAllMessages(other.offlineAwardItems_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasV1Cost()) {
/*       */           setV1Cost(other.getV1Cost());
/*       */         }
/*       */         if (other.hasV1BoxNum()) {
/*       */           setV1BoxNum(other.getV1BoxNum());
/*       */         }
/*       */         if (other.hasV5Cost()) {
/*       */           setV5Cost(other.getV5Cost());
/*       */         }
/*       */         if (other.hasV5BoxNum()) {
/*       */           setV5BoxNum(other.getV5BoxNum());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasAreaName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasOfflineTime()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasGold()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasExp()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasGoldPerHour()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasExpPerHour()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV1Cost()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV1BoxNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV5Cost()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasV5BoxNum()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getOfflineAwardItemsCount(); i++) {
/*       */           if (!getOfflineAwardItems(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         OfflineAwardHandler.OfflineAwardDetail parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAwardDetail)OfflineAwardHandler.OfflineAwardDetail.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAwardDetail)e.getUnfinishedMessage();
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
/*       */       public boolean hasAreaName() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getAreaName() {
/*       */         Object ref = this.areaName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.areaName_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getAreaNameBytes() {
/*       */         Object ref = this.areaName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.areaName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setAreaName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.areaName_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearAreaName() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.areaName_ = OfflineAwardHandler.OfflineAwardDetail.getDefaultInstance().getAreaName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setAreaNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.areaName_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasOfflineTime() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getOfflineTime() {
/*       */         return this.offlineTime_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineTime(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.offlineTime_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearOfflineTime() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.offlineTime_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasGold() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getGold() {
/*       */         return this.gold_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGold(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.gold_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearGold() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.gold_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasExp() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getExp() {
/*       */         return this.exp_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setExp(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.exp_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearExp() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.exp_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasGoldPerHour() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getGoldPerHour() {
/*       */         return this.goldPerHour_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGoldPerHour(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.goldPerHour_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearGoldPerHour() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.goldPerHour_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasExpPerHour() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getExpPerHour() {
/*       */         return this.expPerHour_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setExpPerHour(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.expPerHour_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearExpPerHour() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.expPerHour_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureOfflineAwardItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x40) != 64) {
/*       */           this.offlineAwardItems_ = new ArrayList<>(this.offlineAwardItems_);
/*       */           this.bitField0_ |= 0x40;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.offlineAwardItems_);
/*       */         }
/*       */         return this.offlineAwardItemsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getOfflineAwardItemsCount() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.size();
/*       */         }
/*       */         return this.offlineAwardItemsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.get(index);
/*       */         }
/*       */         return (OfflineAwardHandler.OfflineAwardItem)this.offlineAwardItemsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllOfflineAwardItems(Iterable<? extends OfflineAwardHandler.OfflineAwardItem> values) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.offlineAwardItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearOfflineAwardItems() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeOfflineAwardItems(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder getOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           return this.offlineAwardItems_.get(index);
/*       */         }
/*       */         return (OfflineAwardHandler.OfflineAwardItemOrBuilder)this.offlineAwardItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() {
/*       */         if (this.offlineAwardItemsBuilder_ != null) {
/*       */           return this.offlineAwardItemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.offlineAwardItems_);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder() {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(index, OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<OfflineAwardHandler.OfflineAwardItem.Builder> getOfflineAwardItemsBuilderList() {
/*       */         return getOfflineAwardItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsFieldBuilder() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItemsBuilder_ = new RepeatedFieldBuilder(this.offlineAwardItems_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
/*       */           this.offlineAwardItems_ = null;
/*       */         } 
/*       */         return this.offlineAwardItemsBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV1Cost() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV1Cost() {
/*       */         return this.v1Cost_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV1Cost(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.v1Cost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV1Cost() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.v1Cost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV1BoxNum() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV1BoxNum() {
/*       */         return this.v1BoxNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV1BoxNum(int value) {
/*       */         this.bitField0_ |= 0x100;
/*       */         this.v1BoxNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV1BoxNum() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.v1BoxNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV5Cost() {
/*       */         return ((this.bitField0_ & 0x200) == 512);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV5Cost() {
/*       */         return this.v5Cost_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV5Cost(int value) {
/*       */         this.bitField0_ |= 0x200;
/*       */         this.v5Cost_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV5Cost() {
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.v5Cost_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasV5BoxNum() {
/*       */         return ((this.bitField0_ & 0x400) == 1024);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getV5BoxNum() {
/*       */         return this.v5BoxNum_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setV5BoxNum(int value) {
/*       */         this.bitField0_ |= 0x400;
/*       */         this.v5BoxNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearV5BoxNum() {
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.v5BoxNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class OfflineAreaDetail
/*       */     extends GeneratedMessage
/*       */     implements OfflineAreaDetailOrBuilder
/*       */   {
/*  5299 */     private static final OfflineAreaDetail defaultInstance = new OfflineAreaDetail(true); private final UnknownFieldSet unknownFields; private OfflineAreaDetail(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OfflineAreaDetail(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OfflineAreaDetail getDefaultInstance() { return defaultInstance; } public OfflineAreaDetail getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OfflineAreaDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.name_ = bs; break;case 16: this.bitField0_ |= 0x2; this.id_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.minLevel_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.maxLevel_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.minFightPower_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.goldPerHour_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.expPerHour_ = input.readInt32(); break;case 66: if ((mutable_bitField0_ & 0x80) != 128) { this.offlineAwardItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x80; }  this.offlineAwardItems_.add(input.readMessage(OfflineAwardHandler.OfflineAwardItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x80) == 128) this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAreaDetail_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAreaDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAreaDetail.class, Builder.class); } public static Parser<OfflineAreaDetail> PARSER = (Parser<OfflineAreaDetail>)new AbstractParser<OfflineAreaDetail>() { public OfflineAwardHandler.OfflineAreaDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.OfflineAreaDetail(input, extensionRegistry); } }
/*  5300 */     ; private int bitField0_; public static final int NAME_FIELD_NUMBER = 1; private Object name_; public static final int ID_FIELD_NUMBER = 2; private int id_; public static final int MINLEVEL_FIELD_NUMBER = 3; private int minLevel_; public static final int MAXLEVEL_FIELD_NUMBER = 4; private int maxLevel_; public static final int MINFIGHTPOWER_FIELD_NUMBER = 5; private int minFightPower_; public static final int GOLDPERHOUR_FIELD_NUMBER = 6; private int goldPerHour_; public static final int EXPPERHOUR_FIELD_NUMBER = 7; private int expPerHour_; public static final int OFFLINEAWARDITEMS_FIELD_NUMBER = 8; private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OfflineAreaDetail> getParserForType() { return PARSER; } public boolean hasName() { return ((this.bitField0_ & 0x1) == 1); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public boolean hasId() { return ((this.bitField0_ & 0x2) == 2); } public int getId() { return this.id_; } public boolean hasMinLevel() { return ((this.bitField0_ & 0x4) == 4); } public int getMinLevel() { return this.minLevel_; } public boolean hasMaxLevel() { return ((this.bitField0_ & 0x8) == 8); } public int getMaxLevel() { return this.maxLevel_; } public boolean hasMinFightPower() { return ((this.bitField0_ & 0x10) == 16); } public int getMinFightPower() { return this.minFightPower_; } public boolean hasGoldPerHour() { return ((this.bitField0_ & 0x20) == 32); } public int getGoldPerHour() { return this.goldPerHour_; } public boolean hasExpPerHour() { return ((this.bitField0_ & 0x40) == 64); } public int getExpPerHour() { return this.expPerHour_; } public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() { return this.offlineAwardItems_; } public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() { return (List)this.offlineAwardItems_; } public int getOfflineAwardItemsCount() { return this.offlineAwardItems_.size(); } public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) { return this.offlineAwardItems_.get(index); } public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) { return this.offlineAwardItems_.get(index); } private void initFields() { this.name_ = ""; this.id_ = 0; this.minLevel_ = 0; this.maxLevel_ = 0; this.minFightPower_ = 0; this.goldPerHour_ = 0; this.expPerHour_ = 0; this.offlineAwardItems_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasMinLevel()) { this.memoizedIsInitialized = 0; return false; }  if (!hasMaxLevel()) { this.memoizedIsInitialized = 0; return false; }  if (!hasMinFightPower()) { this.memoizedIsInitialized = 0; return false; }  if (!hasGoldPerHour()) { this.memoizedIsInitialized = 0; return false; }  if (!hasExpPerHour()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getOfflineAwardItemsCount(); i++) { if (!getOfflineAwardItems(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getNameBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.id_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.minLevel_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.maxLevel_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.minFightPower_);  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.goldPerHour_);  if ((this.bitField0_ & 0x40) == 64) output.writeInt32(7, this.expPerHour_);  for (int i = 0; i < this.offlineAwardItems_.size(); i++) output.writeMessage(8, (MessageLite)this.offlineAwardItems_.get(i));  getUnknownFields().writeTo(output); } static { defaultInstance.initFields(); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeBytesSize(1, getNameBytes()); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeInt32Size(2, this.id_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.minLevel_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.maxLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.minFightPower_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.goldPerHour_); 
/*       */       if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeInt32Size(7, this.expPerHour_); 
/*       */       for (int i = 0; i < this.offlineAwardItems_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(8, (MessageLite)this.offlineAwardItems_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static OfflineAreaDetail parseFrom(ByteString data) throws InvalidProtocolBufferException { return (OfflineAreaDetail)PARSER.parseFrom(data); } public static OfflineAreaDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OfflineAreaDetail)PARSER.parseFrom(data, extensionRegistry); } public static OfflineAreaDetail parseFrom(byte[] data) throws InvalidProtocolBufferException { return (OfflineAreaDetail)PARSER.parseFrom(data); } public static OfflineAreaDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OfflineAreaDetail)PARSER.parseFrom(data, extensionRegistry); } public static OfflineAreaDetail parseFrom(InputStream input) throws IOException { return (OfflineAreaDetail)PARSER.parseFrom(input); } public static OfflineAreaDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OfflineAreaDetail)PARSER.parseFrom(input, extensionRegistry); } public static OfflineAreaDetail parseDelimitedFrom(InputStream input) throws IOException { return (OfflineAreaDetail)PARSER.parseDelimitedFrom(input); } public static OfflineAreaDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OfflineAreaDetail)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static OfflineAreaDetail parseFrom(CodedInputStream input) throws IOException { return (OfflineAreaDetail)PARSER.parseFrom(input); }
/*       */     public static OfflineAreaDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OfflineAreaDetail)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(OfflineAreaDetail prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.OfflineAreaDetailOrBuilder { private int bitField0_; private Object name_; private int id_; private int minLevel_; private int maxLevel_; private int minFightPower_; private int goldPerHour_; private int expPerHour_; private List<OfflineAwardHandler.OfflineAwardItem> offlineAwardItems_; private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> offlineAwardItemsBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAreaDetail_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAreaDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.OfflineAreaDetail.class, Builder.class); }
/*       */       private Builder() { this.name_ = "";
/*       */         this.offlineAwardItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.name_ = "";
/*       */         this.offlineAwardItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.OfflineAreaDetail.alwaysUseFieldBuilders)
/*       */           getOfflineAwardItemsFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.minLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.maxLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.minFightPower_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.goldPerHour_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.expPerHour_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFF7F;
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_OfflineAreaDetail_descriptor; }
/*       */       public OfflineAwardHandler.OfflineAreaDetail getDefaultInstanceForType() { return OfflineAwardHandler.OfflineAreaDetail.getDefaultInstance(); }
/*       */       public OfflineAwardHandler.OfflineAreaDetail build() { OfflineAwardHandler.OfflineAreaDetail result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public OfflineAwardHandler.OfflineAreaDetail buildPartial() { OfflineAwardHandler.OfflineAreaDetail result = new OfflineAwardHandler.OfflineAreaDetail(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.minLevel_ = this.minLevel_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.maxLevel_ = this.maxLevel_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.minFightPower_ = this.minFightPower_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.goldPerHour_ = this.goldPerHour_;
/*       */         if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40; 
/*       */         result.expPerHour_ = this.expPerHour_;
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x80) == 128) {
/*       */             this.offlineAwardItems_ = Collections.unmodifiableList(this.offlineAwardItems_);
/*       */             this.bitField0_ &= 0xFFFFFF7F;
/*       */           } 
/*       */           result.offlineAwardItems_ = this.offlineAwardItems_;
/*       */         } else {
/*       */           result.offlineAwardItems_ = this.offlineAwardItemsBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.OfflineAreaDetail)
/*       */           return mergeFrom((OfflineAwardHandler.OfflineAreaDetail)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(OfflineAwardHandler.OfflineAreaDetail other) { if (other == OfflineAwardHandler.OfflineAreaDetail.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasId())
/*       */           setId(other.getId()); 
/*       */         if (other.hasMinLevel())
/*       */           setMinLevel(other.getMinLevel()); 
/*       */         if (other.hasMaxLevel())
/*       */           setMaxLevel(other.getMaxLevel()); 
/*       */         if (other.hasMinFightPower())
/*       */           setMinFightPower(other.getMinFightPower()); 
/*       */         if (other.hasGoldPerHour())
/*       */           setGoldPerHour(other.getGoldPerHour()); 
/*       */         if (other.hasExpPerHour())
/*       */           setExpPerHour(other.getExpPerHour()); 
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (!other.offlineAwardItems_.isEmpty()) {
/*       */             if (this.offlineAwardItems_.isEmpty()) {
/*       */               this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */               this.bitField0_ &= 0xFFFFFF7F;
/*       */             } else {
/*       */               ensureOfflineAwardItemsIsMutable();
/*       */               this.offlineAwardItems_.addAll(other.offlineAwardItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.offlineAwardItems_.isEmpty()) {
/*       */           if (this.offlineAwardItemsBuilder_.isEmpty()) {
/*       */             this.offlineAwardItemsBuilder_.dispose();
/*       */             this.offlineAwardItemsBuilder_ = null;
/*       */             this.offlineAwardItems_ = other.offlineAwardItems_;
/*       */             this.bitField0_ &= 0xFFFFFF7F;
/*       */             this.offlineAwardItemsBuilder_ = OfflineAwardHandler.OfflineAreaDetail.alwaysUseFieldBuilders ? getOfflineAwardItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.offlineAwardItemsBuilder_.addAllMessages(other.offlineAwardItems_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasName())
/*       */           return false; 
/*       */         if (!hasId())
/*       */           return false; 
/*       */         if (!hasMinLevel())
/*       */           return false; 
/*       */         if (!hasMaxLevel())
/*       */           return false; 
/*       */         if (!hasMinFightPower())
/*       */           return false; 
/*       */         if (!hasGoldPerHour())
/*       */           return false; 
/*       */         if (!hasExpPerHour())
/*       */           return false; 
/*       */         for (int i = 0; i < getOfflineAwardItemsCount(); i++) {
/*       */           if (!getOfflineAwardItems(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.OfflineAreaDetail parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAreaDetail)OfflineAwardHandler.OfflineAreaDetail.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.OfflineAreaDetail)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; }
/*       */       public boolean hasName() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public String getName() { Object ref = this.name_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.name_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getNameBytes() { Object ref = this.name_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.name_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearName() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = OfflineAwardHandler.OfflineAreaDetail.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasId() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public int getId() { return this.id_; }
/*       */       public Builder setId(int value) { this.bitField0_ |= 0x2;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearId() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasMinLevel() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public int getMinLevel() { return this.minLevel_; }
/*       */       public Builder setMinLevel(int value) { this.bitField0_ |= 0x4;
/*       */         this.minLevel_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearMinLevel() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.minLevel_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasMaxLevel() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public int getMaxLevel() { return this.maxLevel_; }
/*       */       public Builder setMaxLevel(int value) { this.bitField0_ |= 0x8;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearMaxLevel() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasMinFightPower() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public int getMinFightPower() { return this.minFightPower_; }
/*       */       public Builder setMinFightPower(int value) { this.bitField0_ |= 0x10;
/*       */         this.minFightPower_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearMinFightPower() { this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.minFightPower_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasGoldPerHour() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public int getGoldPerHour() { return this.goldPerHour_; }
/*       */       public Builder setGoldPerHour(int value) { this.bitField0_ |= 0x20;
/*       */         this.goldPerHour_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearGoldPerHour() { this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.goldPerHour_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasExpPerHour() { return ((this.bitField0_ & 0x40) == 64); }
/*       */       public int getExpPerHour() { return this.expPerHour_; }
/*       */       public Builder setExpPerHour(int value) { this.bitField0_ |= 0x40;
/*       */         this.expPerHour_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearExpPerHour() { this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.expPerHour_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureOfflineAwardItemsIsMutable() { if ((this.bitField0_ & 0x80) != 128) {
/*       */           this.offlineAwardItems_ = new ArrayList<>(this.offlineAwardItems_);
/*       */           this.bitField0_ |= 0x80;
/*       */         }  }
/*       */       public List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList() { if (this.offlineAwardItemsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.offlineAwardItems_); 
/*       */         return this.offlineAwardItemsBuilder_.getMessageList(); }
/*       */       public int getOfflineAwardItemsCount() { if (this.offlineAwardItemsBuilder_ == null)
/*       */           return this.offlineAwardItems_.size(); 
/*       */         return this.offlineAwardItemsBuilder_.getCount(); }
/*       */       public OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int index) { if (this.offlineAwardItemsBuilder_ == null)
/*       */           return this.offlineAwardItems_.get(index); 
/*       */         return (OfflineAwardHandler.OfflineAwardItem)this.offlineAwardItemsBuilder_.getMessage(index); }
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem value) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem value) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addOfflineAwardItems(OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addOfflineAwardItems(int index, OfflineAwardHandler.OfflineAwardItem.Builder builderForValue) { if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllOfflineAwardItems(Iterable<? extends OfflineAwardHandler.OfflineAwardItem> values) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.offlineAwardItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearOfflineAwardItems() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFF7F;
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeOfflineAwardItems(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           ensureOfflineAwardItemsIsMutable();
/*       */           this.offlineAwardItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder getOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int index) {
/*       */         if (this.offlineAwardItemsBuilder_ == null)
/*       */           return this.offlineAwardItems_.get(index); 
/*       */         return (OfflineAwardHandler.OfflineAwardItemOrBuilder)this.offlineAwardItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList() {
/*       */         if (this.offlineAwardItemsBuilder_ != null)
/*       */           return this.offlineAwardItemsBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.offlineAwardItems_);
/*       */       }
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder() {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */       public OfflineAwardHandler.OfflineAwardItem.Builder addOfflineAwardItemsBuilder(int index) {
/*       */         return (OfflineAwardHandler.OfflineAwardItem.Builder)getOfflineAwardItemsFieldBuilder().addBuilder(index, OfflineAwardHandler.OfflineAwardItem.getDefaultInstance());
/*       */       }
/*       */       public List<OfflineAwardHandler.OfflineAwardItem.Builder> getOfflineAwardItemsBuilderList() {
/*       */         return getOfflineAwardItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAwardItem, OfflineAwardHandler.OfflineAwardItem.Builder, OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsFieldBuilder() {
/*       */         if (this.offlineAwardItemsBuilder_ == null) {
/*       */           this.offlineAwardItemsBuilder_ = new RepeatedFieldBuilder(this.offlineAwardItems_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
/*       */           this.offlineAwardItems_ = null;
/*       */         } 
/*       */         return this.offlineAwardItemsBuilder_;
/*       */       } } }
/*  5704 */   public static final class SetOfflineAreaIdRequest extends GeneratedMessage implements SetOfflineAreaIdRequestOrBuilder { private static final SetOfflineAreaIdRequest defaultInstance = new SetOfflineAreaIdRequest(true); private final UnknownFieldSet unknownFields; private SetOfflineAreaIdRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetOfflineAreaIdRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetOfflineAreaIdRequest getDefaultInstance() { return defaultInstance; } public SetOfflineAreaIdRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetOfflineAreaIdRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SAreaId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SetOfflineAreaIdRequest.class, Builder.class); } public static Parser<SetOfflineAreaIdRequest> PARSER = (Parser<SetOfflineAreaIdRequest>)new AbstractParser<SetOfflineAreaIdRequest>() { public OfflineAwardHandler.SetOfflineAreaIdRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.SetOfflineAreaIdRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_AREAID_FIELD_NUMBER = 1; private int c2SAreaId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetOfflineAreaIdRequest> getParserForType() { return PARSER; } public boolean hasC2SAreaId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SAreaId() { return this.c2SAreaId_; } private void initFields() { this.c2SAreaId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SAreaId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SAreaId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SAreaId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SetOfflineAreaIdRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(data); } public static SetOfflineAreaIdRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(data, extensionRegistry); } public static SetOfflineAreaIdRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(data); } public static SetOfflineAreaIdRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(data, extensionRegistry); } public static SetOfflineAreaIdRequest parseFrom(InputStream input) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(input); } public static SetOfflineAreaIdRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(input, extensionRegistry); } public static SetOfflineAreaIdRequest parseDelimitedFrom(InputStream input) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseDelimitedFrom(input); } public static SetOfflineAreaIdRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static SetOfflineAreaIdRequest parseFrom(CodedInputStream input) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(input); } public static SetOfflineAreaIdRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SetOfflineAreaIdRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(SetOfflineAreaIdRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.SetOfflineAreaIdRequestOrBuilder {
/*  5705 */       private int bitField0_; private int c2SAreaId_; public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.SetOfflineAreaIdRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.SetOfflineAreaIdRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SAreaId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdRequest_descriptor; } public OfflineAwardHandler.SetOfflineAreaIdRequest getDefaultInstanceForType() { return OfflineAwardHandler.SetOfflineAreaIdRequest.getDefaultInstance(); } public OfflineAwardHandler.SetOfflineAreaIdRequest build() { OfflineAwardHandler.SetOfflineAreaIdRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public OfflineAwardHandler.SetOfflineAreaIdRequest buildPartial() { OfflineAwardHandler.SetOfflineAreaIdRequest result = new OfflineAwardHandler.SetOfflineAreaIdRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SAreaId_ = this.c2SAreaId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.SetOfflineAreaIdRequest) return mergeFrom((OfflineAwardHandler.SetOfflineAreaIdRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(OfflineAwardHandler.SetOfflineAreaIdRequest other) { if (other == OfflineAwardHandler.SetOfflineAreaIdRequest.getDefaultInstance()) return this;  if (other.hasC2SAreaId()) setC2SAreaId(other.getC2SAreaId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SAreaId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.SetOfflineAreaIdRequest parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.SetOfflineAreaIdRequest)OfflineAwardHandler.SetOfflineAreaIdRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.SetOfflineAreaIdRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SAreaId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SAreaId() { return this.c2SAreaId_; } public Builder setC2SAreaId(int value) { this.bitField0_ |= 0x1; this.c2SAreaId_ = value; onChanged(); return this; } public Builder clearC2SAreaId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SAreaId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class QueryOfflineAwardRequest
/*       */     extends GeneratedMessage
/*       */     implements QueryOfflineAwardRequestOrBuilder
/*       */   {
/*  6017 */     private static final QueryOfflineAwardRequest defaultInstance = new QueryOfflineAwardRequest(true); private final UnknownFieldSet unknownFields; private QueryOfflineAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryOfflineAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryOfflineAwardRequest getDefaultInstance() { return defaultInstance; } public QueryOfflineAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryOfflineAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryOfflineAwardRequest.class, Builder.class); } public static Parser<QueryOfflineAwardRequest> PARSER = (Parser<QueryOfflineAwardRequest>)new AbstractParser<QueryOfflineAwardRequest>() { public OfflineAwardHandler.QueryOfflineAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.QueryOfflineAwardRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryOfflineAwardRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QueryOfflineAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QueryOfflineAwardRequest)PARSER.parseFrom(data); } public static QueryOfflineAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryOfflineAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryOfflineAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QueryOfflineAwardRequest)PARSER.parseFrom(data); } public static QueryOfflineAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryOfflineAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryOfflineAwardRequest parseFrom(InputStream input) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseFrom(input); } public static QueryOfflineAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static QueryOfflineAwardRequest parseDelimitedFrom(InputStream input) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseDelimitedFrom(input); } public static QueryOfflineAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static QueryOfflineAwardRequest parseFrom(CodedInputStream input) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseFrom(input); } public static QueryOfflineAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryOfflineAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(QueryOfflineAwardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.QueryOfflineAwardRequestOrBuilder {
/*  6018 */       public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.QueryOfflineAwardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.QueryOfflineAwardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardRequest_descriptor; } public OfflineAwardHandler.QueryOfflineAwardRequest getDefaultInstanceForType() { return OfflineAwardHandler.QueryOfflineAwardRequest.getDefaultInstance(); } public OfflineAwardHandler.QueryOfflineAwardRequest build() { OfflineAwardHandler.QueryOfflineAwardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public OfflineAwardHandler.QueryOfflineAwardRequest buildPartial() { OfflineAwardHandler.QueryOfflineAwardRequest result = new OfflineAwardHandler.QueryOfflineAwardRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.QueryOfflineAwardRequest) return mergeFrom((OfflineAwardHandler.QueryOfflineAwardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(OfflineAwardHandler.QueryOfflineAwardRequest other) { if (other == OfflineAwardHandler.QueryOfflineAwardRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.QueryOfflineAwardRequest parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.QueryOfflineAwardRequest)OfflineAwardHandler.QueryOfflineAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.QueryOfflineAwardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class GetOfflineAwardRequest
/*       */     extends GeneratedMessage
/*       */     implements GetOfflineAwardRequestOrBuilder
/*       */   {
/*  6501 */     private static final GetOfflineAwardRequest defaultInstance = new GetOfflineAwardRequest(true); private final UnknownFieldSet unknownFields; private GetOfflineAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetOfflineAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetOfflineAwardRequest getDefaultInstance() { return defaultInstance; } public GetOfflineAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetOfflineAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SType_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOfflineAwardRequest.class, Builder.class); } public static Parser<GetOfflineAwardRequest> PARSER = (Parser<GetOfflineAwardRequest>)new AbstractParser<GetOfflineAwardRequest>() { public OfflineAwardHandler.GetOfflineAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.GetOfflineAwardRequest(input, extensionRegistry); } }
/*  6502 */     ; private int bitField0_; public static final int C2S_TYPE_FIELD_NUMBER = 1; private Object c2SType_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetOfflineAwardRequest> getParserForType() { return PARSER; } public boolean hasC2SType() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SType() { Object ref = this.c2SType_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SType_ = s;  return s; } public ByteString getC2STypeBytes() { Object ref = this.c2SType_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SType_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SType_ = "";
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
/*       */       if (!hasC2SType()) {
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
/*       */         output.writeBytes(1, getC2STypeBytes());
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getC2STypeBytes());
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
/*       */     public static GetOfflineAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(InputStream input) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static GetOfflineAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetOfflineAwardRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(GetOfflineAwardRequest prototype) {
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
/*       */       implements OfflineAwardHandler.GetOfflineAwardRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private Object c2SType_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardRequest_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.GetOfflineAwardRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SType_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.c2SType_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (OfflineAwardHandler.GetOfflineAwardRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.c2SType_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardRequest_descriptor;
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.GetOfflineAwardRequest getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.GetOfflineAwardRequest.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.GetOfflineAwardRequest build() {
/*       */         OfflineAwardHandler.GetOfflineAwardRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.GetOfflineAwardRequest buildPartial() {
/*       */         OfflineAwardHandler.GetOfflineAwardRequest result = new OfflineAwardHandler.GetOfflineAwardRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SType_ = this.c2SType_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof OfflineAwardHandler.GetOfflineAwardRequest) {
/*       */           return mergeFrom((OfflineAwardHandler.GetOfflineAwardRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(OfflineAwardHandler.GetOfflineAwardRequest other) {
/*       */         if (other == OfflineAwardHandler.GetOfflineAwardRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SType()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.c2SType_ = other.c2SType_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasC2SType()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         OfflineAwardHandler.GetOfflineAwardRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.GetOfflineAwardRequest)OfflineAwardHandler.GetOfflineAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.GetOfflineAwardRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasC2SType() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public String getC2SType() {
/*       */         Object ref = this.c2SType_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SType_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getC2STypeBytes() {
/*       */         Object ref = this.c2SType_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SType_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setC2SType(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearC2SType() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SType_ = OfflineAwardHandler.GetOfflineAwardRequest.getDefaultInstance().getC2SType();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setC2STypeBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class GetCurrentOfflineAreaRequest
/*       */     extends GeneratedMessage
/*       */     implements GetCurrentOfflineAreaRequestOrBuilder
/*       */   {
/*  6814 */     private static final GetCurrentOfflineAreaRequest defaultInstance = new GetCurrentOfflineAreaRequest(true); private final UnknownFieldSet unknownFields; private GetCurrentOfflineAreaRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetCurrentOfflineAreaRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetCurrentOfflineAreaRequest getDefaultInstance() { return defaultInstance; } public GetCurrentOfflineAreaRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetCurrentOfflineAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCurrentOfflineAreaRequest.class, Builder.class); } public static Parser<GetCurrentOfflineAreaRequest> PARSER = (Parser<GetCurrentOfflineAreaRequest>)new AbstractParser<GetCurrentOfflineAreaRequest>() { public OfflineAwardHandler.GetCurrentOfflineAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.GetCurrentOfflineAreaRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetCurrentOfflineAreaRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetCurrentOfflineAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(data); } public static GetCurrentOfflineAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetCurrentOfflineAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(data); } public static GetCurrentOfflineAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetCurrentOfflineAreaRequest parseFrom(InputStream input) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(input); } public static GetCurrentOfflineAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetCurrentOfflineAreaRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseDelimitedFrom(input); } public static GetCurrentOfflineAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetCurrentOfflineAreaRequest parseFrom(CodedInputStream input) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(input); } public static GetCurrentOfflineAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetCurrentOfflineAreaRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.GetCurrentOfflineAreaRequestOrBuilder {
/*  6815 */       public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.GetCurrentOfflineAreaRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.GetCurrentOfflineAreaRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaRequest_descriptor; } public OfflineAwardHandler.GetCurrentOfflineAreaRequest getDefaultInstanceForType() { return OfflineAwardHandler.GetCurrentOfflineAreaRequest.getDefaultInstance(); } public OfflineAwardHandler.GetCurrentOfflineAreaRequest build() { OfflineAwardHandler.GetCurrentOfflineAreaRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public OfflineAwardHandler.GetCurrentOfflineAreaRequest buildPartial() { OfflineAwardHandler.GetCurrentOfflineAreaRequest result = new OfflineAwardHandler.GetCurrentOfflineAreaRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.GetCurrentOfflineAreaRequest) return mergeFrom((OfflineAwardHandler.GetCurrentOfflineAreaRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(OfflineAwardHandler.GetCurrentOfflineAreaRequest other) { if (other == OfflineAwardHandler.GetCurrentOfflineAreaRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.GetCurrentOfflineAreaRequest parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.GetCurrentOfflineAreaRequest)OfflineAwardHandler.GetCurrentOfflineAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.GetCurrentOfflineAreaRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class SetOfflineAreaIdResponse
/*       */     extends GeneratedMessage
/*       */     implements SetOfflineAreaIdResponseOrBuilder
/*       */   {
/*  7376 */     private static final SetOfflineAreaIdResponse defaultInstance = new SetOfflineAreaIdResponse(true); private final UnknownFieldSet unknownFields; private SetOfflineAreaIdResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetOfflineAreaIdResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetOfflineAreaIdResponse getDefaultInstance() { return defaultInstance; } public SetOfflineAreaIdResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetOfflineAreaIdResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SetOfflineAreaIdResponse.class, Builder.class); } public static Parser<SetOfflineAreaIdResponse> PARSER = (Parser<SetOfflineAreaIdResponse>)new AbstractParser<SetOfflineAreaIdResponse>() { public OfflineAwardHandler.SetOfflineAreaIdResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.SetOfflineAreaIdResponse(input, extensionRegistry); } }
/*  7377 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetOfflineAreaIdResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
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
/*       */     public static SetOfflineAreaIdResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(InputStream input) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetOfflineAreaIdResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetOfflineAreaIdResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public static Builder newBuilder(SetOfflineAreaIdResponse prototype) {
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
/*       */       implements OfflineAwardHandler.SetOfflineAreaIdResponseOrBuilder
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdResponse_descriptor;
/*       */       }
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.SetOfflineAreaIdResponse.class, Builder.class);
/*       */       }
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
/*       */         if (OfflineAwardHandler.SetOfflineAreaIdResponse.alwaysUseFieldBuilders);
/*       */       }
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
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_SetOfflineAreaIdResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.SetOfflineAreaIdResponse getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.SetOfflineAreaIdResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public OfflineAwardHandler.SetOfflineAreaIdResponse build() {
/*       */         OfflineAwardHandler.SetOfflineAreaIdResponse result = buildPartial();
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
/*       */       public OfflineAwardHandler.SetOfflineAreaIdResponse buildPartial() {
/*       */         OfflineAwardHandler.SetOfflineAreaIdResponse result = new OfflineAwardHandler.SetOfflineAreaIdResponse(this);
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
/*       */         if (other instanceof OfflineAwardHandler.SetOfflineAreaIdResponse) {
/*       */           return mergeFrom((OfflineAwardHandler.SetOfflineAreaIdResponse)other);
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
/*       */       public Builder mergeFrom(OfflineAwardHandler.SetOfflineAreaIdResponse other) {
/*       */         if (other == OfflineAwardHandler.SetOfflineAreaIdResponse.getDefaultInstance()) {
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
/*       */         OfflineAwardHandler.SetOfflineAreaIdResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.SetOfflineAreaIdResponse)OfflineAwardHandler.SetOfflineAreaIdResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.SetOfflineAreaIdResponse)e.getUnfinishedMessage();
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = OfflineAwardHandler.SetOfflineAreaIdResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class QueryOfflineAwardResponse
/*       */     extends GeneratedMessage
/*       */     implements QueryOfflineAwardResponseOrBuilder
/*       */   {
/*  8139 */     private static final QueryOfflineAwardResponse defaultInstance = new QueryOfflineAwardResponse(true); private final UnknownFieldSet unknownFields; private QueryOfflineAwardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryOfflineAwardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryOfflineAwardResponse getDefaultInstance() { return defaultInstance; } public QueryOfflineAwardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryOfflineAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; OfflineAwardHandler.OfflineAward.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.offlineAward_.toBuilder();  this.offlineAward_ = (OfflineAwardHandler.OfflineAward)input.readMessage(OfflineAwardHandler.OfflineAward.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.offlineAward_); this.offlineAward_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryOfflineAwardResponse.class, Builder.class); } public static Parser<QueryOfflineAwardResponse> PARSER = (Parser<QueryOfflineAwardResponse>)new AbstractParser<QueryOfflineAwardResponse>() { public OfflineAwardHandler.QueryOfflineAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.QueryOfflineAwardResponse(input, extensionRegistry); } }
/*  8140 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int OFFLINEAWARD_FIELD_NUMBER = 3; private OfflineAwardHandler.OfflineAward offlineAward_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryOfflineAwardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasOfflineAward() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public OfflineAwardHandler.OfflineAward getOfflineAward() {
/*       */       return this.offlineAward_;
/*       */     }
/*       */     
/*       */     public OfflineAwardHandler.OfflineAwardOrBuilder getOfflineAwardOrBuilder() {
/*       */       return this.offlineAward_;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.offlineAward_ = OfflineAwardHandler.OfflineAward.getDefaultInstance();
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
/*       */       if (hasOfflineAward() && !getOfflineAward().isInitialized()) {
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
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeMessage(3, (MessageLite)this.offlineAward_);
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
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.offlineAward_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(InputStream input) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static QueryOfflineAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (QueryOfflineAwardResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(QueryOfflineAwardResponse prototype) {
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
/*       */       implements OfflineAwardHandler.QueryOfflineAwardResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private OfflineAwardHandler.OfflineAward offlineAward_;
/*       */       private SingleFieldBuilder<OfflineAwardHandler.OfflineAward, OfflineAwardHandler.OfflineAward.Builder, OfflineAwardHandler.OfflineAwardOrBuilder> offlineAwardBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.QueryOfflineAwardResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.offlineAward_ = OfflineAwardHandler.OfflineAward.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.offlineAward_ = OfflineAwardHandler.OfflineAward.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (OfflineAwardHandler.QueryOfflineAwardResponse.alwaysUseFieldBuilders)
/*       */           getOfflineAwardFieldBuilder(); 
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
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           this.offlineAward_ = OfflineAwardHandler.OfflineAward.getDefaultInstance();
/*       */         } else {
/*       */           this.offlineAwardBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_QueryOfflineAwardResponse_descriptor;
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.QueryOfflineAwardResponse getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.QueryOfflineAwardResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.QueryOfflineAwardResponse build() {
/*       */         OfflineAwardHandler.QueryOfflineAwardResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.QueryOfflineAwardResponse buildPartial() {
/*       */         OfflineAwardHandler.QueryOfflineAwardResponse result = new OfflineAwardHandler.QueryOfflineAwardResponse(this);
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
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           result.offlineAward_ = this.offlineAward_;
/*       */         } else {
/*       */           result.offlineAward_ = (OfflineAwardHandler.OfflineAward)this.offlineAwardBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof OfflineAwardHandler.QueryOfflineAwardResponse)
/*       */           return mergeFrom((OfflineAwardHandler.QueryOfflineAwardResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(OfflineAwardHandler.QueryOfflineAwardResponse other) {
/*       */         if (other == OfflineAwardHandler.QueryOfflineAwardResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasOfflineAward())
/*       */           mergeOfflineAward(other.getOfflineAward()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (hasOfflineAward() && !getOfflineAward().isInitialized())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         OfflineAwardHandler.QueryOfflineAwardResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.QueryOfflineAwardResponse)OfflineAwardHandler.QueryOfflineAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.QueryOfflineAwardResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = OfflineAwardHandler.QueryOfflineAwardResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasOfflineAward() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.OfflineAward getOfflineAward() {
/*       */         if (this.offlineAwardBuilder_ == null)
/*       */           return this.offlineAward_; 
/*       */         return (OfflineAwardHandler.OfflineAward)this.offlineAwardBuilder_.getMessage();
/*       */       }
/*       */       
/*       */       public Builder setOfflineAward(OfflineAwardHandler.OfflineAward value) {
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.offlineAward_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setOfflineAward(OfflineAwardHandler.OfflineAward.Builder builderForValue) {
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           this.offlineAward_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeOfflineAward(OfflineAwardHandler.OfflineAward value) {
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.offlineAward_ != OfflineAwardHandler.OfflineAward.getDefaultInstance()) {
/*       */             this.offlineAward_ = OfflineAwardHandler.OfflineAward.newBuilder(this.offlineAward_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.offlineAward_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearOfflineAward() {
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           this.offlineAward_ = OfflineAwardHandler.OfflineAward.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.offlineAwardBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.OfflineAward.Builder getOfflineAwardBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (OfflineAwardHandler.OfflineAward.Builder)getOfflineAwardFieldBuilder().getBuilder();
/*       */       }
/*       */       
/*       */       public OfflineAwardHandler.OfflineAwardOrBuilder getOfflineAwardOrBuilder() {
/*       */         if (this.offlineAwardBuilder_ != null)
/*       */           return (OfflineAwardHandler.OfflineAwardOrBuilder)this.offlineAwardBuilder_.getMessageOrBuilder(); 
/*       */         return this.offlineAward_;
/*       */       }
/*       */       
/*       */       private SingleFieldBuilder<OfflineAwardHandler.OfflineAward, OfflineAwardHandler.OfflineAward.Builder, OfflineAwardHandler.OfflineAwardOrBuilder> getOfflineAwardFieldBuilder() {
/*       */         if (this.offlineAwardBuilder_ == null) {
/*       */           this.offlineAwardBuilder_ = new SingleFieldBuilder(getOfflineAward(), getParentForChildren(), isClean());
/*       */           this.offlineAward_ = null;
/*       */         } 
/*       */         return this.offlineAwardBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class GetOfflineAwardResponse
/*       */     extends GeneratedMessage
/*       */     implements GetOfflineAwardResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private GetOfflineAwardResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private GetOfflineAwardResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static GetOfflineAwardResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public GetOfflineAwardResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private GetOfflineAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */       return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardResponse_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOfflineAwardResponse.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<GetOfflineAwardResponse> PARSER = (Parser<GetOfflineAwardResponse>)new AbstractParser<GetOfflineAwardResponse>()
/*       */       {
/*       */         public OfflineAwardHandler.GetOfflineAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new OfflineAwardHandler.GetOfflineAwardResponse(input, extensionRegistry);
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
/*       */     public Parser<GetOfflineAwardResponse> getParserForType() {
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
/*  8701 */     private static final GetOfflineAwardResponse defaultInstance = new GetOfflineAwardResponse(true); public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetOfflineAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetOfflineAwardResponse)PARSER.parseFrom(data); } public static GetOfflineAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOfflineAwardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetOfflineAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetOfflineAwardResponse)PARSER.parseFrom(data); } public static GetOfflineAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOfflineAwardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetOfflineAwardResponse parseFrom(InputStream input) throws IOException { return (GetOfflineAwardResponse)PARSER.parseFrom(input); } public static GetOfflineAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOfflineAwardResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetOfflineAwardResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetOfflineAwardResponse)PARSER.parseDelimitedFrom(input); } public static GetOfflineAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOfflineAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetOfflineAwardResponse parseFrom(CodedInputStream input) throws IOException { return (GetOfflineAwardResponse)PARSER.parseFrom(input); } public static GetOfflineAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOfflineAwardResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetOfflineAwardResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.GetOfflineAwardResponseOrBuilder {
/*  8702 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.GetOfflineAwardResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.GetOfflineAwardResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_GetOfflineAwardResponse_descriptor; } public OfflineAwardHandler.GetOfflineAwardResponse getDefaultInstanceForType() { return OfflineAwardHandler.GetOfflineAwardResponse.getDefaultInstance(); } public OfflineAwardHandler.GetOfflineAwardResponse build() { OfflineAwardHandler.GetOfflineAwardResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public OfflineAwardHandler.GetOfflineAwardResponse buildPartial() { OfflineAwardHandler.GetOfflineAwardResponse result = new OfflineAwardHandler.GetOfflineAwardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.GetOfflineAwardResponse) return mergeFrom((OfflineAwardHandler.GetOfflineAwardResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(OfflineAwardHandler.GetOfflineAwardResponse other) { if (other == OfflineAwardHandler.GetOfflineAwardResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.GetOfflineAwardResponse parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.GetOfflineAwardResponse)OfflineAwardHandler.GetOfflineAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.GetOfflineAwardResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = OfflineAwardHandler.GetOfflineAwardResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class GetCurrentOfflineAreaResponse
/*       */     extends GeneratedMessage
/*       */     implements GetCurrentOfflineAreaResponseOrBuilder
/*       */   {
/*  9576 */     private static final GetCurrentOfflineAreaResponse defaultInstance = new GetCurrentOfflineAreaResponse(true); private final UnknownFieldSet unknownFields; private GetCurrentOfflineAreaResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetCurrentOfflineAreaResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetCurrentOfflineAreaResponse getDefaultInstance() { return defaultInstance; } public GetCurrentOfflineAreaResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetCurrentOfflineAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.name_ = bs; break;case 32: this.bitField0_ |= 0x8; this.minLevel_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.maxLevel_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCurrentOfflineAreaResponse.class, Builder.class); } public static Parser<GetCurrentOfflineAreaResponse> PARSER = (Parser<GetCurrentOfflineAreaResponse>)new AbstractParser<GetCurrentOfflineAreaResponse>() { public OfflineAwardHandler.GetCurrentOfflineAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.GetCurrentOfflineAreaResponse(input, extensionRegistry); } }
/*  9577 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int NAME_FIELD_NUMBER = 3; private Object name_; public static final int MINLEVEL_FIELD_NUMBER = 4; private int minLevel_; public static final int MAXLEVEL_FIELD_NUMBER = 5; private int maxLevel_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetCurrentOfflineAreaResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasName() { return ((this.bitField0_ & 0x4) == 4); } public String getName() { Object ref = this.name_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.name_ = s; 
/*       */       return s; } public ByteString getNameBytes() { Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.name_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasMinLevel() { return ((this.bitField0_ & 0x8) == 8); } public int getMinLevel() { return this.minLevel_; } public boolean hasMaxLevel() { return ((this.bitField0_ & 0x10) == 16); } public int getMaxLevel() { return this.maxLevel_; } private void initFields() { this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.name_ = "";
/*       */       this.minLevel_ = 0;
/*       */       this.maxLevel_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
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
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeBytes(3, getNameBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.minLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeInt32(5, this.maxLevel_); 
/*       */       getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBytesSize(3, getNameBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.minLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.maxLevel_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetCurrentOfflineAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(data); } public static GetCurrentOfflineAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetCurrentOfflineAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(data); } public static GetCurrentOfflineAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetCurrentOfflineAreaResponse parseFrom(InputStream input) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(input); } public static GetCurrentOfflineAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetCurrentOfflineAreaResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseDelimitedFrom(input); } public static GetCurrentOfflineAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetCurrentOfflineAreaResponse parseFrom(CodedInputStream input) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(input); } public static GetCurrentOfflineAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetCurrentOfflineAreaResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetCurrentOfflineAreaResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.GetCurrentOfflineAreaResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Object name_; private int minLevel_; private int maxLevel_; public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.GetCurrentOfflineAreaResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = "";
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       } private void maybeForceBuilderInitialization() {
/*       */         if (OfflineAwardHandler.GetCurrentOfflineAreaResponse.alwaysUseFieldBuilders);
/*       */       } private static Builder create() {
/*       */         return new Builder();
/*       */       } public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.minLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.maxLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         return this;
/*       */       } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return OfflineAwardHandler.internal_static_pomelo_area_GetCurrentOfflineAreaResponse_descriptor;
/*       */       }
/*       */       public OfflineAwardHandler.GetCurrentOfflineAreaResponse getDefaultInstanceForType() {
/*       */         return OfflineAwardHandler.GetCurrentOfflineAreaResponse.getDefaultInstance();
/*       */       }
/*       */       public OfflineAwardHandler.GetCurrentOfflineAreaResponse build() {
/*       */         OfflineAwardHandler.GetCurrentOfflineAreaResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public OfflineAwardHandler.GetCurrentOfflineAreaResponse buildPartial() {
/*       */         OfflineAwardHandler.GetCurrentOfflineAreaResponse result = new OfflineAwardHandler.GetCurrentOfflineAreaResponse(this);
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
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.minLevel_ = this.minLevel_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.maxLevel_ = this.maxLevel_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof OfflineAwardHandler.GetCurrentOfflineAreaResponse)
/*       */           return mergeFrom((OfflineAwardHandler.GetCurrentOfflineAreaResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(OfflineAwardHandler.GetCurrentOfflineAreaResponse other) {
/*       */         if (other == OfflineAwardHandler.GetCurrentOfflineAreaResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasMinLevel())
/*       */           setMinLevel(other.getMinLevel()); 
/*       */         if (other.hasMaxLevel())
/*       */           setMaxLevel(other.getMaxLevel()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         OfflineAwardHandler.GetCurrentOfflineAreaResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (OfflineAwardHandler.GetCurrentOfflineAreaResponse)OfflineAwardHandler.GetCurrentOfflineAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (OfflineAwardHandler.GetCurrentOfflineAreaResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = OfflineAwardHandler.GetCurrentOfflineAreaResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
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
/*       */       public ByteString getNameBytes() {
/*       */         Object ref = this.name_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.name_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       public Builder setName(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.name_ = OfflineAwardHandler.GetCurrentOfflineAreaResponse.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMinLevel() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public int getMinLevel() {
/*       */         return this.minLevel_;
/*       */       }
/*       */       public Builder setMinLevel(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.minLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.minLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxLevel() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       public int getMaxLevel() {
/*       */         return this.maxLevel_;
/*       */       }
/*       */       public Builder setMaxLevel(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  9889 */   public static final class QueryAllAreasRequest extends GeneratedMessage implements QueryAllAreasRequestOrBuilder { private static final QueryAllAreasRequest defaultInstance = new QueryAllAreasRequest(true); private final UnknownFieldSet unknownFields; private QueryAllAreasRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryAllAreasRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryAllAreasRequest getDefaultInstance() { return defaultInstance; } public QueryAllAreasRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryAllAreasRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryAllAreasRequest.class, Builder.class); } public static Parser<QueryAllAreasRequest> PARSER = (Parser<QueryAllAreasRequest>)new AbstractParser<QueryAllAreasRequest>() { public OfflineAwardHandler.QueryAllAreasRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.QueryAllAreasRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryAllAreasRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QueryAllAreasRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QueryAllAreasRequest)PARSER.parseFrom(data); } public static QueryAllAreasRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryAllAreasRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryAllAreasRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QueryAllAreasRequest)PARSER.parseFrom(data); } public static QueryAllAreasRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryAllAreasRequest)PARSER.parseFrom(data, extensionRegistry); } public static QueryAllAreasRequest parseFrom(InputStream input) throws IOException { return (QueryAllAreasRequest)PARSER.parseFrom(input); } public static QueryAllAreasRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasRequest)PARSER.parseFrom(input, extensionRegistry); } public static QueryAllAreasRequest parseDelimitedFrom(InputStream input) throws IOException { return (QueryAllAreasRequest)PARSER.parseDelimitedFrom(input); } public static QueryAllAreasRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static QueryAllAreasRequest parseFrom(CodedInputStream input) throws IOException { return (QueryAllAreasRequest)PARSER.parseFrom(input); } public static QueryAllAreasRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(QueryAllAreasRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.QueryAllAreasRequestOrBuilder {
/*  9890 */       public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.QueryAllAreasRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.QueryAllAreasRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasRequest_descriptor; } public OfflineAwardHandler.QueryAllAreasRequest getDefaultInstanceForType() { return OfflineAwardHandler.QueryAllAreasRequest.getDefaultInstance(); } public OfflineAwardHandler.QueryAllAreasRequest build() { OfflineAwardHandler.QueryAllAreasRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public OfflineAwardHandler.QueryAllAreasRequest buildPartial() { OfflineAwardHandler.QueryAllAreasRequest result = new OfflineAwardHandler.QueryAllAreasRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.QueryAllAreasRequest) return mergeFrom((OfflineAwardHandler.QueryAllAreasRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(OfflineAwardHandler.QueryAllAreasRequest other) { if (other == OfflineAwardHandler.QueryAllAreasRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.QueryAllAreasRequest parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.QueryAllAreasRequest)OfflineAwardHandler.QueryAllAreasRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.QueryAllAreasRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class QueryAllAreasResponse
/*       */     extends GeneratedMessage
/*       */     implements QueryAllAreasResponseOrBuilder
/*       */   {
/* 10823 */     private static final QueryAllAreasResponse defaultInstance = new QueryAllAreasResponse(true); private final UnknownFieldSet unknownFields; private QueryAllAreasResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private QueryAllAreasResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static QueryAllAreasResponse getDefaultInstance() { return defaultInstance; } public QueryAllAreasResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private QueryAllAreasResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CAreasDetail_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CAreasDetail_.add(input.readMessage(OfflineAwardHandler.OfflineAreaDetail.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CAreasDetail_ = Collections.unmodifiableList(this.s2CAreasDetail_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryAllAreasResponse.class, Builder.class); } public static Parser<QueryAllAreasResponse> PARSER = (Parser<QueryAllAreasResponse>)new AbstractParser<QueryAllAreasResponse>() { public OfflineAwardHandler.QueryAllAreasResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new OfflineAwardHandler.QueryAllAreasResponse(input, extensionRegistry); } }
/* 10824 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_AREASDETAIL_FIELD_NUMBER = 3; private List<OfflineAwardHandler.OfflineAreaDetail> s2CAreasDetail_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<QueryAllAreasResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<OfflineAwardHandler.OfflineAreaDetail> getS2CAreasDetailList() { return this.s2CAreasDetail_; } public List<? extends OfflineAwardHandler.OfflineAreaDetailOrBuilder> getS2CAreasDetailOrBuilderList() { return (List)this.s2CAreasDetail_; } public int getS2CAreasDetailCount() { return this.s2CAreasDetail_.size(); } public OfflineAwardHandler.OfflineAreaDetail getS2CAreasDetail(int index) { return this.s2CAreasDetail_.get(index); } public OfflineAwardHandler.OfflineAreaDetailOrBuilder getS2CAreasDetailOrBuilder(int index) { return this.s2CAreasDetail_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CAreasDetail_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getS2CAreasDetailCount(); i++) { if (!getS2CAreasDetail(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  for (int i = 0; i < this.s2CAreasDetail_.size(); i++) output.writeMessage(3, (MessageLite)this.s2CAreasDetail_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  for (int i = 0; i < this.s2CAreasDetail_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CAreasDetail_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QueryAllAreasResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QueryAllAreasResponse)PARSER.parseFrom(data); } public static QueryAllAreasResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryAllAreasResponse)PARSER.parseFrom(data, extensionRegistry); } public static QueryAllAreasResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QueryAllAreasResponse)PARSER.parseFrom(data); } public static QueryAllAreasResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QueryAllAreasResponse)PARSER.parseFrom(data, extensionRegistry); } public static QueryAllAreasResponse parseFrom(InputStream input) throws IOException { return (QueryAllAreasResponse)PARSER.parseFrom(input); } public static QueryAllAreasResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasResponse)PARSER.parseFrom(input, extensionRegistry); } public static QueryAllAreasResponse parseDelimitedFrom(InputStream input) throws IOException { return (QueryAllAreasResponse)PARSER.parseDelimitedFrom(input); } public static QueryAllAreasResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static QueryAllAreasResponse parseFrom(CodedInputStream input) throws IOException { return (QueryAllAreasResponse)PARSER.parseFrom(input); } public static QueryAllAreasResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QueryAllAreasResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(QueryAllAreasResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } static { defaultInstance.initFields(); }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements OfflineAwardHandler.QueryAllAreasResponseOrBuilder {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private List<OfflineAwardHandler.OfflineAreaDetail> s2CAreasDetail_;
/*       */       private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAreaDetail, OfflineAwardHandler.OfflineAreaDetail.Builder, OfflineAwardHandler.OfflineAreaDetailOrBuilder> s2CAreasDetailBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineAwardHandler.QueryAllAreasResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; this.s2CAreasDetail_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CAreasDetail_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (OfflineAwardHandler.QueryAllAreasResponse.alwaysUseFieldBuilders)
/*       */           getS2CAreasDetailFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CAreasDetailBuilder_ == null) { this.s2CAreasDetail_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.s2CAreasDetailBuilder_.clear(); }  return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return OfflineAwardHandler.internal_static_pomelo_area_QueryAllAreasResponse_descriptor; }
/*       */       public OfflineAwardHandler.QueryAllAreasResponse getDefaultInstanceForType() { return OfflineAwardHandler.QueryAllAreasResponse.getDefaultInstance(); }
/*       */       public OfflineAwardHandler.QueryAllAreasResponse build() { OfflineAwardHandler.QueryAllAreasResponse result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public OfflineAwardHandler.QueryAllAreasResponse buildPartial() { OfflineAwardHandler.QueryAllAreasResponse result = new OfflineAwardHandler.QueryAllAreasResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.s2CAreasDetailBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.s2CAreasDetail_ = Collections.unmodifiableList(this.s2CAreasDetail_); this.bitField0_ &= 0xFFFFFFFB; }  result.s2CAreasDetail_ = this.s2CAreasDetail_; } else { result.s2CAreasDetail_ = this.s2CAreasDetailBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof OfflineAwardHandler.QueryAllAreasResponse)
/*       */           return mergeFrom((OfflineAwardHandler.QueryAllAreasResponse)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(OfflineAwardHandler.QueryAllAreasResponse other) { if (other == OfflineAwardHandler.QueryAllAreasResponse.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (this.s2CAreasDetailBuilder_ == null) { if (!other.s2CAreasDetail_.isEmpty()) { if (this.s2CAreasDetail_.isEmpty()) { this.s2CAreasDetail_ = other.s2CAreasDetail_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.addAll(other.s2CAreasDetail_); }  onChanged(); }  } else if (!other.s2CAreasDetail_.isEmpty()) { if (this.s2CAreasDetailBuilder_.isEmpty()) { this.s2CAreasDetailBuilder_.dispose(); this.s2CAreasDetailBuilder_ = null; this.s2CAreasDetail_ = other.s2CAreasDetail_; this.bitField0_ &= 0xFFFFFFFB; this.s2CAreasDetailBuilder_ = OfflineAwardHandler.QueryAllAreasResponse.alwaysUseFieldBuilders ? getS2CAreasDetailFieldBuilder() : null; } else { this.s2CAreasDetailBuilder_.addAllMessages(other.s2CAreasDetail_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false;  for (int i = 0; i < getS2CAreasDetailCount(); i++) { if (!getS2CAreasDetail(i).isInitialized())
/*       */             return false;  }  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { OfflineAwardHandler.QueryAllAreasResponse parsedMessage = null; try { parsedMessage = (OfflineAwardHandler.QueryAllAreasResponse)OfflineAwardHandler.QueryAllAreasResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (OfflineAwardHandler.QueryAllAreasResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage);  }  return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*       */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*       */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*       */       public Builder setS2CMsg(String value) { if (value == null)
/*       */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = OfflineAwardHandler.QueryAllAreasResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       private void ensureS2CAreasDetailIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.s2CAreasDetail_ = new ArrayList<>(this.s2CAreasDetail_); this.bitField0_ |= 0x4; }  }
/*       */       public List<OfflineAwardHandler.OfflineAreaDetail> getS2CAreasDetailList() { if (this.s2CAreasDetailBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CAreasDetail_);  return this.s2CAreasDetailBuilder_.getMessageList(); }
/*       */       public int getS2CAreasDetailCount() { if (this.s2CAreasDetailBuilder_ == null)
/*       */           return this.s2CAreasDetail_.size();  return this.s2CAreasDetailBuilder_.getCount(); }
/*       */       public OfflineAwardHandler.OfflineAreaDetail getS2CAreasDetail(int index) { if (this.s2CAreasDetailBuilder_ == null)
/*       */           return this.s2CAreasDetail_.get(index);  return (OfflineAwardHandler.OfflineAreaDetail)this.s2CAreasDetailBuilder_.getMessage(index); }
/*       */       public Builder setS2CAreasDetail(int index, OfflineAwardHandler.OfflineAreaDetail value) { if (this.s2CAreasDetailBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.set(index, value); onChanged(); } else { this.s2CAreasDetailBuilder_.setMessage(index, value); }  return this; }
/*       */       public Builder setS2CAreasDetail(int index, OfflineAwardHandler.OfflineAreaDetail.Builder builderForValue) { if (this.s2CAreasDetailBuilder_ == null) { ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.set(index, builderForValue.build()); onChanged(); } else { this.s2CAreasDetailBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addS2CAreasDetail(OfflineAwardHandler.OfflineAreaDetail value) { if (this.s2CAreasDetailBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.add(value); onChanged(); } else { this.s2CAreasDetailBuilder_.addMessage(value); }  return this; }
/*       */       public Builder addS2CAreasDetail(int index, OfflineAwardHandler.OfflineAreaDetail value) { if (this.s2CAreasDetailBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.add(index, value); onChanged(); } else { this.s2CAreasDetailBuilder_.addMessage(index, value); }  return this; }
/*       */       public Builder addS2CAreasDetail(OfflineAwardHandler.OfflineAreaDetail.Builder builderForValue) { if (this.s2CAreasDetailBuilder_ == null) { ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.add(builderForValue.build()); onChanged(); }
/*       */         else { this.s2CAreasDetailBuilder_.addMessage(builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addS2CAreasDetail(int index, OfflineAwardHandler.OfflineAreaDetail.Builder builderForValue) { if (this.s2CAreasDetailBuilder_ == null) { ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.add(index, builderForValue.build()); onChanged(); }
/*       */         else { this.s2CAreasDetailBuilder_.addMessage(index, builderForValue.build()); }
/*       */          return this; }
/*       */       public Builder addAllS2CAreasDetail(Iterable<? extends OfflineAwardHandler.OfflineAreaDetail> values) { if (this.s2CAreasDetailBuilder_ == null) { ensureS2CAreasDetailIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CAreasDetail_); onChanged(); }
/*       */         else { this.s2CAreasDetailBuilder_.addAllMessages(values); }
/*       */          return this; }
/*       */       public Builder clearS2CAreasDetail() { if (this.s2CAreasDetailBuilder_ == null) { this.s2CAreasDetail_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); }
/*       */         else { this.s2CAreasDetailBuilder_.clear(); }
/*       */          return this; }
/*       */       public Builder removeS2CAreasDetail(int index) { if (this.s2CAreasDetailBuilder_ == null) { ensureS2CAreasDetailIsMutable(); this.s2CAreasDetail_.remove(index); onChanged(); }
/*       */         else { this.s2CAreasDetailBuilder_.remove(index); }
/*       */          return this; }
/*       */       public OfflineAwardHandler.OfflineAreaDetail.Builder getS2CAreasDetailBuilder(int index) { return (OfflineAwardHandler.OfflineAreaDetail.Builder)getS2CAreasDetailFieldBuilder().getBuilder(index); } public OfflineAwardHandler.OfflineAreaDetailOrBuilder getS2CAreasDetailOrBuilder(int index) { if (this.s2CAreasDetailBuilder_ == null)
/*       */           return this.s2CAreasDetail_.get(index);  return (OfflineAwardHandler.OfflineAreaDetailOrBuilder)this.s2CAreasDetailBuilder_.getMessageOrBuilder(index); } public List<? extends OfflineAwardHandler.OfflineAreaDetailOrBuilder> getS2CAreasDetailOrBuilderList() { if (this.s2CAreasDetailBuilder_ != null)
/*       */           return this.s2CAreasDetailBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CAreasDetail_); } public OfflineAwardHandler.OfflineAreaDetail.Builder addS2CAreasDetailBuilder() { return (OfflineAwardHandler.OfflineAreaDetail.Builder)getS2CAreasDetailFieldBuilder().addBuilder(OfflineAwardHandler.OfflineAreaDetail.getDefaultInstance()); } public OfflineAwardHandler.OfflineAreaDetail.Builder addS2CAreasDetailBuilder(int index) { return (OfflineAwardHandler.OfflineAreaDetail.Builder)getS2CAreasDetailFieldBuilder().addBuilder(index, OfflineAwardHandler.OfflineAreaDetail.getDefaultInstance()); } public List<OfflineAwardHandler.OfflineAreaDetail.Builder> getS2CAreasDetailBuilderList() { return getS2CAreasDetailFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<OfflineAwardHandler.OfflineAreaDetail, OfflineAwardHandler.OfflineAreaDetail.Builder, OfflineAwardHandler.OfflineAreaDetailOrBuilder> getS2CAreasDetailFieldBuilder() { if (this.s2CAreasDetailBuilder_ == null) { this.s2CAreasDetailBuilder_ = new RepeatedFieldBuilder(this.s2CAreasDetail_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.s2CAreasDetail_ = null; }
/*       */          return this.s2CAreasDetailBuilder_; } }
/* 10903 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 10908 */     String[] descriptorData = { "\n\031offlineAwardHandler.proto\022\013pomelo.area\"a\n\020OfflineAwardItem\022\022\n\ntemplateId\030\001 \002(\005\022\r\n\005picId\030\002 \002(\005\022\f\n\004name\030\003 \002(\t\022\013\n\003num\030\004 \002(\005\022\017\n\007quality\030\005 \002(\005\"Ú\001\n\fOfflineAward\022\f\n\004flag\030\001 \002(\005\022\016\n\006areaId\030\002 \002(\005\022\f\n\004gold\030\003 \002(\005\022\013\n\003exp\030\004 \002(\005\0228\n\021offlineAwardItems\030\005 \003(\0132\035.pomelo.area.OfflineAwardItem\022\023\n\013offlineTime\030\006 \002(\005\022\016\n\006v1Cost\030\007 \002(\005\022\020\n\bv1BoxNum\030\b \002(\005\022\016\n\006v5Cost\030\t \002(\005\022\020\n\bv5BoxNum\030\n \002(\005\"ý\001\n\022OfflineAwardDetail\022\020\n\bareaName\030\001 \002(", "\t\022\023\n\013offlineTime\030\002 \002(\005\022\f\n\004gold\030\003 \002(\005\022\013\n\003exp\030\004 \002(\005\022\023\n\013goldPerHour\030\005 \002(\005\022\022\n\nexpPerHour\030\006 \002(\005\0228\n\021offlineAwardItems\030\007 \003(\0132\035.pomelo.area.OfflineAwardItem\022\016\n\006v1Cost\030\b \002(\005\022\020\n\bv1BoxNum\030\t \002(\005\022\016\n\006v5Cost\030\n \002(\005\022\020\n\bv5BoxNum\030\013 \002(\005\"Ë\001\n\021OfflineAreaDetail\022\f\n\004name\030\001 \002(\t\022\n\n\002id\030\002 \002(\005\022\020\n\bminLevel\030\003 \002(\005\022\020\n\bmaxLevel\030\004 \002(\005\022\025\n\rminFightPower\030\005 \002(\005\022\023\n\013goldPerHour\030\006 \002(\005\022\022\n\nexpPerHour\030\007 \002(\005\0228\n\021offlineAwardItems\030\b \003(\0132\035.pomelo", ".area.OfflineAwardItem\"-\n\027SetOfflineAreaIdRequest\022\022\n\nc2s_areaId\030\001 \002(\005\"\032\n\030QueryOfflineAwardRequest\"*\n\026GetOfflineAwardRequest\022\020\n\bc2s_type\030\001 \002(\t\"\036\n\034GetCurrentOfflineAreaRequest\"=\n\030SetOfflineAreaIdResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"o\n\031QueryOfflineAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\fofflineAward\030\003 \001(\0132\031.pomelo.area.OfflineAward\"<\n\027GetOfflineAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2", "c_msg\030\002 \001(\t\"t\n\035GetCurrentOfflineAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004name\030\003 \001(\t\022\020\n\bminLevel\030\004 \001(\005\022\020\n\bmaxLevel\030\005 \001(\005\"\026\n\024QueryAllAreasRequest\"s\n\025QueryAllAreasResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0227\n\017s2c_areasDetail\030\003 \003(\0132\036.pomelo.area.OfflineAreaDetail2£\004\n\023offlineAwardHandler\022]\n\024queryAllAreasRequest\022!.pomelo.area.QueryAllAreasRequest\032\".pomelo.area.QueryAllAreasResponse\022f\n\027setOffl", "ineAreaIdRequest\022$.pomelo.area.SetOfflineAreaIdRequest\032%.pomelo.area.SetOfflineAreaIdResponse\022i\n\030queryOfflineAwardRequest\022%.pomelo.area.QueryOfflineAwardRequest\032&.pomelo.area.QueryOfflineAwardResponse\022c\n\026getOfflineAwardRequest\022#.pomelo.area.GetOfflineAwardRequest\032$.pomelo.area.GetOfflineAwardResponse\022u\n\034getCurrentOfflineAreaRequest\022).pomelo.area.GetCurrentOfflineAreaRequest\032*.pomelo.area.GetCurren", "tOfflineAreaResponse" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10961 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 10965 */           OfflineAwardHandler.descriptor = root;
/* 10966 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 10970 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*       */   }
/*       */ 
/*       */   
/* 10974 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OfflineAwardItem_descriptor = getDescriptor().getMessageTypes().get(0);
/* 10975 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OfflineAwardItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OfflineAwardItem_descriptor, new String[] { "TemplateId", "PicId", "Name", "Num", "Quality" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10980 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OfflineAward_descriptor = getDescriptor().getMessageTypes().get(1);
/* 10981 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OfflineAward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OfflineAward_descriptor, new String[] { "Flag", "AreaId", "Gold", "Exp", "OfflineAwardItems", "OfflineTime", "V1Cost", "V1BoxNum", "V5Cost", "V5BoxNum" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10986 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OfflineAwardDetail_descriptor = getDescriptor().getMessageTypes().get(2);
/* 10987 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OfflineAwardDetail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OfflineAwardDetail_descriptor, new String[] { "AreaName", "OfflineTime", "Gold", "Exp", "GoldPerHour", "ExpPerHour", "OfflineAwardItems", "V1Cost", "V1BoxNum", "V5Cost", "V5BoxNum" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10992 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OfflineAreaDetail_descriptor = getDescriptor().getMessageTypes().get(3);
/* 10993 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OfflineAreaDetail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OfflineAreaDetail_descriptor, new String[] { "Name", "Id", "MinLevel", "MaxLevel", "MinFightPower", "GoldPerHour", "ExpPerHour", "OfflineAwardItems" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10998 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetOfflineAreaIdRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 10999 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetOfflineAreaIdRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetOfflineAreaIdRequest_descriptor, new String[] { "C2SAreaId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11004 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryOfflineAwardRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 11005 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryOfflineAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryOfflineAwardRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11010 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetOfflineAwardRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 11011 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOfflineAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOfflineAwardRequest_descriptor, new String[] { "C2SType" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11016 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetCurrentOfflineAreaRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 11017 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCurrentOfflineAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCurrentOfflineAreaRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11022 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetOfflineAreaIdResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 11023 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetOfflineAreaIdResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetOfflineAreaIdResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11028 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryOfflineAwardResponse_descriptor = getDescriptor().getMessageTypes().get(9);
/* 11029 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryOfflineAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryOfflineAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "OfflineAward" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11034 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetOfflineAwardResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 11035 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOfflineAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOfflineAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11040 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetCurrentOfflineAreaResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 11041 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCurrentOfflineAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCurrentOfflineAreaResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Name", "MinLevel", "MaxLevel" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11046 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryAllAreasRequest_descriptor = getDescriptor().getMessageTypes().get(12);
/* 11047 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryAllAreasRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryAllAreasRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 11052 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QueryAllAreasResponse_descriptor = getDescriptor().getMessageTypes().get(13);
/* 11053 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryAllAreasResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryAllAreasResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CAreasDetail" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   public static interface QueryAllAreasResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<OfflineAwardHandler.OfflineAreaDetail> getS2CAreasDetailList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAreaDetail getS2CAreasDetail(int param1Int);
/*       */     
/*       */     int getS2CAreasDetailCount();
/*       */     
/*       */     List<? extends OfflineAwardHandler.OfflineAreaDetailOrBuilder> getS2CAreasDetailOrBuilderList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAreaDetailOrBuilder getS2CAreasDetailOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface QueryAllAreasRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface GetCurrentOfflineAreaResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasMinLevel();
/*       */     
/*       */     int getMinLevel();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */   }
/*       */   
/*       */   public static interface GetOfflineAwardResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface QueryOfflineAwardResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasOfflineAward();
/*       */     
/*       */     OfflineAwardHandler.OfflineAward getOfflineAward();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardOrBuilder getOfflineAwardOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface SetOfflineAreaIdResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface GetCurrentOfflineAreaRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface GetOfflineAwardRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SType();
/*       */     
/*       */     String getC2SType();
/*       */     
/*       */     ByteString getC2STypeBytes();
/*       */   }
/*       */   
/*       */   public static interface QueryOfflineAwardRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface SetOfflineAreaIdRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SAreaId();
/*       */     
/*       */     int getC2SAreaId();
/*       */   }
/*       */   
/*       */   public static interface OfflineAreaDetailOrBuilder extends MessageOrBuilder {
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */     
/*       */     boolean hasMinLevel();
/*       */     
/*       */     int getMinLevel();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */     
/*       */     boolean hasMinFightPower();
/*       */     
/*       */     int getMinFightPower();
/*       */     
/*       */     boolean hasGoldPerHour();
/*       */     
/*       */     int getGoldPerHour();
/*       */     
/*       */     boolean hasExpPerHour();
/*       */     
/*       */     int getExpPerHour();
/*       */     
/*       */     List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int param1Int);
/*       */     
/*       */     int getOfflineAwardItemsCount();
/*       */     
/*       */     List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface OfflineAwardDetailOrBuilder extends MessageOrBuilder {
/*       */     boolean hasAreaName();
/*       */     
/*       */     String getAreaName();
/*       */     
/*       */     ByteString getAreaNameBytes();
/*       */     
/*       */     boolean hasOfflineTime();
/*       */     
/*       */     int getOfflineTime();
/*       */     
/*       */     boolean hasGold();
/*       */     
/*       */     int getGold();
/*       */     
/*       */     boolean hasExp();
/*       */     
/*       */     int getExp();
/*       */     
/*       */     boolean hasGoldPerHour();
/*       */     
/*       */     int getGoldPerHour();
/*       */     
/*       */     boolean hasExpPerHour();
/*       */     
/*       */     int getExpPerHour();
/*       */     
/*       */     List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int param1Int);
/*       */     
/*       */     int getOfflineAwardItemsCount();
/*       */     
/*       */     List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasV1Cost();
/*       */     
/*       */     int getV1Cost();
/*       */     
/*       */     boolean hasV1BoxNum();
/*       */     
/*       */     int getV1BoxNum();
/*       */     
/*       */     boolean hasV5Cost();
/*       */     
/*       */     int getV5Cost();
/*       */     
/*       */     boolean hasV5BoxNum();
/*       */     
/*       */     int getV5BoxNum();
/*       */   }
/*       */   
/*       */   public static interface OfflineAwardOrBuilder extends MessageOrBuilder {
/*       */     boolean hasFlag();
/*       */     
/*       */     int getFlag();
/*       */     
/*       */     boolean hasAreaId();
/*       */     
/*       */     int getAreaId();
/*       */     
/*       */     boolean hasGold();
/*       */     
/*       */     int getGold();
/*       */     
/*       */     boolean hasExp();
/*       */     
/*       */     int getExp();
/*       */     
/*       */     List<OfflineAwardHandler.OfflineAwardItem> getOfflineAwardItemsList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItem getOfflineAwardItems(int param1Int);
/*       */     
/*       */     int getOfflineAwardItemsCount();
/*       */     
/*       */     List<? extends OfflineAwardHandler.OfflineAwardItemOrBuilder> getOfflineAwardItemsOrBuilderList();
/*       */     
/*       */     OfflineAwardHandler.OfflineAwardItemOrBuilder getOfflineAwardItemsOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasOfflineTime();
/*       */     
/*       */     int getOfflineTime();
/*       */     
/*       */     boolean hasV1Cost();
/*       */     
/*       */     int getV1Cost();
/*       */     
/*       */     boolean hasV1BoxNum();
/*       */     
/*       */     int getV1BoxNum();
/*       */     
/*       */     boolean hasV5Cost();
/*       */     
/*       */     int getV5Cost();
/*       */     
/*       */     boolean hasV5BoxNum();
/*       */     
/*       */     int getV5BoxNum();
/*       */   }
/*       */   
/*       */   public static interface OfflineAwardItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasTemplateId();
/*       */     
/*       */     int getTemplateId();
/*       */     
/*       */     boolean hasPicId();
/*       */     
/*       */     int getPicId();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasNum();
/*       */     
/*       */     int getNum();
/*       */     
/*       */     boolean hasQuality();
/*       */     
/*       */     int getQuality();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\OfflineAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */