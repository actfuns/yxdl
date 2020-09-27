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
/*      */ import pomelo.dailyActivity.DailyActivity;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class DailyActivityHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class DailyActivityRequest
/*      */     extends GeneratedMessage
/*      */     implements DailyActivityRequestOrBuilder
/*      */   {
/*  325 */     private static final DailyActivityRequest defaultInstance = new DailyActivityRequest(true); private final UnknownFieldSet unknownFields; private DailyActivityRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DailyActivityRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DailyActivityRequest getDefaultInstance() { return defaultInstance; } public DailyActivityRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DailyActivityRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityRequest.class, Builder.class); } public static Parser<DailyActivityRequest> PARSER = (Parser<DailyActivityRequest>)new AbstractParser<DailyActivityRequest>() { public DailyActivityHandler.DailyActivityRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivityHandler.DailyActivityRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DailyActivityRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DailyActivityRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DailyActivityRequest)PARSER.parseFrom(data); } public static DailyActivityRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DailyActivityRequest)PARSER.parseFrom(data, extensionRegistry); } public static DailyActivityRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DailyActivityRequest)PARSER.parseFrom(data); } public static DailyActivityRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DailyActivityRequest)PARSER.parseFrom(data, extensionRegistry); } public static DailyActivityRequest parseFrom(InputStream input) throws IOException { return (DailyActivityRequest)PARSER.parseFrom(input); } public static DailyActivityRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityRequest)PARSER.parseFrom(input, extensionRegistry); } public static DailyActivityRequest parseDelimitedFrom(InputStream input) throws IOException { return (DailyActivityRequest)PARSER.parseDelimitedFrom(input); } public static DailyActivityRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DailyActivityRequest parseFrom(CodedInputStream input) throws IOException { return (DailyActivityRequest)PARSER.parseFrom(input); } public static DailyActivityRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DailyActivityRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivityHandler.DailyActivityRequestOrBuilder {
/*  326 */       public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityHandler.DailyActivityRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DailyActivityHandler.DailyActivityRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityRequest_descriptor; } public DailyActivityHandler.DailyActivityRequest getDefaultInstanceForType() { return DailyActivityHandler.DailyActivityRequest.getDefaultInstance(); } public DailyActivityHandler.DailyActivityRequest build() { DailyActivityHandler.DailyActivityRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DailyActivityHandler.DailyActivityRequest buildPartial() { DailyActivityHandler.DailyActivityRequest result = new DailyActivityHandler.DailyActivityRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DailyActivityHandler.DailyActivityRequest) return mergeFrom((DailyActivityHandler.DailyActivityRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DailyActivityHandler.DailyActivityRequest other) { if (other == DailyActivityHandler.DailyActivityRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivityHandler.DailyActivityRequest parsedMessage = null; try { parsedMessage = (DailyActivityHandler.DailyActivityRequest)DailyActivityHandler.DailyActivityRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DailyActivityHandler.DailyActivityRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DailyActivityResponse
/*      */     extends GeneratedMessage
/*      */     implements DailyActivityResponseOrBuilder
/*      */   {
/* 2083 */     private static final DailyActivityResponse defaultInstance = new DailyActivityResponse(true); private final UnknownFieldSet unknownFields; private DailyActivityResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DailyActivityResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DailyActivityResponse getDefaultInstance() { return defaultInstance; } public DailyActivityResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DailyActivityResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CDailyLs_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CDailyLs_.add(input.readMessage(DailyActivity.DailyInfo.PARSER, extensionRegistry)); break;case 32: this.bitField0_ |= 0x4; this.s2CTotalDegree_ = input.readInt32(); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CDegreeLs_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CDegreeLs_.add(input.readMessage(DailyActivity.DegreeInfo.PARSER, extensionRegistry)); break;case 48: this.bitField0_ |= 0x8; this.s2CWeekIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CDailyLs_ = Collections.unmodifiableList(this.s2CDailyLs_);  if ((mutable_bitField0_ & 0x10) == 16) this.s2CDegreeLs_ = Collections.unmodifiableList(this.s2CDegreeLs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityResponse.class, Builder.class); } public static Parser<DailyActivityResponse> PARSER = (Parser<DailyActivityResponse>)new AbstractParser<DailyActivityResponse>() { public DailyActivityHandler.DailyActivityResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivityHandler.DailyActivityResponse(input, extensionRegistry); } }
/* 2084 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DAILYLS_FIELD_NUMBER = 3; private List<DailyActivity.DailyInfo> s2CDailyLs_; public static final int S2C_TOTALDEGREE_FIELD_NUMBER = 4; private int s2CTotalDegree_; public static final int S2C_DEGREELS_FIELD_NUMBER = 5; private List<DailyActivity.DegreeInfo> s2CDegreeLs_; public static final int S2C_WEEKINDEX_FIELD_NUMBER = 6; private int s2CWeekIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DailyActivityResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<DailyActivity.DailyInfo> getS2CDailyLsList() { return this.s2CDailyLs_; } static { defaultInstance.initFields(); } public List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList() { return (List)this.s2CDailyLs_; }
/*      */     public int getS2CDailyLsCount() { return this.s2CDailyLs_.size(); }
/*      */     public DailyActivity.DailyInfo getS2CDailyLs(int index) { return this.s2CDailyLs_.get(index); }
/*      */     public DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int index) { return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLs_.get(index); }
/*      */     public boolean hasS2CTotalDegree() { return ((this.bitField0_ & 0x4) == 4); }
/*      */     public int getS2CTotalDegree() { return this.s2CTotalDegree_; }
/*      */     public List<DailyActivity.DegreeInfo> getS2CDegreeLsList() { return this.s2CDegreeLs_; }
/*      */     public List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList() { return (List)this.s2CDegreeLs_; }
/*      */     public int getS2CDegreeLsCount() { return this.s2CDegreeLs_.size(); }
/*      */     public DailyActivity.DegreeInfo getS2CDegreeLs(int index) { return this.s2CDegreeLs_.get(index); }
/*      */     public DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int index) { return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLs_.get(index); }
/*      */     public boolean hasS2CWeekIndex() { return ((this.bitField0_ & 0x8) == 8); }
/*      */     public int getS2CWeekIndex() { return this.s2CWeekIndex_; }
/*      */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CDailyLs_ = Collections.emptyList(); this.s2CTotalDegree_ = 0; this.s2CDegreeLs_ = Collections.emptyList(); this.s2CWeekIndex_ = 0; }
/*      */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*      */         return true;  if (isInitialized == 0)
/*      */         return false;  if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  int i; for (i = 0; i < getS2CDailyLsCount(); i++) {
/*      */         if (!getS2CDailyLs(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0; return false;
/*      */         } 
/*      */       }  for (i = 0; i < getS2CDegreeLsCount(); i++) {
/*      */         if (!getS2CDegreeLs(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0; return false;
/*      */         } 
/*      */       }  this.memoizedIsInitialized = 1; return true; }
/*      */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CDailyLs_.size(); i++)
/*      */         output.writeMessage(3, (MessageLite)this.s2CDailyLs_.get(i));  if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(4, this.s2CTotalDegree_);  for (i = 0; i < this.s2CDegreeLs_.size(); i++)
/*      */         output.writeMessage(5, (MessageLite)this.s2CDegreeLs_.get(i));  if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeInt32(6, this.s2CWeekIndex_);  getUnknownFields().writeTo(output); }
/*      */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*      */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CDailyLs_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CDailyLs_.get(i));  if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(4, this.s2CTotalDegree_);  for (i = 0; i < this.s2CDegreeLs_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CDegreeLs_.get(i));  if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeInt32Size(6, this.s2CWeekIndex_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static DailyActivityResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DailyActivityResponse)PARSER.parseFrom(data); }
/*      */     public static DailyActivityResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DailyActivityResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static DailyActivityResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DailyActivityResponse)PARSER.parseFrom(data); }
/*      */     public static DailyActivityResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DailyActivityResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static DailyActivityResponse parseFrom(InputStream input) throws IOException { return (DailyActivityResponse)PARSER.parseFrom(input); }
/*      */     public static DailyActivityResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static DailyActivityResponse parseDelimitedFrom(InputStream input) throws IOException { return (DailyActivityResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static DailyActivityResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static DailyActivityResponse parseFrom(CodedInputStream input) throws IOException { return (DailyActivityResponse)PARSER.parseFrom(input); }
/*      */     public static DailyActivityResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DailyActivityResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(DailyActivityResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivityHandler.DailyActivityResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<DailyActivity.DailyInfo> s2CDailyLs_; private RepeatedFieldBuilder<DailyActivity.DailyInfo, DailyActivity.DailyInfo.Builder, DailyActivity.DailyInfoOrBuilder> s2CDailyLsBuilder_; private int s2CTotalDegree_; private List<DailyActivity.DegreeInfo> s2CDegreeLs_; private RepeatedFieldBuilder<DailyActivity.DegreeInfo, DailyActivity.DegreeInfo.Builder, DailyActivity.DegreeInfoOrBuilder> s2CDegreeLsBuilder_; private int s2CWeekIndex_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityHandler.DailyActivityResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CDailyLs_ = Collections.emptyList(); this.s2CDegreeLs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CDailyLs_ = Collections.emptyList(); this.s2CDegreeLs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (DailyActivityHandler.DailyActivityResponse.alwaysUseFieldBuilders) {
/*      */           getS2CDailyLsFieldBuilder(); getS2CDegreeLsFieldBuilder();
/*      */         }  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CDailyLsBuilder_ == null) {
/*      */           this.s2CDailyLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.clear();
/*      */         }  this.s2CTotalDegree_ = 0; this.bitField0_ &= 0xFFFFFFF7; if (this.s2CDegreeLsBuilder_ == null) {
/*      */           this.s2CDegreeLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF;
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.clear();
/*      */         }  this.s2CWeekIndex_ = 0; this.bitField0_ &= 0xFFFFFFDF; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return DailyActivityHandler.internal_static_pomelo_area_DailyActivityResponse_descriptor; }
/*      */       public DailyActivityHandler.DailyActivityResponse getDefaultInstanceForType() { return DailyActivityHandler.DailyActivityResponse.getDefaultInstance(); }
/*      */       public DailyActivityHandler.DailyActivityResponse build() { DailyActivityHandler.DailyActivityResponse result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public DailyActivityHandler.DailyActivityResponse buildPartial() { DailyActivityHandler.DailyActivityResponse result = new DailyActivityHandler.DailyActivityResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.s2CDailyLsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.s2CDailyLs_ = Collections.unmodifiableList(this.s2CDailyLs_); this.bitField0_ &= 0xFFFFFFFB;
/*      */           }  result.s2CDailyLs_ = this.s2CDailyLs_;
/*      */         } else {
/*      */           result.s2CDailyLs_ = this.s2CDailyLsBuilder_.build();
/*      */         }  if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x4;  result.s2CTotalDegree_ = this.s2CTotalDegree_; if (this.s2CDegreeLsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x10) == 16) {
/*      */             this.s2CDegreeLs_ = Collections.unmodifiableList(this.s2CDegreeLs_); this.bitField0_ &= 0xFFFFFFEF;
/*      */           }  result.s2CDegreeLs_ = this.s2CDegreeLs_;
/*      */         } else {
/*      */           result.s2CDegreeLs_ = this.s2CDegreeLsBuilder_.build();
/*      */         }  if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x8;  result.s2CWeekIndex_ = this.s2CWeekIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof DailyActivityHandler.DailyActivityResponse)
/*      */           return mergeFrom((DailyActivityHandler.DailyActivityResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(DailyActivityHandler.DailyActivityResponse other) { if (other == DailyActivityHandler.DailyActivityResponse.getDefaultInstance())
/*      */           return this;  if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged();
/*      */         }  if (this.s2CDailyLsBuilder_ == null) {
/*      */           if (!other.s2CDailyLs_.isEmpty()) {
/*      */             if (this.s2CDailyLs_.isEmpty()) {
/*      */               this.s2CDailyLs_ = other.s2CDailyLs_; this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.addAll(other.s2CDailyLs_);
/*      */             }  onChanged();
/*      */           } 
/*      */         } else if (!other.s2CDailyLs_.isEmpty()) {
/*      */           if (this.s2CDailyLsBuilder_.isEmpty()) {
/*      */             this.s2CDailyLsBuilder_.dispose(); this.s2CDailyLsBuilder_ = null; this.s2CDailyLs_ = other.s2CDailyLs_; this.bitField0_ &= 0xFFFFFFFB; this.s2CDailyLsBuilder_ = DailyActivityHandler.DailyActivityResponse.alwaysUseFieldBuilders ? getS2CDailyLsFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CDailyLsBuilder_.addAllMessages(other.s2CDailyLs_);
/*      */           } 
/*      */         }  if (other.hasS2CTotalDegree())
/*      */           setS2CTotalDegree(other.getS2CTotalDegree());  if (this.s2CDegreeLsBuilder_ == null) {
/*      */           if (!other.s2CDegreeLs_.isEmpty()) {
/*      */             if (this.s2CDegreeLs_.isEmpty()) {
/*      */               this.s2CDegreeLs_ = other.s2CDegreeLs_; this.bitField0_ &= 0xFFFFFFEF;
/*      */             } else {
/*      */               ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.addAll(other.s2CDegreeLs_);
/*      */             }  onChanged();
/*      */           } 
/*      */         } else if (!other.s2CDegreeLs_.isEmpty()) {
/*      */           if (this.s2CDegreeLsBuilder_.isEmpty()) {
/*      */             this.s2CDegreeLsBuilder_.dispose(); this.s2CDegreeLsBuilder_ = null; this.s2CDegreeLs_ = other.s2CDegreeLs_; this.bitField0_ &= 0xFFFFFFEF; this.s2CDegreeLsBuilder_ = DailyActivityHandler.DailyActivityResponse.alwaysUseFieldBuilders ? getS2CDegreeLsFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CDegreeLsBuilder_.addAllMessages(other.s2CDegreeLs_);
/*      */           } 
/*      */         }  if (other.hasS2CWeekIndex())
/*      */           setS2CWeekIndex(other.getS2CWeekIndex());  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false;  int i; for (i = 0; i < getS2CDailyLsCount(); i++) {
/*      */           if (!getS2CDailyLs(i).isInitialized())
/*      */             return false; 
/*      */         }  for (i = 0; i < getS2CDegreeLsCount(); i++) {
/*      */           if (!getS2CDegreeLs(i).isInitialized())
/*      */             return false; 
/*      */         }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivityHandler.DailyActivityResponse parsedMessage = null; try {
/*      */           parsedMessage = (DailyActivityHandler.DailyActivityResponse)DailyActivityHandler.DailyActivityResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DailyActivityHandler.DailyActivityResponse)e.getUnfinishedMessage(); throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s;  return s;
/*      */         }  return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b;
/*      */         } 
/*      */         return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = DailyActivityHandler.DailyActivityResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       private void ensureS2CDailyLsIsMutable() { if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.s2CDailyLs_ = new ArrayList<>(this.s2CDailyLs_);
/*      */           this.bitField0_ |= 0x4;
/*      */         }  }
/*      */       public List<DailyActivity.DailyInfo> getS2CDailyLsList() { if (this.s2CDailyLsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CDailyLs_); 
/*      */         return this.s2CDailyLsBuilder_.getMessageList(); }
/*      */       public int getS2CDailyLsCount() { if (this.s2CDailyLsBuilder_ == null)
/*      */           return this.s2CDailyLs_.size(); 
/*      */         return this.s2CDailyLsBuilder_.getCount(); }
/*      */       public DailyActivity.DailyInfo getS2CDailyLs(int index) { if (this.s2CDailyLsBuilder_ == null)
/*      */           return this.s2CDailyLs_.get(index); 
/*      */         return (DailyActivity.DailyInfo)this.s2CDailyLsBuilder_.getMessage(index); }
/*      */       public Builder setS2CDailyLs(int index, DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setS2CDailyLs(int index, DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDailyLs(DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDailyLs(int index, DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDailyLs(DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDailyLs(int index, DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAllS2CDailyLs(Iterable<? extends DailyActivity.DailyInfo> values) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           ensureS2CDailyLsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CDailyLs_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; }
/*      */       public Builder clearS2CDailyLs() { if (this.s2CDailyLsBuilder_ == null) {
/*      */           this.s2CDailyLs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder removeS2CDailyLs(int index) { if (this.s2CDailyLsBuilder_ == null) {
/*      */           ensureS2CDailyLsIsMutable();
/*      */           this.s2CDailyLs_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDailyLsBuilder_.remove(index);
/*      */         } 
/*      */         return this; }
/*      */       public DailyActivity.DailyInfo.Builder getS2CDailyLsBuilder(int index) { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().getBuilder(index); }
/*      */       public DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int index) { if (this.s2CDailyLsBuilder_ == null)
/*      */           return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLs_.get(index); 
/*      */         return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLsBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList() { if (this.s2CDailyLsBuilder_ != null)
/*      */           return this.s2CDailyLsBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CDailyLs_); }
/*      */       public DailyActivity.DailyInfo.Builder addS2CDailyLsBuilder() { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().addBuilder((GeneratedMessage)DailyActivity.DailyInfo.getDefaultInstance()); }
/*      */       public DailyActivity.DailyInfo.Builder addS2CDailyLsBuilder(int index) { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().addBuilder(index, (GeneratedMessage)DailyActivity.DailyInfo.getDefaultInstance()); }
/*      */       public List<DailyActivity.DailyInfo.Builder> getS2CDailyLsBuilderList() { return getS2CDailyLsFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<DailyActivity.DailyInfo, DailyActivity.DailyInfo.Builder, DailyActivity.DailyInfoOrBuilder> getS2CDailyLsFieldBuilder() { if (this.s2CDailyLsBuilder_ == null) {
/*      */           this.s2CDailyLsBuilder_ = new RepeatedFieldBuilder(this.s2CDailyLs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.s2CDailyLs_ = null;
/*      */         } 
/*      */         return this.s2CDailyLsBuilder_; }
/*      */       public boolean hasS2CTotalDegree() { return ((this.bitField0_ & 0x8) == 8); }
/*      */       public int getS2CTotalDegree() { return this.s2CTotalDegree_; }
/*      */       public Builder setS2CTotalDegree(int value) { this.bitField0_ |= 0x8;
/*      */         this.s2CTotalDegree_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CTotalDegree() { this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CTotalDegree_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       private void ensureS2CDegreeLsIsMutable() { if ((this.bitField0_ & 0x10) != 16) {
/*      */           this.s2CDegreeLs_ = new ArrayList<>(this.s2CDegreeLs_);
/*      */           this.bitField0_ |= 0x10;
/*      */         }  }
/*      */       public List<DailyActivity.DegreeInfo> getS2CDegreeLsList() { if (this.s2CDegreeLsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CDegreeLs_); 
/*      */         return this.s2CDegreeLsBuilder_.getMessageList(); }
/*      */       public int getS2CDegreeLsCount() { if (this.s2CDegreeLsBuilder_ == null)
/*      */           return this.s2CDegreeLs_.size(); 
/*      */         return this.s2CDegreeLsBuilder_.getCount(); }
/*      */       public DailyActivity.DegreeInfo getS2CDegreeLs(int index) { if (this.s2CDegreeLsBuilder_ == null)
/*      */           return this.s2CDegreeLs_.get(index); 
/*      */         return (DailyActivity.DegreeInfo)this.s2CDegreeLsBuilder_.getMessage(index); }
/*      */       public Builder setS2CDegreeLs(int index, DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setS2CDegreeLs(int index, DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDegreeLs(DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDegreeLs(int index, DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDegreeLs(DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CDegreeLs(int index, DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAllS2CDegreeLs(Iterable<? extends DailyActivity.DegreeInfo> values) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CDegreeLs_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; }
/*      */       public Builder clearS2CDegreeLs() { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           this.s2CDegreeLs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder removeS2CDegreeLs(int index) { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           ensureS2CDegreeLsIsMutable();
/*      */           this.s2CDegreeLs_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CDegreeLsBuilder_.remove(index);
/*      */         } 
/*      */         return this; }
/*      */       public DailyActivity.DegreeInfo.Builder getS2CDegreeLsBuilder(int index) { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().getBuilder(index); }
/*      */       public DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int index) { if (this.s2CDegreeLsBuilder_ == null)
/*      */           return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLs_.get(index); 
/*      */         return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLsBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList() { if (this.s2CDegreeLsBuilder_ != null)
/*      */           return this.s2CDegreeLsBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CDegreeLs_); }
/*      */       public DailyActivity.DegreeInfo.Builder addS2CDegreeLsBuilder() { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().addBuilder((GeneratedMessage)DailyActivity.DegreeInfo.getDefaultInstance()); }
/*      */       public DailyActivity.DegreeInfo.Builder addS2CDegreeLsBuilder(int index) { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().addBuilder(index, (GeneratedMessage)DailyActivity.DegreeInfo.getDefaultInstance()); }
/*      */       public List<DailyActivity.DegreeInfo.Builder> getS2CDegreeLsBuilderList() { return getS2CDegreeLsFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<DailyActivity.DegreeInfo, DailyActivity.DegreeInfo.Builder, DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsFieldBuilder() { if (this.s2CDegreeLsBuilder_ == null) {
/*      */           this.s2CDegreeLsBuilder_ = new RepeatedFieldBuilder(this.s2CDegreeLs_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*      */           this.s2CDegreeLs_ = null;
/*      */         } 
/*      */         return this.s2CDegreeLsBuilder_; }
/*      */       public boolean hasS2CWeekIndex() { return ((this.bitField0_ & 0x20) == 32); }
/*      */       public int getS2CWeekIndex() { return this.s2CWeekIndex_; }
/*      */       public Builder setS2CWeekIndex(int value) { this.bitField0_ |= 0x20;
/*      */         this.s2CWeekIndex_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CWeekIndex() { this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.s2CWeekIndex_ = 0;
/*      */         onChanged();
/*      */         return this; } } }
/* 2496 */   public static final class GetDegreeRewardRequest extends GeneratedMessage implements GetDegreeRewardRequestOrBuilder { private static final GetDegreeRewardRequest defaultInstance = new GetDegreeRewardRequest(true); private final UnknownFieldSet unknownFields; private GetDegreeRewardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDegreeRewardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDegreeRewardRequest getDefaultInstance() { return defaultInstance; } public GetDegreeRewardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDegreeRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDegreeRewardRequest.class, Builder.class); } public static Parser<GetDegreeRewardRequest> PARSER = (Parser<GetDegreeRewardRequest>)new AbstractParser<GetDegreeRewardRequest>() { public DailyActivityHandler.GetDegreeRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivityHandler.GetDegreeRewardRequest(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDegreeRewardRequest> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } private void initFields() { this.id_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetDegreeRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDegreeRewardRequest)PARSER.parseFrom(data); } public static GetDegreeRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDegreeRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDegreeRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDegreeRewardRequest)PARSER.parseFrom(data); } public static GetDegreeRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDegreeRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetDegreeRewardRequest parseFrom(InputStream input) throws IOException { return (GetDegreeRewardRequest)PARSER.parseFrom(input); } public static GetDegreeRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetDegreeRewardRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetDegreeRewardRequest)PARSER.parseDelimitedFrom(input); } public static GetDegreeRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetDegreeRewardRequest parseFrom(CodedInputStream input) throws IOException { return (GetDegreeRewardRequest)PARSER.parseFrom(input); } public static GetDegreeRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetDegreeRewardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivityHandler.GetDegreeRewardRequestOrBuilder {
/* 2497 */       private int bitField0_; private int id_; public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityHandler.GetDegreeRewardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DailyActivityHandler.GetDegreeRewardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardRequest_descriptor; } public DailyActivityHandler.GetDegreeRewardRequest getDefaultInstanceForType() { return DailyActivityHandler.GetDegreeRewardRequest.getDefaultInstance(); } public DailyActivityHandler.GetDegreeRewardRequest build() { DailyActivityHandler.GetDegreeRewardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DailyActivityHandler.GetDegreeRewardRequest buildPartial() { DailyActivityHandler.GetDegreeRewardRequest result = new DailyActivityHandler.GetDegreeRewardRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DailyActivityHandler.GetDegreeRewardRequest) return mergeFrom((DailyActivityHandler.GetDegreeRewardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DailyActivityHandler.GetDegreeRewardRequest other) { if (other == DailyActivityHandler.GetDegreeRewardRequest.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivityHandler.GetDegreeRewardRequest parsedMessage = null; try { parsedMessage = (DailyActivityHandler.GetDegreeRewardRequest)DailyActivityHandler.GetDegreeRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DailyActivityHandler.GetDegreeRewardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GetDegreeRewardResponse
/*      */     extends GeneratedMessage
/*      */     implements GetDegreeRewardResponseOrBuilder
/*      */   {
/* 3254 */     private static final GetDegreeRewardResponse defaultInstance = new GetDegreeRewardResponse(true); private final UnknownFieldSet unknownFields; private GetDegreeRewardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetDegreeRewardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetDegreeRewardResponse getDefaultInstance() { return defaultInstance; } public GetDegreeRewardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetDegreeRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.id_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CState_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDegreeRewardResponse.class, Builder.class); } public static Parser<GetDegreeRewardResponse> PARSER = (Parser<GetDegreeRewardResponse>)new AbstractParser<GetDegreeRewardResponse>() { public DailyActivityHandler.GetDegreeRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivityHandler.GetDegreeRewardResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int ID_FIELD_NUMBER = 3; private int id_; public static final int S2C_STATE_FIELD_NUMBER = 4; private int s2CState_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetDegreeRewardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasId() { return ((this.bitField0_ & 0x4) == 4); } public int getId() { return this.id_; } public boolean hasS2CState() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CState() { return this.s2CState_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.id_ = 0; this.s2CState_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.id_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CState_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.id_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CState_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetDegreeRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetDegreeRewardResponse)PARSER.parseFrom(data); } public static GetDegreeRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDegreeRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetDegreeRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetDegreeRewardResponse)PARSER.parseFrom(data); } public static GetDegreeRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetDegreeRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetDegreeRewardResponse parseFrom(InputStream input) throws IOException { return (GetDegreeRewardResponse)PARSER.parseFrom(input); } public static GetDegreeRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetDegreeRewardResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetDegreeRewardResponse)PARSER.parseDelimitedFrom(input); } public static GetDegreeRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetDegreeRewardResponse parseFrom(CodedInputStream input) throws IOException { return (GetDegreeRewardResponse)PARSER.parseFrom(input); } public static GetDegreeRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetDegreeRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetDegreeRewardResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivityHandler.GetDegreeRewardResponseOrBuilder {
/* 3255 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int id_; private int s2CState_; public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityHandler.GetDegreeRewardResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DailyActivityHandler.GetDegreeRewardResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.id_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CState_ = 0; this.bitField0_ &= 0xFFFFFFF7; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DailyActivityHandler.internal_static_pomelo_area_GetDegreeRewardResponse_descriptor; } public DailyActivityHandler.GetDegreeRewardResponse getDefaultInstanceForType() { return DailyActivityHandler.GetDegreeRewardResponse.getDefaultInstance(); } public DailyActivityHandler.GetDegreeRewardResponse build() { DailyActivityHandler.GetDegreeRewardResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DailyActivityHandler.GetDegreeRewardResponse buildPartial() { DailyActivityHandler.GetDegreeRewardResponse result = new DailyActivityHandler.GetDegreeRewardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.id_ = this.id_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  result.s2CState_ = this.s2CState_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DailyActivityHandler.GetDegreeRewardResponse) return mergeFrom((DailyActivityHandler.GetDegreeRewardResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DailyActivityHandler.GetDegreeRewardResponse other) { if (other == DailyActivityHandler.GetDegreeRewardResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasId()) setId(other.getId());  if (other.hasS2CState()) setS2CState(other.getS2CState());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivityHandler.GetDegreeRewardResponse parsedMessage = null; try { parsedMessage = (DailyActivityHandler.GetDegreeRewardResponse)DailyActivityHandler.GetDegreeRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DailyActivityHandler.GetDegreeRewardResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = DailyActivityHandler.GetDegreeRewardResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasId() { return ((this.bitField0_ & 0x4) == 4); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x4; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFB; this.id_ = 0; onChanged(); return this; } public boolean hasS2CState() { return ((this.bitField0_ & 0x8) == 8); } public int getS2CState() { return this.s2CState_; } public Builder setS2CState(int value) { this.bitField0_ |= 0x8; this.s2CState_ = value; onChanged(); return this; } public Builder clearS2CState() { this.bitField0_ &= 0xFFFFFFF7; this.s2CState_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class UpdateActivityPush
/*      */     extends GeneratedMessage
/*      */     implements UpdateActivityPushOrBuilder
/*      */   {
/* 4651 */     private static final UpdateActivityPush defaultInstance = new UpdateActivityPush(true); private final UnknownFieldSet unknownFields; private UpdateActivityPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpdateActivityPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpdateActivityPush getDefaultInstance() { return defaultInstance; } public UpdateActivityPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpdateActivityPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: if ((mutable_bitField0_ & 0x1) != 1) { this.s2CDailyLs_ = new ArrayList<>(); mutable_bitField0_ |= 0x1; }  this.s2CDailyLs_.add(input.readMessage(DailyActivity.DailyInfo.PARSER, extensionRegistry)); break;case 16: this.bitField0_ |= 0x1; this.s2CTotalDegree_ = input.readInt32(); break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CDegreeLs_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CDegreeLs_.add(input.readMessage(DailyActivity.DegreeInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x1) == 1) this.s2CDailyLs_ = Collections.unmodifiableList(this.s2CDailyLs_);  if ((mutable_bitField0_ & 0x4) == 4) this.s2CDegreeLs_ = Collections.unmodifiableList(this.s2CDegreeLs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_UpdateActivityPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_UpdateActivityPush_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateActivityPush.class, Builder.class); } public static Parser<UpdateActivityPush> PARSER = (Parser<UpdateActivityPush>)new AbstractParser<UpdateActivityPush>() { public DailyActivityHandler.UpdateActivityPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivityHandler.UpdateActivityPush(input, extensionRegistry); } }
/* 4652 */     ; private int bitField0_; public static final int S2C_DAILYLS_FIELD_NUMBER = 1; private List<DailyActivity.DailyInfo> s2CDailyLs_; public static final int S2C_TOTALDEGREE_FIELD_NUMBER = 2; private int s2CTotalDegree_; public static final int S2C_DEGREELS_FIELD_NUMBER = 3; private List<DailyActivity.DegreeInfo> s2CDegreeLs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpdateActivityPush> getParserForType() { return PARSER; } public List<DailyActivity.DailyInfo> getS2CDailyLsList() { return this.s2CDailyLs_; } public List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList() { return (List)this.s2CDailyLs_; } public int getS2CDailyLsCount() { return this.s2CDailyLs_.size(); } public DailyActivity.DailyInfo getS2CDailyLs(int index) { return this.s2CDailyLs_.get(index); } public DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int index) { return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLs_.get(index); } public boolean hasS2CTotalDegree() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CTotalDegree() { return this.s2CTotalDegree_; } public List<DailyActivity.DegreeInfo> getS2CDegreeLsList() { return this.s2CDegreeLs_; } public List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList() { return (List)this.s2CDegreeLs_; } public int getS2CDegreeLsCount() { return this.s2CDegreeLs_.size(); } public DailyActivity.DegreeInfo getS2CDegreeLs(int index) { return this.s2CDegreeLs_.get(index); } public DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int index) { return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLs_.get(index); } private void initFields() { this.s2CDailyLs_ = Collections.emptyList(); this.s2CTotalDegree_ = 0; this.s2CDegreeLs_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  int i; for (i = 0; i < getS2CDailyLsCount(); i++) { if (!getS2CDailyLs(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getS2CDegreeLsCount(); i++) { if (!getS2CDegreeLs(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); int i; for (i = 0; i < this.s2CDailyLs_.size(); i++) output.writeMessage(1, (MessageLite)this.s2CDailyLs_.get(i));  if ((this.bitField0_ & 0x1) == 1) output.writeInt32(2, this.s2CTotalDegree_);  for (i = 0; i < this.s2CDegreeLs_.size(); i++) output.writeMessage(3, (MessageLite)this.s2CDegreeLs_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; int i; for (i = 0; i < this.s2CDailyLs_.size(); i++) size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.s2CDailyLs_.get(i));  if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(2, this.s2CTotalDegree_);  for (i = 0; i < this.s2CDegreeLs_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CDegreeLs_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpdateActivityPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpdateActivityPush)PARSER.parseFrom(data); } public static UpdateActivityPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpdateActivityPush)PARSER.parseFrom(data, extensionRegistry); } public static UpdateActivityPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpdateActivityPush)PARSER.parseFrom(data); } static { defaultInstance.initFields(); }
/*      */     public static UpdateActivityPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpdateActivityPush)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static UpdateActivityPush parseFrom(InputStream input) throws IOException { return (UpdateActivityPush)PARSER.parseFrom(input); }
/*      */     public static UpdateActivityPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpdateActivityPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static UpdateActivityPush parseDelimitedFrom(InputStream input) throws IOException { return (UpdateActivityPush)PARSER.parseDelimitedFrom(input); }
/*      */     public static UpdateActivityPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpdateActivityPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static UpdateActivityPush parseFrom(CodedInputStream input) throws IOException { return (UpdateActivityPush)PARSER.parseFrom(input); }
/*      */     public static UpdateActivityPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpdateActivityPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(UpdateActivityPush prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivityHandler.UpdateActivityPushOrBuilder {
/*      */       private int bitField0_;
/*      */       private List<DailyActivity.DailyInfo> s2CDailyLs_;
/*      */       private RepeatedFieldBuilder<DailyActivity.DailyInfo, DailyActivity.DailyInfo.Builder, DailyActivity.DailyInfoOrBuilder> s2CDailyLsBuilder_;
/*      */       private int s2CTotalDegree_;
/*      */       private List<DailyActivity.DegreeInfo> s2CDegreeLs_;
/*      */       private RepeatedFieldBuilder<DailyActivity.DegreeInfo, DailyActivity.DegreeInfo.Builder, DailyActivity.DegreeInfoOrBuilder> s2CDegreeLsBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return DailyActivityHandler.internal_static_pomelo_area_UpdateActivityPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivityHandler.internal_static_pomelo_area_UpdateActivityPush_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivityHandler.UpdateActivityPush.class, Builder.class); }
/*      */       private Builder() { this.s2CDailyLs_ = Collections.emptyList(); this.s2CDegreeLs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CDailyLs_ = Collections.emptyList(); this.s2CDegreeLs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (DailyActivityHandler.UpdateActivityPush.alwaysUseFieldBuilders) { getS2CDailyLsFieldBuilder(); getS2CDegreeLsFieldBuilder(); }  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); if (this.s2CDailyLsBuilder_ == null) { this.s2CDailyLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFE; } else { this.s2CDailyLsBuilder_.clear(); }  this.s2CTotalDegree_ = 0; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CDegreeLsBuilder_ == null) { this.s2CDegreeLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.s2CDegreeLsBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return DailyActivityHandler.internal_static_pomelo_area_UpdateActivityPush_descriptor; }
/*      */       public DailyActivityHandler.UpdateActivityPush getDefaultInstanceForType() { return DailyActivityHandler.UpdateActivityPush.getDefaultInstance(); }
/*      */       public DailyActivityHandler.UpdateActivityPush build() { DailyActivityHandler.UpdateActivityPush result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public DailyActivityHandler.UpdateActivityPush buildPartial() { DailyActivityHandler.UpdateActivityPush result = new DailyActivityHandler.UpdateActivityPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if (this.s2CDailyLsBuilder_ == null) { if ((this.bitField0_ & 0x1) == 1) { this.s2CDailyLs_ = Collections.unmodifiableList(this.s2CDailyLs_); this.bitField0_ &= 0xFFFFFFFE; }  result.s2CDailyLs_ = this.s2CDailyLs_; } else { result.s2CDailyLs_ = this.s2CDailyLsBuilder_.build(); }  if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x1;  result.s2CTotalDegree_ = this.s2CTotalDegree_; if (this.s2CDegreeLsBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.s2CDegreeLs_ = Collections.unmodifiableList(this.s2CDegreeLs_); this.bitField0_ &= 0xFFFFFFFB; }  result.s2CDegreeLs_ = this.s2CDegreeLs_; } else { result.s2CDegreeLs_ = this.s2CDegreeLsBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof DailyActivityHandler.UpdateActivityPush) return mergeFrom((DailyActivityHandler.UpdateActivityPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(DailyActivityHandler.UpdateActivityPush other) { if (other == DailyActivityHandler.UpdateActivityPush.getDefaultInstance()) return this;  if (this.s2CDailyLsBuilder_ == null) { if (!other.s2CDailyLs_.isEmpty()) { if (this.s2CDailyLs_.isEmpty()) { this.s2CDailyLs_ = other.s2CDailyLs_; this.bitField0_ &= 0xFFFFFFFE; } else { ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.addAll(other.s2CDailyLs_); }  onChanged(); }  } else if (!other.s2CDailyLs_.isEmpty()) { if (this.s2CDailyLsBuilder_.isEmpty()) { this.s2CDailyLsBuilder_.dispose(); this.s2CDailyLsBuilder_ = null; this.s2CDailyLs_ = other.s2CDailyLs_; this.bitField0_ &= 0xFFFFFFFE; this.s2CDailyLsBuilder_ = DailyActivityHandler.UpdateActivityPush.alwaysUseFieldBuilders ? getS2CDailyLsFieldBuilder() : null; } else { this.s2CDailyLsBuilder_.addAllMessages(other.s2CDailyLs_); }  }  if (other.hasS2CTotalDegree()) setS2CTotalDegree(other.getS2CTotalDegree());  if (this.s2CDegreeLsBuilder_ == null) { if (!other.s2CDegreeLs_.isEmpty()) { if (this.s2CDegreeLs_.isEmpty()) { this.s2CDegreeLs_ = other.s2CDegreeLs_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.addAll(other.s2CDegreeLs_); }  onChanged(); }  } else if (!other.s2CDegreeLs_.isEmpty()) { if (this.s2CDegreeLsBuilder_.isEmpty()) { this.s2CDegreeLsBuilder_.dispose(); this.s2CDegreeLsBuilder_ = null; this.s2CDegreeLs_ = other.s2CDegreeLs_; this.bitField0_ &= 0xFFFFFFFB; this.s2CDegreeLsBuilder_ = DailyActivityHandler.UpdateActivityPush.alwaysUseFieldBuilders ? getS2CDegreeLsFieldBuilder() : null; } else { this.s2CDegreeLsBuilder_.addAllMessages(other.s2CDegreeLs_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { int i; for (i = 0; i < getS2CDailyLsCount(); i++) { if (!getS2CDailyLs(i).isInitialized()) return false;  }  for (i = 0; i < getS2CDegreeLsCount(); i++) { if (!getS2CDegreeLs(i).isInitialized()) return false;  }  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivityHandler.UpdateActivityPush parsedMessage = null; try { parsedMessage = (DailyActivityHandler.UpdateActivityPush)DailyActivityHandler.UpdateActivityPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DailyActivityHandler.UpdateActivityPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } private void ensureS2CDailyLsIsMutable() { if ((this.bitField0_ & 0x1) != 1) { this.s2CDailyLs_ = new ArrayList<>(this.s2CDailyLs_); this.bitField0_ |= 0x1; }  } public List<DailyActivity.DailyInfo> getS2CDailyLsList() { if (this.s2CDailyLsBuilder_ == null) return Collections.unmodifiableList(this.s2CDailyLs_);  return this.s2CDailyLsBuilder_.getMessageList(); } public int getS2CDailyLsCount() { if (this.s2CDailyLsBuilder_ == null) return this.s2CDailyLs_.size();  return this.s2CDailyLsBuilder_.getCount(); } public DailyActivity.DailyInfo getS2CDailyLs(int index) { if (this.s2CDailyLsBuilder_ == null) return this.s2CDailyLs_.get(index);  return (DailyActivity.DailyInfo)this.s2CDailyLsBuilder_.getMessage(index); } public Builder setS2CDailyLs(int index, DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.set(index, value); onChanged(); } else { this.s2CDailyLsBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setS2CDailyLs(int index, DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) { ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.set(index, builderForValue.build()); onChanged(); } else { this.s2CDailyLsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CDailyLs(DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.add(value); onChanged(); } else { this.s2CDailyLsBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addS2CDailyLs(int index, DailyActivity.DailyInfo value) { if (this.s2CDailyLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.add(index, value); onChanged(); } else { this.s2CDailyLsBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addS2CDailyLs(DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) { ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.add(builderForValue.build()); onChanged(); } else { this.s2CDailyLsBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CDailyLs(int index, DailyActivity.DailyInfo.Builder builderForValue) { if (this.s2CDailyLsBuilder_ == null) { ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.add(index, builderForValue.build()); onChanged(); } else { this.s2CDailyLsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllS2CDailyLs(Iterable<? extends DailyActivity.DailyInfo> values) { if (this.s2CDailyLsBuilder_ == null) { ensureS2CDailyLsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CDailyLs_); onChanged(); } else { this.s2CDailyLsBuilder_.addAllMessages(values); }  return this; } public Builder clearS2CDailyLs() { if (this.s2CDailyLsBuilder_ == null) { this.s2CDailyLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFE; onChanged(); } else { this.s2CDailyLsBuilder_.clear(); }  return this; } public Builder removeS2CDailyLs(int index) { if (this.s2CDailyLsBuilder_ == null) { ensureS2CDailyLsIsMutable(); this.s2CDailyLs_.remove(index); onChanged(); } else { this.s2CDailyLsBuilder_.remove(index); }  return this; } public DailyActivity.DailyInfo.Builder getS2CDailyLsBuilder(int index) { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().getBuilder(index); } public DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int index) { if (this.s2CDailyLsBuilder_ == null) return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLs_.get(index);  return (DailyActivity.DailyInfoOrBuilder)this.s2CDailyLsBuilder_.getMessageOrBuilder(index); } public List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList() { if (this.s2CDailyLsBuilder_ != null) return this.s2CDailyLsBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.s2CDailyLs_); } public DailyActivity.DailyInfo.Builder addS2CDailyLsBuilder() { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().addBuilder((GeneratedMessage)DailyActivity.DailyInfo.getDefaultInstance()); } public DailyActivity.DailyInfo.Builder addS2CDailyLsBuilder(int index) { return (DailyActivity.DailyInfo.Builder)getS2CDailyLsFieldBuilder().addBuilder(index, (GeneratedMessage)DailyActivity.DailyInfo.getDefaultInstance()); } public List<DailyActivity.DailyInfo.Builder> getS2CDailyLsBuilderList() { return getS2CDailyLsFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<DailyActivity.DailyInfo, DailyActivity.DailyInfo.Builder, DailyActivity.DailyInfoOrBuilder> getS2CDailyLsFieldBuilder() { if (this.s2CDailyLsBuilder_ == null) { this.s2CDailyLsBuilder_ = new RepeatedFieldBuilder(this.s2CDailyLs_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean()); this.s2CDailyLs_ = null; }  return this.s2CDailyLsBuilder_; } public boolean hasS2CTotalDegree() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CTotalDegree() { return this.s2CTotalDegree_; } public Builder setS2CTotalDegree(int value) { this.bitField0_ |= 0x2; this.s2CTotalDegree_ = value; onChanged(); return this; } public Builder clearS2CTotalDegree() { this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalDegree_ = 0; onChanged(); return this; } private void ensureS2CDegreeLsIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.s2CDegreeLs_ = new ArrayList<>(this.s2CDegreeLs_); this.bitField0_ |= 0x4; }  } public List<DailyActivity.DegreeInfo> getS2CDegreeLsList() { if (this.s2CDegreeLsBuilder_ == null) return Collections.unmodifiableList(this.s2CDegreeLs_);  return this.s2CDegreeLsBuilder_.getMessageList(); } public int getS2CDegreeLsCount() { if (this.s2CDegreeLsBuilder_ == null) return this.s2CDegreeLs_.size();  return this.s2CDegreeLsBuilder_.getCount(); } public DailyActivity.DegreeInfo getS2CDegreeLs(int index) { if (this.s2CDegreeLsBuilder_ == null) return this.s2CDegreeLs_.get(index);  return (DailyActivity.DegreeInfo)this.s2CDegreeLsBuilder_.getMessage(index); } public Builder setS2CDegreeLs(int index, DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.set(index, value); onChanged(); } else { this.s2CDegreeLsBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setS2CDegreeLs(int index, DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) { ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.set(index, builderForValue.build()); onChanged(); } else { this.s2CDegreeLsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CDegreeLs(DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.add(value); onChanged(); } else { this.s2CDegreeLsBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addS2CDegreeLs(int index, DailyActivity.DegreeInfo value) { if (this.s2CDegreeLsBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.add(index, value); onChanged(); } else { this.s2CDegreeLsBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addS2CDegreeLs(DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) { ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.add(builderForValue.build()); onChanged(); } else { this.s2CDegreeLsBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addS2CDegreeLs(int index, DailyActivity.DegreeInfo.Builder builderForValue) { if (this.s2CDegreeLsBuilder_ == null) { ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.add(index, builderForValue.build()); onChanged(); } else { this.s2CDegreeLsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllS2CDegreeLs(Iterable<? extends DailyActivity.DegreeInfo> values) { if (this.s2CDegreeLsBuilder_ == null) { ensureS2CDegreeLsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CDegreeLs_); onChanged(); } else { this.s2CDegreeLsBuilder_.addAllMessages(values); }  return this; } public Builder clearS2CDegreeLs() { if (this.s2CDegreeLsBuilder_ == null) { this.s2CDegreeLs_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); } else { this.s2CDegreeLsBuilder_.clear(); }  return this; } public Builder removeS2CDegreeLs(int index) { if (this.s2CDegreeLsBuilder_ == null) { ensureS2CDegreeLsIsMutable(); this.s2CDegreeLs_.remove(index); onChanged(); } else { this.s2CDegreeLsBuilder_.remove(index); }  return this; } public DailyActivity.DegreeInfo.Builder getS2CDegreeLsBuilder(int index) { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().getBuilder(index); } public DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int index) { if (this.s2CDegreeLsBuilder_ == null) return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLs_.get(index);  return (DailyActivity.DegreeInfoOrBuilder)this.s2CDegreeLsBuilder_.getMessageOrBuilder(index); } public List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList() { if (this.s2CDegreeLsBuilder_ != null) return this.s2CDegreeLsBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.s2CDegreeLs_); } public DailyActivity.DegreeInfo.Builder addS2CDegreeLsBuilder() { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().addBuilder((GeneratedMessage)DailyActivity.DegreeInfo.getDefaultInstance()); } public DailyActivity.DegreeInfo.Builder addS2CDegreeLsBuilder(int index) { return (DailyActivity.DegreeInfo.Builder)getS2CDegreeLsFieldBuilder().addBuilder(index, (GeneratedMessage)DailyActivity.DegreeInfo.getDefaultInstance()); } public List<DailyActivity.DegreeInfo.Builder> getS2CDegreeLsBuilderList() { return getS2CDegreeLsFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<DailyActivity.DegreeInfo, DailyActivity.DegreeInfo.Builder, DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsFieldBuilder() { if (this.s2CDegreeLsBuilder_ == null) { this.s2CDegreeLsBuilder_ = new RepeatedFieldBuilder(this.s2CDegreeLs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.s2CDegreeLs_ = null; }  return this.s2CDegreeLsBuilder_; } }
/* 4686 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 4691 */     String[] descriptorData = { "\n\032dailyActivityHandler.proto\022\013pomelo.area\032\fcommon.proto\032\023dailyActivity.proto\"\026\n\024DailyActivityRequest\"Ø\001\n\025DailyActivityResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0224\n\013s2c_dailyLs\030\003 \003(\0132\037.pomelo.dailyActivity.DailyInfo\022\027\n\017s2c_totalDegree\030\004 \001(\005\0226\n\fs2c_degreeLs\030\005 \003(\0132 .pomelo.dailyActivity.DegreeInfo\022\025\n\rs2c_weekIndex\030\006 \001(\005\"$\n\026GetDegreeRewardRequest\022\n\n\002id\030\001 \002(\005\"[\n\027GetDegreeRewardResponse\022\020\n\bs2c_code\030\001 \002", "(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\n\n\002id\030\003 \001(\005\022\021\n\ts2c_state\030\004 \001(\005\"\001\n\022UpdateActivityPush\0224\n\013s2c_dailyLs\030\001 \003(\0132\037.pomelo.dailyActivity.DailyInfo\022\027\n\017s2c_totalDegree\030\002 \001(\005\0226\n\fs2c_degreeLs\030\003 \003(\0132 .pomelo.dailyActivity.DegreeInfo2Ú\001\n\024dailyActivityHandler\022]\n\024dailyActivityRequest\022!.pomelo.area.DailyActivityRequest\032\".pomelo.area.DailyActivityResponse\022c\n\026getDegreeRewardRequest\022#.pomelo.area.GetDegreeRewardRequest\032$.pomelo", ".area.GetDegreeRewardResponse2X\n\021dailyActivityPush\022C\n\022updateActivityPush\022\037.pomelo.area.UpdateActivityPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4716 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 4720 */           DailyActivityHandler.descriptor = root;
/* 4721 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 4725 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 4727 */           Common.getDescriptor(), 
/* 4728 */           DailyActivity.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 4731 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DailyActivityRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 4732 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyActivityRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyActivityRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4737 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DailyActivityResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 4738 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyActivityResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyActivityResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CDailyLs", "S2CTotalDegree", "S2CDegreeLs", "S2CWeekIndex" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4743 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDegreeRewardRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 4744 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDegreeRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDegreeRewardRequest_descriptor, new String[] { "Id" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4749 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetDegreeRewardResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 4750 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDegreeRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDegreeRewardResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Id", "S2CState" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4755 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpdateActivityPush_descriptor = getDescriptor().getMessageTypes().get(4);
/* 4756 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpdateActivityPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpdateActivityPush_descriptor, new String[] { "S2CDailyLs", "S2CTotalDegree", "S2CDegreeLs" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 4760 */     Common.getDescriptor();
/* 4761 */     DailyActivity.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface UpdateActivityPushOrBuilder extends MessageOrBuilder {
/*      */     List<DailyActivity.DailyInfo> getS2CDailyLsList();
/*      */     
/*      */     DailyActivity.DailyInfo getS2CDailyLs(int param1Int);
/*      */     
/*      */     int getS2CDailyLsCount();
/*      */     
/*      */     List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList();
/*      */     
/*      */     DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int param1Int);
/*      */     
/*      */     boolean hasS2CTotalDegree();
/*      */     
/*      */     int getS2CTotalDegree();
/*      */     
/*      */     List<DailyActivity.DegreeInfo> getS2CDegreeLsList();
/*      */     
/*      */     DailyActivity.DegreeInfo getS2CDegreeLs(int param1Int);
/*      */     
/*      */     int getS2CDegreeLsCount();
/*      */     
/*      */     List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList();
/*      */     
/*      */     DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GetDegreeRewardResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasS2CState();
/*      */     
/*      */     int getS2CState();
/*      */   }
/*      */   
/*      */   public static interface GetDegreeRewardRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */   }
/*      */   
/*      */   public static interface DailyActivityResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<DailyActivity.DailyInfo> getS2CDailyLsList();
/*      */     
/*      */     DailyActivity.DailyInfo getS2CDailyLs(int param1Int);
/*      */     
/*      */     int getS2CDailyLsCount();
/*      */     
/*      */     List<? extends DailyActivity.DailyInfoOrBuilder> getS2CDailyLsOrBuilderList();
/*      */     
/*      */     DailyActivity.DailyInfoOrBuilder getS2CDailyLsOrBuilder(int param1Int);
/*      */     
/*      */     boolean hasS2CTotalDegree();
/*      */     
/*      */     int getS2CTotalDegree();
/*      */     
/*      */     List<DailyActivity.DegreeInfo> getS2CDegreeLsList();
/*      */     
/*      */     DailyActivity.DegreeInfo getS2CDegreeLs(int param1Int);
/*      */     
/*      */     int getS2CDegreeLsCount();
/*      */     
/*      */     List<? extends DailyActivity.DegreeInfoOrBuilder> getS2CDegreeLsOrBuilderList();
/*      */     
/*      */     DailyActivity.DegreeInfoOrBuilder getS2CDegreeLsOrBuilder(int param1Int);
/*      */     
/*      */     boolean hasS2CWeekIndex();
/*      */     
/*      */     int getS2CWeekIndex();
/*      */   }
/*      */   
/*      */   public static interface DailyActivityRequestOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\DailyActivityHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */