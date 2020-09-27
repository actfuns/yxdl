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
/*      */ import com.google.protobuf.LazyStringArrayList;
/*      */ import com.google.protobuf.LazyStringList;
/*      */ import com.google.protobuf.Message;
/*      */ import com.google.protobuf.MessageLite;
/*      */ import com.google.protobuf.MessageOrBuilder;
/*      */ import com.google.protobuf.Parser;
/*      */ import com.google.protobuf.ProtocolStringList;
/*      */ import com.google.protobuf.SingleFieldBuilder;
/*      */ import com.google.protobuf.UnknownFieldSet;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.ObjectStreamException;
/*      */ import java.util.Collection;
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
/*      */ public final class FashionHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetFashionsRequest
/*      */     extends GeneratedMessage
/*      */     implements GetFashionsRequestOrBuilder
/*      */   {
/*  325 */     private static final GetFashionsRequest defaultInstance = new GetFashionsRequest(true); private final UnknownFieldSet unknownFields; private GetFashionsRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetFashionsRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetFashionsRequest getDefaultInstance() { return defaultInstance; } public GetFashionsRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetFashionsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_GetFashionsRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_GetFashionsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFashionsRequest.class, Builder.class); } public static Parser<GetFashionsRequest> PARSER = (Parser<GetFashionsRequest>)new AbstractParser<GetFashionsRequest>() { public FashionHandler.GetFashionsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FashionHandler.GetFashionsRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetFashionsRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetFashionsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetFashionsRequest)PARSER.parseFrom(data); } public static GetFashionsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetFashionsRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetFashionsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetFashionsRequest)PARSER.parseFrom(data); } public static GetFashionsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetFashionsRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetFashionsRequest parseFrom(InputStream input) throws IOException { return (GetFashionsRequest)PARSER.parseFrom(input); } public static GetFashionsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetFashionsRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetFashionsRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetFashionsRequest)PARSER.parseDelimitedFrom(input); } public static GetFashionsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetFashionsRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetFashionsRequest parseFrom(CodedInputStream input) throws IOException { return (GetFashionsRequest)PARSER.parseFrom(input); } public static GetFashionsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetFashionsRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetFashionsRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FashionHandler.GetFashionsRequestOrBuilder {
/*  326 */       public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_GetFashionsRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_GetFashionsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionHandler.GetFashionsRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (FashionHandler.GetFashionsRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return FashionHandler.internal_static_pomelo_area_GetFashionsRequest_descriptor; } public FashionHandler.GetFashionsRequest getDefaultInstanceForType() { return FashionHandler.GetFashionsRequest.getDefaultInstance(); } public FashionHandler.GetFashionsRequest build() { FashionHandler.GetFashionsRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public FashionHandler.GetFashionsRequest buildPartial() { FashionHandler.GetFashionsRequest result = new FashionHandler.GetFashionsRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof FashionHandler.GetFashionsRequest) return mergeFrom((FashionHandler.GetFashionsRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(FashionHandler.GetFashionsRequest other) { if (other == FashionHandler.GetFashionsRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FashionHandler.GetFashionsRequest parsedMessage = null; try { parsedMessage = (FashionHandler.GetFashionsRequest)FashionHandler.GetFashionsRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FashionHandler.GetFashionsRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GetFashionsResponse
/*      */     extends GeneratedMessage
/*      */     implements GetFashionsResponseOrBuilder
/*      */   {
/* 2255 */     private static final GetFashionsResponse defaultInstance = new GetFashionsResponse(true); private final UnknownFieldSet unknownFields; private GetFashionsResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetFashionsResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetFashionsResponse getDefaultInstance() { return defaultInstance; } public GetFashionsResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetFashionsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); if ((mutable_bitField0_ & 0x4) != 4) { this.code1_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x4; }  this.code1_.add(bs); break;case 34: bs = input.readBytes(); if ((mutable_bitField0_ & 0x8) != 8) { this.code2_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x8; }  this.code2_.add(bs); break;case 42: bs = input.readBytes(); if ((mutable_bitField0_ & 0x10) != 16) { this.code3_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x10; }  this.code3_.add(bs); break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x4; this.equipedCode1_ = bs; break;case 58: bs = input.readBytes(); this.bitField0_ |= 0x8; this.equipedCode2_ = bs; break;case 66: bs = input.readBytes(); this.bitField0_ |= 0x10; this.equipedCode3_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.code1_ = this.code1_.getUnmodifiableView();  if ((mutable_bitField0_ & 0x8) == 8) this.code2_ = this.code2_.getUnmodifiableView();  if ((mutable_bitField0_ & 0x10) == 16) this.code3_ = this.code3_.getUnmodifiableView();  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_GetFashionsResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_GetFashionsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFashionsResponse.class, Builder.class); } public static Parser<GetFashionsResponse> PARSER = (Parser<GetFashionsResponse>)new AbstractParser<GetFashionsResponse>() { public FashionHandler.GetFashionsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FashionHandler.GetFashionsResponse(input, extensionRegistry); } }
/* 2256 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int CODE1_FIELD_NUMBER = 3; private LazyStringList code1_; public static final int CODE2_FIELD_NUMBER = 4; private LazyStringList code2_; public static final int CODE3_FIELD_NUMBER = 5; private LazyStringList code3_; public static final int EQUIPED_CODE1_FIELD_NUMBER = 6; private Object equipedCode1_; public static final int EQUIPED_CODE2_FIELD_NUMBER = 7; private Object equipedCode2_; public static final int EQUIPED_CODE3_FIELD_NUMBER = 8; private Object equipedCode3_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetFashionsResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public ProtocolStringList getCode1List() { return (ProtocolStringList)this.code1_; } public int getCode1Count() { return this.code1_.size(); } public String getCode1(int index) { return (String)this.code1_.get(index); } static { defaultInstance.initFields(); } public ByteString getCode1Bytes(int index) { return this.code1_.getByteString(index); } public ProtocolStringList getCode2List() {
/*      */       return (ProtocolStringList)this.code2_;
/*      */     } public int getCode2Count() {
/*      */       return this.code2_.size();
/*      */     } public String getCode2(int index) {
/*      */       return (String)this.code2_.get(index);
/*      */     } public ByteString getCode2Bytes(int index) {
/*      */       return this.code2_.getByteString(index);
/*      */     } public ProtocolStringList getCode3List() {
/*      */       return (ProtocolStringList)this.code3_;
/*      */     } public int getCode3Count() {
/*      */       return this.code3_.size();
/*      */     } public String getCode3(int index) {
/*      */       return (String)this.code3_.get(index);
/*      */     } public ByteString getCode3Bytes(int index) {
/*      */       return this.code3_.getByteString(index);
/*      */     } public boolean hasEquipedCode1() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     } public String getEquipedCode1() {
/*      */       Object ref = this.equipedCode1_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.equipedCode1_ = s; 
/*      */       return s;
/*      */     } public ByteString getEquipedCode1Bytes() {
/*      */       Object ref = this.equipedCode1_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.equipedCode1_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     } public boolean hasEquipedCode2() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     } public String getEquipedCode2() {
/*      */       Object ref = this.equipedCode2_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.equipedCode2_ = s; 
/*      */       return s;
/*      */     } public ByteString getEquipedCode2Bytes() {
/*      */       Object ref = this.equipedCode2_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.equipedCode2_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     } public boolean hasEquipedCode3() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     } public String getEquipedCode3() {
/*      */       Object ref = this.equipedCode3_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.equipedCode3_ = s; 
/*      */       return s;
/*      */     } public ByteString getEquipedCode3Bytes() {
/*      */       Object ref = this.equipedCode3_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.equipedCode3_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     } private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.code1_ = LazyStringArrayList.EMPTY;
/*      */       this.code2_ = LazyStringArrayList.EMPTY;
/*      */       this.code3_ = LazyStringArrayList.EMPTY;
/*      */       this.equipedCode1_ = "";
/*      */       this.equipedCode2_ = "";
/*      */       this.equipedCode3_ = "";
/*      */     } public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     } public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       int i;
/*      */       for (i = 0; i < this.code1_.size(); i++)
/*      */         output.writeBytes(3, this.code1_.getByteString(i)); 
/*      */       for (i = 0; i < this.code2_.size(); i++)
/*      */         output.writeBytes(4, this.code2_.getByteString(i)); 
/*      */       for (i = 0; i < this.code3_.size(); i++)
/*      */         output.writeBytes(5, this.code3_.getByteString(i)); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeBytes(6, getEquipedCode1Bytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeBytes(7, getEquipedCode2Bytes()); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeBytes(8, getEquipedCode3Bytes()); 
/*      */       getUnknownFields().writeTo(output);
/*      */     } public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       int dataSize = 0;
/*      */       int i;
/*      */       for (i = 0; i < this.code1_.size(); i++)
/*      */         dataSize += CodedOutputStream.computeBytesSizeNoTag(this.code1_.getByteString(i)); 
/*      */       size += dataSize;
/*      */       size += 1 * getCode1List().size();
/*      */       dataSize = 0;
/*      */       for (i = 0; i < this.code2_.size(); i++)
/*      */         dataSize += CodedOutputStream.computeBytesSizeNoTag(this.code2_.getByteString(i)); 
/*      */       size += dataSize;
/*      */       size += 1 * getCode2List().size();
/*      */       dataSize = 0;
/*      */       for (i = 0; i < this.code3_.size(); i++)
/*      */         dataSize += CodedOutputStream.computeBytesSizeNoTag(this.code3_.getByteString(i)); 
/*      */       size += dataSize;
/*      */       size += 1 * getCode3List().size();
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeBytesSize(6, getEquipedCode1Bytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeBytesSize(7, getEquipedCode2Bytes()); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeBytesSize(8, getEquipedCode3Bytes()); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     } protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     } public static GetFashionsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(data);
/*      */     } public static GetFashionsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static GetFashionsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(data);
/*      */     } public static GetFashionsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static GetFashionsResponse parseFrom(InputStream input) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(input);
/*      */     } public static GetFashionsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static GetFashionsResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseDelimitedFrom(input);
/*      */     } public static GetFashionsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static GetFashionsResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(input);
/*      */     } public static GetFashionsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFashionsResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     } public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     } public static Builder newBuilder(GetFashionsResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     } public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FashionHandler.GetFashionsResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private LazyStringList code1_; private LazyStringList code2_; private LazyStringList code3_; private Object equipedCode1_; private Object equipedCode2_; private Object equipedCode3_; public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FashionHandler.internal_static_pomelo_area_GetFashionsResponse_descriptor;
/*      */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FashionHandler.internal_static_pomelo_area_GetFashionsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionHandler.GetFashionsResponse.class, Builder.class);
/*      */       } private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.code1_ = LazyStringArrayList.EMPTY;
/*      */         this.code2_ = LazyStringArrayList.EMPTY;
/*      */         this.code3_ = LazyStringArrayList.EMPTY;
/*      */         this.equipedCode1_ = "";
/*      */         this.equipedCode2_ = "";
/*      */         this.equipedCode3_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.code1_ = LazyStringArrayList.EMPTY;
/*      */         this.code2_ = LazyStringArrayList.EMPTY;
/*      */         this.code3_ = LazyStringArrayList.EMPTY;
/*      */         this.equipedCode1_ = "";
/*      */         this.equipedCode2_ = "";
/*      */         this.equipedCode3_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       } private void maybeForceBuilderInitialization() {
/*      */         if (FashionHandler.GetFashionsResponse.alwaysUseFieldBuilders);
/*      */       } private static Builder create() {
/*      */         return new Builder();
/*      */       } public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.code1_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.code2_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.code3_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.equipedCode1_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.equipedCode2_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.equipedCode3_ = "";
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         return this;
/*      */       } public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       } public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FashionHandler.internal_static_pomelo_area_GetFashionsResponse_descriptor;
/*      */       } public FashionHandler.GetFashionsResponse getDefaultInstanceForType() {
/*      */         return FashionHandler.GetFashionsResponse.getDefaultInstance();
/*      */       } public FashionHandler.GetFashionsResponse build() {
/*      */         FashionHandler.GetFashionsResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       } public FashionHandler.GetFashionsResponse buildPartial() {
/*      */         FashionHandler.GetFashionsResponse result = new FashionHandler.GetFashionsResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if ((this.bitField0_ & 0x4) == 4) {
/*      */           this.code1_ = this.code1_.getUnmodifiableView();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } 
/*      */         result.code1_ = this.code1_;
/*      */         if ((this.bitField0_ & 0x8) == 8) {
/*      */           this.code2_ = this.code2_.getUnmodifiableView();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */         } 
/*      */         result.code2_ = this.code2_;
/*      */         if ((this.bitField0_ & 0x10) == 16) {
/*      */           this.code3_ = this.code3_.getUnmodifiableView();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */         } 
/*      */         result.code3_ = this.code3_;
/*      */         if ((from_bitField0_ & 0x20) == 32)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.equipedCode1_ = this.equipedCode1_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.equipedCode2_ = this.equipedCode2_;
/*      */         if ((from_bitField0_ & 0x80) == 128)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.equipedCode3_ = this.equipedCode3_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       } public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FashionHandler.GetFashionsResponse)
/*      */           return mergeFrom((FashionHandler.GetFashionsResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       } public Builder mergeFrom(FashionHandler.GetFashionsResponse other) {
/*      */         if (other == FashionHandler.GetFashionsResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (!other.code1_.isEmpty()) {
/*      */           if (this.code1_.isEmpty()) {
/*      */             this.code1_ = other.code1_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } else {
/*      */             ensureCode1IsMutable();
/*      */             this.code1_.addAll((Collection)other.code1_);
/*      */           } 
/*      */           onChanged();
/*      */         } 
/*      */         if (!other.code2_.isEmpty()) {
/*      */           if (this.code2_.isEmpty()) {
/*      */             this.code2_ = other.code2_;
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */           } else {
/*      */             ensureCode2IsMutable();
/*      */             this.code2_.addAll((Collection)other.code2_);
/*      */           } 
/*      */           onChanged();
/*      */         } 
/*      */         if (!other.code3_.isEmpty()) {
/*      */           if (this.code3_.isEmpty()) {
/*      */             this.code3_ = other.code3_;
/*      */             this.bitField0_ &= 0xFFFFFFEF;
/*      */           } else {
/*      */             ensureCode3IsMutable();
/*      */             this.code3_.addAll((Collection)other.code3_);
/*      */           } 
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasEquipedCode1()) {
/*      */           this.bitField0_ |= 0x20;
/*      */           this.equipedCode1_ = other.equipedCode1_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasEquipedCode2()) {
/*      */           this.bitField0_ |= 0x40;
/*      */           this.equipedCode2_ = other.equipedCode2_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasEquipedCode3()) {
/*      */           this.bitField0_ |= 0x80;
/*      */           this.equipedCode3_ = other.equipedCode3_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       } public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         return true;
/*      */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FashionHandler.GetFashionsResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FashionHandler.GetFashionsResponse)FashionHandler.GetFashionsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FashionHandler.GetFashionsResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = FashionHandler.GetFashionsResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } private void ensureCode1IsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.code1_ = (LazyStringList)new LazyStringArrayList(this.code1_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       } public ProtocolStringList getCode1List() {
/*      */         return (ProtocolStringList)this.code1_.getUnmodifiableView();
/*      */       } public int getCode1Count() {
/*      */         return this.code1_.size();
/*      */       } public String getCode1(int index) {
/*      */         return (String)this.code1_.get(index);
/*      */       } public ByteString getCode1Bytes(int index) {
/*      */         return this.code1_.getByteString(index);
/*      */       } public Builder setCode1(int index, String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode1IsMutable();
/*      */         this.code1_.set(index, value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode1(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode1IsMutable();
/*      */         this.code1_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addAllCode1(Iterable<String> values) {
/*      */         ensureCode1IsMutable();
/*      */         AbstractMessageLite.Builder.addAll(values, (Collection)this.code1_);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearCode1() {
/*      */         this.code1_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode1Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode1IsMutable();
/*      */         this.code1_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } private void ensureCode2IsMutable() {
/*      */         if ((this.bitField0_ & 0x8) != 8) {
/*      */           this.code2_ = (LazyStringList)new LazyStringArrayList(this.code2_);
/*      */           this.bitField0_ |= 0x8;
/*      */         } 
/*      */       } public ProtocolStringList getCode2List() {
/*      */         return (ProtocolStringList)this.code2_.getUnmodifiableView();
/*      */       } public int getCode2Count() {
/*      */         return this.code2_.size();
/*      */       } public String getCode2(int index) {
/*      */         return (String)this.code2_.get(index);
/*      */       } public ByteString getCode2Bytes(int index) {
/*      */         return this.code2_.getByteString(index);
/*      */       } public Builder setCode2(int index, String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode2IsMutable();
/*      */         this.code2_.set(index, value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode2(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode2IsMutable();
/*      */         this.code2_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addAllCode2(Iterable<String> values) {
/*      */         ensureCode2IsMutable();
/*      */         AbstractMessageLite.Builder.addAll(values, (Collection)this.code2_);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearCode2() {
/*      */         this.code2_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode2Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode2IsMutable();
/*      */         this.code2_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } private void ensureCode3IsMutable() {
/*      */         if ((this.bitField0_ & 0x10) != 16) {
/*      */           this.code3_ = (LazyStringList)new LazyStringArrayList(this.code3_);
/*      */           this.bitField0_ |= 0x10;
/*      */         } 
/*      */       } public ProtocolStringList getCode3List() {
/*      */         return (ProtocolStringList)this.code3_.getUnmodifiableView();
/*      */       } public int getCode3Count() {
/*      */         return this.code3_.size();
/*      */       } public String getCode3(int index) {
/*      */         return (String)this.code3_.get(index);
/*      */       } public ByteString getCode3Bytes(int index) {
/*      */         return this.code3_.getByteString(index);
/*      */       } public Builder setCode3(int index, String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode3IsMutable();
/*      */         this.code3_.set(index, value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode3(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode3IsMutable();
/*      */         this.code3_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addAllCode3(Iterable<String> values) {
/*      */         ensureCode3IsMutable();
/*      */         AbstractMessageLite.Builder.addAll(values, (Collection)this.code3_);
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearCode3() {
/*      */         this.code3_ = LazyStringArrayList.EMPTY;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder addCode3Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         ensureCode3IsMutable();
/*      */         this.code3_.add(value);
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasEquipedCode1() {
/*      */         return ((this.bitField0_ & 0x20) == 32);
/*      */       } public String getEquipedCode1() {
/*      */         Object ref = this.equipedCode1_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.equipedCode1_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getEquipedCode1Bytes() {
/*      */         Object ref = this.equipedCode1_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.equipedCode1_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setEquipedCode1(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x20;
/*      */         this.equipedCode1_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearEquipedCode1() {
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.equipedCode1_ = FashionHandler.GetFashionsResponse.getDefaultInstance().getEquipedCode1();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setEquipedCode1Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x20;
/*      */         this.equipedCode1_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasEquipedCode2() {
/*      */         return ((this.bitField0_ & 0x40) == 64);
/*      */       } public String getEquipedCode2() {
/*      */         Object ref = this.equipedCode2_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.equipedCode2_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getEquipedCode2Bytes() {
/*      */         Object ref = this.equipedCode2_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.equipedCode2_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setEquipedCode2(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x40;
/*      */         this.equipedCode2_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearEquipedCode2() {
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.equipedCode2_ = FashionHandler.GetFashionsResponse.getDefaultInstance().getEquipedCode2();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setEquipedCode2Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x40;
/*      */         this.equipedCode2_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasEquipedCode3() {
/*      */         return ((this.bitField0_ & 0x80) == 128);
/*      */       } public String getEquipedCode3() {
/*      */         Object ref = this.equipedCode3_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.equipedCode3_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getEquipedCode3Bytes() {
/*      */         Object ref = this.equipedCode3_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.equipedCode3_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setEquipedCode3(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x80;
/*      */         this.equipedCode3_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearEquipedCode3() {
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.equipedCode3_ = FashionHandler.GetFashionsResponse.getDefaultInstance().getEquipedCode3();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder setEquipedCode3Bytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x80;
/*      */         this.equipedCode3_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } } }
/* 2913 */   public static final class EquipFashionRequest extends GeneratedMessage implements EquipFashionRequestOrBuilder { private static final EquipFashionRequest defaultInstance = new EquipFashionRequest(true); private final UnknownFieldSet unknownFields; private EquipFashionRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipFashionRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipFashionRequest getDefaultInstance() { return defaultInstance; } public EquipFashionRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipFashionRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.code_ = bs; break;case 16: this.bitField0_ |= 0x2; this.ison_ = input.readBool(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_EquipFashionRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_EquipFashionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipFashionRequest.class, Builder.class); } public static Parser<EquipFashionRequest> PARSER = (Parser<EquipFashionRequest>)new AbstractParser<EquipFashionRequest>() { public FashionHandler.EquipFashionRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FashionHandler.EquipFashionRequest(input, extensionRegistry); } }
/* 2914 */     ; private int bitField0_; public static final int CODE_FIELD_NUMBER = 1; private Object code_; public static final int ISON_FIELD_NUMBER = 2; private boolean ison_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipFashionRequest> getParserForType() { return PARSER; } public boolean hasCode() { return ((this.bitField0_ & 0x1) == 1); } public String getCode() { Object ref = this.code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasIson() {
/*      */       return ((this.bitField0_ & 0x2) == 2);
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
/*      */     public boolean getIson() {
/*      */       return this.ison_;
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
/*      */     private void initFields() {
/*      */       this.code_ = "";
/*      */       this.ison_ = false;
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
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasIson()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBool(2, this.ison_);
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
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeBytesSize(1, getCodeBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBoolSize(2, this.ison_);
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
/*      */     public static EquipFashionRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(data);
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
/*      */     public static EquipFashionRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static EquipFashionRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(data);
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
/*      */     public static EquipFashionRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static EquipFashionRequest parseFrom(InputStream input) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(input);
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
/*      */     public static EquipFashionRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static EquipFashionRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseDelimitedFrom(input);
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
/*      */     public static EquipFashionRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     public static EquipFashionRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(input);
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
/*      */     public static EquipFashionRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(EquipFashionRequest prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements FashionHandler.EquipFashionRequestOrBuilder
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
/*      */       private Object code_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private boolean ison_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionRequest_descriptor;
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
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionHandler.EquipFashionRequest.class, Builder.class);
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
/*      */       private Builder() {
/*      */         this.code_ = "";
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
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.code_ = "";
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
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FashionHandler.EquipFashionRequest.alwaysUseFieldBuilders);
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.code_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.ison_ = false;
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
/*      */ 
/*      */ 
/*      */ 
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionRequest_descriptor;
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
/*      */       public FashionHandler.EquipFashionRequest getDefaultInstanceForType() {
/*      */         return FashionHandler.EquipFashionRequest.getDefaultInstance();
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
/*      */       public FashionHandler.EquipFashionRequest build() {
/*      */         FashionHandler.EquipFashionRequest result = buildPartial();
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
/*      */       public FashionHandler.EquipFashionRequest buildPartial() {
/*      */         FashionHandler.EquipFashionRequest result = new FashionHandler.EquipFashionRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.code_ = this.code_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.ison_ = this.ison_;
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FashionHandler.EquipFashionRequest) {
/*      */           return mergeFrom((FashionHandler.EquipFashionRequest)other);
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
/*      */       public Builder mergeFrom(FashionHandler.EquipFashionRequest other) {
/*      */         if (other == FashionHandler.EquipFashionRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasCode()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.code_ = other.code_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasIson()) {
/*      */           setIson(other.getIson());
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasCode()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasIson()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FashionHandler.EquipFashionRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FashionHandler.EquipFashionRequest)FashionHandler.EquipFashionRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FashionHandler.EquipFashionRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasCode() {
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
/*      */       public String getCode() {
/*      */         Object ref = this.code_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.code_ = s;
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
/*      */       public ByteString getCodeBytes() {
/*      */         Object ref = this.code_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.code_ = b;
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
/*      */       public Builder setCode(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.code_ = value;
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
/*      */       public Builder clearCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.code_ = FashionHandler.EquipFashionRequest.getDefaultInstance().getCode();
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
/*      */       public Builder setCodeBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.code_ = value;
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
/*      */       public boolean hasIson() {
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
/*      */       public boolean getIson() {
/*      */         return this.ison_;
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
/*      */       public Builder setIson(boolean value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.ison_ = value;
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
/*      */       public Builder clearIson() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.ison_ = false;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class EquipFashionResponse
/*      */     extends GeneratedMessage
/*      */     implements EquipFashionResponseOrBuilder
/*      */   {
/* 4258 */     private static final EquipFashionResponse defaultInstance = new EquipFashionResponse(true); private final UnknownFieldSet unknownFields; private EquipFashionResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private EquipFashionResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static EquipFashionResponse getDefaultInstance() { return defaultInstance; } public EquipFashionResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private EquipFashionResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; Common.Avatar.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.equipedCode1_.toBuilder();  this.equipedCode1_ = (Common.Avatar)input.readMessage(Common.Avatar.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.equipedCode1_); this.equipedCode1_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break;case 34: subBuilder = null; if ((this.bitField0_ & 0x8) == 8) subBuilder = this.equipedCode2_.toBuilder();  this.equipedCode2_ = (Common.Avatar)input.readMessage(Common.Avatar.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.equipedCode2_); this.equipedCode2_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x8; break;case 42: subBuilder = null; if ((this.bitField0_ & 0x10) == 16) subBuilder = this.equipedCode3_.toBuilder();  this.equipedCode3_ = (Common.Avatar)input.readMessage(Common.Avatar.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.equipedCode3_); this.equipedCode3_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x10; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_EquipFashionResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_EquipFashionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EquipFashionResponse.class, Builder.class); } public static Parser<EquipFashionResponse> PARSER = (Parser<EquipFashionResponse>)new AbstractParser<EquipFashionResponse>() { public FashionHandler.EquipFashionResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FashionHandler.EquipFashionResponse(input, extensionRegistry); } }
/* 4259 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int EQUIPED_CODE1_FIELD_NUMBER = 3; private Common.Avatar equipedCode1_; public static final int EQUIPED_CODE2_FIELD_NUMBER = 4; private Common.Avatar equipedCode2_; public static final int EQUIPED_CODE3_FIELD_NUMBER = 5; private Common.Avatar equipedCode3_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<EquipFashionResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */     
/*      */     public boolean hasEquipedCode1() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */     public Common.Avatar getEquipedCode1() {
/*      */       return this.equipedCode1_;
/*      */     }
/*      */     public Common.AvatarOrBuilder getEquipedCode1OrBuilder() {
/*      */       return (Common.AvatarOrBuilder)this.equipedCode1_;
/*      */     }
/*      */     public boolean hasEquipedCode2() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */     public Common.Avatar getEquipedCode2() {
/*      */       return this.equipedCode2_;
/*      */     }
/*      */     public Common.AvatarOrBuilder getEquipedCode2OrBuilder() {
/*      */       return (Common.AvatarOrBuilder)this.equipedCode2_;
/*      */     }
/*      */     public boolean hasEquipedCode3() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */     public Common.Avatar getEquipedCode3() {
/*      */       return this.equipedCode3_;
/*      */     }
/*      */     public Common.AvatarOrBuilder getEquipedCode3OrBuilder() {
/*      */       return (Common.AvatarOrBuilder)this.equipedCode3_;
/*      */     }
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.equipedCode1_ = Common.Avatar.getDefaultInstance();
/*      */       this.equipedCode2_ = Common.Avatar.getDefaultInstance();
/*      */       this.equipedCode3_ = Common.Avatar.getDefaultInstance();
/*      */     }
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (hasEquipedCode1() && !getEquipedCode1().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (hasEquipedCode2() && !getEquipedCode2().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (hasEquipedCode3() && !getEquipedCode3().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeMessage(3, (MessageLite)this.equipedCode1_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeMessage(4, (MessageLite)this.equipedCode2_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeMessage(5, (MessageLite)this.equipedCode3_); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.equipedCode1_); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.equipedCode2_); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.equipedCode3_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(InputStream input) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static EquipFashionResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     public static EquipFashionResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static EquipFashionResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (EquipFashionResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     public static Builder newBuilder(EquipFashionResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FashionHandler.EquipFashionResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Common.Avatar equipedCode1_; private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> equipedCode1Builder_; private Common.Avatar equipedCode2_; private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> equipedCode2Builder_; private Common.Avatar equipedCode3_; private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> equipedCode3Builder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionResponse_descriptor;
/*      */       }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionHandler.EquipFashionResponse.class, Builder.class);
/*      */       }
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.equipedCode1_ = Common.Avatar.getDefaultInstance();
/*      */         this.equipedCode2_ = Common.Avatar.getDefaultInstance();
/*      */         this.equipedCode3_ = Common.Avatar.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.equipedCode1_ = Common.Avatar.getDefaultInstance();
/*      */         this.equipedCode2_ = Common.Avatar.getDefaultInstance();
/*      */         this.equipedCode3_ = Common.Avatar.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FashionHandler.EquipFashionResponse.alwaysUseFieldBuilders) {
/*      */           getEquipedCode1FieldBuilder();
/*      */           getEquipedCode2FieldBuilder();
/*      */           getEquipedCode3FieldBuilder();
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
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           this.equipedCode1_ = Common.Avatar.getDefaultInstance();
/*      */         } else {
/*      */           this.equipedCode1Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           this.equipedCode2_ = Common.Avatar.getDefaultInstance();
/*      */         } else {
/*      */           this.equipedCode2Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           this.equipedCode3_ = Common.Avatar.getDefaultInstance();
/*      */         } else {
/*      */           this.equipedCode3Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FashionHandler.internal_static_pomelo_area_EquipFashionResponse_descriptor;
/*      */       }
/*      */       
/*      */       public FashionHandler.EquipFashionResponse getDefaultInstanceForType() {
/*      */         return FashionHandler.EquipFashionResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public FashionHandler.EquipFashionResponse build() {
/*      */         FashionHandler.EquipFashionResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public FashionHandler.EquipFashionResponse buildPartial() {
/*      */         FashionHandler.EquipFashionResponse result = new FashionHandler.EquipFashionResponse(this);
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
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           result.equipedCode1_ = this.equipedCode1_;
/*      */         } else {
/*      */           result.equipedCode1_ = (Common.Avatar)this.equipedCode1Builder_.build();
/*      */         } 
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           result.equipedCode2_ = this.equipedCode2_;
/*      */         } else {
/*      */           result.equipedCode2_ = (Common.Avatar)this.equipedCode2Builder_.build();
/*      */         } 
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x10; 
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           result.equipedCode3_ = this.equipedCode3_;
/*      */         } else {
/*      */           result.equipedCode3_ = (Common.Avatar)this.equipedCode3Builder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FashionHandler.EquipFashionResponse)
/*      */           return mergeFrom((FashionHandler.EquipFashionResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(FashionHandler.EquipFashionResponse other) {
/*      */         if (other == FashionHandler.EquipFashionResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasEquipedCode1())
/*      */           mergeEquipedCode1(other.getEquipedCode1()); 
/*      */         if (other.hasEquipedCode2())
/*      */           mergeEquipedCode2(other.getEquipedCode2()); 
/*      */         if (other.hasEquipedCode3())
/*      */           mergeEquipedCode3(other.getEquipedCode3()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         if (hasEquipedCode1() && !getEquipedCode1().isInitialized())
/*      */           return false; 
/*      */         if (hasEquipedCode2() && !getEquipedCode2().isInitialized())
/*      */           return false; 
/*      */         if (hasEquipedCode3() && !getEquipedCode3().isInitialized())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FashionHandler.EquipFashionResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FashionHandler.EquipFashionResponse)FashionHandler.EquipFashionResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FashionHandler.EquipFashionResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = FashionHandler.EquipFashionResponse.getDefaultInstance().getS2CMsg();
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
/*      */       public boolean hasEquipedCode1() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public Common.Avatar getEquipedCode1() {
/*      */         if (this.equipedCode1Builder_ == null)
/*      */           return this.equipedCode1_; 
/*      */         return (Common.Avatar)this.equipedCode1Builder_.getMessage();
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode1(Common.Avatar value) {
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.equipedCode1_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode1Builder_.setMessage((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode1(Common.Avatar.Builder builderForValue) {
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           this.equipedCode1_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode1Builder_.setMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeEquipedCode1(Common.Avatar value) {
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4 && this.equipedCode1_ != Common.Avatar.getDefaultInstance()) {
/*      */             this.equipedCode1_ = Common.Avatar.newBuilder(this.equipedCode1_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.equipedCode1_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode1Builder_.mergeFrom((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearEquipedCode1() {
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           this.equipedCode1_ = Common.Avatar.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode1Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Common.Avatar.Builder getEquipedCode1Builder() {
/*      */         this.bitField0_ |= 0x4;
/*      */         onChanged();
/*      */         return (Common.Avatar.Builder)getEquipedCode1FieldBuilder().getBuilder();
/*      */       }
/*      */       
/*      */       public Common.AvatarOrBuilder getEquipedCode1OrBuilder() {
/*      */         if (this.equipedCode1Builder_ != null)
/*      */           return (Common.AvatarOrBuilder)this.equipedCode1Builder_.getMessageOrBuilder(); 
/*      */         return (Common.AvatarOrBuilder)this.equipedCode1_;
/*      */       }
/*      */       
/*      */       private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getEquipedCode1FieldBuilder() {
/*      */         if (this.equipedCode1Builder_ == null) {
/*      */           this.equipedCode1Builder_ = new SingleFieldBuilder((GeneratedMessage)getEquipedCode1(), getParentForChildren(), isClean());
/*      */           this.equipedCode1_ = null;
/*      */         } 
/*      */         return this.equipedCode1Builder_;
/*      */       }
/*      */       
/*      */       public boolean hasEquipedCode2() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       
/*      */       public Common.Avatar getEquipedCode2() {
/*      */         if (this.equipedCode2Builder_ == null)
/*      */           return this.equipedCode2_; 
/*      */         return (Common.Avatar)this.equipedCode2Builder_.getMessage();
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode2(Common.Avatar value) {
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.equipedCode2_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode2Builder_.setMessage((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode2(Common.Avatar.Builder builderForValue) {
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           this.equipedCode2_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode2Builder_.setMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeEquipedCode2(Common.Avatar value) {
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           if ((this.bitField0_ & 0x8) == 8 && this.equipedCode2_ != Common.Avatar.getDefaultInstance()) {
/*      */             this.equipedCode2_ = Common.Avatar.newBuilder(this.equipedCode2_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.equipedCode2_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode2Builder_.mergeFrom((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x8;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearEquipedCode2() {
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           this.equipedCode2_ = Common.Avatar.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode2Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Common.Avatar.Builder getEquipedCode2Builder() {
/*      */         this.bitField0_ |= 0x8;
/*      */         onChanged();
/*      */         return (Common.Avatar.Builder)getEquipedCode2FieldBuilder().getBuilder();
/*      */       }
/*      */       
/*      */       public Common.AvatarOrBuilder getEquipedCode2OrBuilder() {
/*      */         if (this.equipedCode2Builder_ != null)
/*      */           return (Common.AvatarOrBuilder)this.equipedCode2Builder_.getMessageOrBuilder(); 
/*      */         return (Common.AvatarOrBuilder)this.equipedCode2_;
/*      */       }
/*      */       
/*      */       private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getEquipedCode2FieldBuilder() {
/*      */         if (this.equipedCode2Builder_ == null) {
/*      */           this.equipedCode2Builder_ = new SingleFieldBuilder((GeneratedMessage)getEquipedCode2(), getParentForChildren(), isClean());
/*      */           this.equipedCode2_ = null;
/*      */         } 
/*      */         return this.equipedCode2Builder_;
/*      */       }
/*      */       
/*      */       public boolean hasEquipedCode3() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */       
/*      */       public Common.Avatar getEquipedCode3() {
/*      */         if (this.equipedCode3Builder_ == null)
/*      */           return this.equipedCode3_; 
/*      */         return (Common.Avatar)this.equipedCode3Builder_.getMessage();
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode3(Common.Avatar value) {
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.equipedCode3_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode3Builder_.setMessage((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x10;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setEquipedCode3(Common.Avatar.Builder builderForValue) {
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           this.equipedCode3_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode3Builder_.setMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x10;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeEquipedCode3(Common.Avatar value) {
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           if ((this.bitField0_ & 0x10) == 16 && this.equipedCode3_ != Common.Avatar.getDefaultInstance()) {
/*      */             this.equipedCode3_ = Common.Avatar.newBuilder(this.equipedCode3_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.equipedCode3_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode3Builder_.mergeFrom((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x10;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearEquipedCode3() {
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           this.equipedCode3_ = Common.Avatar.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.equipedCode3Builder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Common.Avatar.Builder getEquipedCode3Builder() {
/*      */         this.bitField0_ |= 0x10;
/*      */         onChanged();
/*      */         return (Common.Avatar.Builder)getEquipedCode3FieldBuilder().getBuilder();
/*      */       }
/*      */       
/*      */       public Common.AvatarOrBuilder getEquipedCode3OrBuilder() {
/*      */         if (this.equipedCode3Builder_ != null)
/*      */           return (Common.AvatarOrBuilder)this.equipedCode3Builder_.getMessageOrBuilder(); 
/*      */         return (Common.AvatarOrBuilder)this.equipedCode3_;
/*      */       }
/*      */       
/*      */       private SingleFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getEquipedCode3FieldBuilder() {
/*      */         if (this.equipedCode3Builder_ == null) {
/*      */           this.equipedCode3Builder_ = new SingleFieldBuilder((GeneratedMessage)getEquipedCode3(), getParentForChildren(), isClean());
/*      */           this.equipedCode3_ = null;
/*      */         } 
/*      */         return this.equipedCode3Builder_;
/*      */       } } }
/*      */   
/* 4884 */   public static final class FashionGetPush extends GeneratedMessage implements FashionGetPushOrBuilder { private static final FashionGetPush defaultInstance = new FashionGetPush(true); private final UnknownFieldSet unknownFields; private FashionGetPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FashionGetPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FashionGetPush getDefaultInstance() { return defaultInstance; } public FashionGetPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FashionGetPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.code_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_FashionGetPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_FashionGetPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionGetPush.class, Builder.class); } public static Parser<FashionGetPush> PARSER = (Parser<FashionGetPush>)new AbstractParser<FashionGetPush>() { public FashionHandler.FashionGetPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FashionHandler.FashionGetPush(input, extensionRegistry); } }
/* 4885 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int CODE_FIELD_NUMBER = 2; private Object code_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FashionGetPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasCode() { return ((this.bitField0_ & 0x2) == 2); } public String getCode() { Object ref = this.code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.code_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getCodeBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getCodeBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FashionGetPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FashionGetPush)PARSER.parseFrom(data); } public static FashionGetPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FashionGetPush)PARSER.parseFrom(data, extensionRegistry); } public static FashionGetPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FashionGetPush)PARSER.parseFrom(data); } public static FashionGetPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FashionGetPush)PARSER.parseFrom(data, extensionRegistry); } public static FashionGetPush parseFrom(InputStream input) throws IOException { return (FashionGetPush)PARSER.parseFrom(input); } static { defaultInstance.initFields(); }
/*      */     public static FashionGetPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FashionGetPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static FashionGetPush parseDelimitedFrom(InputStream input) throws IOException { return (FashionGetPush)PARSER.parseDelimitedFrom(input); }
/*      */     public static FashionGetPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FashionGetPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static FashionGetPush parseFrom(CodedInputStream input) throws IOException { return (FashionGetPush)PARSER.parseFrom(input); }
/*      */     public static FashionGetPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FashionGetPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(FashionGetPush prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FashionHandler.FashionGetPushOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object code_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return FashionHandler.internal_static_pomelo_area_FashionGetPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FashionHandler.internal_static_pomelo_area_FashionGetPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FashionHandler.FashionGetPush.class, Builder.class); }
/*      */       private Builder() { this.code_ = ""; maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.code_ = ""; maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (FashionHandler.FashionGetPush.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.code_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return FashionHandler.internal_static_pomelo_area_FashionGetPush_descriptor; }
/*      */       public FashionHandler.FashionGetPush getDefaultInstanceForType() { return FashionHandler.FashionGetPush.getDefaultInstance(); }
/*      */       public FashionHandler.FashionGetPush build() { FashionHandler.FashionGetPush result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public FashionHandler.FashionGetPush buildPartial() { FashionHandler.FashionGetPush result = new FashionHandler.FashionGetPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.code_ = this.code_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof FashionHandler.FashionGetPush) return mergeFrom((FashionHandler.FashionGetPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(FashionHandler.FashionGetPush other) { if (other == FashionHandler.FashionGetPush.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasCode()) { this.bitField0_ |= 0x2; this.code_ = other.code_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasCode()) return false;  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FashionHandler.FashionGetPush parsedMessage = null; try { parsedMessage = (FashionHandler.FashionGetPush)FashionHandler.FashionGetPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (FashionHandler.FashionGetPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasCode() { return ((this.bitField0_ & 0x2) == 2); } public String getCode() { Object ref = this.code_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; }  return (String)ref; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } public Builder setCode(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.code_ = value; onChanged(); return this; } public Builder clearCode() { this.bitField0_ &= 0xFFFFFFFD; this.code_ = FashionHandler.FashionGetPush.getDefaultInstance().getCode(); onChanged(); return this; } public Builder setCodeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.code_ = value; onChanged(); return this; } } }
/* 4919 */    public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 4924 */     String[] descriptorData = { "\n\024fashionHandler.proto\022\013pomelo.area\032\fcommon.proto\"\024\n\022GetFashionsRequest\"ª\001\n\023GetFashionsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\r\n\005code1\030\003 \003(\t\022\r\n\005code2\030\004 \003(\t\022\r\n\005code3\030\005 \003(\t\022\025\n\requiped_code1\030\006 \001(\t\022\025\n\requiped_code2\030\007 \001(\t\022\025\n\requiped_code3\030\b \001(\t\"1\n\023EquipFashionRequest\022\f\n\004code\030\001 \002(\t\022\f\n\004ison\030\002 \002(\b\"®\001\n\024EquipFashionResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022%\n\requiped_code1\030\003 \001(\0132\016.pomelo.Avatar\022%\n\req", "uiped_code2\030\004 \001(\0132\016.pomelo.Avatar\022%\n\requiped_code3\030\005 \001(\0132\016.pomelo.Avatar\"0\n\016FashionGetPush\022\020\n\bs2c_code\030\001 \002(\005\022\f\n\004code\030\002 \002(\t2Å\001\n\016fashionHandler\022Z\n\023equipFashionRequest\022 .pomelo.area.EquipFashionRequest\032!.pomelo.area.EquipFashionResponse\022W\n\022getFashionsRequest\022\037.pomelo.area.GetFashionsRequest\032 .pomelo.area.GetFashionsResponse2L\n\013fashionPush\022=\n\020onFashionGetPush\022\033.pomelo.area.FashionGetPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4946 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 4950 */           FashionHandler.descriptor = root;
/* 4951 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 4955 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 4957 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 4960 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetFashionsRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 4961 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFashionsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFashionsRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4966 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetFashionsResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 4967 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFashionsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFashionsResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Code1", "Code2", "Code3", "EquipedCode1", "EquipedCode2", "EquipedCode3" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4972 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipFashionRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 4973 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipFashionRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipFashionRequest_descriptor, new String[] { "Code", "Ison" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4978 */   private static final Descriptors.Descriptor internal_static_pomelo_area_EquipFashionResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 4979 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EquipFashionResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EquipFashionResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "EquipedCode1", "EquipedCode2", "EquipedCode3" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 4984 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FashionGetPush_descriptor = getDescriptor().getMessageTypes().get(4);
/* 4985 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FashionGetPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FashionGetPush_descriptor, new String[] { "S2CCode", "Code" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 4989 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface FashionGetPushOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasCode();
/*      */     
/*      */     String getCode();
/*      */     
/*      */     ByteString getCodeBytes();
/*      */   }
/*      */   
/*      */   public static interface EquipFashionResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasEquipedCode1();
/*      */     
/*      */     Common.Avatar getEquipedCode1();
/*      */     
/*      */     Common.AvatarOrBuilder getEquipedCode1OrBuilder();
/*      */     
/*      */     boolean hasEquipedCode2();
/*      */     
/*      */     Common.Avatar getEquipedCode2();
/*      */     
/*      */     Common.AvatarOrBuilder getEquipedCode2OrBuilder();
/*      */     
/*      */     boolean hasEquipedCode3();
/*      */     
/*      */     Common.Avatar getEquipedCode3();
/*      */     
/*      */     Common.AvatarOrBuilder getEquipedCode3OrBuilder();
/*      */   }
/*      */   
/*      */   public static interface EquipFashionRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasCode();
/*      */     
/*      */     String getCode();
/*      */     
/*      */     ByteString getCodeBytes();
/*      */     
/*      */     boolean hasIson();
/*      */     
/*      */     boolean getIson();
/*      */   }
/*      */   
/*      */   public static interface GetFashionsResponseOrBuilder extends MessageOrBuilder {
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
/*      */     ProtocolStringList getCode1List();
/*      */     
/*      */     int getCode1Count();
/*      */     
/*      */     String getCode1(int param1Int);
/*      */     
/*      */     ByteString getCode1Bytes(int param1Int);
/*      */     
/*      */     ProtocolStringList getCode2List();
/*      */     
/*      */     int getCode2Count();
/*      */     
/*      */     String getCode2(int param1Int);
/*      */     
/*      */     ByteString getCode2Bytes(int param1Int);
/*      */     
/*      */     ProtocolStringList getCode3List();
/*      */     
/*      */     int getCode3Count();
/*      */     
/*      */     String getCode3(int param1Int);
/*      */     
/*      */     ByteString getCode3Bytes(int param1Int);
/*      */     
/*      */     boolean hasEquipedCode1();
/*      */     
/*      */     String getEquipedCode1();
/*      */     
/*      */     ByteString getEquipedCode1Bytes();
/*      */     
/*      */     boolean hasEquipedCode2();
/*      */     
/*      */     String getEquipedCode2();
/*      */     
/*      */     ByteString getEquipedCode2Bytes();
/*      */     
/*      */     boolean hasEquipedCode3();
/*      */     
/*      */     String getEquipedCode3();
/*      */     
/*      */     ByteString getEquipedCode3Bytes();
/*      */   }
/*      */   
/*      */   public static interface GetFashionsRequestOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\FashionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */