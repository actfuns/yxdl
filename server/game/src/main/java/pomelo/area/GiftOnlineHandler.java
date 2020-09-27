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
/*      */ import com.google.protobuf.SingleFieldBuilder;
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
/*      */ public final class GiftOnlineHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetOnLineGiftRequest
/*      */     extends GeneratedMessage
/*      */     implements GetOnLineGiftRequestOrBuilder
/*      */   {
/*  317 */     private static final GetOnLineGiftRequest defaultInstance = new GetOnLineGiftRequest(true); private final UnknownFieldSet unknownFields; private GetOnLineGiftRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetOnLineGiftRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetOnLineGiftRequest getDefaultInstance() { return defaultInstance; } public GetOnLineGiftRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetOnLineGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnLineGiftRequest.class, Builder.class); } public static Parser<GetOnLineGiftRequest> PARSER = (Parser<GetOnLineGiftRequest>)new AbstractParser<GetOnLineGiftRequest>() { public GiftOnlineHandler.GetOnLineGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GiftOnlineHandler.GetOnLineGiftRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetOnLineGiftRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetOnLineGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetOnLineGiftRequest)PARSER.parseFrom(data); } public static GetOnLineGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOnLineGiftRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetOnLineGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetOnLineGiftRequest)PARSER.parseFrom(data); } public static GetOnLineGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOnLineGiftRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetOnLineGiftRequest parseFrom(InputStream input) throws IOException { return (GetOnLineGiftRequest)PARSER.parseFrom(input); } public static GetOnLineGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetOnLineGiftRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetOnLineGiftRequest)PARSER.parseDelimitedFrom(input); } public static GetOnLineGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetOnLineGiftRequest parseFrom(CodedInputStream input) throws IOException { return (GetOnLineGiftRequest)PARSER.parseFrom(input); } public static GetOnLineGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetOnLineGiftRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GiftOnlineHandler.GetOnLineGiftRequestOrBuilder {
/*  318 */       public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnlineHandler.GetOnLineGiftRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GiftOnlineHandler.GetOnLineGiftRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftRequest_descriptor; } public GiftOnlineHandler.GetOnLineGiftRequest getDefaultInstanceForType() { return GiftOnlineHandler.GetOnLineGiftRequest.getDefaultInstance(); } public GiftOnlineHandler.GetOnLineGiftRequest build() { GiftOnlineHandler.GetOnLineGiftRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GiftOnlineHandler.GetOnLineGiftRequest buildPartial() { GiftOnlineHandler.GetOnLineGiftRequest result = new GiftOnlineHandler.GetOnLineGiftRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GiftOnlineHandler.GetOnLineGiftRequest) return mergeFrom((GiftOnlineHandler.GetOnLineGiftRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GiftOnlineHandler.GetOnLineGiftRequest other) { if (other == GiftOnlineHandler.GetOnLineGiftRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GiftOnlineHandler.GetOnLineGiftRequest parsedMessage = null; try { parsedMessage = (GiftOnlineHandler.GetOnLineGiftRequest)GiftOnlineHandler.GetOnLineGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GiftOnlineHandler.GetOnLineGiftRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GiftOnLineStruct
/*      */     extends GeneratedMessage
/*      */     implements GiftOnLineStructOrBuilder
/*      */   {
/* 1145 */     private static final GiftOnLineStruct defaultInstance = new GiftOnLineStruct(true); private final UnknownFieldSet unknownFields; private GiftOnLineStruct(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GiftOnLineStruct(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GiftOnLineStruct getDefaultInstance() { return defaultInstance; } public GiftOnLineStruct getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GiftOnLineStruct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.templateId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.count_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.quality_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.picId_ = input.readInt32(); break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.name_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GiftOnLineStruct_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GiftOnLineStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnLineStruct.class, Builder.class); } public static Parser<GiftOnLineStruct> PARSER = (Parser<GiftOnLineStruct>)new AbstractParser<GiftOnLineStruct>() { public GiftOnlineHandler.GiftOnLineStruct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GiftOnlineHandler.GiftOnLineStruct(input, extensionRegistry); } }
/* 1146 */     ; private int bitField0_; public static final int TEMPLATEID_FIELD_NUMBER = 1; private int templateId_; public static final int COUNT_FIELD_NUMBER = 2; private int count_; public static final int QUALITY_FIELD_NUMBER = 3; private int quality_; public static final int PICID_FIELD_NUMBER = 4; private int picId_; public static final int NAME_FIELD_NUMBER = 5; private Object name_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GiftOnLineStruct> getParserForType() { return PARSER; } public boolean hasTemplateId() { return ((this.bitField0_ & 0x1) == 1); } public int getTemplateId() { return this.templateId_; } public boolean hasCount() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getCount() {
/*      */       return this.count_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasQuality() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getQuality() {
/*      */       return this.quality_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasPicId() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getPicId() {
/*      */       return this.picId_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasName() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/*      */       Object ref = this.name_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.name_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getNameBytes() {
/*      */       Object ref = this.name_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.name_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.templateId_ = 0;
/*      */       this.count_ = 0;
/*      */       this.quality_ = 0;
/*      */       this.picId_ = 0;
/*      */       this.name_ = "";
/*      */     }
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
/*      */       if (!hasTemplateId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasCount()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasQuality()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasPicId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasName()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.templateId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.count_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeInt32(3, this.quality_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeInt32(4, this.picId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         output.writeBytes(5, getNameBytes());
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.templateId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.count_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeInt32Size(3, this.quality_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeInt32Size(4, this.picId_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         size += CodedOutputStream.computeBytesSize(5, getNameBytes());
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(InputStream input) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnLineStruct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnLineStruct)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(GiftOnLineStruct prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements GiftOnlineHandler.GiftOnLineStructOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int templateId_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int count_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int quality_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int picId_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object name_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnLineStruct_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnLineStruct_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnlineHandler.GiftOnLineStruct.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.name_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.name_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (GiftOnlineHandler.GiftOnLineStruct.alwaysUseFieldBuilders);
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
/*      */         this.templateId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.count_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.quality_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.picId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.name_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFEF;
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
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnLineStruct_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct getDefaultInstanceForType() {
/*      */         return GiftOnlineHandler.GiftOnLineStruct.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct build() {
/*      */         GiftOnlineHandler.GiftOnLineStruct result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct buildPartial() {
/*      */         GiftOnlineHandler.GiftOnLineStruct result = new GiftOnlineHandler.GiftOnLineStruct(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.templateId_ = this.templateId_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.count_ = this.count_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.quality_ = this.quality_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.picId_ = this.picId_;
/*      */         if ((from_bitField0_ & 0x10) == 16) {
/*      */           to_bitField0_ |= 0x10;
/*      */         }
/*      */         result.name_ = this.name_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof GiftOnlineHandler.GiftOnLineStruct) {
/*      */           return mergeFrom((GiftOnlineHandler.GiftOnLineStruct)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(GiftOnlineHandler.GiftOnLineStruct other) {
/*      */         if (other == GiftOnlineHandler.GiftOnLineStruct.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasTemplateId()) {
/*      */           setTemplateId(other.getTemplateId());
/*      */         }
/*      */         if (other.hasCount()) {
/*      */           setCount(other.getCount());
/*      */         }
/*      */         if (other.hasQuality()) {
/*      */           setQuality(other.getQuality());
/*      */         }
/*      */         if (other.hasPicId()) {
/*      */           setPicId(other.getPicId());
/*      */         }
/*      */         if (other.hasName()) {
/*      */           this.bitField0_ |= 0x10;
/*      */           this.name_ = other.name_;
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
/*      */         if (!hasTemplateId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasCount()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasQuality()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasPicId()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasName()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         GiftOnlineHandler.GiftOnLineStruct parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (GiftOnlineHandler.GiftOnLineStruct)GiftOnlineHandler.GiftOnLineStruct.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (GiftOnlineHandler.GiftOnLineStruct)e.getUnfinishedMessage();
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
/*      */       public boolean hasTemplateId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getTemplateId() {
/*      */         return this.templateId_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setTemplateId(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.templateId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearTemplateId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.templateId_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasCount() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getCount() {
/*      */         return this.count_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setCount(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.count_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearCount() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.count_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasQuality() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getQuality() {
/*      */         return this.quality_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setQuality(int value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.quality_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearQuality() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.quality_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasPicId() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getPicId() {
/*      */         return this.picId_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPicId(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.picId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearPicId() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.picId_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasName() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getName() {
/*      */         Object ref = this.name_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.name_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getNameBytes() {
/*      */         Object ref = this.name_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.name_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setName(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x10;
/*      */         this.name_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearName() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.name_ = GiftOnlineHandler.GiftOnLineStruct.getDefaultInstance().getName();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setNameBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x10;
/*      */         this.name_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GiftOnlineData
/*      */     extends GeneratedMessage
/*      */     implements GiftOnlineDataOrBuilder
/*      */   {
/* 1922 */     private static final GiftOnlineData defaultInstance = new GiftOnlineData(true); private final UnknownFieldSet unknownFields; private GiftOnlineData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GiftOnlineData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GiftOnlineData getDefaultInstance() { return defaultInstance; } public GiftOnlineData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GiftOnlineData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CTime_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.s2CItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.s2CItems_.add(input.readMessage(GiftOnlineHandler.GiftOnLineStruct.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GiftOnlineData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GiftOnlineData_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnlineData.class, Builder.class); } public static Parser<GiftOnlineData> PARSER = (Parser<GiftOnlineData>)new AbstractParser<GiftOnlineData>() { public GiftOnlineHandler.GiftOnlineData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GiftOnlineHandler.GiftOnlineData(input, extensionRegistry); } }
/* 1923 */     ; private int bitField0_; public static final int S2C_TIME_FIELD_NUMBER = 1; private int s2CTime_; public static final int S2C_ITEMS_FIELD_NUMBER = 2; private List<GiftOnlineHandler.GiftOnLineStruct> s2CItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GiftOnlineData> getParserForType() { return PARSER; } public boolean hasS2CTime() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CTime() { return this.s2CTime_; } public List<GiftOnlineHandler.GiftOnLineStruct> getS2CItemsList() { return this.s2CItems_; } public List<? extends GiftOnlineHandler.GiftOnLineStructOrBuilder> getS2CItemsOrBuilderList() { return (List)this.s2CItems_; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getS2CItemsCount() {
/*      */       return this.s2CItems_.size();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public GiftOnlineHandler.GiftOnLineStruct getS2CItems(int index) {
/*      */       return this.s2CItems_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public GiftOnlineHandler.GiftOnLineStructOrBuilder getS2CItemsOrBuilder(int index) {
/*      */       return this.s2CItems_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CTime_ = 0;
/*      */       this.s2CItems_ = Collections.emptyList();
/*      */     }
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
/*      */       if (!hasS2CTime()) {
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
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.s2CTime_);
/*      */       }
/*      */       for (int i = 0; i < this.s2CItems_.size(); i++) {
/*      */         output.writeMessage(2, (MessageLite)this.s2CItems_.get(i));
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CTime_);
/*      */       }
/*      */       for (int i = 0; i < this.s2CItems_.size(); i++) {
/*      */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.s2CItems_.get(i));
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(InputStream input) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static GiftOnlineData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GiftOnlineData)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(GiftOnlineData prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements GiftOnlineHandler.GiftOnlineDataOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int s2CTime_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private List<GiftOnlineHandler.GiftOnLineStruct> s2CItems_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<GiftOnlineHandler.GiftOnLineStruct, GiftOnlineHandler.GiftOnLineStruct.Builder, GiftOnlineHandler.GiftOnLineStructOrBuilder> s2CItemsBuilder_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnlineData_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnlineData_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnlineHandler.GiftOnlineData.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CItems_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CItems_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (GiftOnlineHandler.GiftOnlineData.alwaysUseFieldBuilders) {
/*      */           getS2CItemsFieldBuilder();
/*      */         }
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CTime_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItems_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFD;
/*      */         } else {
/*      */           this.s2CItemsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return GiftOnlineHandler.internal_static_pomelo_area_GiftOnlineData_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnlineData getDefaultInstanceForType() {
/*      */         return GiftOnlineHandler.GiftOnlineData.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnlineData build() {
/*      */         GiftOnlineHandler.GiftOnlineData result = buildPartial();
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
/*      */       public GiftOnlineHandler.GiftOnlineData buildPartial() {
/*      */         GiftOnlineHandler.GiftOnlineData result = new GiftOnlineHandler.GiftOnlineData(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.s2CTime_ = this.s2CTime_;
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x2) == 2) {
/*      */             this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
/*      */             this.bitField0_ &= 0xFFFFFFFD;
/*      */           } 
/*      */           result.s2CItems_ = this.s2CItems_;
/*      */         } else {
/*      */           result.s2CItems_ = this.s2CItemsBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof GiftOnlineHandler.GiftOnlineData) {
/*      */           return mergeFrom((GiftOnlineHandler.GiftOnlineData)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(GiftOnlineHandler.GiftOnlineData other) {
/*      */         if (other == GiftOnlineHandler.GiftOnlineData.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasS2CTime()) {
/*      */           setS2CTime(other.getS2CTime());
/*      */         }
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (!other.s2CItems_.isEmpty()) {
/*      */             if (this.s2CItems_.isEmpty()) {
/*      */               this.s2CItems_ = other.s2CItems_;
/*      */               this.bitField0_ &= 0xFFFFFFFD;
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
/*      */             this.bitField0_ &= 0xFFFFFFFD;
/*      */             this.s2CItemsBuilder_ = GiftOnlineHandler.GiftOnlineData.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CTime()) {
/*      */           return false;
/*      */         }
/*      */         for (int i = 0; i < getS2CItemsCount(); i++) {
/*      */           if (!getS2CItems(i).isInitialized()) {
/*      */             return false;
/*      */           }
/*      */         } 
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         GiftOnlineHandler.GiftOnlineData parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (GiftOnlineHandler.GiftOnlineData)GiftOnlineHandler.GiftOnlineData.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (GiftOnlineHandler.GiftOnlineData)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CTime() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CTime() {
/*      */         return this.s2CTime_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CTime(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CTime_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CTime() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CTime_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void ensureS2CItemsIsMutable() {
/*      */         if ((this.bitField0_ & 0x2) != 2) {
/*      */           this.s2CItems_ = new ArrayList<>(this.s2CItems_);
/*      */           this.bitField0_ |= 0x2;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<GiftOnlineHandler.GiftOnLineStruct> getS2CItemsList() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           return Collections.unmodifiableList(this.s2CItems_);
/*      */         }
/*      */         return this.s2CItemsBuilder_.getMessageList();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CItemsCount() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           return this.s2CItems_.size();
/*      */         }
/*      */         return this.s2CItemsBuilder_.getCount();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct getS2CItems(int index) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           return this.s2CItems_.get(index);
/*      */         }
/*      */         return (GiftOnlineHandler.GiftOnLineStruct)this.s2CItemsBuilder_.getMessage(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CItems(int index, GiftOnlineHandler.GiftOnLineStruct value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setS2CItems(int index, GiftOnlineHandler.GiftOnLineStruct.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CItems(GiftOnlineHandler.GiftOnLineStruct value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CItems(int index, GiftOnlineHandler.GiftOnLineStruct value) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CItems(GiftOnlineHandler.GiftOnLineStruct.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addS2CItems(int index, GiftOnlineHandler.GiftOnLineStruct.Builder builderForValue) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           this.s2CItems_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAllS2CItems(Iterable<? extends GiftOnlineHandler.GiftOnLineStruct> values) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           ensureS2CItemsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CItems_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearS2CItems() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItems_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFD;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CItemsBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
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
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct.Builder getS2CItemsBuilder(int index) {
/*      */         return (GiftOnlineHandler.GiftOnLineStruct.Builder)getS2CItemsFieldBuilder().getBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStructOrBuilder getS2CItemsOrBuilder(int index) {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           return this.s2CItems_.get(index);
/*      */         }
/*      */         return (GiftOnlineHandler.GiftOnLineStructOrBuilder)this.s2CItemsBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<? extends GiftOnlineHandler.GiftOnLineStructOrBuilder> getS2CItemsOrBuilderList() {
/*      */         if (this.s2CItemsBuilder_ != null) {
/*      */           return this.s2CItemsBuilder_.getMessageOrBuilderList();
/*      */         }
/*      */         return Collections.unmodifiableList((List)this.s2CItems_);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct.Builder addS2CItemsBuilder() {
/*      */         return (GiftOnlineHandler.GiftOnLineStruct.Builder)getS2CItemsFieldBuilder().addBuilder(GiftOnlineHandler.GiftOnLineStruct.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public GiftOnlineHandler.GiftOnLineStruct.Builder addS2CItemsBuilder(int index) {
/*      */         return (GiftOnlineHandler.GiftOnLineStruct.Builder)getS2CItemsFieldBuilder().addBuilder(index, GiftOnlineHandler.GiftOnLineStruct.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<GiftOnlineHandler.GiftOnLineStruct.Builder> getS2CItemsBuilderList() {
/*      */         return getS2CItemsFieldBuilder().getBuilderList();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<GiftOnlineHandler.GiftOnLineStruct, GiftOnlineHandler.GiftOnLineStruct.Builder, GiftOnlineHandler.GiftOnLineStructOrBuilder> getS2CItemsFieldBuilder() {
/*      */         if (this.s2CItemsBuilder_ == null) {
/*      */           this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*      */           this.s2CItems_ = null;
/*      */         } 
/*      */         return this.s2CItemsBuilder_;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GetOnLineGiftResponse
/*      */     extends GeneratedMessage
/*      */     implements GetOnLineGiftResponseOrBuilder
/*      */   {
/* 2685 */     private static final GetOnLineGiftResponse defaultInstance = new GetOnLineGiftResponse(true); private final UnknownFieldSet unknownFields; private GetOnLineGiftResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetOnLineGiftResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetOnLineGiftResponse getDefaultInstance() { return defaultInstance; } public GetOnLineGiftResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetOnLineGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; GiftOnlineHandler.GiftOnlineData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (GiftOnlineHandler.GiftOnlineData)input.readMessage(GiftOnlineHandler.GiftOnlineData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnLineGiftResponse.class, Builder.class); } public static Parser<GetOnLineGiftResponse> PARSER = (Parser<GetOnLineGiftResponse>)new AbstractParser<GetOnLineGiftResponse>() { public GiftOnlineHandler.GetOnLineGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GiftOnlineHandler.GetOnLineGiftResponse(input, extensionRegistry); } }
/* 2686 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private GiftOnlineHandler.GiftOnlineData s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetOnLineGiftResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public GiftOnlineHandler.GiftOnlineData getS2CData() { return this.s2CData_; } public GiftOnlineHandler.GiftOnlineDataOrBuilder getS2CDataOrBuilder() { return this.s2CData_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CData_ = GiftOnlineHandler.GiftOnlineData.getDefaultInstance(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (hasS2CData() && !getS2CData().isInitialized()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite)this.s2CData_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetOnLineGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetOnLineGiftResponse)PARSER.parseFrom(data); } public static GetOnLineGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOnLineGiftResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetOnLineGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetOnLineGiftResponse)PARSER.parseFrom(data); } public static GetOnLineGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetOnLineGiftResponse)PARSER.parseFrom(data, extensionRegistry); } static { defaultInstance.initFields(); }
/*      */     public static GetOnLineGiftResponse parseFrom(InputStream input) throws IOException { return (GetOnLineGiftResponse)PARSER.parseFrom(input); }
/*      */     public static GetOnLineGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static GetOnLineGiftResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetOnLineGiftResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static GetOnLineGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static GetOnLineGiftResponse parseFrom(CodedInputStream input) throws IOException { return (GetOnLineGiftResponse)PARSER.parseFrom(input); }
/*      */     public static GetOnLineGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetOnLineGiftResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(GetOnLineGiftResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements GiftOnlineHandler.GetOnLineGiftResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private GiftOnlineHandler.GiftOnlineData s2CData_;
/*      */       private SingleFieldBuilder<GiftOnlineHandler.GiftOnlineData, GiftOnlineHandler.GiftOnlineData.Builder, GiftOnlineHandler.GiftOnlineDataOrBuilder> s2CDataBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftOnlineHandler.GetOnLineGiftResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CData_ = GiftOnlineHandler.GiftOnlineData.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CData_ = GiftOnlineHandler.GiftOnlineData.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (GiftOnlineHandler.GetOnLineGiftResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CDataBuilder_ == null) { this.s2CData_ = GiftOnlineHandler.GiftOnlineData.getDefaultInstance(); } else { this.s2CDataBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return GiftOnlineHandler.internal_static_pomelo_area_GetOnLineGiftResponse_descriptor; }
/*      */       public GiftOnlineHandler.GetOnLineGiftResponse getDefaultInstanceForType() { return GiftOnlineHandler.GetOnLineGiftResponse.getDefaultInstance(); }
/*      */       public GiftOnlineHandler.GetOnLineGiftResponse build() { GiftOnlineHandler.GetOnLineGiftResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GiftOnlineHandler.GetOnLineGiftResponse buildPartial() { GiftOnlineHandler.GetOnLineGiftResponse result = new GiftOnlineHandler.GetOnLineGiftResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  if (this.s2CDataBuilder_ == null) { result.s2CData_ = this.s2CData_; } else { result.s2CData_ = (GiftOnlineHandler.GiftOnlineData)this.s2CDataBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GiftOnlineHandler.GetOnLineGiftResponse) return mergeFrom((GiftOnlineHandler.GetOnLineGiftResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GiftOnlineHandler.GetOnLineGiftResponse other) { if (other == GiftOnlineHandler.GetOnLineGiftResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CData()) mergeS2CData(other.getS2CData());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (hasS2CData() && !getS2CData().isInitialized()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GiftOnlineHandler.GetOnLineGiftResponse parsedMessage = null; try { parsedMessage = (GiftOnlineHandler.GetOnLineGiftResponse)GiftOnlineHandler.GetOnLineGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GiftOnlineHandler.GetOnLineGiftResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = GiftOnlineHandler.GetOnLineGiftResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public GiftOnlineHandler.GiftOnlineData getS2CData() { if (this.s2CDataBuilder_ == null) return this.s2CData_;  return (GiftOnlineHandler.GiftOnlineData)this.s2CDataBuilder_.getMessage(); } public Builder setS2CData(GiftOnlineHandler.GiftOnlineData value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  this.s2CData_ = value; onChanged(); } else { this.s2CDataBuilder_.setMessage(value); }  this.bitField0_ |= 0x4; return this; } public Builder setS2CData(GiftOnlineHandler.GiftOnlineData.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { this.s2CData_ = builderForValue.build(); onChanged(); } else { this.s2CDataBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x4; return this; } public Builder mergeS2CData(GiftOnlineHandler.GiftOnlineData value) { if (this.s2CDataBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != GiftOnlineHandler.GiftOnlineData.getDefaultInstance()) { this.s2CData_ = GiftOnlineHandler.GiftOnlineData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial(); } else { this.s2CData_ = value; }  onChanged(); } else { this.s2CDataBuilder_.mergeFrom(value); }  this.bitField0_ |= 0x4; return this; } public Builder clearS2CData() { if (this.s2CDataBuilder_ == null) { this.s2CData_ = GiftOnlineHandler.GiftOnlineData.getDefaultInstance(); onChanged(); } else { this.s2CDataBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFFB; return this; } public GiftOnlineHandler.GiftOnlineData.Builder getS2CDataBuilder() { this.bitField0_ |= 0x4; onChanged(); return (GiftOnlineHandler.GiftOnlineData.Builder)getS2CDataFieldBuilder().getBuilder(); } public GiftOnlineHandler.GiftOnlineDataOrBuilder getS2CDataOrBuilder() { if (this.s2CDataBuilder_ != null) return (GiftOnlineHandler.GiftOnlineDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder();  return this.s2CData_; } private SingleFieldBuilder<GiftOnlineHandler.GiftOnlineData, GiftOnlineHandler.GiftOnlineData.Builder, GiftOnlineHandler.GiftOnlineDataOrBuilder> getS2CDataFieldBuilder() { if (this.s2CDataBuilder_ == null) { this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean()); this.s2CData_ = null; }  return this.s2CDataBuilder_; } }
/* 2715 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 2720 */     String[] descriptorData = { "\n\027giftOnlineHandler.proto\022\013pomelo.area\"\026\n\024GetOnLineGiftRequest\"c\n\020GiftOnLineStruct\022\022\n\ntemplateId\030\001 \002(\005\022\r\n\005count\030\002 \002(\005\022\017\n\007quality\030\003 \002(\005\022\r\n\005picId\030\004 \002(\005\022\f\n\004name\030\005 \002(\t\"T\n\016GiftOnlineData\022\020\n\bs2c_time\030\001 \002(\005\0220\n\ts2c_items\030\002 \003(\0132\035.pomelo.area.GiftOnLineStruct\"i\n\025GetOnLineGiftResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_data\030\003 \001(\0132\033.pomelo.area.GiftOnlineData2r\n\021giftOnlineHandler\022]\n\024getOnLineGiftReques", "t\022!.pomelo.area.GetOnLineGiftRequest\032\".pomelo.area.GetOnLineGiftResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2734 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 2738 */           GiftOnlineHandler.descriptor = root;
/* 2739 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 2743 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*      */   }
/*      */ 
/*      */   
/* 2747 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetOnLineGiftRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 2748 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOnLineGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOnLineGiftRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2753 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GiftOnLineStruct_descriptor = getDescriptor().getMessageTypes().get(1);
/* 2754 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GiftOnLineStruct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GiftOnLineStruct_descriptor, new String[] { "TemplateId", "Count", "Quality", "PicId", "Name" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2759 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GiftOnlineData_descriptor = getDescriptor().getMessageTypes().get(2);
/* 2760 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GiftOnlineData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GiftOnlineData_descriptor, new String[] { "S2CTime", "S2CItems" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2765 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetOnLineGiftResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 2766 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOnLineGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOnLineGiftResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   public static interface GetOnLineGiftResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CData();
/*      */     
/*      */     GiftOnlineHandler.GiftOnlineData getS2CData();
/*      */     
/*      */     GiftOnlineHandler.GiftOnlineDataOrBuilder getS2CDataOrBuilder();
/*      */   }
/*      */   
/*      */   public static interface GiftOnlineDataOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CTime();
/*      */     
/*      */     int getS2CTime();
/*      */     
/*      */     List<GiftOnlineHandler.GiftOnLineStruct> getS2CItemsList();
/*      */     
/*      */     GiftOnlineHandler.GiftOnLineStruct getS2CItems(int param1Int);
/*      */     
/*      */     int getS2CItemsCount();
/*      */     
/*      */     List<? extends GiftOnlineHandler.GiftOnLineStructOrBuilder> getS2CItemsOrBuilderList();
/*      */     
/*      */     GiftOnlineHandler.GiftOnLineStructOrBuilder getS2CItemsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GiftOnLineStructOrBuilder extends MessageOrBuilder {
/*      */     boolean hasTemplateId();
/*      */     
/*      */     int getTemplateId();
/*      */     
/*      */     boolean hasCount();
/*      */     
/*      */     int getCount();
/*      */     
/*      */     boolean hasQuality();
/*      */     
/*      */     int getQuality();
/*      */     
/*      */     boolean hasPicId();
/*      */     
/*      */     int getPicId();
/*      */     
/*      */     boolean hasName();
/*      */     
/*      */     String getName();
/*      */     
/*      */     ByteString getNameBytes();
/*      */   }
/*      */   
/*      */   public static interface GetOnLineGiftRequestOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\GiftOnlineHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */