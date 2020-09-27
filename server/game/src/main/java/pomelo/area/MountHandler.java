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
/*       */ import pomelo.Common;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class MountHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class ActiveMountSkinRequest
/*       */     extends GeneratedMessage
/*       */     implements ActiveMountSkinRequestOrBuilder
/*       */   {
/*   409 */     private static final ActiveMountSkinRequest defaultInstance = new ActiveMountSkinRequest(true); private final UnknownFieldSet unknownFields; private ActiveMountSkinRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ActiveMountSkinRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ActiveMountSkinRequest getDefaultInstance() { return defaultInstance; } public ActiveMountSkinRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ActiveMountSkinRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SSkinId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActiveMountSkinRequest.class, Builder.class); } public static Parser<ActiveMountSkinRequest> PARSER = (Parser<ActiveMountSkinRequest>)new AbstractParser<ActiveMountSkinRequest>() { public MountHandler.ActiveMountSkinRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.ActiveMountSkinRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_SKINID_FIELD_NUMBER = 1; private int c2SSkinId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ActiveMountSkinRequest> getParserForType() { return PARSER; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SSkinId() { return this.c2SSkinId_; } private void initFields() { this.c2SSkinId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SSkinId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SSkinId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SSkinId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ActiveMountSkinRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ActiveMountSkinRequest)PARSER.parseFrom(data); } public static ActiveMountSkinRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ActiveMountSkinRequest)PARSER.parseFrom(data, extensionRegistry); } public static ActiveMountSkinRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ActiveMountSkinRequest)PARSER.parseFrom(data); } public static ActiveMountSkinRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ActiveMountSkinRequest)PARSER.parseFrom(data, extensionRegistry); } public static ActiveMountSkinRequest parseFrom(InputStream input) throws IOException { return (ActiveMountSkinRequest)PARSER.parseFrom(input); } public static ActiveMountSkinRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ActiveMountSkinRequest)PARSER.parseFrom(input, extensionRegistry); } public static ActiveMountSkinRequest parseDelimitedFrom(InputStream input) throws IOException { return (ActiveMountSkinRequest)PARSER.parseDelimitedFrom(input); } public static ActiveMountSkinRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ActiveMountSkinRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ActiveMountSkinRequest parseFrom(CodedInputStream input) throws IOException { return (ActiveMountSkinRequest)PARSER.parseFrom(input); } public static ActiveMountSkinRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ActiveMountSkinRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ActiveMountSkinRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.ActiveMountSkinRequestOrBuilder {
/*   410 */       private int bitField0_; private int c2SSkinId_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.ActiveMountSkinRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.ActiveMountSkinRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SSkinId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinRequest_descriptor; } public MountHandler.ActiveMountSkinRequest getDefaultInstanceForType() { return MountHandler.ActiveMountSkinRequest.getDefaultInstance(); } public MountHandler.ActiveMountSkinRequest build() { MountHandler.ActiveMountSkinRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.ActiveMountSkinRequest buildPartial() { MountHandler.ActiveMountSkinRequest result = new MountHandler.ActiveMountSkinRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SSkinId_ = this.c2SSkinId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.ActiveMountSkinRequest) return mergeFrom((MountHandler.ActiveMountSkinRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.ActiveMountSkinRequest other) { if (other == MountHandler.ActiveMountSkinRequest.getDefaultInstance()) return this;  if (other.hasC2SSkinId()) setC2SSkinId(other.getC2SSkinId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SSkinId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.ActiveMountSkinRequest parsedMessage = null; try { parsedMessage = (MountHandler.ActiveMountSkinRequest)MountHandler.ActiveMountSkinRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.ActiveMountSkinRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SSkinId() { return this.c2SSkinId_; } public Builder setC2SSkinId(int value) { this.bitField0_ |= 0x1; this.c2SSkinId_ = value; onChanged(); return this; } public Builder clearC2SSkinId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SSkinId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class SaveMountRequest
/*       */     extends GeneratedMessage
/*       */     implements SaveMountRequestOrBuilder
/*       */   {
/*   900 */     private static final SaveMountRequest defaultInstance = new SaveMountRequest(true); private final UnknownFieldSet unknownFields; private SaveMountRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SaveMountRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SaveMountRequest getDefaultInstance() { return defaultInstance; } public SaveMountRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SaveMountRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SMountId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SSkinId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_SaveMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_SaveMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveMountRequest.class, Builder.class); } public static Parser<SaveMountRequest> PARSER = (Parser<SaveMountRequest>)new AbstractParser<SaveMountRequest>() { public MountHandler.SaveMountRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.SaveMountRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_MOUNTID_FIELD_NUMBER = 1; private int c2SMountId_; public static final int C2S_SKINID_FIELD_NUMBER = 2; private int c2SSkinId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SaveMountRequest> getParserForType() { return PARSER; } public boolean hasC2SMountId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SMountId() { return this.c2SMountId_; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x2) == 2); } public int getC2SSkinId() { return this.c2SSkinId_; } private void initFields() { this.c2SMountId_ = 0; this.c2SSkinId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SMountId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasC2SSkinId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SMountId_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2SSkinId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SMountId_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SSkinId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static SaveMountRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (SaveMountRequest)PARSER.parseFrom(data); } public static SaveMountRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SaveMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static SaveMountRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (SaveMountRequest)PARSER.parseFrom(data); } public static SaveMountRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (SaveMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static SaveMountRequest parseFrom(InputStream input) throws IOException { return (SaveMountRequest)PARSER.parseFrom(input); } public static SaveMountRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SaveMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static SaveMountRequest parseDelimitedFrom(InputStream input) throws IOException { return (SaveMountRequest)PARSER.parseDelimitedFrom(input); } public static SaveMountRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SaveMountRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static SaveMountRequest parseFrom(CodedInputStream input) throws IOException { return (SaveMountRequest)PARSER.parseFrom(input); } public static SaveMountRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (SaveMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(SaveMountRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.SaveMountRequestOrBuilder {
/*   901 */       private int bitField0_; private int c2SMountId_; private int c2SSkinId_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_SaveMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_SaveMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.SaveMountRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.SaveMountRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SMountId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.c2SSkinId_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_SaveMountRequest_descriptor; } public MountHandler.SaveMountRequest getDefaultInstanceForType() { return MountHandler.SaveMountRequest.getDefaultInstance(); } public MountHandler.SaveMountRequest build() { MountHandler.SaveMountRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.SaveMountRequest buildPartial() { MountHandler.SaveMountRequest result = new MountHandler.SaveMountRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SMountId_ = this.c2SMountId_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.c2SSkinId_ = this.c2SSkinId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.SaveMountRequest) return mergeFrom((MountHandler.SaveMountRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.SaveMountRequest other) { if (other == MountHandler.SaveMountRequest.getDefaultInstance()) return this;  if (other.hasC2SMountId()) setC2SMountId(other.getC2SMountId());  if (other.hasC2SSkinId()) setC2SSkinId(other.getC2SSkinId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SMountId()) return false;  if (!hasC2SSkinId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.SaveMountRequest parsedMessage = null; try { parsedMessage = (MountHandler.SaveMountRequest)MountHandler.SaveMountRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.SaveMountRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SMountId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SMountId() { return this.c2SMountId_; } public Builder setC2SMountId(int value) { this.bitField0_ |= 0x1; this.c2SMountId_ = value; onChanged(); return this; } public Builder clearC2SMountId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SMountId_ = 0; onChanged(); return this; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x2) == 2); } public int getC2SSkinId() { return this.c2SSkinId_; } public Builder setC2SSkinId(int value) { this.bitField0_ |= 0x2; this.c2SSkinId_ = value; onChanged(); return this; } public Builder clearC2SSkinId() { this.bitField0_ &= 0xFFFFFFFD; this.c2SSkinId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class UpMountStageRequest
/*       */     extends GeneratedMessage
/*       */     implements UpMountStageRequestOrBuilder
/*       */   {
/*  1213 */     private static final UpMountStageRequest defaultInstance = new UpMountStageRequest(true); private final UnknownFieldSet unknownFields; private UpMountStageRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpMountStageRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpMountStageRequest getDefaultInstance() { return defaultInstance; } public UpMountStageRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpMountStageRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_UpMountStageRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_UpMountStageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpMountStageRequest.class, Builder.class); } public static Parser<UpMountStageRequest> PARSER = (Parser<UpMountStageRequest>)new AbstractParser<UpMountStageRequest>() { public MountHandler.UpMountStageRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.UpMountStageRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpMountStageRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpMountStageRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpMountStageRequest)PARSER.parseFrom(data); } public static UpMountStageRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpMountStageRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpMountStageRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpMountStageRequest)PARSER.parseFrom(data); } public static UpMountStageRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpMountStageRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpMountStageRequest parseFrom(InputStream input) throws IOException { return (UpMountStageRequest)PARSER.parseFrom(input); } public static UpMountStageRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpMountStageRequest)PARSER.parseFrom(input, extensionRegistry); } public static UpMountStageRequest parseDelimitedFrom(InputStream input) throws IOException { return (UpMountStageRequest)PARSER.parseDelimitedFrom(input); } public static UpMountStageRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpMountStageRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UpMountStageRequest parseFrom(CodedInputStream input) throws IOException { return (UpMountStageRequest)PARSER.parseFrom(input); } public static UpMountStageRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpMountStageRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UpMountStageRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.UpMountStageRequestOrBuilder {
/*  1214 */       public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_UpMountStageRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_UpMountStageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.UpMountStageRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.UpMountStageRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_UpMountStageRequest_descriptor; } public MountHandler.UpMountStageRequest getDefaultInstanceForType() { return MountHandler.UpMountStageRequest.getDefaultInstance(); } public MountHandler.UpMountStageRequest build() { MountHandler.UpMountStageRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.UpMountStageRequest buildPartial() { MountHandler.UpMountStageRequest result = new MountHandler.UpMountStageRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.UpMountStageRequest) return mergeFrom((MountHandler.UpMountStageRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.UpMountStageRequest other) { if (other == MountHandler.UpMountStageRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.UpMountStageRequest parsedMessage = null; try { parsedMessage = (MountHandler.UpMountStageRequest)MountHandler.UpMountStageRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.UpMountStageRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class GetMountInfoRequest
/*       */     extends GeneratedMessage
/*       */     implements GetMountInfoRequestOrBuilder
/*       */   {
/*  1526 */     private static final GetMountInfoRequest defaultInstance = new GetMountInfoRequest(true); private final UnknownFieldSet unknownFields; private GetMountInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetMountInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetMountInfoRequest getDefaultInstance() { return defaultInstance; } public GetMountInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetMountInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_GetMountInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_GetMountInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMountInfoRequest.class, Builder.class); } public static Parser<GetMountInfoRequest> PARSER = (Parser<GetMountInfoRequest>)new AbstractParser<GetMountInfoRequest>() { public MountHandler.GetMountInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.GetMountInfoRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetMountInfoRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static GetMountInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (GetMountInfoRequest)PARSER.parseFrom(data); } public static GetMountInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetMountInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetMountInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (GetMountInfoRequest)PARSER.parseFrom(data); } public static GetMountInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (GetMountInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static GetMountInfoRequest parseFrom(InputStream input) throws IOException { return (GetMountInfoRequest)PARSER.parseFrom(input); } public static GetMountInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetMountInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static GetMountInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (GetMountInfoRequest)PARSER.parseDelimitedFrom(input); } public static GetMountInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetMountInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static GetMountInfoRequest parseFrom(CodedInputStream input) throws IOException { return (GetMountInfoRequest)PARSER.parseFrom(input); } public static GetMountInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (GetMountInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(GetMountInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.GetMountInfoRequestOrBuilder {
/*  1527 */       public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_GetMountInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_GetMountInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.GetMountInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.GetMountInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_GetMountInfoRequest_descriptor; } public MountHandler.GetMountInfoRequest getDefaultInstanceForType() { return MountHandler.GetMountInfoRequest.getDefaultInstance(); } public MountHandler.GetMountInfoRequest build() { MountHandler.GetMountInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.GetMountInfoRequest buildPartial() { MountHandler.GetMountInfoRequest result = new MountHandler.GetMountInfoRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.GetMountInfoRequest) return mergeFrom((MountHandler.GetMountInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.GetMountInfoRequest other) { if (other == MountHandler.GetMountInfoRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.GetMountInfoRequest parsedMessage = null; try { parsedMessage = (MountHandler.GetMountInfoRequest)MountHandler.GetMountInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.GetMountInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class TrainingMountRequest
/*       */     extends GeneratedMessage
/*       */     implements TrainingMountRequestOrBuilder
/*       */   {
/*  1931 */     private static final TrainingMountRequest defaultInstance = new TrainingMountRequest(true); private final UnknownFieldSet unknownFields; private TrainingMountRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TrainingMountRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TrainingMountRequest getDefaultInstance() { return defaultInstance; } public TrainingMountRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TrainingMountRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SType_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_TrainingMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_TrainingMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TrainingMountRequest.class, Builder.class); } public static Parser<TrainingMountRequest> PARSER = (Parser<TrainingMountRequest>)new AbstractParser<TrainingMountRequest>() { public MountHandler.TrainingMountRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.TrainingMountRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_TYPE_FIELD_NUMBER = 1; private int c2SType_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TrainingMountRequest> getParserForType() { return PARSER; } public boolean hasC2SType() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SType() { return this.c2SType_; } private void initFields() { this.c2SType_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SType()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SType_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SType_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static TrainingMountRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (TrainingMountRequest)PARSER.parseFrom(data); } public static TrainingMountRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TrainingMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static TrainingMountRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (TrainingMountRequest)PARSER.parseFrom(data); } public static TrainingMountRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TrainingMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static TrainingMountRequest parseFrom(InputStream input) throws IOException { return (TrainingMountRequest)PARSER.parseFrom(input); } public static TrainingMountRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TrainingMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static TrainingMountRequest parseDelimitedFrom(InputStream input) throws IOException { return (TrainingMountRequest)PARSER.parseDelimitedFrom(input); } public static TrainingMountRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TrainingMountRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static TrainingMountRequest parseFrom(CodedInputStream input) throws IOException { return (TrainingMountRequest)PARSER.parseFrom(input); } public static TrainingMountRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TrainingMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(TrainingMountRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.TrainingMountRequestOrBuilder {
/*  1932 */       private int bitField0_; private int c2SType_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_TrainingMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_TrainingMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.TrainingMountRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.TrainingMountRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SType_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_TrainingMountRequest_descriptor; } public MountHandler.TrainingMountRequest getDefaultInstanceForType() { return MountHandler.TrainingMountRequest.getDefaultInstance(); } public MountHandler.TrainingMountRequest build() { MountHandler.TrainingMountRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.TrainingMountRequest buildPartial() { MountHandler.TrainingMountRequest result = new MountHandler.TrainingMountRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SType_ = this.c2SType_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.TrainingMountRequest) return mergeFrom((MountHandler.TrainingMountRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.TrainingMountRequest other) { if (other == MountHandler.TrainingMountRequest.getDefaultInstance()) return this;  if (other.hasC2SType()) setC2SType(other.getC2SType());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SType()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.TrainingMountRequest parsedMessage = null; try { parsedMessage = (MountHandler.TrainingMountRequest)MountHandler.TrainingMountRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.TrainingMountRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SType() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SType() { return this.c2SType_; } public Builder setC2SType(int value) { this.bitField0_ |= 0x1; this.c2SType_ = value; onChanged(); return this; } public Builder clearC2SType() { this.bitField0_ &= 0xFFFFFFFE; this.c2SType_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class RidingMountRequest
/*       */     extends GeneratedMessage
/*       */     implements RidingMountRequestOrBuilder
/*       */   {
/*  2336 */     private static final RidingMountRequest defaultInstance = new RidingMountRequest(true); private final UnknownFieldSet unknownFields; private RidingMountRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RidingMountRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RidingMountRequest getDefaultInstance() { return defaultInstance; } public RidingMountRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RidingMountRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SIsUp_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_RidingMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_RidingMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RidingMountRequest.class, Builder.class); } public static Parser<RidingMountRequest> PARSER = (Parser<RidingMountRequest>)new AbstractParser<RidingMountRequest>() { public MountHandler.RidingMountRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.RidingMountRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_ISUP_FIELD_NUMBER = 1; private int c2SIsUp_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RidingMountRequest> getParserForType() { return PARSER; } public boolean hasC2SIsUp() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SIsUp() { return this.c2SIsUp_; } private void initFields() { this.c2SIsUp_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SIsUp()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SIsUp_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SIsUp_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RidingMountRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RidingMountRequest)PARSER.parseFrom(data); } public static RidingMountRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RidingMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static RidingMountRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RidingMountRequest)PARSER.parseFrom(data); } public static RidingMountRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RidingMountRequest)PARSER.parseFrom(data, extensionRegistry); } public static RidingMountRequest parseFrom(InputStream input) throws IOException { return (RidingMountRequest)PARSER.parseFrom(input); } public static RidingMountRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static RidingMountRequest parseDelimitedFrom(InputStream input) throws IOException { return (RidingMountRequest)PARSER.parseDelimitedFrom(input); } public static RidingMountRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RidingMountRequest parseFrom(CodedInputStream input) throws IOException { return (RidingMountRequest)PARSER.parseFrom(input); } public static RidingMountRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RidingMountRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.RidingMountRequestOrBuilder {
/*  2337 */       private int bitField0_; private int c2SIsUp_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_RidingMountRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_RidingMountRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.RidingMountRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.RidingMountRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SIsUp_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_RidingMountRequest_descriptor; } public MountHandler.RidingMountRequest getDefaultInstanceForType() { return MountHandler.RidingMountRequest.getDefaultInstance(); } public MountHandler.RidingMountRequest build() { MountHandler.RidingMountRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.RidingMountRequest buildPartial() { MountHandler.RidingMountRequest result = new MountHandler.RidingMountRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SIsUp_ = this.c2SIsUp_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.RidingMountRequest) return mergeFrom((MountHandler.RidingMountRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.RidingMountRequest other) { if (other == MountHandler.RidingMountRequest.getDefaultInstance()) return this;  if (other.hasC2SIsUp()) setC2SIsUp(other.getC2SIsUp());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SIsUp()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.RidingMountRequest parsedMessage = null; try { parsedMessage = (MountHandler.RidingMountRequest)MountHandler.RidingMountRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.RidingMountRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SIsUp() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SIsUp() { return this.c2SIsUp_; } public Builder setC2SIsUp(int value) { this.bitField0_ |= 0x1; this.c2SIsUp_ = value; onChanged(); return this; } public Builder clearC2SIsUp() { this.bitField0_ &= 0xFFFFFFFE; this.c2SIsUp_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class OneKeyTrainingRequest
/*       */     extends GeneratedMessage
/*       */     implements OneKeyTrainingRequestOrBuilder
/*       */   {
/*  2649 */     private static final OneKeyTrainingRequest defaultInstance = new OneKeyTrainingRequest(true); private final UnknownFieldSet unknownFields; private OneKeyTrainingRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OneKeyTrainingRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OneKeyTrainingRequest getDefaultInstance() { return defaultInstance; } public OneKeyTrainingRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OneKeyTrainingRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OneKeyTrainingRequest.class, Builder.class); } public static Parser<OneKeyTrainingRequest> PARSER = (Parser<OneKeyTrainingRequest>)new AbstractParser<OneKeyTrainingRequest>() { public MountHandler.OneKeyTrainingRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.OneKeyTrainingRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OneKeyTrainingRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static OneKeyTrainingRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (OneKeyTrainingRequest)PARSER.parseFrom(data); } public static OneKeyTrainingRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OneKeyTrainingRequest)PARSER.parseFrom(data, extensionRegistry); } public static OneKeyTrainingRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (OneKeyTrainingRequest)PARSER.parseFrom(data); } public static OneKeyTrainingRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (OneKeyTrainingRequest)PARSER.parseFrom(data, extensionRegistry); } public static OneKeyTrainingRequest parseFrom(InputStream input) throws IOException { return (OneKeyTrainingRequest)PARSER.parseFrom(input); } public static OneKeyTrainingRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OneKeyTrainingRequest)PARSER.parseFrom(input, extensionRegistry); } public static OneKeyTrainingRequest parseDelimitedFrom(InputStream input) throws IOException { return (OneKeyTrainingRequest)PARSER.parseDelimitedFrom(input); } public static OneKeyTrainingRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OneKeyTrainingRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static OneKeyTrainingRequest parseFrom(CodedInputStream input) throws IOException { return (OneKeyTrainingRequest)PARSER.parseFrom(input); } public static OneKeyTrainingRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (OneKeyTrainingRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(OneKeyTrainingRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.OneKeyTrainingRequestOrBuilder {
/*  2650 */       public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.OneKeyTrainingRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.OneKeyTrainingRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingRequest_descriptor; } public MountHandler.OneKeyTrainingRequest getDefaultInstanceForType() { return MountHandler.OneKeyTrainingRequest.getDefaultInstance(); } public MountHandler.OneKeyTrainingRequest build() { MountHandler.OneKeyTrainingRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.OneKeyTrainingRequest buildPartial() { MountHandler.OneKeyTrainingRequest result = new MountHandler.OneKeyTrainingRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.OneKeyTrainingRequest) return mergeFrom((MountHandler.OneKeyTrainingRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.OneKeyTrainingRequest other) { if (other == MountHandler.OneKeyTrainingRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.OneKeyTrainingRequest parsedMessage = null; try { parsedMessage = (MountHandler.OneKeyTrainingRequest)MountHandler.OneKeyTrainingRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.OneKeyTrainingRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class ItemData
/*       */     extends GeneratedMessage
/*       */     implements ItemDataOrBuilder
/*       */   {
/*  3721 */     private static final ItemData defaultInstance = new ItemData(true); private final UnknownFieldSet unknownFields; private ItemData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ItemData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ItemData getDefaultInstance() { return defaultInstance; } public ItemData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ItemData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.costId_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.costItemIcon_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.costItemName_ = bs; break;case 32: this.bitField0_ |= 0x8; this.curItemNum_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.costNum_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.costItemQuality_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ItemData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ItemData_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemData.class, Builder.class); } public static Parser<ItemData> PARSER = (Parser<ItemData>)new AbstractParser<ItemData>() { public MountHandler.ItemData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.ItemData(input, extensionRegistry); } }
/*  3722 */     ; private int bitField0_; public static final int COSTID_FIELD_NUMBER = 1; private Object costId_; public static final int COSTITEMICON_FIELD_NUMBER = 2; private Object costItemIcon_; public static final int COSTITEMNAME_FIELD_NUMBER = 3; private Object costItemName_; public static final int CURITEMNUM_FIELD_NUMBER = 4; private int curItemNum_; public static final int COSTNUM_FIELD_NUMBER = 5; private int costNum_; public static final int COSTITEMQUALITY_FIELD_NUMBER = 6; private int costItemQuality_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ItemData> getParserForType() { return PARSER; } public boolean hasCostId() { return ((this.bitField0_ & 0x1) == 1); } public String getCostId() { Object ref = this.costId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.costId_ = s;  return s; } public ByteString getCostIdBytes() { Object ref = this.costId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.costId_ = b; return b; }  return (ByteString)ref; } public boolean hasCostItemIcon() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getCostItemIcon() {
/*       */       Object ref = this.costItemIcon_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.costItemIcon_ = s;
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
/*       */     public ByteString getCostItemIconBytes() {
/*       */       Object ref = this.costItemIcon_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.costItemIcon_ = b;
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
/*       */     public boolean hasCostItemName() {
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
/*       */     public String getCostItemName() {
/*       */       Object ref = this.costItemName_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.costItemName_ = s;
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
/*       */     public ByteString getCostItemNameBytes() {
/*       */       Object ref = this.costItemName_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.costItemName_ = b;
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
/*       */     public boolean hasCurItemNum() {
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
/*       */     public int getCurItemNum() {
/*       */       return this.curItemNum_;
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
/*       */     public boolean hasCostNum() {
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
/*       */     public int getCostNum() {
/*       */       return this.costNum_;
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
/*       */     public boolean hasCostItemQuality() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
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
/*       */     public int getCostItemQuality() {
/*       */       return this.costItemQuality_;
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
/*       */     private void initFields() {
/*       */       this.costId_ = "";
/*       */       this.costItemIcon_ = "";
/*       */       this.costItemName_ = "";
/*       */       this.curItemNum_ = 0;
/*       */       this.costNum_ = 0;
/*       */       this.costItemQuality_ = 0;
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
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasCostId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCostItemIcon()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCostItemName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCurItemNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCostNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCostItemQuality()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getCostIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getCostItemIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getCostItemNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.curItemNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.costNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.costItemQuality_);
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeBytesSize(1, getCostIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getCostItemIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getCostItemNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.curItemNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.costNum_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.costItemQuality_);
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
/*       */     public static ItemData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ItemData)PARSER.parseFrom(data);
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
/*       */     public static ItemData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ItemData)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static ItemData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ItemData)PARSER.parseFrom(data);
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
/*       */     public static ItemData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ItemData)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static ItemData parseFrom(InputStream input) throws IOException {
/*       */       return (ItemData)PARSER.parseFrom(input);
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
/*       */     public static ItemData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ItemData)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static ItemData parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ItemData)PARSER.parseDelimitedFrom(input);
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
/*       */     public static ItemData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ItemData)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static ItemData parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ItemData)PARSER.parseFrom(input);
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
/*       */     public static ItemData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ItemData)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(ItemData prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements MountHandler.ItemDataOrBuilder
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
/*       */       private Object costId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object costItemIcon_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object costItemName_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int curItemNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int costNum_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int costItemQuality_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return MountHandler.internal_static_pomelo_area_ItemData_descriptor;
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
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_ItemData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.ItemData.class, Builder.class);
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
/*       */       private Builder() {
/*       */         this.costId_ = "";
/*       */         this.costItemIcon_ = "";
/*       */         this.costItemName_ = "";
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.costId_ = "";
/*       */         this.costItemIcon_ = "";
/*       */         this.costItemName_ = "";
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.ItemData.alwaysUseFieldBuilders);
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.costId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.costItemIcon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.costItemName_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.curItemNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.costNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.costItemQuality_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return MountHandler.internal_static_pomelo_area_ItemData_descriptor;
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
/*       */       public MountHandler.ItemData getDefaultInstanceForType() {
/*       */         return MountHandler.ItemData.getDefaultInstance();
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
/*       */       public MountHandler.ItemData build() {
/*       */         MountHandler.ItemData result = buildPartial();
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
/*       */       public MountHandler.ItemData buildPartial() {
/*       */         MountHandler.ItemData result = new MountHandler.ItemData(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.costId_ = this.costId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.costItemIcon_ = this.costItemIcon_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.costItemName_ = this.costItemName_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.curItemNum_ = this.curItemNum_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.costNum_ = this.costNum_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.costItemQuality_ = this.costItemQuality_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.ItemData) {
/*       */           return mergeFrom((MountHandler.ItemData)other);
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
/*       */       public Builder mergeFrom(MountHandler.ItemData other) {
/*       */         if (other == MountHandler.ItemData.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasCostId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.costId_ = other.costId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCostItemIcon()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.costItemIcon_ = other.costItemIcon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCostItemName()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.costItemName_ = other.costItemName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasCurItemNum()) {
/*       */           setCurItemNum(other.getCurItemNum());
/*       */         }
/*       */         if (other.hasCostNum()) {
/*       */           setCostNum(other.getCostNum());
/*       */         }
/*       */         if (other.hasCostItemQuality()) {
/*       */           setCostItemQuality(other.getCostItemQuality());
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasCostId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCostItemIcon()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCostItemName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCurItemNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCostNum()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasCostItemQuality()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.ItemData parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.ItemData)MountHandler.ItemData.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.ItemData)e.getUnfinishedMessage();
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
/*       */       public boolean hasCostId() {
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
/*       */       public String getCostId() {
/*       */         Object ref = this.costId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.costId_ = s;
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
/*       */       public ByteString getCostIdBytes() {
/*       */         Object ref = this.costId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.costId_ = b;
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
/*       */       public Builder setCostId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.costId_ = value;
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
/*       */       public Builder clearCostId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.costId_ = MountHandler.ItemData.getDefaultInstance().getCostId();
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
/*       */       public Builder setCostIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.costId_ = value;
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
/*       */       public boolean hasCostItemIcon() {
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
/*       */       public String getCostItemIcon() {
/*       */         Object ref = this.costItemIcon_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.costItemIcon_ = s;
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
/*       */       public ByteString getCostItemIconBytes() {
/*       */         Object ref = this.costItemIcon_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.costItemIcon_ = b;
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
/*       */       public Builder setCostItemIcon(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.costItemIcon_ = value;
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
/*       */       public Builder clearCostItemIcon() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.costItemIcon_ = MountHandler.ItemData.getDefaultInstance().getCostItemIcon();
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
/*       */       public Builder setCostItemIconBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.costItemIcon_ = value;
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
/*       */       public boolean hasCostItemName() {
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
/*       */       public String getCostItemName() {
/*       */         Object ref = this.costItemName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.costItemName_ = s;
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
/*       */       public ByteString getCostItemNameBytes() {
/*       */         Object ref = this.costItemName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.costItemName_ = b;
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
/*       */       public Builder setCostItemName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.costItemName_ = value;
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
/*       */       public Builder clearCostItemName() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.costItemName_ = MountHandler.ItemData.getDefaultInstance().getCostItemName();
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
/*       */       public Builder setCostItemNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.costItemName_ = value;
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
/*       */       public boolean hasCurItemNum() {
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
/*       */       public int getCurItemNum() {
/*       */         return this.curItemNum_;
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
/*       */       public Builder setCurItemNum(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.curItemNum_ = value;
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
/*       */       public Builder clearCurItemNum() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.curItemNum_ = 0;
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
/*       */       public boolean hasCostNum() {
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
/*       */       public int getCostNum() {
/*       */         return this.costNum_;
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
/*       */       public Builder setCostNum(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.costNum_ = value;
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
/*       */       public Builder clearCostNum() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.costNum_ = 0;
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
/*       */       public boolean hasCostItemQuality() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
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
/*       */       public int getCostItemQuality() {
/*       */         return this.costItemQuality_;
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
/*       */       public Builder setCostItemQuality(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.costItemQuality_ = value;
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
/*       */       public Builder clearCostItemQuality() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.costItemQuality_ = 0;
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
/*       */   public static final class SkinInfoData
/*       */     extends GeneratedMessage
/*       */     implements SkinInfoDataOrBuilder
/*       */   {
/*  5416 */     private static final SkinInfoData defaultInstance = new SkinInfoData(true); private final UnknownFieldSet unknownFields; private SkinInfoData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SkinInfoData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SkinInfoData getDefaultInstance() { return defaultInstance; } public SkinInfoData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SkinInfoData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = bs; break;case 24: this.bitField0_ |= 0x4; this.needRideLevel_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.icon_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.modelFile_ = bs; break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.desc_ = bs; break;case 56: this.bitField0_ |= 0x40; this.state_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.fightPowerValue_ = input.readInt32(); break;case 74: if ((mutable_bitField0_ & 0x100) != 256) { this.skinAttrs_ = new ArrayList<>(); mutable_bitField0_ |= 0x100; }  this.skinAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x100) == 256) this.skinAttrs_ = Collections.unmodifiableList(this.skinAttrs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_SkinInfoData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_SkinInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(SkinInfoData.class, Builder.class); } public static Parser<SkinInfoData> PARSER = (Parser<SkinInfoData>)new AbstractParser<SkinInfoData>() { public MountHandler.SkinInfoData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.SkinInfoData(input, extensionRegistry); } }
/*  5417 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; public static final int NEEDRIDELEVEL_FIELD_NUMBER = 3; private int needRideLevel_; public static final int ICON_FIELD_NUMBER = 4; private Object icon_; public static final int MODELFILE_FIELD_NUMBER = 5; private Object modelFile_; public static final int DESC_FIELD_NUMBER = 6; private Object desc_; public static final int STATE_FIELD_NUMBER = 7; private int state_; public static final int FIGHTPOWERVALUE_FIELD_NUMBER = 8; private int fightPowerValue_; public static final int SKINATTRS_FIELD_NUMBER = 9; private List<Common.AttributeBase> skinAttrs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SkinInfoData> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public boolean hasNeedRideLevel() { return ((this.bitField0_ & 0x4) == 4); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getNeedRideLevel() {
/*       */       return this.needRideLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasIcon() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getIcon() {
/*       */       Object ref = this.icon_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.icon_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getIconBytes() {
/*       */       Object ref = this.icon_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.icon_ = b;
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
/*       */     public boolean hasModelFile() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getModelFile() {
/*       */       Object ref = this.modelFile_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.modelFile_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getModelFileBytes() {
/*       */       Object ref = this.modelFile_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.modelFile_ = b;
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
/*       */     public boolean hasDesc() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getDesc() {
/*       */       Object ref = this.desc_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.desc_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getDescBytes() {
/*       */       Object ref = this.desc_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.desc_ = b;
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
/*       */     public boolean hasState() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getState() {
/*       */       return this.state_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasFightPowerValue() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getFightPowerValue() {
/*       */       return this.fightPowerValue_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<Common.AttributeBase> getSkinAttrsList() {
/*       */       return this.skinAttrs_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList() {
/*       */       return (List)this.skinAttrs_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSkinAttrsCount() {
/*       */       return this.skinAttrs_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.AttributeBase getSkinAttrs(int index) {
/*       */       return this.skinAttrs_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int index) {
/*       */       return (Common.AttributeBaseOrBuilder)this.skinAttrs_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = 0;
/*       */       this.name_ = "";
/*       */       this.needRideLevel_ = 0;
/*       */       this.icon_ = "";
/*       */       this.modelFile_ = "";
/*       */       this.desc_ = "";
/*       */       this.state_ = 0;
/*       */       this.fightPowerValue_ = 0;
/*       */       this.skinAttrs_ = Collections.emptyList();
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
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasNeedRideLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasIcon()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasModelFile()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDesc()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasState()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasFightPowerValue()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getSkinAttrsCount(); i++) {
/*       */         if (!getSkinAttrs(i).isInitialized()) {
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
/*       */         output.writeInt32(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.needRideLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeBytes(5, getModelFileBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeBytes(6, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(7, this.state_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(8, this.fightPowerValue_);
/*       */       }
/*       */       for (int i = 0; i < this.skinAttrs_.size(); i++) {
/*       */         output.writeMessage(9, (MessageLite)this.skinAttrs_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.needRideLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeBytesSize(5, getModelFileBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeBytesSize(6, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(7, this.state_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.fightPowerValue_);
/*       */       }
/*       */       for (int i = 0; i < this.skinAttrs_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(9, (MessageLite)this.skinAttrs_.get(i));
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
/*       */     public static SkinInfoData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SkinInfoData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SkinInfoData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SkinInfoData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SkinInfoData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(InputStream input) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SkinInfoData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SkinInfoData)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(SkinInfoData prototype) {
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
/*       */       implements MountHandler.SkinInfoDataOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int id_;
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
/*       */       private int needRideLevel_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object icon_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object modelFile_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object desc_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int state_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int fightPowerValue_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<Common.AttributeBase> skinAttrs_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> skinAttrsBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_SkinInfoData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_SkinInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.SkinInfoData.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         this.icon_ = "";
/*       */         this.modelFile_ = "";
/*       */         this.desc_ = "";
/*       */         this.skinAttrs_ = Collections.emptyList();
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
/*       */         this.name_ = "";
/*       */         this.icon_ = "";
/*       */         this.modelFile_ = "";
/*       */         this.desc_ = "";
/*       */         this.skinAttrs_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.SkinInfoData.alwaysUseFieldBuilders) {
/*       */           getSkinAttrsFieldBuilder();
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
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.needRideLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.icon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.modelFile_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.desc_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.state_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.fightPowerValue_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */         } else {
/*       */           this.skinAttrsBuilder_.clear();
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
/*       */         return MountHandler.internal_static_pomelo_area_SkinInfoData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.SkinInfoData getDefaultInstanceForType() {
/*       */         return MountHandler.SkinInfoData.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.SkinInfoData build() {
/*       */         MountHandler.SkinInfoData result = buildPartial();
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
/*       */       public MountHandler.SkinInfoData buildPartial() {
/*       */         MountHandler.SkinInfoData result = new MountHandler.SkinInfoData(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.needRideLevel_ = this.needRideLevel_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.icon_ = this.icon_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.modelFile_ = this.modelFile_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.desc_ = this.desc_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.state_ = this.state_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.fightPowerValue_ = this.fightPowerValue_;
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x100) == 256) {
/*       */             this.skinAttrs_ = Collections.unmodifiableList(this.skinAttrs_);
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */           } 
/*       */           result.skinAttrs_ = this.skinAttrs_;
/*       */         } else {
/*       */           result.skinAttrs_ = this.skinAttrsBuilder_.build();
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
/*       */         if (other instanceof MountHandler.SkinInfoData) {
/*       */           return mergeFrom((MountHandler.SkinInfoData)other);
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
/*       */       public Builder mergeFrom(MountHandler.SkinInfoData other) {
/*       */         if (other == MountHandler.SkinInfoData.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           setId(other.getId());
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasNeedRideLevel()) {
/*       */           setNeedRideLevel(other.getNeedRideLevel());
/*       */         }
/*       */         if (other.hasIcon()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.icon_ = other.icon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasModelFile()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.modelFile_ = other.modelFile_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasDesc()) {
/*       */           this.bitField0_ |= 0x20;
/*       */           this.desc_ = other.desc_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasState()) {
/*       */           setState(other.getState());
/*       */         }
/*       */         if (other.hasFightPowerValue()) {
/*       */           setFightPowerValue(other.getFightPowerValue());
/*       */         }
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (!other.skinAttrs_.isEmpty()) {
/*       */             if (this.skinAttrs_.isEmpty()) {
/*       */               this.skinAttrs_ = other.skinAttrs_;
/*       */               this.bitField0_ &= 0xFFFFFEFF;
/*       */             } else {
/*       */               ensureSkinAttrsIsMutable();
/*       */               this.skinAttrs_.addAll(other.skinAttrs_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.skinAttrs_.isEmpty()) {
/*       */           if (this.skinAttrsBuilder_.isEmpty()) {
/*       */             this.skinAttrsBuilder_.dispose();
/*       */             this.skinAttrsBuilder_ = null;
/*       */             this.skinAttrs_ = other.skinAttrs_;
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */             this.skinAttrsBuilder_ = MountHandler.SkinInfoData.alwaysUseFieldBuilders ? getSkinAttrsFieldBuilder() : null;
/*       */           } else {
/*       */             this.skinAttrsBuilder_.addAllMessages(other.skinAttrs_);
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
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasNeedRideLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasIcon()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasModelFile()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasDesc()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasState()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasFightPowerValue()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getSkinAttrsCount(); i++) {
/*       */           if (!getSkinAttrs(i).isInitialized()) {
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
/*       */         MountHandler.SkinInfoData parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.SkinInfoData)MountHandler.SkinInfoData.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.SkinInfoData)e.getUnfinishedMessage();
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getId() {
/*       */         return this.id_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
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
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = MountHandler.SkinInfoData.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */         this.bitField0_ |= 0x2;
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
/*       */       public boolean hasNeedRideLevel() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getNeedRideLevel() {
/*       */         return this.needRideLevel_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNeedRideLevel(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.needRideLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearNeedRideLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.needRideLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasIcon() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getIcon() {
/*       */         Object ref = this.icon_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.icon_ = s;
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
/*       */       public ByteString getIconBytes() {
/*       */         Object ref = this.icon_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.icon_ = b;
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
/*       */       public Builder setIcon(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.icon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearIcon() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.icon_ = MountHandler.SkinInfoData.getDefaultInstance().getIcon();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIconBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.icon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasModelFile() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getModelFile() {
/*       */         Object ref = this.modelFile_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.modelFile_ = s;
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
/*       */       public ByteString getModelFileBytes() {
/*       */         Object ref = this.modelFile_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.modelFile_ = b;
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
/*       */       public Builder setModelFile(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.modelFile_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearModelFile() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.modelFile_ = MountHandler.SkinInfoData.getDefaultInstance().getModelFile();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setModelFileBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.modelFile_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasDesc() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getDesc() {
/*       */         Object ref = this.desc_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.desc_ = s;
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
/*       */       public ByteString getDescBytes() {
/*       */         Object ref = this.desc_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.desc_ = b;
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
/*       */       public Builder setDesc(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.desc_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDesc() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.desc_ = MountHandler.SkinInfoData.getDefaultInstance().getDesc();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDescBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.desc_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasState() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getState() {
/*       */         return this.state_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setState(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.state_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearState() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.state_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasFightPowerValue() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getFightPowerValue() {
/*       */         return this.fightPowerValue_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setFightPowerValue(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.fightPowerValue_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearFightPowerValue() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.fightPowerValue_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureSkinAttrsIsMutable() {
/*       */         if ((this.bitField0_ & 0x100) != 256) {
/*       */           this.skinAttrs_ = new ArrayList<>(this.skinAttrs_);
/*       */           this.bitField0_ |= 0x100;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.AttributeBase> getSkinAttrsList() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.skinAttrs_);
/*       */         }
/*       */         return this.skinAttrsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getSkinAttrsCount() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return this.skinAttrs_.size();
/*       */         }
/*       */         return this.skinAttrsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase getSkinAttrs(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return this.skinAttrs_.get(index);
/*       */         }
/*       */         return (Common.AttributeBase)this.skinAttrsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkinAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkinAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllSkinAttrs(Iterable<? extends Common.AttributeBase> values) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.skinAttrs_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearSkinAttrs() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeSkinAttrs(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder getSkinAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return (Common.AttributeBaseOrBuilder)this.skinAttrs_.get(index);
/*       */         }
/*       */         return (Common.AttributeBaseOrBuilder)this.skinAttrsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList() {
/*       */         if (this.skinAttrsBuilder_ != null) {
/*       */           return this.skinAttrsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return (List)Collections.unmodifiableList(this.skinAttrs_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder addSkinAttrsBuilder() {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().addBuilder((GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder addSkinAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.AttributeBase.Builder> getSkinAttrsBuilderList() {
/*       */         return getSkinAttrsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getSkinAttrsFieldBuilder() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrsBuilder_ = new RepeatedFieldBuilder(this.skinAttrs_, ((this.bitField0_ & 0x100) == 256), getParentForChildren(), isClean());
/*       */           this.skinAttrs_ = null;
/*       */         } 
/*       */         return this.skinAttrsBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class MountInfoData
/*       */     extends GeneratedMessage
/*       */     implements MountInfoDataOrBuilder
/*       */   {
/*  7111 */     private static final MountInfoData defaultInstance = new MountInfoData(true); private final UnknownFieldSet unknownFields; private MountInfoData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MountInfoData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MountInfoData getDefaultInstance() { return defaultInstance; } public MountInfoData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MountInfoData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = bs; break;case 24: this.bitField0_ |= 0x4; this.level_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.icon_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.modelFile_ = bs; break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.desc_ = bs; break;case 56: this.bitField0_ |= 0x40; this.state_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.fightPowerValue_ = input.readInt32(); break;case 74: if ((mutable_bitField0_ & 0x100) != 256) { this.skinAttrs_ = new ArrayList<>(); mutable_bitField0_ |= 0x100; }  this.skinAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x100) == 256) this.skinAttrs_ = Collections.unmodifiableList(this.skinAttrs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountInfoData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountInfoData.class, Builder.class); } public static Parser<MountInfoData> PARSER = (Parser<MountInfoData>)new AbstractParser<MountInfoData>() { public MountHandler.MountInfoData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.MountInfoData(input, extensionRegistry); } }
/*  7112 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; public static final int LEVEL_FIELD_NUMBER = 3; private int level_; public static final int ICON_FIELD_NUMBER = 4; private Object icon_; public static final int MODELFILE_FIELD_NUMBER = 5; private Object modelFile_; public static final int DESC_FIELD_NUMBER = 6; private Object desc_; public static final int STATE_FIELD_NUMBER = 7; private int state_; public static final int FIGHTPOWERVALUE_FIELD_NUMBER = 8; private int fightPowerValue_; public static final int SKINATTRS_FIELD_NUMBER = 9; private List<Common.AttributeBase> skinAttrs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MountInfoData> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public boolean hasLevel() { return ((this.bitField0_ & 0x4) == 4); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getLevel() {
/*       */       return this.level_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasIcon() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getIcon() {
/*       */       Object ref = this.icon_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.icon_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getIconBytes() {
/*       */       Object ref = this.icon_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.icon_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasModelFile() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getModelFile() {
/*       */       Object ref = this.modelFile_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.modelFile_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getModelFileBytes() {
/*       */       Object ref = this.modelFile_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.modelFile_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasDesc() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getDesc() {
/*       */       Object ref = this.desc_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.desc_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getDescBytes() {
/*       */       Object ref = this.desc_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.desc_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasState() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getState() {
/*       */       return this.state_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasFightPowerValue() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getFightPowerValue() {
/*       */       return this.fightPowerValue_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<Common.AttributeBase> getSkinAttrsList() {
/*       */       return this.skinAttrs_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList() {
/*       */       return (List)this.skinAttrs_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSkinAttrsCount() {
/*       */       return this.skinAttrs_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.AttributeBase getSkinAttrs(int index) {
/*       */       return this.skinAttrs_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int index) {
/*       */       return (Common.AttributeBaseOrBuilder)this.skinAttrs_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = 0;
/*       */       this.name_ = "";
/*       */       this.level_ = 0;
/*       */       this.icon_ = "";
/*       */       this.modelFile_ = "";
/*       */       this.desc_ = "";
/*       */       this.state_ = 0;
/*       */       this.fightPowerValue_ = 0;
/*       */       this.skinAttrs_ = Collections.emptyList();
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
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasLevel()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasIcon()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasModelFile()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDesc()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasState()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasFightPowerValue()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getSkinAttrsCount(); i++) {
/*       */         if (!getSkinAttrs(i).isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeBytes(5, getModelFileBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeBytes(6, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(7, this.state_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(8, this.fightPowerValue_);
/*       */       }
/*       */       for (int i = 0; i < this.skinAttrs_.size(); i++) {
/*       */         output.writeMessage(9, (MessageLite)this.skinAttrs_.get(i));
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeBytesSize(5, getModelFileBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeBytesSize(6, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(7, this.state_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.fightPowerValue_);
/*       */       }
/*       */       for (int i = 0; i < this.skinAttrs_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(9, (MessageLite)this.skinAttrs_.get(i));
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
/*       */     public static MountInfoData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (MountInfoData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MountInfoData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (MountInfoData)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (MountInfoData)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(InputStream input) throws IOException {
/*       */       return (MountInfoData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MountInfoData)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (MountInfoData)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MountInfoData)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(CodedInputStream input) throws IOException {
/*       */       return (MountInfoData)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static MountInfoData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (MountInfoData)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(MountInfoData prototype) {
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
/*       */       implements MountHandler.MountInfoDataOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int id_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object name_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int level_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object icon_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object modelFile_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object desc_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int state_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int fightPowerValue_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<Common.AttributeBase> skinAttrs_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> skinAttrsBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_MountInfoData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_MountInfoData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.MountInfoData.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         this.icon_ = "";
/*       */         this.modelFile_ = "";
/*       */         this.desc_ = "";
/*       */         this.skinAttrs_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.name_ = "";
/*       */         this.icon_ = "";
/*       */         this.modelFile_ = "";
/*       */         this.desc_ = "";
/*       */         this.skinAttrs_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.MountInfoData.alwaysUseFieldBuilders) {
/*       */           getSkinAttrsFieldBuilder();
/*       */         }
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
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.level_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.icon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.modelFile_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.desc_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.state_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.fightPowerValue_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */         } else {
/*       */           this.skinAttrsBuilder_.clear();
/*       */         } 
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
/*       */         return MountHandler.internal_static_pomelo_area_MountInfoData_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountInfoData getDefaultInstanceForType() {
/*       */         return MountHandler.MountInfoData.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountInfoData build() {
/*       */         MountHandler.MountInfoData result = buildPartial();
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
/*       */       public MountHandler.MountInfoData buildPartial() {
/*       */         MountHandler.MountInfoData result = new MountHandler.MountInfoData(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.level_ = this.level_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.icon_ = this.icon_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.modelFile_ = this.modelFile_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.desc_ = this.desc_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.state_ = this.state_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.fightPowerValue_ = this.fightPowerValue_;
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x100) == 256) {
/*       */             this.skinAttrs_ = Collections.unmodifiableList(this.skinAttrs_);
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */           } 
/*       */           result.skinAttrs_ = this.skinAttrs_;
/*       */         } else {
/*       */           result.skinAttrs_ = this.skinAttrsBuilder_.build();
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.MountInfoData) {
/*       */           return mergeFrom((MountHandler.MountInfoData)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(MountHandler.MountInfoData other) {
/*       */         if (other == MountHandler.MountInfoData.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           setId(other.getId());
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasLevel()) {
/*       */           setLevel(other.getLevel());
/*       */         }
/*       */         if (other.hasIcon()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.icon_ = other.icon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasModelFile()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.modelFile_ = other.modelFile_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasDesc()) {
/*       */           this.bitField0_ |= 0x20;
/*       */           this.desc_ = other.desc_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasState()) {
/*       */           setState(other.getState());
/*       */         }
/*       */         if (other.hasFightPowerValue()) {
/*       */           setFightPowerValue(other.getFightPowerValue());
/*       */         }
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (!other.skinAttrs_.isEmpty()) {
/*       */             if (this.skinAttrs_.isEmpty()) {
/*       */               this.skinAttrs_ = other.skinAttrs_;
/*       */               this.bitField0_ &= 0xFFFFFEFF;
/*       */             } else {
/*       */               ensureSkinAttrsIsMutable();
/*       */               this.skinAttrs_.addAll(other.skinAttrs_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.skinAttrs_.isEmpty()) {
/*       */           if (this.skinAttrsBuilder_.isEmpty()) {
/*       */             this.skinAttrsBuilder_.dispose();
/*       */             this.skinAttrsBuilder_ = null;
/*       */             this.skinAttrs_ = other.skinAttrs_;
/*       */             this.bitField0_ &= 0xFFFFFEFF;
/*       */             this.skinAttrsBuilder_ = MountHandler.MountInfoData.alwaysUseFieldBuilders ? getSkinAttrsFieldBuilder() : null;
/*       */           } else {
/*       */             this.skinAttrsBuilder_.addAllMessages(other.skinAttrs_);
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasLevel()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasIcon()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasModelFile()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasDesc()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasState()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasFightPowerValue()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getSkinAttrsCount(); i++) {
/*       */           if (!getSkinAttrs(i).isInitialized()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.MountInfoData parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.MountInfoData)MountHandler.MountInfoData.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.MountInfoData)e.getUnfinishedMessage();
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getId() {
/*       */         return this.id_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = MountHandler.MountInfoData.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasLevel() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getLevel() {
/*       */         return this.level_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setLevel(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasIcon() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getIcon() {
/*       */         Object ref = this.icon_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.icon_ = s;
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
/*       */       public ByteString getIconBytes() {
/*       */         Object ref = this.icon_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.icon_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIcon(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.icon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearIcon() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.icon_ = MountHandler.MountInfoData.getDefaultInstance().getIcon();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIconBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.icon_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasModelFile() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getModelFile() {
/*       */         Object ref = this.modelFile_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.modelFile_ = s;
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
/*       */       public ByteString getModelFileBytes() {
/*       */         Object ref = this.modelFile_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.modelFile_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setModelFile(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.modelFile_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearModelFile() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.modelFile_ = MountHandler.MountInfoData.getDefaultInstance().getModelFile();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setModelFileBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.modelFile_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasDesc() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getDesc() {
/*       */         Object ref = this.desc_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.desc_ = s;
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
/*       */       public ByteString getDescBytes() {
/*       */         Object ref = this.desc_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.desc_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDesc(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.desc_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDesc() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.desc_ = MountHandler.MountInfoData.getDefaultInstance().getDesc();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDescBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.desc_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasState() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getState() {
/*       */         return this.state_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setState(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.state_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearState() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.state_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasFightPowerValue() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getFightPowerValue() {
/*       */         return this.fightPowerValue_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setFightPowerValue(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.fightPowerValue_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearFightPowerValue() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.fightPowerValue_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureSkinAttrsIsMutable() {
/*       */         if ((this.bitField0_ & 0x100) != 256) {
/*       */           this.skinAttrs_ = new ArrayList<>(this.skinAttrs_);
/*       */           this.bitField0_ |= 0x100;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.AttributeBase> getSkinAttrsList() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.skinAttrs_);
/*       */         }
/*       */         return this.skinAttrsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getSkinAttrsCount() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return this.skinAttrs_.size();
/*       */         }
/*       */         return this.skinAttrsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase getSkinAttrs(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return this.skinAttrs_.get(index);
/*       */         }
/*       */         return (Common.AttributeBase)this.skinAttrsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkinAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setSkinAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addSkinAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllSkinAttrs(Iterable<? extends Common.AttributeBase> values) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.skinAttrs_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearSkinAttrs() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFEFF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeSkinAttrs(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           ensureSkinAttrsIsMutable();
/*       */           this.skinAttrs_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.skinAttrsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder getSkinAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int index) {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           return (Common.AttributeBaseOrBuilder)this.skinAttrs_.get(index);
/*       */         }
/*       */         return (Common.AttributeBaseOrBuilder)this.skinAttrsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList() {
/*       */         if (this.skinAttrsBuilder_ != null) {
/*       */           return this.skinAttrsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return (List)Collections.unmodifiableList(this.skinAttrs_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder addSkinAttrsBuilder() {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().addBuilder((GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.AttributeBase.Builder addSkinAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getSkinAttrsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.AttributeBase.Builder> getSkinAttrsBuilderList() {
/*       */         return getSkinAttrsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getSkinAttrsFieldBuilder() {
/*       */         if (this.skinAttrsBuilder_ == null) {
/*       */           this.skinAttrsBuilder_ = new RepeatedFieldBuilder(this.skinAttrs_, ((this.bitField0_ & 0x100) == 256), getParentForChildren(), isClean());
/*       */           this.skinAttrs_ = null;
/*       */         } 
/*       */         return this.skinAttrsBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class MountData
/*       */     extends GeneratedMessage
/*       */     implements MountDataOrBuilder
/*       */   {
/*  8673 */     private static final MountData defaultInstance = new MountData(true); private final UnknownFieldSet unknownFields; private MountData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MountData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MountData getDefaultInstance() { return defaultInstance; } public MountData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MountData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int length, limit, tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.rideLevel_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.starLv_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x4; this.fightPowerValue_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x8; this.usingSkinID_ = input.readInt32(); break;case 64: if ((mutable_bitField0_ & 0x10) != 16) { this.mountSkins_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.mountSkins_.add(Integer.valueOf(input.readInt32())); break;case 66: length = input.readRawVarint32(); limit = input.pushLimit(length); if ((mutable_bitField0_ & 0x10) != 16 && input.getBytesUntilLimit() > 0) { this.mountSkins_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  while (input.getBytesUntilLimit() > 0) this.mountSkins_.add(Integer.valueOf(input.readInt32()));  input.popLimit(limit); break;case 106: if ((mutable_bitField0_ & 0x20) != 32) { this.mountAttrs_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.mountAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry)); break;case 114: if ((mutable_bitField0_ & 0x40) != 64) { this.mountAttrsNext_ = new ArrayList<>(); mutable_bitField0_ |= 0x40; }  this.mountAttrsNext_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.mountSkins_ = Collections.unmodifiableList(this.mountSkins_);  if ((mutable_bitField0_ & 0x20) == 32) this.mountAttrs_ = Collections.unmodifiableList(this.mountAttrs_);  if ((mutable_bitField0_ & 0x40) == 64) this.mountAttrsNext_ = Collections.unmodifiableList(this.mountAttrsNext_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountData.class, Builder.class); } public static Parser<MountData> PARSER = (Parser<MountData>)new AbstractParser<MountData>() { public MountHandler.MountData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.MountData(input, extensionRegistry); } }
/*  8674 */     ; private int bitField0_; public static final int RIDELEVEL_FIELD_NUMBER = 1; private int rideLevel_; public static final int STARLV_FIELD_NUMBER = 2; private int starLv_; public static final int FIGHTPOWERVALUE_FIELD_NUMBER = 4; private int fightPowerValue_; public static final int USINGSKINID_FIELD_NUMBER = 7; private int usingSkinID_; public static final int MOUNTSKINS_FIELD_NUMBER = 8; private List<Integer> mountSkins_; public static final int MOUNTATTRS_FIELD_NUMBER = 13; private List<Common.AttributeBase> mountAttrs_; public static final int MOUNTATTRSNEXT_FIELD_NUMBER = 14; private List<Common.AttributeBase> mountAttrsNext_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MountData> getParserForType() { return PARSER; } public boolean hasRideLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getRideLevel() { return this.rideLevel_; } public boolean hasStarLv() { return ((this.bitField0_ & 0x2) == 2); } public int getStarLv() { return this.starLv_; } public boolean hasFightPowerValue() { return ((this.bitField0_ & 0x4) == 4); } public int getFightPowerValue() { return this.fightPowerValue_; } public boolean hasUsingSkinID() { return ((this.bitField0_ & 0x8) == 8); } public int getUsingSkinID() { return this.usingSkinID_; } public List<Integer> getMountSkinsList() { return this.mountSkins_; } public int getMountSkinsCount() { return this.mountSkins_.size(); } public int getMountSkins(int index) { return ((Integer)this.mountSkins_.get(index)).intValue(); } public List<Common.AttributeBase> getMountAttrsList() { return this.mountAttrs_; } public List<? extends Common.AttributeBaseOrBuilder> getMountAttrsOrBuilderList() { return (List)this.mountAttrs_; } public int getMountAttrsCount() { return this.mountAttrs_.size(); } public Common.AttributeBase getMountAttrs(int index) { return this.mountAttrs_.get(index); } public Common.AttributeBaseOrBuilder getMountAttrsOrBuilder(int index) { return (Common.AttributeBaseOrBuilder)this.mountAttrs_.get(index); } public List<Common.AttributeBase> getMountAttrsNextList() { return this.mountAttrsNext_; } public List<? extends Common.AttributeBaseOrBuilder> getMountAttrsNextOrBuilderList() { return (List)this.mountAttrsNext_; } public int getMountAttrsNextCount() { return this.mountAttrsNext_.size(); } public Common.AttributeBase getMountAttrsNext(int index) { return this.mountAttrsNext_.get(index); } public Common.AttributeBaseOrBuilder getMountAttrsNextOrBuilder(int index) { return (Common.AttributeBaseOrBuilder)this.mountAttrsNext_.get(index); } private void initFields() { this.rideLevel_ = 0; this.starLv_ = 0; this.fightPowerValue_ = 0; this.usingSkinID_ = 0; this.mountSkins_ = Collections.emptyList(); this.mountAttrs_ = Collections.emptyList(); this.mountAttrsNext_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasRideLevel()) { this.memoizedIsInitialized = 0; return false; }  if (!hasStarLv()) { this.memoizedIsInitialized = 0; return false; }  if (!hasFightPowerValue()) { this.memoizedIsInitialized = 0; return false; }  if (!hasUsingSkinID()) { this.memoizedIsInitialized = 0; return false; }  int i; for (i = 0; i < getMountAttrsCount(); i++) { if (!getMountAttrs(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  for (i = 0; i < getMountAttrsNextCount(); i++) { if (!getMountAttrsNext(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.rideLevel_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.starLv_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(4, this.fightPowerValue_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(7, this.usingSkinID_);  int i; for (i = 0; i < this.mountSkins_.size(); i++) output.writeInt32(8, ((Integer)this.mountSkins_.get(i)).intValue());  for (i = 0; i < this.mountAttrs_.size(); i++) output.writeMessage(13, (MessageLite)this.mountAttrs_.get(i));  for (i = 0; i < this.mountAttrsNext_.size(); i++) output.writeMessage(14, (MessageLite)this.mountAttrsNext_.get(i));  getUnknownFields().writeTo(output); } static { defaultInstance.initFields(); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.rideLevel_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeInt32Size(2, this.starLv_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.fightPowerValue_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(7, this.usingSkinID_); 
/*       */       int dataSize = 0;
/*       */       for (int j = 0; j < this.mountSkins_.size(); j++)
/*       */         dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.mountSkins_.get(j)).intValue()); 
/*       */       size += dataSize;
/*       */       size += 1 * getMountSkinsList().size();
/*       */       int i;
/*       */       for (i = 0; i < this.mountAttrs_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(13, (MessageLite)this.mountAttrs_.get(i)); 
/*       */       for (i = 0; i < this.mountAttrsNext_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(14, (MessageLite)this.mountAttrsNext_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static MountData parseFrom(ByteString data) throws InvalidProtocolBufferException { return (MountData)PARSER.parseFrom(data); }
/*       */     public static MountData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountData)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static MountData parseFrom(byte[] data) throws InvalidProtocolBufferException { return (MountData)PARSER.parseFrom(data); }
/*       */     public static MountData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountData)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static MountData parseFrom(InputStream input) throws IOException { return (MountData)PARSER.parseFrom(input); }
/*       */     public static MountData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountData)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static MountData parseDelimitedFrom(InputStream input) throws IOException { return (MountData)PARSER.parseDelimitedFrom(input); }
/*       */     public static MountData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountData)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static MountData parseFrom(CodedInputStream input) throws IOException { return (MountData)PARSER.parseFrom(input); }
/*       */     public static MountData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountData)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(MountData prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.MountDataOrBuilder {
/*       */       private int bitField0_;
/*       */       private int rideLevel_;
/*       */       private int starLv_;
/*       */       private int fightPowerValue_;
/*       */       private int usingSkinID_;
/*       */       private List<Integer> mountSkins_;
/*       */       private List<Common.AttributeBase> mountAttrs_;
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> mountAttrsBuilder_;
/*       */       private List<Common.AttributeBase> mountAttrsNext_;
/*       */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> mountAttrsNextBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountData_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountData_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.MountData.class, Builder.class); }
/*       */       private Builder() { this.mountSkins_ = Collections.emptyList();
/*       */         this.mountAttrs_ = Collections.emptyList();
/*       */         this.mountAttrsNext_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.mountSkins_ = Collections.emptyList();
/*       */         this.mountAttrs_ = Collections.emptyList();
/*       */         this.mountAttrsNext_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (MountHandler.MountData.alwaysUseFieldBuilders) {
/*       */           getMountAttrsFieldBuilder();
/*       */           getMountAttrsNextFieldBuilder();
/*       */         }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.rideLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.starLv_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.fightPowerValue_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.usingSkinID_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.mountSkins_ = Collections.emptyList();
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           this.mountAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */         } else {
/*       */           this.mountAttrsBuilder_.clear();
/*       */         } 
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           this.mountAttrsNext_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_MountData_descriptor; }
/*       */       public MountHandler.MountData getDefaultInstanceForType() { return MountHandler.MountData.getDefaultInstance(); }
/*       */       public MountHandler.MountData build() { MountHandler.MountData result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; } public MountHandler.MountData buildPartial() { MountHandler.MountData result = new MountHandler.MountData(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.rideLevel_ = this.rideLevel_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.starLv_ = this.starLv_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.fightPowerValue_ = this.fightPowerValue_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.usingSkinID_ = this.usingSkinID_;
/*       */         if ((this.bitField0_ & 0x10) == 16) {
/*       */           this.mountSkins_ = Collections.unmodifiableList(this.mountSkins_);
/*       */           this.bitField0_ &= 0xFFFFFFEF;
/*       */         } 
/*       */         result.mountSkins_ = this.mountSkins_;
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x20) == 32) {
/*       */             this.mountAttrs_ = Collections.unmodifiableList(this.mountAttrs_);
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */           } 
/*       */           result.mountAttrs_ = this.mountAttrs_;
/*       */         } else {
/*       */           result.mountAttrs_ = this.mountAttrsBuilder_.build();
/*       */         } 
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x40) == 64) {
/*       */             this.mountAttrsNext_ = Collections.unmodifiableList(this.mountAttrsNext_);
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */           } 
/*       */           result.mountAttrsNext_ = this.mountAttrsNext_;
/*       */         } else {
/*       */           result.mountAttrsNext_ = this.mountAttrsNextBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.MountData)
/*       */           return mergeFrom((MountHandler.MountData)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; } public Builder mergeFrom(MountHandler.MountData other) { if (other == MountHandler.MountData.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasRideLevel())
/*       */           setRideLevel(other.getRideLevel()); 
/*       */         if (other.hasStarLv())
/*       */           setStarLv(other.getStarLv()); 
/*       */         if (other.hasFightPowerValue())
/*       */           setFightPowerValue(other.getFightPowerValue()); 
/*       */         if (other.hasUsingSkinID())
/*       */           setUsingSkinID(other.getUsingSkinID()); 
/*       */         if (!other.mountSkins_.isEmpty()) {
/*       */           if (this.mountSkins_.isEmpty()) {
/*       */             this.mountSkins_ = other.mountSkins_;
/*       */             this.bitField0_ &= 0xFFFFFFEF;
/*       */           } else {
/*       */             ensureMountSkinsIsMutable();
/*       */             this.mountSkins_.addAll(other.mountSkins_);
/*       */           } 
/*       */           onChanged();
/*       */         } 
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           if (!other.mountAttrs_.isEmpty()) {
/*       */             if (this.mountAttrs_.isEmpty()) {
/*       */               this.mountAttrs_ = other.mountAttrs_;
/*       */               this.bitField0_ &= 0xFFFFFFDF;
/*       */             } else {
/*       */               ensureMountAttrsIsMutable();
/*       */               this.mountAttrs_.addAll(other.mountAttrs_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.mountAttrs_.isEmpty()) {
/*       */           if (this.mountAttrsBuilder_.isEmpty()) {
/*       */             this.mountAttrsBuilder_.dispose();
/*       */             this.mountAttrsBuilder_ = null;
/*       */             this.mountAttrs_ = other.mountAttrs_;
/*       */             this.bitField0_ &= 0xFFFFFFDF;
/*       */             this.mountAttrsBuilder_ = MountHandler.MountData.alwaysUseFieldBuilders ? getMountAttrsFieldBuilder() : null;
/*       */           } else {
/*       */             this.mountAttrsBuilder_.addAllMessages(other.mountAttrs_);
/*       */           } 
/*       */         } 
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           if (!other.mountAttrsNext_.isEmpty()) {
/*       */             if (this.mountAttrsNext_.isEmpty()) {
/*       */               this.mountAttrsNext_ = other.mountAttrsNext_;
/*       */               this.bitField0_ &= 0xFFFFFFBF;
/*       */             } else {
/*       */               ensureMountAttrsNextIsMutable();
/*       */               this.mountAttrsNext_.addAll(other.mountAttrsNext_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.mountAttrsNext_.isEmpty()) {
/*       */           if (this.mountAttrsNextBuilder_.isEmpty()) {
/*       */             this.mountAttrsNextBuilder_.dispose();
/*       */             this.mountAttrsNextBuilder_ = null;
/*       */             this.mountAttrsNext_ = other.mountAttrsNext_;
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */             this.mountAttrsNextBuilder_ = MountHandler.MountData.alwaysUseFieldBuilders ? getMountAttrsNextFieldBuilder() : null;
/*       */           } else {
/*       */             this.mountAttrsNextBuilder_.addAllMessages(other.mountAttrsNext_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; } public final boolean isInitialized() { if (!hasRideLevel())
/*       */           return false; 
/*       */         if (!hasStarLv())
/*       */           return false; 
/*       */         if (!hasFightPowerValue())
/*       */           return false; 
/*       */         if (!hasUsingSkinID())
/*       */           return false; 
/*       */         int i;
/*       */         for (i = 0; i < getMountAttrsCount(); i++) {
/*       */           if (!getMountAttrs(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         for (i = 0; i < getMountAttrsNextCount(); i++) {
/*       */           if (!getMountAttrsNext(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.MountData parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.MountData)MountHandler.MountData.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.MountData)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; } public boolean hasRideLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getRideLevel() { return this.rideLevel_; } public Builder setRideLevel(int value) { this.bitField0_ |= 0x1;
/*       */         this.rideLevel_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearRideLevel() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.rideLevel_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasStarLv() { return ((this.bitField0_ & 0x2) == 2); } public int getStarLv() { return this.starLv_; } public Builder setStarLv(int value) { this.bitField0_ |= 0x2;
/*       */         this.starLv_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearStarLv() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.starLv_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasFightPowerValue() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       } public int getFightPowerValue() {
/*       */         return this.fightPowerValue_;
/*       */       } public Builder setFightPowerValue(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.fightPowerValue_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearFightPowerValue() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.fightPowerValue_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasUsingSkinID() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       } public int getUsingSkinID() {
/*       */         return this.usingSkinID_;
/*       */       } public Builder setUsingSkinID(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.usingSkinID_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearUsingSkinID() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.usingSkinID_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } private void ensureMountSkinsIsMutable() {
/*       */         if ((this.bitField0_ & 0x10) != 16) {
/*       */           this.mountSkins_ = new ArrayList<>(this.mountSkins_);
/*       */           this.bitField0_ |= 0x10;
/*       */         } 
/*       */       } public List<Integer> getMountSkinsList() {
/*       */         return Collections.unmodifiableList(this.mountSkins_);
/*       */       } public int getMountSkinsCount() {
/*       */         return this.mountSkins_.size();
/*       */       } public int getMountSkins(int index) {
/*       */         return ((Integer)this.mountSkins_.get(index)).intValue();
/*       */       } public Builder setMountSkins(int index, int value) {
/*       */         ensureMountSkinsIsMutable();
/*       */         this.mountSkins_.set(index, Integer.valueOf(value));
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder addMountSkins(int value) {
/*       */         ensureMountSkinsIsMutable();
/*       */         this.mountSkins_.add(Integer.valueOf(value));
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder addAllMountSkins(Iterable<? extends Integer> values) {
/*       */         ensureMountSkinsIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, this.mountSkins_);
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearMountSkins() {
/*       */         this.mountSkins_ = Collections.emptyList();
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         onChanged();
/*       */         return this;
/*       */       } private void ensureMountAttrsIsMutable() {
/*       */         if ((this.bitField0_ & 0x20) != 32) {
/*       */           this.mountAttrs_ = new ArrayList<>(this.mountAttrs_);
/*       */           this.bitField0_ |= 0x20;
/*       */         } 
/*       */       } public List<Common.AttributeBase> getMountAttrsList() {
/*       */         if (this.mountAttrsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.mountAttrs_); 
/*       */         return this.mountAttrsBuilder_.getMessageList();
/*       */       } public int getMountAttrsCount() {
/*       */         if (this.mountAttrsBuilder_ == null)
/*       */           return this.mountAttrs_.size(); 
/*       */         return this.mountAttrsBuilder_.getCount();
/*       */       } public Common.AttributeBase getMountAttrs(int index) {
/*       */         if (this.mountAttrsBuilder_ == null)
/*       */           return this.mountAttrs_.get(index); 
/*       */         return (Common.AttributeBase)this.mountAttrsBuilder_.getMessage(index);
/*       */       } public Builder setMountAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder setMountAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrs(Common.AttributeBase value) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrs(int index, Common.AttributeBase value) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrs(Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrs(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addAllMountAttrs(Iterable<? extends Common.AttributeBase> values) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           ensureMountAttrsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.mountAttrs_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       } public Builder clearMountAttrs() {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           this.mountAttrs_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFDF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder removeMountAttrs(int index) {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           ensureMountAttrsIsMutable();
/*       */           this.mountAttrs_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       } public Common.AttributeBase.Builder getMountAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsFieldBuilder().getBuilder(index);
/*       */       } public Common.AttributeBaseOrBuilder getMountAttrsOrBuilder(int index) {
/*       */         if (this.mountAttrsBuilder_ == null)
/*       */           return (Common.AttributeBaseOrBuilder)this.mountAttrs_.get(index); 
/*       */         return (Common.AttributeBaseOrBuilder)this.mountAttrsBuilder_.getMessageOrBuilder(index);
/*       */       } public List<? extends Common.AttributeBaseOrBuilder> getMountAttrsOrBuilderList() {
/*       */         if (this.mountAttrsBuilder_ != null)
/*       */           return this.mountAttrsBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.mountAttrs_);
/*       */       } public Common.AttributeBase.Builder addMountAttrsBuilder() {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsFieldBuilder().addBuilder((GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       } public Common.AttributeBase.Builder addMountAttrsBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       } public List<Common.AttributeBase.Builder> getMountAttrsBuilderList() {
/*       */         return getMountAttrsFieldBuilder().getBuilderList();
/*       */       } private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getMountAttrsFieldBuilder() {
/*       */         if (this.mountAttrsBuilder_ == null) {
/*       */           this.mountAttrsBuilder_ = new RepeatedFieldBuilder(this.mountAttrs_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
/*       */           this.mountAttrs_ = null;
/*       */         } 
/*       */         return this.mountAttrsBuilder_;
/*       */       } private void ensureMountAttrsNextIsMutable() {
/*       */         if ((this.bitField0_ & 0x40) != 64) {
/*       */           this.mountAttrsNext_ = new ArrayList<>(this.mountAttrsNext_);
/*       */           this.bitField0_ |= 0x40;
/*       */         } 
/*       */       } public List<Common.AttributeBase> getMountAttrsNextList() {
/*       */         if (this.mountAttrsNextBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.mountAttrsNext_); 
/*       */         return this.mountAttrsNextBuilder_.getMessageList();
/*       */       } public int getMountAttrsNextCount() {
/*       */         if (this.mountAttrsNextBuilder_ == null)
/*       */           return this.mountAttrsNext_.size(); 
/*       */         return this.mountAttrsNextBuilder_.getCount();
/*       */       } public Common.AttributeBase getMountAttrsNext(int index) {
/*       */         if (this.mountAttrsNextBuilder_ == null)
/*       */           return this.mountAttrsNext_.get(index); 
/*       */         return (Common.AttributeBase)this.mountAttrsNextBuilder_.getMessage(index);
/*       */       } public Builder setMountAttrsNext(int index, Common.AttributeBase value) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder setMountAttrsNext(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrsNext(Common.AttributeBase value) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrsNext(int index, Common.AttributeBase value) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrsNext(Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addMountAttrsNext(int index, Common.AttributeBase.Builder builderForValue) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addAllMountAttrsNext(Iterable<? extends Common.AttributeBase> values) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           ensureMountAttrsNextIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.mountAttrsNext_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       } public Builder clearMountAttrsNext() {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           this.mountAttrsNext_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder removeMountAttrsNext(int index) {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           ensureMountAttrsNextIsMutable();
/*       */           this.mountAttrsNext_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.mountAttrsNextBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       } public Common.AttributeBase.Builder getMountAttrsNextBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsNextFieldBuilder().getBuilder(index);
/*       */       } public Common.AttributeBaseOrBuilder getMountAttrsNextOrBuilder(int index) {
/*       */         if (this.mountAttrsNextBuilder_ == null)
/*       */           return (Common.AttributeBaseOrBuilder)this.mountAttrsNext_.get(index); 
/*       */         return (Common.AttributeBaseOrBuilder)this.mountAttrsNextBuilder_.getMessageOrBuilder(index);
/*       */       } public List<? extends Common.AttributeBaseOrBuilder> getMountAttrsNextOrBuilderList() {
/*       */         if (this.mountAttrsNextBuilder_ != null)
/*       */           return this.mountAttrsNextBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.mountAttrsNext_);
/*       */       } public Common.AttributeBase.Builder addMountAttrsNextBuilder() {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsNextFieldBuilder().addBuilder((GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       } public Common.AttributeBase.Builder addMountAttrsNextBuilder(int index) {
/*       */         return (Common.AttributeBase.Builder)getMountAttrsNextFieldBuilder().addBuilder(index, (GeneratedMessage)Common.AttributeBase.getDefaultInstance());
/*       */       } public List<Common.AttributeBase.Builder> getMountAttrsNextBuilderList() {
/*       */         return getMountAttrsNextFieldBuilder().getBuilderList();
/*       */       } private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getMountAttrsNextFieldBuilder() {
/*       */         if (this.mountAttrsNextBuilder_ == null) {
/*       */           this.mountAttrsNextBuilder_ = new RepeatedFieldBuilder(this.mountAttrsNext_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
/*       */           this.mountAttrsNext_ = null;
/*       */         } 
/*       */         return this.mountAttrsNextBuilder_;
/*       */       }
/*       */     }
/*       */   } public static final class ActiveMountSkinResponse extends GeneratedMessage implements ActiveMountSkinResponseOrBuilder {
/*  9235 */     private static final ActiveMountSkinResponse defaultInstance = new ActiveMountSkinResponse(true); private final UnknownFieldSet unknownFields; private ActiveMountSkinResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ActiveMountSkinResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ActiveMountSkinResponse getDefaultInstance() { return defaultInstance; } public ActiveMountSkinResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ActiveMountSkinResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ActiveMountSkinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActiveMountSkinResponse.class, Builder.class); } public static Parser<ActiveMountSkinResponse> PARSER = (Parser<ActiveMountSkinResponse>)new AbstractParser<ActiveMountSkinResponse>() { public MountHandler.ActiveMountSkinResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.ActiveMountSkinResponse(input, extensionRegistry); } }
/*  9236 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ActiveMountSkinResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
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
/*       */     public static ActiveMountSkinResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(data);
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
/*       */     public static ActiveMountSkinResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static ActiveMountSkinResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(data);
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
/*       */     public static ActiveMountSkinResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static ActiveMountSkinResponse parseFrom(InputStream input) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(input);
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
/*       */     public static ActiveMountSkinResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static ActiveMountSkinResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static ActiveMountSkinResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static ActiveMountSkinResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(input);
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
/*       */     public static ActiveMountSkinResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ActiveMountSkinResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(ActiveMountSkinResponse prototype) {
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
/*       */       implements MountHandler.ActiveMountSkinResponseOrBuilder
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
/*       */         return MountHandler.internal_static_pomelo_area_ActiveMountSkinResponse_descriptor;
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
/*       */         return MountHandler.internal_static_pomelo_area_ActiveMountSkinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.ActiveMountSkinResponse.class, Builder.class);
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
/*       */         if (MountHandler.ActiveMountSkinResponse.alwaysUseFieldBuilders);
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
/*       */         return MountHandler.internal_static_pomelo_area_ActiveMountSkinResponse_descriptor;
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
/*       */       public MountHandler.ActiveMountSkinResponse getDefaultInstanceForType() {
/*       */         return MountHandler.ActiveMountSkinResponse.getDefaultInstance();
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
/*       */       public MountHandler.ActiveMountSkinResponse build() {
/*       */         MountHandler.ActiveMountSkinResponse result = buildPartial();
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
/*       */       public MountHandler.ActiveMountSkinResponse buildPartial() {
/*       */         MountHandler.ActiveMountSkinResponse result = new MountHandler.ActiveMountSkinResponse(this);
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
/*       */         if (other instanceof MountHandler.ActiveMountSkinResponse) {
/*       */           return mergeFrom((MountHandler.ActiveMountSkinResponse)other);
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
/*       */       public Builder mergeFrom(MountHandler.ActiveMountSkinResponse other) {
/*       */         if (other == MountHandler.ActiveMountSkinResponse.getDefaultInstance()) {
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
/*       */         MountHandler.ActiveMountSkinResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.ActiveMountSkinResponse)MountHandler.ActiveMountSkinResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.ActiveMountSkinResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = MountHandler.ActiveMountSkinResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class SaveMountResponse
/*       */     extends GeneratedMessage
/*       */     implements SaveMountResponseOrBuilder
/*       */   {
/*  9998 */     private static final SaveMountResponse defaultInstance = new SaveMountResponse(true); private final UnknownFieldSet unknownFields; private SaveMountResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SaveMountResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SaveMountResponse getDefaultInstance() { return defaultInstance; } public SaveMountResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SaveMountResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; MountHandler.MountData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (MountHandler.MountData)input.readMessage(MountHandler.MountData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_SaveMountResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_SaveMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveMountResponse.class, Builder.class); } public static Parser<SaveMountResponse> PARSER = (Parser<SaveMountResponse>)new AbstractParser<SaveMountResponse>() { public MountHandler.SaveMountResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.SaveMountResponse(input, extensionRegistry); } }
/*  9999 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private MountHandler.MountData s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SaveMountResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CData() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountData getS2CData() {
/*       */       return this.s2CData_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */       return this.s2CData_;
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
/*       */       this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */       if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_);
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
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_);
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
/*       */     public static SaveMountResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(InputStream input) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SaveMountResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SaveMountResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(SaveMountResponse prototype) {
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
/*       */       implements MountHandler.SaveMountResponseOrBuilder
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
/*       */       private MountHandler.MountData s2CData_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> s2CDataBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_SaveMountResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_SaveMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.SaveMountResponse.class, Builder.class);
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
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */         if (MountHandler.SaveMountResponse.alwaysUseFieldBuilders) {
/*       */           getS2CDataFieldBuilder();
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
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
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
/*       */         return MountHandler.internal_static_pomelo_area_SaveMountResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.SaveMountResponse getDefaultInstanceForType() {
/*       */         return MountHandler.SaveMountResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.SaveMountResponse build() {
/*       */         MountHandler.SaveMountResponse result = buildPartial();
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
/*       */       public MountHandler.SaveMountResponse buildPartial() {
/*       */         MountHandler.SaveMountResponse result = new MountHandler.SaveMountResponse(this);
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
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = (MountHandler.MountData)this.s2CDataBuilder_.build();
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
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.SaveMountResponse) {
/*       */           return mergeFrom((MountHandler.SaveMountResponse)other);
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
/*       */       public Builder mergeFrom(MountHandler.SaveMountResponse other) {
/*       */         if (other == MountHandler.SaveMountResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CData()) {
/*       */           mergeS2CData(other.getS2CData());
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
/*       */         if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */         MountHandler.SaveMountResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.SaveMountResponse)MountHandler.SaveMountResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.SaveMountResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = MountHandler.SaveMountResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasS2CData() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData getS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           return this.s2CData_;
/*       */         }
/*       */         return (MountHandler.MountData)this.s2CDataBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CData_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MountHandler.MountData.getDefaultInstance()) {
/*       */             this.s2CData_ = MountHandler.MountData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CData_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData.Builder getS2CDataBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (MountHandler.MountData.Builder)getS2CDataFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */         if (this.s2CDataBuilder_ != null) {
/*       */           return (MountHandler.MountDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.s2CData_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class UpMountStageResponse
/*       */     extends GeneratedMessage
/*       */     implements UpMountStageResponseOrBuilder
/*       */   {
/* 10839 */     private static final UpMountStageResponse defaultInstance = new UpMountStageResponse(true); private final UnknownFieldSet unknownFields; private UpMountStageResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpMountStageResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpMountStageResponse getDefaultInstance() { return defaultInstance; } public UpMountStageResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpMountStageResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; MountHandler.MountData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (MountHandler.MountData)input.readMessage(MountHandler.MountData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break;case 32: this.bitField0_ |= 0x8; this.s2CCurLuckyValue_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_UpMountStageResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_UpMountStageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpMountStageResponse.class, Builder.class); } public static Parser<UpMountStageResponse> PARSER = (Parser<UpMountStageResponse>)new AbstractParser<UpMountStageResponse>() { public MountHandler.UpMountStageResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.UpMountStageResponse(input, extensionRegistry); } }
/* 10840 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private MountHandler.MountData s2CData_; public static final int S2C_CURLUCKYVALUE_FIELD_NUMBER = 4; private int s2CCurLuckyValue_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpMountStageResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CData() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountData getS2CData() {
/*       */       return this.s2CData_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */       return this.s2CData_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasS2CCurLuckyValue() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getS2CCurLuckyValue() {
/*       */       return this.s2CCurLuckyValue_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */       this.s2CCurLuckyValue_ = 0;
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
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.s2CCurLuckyValue_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.s2CCurLuckyValue_);
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
/*       */     public static UpMountStageResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static UpMountStageResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpMountStageResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(UpMountStageResponse prototype) {
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
/*       */       implements MountHandler.UpMountStageResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private MountHandler.MountData s2CData_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> s2CDataBuilder_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCurLuckyValue_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_UpMountStageResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_UpMountStageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.UpMountStageResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.UpMountStageResponse.alwaysUseFieldBuilders) {
/*       */           getS2CDataFieldBuilder();
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
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.s2CCurLuckyValue_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
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
/*       */         return MountHandler.internal_static_pomelo_area_UpMountStageResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.UpMountStageResponse getDefaultInstanceForType() {
/*       */         return MountHandler.UpMountStageResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.UpMountStageResponse build() {
/*       */         MountHandler.UpMountStageResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.UpMountStageResponse buildPartial() {
/*       */         MountHandler.UpMountStageResponse result = new MountHandler.UpMountStageResponse(this);
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
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = (MountHandler.MountData)this.s2CDataBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.s2CCurLuckyValue_ = this.s2CCurLuckyValue_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.UpMountStageResponse) {
/*       */           return mergeFrom((MountHandler.UpMountStageResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(MountHandler.UpMountStageResponse other) {
/*       */         if (other == MountHandler.UpMountStageResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CData()) {
/*       */           mergeS2CData(other.getS2CData());
/*       */         }
/*       */         if (other.hasS2CCurLuckyValue()) {
/*       */           setS2CCurLuckyValue(other.getS2CCurLuckyValue());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (hasS2CData() && !getS2CData().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.UpMountStageResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.UpMountStageResponse)MountHandler.UpMountStageResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.UpMountStageResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = MountHandler.UpMountStageResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasS2CData() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData getS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           return this.s2CData_;
/*       */         }
/*       */         return (MountHandler.MountData)this.s2CDataBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CData_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MountHandler.MountData.getDefaultInstance()) {
/*       */             this.s2CData_ = MountHandler.MountData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CData_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData.Builder getS2CDataBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (MountHandler.MountData.Builder)getS2CDataFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */         if (this.s2CDataBuilder_ != null) {
/*       */           return (MountHandler.MountDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.s2CData_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CCurLuckyValue() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCurLuckyValue() {
/*       */         return this.s2CCurLuckyValue_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCurLuckyValue(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.s2CCurLuckyValue_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCurLuckyValue() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.s2CCurLuckyValue_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class GetMountInfoResponse
/*       */     extends GeneratedMessage
/*       */     implements GetMountInfoResponseOrBuilder
/*       */   {
/* 11602 */     private static final GetMountInfoResponse defaultInstance = new GetMountInfoResponse(true); private final UnknownFieldSet unknownFields; private GetMountInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetMountInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetMountInfoResponse getDefaultInstance() { return defaultInstance; } public GetMountInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetMountInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; MountHandler.MountData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (MountHandler.MountData)input.readMessage(MountHandler.MountData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_GetMountInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_GetMountInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMountInfoResponse.class, Builder.class); } public static Parser<GetMountInfoResponse> PARSER = (Parser<GetMountInfoResponse>)new AbstractParser<GetMountInfoResponse>() { public MountHandler.GetMountInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.GetMountInfoResponse(input, extensionRegistry); } }
/* 11603 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private MountHandler.MountData s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetMountInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CData() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountData getS2CData() {
/*       */       return this.s2CData_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */       return this.s2CData_;
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
/*       */       this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */       if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_);
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
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_);
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
/*       */     public static GetMountInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(InputStream input) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static GetMountInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (GetMountInfoResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(GetMountInfoResponse prototype) {
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
/*       */       implements MountHandler.GetMountInfoResponseOrBuilder
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
/*       */       private MountHandler.MountData s2CData_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> s2CDataBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_GetMountInfoResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_GetMountInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.GetMountInfoResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.GetMountInfoResponse.alwaysUseFieldBuilders) {
/*       */           getS2CDataFieldBuilder();
/*       */         }
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
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
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
/*       */         return MountHandler.internal_static_pomelo_area_GetMountInfoResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.GetMountInfoResponse getDefaultInstanceForType() {
/*       */         return MountHandler.GetMountInfoResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.GetMountInfoResponse build() {
/*       */         MountHandler.GetMountInfoResponse result = buildPartial();
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
/*       */       public MountHandler.GetMountInfoResponse buildPartial() {
/*       */         MountHandler.GetMountInfoResponse result = new MountHandler.GetMountInfoResponse(this);
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
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = (MountHandler.MountData)this.s2CDataBuilder_.build();
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.GetMountInfoResponse) {
/*       */           return mergeFrom((MountHandler.GetMountInfoResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(MountHandler.GetMountInfoResponse other) {
/*       */         if (other == MountHandler.GetMountInfoResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CData()) {
/*       */           mergeS2CData(other.getS2CData());
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
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */         MountHandler.GetMountInfoResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.GetMountInfoResponse)MountHandler.GetMountInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.GetMountInfoResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = MountHandler.GetMountInfoResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasS2CData() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData getS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           return this.s2CData_;
/*       */         }
/*       */         return (MountHandler.MountData)this.s2CDataBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CData_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MountHandler.MountData.getDefaultInstance()) {
/*       */             this.s2CData_ = MountHandler.MountData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CData_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountData.Builder getS2CDataBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (MountHandler.MountData.Builder)getS2CDataFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */         if (this.s2CDataBuilder_ != null) {
/*       */           return (MountHandler.MountDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.s2CData_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class TrainingMountResponse
/*       */     extends GeneratedMessage
/*       */     implements TrainingMountResponseOrBuilder
/*       */   {
/* 12365 */     private static final TrainingMountResponse defaultInstance = new TrainingMountResponse(true); private final UnknownFieldSet unknownFields; private TrainingMountResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TrainingMountResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TrainingMountResponse getDefaultInstance() { return defaultInstance; } public TrainingMountResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TrainingMountResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; MountHandler.MountData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (MountHandler.MountData)input.readMessage(MountHandler.MountData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_TrainingMountResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_TrainingMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TrainingMountResponse.class, Builder.class); } public static Parser<TrainingMountResponse> PARSER = (Parser<TrainingMountResponse>)new AbstractParser<TrainingMountResponse>() { public MountHandler.TrainingMountResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.TrainingMountResponse(input, extensionRegistry); } }
/* 12366 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private MountHandler.MountData s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TrainingMountResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CData() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public MountHandler.MountData getS2CData() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     
/*       */     public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */       if (hasS2CData() && !getS2CData().isInitialized()) {
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
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_);
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
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(InputStream input) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static TrainingMountResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TrainingMountResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TrainingMountResponse prototype) {
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
/*       */       implements MountHandler.TrainingMountResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private MountHandler.MountData s2CData_;
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> s2CDataBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_TrainingMountResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_TrainingMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.TrainingMountResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.TrainingMountResponse.alwaysUseFieldBuilders)
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
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
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
/*       */         return MountHandler.internal_static_pomelo_area_TrainingMountResponse_descriptor;
/*       */       }
/*       */       
/*       */       public MountHandler.TrainingMountResponse getDefaultInstanceForType() {
/*       */         return MountHandler.TrainingMountResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public MountHandler.TrainingMountResponse build() {
/*       */         MountHandler.TrainingMountResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public MountHandler.TrainingMountResponse buildPartial() {
/*       */         MountHandler.TrainingMountResponse result = new MountHandler.TrainingMountResponse(this);
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
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = (MountHandler.MountData)this.s2CDataBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.TrainingMountResponse)
/*       */           return mergeFrom((MountHandler.TrainingMountResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(MountHandler.TrainingMountResponse other) {
/*       */         if (other == MountHandler.TrainingMountResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasS2CData())
/*       */           mergeS2CData(other.getS2CData()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (hasS2CData() && !getS2CData().isInitialized())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.TrainingMountResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.TrainingMountResponse)MountHandler.TrainingMountResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.TrainingMountResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = MountHandler.TrainingMountResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasS2CData() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public MountHandler.MountData getS2CData() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_; 
/*       */         return (MountHandler.MountData)this.s2CDataBuilder_.getMessage();
/*       */       }
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.s2CData_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MountHandler.MountData.getDefaultInstance()) {
/*       */             this.s2CData_ = MountHandler.MountData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CData_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public MountHandler.MountData.Builder getS2CDataBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (MountHandler.MountData.Builder)getS2CDataFieldBuilder().getBuilder();
/*       */       }
/*       */       
/*       */       public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */         if (this.s2CDataBuilder_ != null)
/*       */           return (MountHandler.MountDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(); 
/*       */         return this.s2CData_;
/*       */       }
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class RidingMountResponse
/*       */     extends GeneratedMessage
/*       */     implements RidingMountResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private RidingMountResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private RidingMountResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static RidingMountResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public RidingMountResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private RidingMountResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */       return MountHandler.internal_static_pomelo_area_RidingMountResponse_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return MountHandler.internal_static_pomelo_area_RidingMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RidingMountResponse.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<RidingMountResponse> PARSER = (Parser<RidingMountResponse>)new AbstractParser<RidingMountResponse>()
/*       */       {
/*       */         public MountHandler.RidingMountResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new MountHandler.RidingMountResponse(input, extensionRegistry);
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
/*       */     public Parser<RidingMountResponse> getParserForType() {
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
/* 12927 */     private static final RidingMountResponse defaultInstance = new RidingMountResponse(true); public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RidingMountResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RidingMountResponse)PARSER.parseFrom(data); } public static RidingMountResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RidingMountResponse)PARSER.parseFrom(data, extensionRegistry); } public static RidingMountResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RidingMountResponse)PARSER.parseFrom(data); } public static RidingMountResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RidingMountResponse)PARSER.parseFrom(data, extensionRegistry); } public static RidingMountResponse parseFrom(InputStream input) throws IOException { return (RidingMountResponse)PARSER.parseFrom(input); } public static RidingMountResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountResponse)PARSER.parseFrom(input, extensionRegistry); } public static RidingMountResponse parseDelimitedFrom(InputStream input) throws IOException { return (RidingMountResponse)PARSER.parseDelimitedFrom(input); } public static RidingMountResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RidingMountResponse parseFrom(CodedInputStream input) throws IOException { return (RidingMountResponse)PARSER.parseFrom(input); } public static RidingMountResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RidingMountResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RidingMountResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.RidingMountResponseOrBuilder {
/* 12928 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_RidingMountResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_RidingMountResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.RidingMountResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.RidingMountResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_RidingMountResponse_descriptor; } public MountHandler.RidingMountResponse getDefaultInstanceForType() { return MountHandler.RidingMountResponse.getDefaultInstance(); } public MountHandler.RidingMountResponse build() { MountHandler.RidingMountResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.RidingMountResponse buildPartial() { MountHandler.RidingMountResponse result = new MountHandler.RidingMountResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.RidingMountResponse) return mergeFrom((MountHandler.RidingMountResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.RidingMountResponse other) { if (other == MountHandler.RidingMountResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.RidingMountResponse parsedMessage = null; try { parsedMessage = (MountHandler.RidingMountResponse)MountHandler.RidingMountResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.RidingMountResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = MountHandler.RidingMountResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class OneKeyTrainingResponse
/*       */     extends GeneratedMessage
/*       */     implements OneKeyTrainingResponseOrBuilder
/*       */   {
/* 13690 */     private static final OneKeyTrainingResponse defaultInstance = new OneKeyTrainingResponse(true); private final UnknownFieldSet unknownFields; private OneKeyTrainingResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private OneKeyTrainingResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static OneKeyTrainingResponse getDefaultInstance() { return defaultInstance; } public OneKeyTrainingResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private OneKeyTrainingResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; MountHandler.MountData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();  this.s2CData_ = (MountHandler.MountData)input.readMessage(MountHandler.MountData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CData_); this.s2CData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_OneKeyTrainingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OneKeyTrainingResponse.class, Builder.class); } public static Parser<OneKeyTrainingResponse> PARSER = (Parser<OneKeyTrainingResponse>)new AbstractParser<OneKeyTrainingResponse>() { public MountHandler.OneKeyTrainingResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.OneKeyTrainingResponse(input, extensionRegistry); } }
/* 13691 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private MountHandler.MountData s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<OneKeyTrainingResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CData() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     public MountHandler.MountData getS2CData() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */       return this.s2CData_;
/*       */     }
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CData_ = MountHandler.MountData.getDefaultInstance();
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
/*       */       if (hasS2CData() && !getS2CData().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
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
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeMessage(3, (MessageLite)this.s2CData_); 
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
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CData_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(InputStream input) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     public static OneKeyTrainingResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (OneKeyTrainingResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(OneKeyTrainingResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.OneKeyTrainingResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_;
/*       */       private MountHandler.MountData s2CData_;
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> s2CDataBuilder_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_OneKeyTrainingResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_OneKeyTrainingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.OneKeyTrainingResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.OneKeyTrainingResponse.alwaysUseFieldBuilders)
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
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
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
/*       */         return MountHandler.internal_static_pomelo_area_OneKeyTrainingResponse_descriptor;
/*       */       }
/*       */       
/*       */       public MountHandler.OneKeyTrainingResponse getDefaultInstanceForType() {
/*       */         return MountHandler.OneKeyTrainingResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public MountHandler.OneKeyTrainingResponse build() {
/*       */         MountHandler.OneKeyTrainingResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public MountHandler.OneKeyTrainingResponse buildPartial() {
/*       */         MountHandler.OneKeyTrainingResponse result = new MountHandler.OneKeyTrainingResponse(this);
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
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           result.s2CData_ = this.s2CData_;
/*       */         } else {
/*       */           result.s2CData_ = (MountHandler.MountData)this.s2CDataBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.OneKeyTrainingResponse)
/*       */           return mergeFrom((MountHandler.OneKeyTrainingResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(MountHandler.OneKeyTrainingResponse other) {
/*       */         if (other == MountHandler.OneKeyTrainingResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasS2CData())
/*       */           mergeS2CData(other.getS2CData()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (hasS2CData() && !getS2CData().isInitialized())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.OneKeyTrainingResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.OneKeyTrainingResponse)MountHandler.OneKeyTrainingResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.OneKeyTrainingResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = MountHandler.OneKeyTrainingResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasS2CData() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public MountHandler.MountData getS2CData() {
/*       */         if (this.s2CDataBuilder_ == null)
/*       */           return this.s2CData_; 
/*       */         return (MountHandler.MountData)this.s2CDataBuilder_.getMessage();
/*       */       }
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.s2CData_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CData(MountHandler.MountData.Builder builderForValue) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeS2CData(MountHandler.MountData value) {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MountHandler.MountData.getDefaultInstance()) {
/*       */             this.s2CData_ = MountHandler.MountData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CData_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CData() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CData_ = MountHandler.MountData.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CDataBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public MountHandler.MountData.Builder getS2CDataBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (MountHandler.MountData.Builder)getS2CDataFieldBuilder().getBuilder();
/*       */       }
/*       */       
/*       */       public MountHandler.MountDataOrBuilder getS2CDataOrBuilder() {
/*       */         if (this.s2CDataBuilder_ != null)
/*       */           return (MountHandler.MountDataOrBuilder)this.s2CDataBuilder_.getMessageOrBuilder(); 
/*       */         return this.s2CData_;
/*       */       }
/*       */       
/*       */       private SingleFieldBuilder<MountHandler.MountData, MountHandler.MountData.Builder, MountHandler.MountDataOrBuilder> getS2CDataFieldBuilder() {
/*       */         if (this.s2CDataBuilder_ == null) {
/*       */           this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
/*       */           this.s2CData_ = null;
/*       */         } 
/*       */         return this.s2CDataBuilder_;
/*       */       } } }
/*       */   
/* 14095 */   public static final class ChooseFirstSkinRequest extends GeneratedMessage implements ChooseFirstSkinRequestOrBuilder { private static final ChooseFirstSkinRequest defaultInstance = new ChooseFirstSkinRequest(true); private final UnknownFieldSet unknownFields; private ChooseFirstSkinRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChooseFirstSkinRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChooseFirstSkinRequest getDefaultInstance() { return defaultInstance; } public ChooseFirstSkinRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChooseFirstSkinRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SSkinId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChooseFirstSkinRequest.class, Builder.class); } public static Parser<ChooseFirstSkinRequest> PARSER = (Parser<ChooseFirstSkinRequest>)new AbstractParser<ChooseFirstSkinRequest>() { public MountHandler.ChooseFirstSkinRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.ChooseFirstSkinRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_SKINID_FIELD_NUMBER = 1; private int c2SSkinId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChooseFirstSkinRequest> getParserForType() { return PARSER; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SSkinId() { return this.c2SSkinId_; } private void initFields() { this.c2SSkinId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SSkinId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SSkinId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SSkinId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ChooseFirstSkinRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ChooseFirstSkinRequest)PARSER.parseFrom(data); } public static ChooseFirstSkinRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ChooseFirstSkinRequest)PARSER.parseFrom(data, extensionRegistry); } public static ChooseFirstSkinRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ChooseFirstSkinRequest)PARSER.parseFrom(data); } public static ChooseFirstSkinRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ChooseFirstSkinRequest)PARSER.parseFrom(data, extensionRegistry); } public static ChooseFirstSkinRequest parseFrom(InputStream input) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseFrom(input); } public static ChooseFirstSkinRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseFrom(input, extensionRegistry); } public static ChooseFirstSkinRequest parseDelimitedFrom(InputStream input) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseDelimitedFrom(input); } public static ChooseFirstSkinRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ChooseFirstSkinRequest parseFrom(CodedInputStream input) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseFrom(input); } public static ChooseFirstSkinRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChooseFirstSkinRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ChooseFirstSkinRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.ChooseFirstSkinRequestOrBuilder {
/* 14096 */       private int bitField0_; private int c2SSkinId_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.ChooseFirstSkinRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.ChooseFirstSkinRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SSkinId_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinRequest_descriptor; } public MountHandler.ChooseFirstSkinRequest getDefaultInstanceForType() { return MountHandler.ChooseFirstSkinRequest.getDefaultInstance(); } public MountHandler.ChooseFirstSkinRequest build() { MountHandler.ChooseFirstSkinRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.ChooseFirstSkinRequest buildPartial() { MountHandler.ChooseFirstSkinRequest result = new MountHandler.ChooseFirstSkinRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SSkinId_ = this.c2SSkinId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.ChooseFirstSkinRequest) return mergeFrom((MountHandler.ChooseFirstSkinRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.ChooseFirstSkinRequest other) { if (other == MountHandler.ChooseFirstSkinRequest.getDefaultInstance()) return this;  if (other.hasC2SSkinId()) setC2SSkinId(other.getC2SSkinId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SSkinId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.ChooseFirstSkinRequest parsedMessage = null; try { parsedMessage = (MountHandler.ChooseFirstSkinRequest)MountHandler.ChooseFirstSkinRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.ChooseFirstSkinRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SSkinId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SSkinId() { return this.c2SSkinId_; } public Builder setC2SSkinId(int value) { this.bitField0_ |= 0x1; this.c2SSkinId_ = value; onChanged(); return this; } public Builder clearC2SSkinId() { this.bitField0_ &= 0xFFFFFFFE; this.c2SSkinId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class ChooseFirstSkinResponse
/*       */     extends GeneratedMessage
/*       */     implements ChooseFirstSkinResponseOrBuilder
/*       */   {
/* 14657 */     private static final ChooseFirstSkinResponse defaultInstance = new ChooseFirstSkinResponse(true); private final UnknownFieldSet unknownFields; private ChooseFirstSkinResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChooseFirstSkinResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChooseFirstSkinResponse getDefaultInstance() { return defaultInstance; } public ChooseFirstSkinResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChooseFirstSkinResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_ChooseFirstSkinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChooseFirstSkinResponse.class, Builder.class); } public static Parser<ChooseFirstSkinResponse> PARSER = (Parser<ChooseFirstSkinResponse>)new AbstractParser<ChooseFirstSkinResponse>() { public MountHandler.ChooseFirstSkinResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.ChooseFirstSkinResponse(input, extensionRegistry); } }
/* 14658 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChooseFirstSkinResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
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
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(InputStream input) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static ChooseFirstSkinResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (ChooseFirstSkinResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(ChooseFirstSkinResponse prototype) {
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
/*       */       implements MountHandler.ChooseFirstSkinResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return MountHandler.internal_static_pomelo_area_ChooseFirstSkinResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return MountHandler.internal_static_pomelo_area_ChooseFirstSkinResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.ChooseFirstSkinResponse.class, Builder.class);
/*       */       }
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (MountHandler.ChooseFirstSkinResponse.alwaysUseFieldBuilders);
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
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return MountHandler.internal_static_pomelo_area_ChooseFirstSkinResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.ChooseFirstSkinResponse getDefaultInstanceForType() {
/*       */         return MountHandler.ChooseFirstSkinResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.ChooseFirstSkinResponse build() {
/*       */         MountHandler.ChooseFirstSkinResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public MountHandler.ChooseFirstSkinResponse buildPartial() {
/*       */         MountHandler.ChooseFirstSkinResponse result = new MountHandler.ChooseFirstSkinResponse(this);
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof MountHandler.ChooseFirstSkinResponse) {
/*       */           return mergeFrom((MountHandler.ChooseFirstSkinResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(MountHandler.ChooseFirstSkinResponse other) {
/*       */         if (other == MountHandler.ChooseFirstSkinResponse.getDefaultInstance()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         MountHandler.ChooseFirstSkinResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.ChooseFirstSkinResponse)MountHandler.ChooseFirstSkinResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.ChooseFirstSkinResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = MountHandler.ChooseFirstSkinResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */   public static final class MountFlagPush
/*       */     extends GeneratedMessage
/*       */     implements MountFlagPushOrBuilder
/*       */   {
/* 15188 */     private static final MountFlagPush defaultInstance = new MountFlagPush(true); private final UnknownFieldSet unknownFields; private MountFlagPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MountFlagPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MountFlagPush getDefaultInstance() { return defaultInstance; } public MountFlagPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MountFlagPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 24: this.bitField0_ |= 0x1; this.s2CFlag_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x2; this.s2CUsingSkinId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountFlagPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountFlagPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MountFlagPush.class, Builder.class); } public static Parser<MountFlagPush> PARSER = (Parser<MountFlagPush>)new AbstractParser<MountFlagPush>() { public MountHandler.MountFlagPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.MountFlagPush(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_FLAG_FIELD_NUMBER = 3; private int s2CFlag_; public static final int S2C_USINGSKINID_FIELD_NUMBER = 4; private int s2CUsingSkinId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MountFlagPush> getParserForType() { return PARSER; } public boolean hasS2CFlag() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CFlag() { return this.s2CFlag_; } public boolean hasS2CUsingSkinId() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CUsingSkinId() { return this.s2CUsingSkinId_; } private void initFields() { this.s2CFlag_ = 0; this.s2CUsingSkinId_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(3, this.s2CFlag_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(4, this.s2CUsingSkinId_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(3, this.s2CFlag_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(4, this.s2CUsingSkinId_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static MountFlagPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (MountFlagPush)PARSER.parseFrom(data); } public static MountFlagPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountFlagPush)PARSER.parseFrom(data, extensionRegistry); } public static MountFlagPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (MountFlagPush)PARSER.parseFrom(data); } public static MountFlagPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountFlagPush)PARSER.parseFrom(data, extensionRegistry); } public static MountFlagPush parseFrom(InputStream input) throws IOException { return (MountFlagPush)PARSER.parseFrom(input); } public static MountFlagPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountFlagPush)PARSER.parseFrom(input, extensionRegistry); } public static MountFlagPush parseDelimitedFrom(InputStream input) throws IOException { return (MountFlagPush)PARSER.parseDelimitedFrom(input); } public static MountFlagPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountFlagPush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static MountFlagPush parseFrom(CodedInputStream input) throws IOException { return (MountFlagPush)PARSER.parseFrom(input); } public static MountFlagPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountFlagPush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(MountFlagPush prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.MountFlagPushOrBuilder {
/* 15189 */       private int bitField0_; private int s2CFlag_; private int s2CUsingSkinId_; public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountFlagPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountFlagPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.MountFlagPush.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (MountHandler.MountFlagPush.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CFlag_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CUsingSkinId_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_MountFlagPush_descriptor; } public MountHandler.MountFlagPush getDefaultInstanceForType() { return MountHandler.MountFlagPush.getDefaultInstance(); } public MountHandler.MountFlagPush build() { MountHandler.MountFlagPush result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public MountHandler.MountFlagPush buildPartial() { MountHandler.MountFlagPush result = new MountHandler.MountFlagPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CFlag_ = this.s2CFlag_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CUsingSkinId_ = this.s2CUsingSkinId_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof MountHandler.MountFlagPush) return mergeFrom((MountHandler.MountFlagPush)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(MountHandler.MountFlagPush other) { if (other == MountHandler.MountFlagPush.getDefaultInstance()) return this;  if (other.hasS2CFlag()) setS2CFlag(other.getS2CFlag());  if (other.hasS2CUsingSkinId()) setS2CUsingSkinId(other.getS2CUsingSkinId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.MountFlagPush parsedMessage = null; try { parsedMessage = (MountHandler.MountFlagPush)MountHandler.MountFlagPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (MountHandler.MountFlagPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CFlag() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CFlag() { return this.s2CFlag_; } public Builder setS2CFlag(int value) { this.bitField0_ |= 0x1; this.s2CFlag_ = value; onChanged(); return this; } public Builder clearS2CFlag() { this.bitField0_ &= 0xFFFFFFFE; this.s2CFlag_ = 0; onChanged(); return this; } public boolean hasS2CUsingSkinId() { return ((this.bitField0_ & 0x2) == 2); } public int getS2CUsingSkinId() { return this.s2CUsingSkinId_; } public Builder setS2CUsingSkinId(int value) { this.bitField0_ |= 0x2; this.s2CUsingSkinId_ = value; onChanged(); return this; } public Builder clearS2CUsingSkinId() { this.bitField0_ &= 0xFFFFFFFD; this.s2CUsingSkinId_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class MountNewSkinPush
/*       */     extends GeneratedMessage
/*       */     implements MountNewSkinPushOrBuilder
/*       */   {
/* 15742 */     private static final MountNewSkinPush defaultInstance = new MountNewSkinPush(true); private final UnknownFieldSet unknownFields; private MountNewSkinPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private MountNewSkinPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static MountNewSkinPush getDefaultInstance() { return defaultInstance; } public MountNewSkinPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private MountNewSkinPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 24: this.bitField0_ |= 0x1; this.s2CSkinId_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CSkinName_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountNewSkinPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountNewSkinPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MountNewSkinPush.class, Builder.class); } public static Parser<MountNewSkinPush> PARSER = (Parser<MountNewSkinPush>)new AbstractParser<MountNewSkinPush>() { public MountHandler.MountNewSkinPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new MountHandler.MountNewSkinPush(input, extensionRegistry); } }
/* 15743 */     ; private int bitField0_; public static final int S2C_SKINID_FIELD_NUMBER = 3; private int s2CSkinId_; public static final int S2C_SKINNAME_FIELD_NUMBER = 4; private Object s2CSkinName_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<MountNewSkinPush> getParserForType() { return PARSER; } public boolean hasS2CSkinId() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CSkinId() { return this.s2CSkinId_; } public boolean hasS2CSkinName() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); } public String getS2CSkinName() { Object ref = this.s2CSkinName_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.s2CSkinName_ = s;  return s; } public ByteString getS2CSkinNameBytes() { Object ref = this.s2CSkinName_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CSkinName_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     private void initFields() { this.s2CSkinId_ = 0; this.s2CSkinName_ = ""; }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(3, this.s2CSkinId_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(4, getS2CSkinNameBytes());  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.s2CSkinId_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(4, getS2CSkinNameBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static MountNewSkinPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (MountNewSkinPush)PARSER.parseFrom(data); }
/*       */     public static MountNewSkinPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountNewSkinPush)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static MountNewSkinPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (MountNewSkinPush)PARSER.parseFrom(data); }
/*       */     public static MountNewSkinPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (MountNewSkinPush)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static MountNewSkinPush parseFrom(InputStream input) throws IOException { return (MountNewSkinPush)PARSER.parseFrom(input); }
/*       */     public static MountNewSkinPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountNewSkinPush)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static MountNewSkinPush parseDelimitedFrom(InputStream input) throws IOException { return (MountNewSkinPush)PARSER.parseDelimitedFrom(input); }
/*       */     public static MountNewSkinPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountNewSkinPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static MountNewSkinPush parseFrom(CodedInputStream input) throws IOException { return (MountNewSkinPush)PARSER.parseFrom(input); }
/*       */     public static MountNewSkinPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (MountNewSkinPush)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(MountNewSkinPush prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements MountHandler.MountNewSkinPushOrBuilder { private int bitField0_; private int s2CSkinId_; private Object s2CSkinName_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return MountHandler.internal_static_pomelo_area_MountNewSkinPush_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return MountHandler.internal_static_pomelo_area_MountNewSkinPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MountHandler.MountNewSkinPush.class, Builder.class); }
/*       */       private Builder() { this.s2CSkinName_ = ""; maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CSkinName_ = ""; maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (MountHandler.MountNewSkinPush.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CSkinId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CSkinName_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return MountHandler.internal_static_pomelo_area_MountNewSkinPush_descriptor; }
/*       */       public MountHandler.MountNewSkinPush getDefaultInstanceForType() { return MountHandler.MountNewSkinPush.getDefaultInstance(); }
/*       */       public MountHandler.MountNewSkinPush build() { MountHandler.MountNewSkinPush result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public MountHandler.MountNewSkinPush buildPartial() { MountHandler.MountNewSkinPush result = new MountHandler.MountNewSkinPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CSkinId_ = this.s2CSkinId_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.s2CSkinName_ = this.s2CSkinName_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof MountHandler.MountNewSkinPush)
/*       */           return mergeFrom((MountHandler.MountNewSkinPush)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(MountHandler.MountNewSkinPush other) { if (other == MountHandler.MountNewSkinPush.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CSkinId())
/*       */           setS2CSkinId(other.getS2CSkinId()); 
/*       */         if (other.hasS2CSkinName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CSkinName_ = other.s2CSkinName_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { MountHandler.MountNewSkinPush parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (MountHandler.MountNewSkinPush)MountHandler.MountNewSkinPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (MountHandler.MountNewSkinPush)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; }
/*       */       public boolean hasS2CSkinId() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getS2CSkinId() { return this.s2CSkinId_; }
/*       */       public Builder setS2CSkinId(int value) { this.bitField0_ |= 0x1;
/*       */         this.s2CSkinId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearS2CSkinId() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CSkinId_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasS2CSkinName() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getS2CSkinName() { Object ref = this.s2CSkinName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CSkinName_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getS2CSkinNameBytes() { Object ref = this.s2CSkinName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CSkinName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setS2CSkinName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CSkinName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearS2CSkinName() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CSkinName_ = MountHandler.MountNewSkinPush.getDefaultInstance().getS2CSkinName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CSkinNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CSkinName_ = value;
/*       */         onChanged();
/*       */         return this; } }
/*       */   }
/* 15862 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 15867 */     String[] descriptorData = { "\n\022mountHandler.proto\022\013pomelo.area\032\fcommon.proto\",\n\026ActiveMountSkinRequest\022\022\n\nc2s_skinId\030\001 \002(\005\";\n\020SaveMountRequest\022\023\n\013c2s_mountId\030\001 \002(\005\022\022\n\nc2s_skinId\030\002 \002(\005\"\025\n\023UpMountStageRequest\"\025\n\023GetMountInfoRequest\"(\n\024TrainingMountRequest\022\020\n\bc2s_type\030\001 \002(\005\"&\n\022RidingMountRequest\022\020\n\bc2s_isUp\030\001 \002(\005\"\027\n\025OneKeyTrainingRequest\"\001\n\bItemData\022\016\n\006costId\030\001 \002(\t\022\024\n\fcostItemIcon\030\002 \002(\t\022\024\n\fcostItemName\030\003 \002(\t\022\022\n\ncurItemNum\030\004 \002(\005", "\022\017\n\007costNum\030\005 \002(\005\022\027\n\017costItemQuality\030\006 \002(\005\"À\001\n\fSkinInfoData\022\n\n\002id\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\025\n\rneedRideLevel\030\003 \002(\005\022\f\n\004icon\030\004 \002(\t\022\021\n\tmodelFile\030\005 \002(\t\022\f\n\004desc\030\006 \002(\t\022\r\n\005state\030\007 \002(\005\022\027\n\017fightPowerValue\030\b \002(\005\022(\n\tskinAttrs\030\t \003(\0132\025.pomelo.AttributeBase\"¹\001\n\rMountInfoData\022\n\n\002id\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\r\n\005level\030\003 \002(\005\022\f\n\004icon\030\004 \002(\t\022\021\n\tmodelFile\030\005 \002(\t\022\f\n\004desc\030\006 \002(\t\022\r\n\005state\030\007 \002(\005\022\027\n\017fightPowerValue\030\b \002(\005\022(\n\tskinAttrs\030\t \003", "(\0132\025.pomelo.AttributeBase\"Ê\001\n\tMountData\022\021\n\trideLevel\030\001 \002(\005\022\016\n\006starLv\030\002 \002(\005\022\027\n\017fightPowerValue\030\004 \002(\005\022\023\n\013usingSkinID\030\007 \002(\005\022\022\n\nmountSkins\030\b \003(\005\022)\n\nmountAttrs\030\r \003(\0132\025.pomelo.AttributeBase\022-\n\016mountAttrsNext\030\016 \003(\0132\025.pomelo.AttributeBase\"<\n\027ActiveMountSkinResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"`\n\021SaveMountResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MountData\"~\n\024UpMoun", "tStageResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MountData\022\031\n\021s2c_curLuckyValue\030\004 \001(\005\"c\n\024GetMountInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MountData\"d\n\025TrainingMountResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MountData\"8\n\023RidingMountResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"e\n\026OneKeyTrainingRes", "ponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MountData\",\n\026ChooseFirstSkinRequest\022\022\n\nc2s_skinId\030\001 \002(\005\"<\n\027ChooseFirstSkinResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\":\n\rMountFlagPush\022\020\n\bs2c_flag\030\003 \001(\005\022\027\n\017s2c_usingSkinId\030\004 \001(\005\"<\n\020MountNewSkinPush\022\022\n\ns2c_skinId\030\003 \001(\005\022\024\n\fs2c_skinName\030\004 \001(\t2ý\005\n\fmountHandler\022c\n\026activeMountSkinRequest\022#.pomelo.area.ActiveMountSkinRequest\032$.pomel", "o.area.ActiveMountSkinResponse\022Q\n\020saveMountRequest\022\035.pomelo.area.SaveMountRequest\032\036.pomelo.area.SaveMountResponse\022Z\n\023upMountStageRequest\022 .pomelo.area.UpMountStageRequest\032!.pomelo.area.UpMountStageResponse\022Z\n\023getMountInfoRequest\022 .pomelo.area.GetMountInfoRequest\032!.pomelo.area.GetMountInfoResponse\022]\n\024trainingMountRequest\022!.pomelo.area.TrainingMountRequest\032\".pomelo.area.TrainingMountResponse\022W\n\022ridi", "ngMountRequest\022\037.pomelo.area.RidingMountRequest\032 .pomelo.area.RidingMountResponse\022`\n\025oneKeyTrainingRequest\022\".pomelo.area.OneKeyTrainingRequest\032#.pomelo.area.OneKeyTrainingResponse\022c\n\026chooseFirstSkinRequest\022#.pomelo.area.ChooseFirstSkinRequest\032$.pomelo.area.ChooseFirstSkinResponse2\001\n\tmountPush\0229\n\rmountFlagPush\022\032.pomelo.area.MountFlagPush\032\f.pomelo.Void\022?\n\020mountNewSkinPush\022\035.pomelo.area.MountNewSkin", "Push\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 15940 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 15944 */           MountHandler.descriptor = root;
/* 15945 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 15949 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 15951 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 15954 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ActiveMountSkinRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 15955 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActiveMountSkinRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActiveMountSkinRequest_descriptor, new String[] { "C2SSkinId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15960 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SaveMountRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 15961 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveMountRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveMountRequest_descriptor, new String[] { "C2SMountId", "C2SSkinId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15966 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpMountStageRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 15967 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpMountStageRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpMountStageRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15972 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetMountInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 15973 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMountInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMountInfoRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15978 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TrainingMountRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 15979 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TrainingMountRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TrainingMountRequest_descriptor, new String[] { "C2SType" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15984 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RidingMountRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 15985 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RidingMountRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RidingMountRequest_descriptor, new String[] { "C2SIsUp" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15990 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OneKeyTrainingRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 15991 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OneKeyTrainingRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OneKeyTrainingRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 15996 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ItemData_descriptor = getDescriptor().getMessageTypes().get(7);
/* 15997 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ItemData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ItemData_descriptor, new String[] { "CostId", "CostItemIcon", "CostItemName", "CurItemNum", "CostNum", "CostItemQuality" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16002 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SkinInfoData_descriptor = getDescriptor().getMessageTypes().get(8);
/* 16003 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkinInfoData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkinInfoData_descriptor, new String[] { "Id", "Name", "NeedRideLevel", "Icon", "ModelFile", "Desc", "State", "FightPowerValue", "SkinAttrs" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16008 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MountInfoData_descriptor = getDescriptor().getMessageTypes().get(9);
/* 16009 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MountInfoData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MountInfoData_descriptor, new String[] { "Id", "Name", "Level", "Icon", "ModelFile", "Desc", "State", "FightPowerValue", "SkinAttrs" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16014 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MountData_descriptor = getDescriptor().getMessageTypes().get(10);
/* 16015 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MountData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MountData_descriptor, new String[] { "RideLevel", "StarLv", "FightPowerValue", "UsingSkinID", "MountSkins", "MountAttrs", "MountAttrsNext" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16020 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ActiveMountSkinResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 16021 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActiveMountSkinResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActiveMountSkinResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16026 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SaveMountResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 16027 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveMountResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveMountResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16032 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpMountStageResponse_descriptor = getDescriptor().getMessageTypes().get(13);
/* 16033 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpMountStageResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpMountStageResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData", "S2CCurLuckyValue" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16038 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetMountInfoResponse_descriptor = getDescriptor().getMessageTypes().get(14);
/* 16039 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMountInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMountInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16044 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TrainingMountResponse_descriptor = getDescriptor().getMessageTypes().get(15);
/* 16045 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TrainingMountResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TrainingMountResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16050 */   private static final Descriptors.Descriptor internal_static_pomelo_area_RidingMountResponse_descriptor = getDescriptor().getMessageTypes().get(16);
/* 16051 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RidingMountResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RidingMountResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16056 */   private static final Descriptors.Descriptor internal_static_pomelo_area_OneKeyTrainingResponse_descriptor = getDescriptor().getMessageTypes().get(17);
/* 16057 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OneKeyTrainingResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OneKeyTrainingResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16062 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ChooseFirstSkinRequest_descriptor = getDescriptor().getMessageTypes().get(18);
/* 16063 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChooseFirstSkinRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChooseFirstSkinRequest_descriptor, new String[] { "C2SSkinId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16068 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ChooseFirstSkinResponse_descriptor = getDescriptor().getMessageTypes().get(19);
/* 16069 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChooseFirstSkinResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChooseFirstSkinResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16074 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MountFlagPush_descriptor = getDescriptor().getMessageTypes().get(20);
/* 16075 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MountFlagPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MountFlagPush_descriptor, new String[] { "S2CFlag", "S2CUsingSkinId" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 16080 */   private static final Descriptors.Descriptor internal_static_pomelo_area_MountNewSkinPush_descriptor = getDescriptor().getMessageTypes().get(21);
/* 16081 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MountNewSkinPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MountNewSkinPush_descriptor, new String[] { "S2CSkinId", "S2CSkinName" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 16085 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface MountNewSkinPushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CSkinId();
/*       */     
/*       */     int getS2CSkinId();
/*       */     
/*       */     boolean hasS2CSkinName();
/*       */     
/*       */     String getS2CSkinName();
/*       */     
/*       */     ByteString getS2CSkinNameBytes();
/*       */   }
/*       */   
/*       */   public static interface MountFlagPushOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CFlag();
/*       */     
/*       */     int getS2CFlag();
/*       */     
/*       */     boolean hasS2CUsingSkinId();
/*       */     
/*       */     int getS2CUsingSkinId();
/*       */   }
/*       */   
/*       */   public static interface ChooseFirstSkinResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface ChooseFirstSkinRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SSkinId();
/*       */     
/*       */     int getC2SSkinId();
/*       */   }
/*       */   
/*       */   public static interface OneKeyTrainingResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CData();
/*       */     
/*       */     MountHandler.MountData getS2CData();
/*       */     
/*       */     MountHandler.MountDataOrBuilder getS2CDataOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface RidingMountResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface TrainingMountResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CData();
/*       */     
/*       */     MountHandler.MountData getS2CData();
/*       */     
/*       */     MountHandler.MountDataOrBuilder getS2CDataOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface GetMountInfoResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CData();
/*       */     
/*       */     MountHandler.MountData getS2CData();
/*       */     
/*       */     MountHandler.MountDataOrBuilder getS2CDataOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface UpMountStageResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CData();
/*       */     
/*       */     MountHandler.MountData getS2CData();
/*       */     
/*       */     MountHandler.MountDataOrBuilder getS2CDataOrBuilder();
/*       */     
/*       */     boolean hasS2CCurLuckyValue();
/*       */     
/*       */     int getS2CCurLuckyValue();
/*       */   }
/*       */   
/*       */   public static interface SaveMountResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CData();
/*       */     
/*       */     MountHandler.MountData getS2CData();
/*       */     
/*       */     MountHandler.MountDataOrBuilder getS2CDataOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface ActiveMountSkinResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface MountDataOrBuilder extends MessageOrBuilder {
/*       */     boolean hasRideLevel();
/*       */     
/*       */     int getRideLevel();
/*       */     
/*       */     boolean hasStarLv();
/*       */     
/*       */     int getStarLv();
/*       */     
/*       */     boolean hasFightPowerValue();
/*       */     
/*       */     int getFightPowerValue();
/*       */     
/*       */     boolean hasUsingSkinID();
/*       */     
/*       */     int getUsingSkinID();
/*       */     
/*       */     List<Integer> getMountSkinsList();
/*       */     
/*       */     int getMountSkinsCount();
/*       */     
/*       */     int getMountSkins(int param1Int);
/*       */     
/*       */     List<Common.AttributeBase> getMountAttrsList();
/*       */     
/*       */     Common.AttributeBase getMountAttrs(int param1Int);
/*       */     
/*       */     int getMountAttrsCount();
/*       */     
/*       */     List<? extends Common.AttributeBaseOrBuilder> getMountAttrsOrBuilderList();
/*       */     
/*       */     Common.AttributeBaseOrBuilder getMountAttrsOrBuilder(int param1Int);
/*       */     
/*       */     List<Common.AttributeBase> getMountAttrsNextList();
/*       */     
/*       */     Common.AttributeBase getMountAttrsNext(int param1Int);
/*       */     
/*       */     int getMountAttrsNextCount();
/*       */     
/*       */     List<? extends Common.AttributeBaseOrBuilder> getMountAttrsNextOrBuilderList();
/*       */     
/*       */     Common.AttributeBaseOrBuilder getMountAttrsNextOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface MountInfoDataOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasIcon();
/*       */     
/*       */     String getIcon();
/*       */     
/*       */     ByteString getIconBytes();
/*       */     
/*       */     boolean hasModelFile();
/*       */     
/*       */     String getModelFile();
/*       */     
/*       */     ByteString getModelFileBytes();
/*       */     
/*       */     boolean hasDesc();
/*       */     
/*       */     String getDesc();
/*       */     
/*       */     ByteString getDescBytes();
/*       */     
/*       */     boolean hasState();
/*       */     
/*       */     int getState();
/*       */     
/*       */     boolean hasFightPowerValue();
/*       */     
/*       */     int getFightPowerValue();
/*       */     
/*       */     List<Common.AttributeBase> getSkinAttrsList();
/*       */     
/*       */     Common.AttributeBase getSkinAttrs(int param1Int);
/*       */     
/*       */     int getSkinAttrsCount();
/*       */     
/*       */     List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList();
/*       */     
/*       */     Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface SkinInfoDataOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasNeedRideLevel();
/*       */     
/*       */     int getNeedRideLevel();
/*       */     
/*       */     boolean hasIcon();
/*       */     
/*       */     String getIcon();
/*       */     
/*       */     ByteString getIconBytes();
/*       */     
/*       */     boolean hasModelFile();
/*       */     
/*       */     String getModelFile();
/*       */     
/*       */     ByteString getModelFileBytes();
/*       */     
/*       */     boolean hasDesc();
/*       */     
/*       */     String getDesc();
/*       */     
/*       */     ByteString getDescBytes();
/*       */     
/*       */     boolean hasState();
/*       */     
/*       */     int getState();
/*       */     
/*       */     boolean hasFightPowerValue();
/*       */     
/*       */     int getFightPowerValue();
/*       */     
/*       */     List<Common.AttributeBase> getSkinAttrsList();
/*       */     
/*       */     Common.AttributeBase getSkinAttrs(int param1Int);
/*       */     
/*       */     int getSkinAttrsCount();
/*       */     
/*       */     List<? extends Common.AttributeBaseOrBuilder> getSkinAttrsOrBuilderList();
/*       */     
/*       */     Common.AttributeBaseOrBuilder getSkinAttrsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface ItemDataOrBuilder extends MessageOrBuilder {
/*       */     boolean hasCostId();
/*       */     
/*       */     String getCostId();
/*       */     
/*       */     ByteString getCostIdBytes();
/*       */     
/*       */     boolean hasCostItemIcon();
/*       */     
/*       */     String getCostItemIcon();
/*       */     
/*       */     ByteString getCostItemIconBytes();
/*       */     
/*       */     boolean hasCostItemName();
/*       */     
/*       */     String getCostItemName();
/*       */     
/*       */     ByteString getCostItemNameBytes();
/*       */     
/*       */     boolean hasCurItemNum();
/*       */     
/*       */     int getCurItemNum();
/*       */     
/*       */     boolean hasCostNum();
/*       */     
/*       */     int getCostNum();
/*       */     
/*       */     boolean hasCostItemQuality();
/*       */     
/*       */     int getCostItemQuality();
/*       */   }
/*       */   
/*       */   public static interface OneKeyTrainingRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface RidingMountRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SIsUp();
/*       */     
/*       */     int getC2SIsUp();
/*       */   }
/*       */   
/*       */   public static interface TrainingMountRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SType();
/*       */     
/*       */     int getC2SType();
/*       */   }
/*       */   
/*       */   public static interface GetMountInfoRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface UpMountStageRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface SaveMountRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SMountId();
/*       */     
/*       */     int getC2SMountId();
/*       */     
/*       */     boolean hasC2SSkinId();
/*       */     
/*       */     int getC2SSkinId();
/*       */   }
/*       */   
/*       */   public static interface ActiveMountSkinRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SSkinId();
/*       */     
/*       */     int getC2SSkinId();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\MountHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */