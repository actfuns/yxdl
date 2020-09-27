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
/*      */ import pomelo.player.PlayerOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class FunctionOpenHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class GetFunctionListRequest
/*      */     extends GeneratedMessage
/*      */     implements GetFunctionListRequestOrBuilder
/*      */   {
/*  317 */     private static final GetFunctionListRequest defaultInstance = new GetFunctionListRequest(true); private final UnknownFieldSet unknownFields; private GetFunctionListRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetFunctionListRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetFunctionListRequest getDefaultInstance() { return defaultInstance; } public GetFunctionListRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetFunctionListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFunctionListRequest.class, Builder.class); } public static Parser<GetFunctionListRequest> PARSER = (Parser<GetFunctionListRequest>)new AbstractParser<GetFunctionListRequest>() { public FunctionOpenHandler.GetFunctionListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.GetFunctionListRequest(input, extensionRegistry); } }
/*  318 */     ; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetFunctionListRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(data);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(data);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(InputStream input) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(input);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseDelimitedFrom(input);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(input);
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
/*      */ 
/*      */     
/*      */     public static GetFunctionListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(GetFunctionListRequest prototype) {
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
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements FunctionOpenHandler.GetFunctionListRequestOrBuilder
/*      */     {
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListRequest_descriptor;
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
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.GetFunctionListRequest.class, Builder.class);
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
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
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
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
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
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.GetFunctionListRequest.alwaysUseFieldBuilders);
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
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
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
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListRequest_descriptor;
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
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListRequest getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.GetFunctionListRequest.getDefaultInstance();
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
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListRequest build() {
/*      */         FunctionOpenHandler.GetFunctionListRequest result = buildPartial();
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
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListRequest buildPartial() {
/*      */         FunctionOpenHandler.GetFunctionListRequest result = new FunctionOpenHandler.GetFunctionListRequest(this);
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
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.GetFunctionListRequest) {
/*      */           return mergeFrom((FunctionOpenHandler.GetFunctionListRequest)other);
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
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(FunctionOpenHandler.GetFunctionListRequest other) {
/*      */         if (other == FunctionOpenHandler.GetFunctionListRequest.getDefaultInstance()) {
/*      */           return this;
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
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
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
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.GetFunctionListRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.GetFunctionListRequest)FunctionOpenHandler.GetFunctionListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.GetFunctionListRequest)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null) {
/*      */             mergeFrom(parsedMessage);
/*      */           }
/*      */         } 
/*      */         return this;
/*      */       }
/*      */     }
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
/*      */   public static final class GetFunctionListResponse
/*      */     extends GeneratedMessage
/*      */     implements GetFunctionListResponseOrBuilder
/*      */   {
/* 1239 */     private static final GetFunctionListResponse defaultInstance = new GetFunctionListResponse(true); private final UnknownFieldSet unknownFields; private GetFunctionListResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetFunctionListResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetFunctionListResponse getDefaultInstance() { return defaultInstance; } public GetFunctionListResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetFunctionListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CList_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CList_.add(input.readMessage(PlayerOuterClass.FunctionInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CList_ = Collections.unmodifiableList(this.s2CList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFunctionListResponse.class, Builder.class); } public static Parser<GetFunctionListResponse> PARSER = (Parser<GetFunctionListResponse>)new AbstractParser<GetFunctionListResponse>() { public FunctionOpenHandler.GetFunctionListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.GetFunctionListResponse(input, extensionRegistry); } }
/* 1240 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_LIST_FIELD_NUMBER = 3; private List<PlayerOuterClass.FunctionInfo> s2CList_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetFunctionListResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */     
/*      */     public List<PlayerOuterClass.FunctionInfo> getS2CListList() {
/*      */       return this.s2CList_;
/*      */     }
/*      */     
/*      */     public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList() {
/*      */       return (List)this.s2CList_;
/*      */     }
/*      */     
/*      */     public int getS2CListCount() {
/*      */       return this.s2CList_.size();
/*      */     }
/*      */     
/*      */     public PlayerOuterClass.FunctionInfo getS2CList(int index) {
/*      */       return this.s2CList_.get(index);
/*      */     }
/*      */     
/*      */     public PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int index) {
/*      */       return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CList_.get(index);
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CList_ = Collections.emptyList();
/*      */     }
/*      */     
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
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
/*      */       for (int i = 0; i < this.s2CList_.size(); i++)
/*      */         output.writeMessage(3, (MessageLite)this.s2CList_.get(i)); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*      */       for (int i = 0; i < this.s2CList_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CList_.get(i)); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(InputStream input) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static GetFunctionListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetFunctionListResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     
/*      */     public static Builder newBuilder(GetFunctionListResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionOpenHandler.GetFunctionListResponseOrBuilder { private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private List<PlayerOuterClass.FunctionInfo> s2CList_;
/*      */       private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> s2CListBuilder_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListResponse_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.GetFunctionListResponse.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CList_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CList_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.GetFunctionListResponse.alwaysUseFieldBuilders)
/*      */           getS2CListFieldBuilder(); 
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
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.s2CListBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_GetFunctionListResponse_descriptor;
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListResponse getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.GetFunctionListResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListResponse build() {
/*      */         FunctionOpenHandler.GetFunctionListResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.GetFunctionListResponse buildPartial() {
/*      */         FunctionOpenHandler.GetFunctionListResponse result = new FunctionOpenHandler.GetFunctionListResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.s2CList_ = Collections.unmodifiableList(this.s2CList_);
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } 
/*      */           result.s2CList_ = this.s2CList_;
/*      */         } else {
/*      */           result.s2CList_ = this.s2CListBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.GetFunctionListResponse)
/*      */           return mergeFrom((FunctionOpenHandler.GetFunctionListResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(FunctionOpenHandler.GetFunctionListResponse other) {
/*      */         if (other == FunctionOpenHandler.GetFunctionListResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (!other.s2CList_.isEmpty()) {
/*      */             if (this.s2CList_.isEmpty()) {
/*      */               this.s2CList_ = other.s2CList_;
/*      */               this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureS2CListIsMutable();
/*      */               this.s2CList_.addAll(other.s2CList_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CList_.isEmpty()) {
/*      */           if (this.s2CListBuilder_.isEmpty()) {
/*      */             this.s2CListBuilder_.dispose();
/*      */             this.s2CListBuilder_ = null;
/*      */             this.s2CList_ = other.s2CList_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */             this.s2CListBuilder_ = FunctionOpenHandler.GetFunctionListResponse.alwaysUseFieldBuilders ? getS2CListFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CListBuilder_.addAllMessages(other.s2CList_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.GetFunctionListResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.GetFunctionListResponse)FunctionOpenHandler.GetFunctionListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.GetFunctionListResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = FunctionOpenHandler.GetFunctionListResponse.getDefaultInstance().getS2CMsg();
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
/*      */       private void ensureS2CListIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.s2CList_ = new ArrayList<>(this.s2CList_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */       
/*      */       public List<PlayerOuterClass.FunctionInfo> getS2CListList() {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CList_); 
/*      */         return this.s2CListBuilder_.getMessageList();
/*      */       }
/*      */       
/*      */       public int getS2CListCount() {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return this.s2CList_.size(); 
/*      */         return this.s2CListBuilder_.getCount();
/*      */       }
/*      */       
/*      */       public PlayerOuterClass.FunctionInfo getS2CList(int index) {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return this.s2CList_.get(index); 
/*      */         return (PlayerOuterClass.FunctionInfo)this.s2CListBuilder_.getMessage(index);
/*      */       }
/*      */       
/*      */       public Builder setS2CList(int index, PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CList(PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CList(int index, PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CList(PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addS2CList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder addAllS2CList(Iterable<? extends PlayerOuterClass.FunctionInfo> values) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CList_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CList() {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder removeS2CList(int index) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public PlayerOuterClass.FunctionInfo.Builder getS2CListBuilder(int index) {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().getBuilder(index);
/*      */       }
/*      */       
/*      */       public PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int index) {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CList_.get(index); 
/*      */         return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CListBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       
/*      */       public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList() {
/*      */         if (this.s2CListBuilder_ != null)
/*      */           return this.s2CListBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CList_);
/*      */       }
/*      */       
/*      */       public PlayerOuterClass.FunctionInfo.Builder addS2CListBuilder() {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().addBuilder((GeneratedMessage)PlayerOuterClass.FunctionInfo.getDefaultInstance());
/*      */       }
/*      */       
/*      */       public PlayerOuterClass.FunctionInfo.Builder addS2CListBuilder(int index) {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().addBuilder(index, (GeneratedMessage)PlayerOuterClass.FunctionInfo.getDefaultInstance());
/*      */       }
/*      */       
/*      */       public List<PlayerOuterClass.FunctionInfo.Builder> getS2CListBuilderList() {
/*      */         return getS2CListFieldBuilder().getBuilderList();
/*      */       }
/*      */       
/*      */       private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> getS2CListFieldBuilder() {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CListBuilder_ = new RepeatedFieldBuilder(this.s2CList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.s2CList_ = null;
/*      */         } 
/*      */         return this.s2CListBuilder_;
/*      */       } } }
/*      */   
/* 1771 */   public static final class SetFunctionPlayedRequest extends GeneratedMessage implements SetFunctionPlayedRequestOrBuilder { private static final SetFunctionPlayedRequest defaultInstance = new SetFunctionPlayedRequest(true); private final UnknownFieldSet unknownFields; private SetFunctionPlayedRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetFunctionPlayedRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetFunctionPlayedRequest getDefaultInstance() { return defaultInstance; } public SetFunctionPlayedRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetFunctionPlayedRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.functionName_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SetFunctionPlayedRequest.class, Builder.class); } public static Parser<SetFunctionPlayedRequest> PARSER = (Parser<SetFunctionPlayedRequest>)new AbstractParser<SetFunctionPlayedRequest>() { public FunctionOpenHandler.SetFunctionPlayedRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.SetFunctionPlayedRequest(input, extensionRegistry); } }
/* 1772 */     ; private int bitField0_; public static final int FUNCTIONNAME_FIELD_NUMBER = 1; private Object functionName_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetFunctionPlayedRequest> getParserForType() { return PARSER; } public boolean hasFunctionName() { return ((this.bitField0_ & 0x1) == 1); } public String getFunctionName() { Object ref = this.functionName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.functionName_ = s;  return s; } public ByteString getFunctionNameBytes() { Object ref = this.functionName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.functionName_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
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
/*      */       this.functionName_ = "";
/*      */     }
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
/*      */       if (!hasFunctionName()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getFunctionNameBytes());
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
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeBytesSize(1, getFunctionNameBytes());
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
/*      */     public static SetFunctionPlayedRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(InputStream input) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public static Builder newBuilder(SetFunctionPlayedRequest prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements FunctionOpenHandler.SetFunctionPlayedRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object functionName_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.SetFunctionPlayedRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.functionName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.functionName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.SetFunctionPlayedRequest.alwaysUseFieldBuilders);
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.functionName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         return this;
/*      */       }
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.SetFunctionPlayedRequest getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.SetFunctionPlayedRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.SetFunctionPlayedRequest build() {
/*      */         FunctionOpenHandler.SetFunctionPlayedRequest result = buildPartial();
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
/*      */       public FunctionOpenHandler.SetFunctionPlayedRequest buildPartial() {
/*      */         FunctionOpenHandler.SetFunctionPlayedRequest result = new FunctionOpenHandler.SetFunctionPlayedRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.functionName_ = this.functionName_;
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.SetFunctionPlayedRequest) {
/*      */           return mergeFrom((FunctionOpenHandler.SetFunctionPlayedRequest)other);
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
/*      */       public Builder mergeFrom(FunctionOpenHandler.SetFunctionPlayedRequest other) {
/*      */         if (other == FunctionOpenHandler.SetFunctionPlayedRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasFunctionName()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.functionName_ = other.functionName_;
/*      */           onChanged();
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasFunctionName()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.SetFunctionPlayedRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.SetFunctionPlayedRequest)FunctionOpenHandler.SetFunctionPlayedRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.SetFunctionPlayedRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasFunctionName() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getFunctionName() {
/*      */         Object ref = this.functionName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.functionName_ = s;
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
/*      */       public ByteString getFunctionNameBytes() {
/*      */         Object ref = this.functionName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.functionName_ = b;
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
/*      */       public Builder setFunctionName(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.functionName_ = value;
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
/*      */       public Builder clearFunctionName() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.functionName_ = FunctionOpenHandler.SetFunctionPlayedRequest.getDefaultInstance().getFunctionName();
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
/*      */       public Builder setFunctionNameBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.functionName_ = value;
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
/*      */   public static final class SetFunctionPlayedResponse
/*      */     extends GeneratedMessage
/*      */     implements SetFunctionPlayedResponseOrBuilder
/*      */   {
/* 2333 */     private static final SetFunctionPlayedResponse defaultInstance = new SetFunctionPlayedResponse(true); private final UnknownFieldSet unknownFields; private SetFunctionPlayedResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetFunctionPlayedResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetFunctionPlayedResponse getDefaultInstance() { return defaultInstance; } public SetFunctionPlayedResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetFunctionPlayedResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SetFunctionPlayedResponse.class, Builder.class); } public static Parser<SetFunctionPlayedResponse> PARSER = (Parser<SetFunctionPlayedResponse>)new AbstractParser<SetFunctionPlayedResponse>() { public FunctionOpenHandler.SetFunctionPlayedResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.SetFunctionPlayedResponse(input, extensionRegistry); } }
/* 2334 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetFunctionPlayedResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getS2CMsg() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.s2CMsg_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */     }
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
/*      */       if (!hasS2CCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getS2CMsgBytes());
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(InputStream input) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static SetFunctionPlayedResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (SetFunctionPlayedResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(SetFunctionPlayedResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements FunctionOpenHandler.SetFunctionPlayedResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */       
/*      */       private int s2CCode_;
/*      */ 
/*      */       
/*      */       private Object s2CMsg_;
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.SetFunctionPlayedResponse.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.SetFunctionPlayedResponse.alwaysUseFieldBuilders);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_SetFunctionPlayedResponse_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.SetFunctionPlayedResponse getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.SetFunctionPlayedResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.SetFunctionPlayedResponse build() {
/*      */         FunctionOpenHandler.SetFunctionPlayedResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public FunctionOpenHandler.SetFunctionPlayedResponse buildPartial() {
/*      */         FunctionOpenHandler.SetFunctionPlayedResponse result = new FunctionOpenHandler.SetFunctionPlayedResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.SetFunctionPlayedResponse) {
/*      */           return mergeFrom((FunctionOpenHandler.SetFunctionPlayedResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(FunctionOpenHandler.SetFunctionPlayedResponse other) {
/*      */         if (other == FunctionOpenHandler.SetFunctionPlayedResponse.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasS2CCode()) {
/*      */           setS2CCode(other.getS2CCode());
/*      */         }
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.SetFunctionPlayedResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.SetFunctionPlayedResponse)FunctionOpenHandler.SetFunctionPlayedResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.SetFunctionPlayedResponse)e.getUnfinishedMessage();
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
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setS2CCode(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.s2CCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearS2CCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CCode_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasS2CMsg() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */       
/*      */       public String getS2CMsg() {
/*      */         Object ref = this.s2CMsg_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.s2CMsg_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
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
/*      */       
/*      */       public Builder setS2CMsg(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = FunctionOpenHandler.SetFunctionPlayedResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder setS2CMsgBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static final class ReceiveFunctionAwardRequest
/*      */     extends GeneratedMessage
/*      */     implements ReceiveFunctionAwardRequestOrBuilder
/*      */   {
/* 2778 */     private static final ReceiveFunctionAwardRequest defaultInstance = new ReceiveFunctionAwardRequest(true); private final UnknownFieldSet unknownFields; private ReceiveFunctionAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ReceiveFunctionAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ReceiveFunctionAwardRequest getDefaultInstance() { return defaultInstance; } public ReceiveFunctionAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ReceiveFunctionAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.guideId_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveFunctionAwardRequest.class, Builder.class); } public static Parser<ReceiveFunctionAwardRequest> PARSER = (Parser<ReceiveFunctionAwardRequest>)new AbstractParser<ReceiveFunctionAwardRequest>() { public FunctionOpenHandler.ReceiveFunctionAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.ReceiveFunctionAwardRequest(input, extensionRegistry); } }
/* 2779 */     ; private int bitField0_; public static final int GUIDE_ID_FIELD_NUMBER = 1; private int guideId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ReceiveFunctionAwardRequest> getParserForType() { return PARSER; } public boolean hasGuideId() { return ((this.bitField0_ & 0x1) == 1); } public int getGuideId() { return this.guideId_; } private void initFields() { this.guideId_ = 0; } static { defaultInstance.initFields(); }
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasGuideId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.guideId_); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.guideId_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(data);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(data);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(InputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     public static Builder newBuilder(ReceiveFunctionAwardRequest prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionOpenHandler.ReceiveFunctionAwardRequestOrBuilder { private int bitField0_; private int guideId_;
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardRequest_descriptor;
/*      */       }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.ReceiveFunctionAwardRequest.class, Builder.class);
/*      */       }
/*      */       private Builder() {
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.ReceiveFunctionAwardRequest.alwaysUseFieldBuilders);
/*      */       }
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.guideId_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         return this;
/*      */       }
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardRequest_descriptor;
/*      */       }
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardRequest getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.ReceiveFunctionAwardRequest.getDefaultInstance();
/*      */       }
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardRequest build() {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardRequest result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardRequest buildPartial() {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardRequest result = new FunctionOpenHandler.ReceiveFunctionAwardRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.guideId_ = this.guideId_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.ReceiveFunctionAwardRequest)
/*      */           return mergeFrom((FunctionOpenHandler.ReceiveFunctionAwardRequest)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       public Builder mergeFrom(FunctionOpenHandler.ReceiveFunctionAwardRequest other) {
/*      */         if (other == FunctionOpenHandler.ReceiveFunctionAwardRequest.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasGuideId())
/*      */           setGuideId(other.getGuideId()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       public final boolean isInitialized() {
/*      */         if (!hasGuideId())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.ReceiveFunctionAwardRequest)FunctionOpenHandler.ReceiveFunctionAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.ReceiveFunctionAwardRequest)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public boolean hasGuideId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       public int getGuideId() {
/*      */         return this.guideId_;
/*      */       }
/*      */       public Builder setGuideId(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.guideId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearGuideId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.guideId_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } }
/*      */   }
/*      */   public static final class ReceiveFunctionAwardResponse extends GeneratedMessage implements ReceiveFunctionAwardResponseOrBuilder { private final UnknownFieldSet unknownFields;
/*      */     private ReceiveFunctionAwardResponse(GeneratedMessage.Builder<?> builder) {
/*      */       super(builder);
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = builder.getUnknownFields();
/*      */     }
/*      */     private ReceiveFunctionAwardResponse(boolean noInit) {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse getDefaultInstance() {
/*      */       return defaultInstance;
/*      */     }
/*      */     public ReceiveFunctionAwardResponse getDefaultInstanceForType() {
/*      */       return defaultInstance;
/*      */     }
/*      */     public final UnknownFieldSet getUnknownFields() {
/*      */       return this.unknownFields;
/*      */     }
/*      */     private ReceiveFunctionAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       initFields();
/*      */       int mutable_bitField0_ = 0;
/*      */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*      */       try {
/*      */         boolean done = false;
/*      */         while (!done) {
/*      */           ByteString bs;
/*      */           int tag = input.readTag();
/*      */           switch (tag) {
/*      */             case 0:
/*      */               done = true;
/*      */               break;
/*      */             case 8:
/*      */               this.bitField0_ |= 0x1;
/*      */               this.s2CCode_ = input.readInt32();
/*      */               break;
/*      */             case 18:
/*      */               bs = input.readBytes();
/*      */               this.bitField0_ |= 0x2;
/*      */               this.s2CMsg_ = bs;
/*      */               break;
/*      */           } 
/*      */         } 
/*      */       } catch (InvalidProtocolBufferException e) {
/*      */         throw e.setUnfinishedMessage(this);
/*      */       } catch (IOException e) {
/*      */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*      */       } finally {
/*      */         this.unknownFields = unknownFields.build();
/*      */         makeExtensionsImmutable();
/*      */       } 
/*      */     }
/*      */     public static final Descriptors.Descriptor getDescriptor() {
/*      */       return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardResponse_descriptor;
/*      */     }
/*      */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */       return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveFunctionAwardResponse.class, Builder.class);
/*      */     }
/*      */     public static Parser<ReceiveFunctionAwardResponse> PARSER = (Parser<ReceiveFunctionAwardResponse>)new AbstractParser<ReceiveFunctionAwardResponse>() { public FunctionOpenHandler.ReceiveFunctionAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */           return new FunctionOpenHandler.ReceiveFunctionAwardResponse(input, extensionRegistry);
/*      */         } }
/*      */     ;
/*      */     private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L;
/*      */     public Parser<ReceiveFunctionAwardResponse> getParserForType() {
/*      */       return PARSER;
/*      */     }
/*      */     public boolean hasS2CCode() {
/*      */       return ((this.bitField0_ & 0x1) == 1);
/*      */     }
/*      */     public int getS2CCode() {
/*      */       return this.s2CCode_;
/*      */     }
/*      */     public boolean hasS2CMsg() {
/*      */       return ((this.bitField0_ & 0x2) == 2);
/*      */     }
/*      */     public String getS2CMsg() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CMsg_ = s; 
/*      */       return s;
/*      */     }
/*      */     public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
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
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.s2CCode_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getS2CMsgBytes()); 
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
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(InputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static ReceiveFunctionAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ReceiveFunctionAwardResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     
/*      */     public static Builder newBuilder(ReceiveFunctionAwardResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionOpenHandler.ReceiveFunctionAwardResponseOrBuilder { private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardResponse_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.ReceiveFunctionAwardResponse.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.ReceiveFunctionAwardResponse.alwaysUseFieldBuilders);
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
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_ReceiveFunctionAwardResponse_descriptor;
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardResponse getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.ReceiveFunctionAwardResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardResponse build() {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public FunctionOpenHandler.ReceiveFunctionAwardResponse buildPartial() {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardResponse result = new FunctionOpenHandler.ReceiveFunctionAwardResponse(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.ReceiveFunctionAwardResponse)
/*      */           return mergeFrom((FunctionOpenHandler.ReceiveFunctionAwardResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(FunctionOpenHandler.ReceiveFunctionAwardResponse other) {
/*      */         if (other == FunctionOpenHandler.ReceiveFunctionAwardResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.ReceiveFunctionAwardResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.ReceiveFunctionAwardResponse)FunctionOpenHandler.ReceiveFunctionAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.ReceiveFunctionAwardResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = FunctionOpenHandler.ReceiveFunctionAwardResponse.getDefaultInstance().getS2CMsg();
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
/*      */       } }
/* 3340 */     private static final ReceiveFunctionAwardResponse defaultInstance = new ReceiveFunctionAwardResponse(true); static {
/* 3341 */       defaultInstance.initFields();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class FunctionOpenListPush
/*      */     extends GeneratedMessage
/*      */     implements FunctionOpenListPushOrBuilder
/*      */   {
/* 4380 */     private static final FunctionOpenListPush defaultInstance = new FunctionOpenListPush(true); private final UnknownFieldSet unknownFields; private FunctionOpenListPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private FunctionOpenListPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static FunctionOpenListPush getDefaultInstance() { return defaultInstance; } public FunctionOpenListPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private FunctionOpenListPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.s2CList_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.s2CList_.add(input.readMessage(PlayerOuterClass.FunctionInfo.PARSER, extensionRegistry)); break;case 32: this.bitField0_ |= 0x4; this.s2CIsAll_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.s2CList_ = Collections.unmodifiableList(this.s2CList_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_FunctionOpenListPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_FunctionOpenListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenListPush.class, Builder.class); } public static Parser<FunctionOpenListPush> PARSER = (Parser<FunctionOpenListPush>)new AbstractParser<FunctionOpenListPush>() { public FunctionOpenHandler.FunctionOpenListPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new FunctionOpenHandler.FunctionOpenListPush(input, extensionRegistry); } }
/* 4381 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_LIST_FIELD_NUMBER = 3; private List<PlayerOuterClass.FunctionInfo> s2CList_; public static final int S2C_ISALL_FIELD_NUMBER = 4; private int s2CIsAll_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<FunctionOpenListPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */      public List<PlayerOuterClass.FunctionInfo> getS2CListList() {
/*      */       return this.s2CList_;
/*      */     } public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList() {
/*      */       return (List)this.s2CList_;
/*      */     } public int getS2CListCount() {
/*      */       return this.s2CList_.size();
/*      */     } public PlayerOuterClass.FunctionInfo getS2CList(int index) {
/*      */       return this.s2CList_.get(index);
/*      */     } public PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int index) {
/*      */       return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CList_.get(index);
/*      */     } public boolean hasS2CIsAll() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     } public int getS2CIsAll() {
/*      */       return this.s2CIsAll_;
/*      */     } private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CList_ = Collections.emptyList();
/*      */       this.s2CIsAll_ = 0;
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
/*      */       for (int i = 0; i < this.s2CList_.size(); i++)
/*      */         output.writeMessage(3, (MessageLite)this.s2CList_.get(i)); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(4, this.s2CIsAll_); 
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
/*      */       for (int i = 0; i < this.s2CList_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CList_.get(i)); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(4, this.s2CIsAll_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     } protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     } public static FunctionOpenListPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(data);
/*      */     } public static FunctionOpenListPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static FunctionOpenListPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(data);
/*      */     } public static FunctionOpenListPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static FunctionOpenListPush parseFrom(InputStream input) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(input);
/*      */     } public static FunctionOpenListPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static FunctionOpenListPush parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseDelimitedFrom(input);
/*      */     } public static FunctionOpenListPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static FunctionOpenListPush parseFrom(CodedInputStream input) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(input);
/*      */     } public static FunctionOpenListPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (FunctionOpenListPush)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     } public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     } public static Builder newBuilder(FunctionOpenListPush prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     } public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionOpenHandler.FunctionOpenListPushOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<PlayerOuterClass.FunctionInfo> s2CList_; private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> s2CListBuilder_; private int s2CIsAll_; public static final Descriptors.Descriptor getDescriptor() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_FunctionOpenListPush_descriptor;
/*      */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_FunctionOpenListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.FunctionOpenListPush.class, Builder.class);
/*      */       } private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CList_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CList_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private void maybeForceBuilderInitialization() {
/*      */         if (FunctionOpenHandler.FunctionOpenListPush.alwaysUseFieldBuilders)
/*      */           getS2CListFieldBuilder(); 
/*      */       } private static Builder create() {
/*      */         return new Builder();
/*      */       } public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */         } else {
/*      */           this.s2CListBuilder_.clear();
/*      */         } 
/*      */         this.s2CIsAll_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         return this;
/*      */       } public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       } public Descriptors.Descriptor getDescriptorForType() {
/*      */         return FunctionOpenHandler.internal_static_pomelo_area_FunctionOpenListPush_descriptor;
/*      */       }
/*      */       public FunctionOpenHandler.FunctionOpenListPush getDefaultInstanceForType() {
/*      */         return FunctionOpenHandler.FunctionOpenListPush.getDefaultInstance();
/*      */       }
/*      */       public FunctionOpenHandler.FunctionOpenListPush build() {
/*      */         FunctionOpenHandler.FunctionOpenListPush result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       public FunctionOpenHandler.FunctionOpenListPush buildPartial() {
/*      */         FunctionOpenHandler.FunctionOpenListPush result = new FunctionOpenHandler.FunctionOpenListPush(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.s2CCode_ = this.s2CCode_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.s2CMsg_ = this.s2CMsg_;
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4) {
/*      */             this.s2CList_ = Collections.unmodifiableList(this.s2CList_);
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */           } 
/*      */           result.s2CList_ = this.s2CList_;
/*      */         } else {
/*      */           result.s2CList_ = this.s2CListBuilder_.build();
/*      */         } 
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.s2CIsAll_ = this.s2CIsAll_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof FunctionOpenHandler.FunctionOpenListPush)
/*      */           return mergeFrom((FunctionOpenHandler.FunctionOpenListPush)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       public Builder mergeFrom(FunctionOpenHandler.FunctionOpenListPush other) {
/*      */         if (other == FunctionOpenHandler.FunctionOpenListPush.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (!other.s2CList_.isEmpty()) {
/*      */             if (this.s2CList_.isEmpty()) {
/*      */               this.s2CList_ = other.s2CList_;
/*      */               this.bitField0_ &= 0xFFFFFFFB;
/*      */             } else {
/*      */               ensureS2CListIsMutable();
/*      */               this.s2CList_.addAll(other.s2CList_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CList_.isEmpty()) {
/*      */           if (this.s2CListBuilder_.isEmpty()) {
/*      */             this.s2CListBuilder_.dispose();
/*      */             this.s2CListBuilder_ = null;
/*      */             this.s2CList_ = other.s2CList_;
/*      */             this.bitField0_ &= 0xFFFFFFFB;
/*      */             this.s2CListBuilder_ = FunctionOpenHandler.FunctionOpenListPush.alwaysUseFieldBuilders ? getS2CListFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CListBuilder_.addAllMessages(other.s2CList_);
/*      */           } 
/*      */         } 
/*      */         if (other.hasS2CIsAll())
/*      */           setS2CIsAll(other.getS2CIsAll()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         FunctionOpenHandler.FunctionOpenListPush parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (FunctionOpenHandler.FunctionOpenListPush)FunctionOpenHandler.FunctionOpenListPush.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (FunctionOpenHandler.FunctionOpenListPush)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public boolean hasS2CCode() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       public int getS2CCode() {
/*      */         return this.s2CCode_;
/*      */       }
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
/*      */         this.s2CMsg_ = FunctionOpenHandler.FunctionOpenListPush.getDefaultInstance().getS2CMsg();
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
/*      */       private void ensureS2CListIsMutable() {
/*      */         if ((this.bitField0_ & 0x4) != 4) {
/*      */           this.s2CList_ = new ArrayList<>(this.s2CList_);
/*      */           this.bitField0_ |= 0x4;
/*      */         } 
/*      */       }
/*      */       public List<PlayerOuterClass.FunctionInfo> getS2CListList() {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CList_); 
/*      */         return this.s2CListBuilder_.getMessageList();
/*      */       }
/*      */       public int getS2CListCount() {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return this.s2CList_.size(); 
/*      */         return this.s2CListBuilder_.getCount();
/*      */       }
/*      */       public PlayerOuterClass.FunctionInfo getS2CList(int index) {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return this.s2CList_.get(index); 
/*      */         return (PlayerOuterClass.FunctionInfo)this.s2CListBuilder_.getMessage(index);
/*      */       }
/*      */       public Builder setS2CList(int index, PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CList(PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CList(int index, PlayerOuterClass.FunctionInfo value) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CList(PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addAllS2CList(Iterable<? extends PlayerOuterClass.FunctionInfo> values) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CList_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CList() {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CList_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFFB;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder removeS2CList(int index) {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           ensureS2CListIsMutable();
/*      */           this.s2CList_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CListBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public PlayerOuterClass.FunctionInfo.Builder getS2CListBuilder(int index) {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().getBuilder(index);
/*      */       }
/*      */       public PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int index) {
/*      */         if (this.s2CListBuilder_ == null)
/*      */           return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CList_.get(index); 
/*      */         return (PlayerOuterClass.FunctionInfoOrBuilder)this.s2CListBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList() {
/*      */         if (this.s2CListBuilder_ != null)
/*      */           return this.s2CListBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CList_);
/*      */       }
/*      */       public PlayerOuterClass.FunctionInfo.Builder addS2CListBuilder() {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().addBuilder((GeneratedMessage)PlayerOuterClass.FunctionInfo.getDefaultInstance());
/*      */       }
/*      */       public PlayerOuterClass.FunctionInfo.Builder addS2CListBuilder(int index) {
/*      */         return (PlayerOuterClass.FunctionInfo.Builder)getS2CListFieldBuilder().addBuilder(index, (GeneratedMessage)PlayerOuterClass.FunctionInfo.getDefaultInstance());
/*      */       }
/*      */       public List<PlayerOuterClass.FunctionInfo.Builder> getS2CListBuilderList() {
/*      */         return getS2CListFieldBuilder().getBuilderList();
/*      */       }
/*      */       private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> getS2CListFieldBuilder() {
/*      */         if (this.s2CListBuilder_ == null) {
/*      */           this.s2CListBuilder_ = new RepeatedFieldBuilder(this.s2CList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*      */           this.s2CList_ = null;
/*      */         } 
/*      */         return this.s2CListBuilder_;
/*      */       }
/*      */       public boolean hasS2CIsAll() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */       public int getS2CIsAll() {
/*      */         return this.s2CIsAll_;
/*      */       }
/*      */       public Builder setS2CIsAll(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.s2CIsAll_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CIsAll() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.s2CIsAll_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } }
/*      */   }
/*      */   public static final class FunctionAwardListPush extends GeneratedMessage implements FunctionAwardListPushOrBuilder { private final UnknownFieldSet unknownFields;
/*      */     private FunctionAwardListPush(GeneratedMessage.Builder<?> builder) {
/*      */       super(builder);
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = builder.getUnknownFields();
/*      */     }
/*      */     private FunctionAwardListPush(boolean noInit) {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*      */     }
/*      */     public static FunctionAwardListPush getDefaultInstance() {
/*      */       return defaultInstance;
/*      */     }
/*      */     public FunctionAwardListPush getDefaultInstanceForType() {
/*      */       return defaultInstance;
/*      */     }
/*      */     public final UnknownFieldSet getUnknownFields() {
/*      */       return this.unknownFields;
/*      */     }
/*      */     private FunctionAwardListPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       initFields();
/*      */       int mutable_bitField0_ = 0;
/*      */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*      */       try {
/*      */         boolean done = false;
/*      */         while (!done) {
/*      */           int length, limit, tag = input.readTag();
/*      */           switch (tag) {
/*      */             case 0:
/*      */               done = true;
/*      */               break;
/*      */             case 8:
/*      */               if ((mutable_bitField0_ & 0x1) != 1) {
/*      */                 this.guideIds_ = new ArrayList<>();
/*      */                 mutable_bitField0_ |= 0x1;
/*      */               } 
/*      */               this.guideIds_.add(Integer.valueOf(input.readInt32()));
/*      */               break;
/*      */             case 10:
/*      */               length = input.readRawVarint32();
/*      */               limit = input.pushLimit(length);
/*      */               if ((mutable_bitField0_ & 0x1) != 1 && input.getBytesUntilLimit() > 0) {
/*      */                 this.guideIds_ = new ArrayList<>();
/*      */                 mutable_bitField0_ |= 0x1;
/*      */               } 
/*      */               while (input.getBytesUntilLimit() > 0)
/*      */                 this.guideIds_.add(Integer.valueOf(input.readInt32())); 
/*      */               input.popLimit(limit);
/*      */               break;
/*      */           } 
/*      */         } 
/*      */       } catch (InvalidProtocolBufferException e) {
/*      */         throw e.setUnfinishedMessage(this);
/*      */       } catch (IOException e) {
/*      */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*      */       } finally {
/*      */         if ((mutable_bitField0_ & 0x1) == 1)
/*      */           this.guideIds_ = Collections.unmodifiableList(this.guideIds_); 
/*      */         this.unknownFields = unknownFields.build();
/*      */         makeExtensionsImmutable();
/*      */       } 
/*      */     }
/*      */     public static final Descriptors.Descriptor getDescriptor() {
/*      */       return FunctionOpenHandler.internal_static_pomelo_area_FunctionAwardListPush_descriptor;
/*      */     }
/*      */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */       return FunctionOpenHandler.internal_static_pomelo_area_FunctionAwardListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionAwardListPush.class, Builder.class);
/*      */     }
/*      */     public static Parser<FunctionAwardListPush> PARSER = (Parser<FunctionAwardListPush>)new AbstractParser<FunctionAwardListPush>() { public FunctionOpenHandler.FunctionAwardListPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */           return new FunctionOpenHandler.FunctionAwardListPush(input, extensionRegistry);
/*      */         } }
/*      */     ;
/* 4911 */     public static final int GUIDEIDS_FIELD_NUMBER = 1; private List<Integer> guideIds_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; private static final FunctionAwardListPush defaultInstance = new FunctionAwardListPush(true);
/* 4912 */     public Parser<FunctionAwardListPush> getParserForType() { return PARSER; } public List<Integer> getGuideIdsList() { return this.guideIds_; } public int getGuideIdsCount() { return this.guideIds_.size(); } public int getGuideIds(int index) { return ((Integer)this.guideIds_.get(index)).intValue(); } private void initFields() { this.guideIds_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); for (int i = 0; i < this.guideIds_.size(); i++) output.writeInt32(1, ((Integer)this.guideIds_.get(i)).intValue());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; int dataSize = 0; for (int i = 0; i < this.guideIds_.size(); i++) dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.guideIds_.get(i)).intValue());  size += dataSize; size += 1 * getGuideIdsList().size(); size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static FunctionAwardListPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (FunctionAwardListPush)PARSER.parseFrom(data); } public static FunctionAwardListPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FunctionAwardListPush)PARSER.parseFrom(data, extensionRegistry); } public static FunctionAwardListPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (FunctionAwardListPush)PARSER.parseFrom(data); } public static FunctionAwardListPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (FunctionAwardListPush)PARSER.parseFrom(data, extensionRegistry); } public static FunctionAwardListPush parseFrom(InputStream input) throws IOException { return (FunctionAwardListPush)PARSER.parseFrom(input); } public static FunctionAwardListPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FunctionAwardListPush)PARSER.parseFrom(input, extensionRegistry); } static { defaultInstance.initFields(); } public static FunctionAwardListPush parseDelimitedFrom(InputStream input) throws IOException { return (FunctionAwardListPush)PARSER.parseDelimitedFrom(input); } public static FunctionAwardListPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FunctionAwardListPush)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static FunctionAwardListPush parseFrom(CodedInputStream input) throws IOException { return (FunctionAwardListPush)PARSER.parseFrom(input); }
/*      */     public static FunctionAwardListPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (FunctionAwardListPush)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(FunctionAwardListPush prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionOpenHandler.FunctionAwardListPushOrBuilder {
/*      */       private int bitField0_; private List<Integer> guideIds_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return FunctionOpenHandler.internal_static_pomelo_area_FunctionAwardListPush_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return FunctionOpenHandler.internal_static_pomelo_area_FunctionAwardListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionOpenHandler.FunctionAwardListPush.class, Builder.class); }
/*      */       private Builder() { this.guideIds_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.guideIds_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (FunctionOpenHandler.FunctionAwardListPush.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.guideIds_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFE; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return FunctionOpenHandler.internal_static_pomelo_area_FunctionAwardListPush_descriptor; }
/*      */       public FunctionOpenHandler.FunctionAwardListPush getDefaultInstanceForType() { return FunctionOpenHandler.FunctionAwardListPush.getDefaultInstance(); }
/*      */       public FunctionOpenHandler.FunctionAwardListPush build() { FunctionOpenHandler.FunctionAwardListPush result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public FunctionOpenHandler.FunctionAwardListPush buildPartial() { FunctionOpenHandler.FunctionAwardListPush result = new FunctionOpenHandler.FunctionAwardListPush(this); int from_bitField0_ = this.bitField0_; if ((this.bitField0_ & 0x1) == 1) { this.guideIds_ = Collections.unmodifiableList(this.guideIds_); this.bitField0_ &= 0xFFFFFFFE; }
/*      */          result.guideIds_ = this.guideIds_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof FunctionOpenHandler.FunctionAwardListPush)
/*      */           return mergeFrom((FunctionOpenHandler.FunctionAwardListPush)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(FunctionOpenHandler.FunctionAwardListPush other) { if (other == FunctionOpenHandler.FunctionAwardListPush.getDefaultInstance())
/*      */           return this;  if (!other.guideIds_.isEmpty()) { if (this.guideIds_.isEmpty()) { this.guideIds_ = other.guideIds_; this.bitField0_ &= 0xFFFFFFFE; }
/*      */           else { ensureGuideIdsIsMutable(); this.guideIds_.addAll(other.guideIds_); }
/*      */            onChanged(); }
/*      */          mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { FunctionOpenHandler.FunctionAwardListPush parsedMessage = null; try { parsedMessage = (FunctionOpenHandler.FunctionAwardListPush)FunctionOpenHandler.FunctionAwardListPush.PARSER.parsePartialFrom(input, extensionRegistry); }
/*      */         catch (InvalidProtocolBufferException e)
/*      */         { parsedMessage = (FunctionOpenHandler.FunctionAwardListPush)e.getUnfinishedMessage(); throw e; }
/*      */         finally
/*      */         { if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage);  }
/*      */          return this; }
/*      */       private void ensureGuideIdsIsMutable() { if ((this.bitField0_ & 0x1) != 1) {
/*      */           this.guideIds_ = new ArrayList<>(this.guideIds_); this.bitField0_ |= 0x1;
/*      */         }  }
/*      */       public List<Integer> getGuideIdsList() { return Collections.unmodifiableList(this.guideIds_); }
/*      */       public int getGuideIdsCount() { return this.guideIds_.size(); }
/*      */       public int getGuideIds(int index) { return ((Integer)this.guideIds_.get(index)).intValue(); }
/*      */       public Builder setGuideIds(int index, int value) { ensureGuideIdsIsMutable(); this.guideIds_.set(index, Integer.valueOf(value)); onChanged(); return this; }
/*      */       public Builder addGuideIds(int value) { ensureGuideIdsIsMutable(); this.guideIds_.add(Integer.valueOf(value)); onChanged(); return this; }
/*      */       public Builder addAllGuideIds(Iterable<? extends Integer> values) { ensureGuideIdsIsMutable(); AbstractMessageLite.Builder.addAll(values, this.guideIds_); onChanged(); return this; }
/*      */       public Builder clearGuideIds() { this.guideIds_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFFE; onChanged(); return this; } } }
/* 4961 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 4966 */     String[] descriptorData = { "\n\031functionOpenHandler.proto\022\013pomelo.area\032\fcommon.proto\032\fplayer.proto\"\030\n\026GetFunctionListRequest\"k\n\027GetFunctionListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_list\030\003 \003(\0132\033.pomelo.player.FunctionInfo\"0\n\030SetFunctionPlayedRequest\022\024\n\ffunctionName\030\001 \002(\t\">\n\031SetFunctionPlayedResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"/\n\033ReceiveFunctionAwardRequest\022\020\n\bguide_id\030\001 \002(\005\"A\n\034ReceiveFunctionAwardResponse\022\020", "\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"{\n\024FunctionOpenListPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_list\030\003 \003(\0132\033.pomelo.player.FunctionInfo\022\021\n\ts2c_isAll\030\004 \001(\005\")\n\025FunctionAwardListPush\022\020\n\bguideIds\030\001 \003(\0052Ù\002\n\023functionOpenHandler\022c\n\026getFunctionListRequest\022#.pomelo.area.GetFunctionListRequest\032$.pomelo.area.GetFunctionListResponse\022i\n\030setFunctionPlayedRequest\022%.pomelo.area.SetFunctionPlayedRequest\032&.pome", "lo.area.SetFunctionPlayedResponse\022r\n\033receiveFunctionAwardRequest\022(.pomelo.area.ReceiveFunctionAwardRequest\032).pomelo.area.ReceiveFunctionAwardResponse2¦\001\n\020functionOpenPush\022G\n\024functionOpenListPush\022!.pomelo.area.FunctionOpenListPush\032\f.pomelo.Void\022I\n\025functionAwardListPush\022\".pomelo.area.FunctionAwardListPush\032\f.pomelo.Void" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4996 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 5000 */           FunctionOpenHandler.descriptor = root;
/* 5001 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 5005 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 5007 */           Common.getDescriptor(), 
/* 5008 */           PlayerOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 5011 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetFunctionListRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 5012 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFunctionListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFunctionListRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5017 */   private static final Descriptors.Descriptor internal_static_pomelo_area_GetFunctionListResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 5018 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFunctionListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFunctionListResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CList" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5023 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetFunctionPlayedRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 5024 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetFunctionPlayedRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetFunctionPlayedRequest_descriptor, new String[] { "FunctionName" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5029 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetFunctionPlayedResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 5030 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetFunctionPlayedResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetFunctionPlayedResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5035 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveFunctionAwardRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 5036 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveFunctionAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveFunctionAwardRequest_descriptor, new String[] { "GuideId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5041 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveFunctionAwardResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 5042 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveFunctionAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveFunctionAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5047 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FunctionOpenListPush_descriptor = getDescriptor().getMessageTypes().get(6);
/* 5048 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FunctionOpenListPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FunctionOpenListPush_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CList", "S2CIsAll" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5053 */   private static final Descriptors.Descriptor internal_static_pomelo_area_FunctionAwardListPush_descriptor = getDescriptor().getMessageTypes().get(7);
/* 5054 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FunctionAwardListPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FunctionAwardListPush_descriptor, new String[] { "GuideIds" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 5058 */     Common.getDescriptor();
/* 5059 */     PlayerOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface FunctionAwardListPushOrBuilder extends MessageOrBuilder {
/*      */     List<Integer> getGuideIdsList();
/*      */     
/*      */     int getGuideIdsCount();
/*      */     
/*      */     int getGuideIds(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface FunctionOpenListPushOrBuilder extends MessageOrBuilder {
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
/*      */     List<PlayerOuterClass.FunctionInfo> getS2CListList();
/*      */     
/*      */     PlayerOuterClass.FunctionInfo getS2CList(int param1Int);
/*      */     
/*      */     int getS2CListCount();
/*      */     
/*      */     List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList();
/*      */     
/*      */     PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int param1Int);
/*      */     
/*      */     boolean hasS2CIsAll();
/*      */     
/*      */     int getS2CIsAll();
/*      */   }
/*      */   
/*      */   public static interface ReceiveFunctionAwardResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface ReceiveFunctionAwardRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasGuideId();
/*      */     
/*      */     int getGuideId();
/*      */   }
/*      */   
/*      */   public static interface SetFunctionPlayedResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface SetFunctionPlayedRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasFunctionName();
/*      */     
/*      */     String getFunctionName();
/*      */     
/*      */     ByteString getFunctionNameBytes();
/*      */   }
/*      */   
/*      */   public static interface GetFunctionListResponseOrBuilder extends MessageOrBuilder {
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
/*      */     List<PlayerOuterClass.FunctionInfo> getS2CListList();
/*      */     
/*      */     PlayerOuterClass.FunctionInfo getS2CList(int param1Int);
/*      */     
/*      */     int getS2CListCount();
/*      */     
/*      */     List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getS2CListOrBuilderList();
/*      */     
/*      */     PlayerOuterClass.FunctionInfoOrBuilder getS2CListOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface GetFunctionListRequestOrBuilder extends MessageOrBuilder {}
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\FunctionOpenHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */