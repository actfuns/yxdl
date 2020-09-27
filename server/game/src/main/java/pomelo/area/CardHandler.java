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
/*       */ public final class CardHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class CardRegisterRequest
/*       */     extends GeneratedMessage
/*       */     implements CardRegisterRequestOrBuilder
/*       */   {
/*   409 */     private static final CardRegisterRequest defaultInstance = new CardRegisterRequest(true); private final UnknownFieldSet unknownFields; private CardRegisterRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardRegisterRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardRegisterRequest getDefaultInstance() { return defaultInstance; } public CardRegisterRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardRegisterRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SCardId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardRegisterRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardRegisterRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardRegisterRequest.class, Builder.class); } public static Parser<CardRegisterRequest> PARSER = (Parser<CardRegisterRequest>)new AbstractParser<CardRegisterRequest>() { public CardHandler.CardRegisterRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardRegisterRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_CARDID_FIELD_NUMBER = 1; private int c2SCardId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardRegisterRequest> getParserForType() { return PARSER; } public boolean hasC2SCardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardId() { return this.c2SCardId_; } private void initFields() { this.c2SCardId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SCardId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SCardId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SCardId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardRegisterRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardRegisterRequest)PARSER.parseFrom(data); } public static CardRegisterRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardRegisterRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardRegisterRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardRegisterRequest)PARSER.parseFrom(data); } public static CardRegisterRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardRegisterRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardRegisterRequest parseFrom(InputStream input) throws IOException { return (CardRegisterRequest)PARSER.parseFrom(input); } public static CardRegisterRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardRegisterRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardRegisterRequest)PARSER.parseDelimitedFrom(input); } public static CardRegisterRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardRegisterRequest parseFrom(CodedInputStream input) throws IOException { return (CardRegisterRequest)PARSER.parseFrom(input); } public static CardRegisterRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardRegisterRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardRegisterRequestOrBuilder {
/*   410 */       private int bitField0_; private int c2SCardId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardRegisterRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardRegisterRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardRegisterRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardRegisterRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SCardId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardRegisterRequest_descriptor; } public CardHandler.CardRegisterRequest getDefaultInstanceForType() { return CardHandler.CardRegisterRequest.getDefaultInstance(); } public CardHandler.CardRegisterRequest build() { CardHandler.CardRegisterRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardRegisterRequest buildPartial() { CardHandler.CardRegisterRequest result = new CardHandler.CardRegisterRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SCardId_ = this.c2SCardId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardRegisterRequest) return mergeFrom((CardHandler.CardRegisterRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardRegisterRequest other) { if (other == CardHandler.CardRegisterRequest.getDefaultInstance()) return this;  if (other.hasC2SCardId()) setC2SCardId(other.getC2SCardId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SCardId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardRegisterRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardRegisterRequest)CardHandler.CardRegisterRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardRegisterRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SCardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardId() { return this.c2SCardId_; } public Builder setC2SCardId(int value) { this.bitField0_ |= 0x1; this.c2SCardId_ = value; onChanged(); return this; } public Builder clearC2SCardId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SCardId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardLevelUpRequest
/*       */     extends GeneratedMessage
/*       */     implements CardLevelUpRequestOrBuilder
/*       */   {
/*   814 */     private static final CardLevelUpRequest defaultInstance = new CardLevelUpRequest(true); private final UnknownFieldSet unknownFields; private CardLevelUpRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardLevelUpRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardLevelUpRequest getDefaultInstance() { return defaultInstance; } public CardLevelUpRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardLevelUpRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SCardTemplateId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardLevelUpRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardLevelUpRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardLevelUpRequest.class, Builder.class); } public static Parser<CardLevelUpRequest> PARSER = (Parser<CardLevelUpRequest>)new AbstractParser<CardLevelUpRequest>() { public CardHandler.CardLevelUpRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardLevelUpRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_CARDTEMPLATEID_FIELD_NUMBER = 1; private int c2SCardTemplateId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardLevelUpRequest> getParserForType() { return PARSER; } public boolean hasC2SCardTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardTemplateId() { return this.c2SCardTemplateId_; } private void initFields() { this.c2SCardTemplateId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SCardTemplateId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SCardTemplateId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SCardTemplateId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardLevelUpRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardLevelUpRequest)PARSER.parseFrom(data); } public static CardLevelUpRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardLevelUpRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardLevelUpRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardLevelUpRequest)PARSER.parseFrom(data); } public static CardLevelUpRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardLevelUpRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardLevelUpRequest parseFrom(InputStream input) throws IOException { return (CardLevelUpRequest)PARSER.parseFrom(input); } public static CardLevelUpRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardLevelUpRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardLevelUpRequest)PARSER.parseDelimitedFrom(input); } public static CardLevelUpRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardLevelUpRequest parseFrom(CodedInputStream input) throws IOException { return (CardLevelUpRequest)PARSER.parseFrom(input); } public static CardLevelUpRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardLevelUpRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardLevelUpRequestOrBuilder {
/*   815 */       private int bitField0_; private int c2SCardTemplateId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardLevelUpRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardLevelUpRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardLevelUpRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardLevelUpRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SCardTemplateId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardLevelUpRequest_descriptor; } public CardHandler.CardLevelUpRequest getDefaultInstanceForType() { return CardHandler.CardLevelUpRequest.getDefaultInstance(); } public CardHandler.CardLevelUpRequest build() { CardHandler.CardLevelUpRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardLevelUpRequest buildPartial() { CardHandler.CardLevelUpRequest result = new CardHandler.CardLevelUpRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SCardTemplateId_ = this.c2SCardTemplateId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardLevelUpRequest) return mergeFrom((CardHandler.CardLevelUpRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardLevelUpRequest other) { if (other == CardHandler.CardLevelUpRequest.getDefaultInstance()) return this;  if (other.hasC2SCardTemplateId()) setC2SCardTemplateId(other.getC2SCardTemplateId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SCardTemplateId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardLevelUpRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardLevelUpRequest)CardHandler.CardLevelUpRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardLevelUpRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SCardTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardTemplateId() { return this.c2SCardTemplateId_; } public Builder setC2SCardTemplateId(int value) { this.bitField0_ |= 0x1; this.c2SCardTemplateId_ = value; onChanged(); return this; } public Builder clearC2SCardTemplateId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SCardTemplateId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardPreLevelUpRequest
/*       */     extends GeneratedMessage
/*       */     implements CardPreLevelUpRequestOrBuilder
/*       */   {
/*  1219 */     private static final CardPreLevelUpRequest defaultInstance = new CardPreLevelUpRequest(true); private final UnknownFieldSet unknownFields; private CardPreLevelUpRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardPreLevelUpRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardPreLevelUpRequest getDefaultInstance() { return defaultInstance; } public CardPreLevelUpRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardPreLevelUpRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SCardTemplateId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardPreLevelUpRequest.class, Builder.class); } public static Parser<CardPreLevelUpRequest> PARSER = (Parser<CardPreLevelUpRequest>)new AbstractParser<CardPreLevelUpRequest>() { public CardHandler.CardPreLevelUpRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardPreLevelUpRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_CARDTEMPLATEID_FIELD_NUMBER = 1; private int c2SCardTemplateId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardPreLevelUpRequest> getParserForType() { return PARSER; } public boolean hasC2SCardTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardTemplateId() { return this.c2SCardTemplateId_; } private void initFields() { this.c2SCardTemplateId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SCardTemplateId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SCardTemplateId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SCardTemplateId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardPreLevelUpRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardPreLevelUpRequest)PARSER.parseFrom(data); } public static CardPreLevelUpRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPreLevelUpRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardPreLevelUpRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardPreLevelUpRequest)PARSER.parseFrom(data); } public static CardPreLevelUpRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPreLevelUpRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardPreLevelUpRequest parseFrom(InputStream input) throws IOException { return (CardPreLevelUpRequest)PARSER.parseFrom(input); } public static CardPreLevelUpRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardPreLevelUpRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardPreLevelUpRequest)PARSER.parseDelimitedFrom(input); } public static CardPreLevelUpRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardPreLevelUpRequest parseFrom(CodedInputStream input) throws IOException { return (CardPreLevelUpRequest)PARSER.parseFrom(input); } public static CardPreLevelUpRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardPreLevelUpRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardPreLevelUpRequestOrBuilder {
/*  1220 */       private int bitField0_; private int c2SCardTemplateId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardPreLevelUpRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardPreLevelUpRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SCardTemplateId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpRequest_descriptor; } public CardHandler.CardPreLevelUpRequest getDefaultInstanceForType() { return CardHandler.CardPreLevelUpRequest.getDefaultInstance(); } public CardHandler.CardPreLevelUpRequest build() { CardHandler.CardPreLevelUpRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardPreLevelUpRequest buildPartial() { CardHandler.CardPreLevelUpRequest result = new CardHandler.CardPreLevelUpRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SCardTemplateId_ = this.c2SCardTemplateId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardPreLevelUpRequest) return mergeFrom((CardHandler.CardPreLevelUpRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardPreLevelUpRequest other) { if (other == CardHandler.CardPreLevelUpRequest.getDefaultInstance()) return this;  if (other.hasC2SCardTemplateId()) setC2SCardTemplateId(other.getC2SCardTemplateId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SCardTemplateId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardPreLevelUpRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardPreLevelUpRequest)CardHandler.CardPreLevelUpRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardPreLevelUpRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SCardTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardTemplateId() { return this.c2SCardTemplateId_; } public Builder setC2SCardTemplateId(int value) { this.bitField0_ |= 0x1; this.c2SCardTemplateId_ = value; onChanged(); return this; } public Builder clearC2SCardTemplateId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SCardTemplateId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardGetAwardRequest
/*       */     extends GeneratedMessage
/*       */     implements CardGetAwardRequestOrBuilder
/*       */   {
/*  1624 */     private static final CardGetAwardRequest defaultInstance = new CardGetAwardRequest(true); private final UnknownFieldSet unknownFields; private CardGetAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardGetAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardGetAwardRequest getDefaultInstance() { return defaultInstance; } public CardGetAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardGetAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SAwardId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardGetAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardGetAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardGetAwardRequest.class, Builder.class); } public static Parser<CardGetAwardRequest> PARSER = (Parser<CardGetAwardRequest>)new AbstractParser<CardGetAwardRequest>() { public CardHandler.CardGetAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardGetAwardRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_AWARDID_FIELD_NUMBER = 1; private int c2SAwardId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardGetAwardRequest> getParserForType() { return PARSER; } public boolean hasC2SAwardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SAwardId() { return this.c2SAwardId_; } private void initFields() { this.c2SAwardId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SAwardId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SAwardId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SAwardId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardGetAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardGetAwardRequest)PARSER.parseFrom(data); } public static CardGetAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardGetAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardGetAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardGetAwardRequest)PARSER.parseFrom(data); } public static CardGetAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardGetAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardGetAwardRequest parseFrom(InputStream input) throws IOException { return (CardGetAwardRequest)PARSER.parseFrom(input); } public static CardGetAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardGetAwardRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardGetAwardRequest)PARSER.parseDelimitedFrom(input); } public static CardGetAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardGetAwardRequest parseFrom(CodedInputStream input) throws IOException { return (CardGetAwardRequest)PARSER.parseFrom(input); } public static CardGetAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardGetAwardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardGetAwardRequestOrBuilder {
/*  1625 */       private int bitField0_; private int c2SAwardId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardGetAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardGetAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardGetAwardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardGetAwardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SAwardId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardGetAwardRequest_descriptor; } public CardHandler.CardGetAwardRequest getDefaultInstanceForType() { return CardHandler.CardGetAwardRequest.getDefaultInstance(); } public CardHandler.CardGetAwardRequest build() { CardHandler.CardGetAwardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardGetAwardRequest buildPartial() { CardHandler.CardGetAwardRequest result = new CardHandler.CardGetAwardRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SAwardId_ = this.c2SAwardId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardGetAwardRequest) return mergeFrom((CardHandler.CardGetAwardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardGetAwardRequest other) { if (other == CardHandler.CardGetAwardRequest.getDefaultInstance()) return this;  if (other.hasC2SAwardId()) setC2SAwardId(other.getC2SAwardId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SAwardId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardGetAwardRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardGetAwardRequest)CardHandler.CardGetAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardGetAwardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SAwardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SAwardId() { return this.c2SAwardId_; } public Builder setC2SAwardId(int value) { this.bitField0_ |= 0x1; this.c2SAwardId_ = value; onChanged(); return this; } public Builder clearC2SAwardId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SAwardId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardEquipRequest
/*       */     extends GeneratedMessage
/*       */     implements CardEquipRequestOrBuilder
/*       */   {
/*  2115 */     private static final CardEquipRequest defaultInstance = new CardEquipRequest(true); private final UnknownFieldSet unknownFields; private CardEquipRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardEquipRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardEquipRequest getDefaultInstance() { return defaultInstance; } public CardEquipRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardEquipRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SCardId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SHolePos_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardEquipRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardEquipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardEquipRequest.class, Builder.class); } public static Parser<CardEquipRequest> PARSER = (Parser<CardEquipRequest>)new AbstractParser<CardEquipRequest>() { public CardHandler.CardEquipRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardEquipRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_CARDID_FIELD_NUMBER = 1; private int c2SCardId_; public static final int C2S_HOLEPOS_FIELD_NUMBER = 2; private int c2SHolePos_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardEquipRequest> getParserForType() { return PARSER; } public boolean hasC2SCardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardId() { return this.c2SCardId_; } public boolean hasC2SHolePos() { return ((this.bitField0_ & 0x2) == 2); } public int getC2SHolePos() { return this.c2SHolePos_; } private void initFields() { this.c2SCardId_ = 0; this.c2SHolePos_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SCardId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasC2SHolePos()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SCardId_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2SHolePos_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SCardId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SHolePos_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardEquipRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardEquipRequest)PARSER.parseFrom(data); } public static CardEquipRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardEquipRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardEquipRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardEquipRequest)PARSER.parseFrom(data); } public static CardEquipRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardEquipRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardEquipRequest parseFrom(InputStream input) throws IOException { return (CardEquipRequest)PARSER.parseFrom(input); } public static CardEquipRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardEquipRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardEquipRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardEquipRequest)PARSER.parseDelimitedFrom(input); } public static CardEquipRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardEquipRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardEquipRequest parseFrom(CodedInputStream input) throws IOException { return (CardEquipRequest)PARSER.parseFrom(input); } public static CardEquipRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardEquipRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardEquipRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardEquipRequestOrBuilder {
/*  2116 */       private int bitField0_; private int c2SCardId_; private int c2SHolePos_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardEquipRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardEquipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardEquipRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardEquipRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SCardId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.c2SHolePos_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardEquipRequest_descriptor; } public CardHandler.CardEquipRequest getDefaultInstanceForType() { return CardHandler.CardEquipRequest.getDefaultInstance(); } public CardHandler.CardEquipRequest build() { CardHandler.CardEquipRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardEquipRequest buildPartial() { CardHandler.CardEquipRequest result = new CardHandler.CardEquipRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SCardId_ = this.c2SCardId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.c2SHolePos_ = this.c2SHolePos_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardEquipRequest) return mergeFrom((CardHandler.CardEquipRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardEquipRequest other) { if (other == CardHandler.CardEquipRequest.getDefaultInstance()) return this;  if (other.hasC2SCardId()) setC2SCardId(other.getC2SCardId());  if (other.hasC2SHolePos()) setC2SHolePos(other.getC2SHolePos());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SCardId()) return false;  if (!hasC2SHolePos()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardEquipRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardEquipRequest)CardHandler.CardEquipRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardEquipRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SCardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SCardId() { return this.c2SCardId_; } public Builder setC2SCardId(int value) { this.bitField0_ |= 0x1; this.c2SCardId_ = value; onChanged(); return this; } public Builder clearC2SCardId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SCardId_ = 0; onChanged(); return this; } public boolean hasC2SHolePos() { return ((this.bitField0_ & 0x2) == 2); } public int getC2SHolePos() { return this.c2SHolePos_; } public Builder setC2SHolePos(int value) { this.bitField0_ |= 0x2; this.c2SHolePos_ = value; onChanged(); return this; } public Builder clearC2SHolePos() { this.bitField0_ &= 0xFFFFFFFD; this.c2SHolePos_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardQueryAllDataRequest
/*       */     extends GeneratedMessage
/*       */     implements CardQueryAllDataRequestOrBuilder
/*       */   {
/*  2428 */     private static final CardQueryAllDataRequest defaultInstance = new CardQueryAllDataRequest(true); private final UnknownFieldSet unknownFields; private CardQueryAllDataRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardQueryAllDataRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardQueryAllDataRequest getDefaultInstance() { return defaultInstance; } public CardQueryAllDataRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardQueryAllDataRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardQueryAllDataRequest.class, Builder.class); } public static Parser<CardQueryAllDataRequest> PARSER = (Parser<CardQueryAllDataRequest>)new AbstractParser<CardQueryAllDataRequest>() { public CardHandler.CardQueryAllDataRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardQueryAllDataRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardQueryAllDataRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardQueryAllDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardQueryAllDataRequest)PARSER.parseFrom(data); } public static CardQueryAllDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardQueryAllDataRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardQueryAllDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardQueryAllDataRequest)PARSER.parseFrom(data); } public static CardQueryAllDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardQueryAllDataRequest)PARSER.parseFrom(data, extensionRegistry); } public static CardQueryAllDataRequest parseFrom(InputStream input) throws IOException { return (CardQueryAllDataRequest)PARSER.parseFrom(input); } public static CardQueryAllDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataRequest)PARSER.parseFrom(input, extensionRegistry); } public static CardQueryAllDataRequest parseDelimitedFrom(InputStream input) throws IOException { return (CardQueryAllDataRequest)PARSER.parseDelimitedFrom(input); } public static CardQueryAllDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardQueryAllDataRequest parseFrom(CodedInputStream input) throws IOException { return (CardQueryAllDataRequest)PARSER.parseFrom(input); } public static CardQueryAllDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardQueryAllDataRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardQueryAllDataRequestOrBuilder {
/*  2429 */       public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardQueryAllDataRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardQueryAllDataRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataRequest_descriptor; } public CardHandler.CardQueryAllDataRequest getDefaultInstanceForType() { return CardHandler.CardQueryAllDataRequest.getDefaultInstance(); } public CardHandler.CardQueryAllDataRequest build() { CardHandler.CardQueryAllDataRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardQueryAllDataRequest buildPartial() { CardHandler.CardQueryAllDataRequest result = new CardHandler.CardQueryAllDataRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardQueryAllDataRequest) return mergeFrom((CardHandler.CardQueryAllDataRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardQueryAllDataRequest other) { if (other == CardHandler.CardQueryAllDataRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardQueryAllDataRequest parsedMessage = null; try { parsedMessage = (CardHandler.CardQueryAllDataRequest)CardHandler.CardQueryAllDataRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardQueryAllDataRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class cardRelationAttStruct
/*       */     extends GeneratedMessage
/*       */     implements cardRelationAttStructOrBuilder
/*       */   {
/*  3414 */     private static final cardRelationAttStruct defaultInstance = new cardRelationAttStruct(true); private final UnknownFieldSet unknownFields; private cardRelationAttStruct(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private cardRelationAttStruct(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static cardRelationAttStruct getDefaultInstance() { return defaultInstance; } public cardRelationAttStruct getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private cardRelationAttStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.name_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.des_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.attName_ = bs; break;case 32: this.bitField0_ |= 0x8; this.attValue_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.condition_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_cardRelationAttStruct_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_cardRelationAttStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(cardRelationAttStruct.class, Builder.class); } public static Parser<cardRelationAttStruct> PARSER = (Parser<cardRelationAttStruct>)new AbstractParser<cardRelationAttStruct>() { public CardHandler.cardRelationAttStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.cardRelationAttStruct(input, extensionRegistry); } }; private int bitField0_; public static final int NAME_FIELD_NUMBER = 1; private Object name_; public static final int DES_FIELD_NUMBER = 2; private Object des_; public static final int ATTNAME_FIELD_NUMBER = 3; private Object attName_; public static final int ATTVALUE_FIELD_NUMBER = 4; private int attValue_; public static final int CONDITION_FIELD_NUMBER = 5; private int condition_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<cardRelationAttStruct> getParserForType() { return PARSER; } public boolean hasName() { return ((this.bitField0_ & 0x1) == 1); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public boolean hasDes() { return ((this.bitField0_ & 0x2) == 2); } public String getDes() { Object ref = this.des_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.des_ = s;  return s; } public ByteString getDesBytes() { Object ref = this.des_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.des_ = b; return b; }  return (ByteString)ref; } public boolean hasAttName() { return ((this.bitField0_ & 0x4) == 4); } public String getAttName() { Object ref = this.attName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.attName_ = s;  return s; } public ByteString getAttNameBytes() { Object ref = this.attName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.attName_ = b; return b; }  return (ByteString)ref; } public boolean hasAttValue() { return ((this.bitField0_ & 0x8) == 8); } public int getAttValue() { return this.attValue_; } public boolean hasCondition() { return ((this.bitField0_ & 0x10) == 16); } public int getCondition() { return this.condition_; } private void initFields() { this.name_ = ""; this.des_ = ""; this.attName_ = ""; this.attValue_ = 0; this.condition_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasDes()) { this.memoizedIsInitialized = 0; return false; }  if (!hasAttName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasAttValue()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCondition()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getNameBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getDesBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getAttNameBytes());  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.attValue_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.condition_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getNameBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getDesBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getAttNameBytes());  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.attValue_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.condition_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static cardRelationAttStruct parseFrom(ByteString data) throws InvalidProtocolBufferException { return (cardRelationAttStruct)PARSER.parseFrom(data); } public static cardRelationAttStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (cardRelationAttStruct)PARSER.parseFrom(data, extensionRegistry); } public static cardRelationAttStruct parseFrom(byte[] data) throws InvalidProtocolBufferException { return (cardRelationAttStruct)PARSER.parseFrom(data); } public static cardRelationAttStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (cardRelationAttStruct)PARSER.parseFrom(data, extensionRegistry); } public static cardRelationAttStruct parseFrom(InputStream input) throws IOException { return (cardRelationAttStruct)PARSER.parseFrom(input); } public static cardRelationAttStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (cardRelationAttStruct)PARSER.parseFrom(input, extensionRegistry); } public static cardRelationAttStruct parseDelimitedFrom(InputStream input) throws IOException { return (cardRelationAttStruct)PARSER.parseDelimitedFrom(input); } public static cardRelationAttStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (cardRelationAttStruct)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static cardRelationAttStruct parseFrom(CodedInputStream input) throws IOException { return (cardRelationAttStruct)PARSER.parseFrom(input); } public static cardRelationAttStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (cardRelationAttStruct)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(cardRelationAttStruct prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.cardRelationAttStructOrBuilder {
/*  3415 */       private int bitField0_; private Object name_; private Object des_; private Object attName_; private int attValue_; private int condition_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_cardRelationAttStruct_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_cardRelationAttStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.cardRelationAttStruct.class, Builder.class); } private Builder() { this.name_ = ""; this.des_ = ""; this.attName_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.name_ = ""; this.des_ = ""; this.attName_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.cardRelationAttStruct.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.name_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.des_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.attName_ = ""; this.bitField0_ &= 0xFFFFFFFB; this.attValue_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.condition_ = 0; this.bitField0_ &= 0xFFFFFFEF; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_cardRelationAttStruct_descriptor; } public CardHandler.cardRelationAttStruct getDefaultInstanceForType() { return CardHandler.cardRelationAttStruct.getDefaultInstance(); } public CardHandler.cardRelationAttStruct build() { CardHandler.cardRelationAttStruct result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.cardRelationAttStruct buildPartial() { CardHandler.cardRelationAttStruct result = new CardHandler.cardRelationAttStruct(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.name_ = this.name_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.des_ = this.des_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.attName_ = this.attName_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.attValue_ = this.attValue_; if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;  result.condition_ = this.condition_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.cardRelationAttStruct) return mergeFrom((CardHandler.cardRelationAttStruct)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.cardRelationAttStruct other) { if (other == CardHandler.cardRelationAttStruct.getDefaultInstance()) return this;  if (other.hasName()) { this.bitField0_ |= 0x1; this.name_ = other.name_; onChanged(); }  if (other.hasDes()) { this.bitField0_ |= 0x2; this.des_ = other.des_; onChanged(); }  if (other.hasAttName()) { this.bitField0_ |= 0x4; this.attName_ = other.attName_; onChanged(); }  if (other.hasAttValue()) setAttValue(other.getAttValue());  if (other.hasCondition()) setCondition(other.getCondition());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasName()) return false;  if (!hasDes()) return false;  if (!hasAttName()) return false;  if (!hasAttValue()) return false;  if (!hasCondition()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.cardRelationAttStruct parsedMessage = null; try { parsedMessage = (CardHandler.cardRelationAttStruct)CardHandler.cardRelationAttStruct.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.cardRelationAttStruct)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasName() { return ((this.bitField0_ & 0x1) == 1); } public String getName() { Object ref = this.name_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; }  return (String)ref; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public Builder setName(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.name_ = value; onChanged(); return this; } public Builder clearName() { this.bitField0_ &= 0xFFFFFFFE; this.name_ = CardHandler.cardRelationAttStruct.getDefaultInstance().getName(); onChanged(); return this; } public Builder setNameBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.name_ = value; onChanged(); return this; } public boolean hasDes() { return ((this.bitField0_ & 0x2) == 2); } public String getDes() { Object ref = this.des_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.des_ = s;  return s; }  return (String)ref; } public ByteString getDesBytes() { Object ref = this.des_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.des_ = b; return b; }  return (ByteString)ref; } public Builder setDes(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.des_ = value; onChanged(); return this; } public Builder clearDes() { this.bitField0_ &= 0xFFFFFFFD; this.des_ = CardHandler.cardRelationAttStruct.getDefaultInstance().getDes(); onChanged(); return this; } public Builder setDesBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.des_ = value; onChanged(); return this; } public boolean hasAttName() { return ((this.bitField0_ & 0x4) == 4); } public String getAttName() { Object ref = this.attName_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.attName_ = s;  return s; }  return (String)ref; } public ByteString getAttNameBytes() { Object ref = this.attName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.attName_ = b; return b; }  return (ByteString)ref; } public Builder setAttName(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.attName_ = value; onChanged(); return this; } public Builder clearAttName() { this.bitField0_ &= 0xFFFFFFFB; this.attName_ = CardHandler.cardRelationAttStruct.getDefaultInstance().getAttName(); onChanged(); return this; } public Builder setAttNameBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.attName_ = value; onChanged(); return this; } public boolean hasAttValue() { return ((this.bitField0_ & 0x8) == 8); } public int getAttValue() { return this.attValue_; } public Builder setAttValue(int value) { this.bitField0_ |= 0x8; this.attValue_ = value; onChanged(); return this; } public Builder clearAttValue() { this.bitField0_ &= 0xFFFFFFF7; this.attValue_ = 0; onChanged(); return this; } public boolean hasCondition() { return ((this.bitField0_ & 0x10) == 16); } public int getCondition() { return this.condition_; } public Builder setCondition(int value) { this.bitField0_ |= 0x10; this.condition_ = value; onChanged(); return this; } public Builder clearCondition() { this.bitField0_ &= 0xFFFFFFEF; this.condition_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardPropertyStruct
/*       */     extends GeneratedMessage
/*       */     implements CardPropertyStructOrBuilder
/*       */   {
/*  4211 */     private static final CardPropertyStruct defaultInstance = new CardPropertyStruct(true); private final UnknownFieldSet unknownFields; private CardPropertyStruct(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardPropertyStruct(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardPropertyStruct getDefaultInstance() { return defaultInstance; } public CardPropertyStruct getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardPropertyStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.describ_ = bs; break;case 16: this.bitField0_ |= 0x2; this.value_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.maxValue_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.name_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPropertyStruct_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(CardPropertyStruct.class, Builder.class); } public static Parser<CardPropertyStruct> PARSER = (Parser<CardPropertyStruct>)new AbstractParser<CardPropertyStruct>() { public CardHandler.CardPropertyStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardPropertyStruct(input, extensionRegistry); } }; private int bitField0_; public static final int DESCRIB_FIELD_NUMBER = 1; private Object describ_; public static final int VALUE_FIELD_NUMBER = 2; private int value_; public static final int MAXVALUE_FIELD_NUMBER = 3; private int maxValue_; public static final int NAME_FIELD_NUMBER = 4; private Object name_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardPropertyStruct> getParserForType() { return PARSER; } public boolean hasDescrib() { return ((this.bitField0_ & 0x1) == 1); } public String getDescrib() { Object ref = this.describ_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.describ_ = s;  return s; } public ByteString getDescribBytes() { Object ref = this.describ_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.describ_ = b; return b; }  return (ByteString)ref; } public boolean hasValue() { return ((this.bitField0_ & 0x2) == 2); } public int getValue() { return this.value_; } public boolean hasMaxValue() { return ((this.bitField0_ & 0x4) == 4); } public int getMaxValue() { return this.maxValue_; } public boolean hasName() { return ((this.bitField0_ & 0x8) == 8); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.describ_ = ""; this.value_ = 0; this.maxValue_ = 0; this.name_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDescrib()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getDescribBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.value_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.maxValue_);  if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getNameBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getDescribBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.value_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.maxValue_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getNameBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardPropertyStruct parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardPropertyStruct)PARSER.parseFrom(data); } public static CardPropertyStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPropertyStruct)PARSER.parseFrom(data, extensionRegistry); } public static CardPropertyStruct parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardPropertyStruct)PARSER.parseFrom(data); } public static CardPropertyStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPropertyStruct)PARSER.parseFrom(data, extensionRegistry); } public static CardPropertyStruct parseFrom(InputStream input) throws IOException { return (CardPropertyStruct)PARSER.parseFrom(input); } public static CardPropertyStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPropertyStruct)PARSER.parseFrom(input, extensionRegistry); } public static CardPropertyStruct parseDelimitedFrom(InputStream input) throws IOException { return (CardPropertyStruct)PARSER.parseDelimitedFrom(input); } public static CardPropertyStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPropertyStruct)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardPropertyStruct parseFrom(CodedInputStream input) throws IOException { return (CardPropertyStruct)PARSER.parseFrom(input); } public static CardPropertyStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPropertyStruct)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardPropertyStruct prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardPropertyStructOrBuilder {
/*  4212 */       private int bitField0_; private Object describ_; private int value_; private int maxValue_; private Object name_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPropertyStruct_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPropertyStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardPropertyStruct.class, Builder.class); } private Builder() { this.describ_ = ""; this.name_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.describ_ = ""; this.name_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardPropertyStruct.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.describ_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.value_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.maxValue_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.name_ = ""; this.bitField0_ &= 0xFFFFFFF7; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardPropertyStruct_descriptor; } public CardHandler.CardPropertyStruct getDefaultInstanceForType() { return CardHandler.CardPropertyStruct.getDefaultInstance(); } public CardHandler.CardPropertyStruct build() { CardHandler.CardPropertyStruct result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardPropertyStruct buildPartial() { CardHandler.CardPropertyStruct result = new CardHandler.CardPropertyStruct(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.describ_ = this.describ_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.value_ = this.value_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.maxValue_ = this.maxValue_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.name_ = this.name_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardPropertyStruct) return mergeFrom((CardHandler.CardPropertyStruct)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardPropertyStruct other) { if (other == CardHandler.CardPropertyStruct.getDefaultInstance()) return this;  if (other.hasDescrib()) { this.bitField0_ |= 0x1; this.describ_ = other.describ_; onChanged(); }  if (other.hasValue()) setValue(other.getValue());  if (other.hasMaxValue()) setMaxValue(other.getMaxValue());  if (other.hasName()) { this.bitField0_ |= 0x8; this.name_ = other.name_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDescrib()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardPropertyStruct parsedMessage = null; try { parsedMessage = (CardHandler.CardPropertyStruct)CardHandler.CardPropertyStruct.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardPropertyStruct)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDescrib() { return ((this.bitField0_ & 0x1) == 1); } public String getDescrib() { Object ref = this.describ_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.describ_ = s;  return s; }  return (String)ref; } public ByteString getDescribBytes() { Object ref = this.describ_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.describ_ = b; return b; }  return (ByteString)ref; } public Builder setDescrib(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.describ_ = value; onChanged(); return this; } public Builder clearDescrib() { this.bitField0_ &= 0xFFFFFFFE; this.describ_ = CardHandler.CardPropertyStruct.getDefaultInstance().getDescrib(); onChanged(); return this; } public Builder setDescribBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.describ_ = value; onChanged(); return this; } public boolean hasValue() { return ((this.bitField0_ & 0x2) == 2); } public int getValue() { return this.value_; } public Builder setValue(int value) { this.bitField0_ |= 0x2; this.value_ = value; onChanged(); return this; } public Builder clearValue() { this.bitField0_ &= 0xFFFFFFFD; this.value_ = 0; onChanged(); return this; } public boolean hasMaxValue() { return ((this.bitField0_ & 0x4) == 4); } public int getMaxValue() { return this.maxValue_; } public Builder setMaxValue(int value) { this.bitField0_ |= 0x4; this.maxValue_ = value; onChanged(); return this; } public Builder clearMaxValue() { this.bitField0_ &= 0xFFFFFFFB; this.maxValue_ = 0; onChanged(); return this; } public boolean hasName() { return ((this.bitField0_ & 0x8) == 8); } public String getName() { Object ref = this.name_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; }  return (String)ref; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public Builder setName(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x8; this.name_ = value; onChanged(); return this; } public Builder clearName() { this.bitField0_ &= 0xFFFFFFF7; this.name_ = CardHandler.CardPropertyStruct.getDefaultInstance().getName(); onChanged(); return this; } public Builder setNameBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x8; this.name_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class Card
/*       */     extends GeneratedMessage
/*       */     implements CardOrBuilder
/*       */   {
/*  7035 */     private static final Card defaultInstance = new Card(true); private final UnknownFieldSet unknownFields; private Card(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private Card(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static Card getDefaultInstance() { return defaultInstance; } public Card getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private Card(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString byteString1; CardHandler.CardPropertyStruct.Builder builder; CardHandler.cardRelationAttStruct.Builder subBuilder; ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 18: byteString1 = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = byteString1; break;case 24: this.bitField0_ |= 0x4; this.isActive_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.inUsePos_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.pic_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.level_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.maxLevel_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.quality_ = input.readInt32(); break;case 74: byteString1 = input.readBytes(); this.bitField0_ |= 0x100; this.qualityName_ = byteString1; break;case 80: this.bitField0_ |= 0x200; this.cardType_ = input.readInt32(); break;case 90: byteString1 = input.readBytes(); this.bitField0_ |= 0x400; this.typeName_ = byteString1; break;case 96: this.bitField0_ |= 0x800; this.suitType_ = input.readInt32(); break;case 106: byteString1 = input.readBytes(); this.bitField0_ |= 0x1000; this.suitDes_ = byteString1; break;case 114: builder = null; if ((this.bitField0_ & 0x2000) == 8192) builder = this.baseAtt_.toBuilder();  this.baseAtt_ = (CardHandler.CardPropertyStruct)input.readMessage(CardHandler.CardPropertyStruct.PARSER, extensionRegistry); if (builder != null) { builder.mergeFrom(this.baseAtt_); this.baseAtt_ = builder.buildPartial(); }  this.bitField0_ |= 0x2000; break;case 122: builder = null; if ((this.bitField0_ & 0x4000) == 16384) builder = this.baseAttNextLevel_.toBuilder();  this.baseAttNextLevel_ = (CardHandler.CardPropertyStruct)input.readMessage(CardHandler.CardPropertyStruct.PARSER, extensionRegistry); if (builder != null) { builder.mergeFrom(this.baseAttNextLevel_); this.baseAttNextLevel_ = builder.buildPartial(); }  this.bitField0_ |= 0x4000; break;case 130: subBuilder = null; if ((this.bitField0_ & 0x8000) == 32768) subBuilder = this.relationAtt1_.toBuilder();  this.relationAtt1_ = (CardHandler.cardRelationAttStruct)input.readMessage(CardHandler.cardRelationAttStruct.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.relationAtt1_); this.relationAtt1_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x8000; break;case 138: subBuilder = null; if ((this.bitField0_ & 0x10000) == 65536) subBuilder = this.relationAtt2_.toBuilder();  this.relationAtt2_ = (CardHandler.cardRelationAttStruct)input.readMessage(CardHandler.cardRelationAttStruct.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.relationAtt2_); this.relationAtt2_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x10000; break;case 144: this.bitField0_ |= 0x20000; this.levelUpItemId_ = input.readInt32(); break;case 154: bs = input.readBytes(); this.bitField0_ |= 0x40000; this.from_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_Card_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_Card_fieldAccessorTable.ensureFieldAccessorsInitialized(Card.class, Builder.class); } public static Parser<Card> PARSER = (Parser<Card>)new AbstractParser<Card>() { public CardHandler.Card parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.Card(input, extensionRegistry); } }
/*  7036 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; public static final int ISACTIVE_FIELD_NUMBER = 3; private int isActive_; public static final int INUSEPOS_FIELD_NUMBER = 4; private int inUsePos_; public static final int PIC_FIELD_NUMBER = 5; private int pic_; public static final int LEVEL_FIELD_NUMBER = 6; private int level_; public static final int MAXLEVEL_FIELD_NUMBER = 7; private int maxLevel_; public static final int QUALITY_FIELD_NUMBER = 8; private int quality_; public static final int QUALITYNAME_FIELD_NUMBER = 9; private Object qualityName_; public static final int CARDTYPE_FIELD_NUMBER = 10; private int cardType_; public static final int TYPENAME_FIELD_NUMBER = 11; private Object typeName_; public static final int SUITTYPE_FIELD_NUMBER = 12; private int suitType_; public static final int SUITDES_FIELD_NUMBER = 13; private Object suitDes_; public static final int BASEATT_FIELD_NUMBER = 14; private CardHandler.CardPropertyStruct baseAtt_; public static final int BASEATTNEXTLEVEL_FIELD_NUMBER = 15; private CardHandler.CardPropertyStruct baseAttNextLevel_; public static final int RELATIONATT1_FIELD_NUMBER = 16; private CardHandler.cardRelationAttStruct relationAtt1_; public static final int RELATIONATT2_FIELD_NUMBER = 17; private CardHandler.cardRelationAttStruct relationAtt2_; public static final int LEVELUPITEMID_FIELD_NUMBER = 18; private int levelUpItemId_; public static final int FROM_FIELD_NUMBER = 19; private Object from_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<Card> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public boolean hasIsActive() { return ((this.bitField0_ & 0x4) == 4); } public int getIsActive() { return this.isActive_; } static { defaultInstance.initFields(); } public boolean hasInUsePos() { return ((this.bitField0_ & 0x8) == 8); }
/*       */     public int getInUsePos() { return this.inUsePos_; }
/*       */     public boolean hasPic() { return ((this.bitField0_ & 0x10) == 16); }
/*       */     public int getPic() { return this.pic_; }
/*       */     public boolean hasLevel() { return ((this.bitField0_ & 0x20) == 32); }
/*       */     public int getLevel() { return this.level_; }
/*       */     public boolean hasMaxLevel() { return ((this.bitField0_ & 0x40) == 64); }
/*       */     public int getMaxLevel() { return this.maxLevel_; }
/*       */     public boolean hasQuality() { return ((this.bitField0_ & 0x80) == 128); }
/*       */     public int getQuality() { return this.quality_; }
/*       */     public boolean hasQualityName() { return ((this.bitField0_ & 0x100) == 256); }
/*       */     public String getQualityName() { Object ref = this.qualityName_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.qualityName_ = s;  return s; }
/*       */     public ByteString getQualityNameBytes() { Object ref = this.qualityName_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.qualityName_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     public boolean hasCardType() { return ((this.bitField0_ & 0x200) == 512); }
/*       */     public int getCardType() { return this.cardType_; }
/*       */     public boolean hasTypeName() { return ((this.bitField0_ & 0x400) == 1024); }
/*       */     public String getTypeName() { Object ref = this.typeName_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.typeName_ = s;  return s; }
/*       */     public ByteString getTypeNameBytes() { Object ref = this.typeName_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.typeName_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     public boolean hasSuitType() { return ((this.bitField0_ & 0x800) == 2048); }
/*       */     public int getSuitType() { return this.suitType_; }
/*       */     public boolean hasSuitDes() { return ((this.bitField0_ & 0x1000) == 4096); }
/*       */     public String getSuitDes() { Object ref = this.suitDes_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.suitDes_ = s;  return s; }
/*       */     public ByteString getSuitDesBytes() { Object ref = this.suitDes_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.suitDes_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     public boolean hasBaseAtt() { return ((this.bitField0_ & 0x2000) == 8192); }
/*       */     public CardHandler.CardPropertyStruct getBaseAtt() { return this.baseAtt_; }
/*       */     public CardHandler.CardPropertyStructOrBuilder getBaseAttOrBuilder() { return this.baseAtt_; }
/*       */     public boolean hasBaseAttNextLevel() { return ((this.bitField0_ & 0x4000) == 16384); }
/*       */     public CardHandler.CardPropertyStruct getBaseAttNextLevel() { return this.baseAttNextLevel_; }
/*       */     public CardHandler.CardPropertyStructOrBuilder getBaseAttNextLevelOrBuilder() { return this.baseAttNextLevel_; }
/*       */     public boolean hasRelationAtt1() { return ((this.bitField0_ & 0x8000) == 32768); }
/*       */     public CardHandler.cardRelationAttStruct getRelationAtt1() { return this.relationAtt1_; }
/*       */     public CardHandler.cardRelationAttStructOrBuilder getRelationAtt1OrBuilder() { return this.relationAtt1_; }
/*       */     public boolean hasRelationAtt2() { return ((this.bitField0_ & 0x10000) == 65536); }
/*       */     public CardHandler.cardRelationAttStruct getRelationAtt2() { return this.relationAtt2_; }
/*       */     public CardHandler.cardRelationAttStructOrBuilder getRelationAtt2OrBuilder() { return this.relationAtt2_; }
/*       */     public boolean hasLevelUpItemId() { return ((this.bitField0_ & 0x20000) == 131072); }
/*       */     public int getLevelUpItemId() { return this.levelUpItemId_; }
/*       */     public boolean hasFrom() { return ((this.bitField0_ & 0x40000) == 262144); }
/*       */     public String getFrom() { Object ref = this.from_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.from_ = s;  return s; }
/*       */     public ByteString getFromBytes() { Object ref = this.from_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.from_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     private void initFields() { this.id_ = 0; this.name_ = ""; this.isActive_ = 0; this.inUsePos_ = 0; this.pic_ = 0; this.level_ = 0; this.maxLevel_ = 0; this.quality_ = 0; this.qualityName_ = ""; this.cardType_ = 0; this.typeName_ = ""; this.suitType_ = 0; this.suitDes_ = ""; this.baseAtt_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.relationAtt1_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.relationAtt2_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.levelUpItemId_ = 0; this.from_ = ""; }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasIsActive()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasInUsePos()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPic()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasLevel()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasMaxLevel()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasQuality()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasQualityName()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasCardType()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasTypeName()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasSuitType()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasSuitDes()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasBaseAtt()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasBaseAttNextLevel()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasRelationAtt1()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasRelationAtt2()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasLevelUpItemId()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasFrom()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!getBaseAtt().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!getBaseAttNextLevel().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!getRelationAtt1().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!getRelationAtt2().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getNameBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(3, this.isActive_);  if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.inUsePos_);  if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeInt32(5, this.pic_);  if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeInt32(6, this.level_);  if ((this.bitField0_ & 0x40) == 64)
/*       */         output.writeInt32(7, this.maxLevel_);  if ((this.bitField0_ & 0x80) == 128)
/*       */         output.writeInt32(8, this.quality_);  if ((this.bitField0_ & 0x100) == 256)
/*       */         output.writeBytes(9, getQualityNameBytes());  if ((this.bitField0_ & 0x200) == 512)
/*       */         output.writeInt32(10, this.cardType_);  if ((this.bitField0_ & 0x400) == 1024)
/*       */         output.writeBytes(11, getTypeNameBytes());  if ((this.bitField0_ & 0x800) == 2048)
/*       */         output.writeInt32(12, this.suitType_);  if ((this.bitField0_ & 0x1000) == 4096)
/*       */         output.writeBytes(13, getSuitDesBytes());  if ((this.bitField0_ & 0x2000) == 8192)
/*       */         output.writeMessage(14, (MessageLite)this.baseAtt_);  if ((this.bitField0_ & 0x4000) == 16384)
/*       */         output.writeMessage(15, (MessageLite)this.baseAttNextLevel_);  if ((this.bitField0_ & 0x8000) == 32768)
/*       */         output.writeMessage(16, (MessageLite)this.relationAtt1_);  if ((this.bitField0_ & 0x10000) == 65536)
/*       */         output.writeMessage(17, (MessageLite)this.relationAtt2_);  if ((this.bitField0_ & 0x20000) == 131072)
/*       */         output.writeInt32(18, this.levelUpItemId_);  if ((this.bitField0_ & 0x40000) == 262144)
/*       */         output.writeBytes(19, getFromBytes());  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.isActive_);  if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.inUsePos_);  if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.pic_);  if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.level_);  if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeInt32Size(7, this.maxLevel_);  if ((this.bitField0_ & 0x80) == 128)
/*       */         size += CodedOutputStream.computeInt32Size(8, this.quality_);  if ((this.bitField0_ & 0x100) == 256)
/*       */         size += CodedOutputStream.computeBytesSize(9, getQualityNameBytes());  if ((this.bitField0_ & 0x200) == 512)
/*       */         size += CodedOutputStream.computeInt32Size(10, this.cardType_);  if ((this.bitField0_ & 0x400) == 1024)
/*       */         size += CodedOutputStream.computeBytesSize(11, getTypeNameBytes());  if ((this.bitField0_ & 0x800) == 2048)
/*       */         size += CodedOutputStream.computeInt32Size(12, this.suitType_);  if ((this.bitField0_ & 0x1000) == 4096)
/*       */         size += CodedOutputStream.computeBytesSize(13, getSuitDesBytes());  if ((this.bitField0_ & 0x2000) == 8192)
/*       */         size += CodedOutputStream.computeMessageSize(14, (MessageLite)this.baseAtt_);  if ((this.bitField0_ & 0x4000) == 16384)
/*       */         size += CodedOutputStream.computeMessageSize(15, (MessageLite)this.baseAttNextLevel_);  if ((this.bitField0_ & 0x8000) == 32768)
/*       */         size += CodedOutputStream.computeMessageSize(16, (MessageLite)this.relationAtt1_);  if ((this.bitField0_ & 0x10000) == 65536)
/*       */         size += CodedOutputStream.computeMessageSize(17, (MessageLite)this.relationAtt2_);  if ((this.bitField0_ & 0x20000) == 131072)
/*       */         size += CodedOutputStream.computeInt32Size(18, this.levelUpItemId_);  if ((this.bitField0_ & 0x40000) == 262144)
/*       */         size += CodedOutputStream.computeBytesSize(19, getFromBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static Card parseFrom(ByteString data) throws InvalidProtocolBufferException { return (Card)PARSER.parseFrom(data); }
/*       */     public static Card parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Card)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static Card parseFrom(byte[] data) throws InvalidProtocolBufferException { return (Card)PARSER.parseFrom(data); }
/*       */     public static Card parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (Card)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static Card parseFrom(InputStream input) throws IOException { return (Card)PARSER.parseFrom(input); }
/*       */     public static Card parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Card)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Card parseDelimitedFrom(InputStream input) throws IOException { return (Card)PARSER.parseDelimitedFrom(input); }
/*       */     public static Card parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Card)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static Card parseFrom(CodedInputStream input) throws IOException { return (Card)PARSER.parseFrom(input); }
/*       */     public static Card parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (Card)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(Card prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardOrBuilder { private int bitField0_; private int id_; private Object name_; private int isActive_; private int inUsePos_; private int pic_; private int level_; private int maxLevel_; private int quality_; private Object qualityName_; private int cardType_; private Object typeName_; private int suitType_; private Object suitDes_; private CardHandler.CardPropertyStruct baseAtt_; private SingleFieldBuilder<CardHandler.CardPropertyStruct, CardHandler.CardPropertyStruct.Builder, CardHandler.CardPropertyStructOrBuilder> baseAttBuilder_; private CardHandler.CardPropertyStruct baseAttNextLevel_; private SingleFieldBuilder<CardHandler.CardPropertyStruct, CardHandler.CardPropertyStruct.Builder, CardHandler.CardPropertyStructOrBuilder> baseAttNextLevelBuilder_; private CardHandler.cardRelationAttStruct relationAtt1_; private SingleFieldBuilder<CardHandler.cardRelationAttStruct, CardHandler.cardRelationAttStruct.Builder, CardHandler.cardRelationAttStructOrBuilder> relationAtt1Builder_; private CardHandler.cardRelationAttStruct relationAtt2_; private SingleFieldBuilder<CardHandler.cardRelationAttStruct, CardHandler.cardRelationAttStruct.Builder, CardHandler.cardRelationAttStructOrBuilder> relationAtt2Builder_; private int levelUpItemId_; private Object from_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_Card_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_Card_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.Card.class, Builder.class); }
/*       */       private Builder() { this.name_ = ""; this.qualityName_ = ""; this.typeName_ = ""; this.suitDes_ = ""; this.baseAtt_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.relationAtt1_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.relationAtt2_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.from_ = ""; maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.name_ = ""; this.qualityName_ = ""; this.typeName_ = ""; this.suitDes_ = ""; this.baseAtt_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.getDefaultInstance(); this.relationAtt1_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.relationAtt2_ = CardHandler.cardRelationAttStruct.getDefaultInstance(); this.from_ = ""; maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (CardHandler.Card.alwaysUseFieldBuilders) {
/*       */           getBaseAttFieldBuilder(); getBaseAttNextLevelFieldBuilder(); getRelationAtt1FieldBuilder(); getRelationAtt2FieldBuilder();
/*       */         }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.name_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.isActive_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.inUsePos_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.pic_ = 0; this.bitField0_ &= 0xFFFFFFEF; this.level_ = 0; this.bitField0_ &= 0xFFFFFFDF; this.maxLevel_ = 0; this.bitField0_ &= 0xFFFFFFBF; this.quality_ = 0; this.bitField0_ &= 0xFFFFFF7F; this.qualityName_ = ""; this.bitField0_ &= 0xFFFFFEFF; this.cardType_ = 0; this.bitField0_ &= 0xFFFFFDFF; this.typeName_ = ""; this.bitField0_ &= 0xFFFFFBFF; this.suitType_ = 0; this.bitField0_ &= 0xFFFFF7FF; this.suitDes_ = ""; this.bitField0_ &= 0xFFFFEFFF; if (this.baseAttBuilder_ == null) {
/*       */           this.baseAtt_ = CardHandler.CardPropertyStruct.getDefaultInstance();
/*       */         } else {
/*       */           this.baseAttBuilder_.clear();
/*       */         }  this.bitField0_ &= 0xFFFFDFFF; if (this.baseAttNextLevelBuilder_ == null) {
/*       */           this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.getDefaultInstance();
/*       */         } else {
/*       */           this.baseAttNextLevelBuilder_.clear();
/*       */         }  this.bitField0_ &= 0xFFFFBFFF; if (this.relationAtt1Builder_ == null) {
/*       */           this.relationAtt1_ = CardHandler.cardRelationAttStruct.getDefaultInstance();
/*       */         } else {
/*       */           this.relationAtt1Builder_.clear();
/*       */         }  this.bitField0_ &= 0xFFFF7FFF; if (this.relationAtt2Builder_ == null) {
/*       */           this.relationAtt2_ = CardHandler.cardRelationAttStruct.getDefaultInstance();
/*       */         } else {
/*       */           this.relationAtt2Builder_.clear();
/*       */         }  this.bitField0_ &= 0xFFFEFFFF; this.levelUpItemId_ = 0; this.bitField0_ &= 0xFFFDFFFF; this.from_ = ""; this.bitField0_ &= 0xFFFBFFFF; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_Card_descriptor; }
/*       */       public CardHandler.Card getDefaultInstanceForType() { return CardHandler.Card.getDefaultInstance(); }
/*       */       public CardHandler.Card build() { CardHandler.Card result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public CardHandler.Card buildPartial() { CardHandler.Card result = new CardHandler.Card(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.id_ = this.id_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.name_ = this.name_; if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4;  result.isActive_ = this.isActive_; if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8;  result.inUsePos_ = this.inUsePos_; if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10;  result.pic_ = this.pic_; if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20;  result.level_ = this.level_; if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40;  result.maxLevel_ = this.maxLevel_; if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x80;  result.quality_ = this.quality_; if ((from_bitField0_ & 0x100) == 256)
/*       */           to_bitField0_ |= 0x100;  result.qualityName_ = this.qualityName_; if ((from_bitField0_ & 0x200) == 512)
/*       */           to_bitField0_ |= 0x200;  result.cardType_ = this.cardType_; if ((from_bitField0_ & 0x400) == 1024)
/*       */           to_bitField0_ |= 0x400;  result.typeName_ = this.typeName_; if ((from_bitField0_ & 0x800) == 2048)
/*       */           to_bitField0_ |= 0x800;  result.suitType_ = this.suitType_; if ((from_bitField0_ & 0x1000) == 4096)
/*       */           to_bitField0_ |= 0x1000;  result.suitDes_ = this.suitDes_; if ((from_bitField0_ & 0x2000) == 8192)
/*       */           to_bitField0_ |= 0x2000;  if (this.baseAttBuilder_ == null) {
/*       */           result.baseAtt_ = this.baseAtt_;
/*       */         } else {
/*       */           result.baseAtt_ = (CardHandler.CardPropertyStruct)this.baseAttBuilder_.build();
/*       */         }  if ((from_bitField0_ & 0x4000) == 16384)
/*       */           to_bitField0_ |= 0x4000;  if (this.baseAttNextLevelBuilder_ == null) {
/*       */           result.baseAttNextLevel_ = this.baseAttNextLevel_;
/*       */         } else {
/*       */           result.baseAttNextLevel_ = (CardHandler.CardPropertyStruct)this.baseAttNextLevelBuilder_.build();
/*       */         }  if ((from_bitField0_ & 0x8000) == 32768)
/*       */           to_bitField0_ |= 0x8000;  if (this.relationAtt1Builder_ == null) {
/*       */           result.relationAtt1_ = this.relationAtt1_;
/*       */         } else {
/*       */           result.relationAtt1_ = (CardHandler.cardRelationAttStruct)this.relationAtt1Builder_.build();
/*       */         }  if ((from_bitField0_ & 0x10000) == 65536)
/*       */           to_bitField0_ |= 0x10000; 
/*       */         if (this.relationAtt2Builder_ == null) {
/*       */           result.relationAtt2_ = this.relationAtt2_;
/*       */         } else {
/*       */           result.relationAtt2_ = (CardHandler.cardRelationAttStruct)this.relationAtt2Builder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x20000) == 131072)
/*       */           to_bitField0_ |= 0x20000; 
/*       */         result.levelUpItemId_ = this.levelUpItemId_;
/*       */         if ((from_bitField0_ & 0x40000) == 262144)
/*       */           to_bitField0_ |= 0x40000; 
/*       */         result.from_ = this.from_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof CardHandler.Card)
/*       */           return mergeFrom((CardHandler.Card)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(CardHandler.Card other) { if (other == CardHandler.Card.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasId())
/*       */           setId(other.getId()); 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasIsActive())
/*       */           setIsActive(other.getIsActive()); 
/*       */         if (other.hasInUsePos())
/*       */           setInUsePos(other.getInUsePos()); 
/*       */         if (other.hasPic())
/*       */           setPic(other.getPic()); 
/*       */         if (other.hasLevel())
/*       */           setLevel(other.getLevel()); 
/*       */         if (other.hasMaxLevel())
/*       */           setMaxLevel(other.getMaxLevel()); 
/*       */         if (other.hasQuality())
/*       */           setQuality(other.getQuality()); 
/*       */         if (other.hasQualityName()) {
/*       */           this.bitField0_ |= 0x100;
/*       */           this.qualityName_ = other.qualityName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCardType())
/*       */           setCardType(other.getCardType()); 
/*       */         if (other.hasTypeName()) {
/*       */           this.bitField0_ |= 0x400;
/*       */           this.typeName_ = other.typeName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasSuitType())
/*       */           setSuitType(other.getSuitType()); 
/*       */         if (other.hasSuitDes()) {
/*       */           this.bitField0_ |= 0x1000;
/*       */           this.suitDes_ = other.suitDes_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasBaseAtt())
/*       */           mergeBaseAtt(other.getBaseAtt()); 
/*       */         if (other.hasBaseAttNextLevel())
/*       */           mergeBaseAttNextLevel(other.getBaseAttNextLevel()); 
/*       */         if (other.hasRelationAtt1())
/*       */           mergeRelationAtt1(other.getRelationAtt1()); 
/*       */         if (other.hasRelationAtt2())
/*       */           mergeRelationAtt2(other.getRelationAtt2()); 
/*       */         if (other.hasLevelUpItemId())
/*       */           setLevelUpItemId(other.getLevelUpItemId()); 
/*       */         if (other.hasFrom()) {
/*       */           this.bitField0_ |= 0x40000;
/*       */           this.from_ = other.from_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasId())
/*       */           return false; 
/*       */         if (!hasName())
/*       */           return false; 
/*       */         if (!hasIsActive())
/*       */           return false; 
/*       */         if (!hasInUsePos())
/*       */           return false; 
/*       */         if (!hasPic())
/*       */           return false; 
/*       */         if (!hasLevel())
/*       */           return false; 
/*       */         if (!hasMaxLevel())
/*       */           return false; 
/*       */         if (!hasQuality())
/*       */           return false; 
/*       */         if (!hasQualityName())
/*       */           return false; 
/*       */         if (!hasCardType())
/*       */           return false; 
/*       */         if (!hasTypeName())
/*       */           return false; 
/*       */         if (!hasSuitType())
/*       */           return false; 
/*       */         if (!hasSuitDes())
/*       */           return false; 
/*       */         if (!hasBaseAtt())
/*       */           return false; 
/*       */         if (!hasBaseAttNextLevel())
/*       */           return false; 
/*       */         if (!hasRelationAtt1())
/*       */           return false; 
/*       */         if (!hasRelationAtt2())
/*       */           return false; 
/*       */         if (!hasLevelUpItemId())
/*       */           return false; 
/*       */         if (!hasFrom())
/*       */           return false; 
/*       */         if (!getBaseAtt().isInitialized())
/*       */           return false; 
/*       */         if (!getBaseAttNextLevel().isInitialized())
/*       */           return false; 
/*       */         if (!getRelationAtt1().isInitialized())
/*       */           return false; 
/*       */         if (!getRelationAtt2().isInitialized())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.Card parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (CardHandler.Card)CardHandler.Card.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (CardHandler.Card)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; }
/*       */       public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getId() { return this.id_; }
/*       */       public Builder setId(int value) { this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); }
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
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearName() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = CardHandler.Card.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasIsActive() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public int getIsActive() { return this.isActive_; }
/*       */       public Builder setIsActive(int value) { this.bitField0_ |= 0x4;
/*       */         this.isActive_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearIsActive() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.isActive_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasInUsePos() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public int getInUsePos() { return this.inUsePos_; }
/*       */       public Builder setInUsePos(int value) { this.bitField0_ |= 0x8;
/*       */         this.inUsePos_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearInUsePos() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.inUsePos_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPic() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public int getPic() { return this.pic_; }
/*       */       public Builder setPic(int value) { this.bitField0_ |= 0x10;
/*       */         this.pic_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPic() { this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.pic_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasLevel() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public int getLevel() { return this.level_; }
/*       */       public Builder setLevel(int value) { this.bitField0_ |= 0x20;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearLevel() { this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasMaxLevel() { return ((this.bitField0_ & 0x40) == 64); }
/*       */       public int getMaxLevel() { return this.maxLevel_; }
/*       */       public Builder setMaxLevel(int value) { this.bitField0_ |= 0x40;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearMaxLevel() { this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasQuality() { return ((this.bitField0_ & 0x80) == 128); }
/*       */       public int getQuality() { return this.quality_; }
/*       */       public Builder setQuality(int value) { this.bitField0_ |= 0x80;
/*       */         this.quality_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearQuality() { this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.quality_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasQualityName() { return ((this.bitField0_ & 0x100) == 256); }
/*       */       public String getQualityName() { Object ref = this.qualityName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.qualityName_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getQualityNameBytes() { Object ref = this.qualityName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.qualityName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setQualityName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x100;
/*       */         this.qualityName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearQualityName() { this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.qualityName_ = CardHandler.Card.getDefaultInstance().getQualityName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setQualityNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x100;
/*       */         this.qualityName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasCardType() { return ((this.bitField0_ & 0x200) == 512); }
/*       */       public int getCardType() { return this.cardType_; }
/*       */       public Builder setCardType(int value) { this.bitField0_ |= 0x200;
/*       */         this.cardType_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearCardType() { this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.cardType_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasTypeName() { return ((this.bitField0_ & 0x400) == 1024); }
/*       */       public String getTypeName() { Object ref = this.typeName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.typeName_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getTypeNameBytes() { Object ref = this.typeName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.typeName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setTypeName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x400;
/*       */         this.typeName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearTypeName() { this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.typeName_ = CardHandler.Card.getDefaultInstance().getTypeName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setTypeNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x400;
/*       */         this.typeName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasSuitType() { return ((this.bitField0_ & 0x800) == 2048); }
/*       */       public int getSuitType() { return this.suitType_; }
/*       */       public Builder setSuitType(int value) { this.bitField0_ |= 0x800;
/*       */         this.suitType_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearSuitType() { this.bitField0_ &= 0xFFFFF7FF;
/*       */         this.suitType_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasSuitDes() { return ((this.bitField0_ & 0x1000) == 4096); }
/*       */       public String getSuitDes() { Object ref = this.suitDes_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.suitDes_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getSuitDesBytes() { Object ref = this.suitDes_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.suitDes_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setSuitDes(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1000;
/*       */         this.suitDes_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearSuitDes() { this.bitField0_ &= 0xFFFFEFFF;
/*       */         this.suitDes_ = CardHandler.Card.getDefaultInstance().getSuitDes();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setSuitDesBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x1000;
/*       */         this.suitDes_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasBaseAtt() { return ((this.bitField0_ & 0x2000) == 8192); }
/*       */       public CardHandler.CardPropertyStruct getBaseAtt() { if (this.baseAttBuilder_ == null)
/*       */           return this.baseAtt_; 
/*       */         return (CardHandler.CardPropertyStruct)this.baseAttBuilder_.getMessage(); }
/*       */       public Builder setBaseAtt(CardHandler.CardPropertyStruct value) { if (this.baseAttBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.baseAtt_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2000;
/*       */         return this; }
/*       */       public Builder setBaseAtt(CardHandler.CardPropertyStruct.Builder builderForValue) { if (this.baseAttBuilder_ == null) {
/*       */           this.baseAtt_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x2000;
/*       */         return this; }
/*       */       public Builder mergeBaseAtt(CardHandler.CardPropertyStruct value) { if (this.baseAttBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2000) == 8192 && this.baseAtt_ != CardHandler.CardPropertyStruct.getDefaultInstance()) {
/*       */             this.baseAtt_ = CardHandler.CardPropertyStruct.newBuilder(this.baseAtt_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.baseAtt_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2000;
/*       */         return this; }
/*       */       public Builder clearBaseAtt() { if (this.baseAttBuilder_ == null) {
/*       */           this.baseAtt_ = CardHandler.CardPropertyStruct.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFDFFF;
/*       */         return this; }
/*       */       public CardHandler.CardPropertyStruct.Builder getBaseAttBuilder() { this.bitField0_ |= 0x2000;
/*       */         onChanged();
/*       */         return (CardHandler.CardPropertyStruct.Builder)getBaseAttFieldBuilder().getBuilder(); }
/*       */       public CardHandler.CardPropertyStructOrBuilder getBaseAttOrBuilder() { if (this.baseAttBuilder_ != null)
/*       */           return (CardHandler.CardPropertyStructOrBuilder)this.baseAttBuilder_.getMessageOrBuilder(); 
/*       */         return this.baseAtt_; }
/*       */       private SingleFieldBuilder<CardHandler.CardPropertyStruct, CardHandler.CardPropertyStruct.Builder, CardHandler.CardPropertyStructOrBuilder> getBaseAttFieldBuilder() { if (this.baseAttBuilder_ == null) {
/*       */           this.baseAttBuilder_ = new SingleFieldBuilder(getBaseAtt(), getParentForChildren(), isClean());
/*       */           this.baseAtt_ = null;
/*       */         } 
/*       */         return this.baseAttBuilder_; }
/*       */       public boolean hasBaseAttNextLevel() { return ((this.bitField0_ & 0x4000) == 16384); }
/*       */       public CardHandler.CardPropertyStruct getBaseAttNextLevel() { if (this.baseAttNextLevelBuilder_ == null)
/*       */           return this.baseAttNextLevel_; 
/*       */         return (CardHandler.CardPropertyStruct)this.baseAttNextLevelBuilder_.getMessage(); }
/*       */       public Builder setBaseAttNextLevel(CardHandler.CardPropertyStruct value) { if (this.baseAttNextLevelBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.baseAttNextLevel_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttNextLevelBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4000;
/*       */         return this; }
/*       */       public Builder setBaseAttNextLevel(CardHandler.CardPropertyStruct.Builder builderForValue) { if (this.baseAttNextLevelBuilder_ == null) {
/*       */           this.baseAttNextLevel_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttNextLevelBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4000;
/*       */         return this; }
/*       */       public Builder mergeBaseAttNextLevel(CardHandler.CardPropertyStruct value) { if (this.baseAttNextLevelBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4000) == 16384 && this.baseAttNextLevel_ != CardHandler.CardPropertyStruct.getDefaultInstance()) {
/*       */             this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.newBuilder(this.baseAttNextLevel_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.baseAttNextLevel_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttNextLevelBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4000;
/*       */         return this; }
/*       */       public Builder clearBaseAttNextLevel() { if (this.baseAttNextLevelBuilder_ == null) {
/*       */           this.baseAttNextLevel_ = CardHandler.CardPropertyStruct.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.baseAttNextLevelBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFBFFF;
/*       */         return this; }
/*       */       public CardHandler.CardPropertyStruct.Builder getBaseAttNextLevelBuilder() { this.bitField0_ |= 0x4000;
/*       */         onChanged();
/*       */         return (CardHandler.CardPropertyStruct.Builder)getBaseAttNextLevelFieldBuilder().getBuilder(); }
/*       */       public CardHandler.CardPropertyStructOrBuilder getBaseAttNextLevelOrBuilder() { if (this.baseAttNextLevelBuilder_ != null)
/*       */           return (CardHandler.CardPropertyStructOrBuilder)this.baseAttNextLevelBuilder_.getMessageOrBuilder(); 
/*       */         return this.baseAttNextLevel_; }
/*       */       private SingleFieldBuilder<CardHandler.CardPropertyStruct, CardHandler.CardPropertyStruct.Builder, CardHandler.CardPropertyStructOrBuilder> getBaseAttNextLevelFieldBuilder() { if (this.baseAttNextLevelBuilder_ == null) {
/*       */           this.baseAttNextLevelBuilder_ = new SingleFieldBuilder(getBaseAttNextLevel(), getParentForChildren(), isClean());
/*       */           this.baseAttNextLevel_ = null;
/*       */         } 
/*       */         return this.baseAttNextLevelBuilder_; }
/*       */       public boolean hasRelationAtt1() { return ((this.bitField0_ & 0x8000) == 32768); }
/*       */       public CardHandler.cardRelationAttStruct getRelationAtt1() { if (this.relationAtt1Builder_ == null)
/*       */           return this.relationAtt1_; 
/*       */         return (CardHandler.cardRelationAttStruct)this.relationAtt1Builder_.getMessage(); }
/*       */       public Builder setRelationAtt1(CardHandler.cardRelationAttStruct value) { if (this.relationAtt1Builder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.relationAtt1_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt1Builder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x8000;
/*       */         return this; }
/*       */       public Builder setRelationAtt1(CardHandler.cardRelationAttStruct.Builder builderForValue) { if (this.relationAtt1Builder_ == null) {
/*       */           this.relationAtt1_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt1Builder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x8000;
/*       */         return this; }
/*       */       public Builder mergeRelationAtt1(CardHandler.cardRelationAttStruct value) { if (this.relationAtt1Builder_ == null) {
/*       */           if ((this.bitField0_ & 0x8000) == 32768 && this.relationAtt1_ != CardHandler.cardRelationAttStruct.getDefaultInstance()) {
/*       */             this.relationAtt1_ = CardHandler.cardRelationAttStruct.newBuilder(this.relationAtt1_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.relationAtt1_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt1Builder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x8000;
/*       */         return this; }
/*       */       public Builder clearRelationAtt1() { if (this.relationAtt1Builder_ == null) {
/*       */           this.relationAtt1_ = CardHandler.cardRelationAttStruct.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt1Builder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFF7FFF;
/*       */         return this; }
/*       */       public CardHandler.cardRelationAttStruct.Builder getRelationAtt1Builder() { this.bitField0_ |= 0x8000;
/*       */         onChanged();
/*       */         return (CardHandler.cardRelationAttStruct.Builder)getRelationAtt1FieldBuilder().getBuilder(); }
/*       */       public CardHandler.cardRelationAttStructOrBuilder getRelationAtt1OrBuilder() { if (this.relationAtt1Builder_ != null)
/*       */           return (CardHandler.cardRelationAttStructOrBuilder)this.relationAtt1Builder_.getMessageOrBuilder(); 
/*       */         return this.relationAtt1_; }
/*       */       private SingleFieldBuilder<CardHandler.cardRelationAttStruct, CardHandler.cardRelationAttStruct.Builder, CardHandler.cardRelationAttStructOrBuilder> getRelationAtt1FieldBuilder() { if (this.relationAtt1Builder_ == null) {
/*       */           this.relationAtt1Builder_ = new SingleFieldBuilder(getRelationAtt1(), getParentForChildren(), isClean());
/*       */           this.relationAtt1_ = null;
/*       */         } 
/*       */         return this.relationAtt1Builder_; }
/*       */       public boolean hasRelationAtt2() { return ((this.bitField0_ & 0x10000) == 65536); }
/*       */       public CardHandler.cardRelationAttStruct getRelationAtt2() { if (this.relationAtt2Builder_ == null)
/*       */           return this.relationAtt2_; 
/*       */         return (CardHandler.cardRelationAttStruct)this.relationAtt2Builder_.getMessage(); }
/*       */       public Builder setRelationAtt2(CardHandler.cardRelationAttStruct value) { if (this.relationAtt2Builder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.relationAtt2_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt2Builder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x10000;
/*       */         return this; }
/*       */       public Builder setRelationAtt2(CardHandler.cardRelationAttStruct.Builder builderForValue) { if (this.relationAtt2Builder_ == null) {
/*       */           this.relationAtt2_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt2Builder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x10000;
/*       */         return this; }
/*       */       public Builder mergeRelationAtt2(CardHandler.cardRelationAttStruct value) { if (this.relationAtt2Builder_ == null) {
/*       */           if ((this.bitField0_ & 0x10000) == 65536 && this.relationAtt2_ != CardHandler.cardRelationAttStruct.getDefaultInstance()) {
/*       */             this.relationAtt2_ = CardHandler.cardRelationAttStruct.newBuilder(this.relationAtt2_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.relationAtt2_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt2Builder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x10000;
/*       */         return this; }
/*       */       public Builder clearRelationAtt2() { if (this.relationAtt2Builder_ == null) {
/*       */           this.relationAtt2_ = CardHandler.cardRelationAttStruct.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.relationAtt2Builder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFEFFFF;
/*       */         return this; }
/*       */       public CardHandler.cardRelationAttStruct.Builder getRelationAtt2Builder() { this.bitField0_ |= 0x10000;
/*       */         onChanged();
/*       */         return (CardHandler.cardRelationAttStruct.Builder)getRelationAtt2FieldBuilder().getBuilder(); }
/*       */       public CardHandler.cardRelationAttStructOrBuilder getRelationAtt2OrBuilder() { if (this.relationAtt2Builder_ != null)
/*       */           return (CardHandler.cardRelationAttStructOrBuilder)this.relationAtt2Builder_.getMessageOrBuilder(); 
/*       */         return this.relationAtt2_; }
/*       */       private SingleFieldBuilder<CardHandler.cardRelationAttStruct, CardHandler.cardRelationAttStruct.Builder, CardHandler.cardRelationAttStructOrBuilder> getRelationAtt2FieldBuilder() { if (this.relationAtt2Builder_ == null) {
/*       */           this.relationAtt2Builder_ = new SingleFieldBuilder(getRelationAtt2(), getParentForChildren(), isClean());
/*       */           this.relationAtt2_ = null;
/*       */         } 
/*       */         return this.relationAtt2Builder_; }
/*       */       public boolean hasLevelUpItemId() { return ((this.bitField0_ & 0x20000) == 131072); }
/*       */       public int getLevelUpItemId() { return this.levelUpItemId_; }
/*       */       public Builder setLevelUpItemId(int value) { this.bitField0_ |= 0x20000;
/*       */         this.levelUpItemId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearLevelUpItemId() { this.bitField0_ &= 0xFFFDFFFF;
/*       */         this.levelUpItemId_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasFrom() { return ((this.bitField0_ & 0x40000) == 262144); }
/*       */       public String getFrom() { Object ref = this.from_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.from_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getFromBytes() { Object ref = this.from_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.from_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setFrom(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40000;
/*       */         this.from_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearFrom() { this.bitField0_ &= 0xFFFBFFFF;
/*       */         this.from_ = CardHandler.Card.getDefaultInstance().getFrom();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setFromBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40000;
/*       */         this.from_ = value;
/*       */         onChanged();
/*       */         return this; } } }
/*  7870 */   public static final class CardHole extends GeneratedMessage implements CardHoleOrBuilder { private static final CardHole defaultInstance = new CardHole(true); private final UnknownFieldSet unknownFields; private CardHole(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardHole(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardHole getDefaultInstance() { return defaultInstance; } public CardHole getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardHole(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.pos_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.quality_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.cardId_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.status_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.unLockLevel_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.taskId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardHole_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardHole_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHole.class, Builder.class); } public static Parser<CardHole> PARSER = (Parser<CardHole>)new AbstractParser<CardHole>() { public CardHandler.CardHole parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardHole(input, extensionRegistry); } }; private int bitField0_; public static final int POS_FIELD_NUMBER = 1; private int pos_; public static final int QUALITY_FIELD_NUMBER = 2; private int quality_; public static final int CARDID_FIELD_NUMBER = 3; private int cardId_; public static final int STATUS_FIELD_NUMBER = 4; private int status_; public static final int UNLOCKLEVEL_FIELD_NUMBER = 5; private int unLockLevel_; public static final int TASKID_FIELD_NUMBER = 6; private int taskId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardHole> getParserForType() { return PARSER; } public boolean hasPos() { return ((this.bitField0_ & 0x1) == 1); } public int getPos() { return this.pos_; } public boolean hasQuality() { return ((this.bitField0_ & 0x2) == 2); } public int getQuality() { return this.quality_; } public boolean hasCardId() { return ((this.bitField0_ & 0x4) == 4); } public int getCardId() { return this.cardId_; } public boolean hasStatus() { return ((this.bitField0_ & 0x8) == 8); } public int getStatus() { return this.status_; } public boolean hasUnLockLevel() { return ((this.bitField0_ & 0x10) == 16); } public int getUnLockLevel() { return this.unLockLevel_; } public boolean hasTaskId() { return ((this.bitField0_ & 0x20) == 32); } public int getTaskId() { return this.taskId_; } private void initFields() { this.pos_ = 0; this.quality_ = 0; this.cardId_ = 0; this.status_ = 0; this.unLockLevel_ = 0; this.taskId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasPos()) { this.memoizedIsInitialized = 0; return false; }  if (!hasQuality()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCardId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasStatus()) { this.memoizedIsInitialized = 0; return false; }  if (!hasUnLockLevel()) { this.memoizedIsInitialized = 0; return false; }  if (!hasTaskId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.pos_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.quality_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.cardId_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.status_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.unLockLevel_);  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.taskId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.pos_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.quality_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.cardId_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.status_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.unLockLevel_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.taskId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardHole parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardHole)PARSER.parseFrom(data); } public static CardHole parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardHole)PARSER.parseFrom(data, extensionRegistry); } public static CardHole parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardHole)PARSER.parseFrom(data); } public static CardHole parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardHole)PARSER.parseFrom(data, extensionRegistry); } public static CardHole parseFrom(InputStream input) throws IOException { return (CardHole)PARSER.parseFrom(input); } public static CardHole parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardHole)PARSER.parseFrom(input, extensionRegistry); } public static CardHole parseDelimitedFrom(InputStream input) throws IOException { return (CardHole)PARSER.parseDelimitedFrom(input); } public static CardHole parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardHole)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardHole parseFrom(CodedInputStream input) throws IOException { return (CardHole)PARSER.parseFrom(input); } public static CardHole parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardHole)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardHole prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardHoleOrBuilder {
/*  7871 */       private int bitField0_; private int pos_; private int quality_; private int cardId_; private int status_; private int unLockLevel_; private int taskId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardHole_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardHole_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardHole.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardHole.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.pos_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.quality_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.cardId_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.status_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.unLockLevel_ = 0; this.bitField0_ &= 0xFFFFFFEF; this.taskId_ = 0; this.bitField0_ &= 0xFFFFFFDF; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardHole_descriptor; } public CardHandler.CardHole getDefaultInstanceForType() { return CardHandler.CardHole.getDefaultInstance(); } public CardHandler.CardHole build() { CardHandler.CardHole result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardHole buildPartial() { CardHandler.CardHole result = new CardHandler.CardHole(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.pos_ = this.pos_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.quality_ = this.quality_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.cardId_ = this.cardId_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.status_ = this.status_; if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;  result.unLockLevel_ = this.unLockLevel_; if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;  result.taskId_ = this.taskId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardHole) return mergeFrom((CardHandler.CardHole)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardHole other) { if (other == CardHandler.CardHole.getDefaultInstance()) return this;  if (other.hasPos()) setPos(other.getPos());  if (other.hasQuality()) setQuality(other.getQuality());  if (other.hasCardId()) setCardId(other.getCardId());  if (other.hasStatus()) setStatus(other.getStatus());  if (other.hasUnLockLevel()) setUnLockLevel(other.getUnLockLevel());  if (other.hasTaskId()) setTaskId(other.getTaskId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasPos()) return false;  if (!hasQuality()) return false;  if (!hasCardId()) return false;  if (!hasStatus()) return false;  if (!hasUnLockLevel()) return false;  if (!hasTaskId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardHole parsedMessage = null; try { parsedMessage = (CardHandler.CardHole)CardHandler.CardHole.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardHole)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasPos() { return ((this.bitField0_ & 0x1) == 1); } public int getPos() { return this.pos_; } public Builder setPos(int value) { this.bitField0_ |= 0x1; this.pos_ = value; onChanged(); return this; } public Builder clearPos() { this.bitField0_ &= 0xFFFFFFFE; this.pos_ = 0; onChanged(); return this; } public boolean hasQuality() { return ((this.bitField0_ & 0x2) == 2); } public int getQuality() { return this.quality_; } public Builder setQuality(int value) { this.bitField0_ |= 0x2; this.quality_ = value; onChanged(); return this; } public Builder clearQuality() { this.bitField0_ &= 0xFFFFFFFD; this.quality_ = 0; onChanged(); return this; } public boolean hasCardId() { return ((this.bitField0_ & 0x4) == 4); } public int getCardId() { return this.cardId_; } public Builder setCardId(int value) { this.bitField0_ |= 0x4; this.cardId_ = value; onChanged(); return this; } public Builder clearCardId() { this.bitField0_ &= 0xFFFFFFFB; this.cardId_ = 0; onChanged(); return this; } public boolean hasStatus() { return ((this.bitField0_ & 0x8) == 8); } public int getStatus() { return this.status_; } public Builder setStatus(int value) { this.bitField0_ |= 0x8; this.status_ = value; onChanged(); return this; } public Builder clearStatus() { this.bitField0_ &= 0xFFFFFFF7; this.status_ = 0; onChanged(); return this; } public boolean hasUnLockLevel() { return ((this.bitField0_ & 0x10) == 16); } public int getUnLockLevel() { return this.unLockLevel_; } public Builder setUnLockLevel(int value) { this.bitField0_ |= 0x10; this.unLockLevel_ = value; onChanged(); return this; } public Builder clearUnLockLevel() { this.bitField0_ &= 0xFFFFFFEF; this.unLockLevel_ = 0; onChanged(); return this; } public boolean hasTaskId() { return ((this.bitField0_ & 0x20) == 32); } public int getTaskId() { return this.taskId_; } public Builder setTaskId(int value) { this.bitField0_ |= 0x20; this.taskId_ = value; onChanged(); return this; } public Builder clearTaskId() { this.bitField0_ &= 0xFFFFFFDF; this.taskId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardAward
/*       */     extends GeneratedMessage
/*       */     implements CardAwardOrBuilder
/*       */   {
/*  8784 */     private static final CardAward defaultInstance = new CardAward(true); private final UnknownFieldSet unknownFields; private CardAward(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardAward(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardAward getDefaultInstance() { return defaultInstance; } public CardAward getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardAward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.targetId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.status_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.des_ = bs; break;case 32: this.bitField0_ |= 0x8; this.cardType_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.collectNum_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.awardId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardAward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardAward_fieldAccessorTable.ensureFieldAccessorsInitialized(CardAward.class, Builder.class); } public static Parser<CardAward> PARSER = (Parser<CardAward>)new AbstractParser<CardAward>() { public CardHandler.CardAward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardAward(input, extensionRegistry); } }; private int bitField0_; public static final int TARGETID_FIELD_NUMBER = 1; private int targetId_; public static final int STATUS_FIELD_NUMBER = 2; private int status_; public static final int DES_FIELD_NUMBER = 3; private Object des_; public static final int CARDTYPE_FIELD_NUMBER = 4; private int cardType_; public static final int COLLECTNUM_FIELD_NUMBER = 5; private int collectNum_; public static final int AWARDID_FIELD_NUMBER = 6; private int awardId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardAward> getParserForType() { return PARSER; } public boolean hasTargetId() { return ((this.bitField0_ & 0x1) == 1); } public int getTargetId() { return this.targetId_; } public boolean hasStatus() { return ((this.bitField0_ & 0x2) == 2); } public int getStatus() { return this.status_; } public boolean hasDes() { return ((this.bitField0_ & 0x4) == 4); } public String getDes() { Object ref = this.des_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.des_ = s;  return s; } public ByteString getDesBytes() { Object ref = this.des_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.des_ = b; return b; }  return (ByteString)ref; } public boolean hasCardType() { return ((this.bitField0_ & 0x8) == 8); } public int getCardType() { return this.cardType_; } public boolean hasCollectNum() { return ((this.bitField0_ & 0x10) == 16); } public int getCollectNum() { return this.collectNum_; } public boolean hasAwardId() { return ((this.bitField0_ & 0x20) == 32); } public int getAwardId() { return this.awardId_; } private void initFields() { this.targetId_ = 0; this.status_ = 0; this.des_ = ""; this.cardType_ = 0; this.collectNum_ = 0; this.awardId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasTargetId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasStatus()) { this.memoizedIsInitialized = 0; return false; }  if (!hasDes()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCardType()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCollectNum()) { this.memoizedIsInitialized = 0; return false; }  if (!hasAwardId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.targetId_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.status_);  if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getDesBytes());  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.cardType_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.collectNum_);  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.awardId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.targetId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.status_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getDesBytes());  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.cardType_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.collectNum_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.awardId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardAward parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardAward)PARSER.parseFrom(data); } public static CardAward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardAward)PARSER.parseFrom(data, extensionRegistry); } public static CardAward parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardAward)PARSER.parseFrom(data); } public static CardAward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardAward)PARSER.parseFrom(data, extensionRegistry); } public static CardAward parseFrom(InputStream input) throws IOException { return (CardAward)PARSER.parseFrom(input); } public static CardAward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardAward)PARSER.parseFrom(input, extensionRegistry); } public static CardAward parseDelimitedFrom(InputStream input) throws IOException { return (CardAward)PARSER.parseDelimitedFrom(input); } public static CardAward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardAward)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardAward parseFrom(CodedInputStream input) throws IOException { return (CardAward)PARSER.parseFrom(input); } public static CardAward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardAward)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardAward prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardAwardOrBuilder {
/*  8785 */       private int bitField0_; private int targetId_; private int status_; private Object des_; private int cardType_; private int collectNum_; private int awardId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardAward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardAward_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardAward.class, Builder.class); } private Builder() { this.des_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.des_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardAward.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.targetId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.status_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.des_ = ""; this.bitField0_ &= 0xFFFFFFFB; this.cardType_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.collectNum_ = 0; this.bitField0_ &= 0xFFFFFFEF; this.awardId_ = 0; this.bitField0_ &= 0xFFFFFFDF; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardAward_descriptor; } public CardHandler.CardAward getDefaultInstanceForType() { return CardHandler.CardAward.getDefaultInstance(); } public CardHandler.CardAward build() { CardHandler.CardAward result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardAward buildPartial() { CardHandler.CardAward result = new CardHandler.CardAward(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.targetId_ = this.targetId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.status_ = this.status_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.des_ = this.des_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.cardType_ = this.cardType_; if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;  result.collectNum_ = this.collectNum_; if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;  result.awardId_ = this.awardId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardAward) return mergeFrom((CardHandler.CardAward)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardAward other) { if (other == CardHandler.CardAward.getDefaultInstance()) return this;  if (other.hasTargetId()) setTargetId(other.getTargetId());  if (other.hasStatus()) setStatus(other.getStatus());  if (other.hasDes()) { this.bitField0_ |= 0x4; this.des_ = other.des_; onChanged(); }  if (other.hasCardType()) setCardType(other.getCardType());  if (other.hasCollectNum()) setCollectNum(other.getCollectNum());  if (other.hasAwardId()) setAwardId(other.getAwardId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasTargetId()) return false;  if (!hasStatus()) return false;  if (!hasDes()) return false;  if (!hasCardType()) return false;  if (!hasCollectNum()) return false;  if (!hasAwardId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardAward parsedMessage = null; try { parsedMessage = (CardHandler.CardAward)CardHandler.CardAward.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardAward)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasTargetId() { return ((this.bitField0_ & 0x1) == 1); } public int getTargetId() { return this.targetId_; } public Builder setTargetId(int value) { this.bitField0_ |= 0x1; this.targetId_ = value; onChanged(); return this; } public Builder clearTargetId() { this.bitField0_ &= 0xFFFFFFFE; this.targetId_ = 0; onChanged(); return this; } public boolean hasStatus() { return ((this.bitField0_ & 0x2) == 2); } public int getStatus() { return this.status_; } public Builder setStatus(int value) { this.bitField0_ |= 0x2; this.status_ = value; onChanged(); return this; } public Builder clearStatus() { this.bitField0_ &= 0xFFFFFFFD; this.status_ = 0; onChanged(); return this; } public boolean hasDes() { return ((this.bitField0_ & 0x4) == 4); } public String getDes() { Object ref = this.des_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.des_ = s;  return s; }  return (String)ref; } public ByteString getDesBytes() { Object ref = this.des_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.des_ = b; return b; }  return (ByteString)ref; } public Builder setDes(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.des_ = value; onChanged(); return this; } public Builder clearDes() { this.bitField0_ &= 0xFFFFFFFB; this.des_ = CardHandler.CardAward.getDefaultInstance().getDes(); onChanged(); return this; } public Builder setDesBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.des_ = value; onChanged(); return this; } public boolean hasCardType() { return ((this.bitField0_ & 0x8) == 8); } public int getCardType() { return this.cardType_; } public Builder setCardType(int value) { this.bitField0_ |= 0x8; this.cardType_ = value; onChanged(); return this; } public Builder clearCardType() { this.bitField0_ &= 0xFFFFFFF7; this.cardType_ = 0; onChanged(); return this; } public boolean hasCollectNum() { return ((this.bitField0_ & 0x10) == 16); } public int getCollectNum() { return this.collectNum_; } public Builder setCollectNum(int value) { this.bitField0_ |= 0x10; this.collectNum_ = value; onChanged(); return this; } public Builder clearCollectNum() { this.bitField0_ &= 0xFFFFFFEF; this.collectNum_ = 0; onChanged(); return this; } public boolean hasAwardId() { return ((this.bitField0_ & 0x20) == 32); } public int getAwardId() { return this.awardId_; } public Builder setAwardId(int value) { this.bitField0_ |= 0x20; this.awardId_ = value; onChanged(); return this; } public Builder clearAwardId() { this.bitField0_ &= 0xFFFFFFDF; this.awardId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardSuit
/*       */     extends GeneratedMessage
/*       */     implements CardSuitOrBuilder
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
/*       */     private CardSuit(GeneratedMessage.Builder<?> builder) {
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
/*       */     private CardSuit(boolean noInit) {
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
/*       */     public static CardSuit getDefaultInstance() {
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
/*       */     public CardSuit getDefaultInstanceForType() {
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
/*       */     private CardSuit(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */               this.suitId_ = input.readInt32();
/*       */               break;
/*       */             case 18:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x2;
/*       */               this.name_ = bs;
/*       */               break;
/*       */             case 24:
/*       */               this.bitField0_ |= 0x4;
/*       */               this.num_ = input.readInt32();
/*       */               break;
/*       */             case 32:
/*       */               this.bitField0_ |= 0x8;
/*       */               this.itemid1_ = input.readInt32();
/*       */               break;
/*       */             case 40:
/*       */               this.bitField0_ |= 0x10;
/*       */               this.itemid2_ = input.readInt32();
/*       */               break;
/*       */             case 48:
/*       */               this.bitField0_ |= 0x20;
/*       */               this.itemid3_ = input.readInt32();
/*       */               break;
/*       */             case 56:
/*       */               this.bitField0_ |= 0x40;
/*       */               this.itemid4_ = input.readInt32();
/*       */               break;
/*       */             case 64:
/*       */               this.bitField0_ |= 0x80;
/*       */               this.itemid5_ = input.readInt32();
/*       */               break;
/*       */             case 72:
/*       */               this.bitField0_ |= 0x100;
/*       */               this.itemid6_ = input.readInt32();
/*       */               break;
/*       */             case 82:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x200;
/*       */               this.story_ = bs;
/*       */               break;
/*       */             case 90:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x400;
/*       */               this.suitSkillName_ = bs;
/*       */               break;
/*       */             case 98:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x800;
/*       */               this.suitskillDes_ = bs;
/*       */               break;
/*       */             case 104:
/*       */               this.bitField0_ |= 0x1000;
/*       */               this.buffId_ = input.readInt32();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       return CardHandler.internal_static_pomelo_area_CardSuit_descriptor;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       return CardHandler.internal_static_pomelo_area_CardSuit_fieldAccessorTable.ensureFieldAccessorsInitialized(CardSuit.class, Builder.class);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<CardSuit> PARSER = (Parser<CardSuit>)new AbstractParser<CardSuit>()
/*       */       {
/*       */         public CardHandler.CardSuit parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new CardHandler.CardSuit(input, extensionRegistry);
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
/*       */     public static final int SUITID_FIELD_NUMBER = 1;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int suitId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int NAME_FIELD_NUMBER = 2;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object name_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int NUM_FIELD_NUMBER = 3;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int num_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID1_FIELD_NUMBER = 4;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid1_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID2_FIELD_NUMBER = 5;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid2_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID3_FIELD_NUMBER = 6;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid3_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID4_FIELD_NUMBER = 7;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid4_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID5_FIELD_NUMBER = 8;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid5_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int ITEMID6_FIELD_NUMBER = 9;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int itemid6_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int STORY_FIELD_NUMBER = 10;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object story_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int SUITSKILLNAME_FIELD_NUMBER = 11;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object suitSkillName_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int SUITSKILLDES_FIELD_NUMBER = 12;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private Object suitskillDes_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final int BUFFID_FIELD_NUMBER = 13;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private int buffId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */     public Parser<CardSuit> getParserForType() {
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
/*       */     public boolean hasSuitId() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSuitId() {
/*       */       return this.suitId_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10537 */     private static final CardSuit defaultInstance = new CardSuit(true); public boolean hasNum() { return ((this.bitField0_ & 0x4) == 4); } public int getNum() { return this.num_; } public boolean hasItemid1() { return ((this.bitField0_ & 0x8) == 8); } public int getItemid1() { return this.itemid1_; } public boolean hasItemid2() { return ((this.bitField0_ & 0x10) == 16); } public int getItemid2() { return this.itemid2_; } public boolean hasItemid3() { return ((this.bitField0_ & 0x20) == 32); } public int getItemid3() { return this.itemid3_; } public boolean hasItemid4() { return ((this.bitField0_ & 0x40) == 64); } public int getItemid4() { return this.itemid4_; } public boolean hasItemid5() { return ((this.bitField0_ & 0x80) == 128); } public int getItemid5() { return this.itemid5_; } public boolean hasItemid6() { return ((this.bitField0_ & 0x100) == 256); } public int getItemid6() { return this.itemid6_; } public boolean hasStory() { return ((this.bitField0_ & 0x200) == 512); } public String getStory() { Object ref = this.story_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.story_ = s;  return s; } public ByteString getStoryBytes() { Object ref = this.story_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.story_ = b; return b; }  return (ByteString)ref; } public boolean hasSuitSkillName() { return ((this.bitField0_ & 0x400) == 1024); } public String getSuitSkillName() { Object ref = this.suitSkillName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.suitSkillName_ = s;  return s; } public ByteString getSuitSkillNameBytes() { Object ref = this.suitSkillName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.suitSkillName_ = b; return b; }  return (ByteString)ref; } public boolean hasSuitskillDes() { return ((this.bitField0_ & 0x800) == 2048); } public String getSuitskillDes() { Object ref = this.suitskillDes_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.suitskillDes_ = s;  return s; } public ByteString getSuitskillDesBytes() { Object ref = this.suitskillDes_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.suitskillDes_ = b; return b; }  return (ByteString)ref; } public boolean hasBuffId() { return ((this.bitField0_ & 0x1000) == 4096); } public int getBuffId() { return this.buffId_; } private void initFields() { this.suitId_ = 0; this.name_ = ""; this.num_ = 0; this.itemid1_ = 0; this.itemid2_ = 0; this.itemid3_ = 0; this.itemid4_ = 0; this.itemid5_ = 0; this.itemid6_ = 0; this.story_ = ""; this.suitSkillName_ = ""; this.suitskillDes_ = ""; this.buffId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasSuitId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasNum()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid1()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid2()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid3()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid4()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid5()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemid6()) { this.memoizedIsInitialized = 0; return false; }  if (!hasStory()) { this.memoizedIsInitialized = 0; return false; }  if (!hasSuitSkillName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasSuitskillDes()) { this.memoizedIsInitialized = 0; return false; }  if (!hasBuffId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.suitId_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getNameBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.num_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.itemid1_);  if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.itemid2_);  if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.itemid3_);  if ((this.bitField0_ & 0x40) == 64) output.writeInt32(7, this.itemid4_);  if ((this.bitField0_ & 0x80) == 128) output.writeInt32(8, this.itemid5_);  if ((this.bitField0_ & 0x100) == 256) output.writeInt32(9, this.itemid6_);  if ((this.bitField0_ & 0x200) == 512) output.writeBytes(10, getStoryBytes());  if ((this.bitField0_ & 0x400) == 1024) output.writeBytes(11, getSuitSkillNameBytes());  if ((this.bitField0_ & 0x800) == 2048) output.writeBytes(12, getSuitskillDesBytes());  if ((this.bitField0_ & 0x1000) == 4096) output.writeInt32(13, this.buffId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.suitId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getNameBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.num_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.itemid1_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.itemid2_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.itemid3_);  if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(7, this.itemid4_);  if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeInt32Size(8, this.itemid5_);  if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeInt32Size(9, this.itemid6_);  if ((this.bitField0_ & 0x200) == 512) size += CodedOutputStream.computeBytesSize(10, getStoryBytes());  if ((this.bitField0_ & 0x400) == 1024) size += CodedOutputStream.computeBytesSize(11, getSuitSkillNameBytes());  if ((this.bitField0_ & 0x800) == 2048) size += CodedOutputStream.computeBytesSize(12, getSuitskillDesBytes());  if ((this.bitField0_ & 0x1000) == 4096) size += CodedOutputStream.computeInt32Size(13, this.buffId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardSuit parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardSuit)PARSER.parseFrom(data); } public static CardSuit parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardSuit)PARSER.parseFrom(data, extensionRegistry); } public static CardSuit parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardSuit)PARSER.parseFrom(data); } public static CardSuit parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardSuit)PARSER.parseFrom(data, extensionRegistry); } public static CardSuit parseFrom(InputStream input) throws IOException { return (CardSuit)PARSER.parseFrom(input); } public static CardSuit parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardSuit)PARSER.parseFrom(input, extensionRegistry); } public static CardSuit parseDelimitedFrom(InputStream input) throws IOException { return (CardSuit)PARSER.parseDelimitedFrom(input); } public static CardSuit parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardSuit)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardSuit parseFrom(CodedInputStream input) throws IOException { return (CardSuit)PARSER.parseFrom(input); } public static CardSuit parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardSuit)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardSuit prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardSuitOrBuilder {
/* 10538 */       private int bitField0_; private int suitId_; private Object name_; private int num_; private int itemid1_; private int itemid2_; private int itemid3_; private int itemid4_; private int itemid5_; private int itemid6_; private Object story_; private Object suitSkillName_; private Object suitskillDes_; private int buffId_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardSuit_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardSuit_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardSuit.class, Builder.class); } private Builder() { this.name_ = ""; this.story_ = ""; this.suitSkillName_ = ""; this.suitskillDes_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.name_ = ""; this.story_ = ""; this.suitSkillName_ = ""; this.suitskillDes_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardSuit.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.suitId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.name_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.num_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.itemid1_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.itemid2_ = 0; this.bitField0_ &= 0xFFFFFFEF; this.itemid3_ = 0; this.bitField0_ &= 0xFFFFFFDF; this.itemid4_ = 0; this.bitField0_ &= 0xFFFFFFBF; this.itemid5_ = 0; this.bitField0_ &= 0xFFFFFF7F; this.itemid6_ = 0; this.bitField0_ &= 0xFFFFFEFF; this.story_ = ""; this.bitField0_ &= 0xFFFFFDFF; this.suitSkillName_ = ""; this.bitField0_ &= 0xFFFFFBFF; this.suitskillDes_ = ""; this.bitField0_ &= 0xFFFFF7FF; this.buffId_ = 0; this.bitField0_ &= 0xFFFFEFFF; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardSuit_descriptor; } public CardHandler.CardSuit getDefaultInstanceForType() { return CardHandler.CardSuit.getDefaultInstance(); } public CardHandler.CardSuit build() { CardHandler.CardSuit result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardSuit buildPartial() { CardHandler.CardSuit result = new CardHandler.CardSuit(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.suitId_ = this.suitId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.name_ = this.name_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.num_ = this.num_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.itemid1_ = this.itemid1_; if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;  result.itemid2_ = this.itemid2_; if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;  result.itemid3_ = this.itemid3_; if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x40;  result.itemid4_ = this.itemid4_; if ((from_bitField0_ & 0x80) == 128) to_bitField0_ |= 0x80;  result.itemid5_ = this.itemid5_; if ((from_bitField0_ & 0x100) == 256) to_bitField0_ |= 0x100;  result.itemid6_ = this.itemid6_; if ((from_bitField0_ & 0x200) == 512) to_bitField0_ |= 0x200;  result.story_ = this.story_; if ((from_bitField0_ & 0x400) == 1024) to_bitField0_ |= 0x400;  result.suitSkillName_ = this.suitSkillName_; if ((from_bitField0_ & 0x800) == 2048) to_bitField0_ |= 0x800;  result.suitskillDes_ = this.suitskillDes_; if ((from_bitField0_ & 0x1000) == 4096) to_bitField0_ |= 0x1000;  result.buffId_ = this.buffId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardSuit) return mergeFrom((CardHandler.CardSuit)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardSuit other) { if (other == CardHandler.CardSuit.getDefaultInstance()) return this;  if (other.hasSuitId()) setSuitId(other.getSuitId());  if (other.hasName()) { this.bitField0_ |= 0x2; this.name_ = other.name_; onChanged(); }  if (other.hasNum()) setNum(other.getNum());  if (other.hasItemid1()) setItemid1(other.getItemid1());  if (other.hasItemid2()) setItemid2(other.getItemid2());  if (other.hasItemid3()) setItemid3(other.getItemid3());  if (other.hasItemid4()) setItemid4(other.getItemid4());  if (other.hasItemid5()) setItemid5(other.getItemid5());  if (other.hasItemid6()) setItemid6(other.getItemid6());  if (other.hasStory()) { this.bitField0_ |= 0x200; this.story_ = other.story_; onChanged(); }  if (other.hasSuitSkillName()) { this.bitField0_ |= 0x400; this.suitSkillName_ = other.suitSkillName_; onChanged(); }  if (other.hasSuitskillDes()) { this.bitField0_ |= 0x800; this.suitskillDes_ = other.suitskillDes_; onChanged(); }  if (other.hasBuffId()) setBuffId(other.getBuffId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasSuitId()) return false;  if (!hasName()) return false;  if (!hasNum()) return false;  if (!hasItemid1()) return false;  if (!hasItemid2()) return false;  if (!hasItemid3()) return false;  if (!hasItemid4()) return false;  if (!hasItemid5()) return false;  if (!hasItemid6()) return false;  if (!hasStory()) return false;  if (!hasSuitSkillName()) return false;  if (!hasSuitskillDes()) return false;  if (!hasBuffId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardSuit parsedMessage = null; try { parsedMessage = (CardHandler.CardSuit)CardHandler.CardSuit.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardSuit)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasSuitId() { return ((this.bitField0_ & 0x1) == 1); } public int getSuitId() { return this.suitId_; } public Builder setSuitId(int value) { this.bitField0_ |= 0x1; this.suitId_ = value; onChanged(); return this; } public Builder clearSuitId() { this.bitField0_ &= 0xFFFFFFFE; this.suitId_ = 0; onChanged(); return this; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } public String getName() { Object ref = this.name_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; }  return (String)ref; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public Builder setName(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.name_ = value; onChanged(); return this; } public Builder clearName() { this.bitField0_ &= 0xFFFFFFFD; this.name_ = CardHandler.CardSuit.getDefaultInstance().getName(); onChanged(); return this; } public Builder setNameBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.name_ = value; onChanged(); return this; } public boolean hasNum() { return ((this.bitField0_ & 0x4) == 4); } public int getNum() { return this.num_; } public Builder setNum(int value) { this.bitField0_ |= 0x4; this.num_ = value; onChanged(); return this; } public Builder clearNum() { this.bitField0_ &= 0xFFFFFFFB; this.num_ = 0; onChanged(); return this; } public boolean hasItemid1() { return ((this.bitField0_ & 0x8) == 8); } public int getItemid1() { return this.itemid1_; } public Builder setItemid1(int value) { this.bitField0_ |= 0x8; this.itemid1_ = value; onChanged(); return this; } public Builder clearItemid1() { this.bitField0_ &= 0xFFFFFFF7; this.itemid1_ = 0; onChanged(); return this; } public boolean hasItemid2() { return ((this.bitField0_ & 0x10) == 16); } public int getItemid2() { return this.itemid2_; } public Builder setItemid2(int value) { this.bitField0_ |= 0x10; this.itemid2_ = value; onChanged(); return this; } public Builder clearItemid2() { this.bitField0_ &= 0xFFFFFFEF; this.itemid2_ = 0; onChanged(); return this; } public boolean hasItemid3() { return ((this.bitField0_ & 0x20) == 32); } public int getItemid3() { return this.itemid3_; } public Builder setItemid3(int value) { this.bitField0_ |= 0x20; this.itemid3_ = value; onChanged(); return this; } public Builder clearItemid3() { this.bitField0_ &= 0xFFFFFFDF; this.itemid3_ = 0; onChanged(); return this; } public boolean hasItemid4() { return ((this.bitField0_ & 0x40) == 64); } public int getItemid4() { return this.itemid4_; } public Builder setItemid4(int value) { this.bitField0_ |= 0x40; this.itemid4_ = value; onChanged(); return this; } public Builder clearItemid4() { this.bitField0_ &= 0xFFFFFFBF; this.itemid4_ = 0; onChanged(); return this; } public boolean hasItemid5() { return ((this.bitField0_ & 0x80) == 128); } public int getItemid5() { return this.itemid5_; } public Builder setItemid5(int value) { this.bitField0_ |= 0x80; this.itemid5_ = value; onChanged(); return this; } public Builder clearItemid5() { this.bitField0_ &= 0xFFFFFF7F; this.itemid5_ = 0; onChanged(); return this; } public boolean hasItemid6() { return ((this.bitField0_ & 0x100) == 256); } public int getItemid6() { return this.itemid6_; } public Builder setItemid6(int value) { this.bitField0_ |= 0x100; this.itemid6_ = value; onChanged(); return this; } public Builder clearItemid6() { this.bitField0_ &= 0xFFFFFEFF; this.itemid6_ = 0; onChanged(); return this; } public boolean hasStory() { return ((this.bitField0_ & 0x200) == 512); } public String getStory() { Object ref = this.story_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.story_ = s;  return s; }  return (String)ref; } public ByteString getStoryBytes() { Object ref = this.story_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.story_ = b; return b; }  return (ByteString)ref; } public Builder setStory(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x200; this.story_ = value; onChanged(); return this; } public Builder clearStory() { this.bitField0_ &= 0xFFFFFDFF; this.story_ = CardHandler.CardSuit.getDefaultInstance().getStory(); onChanged(); return this; } public Builder setStoryBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x200; this.story_ = value; onChanged(); return this; } public boolean hasSuitSkillName() { return ((this.bitField0_ & 0x400) == 1024); } public String getSuitSkillName() { Object ref = this.suitSkillName_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.suitSkillName_ = s;  return s; }  return (String)ref; } public ByteString getSuitSkillNameBytes() { Object ref = this.suitSkillName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.suitSkillName_ = b; return b; }  return (ByteString)ref; } public Builder setSuitSkillName(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x400; this.suitSkillName_ = value; onChanged(); return this; } public Builder clearSuitSkillName() { this.bitField0_ &= 0xFFFFFBFF; this.suitSkillName_ = CardHandler.CardSuit.getDefaultInstance().getSuitSkillName(); onChanged(); return this; } public Builder setSuitSkillNameBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x400; this.suitSkillName_ = value; onChanged(); return this; } public boolean hasSuitskillDes() { return ((this.bitField0_ & 0x800) == 2048); } public String getSuitskillDes() { Object ref = this.suitskillDes_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.suitskillDes_ = s;  return s; }  return (String)ref; } public ByteString getSuitskillDesBytes() { Object ref = this.suitskillDes_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.suitskillDes_ = b; return b; }  return (ByteString)ref; } public Builder setSuitskillDes(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x800; this.suitskillDes_ = value; onChanged(); return this; } public Builder clearSuitskillDes() { this.bitField0_ &= 0xFFFFF7FF; this.suitskillDes_ = CardHandler.CardSuit.getDefaultInstance().getSuitskillDes(); onChanged(); return this; } public Builder setSuitskillDesBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x800; this.suitskillDes_ = value; onChanged(); return this; } public boolean hasBuffId() { return ((this.bitField0_ & 0x1000) == 4096); } public int getBuffId() { return this.buffId_; } public Builder setBuffId(int value) { this.bitField0_ |= 0x1000; this.buffId_ = value; onChanged(); return this; } public Builder clearBuffId() { this.bitField0_ &= 0xFFFFEFFF; this.buffId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class CardRegisterResponse
/*       */     extends GeneratedMessage
/*       */     implements CardRegisterResponseOrBuilder
/*       */   {
/* 12587 */     private static final CardRegisterResponse defaultInstance = new CardRegisterResponse(true); private final UnknownFieldSet unknownFields; private CardRegisterResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardRegisterResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardRegisterResponse getDefaultInstance() { return defaultInstance; } public CardRegisterResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardRegisterResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CCard_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CCard_.add(input.readMessage(CardHandler.Card.PARSER, extensionRegistry)); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CCardHole_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CCardHole_.add(input.readMessage(CardHandler.CardHole.PARSER, extensionRegistry)); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CCardAward_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CCardAward_.add(input.readMessage(CardHandler.CardAward.PARSER, extensionRegistry)); break;case 50: if ((mutable_bitField0_ & 0x20) != 32) { this.s2CCardSuit_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.s2CCardSuit_.add(input.readMessage(CardHandler.CardSuit.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_);  if ((mutable_bitField0_ & 0x8) == 8) this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_);  if ((mutable_bitField0_ & 0x10) == 16) this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_);  if ((mutable_bitField0_ & 0x20) == 32) this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardRegisterResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardRegisterResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardRegisterResponse.class, Builder.class); } public static Parser<CardRegisterResponse> PARSER = (Parser<CardRegisterResponse>)new AbstractParser<CardRegisterResponse>() { public CardHandler.CardRegisterResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardRegisterResponse(input, extensionRegistry); } }
/* 12588 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CARD_FIELD_NUMBER = 3; private List<CardHandler.Card> s2CCard_; public static final int S2C_CARDHOLE_FIELD_NUMBER = 4; private List<CardHandler.CardHole> s2CCardHole_; public static final int S2C_CARDAWARD_FIELD_NUMBER = 5; private List<CardHandler.CardAward> s2CCardAward_; public static final int S2C_CARDSUIT_FIELD_NUMBER = 6; private List<CardHandler.CardSuit> s2CCardSuit_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardRegisterResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<CardHandler.Card> getS2CCardList() { return this.s2CCard_; } public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() { return (List)this.s2CCard_; } public int getS2CCardCount() { return this.s2CCard_.size(); } public CardHandler.Card getS2CCard(int index) { return this.s2CCard_.get(index); } static { defaultInstance.initFields(); } public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) { return this.s2CCard_.get(index); }
/*       */     public List<CardHandler.CardHole> getS2CCardHoleList() { return this.s2CCardHole_; }
/*       */     public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() { return (List)this.s2CCardHole_; }
/*       */     public int getS2CCardHoleCount() { return this.s2CCardHole_.size(); }
/*       */     public CardHandler.CardHole getS2CCardHole(int index) { return this.s2CCardHole_.get(index); }
/*       */     public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) { return this.s2CCardHole_.get(index); }
/*       */     public List<CardHandler.CardAward> getS2CCardAwardList() { return this.s2CCardAward_; }
/*       */     public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() { return (List)this.s2CCardAward_; }
/*       */     public int getS2CCardAwardCount() { return this.s2CCardAward_.size(); }
/*       */     public CardHandler.CardAward getS2CCardAward(int index) { return this.s2CCardAward_.get(index); }
/*       */     public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) { return this.s2CCardAward_.get(index); }
/*       */     public List<CardHandler.CardSuit> getS2CCardSuitList() { return this.s2CCardSuit_; }
/*       */     public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() { return (List)this.s2CCardSuit_; }
/*       */     public int getS2CCardSuitCount() { return this.s2CCardSuit_.size(); }
/*       */     public CardHandler.CardSuit getS2CCardSuit(int index) { return this.s2CCardSuit_.get(index); }
/*       */     public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) { return this.s2CCardSuit_.get(index); }
/*       */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  int i; for (i = 0; i < getS2CCardCount(); i++) {
/*       */         if (!getS2CCard(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0; return false;
/*       */         } 
/*       */       }  for (i = 0; i < getS2CCardHoleCount(); i++) {
/*       */         if (!getS2CCardHole(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0; return false;
/*       */         } 
/*       */       }  for (i = 0; i < getS2CCardAwardCount(); i++) {
/*       */         if (!getS2CCardAward(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0; return false;
/*       */         } 
/*       */       }  for (i = 0; i < getS2CCardSuitCount(); i++) {
/*       */         if (!getS2CCardSuit(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0; return false;
/*       */         } 
/*       */       }  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CCard_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.s2CCard_.get(i));  for (i = 0; i < this.s2CCardHole_.size(); i++)
/*       */         output.writeMessage(4, (MessageLite)this.s2CCardHole_.get(i));  for (i = 0; i < this.s2CCardAward_.size(); i++)
/*       */         output.writeMessage(5, (MessageLite)this.s2CCardAward_.get(i));  for (i = 0; i < this.s2CCardSuit_.size(); i++)
/*       */         output.writeMessage(6, (MessageLite)this.s2CCardSuit_.get(i));  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CCard_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCard_.get(i));  for (i = 0; i < this.s2CCardHole_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CCardHole_.get(i));  for (i = 0; i < this.s2CCardAward_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CCardAward_.get(i));  for (i = 0; i < this.s2CCardSuit_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(6, (MessageLite)this.s2CCardSuit_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static CardRegisterResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardRegisterResponse)PARSER.parseFrom(data); }
/*       */     public static CardRegisterResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardRegisterResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static CardRegisterResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardRegisterResponse)PARSER.parseFrom(data); }
/*       */     public static CardRegisterResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardRegisterResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static CardRegisterResponse parseFrom(InputStream input) throws IOException { return (CardRegisterResponse)PARSER.parseFrom(input); }
/*       */     public static CardRegisterResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static CardRegisterResponse parseDelimitedFrom(InputStream input) throws IOException { return (CardRegisterResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static CardRegisterResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static CardRegisterResponse parseFrom(CodedInputStream input) throws IOException { return (CardRegisterResponse)PARSER.parseFrom(input); }
/*       */     public static CardRegisterResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardRegisterResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(CardRegisterResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardRegisterResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<CardHandler.Card> s2CCard_; private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> s2CCardBuilder_; private List<CardHandler.CardHole> s2CCardHole_; private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> s2CCardHoleBuilder_; private List<CardHandler.CardAward> s2CCardAward_; private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> s2CCardAwardBuilder_; private List<CardHandler.CardSuit> s2CCardSuit_; private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> s2CCardSuitBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardRegisterResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardRegisterResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardRegisterResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (CardHandler.CardRegisterResponse.alwaysUseFieldBuilders) {
/*       */           getS2CCardFieldBuilder(); getS2CCardHoleFieldBuilder();
/*       */           getS2CCardAwardFieldBuilder();
/*       */           getS2CCardSuitFieldBuilder();
/*       */         }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCard_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CCardBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHole_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAward_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuit_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardRegisterResponse_descriptor; }
/*       */       public CardHandler.CardRegisterResponse getDefaultInstanceForType() { return CardHandler.CardRegisterResponse.getDefaultInstance(); }
/*       */       public CardHandler.CardRegisterResponse build() { CardHandler.CardRegisterResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public CardHandler.CardRegisterResponse buildPartial() { CardHandler.CardRegisterResponse result = new CardHandler.CardRegisterResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CCard_ = this.s2CCard_;
/*       */         } else {
/*       */           result.s2CCard_ = this.s2CCardBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.s2CCardHole_ = this.s2CCardHole_;
/*       */         } else {
/*       */           result.s2CCardHole_ = this.s2CCardHoleBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x10) == 16) {
/*       */             this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_);
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */           } 
/*       */           result.s2CCardAward_ = this.s2CCardAward_;
/*       */         } else {
/*       */           result.s2CCardAward_ = this.s2CCardAwardBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x20) == 32) {
/*       */             this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_);
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */           } 
/*       */           result.s2CCardSuit_ = this.s2CCardSuit_;
/*       */         } else {
/*       */           result.s2CCardSuit_ = this.s2CCardSuitBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardRegisterResponse)
/*       */           return mergeFrom((CardHandler.CardRegisterResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(CardHandler.CardRegisterResponse other) { if (other == CardHandler.CardRegisterResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if (!other.s2CCard_.isEmpty()) {
/*       */             if (this.s2CCard_.isEmpty()) {
/*       */               this.s2CCard_ = other.s2CCard_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CCardIsMutable();
/*       */               this.s2CCard_.addAll(other.s2CCard_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCard_.isEmpty()) {
/*       */           if (this.s2CCardBuilder_.isEmpty()) {
/*       */             this.s2CCardBuilder_.dispose();
/*       */             this.s2CCardBuilder_ = null;
/*       */             this.s2CCard_ = other.s2CCard_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CCardBuilder_ = CardHandler.CardRegisterResponse.alwaysUseFieldBuilders ? getS2CCardFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardBuilder_.addAllMessages(other.s2CCard_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (!other.s2CCardHole_.isEmpty()) {
/*       */             if (this.s2CCardHole_.isEmpty()) {
/*       */               this.s2CCardHole_ = other.s2CCardHole_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureS2CCardHoleIsMutable();
/*       */               this.s2CCardHole_.addAll(other.s2CCardHole_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardHole_.isEmpty()) {
/*       */           if (this.s2CCardHoleBuilder_.isEmpty()) {
/*       */             this.s2CCardHoleBuilder_.dispose();
/*       */             this.s2CCardHoleBuilder_ = null;
/*       */             this.s2CCardHole_ = other.s2CCardHole_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.s2CCardHoleBuilder_ = CardHandler.CardRegisterResponse.alwaysUseFieldBuilders ? getS2CCardHoleFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardHoleBuilder_.addAllMessages(other.s2CCardHole_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (!other.s2CCardAward_.isEmpty()) {
/*       */             if (this.s2CCardAward_.isEmpty()) {
/*       */               this.s2CCardAward_ = other.s2CCardAward_;
/*       */               this.bitField0_ &= 0xFFFFFFEF;
/*       */             } else {
/*       */               ensureS2CCardAwardIsMutable();
/*       */               this.s2CCardAward_.addAll(other.s2CCardAward_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardAward_.isEmpty()) {
/*       */           if (this.s2CCardAwardBuilder_.isEmpty()) {
/*       */             this.s2CCardAwardBuilder_.dispose();
/*       */             this.s2CCardAwardBuilder_ = null;
/*       */             this.s2CCardAward_ = other.s2CCardAward_;
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */             this.s2CCardAwardBuilder_ = CardHandler.CardRegisterResponse.alwaysUseFieldBuilders ? getS2CCardAwardFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardAwardBuilder_.addAllMessages(other.s2CCardAward_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (!other.s2CCardSuit_.isEmpty()) {
/*       */             if (this.s2CCardSuit_.isEmpty()) {
/*       */               this.s2CCardSuit_ = other.s2CCardSuit_;
/*       */               this.bitField0_ &= 0xFFFFFFDF;
/*       */             } else {
/*       */               ensureS2CCardSuitIsMutable();
/*       */               this.s2CCardSuit_.addAll(other.s2CCardSuit_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardSuit_.isEmpty()) {
/*       */           if (this.s2CCardSuitBuilder_.isEmpty()) {
/*       */             this.s2CCardSuitBuilder_.dispose();
/*       */             this.s2CCardSuitBuilder_ = null;
/*       */             this.s2CCardSuit_ = other.s2CCardSuit_;
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */             this.s2CCardSuitBuilder_ = CardHandler.CardRegisterResponse.alwaysUseFieldBuilders ? getS2CCardSuitFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardSuitBuilder_.addAllMessages(other.s2CCardSuit_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         int i;
/*       */         for (i = 0; i < getS2CCardCount(); i++) {
/*       */           if (!getS2CCard(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         for (i = 0; i < getS2CCardHoleCount(); i++) {
/*       */           if (!getS2CCardHole(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         for (i = 0; i < getS2CCardAwardCount(); i++) {
/*       */           if (!getS2CCardAward(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         for (i = 0; i < getS2CCardSuitCount(); i++) {
/*       */           if (!getS2CCardSuit(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardRegisterResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (CardHandler.CardRegisterResponse)CardHandler.CardRegisterResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (CardHandler.CardRegisterResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = CardHandler.CardRegisterResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureS2CCardIsMutable() { if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CCard_ = new ArrayList<>(this.s2CCard_);
/*       */           this.bitField0_ |= 0x4;
/*       */         }  }
/*       */       public List<CardHandler.Card> getS2CCardList() { if (this.s2CCardBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CCard_); 
/*       */         return this.s2CCardBuilder_.getMessageList(); }
/*       */       public int getS2CCardCount() { if (this.s2CCardBuilder_ == null)
/*       */           return this.s2CCard_.size(); 
/*       */         return this.s2CCardBuilder_.getCount(); }
/*       */       public CardHandler.Card getS2CCard(int index) { if (this.s2CCardBuilder_ == null)
/*       */           return this.s2CCard_.get(index); 
/*       */         return (CardHandler.Card)this.s2CCardBuilder_.getMessage(index); }
/*       */       public Builder setS2CCard(int index, CardHandler.Card value) { if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setS2CCard(int index, CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCard(int index, CardHandler.Card value) { if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCard(CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCard(int index, CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllS2CCard(Iterable<? extends CardHandler.Card> values) { if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCard_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearS2CCard() { if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCard_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeS2CCard(int index) { if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public CardHandler.Card.Builder getS2CCardBuilder(int index) { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) { if (this.s2CCardBuilder_ == null)
/*       */           return this.s2CCard_.get(index); 
/*       */         return (CardHandler.CardOrBuilder)this.s2CCardBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() { if (this.s2CCardBuilder_ != null)
/*       */           return this.s2CCardBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CCard_); }
/*       */       public CardHandler.Card.Builder addS2CCardBuilder() { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(CardHandler.Card.getDefaultInstance()); }
/*       */       public CardHandler.Card.Builder addS2CCardBuilder(int index) { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(index, CardHandler.Card.getDefaultInstance()); }
/*       */       public List<CardHandler.Card.Builder> getS2CCardBuilderList() { return getS2CCardFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> getS2CCardFieldBuilder() { if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCardBuilder_ = new RepeatedFieldBuilder(this.s2CCard_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CCard_ = null;
/*       */         } 
/*       */         return this.s2CCardBuilder_; }
/*       */       private void ensureS2CCardHoleIsMutable() { if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.s2CCardHole_ = new ArrayList<>(this.s2CCardHole_);
/*       */           this.bitField0_ |= 0x8;
/*       */         }  }
/*       */       public List<CardHandler.CardHole> getS2CCardHoleList() { if (this.s2CCardHoleBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CCardHole_); 
/*       */         return this.s2CCardHoleBuilder_.getMessageList(); }
/*       */       public int getS2CCardHoleCount() { if (this.s2CCardHoleBuilder_ == null)
/*       */           return this.s2CCardHole_.size(); 
/*       */         return this.s2CCardHoleBuilder_.getCount(); }
/*       */       public CardHandler.CardHole getS2CCardHole(int index) { if (this.s2CCardHoleBuilder_ == null)
/*       */           return this.s2CCardHole_.get(index); 
/*       */         return (CardHandler.CardHole)this.s2CCardHoleBuilder_.getMessage(index); }
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardHole(CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardHole(CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllS2CCardHole(Iterable<? extends CardHandler.CardHole> values) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardHole_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearS2CCardHole() { if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHole_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeS2CCardHole(int index) { if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public CardHandler.CardHole.Builder getS2CCardHoleBuilder(int index) { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) { if (this.s2CCardHoleBuilder_ == null)
/*       */           return this.s2CCardHole_.get(index); 
/*       */         return (CardHandler.CardHoleOrBuilder)this.s2CCardHoleBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() { if (this.s2CCardHoleBuilder_ != null)
/*       */           return this.s2CCardHoleBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CCardHole_); }
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder() { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(CardHandler.CardHole.getDefaultInstance()); }
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder(int index) { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(index, CardHandler.CardHole.getDefaultInstance()); }
/*       */       public List<CardHandler.CardHole.Builder> getS2CCardHoleBuilderList() { return getS2CCardHoleFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> getS2CCardHoleFieldBuilder() { if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHoleBuilder_ = new RepeatedFieldBuilder(this.s2CCardHole_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.s2CCardHole_ = null;
/*       */         } 
/*       */         return this.s2CCardHoleBuilder_; }
/*       */       private void ensureS2CCardAwardIsMutable() { if ((this.bitField0_ & 0x10) != 16) {
/*       */           this.s2CCardAward_ = new ArrayList<>(this.s2CCardAward_);
/*       */           this.bitField0_ |= 0x10;
/*       */         }  }
/*       */       public List<CardHandler.CardAward> getS2CCardAwardList() { if (this.s2CCardAwardBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CCardAward_); 
/*       */         return this.s2CCardAwardBuilder_.getMessageList(); }
/*       */       public int getS2CCardAwardCount() { if (this.s2CCardAwardBuilder_ == null)
/*       */           return this.s2CCardAward_.size(); 
/*       */         return this.s2CCardAwardBuilder_.getCount(); }
/*       */       public CardHandler.CardAward getS2CCardAward(int index) { if (this.s2CCardAwardBuilder_ == null)
/*       */           return this.s2CCardAward_.get(index); 
/*       */         return (CardHandler.CardAward)this.s2CCardAwardBuilder_.getMessage(index); }
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardAward(CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardAward(CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllS2CCardAward(Iterable<? extends CardHandler.CardAward> values) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardAward_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearS2CCardAward() { if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAward_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeS2CCardAward(int index) { if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public CardHandler.CardAward.Builder getS2CCardAwardBuilder(int index) { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) { if (this.s2CCardAwardBuilder_ == null)
/*       */           return this.s2CCardAward_.get(index); 
/*       */         return (CardHandler.CardAwardOrBuilder)this.s2CCardAwardBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() { if (this.s2CCardAwardBuilder_ != null)
/*       */           return this.s2CCardAwardBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CCardAward_); }
/*       */       public CardHandler.CardAward.Builder addS2CCardAwardBuilder() { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(CardHandler.CardAward.getDefaultInstance()); }
/*       */       public CardHandler.CardAward.Builder addS2CCardAwardBuilder(int index) { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(index, CardHandler.CardAward.getDefaultInstance()); }
/*       */       public List<CardHandler.CardAward.Builder> getS2CCardAwardBuilderList() { return getS2CCardAwardFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> getS2CCardAwardFieldBuilder() { if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAwardBuilder_ = new RepeatedFieldBuilder(this.s2CCardAward_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*       */           this.s2CCardAward_ = null;
/*       */         } 
/*       */         return this.s2CCardAwardBuilder_; }
/*       */       private void ensureS2CCardSuitIsMutable() { if ((this.bitField0_ & 0x20) != 32) {
/*       */           this.s2CCardSuit_ = new ArrayList<>(this.s2CCardSuit_);
/*       */           this.bitField0_ |= 0x20;
/*       */         }  }
/*       */       public List<CardHandler.CardSuit> getS2CCardSuitList() { if (this.s2CCardSuitBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CCardSuit_); 
/*       */         return this.s2CCardSuitBuilder_.getMessageList(); }
/*       */       public int getS2CCardSuitCount() { if (this.s2CCardSuitBuilder_ == null)
/*       */           return this.s2CCardSuit_.size(); 
/*       */         return this.s2CCardSuitBuilder_.getCount(); }
/*       */       public CardHandler.CardSuit getS2CCardSuit(int index) { if (this.s2CCardSuitBuilder_ == null)
/*       */           return this.s2CCardSuit_.get(index); 
/*       */         return (CardHandler.CardSuit)this.s2CCardSuitBuilder_.getMessage(index); }
/*       */       public Builder setS2CCardSuit(int index, CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardSuit(CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardSuit(int index, CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardSuit(CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllS2CCardSuit(Iterable<? extends CardHandler.CardSuit> values) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardSuit_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearS2CCardSuit() { if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuit_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeS2CCardSuit(int index) { if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public CardHandler.CardSuit.Builder getS2CCardSuitBuilder(int index) { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) { if (this.s2CCardSuitBuilder_ == null)
/*       */           return this.s2CCardSuit_.get(index); 
/*       */         return (CardHandler.CardSuitOrBuilder)this.s2CCardSuitBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() { if (this.s2CCardSuitBuilder_ != null)
/*       */           return this.s2CCardSuitBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CCardSuit_); }
/*       */       public CardHandler.CardSuit.Builder addS2CCardSuitBuilder() { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(CardHandler.CardSuit.getDefaultInstance()); }
/*       */       public CardHandler.CardSuit.Builder addS2CCardSuitBuilder(int index) { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(index, CardHandler.CardSuit.getDefaultInstance()); }
/*       */       public List<CardHandler.CardSuit.Builder> getS2CCardSuitBuilderList() { return getS2CCardSuitFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> getS2CCardSuitFieldBuilder() { if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuitBuilder_ = new RepeatedFieldBuilder(this.s2CCardSuit_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
/*       */           this.s2CCardSuit_ = null;
/*       */         } 
/*       */         return this.s2CCardSuitBuilder_; } } }
/* 13354 */   public static final class CardLevelUpResponse extends GeneratedMessage implements CardLevelUpResponseOrBuilder { private static final CardLevelUpResponse defaultInstance = new CardLevelUpResponse(true); private final UnknownFieldSet unknownFields; private CardLevelUpResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardLevelUpResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardLevelUpResponse getDefaultInstance() { return defaultInstance; } public CardLevelUpResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardLevelUpResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; CardHandler.Card.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CCard_.toBuilder();  this.s2CCard_ = (CardHandler.Card)input.readMessage(CardHandler.Card.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CCard_); this.s2CCard_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardLevelUpResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardLevelUpResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardLevelUpResponse.class, Builder.class); } public static Parser<CardLevelUpResponse> PARSER = (Parser<CardLevelUpResponse>)new AbstractParser<CardLevelUpResponse>() { public CardHandler.CardLevelUpResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardLevelUpResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CARD_FIELD_NUMBER = 3; private CardHandler.Card s2CCard_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardLevelUpResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CCard() { return ((this.bitField0_ & 0x4) == 4); } public CardHandler.Card getS2CCard() { return this.s2CCard_; } public CardHandler.CardOrBuilder getS2CCardOrBuilder() { return this.s2CCard_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CCard()) { this.memoizedIsInitialized = 0; return false; }  if (!getS2CCard().isInitialized()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite)this.s2CCard_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCard_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardLevelUpResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardLevelUpResponse)PARSER.parseFrom(data); } public static CardLevelUpResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardLevelUpResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardLevelUpResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardLevelUpResponse)PARSER.parseFrom(data); } public static CardLevelUpResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardLevelUpResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardLevelUpResponse parseFrom(InputStream input) throws IOException { return (CardLevelUpResponse)PARSER.parseFrom(input); } public static CardLevelUpResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpResponse)PARSER.parseFrom(input, extensionRegistry); } public static CardLevelUpResponse parseDelimitedFrom(InputStream input) throws IOException { return (CardLevelUpResponse)PARSER.parseDelimitedFrom(input); } public static CardLevelUpResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardLevelUpResponse parseFrom(CodedInputStream input) throws IOException { return (CardLevelUpResponse)PARSER.parseFrom(input); } public static CardLevelUpResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardLevelUpResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardLevelUpResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardLevelUpResponseOrBuilder {
/* 13355 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private CardHandler.Card s2CCard_; private SingleFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> s2CCardBuilder_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardLevelUpResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardLevelUpResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardLevelUpResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardLevelUpResponse.alwaysUseFieldBuilders) getS2CCardFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CCardBuilder_ == null) { this.s2CCard_ = CardHandler.Card.getDefaultInstance(); } else { this.s2CCardBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardLevelUpResponse_descriptor; } public CardHandler.CardLevelUpResponse getDefaultInstanceForType() { return CardHandler.CardLevelUpResponse.getDefaultInstance(); } public CardHandler.CardLevelUpResponse build() { CardHandler.CardLevelUpResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardLevelUpResponse buildPartial() { CardHandler.CardLevelUpResponse result = new CardHandler.CardLevelUpResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  if (this.s2CCardBuilder_ == null) { result.s2CCard_ = this.s2CCard_; } else { result.s2CCard_ = (CardHandler.Card)this.s2CCardBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardLevelUpResponse) return mergeFrom((CardHandler.CardLevelUpResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardLevelUpResponse other) { if (other == CardHandler.CardLevelUpResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CCard()) mergeS2CCard(other.getS2CCard());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasS2CCard()) return false;  if (!getS2CCard().isInitialized()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardLevelUpResponse parsedMessage = null; try { parsedMessage = (CardHandler.CardLevelUpResponse)CardHandler.CardLevelUpResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardLevelUpResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = CardHandler.CardLevelUpResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CCard() { return ((this.bitField0_ & 0x4) == 4); } public CardHandler.Card getS2CCard() { if (this.s2CCardBuilder_ == null) return this.s2CCard_;  return (CardHandler.Card)this.s2CCardBuilder_.getMessage(); } public Builder setS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if (value == null) throw new NullPointerException();  this.s2CCard_ = value; onChanged(); } else { this.s2CCardBuilder_.setMessage(value); }  this.bitField0_ |= 0x4; return this; } public Builder setS2CCard(CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) { this.s2CCard_ = builderForValue.build(); onChanged(); } else { this.s2CCardBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x4; return this; } public Builder mergeS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4 && this.s2CCard_ != CardHandler.Card.getDefaultInstance()) { this.s2CCard_ = CardHandler.Card.newBuilder(this.s2CCard_).mergeFrom(value).buildPartial(); } else { this.s2CCard_ = value; }  onChanged(); } else { this.s2CCardBuilder_.mergeFrom(value); }  this.bitField0_ |= 0x4; return this; } public Builder clearS2CCard() { if (this.s2CCardBuilder_ == null) { this.s2CCard_ = CardHandler.Card.getDefaultInstance(); onChanged(); } else { this.s2CCardBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; } public CardHandler.Card.Builder getS2CCardBuilder() { this.bitField0_ |= 0x4; onChanged(); return (CardHandler.Card.Builder)getS2CCardFieldBuilder().getBuilder(); } public CardHandler.CardOrBuilder getS2CCardOrBuilder() { if (this.s2CCardBuilder_ != null) return (CardHandler.CardOrBuilder)this.s2CCardBuilder_.getMessageOrBuilder();  return this.s2CCard_; } private SingleFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> getS2CCardFieldBuilder() { if (this.s2CCardBuilder_ == null) { this.s2CCardBuilder_ = new SingleFieldBuilder(getS2CCard(), getParentForChildren(), isClean()); this.s2CCard_ = null; }  return this.s2CCardBuilder_; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardPreLevelUpResponse
/*       */     extends GeneratedMessage
/*       */     implements CardPreLevelUpResponseOrBuilder
/*       */   {
/* 14121 */     private static final CardPreLevelUpResponse defaultInstance = new CardPreLevelUpResponse(true); private final UnknownFieldSet unknownFields; private CardPreLevelUpResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardPreLevelUpResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardPreLevelUpResponse getDefaultInstance() { return defaultInstance; } public CardPreLevelUpResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardPreLevelUpResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; CardHandler.Card.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CCard_.toBuilder();  this.s2CCard_ = (CardHandler.Card)input.readMessage(CardHandler.Card.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CCard_); this.s2CCard_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardPreLevelUpResponse.class, Builder.class); } public static Parser<CardPreLevelUpResponse> PARSER = (Parser<CardPreLevelUpResponse>)new AbstractParser<CardPreLevelUpResponse>() { public CardHandler.CardPreLevelUpResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardPreLevelUpResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CARD_FIELD_NUMBER = 3; private CardHandler.Card s2CCard_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardPreLevelUpResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CCard() { return ((this.bitField0_ & 0x4) == 4); } public CardHandler.Card getS2CCard() { return this.s2CCard_; } public CardHandler.CardOrBuilder getS2CCardOrBuilder() { return this.s2CCard_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CCard()) { this.memoizedIsInitialized = 0; return false; }  if (!getS2CCard().isInitialized()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite)this.s2CCard_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCard_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardPreLevelUpResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardPreLevelUpResponse)PARSER.parseFrom(data); } public static CardPreLevelUpResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPreLevelUpResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardPreLevelUpResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardPreLevelUpResponse)PARSER.parseFrom(data); } public static CardPreLevelUpResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardPreLevelUpResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardPreLevelUpResponse parseFrom(InputStream input) throws IOException { return (CardPreLevelUpResponse)PARSER.parseFrom(input); } public static CardPreLevelUpResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpResponse)PARSER.parseFrom(input, extensionRegistry); } public static CardPreLevelUpResponse parseDelimitedFrom(InputStream input) throws IOException { return (CardPreLevelUpResponse)PARSER.parseDelimitedFrom(input); } public static CardPreLevelUpResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardPreLevelUpResponse parseFrom(CodedInputStream input) throws IOException { return (CardPreLevelUpResponse)PARSER.parseFrom(input); } public static CardPreLevelUpResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardPreLevelUpResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardPreLevelUpResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardPreLevelUpResponseOrBuilder {
/* 14122 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private CardHandler.Card s2CCard_; private SingleFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> s2CCardBuilder_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardPreLevelUpResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CCard_ = CardHandler.Card.getDefaultInstance(); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardPreLevelUpResponse.alwaysUseFieldBuilders) getS2CCardFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CCardBuilder_ == null) { this.s2CCard_ = CardHandler.Card.getDefaultInstance(); } else { this.s2CCardBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardPreLevelUpResponse_descriptor; } public CardHandler.CardPreLevelUpResponse getDefaultInstanceForType() { return CardHandler.CardPreLevelUpResponse.getDefaultInstance(); } public CardHandler.CardPreLevelUpResponse build() { CardHandler.CardPreLevelUpResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardPreLevelUpResponse buildPartial() { CardHandler.CardPreLevelUpResponse result = new CardHandler.CardPreLevelUpResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  if (this.s2CCardBuilder_ == null) { result.s2CCard_ = this.s2CCard_; } else { result.s2CCard_ = (CardHandler.Card)this.s2CCardBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardPreLevelUpResponse) return mergeFrom((CardHandler.CardPreLevelUpResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardPreLevelUpResponse other) { if (other == CardHandler.CardPreLevelUpResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CCard()) mergeS2CCard(other.getS2CCard());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasS2CCard()) return false;  if (!getS2CCard().isInitialized()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardPreLevelUpResponse parsedMessage = null; try { parsedMessage = (CardHandler.CardPreLevelUpResponse)CardHandler.CardPreLevelUpResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardPreLevelUpResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = CardHandler.CardPreLevelUpResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CCard() { return ((this.bitField0_ & 0x4) == 4); } public CardHandler.Card getS2CCard() { if (this.s2CCardBuilder_ == null) return this.s2CCard_;  return (CardHandler.Card)this.s2CCardBuilder_.getMessage(); } public Builder setS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if (value == null) throw new NullPointerException();  this.s2CCard_ = value; onChanged(); } else { this.s2CCardBuilder_.setMessage(value); }  this.bitField0_ |= 0x4; return this; } public Builder setS2CCard(CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) { this.s2CCard_ = builderForValue.build(); onChanged(); } else { this.s2CCardBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x4; return this; } public Builder mergeS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4 && this.s2CCard_ != CardHandler.Card.getDefaultInstance()) { this.s2CCard_ = CardHandler.Card.newBuilder(this.s2CCard_).mergeFrom(value).buildPartial(); } else { this.s2CCard_ = value; }  onChanged(); } else { this.s2CCardBuilder_.mergeFrom(value); }  this.bitField0_ |= 0x4; return this; } public Builder clearS2CCard() { if (this.s2CCardBuilder_ == null) { this.s2CCard_ = CardHandler.Card.getDefaultInstance(); onChanged(); } else { this.s2CCardBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; } public CardHandler.Card.Builder getS2CCardBuilder() { this.bitField0_ |= 0x4; onChanged(); return (CardHandler.Card.Builder)getS2CCardFieldBuilder().getBuilder(); } public CardHandler.CardOrBuilder getS2CCardOrBuilder() { if (this.s2CCardBuilder_ != null) return (CardHandler.CardOrBuilder)this.s2CCardBuilder_.getMessageOrBuilder();  return this.s2CCard_; } private SingleFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> getS2CCardFieldBuilder() { if (this.s2CCardBuilder_ == null) { this.s2CCardBuilder_ = new SingleFieldBuilder(getS2CCard(), getParentForChildren(), isClean()); this.s2CCard_ = null; }  return this.s2CCardBuilder_; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class CardGetAwardResponse
/*       */     extends GeneratedMessage
/*       */     implements CardGetAwardResponseOrBuilder
/*       */   {
/* 14683 */     private static final CardGetAwardResponse defaultInstance = new CardGetAwardResponse(true); private final UnknownFieldSet unknownFields; private CardGetAwardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardGetAwardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardGetAwardResponse getDefaultInstance() { return defaultInstance; } public CardGetAwardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardGetAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardGetAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardGetAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardGetAwardResponse.class, Builder.class); } public static Parser<CardGetAwardResponse> PARSER = (Parser<CardGetAwardResponse>)new AbstractParser<CardGetAwardResponse>() { public CardHandler.CardGetAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardGetAwardResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardGetAwardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardGetAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardGetAwardResponse)PARSER.parseFrom(data); } public static CardGetAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardGetAwardResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardGetAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardGetAwardResponse)PARSER.parseFrom(data); } public static CardGetAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardGetAwardResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardGetAwardResponse parseFrom(InputStream input) throws IOException { return (CardGetAwardResponse)PARSER.parseFrom(input); } public static CardGetAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardResponse)PARSER.parseFrom(input, extensionRegistry); } public static CardGetAwardResponse parseDelimitedFrom(InputStream input) throws IOException { return (CardGetAwardResponse)PARSER.parseDelimitedFrom(input); } public static CardGetAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static CardGetAwardResponse parseFrom(CodedInputStream input) throws IOException { return (CardGetAwardResponse)PARSER.parseFrom(input); } public static CardGetAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardGetAwardResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(CardGetAwardResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardGetAwardResponseOrBuilder {
/* 14684 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardGetAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardGetAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardGetAwardResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (CardHandler.CardGetAwardResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardGetAwardResponse_descriptor; } public CardHandler.CardGetAwardResponse getDefaultInstanceForType() { return CardHandler.CardGetAwardResponse.getDefaultInstance(); } public CardHandler.CardGetAwardResponse build() { CardHandler.CardGetAwardResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public CardHandler.CardGetAwardResponse buildPartial() { CardHandler.CardGetAwardResponse result = new CardHandler.CardGetAwardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardGetAwardResponse) return mergeFrom((CardHandler.CardGetAwardResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(CardHandler.CardGetAwardResponse other) { if (other == CardHandler.CardGetAwardResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardGetAwardResponse parsedMessage = null; try { parsedMessage = (CardHandler.CardGetAwardResponse)CardHandler.CardGetAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardGetAwardResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = CardHandler.CardGetAwardResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class CardEquipResponse
/*       */     extends GeneratedMessage
/*       */     implements CardEquipResponseOrBuilder
/*       */   {
/* 16733 */     private static final CardEquipResponse defaultInstance = new CardEquipResponse(true); private final UnknownFieldSet unknownFields; private CardEquipResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardEquipResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardEquipResponse getDefaultInstance() { return defaultInstance; } public CardEquipResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardEquipResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CCard_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CCard_.add(input.readMessage(CardHandler.Card.PARSER, extensionRegistry)); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CCardHole_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CCardHole_.add(input.readMessage(CardHandler.CardHole.PARSER, extensionRegistry)); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CCardAward_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CCardAward_.add(input.readMessage(CardHandler.CardAward.PARSER, extensionRegistry)); break;case 50: if ((mutable_bitField0_ & 0x20) != 32) { this.s2CCardSuit_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.s2CCardSuit_.add(input.readMessage(CardHandler.CardSuit.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_);  if ((mutable_bitField0_ & 0x8) == 8) this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_);  if ((mutable_bitField0_ & 0x10) == 16) this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_);  if ((mutable_bitField0_ & 0x20) == 32) this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardEquipResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardEquipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardEquipResponse.class, Builder.class); } public static Parser<CardEquipResponse> PARSER = (Parser<CardEquipResponse>)new AbstractParser<CardEquipResponse>() { public CardHandler.CardEquipResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardEquipResponse(input, extensionRegistry); } }
/* 16734 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CARD_FIELD_NUMBER = 3; private List<CardHandler.Card> s2CCard_; public static final int S2C_CARDHOLE_FIELD_NUMBER = 4; private List<CardHandler.CardHole> s2CCardHole_; public static final int S2C_CARDAWARD_FIELD_NUMBER = 5; private List<CardHandler.CardAward> s2CCardAward_; public static final int S2C_CARDSUIT_FIELD_NUMBER = 6; private List<CardHandler.CardSuit> s2CCardSuit_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardEquipResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<CardHandler.Card> getS2CCardList() { return this.s2CCard_; } public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() { return (List)this.s2CCard_; } public int getS2CCardCount() { return this.s2CCard_.size(); } public CardHandler.Card getS2CCard(int index) { return this.s2CCard_.get(index); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) {
/*       */       return this.s2CCard_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<CardHandler.CardHole> getS2CCardHoleList() {
/*       */       return this.s2CCardHole_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() {
/*       */       return (List)this.s2CCardHole_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getS2CCardHoleCount() {
/*       */       return this.s2CCardHole_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardHole getS2CCardHole(int index) {
/*       */       return this.s2CCardHole_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) {
/*       */       return this.s2CCardHole_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<CardHandler.CardAward> getS2CCardAwardList() {
/*       */       return this.s2CCardAward_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() {
/*       */       return (List)this.s2CCardAward_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getS2CCardAwardCount() {
/*       */       return this.s2CCardAward_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardAward getS2CCardAward(int index) {
/*       */       return this.s2CCardAward_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) {
/*       */       return this.s2CCardAward_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<CardHandler.CardSuit> getS2CCardSuitList() {
/*       */       return this.s2CCardSuit_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() {
/*       */       return (List)this.s2CCardSuit_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getS2CCardSuitCount() {
/*       */       return this.s2CCardSuit_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardSuit getS2CCardSuit(int index) {
/*       */       return this.s2CCardSuit_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) {
/*       */       return this.s2CCardSuit_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CCard_ = Collections.emptyList();
/*       */       this.s2CCardHole_ = Collections.emptyList();
/*       */       this.s2CCardAward_ = Collections.emptyList();
/*       */       this.s2CCardSuit_ = Collections.emptyList();
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
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       int i;
/*       */       for (i = 0; i < getS2CCardCount(); i++) {
/*       */         if (!getS2CCard(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       for (i = 0; i < getS2CCardHoleCount(); i++) {
/*       */         if (!getS2CCardHole(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       for (i = 0; i < getS2CCardAwardCount(); i++) {
/*       */         if (!getS2CCardAward(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       for (i = 0; i < getS2CCardSuitCount(); i++) {
/*       */         if (!getS2CCardSuit(i).isInitialized()) {
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
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       int i;
/*       */       for (i = 0; i < this.s2CCard_.size(); i++) {
/*       */         output.writeMessage(3, (MessageLite)this.s2CCard_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardHole_.size(); i++) {
/*       */         output.writeMessage(4, (MessageLite)this.s2CCardHole_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardAward_.size(); i++) {
/*       */         output.writeMessage(5, (MessageLite)this.s2CCardAward_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardSuit_.size(); i++) {
/*       */         output.writeMessage(6, (MessageLite)this.s2CCardSuit_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       int i;
/*       */       for (i = 0; i < this.s2CCard_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCard_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardHole_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CCardHole_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardAward_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CCardAward_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.s2CCardSuit_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(6, (MessageLite)this.s2CCardSuit_.get(i));
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
/*       */     public static CardEquipResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(InputStream input) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static CardEquipResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (CardEquipResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(CardEquipResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements CardHandler.CardEquipResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
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
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<CardHandler.Card> s2CCard_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> s2CCardBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<CardHandler.CardHole> s2CCardHole_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> s2CCardHoleBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<CardHandler.CardAward> s2CCardAward_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> s2CCardAwardBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<CardHandler.CardSuit> s2CCardSuit_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> s2CCardSuitBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return CardHandler.internal_static_pomelo_area_CardEquipResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return CardHandler.internal_static_pomelo_area_CardEquipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardEquipResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CCard_ = Collections.emptyList();
/*       */         this.s2CCardHole_ = Collections.emptyList();
/*       */         this.s2CCardAward_ = Collections.emptyList();
/*       */         this.s2CCardSuit_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CCard_ = Collections.emptyList();
/*       */         this.s2CCardHole_ = Collections.emptyList();
/*       */         this.s2CCardAward_ = Collections.emptyList();
/*       */         this.s2CCardSuit_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (CardHandler.CardEquipResponse.alwaysUseFieldBuilders) {
/*       */           getS2CCardFieldBuilder();
/*       */           getS2CCardHoleFieldBuilder();
/*       */           getS2CCardAwardFieldBuilder();
/*       */           getS2CCardSuitFieldBuilder();
/*       */         } 
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCard_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CCardBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHole_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAward_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.clear();
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuit_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return CardHandler.internal_static_pomelo_area_CardEquipResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardEquipResponse getDefaultInstanceForType() {
/*       */         return CardHandler.CardEquipResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardEquipResponse build() {
/*       */         CardHandler.CardEquipResponse result = buildPartial();
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
/*       */       public CardHandler.CardEquipResponse buildPartial() {
/*       */         CardHandler.CardEquipResponse result = new CardHandler.CardEquipResponse(this);
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
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CCard_ = this.s2CCard_;
/*       */         } else {
/*       */           result.s2CCard_ = this.s2CCardBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.s2CCardHole_ = this.s2CCardHole_;
/*       */         } else {
/*       */           result.s2CCardHole_ = this.s2CCardHoleBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x10) == 16) {
/*       */             this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_);
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */           } 
/*       */           result.s2CCardAward_ = this.s2CCardAward_;
/*       */         } else {
/*       */           result.s2CCardAward_ = this.s2CCardAwardBuilder_.build();
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x20) == 32) {
/*       */             this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_);
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */           } 
/*       */           result.s2CCardSuit_ = this.s2CCardSuit_;
/*       */         } else {
/*       */           result.s2CCardSuit_ = this.s2CCardSuitBuilder_.build();
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof CardHandler.CardEquipResponse) {
/*       */           return mergeFrom((CardHandler.CardEquipResponse)other);
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
/*       */       public Builder mergeFrom(CardHandler.CardEquipResponse other) {
/*       */         if (other == CardHandler.CardEquipResponse.getDefaultInstance()) {
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
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if (!other.s2CCard_.isEmpty()) {
/*       */             if (this.s2CCard_.isEmpty()) {
/*       */               this.s2CCard_ = other.s2CCard_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CCardIsMutable();
/*       */               this.s2CCard_.addAll(other.s2CCard_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCard_.isEmpty()) {
/*       */           if (this.s2CCardBuilder_.isEmpty()) {
/*       */             this.s2CCardBuilder_.dispose();
/*       */             this.s2CCardBuilder_ = null;
/*       */             this.s2CCard_ = other.s2CCard_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CCardBuilder_ = CardHandler.CardEquipResponse.alwaysUseFieldBuilders ? getS2CCardFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardBuilder_.addAllMessages(other.s2CCard_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (!other.s2CCardHole_.isEmpty()) {
/*       */             if (this.s2CCardHole_.isEmpty()) {
/*       */               this.s2CCardHole_ = other.s2CCardHole_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureS2CCardHoleIsMutable();
/*       */               this.s2CCardHole_.addAll(other.s2CCardHole_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardHole_.isEmpty()) {
/*       */           if (this.s2CCardHoleBuilder_.isEmpty()) {
/*       */             this.s2CCardHoleBuilder_.dispose();
/*       */             this.s2CCardHoleBuilder_ = null;
/*       */             this.s2CCardHole_ = other.s2CCardHole_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.s2CCardHoleBuilder_ = CardHandler.CardEquipResponse.alwaysUseFieldBuilders ? getS2CCardHoleFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardHoleBuilder_.addAllMessages(other.s2CCardHole_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (!other.s2CCardAward_.isEmpty()) {
/*       */             if (this.s2CCardAward_.isEmpty()) {
/*       */               this.s2CCardAward_ = other.s2CCardAward_;
/*       */               this.bitField0_ &= 0xFFFFFFEF;
/*       */             } else {
/*       */               ensureS2CCardAwardIsMutable();
/*       */               this.s2CCardAward_.addAll(other.s2CCardAward_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardAward_.isEmpty()) {
/*       */           if (this.s2CCardAwardBuilder_.isEmpty()) {
/*       */             this.s2CCardAwardBuilder_.dispose();
/*       */             this.s2CCardAwardBuilder_ = null;
/*       */             this.s2CCardAward_ = other.s2CCardAward_;
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */             this.s2CCardAwardBuilder_ = CardHandler.CardEquipResponse.alwaysUseFieldBuilders ? getS2CCardAwardFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardAwardBuilder_.addAllMessages(other.s2CCardAward_);
/*       */           } 
/*       */         } 
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (!other.s2CCardSuit_.isEmpty()) {
/*       */             if (this.s2CCardSuit_.isEmpty()) {
/*       */               this.s2CCardSuit_ = other.s2CCardSuit_;
/*       */               this.bitField0_ &= 0xFFFFFFDF;
/*       */             } else {
/*       */               ensureS2CCardSuitIsMutable();
/*       */               this.s2CCardSuit_.addAll(other.s2CCardSuit_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CCardSuit_.isEmpty()) {
/*       */           if (this.s2CCardSuitBuilder_.isEmpty()) {
/*       */             this.s2CCardSuitBuilder_.dispose();
/*       */             this.s2CCardSuitBuilder_ = null;
/*       */             this.s2CCardSuit_ = other.s2CCardSuit_;
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */             this.s2CCardSuitBuilder_ = CardHandler.CardEquipResponse.alwaysUseFieldBuilders ? getS2CCardSuitFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CCardSuitBuilder_.addAllMessages(other.s2CCardSuit_);
/*       */           } 
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         int i;
/*       */         for (i = 0; i < getS2CCardCount(); i++) {
/*       */           if (!getS2CCard(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         for (i = 0; i < getS2CCardHoleCount(); i++) {
/*       */           if (!getS2CCardHole(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         for (i = 0; i < getS2CCardAwardCount(); i++) {
/*       */           if (!getS2CCardAward(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         for (i = 0; i < getS2CCardSuitCount(); i++) {
/*       */           if (!getS2CCardSuit(i).isInitialized()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         CardHandler.CardEquipResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (CardHandler.CardEquipResponse)CardHandler.CardEquipResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (CardHandler.CardEquipResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */         this.s2CMsg_ = CardHandler.CardEquipResponse.getDefaultInstance().getS2CMsg();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureS2CCardIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CCard_ = new ArrayList<>(this.s2CCard_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.Card> getS2CCardList() {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.s2CCard_);
/*       */         }
/*       */         return this.s2CCardBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCardCount() {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           return this.s2CCard_.size();
/*       */         }
/*       */         return this.s2CCardBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.Card getS2CCard(int index) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           return this.s2CCard_.get(index);
/*       */         }
/*       */         return (CardHandler.Card)this.s2CCardBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCard(int index, CardHandler.Card value) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCard(int index, CardHandler.Card.Builder builderForValue) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCard(CardHandler.Card value) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCard(int index, CardHandler.Card value) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCard(CardHandler.Card.Builder builderForValue) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCard(int index, CardHandler.Card.Builder builderForValue) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllS2CCard(Iterable<? extends CardHandler.Card> values) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCard_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCard() {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCard_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeS2CCard(int index) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           ensureS2CCardIsMutable();
/*       */           this.s2CCard_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.Card.Builder getS2CCardBuilder(int index) {
/*       */         return (CardHandler.Card.Builder)getS2CCardFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           return this.s2CCard_.get(index);
/*       */         }
/*       */         return (CardHandler.CardOrBuilder)this.s2CCardBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() {
/*       */         if (this.s2CCardBuilder_ != null) {
/*       */           return this.s2CCardBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.s2CCard_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.Card.Builder addS2CCardBuilder() {
/*       */         return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(CardHandler.Card.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.Card.Builder addS2CCardBuilder(int index) {
/*       */         return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(index, CardHandler.Card.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.Card.Builder> getS2CCardBuilderList() {
/*       */         return getS2CCardFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> getS2CCardFieldBuilder() {
/*       */         if (this.s2CCardBuilder_ == null) {
/*       */           this.s2CCardBuilder_ = new RepeatedFieldBuilder(this.s2CCard_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CCard_ = null;
/*       */         } 
/*       */         return this.s2CCardBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureS2CCardHoleIsMutable() {
/*       */         if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.s2CCardHole_ = new ArrayList<>(this.s2CCardHole_);
/*       */           this.bitField0_ |= 0x8;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardHole> getS2CCardHoleList() {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.s2CCardHole_);
/*       */         }
/*       */         return this.s2CCardHoleBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCardHoleCount() {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           return this.s2CCardHole_.size();
/*       */         }
/*       */         return this.s2CCardHoleBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardHole getS2CCardHole(int index) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           return this.s2CCardHole_.get(index);
/*       */         }
/*       */         return (CardHandler.CardHole)this.s2CCardHoleBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole value) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardHole(CardHandler.CardHole value) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole value) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardHole(CardHandler.CardHole.Builder builderForValue) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllS2CCardHole(Iterable<? extends CardHandler.CardHole> values) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardHole_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCardHole() {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHole_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeS2CCardHole(int index) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           ensureS2CCardHoleIsMutable();
/*       */           this.s2CCardHole_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardHoleBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardHole.Builder getS2CCardHoleBuilder(int index) {
/*       */         return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           return this.s2CCardHole_.get(index);
/*       */         }
/*       */         return (CardHandler.CardHoleOrBuilder)this.s2CCardHoleBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() {
/*       */         if (this.s2CCardHoleBuilder_ != null) {
/*       */           return this.s2CCardHoleBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.s2CCardHole_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder() {
/*       */         return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(CardHandler.CardHole.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder(int index) {
/*       */         return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(index, CardHandler.CardHole.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardHole.Builder> getS2CCardHoleBuilderList() {
/*       */         return getS2CCardHoleFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> getS2CCardHoleFieldBuilder() {
/*       */         if (this.s2CCardHoleBuilder_ == null) {
/*       */           this.s2CCardHoleBuilder_ = new RepeatedFieldBuilder(this.s2CCardHole_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.s2CCardHole_ = null;
/*       */         } 
/*       */         return this.s2CCardHoleBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureS2CCardAwardIsMutable() {
/*       */         if ((this.bitField0_ & 0x10) != 16) {
/*       */           this.s2CCardAward_ = new ArrayList<>(this.s2CCardAward_);
/*       */           this.bitField0_ |= 0x10;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardAward> getS2CCardAwardList() {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.s2CCardAward_);
/*       */         }
/*       */         return this.s2CCardAwardBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCardAwardCount() {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           return this.s2CCardAward_.size();
/*       */         }
/*       */         return this.s2CCardAwardBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardAward getS2CCardAward(int index) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           return this.s2CCardAward_.get(index);
/*       */         }
/*       */         return (CardHandler.CardAward)this.s2CCardAwardBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward value) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardAward(CardHandler.CardAward value) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward value) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardAward(CardHandler.CardAward.Builder builderForValue) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllS2CCardAward(Iterable<? extends CardHandler.CardAward> values) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardAward_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCardAward() {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAward_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeS2CCardAward(int index) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           ensureS2CCardAwardIsMutable();
/*       */           this.s2CCardAward_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardAwardBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardAward.Builder getS2CCardAwardBuilder(int index) {
/*       */         return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           return this.s2CCardAward_.get(index);
/*       */         }
/*       */         return (CardHandler.CardAwardOrBuilder)this.s2CCardAwardBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() {
/*       */         if (this.s2CCardAwardBuilder_ != null) {
/*       */           return this.s2CCardAwardBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.s2CCardAward_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardAward.Builder addS2CCardAwardBuilder() {
/*       */         return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(CardHandler.CardAward.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardAward.Builder addS2CCardAwardBuilder(int index) {
/*       */         return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(index, CardHandler.CardAward.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardAward.Builder> getS2CCardAwardBuilderList() {
/*       */         return getS2CCardAwardFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> getS2CCardAwardFieldBuilder() {
/*       */         if (this.s2CCardAwardBuilder_ == null) {
/*       */           this.s2CCardAwardBuilder_ = new RepeatedFieldBuilder(this.s2CCardAward_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*       */           this.s2CCardAward_ = null;
/*       */         } 
/*       */         return this.s2CCardAwardBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureS2CCardSuitIsMutable() {
/*       */         if ((this.bitField0_ & 0x20) != 32) {
/*       */           this.s2CCardSuit_ = new ArrayList<>(this.s2CCardSuit_);
/*       */           this.bitField0_ |= 0x20;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardSuit> getS2CCardSuitList() {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.s2CCardSuit_);
/*       */         }
/*       */         return this.s2CCardSuitBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCardSuitCount() {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           return this.s2CCardSuit_.size();
/*       */         }
/*       */         return this.s2CCardSuitBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardSuit getS2CCardSuit(int index) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           return this.s2CCardSuit_.get(index);
/*       */         }
/*       */         return (CardHandler.CardSuit)this.s2CCardSuitBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardSuit(int index, CardHandler.CardSuit value) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardSuit(CardHandler.CardSuit value) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardSuit(int index, CardHandler.CardSuit value) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardSuit(CardHandler.CardSuit.Builder builderForValue) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllS2CCardSuit(Iterable<? extends CardHandler.CardSuit> values) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CCardSuit_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCardSuit() {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuit_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeS2CCardSuit(int index) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           ensureS2CCardSuitIsMutable();
/*       */           this.s2CCardSuit_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CCardSuitBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardSuit.Builder getS2CCardSuitBuilder(int index) {
/*       */         return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           return this.s2CCardSuit_.get(index);
/*       */         }
/*       */         return (CardHandler.CardSuitOrBuilder)this.s2CCardSuitBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() {
/*       */         if (this.s2CCardSuitBuilder_ != null) {
/*       */           return this.s2CCardSuitBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.s2CCardSuit_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardSuit.Builder addS2CCardSuitBuilder() {
/*       */         return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(CardHandler.CardSuit.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public CardHandler.CardSuit.Builder addS2CCardSuitBuilder(int index) {
/*       */         return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(index, CardHandler.CardSuit.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<CardHandler.CardSuit.Builder> getS2CCardSuitBuilderList() {
/*       */         return getS2CCardSuitFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> getS2CCardSuitFieldBuilder() {
/*       */         if (this.s2CCardSuitBuilder_ == null) {
/*       */           this.s2CCardSuitBuilder_ = new RepeatedFieldBuilder(this.s2CCardSuit_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
/*       */           this.s2CCardSuit_ = null;
/*       */         } 
/*       */         return this.s2CCardSuitBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class CardQueryAllDataResponse
/*       */     extends GeneratedMessage
/*       */     implements CardQueryAllDataResponseOrBuilder
/*       */   {
/* 18783 */     private static final CardQueryAllDataResponse defaultInstance = new CardQueryAllDataResponse(true); private final UnknownFieldSet unknownFields; private CardQueryAllDataResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CardQueryAllDataResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CardQueryAllDataResponse getDefaultInstance() { return defaultInstance; } public CardQueryAllDataResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CardQueryAllDataResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CCard_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CCard_.add(input.readMessage(CardHandler.Card.PARSER, extensionRegistry)); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CCardHole_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CCardHole_.add(input.readMessage(CardHandler.CardHole.PARSER, extensionRegistry)); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CCardAward_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CCardAward_.add(input.readMessage(CardHandler.CardAward.PARSER, extensionRegistry)); break;case 50: if ((mutable_bitField0_ & 0x20) != 32) { this.s2CCardSuit_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.s2CCardSuit_.add(input.readMessage(CardHandler.CardSuit.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_);  if ((mutable_bitField0_ & 0x8) == 8) this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_);  if ((mutable_bitField0_ & 0x10) == 16) this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_);  if ((mutable_bitField0_ & 0x20) == 32) this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardQueryAllDataResponse.class, Builder.class); } public static Parser<CardQueryAllDataResponse> PARSER = (Parser<CardQueryAllDataResponse>)new AbstractParser<CardQueryAllDataResponse>() { public CardHandler.CardQueryAllDataResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new CardHandler.CardQueryAllDataResponse(input, extensionRegistry); } }
/* 18784 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CARD_FIELD_NUMBER = 3; private List<CardHandler.Card> s2CCard_; public static final int S2C_CARDHOLE_FIELD_NUMBER = 4; private List<CardHandler.CardHole> s2CCardHole_; public static final int S2C_CARDAWARD_FIELD_NUMBER = 5; private List<CardHandler.CardAward> s2CCardAward_; public static final int S2C_CARDSUIT_FIELD_NUMBER = 6; private List<CardHandler.CardSuit> s2CCardSuit_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CardQueryAllDataResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<CardHandler.Card> getS2CCardList() { return this.s2CCard_; } public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() { return (List)this.s2CCard_; } public int getS2CCardCount() { return this.s2CCard_.size(); } public CardHandler.Card getS2CCard(int index) { return this.s2CCard_.get(index); } public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) { return this.s2CCard_.get(index); } public List<CardHandler.CardHole> getS2CCardHoleList() { return this.s2CCardHole_; } public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() { return (List)this.s2CCardHole_; } public int getS2CCardHoleCount() { return this.s2CCardHole_.size(); } public CardHandler.CardHole getS2CCardHole(int index) { return this.s2CCardHole_.get(index); } public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) { return this.s2CCardHole_.get(index); } public List<CardHandler.CardAward> getS2CCardAwardList() { return this.s2CCardAward_; } public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() { return (List)this.s2CCardAward_; } public int getS2CCardAwardCount() { return this.s2CCardAward_.size(); } public CardHandler.CardAward getS2CCardAward(int index) { return this.s2CCardAward_.get(index); } public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) { return this.s2CCardAward_.get(index); } public List<CardHandler.CardSuit> getS2CCardSuitList() { return this.s2CCardSuit_; } public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() { return (List)this.s2CCardSuit_; } public int getS2CCardSuitCount() { return this.s2CCardSuit_.size(); } public CardHandler.CardSuit getS2CCardSuit(int index) { return this.s2CCardSuit_.get(index); } public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) { return this.s2CCardSuit_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  int i; for (i = 0; i < getS2CCardCount(); i++) { if (!getS2CCard(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getS2CCardHoleCount(); i++) { if (!getS2CCardHole(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getS2CCardAwardCount(); i++) { if (!getS2CCardAward(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getS2CCardSuitCount(); i++) { if (!getS2CCardSuit(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CCard_.size(); i++) output.writeMessage(3, (MessageLite)this.s2CCard_.get(i));  for (i = 0; i < this.s2CCardHole_.size(); i++) output.writeMessage(4, (MessageLite)this.s2CCardHole_.get(i));  for (i = 0; i < this.s2CCardAward_.size(); i++) output.writeMessage(5, (MessageLite)this.s2CCardAward_.get(i));  for (i = 0; i < this.s2CCardSuit_.size(); i++) output.writeMessage(6, (MessageLite)this.s2CCardSuit_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CCard_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCard_.get(i));  for (i = 0; i < this.s2CCardHole_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CCardHole_.get(i));  for (i = 0; i < this.s2CCardAward_.size(); i++) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CCardAward_.get(i));  for (i = 0; i < this.s2CCardSuit_.size(); i++) size += CodedOutputStream.computeMessageSize(6, (MessageLite)this.s2CCardSuit_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static CardQueryAllDataResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (CardQueryAllDataResponse)PARSER.parseFrom(data); } public static CardQueryAllDataResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardQueryAllDataResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardQueryAllDataResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (CardQueryAllDataResponse)PARSER.parseFrom(data); } public static CardQueryAllDataResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (CardQueryAllDataResponse)PARSER.parseFrom(data, extensionRegistry); } public static CardQueryAllDataResponse parseFrom(InputStream input) throws IOException { return (CardQueryAllDataResponse)PARSER.parseFrom(input); } public static CardQueryAllDataResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataResponse)PARSER.parseFrom(input, extensionRegistry); } public static CardQueryAllDataResponse parseDelimitedFrom(InputStream input) throws IOException { return (CardQueryAllDataResponse)PARSER.parseDelimitedFrom(input); } static { defaultInstance.initFields(); }
/*       */     public static CardQueryAllDataResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static CardQueryAllDataResponse parseFrom(CodedInputStream input) throws IOException { return (CardQueryAllDataResponse)PARSER.parseFrom(input); }
/*       */     public static CardQueryAllDataResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (CardQueryAllDataResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(CardQueryAllDataResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements CardHandler.CardQueryAllDataResponseOrBuilder {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private List<CardHandler.Card> s2CCard_;
/*       */       private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> s2CCardBuilder_;
/*       */       private List<CardHandler.CardHole> s2CCardHole_;
/*       */       private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> s2CCardHoleBuilder_;
/*       */       private List<CardHandler.CardAward> s2CCardAward_;
/*       */       private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> s2CCardAwardBuilder_;
/*       */       private List<CardHandler.CardSuit> s2CCardSuit_;
/*       */       private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> s2CCardSuitBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CardHandler.CardQueryAllDataResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CCard_ = Collections.emptyList(); this.s2CCardHole_ = Collections.emptyList(); this.s2CCardAward_ = Collections.emptyList(); this.s2CCardSuit_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (CardHandler.CardQueryAllDataResponse.alwaysUseFieldBuilders) { getS2CCardFieldBuilder(); getS2CCardHoleFieldBuilder(); getS2CCardAwardFieldBuilder(); getS2CCardSuitFieldBuilder(); }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CCardBuilder_ == null) { this.s2CCard_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.s2CCardBuilder_.clear(); }  if (this.s2CCardHoleBuilder_ == null) { this.s2CCardHole_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; } else { this.s2CCardHoleBuilder_.clear(); }  if (this.s2CCardAwardBuilder_ == null) { this.s2CCardAward_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; } else { this.s2CCardAwardBuilder_.clear(); }  if (this.s2CCardSuitBuilder_ == null) { this.s2CCardSuit_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFDF; } else { this.s2CCardSuitBuilder_.clear(); }  return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return CardHandler.internal_static_pomelo_area_CardQueryAllDataResponse_descriptor; }
/*       */       public CardHandler.CardQueryAllDataResponse getDefaultInstanceForType() { return CardHandler.CardQueryAllDataResponse.getDefaultInstance(); }
/*       */       public CardHandler.CardQueryAllDataResponse build() { CardHandler.CardQueryAllDataResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*       */       public CardHandler.CardQueryAllDataResponse buildPartial() { CardHandler.CardQueryAllDataResponse result = new CardHandler.CardQueryAllDataResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.s2CCardBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.s2CCard_ = Collections.unmodifiableList(this.s2CCard_); this.bitField0_ &= 0xFFFFFFFB; }  result.s2CCard_ = this.s2CCard_; } else { result.s2CCard_ = this.s2CCardBuilder_.build(); }  if (this.s2CCardHoleBuilder_ == null) { if ((this.bitField0_ & 0x8) == 8) { this.s2CCardHole_ = Collections.unmodifiableList(this.s2CCardHole_); this.bitField0_ &= 0xFFFFFFF7; }  result.s2CCardHole_ = this.s2CCardHole_; } else { result.s2CCardHole_ = this.s2CCardHoleBuilder_.build(); }  if (this.s2CCardAwardBuilder_ == null) { if ((this.bitField0_ & 0x10) == 16) { this.s2CCardAward_ = Collections.unmodifiableList(this.s2CCardAward_); this.bitField0_ &= 0xFFFFFFEF; }  result.s2CCardAward_ = this.s2CCardAward_; } else { result.s2CCardAward_ = this.s2CCardAwardBuilder_.build(); }  if (this.s2CCardSuitBuilder_ == null) { if ((this.bitField0_ & 0x20) == 32) { this.s2CCardSuit_ = Collections.unmodifiableList(this.s2CCardSuit_); this.bitField0_ &= 0xFFFFFFDF; }  result.s2CCardSuit_ = this.s2CCardSuit_; } else { result.s2CCardSuit_ = this.s2CCardSuitBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof CardHandler.CardQueryAllDataResponse) return mergeFrom((CardHandler.CardQueryAllDataResponse)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(CardHandler.CardQueryAllDataResponse other) { if (other == CardHandler.CardQueryAllDataResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (this.s2CCardBuilder_ == null) { if (!other.s2CCard_.isEmpty()) { if (this.s2CCard_.isEmpty()) { this.s2CCard_ = other.s2CCard_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureS2CCardIsMutable(); this.s2CCard_.addAll(other.s2CCard_); }  onChanged(); }  } else if (!other.s2CCard_.isEmpty()) { if (this.s2CCardBuilder_.isEmpty()) { this.s2CCardBuilder_.dispose(); this.s2CCardBuilder_ = null; this.s2CCard_ = other.s2CCard_; this.bitField0_ &= 0xFFFFFFFB; this.s2CCardBuilder_ = CardHandler.CardQueryAllDataResponse.alwaysUseFieldBuilders ? getS2CCardFieldBuilder() : null; } else { this.s2CCardBuilder_.addAllMessages(other.s2CCard_); }  }  if (this.s2CCardHoleBuilder_ == null) { if (!other.s2CCardHole_.isEmpty()) { if (this.s2CCardHole_.isEmpty()) { this.s2CCardHole_ = other.s2CCardHole_; this.bitField0_ &= 0xFFFFFFF7; } else { ensureS2CCardHoleIsMutable(); this.s2CCardHole_.addAll(other.s2CCardHole_); }  onChanged(); }  } else if (!other.s2CCardHole_.isEmpty()) { if (this.s2CCardHoleBuilder_.isEmpty()) { this.s2CCardHoleBuilder_.dispose(); this.s2CCardHoleBuilder_ = null; this.s2CCardHole_ = other.s2CCardHole_; this.bitField0_ &= 0xFFFFFFF7; this.s2CCardHoleBuilder_ = CardHandler.CardQueryAllDataResponse.alwaysUseFieldBuilders ? getS2CCardHoleFieldBuilder() : null; } else { this.s2CCardHoleBuilder_.addAllMessages(other.s2CCardHole_); }  }  if (this.s2CCardAwardBuilder_ == null) { if (!other.s2CCardAward_.isEmpty()) { if (this.s2CCardAward_.isEmpty()) { this.s2CCardAward_ = other.s2CCardAward_; this.bitField0_ &= 0xFFFFFFEF; } else { ensureS2CCardAwardIsMutable(); this.s2CCardAward_.addAll(other.s2CCardAward_); }  onChanged(); }  } else if (!other.s2CCardAward_.isEmpty()) { if (this.s2CCardAwardBuilder_.isEmpty()) { this.s2CCardAwardBuilder_.dispose(); this.s2CCardAwardBuilder_ = null; this.s2CCardAward_ = other.s2CCardAward_; this.bitField0_ &= 0xFFFFFFEF; this.s2CCardAwardBuilder_ = CardHandler.CardQueryAllDataResponse.alwaysUseFieldBuilders ? getS2CCardAwardFieldBuilder() : null; } else { this.s2CCardAwardBuilder_.addAllMessages(other.s2CCardAward_); }  }  if (this.s2CCardSuitBuilder_ == null) { if (!other.s2CCardSuit_.isEmpty()) { if (this.s2CCardSuit_.isEmpty()) { this.s2CCardSuit_ = other.s2CCardSuit_; this.bitField0_ &= 0xFFFFFFDF; } else { ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.addAll(other.s2CCardSuit_); }  onChanged(); }  } else if (!other.s2CCardSuit_.isEmpty()) { if (this.s2CCardSuitBuilder_.isEmpty()) { this.s2CCardSuitBuilder_.dispose(); this.s2CCardSuitBuilder_ = null; this.s2CCardSuit_ = other.s2CCardSuit_; this.bitField0_ &= 0xFFFFFFDF; this.s2CCardSuitBuilder_ = CardHandler.CardQueryAllDataResponse.alwaysUseFieldBuilders ? getS2CCardSuitFieldBuilder() : null; } else { this.s2CCardSuitBuilder_.addAllMessages(other.s2CCardSuit_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  int i; for (i = 0; i < getS2CCardCount(); i++) { if (!getS2CCard(i).isInitialized()) return false;  }  for (i = 0; i < getS2CCardHoleCount(); i++) { if (!getS2CCardHole(i).isInitialized()) return false;  }  for (i = 0; i < getS2CCardAwardCount(); i++) { if (!getS2CCardAward(i).isInitialized()) return false;  }  for (i = 0; i < getS2CCardSuitCount(); i++) { if (!getS2CCardSuit(i).isInitialized()) return false;  }  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { CardHandler.CardQueryAllDataResponse parsedMessage = null; try { parsedMessage = (CardHandler.CardQueryAllDataResponse)CardHandler.CardQueryAllDataResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (CardHandler.CardQueryAllDataResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*       */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CCode() { return this.s2CCode_; }
/*       */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*       */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*       */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*       */       public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = CardHandler.CardQueryAllDataResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       private void ensureS2CCardIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.s2CCard_ = new ArrayList<>(this.s2CCard_); this.bitField0_ |= 0x4; }  }
/*       */       public List<CardHandler.Card> getS2CCardList() { if (this.s2CCardBuilder_ == null) return Collections.unmodifiableList(this.s2CCard_);  return this.s2CCardBuilder_.getMessageList(); }
/*       */       public int getS2CCardCount() { if (this.s2CCardBuilder_ == null) return this.s2CCard_.size();  return this.s2CCardBuilder_.getCount(); }
/*       */       public CardHandler.Card getS2CCard(int index) { if (this.s2CCardBuilder_ == null) return this.s2CCard_.get(index);  return (CardHandler.Card)this.s2CCardBuilder_.getMessage(index); }
/*       */       public Builder setS2CCard(int index, CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardIsMutable(); this.s2CCard_.set(index, value); onChanged(); } else { this.s2CCardBuilder_.setMessage(index, value); }  return this; }
/*       */       public Builder setS2CCard(int index, CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) { ensureS2CCardIsMutable(); this.s2CCard_.set(index, builderForValue.build()); onChanged(); } else { this.s2CCardBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCard(CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardIsMutable(); this.s2CCard_.add(value); onChanged(); } else { this.s2CCardBuilder_.addMessage(value); }  return this; }
/*       */       public Builder addS2CCard(int index, CardHandler.Card value) { if (this.s2CCardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardIsMutable(); this.s2CCard_.add(index, value); onChanged(); } else { this.s2CCardBuilder_.addMessage(index, value); }  return this; }
/*       */       public Builder addS2CCard(CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) { ensureS2CCardIsMutable(); this.s2CCard_.add(builderForValue.build()); onChanged(); } else { this.s2CCardBuilder_.addMessage(builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCard(int index, CardHandler.Card.Builder builderForValue) { if (this.s2CCardBuilder_ == null) { ensureS2CCardIsMutable(); this.s2CCard_.add(index, builderForValue.build()); onChanged(); } else { this.s2CCardBuilder_.addMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addAllS2CCard(Iterable<? extends CardHandler.Card> values) { if (this.s2CCardBuilder_ == null) { ensureS2CCardIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CCard_); onChanged(); } else { this.s2CCardBuilder_.addAllMessages(values); }  return this; }
/*       */       public Builder clearS2CCard() { if (this.s2CCardBuilder_ == null) { this.s2CCard_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); } else { this.s2CCardBuilder_.clear(); }  return this; }
/*       */       public Builder removeS2CCard(int index) { if (this.s2CCardBuilder_ == null) { ensureS2CCardIsMutable(); this.s2CCard_.remove(index); onChanged(); } else { this.s2CCardBuilder_.remove(index); }  return this; }
/*       */       public CardHandler.Card.Builder getS2CCardBuilder(int index) { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardOrBuilder getS2CCardOrBuilder(int index) { if (this.s2CCardBuilder_ == null) return this.s2CCard_.get(index);  return (CardHandler.CardOrBuilder)this.s2CCardBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList() { if (this.s2CCardBuilder_ != null) return this.s2CCardBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CCard_); }
/*       */       public CardHandler.Card.Builder addS2CCardBuilder() { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(CardHandler.Card.getDefaultInstance()); }
/*       */       public CardHandler.Card.Builder addS2CCardBuilder(int index) { return (CardHandler.Card.Builder)getS2CCardFieldBuilder().addBuilder(index, CardHandler.Card.getDefaultInstance()); }
/*       */       public List<CardHandler.Card.Builder> getS2CCardBuilderList() { return getS2CCardFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.Card, CardHandler.Card.Builder, CardHandler.CardOrBuilder> getS2CCardFieldBuilder() { if (this.s2CCardBuilder_ == null) { this.s2CCardBuilder_ = new RepeatedFieldBuilder(this.s2CCard_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.s2CCard_ = null; }  return this.s2CCardBuilder_; }
/*       */       private void ensureS2CCardHoleIsMutable() { if ((this.bitField0_ & 0x8) != 8) { this.s2CCardHole_ = new ArrayList<>(this.s2CCardHole_); this.bitField0_ |= 0x8; }  }
/*       */       public List<CardHandler.CardHole> getS2CCardHoleList() { if (this.s2CCardHoleBuilder_ == null) return Collections.unmodifiableList(this.s2CCardHole_);  return this.s2CCardHoleBuilder_.getMessageList(); }
/*       */       public int getS2CCardHoleCount() { if (this.s2CCardHoleBuilder_ == null) return this.s2CCardHole_.size();  return this.s2CCardHoleBuilder_.getCount(); }
/*       */       public CardHandler.CardHole getS2CCardHole(int index) { if (this.s2CCardHoleBuilder_ == null) return this.s2CCardHole_.get(index);  return (CardHandler.CardHole)this.s2CCardHoleBuilder_.getMessage(index); }
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardHoleIsMutable(); this.s2CCardHole_.set(index, value); onChanged(); } else { this.s2CCardHoleBuilder_.setMessage(index, value); }  return this; }
/*       */       public Builder setS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) { ensureS2CCardHoleIsMutable(); this.s2CCardHole_.set(index, builderForValue.build()); onChanged(); } else { this.s2CCardHoleBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCardHole(CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardHoleIsMutable(); this.s2CCardHole_.add(value); onChanged(); } else { this.s2CCardHoleBuilder_.addMessage(value); }  return this; }
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole value) { if (this.s2CCardHoleBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardHoleIsMutable(); this.s2CCardHole_.add(index, value); onChanged(); } else { this.s2CCardHoleBuilder_.addMessage(index, value); }  return this; }
/*       */       public Builder addS2CCardHole(CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) { ensureS2CCardHoleIsMutable(); this.s2CCardHole_.add(builderForValue.build()); onChanged(); } else { this.s2CCardHoleBuilder_.addMessage(builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCardHole(int index, CardHandler.CardHole.Builder builderForValue) { if (this.s2CCardHoleBuilder_ == null) { ensureS2CCardHoleIsMutable(); this.s2CCardHole_.add(index, builderForValue.build()); onChanged(); } else { this.s2CCardHoleBuilder_.addMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addAllS2CCardHole(Iterable<? extends CardHandler.CardHole> values) { if (this.s2CCardHoleBuilder_ == null) { ensureS2CCardHoleIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CCardHole_); onChanged(); } else { this.s2CCardHoleBuilder_.addAllMessages(values); }  return this; }
/*       */       public Builder clearS2CCardHole() { if (this.s2CCardHoleBuilder_ == null) { this.s2CCardHole_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; onChanged(); } else { this.s2CCardHoleBuilder_.clear(); }  return this; }
/*       */       public Builder removeS2CCardHole(int index) { if (this.s2CCardHoleBuilder_ == null) { ensureS2CCardHoleIsMutable(); this.s2CCardHole_.remove(index); onChanged(); } else { this.s2CCardHoleBuilder_.remove(index); }  return this; }
/*       */       public CardHandler.CardHole.Builder getS2CCardHoleBuilder(int index) { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().getBuilder(index); }
/*       */       public CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int index) { if (this.s2CCardHoleBuilder_ == null) return this.s2CCardHole_.get(index);  return (CardHandler.CardHoleOrBuilder)this.s2CCardHoleBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList() { if (this.s2CCardHoleBuilder_ != null) return this.s2CCardHoleBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CCardHole_); }
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder() { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(CardHandler.CardHole.getDefaultInstance()); }
/*       */       public CardHandler.CardHole.Builder addS2CCardHoleBuilder(int index) { return (CardHandler.CardHole.Builder)getS2CCardHoleFieldBuilder().addBuilder(index, CardHandler.CardHole.getDefaultInstance()); }
/*       */       public List<CardHandler.CardHole.Builder> getS2CCardHoleBuilderList() { return getS2CCardHoleFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<CardHandler.CardHole, CardHandler.CardHole.Builder, CardHandler.CardHoleOrBuilder> getS2CCardHoleFieldBuilder() { if (this.s2CCardHoleBuilder_ == null) { this.s2CCardHoleBuilder_ = new RepeatedFieldBuilder(this.s2CCardHole_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean()); this.s2CCardHole_ = null; }  return this.s2CCardHoleBuilder_; }
/*       */       private void ensureS2CCardAwardIsMutable() { if ((this.bitField0_ & 0x10) != 16) { this.s2CCardAward_ = new ArrayList<>(this.s2CCardAward_); this.bitField0_ |= 0x10; }  }
/*       */       public List<CardHandler.CardAward> getS2CCardAwardList() { if (this.s2CCardAwardBuilder_ == null) return Collections.unmodifiableList(this.s2CCardAward_);  return this.s2CCardAwardBuilder_.getMessageList(); }
/*       */       public int getS2CCardAwardCount() { if (this.s2CCardAwardBuilder_ == null) return this.s2CCardAward_.size();  return this.s2CCardAwardBuilder_.getCount(); }
/*       */       public CardHandler.CardAward getS2CCardAward(int index) { if (this.s2CCardAwardBuilder_ == null) return this.s2CCardAward_.get(index);  return (CardHandler.CardAward)this.s2CCardAwardBuilder_.getMessage(index); }
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardAwardIsMutable(); this.s2CCardAward_.set(index, value); onChanged(); } else { this.s2CCardAwardBuilder_.setMessage(index, value); }  return this; }
/*       */       public Builder setS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) { ensureS2CCardAwardIsMutable(); this.s2CCardAward_.set(index, builderForValue.build()); onChanged(); } else { this.s2CCardAwardBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCardAward(CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardAwardIsMutable(); this.s2CCardAward_.add(value); onChanged(); } else { this.s2CCardAwardBuilder_.addMessage(value); }  return this; }
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward value) { if (this.s2CCardAwardBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardAwardIsMutable(); this.s2CCardAward_.add(index, value); onChanged(); } else { this.s2CCardAwardBuilder_.addMessage(index, value); }  return this; }
/*       */       public Builder addS2CCardAward(CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) { ensureS2CCardAwardIsMutable(); this.s2CCardAward_.add(builderForValue.build()); onChanged(); } else { this.s2CCardAwardBuilder_.addMessage(builderForValue.build()); }  return this; }
/*       */       public Builder addS2CCardAward(int index, CardHandler.CardAward.Builder builderForValue) { if (this.s2CCardAwardBuilder_ == null) { ensureS2CCardAwardIsMutable(); this.s2CCardAward_.add(index, builderForValue.build()); onChanged(); } else { this.s2CCardAwardBuilder_.addMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addAllS2CCardAward(Iterable<? extends CardHandler.CardAward> values) { if (this.s2CCardAwardBuilder_ == null) { ensureS2CCardAwardIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CCardAward_); onChanged(); } else { this.s2CCardAwardBuilder_.addAllMessages(values); }  return this; }
/*       */       public Builder clearS2CCardAward() { if (this.s2CCardAwardBuilder_ == null) { this.s2CCardAward_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; onChanged(); } else { this.s2CCardAwardBuilder_.clear(); }  return this; } public Builder removeS2CCardAward(int index) { if (this.s2CCardAwardBuilder_ == null) { ensureS2CCardAwardIsMutable(); this.s2CCardAward_.remove(index); onChanged(); } else { this.s2CCardAwardBuilder_.remove(index); }  return this; } public CardHandler.CardAward.Builder getS2CCardAwardBuilder(int index) { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().getBuilder(index); } public CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int index) { if (this.s2CCardAwardBuilder_ == null) return this.s2CCardAward_.get(index);  return (CardHandler.CardAwardOrBuilder)this.s2CCardAwardBuilder_.getMessageOrBuilder(index); } public List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList() { if (this.s2CCardAwardBuilder_ != null) return this.s2CCardAwardBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CCardAward_); } public CardHandler.CardAward.Builder addS2CCardAwardBuilder() { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(CardHandler.CardAward.getDefaultInstance()); } public CardHandler.CardAward.Builder addS2CCardAwardBuilder(int index) { return (CardHandler.CardAward.Builder)getS2CCardAwardFieldBuilder().addBuilder(index, CardHandler.CardAward.getDefaultInstance()); } public List<CardHandler.CardAward.Builder> getS2CCardAwardBuilderList() { return getS2CCardAwardFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<CardHandler.CardAward, CardHandler.CardAward.Builder, CardHandler.CardAwardOrBuilder> getS2CCardAwardFieldBuilder() { if (this.s2CCardAwardBuilder_ == null) { this.s2CCardAwardBuilder_ = new RepeatedFieldBuilder(this.s2CCardAward_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean()); this.s2CCardAward_ = null; }  return this.s2CCardAwardBuilder_; } private void ensureS2CCardSuitIsMutable() { if ((this.bitField0_ & 0x20) != 32) { this.s2CCardSuit_ = new ArrayList<>(this.s2CCardSuit_); this.bitField0_ |= 0x20; }  } public List<CardHandler.CardSuit> getS2CCardSuitList() { if (this.s2CCardSuitBuilder_ == null) return Collections.unmodifiableList(this.s2CCardSuit_);  return this.s2CCardSuitBuilder_.getMessageList(); } public int getS2CCardSuitCount() { if (this.s2CCardSuitBuilder_ == null) return this.s2CCardSuit_.size();  return this.s2CCardSuitBuilder_.getCount(); } public CardHandler.CardSuit getS2CCardSuit(int index) { if (this.s2CCardSuitBuilder_ == null) return this.s2CCardSuit_.get(index);  return (CardHandler.CardSuit)this.s2CCardSuitBuilder_.getMessage(index); } public Builder setS2CCardSuit(int index, CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.set(index, value); onChanged(); } else { this.s2CCardSuitBuilder_.setMessage(index, value); }  return this; } public Builder setS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) { ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.set(index, builderForValue.build()); onChanged(); } else { this.s2CCardSuitBuilder_.setMessage(index, builderForValue.build()); }  return this; } public Builder addS2CCardSuit(CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.add(value); onChanged(); } else { this.s2CCardSuitBuilder_.addMessage(value); }  return this; } public Builder addS2CCardSuit(int index, CardHandler.CardSuit value) { if (this.s2CCardSuitBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.add(index, value); onChanged(); } else { this.s2CCardSuitBuilder_.addMessage(index, value); }  return this; } public Builder addS2CCardSuit(CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) { ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.add(builderForValue.build()); onChanged(); } else { this.s2CCardSuitBuilder_.addMessage(builderForValue.build()); }  return this; } public Builder addS2CCardSuit(int index, CardHandler.CardSuit.Builder builderForValue) { if (this.s2CCardSuitBuilder_ == null) { ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.add(index, builderForValue.build()); onChanged(); } else { this.s2CCardSuitBuilder_.addMessage(index, builderForValue.build()); }  return this; } public Builder addAllS2CCardSuit(Iterable<? extends CardHandler.CardSuit> values) { if (this.s2CCardSuitBuilder_ == null) { ensureS2CCardSuitIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CCardSuit_); onChanged(); } else { this.s2CCardSuitBuilder_.addAllMessages(values); }  return this; } public Builder clearS2CCardSuit() { if (this.s2CCardSuitBuilder_ == null) { this.s2CCardSuit_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFDF; onChanged(); } else { this.s2CCardSuitBuilder_.clear(); }  return this; } public Builder removeS2CCardSuit(int index) { if (this.s2CCardSuitBuilder_ == null) { ensureS2CCardSuitIsMutable(); this.s2CCardSuit_.remove(index); onChanged(); } else { this.s2CCardSuitBuilder_.remove(index); }  return this; } public CardHandler.CardSuit.Builder getS2CCardSuitBuilder(int index) { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().getBuilder(index); } public CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int index) { if (this.s2CCardSuitBuilder_ == null) return this.s2CCardSuit_.get(index);  return (CardHandler.CardSuitOrBuilder)this.s2CCardSuitBuilder_.getMessageOrBuilder(index); } public List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList() { if (this.s2CCardSuitBuilder_ != null) return this.s2CCardSuitBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CCardSuit_); } public CardHandler.CardSuit.Builder addS2CCardSuitBuilder() { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(CardHandler.CardSuit.getDefaultInstance()); } public CardHandler.CardSuit.Builder addS2CCardSuitBuilder(int index) { return (CardHandler.CardSuit.Builder)getS2CCardSuitFieldBuilder().addBuilder(index, CardHandler.CardSuit.getDefaultInstance()); } public List<CardHandler.CardSuit.Builder> getS2CCardSuitBuilderList() { return getS2CCardSuitFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<CardHandler.CardSuit, CardHandler.CardSuit.Builder, CardHandler.CardSuitOrBuilder> getS2CCardSuitFieldBuilder() { if (this.s2CCardSuitBuilder_ == null) { this.s2CCardSuitBuilder_ = new RepeatedFieldBuilder(this.s2CCardSuit_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean()); this.s2CCardSuit_ = null; }  return this.s2CCardSuitBuilder_; } }
/* 18883 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 18888 */     String[] descriptorData = { "\n\021cardHandler.proto\022\013pomelo.area\")\n\023CardRegisterRequest\022\022\n\nc2s_cardId\030\001 \002(\005\"0\n\022CardLevelUpRequest\022\032\n\022c2s_cardTemplateId\030\001 \002(\005\"3\n\025CardPreLevelUpRequest\022\032\n\022c2s_cardTemplateId\030\001 \002(\005\"*\n\023CardGetAwardRequest\022\023\n\013c2s_awardId\030\001 \002(\005\";\n\020CardEquipRequest\022\022\n\nc2s_cardId\030\001 \002(\005\022\023\n\013c2s_holePos\030\002 \002(\005\"\031\n\027CardQueryAllDataRequest\"h\n\025cardRelationAttStruct\022\f\n\004name\030\001 \002(\t\022\013\n\003des\030\002 \002(\t\022\017\n\007attName\030\003 \002(\t\022\020\n\battValue\030\004 \002(\005\022\021\n", "\tcondition\030\005 \002(\005\"T\n\022CardPropertyStruct\022\017\n\007describ\030\001 \002(\t\022\r\n\005value\030\002 \001(\005\022\020\n\bmaxValue\030\003 \001(\005\022\f\n\004name\030\004 \001(\t\"å\003\n\004Card\022\n\n\002id\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\020\n\bisActive\030\003 \002(\005\022\020\n\binUsePos\030\004 \002(\005\022\013\n\003pic\030\005 \002(\005\022\r\n\005level\030\006 \002(\005\022\020\n\bmaxLevel\030\007 \002(\005\022\017\n\007quality\030\b \002(\005\022\023\n\013qualityName\030\t \002(\t\022\020\n\bcardType\030\n \002(\005\022\020\n\btypeName\030\013 \002(\t\022\020\n\bsuitType\030\f \002(\005\022\017\n\007suitDes\030\r \002(\t\0220\n\007baseAtt\030\016 \002(\0132\037.pomelo.area.CardPropertyStruct\0229\n\020baseAttNextLevel\030\017", " \002(\0132\037.pomelo.area.CardPropertyStruct\0228\n\frelationAtt1\030\020 \002(\0132\".pomelo.area.cardRelationAttStruct\0228\n\frelationAtt2\030\021 \002(\0132\".pomelo.area.cardRelationAttStruct\022\025\n\rlevelUpItemId\030\022 \002(\005\022\f\n\004from\030\023 \002(\t\"m\n\bCardHole\022\013\n\003pos\030\001 \002(\005\022\017\n\007quality\030\002 \002(\005\022\016\n\006cardId\030\003 \002(\005\022\016\n\006status\030\004 \002(\005\022\023\n\013unLockLevel\030\005 \002(\005\022\016\n\006taskId\030\006 \002(\005\"q\n\tCardAward\022\020\n\btargetId\030\001 \002(\005\022\016\n\006status\030\002 \002(\005\022\013\n\003des\030\003 \002(\t\022\020\n\bcardType\030\004 \002(\005\022\022\n\ncollectNum\030\005 \002(\005\022", "\017\n\007awardId\030\006 \002(\005\"ç\001\n\bCardSuit\022\016\n\006suitId\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\013\n\003num\030\003 \002(\005\022\017\n\007itemid1\030\004 \002(\005\022\017\n\007itemid2\030\005 \002(\005\022\017\n\007itemid3\030\006 \002(\005\022\017\n\007itemid4\030\007 \002(\005\022\017\n\007itemid5\030\b \002(\005\022\017\n\007itemid6\030\t \002(\005\022\r\n\005story\030\n \002(\t\022\025\n\rsuitSkillName\030\013 \002(\t\022\024\n\fsuitskillDes\030\f \002(\t\022\016\n\006buffId\030\r \002(\005\"ç\001\n\024CardRegisterResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\bs2c_card\030\003 \003(\0132\021.pomelo.area.Card\022+\n\fs2c_cardHole\030\004 \003(\0132\025.pomelo.area.CardHole\022-\n\rs2c_", "cardAward\030\005 \003(\0132\026.pomelo.area.CardAward\022+\n\fs2c_cardSuit\030\006 \003(\0132\025.pomelo.area.CardSuit\"]\n\023CardLevelUpResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\bs2c_card\030\003 \002(\0132\021.pomelo.area.Card\"`\n\026CardPreLevelUpResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\bs2c_card\030\003 \002(\0132\021.pomelo.area.Card\"9\n\024CardGetAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"ä\001\n\021CardEquipResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\bs2c", "_card\030\003 \003(\0132\021.pomelo.area.Card\022+\n\fs2c_cardHole\030\004 \003(\0132\025.pomelo.area.CardHole\022-\n\rs2c_cardAward\030\005 \003(\0132\026.pomelo.area.CardAward\022+\n\fs2c_cardSuit\030\006 \003(\0132\025.pomelo.area.CardSuit\"ë\001\n\030CardQueryAllDataResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\bs2c_card\030\003 \003(\0132\021.pomelo.area.Card\022+\n\fs2c_cardHole\030\004 \003(\0132\025.pomelo.area.CardHole\022-\n\rs2c_cardAward\030\005 \003(\0132\026.pomelo.area.CardAward\022+\n\fs2c_cardSuit\030\006 \003(\0132\025.pomelo.area.Car", "dSuit2»\004\n\013cardHandler\022Z\n\023cardRegisterRequest\022 .pomelo.area.CardRegisterRequest\032!.pomelo.area.CardRegisterResponse\022W\n\022cardLevelUpRequest\022\037.pomelo.area.CardLevelUpRequest\032 .pomelo.area.CardLevelUpResponse\022`\n\025cardPreLevelUpRequest\022\".pomelo.area.CardPreLevelUpRequest\032#.pomelo.area.CardPreLevelUpResponse\022Z\n\023cardGetAwardRequest\022 .pomelo.area.CardGetAwardRequest\032!.pomelo.area.CardGetAwardResponse\022Q\n\020card", "EquipRequest\022\035.pomelo.area.CardEquipRequest\032\036.pomelo.area.CardEquipResponse\022f\n\027cardQueryAllDataRequest\022$.pomelo.area.CardQueryAllDataRequest\032%.pomelo.area.CardQueryAllDataResponse" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 18965 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 18969 */           CardHandler.descriptor = root;
/* 18970 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 18974 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*       */   }
/*       */ 
/*       */   
/* 18978 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardRegisterRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 18979 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardRegisterRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardRegisterRequest_descriptor, new String[] { "C2SCardId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 18984 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardLevelUpRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 18985 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardLevelUpRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardLevelUpRequest_descriptor, new String[] { "C2SCardTemplateId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 18990 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardPreLevelUpRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 18991 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardPreLevelUpRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardPreLevelUpRequest_descriptor, new String[] { "C2SCardTemplateId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 18996 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardGetAwardRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 18997 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardGetAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardGetAwardRequest_descriptor, new String[] { "C2SAwardId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19002 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardEquipRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 19003 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardEquipRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardEquipRequest_descriptor, new String[] { "C2SCardId", "C2SHolePos" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19008 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardQueryAllDataRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 19009 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardQueryAllDataRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardQueryAllDataRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19014 */   private static final Descriptors.Descriptor internal_static_pomelo_area_cardRelationAttStruct_descriptor = getDescriptor().getMessageTypes().get(6);
/* 19015 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_cardRelationAttStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_cardRelationAttStruct_descriptor, new String[] { "Name", "Des", "AttName", "AttValue", "Condition" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19020 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardPropertyStruct_descriptor = getDescriptor().getMessageTypes().get(7);
/* 19021 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardPropertyStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardPropertyStruct_descriptor, new String[] { "Describ", "Value", "MaxValue", "Name" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19026 */   private static final Descriptors.Descriptor internal_static_pomelo_area_Card_descriptor = getDescriptor().getMessageTypes().get(8);
/* 19027 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Card_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Card_descriptor, new String[] { "Id", "Name", "IsActive", "InUsePos", "Pic", "Level", "MaxLevel", "Quality", "QualityName", "CardType", "TypeName", "SuitType", "SuitDes", "BaseAtt", "BaseAttNextLevel", "RelationAtt1", "RelationAtt2", "LevelUpItemId", "From" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19032 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardHole_descriptor = getDescriptor().getMessageTypes().get(9);
/* 19033 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardHole_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardHole_descriptor, new String[] { "Pos", "Quality", "CardId", "Status", "UnLockLevel", "TaskId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19038 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardAward_descriptor = getDescriptor().getMessageTypes().get(10);
/* 19039 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardAward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardAward_descriptor, new String[] { "TargetId", "Status", "Des", "CardType", "CollectNum", "AwardId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19044 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardSuit_descriptor = getDescriptor().getMessageTypes().get(11);
/* 19045 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardSuit_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardSuit_descriptor, new String[] { "SuitId", "Name", "Num", "Itemid1", "Itemid2", "Itemid3", "Itemid4", "Itemid5", "Itemid6", "Story", "SuitSkillName", "SuitskillDes", "BuffId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19050 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardRegisterResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 19051 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardRegisterResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardRegisterResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCard", "S2CCardHole", "S2CCardAward", "S2CCardSuit" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19056 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardLevelUpResponse_descriptor = getDescriptor().getMessageTypes().get(13);
/* 19057 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardLevelUpResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardLevelUpResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCard" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19062 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardPreLevelUpResponse_descriptor = getDescriptor().getMessageTypes().get(14);
/* 19063 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardPreLevelUpResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardPreLevelUpResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCard" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19068 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardGetAwardResponse_descriptor = getDescriptor().getMessageTypes().get(15);
/* 19069 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardGetAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardGetAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19074 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardEquipResponse_descriptor = getDescriptor().getMessageTypes().get(16);
/* 19075 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardEquipResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardEquipResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCard", "S2CCardHole", "S2CCardAward", "S2CCardSuit" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19080 */   private static final Descriptors.Descriptor internal_static_pomelo_area_CardQueryAllDataResponse_descriptor = getDescriptor().getMessageTypes().get(17);
/* 19081 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CardQueryAllDataResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CardQueryAllDataResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCard", "S2CCardHole", "S2CCardAward", "S2CCardSuit" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   public static interface CardQueryAllDataResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<CardHandler.Card> getS2CCardList();
/*       */     
/*       */     CardHandler.Card getS2CCard(int param1Int);
/*       */     
/*       */     int getS2CCardCount();
/*       */     
/*       */     List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList();
/*       */     
/*       */     CardHandler.CardOrBuilder getS2CCardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardHole> getS2CCardHoleList();
/*       */     
/*       */     CardHandler.CardHole getS2CCardHole(int param1Int);
/*       */     
/*       */     int getS2CCardHoleCount();
/*       */     
/*       */     List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList();
/*       */     
/*       */     CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardAward> getS2CCardAwardList();
/*       */     
/*       */     CardHandler.CardAward getS2CCardAward(int param1Int);
/*       */     
/*       */     int getS2CCardAwardCount();
/*       */     
/*       */     List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList();
/*       */     
/*       */     CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardSuit> getS2CCardSuitList();
/*       */     
/*       */     CardHandler.CardSuit getS2CCardSuit(int param1Int);
/*       */     
/*       */     int getS2CCardSuitCount();
/*       */     
/*       */     List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList();
/*       */     
/*       */     CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface CardEquipResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<CardHandler.Card> getS2CCardList();
/*       */     
/*       */     CardHandler.Card getS2CCard(int param1Int);
/*       */     
/*       */     int getS2CCardCount();
/*       */     
/*       */     List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList();
/*       */     
/*       */     CardHandler.CardOrBuilder getS2CCardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardHole> getS2CCardHoleList();
/*       */     
/*       */     CardHandler.CardHole getS2CCardHole(int param1Int);
/*       */     
/*       */     int getS2CCardHoleCount();
/*       */     
/*       */     List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList();
/*       */     
/*       */     CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardAward> getS2CCardAwardList();
/*       */     
/*       */     CardHandler.CardAward getS2CCardAward(int param1Int);
/*       */     
/*       */     int getS2CCardAwardCount();
/*       */     
/*       */     List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList();
/*       */     
/*       */     CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardSuit> getS2CCardSuitList();
/*       */     
/*       */     CardHandler.CardSuit getS2CCardSuit(int param1Int);
/*       */     
/*       */     int getS2CCardSuitCount();
/*       */     
/*       */     List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList();
/*       */     
/*       */     CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface CardGetAwardResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface CardPreLevelUpResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CCard();
/*       */     
/*       */     CardHandler.Card getS2CCard();
/*       */     
/*       */     CardHandler.CardOrBuilder getS2CCardOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface CardLevelUpResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CCard();
/*       */     
/*       */     CardHandler.Card getS2CCard();
/*       */     
/*       */     CardHandler.CardOrBuilder getS2CCardOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface CardRegisterResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<CardHandler.Card> getS2CCardList();
/*       */     
/*       */     CardHandler.Card getS2CCard(int param1Int);
/*       */     
/*       */     int getS2CCardCount();
/*       */     
/*       */     List<? extends CardHandler.CardOrBuilder> getS2CCardOrBuilderList();
/*       */     
/*       */     CardHandler.CardOrBuilder getS2CCardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardHole> getS2CCardHoleList();
/*       */     
/*       */     CardHandler.CardHole getS2CCardHole(int param1Int);
/*       */     
/*       */     int getS2CCardHoleCount();
/*       */     
/*       */     List<? extends CardHandler.CardHoleOrBuilder> getS2CCardHoleOrBuilderList();
/*       */     
/*       */     CardHandler.CardHoleOrBuilder getS2CCardHoleOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardAward> getS2CCardAwardList();
/*       */     
/*       */     CardHandler.CardAward getS2CCardAward(int param1Int);
/*       */     
/*       */     int getS2CCardAwardCount();
/*       */     
/*       */     List<? extends CardHandler.CardAwardOrBuilder> getS2CCardAwardOrBuilderList();
/*       */     
/*       */     CardHandler.CardAwardOrBuilder getS2CCardAwardOrBuilder(int param1Int);
/*       */     
/*       */     List<CardHandler.CardSuit> getS2CCardSuitList();
/*       */     
/*       */     CardHandler.CardSuit getS2CCardSuit(int param1Int);
/*       */     
/*       */     int getS2CCardSuitCount();
/*       */     
/*       */     List<? extends CardHandler.CardSuitOrBuilder> getS2CCardSuitOrBuilderList();
/*       */     
/*       */     CardHandler.CardSuitOrBuilder getS2CCardSuitOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface CardSuitOrBuilder extends MessageOrBuilder {
/*       */     boolean hasSuitId();
/*       */     
/*       */     int getSuitId();
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
/*       */     boolean hasItemid1();
/*       */     
/*       */     int getItemid1();
/*       */     
/*       */     boolean hasItemid2();
/*       */     
/*       */     int getItemid2();
/*       */     
/*       */     boolean hasItemid3();
/*       */     
/*       */     int getItemid3();
/*       */     
/*       */     boolean hasItemid4();
/*       */     
/*       */     int getItemid4();
/*       */     
/*       */     boolean hasItemid5();
/*       */     
/*       */     int getItemid5();
/*       */     
/*       */     boolean hasItemid6();
/*       */     
/*       */     int getItemid6();
/*       */     
/*       */     boolean hasStory();
/*       */     
/*       */     String getStory();
/*       */     
/*       */     ByteString getStoryBytes();
/*       */     
/*       */     boolean hasSuitSkillName();
/*       */     
/*       */     String getSuitSkillName();
/*       */     
/*       */     ByteString getSuitSkillNameBytes();
/*       */     
/*       */     boolean hasSuitskillDes();
/*       */     
/*       */     String getSuitskillDes();
/*       */     
/*       */     ByteString getSuitskillDesBytes();
/*       */     
/*       */     boolean hasBuffId();
/*       */     
/*       */     int getBuffId();
/*       */   }
/*       */   
/*       */   public static interface CardAwardOrBuilder extends MessageOrBuilder {
/*       */     boolean hasTargetId();
/*       */     
/*       */     int getTargetId();
/*       */     
/*       */     boolean hasStatus();
/*       */     
/*       */     int getStatus();
/*       */     
/*       */     boolean hasDes();
/*       */     
/*       */     String getDes();
/*       */     
/*       */     ByteString getDesBytes();
/*       */     
/*       */     boolean hasCardType();
/*       */     
/*       */     int getCardType();
/*       */     
/*       */     boolean hasCollectNum();
/*       */     
/*       */     int getCollectNum();
/*       */     
/*       */     boolean hasAwardId();
/*       */     
/*       */     int getAwardId();
/*       */   }
/*       */   
/*       */   public static interface CardHoleOrBuilder extends MessageOrBuilder {
/*       */     boolean hasPos();
/*       */     
/*       */     int getPos();
/*       */     
/*       */     boolean hasQuality();
/*       */     
/*       */     int getQuality();
/*       */     
/*       */     boolean hasCardId();
/*       */     
/*       */     int getCardId();
/*       */     
/*       */     boolean hasStatus();
/*       */     
/*       */     int getStatus();
/*       */     
/*       */     boolean hasUnLockLevel();
/*       */     
/*       */     int getUnLockLevel();
/*       */     
/*       */     boolean hasTaskId();
/*       */     
/*       */     int getTaskId();
/*       */   }
/*       */   
/*       */   public static interface CardOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasIsActive();
/*       */     
/*       */     int getIsActive();
/*       */     
/*       */     boolean hasInUsePos();
/*       */     
/*       */     int getInUsePos();
/*       */     
/*       */     boolean hasPic();
/*       */     
/*       */     int getPic();
/*       */     
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */     
/*       */     boolean hasQuality();
/*       */     
/*       */     int getQuality();
/*       */     
/*       */     boolean hasQualityName();
/*       */     
/*       */     String getQualityName();
/*       */     
/*       */     ByteString getQualityNameBytes();
/*       */     
/*       */     boolean hasCardType();
/*       */     
/*       */     int getCardType();
/*       */     
/*       */     boolean hasTypeName();
/*       */     
/*       */     String getTypeName();
/*       */     
/*       */     ByteString getTypeNameBytes();
/*       */     
/*       */     boolean hasSuitType();
/*       */     
/*       */     int getSuitType();
/*       */     
/*       */     boolean hasSuitDes();
/*       */     
/*       */     String getSuitDes();
/*       */     
/*       */     ByteString getSuitDesBytes();
/*       */     
/*       */     boolean hasBaseAtt();
/*       */     
/*       */     CardHandler.CardPropertyStruct getBaseAtt();
/*       */     
/*       */     CardHandler.CardPropertyStructOrBuilder getBaseAttOrBuilder();
/*       */     
/*       */     boolean hasBaseAttNextLevel();
/*       */     
/*       */     CardHandler.CardPropertyStruct getBaseAttNextLevel();
/*       */     
/*       */     CardHandler.CardPropertyStructOrBuilder getBaseAttNextLevelOrBuilder();
/*       */     
/*       */     boolean hasRelationAtt1();
/*       */     
/*       */     CardHandler.cardRelationAttStruct getRelationAtt1();
/*       */     
/*       */     CardHandler.cardRelationAttStructOrBuilder getRelationAtt1OrBuilder();
/*       */     
/*       */     boolean hasRelationAtt2();
/*       */     
/*       */     CardHandler.cardRelationAttStruct getRelationAtt2();
/*       */     
/*       */     CardHandler.cardRelationAttStructOrBuilder getRelationAtt2OrBuilder();
/*       */     
/*       */     boolean hasLevelUpItemId();
/*       */     
/*       */     int getLevelUpItemId();
/*       */     
/*       */     boolean hasFrom();
/*       */     
/*       */     String getFrom();
/*       */     
/*       */     ByteString getFromBytes();
/*       */   }
/*       */   
/*       */   public static interface CardPropertyStructOrBuilder extends MessageOrBuilder {
/*       */     boolean hasDescrib();
/*       */     
/*       */     String getDescrib();
/*       */     
/*       */     ByteString getDescribBytes();
/*       */     
/*       */     boolean hasValue();
/*       */     
/*       */     int getValue();
/*       */     
/*       */     boolean hasMaxValue();
/*       */     
/*       */     int getMaxValue();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */   }
/*       */   
/*       */   public static interface cardRelationAttStructOrBuilder extends MessageOrBuilder {
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasDes();
/*       */     
/*       */     String getDes();
/*       */     
/*       */     ByteString getDesBytes();
/*       */     
/*       */     boolean hasAttName();
/*       */     
/*       */     String getAttName();
/*       */     
/*       */     ByteString getAttNameBytes();
/*       */     
/*       */     boolean hasAttValue();
/*       */     
/*       */     int getAttValue();
/*       */     
/*       */     boolean hasCondition();
/*       */     
/*       */     int getCondition();
/*       */   }
/*       */   
/*       */   public static interface CardQueryAllDataRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface CardEquipRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SCardId();
/*       */     
/*       */     int getC2SCardId();
/*       */     
/*       */     boolean hasC2SHolePos();
/*       */     
/*       */     int getC2SHolePos();
/*       */   }
/*       */   
/*       */   public static interface CardGetAwardRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SAwardId();
/*       */     
/*       */     int getC2SAwardId();
/*       */   }
/*       */   
/*       */   public static interface CardPreLevelUpRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SCardTemplateId();
/*       */     
/*       */     int getC2SCardTemplateId();
/*       */   }
/*       */   
/*       */   public static interface CardLevelUpRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SCardTemplateId();
/*       */     
/*       */     int getC2SCardTemplateId();
/*       */   }
/*       */   
/*       */   public static interface CardRegisterRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SCardId();
/*       */     
/*       */     int getC2SCardId();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\CardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */