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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class VitalityHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetVitalityListRequest
/*      */     extends GeneratedMessage
/*      */     implements GetVitalityListRequestOrBuilder
/*      */   {
/*  317 */     private static final GetVitalityListRequest defaultInstance = new GetVitalityListRequest(true); private final UnknownFieldSet unknownFields; private GetVitalityListRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetVitalityListRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetVitalityListRequest getDefaultInstance() { return defaultInstance; } public GetVitalityListRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetVitalityListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetVitalityListRequest.class, Builder.class); } public static Parser<GetVitalityListRequest> PARSER = (Parser<GetVitalityListRequest>)new AbstractParser<GetVitalityListRequest>() { public VitalityHandler.GetVitalityListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetVitalityListRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetVitalityListRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetVitalityListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetVitalityListRequest)PARSER.parseFrom(data); } public static GetVitalityListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityListRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetVitalityListRequest)PARSER.parseFrom(data); } public static GetVitalityListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityListRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityListRequest parseFrom(InputStream input) throws IOException { return (GetVitalityListRequest)PARSER.parseFrom(input); } public static GetVitalityListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetVitalityListRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetVitalityListRequest)PARSER.parseDelimitedFrom(input); } public static GetVitalityListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetVitalityListRequest parseFrom(CodedInputStream input) throws IOException { return (GetVitalityListRequest)PARSER.parseFrom(input); } public static GetVitalityListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetVitalityListRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetVitalityListRequestOrBuilder {
/*  318 */       public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetVitalityListRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.GetVitalityListRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListRequest_descriptor; } public VitalityHandler.GetVitalityListRequest getDefaultInstanceForType() { return VitalityHandler.GetVitalityListRequest.getDefaultInstance(); } public VitalityHandler.GetVitalityListRequest build() { VitalityHandler.GetVitalityListRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.GetVitalityListRequest buildPartial() { VitalityHandler.GetVitalityListRequest result = new VitalityHandler.GetVitalityListRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetVitalityListRequest) return mergeFrom((VitalityHandler.GetVitalityListRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.GetVitalityListRequest other) { if (other == VitalityHandler.GetVitalityListRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetVitalityListRequest parsedMessage = null; try { parsedMessage = (VitalityHandler.GetVitalityListRequest)VitalityHandler.GetVitalityListRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.GetVitalityListRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class VitalityInfo
/*      */     extends GeneratedMessage
/*      */     implements VitalityInfoOrBuilder
/*      */   {
/*  894 */     private static final VitalityInfo defaultInstance = new VitalityInfo(true); private final UnknownFieldSet unknownFields; private VitalityInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private VitalityInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static VitalityInfo getDefaultInstance() { return defaultInstance; } public VitalityInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private VitalityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.currCount_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.maxCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_VitalityInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_VitalityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityInfo.class, Builder.class); } public static Parser<VitalityInfo> PARSER = (Parser<VitalityInfo>)new AbstractParser<VitalityInfo>() { public VitalityHandler.VitalityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.VitalityInfo(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int CURRCOUNT_FIELD_NUMBER = 2; private int currCount_; public static final int MAXCOUNT_FIELD_NUMBER = 3; private int maxCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<VitalityInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasCurrCount() { return ((this.bitField0_ & 0x2) == 2); } public int getCurrCount() { return this.currCount_; } public boolean hasMaxCount() { return ((this.bitField0_ & 0x4) == 4); } public int getMaxCount() { return this.maxCount_; } private void initFields() { this.id_ = 0; this.currCount_ = 0; this.maxCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasCurrCount()) { this.memoizedIsInitialized = 0; return false; }  if (!hasMaxCount()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.currCount_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.maxCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.currCount_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.maxCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static VitalityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (VitalityInfo)PARSER.parseFrom(data); } public static VitalityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (VitalityInfo)PARSER.parseFrom(data, extensionRegistry); } public static VitalityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (VitalityInfo)PARSER.parseFrom(data); } public static VitalityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (VitalityInfo)PARSER.parseFrom(data, extensionRegistry); } public static VitalityInfo parseFrom(InputStream input) throws IOException { return (VitalityInfo)PARSER.parseFrom(input); } public static VitalityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (VitalityInfo)PARSER.parseFrom(input, extensionRegistry); } public static VitalityInfo parseDelimitedFrom(InputStream input) throws IOException { return (VitalityInfo)PARSER.parseDelimitedFrom(input); } public static VitalityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (VitalityInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static VitalityInfo parseFrom(CodedInputStream input) throws IOException { return (VitalityInfo)PARSER.parseFrom(input); } public static VitalityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (VitalityInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(VitalityInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.VitalityInfoOrBuilder {
/*  895 */       private int bitField0_; private int id_; private int currCount_; private int maxCount_; public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_VitalityInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_VitalityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.VitalityInfo.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.VitalityInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.currCount_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.maxCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_VitalityInfo_descriptor; } public VitalityHandler.VitalityInfo getDefaultInstanceForType() { return VitalityHandler.VitalityInfo.getDefaultInstance(); } public VitalityHandler.VitalityInfo build() { VitalityHandler.VitalityInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.VitalityInfo buildPartial() { VitalityHandler.VitalityInfo result = new VitalityHandler.VitalityInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.currCount_ = this.currCount_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.maxCount_ = this.maxCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.VitalityInfo) return mergeFrom((VitalityHandler.VitalityInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.VitalityInfo other) { if (other == VitalityHandler.VitalityInfo.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  if (other.hasCurrCount()) setCurrCount(other.getCurrCount());  if (other.hasMaxCount()) setMaxCount(other.getMaxCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  if (!hasCurrCount()) return false;  if (!hasMaxCount()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.VitalityInfo parsedMessage = null; try { parsedMessage = (VitalityHandler.VitalityInfo)VitalityHandler.VitalityInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.VitalityInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } public boolean hasCurrCount() { return ((this.bitField0_ & 0x2) == 2); } public int getCurrCount() { return this.currCount_; } public Builder setCurrCount(int value) { this.bitField0_ |= 0x2; this.currCount_ = value; onChanged(); return this; } public Builder clearCurrCount() { this.bitField0_ &= 0xFFFFFFFD; this.currCount_ = 0; onChanged(); return this; } public boolean hasMaxCount() { return ((this.bitField0_ & 0x4) == 4); } public int getMaxCount() { return this.maxCount_; } public Builder setMaxCount(int value) { this.bitField0_ |= 0x4; this.maxCount_ = value; onChanged(); return this; } public Builder clearMaxCount() { this.bitField0_ &= 0xFFFFFFFB; this.maxCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class AwardInfo
/*      */     extends GeneratedMessage
/*      */     implements AwardInfoOrBuilder
/*      */   {
/* 1385 */     private static final AwardInfo defaultInstance = new AwardInfo(true); private final UnknownFieldSet unknownFields; private AwardInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private AwardInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static AwardInfo getDefaultInstance() { return defaultInstance; } public AwardInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private AwardInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.state_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_AwardInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_AwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AwardInfo.class, Builder.class); } public static Parser<AwardInfo> PARSER = (Parser<AwardInfo>)new AbstractParser<AwardInfo>() { public VitalityHandler.AwardInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.AwardInfo(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int STATE_FIELD_NUMBER = 2; private int state_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<AwardInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasState() { return ((this.bitField0_ & 0x2) == 2); } public int getState() { return this.state_; } private void initFields() { this.id_ = 0; this.state_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasState()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.state_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.state_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static AwardInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (AwardInfo)PARSER.parseFrom(data); } public static AwardInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (AwardInfo)PARSER.parseFrom(data, extensionRegistry); } public static AwardInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (AwardInfo)PARSER.parseFrom(data); } public static AwardInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (AwardInfo)PARSER.parseFrom(data, extensionRegistry); } public static AwardInfo parseFrom(InputStream input) throws IOException { return (AwardInfo)PARSER.parseFrom(input); } public static AwardInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AwardInfo)PARSER.parseFrom(input, extensionRegistry); } public static AwardInfo parseDelimitedFrom(InputStream input) throws IOException { return (AwardInfo)PARSER.parseDelimitedFrom(input); } public static AwardInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AwardInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static AwardInfo parseFrom(CodedInputStream input) throws IOException { return (AwardInfo)PARSER.parseFrom(input); } public static AwardInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (AwardInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(AwardInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.AwardInfoOrBuilder {
/* 1386 */       private int bitField0_; private int id_; private int state_; public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_AwardInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_AwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.AwardInfo.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.AwardInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.state_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_AwardInfo_descriptor; } public VitalityHandler.AwardInfo getDefaultInstanceForType() { return VitalityHandler.AwardInfo.getDefaultInstance(); } public VitalityHandler.AwardInfo build() { VitalityHandler.AwardInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.AwardInfo buildPartial() { VitalityHandler.AwardInfo result = new VitalityHandler.AwardInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.state_ = this.state_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.AwardInfo) return mergeFrom((VitalityHandler.AwardInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.AwardInfo other) { if (other == VitalityHandler.AwardInfo.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  if (other.hasState()) setState(other.getState());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  if (!hasState()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.AwardInfo parsedMessage = null; try { parsedMessage = (VitalityHandler.AwardInfo)VitalityHandler.AwardInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.AwardInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } public boolean hasState() { return ((this.bitField0_ & 0x2) == 2); } public int getState() { return this.state_; } public Builder setState(int value) { this.bitField0_ |= 0x2; this.state_ = value; onChanged(); return this; } public Builder clearState() { this.bitField0_ &= 0xFFFFFFFD; this.state_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetVitalityListResponse
/*      */     extends GeneratedMessage
/*      */     implements GetVitalityListResponseOrBuilder
/*      */   {
/* 2863 */     private static final GetVitalityListResponse defaultInstance = new GetVitalityListResponse(true); private final UnknownFieldSet unknownFields; private GetVitalityListResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetVitalityListResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetVitalityListResponse getDefaultInstance() { return defaultInstance; } public GetVitalityListResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetVitalityListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.s2CTotalCurrCount_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.s2CTotalMaxCount_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.s2CMsg_ = bs; break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.s2CVitalityList_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.s2CVitalityList_.add(input.readMessage(VitalityHandler.VitalityInfo.PARSER, extensionRegistry)); break;case 50: if ((mutable_bitField0_ & 0x20) != 32) { this.s2CAwardList_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.s2CAwardList_.add(input.readMessage(VitalityHandler.AwardInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.s2CVitalityList_ = Collections.unmodifiableList(this.s2CVitalityList_);  if ((mutable_bitField0_ & 0x20) == 32) this.s2CAwardList_ = Collections.unmodifiableList(this.s2CAwardList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetVitalityListResponse.class, Builder.class); } public static Parser<GetVitalityListResponse> PARSER = (Parser<GetVitalityListResponse>)new AbstractParser<GetVitalityListResponse>() { public VitalityHandler.GetVitalityListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetVitalityListResponse(input, extensionRegistry); } }
/* 2864 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_TOTALCURRCOUNT_FIELD_NUMBER = 2; private int s2CTotalCurrCount_; public static final int S2C_TOTALMAXCOUNT_FIELD_NUMBER = 3; private int s2CTotalMaxCount_; public static final int S2C_MSG_FIELD_NUMBER = 4; private Object s2CMsg_; public static final int S2C_VITALITYLIST_FIELD_NUMBER = 5; private List<VitalityHandler.VitalityInfo> s2CVitalityList_; public static final int S2C_AWARDLIST_FIELD_NUMBER = 6; private List<VitalityHandler.AwardInfo> s2CAwardList_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetVitalityListResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CTotalCurrCount() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CTotalCurrCount() { return this.s2CTotalCurrCount_; } public boolean hasS2CTotalMaxCount() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CTotalMaxCount() { return this.s2CTotalMaxCount_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x8) == 8); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<VitalityHandler.VitalityInfo> getS2CVitalityListList() { return this.s2CVitalityList_; } public List<? extends VitalityHandler.VitalityInfoOrBuilder> getS2CVitalityListOrBuilderList() { return (List)this.s2CVitalityList_; } public int getS2CVitalityListCount() { return this.s2CVitalityList_.size(); } public VitalityHandler.VitalityInfo getS2CVitalityList(int index) { return this.s2CVitalityList_.get(index); } public VitalityHandler.VitalityInfoOrBuilder getS2CVitalityListOrBuilder(int index) { return this.s2CVitalityList_.get(index); } public List<VitalityHandler.AwardInfo> getS2CAwardListList() { return this.s2CAwardList_; } public List<? extends VitalityHandler.AwardInfoOrBuilder> getS2CAwardListOrBuilderList() { return (List)this.s2CAwardList_; } public int getS2CAwardListCount() { return this.s2CAwardList_.size(); } public VitalityHandler.AwardInfo getS2CAwardList(int index) { return this.s2CAwardList_.get(index); } public VitalityHandler.AwardInfoOrBuilder getS2CAwardListOrBuilder(int index) { return this.s2CAwardList_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CTotalCurrCount_ = 0; this.s2CTotalMaxCount_ = 0; this.s2CMsg_ = ""; this.s2CVitalityList_ = Collections.emptyList(); this.s2CAwardList_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CTotalCurrCount()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CTotalMaxCount()) { this.memoizedIsInitialized = 0; return false; }  int i; for (i = 0; i < getS2CVitalityListCount(); i++) { if (!getS2CVitalityList(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getS2CAwardListCount(); i++) { if (!getS2CAwardList(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.s2CTotalCurrCount_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CTotalMaxCount_);  if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CVitalityList_.size(); i++) output.writeMessage(5, (MessageLite)this.s2CVitalityList_.get(i));  for (i = 0; i < this.s2CAwardList_.size(); i++) output.writeMessage(6, (MessageLite)this.s2CAwardList_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.s2CTotalCurrCount_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CTotalMaxCount_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getS2CMsgBytes());  int i; for (i = 0; i < this.s2CVitalityList_.size(); i++) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.s2CVitalityList_.get(i));  for (i = 0; i < this.s2CAwardList_.size(); i++) size += CodedOutputStream.computeMessageSize(6, (MessageLite)this.s2CAwardList_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } static { defaultInstance.initFields(); }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static GetVitalityListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetVitalityListResponse)PARSER.parseFrom(data); }
/*      */     public static GetVitalityListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityListResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetVitalityListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetVitalityListResponse)PARSER.parseFrom(data); }
/*      */     public static GetVitalityListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityListResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static GetVitalityListResponse parseFrom(InputStream input) throws IOException { return (GetVitalityListResponse)PARSER.parseFrom(input); }
/*      */     public static GetVitalityListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static GetVitalityListResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetVitalityListResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static GetVitalityListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static GetVitalityListResponse parseFrom(CodedInputStream input) throws IOException { return (GetVitalityListResponse)PARSER.parseFrom(input); }
/*      */     public static GetVitalityListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityListResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(GetVitalityListResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetVitalityListResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private int s2CTotalCurrCount_;
/*      */       private int s2CTotalMaxCount_;
/*      */       private Object s2CMsg_;
/*      */       private List<VitalityHandler.VitalityInfo> s2CVitalityList_;
/*      */       private RepeatedFieldBuilder<VitalityHandler.VitalityInfo, VitalityHandler.VitalityInfo.Builder, VitalityHandler.VitalityInfoOrBuilder> s2CVitalityListBuilder_;
/*      */       private List<VitalityHandler.AwardInfo> s2CAwardList_;
/*      */       private RepeatedFieldBuilder<VitalityHandler.AwardInfo, VitalityHandler.AwardInfo.Builder, VitalityHandler.AwardInfoOrBuilder> s2CAwardListBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetVitalityListResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CVitalityList_ = Collections.emptyList(); this.s2CAwardList_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CVitalityList_ = Collections.emptyList(); this.s2CAwardList_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (VitalityHandler.GetVitalityListResponse.alwaysUseFieldBuilders) {
/*      */           getS2CVitalityListFieldBuilder(); getS2CAwardListFieldBuilder();
/*      */         }  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CTotalCurrCount_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.s2CTotalMaxCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFF7; if (this.s2CVitalityListBuilder_ == null) {
/*      */           this.s2CVitalityList_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFEF;
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.clear();
/*      */         }  if (this.s2CAwardListBuilder_ == null) {
/*      */           this.s2CAwardList_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFDF;
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.clear();
/*      */         }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetVitalityListResponse_descriptor; }
/*      */       public VitalityHandler.GetVitalityListResponse getDefaultInstanceForType() { return VitalityHandler.GetVitalityListResponse.getDefaultInstance(); }
/*      */       public VitalityHandler.GetVitalityListResponse build() { VitalityHandler.GetVitalityListResponse result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public VitalityHandler.GetVitalityListResponse buildPartial() { VitalityHandler.GetVitalityListResponse result = new VitalityHandler.GetVitalityListResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2;  result.s2CTotalCurrCount_ = this.s2CTotalCurrCount_; if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4;  result.s2CTotalMaxCount_ = this.s2CTotalMaxCount_; if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8;  result.s2CMsg_ = this.s2CMsg_; if (this.s2CVitalityListBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x10) == 16) {
/*      */             this.s2CVitalityList_ = Collections.unmodifiableList(this.s2CVitalityList_); this.bitField0_ &= 0xFFFFFFEF;
/*      */           }  result.s2CVitalityList_ = this.s2CVitalityList_;
/*      */         } else {
/*      */           result.s2CVitalityList_ = this.s2CVitalityListBuilder_.build();
/*      */         }  if (this.s2CAwardListBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x20) == 32) {
/*      */             this.s2CAwardList_ = Collections.unmodifiableList(this.s2CAwardList_); this.bitField0_ &= 0xFFFFFFDF;
/*      */           }  result.s2CAwardList_ = this.s2CAwardList_;
/*      */         } else {
/*      */           result.s2CAwardList_ = this.s2CAwardListBuilder_.build();
/*      */         }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetVitalityListResponse)
/*      */           return mergeFrom((VitalityHandler.GetVitalityListResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(VitalityHandler.GetVitalityListResponse other) { if (other == VitalityHandler.GetVitalityListResponse.getDefaultInstance())
/*      */           return this;  if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode());  if (other.hasS2CTotalCurrCount())
/*      */           setS2CTotalCurrCount(other.getS2CTotalCurrCount());  if (other.hasS2CTotalMaxCount())
/*      */           setS2CTotalMaxCount(other.getS2CTotalMaxCount());  if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x8; this.s2CMsg_ = other.s2CMsg_; onChanged();
/*      */         }  if (this.s2CVitalityListBuilder_ == null) {
/*      */           if (!other.s2CVitalityList_.isEmpty()) {
/*      */             if (this.s2CVitalityList_.isEmpty()) {
/*      */               this.s2CVitalityList_ = other.s2CVitalityList_; this.bitField0_ &= 0xFFFFFFEF;
/*      */             } else {
/*      */               ensureS2CVitalityListIsMutable(); this.s2CVitalityList_.addAll(other.s2CVitalityList_);
/*      */             }  onChanged();
/*      */           } 
/*      */         } else if (!other.s2CVitalityList_.isEmpty()) {
/*      */           if (this.s2CVitalityListBuilder_.isEmpty()) {
/*      */             this.s2CVitalityListBuilder_.dispose(); this.s2CVitalityListBuilder_ = null; this.s2CVitalityList_ = other.s2CVitalityList_; this.bitField0_ &= 0xFFFFFFEF; this.s2CVitalityListBuilder_ = VitalityHandler.GetVitalityListResponse.alwaysUseFieldBuilders ? getS2CVitalityListFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CVitalityListBuilder_.addAllMessages(other.s2CVitalityList_);
/*      */           } 
/*      */         }  if (this.s2CAwardListBuilder_ == null) {
/*      */           if (!other.s2CAwardList_.isEmpty()) {
/*      */             if (this.s2CAwardList_.isEmpty()) {
/*      */               this.s2CAwardList_ = other.s2CAwardList_;
/*      */               this.bitField0_ &= 0xFFFFFFDF;
/*      */             } else {
/*      */               ensureS2CAwardListIsMutable();
/*      */               this.s2CAwardList_.addAll(other.s2CAwardList_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CAwardList_.isEmpty()) {
/*      */           if (this.s2CAwardListBuilder_.isEmpty()) {
/*      */             this.s2CAwardListBuilder_.dispose();
/*      */             this.s2CAwardListBuilder_ = null;
/*      */             this.s2CAwardList_ = other.s2CAwardList_;
/*      */             this.bitField0_ &= 0xFFFFFFDF;
/*      */             this.s2CAwardListBuilder_ = VitalityHandler.GetVitalityListResponse.alwaysUseFieldBuilders ? getS2CAwardListFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CAwardListBuilder_.addAllMessages(other.s2CAwardList_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false; 
/*      */         if (!hasS2CTotalCurrCount())
/*      */           return false; 
/*      */         if (!hasS2CTotalMaxCount())
/*      */           return false; 
/*      */         int i;
/*      */         for (i = 0; i < getS2CVitalityListCount(); i++) {
/*      */           if (!getS2CVitalityList(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         for (i = 0; i < getS2CAwardListCount(); i++) {
/*      */           if (!getS2CAwardList(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetVitalityListResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (VitalityHandler.GetVitalityListResponse)VitalityHandler.GetVitalityListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (VitalityHandler.GetVitalityListResponse)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasS2CTotalCurrCount() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public int getS2CTotalCurrCount() { return this.s2CTotalCurrCount_; }
/*      */       public Builder setS2CTotalCurrCount(int value) { this.bitField0_ |= 0x2;
/*      */         this.s2CTotalCurrCount_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CTotalCurrCount() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CTotalCurrCount_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasS2CTotalMaxCount() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getS2CTotalMaxCount() { return this.s2CTotalMaxCount_; }
/*      */       public Builder setS2CTotalMaxCount(int value) { this.bitField0_ |= 0x4;
/*      */         this.s2CTotalMaxCount_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CTotalMaxCount() { this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CTotalMaxCount_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x8) == 8); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CMsg_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x8;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CMsg_ = VitalityHandler.GetVitalityListResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x8;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       private void ensureS2CVitalityListIsMutable() { if ((this.bitField0_ & 0x10) != 16) {
/*      */           this.s2CVitalityList_ = new ArrayList<>(this.s2CVitalityList_);
/*      */           this.bitField0_ |= 0x10;
/*      */         }  }
/*      */       public List<VitalityHandler.VitalityInfo> getS2CVitalityListList() { if (this.s2CVitalityListBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CVitalityList_); 
/*      */         return this.s2CVitalityListBuilder_.getMessageList(); }
/*      */       public int getS2CVitalityListCount() { if (this.s2CVitalityListBuilder_ == null)
/*      */           return this.s2CVitalityList_.size(); 
/*      */         return this.s2CVitalityListBuilder_.getCount(); }
/*      */       public VitalityHandler.VitalityInfo getS2CVitalityList(int index) { if (this.s2CVitalityListBuilder_ == null)
/*      */           return this.s2CVitalityList_.get(index); 
/*      */         return (VitalityHandler.VitalityInfo)this.s2CVitalityListBuilder_.getMessage(index); }
/*      */       public Builder setS2CVitalityList(int index, VitalityHandler.VitalityInfo value) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setS2CVitalityList(int index, VitalityHandler.VitalityInfo.Builder builderForValue) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CVitalityList(VitalityHandler.VitalityInfo value) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.addMessage(value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CVitalityList(int index, VitalityHandler.VitalityInfo value) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CVitalityList(VitalityHandler.VitalityInfo.Builder builderForValue) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CVitalityList(int index, VitalityHandler.VitalityInfo.Builder builderForValue) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAllS2CVitalityList(Iterable<? extends VitalityHandler.VitalityInfo> values) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           ensureS2CVitalityListIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CVitalityList_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; }
/*      */       public Builder clearS2CVitalityList() { if (this.s2CVitalityListBuilder_ == null) {
/*      */           this.s2CVitalityList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder removeS2CVitalityList(int index) { if (this.s2CVitalityListBuilder_ == null) {
/*      */           ensureS2CVitalityListIsMutable();
/*      */           this.s2CVitalityList_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CVitalityListBuilder_.remove(index);
/*      */         } 
/*      */         return this; }
/*      */       public VitalityHandler.VitalityInfo.Builder getS2CVitalityListBuilder(int index) { return (VitalityHandler.VitalityInfo.Builder)getS2CVitalityListFieldBuilder().getBuilder(index); }
/*      */       public VitalityHandler.VitalityInfoOrBuilder getS2CVitalityListOrBuilder(int index) { if (this.s2CVitalityListBuilder_ == null)
/*      */           return this.s2CVitalityList_.get(index); 
/*      */         return (VitalityHandler.VitalityInfoOrBuilder)this.s2CVitalityListBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends VitalityHandler.VitalityInfoOrBuilder> getS2CVitalityListOrBuilderList() { if (this.s2CVitalityListBuilder_ != null)
/*      */           return this.s2CVitalityListBuilder_.getMessageOrBuilderList(); 
/*      */         return Collections.unmodifiableList((List)this.s2CVitalityList_); }
/*      */       public VitalityHandler.VitalityInfo.Builder addS2CVitalityListBuilder() { return (VitalityHandler.VitalityInfo.Builder)getS2CVitalityListFieldBuilder().addBuilder(VitalityHandler.VitalityInfo.getDefaultInstance()); }
/*      */       public VitalityHandler.VitalityInfo.Builder addS2CVitalityListBuilder(int index) { return (VitalityHandler.VitalityInfo.Builder)getS2CVitalityListFieldBuilder().addBuilder(index, VitalityHandler.VitalityInfo.getDefaultInstance()); }
/*      */       public List<VitalityHandler.VitalityInfo.Builder> getS2CVitalityListBuilderList() { return getS2CVitalityListFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<VitalityHandler.VitalityInfo, VitalityHandler.VitalityInfo.Builder, VitalityHandler.VitalityInfoOrBuilder> getS2CVitalityListFieldBuilder() { if (this.s2CVitalityListBuilder_ == null) {
/*      */           this.s2CVitalityListBuilder_ = new RepeatedFieldBuilder(this.s2CVitalityList_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*      */           this.s2CVitalityList_ = null;
/*      */         } 
/*      */         return this.s2CVitalityListBuilder_; }
/*      */       private void ensureS2CAwardListIsMutable() { if ((this.bitField0_ & 0x20) != 32) {
/*      */           this.s2CAwardList_ = new ArrayList<>(this.s2CAwardList_);
/*      */           this.bitField0_ |= 0x20;
/*      */         }  }
/*      */       public List<VitalityHandler.AwardInfo> getS2CAwardListList() { if (this.s2CAwardListBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CAwardList_); 
/*      */         return this.s2CAwardListBuilder_.getMessageList(); }
/*      */       public int getS2CAwardListCount() { if (this.s2CAwardListBuilder_ == null)
/*      */           return this.s2CAwardList_.size(); 
/*      */         return this.s2CAwardListBuilder_.getCount(); }
/*      */       public VitalityHandler.AwardInfo getS2CAwardList(int index) { if (this.s2CAwardListBuilder_ == null)
/*      */           return this.s2CAwardList_.get(index); 
/*      */         return (VitalityHandler.AwardInfo)this.s2CAwardListBuilder_.getMessage(index); }
/*      */       public Builder setS2CAwardList(int index, VitalityHandler.AwardInfo value) { if (this.s2CAwardListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.setMessage(index, value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setS2CAwardList(int index, VitalityHandler.AwardInfo.Builder builderForValue) { if (this.s2CAwardListBuilder_ == null) {
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.setMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CAwardList(VitalityHandler.AwardInfo value) { if (this.s2CAwardListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.addMessage(value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addS2CAwardList(int index, VitalityHandler.AwardInfo value) { if (this.s2CAwardListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.addMessage(index, value);
/*      */         } 
/*      */         return this; } public Builder addS2CAwardList(VitalityHandler.AwardInfo.Builder builderForValue) { if (this.s2CAwardListBuilder_ == null) {
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.addMessage(builderForValue.build());
/*      */         } 
/*      */         return this; } public Builder addS2CAwardList(int index, VitalityHandler.AwardInfo.Builder builderForValue) { if (this.s2CAwardListBuilder_ == null) {
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.addMessage(index, builderForValue.build());
/*      */         } 
/*      */         return this; } public Builder addAllS2CAwardList(Iterable<? extends VitalityHandler.AwardInfo> values) { if (this.s2CAwardListBuilder_ == null) {
/*      */           ensureS2CAwardListIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CAwardList_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; } public Builder clearS2CAwardList() { if (this.s2CAwardListBuilder_ == null) {
/*      */           this.s2CAwardList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFDF;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.clear();
/*      */         } 
/*      */         return this; } public Builder removeS2CAwardList(int index) { if (this.s2CAwardListBuilder_ == null) {
/*      */           ensureS2CAwardListIsMutable();
/*      */           this.s2CAwardList_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CAwardListBuilder_.remove(index);
/*      */         } 
/*      */         return this; } public VitalityHandler.AwardInfo.Builder getS2CAwardListBuilder(int index) { return (VitalityHandler.AwardInfo.Builder)getS2CAwardListFieldBuilder().getBuilder(index); } public VitalityHandler.AwardInfoOrBuilder getS2CAwardListOrBuilder(int index) { if (this.s2CAwardListBuilder_ == null)
/*      */           return this.s2CAwardList_.get(index); 
/*      */         return (VitalityHandler.AwardInfoOrBuilder)this.s2CAwardListBuilder_.getMessageOrBuilder(index); } public List<? extends VitalityHandler.AwardInfoOrBuilder> getS2CAwardListOrBuilderList() { if (this.s2CAwardListBuilder_ != null)
/*      */           return this.s2CAwardListBuilder_.getMessageOrBuilderList(); 
/*      */         return Collections.unmodifiableList((List)this.s2CAwardList_); } public VitalityHandler.AwardInfo.Builder addS2CAwardListBuilder() { return (VitalityHandler.AwardInfo.Builder)getS2CAwardListFieldBuilder().addBuilder(VitalityHandler.AwardInfo.getDefaultInstance()); } public VitalityHandler.AwardInfo.Builder addS2CAwardListBuilder(int index) { return (VitalityHandler.AwardInfo.Builder)getS2CAwardListFieldBuilder().addBuilder(index, VitalityHandler.AwardInfo.getDefaultInstance()); } public List<VitalityHandler.AwardInfo.Builder> getS2CAwardListBuilderList() { return getS2CAwardListFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<VitalityHandler.AwardInfo, VitalityHandler.AwardInfo.Builder, VitalityHandler.AwardInfoOrBuilder> getS2CAwardListFieldBuilder() { if (this.s2CAwardListBuilder_ == null) {
/*      */           this.s2CAwardListBuilder_ = new RepeatedFieldBuilder(this.s2CAwardList_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
/*      */           this.s2CAwardList_ = null;
/*      */         } 
/*      */         return this.s2CAwardListBuilder_; }
/*      */     }
/*      */   } public static final class GetVitalityRewardRequest extends GeneratedMessage implements GetVitalityRewardRequestOrBuilder {
/* 3268 */     private static final GetVitalityRewardRequest defaultInstance = new GetVitalityRewardRequest(true); private final UnknownFieldSet unknownFields; private GetVitalityRewardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetVitalityRewardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetVitalityRewardRequest getDefaultInstance() { return defaultInstance; } public GetVitalityRewardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetVitalityRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SRewardId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetVitalityRewardRequest.class, Builder.class); } public static Parser<GetVitalityRewardRequest> PARSER = (Parser<GetVitalityRewardRequest>)new AbstractParser<GetVitalityRewardRequest>() { public VitalityHandler.GetVitalityRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetVitalityRewardRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_REWARDID_FIELD_NUMBER = 1; private int c2SRewardId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetVitalityRewardRequest> getParserForType() { return PARSER; } public boolean hasC2SRewardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SRewardId() { return this.c2SRewardId_; } private void initFields() { this.c2SRewardId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SRewardId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SRewardId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SRewardId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetVitalityRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetVitalityRewardRequest)PARSER.parseFrom(data); } public static GetVitalityRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetVitalityRewardRequest)PARSER.parseFrom(data); } public static GetVitalityRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityRewardRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityRewardRequest parseFrom(InputStream input) throws IOException { return (GetVitalityRewardRequest)PARSER.parseFrom(input); } public static GetVitalityRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetVitalityRewardRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetVitalityRewardRequest)PARSER.parseDelimitedFrom(input); } public static GetVitalityRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetVitalityRewardRequest parseFrom(CodedInputStream input) throws IOException { return (GetVitalityRewardRequest)PARSER.parseFrom(input); } public static GetVitalityRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetVitalityRewardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetVitalityRewardRequestOrBuilder {
/* 3269 */       private int bitField0_; private int c2SRewardId_; public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetVitalityRewardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.GetVitalityRewardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SRewardId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardRequest_descriptor; } public VitalityHandler.GetVitalityRewardRequest getDefaultInstanceForType() { return VitalityHandler.GetVitalityRewardRequest.getDefaultInstance(); } public VitalityHandler.GetVitalityRewardRequest build() { VitalityHandler.GetVitalityRewardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.GetVitalityRewardRequest buildPartial() { VitalityHandler.GetVitalityRewardRequest result = new VitalityHandler.GetVitalityRewardRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SRewardId_ = this.c2SRewardId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetVitalityRewardRequest) return mergeFrom((VitalityHandler.GetVitalityRewardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.GetVitalityRewardRequest other) { if (other == VitalityHandler.GetVitalityRewardRequest.getDefaultInstance()) return this;  if (other.hasC2SRewardId()) setC2SRewardId(other.getC2SRewardId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SRewardId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetVitalityRewardRequest parsedMessage = null; try { parsedMessage = (VitalityHandler.GetVitalityRewardRequest)VitalityHandler.GetVitalityRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.GetVitalityRewardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SRewardId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SRewardId() { return this.c2SRewardId_; } public Builder setC2SRewardId(int value) { this.bitField0_ |= 0x1; this.c2SRewardId_ = value; onChanged(); return this; } public Builder clearC2SRewardId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SRewardId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetVitalityRewardResponse
/*      */     extends GeneratedMessage
/*      */     implements GetVitalityRewardResponseOrBuilder
/*      */   {
/* 3830 */     private static final GetVitalityRewardResponse defaultInstance = new GetVitalityRewardResponse(true); private final UnknownFieldSet unknownFields; private GetVitalityRewardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetVitalityRewardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetVitalityRewardResponse getDefaultInstance() { return defaultInstance; } public GetVitalityRewardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetVitalityRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetVitalityRewardResponse.class, Builder.class); } public static Parser<GetVitalityRewardResponse> PARSER = (Parser<GetVitalityRewardResponse>)new AbstractParser<GetVitalityRewardResponse>() { public VitalityHandler.GetVitalityRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetVitalityRewardResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetVitalityRewardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetVitalityRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetVitalityRewardResponse)PARSER.parseFrom(data); } public static GetVitalityRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetVitalityRewardResponse)PARSER.parseFrom(data); } public static GetVitalityRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetVitalityRewardResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetVitalityRewardResponse parseFrom(InputStream input) throws IOException { return (GetVitalityRewardResponse)PARSER.parseFrom(input); } public static GetVitalityRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetVitalityRewardResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetVitalityRewardResponse)PARSER.parseDelimitedFrom(input); } public static GetVitalityRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetVitalityRewardResponse parseFrom(CodedInputStream input) throws IOException { return (GetVitalityRewardResponse)PARSER.parseFrom(input); } public static GetVitalityRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetVitalityRewardResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetVitalityRewardResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetVitalityRewardResponseOrBuilder {
/* 3831 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetVitalityRewardResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.GetVitalityRewardResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetVitalityRewardResponse_descriptor; } public VitalityHandler.GetVitalityRewardResponse getDefaultInstanceForType() { return VitalityHandler.GetVitalityRewardResponse.getDefaultInstance(); } public VitalityHandler.GetVitalityRewardResponse build() { VitalityHandler.GetVitalityRewardResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.GetVitalityRewardResponse buildPartial() { VitalityHandler.GetVitalityRewardResponse result = new VitalityHandler.GetVitalityRewardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetVitalityRewardResponse) return mergeFrom((VitalityHandler.GetVitalityRewardResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.GetVitalityRewardResponse other) { if (other == VitalityHandler.GetVitalityRewardResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetVitalityRewardResponse parsedMessage = null; try { parsedMessage = (VitalityHandler.GetVitalityRewardResponse)VitalityHandler.GetVitalityRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.GetVitalityRewardResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = VitalityHandler.GetVitalityRewardResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetRecommendPlayListRequest
/*      */     extends GeneratedMessage
/*      */     implements GetRecommendPlayListRequestOrBuilder
/*      */   {
/* 4143 */     private static final GetRecommendPlayListRequest defaultInstance = new GetRecommendPlayListRequest(true); private final UnknownFieldSet unknownFields; private GetRecommendPlayListRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRecommendPlayListRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRecommendPlayListRequest getDefaultInstance() { return defaultInstance; } public GetRecommendPlayListRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRecommendPlayListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRecommendPlayListRequest.class, Builder.class); } public static Parser<GetRecommendPlayListRequest> PARSER = (Parser<GetRecommendPlayListRequest>)new AbstractParser<GetRecommendPlayListRequest>() { public VitalityHandler.GetRecommendPlayListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetRecommendPlayListRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRecommendPlayListRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetRecommendPlayListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetRecommendPlayListRequest)PARSER.parseFrom(data); } public static GetRecommendPlayListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetRecommendPlayListRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetRecommendPlayListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetRecommendPlayListRequest)PARSER.parseFrom(data); } public static GetRecommendPlayListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetRecommendPlayListRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetRecommendPlayListRequest parseFrom(InputStream input) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseFrom(input); } public static GetRecommendPlayListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetRecommendPlayListRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseDelimitedFrom(input); } public static GetRecommendPlayListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetRecommendPlayListRequest parseFrom(CodedInputStream input) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseFrom(input); } public static GetRecommendPlayListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetRecommendPlayListRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetRecommendPlayListRequestOrBuilder {
/* 4144 */       public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetRecommendPlayListRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.GetRecommendPlayListRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListRequest_descriptor; } public VitalityHandler.GetRecommendPlayListRequest getDefaultInstanceForType() { return VitalityHandler.GetRecommendPlayListRequest.getDefaultInstance(); } public VitalityHandler.GetRecommendPlayListRequest build() { VitalityHandler.GetRecommendPlayListRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.GetRecommendPlayListRequest buildPartial() { VitalityHandler.GetRecommendPlayListRequest result = new VitalityHandler.GetRecommendPlayListRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetRecommendPlayListRequest) return mergeFrom((VitalityHandler.GetRecommendPlayListRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.GetRecommendPlayListRequest other) { if (other == VitalityHandler.GetRecommendPlayListRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetRecommendPlayListRequest parsedMessage = null; try { parsedMessage = (VitalityHandler.GetRecommendPlayListRequest)VitalityHandler.GetRecommendPlayListRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.GetRecommendPlayListRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class RecommendPlayInfo
/*      */     extends GeneratedMessage
/*      */     implements RecommendPlayInfoOrBuilder
/*      */   {
/* 4720 */     private static final RecommendPlayInfo defaultInstance = new RecommendPlayInfo(true); private final UnknownFieldSet unknownFields; private RecommendPlayInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RecommendPlayInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RecommendPlayInfo getDefaultInstance() { return defaultInstance; } public RecommendPlayInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RecommendPlayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.maxTime_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.remainTime_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_RecommendPlayInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_RecommendPlayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RecommendPlayInfo.class, Builder.class); } public static Parser<RecommendPlayInfo> PARSER = (Parser<RecommendPlayInfo>)new AbstractParser<RecommendPlayInfo>() { public VitalityHandler.RecommendPlayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.RecommendPlayInfo(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int MAXTIME_FIELD_NUMBER = 2; private int maxTime_; public static final int REMAINTIME_FIELD_NUMBER = 3; private int remainTime_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RecommendPlayInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasMaxTime() { return ((this.bitField0_ & 0x2) == 2); } public int getMaxTime() { return this.maxTime_; } public boolean hasRemainTime() { return ((this.bitField0_ & 0x4) == 4); } public int getRemainTime() { return this.remainTime_; } private void initFields() { this.id_ = 0; this.maxTime_ = 0; this.remainTime_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasMaxTime()) { this.memoizedIsInitialized = 0; return false; }  if (!hasRemainTime()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.maxTime_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.remainTime_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.maxTime_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.remainTime_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RecommendPlayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RecommendPlayInfo)PARSER.parseFrom(data); } public static RecommendPlayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RecommendPlayInfo)PARSER.parseFrom(data, extensionRegistry); } public static RecommendPlayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RecommendPlayInfo)PARSER.parseFrom(data); } public static RecommendPlayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RecommendPlayInfo)PARSER.parseFrom(data, extensionRegistry); } public static RecommendPlayInfo parseFrom(InputStream input) throws IOException { return (RecommendPlayInfo)PARSER.parseFrom(input); } public static RecommendPlayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecommendPlayInfo)PARSER.parseFrom(input, extensionRegistry); } public static RecommendPlayInfo parseDelimitedFrom(InputStream input) throws IOException { return (RecommendPlayInfo)PARSER.parseDelimitedFrom(input); } public static RecommendPlayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecommendPlayInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RecommendPlayInfo parseFrom(CodedInputStream input) throws IOException { return (RecommendPlayInfo)PARSER.parseFrom(input); } public static RecommendPlayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RecommendPlayInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RecommendPlayInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.RecommendPlayInfoOrBuilder {
/* 4721 */       private int bitField0_; private int id_; private int maxTime_; private int remainTime_; public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_RecommendPlayInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_RecommendPlayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.RecommendPlayInfo.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (VitalityHandler.RecommendPlayInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.maxTime_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.remainTime_ = 0; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_RecommendPlayInfo_descriptor; } public VitalityHandler.RecommendPlayInfo getDefaultInstanceForType() { return VitalityHandler.RecommendPlayInfo.getDefaultInstance(); } public VitalityHandler.RecommendPlayInfo build() { VitalityHandler.RecommendPlayInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public VitalityHandler.RecommendPlayInfo buildPartial() { VitalityHandler.RecommendPlayInfo result = new VitalityHandler.RecommendPlayInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.maxTime_ = this.maxTime_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.remainTime_ = this.remainTime_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.RecommendPlayInfo) return mergeFrom((VitalityHandler.RecommendPlayInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(VitalityHandler.RecommendPlayInfo other) { if (other == VitalityHandler.RecommendPlayInfo.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  if (other.hasMaxTime()) setMaxTime(other.getMaxTime());  if (other.hasRemainTime()) setRemainTime(other.getRemainTime());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  if (!hasMaxTime()) return false;  if (!hasRemainTime()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.RecommendPlayInfo parsedMessage = null; try { parsedMessage = (VitalityHandler.RecommendPlayInfo)VitalityHandler.RecommendPlayInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.RecommendPlayInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } public boolean hasMaxTime() { return ((this.bitField0_ & 0x2) == 2); } public int getMaxTime() { return this.maxTime_; } public Builder setMaxTime(int value) { this.bitField0_ |= 0x2; this.maxTime_ = value; onChanged(); return this; } public Builder clearMaxTime() { this.bitField0_ &= 0xFFFFFFFD; this.maxTime_ = 0; onChanged(); return this; } public boolean hasRemainTime() { return ((this.bitField0_ & 0x4) == 4); } public int getRemainTime() { return this.remainTime_; } public Builder setRemainTime(int value) { this.bitField0_ |= 0x4; this.remainTime_ = value; onChanged(); return this; } public Builder clearRemainTime() { this.bitField0_ &= 0xFFFFFFFB; this.remainTime_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*      */   public static final class GetRecommendPlayListResponse
/*      */     extends GeneratedMessage
/*      */     implements GetRecommendPlayListResponseOrBuilder
/*      */   {
/* 5654 */     private static final GetRecommendPlayListResponse defaultInstance = new GetRecommendPlayListResponse(true); private final UnknownFieldSet unknownFields; private GetRecommendPlayListResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRecommendPlayListResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRecommendPlayListResponse getDefaultInstance() { return defaultInstance; } public GetRecommendPlayListResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRecommendPlayListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CRecommendPlayList_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CRecommendPlayList_.add(input.readMessage(VitalityHandler.RecommendPlayInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CRecommendPlayList_ = Collections.unmodifiableList(this.s2CRecommendPlayList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRecommendPlayListResponse.class, Builder.class); } public static Parser<GetRecommendPlayListResponse> PARSER = (Parser<GetRecommendPlayListResponse>)new AbstractParser<GetRecommendPlayListResponse>() { public VitalityHandler.GetRecommendPlayListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new VitalityHandler.GetRecommendPlayListResponse(input, extensionRegistry); } }
/* 5655 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_RECOMMENDPLAYLIST_FIELD_NUMBER = 3; private List<VitalityHandler.RecommendPlayInfo> s2CRecommendPlayList_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRecommendPlayListResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public List<VitalityHandler.RecommendPlayInfo> getS2CRecommendPlayListList() { return this.s2CRecommendPlayList_; } public List<? extends VitalityHandler.RecommendPlayInfoOrBuilder> getS2CRecommendPlayListOrBuilderList() { return (List)this.s2CRecommendPlayList_; } public int getS2CRecommendPlayListCount() { return this.s2CRecommendPlayList_.size(); } public VitalityHandler.RecommendPlayInfo getS2CRecommendPlayList(int index) { return this.s2CRecommendPlayList_.get(index); } public VitalityHandler.RecommendPlayInfoOrBuilder getS2CRecommendPlayListOrBuilder(int index) { return this.s2CRecommendPlayList_.get(index); } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CRecommendPlayList_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getS2CRecommendPlayListCount(); i++) { if (!getS2CRecommendPlayList(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  for (int i = 0; i < this.s2CRecommendPlayList_.size(); i++) output.writeMessage(3, (MessageLite)this.s2CRecommendPlayList_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  for (int i = 0; i < this.s2CRecommendPlayList_.size(); i++) size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CRecommendPlayList_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetRecommendPlayListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetRecommendPlayListResponse)PARSER.parseFrom(data); } public static GetRecommendPlayListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetRecommendPlayListResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetRecommendPlayListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetRecommendPlayListResponse)PARSER.parseFrom(data); } public static GetRecommendPlayListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetRecommendPlayListResponse)PARSER.parseFrom(data, extensionRegistry); } public static GetRecommendPlayListResponse parseFrom(InputStream input) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseFrom(input); } public static GetRecommendPlayListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseFrom(input, extensionRegistry); } public static GetRecommendPlayListResponse parseDelimitedFrom(InputStream input) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseDelimitedFrom(input); } public static GetRecommendPlayListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetRecommendPlayListResponse parseFrom(CodedInputStream input) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseFrom(input); } public static GetRecommendPlayListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetRecommendPlayListResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(GetRecommendPlayListResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements VitalityHandler.GetRecommendPlayListResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<VitalityHandler.RecommendPlayInfo> s2CRecommendPlayList_; private RepeatedFieldBuilder<VitalityHandler.RecommendPlayInfo, VitalityHandler.RecommendPlayInfo.Builder, VitalityHandler.RecommendPlayInfoOrBuilder> s2CRecommendPlayListBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VitalityHandler.GetRecommendPlayListResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CRecommendPlayList_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CRecommendPlayList_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (VitalityHandler.GetRecommendPlayListResponse.alwaysUseFieldBuilders) getS2CRecommendPlayListFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; if (this.s2CRecommendPlayListBuilder_ == null) { this.s2CRecommendPlayList_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; } else { this.s2CRecommendPlayListBuilder_.clear(); }  return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return VitalityHandler.internal_static_pomelo_area_GetRecommendPlayListResponse_descriptor; }
/*      */       public VitalityHandler.GetRecommendPlayListResponse getDefaultInstanceForType() { return VitalityHandler.GetRecommendPlayListResponse.getDefaultInstance(); }
/*      */       public VitalityHandler.GetRecommendPlayListResponse build() { VitalityHandler.GetRecommendPlayListResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public VitalityHandler.GetRecommendPlayListResponse buildPartial() { VitalityHandler.GetRecommendPlayListResponse result = new VitalityHandler.GetRecommendPlayListResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if (this.s2CRecommendPlayListBuilder_ == null) { if ((this.bitField0_ & 0x4) == 4) { this.s2CRecommendPlayList_ = Collections.unmodifiableList(this.s2CRecommendPlayList_); this.bitField0_ &= 0xFFFFFFFB; }  result.s2CRecommendPlayList_ = this.s2CRecommendPlayList_; } else { result.s2CRecommendPlayList_ = this.s2CRecommendPlayListBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof VitalityHandler.GetRecommendPlayListResponse) return mergeFrom((VitalityHandler.GetRecommendPlayListResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(VitalityHandler.GetRecommendPlayListResponse other) { if (other == VitalityHandler.GetRecommendPlayListResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (this.s2CRecommendPlayListBuilder_ == null) { if (!other.s2CRecommendPlayList_.isEmpty()) { if (this.s2CRecommendPlayList_.isEmpty()) { this.s2CRecommendPlayList_ = other.s2CRecommendPlayList_; this.bitField0_ &= 0xFFFFFFFB; } else { ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.addAll(other.s2CRecommendPlayList_); }  onChanged(); }  } else if (!other.s2CRecommendPlayList_.isEmpty()) { if (this.s2CRecommendPlayListBuilder_.isEmpty()) { this.s2CRecommendPlayListBuilder_.dispose(); this.s2CRecommendPlayListBuilder_ = null; this.s2CRecommendPlayList_ = other.s2CRecommendPlayList_; this.bitField0_ &= 0xFFFFFFFB; this.s2CRecommendPlayListBuilder_ = VitalityHandler.GetRecommendPlayListResponse.alwaysUseFieldBuilders ? getS2CRecommendPlayListFieldBuilder() : null; } else { this.s2CRecommendPlayListBuilder_.addAllMessages(other.s2CRecommendPlayList_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  for (int i = 0; i < getS2CRecommendPlayListCount(); i++) { if (!getS2CRecommendPlayList(i).isInitialized()) return false;  }  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { VitalityHandler.GetRecommendPlayListResponse parsedMessage = null; try { parsedMessage = (VitalityHandler.GetRecommendPlayListResponse)VitalityHandler.GetRecommendPlayListResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (VitalityHandler.GetRecommendPlayListResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = VitalityHandler.GetRecommendPlayListResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       private void ensureS2CRecommendPlayListIsMutable() { if ((this.bitField0_ & 0x4) != 4) { this.s2CRecommendPlayList_ = new ArrayList<>(this.s2CRecommendPlayList_); this.bitField0_ |= 0x4; }  }
/*      */       public List<VitalityHandler.RecommendPlayInfo> getS2CRecommendPlayListList() { if (this.s2CRecommendPlayListBuilder_ == null) return Collections.unmodifiableList(this.s2CRecommendPlayList_);  return this.s2CRecommendPlayListBuilder_.getMessageList(); }
/*      */       public int getS2CRecommendPlayListCount() { if (this.s2CRecommendPlayListBuilder_ == null) return this.s2CRecommendPlayList_.size();  return this.s2CRecommendPlayListBuilder_.getCount(); }
/*      */       public VitalityHandler.RecommendPlayInfo getS2CRecommendPlayList(int index) { if (this.s2CRecommendPlayListBuilder_ == null) return this.s2CRecommendPlayList_.get(index);  return (VitalityHandler.RecommendPlayInfo)this.s2CRecommendPlayListBuilder_.getMessage(index); }
/*      */       public Builder setS2CRecommendPlayList(int index, VitalityHandler.RecommendPlayInfo value) { if (this.s2CRecommendPlayListBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.set(index, value); onChanged(); } else { this.s2CRecommendPlayListBuilder_.setMessage(index, value); }  return this; }
/*      */       public Builder setS2CRecommendPlayList(int index, VitalityHandler.RecommendPlayInfo.Builder builderForValue) { if (this.s2CRecommendPlayListBuilder_ == null) { ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.set(index, builderForValue.build()); onChanged(); } else { this.s2CRecommendPlayListBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*      */       public Builder addS2CRecommendPlayList(VitalityHandler.RecommendPlayInfo value) { if (this.s2CRecommendPlayListBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.add(value); onChanged(); } else { this.s2CRecommendPlayListBuilder_.addMessage(value); }  return this; }
/*      */       public Builder addS2CRecommendPlayList(int index, VitalityHandler.RecommendPlayInfo value) { if (this.s2CRecommendPlayListBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.add(index, value); onChanged(); } else { this.s2CRecommendPlayListBuilder_.addMessage(index, value); }  return this; }
/*      */       public Builder addS2CRecommendPlayList(VitalityHandler.RecommendPlayInfo.Builder builderForValue) { if (this.s2CRecommendPlayListBuilder_ == null) { ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.add(builderForValue.build()); onChanged(); } else { this.s2CRecommendPlayListBuilder_.addMessage(builderForValue.build()); }  return this; }
/*      */       public Builder addS2CRecommendPlayList(int index, VitalityHandler.RecommendPlayInfo.Builder builderForValue) { if (this.s2CRecommendPlayListBuilder_ == null) { ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.add(index, builderForValue.build()); onChanged(); } else { this.s2CRecommendPlayListBuilder_.addMessage(index, builderForValue.build()); }  return this; }
/*      */       public Builder addAllS2CRecommendPlayList(Iterable<? extends VitalityHandler.RecommendPlayInfo> values) { if (this.s2CRecommendPlayListBuilder_ == null) { ensureS2CRecommendPlayListIsMutable(); AbstractMessageLite.Builder.addAll(values, this.s2CRecommendPlayList_); onChanged(); } else { this.s2CRecommendPlayListBuilder_.addAllMessages(values); }  return this; }
/*      */       public Builder clearS2CRecommendPlayList() { if (this.s2CRecommendPlayListBuilder_ == null) { this.s2CRecommendPlayList_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFB; onChanged(); } else { this.s2CRecommendPlayListBuilder_.clear(); }  return this; }
/*      */       public Builder removeS2CRecommendPlayList(int index) { if (this.s2CRecommendPlayListBuilder_ == null) { ensureS2CRecommendPlayListIsMutable(); this.s2CRecommendPlayList_.remove(index); onChanged(); } else { this.s2CRecommendPlayListBuilder_.remove(index); }  return this; }
/*      */       public VitalityHandler.RecommendPlayInfo.Builder getS2CRecommendPlayListBuilder(int index) { return (VitalityHandler.RecommendPlayInfo.Builder)getS2CRecommendPlayListFieldBuilder().getBuilder(index); }
/*      */       public VitalityHandler.RecommendPlayInfoOrBuilder getS2CRecommendPlayListOrBuilder(int index) { if (this.s2CRecommendPlayListBuilder_ == null) return this.s2CRecommendPlayList_.get(index);  return (VitalityHandler.RecommendPlayInfoOrBuilder)this.s2CRecommendPlayListBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends VitalityHandler.RecommendPlayInfoOrBuilder> getS2CRecommendPlayListOrBuilderList() { if (this.s2CRecommendPlayListBuilder_ != null) return this.s2CRecommendPlayListBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.s2CRecommendPlayList_); }
/*      */       public VitalityHandler.RecommendPlayInfo.Builder addS2CRecommendPlayListBuilder() { return (VitalityHandler.RecommendPlayInfo.Builder)getS2CRecommendPlayListFieldBuilder().addBuilder(VitalityHandler.RecommendPlayInfo.getDefaultInstance()); }
/*      */       public VitalityHandler.RecommendPlayInfo.Builder addS2CRecommendPlayListBuilder(int index) { return (VitalityHandler.RecommendPlayInfo.Builder)getS2CRecommendPlayListFieldBuilder().addBuilder(index, VitalityHandler.RecommendPlayInfo.getDefaultInstance()); }
/*      */       public List<VitalityHandler.RecommendPlayInfo.Builder> getS2CRecommendPlayListBuilderList() { return getS2CRecommendPlayListFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<VitalityHandler.RecommendPlayInfo, VitalityHandler.RecommendPlayInfo.Builder, VitalityHandler.RecommendPlayInfoOrBuilder> getS2CRecommendPlayListFieldBuilder() { if (this.s2CRecommendPlayListBuilder_ == null) { this.s2CRecommendPlayListBuilder_ = new RepeatedFieldBuilder(this.s2CRecommendPlayList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean()); this.s2CRecommendPlayList_ = null; }  return this.s2CRecommendPlayListBuilder_; } }
/*      */   }
/* 5709 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 5714 */     String[] descriptorData = { "\n\025vitalityHandler.proto\022\013pomelo.area\"\030\n\026GetVitalityListRequest\"?\n\fVitalityInfo\022\n\n\002id\030\001 \002(\005\022\021\n\tcurrCount\030\002 \002(\005\022\020\n\bmaxCount\030\003 \002(\005\"&\n\tAwardInfo\022\n\n\002id\030\001 \002(\005\022\r\n\005state\030\002 \002(\005\"×\001\n\027GetVitalityListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\032\n\022s2c_totalCurrCount\030\002 \002(\005\022\031\n\021s2c_totalMaxCount\030\003 \002(\005\022\017\n\007s2c_msg\030\004 \001(\t\0223\n\020s2c_vitalityList\030\005 \003(\0132\031.pomelo.area.VitalityInfo\022-\n\rs2c_awardList\030\006 \003(\0132\026.pomelo.area.AwardInfo\"0\n\030GetVitality", "RewardRequest\022\024\n\fc2s_rewardId\030\001 \002(\005\">\n\031GetVitalityRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\035\n\033GetRecommendPlayListRequest\"D\n\021RecommendPlayInfo\022\n\n\002id\030\001 \002(\005\022\017\n\007maxTime\030\002 \002(\005\022\022\n\nremainTime\030\003 \002(\005\"\001\n\034GetRecommendPlayListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022=\n\025s2c_recommendPlayList\030\003 \003(\0132\036.pomelo.area.RecommendPlayInfo2Õ\002\n\017vitalityHandler\022c\n\026getVitalityListRequest\022#.pomelo.area.GetVital", "ityListRequest\032$.pomelo.area.GetVitalityListResponse\022i\n\030getVitalityRewardRequest\022%.pomelo.area.GetVitalityRewardRequest\032&.pomelo.area.GetVitalityRewardResponse\022r\n\033getRecommendPlayListRequest\022(.pomelo.area.GetRecommendPlayListRequest\032).pomelo.area.GetRecommendPlayListResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5743 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 5747 */           VitalityHandler.descriptor = root;
/* 5748 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 5752 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*      */   }
/*      */ 
/*      */   
/* 5756 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetVitalityListRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 5757 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetVitalityListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetVitalityListRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5762 */   private static final Descriptors.Descriptor internal_static_pomelo_area_VitalityInfo_descriptor = getDescriptor().getMessageTypes().get(1);
/* 5763 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VitalityInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VitalityInfo_descriptor, new String[] { "Id", "CurrCount", "MaxCount" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5768 */   private static final Descriptors.Descriptor internal_static_pomelo_area_AwardInfo_descriptor = getDescriptor().getMessageTypes().get(2);
/* 5769 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AwardInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AwardInfo_descriptor, new String[] { "Id", "State" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5774 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetVitalityListResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 5775 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetVitalityListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetVitalityListResponse_descriptor, new String[] { "S2CCode", "S2CTotalCurrCount", "S2CTotalMaxCount", "S2CMsg", "S2CVitalityList", "S2CAwardList" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5780 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetVitalityRewardRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 5781 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetVitalityRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetVitalityRewardRequest_descriptor, new String[] { "C2SRewardId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5786 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetVitalityRewardResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 5787 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetVitalityRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetVitalityRewardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5792 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetRecommendPlayListRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 5793 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRecommendPlayListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRecommendPlayListRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5798 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RecommendPlayInfo_descriptor = getDescriptor().getMessageTypes().get(7);
/* 5799 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RecommendPlayInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RecommendPlayInfo_descriptor, new String[] { "Id", "MaxTime", "RemainTime" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5804 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetRecommendPlayListResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 5805 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRecommendPlayListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRecommendPlayListResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CRecommendPlayList" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   public static interface GetRecommendPlayListResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<VitalityHandler.RecommendPlayInfo> getS2CRecommendPlayListList();
/*      */     
/*      */     VitalityHandler.RecommendPlayInfo getS2CRecommendPlayList(int param1Int);
/*      */     
/*      */     int getS2CRecommendPlayListCount();
/*      */     
/*      */     List<? extends VitalityHandler.RecommendPlayInfoOrBuilder> getS2CRecommendPlayListOrBuilderList();
/*      */     
/*      */     VitalityHandler.RecommendPlayInfoOrBuilder getS2CRecommendPlayListOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface RecommendPlayInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasMaxTime();
/*      */     
/*      */     int getMaxTime();
/*      */     
/*      */     boolean hasRemainTime();
/*      */     
/*      */     int getRemainTime();
/*      */   }
/*      */   
/*      */   public static interface GetRecommendPlayListRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface GetVitalityRewardResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface GetVitalityRewardRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SRewardId();
/*      */     
/*      */     int getC2SRewardId();
/*      */   }
/*      */   
/*      */   public static interface GetVitalityListResponseOrBuilder extends MessageOrBuilder {
/*      */     boolean hasS2CCode();
/*      */     
/*      */     int getS2CCode();
/*      */     
/*      */     boolean hasS2CTotalCurrCount();
/*      */     
/*      */     int getS2CTotalCurrCount();
/*      */     
/*      */     boolean hasS2CTotalMaxCount();
/*      */     
/*      */     int getS2CTotalMaxCount();
/*      */     
/*      */     boolean hasS2CMsg();
/*      */     
/*      */     String getS2CMsg();
/*      */     
/*      */     ByteString getS2CMsgBytes();
/*      */     
/*      */     List<VitalityHandler.VitalityInfo> getS2CVitalityListList();
/*      */     
/*      */     VitalityHandler.VitalityInfo getS2CVitalityList(int param1Int);
/*      */     
/*      */     int getS2CVitalityListCount();
/*      */     
/*      */     List<? extends VitalityHandler.VitalityInfoOrBuilder> getS2CVitalityListOrBuilderList();
/*      */     
/*      */     VitalityHandler.VitalityInfoOrBuilder getS2CVitalityListOrBuilder(int param1Int);
/*      */     
/*      */     List<VitalityHandler.AwardInfo> getS2CAwardListList();
/*      */     
/*      */     VitalityHandler.AwardInfo getS2CAwardList(int param1Int);
/*      */     
/*      */     int getS2CAwardListCount();
/*      */     
/*      */     List<? extends VitalityHandler.AwardInfoOrBuilder> getS2CAwardListOrBuilderList();
/*      */     
/*      */     VitalityHandler.AwardInfoOrBuilder getS2CAwardListOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface AwardInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasState();
/*      */     
/*      */     int getState();
/*      */   }
/*      */   
/*      */   public static interface VitalityInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasCurrCount();
/*      */     
/*      */     int getCurrCount();
/*      */     
/*      */     boolean hasMaxCount();
/*      */     
/*      */     int getMaxCount();
/*      */   }
/*      */   
/*      */   public static interface GetVitalityListRequestOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\VitalityHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */