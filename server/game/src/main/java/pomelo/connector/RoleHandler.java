/*      */ package pomelo.connector;
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
/*      */ public final class RoleHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class CreatePlayerRequest
/*      */     extends GeneratedMessage
/*      */     implements CreatePlayerRequestOrBuilder
/*      */   {
/*      */     private final UnknownFieldSet unknownFields;
/*      */     
/*      */     private CreatePlayerRequest(GeneratedMessage.Builder<?> builder) {
/*      */       super(builder);
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = builder.getUnknownFields();
/*      */     }
/*      */     
/*      */     private CreatePlayerRequest(boolean noInit) {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest getDefaultInstance() {
/*      */       return defaultInstance;
/*      */     }
/*      */     
/*      */     public CreatePlayerRequest getDefaultInstanceForType() {
/*      */       return defaultInstance;
/*      */     }
/*      */     
/*      */     public final UnknownFieldSet getUnknownFields() {
/*      */       return this.unknownFields;
/*      */     }
/*      */     
/*      */     private CreatePlayerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*      */               this.c2SPro_ = input.readInt32();
/*      */               break;
/*      */             case 18:
/*      */               bs = input.readBytes();
/*      */               this.bitField0_ |= 0x2;
/*      */               this.c2SName_ = bs;
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
/*      */     
/*      */     public static final Descriptors.Descriptor getDescriptor() {
/*      */       return RoleHandler.internal_static_pomelo_connector_CreatePlayerRequest_descriptor;
/*      */     }
/*      */     
/*      */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */       return RoleHandler.internal_static_pomelo_connector_CreatePlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CreatePlayerRequest.class, Builder.class);
/*      */     }
/*      */     
/*      */     public static Parser<CreatePlayerRequest> PARSER = (Parser<CreatePlayerRequest>)new AbstractParser<CreatePlayerRequest>()
/*      */       {
/*      */         public RoleHandler.CreatePlayerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */           return new RoleHandler.CreatePlayerRequest(input, extensionRegistry);
/*      */         }
/*      */       };
/*      */     
/*      */     private int bitField0_;
/*      */     public static final int C2S_PRO_FIELD_NUMBER = 1;
/*      */     private int c2SPro_;
/*      */     public static final int C2S_NAME_FIELD_NUMBER = 2;
/*      */     private Object c2SName_;
/*      */     private byte memoizedIsInitialized;
/*      */     private int memoizedSerializedSize;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     public Parser<CreatePlayerRequest> getParserForType() {
/*      */       return PARSER;
/*      */     }
/*      */     
/*      */     public boolean hasC2SPro() {
/*      */       return ((this.bitField0_ & 0x1) == 1);
/*      */     }
/*      */     
/*      */     public int getC2SPro() {
/*      */       return this.c2SPro_;
/*      */     }
/*      */     
/*      */     public boolean hasC2SName() {
/*      */       return ((this.bitField0_ & 0x2) == 2);
/*      */     }
/*      */     
/*      */     public String getC2SName() {
/*      */       Object ref = this.c2SName_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.c2SName_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getC2SNameBytes() {
/*      */       Object ref = this.c2SName_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.c2SName_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.c2SPro_ = 0;
/*      */       this.c2SName_ = "";
/*      */     }
/*      */     
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasC2SPro()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasC2SName()) {
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
/*      */         output.writeInt32(1, this.c2SPro_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeBytes(2, getC2SNameBytes()); 
/*      */       getUnknownFields().writeTo(output);
/*      */     }
/*      */     
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.c2SPro_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeBytesSize(2, getC2SNameBytes()); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(InputStream input) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static CreatePlayerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(CreatePlayerRequest prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements RoleHandler.CreatePlayerRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       private int c2SPro_;
/*      */       private Object c2SName_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerRequest_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.CreatePlayerRequest.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.c2SName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.c2SName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.CreatePlayerRequest.alwaysUseFieldBuilders);
/*      */       }
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.c2SPro_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerRequest_descriptor;
/*      */       }
/*      */       
/*      */       public RoleHandler.CreatePlayerRequest getDefaultInstanceForType() {
/*      */         return RoleHandler.CreatePlayerRequest.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public RoleHandler.CreatePlayerRequest build() {
/*      */         RoleHandler.CreatePlayerRequest result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public RoleHandler.CreatePlayerRequest buildPartial() {
/*      */         RoleHandler.CreatePlayerRequest result = new RoleHandler.CreatePlayerRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.c2SPro_ = this.c2SPro_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.c2SName_ = this.c2SName_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.CreatePlayerRequest)
/*      */           return mergeFrom((RoleHandler.CreatePlayerRequest)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(RoleHandler.CreatePlayerRequest other) {
/*      */         if (other == RoleHandler.CreatePlayerRequest.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasC2SPro())
/*      */           setC2SPro(other.getC2SPro()); 
/*      */         if (other.hasC2SName()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.c2SName_ = other.c2SName_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasC2SPro())
/*      */           return false; 
/*      */         if (!hasC2SName())
/*      */           return false; 
/*      */         return true;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.CreatePlayerRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.CreatePlayerRequest)RoleHandler.CreatePlayerRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.CreatePlayerRequest)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SPro() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */       
/*      */       public int getC2SPro() {
/*      */         return this.c2SPro_;
/*      */       }
/*      */       
/*      */       public Builder setC2SPro(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SPro_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SPro() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SPro_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public boolean hasC2SName() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */       
/*      */       public String getC2SName() {
/*      */         Object ref = this.c2SName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.c2SName_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getC2SNameBytes() {
/*      */         Object ref = this.c2SName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SName_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setC2SName(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearC2SName() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.c2SName_ = RoleHandler.CreatePlayerRequest.getDefaultInstance().getC2SName();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setC2SNameBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x2;
/*      */         this.c2SName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*  574 */     private static final CreatePlayerRequest defaultInstance = new CreatePlayerRequest(true); static {
/*  575 */       defaultInstance.initFields();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class CreatePlayerResponse
/*      */     extends GeneratedMessage
/*      */     implements CreatePlayerResponseOrBuilder
/*      */   {
/* 1709 */     private static final CreatePlayerResponse defaultInstance = new CreatePlayerResponse(true); private final UnknownFieldSet unknownFields; private CreatePlayerResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private CreatePlayerResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static CreatePlayerResponse getDefaultInstance() { return defaultInstance; } public CreatePlayerResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private CreatePlayerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; PlayerOuterClass.PlayerBasic.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CPlayer_.toBuilder();  this.s2CPlayer_ = (PlayerOuterClass.PlayerBasic)input.readMessage(PlayerOuterClass.PlayerBasic.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CPlayer_); this.s2CPlayer_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.s2CPlayers_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.s2CPlayers_.add(input.readMessage(PlayerOuterClass.PlayerBasic.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.s2CPlayers_ = Collections.unmodifiableList(this.s2CPlayers_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_CreatePlayerResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_CreatePlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CreatePlayerResponse.class, Builder.class); } public static Parser<CreatePlayerResponse> PARSER = (Parser<CreatePlayerResponse>)new AbstractParser<CreatePlayerResponse>() { public RoleHandler.CreatePlayerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.CreatePlayerResponse(input, extensionRegistry); } }
/* 1710 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_PLAYER_FIELD_NUMBER = 3; private PlayerOuterClass.PlayerBasic s2CPlayer_; public static final int S2C_PLAYERS_FIELD_NUMBER = 4; private List<PlayerOuterClass.PlayerBasic> s2CPlayers_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<CreatePlayerResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */      public boolean hasS2CPlayer() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     } public PlayerOuterClass.PlayerBasic getS2CPlayer() {
/*      */       return this.s2CPlayer_;
/*      */     } public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayerOrBuilder() {
/*      */       return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayer_;
/*      */     } public List<PlayerOuterClass.PlayerBasic> getS2CPlayersList() {
/*      */       return this.s2CPlayers_;
/*      */     } public List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList() {
/*      */       return (List)this.s2CPlayers_;
/*      */     }
/*      */     public int getS2CPlayersCount() {
/*      */       return this.s2CPlayers_.size();
/*      */     }
/*      */     public PlayerOuterClass.PlayerBasic getS2CPlayers(int index) {
/*      */       return this.s2CPlayers_.get(index);
/*      */     }
/*      */     public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int index) {
/*      */       return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayers_.get(index);
/*      */     }
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.getDefaultInstance();
/*      */       this.s2CPlayers_ = Collections.emptyList();
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
/*      */       if (hasS2CPlayer() && !getS2CPlayer().isInitialized()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       for (int i = 0; i < getS2CPlayersCount(); i++) {
/*      */         if (!getS2CPlayers(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
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
/*      */         output.writeMessage(3, (MessageLite)this.s2CPlayer_); 
/*      */       for (int i = 0; i < this.s2CPlayers_.size(); i++)
/*      */         output.writeMessage(4, (MessageLite)this.s2CPlayers_.get(i)); 
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
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CPlayer_); 
/*      */       for (int i = 0; i < this.s2CPlayers_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CPlayers_.get(i)); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(InputStream input) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static CreatePlayerResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     public static CreatePlayerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     public static CreatePlayerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (CreatePlayerResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */     public static Builder newBuilder(CreatePlayerResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements RoleHandler.CreatePlayerResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private PlayerOuterClass.PlayerBasic s2CPlayer_; private SingleFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> s2CPlayerBuilder_; private List<PlayerOuterClass.PlayerBasic> s2CPlayers_; private RepeatedFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> s2CPlayersBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerResponse_descriptor;
/*      */       }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.CreatePlayerResponse.class, Builder.class);
/*      */       }
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.getDefaultInstance();
/*      */         this.s2CPlayers_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.getDefaultInstance();
/*      */         this.s2CPlayers_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.CreatePlayerResponse.alwaysUseFieldBuilders) {
/*      */           getS2CPlayerFieldBuilder();
/*      */           getS2CPlayersFieldBuilder();
/*      */         } 
/*      */       }
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.getDefaultInstance();
/*      */         } else {
/*      */           this.s2CPlayerBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           this.s2CPlayers_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_CreatePlayerResponse_descriptor;
/*      */       }
/*      */       public RoleHandler.CreatePlayerResponse getDefaultInstanceForType() {
/*      */         return RoleHandler.CreatePlayerResponse.getDefaultInstance();
/*      */       }
/*      */       public RoleHandler.CreatePlayerResponse build() {
/*      */         RoleHandler.CreatePlayerResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       public RoleHandler.CreatePlayerResponse buildPartial() {
/*      */         RoleHandler.CreatePlayerResponse result = new RoleHandler.CreatePlayerResponse(this);
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
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           result.s2CPlayer_ = this.s2CPlayer_;
/*      */         } else {
/*      */           result.s2CPlayer_ = (PlayerOuterClass.PlayerBasic)this.s2CPlayerBuilder_.build();
/*      */         } 
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x8) == 8) {
/*      */             this.s2CPlayers_ = Collections.unmodifiableList(this.s2CPlayers_);
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */           } 
/*      */           result.s2CPlayers_ = this.s2CPlayers_;
/*      */         } else {
/*      */           result.s2CPlayers_ = this.s2CPlayersBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.CreatePlayerResponse)
/*      */           return mergeFrom((RoleHandler.CreatePlayerResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       public Builder mergeFrom(RoleHandler.CreatePlayerResponse other) {
/*      */         if (other == RoleHandler.CreatePlayerResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CPlayer())
/*      */           mergeS2CPlayer(other.getS2CPlayer()); 
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           if (!other.s2CPlayers_.isEmpty()) {
/*      */             if (this.s2CPlayers_.isEmpty()) {
/*      */               this.s2CPlayers_ = other.s2CPlayers_;
/*      */               this.bitField0_ &= 0xFFFFFFF7;
/*      */             } else {
/*      */               ensureS2CPlayersIsMutable();
/*      */               this.s2CPlayers_.addAll(other.s2CPlayers_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.s2CPlayers_.isEmpty()) {
/*      */           if (this.s2CPlayersBuilder_.isEmpty()) {
/*      */             this.s2CPlayersBuilder_.dispose();
/*      */             this.s2CPlayersBuilder_ = null;
/*      */             this.s2CPlayers_ = other.s2CPlayers_;
/*      */             this.bitField0_ &= 0xFFFFFFF7;
/*      */             this.s2CPlayersBuilder_ = RoleHandler.CreatePlayerResponse.alwaysUseFieldBuilders ? getS2CPlayersFieldBuilder() : null;
/*      */           } else {
/*      */             this.s2CPlayersBuilder_.addAllMessages(other.s2CPlayers_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */       public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         if (hasS2CPlayer() && !getS2CPlayer().isInitialized())
/*      */           return false; 
/*      */         for (int i = 0; i < getS2CPlayersCount(); i++) {
/*      */           if (!getS2CPlayers(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true;
/*      */       }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.CreatePlayerResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.CreatePlayerResponse)RoleHandler.CreatePlayerResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.CreatePlayerResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = RoleHandler.CreatePlayerResponse.getDefaultInstance().getS2CMsg();
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
/*      */       public boolean hasS2CPlayer() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic getS2CPlayer() {
/*      */         if (this.s2CPlayerBuilder_ == null)
/*      */           return this.s2CPlayer_; 
/*      */         return (PlayerOuterClass.PlayerBasic)this.s2CPlayerBuilder_.getMessage();
/*      */       }
/*      */       public Builder setS2CPlayer(PlayerOuterClass.PlayerBasic value) {
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.s2CPlayer_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayerBuilder_.setMessage((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CPlayer(PlayerOuterClass.PlayerBasic.Builder builderForValue) {
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           this.s2CPlayer_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayerBuilder_.setMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder mergeS2CPlayer(PlayerOuterClass.PlayerBasic value) {
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4 && this.s2CPlayer_ != PlayerOuterClass.PlayerBasic.getDefaultInstance()) {
/*      */             this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.newBuilder(this.s2CPlayer_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.s2CPlayer_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayerBuilder_.mergeFrom((GeneratedMessage)value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CPlayer() {
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           this.s2CPlayer_ = PlayerOuterClass.PlayerBasic.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayerBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic.Builder getS2CPlayerBuilder() {
/*      */         this.bitField0_ |= 0x4;
/*      */         onChanged();
/*      */         return (PlayerOuterClass.PlayerBasic.Builder)getS2CPlayerFieldBuilder().getBuilder();
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayerOrBuilder() {
/*      */         if (this.s2CPlayerBuilder_ != null)
/*      */           return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayerBuilder_.getMessageOrBuilder(); 
/*      */         return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayer_;
/*      */       }
/*      */       private SingleFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayerFieldBuilder() {
/*      */         if (this.s2CPlayerBuilder_ == null) {
/*      */           this.s2CPlayerBuilder_ = new SingleFieldBuilder((GeneratedMessage)getS2CPlayer(), getParentForChildren(), isClean());
/*      */           this.s2CPlayer_ = null;
/*      */         } 
/*      */         return this.s2CPlayerBuilder_;
/*      */       }
/*      */       private void ensureS2CPlayersIsMutable() {
/*      */         if ((this.bitField0_ & 0x8) != 8) {
/*      */           this.s2CPlayers_ = new ArrayList<>(this.s2CPlayers_);
/*      */           this.bitField0_ |= 0x8;
/*      */         } 
/*      */       }
/*      */       public List<PlayerOuterClass.PlayerBasic> getS2CPlayersList() {
/*      */         if (this.s2CPlayersBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.s2CPlayers_); 
/*      */         return this.s2CPlayersBuilder_.getMessageList();
/*      */       }
/*      */       public int getS2CPlayersCount() {
/*      */         if (this.s2CPlayersBuilder_ == null)
/*      */           return this.s2CPlayers_.size(); 
/*      */         return this.s2CPlayersBuilder_.getCount();
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic getS2CPlayers(int index) {
/*      */         if (this.s2CPlayersBuilder_ == null)
/*      */           return this.s2CPlayers_.get(index); 
/*      */         return (PlayerOuterClass.PlayerBasic)this.s2CPlayersBuilder_.getMessage(index);
/*      */       }
/*      */       public Builder setS2CPlayers(int index, PlayerOuterClass.PlayerBasic value) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CPlayers(int index, PlayerOuterClass.PlayerBasic.Builder builderForValue) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CPlayers(PlayerOuterClass.PlayerBasic value) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CPlayers(int index, PlayerOuterClass.PlayerBasic value) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CPlayers(PlayerOuterClass.PlayerBasic.Builder builderForValue) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addS2CPlayers(int index, PlayerOuterClass.PlayerBasic.Builder builderForValue) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder addAllS2CPlayers(Iterable<? extends PlayerOuterClass.PlayerBasic> values) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           ensureS2CPlayersIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.s2CPlayers_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CPlayers() {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           this.s2CPlayers_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFF7;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public Builder removeS2CPlayers(int index) {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           ensureS2CPlayersIsMutable();
/*      */           this.s2CPlayers_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CPlayersBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic.Builder getS2CPlayersBuilder(int index) {
/*      */         return (PlayerOuterClass.PlayerBasic.Builder)getS2CPlayersFieldBuilder().getBuilder(index);
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int index) {
/*      */         if (this.s2CPlayersBuilder_ == null)
/*      */           return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayers_.get(index); 
/*      */         return (PlayerOuterClass.PlayerBasicOrBuilder)this.s2CPlayersBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */       public List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList() {
/*      */         if (this.s2CPlayersBuilder_ != null)
/*      */           return this.s2CPlayersBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.s2CPlayers_);
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic.Builder addS2CPlayersBuilder() {
/*      */         return (PlayerOuterClass.PlayerBasic.Builder)getS2CPlayersFieldBuilder().addBuilder((GeneratedMessage)PlayerOuterClass.PlayerBasic.getDefaultInstance());
/*      */       }
/*      */       public PlayerOuterClass.PlayerBasic.Builder addS2CPlayersBuilder(int index) {
/*      */         return (PlayerOuterClass.PlayerBasic.Builder)getS2CPlayersFieldBuilder().addBuilder(index, (GeneratedMessage)PlayerOuterClass.PlayerBasic.getDefaultInstance());
/*      */       }
/*      */       public List<PlayerOuterClass.PlayerBasic.Builder> getS2CPlayersBuilderList() {
/*      */         return getS2CPlayersFieldBuilder().getBuilderList();
/*      */       }
/*      */       private RepeatedFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersFieldBuilder() {
/*      */         if (this.s2CPlayersBuilder_ == null) {
/*      */           this.s2CPlayersBuilder_ = new RepeatedFieldBuilder(this.s2CPlayers_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*      */           this.s2CPlayers_ = null;
/*      */         } 
/*      */         return this.s2CPlayersBuilder_;
/*      */       } } }
/* 2279 */   public static final class ChangePlayerNameRequest extends GeneratedMessage implements ChangePlayerNameRequestOrBuilder { private static final ChangePlayerNameRequest defaultInstance = new ChangePlayerNameRequest(true); private final UnknownFieldSet unknownFields; private ChangePlayerNameRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChangePlayerNameRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChangePlayerNameRequest getDefaultInstance() { return defaultInstance; } public ChangePlayerNameRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChangePlayerNameRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SName_ = bs; break;case 16: this.bitField0_ |= 0x2; this.pos_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangePlayerNameRequest.class, Builder.class); } public static Parser<ChangePlayerNameRequest> PARSER = (Parser<ChangePlayerNameRequest>)new AbstractParser<ChangePlayerNameRequest>() { public RoleHandler.ChangePlayerNameRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.ChangePlayerNameRequest(input, extensionRegistry); } }
/* 2280 */     ; private int bitField0_; public static final int C2S_NAME_FIELD_NUMBER = 1; private Object c2SName_; public static final int POS_FIELD_NUMBER = 2; private int pos_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChangePlayerNameRequest> getParserForType() { return PARSER; } public boolean hasC2SName() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SName() { Object ref = this.c2SName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SName_ = s;  return s; } public ByteString getC2SNameBytes() { Object ref = this.c2SName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SName_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasPos() {
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
/*      */     public int getPos() {
/*      */       return this.pos_;
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
/*      */     private void initFields() {
/*      */       this.c2SName_ = "";
/*      */       this.pos_ = 0;
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
/*      */     public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1) {
/*      */         return true;
/*      */       }
/*      */       if (isInitialized == 0) {
/*      */         return false;
/*      */       }
/*      */       if (!hasC2SName()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasPos()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeBytes(1, getC2SNameBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.pos_);
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
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeBytesSize(1, getC2SNameBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.pos_);
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
/*      */     public static ChangePlayerNameRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(data);
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
/*      */     public static ChangePlayerNameRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static ChangePlayerNameRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(data);
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
/*      */     public static ChangePlayerNameRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static ChangePlayerNameRequest parseFrom(InputStream input) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(input);
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
/*      */     public static ChangePlayerNameRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangePlayerNameRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangePlayerNameRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangePlayerNameRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangePlayerNameRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public static Builder newBuilder(ChangePlayerNameRequest prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements RoleHandler.ChangePlayerNameRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Object c2SName_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private int pos_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.ChangePlayerNameRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.c2SName_ = "";
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
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.c2SName_ = "";
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
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.ChangePlayerNameRequest.alwaysUseFieldBuilders);
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.c2SName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.pos_ = 0;
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RoleHandler.ChangePlayerNameRequest getDefaultInstanceForType() {
/*      */         return RoleHandler.ChangePlayerNameRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RoleHandler.ChangePlayerNameRequest build() {
/*      */         RoleHandler.ChangePlayerNameRequest result = buildPartial();
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
/*      */       public RoleHandler.ChangePlayerNameRequest buildPartial() {
/*      */         RoleHandler.ChangePlayerNameRequest result = new RoleHandler.ChangePlayerNameRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SName_ = this.c2SName_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.pos_ = this.pos_;
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.ChangePlayerNameRequest) {
/*      */           return mergeFrom((RoleHandler.ChangePlayerNameRequest)other);
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
/*      */       public Builder mergeFrom(RoleHandler.ChangePlayerNameRequest other) {
/*      */         if (other == RoleHandler.ChangePlayerNameRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SName()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.c2SName_ = other.c2SName_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasPos()) {
/*      */           setPos(other.getPos());
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasC2SName()) {
/*      */           return false;
/*      */         }
/*      */         if (!hasPos()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.ChangePlayerNameRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.ChangePlayerNameRequest)RoleHandler.ChangePlayerNameRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.ChangePlayerNameRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasC2SName() {
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
/*      */       public String getC2SName() {
/*      */         Object ref = this.c2SName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SName_ = s;
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
/*      */       public ByteString getC2SNameBytes() {
/*      */         Object ref = this.c2SName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SName_ = b;
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
/*      */       public Builder setC2SName(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SName_ = value;
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
/*      */       public Builder clearC2SName() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SName_ = RoleHandler.ChangePlayerNameRequest.getDefaultInstance().getC2SName();
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
/*      */       public Builder setC2SNameBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SName_ = value;
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
/*      */       public boolean hasPos() {
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
/*      */       public int getPos() {
/*      */         return this.pos_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPos(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.pos_ = value;
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
/*      */       public Builder clearPos() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.pos_ = 0;
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
/*      */   public static final class ChangePlayerNameResponse
/*      */     extends GeneratedMessage
/*      */     implements ChangePlayerNameResponseOrBuilder
/*      */   {
/* 2998 */     private static final ChangePlayerNameResponse defaultInstance = new ChangePlayerNameResponse(true); private final UnknownFieldSet unknownFields; private ChangePlayerNameResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChangePlayerNameResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChangePlayerNameResponse getDefaultInstance() { return defaultInstance; } public ChangePlayerNameResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChangePlayerNameResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CName_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangePlayerNameResponse.class, Builder.class); } public static Parser<ChangePlayerNameResponse> PARSER = (Parser<ChangePlayerNameResponse>)new AbstractParser<ChangePlayerNameResponse>() { public RoleHandler.ChangePlayerNameResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.ChangePlayerNameResponse(input, extensionRegistry); } }
/* 2999 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_NAME_FIELD_NUMBER = 3; private Object s2CName_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChangePlayerNameResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*      */     public boolean hasS2CName() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */     
/*      */     public String getS2CName() {
/*      */       Object ref = this.s2CName_;
/*      */       if (ref instanceof String)
/*      */         return (String)ref; 
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8())
/*      */         this.s2CName_ = s; 
/*      */       return s;
/*      */     }
/*      */     
/*      */     public ByteString getS2CNameBytes() {
/*      */       Object ref = this.s2CName_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CName_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CName_ = "";
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
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeBytes(3, getS2CNameBytes()); 
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
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeBytesSize(3, getS2CNameBytes()); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(data);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(InputStream input) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(input);
/*      */     }
/*      */     
/*      */     public static ChangePlayerNameResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangePlayerNameResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(ChangePlayerNameResponse prototype) {
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
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements RoleHandler.ChangePlayerNameResponseOrBuilder { private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private Object s2CName_;
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameResponse_descriptor;
/*      */       }
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.ChangePlayerNameResponse.class, Builder.class);
/*      */       }
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.ChangePlayerNameResponse.alwaysUseFieldBuilders);
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
/*      */         this.s2CName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_ChangePlayerNameResponse_descriptor;
/*      */       }
/*      */       
/*      */       public RoleHandler.ChangePlayerNameResponse getDefaultInstanceForType() {
/*      */         return RoleHandler.ChangePlayerNameResponse.getDefaultInstance();
/*      */       }
/*      */       
/*      */       public RoleHandler.ChangePlayerNameResponse build() {
/*      */         RoleHandler.ChangePlayerNameResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       }
/*      */       
/*      */       public RoleHandler.ChangePlayerNameResponse buildPartial() {
/*      */         RoleHandler.ChangePlayerNameResponse result = new RoleHandler.ChangePlayerNameResponse(this);
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
/*      */         result.s2CName_ = this.s2CName_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.ChangePlayerNameResponse)
/*      */           return mergeFrom((RoleHandler.ChangePlayerNameResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder mergeFrom(RoleHandler.ChangePlayerNameResponse other) {
/*      */         if (other == RoleHandler.ChangePlayerNameResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CName()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.s2CName_ = other.s2CName_;
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
/*      */         RoleHandler.ChangePlayerNameResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.ChangePlayerNameResponse)RoleHandler.ChangePlayerNameResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.ChangePlayerNameResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = RoleHandler.ChangePlayerNameResponse.getDefaultInstance().getS2CMsg();
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
/*      */       public boolean hasS2CName() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public String getS2CName() {
/*      */         Object ref = this.s2CName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.s2CName_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CNameBytes() {
/*      */         Object ref = this.s2CName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CName_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CName(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CName() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CName_ = RoleHandler.ChangePlayerNameResponse.getDefaultInstance().getS2CName();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CNameBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } }
/*      */   }
/*      */   
/*      */   public static final class GetRandomNameRequest extends GeneratedMessage implements GetRandomNameRequestOrBuilder {
/* 3403 */     private static final GetRandomNameRequest defaultInstance = new GetRandomNameRequest(true); private final UnknownFieldSet unknownFields; private GetRandomNameRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRandomNameRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRandomNameRequest getDefaultInstance() { return defaultInstance; } public GetRandomNameRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRandomNameRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SPro_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_GetRandomNameRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_GetRandomNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRandomNameRequest.class, Builder.class); } public static Parser<GetRandomNameRequest> PARSER = (Parser<GetRandomNameRequest>)new AbstractParser<GetRandomNameRequest>() { public RoleHandler.GetRandomNameRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.GetRandomNameRequest(input, extensionRegistry); } }
/* 3404 */     ; private int bitField0_; public static final int C2S_PRO_FIELD_NUMBER = 1; private int c2SPro_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRandomNameRequest> getParserForType() { return PARSER; } public boolean hasC2SPro() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SPro() { return this.c2SPro_; } private void initFields() { this.c2SPro_ = 0; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */       if (!hasC2SPro()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.c2SPro_);
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
/*      */     public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1) {
/*      */         return size;
/*      */       }
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         size += CodedOutputStream.computeInt32Size(1, this.c2SPro_);
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
/*      */     public static GetRandomNameRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(data);
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
/*      */     public static GetRandomNameRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static GetRandomNameRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(data);
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
/*      */     public static GetRandomNameRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*      */     public static GetRandomNameRequest parseFrom(InputStream input) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(input);
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
/*      */     public static GetRandomNameRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static GetRandomNameRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseDelimitedFrom(input);
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
/*      */     public static GetRandomNameRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*      */     public static GetRandomNameRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(input);
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
/*      */     public static GetRandomNameRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(GetRandomNameRequest prototype) {
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements RoleHandler.GetRandomNameRequestOrBuilder
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
/*      */       private int c2SPro_;
/*      */ 
/*      */ 
/*      */ 
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
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameRequest_descriptor;
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
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.GetRandomNameRequest.class, Builder.class);
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
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.GetRandomNameRequest.alwaysUseFieldBuilders);
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.c2SPro_ = 0;
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameRequest_descriptor;
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
/*      */       public RoleHandler.GetRandomNameRequest getDefaultInstanceForType() {
/*      */         return RoleHandler.GetRandomNameRequest.getDefaultInstance();
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
/*      */       public RoleHandler.GetRandomNameRequest build() {
/*      */         RoleHandler.GetRandomNameRequest result = buildPartial();
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
/*      */       public RoleHandler.GetRandomNameRequest buildPartial() {
/*      */         RoleHandler.GetRandomNameRequest result = new RoleHandler.GetRandomNameRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SPro_ = this.c2SPro_;
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
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.GetRandomNameRequest) {
/*      */           return mergeFrom((RoleHandler.GetRandomNameRequest)other);
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
/*      */       public Builder mergeFrom(RoleHandler.GetRandomNameRequest other) {
/*      */         if (other == RoleHandler.GetRandomNameRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SPro()) {
/*      */           setC2SPro(other.getC2SPro());
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
/*      */       public final boolean isInitialized() {
/*      */         if (!hasC2SPro()) {
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.GetRandomNameRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.GetRandomNameRequest)RoleHandler.GetRandomNameRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.GetRandomNameRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasC2SPro() {
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
/*      */       public int getC2SPro() {
/*      */         return this.c2SPro_;
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
/*      */       public Builder setC2SPro(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SPro_ = value;
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
/*      */       public Builder clearC2SPro() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SPro_ = 0;
/*      */         onChanged();
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
/*      */   public static final class GetRandomNameResponse
/*      */     extends GeneratedMessage
/*      */     implements GetRandomNameResponseOrBuilder
/*      */   {
/* 4122 */     private static final GetRandomNameResponse defaultInstance = new GetRandomNameResponse(true); private final UnknownFieldSet unknownFields; private GetRandomNameResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private GetRandomNameResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static GetRandomNameResponse getDefaultInstance() { return defaultInstance; } public GetRandomNameResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private GetRandomNameResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.s2CName_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_GetRandomNameResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_GetRandomNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRandomNameResponse.class, Builder.class); } public static Parser<GetRandomNameResponse> PARSER = (Parser<GetRandomNameResponse>)new AbstractParser<GetRandomNameResponse>() { public RoleHandler.GetRandomNameResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.GetRandomNameResponse(input, extensionRegistry); } }
/* 4123 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_NAME_FIELD_NUMBER = 3; private Object s2CName_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<GetRandomNameResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*      */     public boolean hasS2CName() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getS2CName() {
/*      */       Object ref = this.s2CName_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.s2CName_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */     
/*      */     public ByteString getS2CNameBytes() {
/*      */       Object ref = this.s2CName_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CName_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CName_ = "";
/*      */     }
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.s2CCode_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeBytes(2, getS2CMsgBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeBytes(3, getS2CNameBytes());
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeBytesSize(3, getS2CNameBytes());
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(InputStream input) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */     
/*      */     public static GetRandomNameResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (GetRandomNameResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     }
/*      */ 
/*      */     
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(GetRandomNameResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
/*      */ 
/*      */     
/*      */     public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements RoleHandler.GetRandomNameResponseOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */       
/*      */       private int s2CCode_;
/*      */       
/*      */       private Object s2CMsg_;
/*      */       
/*      */       private Object s2CName_;
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.GetRandomNameResponse.class, Builder.class);
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CName_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.GetRandomNameResponse.alwaysUseFieldBuilders);
/*      */       }
/*      */ 
/*      */       
/*      */       private static Builder create() {
/*      */         return new Builder();
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CName_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       }
/*      */ 
/*      */       
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return RoleHandler.internal_static_pomelo_connector_GetRandomNameResponse_descriptor;
/*      */       }
/*      */ 
/*      */       
/*      */       public RoleHandler.GetRandomNameResponse getDefaultInstanceForType() {
/*      */         return RoleHandler.GetRandomNameResponse.getDefaultInstance();
/*      */       }
/*      */ 
/*      */       
/*      */       public RoleHandler.GetRandomNameResponse build() {
/*      */         RoleHandler.GetRandomNameResponse result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public RoleHandler.GetRandomNameResponse buildPartial() {
/*      */         RoleHandler.GetRandomNameResponse result = new RoleHandler.GetRandomNameResponse(this);
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
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.s2CName_ = this.s2CName_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.GetRandomNameResponse) {
/*      */           return mergeFrom((RoleHandler.GetRandomNameResponse)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(RoleHandler.GetRandomNameResponse other) {
/*      */         if (other == RoleHandler.GetRandomNameResponse.getDefaultInstance()) {
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
/*      */         if (other.hasS2CName()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.s2CName_ = other.s2CName_;
/*      */           onChanged();
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
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
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.GetRandomNameResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.GetRandomNameResponse)RoleHandler.GetRandomNameResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.GetRandomNameResponse)e.getUnfinishedMessage();
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
/*      */           if (bs.isValidUtf8()) {
/*      */             this.s2CMsg_ = s;
/*      */           }
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
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x2;
/*      */         this.s2CMsg_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CMsg() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.s2CMsg_ = RoleHandler.GetRandomNameResponse.getDefaultInstance().getS2CMsg();
/*      */         onChanged();
/*      */         return this;
/*      */       }
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
/*      */       
/*      */       public boolean hasS2CName() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       
/*      */       public String getS2CName() {
/*      */         Object ref = this.s2CName_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.s2CName_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */       
/*      */       public ByteString getS2CNameBytes() {
/*      */         Object ref = this.s2CName_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.s2CName_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */       
/*      */       public Builder setS2CName(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder clearS2CName() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.s2CName_ = RoleHandler.GetRandomNameResponse.getDefaultInstance().getS2CName();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       
/*      */       public Builder setS2CNameBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x4;
/*      */         this.s2CName_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class DeletePlayerRequest
/*      */     extends GeneratedMessage
/*      */     implements DeletePlayerRequestOrBuilder
/*      */   {
/* 4606 */     private static final DeletePlayerRequest defaultInstance = new DeletePlayerRequest(true); private final UnknownFieldSet unknownFields; private DeletePlayerRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DeletePlayerRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DeletePlayerRequest getDefaultInstance() { return defaultInstance; } public DeletePlayerRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DeletePlayerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.c2SPlayerId_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_DeletePlayerRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_DeletePlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DeletePlayerRequest.class, Builder.class); } public static Parser<DeletePlayerRequest> PARSER = (Parser<DeletePlayerRequest>)new AbstractParser<DeletePlayerRequest>() { public RoleHandler.DeletePlayerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new RoleHandler.DeletePlayerRequest(input, extensionRegistry); } }
/* 4607 */     ; private int bitField0_; public static final int C2S_PLAYERID_FIELD_NUMBER = 1; private Object c2SPlayerId_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DeletePlayerRequest> getParserForType() { return PARSER; } public boolean hasC2SPlayerId() { return ((this.bitField0_ & 0x1) == 1); } public String getC2SPlayerId() { Object ref = this.c2SPlayerId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.c2SPlayerId_ = s;  return s; } public ByteString getC2SPlayerIdBytes() { Object ref = this.c2SPlayerId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.c2SPlayerId_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.c2SPlayerId_ = "";
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
/*      */       if (!hasC2SPlayerId()) {
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
/*      */         output.writeBytes(1, getC2SPlayerIdBytes());
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeBytesSize(1, getC2SPlayerIdBytes());
/*      */       }
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     }
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
/*      */     public static DeletePlayerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(InputStream input) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DeletePlayerRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(DeletePlayerRequest prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements RoleHandler.DeletePlayerRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */       
/*      */       private Object c2SPlayerId_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return RoleHandler.internal_static_pomelo_connector_DeletePlayerRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return RoleHandler.internal_static_pomelo_connector_DeletePlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.DeletePlayerRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.c2SPlayerId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.c2SPlayerId_ = "";
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (RoleHandler.DeletePlayerRequest.alwaysUseFieldBuilders);
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
/*      */         this.c2SPlayerId_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFE;
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
/*      */         return RoleHandler.internal_static_pomelo_connector_DeletePlayerRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RoleHandler.DeletePlayerRequest getDefaultInstanceForType() {
/*      */         return RoleHandler.DeletePlayerRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RoleHandler.DeletePlayerRequest build() {
/*      */         RoleHandler.DeletePlayerRequest result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public RoleHandler.DeletePlayerRequest buildPartial() {
/*      */         RoleHandler.DeletePlayerRequest result = new RoleHandler.DeletePlayerRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.c2SPlayerId_ = this.c2SPlayerId_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof RoleHandler.DeletePlayerRequest) {
/*      */           return mergeFrom((RoleHandler.DeletePlayerRequest)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(RoleHandler.DeletePlayerRequest other) {
/*      */         if (other == RoleHandler.DeletePlayerRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SPlayerId()) {
/*      */           this.bitField0_ |= 0x1;
/*      */           this.c2SPlayerId_ = other.c2SPlayerId_;
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
/*      */         if (!hasC2SPlayerId()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         RoleHandler.DeletePlayerRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (RoleHandler.DeletePlayerRequest)RoleHandler.DeletePlayerRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (RoleHandler.DeletePlayerRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasC2SPlayerId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getC2SPlayerId() {
/*      */         Object ref = this.c2SPlayerId_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.c2SPlayerId_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getC2SPlayerIdBytes() {
/*      */         Object ref = this.c2SPlayerId_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.c2SPlayerId_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SPlayerId(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SPlayerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearC2SPlayerId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.c2SPlayerId_ = RoleHandler.DeletePlayerRequest.getDefaultInstance().getC2SPlayerId();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SPlayerIdBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x1;
/*      */         this.c2SPlayerId_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DeletePlayerResponse
/*      */     extends GeneratedMessage
/*      */     implements DeletePlayerResponseOrBuilder
/*      */   {
/*      */     private final UnknownFieldSet unknownFields;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private DeletePlayerResponse(GeneratedMessage.Builder<?> builder) {
/*      */       super(builder);
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = builder.getUnknownFields();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private DeletePlayerResponse(boolean noInit) {
/*      */       this.memoizedIsInitialized = -1;
/*      */       this.memoizedSerializedSize = -1;
/*      */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DeletePlayerResponse getDefaultInstance() {
/*      */       return defaultInstance;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DeletePlayerResponse getDefaultInstanceForType() {
/*      */       return defaultInstance;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final UnknownFieldSet getUnknownFields() {
/*      */       return this.unknownFields;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private DeletePlayerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final Descriptors.Descriptor getDescriptor() {
/*      */       return RoleHandler.internal_static_pomelo_connector_DeletePlayerResponse_descriptor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */       return RoleHandler.internal_static_pomelo_connector_DeletePlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DeletePlayerResponse.class, Builder.class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Parser<DeletePlayerResponse> PARSER = (Parser<DeletePlayerResponse>)new AbstractParser<DeletePlayerResponse>()
/*      */       {
/*      */         public RoleHandler.DeletePlayerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */           return new RoleHandler.DeletePlayerResponse(input, extensionRegistry);
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int bitField0_;
/*      */ 
/*      */ 
/*      */     
/*      */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*      */ 
/*      */ 
/*      */     
/*      */     private int s2CCode_;
/*      */ 
/*      */ 
/*      */     
/*      */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*      */ 
/*      */ 
/*      */     
/*      */     private Object s2CMsg_;
/*      */ 
/*      */ 
/*      */     
/*      */     private byte memoizedIsInitialized;
/*      */ 
/*      */ 
/*      */     
/*      */     private int memoizedSerializedSize;
/*      */ 
/*      */ 
/*      */     
/* 5168 */     private static final DeletePlayerResponse defaultInstance = new DeletePlayerResponse(true);
/* 5169 */     private static final long serialVersionUID = 0L; public Parser<DeletePlayerResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DeletePlayerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DeletePlayerResponse)PARSER.parseFrom(data); } public static DeletePlayerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DeletePlayerResponse)PARSER.parseFrom(data, extensionRegistry); } public static DeletePlayerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DeletePlayerResponse)PARSER.parseFrom(data); } public static DeletePlayerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DeletePlayerResponse)PARSER.parseFrom(data, extensionRegistry); } public static DeletePlayerResponse parseFrom(InputStream input) throws IOException { return (DeletePlayerResponse)PARSER.parseFrom(input); } public static DeletePlayerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeletePlayerResponse)PARSER.parseFrom(input, extensionRegistry); } public static DeletePlayerResponse parseDelimitedFrom(InputStream input) throws IOException { return (DeletePlayerResponse)PARSER.parseDelimitedFrom(input); } public static DeletePlayerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeletePlayerResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DeletePlayerResponse parseFrom(CodedInputStream input) throws IOException { return (DeletePlayerResponse)PARSER.parseFrom(input); } public static DeletePlayerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeletePlayerResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DeletePlayerResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } static { defaultInstance.initFields(); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements RoleHandler.DeletePlayerResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return RoleHandler.internal_static_pomelo_connector_DeletePlayerResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return RoleHandler.internal_static_pomelo_connector_DeletePlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RoleHandler.DeletePlayerResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (RoleHandler.DeletePlayerResponse.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return RoleHandler.internal_static_pomelo_connector_DeletePlayerResponse_descriptor; }
/*      */       public RoleHandler.DeletePlayerResponse getDefaultInstanceForType() { return RoleHandler.DeletePlayerResponse.getDefaultInstance(); }
/*      */       public RoleHandler.DeletePlayerResponse build() { RoleHandler.DeletePlayerResponse result = buildPartial(); if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result);  return result; }
/*      */       public RoleHandler.DeletePlayerResponse buildPartial() { RoleHandler.DeletePlayerResponse result = new RoleHandler.DeletePlayerResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof RoleHandler.DeletePlayerResponse)
/*      */           return mergeFrom((RoleHandler.DeletePlayerResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(RoleHandler.DeletePlayerResponse other) { if (other == RoleHandler.DeletePlayerResponse.getDefaultInstance())
/*      */           return this;  if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }
/*      */          mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode())
/*      */           return false;  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { RoleHandler.DeletePlayerResponse parsedMessage = null; try { parsedMessage = (RoleHandler.DeletePlayerResponse)RoleHandler.DeletePlayerResponse.PARSER.parsePartialFrom(input, extensionRegistry); }
/*      */         catch (InvalidProtocolBufferException e)
/*      */         { parsedMessage = (RoleHandler.DeletePlayerResponse)e.getUnfinishedMessage(); throw e; }
/*      */         finally
/*      */         { if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage);  }
/*      */          return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*      */             this.s2CMsg_ = s;  return s;
/*      */         }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b;
/*      */         }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = RoleHandler.DeletePlayerResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*      */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } }
/* 5218 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 5223 */     String[] descriptorData = { "\n\021roleHandler.proto\022\020pomelo.connector\032\fplayer.proto\"8\n\023CreatePlayerRequest\022\017\n\007c2s_pro\030\001 \002(\005\022\020\n\bc2s_name\030\002 \002(\t\"\001\n\024CreatePlayerResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\ns2c_player\030\003 \001(\0132\032.pomelo.player.PlayerBasic\022/\n\013s2c_players\030\004 \003(\0132\032.pomelo.player.PlayerBasic\"8\n\027ChangePlayerNameRequest\022\020\n\bc2s_name\030\001 \002(\t\022\013\n\003pos\030\002 \002(\005\"O\n\030ChangePlayerNameResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_name\030", "\003 \001(\t\"'\n\024GetRandomNameRequest\022\017\n\007c2s_pro\030\001 \002(\005\"L\n\025GetRandomNameResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_name\030\003 \001(\t\"+\n\023DeletePlayerRequest\022\024\n\fc2s_playerId\030\001 \002(\t\"9\n\024DeletePlayerResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2´\003\n\013roleHandler\022d\n\023createPlayerRequest\022%.pomelo.connector.CreatePlayerRequest\032&.pomelo.connector.CreatePlayerResponse\022p\n\027changePlayerNameRequest\022).pomelo.connector.ChangeP", "layerNameRequest\032*.pomelo.connector.ChangePlayerNameResponse\022d\n\023deletePlayerRequest\022%.pomelo.connector.DeletePlayerRequest\032&.pomelo.connector.DeletePlayerResponse\022g\n\024getRandomNameRequest\022&.pomelo.connector.GetRandomNameRequest\032'.pomelo.connector.GetRandomNameResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5252 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 5256 */           RoleHandler.descriptor = root;
/* 5257 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 5261 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 5263 */           PlayerOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 5266 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_CreatePlayerRequest_descriptor = getDescriptor().getMessageTypes().get(0);
/* 5267 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_CreatePlayerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_CreatePlayerRequest_descriptor, new String[] { "C2SPro", "C2SName" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5272 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_CreatePlayerResponse_descriptor = getDescriptor().getMessageTypes().get(1);
/* 5273 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_CreatePlayerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_CreatePlayerResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CPlayer", "S2CPlayers" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5278 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_ChangePlayerNameRequest_descriptor = getDescriptor().getMessageTypes().get(2);
/* 5279 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_ChangePlayerNameRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_ChangePlayerNameRequest_descriptor, new String[] { "C2SName", "Pos" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5284 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_ChangePlayerNameResponse_descriptor = getDescriptor().getMessageTypes().get(3);
/* 5285 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_ChangePlayerNameResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_ChangePlayerNameResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CName" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5290 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_GetRandomNameRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 5291 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_GetRandomNameRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_GetRandomNameRequest_descriptor, new String[] { "C2SPro" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5296 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_GetRandomNameResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 5297 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_GetRandomNameResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_GetRandomNameResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CName" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5302 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_DeletePlayerRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 5303 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_DeletePlayerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_DeletePlayerRequest_descriptor, new String[] { "C2SPlayerId" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 5308 */   private static final Descriptors.Descriptor internal_static_pomelo_connector_DeletePlayerResponse_descriptor = getDescriptor().getMessageTypes().get(7);
/* 5309 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_DeletePlayerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_DeletePlayerResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 5313 */     PlayerOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface DeletePlayerResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface DeletePlayerRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SPlayerId();
/*      */     
/*      */     String getC2SPlayerId();
/*      */     
/*      */     ByteString getC2SPlayerIdBytes();
/*      */   }
/*      */   
/*      */   public static interface GetRandomNameResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CName();
/*      */     
/*      */     String getS2CName();
/*      */     
/*      */     ByteString getS2CNameBytes();
/*      */   }
/*      */   
/*      */   public static interface GetRandomNameRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SPro();
/*      */     
/*      */     int getC2SPro();
/*      */   }
/*      */   
/*      */   public static interface ChangePlayerNameResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CName();
/*      */     
/*      */     String getS2CName();
/*      */     
/*      */     ByteString getS2CNameBytes();
/*      */   }
/*      */   
/*      */   public static interface ChangePlayerNameRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SName();
/*      */     
/*      */     String getC2SName();
/*      */     
/*      */     ByteString getC2SNameBytes();
/*      */     
/*      */     boolean hasPos();
/*      */     
/*      */     int getPos();
/*      */   }
/*      */   
/*      */   public static interface CreatePlayerResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CPlayer();
/*      */     
/*      */     PlayerOuterClass.PlayerBasic getS2CPlayer();
/*      */     
/*      */     PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayerOrBuilder();
/*      */     
/*      */     List<PlayerOuterClass.PlayerBasic> getS2CPlayersList();
/*      */     
/*      */     PlayerOuterClass.PlayerBasic getS2CPlayers(int param1Int);
/*      */     
/*      */     int getS2CPlayersCount();
/*      */     
/*      */     List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList();
/*      */     
/*      */     PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface CreatePlayerRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SPro();
/*      */     
/*      */     int getC2SPro();
/*      */     
/*      */     boolean hasC2SName();
/*      */     
/*      */     String getC2SName();
/*      */     
/*      */     ByteString getC2SNameBytes();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\connector\RoleHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */