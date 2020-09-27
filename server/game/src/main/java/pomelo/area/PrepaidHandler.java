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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class PrepaidHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class PrepaidSDKRequest
/*       */     extends GeneratedMessage
/*       */     implements PrepaidSDKRequestOrBuilder
/*       */   {
/*   488 */     private static final PrepaidSDKRequest defaultInstance = new PrepaidSDKRequest(true); private final UnknownFieldSet unknownFields; private PrepaidSDKRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidSDKRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidSDKRequest getDefaultInstance() { return defaultInstance; } public PrepaidSDKRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidSDKRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.s2CParam_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidSDKRequest.class, Builder.class); } public static Parser<PrepaidSDKRequest> PARSER = (Parser<PrepaidSDKRequest>)new AbstractParser<PrepaidSDKRequest>() { public PrepaidHandler.PrepaidSDKRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidSDKRequest(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_PARAM_FIELD_NUMBER = 1; private Object s2CParam_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidSDKRequest> getParserForType() { return PARSER; } public boolean hasS2CParam() { return ((this.bitField0_ & 0x1) == 1); } public String getS2CParam() { Object ref = this.s2CParam_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CParam_ = s;  return s; } public ByteString getS2CParamBytes() { Object ref = this.s2CParam_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CParam_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CParam_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CParam()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getS2CParamBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getS2CParamBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidSDKRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidSDKRequest)PARSER.parseFrom(data); } public static PrepaidSDKRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidSDKRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidSDKRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidSDKRequest)PARSER.parseFrom(data); } public static PrepaidSDKRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidSDKRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidSDKRequest parseFrom(InputStream input) throws IOException { return (PrepaidSDKRequest)PARSER.parseFrom(input); } public static PrepaidSDKRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKRequest)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidSDKRequest parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidSDKRequest)PARSER.parseDelimitedFrom(input); } public static PrepaidSDKRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidSDKRequest parseFrom(CodedInputStream input) throws IOException { return (PrepaidSDKRequest)PARSER.parseFrom(input); } public static PrepaidSDKRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidSDKRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidSDKRequestOrBuilder {
/*   489 */       private int bitField0_; private Object s2CParam_; public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidSDKRequest.class, Builder.class); } private Builder() { this.s2CParam_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CParam_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidSDKRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CParam_ = ""; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKRequest_descriptor; } public PrepaidHandler.PrepaidSDKRequest getDefaultInstanceForType() { return PrepaidHandler.PrepaidSDKRequest.getDefaultInstance(); } public PrepaidHandler.PrepaidSDKRequest build() { PrepaidHandler.PrepaidSDKRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidSDKRequest buildPartial() { PrepaidHandler.PrepaidSDKRequest result = new PrepaidHandler.PrepaidSDKRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CParam_ = this.s2CParam_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidSDKRequest) return mergeFrom((PrepaidHandler.PrepaidSDKRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidSDKRequest other) { if (other == PrepaidHandler.PrepaidSDKRequest.getDefaultInstance()) return this;  if (other.hasS2CParam()) { this.bitField0_ |= 0x1; this.s2CParam_ = other.s2CParam_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CParam()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidSDKRequest parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidSDKRequest)PrepaidHandler.PrepaidSDKRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidSDKRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CParam() { return ((this.bitField0_ & 0x1) == 1); } public String getS2CParam() { Object ref = this.s2CParam_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CParam_ = s;  return s; }  return (String)ref; } public ByteString getS2CParamBytes() { Object ref = this.s2CParam_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CParam_ = b; return b; }  return (ByteString)ref; } public Builder setS2CParam(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CParam_ = value; onChanged(); return this; } public Builder clearS2CParam() { this.bitField0_ &= 0xFFFFFFFE; this.s2CParam_ = PrepaidHandler.PrepaidSDKRequest.getDefaultInstance().getS2CParam(); onChanged(); return this; } public Builder setS2CParamBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CParam_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PrepaidSDKResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidSDKResponseOrBuilder
/*       */   {
/*  1215 */     private static final PrepaidSDKResponse defaultInstance = new PrepaidSDKResponse(true); private final UnknownFieldSet unknownFields; private PrepaidSDKResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidSDKResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidSDKResponse getDefaultInstance() { return defaultInstance; } public PrepaidSDKResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidSDKResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CData_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidSDKResponse.class, Builder.class); } public static Parser<PrepaidSDKResponse> PARSER = (Parser<PrepaidSDKResponse>)new AbstractParser<PrepaidSDKResponse>() { public PrepaidHandler.PrepaidSDKResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidSDKResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private Object s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidSDKResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CData() { Object ref = this.s2CData_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CData_ = s;  return s; } public ByteString getS2CDataBytes() { Object ref = this.s2CData_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CData_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CData_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CData()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getS2CDataBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getS2CDataBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidSDKResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidSDKResponse)PARSER.parseFrom(data); } public static PrepaidSDKResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidSDKResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidSDKResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidSDKResponse)PARSER.parseFrom(data); } public static PrepaidSDKResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidSDKResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidSDKResponse parseFrom(InputStream input) throws IOException { return (PrepaidSDKResponse)PARSER.parseFrom(input); } public static PrepaidSDKResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKResponse)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidSDKResponse parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidSDKResponse)PARSER.parseDelimitedFrom(input); } public static PrepaidSDKResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidSDKResponse parseFrom(CodedInputStream input) throws IOException { return (PrepaidSDKResponse)PARSER.parseFrom(input); } public static PrepaidSDKResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidSDKResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidSDKResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidSDKResponseOrBuilder {
/*  1216 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Object s2CData_; public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidSDKResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.s2CData_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CData_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidSDKResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CData_ = ""; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidSDKResponse_descriptor; } public PrepaidHandler.PrepaidSDKResponse getDefaultInstanceForType() { return PrepaidHandler.PrepaidSDKResponse.getDefaultInstance(); } public PrepaidHandler.PrepaidSDKResponse build() { PrepaidHandler.PrepaidSDKResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidSDKResponse buildPartial() { PrepaidHandler.PrepaidSDKResponse result = new PrepaidHandler.PrepaidSDKResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CData_ = this.s2CData_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidSDKResponse) return mergeFrom((PrepaidHandler.PrepaidSDKResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidSDKResponse other) { if (other == PrepaidHandler.PrepaidSDKResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CData()) { this.bitField0_ |= 0x4; this.s2CData_ = other.s2CData_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasS2CData()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidSDKResponse parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidSDKResponse)PrepaidHandler.PrepaidSDKResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidSDKResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = PrepaidHandler.PrepaidSDKResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CData() { Object ref = this.s2CData_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CData_ = s;  return s; }  return (String)ref; } public ByteString getS2CDataBytes() { Object ref = this.s2CData_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CData_ = b; return b; }  return (ByteString)ref; } public Builder setS2CData(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CData_ = value; onChanged(); return this; } public Builder clearS2CData() { this.bitField0_ &= 0xFFFFFFFB; this.s2CData_ = PrepaidHandler.PrepaidSDKResponse.getDefaultInstance().getS2CData(); onChanged(); return this; } public Builder setS2CDataBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CData_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PayItem
/*       */     extends GeneratedMessage
/*       */     implements PayItemOrBuilder
/*       */   {
/*  2704 */     private static final PayItem defaultInstance = new PayItem(true); private final UnknownFieldSet unknownFields; private PayItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PayItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PayItem getDefaultInstance() { return defaultInstance; } public PayItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PayItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.itemNumId_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.itemStrId_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.itemName_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.icon_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.desc_ = bs; break;case 48: this.bitField0_ |= 0x20; this.price_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.diamond_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.ticket_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x100; this.flag_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PayItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PayItem_fieldAccessorTable.ensureFieldAccessorsInitialized(PayItem.class, Builder.class); } public static Parser<PayItem> PARSER = (Parser<PayItem>)new AbstractParser<PayItem>() { public PrepaidHandler.PayItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PayItem(input, extensionRegistry); } }
/*  2705 */     ; private int bitField0_; public static final int ITEMNUMID_FIELD_NUMBER = 1; private int itemNumId_; public static final int ITEMSTRID_FIELD_NUMBER = 2; private Object itemStrId_; public static final int ITEMNAME_FIELD_NUMBER = 3; private Object itemName_; public static final int ICON_FIELD_NUMBER = 4; private Object icon_; public static final int DESC_FIELD_NUMBER = 5; private Object desc_; public static final int PRICE_FIELD_NUMBER = 6; private int price_; public static final int DIAMOND_FIELD_NUMBER = 7; private int diamond_; public static final int TICKET_FIELD_NUMBER = 8; private int ticket_; public static final int FLAG_FIELD_NUMBER = 9; private int flag_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PayItem> getParserForType() { return PARSER; } public boolean hasItemNumId() { return ((this.bitField0_ & 0x1) == 1); } public int getItemNumId() { return this.itemNumId_; } public boolean hasItemStrId() { return ((this.bitField0_ & 0x2) == 2); } public String getItemStrId() { Object ref = this.itemStrId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.itemStrId_ = s;  return s; } public ByteString getItemStrIdBytes() { Object ref = this.itemStrId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.itemStrId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasItemName() {
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
/*       */     public String getItemName() {
/*       */       Object ref = this.itemName_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.itemName_ = s;
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
/*       */     public ByteString getItemNameBytes() {
/*       */       Object ref = this.itemName_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.itemName_ = b;
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
/*       */     public boolean hasIcon() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasDesc() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasPrice() {
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
/*       */     public int getPrice() {
/*       */       return this.price_;
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
/*       */     public boolean hasDiamond() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
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
/*       */     public int getDiamond() {
/*       */       return this.diamond_;
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
/*       */     public boolean hasTicket() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
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
/*       */     public int getTicket() {
/*       */       return this.ticket_;
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
/*       */     public boolean hasFlag() {
/*       */       return ((this.bitField0_ & 0x100) == 256);
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
/*       */     public int getFlag() {
/*       */       return this.flag_;
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
/*       */     private void initFields() {
/*       */       this.itemNumId_ = 0;
/*       */       this.itemStrId_ = "";
/*       */       this.itemName_ = "";
/*       */       this.icon_ = "";
/*       */       this.desc_ = "";
/*       */       this.price_ = 0;
/*       */       this.diamond_ = 0;
/*       */       this.ticket_ = 0;
/*       */       this.flag_ = 0;
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
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1) {
/*       */         return true;
/*       */       }
/*       */       if (isInitialized == 0) {
/*       */         return false;
/*       */       }
/*       */       if (!hasItemNumId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemStrId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasItemName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasIcon()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDesc()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasPrice()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDiamond()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasTicket()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasFlag()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.itemNumId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getItemStrIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getItemNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeBytes(5, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeInt32(6, this.price_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         output.writeInt32(7, this.diamond_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         output.writeInt32(8, this.ticket_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         output.writeInt32(9, this.flag_);
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.itemNumId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getItemStrIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getItemNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getIconBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeBytesSize(5, getDescBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeInt32Size(6, this.price_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x40) == 64) {
/*       */         size += CodedOutputStream.computeInt32Size(7, this.diamond_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x80) == 128) {
/*       */         size += CodedOutputStream.computeInt32Size(8, this.ticket_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x100) == 256) {
/*       */         size += CodedOutputStream.computeInt32Size(9, this.flag_);
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
/*       */     public static PayItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PayItem)PARSER.parseFrom(data);
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
/*       */     public static PayItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PayItem)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static PayItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PayItem)PARSER.parseFrom(data);
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
/*       */     public static PayItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PayItem)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static PayItem parseFrom(InputStream input) throws IOException {
/*       */       return (PayItem)PARSER.parseFrom(input);
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
/*       */     public static PayItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PayItem)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static PayItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (PayItem)PARSER.parseDelimitedFrom(input);
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
/*       */     public static PayItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PayItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static PayItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (PayItem)PARSER.parseFrom(input);
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
/*       */     public static PayItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PayItem)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(PayItem prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements PrepaidHandler.PayItemOrBuilder
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
/*       */       private int itemNumId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object itemStrId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object itemName_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int price_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int diamond_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int ticket_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PayItem_descriptor;
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
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PayItem_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PayItem.class, Builder.class);
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
/*       */       private Builder() {
/*       */         this.itemStrId_ = "";
/*       */         this.itemName_ = "";
/*       */         this.icon_ = "";
/*       */         this.desc_ = "";
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.itemStrId_ = "";
/*       */         this.itemName_ = "";
/*       */         this.icon_ = "";
/*       */         this.desc_ = "";
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (PrepaidHandler.PayItem.alwaysUseFieldBuilders);
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.itemNumId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.itemStrId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.itemName_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.icon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.desc_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.price_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.diamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.ticket_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.flag_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PayItem_descriptor;
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
/*       */       public PrepaidHandler.PayItem getDefaultInstanceForType() {
/*       */         return PrepaidHandler.PayItem.getDefaultInstance();
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
/*       */       public PrepaidHandler.PayItem build() {
/*       */         PrepaidHandler.PayItem result = buildPartial();
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
/*       */       public PrepaidHandler.PayItem buildPartial() {
/*       */         PrepaidHandler.PayItem result = new PrepaidHandler.PayItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.itemNumId_ = this.itemNumId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.itemStrId_ = this.itemStrId_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.itemName_ = this.itemName_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.icon_ = this.icon_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.desc_ = this.desc_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.price_ = this.price_;
/*       */         if ((from_bitField0_ & 0x40) == 64) {
/*       */           to_bitField0_ |= 0x40;
/*       */         }
/*       */         result.diamond_ = this.diamond_;
/*       */         if ((from_bitField0_ & 0x80) == 128) {
/*       */           to_bitField0_ |= 0x80;
/*       */         }
/*       */         result.ticket_ = this.ticket_;
/*       */         if ((from_bitField0_ & 0x100) == 256) {
/*       */           to_bitField0_ |= 0x100;
/*       */         }
/*       */         result.flag_ = this.flag_;
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
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof PrepaidHandler.PayItem) {
/*       */           return mergeFrom((PrepaidHandler.PayItem)other);
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
/*       */       public Builder mergeFrom(PrepaidHandler.PayItem other) {
/*       */         if (other == PrepaidHandler.PayItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasItemNumId()) {
/*       */           setItemNumId(other.getItemNumId());
/*       */         }
/*       */         if (other.hasItemStrId()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.itemStrId_ = other.itemStrId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasItemName()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.itemName_ = other.itemName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasIcon()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.icon_ = other.icon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasDesc()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.desc_ = other.desc_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPrice()) {
/*       */           setPrice(other.getPrice());
/*       */         }
/*       */         if (other.hasDiamond()) {
/*       */           setDiamond(other.getDiamond());
/*       */         }
/*       */         if (other.hasTicket()) {
/*       */           setTicket(other.getTicket());
/*       */         }
/*       */         if (other.hasFlag()) {
/*       */           setFlag(other.getFlag());
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
/*       */       public final boolean isInitialized() {
/*       */         if (!hasItemNumId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemStrId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasItemName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasIcon()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasDesc()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasPrice()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasDiamond()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasTicket()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasFlag()) {
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
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         PrepaidHandler.PayItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PayItem)PrepaidHandler.PayItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PayItem)e.getUnfinishedMessage();
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
/*       */       public boolean hasItemNumId() {
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
/*       */       public int getItemNumId() {
/*       */         return this.itemNumId_;
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
/*       */       public Builder setItemNumId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.itemNumId_ = value;
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
/*       */       public Builder clearItemNumId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.itemNumId_ = 0;
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
/*       */       public boolean hasItemStrId() {
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
/*       */       public String getItemStrId() {
/*       */         Object ref = this.itemStrId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.itemStrId_ = s;
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
/*       */       public ByteString getItemStrIdBytes() {
/*       */         Object ref = this.itemStrId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.itemStrId_ = b;
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
/*       */       public Builder setItemStrId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.itemStrId_ = value;
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
/*       */       public Builder clearItemStrId() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.itemStrId_ = PrepaidHandler.PayItem.getDefaultInstance().getItemStrId();
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
/*       */       public Builder setItemStrIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.itemStrId_ = value;
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
/*       */       public boolean hasItemName() {
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
/*       */       public String getItemName() {
/*       */         Object ref = this.itemName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.itemName_ = s;
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
/*       */       public ByteString getItemNameBytes() {
/*       */         Object ref = this.itemName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.itemName_ = b;
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
/*       */       public Builder setItemName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.itemName_ = value;
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
/*       */       public Builder clearItemName() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.itemName_ = PrepaidHandler.PayItem.getDefaultInstance().getItemName();
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
/*       */       public Builder setItemNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.itemName_ = value;
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
/*       */       public boolean hasIcon() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearIcon() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.icon_ = PrepaidHandler.PayItem.getDefaultInstance().getIcon();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasDesc() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDesc(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDesc() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.desc_ = PrepaidHandler.PayItem.getDefaultInstance().getDesc();
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
/*       */       public Builder setDescBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasPrice() {
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
/*       */       public int getPrice() {
/*       */         return this.price_;
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
/*       */       public Builder setPrice(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.price_ = value;
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
/*       */       public Builder clearPrice() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.price_ = 0;
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
/*       */       public boolean hasDiamond() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
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
/*       */       public int getDiamond() {
/*       */         return this.diamond_;
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
/*       */       public Builder setDiamond(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.diamond_ = value;
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
/*       */       public Builder clearDiamond() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.diamond_ = 0;
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
/*       */       public boolean hasTicket() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
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
/*       */       public int getTicket() {
/*       */         return this.ticket_;
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
/*       */       public Builder setTicket(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.ticket_ = value;
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
/*       */       public Builder clearTicket() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.ticket_ = 0;
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
/*       */       public boolean hasFlag() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setFlag(int value) {
/*       */         this.bitField0_ |= 0x100;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearFlag() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.flag_ = 0;
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
/*       */   public static final class FeeItem
/*       */     extends GeneratedMessage
/*       */     implements FeeItemOrBuilder
/*       */   {
/*  4733 */     private static final FeeItem defaultInstance = new FeeItem(true); private final UnknownFieldSet unknownFields; private FeeItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FeeItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FeeItem getDefaultInstance() { return defaultInstance; } public FeeItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FeeItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.packageIcon_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.appProductId_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.packageName_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.packageDesc_ = bs; break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.packageDescFirst_ = bs; break;case 58: bs = input.readBytes(); this.bitField0_ |= 0x40; this.payMoneyType_ = bs; break;case 64: this.bitField0_ |= 0x80; this.payMoneyAmount_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x100; this.payDiamond_ = input.readInt32(); break;case 80: this.bitField0_ |= 0x200; this.firstDiamond_ = input.readInt32(); break;case 88: this.bitField0_ |= 0x400; this.nonFirstDiamond_ = input.readInt32(); break;case 96: this.bitField0_ |= 0x800; this.payCashFirst_ = input.readInt32(); break;case 104: this.bitField0_ |= 0x1000; this.payTag_ = input.readInt32(); break;case 112: this.bitField0_ |= 0x2000; this.virgin_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_FeeItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_FeeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(FeeItem.class, Builder.class); } public static Parser<FeeItem> PARSER = (Parser<FeeItem>)new AbstractParser<FeeItem>() { public PrepaidHandler.FeeItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.FeeItem(input, extensionRegistry); } }
/*  4734 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int PACKAGEICON_FIELD_NUMBER = 2; private Object packageIcon_; public static final int APPPRODUCTID_FIELD_NUMBER = 3; private Object appProductId_; public static final int PACKAGENAME_FIELD_NUMBER = 4; private Object packageName_; public static final int PACKAGEDESC_FIELD_NUMBER = 5; private Object packageDesc_; public static final int PACKAGEDESCFIRST_FIELD_NUMBER = 6; private Object packageDescFirst_; public static final int PAYMONEYTYPE_FIELD_NUMBER = 7; private Object payMoneyType_; public static final int PAYMONEYAMOUNT_FIELD_NUMBER = 8; private int payMoneyAmount_; public static final int PAYDIAMOND_FIELD_NUMBER = 9; private int payDiamond_; public static final int FIRSTDIAMOND_FIELD_NUMBER = 10; private int firstDiamond_; public static final int NONFIRSTDIAMOND_FIELD_NUMBER = 11; private int nonFirstDiamond_; public static final int PAYCASHFIRST_FIELD_NUMBER = 12; private int payCashFirst_; public static final int PAYTAG_FIELD_NUMBER = 13; private int payTag_; public static final int VIRGIN_FIELD_NUMBER = 14; private int virgin_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FeeItem> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasPackageIcon() { return ((this.bitField0_ & 0x2) == 2); } public String getPackageIcon() { Object ref = this.packageIcon_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.packageIcon_ = s;  return s; } public ByteString getPackageIconBytes() { Object ref = this.packageIcon_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.packageIcon_ = b; return b; }  return (ByteString)ref; } public boolean hasAppProductId() { return ((this.bitField0_ & 0x4) == 4); } public String getAppProductId() { Object ref = this.appProductId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.appProductId_ = s;  return s; } public ByteString getAppProductIdBytes() { Object ref = this.appProductId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.appProductId_ = b; return b; }  return (ByteString)ref; } public boolean hasPackageName() { return ((this.bitField0_ & 0x8) == 8); } public String getPackageName() { Object ref = this.packageName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.packageName_ = s;  return s; } public ByteString getPackageNameBytes() { Object ref = this.packageName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.packageName_ = b; return b; }  return (ByteString)ref; } public boolean hasPackageDesc() { return ((this.bitField0_ & 0x10) == 16); } public String getPackageDesc() { Object ref = this.packageDesc_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.packageDesc_ = s;  return s; } public ByteString getPackageDescBytes() { Object ref = this.packageDesc_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.packageDesc_ = b; return b; }  return (ByteString)ref; } public boolean hasPackageDescFirst() { return ((this.bitField0_ & 0x20) == 32); } public String getPackageDescFirst() { Object ref = this.packageDescFirst_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.packageDescFirst_ = s;  return s; } public ByteString getPackageDescFirstBytes() { Object ref = this.packageDescFirst_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.packageDescFirst_ = b; return b; }  return (ByteString)ref; } public boolean hasPayMoneyType() { return ((this.bitField0_ & 0x40) == 64); } public String getPayMoneyType() { Object ref = this.payMoneyType_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.payMoneyType_ = s;  return s; } public ByteString getPayMoneyTypeBytes() { Object ref = this.payMoneyType_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.payMoneyType_ = b; return b; }  return (ByteString)ref; } public boolean hasPayMoneyAmount() { return ((this.bitField0_ & 0x80) == 128); } public int getPayMoneyAmount() { return this.payMoneyAmount_; } public boolean hasPayDiamond() { return ((this.bitField0_ & 0x100) == 256); } public int getPayDiamond() { return this.payDiamond_; } public boolean hasFirstDiamond() { return ((this.bitField0_ & 0x200) == 512); } public int getFirstDiamond() { return this.firstDiamond_; } public boolean hasNonFirstDiamond() { return ((this.bitField0_ & 0x400) == 1024); } public int getNonFirstDiamond() { return this.nonFirstDiamond_; } public boolean hasPayCashFirst() { return ((this.bitField0_ & 0x800) == 2048); } public int getPayCashFirst() { return this.payCashFirst_; } public boolean hasPayTag() { return ((this.bitField0_ & 0x1000) == 4096); } static { defaultInstance.initFields(); }
/*       */     public int getPayTag() { return this.payTag_; }
/*       */     public boolean hasVirgin() { return ((this.bitField0_ & 0x2000) == 8192); }
/*       */     public int getVirgin() { return this.virgin_; }
/*       */     private void initFields() { this.id_ = 0; this.packageIcon_ = ""; this.appProductId_ = ""; this.packageName_ = ""; this.packageDesc_ = ""; this.packageDescFirst_ = ""; this.payMoneyType_ = ""; this.payMoneyAmount_ = 0; this.payDiamond_ = 0; this.firstDiamond_ = 0; this.nonFirstDiamond_ = 0; this.payCashFirst_ = 0; this.payTag_ = 0; this.virgin_ = 0; }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPackageIcon()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasAppProductId()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPackageName()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPackageDesc()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPackageDescFirst()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPayMoneyType()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPayMoneyAmount()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPayDiamond()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasFirstDiamond()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasNonFirstDiamond()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPayCashFirst()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasPayTag()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  if (!hasVirgin()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getPackageIconBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeBytes(3, getAppProductIdBytes());  if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeBytes(4, getPackageNameBytes());  if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeBytes(5, getPackageDescBytes());  if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeBytes(6, getPackageDescFirstBytes());  if ((this.bitField0_ & 0x40) == 64)
/*       */         output.writeBytes(7, getPayMoneyTypeBytes());  if ((this.bitField0_ & 0x80) == 128)
/*       */         output.writeInt32(8, this.payMoneyAmount_);  if ((this.bitField0_ & 0x100) == 256)
/*       */         output.writeInt32(9, this.payDiamond_);  if ((this.bitField0_ & 0x200) == 512)
/*       */         output.writeInt32(10, this.firstDiamond_);  if ((this.bitField0_ & 0x400) == 1024)
/*       */         output.writeInt32(11, this.nonFirstDiamond_);  if ((this.bitField0_ & 0x800) == 2048)
/*       */         output.writeInt32(12, this.payCashFirst_);  if ((this.bitField0_ & 0x1000) == 4096)
/*       */         output.writeInt32(13, this.payTag_);  if ((this.bitField0_ & 0x2000) == 8192)
/*       */         output.writeInt32(14, this.virgin_);  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getPackageIconBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBytesSize(3, getAppProductIdBytes());  if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeBytesSize(4, getPackageNameBytes());  if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeBytesSize(5, getPackageDescBytes());  if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeBytesSize(6, getPackageDescFirstBytes());  if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeBytesSize(7, getPayMoneyTypeBytes());  if ((this.bitField0_ & 0x80) == 128)
/*       */         size += CodedOutputStream.computeInt32Size(8, this.payMoneyAmount_); 
/*       */       if ((this.bitField0_ & 0x100) == 256)
/*       */         size += CodedOutputStream.computeInt32Size(9, this.payDiamond_); 
/*       */       if ((this.bitField0_ & 0x200) == 512)
/*       */         size += CodedOutputStream.computeInt32Size(10, this.firstDiamond_); 
/*       */       if ((this.bitField0_ & 0x400) == 1024)
/*       */         size += CodedOutputStream.computeInt32Size(11, this.nonFirstDiamond_); 
/*       */       if ((this.bitField0_ & 0x800) == 2048)
/*       */         size += CodedOutputStream.computeInt32Size(12, this.payCashFirst_); 
/*       */       if ((this.bitField0_ & 0x1000) == 4096)
/*       */         size += CodedOutputStream.computeInt32Size(13, this.payTag_); 
/*       */       if ((this.bitField0_ & 0x2000) == 8192)
/*       */         size += CodedOutputStream.computeInt32Size(14, this.virgin_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static FeeItem parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FeeItem)PARSER.parseFrom(data); }
/*       */     public static FeeItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FeeItem)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static FeeItem parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FeeItem)PARSER.parseFrom(data); }
/*       */     public static FeeItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FeeItem)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static FeeItem parseFrom(InputStream input) throws IOException { return (FeeItem)PARSER.parseFrom(input); }
/*       */     public static FeeItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FeeItem)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static FeeItem parseDelimitedFrom(InputStream input) throws IOException { return (FeeItem)PARSER.parseDelimitedFrom(input); }
/*       */     public static FeeItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FeeItem)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static FeeItem parseFrom(CodedInputStream input) throws IOException { return (FeeItem)PARSER.parseFrom(input); }
/*       */     public static FeeItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FeeItem)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(FeeItem prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.FeeItemOrBuilder {
/*       */       private int bitField0_;
/*       */       private int id_;
/*       */       private Object packageIcon_;
/*       */       private Object appProductId_;
/*       */       private Object packageName_;
/*       */       private Object packageDesc_;
/*       */       private Object packageDescFirst_;
/*       */       private Object payMoneyType_;
/*       */       private int payMoneyAmount_;
/*       */       private int payDiamond_;
/*       */       private int firstDiamond_;
/*       */       private int nonFirstDiamond_;
/*       */       private int payCashFirst_;
/*       */       private int payTag_;
/*       */       private int virgin_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_FeeItem_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_FeeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.FeeItem.class, Builder.class); }
/*       */       private Builder() { this.packageIcon_ = "";
/*       */         this.appProductId_ = "";
/*       */         this.packageName_ = "";
/*       */         this.packageDesc_ = "";
/*       */         this.packageDescFirst_ = "";
/*       */         this.payMoneyType_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.packageIcon_ = "";
/*       */         this.appProductId_ = "";
/*       */         this.packageName_ = "";
/*       */         this.packageDesc_ = "";
/*       */         this.packageDescFirst_ = "";
/*       */         this.payMoneyType_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (PrepaidHandler.FeeItem.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.packageIcon_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.appProductId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.packageName_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.packageDesc_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.packageDescFirst_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.payMoneyType_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.payMoneyAmount_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.payDiamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.firstDiamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.nonFirstDiamond_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.payCashFirst_ = 0;
/*       */         this.bitField0_ &= 0xFFFFF7FF;
/*       */         this.payTag_ = 0;
/*       */         this.bitField0_ &= 0xFFFFEFFF;
/*       */         this.virgin_ = 0;
/*       */         this.bitField0_ &= 0xFFFFDFFF;
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_FeeItem_descriptor; }
/*       */       public PrepaidHandler.FeeItem getDefaultInstanceForType() { return PrepaidHandler.FeeItem.getDefaultInstance(); }
/*       */       public PrepaidHandler.FeeItem build() { PrepaidHandler.FeeItem result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public PrepaidHandler.FeeItem buildPartial() { PrepaidHandler.FeeItem result = new PrepaidHandler.FeeItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.packageIcon_ = this.packageIcon_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.appProductId_ = this.appProductId_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.packageName_ = this.packageName_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.packageDesc_ = this.packageDesc_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.packageDescFirst_ = this.packageDescFirst_;
/*       */         if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40; 
/*       */         result.payMoneyType_ = this.payMoneyType_;
/*       */         if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x80; 
/*       */         result.payMoneyAmount_ = this.payMoneyAmount_;
/*       */         if ((from_bitField0_ & 0x100) == 256)
/*       */           to_bitField0_ |= 0x100; 
/*       */         result.payDiamond_ = this.payDiamond_;
/*       */         if ((from_bitField0_ & 0x200) == 512)
/*       */           to_bitField0_ |= 0x200; 
/*       */         result.firstDiamond_ = this.firstDiamond_;
/*       */         if ((from_bitField0_ & 0x400) == 1024)
/*       */           to_bitField0_ |= 0x400; 
/*       */         result.nonFirstDiamond_ = this.nonFirstDiamond_;
/*       */         if ((from_bitField0_ & 0x800) == 2048)
/*       */           to_bitField0_ |= 0x800; 
/*       */         result.payCashFirst_ = this.payCashFirst_;
/*       */         if ((from_bitField0_ & 0x1000) == 4096)
/*       */           to_bitField0_ |= 0x1000; 
/*       */         result.payTag_ = this.payTag_;
/*       */         if ((from_bitField0_ & 0x2000) == 8192)
/*       */           to_bitField0_ |= 0x2000; 
/*       */         result.virgin_ = this.virgin_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.FeeItem)
/*       */           return mergeFrom((PrepaidHandler.FeeItem)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(PrepaidHandler.FeeItem other) { if (other == PrepaidHandler.FeeItem.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasId())
/*       */           setId(other.getId()); 
/*       */         if (other.hasPackageIcon()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.packageIcon_ = other.packageIcon_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasAppProductId()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.appProductId_ = other.appProductId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPackageName()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.packageName_ = other.packageName_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPackageDesc()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.packageDesc_ = other.packageDesc_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPackageDescFirst()) {
/*       */           this.bitField0_ |= 0x20;
/*       */           this.packageDescFirst_ = other.packageDescFirst_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPayMoneyType()) {
/*       */           this.bitField0_ |= 0x40;
/*       */           this.payMoneyType_ = other.payMoneyType_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasPayMoneyAmount())
/*       */           setPayMoneyAmount(other.getPayMoneyAmount()); 
/*       */         if (other.hasPayDiamond())
/*       */           setPayDiamond(other.getPayDiamond()); 
/*       */         if (other.hasFirstDiamond())
/*       */           setFirstDiamond(other.getFirstDiamond()); 
/*       */         if (other.hasNonFirstDiamond())
/*       */           setNonFirstDiamond(other.getNonFirstDiamond()); 
/*       */         if (other.hasPayCashFirst())
/*       */           setPayCashFirst(other.getPayCashFirst()); 
/*       */         if (other.hasPayTag())
/*       */           setPayTag(other.getPayTag()); 
/*       */         if (other.hasVirgin())
/*       */           setVirgin(other.getVirgin()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasId())
/*       */           return false; 
/*       */         if (!hasPackageIcon())
/*       */           return false; 
/*       */         if (!hasAppProductId())
/*       */           return false; 
/*       */         if (!hasPackageName())
/*       */           return false; 
/*       */         if (!hasPackageDesc())
/*       */           return false; 
/*       */         if (!hasPackageDescFirst())
/*       */           return false; 
/*       */         if (!hasPayMoneyType())
/*       */           return false; 
/*       */         if (!hasPayMoneyAmount())
/*       */           return false; 
/*       */         if (!hasPayDiamond())
/*       */           return false; 
/*       */         if (!hasFirstDiamond())
/*       */           return false; 
/*       */         if (!hasNonFirstDiamond())
/*       */           return false; 
/*       */         if (!hasPayCashFirst())
/*       */           return false; 
/*       */         if (!hasPayTag())
/*       */           return false; 
/*       */         if (!hasVirgin())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.FeeItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.FeeItem)PrepaidHandler.FeeItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.FeeItem)e.getUnfinishedMessage();
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
/*       */       public boolean hasPackageIcon() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getPackageIcon() { Object ref = this.packageIcon_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.packageIcon_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getPackageIconBytes() { Object ref = this.packageIcon_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.packageIcon_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setPackageIcon(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.packageIcon_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPackageIcon() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.packageIcon_ = PrepaidHandler.FeeItem.getDefaultInstance().getPackageIcon();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setPackageIconBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.packageIcon_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasAppProductId() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public String getAppProductId() { Object ref = this.appProductId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.appProductId_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getAppProductIdBytes() { Object ref = this.appProductId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.appProductId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setAppProductId(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.appProductId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearAppProductId() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.appProductId_ = PrepaidHandler.FeeItem.getDefaultInstance().getAppProductId();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setAppProductIdBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.appProductId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPackageName() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public String getPackageName() { Object ref = this.packageName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.packageName_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getPackageNameBytes() { Object ref = this.packageName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.packageName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setPackageName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.packageName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPackageName() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.packageName_ = PrepaidHandler.FeeItem.getDefaultInstance().getPackageName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setPackageNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.packageName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPackageDesc() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public String getPackageDesc() { Object ref = this.packageDesc_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.packageDesc_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getPackageDescBytes() { Object ref = this.packageDesc_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.packageDesc_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setPackageDesc(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.packageDesc_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPackageDesc() { this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.packageDesc_ = PrepaidHandler.FeeItem.getDefaultInstance().getPackageDesc();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setPackageDescBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.packageDesc_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPackageDescFirst() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public String getPackageDescFirst() { Object ref = this.packageDescFirst_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.packageDescFirst_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getPackageDescFirstBytes() { Object ref = this.packageDescFirst_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.packageDescFirst_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setPackageDescFirst(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x20;
/*       */         this.packageDescFirst_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPackageDescFirst() { this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.packageDescFirst_ = PrepaidHandler.FeeItem.getDefaultInstance().getPackageDescFirst();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setPackageDescFirstBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x20;
/*       */         this.packageDescFirst_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPayMoneyType() { return ((this.bitField0_ & 0x40) == 64); }
/*       */       public String getPayMoneyType() { Object ref = this.payMoneyType_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.payMoneyType_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getPayMoneyTypeBytes() { Object ref = this.payMoneyType_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.payMoneyType_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setPayMoneyType(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.payMoneyType_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPayMoneyType() { this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.payMoneyType_ = PrepaidHandler.FeeItem.getDefaultInstance().getPayMoneyType();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setPayMoneyTypeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.payMoneyType_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPayMoneyAmount() { return ((this.bitField0_ & 0x80) == 128); }
/*       */       public int getPayMoneyAmount() { return this.payMoneyAmount_; }
/*       */       public Builder setPayMoneyAmount(int value) { this.bitField0_ |= 0x80;
/*       */         this.payMoneyAmount_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPayMoneyAmount() { this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.payMoneyAmount_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasPayDiamond() { return ((this.bitField0_ & 0x100) == 256); }
/*       */       public int getPayDiamond() { return this.payDiamond_; }
/*       */       public Builder setPayDiamond(int value) { this.bitField0_ |= 0x100;
/*       */         this.payDiamond_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearPayDiamond() { this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.payDiamond_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasFirstDiamond() { return ((this.bitField0_ & 0x200) == 512); }
/*       */       public int getFirstDiamond() { return this.firstDiamond_; } public Builder setFirstDiamond(int value) { this.bitField0_ |= 0x200;
/*       */         this.firstDiamond_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearFirstDiamond() { this.bitField0_ &= 0xFFFFFDFF;
/*       */         this.firstDiamond_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasNonFirstDiamond() { return ((this.bitField0_ & 0x400) == 1024); } public int getNonFirstDiamond() { return this.nonFirstDiamond_; } public Builder setNonFirstDiamond(int value) { this.bitField0_ |= 0x400;
/*       */         this.nonFirstDiamond_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearNonFirstDiamond() { this.bitField0_ &= 0xFFFFFBFF;
/*       */         this.nonFirstDiamond_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasPayCashFirst() { return ((this.bitField0_ & 0x800) == 2048); } public int getPayCashFirst() { return this.payCashFirst_; } public Builder setPayCashFirst(int value) { this.bitField0_ |= 0x800;
/*       */         this.payCashFirst_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearPayCashFirst() { this.bitField0_ &= 0xFFFFF7FF;
/*       */         this.payCashFirst_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasPayTag() { return ((this.bitField0_ & 0x1000) == 4096); } public int getPayTag() { return this.payTag_; } public Builder setPayTag(int value) { this.bitField0_ |= 0x1000;
/*       */         this.payTag_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearPayTag() { this.bitField0_ &= 0xFFFFEFFF;
/*       */         this.payTag_ = 0;
/*       */         onChanged();
/*       */         return this; } public boolean hasVirgin() { return ((this.bitField0_ & 0x2000) == 8192); } public int getVirgin() { return this.virgin_; } public Builder setVirgin(int value) { this.bitField0_ |= 0x2000;
/*       */         this.virgin_ = value;
/*       */         onChanged();
/*       */         return this; } public Builder clearVirgin() { this.bitField0_ &= 0xFFFFDFFF;
/*       */         this.virgin_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */     }
/*       */   } public static final class PayAward extends GeneratedMessage implements PayAwardOrBuilder {
/*  5303 */     private static final PayAward defaultInstance = new PayAward(true); private final UnknownFieldSet unknownFields; private PayAward(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PayAward(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PayAward getDefaultInstance() { return defaultInstance; } public PayAward getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PayAward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.code_ = bs; break;case 16: this.bitField0_ |= 0x2; this.groupCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PayAward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PayAward_fieldAccessorTable.ensureFieldAccessorsInitialized(PayAward.class, Builder.class); } public static Parser<PayAward> PARSER = (Parser<PayAward>)new AbstractParser<PayAward>() { public PrepaidHandler.PayAward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PayAward(input, extensionRegistry); } }; private int bitField0_; public static final int CODE_FIELD_NUMBER = 1; private Object code_; public static final int GROUPCOUNT_FIELD_NUMBER = 2; private int groupCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PayAward> getParserForType() { return PARSER; } public boolean hasCode() { return ((this.bitField0_ & 0x1) == 1); } public String getCode() { Object ref = this.code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } public boolean hasGroupCount() { return ((this.bitField0_ & 0x2) == 2); } public int getGroupCount() { return this.groupCount_; } private void initFields() { this.code_ = ""; this.groupCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasGroupCount()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getCodeBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.groupCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getCodeBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.groupCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PayAward parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PayAward)PARSER.parseFrom(data); } public static PayAward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PayAward)PARSER.parseFrom(data, extensionRegistry); } public static PayAward parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PayAward)PARSER.parseFrom(data); } public static PayAward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PayAward)PARSER.parseFrom(data, extensionRegistry); } public static PayAward parseFrom(InputStream input) throws IOException { return (PayAward)PARSER.parseFrom(input); } public static PayAward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PayAward)PARSER.parseFrom(input, extensionRegistry); } public static PayAward parseDelimitedFrom(InputStream input) throws IOException { return (PayAward)PARSER.parseDelimitedFrom(input); } public static PayAward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PayAward)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PayAward parseFrom(CodedInputStream input) throws IOException { return (PayAward)PARSER.parseFrom(input); } public static PayAward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PayAward)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PayAward prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PayAwardOrBuilder {
/*  5304 */       private int bitField0_; private Object code_; private int groupCount_; public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PayAward_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PayAward_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PayAward.class, Builder.class); } private Builder() { this.code_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.code_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PayAward.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.code_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.groupCount_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PayAward_descriptor; } public PrepaidHandler.PayAward getDefaultInstanceForType() { return PrepaidHandler.PayAward.getDefaultInstance(); } public PrepaidHandler.PayAward build() { PrepaidHandler.PayAward result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PayAward buildPartial() { PrepaidHandler.PayAward result = new PrepaidHandler.PayAward(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.code_ = this.code_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.groupCount_ = this.groupCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PayAward) return mergeFrom((PrepaidHandler.PayAward)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PayAward other) { if (other == PrepaidHandler.PayAward.getDefaultInstance()) return this;  if (other.hasCode()) { this.bitField0_ |= 0x1; this.code_ = other.code_; onChanged(); }  if (other.hasGroupCount()) setGroupCount(other.getGroupCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasCode()) return false;  if (!hasGroupCount()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PayAward parsedMessage = null; try { parsedMessage = (PrepaidHandler.PayAward)PrepaidHandler.PayAward.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PayAward)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasCode() { return ((this.bitField0_ & 0x1) == 1); } public String getCode() { Object ref = this.code_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; }  return (String)ref; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } public Builder setCode(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.code_ = value; onChanged(); return this; } public Builder clearCode() { this.bitField0_ &= 0xFFFFFFFE; this.code_ = PrepaidHandler.PayAward.getDefaultInstance().getCode(); onChanged(); return this; } public Builder setCodeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.code_ = value; onChanged(); return this; } public boolean hasGroupCount() { return ((this.bitField0_ & 0x2) == 2); } public int getGroupCount() { return this.groupCount_; } public Builder setGroupCount(int value) { this.bitField0_ |= 0x2; this.groupCount_ = value; onChanged(); return this; } public Builder clearGroupCount() { this.bitField0_ &= 0xFFFFFFFD; this.groupCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PrepaidListRequest
/*       */     extends GeneratedMessage
/*       */     implements PrepaidListRequestOrBuilder
/*       */   {
/*  5616 */     private static final PrepaidListRequest defaultInstance = new PrepaidListRequest(true); private final UnknownFieldSet unknownFields; private PrepaidListRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidListRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidListRequest getDefaultInstance() { return defaultInstance; } public PrepaidListRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidListRequest.class, Builder.class); } public static Parser<PrepaidListRequest> PARSER = (Parser<PrepaidListRequest>)new AbstractParser<PrepaidListRequest>() { public PrepaidHandler.PrepaidListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidListRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidListRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidListRequest)PARSER.parseFrom(data); } public static PrepaidListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidListRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidListRequest)PARSER.parseFrom(data); } public static PrepaidListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidListRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidListRequest parseFrom(InputStream input) throws IOException { return (PrepaidListRequest)PARSER.parseFrom(input); } public static PrepaidListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListRequest)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidListRequest parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidListRequest)PARSER.parseDelimitedFrom(input); } public static PrepaidListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidListRequest parseFrom(CodedInputStream input) throws IOException { return (PrepaidListRequest)PARSER.parseFrom(input); } public static PrepaidListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidListRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidListRequestOrBuilder {
/*  5617 */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidListRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidListRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListRequest_descriptor; } public PrepaidHandler.PrepaidListRequest getDefaultInstanceForType() { return PrepaidHandler.PrepaidListRequest.getDefaultInstance(); } public PrepaidHandler.PrepaidListRequest build() { PrepaidHandler.PrepaidListRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidListRequest buildPartial() { PrepaidHandler.PrepaidListRequest result = new PrepaidHandler.PrepaidListRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidListRequest) return mergeFrom((PrepaidHandler.PrepaidListRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidListRequest other) { if (other == PrepaidHandler.PrepaidListRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidListRequest parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidListRequest)PrepaidHandler.PrepaidListRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidListRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PrepaidListResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidListResponseOrBuilder
/*       */   {
/*  6550 */     private static final PrepaidListResponse defaultInstance = new PrepaidListResponse(true); private final UnknownFieldSet unknownFields; private PrepaidListResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidListResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidListResponse getDefaultInstance() { return defaultInstance; } public PrepaidListResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CItems_.add(input.readMessage(PrepaidHandler.FeeItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidListResponse.class, Builder.class); } public static Parser<PrepaidListResponse> PARSER = (Parser<PrepaidListResponse>)new AbstractParser<PrepaidListResponse>() { public PrepaidHandler.PrepaidListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidListResponse(input, extensionRegistry); } }
/*  6551 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_ITEMS_FIELD_NUMBER = 3; private List<PrepaidHandler.FeeItem> s2CItems_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidListResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public List<PrepaidHandler.FeeItem> getS2CItemsList() { return this.s2CItems_; }
/*       */     public List<? extends PrepaidHandler.FeeItemOrBuilder> getS2CItemsOrBuilderList() { return (List)this.s2CItems_; }
/*       */     public int getS2CItemsCount() { return this.s2CItems_.size(); }
/*       */     public PrepaidHandler.FeeItem getS2CItems(int index) { return this.s2CItems_.get(index); }
/*       */     public PrepaidHandler.FeeItemOrBuilder getS2CItemsOrBuilder(int index) { return this.s2CItems_.get(index); }
/*       */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CItems_ = Collections.emptyList(); }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  for (int i = 0; i < getS2CItemsCount(); i++) {
/*       */         if (!getS2CItems(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0; return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.s2CItems_.get(i)); 
/*       */       getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CItems_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static PrepaidListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidListResponse)PARSER.parseFrom(data); }
/*       */     public static PrepaidListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidListResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static PrepaidListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidListResponse)PARSER.parseFrom(data); }
/*       */     public static PrepaidListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidListResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static PrepaidListResponse parseFrom(InputStream input) throws IOException { return (PrepaidListResponse)PARSER.parseFrom(input); }
/*       */     public static PrepaidListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static PrepaidListResponse parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidListResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static PrepaidListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static PrepaidListResponse parseFrom(CodedInputStream input) throws IOException { return (PrepaidListResponse)PARSER.parseFrom(input); }
/*       */     public static PrepaidListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidListResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(PrepaidListResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidListResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<PrepaidHandler.FeeItem> s2CItems_; private RepeatedFieldBuilder<PrepaidHandler.FeeItem, PrepaidHandler.FeeItem.Builder, PrepaidHandler.FeeItemOrBuilder> s2CItemsBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidListResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = "";
/*       */         this.s2CItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidListResponse.alwaysUseFieldBuilders)
/*       */           getS2CItemsFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CItemsBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidListResponse_descriptor; }
/*       */       public PrepaidHandler.PrepaidListResponse getDefaultInstanceForType() { return PrepaidHandler.PrepaidListResponse.getDefaultInstance(); }
/*       */       public PrepaidHandler.PrepaidListResponse build() { PrepaidHandler.PrepaidListResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public PrepaidHandler.PrepaidListResponse buildPartial() { PrepaidHandler.PrepaidListResponse result = new PrepaidHandler.PrepaidListResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CItems_ = this.s2CItems_;
/*       */         } else {
/*       */           result.s2CItems_ = this.s2CItemsBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidListResponse)
/*       */           return mergeFrom((PrepaidHandler.PrepaidListResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidListResponse other) { if (other == PrepaidHandler.PrepaidListResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if (!other.s2CItems_.isEmpty()) {
/*       */             if (this.s2CItems_.isEmpty()) {
/*       */               this.s2CItems_ = other.s2CItems_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CItemsIsMutable();
/*       */               this.s2CItems_.addAll(other.s2CItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CItems_.isEmpty()) {
/*       */           if (this.s2CItemsBuilder_.isEmpty()) {
/*       */             this.s2CItemsBuilder_.dispose();
/*       */             this.s2CItemsBuilder_ = null;
/*       */             this.s2CItems_ = other.s2CItems_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CItemsBuilder_ = PrepaidHandler.PrepaidListResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getS2CItemsCount(); i++) {
/*       */           if (!getS2CItems(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidListResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PrepaidListResponse)PrepaidHandler.PrepaidListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PrepaidListResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = PrepaidHandler.PrepaidListResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureS2CItemsIsMutable() { if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CItems_ = new ArrayList<>(this.s2CItems_);
/*       */           this.bitField0_ |= 0x4;
/*       */         }  }
/*       */       public List<PrepaidHandler.FeeItem> getS2CItemsList() { if (this.s2CItemsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CItems_); 
/*       */         return this.s2CItemsBuilder_.getMessageList(); }
/*       */       public int getS2CItemsCount() { if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.size(); 
/*       */         return this.s2CItemsBuilder_.getCount(); }
/*       */       public PrepaidHandler.FeeItem getS2CItems(int index) { if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.get(index); 
/*       */         return (PrepaidHandler.FeeItem)this.s2CItemsBuilder_.getMessage(index); }
/*       */       public Builder setS2CItems(int index, PrepaidHandler.FeeItem value) { if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setS2CItems(int index, PrepaidHandler.FeeItem.Builder builderForValue) { if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CItems(PrepaidHandler.FeeItem value) { if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CItems(int index, PrepaidHandler.FeeItem value) { if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CItems(PrepaidHandler.FeeItem.Builder builderForValue) { if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addS2CItems(int index, PrepaidHandler.FeeItem.Builder builderForValue) { if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllS2CItems(Iterable<? extends PrepaidHandler.FeeItem> values) { if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearS2CItems() { if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeS2CItems(int index) { if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public PrepaidHandler.FeeItem.Builder getS2CItemsBuilder(int index) { return (PrepaidHandler.FeeItem.Builder)getS2CItemsFieldBuilder().getBuilder(index); }
/*       */       public PrepaidHandler.FeeItemOrBuilder getS2CItemsOrBuilder(int index) { if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.get(index); 
/*       */         return (PrepaidHandler.FeeItemOrBuilder)this.s2CItemsBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends PrepaidHandler.FeeItemOrBuilder> getS2CItemsOrBuilderList() { if (this.s2CItemsBuilder_ != null)
/*       */           return this.s2CItemsBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CItems_); }
/*       */       public PrepaidHandler.FeeItem.Builder addS2CItemsBuilder() { return (PrepaidHandler.FeeItem.Builder)getS2CItemsFieldBuilder().addBuilder(PrepaidHandler.FeeItem.getDefaultInstance()); }
/*       */       public PrepaidHandler.FeeItem.Builder addS2CItemsBuilder(int index) { return (PrepaidHandler.FeeItem.Builder)getS2CItemsFieldBuilder().addBuilder(index, PrepaidHandler.FeeItem.getDefaultInstance()); }
/*       */       public List<PrepaidHandler.FeeItem.Builder> getS2CItemsBuilderList() { return getS2CItemsFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<PrepaidHandler.FeeItem, PrepaidHandler.FeeItem.Builder, PrepaidHandler.FeeItemOrBuilder> getS2CItemsFieldBuilder() { if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CItems_ = null;
/*       */         } 
/*       */         return this.s2CItemsBuilder_; } } }
/*  6863 */   public static final class PrepaidAwardRequest extends GeneratedMessage implements PrepaidAwardRequestOrBuilder { private static final PrepaidAwardRequest defaultInstance = new PrepaidAwardRequest(true); private final UnknownFieldSet unknownFields; private PrepaidAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidAwardRequest getDefaultInstance() { return defaultInstance; } public PrepaidAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidAwardRequest.class, Builder.class); } public static Parser<PrepaidAwardRequest> PARSER = (Parser<PrepaidAwardRequest>)new AbstractParser<PrepaidAwardRequest>() { public PrepaidHandler.PrepaidAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidAwardRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidAwardRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidAwardRequest)PARSER.parseFrom(data); } public static PrepaidAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidAwardRequest)PARSER.parseFrom(data); } public static PrepaidAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAwardRequest parseFrom(InputStream input) throws IOException { return (PrepaidAwardRequest)PARSER.parseFrom(input); } public static PrepaidAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidAwardRequest parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidAwardRequest)PARSER.parseDelimitedFrom(input); } public static PrepaidAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidAwardRequest parseFrom(CodedInputStream input) throws IOException { return (PrepaidAwardRequest)PARSER.parseFrom(input); } public static PrepaidAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidAwardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidAwardRequestOrBuilder {
/*  6864 */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidAwardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidAwardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardRequest_descriptor; } public PrepaidHandler.PrepaidAwardRequest getDefaultInstanceForType() { return PrepaidHandler.PrepaidAwardRequest.getDefaultInstance(); } public PrepaidHandler.PrepaidAwardRequest build() { PrepaidHandler.PrepaidAwardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidAwardRequest buildPartial() { PrepaidHandler.PrepaidAwardRequest result = new PrepaidHandler.PrepaidAwardRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidAwardRequest) return mergeFrom((PrepaidHandler.PrepaidAwardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidAwardRequest other) { if (other == PrepaidHandler.PrepaidAwardRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidAwardRequest parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidAwardRequest)PrepaidHandler.PrepaidAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidAwardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class PrepaidAwardResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidAwardResponseOrBuilder
/*       */   {
/*  7915 */     private static final PrepaidAwardResponse defaultInstance = new PrepaidAwardResponse(true); private final UnknownFieldSet unknownFields; private PrepaidAwardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidAwardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidAwardResponse getDefaultInstance() { return defaultInstance; } public PrepaidAwardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CItems_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CItems_.add(input.readMessage(PrepaidHandler.PayAward.PARSER, extensionRegistry)); break;case 32: this.bitField0_ |= 0x4; this.s2CIsGet_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidAwardResponse.class, Builder.class); } public static Parser<PrepaidAwardResponse> PARSER = (Parser<PrepaidAwardResponse>)new AbstractParser<PrepaidAwardResponse>() { public PrepaidHandler.PrepaidAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidAwardResponse(input, extensionRegistry); } }
/*  7916 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_ITEMS_FIELD_NUMBER = 3; private List<PrepaidHandler.PayAward> s2CItems_; public static final int S2C_ISGET_FIELD_NUMBER = 4; private int s2CIsGet_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidAwardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */      public List<PrepaidHandler.PayAward> getS2CItemsList() {
/*       */       return this.s2CItems_;
/*       */     } public List<? extends PrepaidHandler.PayAwardOrBuilder> getS2CItemsOrBuilderList() {
/*       */       return (List)this.s2CItems_;
/*       */     } public int getS2CItemsCount() {
/*       */       return this.s2CItems_.size();
/*       */     } public PrepaidHandler.PayAward getS2CItems(int index) {
/*       */       return this.s2CItems_.get(index);
/*       */     } public PrepaidHandler.PayAwardOrBuilder getS2CItemsOrBuilder(int index) {
/*       */       return this.s2CItems_.get(index);
/*       */     } public boolean hasS2CIsGet() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public int getS2CIsGet() {
/*       */       return this.s2CIsGet_;
/*       */     } private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CItems_ = Collections.emptyList();
/*       */       this.s2CIsGet_ = 0;
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
/*       */       if (!hasS2CIsGet()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getS2CItemsCount(); i++) {
/*       */         if (!getS2CItems(i).isInitialized()) {
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
/*       */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.s2CItems_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(4, this.s2CIsGet_); 
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
/*       */       for (int i = 0; i < this.s2CItems_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CItems_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.s2CIsGet_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static PrepaidAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(data);
/*       */     } public static PrepaidAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static PrepaidAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(data);
/*       */     } public static PrepaidAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static PrepaidAwardResponse parseFrom(InputStream input) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(input);
/*       */     } public static PrepaidAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static PrepaidAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseDelimitedFrom(input);
/*       */     } public static PrepaidAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     } public static PrepaidAwardResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(input);
/*       */     } public static PrepaidAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidAwardResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(PrepaidAwardResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidAwardResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<PrepaidHandler.PayAward> s2CItems_; private RepeatedFieldBuilder<PrepaidHandler.PayAward, PrepaidHandler.PayAward.Builder, PrepaidHandler.PayAwardOrBuilder> s2CItemsBuilder_; private int s2CIsGet_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardResponse_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidAwardResponse.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CItems_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (PrepaidHandler.PrepaidAwardResponse.alwaysUseFieldBuilders)
/*       */           getS2CItemsFieldBuilder(); 
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
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.s2CItemsBuilder_.clear();
/*       */         } 
/*       */         this.s2CIsGet_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidAwardResponse_descriptor;
/*       */       }
/*       */       public PrepaidHandler.PrepaidAwardResponse getDefaultInstanceForType() {
/*       */         return PrepaidHandler.PrepaidAwardResponse.getDefaultInstance();
/*       */       }
/*       */       public PrepaidHandler.PrepaidAwardResponse build() {
/*       */         PrepaidHandler.PrepaidAwardResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public PrepaidHandler.PrepaidAwardResponse buildPartial() {
/*       */         PrepaidHandler.PrepaidAwardResponse result = new PrepaidHandler.PrepaidAwardResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.s2CItems_ = this.s2CItems_;
/*       */         } else {
/*       */           result.s2CItems_ = this.s2CItemsBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.s2CIsGet_ = this.s2CIsGet_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof PrepaidHandler.PrepaidAwardResponse)
/*       */           return mergeFrom((PrepaidHandler.PrepaidAwardResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidAwardResponse other) {
/*       */         if (other == PrepaidHandler.PrepaidAwardResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if (!other.s2CItems_.isEmpty()) {
/*       */             if (this.s2CItems_.isEmpty()) {
/*       */               this.s2CItems_ = other.s2CItems_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureS2CItemsIsMutable();
/*       */               this.s2CItems_.addAll(other.s2CItems_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.s2CItems_.isEmpty()) {
/*       */           if (this.s2CItemsBuilder_.isEmpty()) {
/*       */             this.s2CItemsBuilder_.dispose();
/*       */             this.s2CItemsBuilder_ = null;
/*       */             this.s2CItems_ = other.s2CItems_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.s2CItemsBuilder_ = PrepaidHandler.PrepaidAwardResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasS2CIsGet())
/*       */           setS2CIsGet(other.getS2CIsGet()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         if (!hasS2CIsGet())
/*       */           return false; 
/*       */         for (int i = 0; i < getS2CItemsCount(); i++) {
/*       */           if (!getS2CItems(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         PrepaidHandler.PrepaidAwardResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PrepaidAwardResponse)PrepaidHandler.PrepaidAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PrepaidAwardResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = PrepaidHandler.PrepaidAwardResponse.getDefaultInstance().getS2CMsg();
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
/*       */       private void ensureS2CItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.s2CItems_ = new ArrayList<>(this.s2CItems_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       public List<PrepaidHandler.PayAward> getS2CItemsList() {
/*       */         if (this.s2CItemsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.s2CItems_); 
/*       */         return this.s2CItemsBuilder_.getMessageList();
/*       */       }
/*       */       public int getS2CItemsCount() {
/*       */         if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.size(); 
/*       */         return this.s2CItemsBuilder_.getCount();
/*       */       }
/*       */       public PrepaidHandler.PayAward getS2CItems(int index) {
/*       */         if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.get(index); 
/*       */         return (PrepaidHandler.PayAward)this.s2CItemsBuilder_.getMessage(index);
/*       */       }
/*       */       public Builder setS2CItems(int index, PrepaidHandler.PayAward value) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder setS2CItems(int index, PrepaidHandler.PayAward.Builder builderForValue) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CItems(PrepaidHandler.PayAward value) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CItems(int index, PrepaidHandler.PayAward value) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CItems(PrepaidHandler.PayAward.Builder builderForValue) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addS2CItems(int index, PrepaidHandler.PayAward.Builder builderForValue) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAllS2CItems(Iterable<? extends PrepaidHandler.PayAward> values) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.s2CItems_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CItems() {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItems_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeS2CItems(int index) {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           ensureS2CItemsIsMutable();
/*       */           this.s2CItems_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CItemsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public PrepaidHandler.PayAward.Builder getS2CItemsBuilder(int index) {
/*       */         return (PrepaidHandler.PayAward.Builder)getS2CItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public PrepaidHandler.PayAwardOrBuilder getS2CItemsOrBuilder(int index) {
/*       */         if (this.s2CItemsBuilder_ == null)
/*       */           return this.s2CItems_.get(index); 
/*       */         return (PrepaidHandler.PayAwardOrBuilder)this.s2CItemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends PrepaidHandler.PayAwardOrBuilder> getS2CItemsOrBuilderList() {
/*       */         if (this.s2CItemsBuilder_ != null)
/*       */           return this.s2CItemsBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.s2CItems_);
/*       */       }
/*       */       public PrepaidHandler.PayAward.Builder addS2CItemsBuilder() {
/*       */         return (PrepaidHandler.PayAward.Builder)getS2CItemsFieldBuilder().addBuilder(PrepaidHandler.PayAward.getDefaultInstance());
/*       */       }
/*       */       public PrepaidHandler.PayAward.Builder addS2CItemsBuilder(int index) {
/*       */         return (PrepaidHandler.PayAward.Builder)getS2CItemsFieldBuilder().addBuilder(index, PrepaidHandler.PayAward.getDefaultInstance());
/*       */       }
/*       */       public List<PrepaidHandler.PayAward.Builder> getS2CItemsBuilderList() {
/*       */         return getS2CItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<PrepaidHandler.PayAward, PrepaidHandler.PayAward.Builder, PrepaidHandler.PayAwardOrBuilder> getS2CItemsFieldBuilder() {
/*       */         if (this.s2CItemsBuilder_ == null) {
/*       */           this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.s2CItems_ = null;
/*       */         } 
/*       */         return this.s2CItemsBuilder_;
/*       */       }
/*       */       public boolean hasS2CIsGet() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public int getS2CIsGet() {
/*       */         return this.s2CIsGet_;
/*       */       }
/*       */       public Builder setS2CIsGet(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.s2CIsGet_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2CIsGet() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.s2CIsGet_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  8399 */   public static final class PrepaidAPPRequest extends GeneratedMessage implements PrepaidAPPRequestOrBuilder { private static final PrepaidAPPRequest defaultInstance = new PrepaidAPPRequest(true); private final UnknownFieldSet unknownFields; private PrepaidAPPRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidAPPRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidAPPRequest getDefaultInstance() { return defaultInstance; } public PrepaidAPPRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidAPPRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.s2CParam_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidAPPRequest.class, Builder.class); } public static Parser<PrepaidAPPRequest> PARSER = (Parser<PrepaidAPPRequest>)new AbstractParser<PrepaidAPPRequest>() { public PrepaidHandler.PrepaidAPPRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidAPPRequest(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_PARAM_FIELD_NUMBER = 1; private Object s2CParam_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidAPPRequest> getParserForType() { return PARSER; } public boolean hasS2CParam() { return ((this.bitField0_ & 0x1) == 1); } public String getS2CParam() { Object ref = this.s2CParam_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CParam_ = s;  return s; } public ByteString getS2CParamBytes() { Object ref = this.s2CParam_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CParam_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CParam_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CParam()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getS2CParamBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getS2CParamBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidAPPRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidAPPRequest)PARSER.parseFrom(data); } public static PrepaidAPPRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAPPRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAPPRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidAPPRequest)PARSER.parseFrom(data); } public static PrepaidAPPRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAPPRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAPPRequest parseFrom(InputStream input) throws IOException { return (PrepaidAPPRequest)PARSER.parseFrom(input); } public static PrepaidAPPRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPRequest)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidAPPRequest parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidAPPRequest)PARSER.parseDelimitedFrom(input); } public static PrepaidAPPRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidAPPRequest parseFrom(CodedInputStream input) throws IOException { return (PrepaidAPPRequest)PARSER.parseFrom(input); } public static PrepaidAPPRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidAPPRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidAPPRequestOrBuilder {
/*  8400 */       private int bitField0_; private Object s2CParam_; public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidAPPRequest.class, Builder.class); } private Builder() { this.s2CParam_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CParam_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidAPPRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CParam_ = ""; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPRequest_descriptor; } public PrepaidHandler.PrepaidAPPRequest getDefaultInstanceForType() { return PrepaidHandler.PrepaidAPPRequest.getDefaultInstance(); } public PrepaidHandler.PrepaidAPPRequest build() { PrepaidHandler.PrepaidAPPRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidAPPRequest buildPartial() { PrepaidHandler.PrepaidAPPRequest result = new PrepaidHandler.PrepaidAPPRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CParam_ = this.s2CParam_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidAPPRequest) return mergeFrom((PrepaidHandler.PrepaidAPPRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidAPPRequest other) { if (other == PrepaidHandler.PrepaidAPPRequest.getDefaultInstance()) return this;  if (other.hasS2CParam()) { this.bitField0_ |= 0x1; this.s2CParam_ = other.s2CParam_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CParam()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidAPPRequest parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidAPPRequest)PrepaidHandler.PrepaidAPPRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidAPPRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CParam() { return ((this.bitField0_ & 0x1) == 1); } public String getS2CParam() { Object ref = this.s2CParam_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CParam_ = s;  return s; }  return (String)ref; } public ByteString getS2CParamBytes() { Object ref = this.s2CParam_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CParam_ = b; return b; }  return (ByteString)ref; } public Builder setS2CParam(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CParam_ = value; onChanged(); return this; } public Builder clearS2CParam() { this.bitField0_ &= 0xFFFFFFFE; this.s2CParam_ = PrepaidHandler.PrepaidAPPRequest.getDefaultInstance().getS2CParam(); onChanged(); return this; } public Builder setS2CParamBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.s2CParam_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PrepaidAPPResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidAPPResponseOrBuilder
/*       */   {
/*  9126 */     private static final PrepaidAPPResponse defaultInstance = new PrepaidAPPResponse(true); private final UnknownFieldSet unknownFields; private PrepaidAPPResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidAPPResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidAPPResponse getDefaultInstance() { return defaultInstance; } public PrepaidAPPResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidAPPResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CData_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidAPPResponse.class, Builder.class); } public static Parser<PrepaidAPPResponse> PARSER = (Parser<PrepaidAPPResponse>)new AbstractParser<PrepaidAPPResponse>() { public PrepaidHandler.PrepaidAPPResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidAPPResponse(input, extensionRegistry); } }; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_DATA_FIELD_NUMBER = 3; private Object s2CData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidAPPResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CData() { Object ref = this.s2CData_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CData_ = s;  return s; } public ByteString getS2CDataBytes() { Object ref = this.s2CData_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CData_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CData_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasS2CData()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getS2CDataBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getS2CDataBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidAPPResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidAPPResponse)PARSER.parseFrom(data); } public static PrepaidAPPResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAPPResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAPPResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidAPPResponse)PARSER.parseFrom(data); } public static PrepaidAPPResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidAPPResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidAPPResponse parseFrom(InputStream input) throws IOException { return (PrepaidAPPResponse)PARSER.parseFrom(input); } public static PrepaidAPPResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPResponse)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidAPPResponse parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidAPPResponse)PARSER.parseDelimitedFrom(input); } public static PrepaidAPPResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidAPPResponse parseFrom(CodedInputStream input) throws IOException { return (PrepaidAPPResponse)PARSER.parseFrom(input); } public static PrepaidAPPResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidAPPResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidAPPResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidAPPResponseOrBuilder {
/*  9127 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Object s2CData_; public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidAPPResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; this.s2CData_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CData_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidAPPResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CData_ = ""; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidAPPResponse_descriptor; } public PrepaidHandler.PrepaidAPPResponse getDefaultInstanceForType() { return PrepaidHandler.PrepaidAPPResponse.getDefaultInstance(); } public PrepaidHandler.PrepaidAPPResponse build() { PrepaidHandler.PrepaidAPPResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidAPPResponse buildPartial() { PrepaidHandler.PrepaidAPPResponse result = new PrepaidHandler.PrepaidAPPResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CData_ = this.s2CData_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidAPPResponse) return mergeFrom((PrepaidHandler.PrepaidAPPResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidAPPResponse other) { if (other == PrepaidHandler.PrepaidAPPResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CData()) { this.bitField0_ |= 0x4; this.s2CData_ = other.s2CData_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasS2CData()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidAPPResponse parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidAPPResponse)PrepaidHandler.PrepaidAPPResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidAPPResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = PrepaidHandler.PrepaidAPPResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CData() { return ((this.bitField0_ & 0x4) == 4); } public String getS2CData() { Object ref = this.s2CData_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CData_ = s;  return s; }  return (String)ref; } public ByteString getS2CDataBytes() { Object ref = this.s2CData_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CData_ = b; return b; }  return (ByteString)ref; } public Builder setS2CData(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CData_ = value; onChanged(); return this; } public Builder clearS2CData() { this.bitField0_ &= 0xFFFFFFFB; this.s2CData_ = PrepaidHandler.PrepaidAPPResponse.getDefaultInstance().getS2CData(); onChanged(); return this; } public Builder setS2CDataBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x4; this.s2CData_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class PrepaidOrderIdRequest
/*       */     extends GeneratedMessage
/*       */     implements PrepaidOrderIdRequestOrBuilder
/*       */   {
/* 10082 */     private static final PrepaidOrderIdRequest defaultInstance = new PrepaidOrderIdRequest(true); private final UnknownFieldSet unknownFields; private PrepaidOrderIdRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidOrderIdRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidOrderIdRequest getDefaultInstance() { return defaultInstance; } public PrepaidOrderIdRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidOrderIdRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SProductId_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.c2SType_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.c2SChannelId_ = input.readInt32(); break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.c2SImei_ = bs; break;case 40: this.bitField0_ |= 0x10; this.c2SOs_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidOrderIdRequest.class, Builder.class); } public static Parser<PrepaidOrderIdRequest> PARSER = (Parser<PrepaidOrderIdRequest>)new AbstractParser<PrepaidOrderIdRequest>() { public PrepaidHandler.PrepaidOrderIdRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidOrderIdRequest(input, extensionRegistry); } }
/* 10083 */     ; private int bitField0_; public static final int C2S_PRODUCTID_FIELD_NUMBER = 1; private int c2SProductId_; public static final int C2S_TYPE_FIELD_NUMBER = 2; private int c2SType_; public static final int C2S_CHANNELID_FIELD_NUMBER = 3; private int c2SChannelId_; public static final int C2S_IMEI_FIELD_NUMBER = 4; private Object c2SImei_; public static final int C2S_OS_FIELD_NUMBER = 5; private int c2SOs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidOrderIdRequest> getParserForType() { return PARSER; } public boolean hasC2SProductId() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SProductId() { return this.c2SProductId_; } public boolean hasC2SType() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SType() {
/*       */       return this.c2SType_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SChannelId() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SChannelId() {
/*       */       return this.c2SChannelId_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasC2SImei() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public String getC2SImei() {
/*       */       Object ref = this.c2SImei_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.c2SImei_ = s;
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
/*       */     public ByteString getC2SImeiBytes() {
/*       */       Object ref = this.c2SImei_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.c2SImei_ = b;
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
/*       */     public boolean hasC2SOs() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getC2SOs() {
/*       */       return this.c2SOs_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.c2SProductId_ = 0;
/*       */       this.c2SType_ = 0;
/*       */       this.c2SChannelId_ = 0;
/*       */       this.c2SImei_ = "";
/*       */       this.c2SOs_ = 0;
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
/*       */       if (!hasC2SProductId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SType()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasC2SChannelId()) {
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
/*       */         output.writeInt32(1, this.c2SProductId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.c2SType_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.c2SChannelId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getC2SImeiBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeInt32(5, this.c2SOs_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.c2SProductId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.c2SType_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.c2SChannelId_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getC2SImeiBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.c2SOs_);
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
/*       */     public static PrepaidOrderIdRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(InputStream input) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidOrderIdRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidOrderIdRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(PrepaidOrderIdRequest prototype) {
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
/*       */       implements PrepaidHandler.PrepaidOrderIdRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SProductId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SType_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SChannelId_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object c2SImei_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int c2SOs_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidOrderIdRequest.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.c2SImei_ = "";
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
/*       */         this.c2SImei_ = "";
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
/*       */         if (PrepaidHandler.PrepaidOrderIdRequest.alwaysUseFieldBuilders);
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
/*       */         this.c2SProductId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SType_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SChannelId_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SImei_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SOs_ = 0;
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
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public PrepaidHandler.PrepaidOrderIdRequest getDefaultInstanceForType() {
/*       */         return PrepaidHandler.PrepaidOrderIdRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public PrepaidHandler.PrepaidOrderIdRequest build() {
/*       */         PrepaidHandler.PrepaidOrderIdRequest result = buildPartial();
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
/*       */       public PrepaidHandler.PrepaidOrderIdRequest buildPartial() {
/*       */         PrepaidHandler.PrepaidOrderIdRequest result = new PrepaidHandler.PrepaidOrderIdRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.c2SProductId_ = this.c2SProductId_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.c2SType_ = this.c2SType_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.c2SChannelId_ = this.c2SChannelId_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.c2SImei_ = this.c2SImei_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.c2SOs_ = this.c2SOs_;
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
/*       */         if (other instanceof PrepaidHandler.PrepaidOrderIdRequest) {
/*       */           return mergeFrom((PrepaidHandler.PrepaidOrderIdRequest)other);
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
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidOrderIdRequest other) {
/*       */         if (other == PrepaidHandler.PrepaidOrderIdRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasC2SProductId()) {
/*       */           setC2SProductId(other.getC2SProductId());
/*       */         }
/*       */         if (other.hasC2SType()) {
/*       */           setC2SType(other.getC2SType());
/*       */         }
/*       */         if (other.hasC2SChannelId()) {
/*       */           setC2SChannelId(other.getC2SChannelId());
/*       */         }
/*       */         if (other.hasC2SImei()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.c2SImei_ = other.c2SImei_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasC2SOs()) {
/*       */           setC2SOs(other.getC2SOs());
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
/*       */         if (!hasC2SProductId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SType()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasC2SChannelId()) {
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
/*       */         PrepaidHandler.PrepaidOrderIdRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PrepaidOrderIdRequest)PrepaidHandler.PrepaidOrderIdRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PrepaidOrderIdRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasC2SProductId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SProductId() {
/*       */         return this.c2SProductId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SProductId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.c2SProductId_ = value;
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
/*       */       public Builder clearC2SProductId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.c2SProductId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SType() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SType() {
/*       */         return this.c2SType_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SType(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.c2SType_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SType() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.c2SType_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SChannelId() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SChannelId() {
/*       */         return this.c2SChannelId_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SChannelId(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.c2SChannelId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SChannelId() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.c2SChannelId_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SImei() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getC2SImei() {
/*       */         Object ref = this.c2SImei_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.c2SImei_ = s;
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
/*       */       public ByteString getC2SImeiBytes() {
/*       */         Object ref = this.c2SImei_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.c2SImei_ = b;
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
/*       */       public Builder setC2SImei(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.c2SImei_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SImei() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.c2SImei_ = PrepaidHandler.PrepaidOrderIdRequest.getDefaultInstance().getC2SImei();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SImeiBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.c2SImei_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasC2SOs() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getC2SOs() {
/*       */         return this.c2SOs_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setC2SOs(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.c2SOs_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearC2SOs() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.c2SOs_ = 0;
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
/*       */   public static final class PrepaidOrderIdResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidOrderIdResponseOrBuilder
/*       */   {
/* 11006 */     private static final PrepaidOrderIdResponse defaultInstance = new PrepaidOrderIdResponse(true); private final UnknownFieldSet unknownFields; private PrepaidOrderIdResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidOrderIdResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidOrderIdResponse getDefaultInstance() { return defaultInstance; } public PrepaidOrderIdResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidOrderIdResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2COrderId_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.appNotifyUrl_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidOrderIdResponse.class, Builder.class); } public static Parser<PrepaidOrderIdResponse> PARSER = (Parser<PrepaidOrderIdResponse>)new AbstractParser<PrepaidOrderIdResponse>() { public PrepaidHandler.PrepaidOrderIdResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidOrderIdResponse(input, extensionRegistry); } }
/* 11007 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_ORDERID_FIELD_NUMBER = 3; private Object s2COrderId_; public static final int APP_NOTIFY_URL_FIELD_NUMBER = 4; private Object appNotifyUrl_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidOrderIdResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2CMsg_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasS2COrderId() { return ((this.bitField0_ & 0x4) == 4); } public String getS2COrderId() { Object ref = this.s2COrderId_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.s2COrderId_ = s; 
/*       */       return s; } public ByteString getS2COrderIdBytes() { Object ref = this.s2COrderId_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.s2COrderId_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasAppNotifyUrl() { return ((this.bitField0_ & 0x8) == 8); } public String getAppNotifyUrl() { Object ref = this.appNotifyUrl_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.appNotifyUrl_ = s; 
/*       */       return s; } public ByteString getAppNotifyUrlBytes() { Object ref = this.appNotifyUrl_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.appNotifyUrl_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2COrderId_ = "";
/*       */       this.appNotifyUrl_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
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
/*       */         output.writeBytes(3, getS2COrderIdBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeBytes(4, getAppNotifyUrlBytes()); 
/*       */       getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBytesSize(3, getS2COrderIdBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeBytesSize(4, getAppNotifyUrlBytes()); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidOrderIdResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidOrderIdResponse)PARSER.parseFrom(data); } public static PrepaidOrderIdResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidOrderIdResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidOrderIdResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidOrderIdResponse)PARSER.parseFrom(data); } public static PrepaidOrderIdResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidOrderIdResponse)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidOrderIdResponse parseFrom(InputStream input) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseFrom(input); } public static PrepaidOrderIdResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidOrderIdResponse parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseDelimitedFrom(input); } public static PrepaidOrderIdResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static PrepaidOrderIdResponse parseFrom(CodedInputStream input) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseFrom(input); }
/*       */     public static PrepaidOrderIdResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidOrderIdResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(PrepaidOrderIdResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidOrderIdResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Object s2COrderId_; private Object appNotifyUrl_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidOrderIdResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = "";
/*       */         this.s2COrderId_ = "";
/*       */         this.appNotifyUrl_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2COrderId_ = "";
/*       */         this.appNotifyUrl_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidOrderIdResponse.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2COrderId_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.appNotifyUrl_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidOrderIdResponse_descriptor; }
/*       */       public PrepaidHandler.PrepaidOrderIdResponse getDefaultInstanceForType() { return PrepaidHandler.PrepaidOrderIdResponse.getDefaultInstance(); }
/*       */       public PrepaidHandler.PrepaidOrderIdResponse build() { PrepaidHandler.PrepaidOrderIdResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public PrepaidHandler.PrepaidOrderIdResponse buildPartial() { PrepaidHandler.PrepaidOrderIdResponse result = new PrepaidHandler.PrepaidOrderIdResponse(this);
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
/*       */         result.s2COrderId_ = this.s2COrderId_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.appNotifyUrl_ = this.appNotifyUrl_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidOrderIdResponse)
/*       */           return mergeFrom((PrepaidHandler.PrepaidOrderIdResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidOrderIdResponse other) { if (other == PrepaidHandler.PrepaidOrderIdResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasS2COrderId()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.s2COrderId_ = other.s2COrderId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasAppNotifyUrl()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.appNotifyUrl_ = other.appNotifyUrl_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidOrderIdResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PrepaidOrderIdResponse)PrepaidHandler.PrepaidOrderIdResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PrepaidOrderIdResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = PrepaidHandler.PrepaidOrderIdResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasS2COrderId() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       public String getS2COrderId() {
/*       */         Object ref = this.s2COrderId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2COrderId_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       public ByteString getS2COrderIdBytes() {
/*       */         Object ref = this.s2COrderId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2COrderId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       public Builder setS2COrderId(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.s2COrderId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearS2COrderId() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.s2COrderId_ = PrepaidHandler.PrepaidOrderIdResponse.getDefaultInstance().getS2COrderId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder setS2COrderIdBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.s2COrderId_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasAppNotifyUrl() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public String getAppNotifyUrl() {
/*       */         Object ref = this.appNotifyUrl_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.appNotifyUrl_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       public ByteString getAppNotifyUrlBytes() {
/*       */         Object ref = this.appNotifyUrl_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.appNotifyUrl_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       public Builder setAppNotifyUrl(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.appNotifyUrl_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearAppNotifyUrl() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.appNotifyUrl_ = PrepaidHandler.PrepaidOrderIdResponse.getDefaultInstance().getAppNotifyUrl();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder setAppNotifyUrlBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.appNotifyUrl_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/* 11319 */   public static final class PrepaidFirstRequest extends GeneratedMessage implements PrepaidFirstRequestOrBuilder { private static final PrepaidFirstRequest defaultInstance = new PrepaidFirstRequest(true); private final UnknownFieldSet unknownFields; private PrepaidFirstRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidFirstRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidFirstRequest getDefaultInstance() { return defaultInstance; } public PrepaidFirstRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidFirstRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidFirstRequest.class, Builder.class); } public static Parser<PrepaidFirstRequest> PARSER = (Parser<PrepaidFirstRequest>)new AbstractParser<PrepaidFirstRequest>() { public PrepaidHandler.PrepaidFirstRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidFirstRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidFirstRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static PrepaidFirstRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidFirstRequest)PARSER.parseFrom(data); } public static PrepaidFirstRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidFirstRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidFirstRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidFirstRequest)PARSER.parseFrom(data); } public static PrepaidFirstRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidFirstRequest)PARSER.parseFrom(data, extensionRegistry); } public static PrepaidFirstRequest parseFrom(InputStream input) throws IOException { return (PrepaidFirstRequest)PARSER.parseFrom(input); } public static PrepaidFirstRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstRequest)PARSER.parseFrom(input, extensionRegistry); } public static PrepaidFirstRequest parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidFirstRequest)PARSER.parseDelimitedFrom(input); } public static PrepaidFirstRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static PrepaidFirstRequest parseFrom(CodedInputStream input) throws IOException { return (PrepaidFirstRequest)PARSER.parseFrom(input); } public static PrepaidFirstRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(PrepaidFirstRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidFirstRequestOrBuilder {
/* 11320 */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidFirstRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidFirstRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstRequest_descriptor; } public PrepaidHandler.PrepaidFirstRequest getDefaultInstanceForType() { return PrepaidHandler.PrepaidFirstRequest.getDefaultInstance(); } public PrepaidHandler.PrepaidFirstRequest build() { PrepaidHandler.PrepaidFirstRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public PrepaidHandler.PrepaidFirstRequest buildPartial() { PrepaidHandler.PrepaidFirstRequest result = new PrepaidHandler.PrepaidFirstRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidFirstRequest) return mergeFrom((PrepaidHandler.PrepaidFirstRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(PrepaidHandler.PrepaidFirstRequest other) { if (other == PrepaidHandler.PrepaidFirstRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidFirstRequest parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidFirstRequest)PrepaidHandler.PrepaidFirstRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidFirstRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class PrepaidFirstItem
/*       */     extends GeneratedMessage
/*       */     implements PrepaidFirstItemOrBuilder
/*       */   {
/* 12334 */     private static final PrepaidFirstItem defaultInstance = new PrepaidFirstItem(true); private final UnknownFieldSet unknownFields; private PrepaidFirstItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidFirstItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidFirstItem getDefaultInstance() { return defaultInstance; } public PrepaidFirstItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidFirstItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.payMoney_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.isFinish_ = input.readInt32(); break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.items_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.items_.add(input.readMessage(Common.KeyValueStruct.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.items_ = Collections.unmodifiableList(this.items_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstItem_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidFirstItem.class, Builder.class); } public static Parser<PrepaidFirstItem> PARSER = (Parser<PrepaidFirstItem>)new AbstractParser<PrepaidFirstItem>() { public PrepaidHandler.PrepaidFirstItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidFirstItem(input, extensionRegistry); } }
/* 12335 */     ; private int bitField0_; public static final int PAYMONEY_FIELD_NUMBER = 1; private int payMoney_; public static final int ISFINISH_FIELD_NUMBER = 2; private int isFinish_; public static final int ITEMS_FIELD_NUMBER = 3; private List<Common.KeyValueStruct> items_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidFirstItem> getParserForType() { return PARSER; } public boolean hasPayMoney() { return ((this.bitField0_ & 0x1) == 1); } public int getPayMoney() { return this.payMoney_; } public boolean hasIsFinish() { return ((this.bitField0_ & 0x2) == 2); } public int getIsFinish() { return this.isFinish_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<Common.KeyValueStruct> getItemsList() {
/*       */       return this.items_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList() {
/*       */       return (List)this.items_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getItemsCount() {
/*       */       return this.items_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.KeyValueStruct getItems(int index) {
/*       */       return this.items_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public Common.KeyValueStructOrBuilder getItemsOrBuilder(int index) {
/*       */       return (Common.KeyValueStructOrBuilder)this.items_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.payMoney_ = 0;
/*       */       this.isFinish_ = 0;
/*       */       this.items_ = Collections.emptyList();
/*       */     }
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
/*       */       if (!hasPayMoney()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasIsFinish()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getItemsCount(); i++) {
/*       */         if (!getItems(i).isInitialized()) {
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
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.payMoney_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.isFinish_);
/*       */       }
/*       */       for (int i = 0; i < this.items_.size(); i++) {
/*       */         output.writeMessage(3, (MessageLite)this.items_.get(i));
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
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1) {
/*       */         return size;
/*       */       }
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.payMoney_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.isFinish_);
/*       */       }
/*       */       for (int i = 0; i < this.items_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.items_.get(i));
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
/*       */     public static PrepaidFirstItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(InputStream input) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static PrepaidFirstItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (PrepaidFirstItem)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public static Builder newBuilder(PrepaidFirstItem prototype) {
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements PrepaidHandler.PrepaidFirstItemOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int payMoney_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int isFinish_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<Common.KeyValueStruct> items_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> itemsBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstItem_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidFirstItem.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.items_ = Collections.emptyList();
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
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.items_ = Collections.emptyList();
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (PrepaidHandler.PrepaidFirstItem.alwaysUseFieldBuilders) {
/*       */           getItemsFieldBuilder();
/*       */         }
/*       */       }
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
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.payMoney_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.isFinish_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.itemsBuilder_ == null) {
/*       */           this.items_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.itemsBuilder_.clear();
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
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstItem_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public PrepaidHandler.PrepaidFirstItem getDefaultInstanceForType() {
/*       */         return PrepaidHandler.PrepaidFirstItem.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public PrepaidHandler.PrepaidFirstItem build() {
/*       */         PrepaidHandler.PrepaidFirstItem result = buildPartial();
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
/*       */       public PrepaidHandler.PrepaidFirstItem buildPartial() {
/*       */         PrepaidHandler.PrepaidFirstItem result = new PrepaidHandler.PrepaidFirstItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.payMoney_ = this.payMoney_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.isFinish_ = this.isFinish_;
/*       */         if (this.itemsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.items_ = Collections.unmodifiableList(this.items_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.items_ = this.items_;
/*       */         } else {
/*       */           result.items_ = this.itemsBuilder_.build();
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
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof PrepaidHandler.PrepaidFirstItem) {
/*       */           return mergeFrom((PrepaidHandler.PrepaidFirstItem)other);
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
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidFirstItem other) {
/*       */         if (other == PrepaidHandler.PrepaidFirstItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasPayMoney()) {
/*       */           setPayMoney(other.getPayMoney());
/*       */         }
/*       */         if (other.hasIsFinish()) {
/*       */           setIsFinish(other.getIsFinish());
/*       */         }
/*       */         if (this.itemsBuilder_ == null) {
/*       */           if (!other.items_.isEmpty()) {
/*       */             if (this.items_.isEmpty()) {
/*       */               this.items_ = other.items_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureItemsIsMutable();
/*       */               this.items_.addAll(other.items_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.items_.isEmpty()) {
/*       */           if (this.itemsBuilder_.isEmpty()) {
/*       */             this.itemsBuilder_.dispose();
/*       */             this.itemsBuilder_ = null;
/*       */             this.items_ = other.items_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.itemsBuilder_ = PrepaidHandler.PrepaidFirstItem.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
/*       */           } else {
/*       */             this.itemsBuilder_.addAllMessages(other.items_);
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
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasPayMoney()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasIsFinish()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getItemsCount(); i++) {
/*       */           if (!getItems(i).isInitialized()) {
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
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         PrepaidHandler.PrepaidFirstItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (PrepaidHandler.PrepaidFirstItem)PrepaidHandler.PrepaidFirstItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (PrepaidHandler.PrepaidFirstItem)e.getUnfinishedMessage();
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
/*       */       public boolean hasPayMoney() {
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
/*       */       public int getPayMoney() {
/*       */         return this.payMoney_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setPayMoney(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.payMoney_ = value;
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
/*       */       public Builder clearPayMoney() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.payMoney_ = 0;
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
/*       */       public boolean hasIsFinish() {
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
/*       */       public int getIsFinish() {
/*       */         return this.isFinish_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIsFinish(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.isFinish_ = value;
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
/*       */       public Builder clearIsFinish() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.isFinish_ = 0;
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
/*       */       private void ensureItemsIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.items_ = new ArrayList<>(this.items_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.KeyValueStruct> getItemsList() {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.items_);
/*       */         }
/*       */         return this.itemsBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getItemsCount() {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           return this.items_.size();
/*       */         }
/*       */         return this.itemsBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.KeyValueStruct getItems(int index) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           return this.items_.get(index);
/*       */         }
/*       */         return (Common.KeyValueStruct)this.itemsBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setItems(int index, Common.KeyValueStruct value) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureItemsIsMutable();
/*       */           this.items_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.setMessage(index, (GeneratedMessage)value);
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
/*       */       public Builder setItems(int index, Common.KeyValueStruct.Builder builderForValue) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           ensureItemsIsMutable();
/*       */           this.items_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
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
/*       */       public Builder addItems(Common.KeyValueStruct value) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureItemsIsMutable();
/*       */           this.items_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.addMessage((GeneratedMessage)value);
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
/*       */       public Builder addItems(int index, Common.KeyValueStruct value) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureItemsIsMutable();
/*       */           this.items_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.addMessage(index, (GeneratedMessage)value);
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
/*       */       public Builder addItems(Common.KeyValueStruct.Builder builderForValue) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           ensureItemsIsMutable();
/*       */           this.items_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
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
/*       */       public Builder addItems(int index, Common.KeyValueStruct.Builder builderForValue) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           ensureItemsIsMutable();
/*       */           this.items_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
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
/*       */       public Builder addAllItems(Iterable<? extends Common.KeyValueStruct> values) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           ensureItemsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.items_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.addAllMessages(values);
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
/*       */       public Builder clearItems() {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           this.items_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.clear();
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
/*       */       public Builder removeItems(int index) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           ensureItemsIsMutable();
/*       */           this.items_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemsBuilder_.remove(index);
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
/*       */       public Common.KeyValueStruct.Builder getItemsBuilder(int index) {
/*       */         return (Common.KeyValueStruct.Builder)getItemsFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.KeyValueStructOrBuilder getItemsOrBuilder(int index) {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           return (Common.KeyValueStructOrBuilder)this.items_.get(index);
/*       */         }
/*       */         return (Common.KeyValueStructOrBuilder)this.itemsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList() {
/*       */         if (this.itemsBuilder_ != null) {
/*       */           return this.itemsBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return (List)Collections.unmodifiableList(this.items_);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.KeyValueStruct.Builder addItemsBuilder() {
/*       */         return (Common.KeyValueStruct.Builder)getItemsFieldBuilder().addBuilder((GeneratedMessage)Common.KeyValueStruct.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Common.KeyValueStruct.Builder addItemsBuilder(int index) {
/*       */         return (Common.KeyValueStruct.Builder)getItemsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.KeyValueStruct.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<Common.KeyValueStruct.Builder> getItemsBuilderList() {
/*       */         return getItemsFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> getItemsFieldBuilder() {
/*       */         if (this.itemsBuilder_ == null) {
/*       */           this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.items_ = null;
/*       */         } 
/*       */         return this.itemsBuilder_;
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
/*       */   public static final class PrepaidFirstResponse
/*       */     extends GeneratedMessage
/*       */     implements PrepaidFirstResponseOrBuilder
/*       */   {
/* 13394 */     private static final PrepaidFirstResponse defaultInstance = new PrepaidFirstResponse(true); private final UnknownFieldSet unknownFields; private PrepaidFirstResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private PrepaidFirstResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static PrepaidFirstResponse getDefaultInstance() { return defaultInstance; } public PrepaidFirstResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private PrepaidFirstResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.totalPay_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.awards_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.awards_.add(input.readMessage(PrepaidHandler.PrepaidFirstItem.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.awards_ = Collections.unmodifiableList(this.awards_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidFirstResponse.class, Builder.class); } public static Parser<PrepaidFirstResponse> PARSER = (Parser<PrepaidFirstResponse>)new AbstractParser<PrepaidFirstResponse>() { public PrepaidHandler.PrepaidFirstResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new PrepaidHandler.PrepaidFirstResponse(input, extensionRegistry); } }
/* 13395 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int TOTALPAY_FIELD_NUMBER = 3; private int totalPay_; public static final int AWARDS_FIELD_NUMBER = 4; private List<PrepaidHandler.PrepaidFirstItem> awards_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<PrepaidFirstResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); } public boolean hasTotalPay() { return ((this.bitField0_ & 0x4) == 4); }
/*       */     public int getTotalPay() { return this.totalPay_; }
/*       */     public List<PrepaidHandler.PrepaidFirstItem> getAwardsList() { return this.awards_; }
/*       */     public List<? extends PrepaidHandler.PrepaidFirstItemOrBuilder> getAwardsOrBuilderList() { return (List)this.awards_; }
/*       */     public int getAwardsCount() { return this.awards_.size(); }
/*       */     public PrepaidHandler.PrepaidFirstItem getAwards(int index) { return this.awards_.get(index); }
/*       */     public PrepaidHandler.PrepaidFirstItemOrBuilder getAwardsOrBuilder(int index) { return this.awards_.get(index); }
/*       */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.totalPay_ = 0; this.awards_ = Collections.emptyList(); }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasTotalPay()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getAwardsCount(); i++) { if (!getAwards(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.totalPay_);  for (int i = 0; i < this.awards_.size(); i++) output.writeMessage(4, (MessageLite)this.awards_.get(i));  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.totalPay_);  for (int i = 0; i < this.awards_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.awards_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static PrepaidFirstResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (PrepaidFirstResponse)PARSER.parseFrom(data); }
/*       */     public static PrepaidFirstResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidFirstResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static PrepaidFirstResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (PrepaidFirstResponse)PARSER.parseFrom(data); }
/*       */     public static PrepaidFirstResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (PrepaidFirstResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static PrepaidFirstResponse parseFrom(InputStream input) throws IOException { return (PrepaidFirstResponse)PARSER.parseFrom(input); }
/*       */     public static PrepaidFirstResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static PrepaidFirstResponse parseDelimitedFrom(InputStream input) throws IOException { return (PrepaidFirstResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static PrepaidFirstResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static PrepaidFirstResponse parseFrom(CodedInputStream input) throws IOException { return (PrepaidFirstResponse)PARSER.parseFrom(input); }
/*       */     public static PrepaidFirstResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (PrepaidFirstResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(PrepaidFirstResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements PrepaidHandler.PrepaidFirstResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int totalPay_; private List<PrepaidHandler.PrepaidFirstItem> awards_; private RepeatedFieldBuilder<PrepaidHandler.PrepaidFirstItem, PrepaidHandler.PrepaidFirstItem.Builder, PrepaidHandler.PrepaidFirstItemOrBuilder> awardsBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PrepaidHandler.PrepaidFirstResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; this.awards_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.awards_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (PrepaidHandler.PrepaidFirstResponse.alwaysUseFieldBuilders) getAwardsFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.totalPay_ = 0; this.bitField0_ &= 0xFFFFFFFB; if (this.awardsBuilder_ == null) { this.awards_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; } else { this.awardsBuilder_.clear(); }  return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return PrepaidHandler.internal_static_pomelo_area_PrepaidFirstResponse_descriptor; }
/*       */       public PrepaidHandler.PrepaidFirstResponse getDefaultInstanceForType() { return PrepaidHandler.PrepaidFirstResponse.getDefaultInstance(); }
/*       */       public PrepaidHandler.PrepaidFirstResponse build() { PrepaidHandler.PrepaidFirstResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*       */       public PrepaidHandler.PrepaidFirstResponse buildPartial() { PrepaidHandler.PrepaidFirstResponse result = new PrepaidHandler.PrepaidFirstResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.totalPay_ = this.totalPay_; if (this.awardsBuilder_ == null) { if ((this.bitField0_ & 0x8) == 8) { this.awards_ = Collections.unmodifiableList(this.awards_); this.bitField0_ &= 0xFFFFFFF7; }  result.awards_ = this.awards_; } else { result.awards_ = this.awardsBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof PrepaidHandler.PrepaidFirstResponse) return mergeFrom((PrepaidHandler.PrepaidFirstResponse)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(PrepaidHandler.PrepaidFirstResponse other) { if (other == PrepaidHandler.PrepaidFirstResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasTotalPay()) setTotalPay(other.getTotalPay());  if (this.awardsBuilder_ == null) { if (!other.awards_.isEmpty()) { if (this.awards_.isEmpty()) { this.awards_ = other.awards_; this.bitField0_ &= 0xFFFFFFF7; } else { ensureAwardsIsMutable(); this.awards_.addAll(other.awards_); }  onChanged(); }  } else if (!other.awards_.isEmpty()) { if (this.awardsBuilder_.isEmpty()) { this.awardsBuilder_.dispose(); this.awardsBuilder_ = null; this.awards_ = other.awards_; this.bitField0_ &= 0xFFFFFFF7; this.awardsBuilder_ = PrepaidHandler.PrepaidFirstResponse.alwaysUseFieldBuilders ? getAwardsFieldBuilder() : null; } else { this.awardsBuilder_.addAllMessages(other.awards_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (!hasTotalPay()) return false;  for (int i = 0; i < getAwardsCount(); i++) { if (!getAwards(i).isInitialized()) return false;  }  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { PrepaidHandler.PrepaidFirstResponse parsedMessage = null; try { parsedMessage = (PrepaidHandler.PrepaidFirstResponse)PrepaidHandler.PrepaidFirstResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (PrepaidHandler.PrepaidFirstResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
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
/*       */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = PrepaidHandler.PrepaidFirstResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       public boolean hasTotalPay() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public int getTotalPay() { return this.totalPay_; }
/*       */       public Builder setTotalPay(int value) { this.bitField0_ |= 0x4; this.totalPay_ = value; onChanged(); return this; }
/*       */       public Builder clearTotalPay() { this.bitField0_ &= 0xFFFFFFFB; this.totalPay_ = 0; onChanged(); return this; }
/*       */       private void ensureAwardsIsMutable() { if ((this.bitField0_ & 0x8) != 8) { this.awards_ = new ArrayList<>(this.awards_); this.bitField0_ |= 0x8; }  }
/*       */       public List<PrepaidHandler.PrepaidFirstItem> getAwardsList() { if (this.awardsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.awards_);  return this.awardsBuilder_.getMessageList(); }
/*       */       public int getAwardsCount() { if (this.awardsBuilder_ == null)
/*       */           return this.awards_.size();  return this.awardsBuilder_.getCount(); }
/*       */       public PrepaidHandler.PrepaidFirstItem getAwards(int index) { if (this.awardsBuilder_ == null)
/*       */           return this.awards_.get(index);  return (PrepaidHandler.PrepaidFirstItem)this.awardsBuilder_.getMessage(index); }
/*       */       public Builder setAwards(int index, PrepaidHandler.PrepaidFirstItem value) { if (this.awardsBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureAwardsIsMutable(); this.awards_.set(index, value); onChanged(); } else { this.awardsBuilder_.setMessage(index, value); }  return this; }
/*       */       public Builder setAwards(int index, PrepaidHandler.PrepaidFirstItem.Builder builderForValue) { if (this.awardsBuilder_ == null) { ensureAwardsIsMutable(); this.awards_.set(index, builderForValue.build()); onChanged(); } else { this.awardsBuilder_.setMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addAwards(PrepaidHandler.PrepaidFirstItem value) { if (this.awardsBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureAwardsIsMutable(); this.awards_.add(value); onChanged(); } else { this.awardsBuilder_.addMessage(value); }  return this; }
/*       */       public Builder addAwards(int index, PrepaidHandler.PrepaidFirstItem value) { if (this.awardsBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  ensureAwardsIsMutable(); this.awards_.add(index, value); onChanged(); } else { this.awardsBuilder_.addMessage(index, value); }  return this; }
/*       */       public Builder addAwards(PrepaidHandler.PrepaidFirstItem.Builder builderForValue) { if (this.awardsBuilder_ == null) { ensureAwardsIsMutable(); this.awards_.add(builderForValue.build()); onChanged(); } else { this.awardsBuilder_.addMessage(builderForValue.build()); }  return this; }
/*       */       public Builder addAwards(int index, PrepaidHandler.PrepaidFirstItem.Builder builderForValue) { if (this.awardsBuilder_ == null) { ensureAwardsIsMutable(); this.awards_.add(index, builderForValue.build()); onChanged(); } else { this.awardsBuilder_.addMessage(index, builderForValue.build()); }  return this; }
/*       */       public Builder addAllAwards(Iterable<? extends PrepaidHandler.PrepaidFirstItem> values) { if (this.awardsBuilder_ == null) { ensureAwardsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.awards_); onChanged(); } else { this.awardsBuilder_.addAllMessages(values); }  return this; }
/*       */       public Builder clearAwards() { if (this.awardsBuilder_ == null) { this.awards_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; onChanged(); } else { this.awardsBuilder_.clear(); }  return this; }
/*       */       public Builder removeAwards(int index) { if (this.awardsBuilder_ == null) { ensureAwardsIsMutable(); this.awards_.remove(index); onChanged(); } else { this.awardsBuilder_.remove(index); }  return this; }
/*       */       public PrepaidHandler.PrepaidFirstItem.Builder getAwardsBuilder(int index) { return (PrepaidHandler.PrepaidFirstItem.Builder)getAwardsFieldBuilder().getBuilder(index); }
/*       */       public PrepaidHandler.PrepaidFirstItemOrBuilder getAwardsOrBuilder(int index) { if (this.awardsBuilder_ == null)
/*       */           return this.awards_.get(index);  return (PrepaidHandler.PrepaidFirstItemOrBuilder)this.awardsBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends PrepaidHandler.PrepaidFirstItemOrBuilder> getAwardsOrBuilderList() { if (this.awardsBuilder_ != null)
/*       */           return this.awardsBuilder_.getMessageOrBuilderList();  return Collections.unmodifiableList((List)this.awards_); }
/*       */       public PrepaidHandler.PrepaidFirstItem.Builder addAwardsBuilder() { return (PrepaidHandler.PrepaidFirstItem.Builder)getAwardsFieldBuilder().addBuilder(PrepaidHandler.PrepaidFirstItem.getDefaultInstance()); }
/*       */       public PrepaidHandler.PrepaidFirstItem.Builder addAwardsBuilder(int index) { return (PrepaidHandler.PrepaidFirstItem.Builder)getAwardsFieldBuilder().addBuilder(index, PrepaidHandler.PrepaidFirstItem.getDefaultInstance()); }
/*       */       public List<PrepaidHandler.PrepaidFirstItem.Builder> getAwardsBuilderList() { return getAwardsFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<PrepaidHandler.PrepaidFirstItem, PrepaidHandler.PrepaidFirstItem.Builder, PrepaidHandler.PrepaidFirstItemOrBuilder> getAwardsFieldBuilder() { if (this.awardsBuilder_ == null) { this.awardsBuilder_ = new RepeatedFieldBuilder(this.awards_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean()); this.awards_ = null; }  return this.awardsBuilder_; } } }
/* 13484 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 13489 */     String[] descriptorData = { "\n\024prepaidHandler.proto\022\013pomelo.area\032\fcommon.proto\"&\n\021PrepaidSDKRequest\022\021\n\ts2c_param\030\001 \002(\t\"I\n\022PrepaidSDKResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_data\030\003 \002(\t\"\001\n\007PayItem\022\021\n\titemNumId\030\001 \002(\005\022\021\n\titemStrId\030\002 \002(\t\022\020\n\bitemName\030\003 \002(\t\022\f\n\004icon\030\004 \002(\t\022\f\n\004desc\030\005 \002(\t\022\r\n\005price\030\006 \002(\005\022\017\n\007diamond\030\007 \002(\005\022\016\n\006ticket\030\b \002(\005\022\f\n\004flag\030\t \002(\005\"«\002\n\007FeeItem\022\n\n\002id\030\001 \002(\005\022\023\n\013packageIcon\030\002 \002(\t\022\024\n\fappProductId\030\003 \002(\t\022\023\n\013package", "Name\030\004 \002(\t\022\023\n\013packageDesc\030\005 \002(\t\022\030\n\020packageDescFirst\030\006 \002(\t\022\024\n\fpayMoneyType\030\007 \002(\t\022\026\n\016payMoneyAmount\030\b \002(\005\022\022\n\npayDiamond\030\t \002(\005\022\024\n\ffirstDiamond\030\n \002(\005\022\027\n\017nonFirstDiamond\030\013 \002(\005\022\024\n\fpayCashFirst\030\f \002(\005\022\016\n\006payTag\030\r \002(\005\022\016\n\006virgin\030\016 \002(\005\",\n\bPayAward\022\f\n\004code\030\001 \002(\t\022\022\n\ngroupCount\030\002 \002(\005\"\024\n\022PrepaidListRequest\"a\n\023PrepaidListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022'\n\ts2c_items\030\003 \003(\0132\024.pomelo.area.FeeItem\"\025\n\023Prepa", "idAwardRequest\"v\n\024PrepaidAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\ts2c_items\030\003 \003(\0132\025.pomelo.area.PayAward\022\021\n\ts2c_isGet\030\004 \002(\005\"&\n\021PrepaidAPPRequest\022\021\n\ts2c_param\030\001 \002(\t\"I\n\022PrepaidAPPResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_data\030\003 \002(\t\"y\n\025PrepaidOrderIdRequest\022\025\n\rc2s_productId\030\001 \002(\005\022\020\n\bc2s_type\030\002 \002(\005\022\025\n\rc2s_channelId\030\003 \002(\005\022\020\n\bc2s_imei\030\004 \001(\t\022\016\n\006c2s_os\030\005 \001(\005\"h\n\026PrepaidOrderIdResponse\022\020", "\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013s2c_orderId\030\003 \001(\t\022\026\n\016app_notify_url\030\004 \001(\t\"\025\n\023PrepaidFirstRequest\"]\n\020PrepaidFirstItem\022\020\n\bpayMoney\030\001 \002(\005\022\020\n\bisFinish\030\002 \002(\005\022%\n\005items\030\003 \003(\0132\026.pomelo.KeyValueStruct\"z\n\024PrepaidFirstResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\btotalPay\030\003 \002(\005\022-\n\006awards\030\004 \003(\0132\035.pomelo.area.PrepaidFirstItem2´\004\n\016prepaidHandler\022T\n\021prepaidSDKRequest\022\036.pomelo.area.PrepaidSDKRequest\032\037.pomel", "o.area.PrepaidSDKResponse\022W\n\022prepaidListRequest\022\037.pomelo.area.PrepaidListRequest\032 .pomelo.area.PrepaidListResponse\022Z\n\023prepaidAwardRequest\022 .pomelo.area.PrepaidAwardRequest\032!.pomelo.area.PrepaidAwardResponse\022T\n\021prepaidAPPRequest\022\036.pomelo.area.PrepaidAPPRequest\032\037.pomelo.area.PrepaidAPPResponse\022`\n\025prepaidOrderIdRequest\022\".pomelo.area.PrepaidOrderIdRequest\032#.pomelo.area.PrepaidOrderIdResponse\022_\n\030prepai", "dFirstAwardRequest\022 .pomelo.area.PrepaidFirstRequest\032!.pomelo.area.PrepaidFirstResponse" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 13544 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 13548 */           PrepaidHandler.descriptor = root;
/* 13549 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 13553 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 13555 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 13558 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidSDKRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 13559 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidSDKRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidSDKRequest_descriptor, new String[] { "S2CParam" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13564 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidSDKResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 13565 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidSDKResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidSDKResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13570 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PayItem_descriptor = getDescriptor().getMessageTypes().get(2);
/* 13571 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PayItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PayItem_descriptor, new String[] { "ItemNumId", "ItemStrId", "ItemName", "Icon", "Desc", "Price", "Diamond", "Ticket", "Flag" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13576 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FeeItem_descriptor = getDescriptor().getMessageTypes().get(3);
/* 13577 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FeeItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FeeItem_descriptor, new String[] { "Id", "PackageIcon", "AppProductId", "PackageName", "PackageDesc", "PackageDescFirst", "PayMoneyType", "PayMoneyAmount", "PayDiamond", "FirstDiamond", "NonFirstDiamond", "PayCashFirst", "PayTag", "Virgin" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13582 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PayAward_descriptor = getDescriptor().getMessageTypes().get(4);
/* 13583 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PayAward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PayAward_descriptor, new String[] { "Code", "GroupCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13588 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidListRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 13589 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidListRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13594 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidListResponse_descriptor = getDescriptor().getMessageTypes().get(6);
/* 13595 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidListResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CItems" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13600 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidAwardRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 13601 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidAwardRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13606 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidAwardResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 13607 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CItems", "S2CIsGet" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13612 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidAPPRequest_descriptor = getDescriptor().getMessageTypes().get(9);
/* 13613 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidAPPRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidAPPRequest_descriptor, new String[] { "S2CParam" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13618 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidAPPResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 13619 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidAPPResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidAPPResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CData" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13624 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidOrderIdRequest_descriptor = getDescriptor().getMessageTypes().get(11);
/* 13625 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidOrderIdRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidOrderIdRequest_descriptor, new String[] { "C2SProductId", "C2SType", "C2SChannelId", "C2SImei", "C2SOs" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13630 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidOrderIdResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 13631 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidOrderIdResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidOrderIdResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2COrderId", "AppNotifyUrl" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13636 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidFirstRequest_descriptor = getDescriptor().getMessageTypes().get(13);
/* 13637 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidFirstRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidFirstRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13642 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidFirstItem_descriptor = getDescriptor().getMessageTypes().get(14);
/* 13643 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidFirstItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidFirstItem_descriptor, new String[] { "PayMoney", "IsFinish", "Items" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 13648 */   private static final Descriptors.Descriptor internal_static_pomelo_area_PrepaidFirstResponse_descriptor = getDescriptor().getMessageTypes().get(15);
/* 13649 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PrepaidFirstResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PrepaidFirstResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "TotalPay", "Awards" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 13653 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface PrepaidFirstResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasTotalPay();
/*       */     
/*       */     int getTotalPay();
/*       */     
/*       */     List<PrepaidHandler.PrepaidFirstItem> getAwardsList();
/*       */     
/*       */     PrepaidHandler.PrepaidFirstItem getAwards(int param1Int);
/*       */     
/*       */     int getAwardsCount();
/*       */     
/*       */     List<? extends PrepaidHandler.PrepaidFirstItemOrBuilder> getAwardsOrBuilderList();
/*       */     
/*       */     PrepaidHandler.PrepaidFirstItemOrBuilder getAwardsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface PrepaidFirstItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasPayMoney();
/*       */     
/*       */     int getPayMoney();
/*       */     
/*       */     boolean hasIsFinish();
/*       */     
/*       */     int getIsFinish();
/*       */     
/*       */     List<Common.KeyValueStruct> getItemsList();
/*       */     
/*       */     Common.KeyValueStruct getItems(int param1Int);
/*       */     
/*       */     int getItemsCount();
/*       */     
/*       */     List<? extends Common.KeyValueStructOrBuilder> getItemsOrBuilderList();
/*       */     
/*       */     Common.KeyValueStructOrBuilder getItemsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface PrepaidFirstRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface PrepaidOrderIdResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2COrderId();
/*       */     
/*       */     String getS2COrderId();
/*       */     
/*       */     ByteString getS2COrderIdBytes();
/*       */     
/*       */     boolean hasAppNotifyUrl();
/*       */     
/*       */     String getAppNotifyUrl();
/*       */     
/*       */     ByteString getAppNotifyUrlBytes();
/*       */   }
/*       */   
/*       */   public static interface PrepaidOrderIdRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SProductId();
/*       */     
/*       */     int getC2SProductId();
/*       */     
/*       */     boolean hasC2SType();
/*       */     
/*       */     int getC2SType();
/*       */     
/*       */     boolean hasC2SChannelId();
/*       */     
/*       */     int getC2SChannelId();
/*       */     
/*       */     boolean hasC2SImei();
/*       */     
/*       */     String getC2SImei();
/*       */     
/*       */     ByteString getC2SImeiBytes();
/*       */     
/*       */     boolean hasC2SOs();
/*       */     
/*       */     int getC2SOs();
/*       */   }
/*       */   
/*       */   public static interface PrepaidAPPResponseOrBuilder extends MessageOrBuilder {
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
/*       */     String getS2CData();
/*       */     
/*       */     ByteString getS2CDataBytes();
/*       */   }
/*       */   
/*       */   public static interface PrepaidAPPRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CParam();
/*       */     
/*       */     String getS2CParam();
/*       */     
/*       */     ByteString getS2CParamBytes();
/*       */   }
/*       */   
/*       */   public static interface PrepaidAwardResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<PrepaidHandler.PayAward> getS2CItemsList();
/*       */     
/*       */     PrepaidHandler.PayAward getS2CItems(int param1Int);
/*       */     
/*       */     int getS2CItemsCount();
/*       */     
/*       */     List<? extends PrepaidHandler.PayAwardOrBuilder> getS2CItemsOrBuilderList();
/*       */     
/*       */     PrepaidHandler.PayAwardOrBuilder getS2CItemsOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasS2CIsGet();
/*       */     
/*       */     int getS2CIsGet();
/*       */   }
/*       */   
/*       */   public static interface PrepaidAwardRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface PrepaidListResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<PrepaidHandler.FeeItem> getS2CItemsList();
/*       */     
/*       */     PrepaidHandler.FeeItem getS2CItems(int param1Int);
/*       */     
/*       */     int getS2CItemsCount();
/*       */     
/*       */     List<? extends PrepaidHandler.FeeItemOrBuilder> getS2CItemsOrBuilderList();
/*       */     
/*       */     PrepaidHandler.FeeItemOrBuilder getS2CItemsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface PrepaidListRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface PayAwardOrBuilder extends MessageOrBuilder {
/*       */     boolean hasCode();
/*       */     
/*       */     String getCode();
/*       */     
/*       */     ByteString getCodeBytes();
/*       */     
/*       */     boolean hasGroupCount();
/*       */     
/*       */     int getGroupCount();
/*       */   }
/*       */   
/*       */   public static interface FeeItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */     
/*       */     boolean hasPackageIcon();
/*       */     
/*       */     String getPackageIcon();
/*       */     
/*       */     ByteString getPackageIconBytes();
/*       */     
/*       */     boolean hasAppProductId();
/*       */     
/*       */     String getAppProductId();
/*       */     
/*       */     ByteString getAppProductIdBytes();
/*       */     
/*       */     boolean hasPackageName();
/*       */     
/*       */     String getPackageName();
/*       */     
/*       */     ByteString getPackageNameBytes();
/*       */     
/*       */     boolean hasPackageDesc();
/*       */     
/*       */     String getPackageDesc();
/*       */     
/*       */     ByteString getPackageDescBytes();
/*       */     
/*       */     boolean hasPackageDescFirst();
/*       */     
/*       */     String getPackageDescFirst();
/*       */     
/*       */     ByteString getPackageDescFirstBytes();
/*       */     
/*       */     boolean hasPayMoneyType();
/*       */     
/*       */     String getPayMoneyType();
/*       */     
/*       */     ByteString getPayMoneyTypeBytes();
/*       */     
/*       */     boolean hasPayMoneyAmount();
/*       */     
/*       */     int getPayMoneyAmount();
/*       */     
/*       */     boolean hasPayDiamond();
/*       */     
/*       */     int getPayDiamond();
/*       */     
/*       */     boolean hasFirstDiamond();
/*       */     
/*       */     int getFirstDiamond();
/*       */     
/*       */     boolean hasNonFirstDiamond();
/*       */     
/*       */     int getNonFirstDiamond();
/*       */     
/*       */     boolean hasPayCashFirst();
/*       */     
/*       */     int getPayCashFirst();
/*       */     
/*       */     boolean hasPayTag();
/*       */     
/*       */     int getPayTag();
/*       */     
/*       */     boolean hasVirgin();
/*       */     
/*       */     int getVirgin();
/*       */   }
/*       */   
/*       */   public static interface PayItemOrBuilder extends MessageOrBuilder {
/*       */     boolean hasItemNumId();
/*       */     
/*       */     int getItemNumId();
/*       */     
/*       */     boolean hasItemStrId();
/*       */     
/*       */     String getItemStrId();
/*       */     
/*       */     ByteString getItemStrIdBytes();
/*       */     
/*       */     boolean hasItemName();
/*       */     
/*       */     String getItemName();
/*       */     
/*       */     ByteString getItemNameBytes();
/*       */     
/*       */     boolean hasIcon();
/*       */     
/*       */     String getIcon();
/*       */     
/*       */     ByteString getIconBytes();
/*       */     
/*       */     boolean hasDesc();
/*       */     
/*       */     String getDesc();
/*       */     
/*       */     ByteString getDescBytes();
/*       */     
/*       */     boolean hasPrice();
/*       */     
/*       */     int getPrice();
/*       */     
/*       */     boolean hasDiamond();
/*       */     
/*       */     int getDiamond();
/*       */     
/*       */     boolean hasTicket();
/*       */     
/*       */     int getTicket();
/*       */     
/*       */     boolean hasFlag();
/*       */     
/*       */     int getFlag();
/*       */   }
/*       */   
/*       */   public static interface PrepaidSDKResponseOrBuilder extends MessageOrBuilder {
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
/*       */     String getS2CData();
/*       */     
/*       */     ByteString getS2CDataBytes();
/*       */   }
/*       */   
/*       */   public static interface PrepaidSDKRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasS2CParam();
/*       */     
/*       */     String getS2CParam();
/*       */     
/*       */     ByteString getS2CParamBytes();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\PrepaidHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */