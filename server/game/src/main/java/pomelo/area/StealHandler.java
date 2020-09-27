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
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class StealHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class StealResponse
/*      */     extends GeneratedMessage
/*      */     implements StealResponseOrBuilder
/*      */   {
/* 1016 */     private static final StealResponse defaultInstance = new StealResponse(true); private final UnknownFieldSet unknownFields; private StealResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StealResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StealResponse getDefaultInstance() { return defaultInstance; } public StealResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StealResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CResult_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CItems_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return StealHandler.internal_static_pomelo_area_StealResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return StealHandler.internal_static_pomelo_area_StealResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(StealResponse.class, Builder.class); } public static Parser<StealResponse> PARSER = (Parser<StealResponse>)new AbstractParser<StealResponse>() { public StealHandler.StealResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new StealHandler.StealResponse(input, extensionRegistry); } }
/* 1017 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_RESULT_FIELD_NUMBER = 3; private int s2CResult_; public static final int S2C_ITEMS_FIELD_NUMBER = 4; private List<ItemOuterClass.MiniItem> s2CItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StealResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public boolean hasS2CResult() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CResult() { return this.s2CResult_; } public List<ItemOuterClass.MiniItem> getS2CItemsList() { return this.s2CItems_; } public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemsOrBuilderList() { return (List)this.s2CItems_; } public int getS2CItemsCount() { return this.s2CItems_.size(); } public ItemOuterClass.MiniItem getS2CItems(int index) { return this.s2CItems_.get(index); } public ItemOuterClass.MiniItemOrBuilder getS2CItemsOrBuilder(int index) { return (ItemOuterClass.MiniItemOrBuilder)this.s2CItems_.get(index); } private void initFields() { this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CResult_ = 0;
/*      */       this.s2CItems_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       for (int i = 0; i < getS2CItemsCount(); i++) {
/*      */         if (!getS2CItems(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(3, this.s2CResult_); 
/*      */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*      */         output.writeMessage(4, (MessageLite)this.s2CItems_.get(i)); 
/*      */       getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(3, this.s2CResult_); 
/*      */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CItems_.get(i)); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static StealResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (StealResponse)PARSER.parseFrom(data); } public static StealResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StealResponse)PARSER.parseFrom(data, extensionRegistry); } public static StealResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (StealResponse)PARSER.parseFrom(data); } public static StealResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StealResponse)PARSER.parseFrom(data, extensionRegistry); } public static StealResponse parseFrom(InputStream input) throws IOException { return (StealResponse)PARSER.parseFrom(input); } public static StealResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StealResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static StealResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (StealResponse)PARSER.parseDelimitedFrom(input);
/*      */     } public static StealResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StealResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static StealResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (StealResponse)PARSER.parseFrom(input);
/*      */     } public static StealResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (StealResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     } public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     } public static Builder newBuilder(StealResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     } public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements StealHandler.StealResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CResult_; private List<ItemOuterClass.MiniItem> s2CItems_; private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CItemsBuilder_; public static final Descriptors.Descriptor getDescriptor() {
/*      */         return StealHandler.internal_static_pomelo_area_StealResponse_descriptor;
/*      */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return StealHandler.internal_static_pomelo_area_StealResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(StealHandler.StealResponse.class, Builder.class);
/*      */       } private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CItems_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CItems_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private void maybeForceBuilderInitialization() {
/*      */         if (StealHandler.StealResponse.alwaysUseFieldBuilders)
/*      */           getS2CItemsFieldBuilder(); 
/*      */       } private static Builder create() {
/*      */         return new Builder();
/*      */       } public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CResult_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItems_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */         } else {
/*      */           this.s2CItemsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       } public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       } public Descriptors.Descriptor getDescriptorForType() {
/*      */         return StealHandler.internal_static_pomelo_area_StealResponse_descriptor;
/*      */       } public StealHandler.StealResponse getDefaultInstanceForType() {
/*      */         return StealHandler.StealResponse.getDefaultInstance();
/*      */       } public StealHandler.StealResponse build() {
/*      */         StealHandler.StealResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       } public StealHandler.StealResponse buildPartial() {
/*      */         StealHandler.StealResponse result = new StealHandler.StealResponse(this);
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
/*      */         result.s2CResult_ = this.s2CResult_;
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x8) == 8) {
/*      */             this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */           } 
/*      */           result.s2CItems_ = this.s2CItems_;
/*      */         } else {
/*      */           result.s2CItems_ = this.s2CItemsBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       } public Builder mergeFrom(Message other) {
/*      */         if (other instanceof StealHandler.StealResponse)
/*      */           return mergeFrom((StealHandler.StealResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       } public Builder mergeFrom(StealHandler.StealResponse other) {
/*      */         if (other == StealHandler.StealResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CResult())
/*      */           setS2CResult(other.getS2CResult()); 
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (!other.s2CItems_.isEmpty()) {
/*      */             if (this.s2CItems_.isEmpty()) {
/*      */               this.s2CItems_ = other.s2CItems_;
/*      */               this.bitField0_ &= 0xFFFFFFF7;
/*      */             } else {
/*      */               ensureS2CItemsIsMutable();
/*      */               this.s2CItems_.addAll(other.s2CItems_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CItems_.isEmpty()) {
/*      */           if (this.s2CItemsBuilder_.isEmpty()) {
/*      */             this.s2CItemsBuilder_.dispose();
/*      */             this.s2CItemsBuilder_ = null;
/*      */             this.s2CItems_ = other.s2CItems_;
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */             this.s2CItemsBuilder_ = StealHandler.StealResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       } public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         for (int i = 0; i < getS2CItemsCount(); i++) {
/*      */           if (!getS2CItems(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true;
/*      */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         StealHandler.StealResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (StealHandler.StealResponse)StealHandler.StealResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (StealHandler.StealResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       } public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       } public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       } public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       } public String getS2CMsg() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setS2CMsg(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = StealHandler.StealResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasS2CResult() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       } public int getS2CResult() {
/*      */         return this.s2CResult_;
/*      */       } public Builder setS2CResult(int value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CResult_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearS2CResult() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CResult_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } private void ensureS2CItemsIsMutable() {
/*      */         if ((this.bitField0_ & 0x8) != 8) {
/*      */           this.s2CItems_ = new ArrayList<>(this.s2CItems_);
/*      */           this.bitField0_ |= 0x8;
/*      */         } 
/*      */       } public List<ItemOuterClass.MiniItem> getS2CItemsList() {
/*      */         if (this.s2CItemsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CItems_); 
/*      */         return this.s2CItemsBuilder_.getMessageList();
/*      */       } public int getS2CItemsCount() {
/*      */         if (this.s2CItemsBuilder_ == null)
/*      */           return this.s2CItems_.size(); 
/*      */         return this.s2CItemsBuilder_.getCount();
/*      */       }
/*      */       public ItemOuterClass.MiniItem getS2CItems(int index) {
/*      */         if (this.s2CItemsBuilder_ == null)
/*      */           return this.s2CItems_.get(index); 
/*      */         return (ItemOuterClass.MiniItem)this.s2CItemsBuilder_.getMessage(index);
/*      */       }
/*      */       public Builder setS2CItems(int index, ItemOuterClass.MiniItem value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CItems(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CItems(ItemOuterClass.MiniItem value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CItems(int index, ItemOuterClass.MiniItem value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CItems(ItemOuterClass.MiniItem.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CItems(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addAllS2CItems(Iterable<? extends ItemOuterClass.MiniItem> values) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CItems_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CItems() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItems_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder removeS2CItems(int index) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public ItemOuterClass.MiniItem.Builder getS2CItemsBuilder(int index) {
/*      */         return (ItemOuterClass.MiniItem.Builder)getS2CItemsFieldBuilder().getBuilder(index);
/*      */       }
/*      */       public ItemOuterClass.MiniItemOrBuilder getS2CItemsOrBuilder(int index) {
/*      */         if (this.s2CItemsBuilder_ == null)
/*      */           return (ItemOuterClass.MiniItemOrBuilder)this.s2CItems_.get(index); 
/*      */         return (ItemOuterClass.MiniItemOrBuilder)this.s2CItemsBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemsOrBuilderList() {
/*      */         if (this.s2CItemsBuilder_ != null)
/*      */           return this.s2CItemsBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CItems_);
/*      */       }
/*      */       public ItemOuterClass.MiniItem.Builder addS2CItemsBuilder() {
/*      */         return (ItemOuterClass.MiniItem.Builder)getS2CItemsFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.MiniItem.getDefaultInstance());
/*      */       }
/*      */       public ItemOuterClass.MiniItem.Builder addS2CItemsBuilder(int index) {
/*      */         return (ItemOuterClass.MiniItem.Builder)getS2CItemsFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.MiniItem.getDefaultInstance());
/*      */       }
/*      */       public List<ItemOuterClass.MiniItem.Builder> getS2CItemsBuilderList() {
/*      */         return getS2CItemsFieldBuilder().getBuilderList();
/*      */       }
/*      */       private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CItemsFieldBuilder() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*      */           this.s2CItems_ = null;
/*      */         } 
/*      */         return this.s2CItemsBuilder_;
/*      */       } } }
/* 1421 */   public static final class StealRequest extends GeneratedMessage implements StealRequestOrBuilder { private static final StealRequest defaultInstance = new StealRequest(true); private final UnknownFieldSet unknownFields; private StealRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private StealRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static StealRequest getDefaultInstance() { return defaultInstance; } public StealRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private StealRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return StealHandler.internal_static_pomelo_area_StealRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return StealHandler.internal_static_pomelo_area_StealRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(StealRequest.class, Builder.class); } public static Parser<StealRequest> PARSER = (Parser<StealRequest>)new AbstractParser<StealRequest>() { public StealHandler.StealRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new StealHandler.StealRequest(input, extensionRegistry); } }
/* 1422 */     ; private int bitField0_; public static final int C2S_ID_FIELD_NUMBER = 1; private int c2SId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<StealRequest> getParserForType() { return PARSER; } public boolean hasC2SId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SId() { return this.c2SId_; } private void initFields() { this.c2SId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static StealRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (StealRequest)PARSER.parseFrom(data); } public static StealRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StealRequest)PARSER.parseFrom(data, extensionRegistry); } public static StealRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (StealRequest)PARSER.parseFrom(data); } public static StealRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (StealRequest)PARSER.parseFrom(data, extensionRegistry); } public static StealRequest parseFrom(InputStream input) throws IOException { return (StealRequest)PARSER.parseFrom(input); } public static StealRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StealRequest)PARSER.parseFrom(input, extensionRegistry); } static { defaultInstance.initFields(); }
/*      */     public static StealRequest parseDelimitedFrom(InputStream input) throws IOException { return (StealRequest)PARSER.parseDelimitedFrom(input); }
/*      */     public static StealRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StealRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static StealRequest parseFrom(CodedInputStream input) throws IOException { return (StealRequest)PARSER.parseFrom(input); }
/*      */     public static StealRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (StealRequest)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(StealRequest prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements StealHandler.StealRequestOrBuilder {
/*      */       private int bitField0_;
/*      */       private int c2SId_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return StealHandler.internal_static_pomelo_area_StealRequest_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return StealHandler.internal_static_pomelo_area_StealRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(StealHandler.StealRequest.class, Builder.class); }
/*      */       private Builder() { maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (StealHandler.StealRequest.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return StealHandler.internal_static_pomelo_area_StealRequest_descriptor; } public StealHandler.StealRequest getDefaultInstanceForType() { return StealHandler.StealRequest.getDefaultInstance(); } public StealHandler.StealRequest build() { StealHandler.StealRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public StealHandler.StealRequest buildPartial() { StealHandler.StealRequest result = new StealHandler.StealRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SId_ = this.c2SId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof StealHandler.StealRequest) return mergeFrom((StealHandler.StealRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(StealHandler.StealRequest other) { if (other == StealHandler.StealRequest.getDefaultInstance()) return this;  if (other.hasC2SId()) setC2SId(other.getC2SId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { StealHandler.StealRequest parsedMessage = null; try { parsedMessage = (StealHandler.StealRequest)StealHandler.StealRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (StealHandler.StealRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SId() { return this.c2SId_; } public Builder setC2SId(int value) { this.bitField0_ |= 0x1; this.c2SId_ = value; onChanged(); return this; } public Builder clearC2SId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SId_ = 0; onChanged(); return this; } } }
/* 1441 */    public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1446 */     String[] descriptorData = { "\n\022stealHandler.proto\022\013pomelo.area\032\nitem.proto\"p\n\rStealResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\022\n\ns2c_result\030\003 \001(\005\022(\n\ts2c_items\030\004 \003(\0132\025.pomelo.item.MiniItem\"\036\n\fStealRequest\022\016\n\006c2s_id\030\001 \002(\0052U\n\fstealHandler\022E\n\fstealRequest\022\031.pomelo.area.StealRequest\032\032.pomelo.area.StealResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1455 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 1459 */           StealHandler.descriptor = root;
/* 1460 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 1464 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 1466 */           ItemOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 1469 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StealResponse_descriptor = getDescriptor().getMessageTypes().get(0);
/* 1470 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StealResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StealResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CResult", "S2CItems" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1475 */   private static final Descriptors.Descriptor internal_static_pomelo_area_StealRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 1476 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_StealRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_StealRequest_descriptor, new String[] { "C2SId" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 1480 */     ItemOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface StealRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SId();
/*      */     
/*      */     int getC2SId();
/*      */   }
/*      */   
/*      */   public static interface StealResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CResult();
/*      */     
/*      */     int getS2CResult();
/*      */     
/*      */     List<ItemOuterClass.MiniItem> getS2CItemsList();
/*      */     
/*      */     ItemOuterClass.MiniItem getS2CItems(int param1Int);
/*      */     
/*      */     int getS2CItemsCount();
/*      */     
/*      */     List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemsOrBuilderList();
/*      */     
/*      */     ItemOuterClass.MiniItemOrBuilder getS2CItemsOrBuilder(int param1Int);
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\StealHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */