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
/*       */ import com.google.protobuf.SingleFieldBuilder;
/*       */ import com.google.protobuf.UnknownFieldSet;
/*       */ import java.io.IOException;
/*       */ import java.io.InputStream;
/*       */ import java.io.ObjectStreamException;
/*       */ import pomelo.Common;
/*       */ import pomelo.item.ItemOuterClass;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class GuildDepotHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class UseCond
/*       */     extends GeneratedMessage
/*       */     implements UseCondOrBuilder
/*       */   {
/*   573 */     private static final UseCond defaultInstance = new UseCond(true); private final UnknownFieldSet unknownFields; private UseCond(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UseCond(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UseCond getDefaultInstance() { return defaultInstance; } public UseCond getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UseCond(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.level_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.upLevel_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.job_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_UseCond_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_UseCond_fieldAccessorTable.ensureFieldAccessorsInitialized(UseCond.class, Builder.class); } public static Parser<UseCond> PARSER = (Parser<UseCond>)new AbstractParser<UseCond>() { public GuildDepotHandler.UseCond parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.UseCond(input, extensionRegistry); } }
/*   574 */     ; private int bitField0_; public static final int LEVEL_FIELD_NUMBER = 1; private int level_; public static final int UPLEVEL_FIELD_NUMBER = 2; private int upLevel_; public static final int JOB_FIELD_NUMBER = 3; private int job_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UseCond> getParserForType() { return PARSER; } public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getLevel() { return this.level_; } public boolean hasUpLevel() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getUpLevel() {
/*       */       return this.upLevel_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasJob() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getJob() {
/*       */       return this.job_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.level_ = 0;
/*       */       this.upLevel_ = 0;
/*       */       this.job_ = 0;
/*       */     }
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
/*       */       if (!hasJob()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.upLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(3, this.job_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.level_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.upLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.job_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UseCond)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UseCond)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UseCond)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UseCond)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(InputStream input) throws IOException {
/*       */       return (UseCond)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseCond)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UseCond)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseCond)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UseCond)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static UseCond parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UseCond)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(UseCond prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
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
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements GuildDepotHandler.UseCondOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int level_;
/*       */ 
/*       */       
/*       */       private int upLevel_;
/*       */ 
/*       */       
/*       */       private int job_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UseCond_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UseCond_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.UseCond.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.UseCond.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.level_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.upLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.job_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UseCond_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.UseCond getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.UseCond.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.UseCond build() {
/*       */         GuildDepotHandler.UseCond result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.UseCond buildPartial() {
/*       */         GuildDepotHandler.UseCond result = new GuildDepotHandler.UseCond(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.level_ = this.level_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.upLevel_ = this.upLevel_;
/*       */         if ((from_bitField0_ & 0x4) == 4) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.job_ = this.job_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.UseCond) {
/*       */           return mergeFrom((GuildDepotHandler.UseCond)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(GuildDepotHandler.UseCond other) {
/*       */         if (other == GuildDepotHandler.UseCond.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasLevel()) {
/*       */           setLevel(other.getLevel());
/*       */         }
/*       */         if (other.hasUpLevel()) {
/*       */           setUpLevel(other.getUpLevel());
/*       */         }
/*       */         if (other.hasJob()) {
/*       */           setJob(other.getJob());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasJob()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.UseCond parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.UseCond)GuildDepotHandler.UseCond.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.UseCond)e.getUnfinishedMessage();
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
/*       */       public boolean hasLevel() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getLevel() {
/*       */         return this.level_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setLevel(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.level_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.level_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasUpLevel() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getUpLevel() {
/*       */         return this.upLevel_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setUpLevel(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.upLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearUpLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.upLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasJob() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getJob() {
/*       */         return this.job_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setJob(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.job_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearJob() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.job_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class QualityCond
/*       */     extends GeneratedMessage
/*       */     implements QualityCondOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */     
/*       */     private QualityCond(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */ 
/*       */     
/*       */     private QualityCond(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */ 
/*       */     
/*       */     public static QualityCond getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */     
/*       */     public QualityCond getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */ 
/*       */     
/*       */     private QualityCond(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       initFields();
/*       */       int mutable_bitField0_ = 0;
/*       */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*       */       try {
/*       */         boolean done = false;
/*       */         while (!done) {
/*       */           int tag = input.readTag();
/*       */           switch (tag) {
/*       */             case 0:
/*       */               done = true;
/*       */               break;
/*       */             case 8:
/*       */               this.bitField0_ |= 0x1;
/*       */               this.level_ = input.readInt32();
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.upLevel_ = input.readInt32();
/*       */               break;
/*       */             case 24:
/*       */               this.bitField0_ |= 0x4;
/*       */               this.qColor_ = input.readInt32();
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
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return GuildDepotHandler.internal_static_pomelo_area_QualityCond_descriptor;
/*       */     }
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return GuildDepotHandler.internal_static_pomelo_area_QualityCond_fieldAccessorTable.ensureFieldAccessorsInitialized(QualityCond.class, Builder.class);
/*       */     }
/*       */ 
/*       */     
/*       */     public static Parser<QualityCond> PARSER = (Parser<QualityCond>)new AbstractParser<QualityCond>()
/*       */       {
/*       */         public GuildDepotHandler.QualityCond parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new GuildDepotHandler.QualityCond(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */     
/*       */     public static final int LEVEL_FIELD_NUMBER = 1;
/*       */     
/*       */     private int level_;
/*       */     
/*       */     public static final int UPLEVEL_FIELD_NUMBER = 2;
/*       */     
/*       */     private int upLevel_;
/*       */     
/*       */     public static final int QCOLOR_FIELD_NUMBER = 3;
/*       */     
/*       */     private int qColor_;
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */     
/*       */     public Parser<QualityCond> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasLevel() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getLevel() {
/*       */       return this.level_;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasUpLevel() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */ 
/*       */     
/*  1134 */     private static final QualityCond defaultInstance = new QualityCond(true); public int getUpLevel() { return this.upLevel_; } public boolean hasQColor() { return ((this.bitField0_ & 0x4) == 4); } public int getQColor() { return this.qColor_; } private void initFields() { this.level_ = 0; this.upLevel_ = 0; this.qColor_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.level_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.upLevel_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.qColor_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.level_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.upLevel_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.qColor_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static QualityCond parseFrom(ByteString data) throws InvalidProtocolBufferException { return (QualityCond)PARSER.parseFrom(data); } public static QualityCond parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QualityCond)PARSER.parseFrom(data, extensionRegistry); } public static QualityCond parseFrom(byte[] data) throws InvalidProtocolBufferException { return (QualityCond)PARSER.parseFrom(data); } public static QualityCond parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (QualityCond)PARSER.parseFrom(data, extensionRegistry); } public static QualityCond parseFrom(InputStream input) throws IOException { return (QualityCond)PARSER.parseFrom(input); } public static QualityCond parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QualityCond)PARSER.parseFrom(input, extensionRegistry); } public static QualityCond parseDelimitedFrom(InputStream input) throws IOException { return (QualityCond)PARSER.parseDelimitedFrom(input); } public static QualityCond parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QualityCond)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static QualityCond parseFrom(CodedInputStream input) throws IOException { return (QualityCond)PARSER.parseFrom(input); } public static QualityCond parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (QualityCond)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(QualityCond prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.QualityCondOrBuilder {
/*  1135 */       private int bitField0_; private int level_; private int upLevel_; private int qColor_; public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_QualityCond_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_QualityCond_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.QualityCond.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.QualityCond.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.level_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.upLevel_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.qColor_ = 0; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_QualityCond_descriptor; } public GuildDepotHandler.QualityCond getDefaultInstanceForType() { return GuildDepotHandler.QualityCond.getDefaultInstance(); } public GuildDepotHandler.QualityCond build() { GuildDepotHandler.QualityCond result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.QualityCond buildPartial() { GuildDepotHandler.QualityCond result = new GuildDepotHandler.QualityCond(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.level_ = this.level_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.upLevel_ = this.upLevel_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.qColor_ = this.qColor_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.QualityCond) return mergeFrom((GuildDepotHandler.QualityCond)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.QualityCond other) { if (other == GuildDepotHandler.QualityCond.getDefaultInstance()) return this;  if (other.hasLevel()) setLevel(other.getLevel());  if (other.hasUpLevel()) setUpLevel(other.getUpLevel());  if (other.hasQColor()) setQColor(other.getQColor());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.QualityCond parsedMessage = null; try { parsedMessage = (GuildDepotHandler.QualityCond)GuildDepotHandler.QualityCond.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.QualityCond)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getLevel() { return this.level_; } public Builder setLevel(int value) { this.bitField0_ |= 0x1; this.level_ = value; onChanged(); return this; } public Builder clearLevel() { this.bitField0_ &= 0xFFFFFFFE; this.level_ = 0; onChanged(); return this; } public boolean hasUpLevel() { return ((this.bitField0_ & 0x2) == 2); } public int getUpLevel() { return this.upLevel_; } public Builder setUpLevel(int value) { this.bitField0_ |= 0x2; this.upLevel_ = value; onChanged(); return this; } public Builder clearUpLevel() { this.bitField0_ &= 0xFFFFFFFD; this.upLevel_ = 0; onChanged(); return this; } public boolean hasQColor() { return ((this.bitField0_ & 0x4) == 4); } public int getQColor() { return this.qColor_; } public Builder setQColor(int value) { this.bitField0_ |= 0x4; this.qColor_ = value; onChanged(); return this; } public Builder clearQColor() { this.bitField0_ &= 0xFFFFFFFB; this.qColor_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class DepotCondition
/*       */     extends GeneratedMessage
/*       */     implements DepotConditionOrBuilder
/*       */   {
/*  2212 */     private static final DepotCondition defaultInstance = new DepotCondition(true); private final UnknownFieldSet unknownFields; private DepotCondition(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DepotCondition(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DepotCondition getDefaultInstance() { return defaultInstance; } public DepotCondition getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DepotCondition(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { GuildDepotHandler.UseCond.Builder builder; GuildDepotHandler.QualityCond.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: builder = null; if ((this.bitField0_ & 0x1) == 1) builder = this.useCond_.toBuilder();  this.useCond_ = (GuildDepotHandler.UseCond)input.readMessage(GuildDepotHandler.UseCond.PARSER, extensionRegistry); if (builder != null) { builder.mergeFrom(this.useCond_); this.useCond_ = builder.buildPartial(); }  this.bitField0_ |= 0x1; break;case 18: subBuilder = null; if ((this.bitField0_ & 0x2) == 2) subBuilder = this.minCond_.toBuilder();  this.minCond_ = (GuildDepotHandler.QualityCond)input.readMessage(GuildDepotHandler.QualityCond.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.minCond_); this.minCond_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x2; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.maxCond_.toBuilder();  this.maxCond_ = (GuildDepotHandler.QualityCond)input.readMessage(GuildDepotHandler.QualityCond.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.maxCond_); this.maxCond_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepotCondition_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepotCondition_fieldAccessorTable.ensureFieldAccessorsInitialized(DepotCondition.class, Builder.class); } public static Parser<DepotCondition> PARSER = (Parser<DepotCondition>)new AbstractParser<DepotCondition>() { public GuildDepotHandler.DepotCondition parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DepotCondition(input, extensionRegistry); } }
/*  2213 */     ; private int bitField0_; public static final int USECOND_FIELD_NUMBER = 1; private GuildDepotHandler.UseCond useCond_; public static final int MINCOND_FIELD_NUMBER = 2; private GuildDepotHandler.QualityCond minCond_; public static final int MAXCOND_FIELD_NUMBER = 3; private GuildDepotHandler.QualityCond maxCond_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DepotCondition> getParserForType() { return PARSER; } public boolean hasUseCond() { return ((this.bitField0_ & 0x1) == 1); } public GuildDepotHandler.UseCond getUseCond() { return this.useCond_; } public GuildDepotHandler.UseCondOrBuilder getUseCondOrBuilder() { return this.useCond_; } public boolean hasMinCond() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */      public GuildDepotHandler.QualityCond getMinCond() {
/*       */       return this.minCond_;
/*       */     } public GuildDepotHandler.QualityCondOrBuilder getMinCondOrBuilder() {
/*       */       return this.minCond_;
/*       */     } public boolean hasMaxCond() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public GuildDepotHandler.QualityCond getMaxCond() {
/*       */       return this.maxCond_;
/*       */     } public GuildDepotHandler.QualityCondOrBuilder getMaxCondOrBuilder() {
/*       */       return this.maxCond_;
/*       */     } private void initFields() {
/*       */       this.useCond_ = GuildDepotHandler.UseCond.getDefaultInstance();
/*       */       this.minCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */       this.maxCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */     } public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (hasUseCond() && !getUseCond().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     } public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeMessage(1, (MessageLite)this.useCond_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeMessage(2, (MessageLite)this.minCond_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeMessage(3, (MessageLite)this.maxCond_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     } public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.useCond_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.minCond_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.maxCond_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static DepotCondition parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (DepotCondition)PARSER.parseFrom(data);
/*       */     }
/*       */     public static DepotCondition parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DepotCondition)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static DepotCondition parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (DepotCondition)PARSER.parseFrom(data);
/*       */     }
/*       */     public static DepotCondition parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DepotCondition)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static DepotCondition parseFrom(InputStream input) throws IOException {
/*       */       return (DepotCondition)PARSER.parseFrom(input);
/*       */     }
/*       */     public static DepotCondition parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepotCondition)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static DepotCondition parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (DepotCondition)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static DepotCondition parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepotCondition)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static DepotCondition parseFrom(CodedInputStream input) throws IOException {
/*       */       return (DepotCondition)PARSER.parseFrom(input);
/*       */     }
/*       */     public static DepotCondition parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepotCondition)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(DepotCondition prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.DepotConditionOrBuilder { private int bitField0_; private GuildDepotHandler.UseCond useCond_; private SingleFieldBuilder<GuildDepotHandler.UseCond, GuildDepotHandler.UseCond.Builder, GuildDepotHandler.UseCondOrBuilder> useCondBuilder_; private GuildDepotHandler.QualityCond minCond_; private SingleFieldBuilder<GuildDepotHandler.QualityCond, GuildDepotHandler.QualityCond.Builder, GuildDepotHandler.QualityCondOrBuilder> minCondBuilder_; private GuildDepotHandler.QualityCond maxCond_; private SingleFieldBuilder<GuildDepotHandler.QualityCond, GuildDepotHandler.QualityCond.Builder, GuildDepotHandler.QualityCondOrBuilder> maxCondBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepotCondition_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepotCondition_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DepotCondition.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.useCond_ = GuildDepotHandler.UseCond.getDefaultInstance();
/*       */         this.minCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         this.maxCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.useCond_ = GuildDepotHandler.UseCond.getDefaultInstance();
/*       */         this.minCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         this.maxCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.DepotCondition.alwaysUseFieldBuilders) {
/*       */           getUseCondFieldBuilder();
/*       */           getMinCondFieldBuilder();
/*       */           getMaxCondFieldBuilder();
/*       */         } 
/*       */       }
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         if (this.useCondBuilder_ == null) {
/*       */           this.useCond_ = GuildDepotHandler.UseCond.getDefaultInstance();
/*       */         } else {
/*       */           this.useCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.minCondBuilder_ == null) {
/*       */           this.minCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         } else {
/*       */           this.minCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           this.maxCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */         } else {
/*       */           this.maxCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepotCondition_descriptor;
/*       */       }
/*       */       public GuildDepotHandler.DepotCondition getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */       }
/*       */       public GuildDepotHandler.DepotCondition build() {
/*       */         GuildDepotHandler.DepotCondition result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public GuildDepotHandler.DepotCondition buildPartial() {
/*       */         GuildDepotHandler.DepotCondition result = new GuildDepotHandler.DepotCondition(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         if (this.useCondBuilder_ == null) {
/*       */           result.useCond_ = this.useCond_;
/*       */         } else {
/*       */           result.useCond_ = (GuildDepotHandler.UseCond)this.useCondBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         if (this.minCondBuilder_ == null) {
/*       */           result.minCond_ = this.minCond_;
/*       */         } else {
/*       */           result.minCond_ = (GuildDepotHandler.QualityCond)this.minCondBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           result.maxCond_ = this.maxCond_;
/*       */         } else {
/*       */           result.maxCond_ = (GuildDepotHandler.QualityCond)this.maxCondBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.DepotCondition)
/*       */           return mergeFrom((GuildDepotHandler.DepotCondition)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(GuildDepotHandler.DepotCondition other) {
/*       */         if (other == GuildDepotHandler.DepotCondition.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasUseCond())
/*       */           mergeUseCond(other.getUseCond()); 
/*       */         if (other.hasMinCond())
/*       */           mergeMinCond(other.getMinCond()); 
/*       */         if (other.hasMaxCond())
/*       */           mergeMaxCond(other.getMaxCond()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (hasUseCond() && !getUseCond().isInitialized())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.DepotCondition parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.DepotCondition)GuildDepotHandler.DepotCondition.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.DepotCondition)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public boolean hasUseCond() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       public GuildDepotHandler.UseCond getUseCond() {
/*       */         if (this.useCondBuilder_ == null)
/*       */           return this.useCond_; 
/*       */         return (GuildDepotHandler.UseCond)this.useCondBuilder_.getMessage();
/*       */       }
/*       */       public Builder setUseCond(GuildDepotHandler.UseCond value) {
/*       */         if (this.useCondBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.useCond_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.useCondBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */       public Builder setUseCond(GuildDepotHandler.UseCond.Builder builderForValue) {
/*       */         if (this.useCondBuilder_ == null) {
/*       */           this.useCond_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.useCondBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */       public Builder mergeUseCond(GuildDepotHandler.UseCond value) {
/*       */         if (this.useCondBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x1) == 1 && this.useCond_ != GuildDepotHandler.UseCond.getDefaultInstance()) {
/*       */             this.useCond_ = GuildDepotHandler.UseCond.newBuilder(this.useCond_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.useCond_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.useCondBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x1;
/*       */         return this;
/*       */       }
/*       */       public Builder clearUseCond() {
/*       */         if (this.useCondBuilder_ == null) {
/*       */           this.useCond_ = GuildDepotHandler.UseCond.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.useCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         return this;
/*       */       }
/*       */       public GuildDepotHandler.UseCond.Builder getUseCondBuilder() {
/*       */         this.bitField0_ |= 0x1;
/*       */         onChanged();
/*       */         return (GuildDepotHandler.UseCond.Builder)getUseCondFieldBuilder().getBuilder();
/*       */       }
/*       */       public GuildDepotHandler.UseCondOrBuilder getUseCondOrBuilder() {
/*       */         if (this.useCondBuilder_ != null)
/*       */           return (GuildDepotHandler.UseCondOrBuilder)this.useCondBuilder_.getMessageOrBuilder(); 
/*       */         return this.useCond_;
/*       */       }
/*       */       private SingleFieldBuilder<GuildDepotHandler.UseCond, GuildDepotHandler.UseCond.Builder, GuildDepotHandler.UseCondOrBuilder> getUseCondFieldBuilder() {
/*       */         if (this.useCondBuilder_ == null) {
/*       */           this.useCondBuilder_ = new SingleFieldBuilder(getUseCond(), getParentForChildren(), isClean());
/*       */           this.useCond_ = null;
/*       */         } 
/*       */         return this.useCondBuilder_;
/*       */       }
/*       */       public boolean hasMinCond() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       public GuildDepotHandler.QualityCond getMinCond() {
/*       */         if (this.minCondBuilder_ == null)
/*       */           return this.minCond_; 
/*       */         return (GuildDepotHandler.QualityCond)this.minCondBuilder_.getMessage();
/*       */       }
/*       */       public Builder setMinCond(GuildDepotHandler.QualityCond value) {
/*       */         if (this.minCondBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.minCond_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.minCondBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */       public Builder setMinCond(GuildDepotHandler.QualityCond.Builder builderForValue) {
/*       */         if (this.minCondBuilder_ == null) {
/*       */           this.minCond_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.minCondBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */       public Builder mergeMinCond(GuildDepotHandler.QualityCond value) {
/*       */         if (this.minCondBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2 && this.minCond_ != GuildDepotHandler.QualityCond.getDefaultInstance()) {
/*       */             this.minCond_ = GuildDepotHandler.QualityCond.newBuilder(this.minCond_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.minCond_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.minCondBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x2;
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinCond() {
/*       */         if (this.minCondBuilder_ == null) {
/*       */           this.minCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.minCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */       public GuildDepotHandler.QualityCond.Builder getMinCondBuilder() {
/*       */         this.bitField0_ |= 0x2;
/*       */         onChanged();
/*       */         return (GuildDepotHandler.QualityCond.Builder)getMinCondFieldBuilder().getBuilder();
/*       */       }
/*       */       public GuildDepotHandler.QualityCondOrBuilder getMinCondOrBuilder() {
/*       */         if (this.minCondBuilder_ != null)
/*       */           return (GuildDepotHandler.QualityCondOrBuilder)this.minCondBuilder_.getMessageOrBuilder(); 
/*       */         return this.minCond_;
/*       */       }
/*       */       private SingleFieldBuilder<GuildDepotHandler.QualityCond, GuildDepotHandler.QualityCond.Builder, GuildDepotHandler.QualityCondOrBuilder> getMinCondFieldBuilder() {
/*       */         if (this.minCondBuilder_ == null) {
/*       */           this.minCondBuilder_ = new SingleFieldBuilder(getMinCond(), getParentForChildren(), isClean());
/*       */           this.minCond_ = null;
/*       */         } 
/*       */         return this.minCondBuilder_;
/*       */       }
/*       */       public boolean hasMaxCond() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       public GuildDepotHandler.QualityCond getMaxCond() {
/*       */         if (this.maxCondBuilder_ == null)
/*       */           return this.maxCond_; 
/*       */         return (GuildDepotHandler.QualityCond)this.maxCondBuilder_.getMessage();
/*       */       }
/*       */       public Builder setMaxCond(GuildDepotHandler.QualityCond value) {
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.maxCond_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.maxCondBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       public Builder setMaxCond(GuildDepotHandler.QualityCond.Builder builderForValue) {
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           this.maxCond_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.maxCondBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       public Builder mergeMaxCond(GuildDepotHandler.QualityCond value) {
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.maxCond_ != GuildDepotHandler.QualityCond.getDefaultInstance()) {
/*       */             this.maxCond_ = GuildDepotHandler.QualityCond.newBuilder(this.maxCond_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.maxCond_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.maxCondBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxCond() {
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           this.maxCond_ = GuildDepotHandler.QualityCond.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.maxCondBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       public GuildDepotHandler.QualityCond.Builder getMaxCondBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (GuildDepotHandler.QualityCond.Builder)getMaxCondFieldBuilder().getBuilder();
/*       */       }
/*       */       public GuildDepotHandler.QualityCondOrBuilder getMaxCondOrBuilder() {
/*       */         if (this.maxCondBuilder_ != null)
/*       */           return (GuildDepotHandler.QualityCondOrBuilder)this.maxCondBuilder_.getMessageOrBuilder(); 
/*       */         return this.maxCond_;
/*       */       }
/*       */       private SingleFieldBuilder<GuildDepotHandler.QualityCond, GuildDepotHandler.QualityCond.Builder, GuildDepotHandler.QualityCondOrBuilder> getMaxCondFieldBuilder() {
/*       */         if (this.maxCondBuilder_ == null) {
/*       */           this.maxCondBuilder_ = new SingleFieldBuilder(getMaxCond(), getParentForChildren(), isClean());
/*       */           this.maxCond_ = null;
/*       */         } 
/*       */         return this.maxCondBuilder_;
/*       */       } } }
/*  2657 */   public static final class DepositItemRequest extends GeneratedMessage implements DepositItemRequestOrBuilder { private static final DepositItemRequest defaultInstance = new DepositItemRequest(true); private final UnknownFieldSet unknownFields; private DepositItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DepositItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DepositItemRequest getDefaultInstance() { return defaultInstance; } public DepositItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DepositItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SFromIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DepositItemRequest.class, Builder.class); } public static Parser<DepositItemRequest> PARSER = (Parser<DepositItemRequest>)new AbstractParser<DepositItemRequest>() { public GuildDepotHandler.DepositItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DepositItemRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_FROMINDEX_FIELD_NUMBER = 1; private int c2SFromIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DepositItemRequest> getParserForType() { return PARSER; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } private void initFields() { this.c2SFromIndex_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SFromIndex()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SFromIndex_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SFromIndex_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DepositItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DepositItemRequest)PARSER.parseFrom(data); } public static DepositItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepositItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static DepositItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DepositItemRequest)PARSER.parseFrom(data); } public static DepositItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepositItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static DepositItemRequest parseFrom(InputStream input) throws IOException { return (DepositItemRequest)PARSER.parseFrom(input); } public static DepositItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepositItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static DepositItemRequest parseDelimitedFrom(InputStream input) throws IOException { return (DepositItemRequest)PARSER.parseDelimitedFrom(input); } public static DepositItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepositItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DepositItemRequest parseFrom(CodedInputStream input) throws IOException { return (DepositItemRequest)PARSER.parseFrom(input); } public static DepositItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepositItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DepositItemRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.DepositItemRequestOrBuilder {
/*  2658 */       private int bitField0_; private int c2SFromIndex_; public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DepositItemRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.DepositItemRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SFromIndex_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemRequest_descriptor; } public GuildDepotHandler.DepositItemRequest getDefaultInstanceForType() { return GuildDepotHandler.DepositItemRequest.getDefaultInstance(); } public GuildDepotHandler.DepositItemRequest build() { GuildDepotHandler.DepositItemRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.DepositItemRequest buildPartial() { GuildDepotHandler.DepositItemRequest result = new GuildDepotHandler.DepositItemRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SFromIndex_ = this.c2SFromIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.DepositItemRequest) return mergeFrom((GuildDepotHandler.DepositItemRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.DepositItemRequest other) { if (other == GuildDepotHandler.DepositItemRequest.getDefaultInstance()) return this;  if (other.hasC2SFromIndex()) setC2SFromIndex(other.getC2SFromIndex());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SFromIndex()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.DepositItemRequest parsedMessage = null; try { parsedMessage = (GuildDepotHandler.DepositItemRequest)GuildDepotHandler.DepositItemRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.DepositItemRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } public Builder setC2SFromIndex(int value) { this.bitField0_ |= 0x1; this.c2SFromIndex_ = value; onChanged(); return this; } public Builder clearC2SFromIndex() { this.bitField0_ &= 0xFFFFFFFE; this.c2SFromIndex_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class TakeOutItemRequest
/*       */     extends GeneratedMessage
/*       */     implements TakeOutItemRequestOrBuilder
/*       */   {
/*  3102 */     private static final TakeOutItemRequest defaultInstance = new TakeOutItemRequest(true); private final UnknownFieldSet unknownFields; private TakeOutItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TakeOutItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TakeOutItemRequest getDefaultInstance() { return defaultInstance; } public TakeOutItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TakeOutItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SFromIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeOutItemRequest.class, Builder.class); } public static Parser<TakeOutItemRequest> PARSER = (Parser<TakeOutItemRequest>)new AbstractParser<TakeOutItemRequest>() { public GuildDepotHandler.TakeOutItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.TakeOutItemRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_FROMINDEX_FIELD_NUMBER = 1; private int c2SFromIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TakeOutItemRequest> getParserForType() { return PARSER; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } private void initFields() { this.c2SFromIndex_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SFromIndex()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SFromIndex_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SFromIndex_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static TakeOutItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (TakeOutItemRequest)PARSER.parseFrom(data); } public static TakeOutItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TakeOutItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static TakeOutItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (TakeOutItemRequest)PARSER.parseFrom(data); } public static TakeOutItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (TakeOutItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static TakeOutItemRequest parseFrom(InputStream input) throws IOException { return (TakeOutItemRequest)PARSER.parseFrom(input); } public static TakeOutItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TakeOutItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static TakeOutItemRequest parseDelimitedFrom(InputStream input) throws IOException { return (TakeOutItemRequest)PARSER.parseDelimitedFrom(input); } public static TakeOutItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TakeOutItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static TakeOutItemRequest parseFrom(CodedInputStream input) throws IOException { return (TakeOutItemRequest)PARSER.parseFrom(input); } public static TakeOutItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (TakeOutItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(TakeOutItemRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.TakeOutItemRequestOrBuilder {
/*  3103 */       private int bitField0_; private int c2SFromIndex_; public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.TakeOutItemRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.TakeOutItemRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SFromIndex_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemRequest_descriptor; } public GuildDepotHandler.TakeOutItemRequest getDefaultInstanceForType() { return GuildDepotHandler.TakeOutItemRequest.getDefaultInstance(); } public GuildDepotHandler.TakeOutItemRequest build() { GuildDepotHandler.TakeOutItemRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.TakeOutItemRequest buildPartial() { GuildDepotHandler.TakeOutItemRequest result = new GuildDepotHandler.TakeOutItemRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SFromIndex_ = this.c2SFromIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.TakeOutItemRequest) return mergeFrom((GuildDepotHandler.TakeOutItemRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.TakeOutItemRequest other) { if (other == GuildDepotHandler.TakeOutItemRequest.getDefaultInstance()) return this;  if (other.hasC2SFromIndex()) setC2SFromIndex(other.getC2SFromIndex());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SFromIndex()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.TakeOutItemRequest parsedMessage = null; try { parsedMessage = (GuildDepotHandler.TakeOutItemRequest)GuildDepotHandler.TakeOutItemRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.TakeOutItemRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } public Builder setC2SFromIndex(int value) { this.bitField0_ |= 0x1; this.c2SFromIndex_ = value; onChanged(); return this; } public Builder clearC2SFromIndex() { this.bitField0_ &= 0xFFFFFFFE; this.c2SFromIndex_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class SetConditionRequest
/*       */     extends GeneratedMessage
/*       */     implements SetConditionRequestOrBuilder
/*       */   {
/*  4139 */     private static final SetConditionRequest defaultInstance = new SetConditionRequest(true); private final UnknownFieldSet unknownFields; private SetConditionRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetConditionRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetConditionRequest getDefaultInstance() { return defaultInstance; } public SetConditionRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetConditionRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.useLevel_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.useUpLevel_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.useJob_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.minLevel_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.minUpLevel_ = input.readInt32(); break;case 48: this.bitField0_ |= 0x20; this.minqColor_ = input.readInt32(); break;case 56: this.bitField0_ |= 0x40; this.maxLevel_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x80; this.maxUpLevel_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x100; this.maxqColor_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_SetConditionRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_SetConditionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SetConditionRequest.class, Builder.class); } public static Parser<SetConditionRequest> PARSER = (Parser<SetConditionRequest>)new AbstractParser<SetConditionRequest>() { public GuildDepotHandler.SetConditionRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.SetConditionRequest(input, extensionRegistry); } }
/*  4140 */     ; private int bitField0_; public static final int USELEVEL_FIELD_NUMBER = 1; private int useLevel_; public static final int USEUPLEVEL_FIELD_NUMBER = 2; private int useUpLevel_; public static final int USEJOB_FIELD_NUMBER = 3; private int useJob_; public static final int MINLEVEL_FIELD_NUMBER = 4; private int minLevel_; public static final int MINUPLEVEL_FIELD_NUMBER = 5; private int minUpLevel_; public static final int MINQCOLOR_FIELD_NUMBER = 6; private int minqColor_; public static final int MAXLEVEL_FIELD_NUMBER = 7; private int maxLevel_; public static final int MAXUPLEVEL_FIELD_NUMBER = 8; private int maxUpLevel_; public static final int MAXQCOLOR_FIELD_NUMBER = 9; private int maxqColor_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetConditionRequest> getParserForType() { return PARSER; } public boolean hasUseLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getUseLevel() { return this.useLevel_; } public boolean hasUseUpLevel() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */      public int getUseUpLevel() {
/*       */       return this.useUpLevel_;
/*       */     } public boolean hasUseJob() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public int getUseJob() {
/*       */       return this.useJob_;
/*       */     } public boolean hasMinLevel() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     } public int getMinLevel() {
/*       */       return this.minLevel_;
/*       */     } public boolean hasMinUpLevel() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     } public int getMinUpLevel() {
/*       */       return this.minUpLevel_;
/*       */     } public boolean hasMinqColor() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     } public int getMinqColor() {
/*       */       return this.minqColor_;
/*       */     } public boolean hasMaxLevel() {
/*       */       return ((this.bitField0_ & 0x40) == 64);
/*       */     } public int getMaxLevel() {
/*       */       return this.maxLevel_;
/*       */     } public boolean hasMaxUpLevel() {
/*       */       return ((this.bitField0_ & 0x80) == 128);
/*       */     } public int getMaxUpLevel() {
/*       */       return this.maxUpLevel_;
/*       */     } public boolean hasMaxqColor() {
/*       */       return ((this.bitField0_ & 0x100) == 256);
/*       */     } public int getMaxqColor() {
/*       */       return this.maxqColor_;
/*       */     } private void initFields() {
/*       */       this.useLevel_ = 0;
/*       */       this.useUpLevel_ = 0;
/*       */       this.useJob_ = 0;
/*       */       this.minLevel_ = 0;
/*       */       this.minUpLevel_ = 0;
/*       */       this.minqColor_ = 0;
/*       */       this.maxLevel_ = 0;
/*       */       this.maxUpLevel_ = 0;
/*       */       this.maxqColor_ = 0;
/*       */     } public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasUseJob()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     } public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.useLevel_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeInt32(2, this.useUpLevel_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(3, this.useJob_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.minLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeInt32(5, this.minUpLevel_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeInt32(6, this.minqColor_); 
/*       */       if ((this.bitField0_ & 0x40) == 64)
/*       */         output.writeInt32(7, this.maxLevel_); 
/*       */       if ((this.bitField0_ & 0x80) == 128)
/*       */         output.writeInt32(8, this.maxUpLevel_); 
/*       */       if ((this.bitField0_ & 0x100) == 256)
/*       */         output.writeInt32(9, this.maxqColor_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     } public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.useLevel_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeInt32Size(2, this.useUpLevel_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.useJob_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.minLevel_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.minUpLevel_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.minqColor_); 
/*       */       if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeInt32Size(7, this.maxLevel_); 
/*       */       if ((this.bitField0_ & 0x80) == 128)
/*       */         size += CodedOutputStream.computeInt32Size(8, this.maxUpLevel_); 
/*       */       if ((this.bitField0_ & 0x100) == 256)
/*       */         size += CodedOutputStream.computeInt32Size(9, this.maxqColor_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static SetConditionRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(data);
/*       */     } public static SetConditionRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static SetConditionRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(data);
/*       */     } public static SetConditionRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static SetConditionRequest parseFrom(InputStream input) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(input);
/*       */     } public static SetConditionRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static SetConditionRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static SetConditionRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static SetConditionRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(input);
/*       */     }
/*       */     public static SetConditionRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(SetConditionRequest prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.SetConditionRequestOrBuilder { private int bitField0_; private int useLevel_; private int useUpLevel_; private int useJob_; private int minLevel_; private int minUpLevel_; private int minqColor_; private int maxLevel_; private int maxUpLevel_; private int maxqColor_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionRequest_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.SetConditionRequest.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.SetConditionRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.useLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.useUpLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.useJob_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.minLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.minUpLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.minqColor_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.maxLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.maxUpLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.maxqColor_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionRequest_descriptor;
/*       */       }
/*       */       public GuildDepotHandler.SetConditionRequest getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.SetConditionRequest.getDefaultInstance();
/*       */       }
/*       */       public GuildDepotHandler.SetConditionRequest build() {
/*       */         GuildDepotHandler.SetConditionRequest result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public GuildDepotHandler.SetConditionRequest buildPartial() {
/*       */         GuildDepotHandler.SetConditionRequest result = new GuildDepotHandler.SetConditionRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.useLevel_ = this.useLevel_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.useUpLevel_ = this.useUpLevel_;
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.useJob_ = this.useJob_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.minLevel_ = this.minLevel_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.minUpLevel_ = this.minUpLevel_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.minqColor_ = this.minqColor_;
/*       */         if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40; 
/*       */         result.maxLevel_ = this.maxLevel_;
/*       */         if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x80; 
/*       */         result.maxUpLevel_ = this.maxUpLevel_;
/*       */         if ((from_bitField0_ & 0x100) == 256)
/*       */           to_bitField0_ |= 0x100; 
/*       */         result.maxqColor_ = this.maxqColor_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.SetConditionRequest)
/*       */           return mergeFrom((GuildDepotHandler.SetConditionRequest)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(GuildDepotHandler.SetConditionRequest other) {
/*       */         if (other == GuildDepotHandler.SetConditionRequest.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasUseLevel())
/*       */           setUseLevel(other.getUseLevel()); 
/*       */         if (other.hasUseUpLevel())
/*       */           setUseUpLevel(other.getUseUpLevel()); 
/*       */         if (other.hasUseJob())
/*       */           setUseJob(other.getUseJob()); 
/*       */         if (other.hasMinLevel())
/*       */           setMinLevel(other.getMinLevel()); 
/*       */         if (other.hasMinUpLevel())
/*       */           setMinUpLevel(other.getMinUpLevel()); 
/*       */         if (other.hasMinqColor())
/*       */           setMinqColor(other.getMinqColor()); 
/*       */         if (other.hasMaxLevel())
/*       */           setMaxLevel(other.getMaxLevel()); 
/*       */         if (other.hasMaxUpLevel())
/*       */           setMaxUpLevel(other.getMaxUpLevel()); 
/*       */         if (other.hasMaxqColor())
/*       */           setMaxqColor(other.getMaxqColor()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (!hasUseJob())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.SetConditionRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.SetConditionRequest)GuildDepotHandler.SetConditionRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.SetConditionRequest)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public boolean hasUseLevel() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       public int getUseLevel() {
/*       */         return this.useLevel_;
/*       */       }
/*       */       public Builder setUseLevel(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.useLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearUseLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.useLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasUseUpLevel() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       public int getUseUpLevel() {
/*       */         return this.useUpLevel_;
/*       */       }
/*       */       public Builder setUseUpLevel(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.useUpLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearUseUpLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.useUpLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasUseJob() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       public int getUseJob() {
/*       */         return this.useJob_;
/*       */       }
/*       */       public Builder setUseJob(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.useJob_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearUseJob() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.useJob_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMinLevel() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public int getMinLevel() {
/*       */         return this.minLevel_;
/*       */       }
/*       */       public Builder setMinLevel(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.minLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.minLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMinUpLevel() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       public int getMinUpLevel() {
/*       */         return this.minUpLevel_;
/*       */       }
/*       */       public Builder setMinUpLevel(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.minUpLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinUpLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.minUpLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMinqColor() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       public int getMinqColor() {
/*       */         return this.minqColor_;
/*       */       }
/*       */       public Builder setMinqColor(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.minqColor_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinqColor() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.minqColor_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxLevel() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */       public int getMaxLevel() {
/*       */         return this.maxLevel_;
/*       */       }
/*       */       public Builder setMaxLevel(int value) {
/*       */         this.bitField0_ |= 0x40;
/*       */         this.maxLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.maxLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxUpLevel() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */       public int getMaxUpLevel() {
/*       */         return this.maxUpLevel_;
/*       */       }
/*       */       public Builder setMaxUpLevel(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.maxUpLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxUpLevel() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.maxUpLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxqColor() {
/*       */         return ((this.bitField0_ & 0x100) == 256);
/*       */       }
/*       */       public int getMaxqColor() {
/*       */         return this.maxqColor_;
/*       */       }
/*       */       public Builder setMaxqColor(int value) {
/*       */         this.bitField0_ |= 0x100;
/*       */         this.maxqColor_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxqColor() {
/*       */         this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.maxqColor_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*  4584 */   public static final class DeleteItemRequest extends GeneratedMessage implements DeleteItemRequestOrBuilder { private static final DeleteItemRequest defaultInstance = new DeleteItemRequest(true); private final UnknownFieldSet unknownFields; private DeleteItemRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DeleteItemRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DeleteItemRequest getDefaultInstance() { return defaultInstance; } public DeleteItemRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DeleteItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.c2SFromIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DeleteItemRequest.class, Builder.class); } public static Parser<DeleteItemRequest> PARSER = (Parser<DeleteItemRequest>)new AbstractParser<DeleteItemRequest>() { public GuildDepotHandler.DeleteItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DeleteItemRequest(input, extensionRegistry); } }; private int bitField0_; public static final int C2S_FROMINDEX_FIELD_NUMBER = 1; private int c2SFromIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DeleteItemRequest> getParserForType() { return PARSER; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } private void initFields() { this.c2SFromIndex_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasC2SFromIndex()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SFromIndex_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SFromIndex_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DeleteItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DeleteItemRequest)PARSER.parseFrom(data); } public static DeleteItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DeleteItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static DeleteItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DeleteItemRequest)PARSER.parseFrom(data); } public static DeleteItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DeleteItemRequest)PARSER.parseFrom(data, extensionRegistry); } public static DeleteItemRequest parseFrom(InputStream input) throws IOException { return (DeleteItemRequest)PARSER.parseFrom(input); } public static DeleteItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeleteItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static DeleteItemRequest parseDelimitedFrom(InputStream input) throws IOException { return (DeleteItemRequest)PARSER.parseDelimitedFrom(input); } public static DeleteItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeleteItemRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DeleteItemRequest parseFrom(CodedInputStream input) throws IOException { return (DeleteItemRequest)PARSER.parseFrom(input); } public static DeleteItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DeleteItemRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DeleteItemRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.DeleteItemRequestOrBuilder {
/*  4585 */       private int bitField0_; private int c2SFromIndex_; public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DeleteItemRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.DeleteItemRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.c2SFromIndex_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemRequest_descriptor; } public GuildDepotHandler.DeleteItemRequest getDefaultInstanceForType() { return GuildDepotHandler.DeleteItemRequest.getDefaultInstance(); } public GuildDepotHandler.DeleteItemRequest build() { GuildDepotHandler.DeleteItemRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.DeleteItemRequest buildPartial() { GuildDepotHandler.DeleteItemRequest result = new GuildDepotHandler.DeleteItemRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.c2SFromIndex_ = this.c2SFromIndex_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.DeleteItemRequest) return mergeFrom((GuildDepotHandler.DeleteItemRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.DeleteItemRequest other) { if (other == GuildDepotHandler.DeleteItemRequest.getDefaultInstance()) return this;  if (other.hasC2SFromIndex()) setC2SFromIndex(other.getC2SFromIndex());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasC2SFromIndex()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.DeleteItemRequest parsedMessage = null; try { parsedMessage = (GuildDepotHandler.DeleteItemRequest)GuildDepotHandler.DeleteItemRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.DeleteItemRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasC2SFromIndex() { return ((this.bitField0_ & 0x1) == 1); } public int getC2SFromIndex() { return this.c2SFromIndex_; } public Builder setC2SFromIndex(int value) { this.bitField0_ |= 0x1; this.c2SFromIndex_ = value; onChanged(); return this; } public Builder clearC2SFromIndex() { this.bitField0_ &= 0xFFFFFFFE; this.c2SFromIndex_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class UpgradeDepotRequest
/*       */     extends GeneratedMessage
/*       */     implements UpgradeDepotRequestOrBuilder
/*       */   {
/*  4905 */     private static final UpgradeDepotRequest defaultInstance = new UpgradeDepotRequest(true); private final UnknownFieldSet unknownFields; private UpgradeDepotRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeDepotRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeDepotRequest getDefaultInstance() { return defaultInstance; } public UpgradeDepotRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeDepotRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeDepotRequest.class, Builder.class); } public static Parser<UpgradeDepotRequest> PARSER = (Parser<UpgradeDepotRequest>)new AbstractParser<UpgradeDepotRequest>() { public GuildDepotHandler.UpgradeDepotRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.UpgradeDepotRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeDepotRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpgradeDepotRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpgradeDepotRequest)PARSER.parseFrom(data); } public static UpgradeDepotRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpgradeDepotRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpgradeDepotRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpgradeDepotRequest)PARSER.parseFrom(data); } public static UpgradeDepotRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpgradeDepotRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpgradeDepotRequest parseFrom(InputStream input) throws IOException { return (UpgradeDepotRequest)PARSER.parseFrom(input); } public static UpgradeDepotRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeDepotRequest)PARSER.parseFrom(input, extensionRegistry); } public static UpgradeDepotRequest parseDelimitedFrom(InputStream input) throws IOException { return (UpgradeDepotRequest)PARSER.parseDelimitedFrom(input); } public static UpgradeDepotRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeDepotRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UpgradeDepotRequest parseFrom(CodedInputStream input) throws IOException { return (UpgradeDepotRequest)PARSER.parseFrom(input); } public static UpgradeDepotRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpgradeDepotRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UpgradeDepotRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.UpgradeDepotRequestOrBuilder {
/*  4906 */       public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.UpgradeDepotRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.UpgradeDepotRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotRequest_descriptor; } public GuildDepotHandler.UpgradeDepotRequest getDefaultInstanceForType() { return GuildDepotHandler.UpgradeDepotRequest.getDefaultInstance(); } public GuildDepotHandler.UpgradeDepotRequest build() { GuildDepotHandler.UpgradeDepotRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.UpgradeDepotRequest buildPartial() { GuildDepotHandler.UpgradeDepotRequest result = new GuildDepotHandler.UpgradeDepotRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.UpgradeDepotRequest) return mergeFrom((GuildDepotHandler.UpgradeDepotRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.UpgradeDepotRequest other) { if (other == GuildDepotHandler.UpgradeDepotRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.UpgradeDepotRequest parsedMessage = null; try { parsedMessage = (GuildDepotHandler.UpgradeDepotRequest)GuildDepotHandler.UpgradeDepotRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.UpgradeDepotRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class DepositItemResponse
/*       */     extends GeneratedMessage
/*       */     implements DepositItemResponseOrBuilder
/*       */   {
/*  5754 */     private static final DepositItemResponse defaultInstance = new DepositItemResponse(true); private final UnknownFieldSet unknownFields; private DepositItemResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DepositItemResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DepositItemResponse getDefaultInstance() { return defaultInstance; } public DepositItemResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DepositItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; ItemOuterClass.Grid.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CBagGrid_.toBuilder();  this.s2CBagGrid_ = (ItemOuterClass.Grid)input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CBagGrid_); this.s2CBagGrid_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break;case 32: this.bitField0_ |= 0x8; this.depositCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepositItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DepositItemResponse.class, Builder.class); } public static Parser<DepositItemResponse> PARSER = (Parser<DepositItemResponse>)new AbstractParser<DepositItemResponse>() { public GuildDepotHandler.DepositItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DepositItemResponse(input, extensionRegistry); } }
/*  5755 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_BAGGRID_FIELD_NUMBER = 3; private ItemOuterClass.Grid s2CBagGrid_; public static final int DEPOSITCOUNT_FIELD_NUMBER = 4; private int depositCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DepositItemResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CBagGrid() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */     
/*       */     public ItemOuterClass.Grid getS2CBagGrid() {
/*       */       return this.s2CBagGrid_;
/*       */     }
/*       */ 
/*       */     
/*       */     public ItemOuterClass.GridOrBuilder getS2CBagGridOrBuilder() {
/*       */       return (ItemOuterClass.GridOrBuilder)this.s2CBagGrid_;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasDepositCount() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getDepositCount() {
/*       */       return this.depositCount_;
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CBagGrid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */       this.depositCount_ = 0;
/*       */     }
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
/*       */       if (hasS2CBagGrid() && !getS2CBagGrid().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
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
/*       */         output.writeMessage(3, (MessageLite)this.s2CBagGrid_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.depositCount_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
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
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CBagGrid_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.depositCount_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */ 
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static DepositItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DepositItemResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */ 
/*       */     
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(DepositItemResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */ 
/*       */     
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */ 
/*       */     
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements GuildDepotHandler.DepositItemResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private int s2CCode_;
/*       */       
/*       */       private Object s2CMsg_;
/*       */       
/*       */       private ItemOuterClass.Grid s2CBagGrid_;
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> s2CBagGridBuilder_;
/*       */       
/*       */       private int depositCount_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepositItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepositItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DepositItemResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CBagGrid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CBagGrid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.DepositItemResponse.alwaysUseFieldBuilders) {
/*       */           getS2CBagGridFieldBuilder();
/*       */         }
/*       */       }
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           this.s2CBagGrid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CBagGridBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.depositCount_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DepositItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepositItemResponse getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.DepositItemResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepositItemResponse build() {
/*       */         GuildDepotHandler.DepositItemResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepositItemResponse buildPartial() {
/*       */         GuildDepotHandler.DepositItemResponse result = new GuildDepotHandler.DepositItemResponse(this);
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
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           result.s2CBagGrid_ = this.s2CBagGrid_;
/*       */         } else {
/*       */           result.s2CBagGrid_ = (ItemOuterClass.Grid)this.s2CBagGridBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.depositCount_ = this.depositCount_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.DepositItemResponse) {
/*       */           return mergeFrom((GuildDepotHandler.DepositItemResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(GuildDepotHandler.DepositItemResponse other) {
/*       */         if (other == GuildDepotHandler.DepositItemResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CBagGrid()) {
/*       */           mergeS2CBagGrid(other.getS2CBagGrid());
/*       */         }
/*       */         if (other.hasDepositCount()) {
/*       */           setDepositCount(other.getDepositCount());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (hasS2CBagGrid() && !getS2CBagGrid().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.DepositItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.DepositItemResponse)GuildDepotHandler.DepositItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.DepositItemResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
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
/*       */           if (bs.isValidUtf8()) {
/*       */             this.s2CMsg_ = s;
/*       */           }
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
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = GuildDepotHandler.DepositItemResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasS2CBagGrid() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public ItemOuterClass.Grid getS2CBagGrid() {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           return this.s2CBagGrid_;
/*       */         }
/*       */         return (ItemOuterClass.Grid)this.s2CBagGridBuilder_.getMessage();
/*       */       }
/*       */       
/*       */       public Builder setS2CBagGrid(ItemOuterClass.Grid value) {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CBagGrid_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CBagGridBuilder_.setMessage((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setS2CBagGrid(ItemOuterClass.Grid.Builder builderForValue) {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           this.s2CBagGrid_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CBagGridBuilder_.setMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeS2CBagGrid(ItemOuterClass.Grid value) {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CBagGrid_ != ItemOuterClass.Grid.getDefaultInstance()) {
/*       */             this.s2CBagGrid_ = ItemOuterClass.Grid.newBuilder(this.s2CBagGrid_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CBagGrid_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CBagGridBuilder_.mergeFrom((GeneratedMessage)value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CBagGrid() {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           this.s2CBagGrid_ = ItemOuterClass.Grid.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CBagGridBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public ItemOuterClass.Grid.Builder getS2CBagGridBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (ItemOuterClass.Grid.Builder)getS2CBagGridFieldBuilder().getBuilder();
/*       */       }
/*       */       
/*       */       public ItemOuterClass.GridOrBuilder getS2CBagGridOrBuilder() {
/*       */         if (this.s2CBagGridBuilder_ != null) {
/*       */           return (ItemOuterClass.GridOrBuilder)this.s2CBagGridBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return (ItemOuterClass.GridOrBuilder)this.s2CBagGrid_;
/*       */       }
/*       */       
/*       */       private SingleFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getS2CBagGridFieldBuilder() {
/*       */         if (this.s2CBagGridBuilder_ == null) {
/*       */           this.s2CBagGridBuilder_ = new SingleFieldBuilder((GeneratedMessage)getS2CBagGrid(), getParentForChildren(), isClean());
/*       */           this.s2CBagGrid_ = null;
/*       */         } 
/*       */         return this.s2CBagGridBuilder_;
/*       */       }
/*       */       
/*       */       public boolean hasDepositCount() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       
/*       */       public int getDepositCount() {
/*       */         return this.depositCount_;
/*       */       }
/*       */       
/*       */       public Builder setDepositCount(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.depositCount_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearDepositCount() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.depositCount_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class TakeOutItemResponse
/*       */     extends GeneratedMessage
/*       */     implements TakeOutItemResponseOrBuilder
/*       */   {
/*  6316 */     private static final TakeOutItemResponse defaultInstance = new TakeOutItemResponse(true); private final UnknownFieldSet unknownFields; private TakeOutItemResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private TakeOutItemResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static TakeOutItemResponse getDefaultInstance() { return defaultInstance; } public TakeOutItemResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private TakeOutItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeOutItemResponse.class, Builder.class); } public static Parser<TakeOutItemResponse> PARSER = (Parser<TakeOutItemResponse>)new AbstractParser<TakeOutItemResponse>() { public GuildDepotHandler.TakeOutItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.TakeOutItemResponse(input, extensionRegistry); } }
/*  6317 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<TakeOutItemResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
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
/*       */     public static TakeOutItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(data);
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
/*       */     public static TakeOutItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TakeOutItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(data);
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
/*       */     public static TakeOutItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(data, extensionRegistry);
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
/*       */     public static TakeOutItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(input);
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
/*       */     public static TakeOutItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static TakeOutItemResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseDelimitedFrom(input);
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
/*       */     public static TakeOutItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */     public static TakeOutItemResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(input);
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
/*       */     public static TakeOutItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (TakeOutItemResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(TakeOutItemResponse prototype) {
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
/*       */       implements GuildDepotHandler.TakeOutItemResponseOrBuilder
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
/*       */         return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemResponse_descriptor;
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
/*       */         return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.TakeOutItemResponse.class, Builder.class);
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
/*       */         if (GuildDepotHandler.TakeOutItemResponse.alwaysUseFieldBuilders);
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
/*       */         return GuildDepotHandler.internal_static_pomelo_area_TakeOutItemResponse_descriptor;
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
/*       */       public GuildDepotHandler.TakeOutItemResponse getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.TakeOutItemResponse.getDefaultInstance();
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
/*       */       public GuildDepotHandler.TakeOutItemResponse build() {
/*       */         GuildDepotHandler.TakeOutItemResponse result = buildPartial();
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
/*       */       public GuildDepotHandler.TakeOutItemResponse buildPartial() {
/*       */         GuildDepotHandler.TakeOutItemResponse result = new GuildDepotHandler.TakeOutItemResponse(this);
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
/*       */         if (other instanceof GuildDepotHandler.TakeOutItemResponse) {
/*       */           return mergeFrom((GuildDepotHandler.TakeOutItemResponse)other);
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
/*       */       public Builder mergeFrom(GuildDepotHandler.TakeOutItemResponse other) {
/*       */         if (other == GuildDepotHandler.TakeOutItemResponse.getDefaultInstance()) {
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
/*       */         GuildDepotHandler.TakeOutItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.TakeOutItemResponse)GuildDepotHandler.TakeOutItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.TakeOutItemResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = GuildDepotHandler.TakeOutItemResponse.getDefaultInstance().getS2CMsg();
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
/*       */   public static final class SetConditionResponse
/*       */     extends GeneratedMessage
/*       */     implements SetConditionResponseOrBuilder
/*       */   {
/*  7079 */     private static final SetConditionResponse defaultInstance = new SetConditionResponse(true); private final UnknownFieldSet unknownFields; private SetConditionResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private SetConditionResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static SetConditionResponse getDefaultInstance() { return defaultInstance; } public SetConditionResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private SetConditionResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; GuildDepotHandler.DepotCondition.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CCondition_.toBuilder();  this.s2CCondition_ = (GuildDepotHandler.DepotCondition)input.readMessage(GuildDepotHandler.DepotCondition.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CCondition_); this.s2CCondition_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_SetConditionResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_SetConditionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SetConditionResponse.class, Builder.class); } public static Parser<SetConditionResponse> PARSER = (Parser<SetConditionResponse>)new AbstractParser<SetConditionResponse>() { public GuildDepotHandler.SetConditionResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.SetConditionResponse(input, extensionRegistry); } }
/*  7080 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_CONDITION_FIELD_NUMBER = 3; private GuildDepotHandler.DepotCondition s2CCondition_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<SetConditionResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CCondition() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public GuildDepotHandler.DepotCondition getS2CCondition() {
/*       */       return this.s2CCondition_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public GuildDepotHandler.DepotConditionOrBuilder getS2CConditionOrBuilder() {
/*       */       return this.s2CCondition_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CCondition_ = GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */     }
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
/*       */       if (hasS2CCondition() && !getS2CCondition().isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeMessage(3, (MessageLite)this.s2CCondition_);
/*       */       }
/*       */       getUnknownFields().writeTo(output);
/*       */     }
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
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CCondition_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
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
/*       */     public static SetConditionResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(InputStream input) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static SetConditionResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (SetConditionResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
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
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(SetConditionResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
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
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements GuildDepotHandler.SetConditionResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */       
/*       */       private GuildDepotHandler.DepotCondition s2CCondition_;
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<GuildDepotHandler.DepotCondition, GuildDepotHandler.DepotCondition.Builder, GuildDepotHandler.DepotConditionOrBuilder> s2CConditionBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.SetConditionResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CCondition_ = GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.s2CCondition_ = GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.SetConditionResponse.alwaysUseFieldBuilders) {
/*       */           getS2CConditionFieldBuilder();
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
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           this.s2CCondition_ = GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */         } else {
/*       */           this.s2CConditionBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
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
/*       */         return GuildDepotHandler.internal_static_pomelo_area_SetConditionResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.SetConditionResponse getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.SetConditionResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.SetConditionResponse build() {
/*       */         GuildDepotHandler.SetConditionResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.SetConditionResponse buildPartial() {
/*       */         GuildDepotHandler.SetConditionResponse result = new GuildDepotHandler.SetConditionResponse(this);
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
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           result.s2CCondition_ = this.s2CCondition_;
/*       */         } else {
/*       */           result.s2CCondition_ = (GuildDepotHandler.DepotCondition)this.s2CConditionBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.SetConditionResponse) {
/*       */           return mergeFrom((GuildDepotHandler.SetConditionResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(GuildDepotHandler.SetConditionResponse other) {
/*       */         if (other == GuildDepotHandler.SetConditionResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CCondition()) {
/*       */           mergeS2CCondition(other.getS2CCondition());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         if (hasS2CCondition() && !getS2CCondition().isInitialized()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.SetConditionResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.SetConditionResponse)GuildDepotHandler.SetConditionResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.SetConditionResponse)e.getUnfinishedMessage();
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
/*       */       public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       }
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
/*       */       public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = GuildDepotHandler.SetConditionResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasS2CCondition() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepotCondition getS2CCondition() {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           return this.s2CCondition_;
/*       */         }
/*       */         return (GuildDepotHandler.DepotCondition)this.s2CConditionBuilder_.getMessage();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCondition(GuildDepotHandler.DepotCondition value) {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           this.s2CCondition_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CConditionBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setS2CCondition(GuildDepotHandler.DepotCondition.Builder builderForValue) {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           this.s2CCondition_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CConditionBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeS2CCondition(GuildDepotHandler.DepotCondition value) {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4 && this.s2CCondition_ != GuildDepotHandler.DepotCondition.getDefaultInstance()) {
/*       */             this.s2CCondition_ = GuildDepotHandler.DepotCondition.newBuilder(this.s2CCondition_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.s2CCondition_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CConditionBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x4;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearS2CCondition() {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           this.s2CCondition_ = GuildDepotHandler.DepotCondition.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.s2CConditionBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepotCondition.Builder getS2CConditionBuilder() {
/*       */         this.bitField0_ |= 0x4;
/*       */         onChanged();
/*       */         return (GuildDepotHandler.DepotCondition.Builder)getS2CConditionFieldBuilder().getBuilder();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DepotConditionOrBuilder getS2CConditionOrBuilder() {
/*       */         if (this.s2CConditionBuilder_ != null) {
/*       */           return (GuildDepotHandler.DepotConditionOrBuilder)this.s2CConditionBuilder_.getMessageOrBuilder();
/*       */         }
/*       */         return this.s2CCondition_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private SingleFieldBuilder<GuildDepotHandler.DepotCondition, GuildDepotHandler.DepotCondition.Builder, GuildDepotHandler.DepotConditionOrBuilder> getS2CConditionFieldBuilder() {
/*       */         if (this.s2CConditionBuilder_ == null) {
/*       */           this.s2CConditionBuilder_ = new SingleFieldBuilder(getS2CCondition(), getParentForChildren(), isClean());
/*       */           this.s2CCondition_ = null;
/*       */         } 
/*       */         return this.s2CConditionBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class DeleteItemResponse
/*       */     extends GeneratedMessage
/*       */     implements DeleteItemResponseOrBuilder
/*       */   {
/*  7719 */     private static final DeleteItemResponse defaultInstance = new DeleteItemResponse(true); private final UnknownFieldSet unknownFields; private DeleteItemResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DeleteItemResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DeleteItemResponse getDefaultInstance() { return defaultInstance; } public DeleteItemResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DeleteItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.deleteCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DeleteItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DeleteItemResponse.class, Builder.class); } public static Parser<DeleteItemResponse> PARSER = (Parser<DeleteItemResponse>)new AbstractParser<DeleteItemResponse>() { public GuildDepotHandler.DeleteItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DeleteItemResponse(input, extensionRegistry); } }
/*  7720 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int DELETECOUNT_FIELD_NUMBER = 3; private int deleteCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DeleteItemResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasDeleteCount() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getDeleteCount() {
/*       */       return this.deleteCount_;
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
/*       */       this.deleteCount_ = 0;
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
/*       */         output.writeInt32(3, this.deleteCount_);
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
/*       */         size += CodedOutputStream.computeInt32Size(3, this.deleteCount_);
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
/*       */     public static DeleteItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(InputStream input) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static DeleteItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (DeleteItemResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(DeleteItemResponse prototype) {
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
/*       */       implements GuildDepotHandler.DeleteItemResponseOrBuilder
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
/*       */       private Object s2CMsg_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int deleteCount_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DeleteItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DeleteItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DeleteItemResponse.class, Builder.class);
/*       */       }
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
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.DeleteItemResponse.alwaysUseFieldBuilders);
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
/*       */         this.deleteCount_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
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
/*       */         return GuildDepotHandler.internal_static_pomelo_area_DeleteItemResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DeleteItemResponse getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.DeleteItemResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public GuildDepotHandler.DeleteItemResponse build() {
/*       */         GuildDepotHandler.DeleteItemResponse result = buildPartial();
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
/*       */       public GuildDepotHandler.DeleteItemResponse buildPartial() {
/*       */         GuildDepotHandler.DeleteItemResponse result = new GuildDepotHandler.DeleteItemResponse(this);
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
/*       */         result.deleteCount_ = this.deleteCount_;
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
/*       */         if (other instanceof GuildDepotHandler.DeleteItemResponse) {
/*       */           return mergeFrom((GuildDepotHandler.DeleteItemResponse)other);
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
/*       */       public Builder mergeFrom(GuildDepotHandler.DeleteItemResponse other) {
/*       */         if (other == GuildDepotHandler.DeleteItemResponse.getDefaultInstance()) {
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
/*       */         if (other.hasDeleteCount()) {
/*       */           setDeleteCount(other.getDeleteCount());
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
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.DeleteItemResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.DeleteItemResponse)GuildDepotHandler.DeleteItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.DeleteItemResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = GuildDepotHandler.DeleteItemResponse.getDefaultInstance().getS2CMsg();
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
/*       */       public boolean hasDeleteCount() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getDeleteCount() {
/*       */         return this.deleteCount_;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setDeleteCount(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.deleteCount_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearDeleteCount() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.deleteCount_ = 0;
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
/*       */   public static final class UpgradeDepotResponse
/*       */     extends GeneratedMessage
/*       */     implements UpgradeDepotResponseOrBuilder
/*       */   {
/*  8437 */     private static final UpgradeDepotResponse defaultInstance = new UpgradeDepotResponse(true); private final UnknownFieldSet unknownFields; private UpgradeDepotResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpgradeDepotResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpgradeDepotResponse getDefaultInstance() { return defaultInstance; } public UpgradeDepotResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpgradeDepotResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CLevel_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.s2CFund_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeDepotResponse.class, Builder.class); } public static Parser<UpgradeDepotResponse> PARSER = (Parser<UpgradeDepotResponse>)new AbstractParser<UpgradeDepotResponse>() { public GuildDepotHandler.UpgradeDepotResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.UpgradeDepotResponse(input, extensionRegistry); } }
/*  8438 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_LEVEL_FIELD_NUMBER = 3; private int s2CLevel_; public static final int S2C_FUND_FIELD_NUMBER = 4; private int s2CFund_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpgradeDepotResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
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
/*       */     public boolean hasS2CLevel() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */     
/*       */     public int getS2CLevel() {
/*       */       return this.s2CLevel_;
/*       */     }
/*       */     
/*       */     public boolean hasS2CFund() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */     
/*       */     public int getS2CFund() {
/*       */       return this.s2CFund_;
/*       */     }
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.s2CLevel_ = 0;
/*       */       this.s2CFund_ = 0;
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
/*       */         output.writeInt32(3, this.s2CLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeInt32(4, this.s2CFund_);
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
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(3, this.s2CLevel_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeInt32Size(4, this.s2CFund_);
/*       */       }
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(InputStream input) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static UpgradeDepotResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (UpgradeDepotResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(UpgradeDepotResponse prototype) {
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
/*       */       implements GuildDepotHandler.UpgradeDepotResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private int s2CLevel_;
/*       */       private int s2CFund_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotResponse_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.UpgradeDepotResponse.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (GuildDepotHandler.UpgradeDepotResponse.alwaysUseFieldBuilders);
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
/*       */         this.s2CLevel_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.s2CFund_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return GuildDepotHandler.internal_static_pomelo_area_UpgradeDepotResponse_descriptor;
/*       */       }
/*       */       
/*       */       public GuildDepotHandler.UpgradeDepotResponse getDefaultInstanceForType() {
/*       */         return GuildDepotHandler.UpgradeDepotResponse.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public GuildDepotHandler.UpgradeDepotResponse build() {
/*       */         GuildDepotHandler.UpgradeDepotResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */       
/*       */       public GuildDepotHandler.UpgradeDepotResponse buildPartial() {
/*       */         GuildDepotHandler.UpgradeDepotResponse result = new GuildDepotHandler.UpgradeDepotResponse(this);
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
/*       */         result.s2CLevel_ = this.s2CLevel_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.s2CFund_ = this.s2CFund_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof GuildDepotHandler.UpgradeDepotResponse) {
/*       */           return mergeFrom((GuildDepotHandler.UpgradeDepotResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(GuildDepotHandler.UpgradeDepotResponse other) {
/*       */         if (other == GuildDepotHandler.UpgradeDepotResponse.getDefaultInstance()) {
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
/*       */         if (other.hasS2CLevel()) {
/*       */           setS2CLevel(other.getS2CLevel());
/*       */         }
/*       */         if (other.hasS2CFund()) {
/*       */           setS2CFund(other.getS2CFund());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasS2CCode()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         GuildDepotHandler.UpgradeDepotResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (GuildDepotHandler.UpgradeDepotResponse)GuildDepotHandler.UpgradeDepotResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (GuildDepotHandler.UpgradeDepotResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null) {
/*       */             mergeFrom(parsedMessage);
/*       */           }
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
/*       */           if (bs.isValidUtf8()) {
/*       */             this.s2CMsg_ = s;
/*       */           }
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
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = GuildDepotHandler.UpgradeDepotResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasS2CLevel() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */       
/*       */       public int getS2CLevel() {
/*       */         return this.s2CLevel_;
/*       */       }
/*       */       
/*       */       public Builder setS2CLevel(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.s2CLevel_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CLevel() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.s2CLevel_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasS2CFund() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       
/*       */       public int getS2CFund() {
/*       */         return this.s2CFund_;
/*       */       }
/*       */       
/*       */       public Builder setS2CFund(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.s2CFund_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearS2CFund() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.s2CFund_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class DepotLevelInfo
/*       */     extends GeneratedMessage
/*       */     implements DepotLevelInfoOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private DepotLevelInfo(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private DepotLevelInfo(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static DepotLevelInfo getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public DepotLevelInfo getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private DepotLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       initFields();
/*       */       int mutable_bitField0_ = 0;
/*       */       UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
/*       */       try {
/*       */         boolean done = false;
/*       */         while (!done) {
/*       */           int tag = input.readTag();
/*       */           switch (tag) {
/*       */             case 0:
/*       */               done = true;
/*       */               break;
/*       */             case 8:
/*       */               this.bitField0_ |= 0x1;
/*       */               this.level_ = input.readInt32();
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.bagGridCount_ = input.readInt32();
/*       */               break;
/*       */             case 24:
/*       */               this.bitField0_ |= 0x4;
/*       */               this.bagTotalCount_ = input.readInt32();
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
/*       */       return GuildDepotHandler.internal_static_pomelo_area_DepotLevelInfo_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return GuildDepotHandler.internal_static_pomelo_area_DepotLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DepotLevelInfo.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<DepotLevelInfo> PARSER = (Parser<DepotLevelInfo>)new AbstractParser<DepotLevelInfo>()
/*       */       {
/*       */         public GuildDepotHandler.DepotLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new GuildDepotHandler.DepotLevelInfo(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int LEVEL_FIELD_NUMBER = 1;
/*       */     private int level_;
/*       */     public static final int BAGGRIDCOUNT_FIELD_NUMBER = 2;
/*       */     private int bagGridCount_;
/*       */     public static final int BAGTOTALCOUNT_FIELD_NUMBER = 3;
/*       */     private int bagTotalCount_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<DepotLevelInfo> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasLevel() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public int getLevel() {
/*       */       return this.level_;
/*       */     }
/*       */     
/*       */     public boolean hasBagGridCount() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */     
/*  8990 */     private static final DepotLevelInfo defaultInstance = new DepotLevelInfo(true); public int getBagGridCount() { return this.bagGridCount_; } public boolean hasBagTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getBagTotalCount() { return this.bagTotalCount_; } private void initFields() { this.level_ = 0; this.bagGridCount_ = 0; this.bagTotalCount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.level_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.bagGridCount_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.bagTotalCount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.level_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.bagGridCount_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.bagTotalCount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DepotLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DepotLevelInfo)PARSER.parseFrom(data); } public static DepotLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepotLevelInfo)PARSER.parseFrom(data, extensionRegistry); } public static DepotLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DepotLevelInfo)PARSER.parseFrom(data); } public static DepotLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepotLevelInfo)PARSER.parseFrom(data, extensionRegistry); } public static DepotLevelInfo parseFrom(InputStream input) throws IOException { return (DepotLevelInfo)PARSER.parseFrom(input); } public static DepotLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotLevelInfo)PARSER.parseFrom(input, extensionRegistry); } public static DepotLevelInfo parseDelimitedFrom(InputStream input) throws IOException { return (DepotLevelInfo)PARSER.parseDelimitedFrom(input); } public static DepotLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotLevelInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DepotLevelInfo parseFrom(CodedInputStream input) throws IOException { return (DepotLevelInfo)PARSER.parseFrom(input); } public static DepotLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotLevelInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DepotLevelInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.DepotLevelInfoOrBuilder {
/*  8991 */       private int bitField0_; private int level_; private int bagGridCount_; private int bagTotalCount_; public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepotLevelInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepotLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DepotLevelInfo.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (GuildDepotHandler.DepotLevelInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.level_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.bagGridCount_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.bagTotalCount_ = 0; this.bitField0_ &= 0xFFFFFFFB; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_DepotLevelInfo_descriptor; } public GuildDepotHandler.DepotLevelInfo getDefaultInstanceForType() { return GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); } public GuildDepotHandler.DepotLevelInfo build() { GuildDepotHandler.DepotLevelInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public GuildDepotHandler.DepotLevelInfo buildPartial() { GuildDepotHandler.DepotLevelInfo result = new GuildDepotHandler.DepotLevelInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.level_ = this.level_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.bagGridCount_ = this.bagGridCount_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.bagTotalCount_ = this.bagTotalCount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.DepotLevelInfo) return mergeFrom((GuildDepotHandler.DepotLevelInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(GuildDepotHandler.DepotLevelInfo other) { if (other == GuildDepotHandler.DepotLevelInfo.getDefaultInstance()) return this;  if (other.hasLevel()) setLevel(other.getLevel());  if (other.hasBagGridCount()) setBagGridCount(other.getBagGridCount());  if (other.hasBagTotalCount()) setBagTotalCount(other.getBagTotalCount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.DepotLevelInfo parsedMessage = null; try { parsedMessage = (GuildDepotHandler.DepotLevelInfo)GuildDepotHandler.DepotLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.DepotLevelInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getLevel() { return this.level_; } public Builder setLevel(int value) { this.bitField0_ |= 0x1; this.level_ = value; onChanged(); return this; } public Builder clearLevel() { this.bitField0_ &= 0xFFFFFFFE; this.level_ = 0; onChanged(); return this; } public boolean hasBagGridCount() { return ((this.bitField0_ & 0x2) == 2); } public int getBagGridCount() { return this.bagGridCount_; } public Builder setBagGridCount(int value) { this.bitField0_ |= 0x2; this.bagGridCount_ = value; onChanged(); return this; } public Builder clearBagGridCount() { this.bitField0_ &= 0xFFFFFFFD; this.bagGridCount_ = 0; onChanged(); return this; } public boolean hasBagTotalCount() { return ((this.bitField0_ & 0x4) == 4); } public int getBagTotalCount() { return this.bagTotalCount_; } public Builder setBagTotalCount(int value) { this.bitField0_ |= 0x4; this.bagTotalCount_ = value; onChanged(); return this; } public Builder clearBagTotalCount() { this.bitField0_ &= 0xFFFFFFFB; this.bagTotalCount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class DepotRefreshPush
/*       */     extends GeneratedMessage
/*       */     implements DepotRefreshPushOrBuilder
/*       */   {
/* 10282 */     private static final DepotRefreshPush defaultInstance = new DepotRefreshPush(true); private final UnknownFieldSet unknownFields; private DepotRefreshPush(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DepotRefreshPush(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DepotRefreshPush getDefaultInstance() { return defaultInstance; } public DepotRefreshPush getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DepotRefreshPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; GuildDepotHandler.DepotLevelInfo.Builder builder; GuildDepotHandler.DepotCondition.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.type_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.bagIndex_ = input.readInt32(); break;case 42: builder = null; if ((this.bitField0_ & 0x10) == 16) builder = this.levelInfo_.toBuilder();  this.levelInfo_ = (GuildDepotHandler.DepotLevelInfo)input.readMessage(GuildDepotHandler.DepotLevelInfo.PARSER, extensionRegistry); if (builder != null) { builder.mergeFrom(this.levelInfo_); this.levelInfo_ = builder.buildPartial(); }  this.bitField0_ |= 0x10; break;case 50: subBuilder = null; if ((this.bitField0_ & 0x20) == 32) subBuilder = this.condition_.toBuilder();  this.condition_ = (GuildDepotHandler.DepotCondition)input.readMessage(GuildDepotHandler.DepotCondition.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.condition_); this.condition_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x20; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepotRefreshPush_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepotRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(DepotRefreshPush.class, Builder.class); } public static Parser<DepotRefreshPush> PARSER = (Parser<DepotRefreshPush>)new AbstractParser<DepotRefreshPush>() { public GuildDepotHandler.DepotRefreshPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new GuildDepotHandler.DepotRefreshPush(input, extensionRegistry); } }
/* 10283 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int TYPE_FIELD_NUMBER = 3; private int type_; public static final int BAGINDEX_FIELD_NUMBER = 4; private int bagIndex_; public static final int LEVELINFO_FIELD_NUMBER = 5; private GuildDepotHandler.DepotLevelInfo levelInfo_; public static final int CONDITION_FIELD_NUMBER = 6; private GuildDepotHandler.DepotCondition condition_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DepotRefreshPush> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasType() { return ((this.bitField0_ & 0x4) == 4); } public int getType() { return this.type_; } public boolean hasBagIndex() { return ((this.bitField0_ & 0x8) == 8); } public int getBagIndex() { return this.bagIndex_; } public boolean hasLevelInfo() { return ((this.bitField0_ & 0x10) == 16); } public GuildDepotHandler.DepotLevelInfo getLevelInfo() { return this.levelInfo_; } public GuildDepotHandler.DepotLevelInfoOrBuilder getLevelInfoOrBuilder() { return this.levelInfo_; } public boolean hasCondition() { return ((this.bitField0_ & 0x20) == 32); } public GuildDepotHandler.DepotCondition getCondition() { return this.condition_; } public GuildDepotHandler.DepotConditionOrBuilder getConditionOrBuilder() { return this.condition_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.type_ = 0; this.bagIndex_ = 0; this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); this.condition_ = GuildDepotHandler.DepotCondition.getDefaultInstance(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (hasCondition() && !getCondition().isInitialized()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.type_);  if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.bagIndex_);  if ((this.bitField0_ & 0x10) == 16) output.writeMessage(5, (MessageLite)this.levelInfo_);  if ((this.bitField0_ & 0x20) == 32) output.writeMessage(6, (MessageLite)this.condition_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.type_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.bagIndex_);  if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.levelInfo_);  if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeMessageSize(6, (MessageLite)this.condition_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DepotRefreshPush parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DepotRefreshPush)PARSER.parseFrom(data); } public static DepotRefreshPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepotRefreshPush)PARSER.parseFrom(data, extensionRegistry); } public static DepotRefreshPush parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DepotRefreshPush)PARSER.parseFrom(data); } public static DepotRefreshPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DepotRefreshPush)PARSER.parseFrom(data, extensionRegistry); } public static DepotRefreshPush parseFrom(InputStream input) throws IOException { return (DepotRefreshPush)PARSER.parseFrom(input); } public static DepotRefreshPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotRefreshPush)PARSER.parseFrom(input, extensionRegistry); } public static DepotRefreshPush parseDelimitedFrom(InputStream input) throws IOException { return (DepotRefreshPush)PARSER.parseDelimitedFrom(input); } public static DepotRefreshPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotRefreshPush)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static DepotRefreshPush parseFrom(CodedInputStream input) throws IOException { return (DepotRefreshPush)PARSER.parseFrom(input); } public static DepotRefreshPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DepotRefreshPush)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(DepotRefreshPush prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } static { defaultInstance.initFields(); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildDepotHandler.DepotRefreshPushOrBuilder {
/*       */       private int bitField0_;
/*       */       private int s2CCode_;
/*       */       private Object s2CMsg_;
/*       */       private int type_;
/*       */       private int bagIndex_;
/*       */       private GuildDepotHandler.DepotLevelInfo levelInfo_;
/*       */       private SingleFieldBuilder<GuildDepotHandler.DepotLevelInfo, GuildDepotHandler.DepotLevelInfo.Builder, GuildDepotHandler.DepotLevelInfoOrBuilder> levelInfoBuilder_;
/*       */       private GuildDepotHandler.DepotCondition condition_;
/*       */       private SingleFieldBuilder<GuildDepotHandler.DepotCondition, GuildDepotHandler.DepotCondition.Builder, GuildDepotHandler.DepotConditionOrBuilder> conditionBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return GuildDepotHandler.internal_static_pomelo_area_DepotRefreshPush_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return GuildDepotHandler.internal_static_pomelo_area_DepotRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildDepotHandler.DepotRefreshPush.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); this.condition_ = GuildDepotHandler.DepotCondition.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); this.condition_ = GuildDepotHandler.DepotCondition.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (GuildDepotHandler.DepotRefreshPush.alwaysUseFieldBuilders) { getLevelInfoFieldBuilder(); getConditionFieldBuilder(); }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.type_ = 0; this.bitField0_ &= 0xFFFFFFFB; this.bagIndex_ = 0; this.bitField0_ &= 0xFFFFFFF7; if (this.levelInfoBuilder_ == null) { this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); } else { this.levelInfoBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFEF; if (this.conditionBuilder_ == null) { this.condition_ = GuildDepotHandler.DepotCondition.getDefaultInstance(); } else { this.conditionBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFDF; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return GuildDepotHandler.internal_static_pomelo_area_DepotRefreshPush_descriptor; }
/*       */       public GuildDepotHandler.DepotRefreshPush getDefaultInstanceForType() { return GuildDepotHandler.DepotRefreshPush.getDefaultInstance(); }
/*       */       public GuildDepotHandler.DepotRefreshPush build() { GuildDepotHandler.DepotRefreshPush result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public GuildDepotHandler.DepotRefreshPush buildPartial() { GuildDepotHandler.DepotRefreshPush result = new GuildDepotHandler.DepotRefreshPush(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4;  result.type_ = this.type_; if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8;  result.bagIndex_ = this.bagIndex_; if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10;  if (this.levelInfoBuilder_ == null) { result.levelInfo_ = this.levelInfo_; } else { result.levelInfo_ = (GuildDepotHandler.DepotLevelInfo)this.levelInfoBuilder_.build(); }  if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20;  if (this.conditionBuilder_ == null) { result.condition_ = this.condition_; } else { result.condition_ = (GuildDepotHandler.DepotCondition)this.conditionBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof GuildDepotHandler.DepotRefreshPush)
/*       */           return mergeFrom((GuildDepotHandler.DepotRefreshPush)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(GuildDepotHandler.DepotRefreshPush other) { if (other == GuildDepotHandler.DepotRefreshPush.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasType())
/*       */           setType(other.getType());  if (other.hasBagIndex())
/*       */           setBagIndex(other.getBagIndex());  if (other.hasLevelInfo())
/*       */           mergeLevelInfo(other.getLevelInfo());  if (other.hasCondition())
/*       */           mergeCondition(other.getCondition());  mergeUnknownFields(other.getUnknownFields()); return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false;  if (hasCondition() && !getCondition().isInitialized())
/*       */           return false;  return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { GuildDepotHandler.DepotRefreshPush parsedMessage = null; try { parsedMessage = (GuildDepotHandler.DepotRefreshPush)GuildDepotHandler.DepotRefreshPush.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (GuildDepotHandler.DepotRefreshPush)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage);  }  return this; }
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
/*       */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = GuildDepotHandler.DepotRefreshPush.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*       */       public boolean hasType() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public int getType() { return this.type_; }
/*       */       public Builder setType(int value) { this.bitField0_ |= 0x4; this.type_ = value; onChanged(); return this; }
/*       */       public Builder clearType() { this.bitField0_ &= 0xFFFFFFFB; this.type_ = 0; onChanged(); return this; }
/*       */       public boolean hasBagIndex() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public int getBagIndex() { return this.bagIndex_; }
/*       */       public Builder setBagIndex(int value) { this.bitField0_ |= 0x8; this.bagIndex_ = value; onChanged(); return this; }
/*       */       public Builder clearBagIndex() { this.bitField0_ &= 0xFFFFFFF7; this.bagIndex_ = 0; onChanged(); return this; }
/*       */       public boolean hasLevelInfo() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public GuildDepotHandler.DepotLevelInfo getLevelInfo() { if (this.levelInfoBuilder_ == null)
/*       */           return this.levelInfo_;  return (GuildDepotHandler.DepotLevelInfo)this.levelInfoBuilder_.getMessage(); }
/*       */       public Builder setLevelInfo(GuildDepotHandler.DepotLevelInfo value) { if (this.levelInfoBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  this.levelInfo_ = value; onChanged(); } else { this.levelInfoBuilder_.setMessage(value); }  this.bitField0_ |= 0x10; return this; }
/*       */       public Builder setLevelInfo(GuildDepotHandler.DepotLevelInfo.Builder builderForValue) { if (this.levelInfoBuilder_ == null) { this.levelInfo_ = builderForValue.build(); onChanged(); } else { this.levelInfoBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x10; return this; }
/*       */       public Builder mergeLevelInfo(GuildDepotHandler.DepotLevelInfo value) { if (this.levelInfoBuilder_ == null) { if ((this.bitField0_ & 0x10) == 16 && this.levelInfo_ != GuildDepotHandler.DepotLevelInfo.getDefaultInstance()) { this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.newBuilder(this.levelInfo_).mergeFrom(value).buildPartial(); } else { this.levelInfo_ = value; }  onChanged(); } else { this.levelInfoBuilder_.mergeFrom(value); }  this.bitField0_ |= 0x10; return this; }
/*       */       public Builder clearLevelInfo() { if (this.levelInfoBuilder_ == null) { this.levelInfo_ = GuildDepotHandler.DepotLevelInfo.getDefaultInstance(); onChanged(); } else { this.levelInfoBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFEF; return this; }
/*       */       public GuildDepotHandler.DepotLevelInfo.Builder getLevelInfoBuilder() { this.bitField0_ |= 0x10; onChanged(); return (GuildDepotHandler.DepotLevelInfo.Builder)getLevelInfoFieldBuilder().getBuilder(); }
/*       */       public GuildDepotHandler.DepotLevelInfoOrBuilder getLevelInfoOrBuilder() { if (this.levelInfoBuilder_ != null)
/*       */           return (GuildDepotHandler.DepotLevelInfoOrBuilder)this.levelInfoBuilder_.getMessageOrBuilder();  return this.levelInfo_; } private SingleFieldBuilder<GuildDepotHandler.DepotLevelInfo, GuildDepotHandler.DepotLevelInfo.Builder, GuildDepotHandler.DepotLevelInfoOrBuilder> getLevelInfoFieldBuilder() { if (this.levelInfoBuilder_ == null) { this.levelInfoBuilder_ = new SingleFieldBuilder(getLevelInfo(), getParentForChildren(), isClean()); this.levelInfo_ = null; }  return this.levelInfoBuilder_; } public boolean hasCondition() { return ((this.bitField0_ & 0x20) == 32); } public GuildDepotHandler.DepotCondition getCondition() { if (this.conditionBuilder_ == null)
/*       */           return this.condition_;  return (GuildDepotHandler.DepotCondition)this.conditionBuilder_.getMessage(); } public Builder setCondition(GuildDepotHandler.DepotCondition value) { if (this.conditionBuilder_ == null) { if (value == null)
/*       */             throw new NullPointerException();  this.condition_ = value; onChanged(); } else { this.conditionBuilder_.setMessage(value); }  this.bitField0_ |= 0x20; return this; } public Builder setCondition(GuildDepotHandler.DepotCondition.Builder builderForValue) { if (this.conditionBuilder_ == null) { this.condition_ = builderForValue.build(); onChanged(); } else { this.conditionBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x20; return this; } public Builder mergeCondition(GuildDepotHandler.DepotCondition value) { if (this.conditionBuilder_ == null) { if ((this.bitField0_ & 0x20) == 32 && this.condition_ != GuildDepotHandler.DepotCondition.getDefaultInstance()) { this.condition_ = GuildDepotHandler.DepotCondition.newBuilder(this.condition_).mergeFrom(value).buildPartial(); } else { this.condition_ = value; }  onChanged(); } else { this.conditionBuilder_.mergeFrom(value); }
/*       */          this.bitField0_ |= 0x20; return this; } public Builder clearCondition() { if (this.conditionBuilder_ == null) { this.condition_ = GuildDepotHandler.DepotCondition.getDefaultInstance(); onChanged(); }
/*       */         else { this.conditionBuilder_.clear(); }
/*       */          this.bitField0_ &= 0xFFFFFFDF; return this; } public GuildDepotHandler.DepotCondition.Builder getConditionBuilder() { this.bitField0_ |= 0x20; onChanged(); return (GuildDepotHandler.DepotCondition.Builder)getConditionFieldBuilder().getBuilder(); } public GuildDepotHandler.DepotConditionOrBuilder getConditionOrBuilder() { if (this.conditionBuilder_ != null)
/*       */           return (GuildDepotHandler.DepotConditionOrBuilder)this.conditionBuilder_.getMessageOrBuilder();  return this.condition_; } private SingleFieldBuilder<GuildDepotHandler.DepotCondition, GuildDepotHandler.DepotCondition.Builder, GuildDepotHandler.DepotConditionOrBuilder> getConditionFieldBuilder() { if (this.conditionBuilder_ == null) { this.conditionBuilder_ = new SingleFieldBuilder(getCondition(), getParentForChildren(), isClean()); this.condition_ = null; }
/*       */          return this.conditionBuilder_; } }
/* 10367 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 10372 */     String[] descriptorData = { "\n\027guildDepotHandler.proto\022\013pomelo.area\032\nitem.proto\032\fcommon.proto\"6\n\007UseCond\022\r\n\005level\030\001 \001(\005\022\017\n\007upLevel\030\002 \001(\005\022\013\n\003job\030\003 \002(\005\"=\n\013QualityCond\022\r\n\005level\030\001 \001(\005\022\017\n\007upLevel\030\002 \001(\005\022\016\n\006qColor\030\003 \001(\005\"\001\n\016DepotCondition\022%\n\007useCond\030\001 \001(\0132\024.pomelo.area.UseCond\022)\n\007minCond\030\002 \001(\0132\030.pomelo.area.QualityCond\022)\n\007maxCond\030\003 \001(\0132\030.pomelo.area.QualityCond\"+\n\022DepositItemRequest\022\025\n\rc2s_fromIndex\030\001 \002(\005\"+\n\022TakeOutItemRequest\022\025\n\rc2", "s_fromIndex\030\001 \002(\005\"½\001\n\023SetConditionRequest\022\020\n\buseLevel\030\001 \001(\005\022\022\n\nuseUpLevel\030\002 \001(\005\022\016\n\006useJob\030\003 \002(\005\022\020\n\bminLevel\030\004 \001(\005\022\022\n\nminUpLevel\030\005 \001(\005\022\021\n\tminqColor\030\006 \001(\005\022\020\n\bmaxLevel\030\007 \001(\005\022\022\n\nmaxUpLevel\030\b \001(\005\022\021\n\tmaxqColor\030\t \001(\005\"*\n\021DeleteItemRequest\022\025\n\rc2s_fromIndex\030\001 \002(\005\"\025\n\023UpgradeDepotRequest\"v\n\023DepositItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022&\n\013s2c_bagGrid\030\003 \001(\0132\021.pomelo.item.Grid\022\024\n\fdepositCount\030\004 \001(\005\"8\n\023", "TakeOutItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"m\n\024SetConditionResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0222\n\rs2c_condition\030\003 \001(\0132\033.pomelo.area.DepotCondition\"L\n\022DeleteItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013deleteCount\030\003 \001(\005\"^\n\024UpgradeDepotResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\ts2c_level\030\003 \001(\005\022\020\n\bs2c_fund\030\004 \001(\005\"L\n\016DepotLevelInfo\022\r\n\005level\030\001 \001(\005\022\024\n\fbagGridCount\030\002 \001(\005\022\025\n\rba", "gTotalCount\030\003 \001(\005\"µ\001\n\020DepotRefreshPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004type\030\003 \001(\005\022\020\n\bbagIndex\030\004 \001(\005\022.\n\tlevelInfo\030\005 \001(\0132\033.pomelo.area.DepotLevelInfo\022.\n\tcondition\030\006 \001(\0132\033.pomelo.area.DepotCondition2Ó\003\n\021guildDepotHandler\022W\n\022depositItemRequest\022\037.pomelo.area.DepositItemRequest\032 .pomelo.area.DepositItemResponse\022W\n\022takeOutItemRequest\022\037.pomelo.area.TakeOutItemRequest\032 .pomelo.area.TakeOutItemRespons", "e\022Z\n\023setConditionRequest\022 .pomelo.area.SetConditionRequest\032!.pomelo.area.SetConditionResponse\022T\n\021deleteItemRequest\022\036.pomelo.area.DeleteItemRequest\032\037.pomelo.area.DeleteItemResponse\022Z\n\023upgradeDepotRequest\022 .pomelo.area.UpgradeDepotRequest\032!.pomelo.area.UpgradeDepotResponse2Q\n\016guildDepotPush\022?\n\020depotRefreshPush\022\035.pomelo.area.DepotRefreshPush\032\f.pomelo.Void" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10423 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 10427 */           GuildDepotHandler.descriptor = root;
/* 10428 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 10432 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 10434 */           ItemOuterClass.getDescriptor(), 
/* 10435 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 10438 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UseCond_descriptor = getDescriptor().getMessageTypes().get(0);
/* 10439 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UseCond_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UseCond_descriptor, new String[] { "Level", "UpLevel", "Job" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10444 */   private static final Descriptors.Descriptor internal_static_pomelo_area_QualityCond_descriptor = getDescriptor().getMessageTypes().get(1);
/* 10445 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QualityCond_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QualityCond_descriptor, new String[] { "Level", "UpLevel", "QColor" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10450 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DepotCondition_descriptor = getDescriptor().getMessageTypes().get(2);
/* 10451 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DepotCondition_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DepotCondition_descriptor, new String[] { "UseCond", "MinCond", "MaxCond" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10456 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DepositItemRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 10457 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DepositItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DepositItemRequest_descriptor, new String[] { "C2SFromIndex" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10462 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TakeOutItemRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 10463 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TakeOutItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TakeOutItemRequest_descriptor, new String[] { "C2SFromIndex" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10468 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetConditionRequest_descriptor = getDescriptor().getMessageTypes().get(5);
/* 10469 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetConditionRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetConditionRequest_descriptor, new String[] { "UseLevel", "UseUpLevel", "UseJob", "MinLevel", "MinUpLevel", "MinqColor", "MaxLevel", "MaxUpLevel", "MaxqColor" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10474 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DeleteItemRequest_descriptor = getDescriptor().getMessageTypes().get(6);
/* 10475 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DeleteItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DeleteItemRequest_descriptor, new String[] { "C2SFromIndex" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10480 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeDepotRequest_descriptor = getDescriptor().getMessageTypes().get(7);
/* 10481 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeDepotRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeDepotRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10486 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DepositItemResponse_descriptor = getDescriptor().getMessageTypes().get(8);
/* 10487 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DepositItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DepositItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CBagGrid", "DepositCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10492 */   private static final Descriptors.Descriptor internal_static_pomelo_area_TakeOutItemResponse_descriptor = getDescriptor().getMessageTypes().get(9);
/* 10493 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TakeOutItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TakeOutItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10498 */   private static final Descriptors.Descriptor internal_static_pomelo_area_SetConditionResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 10499 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SetConditionResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SetConditionResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CCondition" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10504 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DeleteItemResponse_descriptor = getDescriptor().getMessageTypes().get(11);
/* 10505 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DeleteItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DeleteItemResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "DeleteCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10510 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeDepotResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 10511 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeDepotResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeDepotResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CLevel", "S2CFund" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10516 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DepotLevelInfo_descriptor = getDescriptor().getMessageTypes().get(13);
/* 10517 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DepotLevelInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DepotLevelInfo_descriptor, new String[] { "Level", "BagGridCount", "BagTotalCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 10522 */   private static final Descriptors.Descriptor internal_static_pomelo_area_DepotRefreshPush_descriptor = getDescriptor().getMessageTypes().get(14);
/* 10523 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DepotRefreshPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DepotRefreshPush_descriptor, new String[] { "S2CCode", "S2CMsg", "Type", "BagIndex", "LevelInfo", "Condition" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 10527 */     ItemOuterClass.getDescriptor();
/* 10528 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface DepotRefreshPushOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasType();
/*       */     
/*       */     int getType();
/*       */     
/*       */     boolean hasBagIndex();
/*       */     
/*       */     int getBagIndex();
/*       */     
/*       */     boolean hasLevelInfo();
/*       */     
/*       */     GuildDepotHandler.DepotLevelInfo getLevelInfo();
/*       */     
/*       */     GuildDepotHandler.DepotLevelInfoOrBuilder getLevelInfoOrBuilder();
/*       */     
/*       */     boolean hasCondition();
/*       */     
/*       */     GuildDepotHandler.DepotCondition getCondition();
/*       */     
/*       */     GuildDepotHandler.DepotConditionOrBuilder getConditionOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface DepotLevelInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasBagGridCount();
/*       */     
/*       */     int getBagGridCount();
/*       */     
/*       */     boolean hasBagTotalCount();
/*       */     
/*       */     int getBagTotalCount();
/*       */   }
/*       */   
/*       */   public static interface UpgradeDepotResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CLevel();
/*       */     
/*       */     int getS2CLevel();
/*       */     
/*       */     boolean hasS2CFund();
/*       */     
/*       */     int getS2CFund();
/*       */   }
/*       */   
/*       */   public static interface DeleteItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasDeleteCount();
/*       */     
/*       */     int getDeleteCount();
/*       */   }
/*       */   
/*       */   public static interface SetConditionResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CCondition();
/*       */     
/*       */     GuildDepotHandler.DepotCondition getS2CCondition();
/*       */     
/*       */     GuildDepotHandler.DepotConditionOrBuilder getS2CConditionOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface TakeOutItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface DepositItemResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasS2CBagGrid();
/*       */     
/*       */     ItemOuterClass.Grid getS2CBagGrid();
/*       */     
/*       */     ItemOuterClass.GridOrBuilder getS2CBagGridOrBuilder();
/*       */     
/*       */     boolean hasDepositCount();
/*       */     
/*       */     int getDepositCount();
/*       */   }
/*       */   
/*       */   public static interface UpgradeDepotRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface DeleteItemRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SFromIndex();
/*       */     
/*       */     int getC2SFromIndex();
/*       */   }
/*       */   
/*       */   public static interface SetConditionRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasUseLevel();
/*       */     
/*       */     int getUseLevel();
/*       */     
/*       */     boolean hasUseUpLevel();
/*       */     
/*       */     int getUseUpLevel();
/*       */     
/*       */     boolean hasUseJob();
/*       */     
/*       */     int getUseJob();
/*       */     
/*       */     boolean hasMinLevel();
/*       */     
/*       */     int getMinLevel();
/*       */     
/*       */     boolean hasMinUpLevel();
/*       */     
/*       */     int getMinUpLevel();
/*       */     
/*       */     boolean hasMinqColor();
/*       */     
/*       */     int getMinqColor();
/*       */     
/*       */     boolean hasMaxLevel();
/*       */     
/*       */     int getMaxLevel();
/*       */     
/*       */     boolean hasMaxUpLevel();
/*       */     
/*       */     int getMaxUpLevel();
/*       */     
/*       */     boolean hasMaxqColor();
/*       */     
/*       */     int getMaxqColor();
/*       */   }
/*       */   
/*       */   public static interface TakeOutItemRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SFromIndex();
/*       */     
/*       */     int getC2SFromIndex();
/*       */   }
/*       */   
/*       */   public static interface DepositItemRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasC2SFromIndex();
/*       */     
/*       */     int getC2SFromIndex();
/*       */   }
/*       */   
/*       */   public static interface DepotConditionOrBuilder extends MessageOrBuilder {
/*       */     boolean hasUseCond();
/*       */     
/*       */     GuildDepotHandler.UseCond getUseCond();
/*       */     
/*       */     GuildDepotHandler.UseCondOrBuilder getUseCondOrBuilder();
/*       */     
/*       */     boolean hasMinCond();
/*       */     
/*       */     GuildDepotHandler.QualityCond getMinCond();
/*       */     
/*       */     GuildDepotHandler.QualityCondOrBuilder getMinCondOrBuilder();
/*       */     
/*       */     boolean hasMaxCond();
/*       */     
/*       */     GuildDepotHandler.QualityCond getMaxCond();
/*       */     
/*       */     GuildDepotHandler.QualityCondOrBuilder getMaxCondOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface QualityCondOrBuilder extends MessageOrBuilder {
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasUpLevel();
/*       */     
/*       */     int getUpLevel();
/*       */     
/*       */     boolean hasQColor();
/*       */     
/*       */     int getQColor();
/*       */   }
/*       */   
/*       */   public static interface UseCondOrBuilder extends MessageOrBuilder {
/*       */     boolean hasLevel();
/*       */     
/*       */     int getLevel();
/*       */     
/*       */     boolean hasUpLevel();
/*       */     
/*       */     int getUpLevel();
/*       */     
/*       */     boolean hasJob();
/*       */     
/*       */     int getJob();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\GuildDepotHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */