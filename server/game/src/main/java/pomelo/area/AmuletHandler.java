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
/*      */ import pomelo.Common;
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
/*      */ public final class AmuletHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetAllAmuletDetailReq
/*      */     extends GeneratedMessage
/*      */     implements GetAllAmuletDetailReqOrBuilder
/*      */   {
/*  317 */     private static final GetAllAmuletDetailReq defaultInstance = new GetAllAmuletDetailReq(true); private final UnknownFieldSet unknownFields; private GetAllAmuletDetailReq(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetAllAmuletDetailReq(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetAllAmuletDetailReq getDefaultInstance() { return defaultInstance; } public GetAllAmuletDetailReq getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetAllAmuletDetailReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllAmuletDetailReq.class, Builder.class); } public static Parser<GetAllAmuletDetailReq> PARSER = (Parser<GetAllAmuletDetailReq>)new AbstractParser<GetAllAmuletDetailReq>() { public AmuletHandler.GetAllAmuletDetailReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.GetAllAmuletDetailReq(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetAllAmuletDetailReq> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetAllAmuletDetailReq parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetAllAmuletDetailReq)PARSER.parseFrom(data); } public static GetAllAmuletDetailReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllAmuletDetailReq)PARSER.parseFrom(data, extensionRegistry); } public static GetAllAmuletDetailReq parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetAllAmuletDetailReq)PARSER.parseFrom(data); } public static GetAllAmuletDetailReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllAmuletDetailReq)PARSER.parseFrom(data, extensionRegistry); } public static GetAllAmuletDetailReq parseFrom(InputStream input) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseFrom(input); } public static GetAllAmuletDetailReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseFrom(input, extensionRegistry); } public static GetAllAmuletDetailReq parseDelimitedFrom(InputStream input) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseDelimitedFrom(input); } public static GetAllAmuletDetailReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetAllAmuletDetailReq parseFrom(CodedInputStream input) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseFrom(input); } public static GetAllAmuletDetailReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailReq)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetAllAmuletDetailReq prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.GetAllAmuletDetailReqOrBuilder {
/*  318 */       public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.GetAllAmuletDetailReq.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.GetAllAmuletDetailReq.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailReq_descriptor; } public AmuletHandler.GetAllAmuletDetailReq getDefaultInstanceForType() { return AmuletHandler.GetAllAmuletDetailReq.getDefaultInstance(); } public AmuletHandler.GetAllAmuletDetailReq build() { AmuletHandler.GetAllAmuletDetailReq result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.GetAllAmuletDetailReq buildPartial() { AmuletHandler.GetAllAmuletDetailReq result = new AmuletHandler.GetAllAmuletDetailReq(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.GetAllAmuletDetailReq) return mergeFrom((AmuletHandler.GetAllAmuletDetailReq)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.GetAllAmuletDetailReq other) { if (other == AmuletHandler.GetAllAmuletDetailReq.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.GetAllAmuletDetailReq parsedMessage = null; try { parsedMessage = (AmuletHandler.GetAllAmuletDetailReq)AmuletHandler.GetAllAmuletDetailReq.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.GetAllAmuletDetailReq)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GetAllAmuletDetailRes
/*      */     extends GeneratedMessage
/*      */     implements GetAllAmuletDetailResOrBuilder
/*      */   {
/* 1407 */     private static final GetAllAmuletDetailRes defaultInstance = new GetAllAmuletDetailRes(true); private final UnknownFieldSet unknownFields; private GetAllAmuletDetailRes(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetAllAmuletDetailRes(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetAllAmuletDetailRes getDefaultInstance() { return defaultInstance; } public GetAllAmuletDetailRes getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetAllAmuletDetailRes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalCount_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CMaxCount_ = input.readInt32(); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CData_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailRes_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllAmuletDetailRes.class, Builder.class); } public static Parser<GetAllAmuletDetailRes> PARSER = (Parser<GetAllAmuletDetailRes>)new AbstractParser<GetAllAmuletDetailRes>() { public AmuletHandler.GetAllAmuletDetailRes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.GetAllAmuletDetailRes(input, extensionRegistry); } }
/* 1408 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALCOUNT_FIELD_NUMBER = 3; private int s2CTotalCount_; public static final int S2C_MAXCOUNT_FIELD_NUMBER = 4; private int s2CMaxCount_; public static final int S2C_DATA_FIELD_NUMBER = 5; private List<ItemOuterClass.ItemDetail> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetAllAmuletDetailRes> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public List<ItemOuterClass.ItemDetail> getS2CDataList() { return this.s2CData_; } public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() { return (List)this.s2CData_; } public int getS2CDataCount() { return this.s2CData_.size(); } public ItemOuterClass.ItemDetail getS2CData(int index) { return this.s2CData_.get(index); } public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) { return (ItemOuterClass.ItemDetailOrBuilder)this.s2CData_.get(index); } private void initFields() { this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CTotalCount_ = 0;
/*      */       this.s2CMaxCount_ = 0;
/*      */       this.s2CData_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
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
/*      */       return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(3, this.s2CTotalCount_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeInt32(4, this.s2CMaxCount_); 
/*      */       for (int i = 0; i < this.s2CData_.size(); i++)
/*      */         output.writeMessage(5, (MessageLite)this.s2CData_.get(i)); 
/*      */       getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(3, this.s2CTotalCount_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeInt32Size(4, this.s2CMaxCount_); 
/*      */       for (int i = 0; i < this.s2CData_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CData_.get(i)); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetAllAmuletDetailRes parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetAllAmuletDetailRes)PARSER.parseFrom(data); } public static GetAllAmuletDetailRes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllAmuletDetailRes)PARSER.parseFrom(data, extensionRegistry); } public static GetAllAmuletDetailRes parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetAllAmuletDetailRes)PARSER.parseFrom(data); } public static GetAllAmuletDetailRes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetAllAmuletDetailRes)PARSER.parseFrom(data, extensionRegistry); } public static GetAllAmuletDetailRes parseFrom(InputStream input) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseFrom(input); } public static GetAllAmuletDetailRes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseFrom(input, extensionRegistry); } public static GetAllAmuletDetailRes parseDelimitedFrom(InputStream input) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseDelimitedFrom(input); } public static GetAllAmuletDetailRes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetAllAmuletDetailRes parseFrom(CodedInputStream input) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseFrom(input); } public static GetAllAmuletDetailRes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetAllAmuletDetailRes)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetAllAmuletDetailRes prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*      */       return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.GetAllAmuletDetailResOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CTotalCount_; private int s2CMaxCount_; private List<ItemOuterClass.ItemDetail> s2CData_; private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> s2CDataBuilder_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailRes_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.GetAllAmuletDetailRes.class, Builder.class); } private Builder() { this.s2CMsg_ = "";
/*      */         this.s2CData_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CData_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.GetAllAmuletDetailRes.alwaysUseFieldBuilders)
/*      */           getS2CDataFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CTotalCount_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CMaxCount_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CData_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */         } else {
/*      */           this.s2CDataBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_GetAllAmuletDetailRes_descriptor; }
/*      */       public AmuletHandler.GetAllAmuletDetailRes getDefaultInstanceForType() { return AmuletHandler.GetAllAmuletDetailRes.getDefaultInstance(); }
/*      */       public AmuletHandler.GetAllAmuletDetailRes build() { AmuletHandler.GetAllAmuletDetailRes result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result; }
/*      */       public AmuletHandler.GetAllAmuletDetailRes buildPartial() { AmuletHandler.GetAllAmuletDetailRes result = new AmuletHandler.GetAllAmuletDetailRes(this);
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
/*      */         result.s2CTotalCount_ = this.s2CTotalCount_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.s2CMaxCount_ = this.s2CMaxCount_;
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x10) == 16) {
/*      */             this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
/*      */             this.bitField0_ &= 0xFFFFFFEF;
/*      */           } 
/*      */           result.s2CData_ = this.s2CData_;
/*      */         } else {
/*      */           result.s2CData_ = this.s2CDataBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.GetAllAmuletDetailRes)
/*      */           return mergeFrom((AmuletHandler.GetAllAmuletDetailRes)other); 
/*      */         super.mergeFrom(other);
/*      */         return this; }
/*      */       public Builder mergeFrom(AmuletHandler.GetAllAmuletDetailRes other) { if (other == AmuletHandler.GetAllAmuletDetailRes.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CTotalCount())
/*      */           setS2CTotalCount(other.getS2CTotalCount()); 
/*      */         if (other.hasS2CMaxCount())
/*      */           setS2CMaxCount(other.getS2CMaxCount()); 
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (!other.s2CData_.isEmpty()) {
/*      */             if (this.s2CData_.isEmpty()) {
/*      */               this.s2CData_ = other.s2CData_;
/*      */               this.bitField0_ &= 0xFFFFFFEF;
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
/*      */             this.bitField0_ &= 0xFFFFFFEF;
/*      */             this.s2CDataBuilder_ = AmuletHandler.GetAllAmuletDetailRes.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CDataBuilder_.addAllMessages(other.s2CData_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false; 
/*      */         for (int i = 0; i < getS2CDataCount(); i++) {
/*      */           if (!getS2CData(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.GetAllAmuletDetailRes parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (AmuletHandler.GetAllAmuletDetailRes)AmuletHandler.GetAllAmuletDetailRes.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (AmuletHandler.GetAllAmuletDetailRes)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
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
/*      */       public ByteString getS2CMsgBytes() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = AmuletHandler.GetAllAmuletDetailRes.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CTotalCount() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       public int getS2CTotalCount() {
/*      */         return this.s2CTotalCount_;
/*      */       }
/*      */       public Builder setS2CTotalCount(int value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CTotalCount_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CTotalCount() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CTotalCount_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CMaxCount() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       public int getS2CMaxCount() {
/*      */         return this.s2CMaxCount_;
/*      */       }
/*      */       public Builder setS2CMaxCount(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.s2CMaxCount_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CMaxCount() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CMaxCount_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       private void ensureS2CDataIsMutable() {
/*      */         if ((this.bitField0_ & 0x10) != 16) {
/*      */           this.s2CData_ = new ArrayList<>(this.s2CData_);
/*      */           this.bitField0_ |= 0x10;
/*      */         } 
/*      */       }
/*      */       public List<ItemOuterClass.ItemDetail> getS2CDataList() {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CData_); 
/*      */         return this.s2CDataBuilder_.getMessageList();
/*      */       }
/*      */       public int getS2CDataCount() {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return this.s2CData_.size(); 
/*      */         return this.s2CDataBuilder_.getCount();
/*      */       }
/*      */       public ItemOuterClass.ItemDetail getS2CData(int index) {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return this.s2CData_.get(index); 
/*      */         return (ItemOuterClass.ItemDetail)this.s2CDataBuilder_.getMessage(index);
/*      */       }
/*      */       public Builder setS2CData(int index, ItemOuterClass.ItemDetail value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CData(ItemOuterClass.ItemDetail value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CData(int index, ItemOuterClass.ItemDetail value) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CData(ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           this.s2CData_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ItemDetail> values) {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           ensureS2CDataIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CData_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CData() {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CData_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDataBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
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
/*      */       public ItemOuterClass.ItemDetail.Builder getS2CDataBuilder(int index) {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().getBuilder(index);
/*      */       }
/*      */       public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) {
/*      */         if (this.s2CDataBuilder_ == null)
/*      */           return (ItemOuterClass.ItemDetailOrBuilder)this.s2CData_.get(index); 
/*      */         return (ItemOuterClass.ItemDetailOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() {
/*      */         if (this.s2CDataBuilder_ != null)
/*      */           return this.s2CDataBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CData_);
/*      */       }
/*      */       public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder() {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance());
/*      */       }
/*      */       public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder(int index) {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance());
/*      */       }
/*      */       public List<ItemOuterClass.ItemDetail.Builder> getS2CDataBuilderList() {
/*      */         return getS2CDataFieldBuilder().getBuilderList();
/*      */       }
/*      */       private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getS2CDataFieldBuilder() {
/*      */         if (this.s2CDataBuilder_ == null) {
/*      */           this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*      */           this.s2CData_ = null;
/*      */         } 
/*      */         return this.s2CDataBuilder_;
/*      */       } } }
/* 1812 */   public static final class EquipAmuletReq extends GeneratedMessage implements EquipAmuletReqOrBuilder { private static final EquipAmuletReq defaultInstance = new EquipAmuletReq(true); private final UnknownFieldSet unknownFields; private EquipAmuletReq(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipAmuletReq(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipAmuletReq getDefaultInstance() { return defaultInstance; } public EquipAmuletReq getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipAmuletReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SGridIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipAmuletReq.class, Builder.class); } public static Parser<EquipAmuletReq> PARSER = (Parser<EquipAmuletReq>)new AbstractParser<EquipAmuletReq>() { public AmuletHandler.EquipAmuletReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.EquipAmuletReq(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_GRIDINDEX_FIELD_NUMBER = 1; private int c2SGridIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipAmuletReq> getParserForType() { return PARSER; } public boolean hasC2SGridIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SGridIndex() { return this.c2SGridIndex_; } private void initFields() { this.c2SGridIndex_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SGridIndex()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SGridIndex_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SGridIndex_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static EquipAmuletReq parseFrom(ByteString data) throws InvalidProtocolBufferException { return (EquipAmuletReq)PARSER.parseFrom(data); } public static EquipAmuletReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static EquipAmuletReq parseFrom(byte[] data) throws InvalidProtocolBufferException { return (EquipAmuletReq)PARSER.parseFrom(data); } public static EquipAmuletReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static EquipAmuletReq parseFrom(InputStream input) throws IOException { return (EquipAmuletReq)PARSER.parseFrom(input); } public static EquipAmuletReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static EquipAmuletReq parseDelimitedFrom(InputStream input) throws IOException { return (EquipAmuletReq)PARSER.parseDelimitedFrom(input); } public static EquipAmuletReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletReq)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static EquipAmuletReq parseFrom(CodedInputStream input) throws IOException { return (EquipAmuletReq)PARSER.parseFrom(input); } public static EquipAmuletReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(EquipAmuletReq prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.EquipAmuletReqOrBuilder {
/* 1813 */       private int bitField0_; private int c2SGridIndex_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.EquipAmuletReq.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.EquipAmuletReq.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SGridIndex_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletReq_descriptor; } public AmuletHandler.EquipAmuletReq getDefaultInstanceForType() { return AmuletHandler.EquipAmuletReq.getDefaultInstance(); } public AmuletHandler.EquipAmuletReq build() { AmuletHandler.EquipAmuletReq result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.EquipAmuletReq buildPartial() { AmuletHandler.EquipAmuletReq result = new AmuletHandler.EquipAmuletReq(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SGridIndex_ = this.c2SGridIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.EquipAmuletReq) return mergeFrom((AmuletHandler.EquipAmuletReq)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.EquipAmuletReq other) { if (other == AmuletHandler.EquipAmuletReq.getDefaultInstance()) return this;  if (other.hasC2SGridIndex()) setC2SGridIndex(other.getC2SGridIndex());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SGridIndex()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.EquipAmuletReq parsedMessage = null; try { parsedMessage = (AmuletHandler.EquipAmuletReq)AmuletHandler.EquipAmuletReq.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.EquipAmuletReq)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SGridIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SGridIndex() { return this.c2SGridIndex_; } public Builder setC2SGridIndex(int value) { this.bitField0_ |= 0x1; this.c2SGridIndex_ = value; onChanged(); return this; } public Builder clearC2SGridIndex() { this.bitField0_ &= 0xFFFFFFFE; this.c2SGridIndex_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
/*      */      }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class UnEquipAmuletReq
/*      */     extends GeneratedMessage
/*      */     implements UnEquipAmuletReqOrBuilder
/*      */   {
/* 2296 */     private static final UnEquipAmuletReq defaultInstance = new UnEquipAmuletReq(true); private final UnknownFieldSet unknownFields; private UnEquipAmuletReq(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnEquipAmuletReq(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnEquipAmuletReq getDefaultInstance() { return defaultInstance; } public UnEquipAmuletReq getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnEquipAmuletReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SGridIndex_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UnEquipAmuletReq.class, Builder.class); } public static Parser<UnEquipAmuletReq> PARSER = (Parser<UnEquipAmuletReq>)new AbstractParser<UnEquipAmuletReq>() { public AmuletHandler.UnEquipAmuletReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.UnEquipAmuletReq(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_GRIDINDEX_FIELD_NUMBER = 1; private Object c2SGridIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnEquipAmuletReq> getParserForType() { return PARSER; } public boolean hasC2SGridIndex() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SGridIndex() { Object ref = this.c2SGridIndex_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SGridIndex_ = s;  return s; } public ByteString getC2SGridIndexBytes() { Object ref = this.c2SGridIndex_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SGridIndex_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.c2SGridIndex_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SGridIndex()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SGridIndexBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SGridIndexBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UnEquipAmuletReq parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UnEquipAmuletReq)PARSER.parseFrom(data); } public static UnEquipAmuletReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnEquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static UnEquipAmuletReq parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UnEquipAmuletReq)PARSER.parseFrom(data); } public static UnEquipAmuletReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnEquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static UnEquipAmuletReq parseFrom(InputStream input) throws IOException { return (UnEquipAmuletReq)PARSER.parseFrom(input); } public static UnEquipAmuletReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static UnEquipAmuletReq parseDelimitedFrom(InputStream input) throws IOException { return (UnEquipAmuletReq)PARSER.parseDelimitedFrom(input); } public static UnEquipAmuletReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletReq)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnEquipAmuletReq parseFrom(CodedInputStream input) throws IOException { return (UnEquipAmuletReq)PARSER.parseFrom(input); } public static UnEquipAmuletReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnEquipAmuletReq prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.UnEquipAmuletReqOrBuilder {
/* 2297 */       private int bitField0_; private Object c2SGridIndex_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.UnEquipAmuletReq.class, Builder.class); } private Builder() { this.c2SGridIndex_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.c2SGridIndex_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.UnEquipAmuletReq.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SGridIndex_ = ""; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletReq_descriptor; } public AmuletHandler.UnEquipAmuletReq getDefaultInstanceForType() { return AmuletHandler.UnEquipAmuletReq.getDefaultInstance(); } public AmuletHandler.UnEquipAmuletReq build() { AmuletHandler.UnEquipAmuletReq result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.UnEquipAmuletReq buildPartial() { AmuletHandler.UnEquipAmuletReq result = new AmuletHandler.UnEquipAmuletReq(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SGridIndex_ = this.c2SGridIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.UnEquipAmuletReq) return mergeFrom((AmuletHandler.UnEquipAmuletReq)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.UnEquipAmuletReq other) { if (other == AmuletHandler.UnEquipAmuletReq.getDefaultInstance()) return this;  if (other.hasC2SGridIndex()) { this.bitField0_ |= 0x1; this.c2SGridIndex_ = other.c2SGridIndex_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SGridIndex()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.UnEquipAmuletReq parsedMessage = null; try { parsedMessage = (AmuletHandler.UnEquipAmuletReq)AmuletHandler.UnEquipAmuletReq.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.UnEquipAmuletReq)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SGridIndex() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SGridIndex() { Object ref = this.c2SGridIndex_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SGridIndex_ = s;  return s; }  return (String)ref; } public ByteString getC2SGridIndexBytes() { Object ref = this.c2SGridIndex_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SGridIndex_ = b; return b; }  return (ByteString)ref; } public Builder setC2SGridIndex(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.c2SGridIndex_ = value; onChanged(); return this; } public Builder clearC2SGridIndex() { this.bitField0_ &= 0xFFFFFFFE; this.c2SGridIndex_ = AmuletHandler.UnEquipAmuletReq.getDefaultInstance().getC2SGridIndex(); onChanged(); return this; } public Builder setC2SGridIndexBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.c2SGridIndex_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class UnAllEquipAmuletReq
/*      */     extends GeneratedMessage
/*      */     implements UnAllEquipAmuletReqOrBuilder
/*      */   {
/* 2609 */     private static final UnAllEquipAmuletReq defaultInstance = new UnAllEquipAmuletReq(true); private final UnknownFieldSet unknownFields; private UnAllEquipAmuletReq(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnAllEquipAmuletReq(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnAllEquipAmuletReq getDefaultInstance() { return defaultInstance; } public UnAllEquipAmuletReq getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnAllEquipAmuletReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(UnAllEquipAmuletReq.class, Builder.class); } public static Parser<UnAllEquipAmuletReq> PARSER = (Parser<UnAllEquipAmuletReq>)new AbstractParser<UnAllEquipAmuletReq>() { public AmuletHandler.UnAllEquipAmuletReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.UnAllEquipAmuletReq(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnAllEquipAmuletReq> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UnAllEquipAmuletReq parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UnAllEquipAmuletReq)PARSER.parseFrom(data); } public static UnAllEquipAmuletReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnAllEquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static UnAllEquipAmuletReq parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UnAllEquipAmuletReq)PARSER.parseFrom(data); } public static UnAllEquipAmuletReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnAllEquipAmuletReq)PARSER.parseFrom(data, extensionRegistry); } public static UnAllEquipAmuletReq parseFrom(InputStream input) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseFrom(input); } public static UnAllEquipAmuletReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static UnAllEquipAmuletReq parseDelimitedFrom(InputStream input) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseDelimitedFrom(input); } public static UnAllEquipAmuletReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnAllEquipAmuletReq parseFrom(CodedInputStream input) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseFrom(input); } public static UnAllEquipAmuletReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletReq)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnAllEquipAmuletReq prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.UnAllEquipAmuletReqOrBuilder {
/* 2610 */       public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletReq_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.UnAllEquipAmuletReq.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.UnAllEquipAmuletReq.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletReq_descriptor; } public AmuletHandler.UnAllEquipAmuletReq getDefaultInstanceForType() { return AmuletHandler.UnAllEquipAmuletReq.getDefaultInstance(); } public AmuletHandler.UnAllEquipAmuletReq build() { AmuletHandler.UnAllEquipAmuletReq result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.UnAllEquipAmuletReq buildPartial() { AmuletHandler.UnAllEquipAmuletReq result = new AmuletHandler.UnAllEquipAmuletReq(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.UnAllEquipAmuletReq) return mergeFrom((AmuletHandler.UnAllEquipAmuletReq)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.UnAllEquipAmuletReq other) { if (other == AmuletHandler.UnAllEquipAmuletReq.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.UnAllEquipAmuletReq parsedMessage = null; try { parsedMessage = (AmuletHandler.UnAllEquipAmuletReq)AmuletHandler.UnAllEquipAmuletReq.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.UnAllEquipAmuletReq)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class EquipAmuletRes
/*      */     extends GeneratedMessage
/*      */     implements EquipAmuletResOrBuilder
/*      */   {
/* 3327 */     private static final EquipAmuletRes defaultInstance = new EquipAmuletRes(true); private final UnknownFieldSet unknownFields; private EquipAmuletRes(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipAmuletRes(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipAmuletRes getDefaultInstance() { return defaultInstance; } public EquipAmuletRes getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipAmuletRes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalCount_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CMaxCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipAmuletRes.class, Builder.class); } public static Parser<EquipAmuletRes> PARSER = (Parser<EquipAmuletRes>)new AbstractParser<EquipAmuletRes>() { public AmuletHandler.EquipAmuletRes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.EquipAmuletRes(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALCOUNT_FIELD_NUMBER = 3; private int s2CTotalCount_; public static final int S2C_MAXCOUNT_FIELD_NUMBER = 4; private int s2CMaxCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipAmuletRes> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CTotalCount_ = 0; this.s2CMaxCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CMaxCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CMaxCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static EquipAmuletRes parseFrom(ByteString data) throws InvalidProtocolBufferException { return (EquipAmuletRes)PARSER.parseFrom(data); } public static EquipAmuletRes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static EquipAmuletRes parseFrom(byte[] data) throws InvalidProtocolBufferException { return (EquipAmuletRes)PARSER.parseFrom(data); } public static EquipAmuletRes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (EquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static EquipAmuletRes parseFrom(InputStream input) throws IOException { return (EquipAmuletRes)PARSER.parseFrom(input); } public static EquipAmuletRes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static EquipAmuletRes parseDelimitedFrom(InputStream input) throws IOException { return (EquipAmuletRes)PARSER.parseDelimitedFrom(input); } public static EquipAmuletRes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletRes)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static EquipAmuletRes parseFrom(CodedInputStream input) throws IOException { return (EquipAmuletRes)PARSER.parseFrom(input); } public static EquipAmuletRes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (EquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(EquipAmuletRes prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.EquipAmuletResOrBuilder {
/* 3328 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CTotalCount_; private int s2CMaxCount_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.EquipAmuletRes.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.EquipAmuletRes.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CMaxCount_ = 0; this.bitField0_ &= 0xFFFFFFF7; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_EquipAmuletRes_descriptor; } public AmuletHandler.EquipAmuletRes getDefaultInstanceForType() { return AmuletHandler.EquipAmuletRes.getDefaultInstance(); } public AmuletHandler.EquipAmuletRes build() { AmuletHandler.EquipAmuletRes result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.EquipAmuletRes buildPartial() { AmuletHandler.EquipAmuletRes result = new AmuletHandler.EquipAmuletRes(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CTotalCount_ = this.s2CTotalCount_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CMaxCount_ = this.s2CMaxCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.EquipAmuletRes) return mergeFrom((AmuletHandler.EquipAmuletRes)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.EquipAmuletRes other) { if (other == AmuletHandler.EquipAmuletRes.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CTotalCount()) setS2CTotalCount(other.getS2CTotalCount());  if (other.hasS2CMaxCount()) setS2CMaxCount(other.getS2CMaxCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.EquipAmuletRes parsedMessage = null; try { parsedMessage = (AmuletHandler.EquipAmuletRes)AmuletHandler.EquipAmuletRes.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.EquipAmuletRes)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = AmuletHandler.EquipAmuletRes.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public Builder setS2CTotalCount(int value) { this.bitField0_ |= 0x4; this.s2CTotalCount_ = value; onChanged(); return this; } public Builder clearS2CTotalCount() { this.bitField0_ &= 0xFFFFFFFB; this.s2CTotalCount_ = 0; onChanged(); return this; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public Builder setS2CMaxCount(int value) { this.bitField0_ |= 0x8; this.s2CMaxCount_ = value; onChanged(); return this; } public Builder clearS2CMaxCount() { this.bitField0_ &= 0xFFFFFFF7; this.s2CMaxCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class UnEquipAmuletRes
/*      */     extends GeneratedMessage
/*      */     implements UnEquipAmuletResOrBuilder
/*      */   {
/* 4045 */     private static final UnEquipAmuletRes defaultInstance = new UnEquipAmuletRes(true); private final UnknownFieldSet unknownFields; private UnEquipAmuletRes(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnEquipAmuletRes(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnEquipAmuletRes getDefaultInstance() { return defaultInstance; } public UnEquipAmuletRes getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnEquipAmuletRes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalCount_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CMaxCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(UnEquipAmuletRes.class, Builder.class); } public static Parser<UnEquipAmuletRes> PARSER = (Parser<UnEquipAmuletRes>)new AbstractParser<UnEquipAmuletRes>() { public AmuletHandler.UnEquipAmuletRes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.UnEquipAmuletRes(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALCOUNT_FIELD_NUMBER = 3; private int s2CTotalCount_; public static final int S2C_MAXCOUNT_FIELD_NUMBER = 4; private int s2CMaxCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnEquipAmuletRes> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CTotalCount_ = 0; this.s2CMaxCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CMaxCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CMaxCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UnEquipAmuletRes parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UnEquipAmuletRes)PARSER.parseFrom(data); } public static UnEquipAmuletRes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnEquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static UnEquipAmuletRes parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UnEquipAmuletRes)PARSER.parseFrom(data); } public static UnEquipAmuletRes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnEquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static UnEquipAmuletRes parseFrom(InputStream input) throws IOException { return (UnEquipAmuletRes)PARSER.parseFrom(input); } public static UnEquipAmuletRes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static UnEquipAmuletRes parseDelimitedFrom(InputStream input) throws IOException { return (UnEquipAmuletRes)PARSER.parseDelimitedFrom(input); } public static UnEquipAmuletRes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletRes)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnEquipAmuletRes parseFrom(CodedInputStream input) throws IOException { return (UnEquipAmuletRes)PARSER.parseFrom(input); } public static UnEquipAmuletRes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnEquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnEquipAmuletRes prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.UnEquipAmuletResOrBuilder {
/* 4046 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CTotalCount_; private int s2CMaxCount_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.UnEquipAmuletRes.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.UnEquipAmuletRes.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CMaxCount_ = 0; this.bitField0_ &= 0xFFFFFFF7; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_UnEquipAmuletRes_descriptor; } public AmuletHandler.UnEquipAmuletRes getDefaultInstanceForType() { return AmuletHandler.UnEquipAmuletRes.getDefaultInstance(); } public AmuletHandler.UnEquipAmuletRes build() { AmuletHandler.UnEquipAmuletRes result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.UnEquipAmuletRes buildPartial() { AmuletHandler.UnEquipAmuletRes result = new AmuletHandler.UnEquipAmuletRes(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CTotalCount_ = this.s2CTotalCount_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CMaxCount_ = this.s2CMaxCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.UnEquipAmuletRes) return mergeFrom((AmuletHandler.UnEquipAmuletRes)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.UnEquipAmuletRes other) { if (other == AmuletHandler.UnEquipAmuletRes.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CTotalCount()) setS2CTotalCount(other.getS2CTotalCount());  if (other.hasS2CMaxCount()) setS2CMaxCount(other.getS2CMaxCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.UnEquipAmuletRes parsedMessage = null; try { parsedMessage = (AmuletHandler.UnEquipAmuletRes)AmuletHandler.UnEquipAmuletRes.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.UnEquipAmuletRes)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = AmuletHandler.UnEquipAmuletRes.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public Builder setS2CTotalCount(int value) { this.bitField0_ |= 0x4; this.s2CTotalCount_ = value; onChanged(); return this; } public Builder clearS2CTotalCount() { this.bitField0_ &= 0xFFFFFFFB; this.s2CTotalCount_ = 0; onChanged(); return this; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public Builder setS2CMaxCount(int value) { this.bitField0_ |= 0x8; this.s2CMaxCount_ = value; onChanged(); return this; } public Builder clearS2CMaxCount() { this.bitField0_ &= 0xFFFFFFF7; this.s2CMaxCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class UnAllEquipAmuletRes
/*      */     extends GeneratedMessage
/*      */     implements UnAllEquipAmuletResOrBuilder
/*      */   {
/* 4763 */     private static final UnAllEquipAmuletRes defaultInstance = new UnAllEquipAmuletRes(true); private final UnknownFieldSet unknownFields; private UnAllEquipAmuletRes(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UnAllEquipAmuletRes(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UnAllEquipAmuletRes getDefaultInstance() { return defaultInstance; } public UnAllEquipAmuletRes getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UnAllEquipAmuletRes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalCount_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CMaxCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(UnAllEquipAmuletRes.class, Builder.class); } public static Parser<UnAllEquipAmuletRes> PARSER = (Parser<UnAllEquipAmuletRes>)new AbstractParser<UnAllEquipAmuletRes>() { public AmuletHandler.UnAllEquipAmuletRes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.UnAllEquipAmuletRes(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALCOUNT_FIELD_NUMBER = 3; private int s2CTotalCount_; public static final int S2C_MAXCOUNT_FIELD_NUMBER = 4; private int s2CMaxCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UnAllEquipAmuletRes> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CTotalCount_ = 0; this.s2CMaxCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CMaxCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CMaxCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UnAllEquipAmuletRes parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UnAllEquipAmuletRes)PARSER.parseFrom(data); } public static UnAllEquipAmuletRes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnAllEquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static UnAllEquipAmuletRes parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UnAllEquipAmuletRes)PARSER.parseFrom(data); } public static UnAllEquipAmuletRes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UnAllEquipAmuletRes)PARSER.parseFrom(data, extensionRegistry); } public static UnAllEquipAmuletRes parseFrom(InputStream input) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseFrom(input); } public static UnAllEquipAmuletRes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static UnAllEquipAmuletRes parseDelimitedFrom(InputStream input) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseDelimitedFrom(input); } public static UnAllEquipAmuletRes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UnAllEquipAmuletRes parseFrom(CodedInputStream input) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseFrom(input); } public static UnAllEquipAmuletRes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UnAllEquipAmuletRes)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UnAllEquipAmuletRes prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.UnAllEquipAmuletResOrBuilder {
/* 4764 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int s2CTotalCount_; private int s2CMaxCount_; public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletRes_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletRes_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.UnAllEquipAmuletRes.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (AmuletHandler.UnAllEquipAmuletRes.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CMaxCount_ = 0; this.bitField0_ &= 0xFFFFFFF7; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_UnAllEquipAmuletRes_descriptor; } public AmuletHandler.UnAllEquipAmuletRes getDefaultInstanceForType() { return AmuletHandler.UnAllEquipAmuletRes.getDefaultInstance(); } public AmuletHandler.UnAllEquipAmuletRes build() { AmuletHandler.UnAllEquipAmuletRes result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public AmuletHandler.UnAllEquipAmuletRes buildPartial() { AmuletHandler.UnAllEquipAmuletRes result = new AmuletHandler.UnAllEquipAmuletRes(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CTotalCount_ = this.s2CTotalCount_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CMaxCount_ = this.s2CMaxCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.UnAllEquipAmuletRes) return mergeFrom((AmuletHandler.UnAllEquipAmuletRes)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(AmuletHandler.UnAllEquipAmuletRes other) { if (other == AmuletHandler.UnAllEquipAmuletRes.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CTotalCount()) setS2CTotalCount(other.getS2CTotalCount());  if (other.hasS2CMaxCount()) setS2CMaxCount(other.getS2CMaxCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.UnAllEquipAmuletRes parsedMessage = null; try { parsedMessage = (AmuletHandler.UnAllEquipAmuletRes)AmuletHandler.UnAllEquipAmuletRes.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.UnAllEquipAmuletRes)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = AmuletHandler.UnAllEquipAmuletRes.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public Builder setS2CTotalCount(int value) { this.bitField0_ |= 0x4; this.s2CTotalCount_ = value; onChanged(); return this; } public Builder clearS2CTotalCount() { this.bitField0_ &= 0xFFFFFFFB; this.s2CTotalCount_ = 0; onChanged(); return this; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public Builder setS2CMaxCount(int value) { this.bitField0_ |= 0x8; this.s2CMaxCount_ = value; onChanged(); return this; } public Builder clearS2CMaxCount() { this.bitField0_ &= 0xFFFFFFF7; this.s2CMaxCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class AmuletEquipNewPush
/*      */     extends GeneratedMessage
/*      */     implements AmuletEquipNewPushOrBuilder
/*      */   {
/* 5853 */     private static final AmuletEquipNewPush defaultInstance = new AmuletEquipNewPush(true); private final UnknownFieldSet unknownFields; private AmuletEquipNewPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AmuletEquipNewPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AmuletEquipNewPush getDefaultInstance() { return defaultInstance; } public AmuletEquipNewPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AmuletEquipNewPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CTotalCount_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CMaxCount_ = input.readInt32(); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CData_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CData_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_AmuletEquipNewPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_AmuletEquipNewPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletEquipNewPush.class, Builder.class); } public static Parser<AmuletEquipNewPush> PARSER = (Parser<AmuletEquipNewPush>)new AbstractParser<AmuletEquipNewPush>() { public AmuletHandler.AmuletEquipNewPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new AmuletHandler.AmuletEquipNewPush(input, extensionRegistry); } }
/* 5854 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_TOTALCOUNT_FIELD_NUMBER = 3; private int s2CTotalCount_; public static final int S2C_MAXCOUNT_FIELD_NUMBER = 4; private int s2CMaxCount_; public static final int S2C_DATA_FIELD_NUMBER = 5; private List<ItemOuterClass.ItemDetail> s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AmuletEquipNewPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalCount() { return this.s2CTotalCount_; } public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public List<ItemOuterClass.ItemDetail> getS2CDataList() { return this.s2CData_; } public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() { return (List)this.s2CData_; } public int getS2CDataCount() { return this.s2CData_.size(); } public ItemOuterClass.ItemDetail getS2CData(int index) { return this.s2CData_.get(index); } public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) { return (ItemOuterClass.ItemDetailOrBuilder)this.s2CData_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CTotalCount_ = 0; this.s2CMaxCount_ = 0; this.s2CData_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CMaxCount_);  for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(5, (MessageLite)this.s2CData_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CTotalCount_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CMaxCount_);  for (int i = 0; i < this.s2CData_.size(); i++) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CData_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static AmuletEquipNewPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (AmuletEquipNewPush)PARSER.parseFrom(data); } static { defaultInstance.initFields(); }
/*      */     public static AmuletEquipNewPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (AmuletEquipNewPush)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static AmuletEquipNewPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (AmuletEquipNewPush)PARSER.parseFrom(data); }
/*      */     public static AmuletEquipNewPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (AmuletEquipNewPush)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static AmuletEquipNewPush parseFrom(InputStream input) throws IOException { return (AmuletEquipNewPush)PARSER.parseFrom(input); }
/*      */     public static AmuletEquipNewPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AmuletEquipNewPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static AmuletEquipNewPush parseDelimitedFrom(InputStream input) throws IOException { return (AmuletEquipNewPush)PARSER.parseDelimitedFrom(input); }
/*      */     public static AmuletEquipNewPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AmuletEquipNewPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static AmuletEquipNewPush parseFrom(CodedInputStream input) throws IOException { return (AmuletEquipNewPush)PARSER.parseFrom(input); }
/*      */     public static AmuletEquipNewPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AmuletEquipNewPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(AmuletEquipNewPush prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements AmuletHandler.AmuletEquipNewPushOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private int s2CTotalCount_;
/*      */       private int s2CMaxCount_;
/*      */       private List<ItemOuterClass.ItemDetail> s2CData_;
/*      */       private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> s2CDataBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return AmuletHandler.internal_static_pomelo_area_AmuletEquipNewPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return AmuletHandler.internal_static_pomelo_area_AmuletEquipNewPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AmuletHandler.AmuletEquipNewPush.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CData_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (AmuletHandler.AmuletEquipNewPush.alwaysUseFieldBuilders) getS2CDataFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CMaxCount_ = 0; this.bitField0_ &= 0xFFFFFFF7; if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; } else { this.s2CDataBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return AmuletHandler.internal_static_pomelo_area_AmuletEquipNewPush_descriptor; }
/*      */       public AmuletHandler.AmuletEquipNewPush getDefaultInstanceForType() { return AmuletHandler.AmuletEquipNewPush.getDefaultInstance(); }
/*      */       public AmuletHandler.AmuletEquipNewPush build() { AmuletHandler.AmuletEquipNewPush result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public AmuletHandler.AmuletEquipNewPush buildPartial() { AmuletHandler.AmuletEquipNewPush result = new AmuletHandler.AmuletEquipNewPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CTotalCount_ = this.s2CTotalCount_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CMaxCount_ = this.s2CMaxCount_; if (this.s2CDataBuilder_ == null) { if ((this.bitField0_ & 0x10) == 16) { this.s2CData_ = Collections.unmodifiableList(this.s2CData_); this.bitField0_ &= 0xFFFFFFEF; }  result.s2CData_ = this.s2CData_; } else { result.s2CData_ = this.s2CDataBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof AmuletHandler.AmuletEquipNewPush) return mergeFrom((AmuletHandler.AmuletEquipNewPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(AmuletHandler.AmuletEquipNewPush other) { if (other == AmuletHandler.AmuletEquipNewPush.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CTotalCount()) setS2CTotalCount(other.getS2CTotalCount());  if (other.hasS2CMaxCount()) setS2CMaxCount(other.getS2CMaxCount());  if (this.s2CDataBuilder_ == null) { if (!other.s2CData_.isEmpty()) { if (this.s2CData_.isEmpty()) { this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFEF; } else { ensureS2CDataIsMutable(); this.s2CData_.addAll(other.s2CData_); }  onChanged(); }  } else if (!other.s2CData_.isEmpty()) { if (this.s2CDataBuilder_.isEmpty()) { this.s2CDataBuilder_.dispose(); this.s2CDataBuilder_ = null; this.s2CData_ = other.s2CData_; this.bitField0_ &= 0xFFFFFFEF; this.s2CDataBuilder_ = AmuletHandler.AmuletEquipNewPush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null; } else { this.s2CDataBuilder_.addAllMessages(other.s2CData_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  for (int i = 0; i < getS2CDataCount(); i++) { if (!getS2CData(i).isInitialized()) return false;  }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { AmuletHandler.AmuletEquipNewPush parsedMessage = null; try { parsedMessage = (AmuletHandler.AmuletEquipNewPush)AmuletHandler.AmuletEquipNewPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (AmuletHandler.AmuletEquipNewPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = AmuletHandler.AmuletEquipNewPush.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public boolean hasS2CTotalCount() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getS2CTotalCount() { return this.s2CTotalCount_; }
/*      */       public Builder setS2CTotalCount(int value) { this.bitField0_ |= 0x4; this.s2CTotalCount_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CTotalCount() { this.bitField0_ &= 0xFFFFFFFB; this.s2CTotalCount_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMaxCount() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CMaxCount() { return this.s2CMaxCount_; } public Builder setS2CMaxCount(int value) { this.bitField0_ |= 0x8; this.s2CMaxCount_ = value; onChanged(); return this; } public Builder clearS2CMaxCount() { this.bitField0_ &= 0xFFFFFFF7; this.s2CMaxCount_ = 0; onChanged(); return this; } private void ensureS2CDataIsMutable() { if ((this.bitField0_ & 0x10) != 16) { this.s2CData_ = new ArrayList<>(this.s2CData_); this.bitField0_ |= 0x10; }  } public List<ItemOuterClass.ItemDetail> getS2CDataList() { if (this.s2CDataBuilder_ == null) return Collections.unmodifiableList(this.s2CData_);  return this.s2CDataBuilder_.getMessageList(); } public int getS2CDataCount() { if (this.s2CDataBuilder_ == null) return this.s2CData_.size();  return this.s2CDataBuilder_.getCount(); } public ItemOuterClass.ItemDetail getS2CData(int index) { if (this.s2CDataBuilder_ == null) return this.s2CData_.get(index);  return (ItemOuterClass.ItemDetail)this.s2CDataBuilder_.getMessage(index); } public Builder setS2CData(int index, ItemOuterClass.ItemDetail value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.set(index, value); onChanged(); } else { this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.set(index, builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CData(ItemOuterClass.ItemDetail value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(value); onChanged(); } else { this.s2CDataBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addS2CData(int index, ItemOuterClass.ItemDetail value) { if (this.s2CDataBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDataIsMutable(); this.s2CData_.add(index, value); onChanged(); } else { this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addS2CData(ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.add(index, builderForValue.build()); onChanged(); } else { this.s2CDataBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ItemDetail> values) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CData_); onChanged(); } else { this.s2CDataBuilder_.addAllMessages(values); }  return this; } public Builder clearS2CData() { if (this.s2CDataBuilder_ == null) { this.s2CData_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF; onChanged(); } else { this.s2CDataBuilder_.clear(); }  return this; } public Builder removeS2CData(int index) { if (this.s2CDataBuilder_ == null) { ensureS2CDataIsMutable(); this.s2CData_.remove(index); onChanged(); } else { this.s2CDataBuilder_.remove(index); }  return this; } public ItemOuterClass.ItemDetail.Builder getS2CDataBuilder(int index) { return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().getBuilder(index); } public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) { if (this.s2CDataBuilder_ == null) return (ItemOuterClass.ItemDetailOrBuilder)this.s2CData_.get(index);  return (ItemOuterClass.ItemDetailOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(index); } public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() { if (this.s2CDataBuilder_ != null) return this.s2CDataBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.s2CData_); } public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder() { return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance()); } public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder(int index) { return (ItemOuterClass.ItemDetail.Builder)getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance()); } public List<ItemOuterClass.ItemDetail.Builder> getS2CDataBuilderList() { return getS2CDataFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getS2CDataFieldBuilder() { if (this.s2CDataBuilder_ == null) { this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean()); this.s2CData_ = null; }  return this.s2CDataBuilder_; } }
/* 5908 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 5913 */     String[] descriptorData = { "\n\023amuletHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"\027\n\025GetAllAmuletDetailReq\"\001\n\025GetAllAmuletDetailRes\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_totalCount\030\003 \001(\005\022\024\n\fs2c_maxCount\030\004 \001(\005\022)\n\bs2c_data\030\005 \003(\0132\027.pomelo.item.ItemDetail\"'\n\016EquipAmuletReq\022\025\n\rc2s_gridIndex\030\001 \002(\005\")\n\020UnEquipAmuletReq\022\025\n\rc2s_gridIndex\030\001 \002(\t\"\025\n\023UnAllEquipAmuletReq\"a\n\016EquipAmuletRes\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s", "2c_totalCount\030\003 \001(\005\022\024\n\fs2c_maxCount\030\004 \001(\005\"c\n\020UnEquipAmuletRes\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_totalCount\030\003 \001(\005\022\024\n\fs2c_maxCount\030\004 \001(\005\"f\n\023UnAllEquipAmuletRes\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_totalCount\030\003 \001(\005\022\024\n\fs2c_maxCount\030\004 \001(\005\"\001\n\022AmuletEquipNewPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_totalCount\030\003 \001(\005\022\024\n\fs2c_maxCount\030\004 \001(\005\022)\n\bs2c_data\030\005 \003(\0132\027.pomelo.item.ItemDetail2ó\002\n\ram", "uletHandler\022]\n\023getAllAmuletRequest\022\".pomelo.area.GetAllAmuletDetailReq\032\".pomelo.area.GetAllAmuletDetailRes\022N\n\022equipAmuletRequest\022\033.pomelo.area.EquipAmuletReq\032\033.pomelo.area.EquipAmuletRes\022T\n\024unEquipAmuletRequest\022\035.pomelo.area.UnEquipAmuletReq\032\035.pomelo.area.UnEquipAmuletRes\022]\n\027unAllEquipAmuletRequest\022 .pomelo.area.UnAllEquipAmuletReq\032 .pomelo.area.UnAllEquipAmuletRes2Q\n\namuletPush\022C\n\022amuletEquipNewP", "ush\022\037.pomelo.area.AmuletEquipNewPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5947 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 5951 */           AmuletHandler.descriptor = root;
/* 5952 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 5956 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 5958 */           Common.getDescriptor(), 
/* 5959 */           ItemOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 5962 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllAmuletDetailReq_descriptor = getDescriptor().getMessageTypes().get(0);
/* 5963 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllAmuletDetailReq_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllAmuletDetailReq_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5968 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllAmuletDetailRes_descriptor = getDescriptor().getMessageTypes().get(1);
/* 5969 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllAmuletDetailRes_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllAmuletDetailRes_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalCount", "S2CMaxCount", "S2CData" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5974 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipAmuletReq_descriptor = getDescriptor().getMessageTypes().get(2);
/* 5975 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipAmuletReq_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipAmuletReq_descriptor, new String[] { "C2SGridIndex" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5980 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnEquipAmuletReq_descriptor = getDescriptor().getMessageTypes().get(3);
/* 5981 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnEquipAmuletReq_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnEquipAmuletReq_descriptor, new String[] { "C2SGridIndex" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5986 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnAllEquipAmuletReq_descriptor = getDescriptor().getMessageTypes().get(4);
/* 5987 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnAllEquipAmuletReq_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnAllEquipAmuletReq_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5992 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipAmuletRes_descriptor = getDescriptor().getMessageTypes().get(5);
/* 5993 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipAmuletRes_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipAmuletRes_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalCount", "S2CMaxCount" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5998 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnEquipAmuletRes_descriptor = getDescriptor().getMessageTypes().get(6);
/* 5999 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnEquipAmuletRes_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnEquipAmuletRes_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalCount", "S2CMaxCount" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6004 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UnAllEquipAmuletRes_descriptor = getDescriptor().getMessageTypes().get(7);
/* 6005 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UnAllEquipAmuletRes_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UnAllEquipAmuletRes_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalCount", "S2CMaxCount" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 6010 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AmuletEquipNewPush_descriptor = getDescriptor().getMessageTypes().get(8);
/* 6011 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AmuletEquipNewPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AmuletEquipNewPush_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CTotalCount", "S2CMaxCount", "S2CData" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 6015 */     Common.getDescriptor();
/* 6016 */     ItemOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface AmuletEquipNewPushOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CTotalCount();
/*      */     
/*      */     int getS2CTotalCount();
/*      */     
/*      */     boolean hasS2CMaxCount();
/*      */     
/*      */     int getS2CMaxCount();
/*      */     
/*      */     List<ItemOuterClass.ItemDetail> getS2CDataList();
/*      */     
/*      */     ItemOuterClass.ItemDetail getS2CData(int param1Int);
/*      */     
/*      */     int getS2CDataCount();
/*      */     
/*      */     List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList();
/*      */     
/*      */     ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface UnAllEquipAmuletResOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CTotalCount();
/*      */     
/*      */     int getS2CTotalCount();
/*      */     
/*      */     boolean hasS2CMaxCount();
/*      */     
/*      */     int getS2CMaxCount();
/*      */   }
/*      */   
/*      */   public static interface UnEquipAmuletResOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CTotalCount();
/*      */     
/*      */     int getS2CTotalCount();
/*      */     
/*      */     boolean hasS2CMaxCount();
/*      */     
/*      */     int getS2CMaxCount();
/*      */   }
/*      */   
/*      */   public static interface EquipAmuletResOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CTotalCount();
/*      */     
/*      */     int getS2CTotalCount();
/*      */     
/*      */     boolean hasS2CMaxCount();
/*      */     
/*      */     int getS2CMaxCount();
/*      */   }
/*      */   
/*      */   public static interface UnAllEquipAmuletReqOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface UnEquipAmuletReqOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SGridIndex();
/*      */     
/*      */     String getC2SGridIndex();
/*      */     
/*      */     ByteString getC2SGridIndexBytes();
/*      */   }
/*      */   
/*      */   public static interface EquipAmuletReqOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SGridIndex();
/*      */     
/*      */     int getC2SGridIndex();
/*      */   }
/*      */   
/*      */   public static interface GetAllAmuletDetailResOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CTotalCount();
/*      */     
/*      */     int getS2CTotalCount();
/*      */     
/*      */     boolean hasS2CMaxCount();
/*      */     
/*      */     int getS2CMaxCount();
/*      */     
/*      */     List<ItemOuterClass.ItemDetail> getS2CDataList();
/*      */     
/*      */     ItemOuterClass.ItemDetail getS2CData(int param1Int);
/*      */     
/*      */     int getS2CDataCount();
/*      */     
/*      */     List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList();
/*      */     
/*      */     ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GetAllAmuletDetailReqOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\AmuletHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */