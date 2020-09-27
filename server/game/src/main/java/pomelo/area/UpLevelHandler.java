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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class UpLevelHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class UpData
/*      */     extends GeneratedMessage
/*      */     implements UpDataOrBuilder
/*      */   {
/* 1279 */     private static final UpData defaultInstance = new UpData(true); private final UnknownFieldSet unknownFields; private UpData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpData getDefaultInstance() { return defaultInstance; } public UpData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.level_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.upLevel_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.reqLevel_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.downLevel_ = input.readInt32(); break;case 42: if ((mutable_bitField0_ & 0x10) != 16) { this.attrs_ = new ArrayList<>(); mutable_bitField0_ |= 0x10; }  this.attrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x10) == 16) this.attrs_ = Collections.unmodifiableList(this.attrs_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpData_fieldAccessorTable.ensureFieldAccessorsInitialized(UpData.class, Builder.class); } public static Parser<UpData> PARSER = (Parser<UpData>)new AbstractParser<UpData>() { public UpLevelHandler.UpData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new UpLevelHandler.UpData(input, extensionRegistry); } }
/* 1280 */     ; private int bitField0_; public static final int LEVEL_FIELD_NUMBER = 1; private int level_; public static final int UPLEVEL_FIELD_NUMBER = 2; private int upLevel_; public static final int REQLEVEL_FIELD_NUMBER = 3; private int reqLevel_; public static final int DOWNLEVEL_FIELD_NUMBER = 4; private int downLevel_; public static final int ATTRS_FIELD_NUMBER = 5; private List<Common.AttributeBase> attrs_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpData> getParserForType() { return PARSER; } public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); } public int getLevel() { return this.level_; } public boolean hasUpLevel() { return ((this.bitField0_ & 0x2) == 2); } public int getUpLevel() { return this.upLevel_; } static { defaultInstance.initFields(); } public boolean hasReqLevel() { return ((this.bitField0_ & 0x4) == 4); }
/*      */     public int getReqLevel() { return this.reqLevel_; }
/*      */     public boolean hasDownLevel() { return ((this.bitField0_ & 0x8) == 8); }
/*      */     public int getDownLevel() { return this.downLevel_; }
/*      */     public List<Common.AttributeBase> getAttrsList() { return this.attrs_; }
/*      */     public List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList() { return (List)this.attrs_; }
/*      */     public int getAttrsCount() { return this.attrs_.size(); }
/*      */     public Common.AttributeBase getAttrs(int index) { return this.attrs_.get(index); }
/*      */     public Common.AttributeBaseOrBuilder getAttrsOrBuilder(int index) { return (Common.AttributeBaseOrBuilder)this.attrs_.get(index); }
/*      */     private void initFields() { this.level_ = 0; this.upLevel_ = 0; this.reqLevel_ = 0; this.downLevel_ = 0; this.attrs_ = Collections.emptyList(); }
/*      */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*      */         return true;  if (isInitialized == 0)
/*      */         return false;  if (!hasLevel()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  if (!hasUpLevel()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  if (!hasReqLevel()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  if (!hasDownLevel()) {
/*      */         this.memoizedIsInitialized = 0; return false;
/*      */       }  for (int i = 0; i < getAttrsCount(); i++) {
/*      */         if (!getAttrs(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0; return false;
/*      */         } 
/*      */       }  this.memoizedIsInitialized = 1; return true; }
/*      */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.level_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeInt32(2, this.upLevel_);  if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeInt32(3, this.reqLevel_);  if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeInt32(4, this.downLevel_);  for (int i = 0; i < this.attrs_.size(); i++)
/*      */         output.writeMessage(5, (MessageLite)this.attrs_.get(i));  getUnknownFields().writeTo(output); }
/*      */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*      */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.level_);  if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeInt32Size(2, this.upLevel_);  if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeInt32Size(3, this.reqLevel_);  if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeInt32Size(4, this.downLevel_);  for (int i = 0; i < this.attrs_.size(); i++)
/*      */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.attrs_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*      */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*      */     public static UpData parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpData)PARSER.parseFrom(data); }
/*      */     public static UpData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpData)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static UpData parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpData)PARSER.parseFrom(data); }
/*      */     public static UpData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpData)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static UpData parseFrom(InputStream input) throws IOException { return (UpData)PARSER.parseFrom(input); }
/*      */     public static UpData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpData)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static UpData parseDelimitedFrom(InputStream input) throws IOException { return (UpData)PARSER.parseDelimitedFrom(input); }
/*      */     public static UpData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpData)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static UpData parseFrom(CodedInputStream input) throws IOException { return (UpData)PARSER.parseFrom(input); }
/*      */     public static UpData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpData)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(UpData prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements UpLevelHandler.UpDataOrBuilder { private int bitField0_; private int level_; private int upLevel_; private int reqLevel_; private int downLevel_; private List<Common.AttributeBase> attrs_; private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> attrsBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpData_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpData_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelHandler.UpData.class, Builder.class); }
/*      */       private Builder() { this.attrs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.attrs_ = Collections.emptyList(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (UpLevelHandler.UpData.alwaysUseFieldBuilders)
/*      */           getAttrsFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear();
/*      */         this.level_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.upLevel_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.reqLevel_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.downLevel_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         if (this.attrsBuilder_ == null) {
/*      */           this.attrs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */         } else {
/*      */           this.attrsBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return UpLevelHandler.internal_static_pomelo_area_UpData_descriptor; }
/*      */       public UpLevelHandler.UpData getDefaultInstanceForType() { return UpLevelHandler.UpData.getDefaultInstance(); }
/*      */       public UpLevelHandler.UpData build() { UpLevelHandler.UpData result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result; }
/*      */       public UpLevelHandler.UpData buildPartial() { UpLevelHandler.UpData result = new UpLevelHandler.UpData(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.level_ = this.level_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.upLevel_ = this.upLevel_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.reqLevel_ = this.reqLevel_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.downLevel_ = this.downLevel_;
/*      */         if (this.attrsBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x10) == 16) {
/*      */             this.attrs_ = Collections.unmodifiableList(this.attrs_);
/*      */             this.bitField0_ &= 0xFFFFFFEF;
/*      */           } 
/*      */           result.attrs_ = this.attrs_;
/*      */         } else {
/*      */           result.attrs_ = this.attrsBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof UpLevelHandler.UpData)
/*      */           return mergeFrom((UpLevelHandler.UpData)other); 
/*      */         super.mergeFrom(other);
/*      */         return this; }
/*      */       public Builder mergeFrom(UpLevelHandler.UpData other) { if (other == UpLevelHandler.UpData.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasLevel())
/*      */           setLevel(other.getLevel()); 
/*      */         if (other.hasUpLevel())
/*      */           setUpLevel(other.getUpLevel()); 
/*      */         if (other.hasReqLevel())
/*      */           setReqLevel(other.getReqLevel()); 
/*      */         if (other.hasDownLevel())
/*      */           setDownLevel(other.getDownLevel()); 
/*      */         if (this.attrsBuilder_ == null) {
/*      */           if (!other.attrs_.isEmpty()) {
/*      */             if (this.attrs_.isEmpty()) {
/*      */               this.attrs_ = other.attrs_;
/*      */               this.bitField0_ &= 0xFFFFFFEF;
/*      */             } else {
/*      */               ensureAttrsIsMutable();
/*      */               this.attrs_.addAll(other.attrs_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.attrs_.isEmpty()) {
/*      */           if (this.attrsBuilder_.isEmpty()) {
/*      */             this.attrsBuilder_.dispose();
/*      */             this.attrsBuilder_ = null;
/*      */             this.attrs_ = other.attrs_;
/*      */             this.bitField0_ &= 0xFFFFFFEF;
/*      */             this.attrsBuilder_ = UpLevelHandler.UpData.alwaysUseFieldBuilders ? getAttrsFieldBuilder() : null;
/*      */           } else {
/*      */             this.attrsBuilder_.addAllMessages(other.attrs_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this; }
/*      */       public final boolean isInitialized() { if (!hasLevel())
/*      */           return false; 
/*      */         if (!hasUpLevel())
/*      */           return false; 
/*      */         if (!hasReqLevel())
/*      */           return false; 
/*      */         if (!hasDownLevel())
/*      */           return false; 
/*      */         for (int i = 0; i < getAttrsCount(); i++) {
/*      */           if (!getAttrs(i).isInitialized())
/*      */             return false; 
/*      */         } 
/*      */         return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { UpLevelHandler.UpData parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (UpLevelHandler.UpData)UpLevelHandler.UpData.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (UpLevelHandler.UpData)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this; }
/*      */       public boolean hasLevel() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getLevel() { return this.level_; }
/*      */       public Builder setLevel(int value) { this.bitField0_ |= 0x1;
/*      */         this.level_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearLevel() { this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.level_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasUpLevel() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public int getUpLevel() { return this.upLevel_; }
/*      */       public Builder setUpLevel(int value) { this.bitField0_ |= 0x2;
/*      */         this.upLevel_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearUpLevel() { this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.upLevel_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasReqLevel() { return ((this.bitField0_ & 0x4) == 4); }
/*      */       public int getReqLevel() { return this.reqLevel_; }
/*      */       public Builder setReqLevel(int value) { this.bitField0_ |= 0x4;
/*      */         this.reqLevel_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearReqLevel() { this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.reqLevel_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       public boolean hasDownLevel() { return ((this.bitField0_ & 0x8) == 8); }
/*      */       public int getDownLevel() { return this.downLevel_; }
/*      */       public Builder setDownLevel(int value) { this.bitField0_ |= 0x8;
/*      */         this.downLevel_ = value;
/*      */         onChanged();
/*      */         return this; }
/*      */       public Builder clearDownLevel() { this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.downLevel_ = 0;
/*      */         onChanged();
/*      */         return this; }
/*      */       private void ensureAttrsIsMutable() { if ((this.bitField0_ & 0x10) != 16) {
/*      */           this.attrs_ = new ArrayList<>(this.attrs_);
/*      */           this.bitField0_ |= 0x10;
/*      */         }  }
/*      */       public List<Common.AttributeBase> getAttrsList() { if (this.attrsBuilder_ == null)
/*      */           return Collections.unmodifiableList(this.attrs_); 
/*      */         return this.attrsBuilder_.getMessageList(); }
/*      */       public int getAttrsCount() { if (this.attrsBuilder_ == null)
/*      */           return this.attrs_.size(); 
/*      */         return this.attrsBuilder_.getCount(); }
/*      */       public Common.AttributeBase getAttrs(int index) { if (this.attrsBuilder_ == null)
/*      */           return this.attrs_.get(index); 
/*      */         return (Common.AttributeBase)this.attrsBuilder_.getMessage(index); }
/*      */       public Builder setAttrs(int index, Common.AttributeBase value) { if (this.attrsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder setAttrs(int index, Common.AttributeBase.Builder builderForValue) { if (this.attrsBuilder_ == null) {
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAttrs(Common.AttributeBase value) { if (this.attrsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAttrs(int index, Common.AttributeBase value) { if (this.attrsBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAttrs(Common.AttributeBase.Builder builderForValue) { if (this.attrsBuilder_ == null) {
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAttrs(int index, Common.AttributeBase.Builder builderForValue) { if (this.attrsBuilder_ == null) {
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this; }
/*      */       public Builder addAllAttrs(Iterable<? extends Common.AttributeBase> values) { if (this.attrsBuilder_ == null) {
/*      */           ensureAttrsIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.attrs_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this; }
/*      */       public Builder clearAttrs() { if (this.attrsBuilder_ == null) {
/*      */           this.attrs_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFFEF;
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.clear();
/*      */         } 
/*      */         return this; }
/*      */       public Builder removeAttrs(int index) { if (this.attrsBuilder_ == null) {
/*      */           ensureAttrsIsMutable();
/*      */           this.attrs_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.attrsBuilder_.remove(index);
/*      */         } 
/*      */         return this; }
/*      */       public Common.AttributeBase.Builder getAttrsBuilder(int index) { return (Common.AttributeBase.Builder)getAttrsFieldBuilder().getBuilder(index); }
/*      */       public Common.AttributeBaseOrBuilder getAttrsOrBuilder(int index) { if (this.attrsBuilder_ == null)
/*      */           return (Common.AttributeBaseOrBuilder)this.attrs_.get(index); 
/*      */         return (Common.AttributeBaseOrBuilder)this.attrsBuilder_.getMessageOrBuilder(index); }
/*      */       public List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList() { if (this.attrsBuilder_ != null)
/*      */           return this.attrsBuilder_.getMessageOrBuilderList(); 
/*      */         return (List)Collections.unmodifiableList(this.attrs_); }
/*      */       public Common.AttributeBase.Builder addAttrsBuilder() { return (Common.AttributeBase.Builder)getAttrsFieldBuilder().addBuilder((GeneratedMessage)Common.AttributeBase.getDefaultInstance()); }
/*      */       public Common.AttributeBase.Builder addAttrsBuilder(int index) { return (Common.AttributeBase.Builder)getAttrsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.AttributeBase.getDefaultInstance()); }
/*      */       public List<Common.AttributeBase.Builder> getAttrsBuilderList() { return getAttrsFieldBuilder().getBuilderList(); }
/*      */       private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getAttrsFieldBuilder() { if (this.attrsBuilder_ == null) {
/*      */           this.attrsBuilder_ = new RepeatedFieldBuilder(this.attrs_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
/*      */           this.attrs_ = null;
/*      */         } 
/*      */         return this.attrsBuilder_; } } }
/* 1600 */   public static final class UpInfoRequest extends GeneratedMessage implements UpInfoRequestOrBuilder { private static final UpInfoRequest defaultInstance = new UpInfoRequest(true); private final UnknownFieldSet unknownFields; private UpInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpInfoRequest getDefaultInstance() { return defaultInstance; } public UpInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpInfoRequest.class, Builder.class); } public static Parser<UpInfoRequest> PARSER = (Parser<UpInfoRequest>)new AbstractParser<UpInfoRequest>() { public UpLevelHandler.UpInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new UpLevelHandler.UpInfoRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpInfoRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpInfoRequest)PARSER.parseFrom(data); } public static UpInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpInfoRequest)PARSER.parseFrom(data); } public static UpInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpInfoRequest parseFrom(InputStream input) throws IOException { return (UpInfoRequest)PARSER.parseFrom(input); } public static UpInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static UpInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (UpInfoRequest)PARSER.parseDelimitedFrom(input); } public static UpInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UpInfoRequest parseFrom(CodedInputStream input) throws IOException { return (UpInfoRequest)PARSER.parseFrom(input); } public static UpInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UpInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements UpLevelHandler.UpInfoRequestOrBuilder {
/* 1601 */       public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelHandler.UpInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (UpLevelHandler.UpInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return UpLevelHandler.internal_static_pomelo_area_UpInfoRequest_descriptor; } public UpLevelHandler.UpInfoRequest getDefaultInstanceForType() { return UpLevelHandler.UpInfoRequest.getDefaultInstance(); } public UpLevelHandler.UpInfoRequest build() { UpLevelHandler.UpInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public UpLevelHandler.UpInfoRequest buildPartial() { UpLevelHandler.UpInfoRequest result = new UpLevelHandler.UpInfoRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof UpLevelHandler.UpInfoRequest) return mergeFrom((UpLevelHandler.UpInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(UpLevelHandler.UpInfoRequest other) { if (other == UpLevelHandler.UpInfoRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { UpLevelHandler.UpInfoRequest parsedMessage = null; try { parsedMessage = (UpLevelHandler.UpInfoRequest)UpLevelHandler.UpInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (UpLevelHandler.UpInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class UpInfoResponse
/*      */     extends GeneratedMessage
/*      */     implements UpInfoResponseOrBuilder
/*      */   {
/* 2363 */     private static final UpInfoResponse defaultInstance = new UpInfoResponse(true); private final UnknownFieldSet unknownFields; private UpInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpInfoResponse getDefaultInstance() { return defaultInstance; } public UpInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; UpLevelHandler.UpData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CUpData_.toBuilder();  this.s2CUpData_ = (UpLevelHandler.UpData)input.readMessage(UpLevelHandler.UpData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CUpData_); this.s2CUpData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpInfoResponse.class, Builder.class); } public static Parser<UpInfoResponse> PARSER = (Parser<UpInfoResponse>)new AbstractParser<UpInfoResponse>() { public UpLevelHandler.UpInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new UpLevelHandler.UpInfoResponse(input, extensionRegistry); } }
/* 2364 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_UPDATA_FIELD_NUMBER = 3; private UpLevelHandler.UpData s2CUpData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } static { defaultInstance.initFields(); }
/*      */      public ByteString getS2CMsgBytes() {
/*      */       Object ref = this.s2CMsg_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.s2CMsg_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     } public boolean hasS2CUpData() {
/*      */       return ((this.bitField0_ & 0x4) == 4);
/*      */     } public UpLevelHandler.UpData getS2CUpData() {
/*      */       return this.s2CUpData_;
/*      */     } public UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder() {
/*      */       return this.s2CUpData_;
/*      */     } private void initFields() {
/*      */       this.s2CCode_ = 0;
/*      */       this.s2CMsg_ = "";
/*      */       this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance();
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
/*      */       if (hasS2CUpData() && !getS2CUpData().isInitialized()) {
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
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeMessage(3, (MessageLite)this.s2CUpData_); 
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
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.s2CUpData_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     } protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     } public static UpInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(data);
/*      */     } public static UpInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static UpInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(data);
/*      */     } public static UpInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static UpInfoResponse parseFrom(InputStream input) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(input);
/*      */     } public static UpInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static UpInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseDelimitedFrom(input);
/*      */     } public static UpInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static UpInfoResponse parseFrom(CodedInputStream input) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(input);
/*      */     } public static UpInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (UpInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     } public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     } public static Builder newBuilder(UpInfoResponse prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     } public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements UpLevelHandler.UpInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private UpLevelHandler.UpData s2CUpData_; private SingleFieldBuilder<UpLevelHandler.UpData, UpLevelHandler.UpData.Builder, UpLevelHandler.UpDataOrBuilder> s2CUpDataBuilder_; public static final Descriptors.Descriptor getDescriptor() {
/*      */         return UpLevelHandler.internal_static_pomelo_area_UpInfoResponse_descriptor;
/*      */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return UpLevelHandler.internal_static_pomelo_area_UpInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelHandler.UpInfoResponse.class, Builder.class);
/*      */       } private Builder() {
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.s2CMsg_ = "";
/*      */         this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       } private void maybeForceBuilderInitialization() {
/*      */         if (UpLevelHandler.UpInfoResponse.alwaysUseFieldBuilders)
/*      */           getS2CUpDataFieldBuilder(); 
/*      */       } private static Builder create() {
/*      */         return new Builder();
/*      */       } public Builder clear() {
/*      */         super.clear();
/*      */         this.s2CCode_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.s2CMsg_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance();
/*      */         } else {
/*      */           this.s2CUpDataBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       } public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       } public Descriptors.Descriptor getDescriptorForType() {
/*      */         return UpLevelHandler.internal_static_pomelo_area_UpInfoResponse_descriptor;
/*      */       } public UpLevelHandler.UpInfoResponse getDefaultInstanceForType() {
/*      */         return UpLevelHandler.UpInfoResponse.getDefaultInstance();
/*      */       } public UpLevelHandler.UpInfoResponse build() {
/*      */         UpLevelHandler.UpInfoResponse result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       } public UpLevelHandler.UpInfoResponse buildPartial() {
/*      */         UpLevelHandler.UpInfoResponse result = new UpLevelHandler.UpInfoResponse(this);
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
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           result.s2CUpData_ = this.s2CUpData_;
/*      */         } else {
/*      */           result.s2CUpData_ = (UpLevelHandler.UpData)this.s2CUpDataBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       } public Builder mergeFrom(Message other) {
/*      */         if (other instanceof UpLevelHandler.UpInfoResponse)
/*      */           return mergeFrom((UpLevelHandler.UpInfoResponse)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       } public Builder mergeFrom(UpLevelHandler.UpInfoResponse other) {
/*      */         if (other == UpLevelHandler.UpInfoResponse.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasS2CCode())
/*      */           setS2CCode(other.getS2CCode()); 
/*      */         if (other.hasS2CMsg()) {
/*      */           this.bitField0_ |= 0x2;
/*      */           this.s2CMsg_ = other.s2CMsg_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasS2CUpData())
/*      */           mergeS2CUpData(other.getS2CUpData()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       } public final boolean isInitialized() {
/*      */         if (!hasS2CCode())
/*      */           return false; 
/*      */         if (hasS2CUpData() && !getS2CUpData().isInitialized())
/*      */           return false; 
/*      */         return true;
/*      */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         UpLevelHandler.UpInfoResponse parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (UpLevelHandler.UpInfoResponse)UpLevelHandler.UpInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (UpLevelHandler.UpInfoResponse)e.getUnfinishedMessage();
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
/*      */         this.s2CMsg_ = UpLevelHandler.UpInfoResponse.getDefaultInstance().getS2CMsg();
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
/*      */       public boolean hasS2CUpData() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */       public UpLevelHandler.UpData getS2CUpData() {
/*      */         if (this.s2CUpDataBuilder_ == null)
/*      */           return this.s2CUpData_; 
/*      */         return (UpLevelHandler.UpData)this.s2CUpDataBuilder_.getMessage();
/*      */       }
/*      */       public Builder setS2CUpData(UpLevelHandler.UpData value) {
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           if (value == null)
/*      */             throw new NullPointerException(); 
/*      */           this.s2CUpData_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CUpDataBuilder_.setMessage(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder setS2CUpData(UpLevelHandler.UpData.Builder builderForValue) {
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           this.s2CUpData_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CUpDataBuilder_.setMessage(builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder mergeS2CUpData(UpLevelHandler.UpData value) {
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x4) == 4 && this.s2CUpData_ != UpLevelHandler.UpData.getDefaultInstance()) {
/*      */             this.s2CUpData_ = UpLevelHandler.UpData.newBuilder(this.s2CUpData_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.s2CUpData_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CUpDataBuilder_.mergeFrom(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x4;
/*      */         return this;
/*      */       }
/*      */       public Builder clearS2CUpData() {
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.s2CUpDataBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         return this;
/*      */       }
/*      */       public UpLevelHandler.UpData.Builder getS2CUpDataBuilder() {
/*      */         this.bitField0_ |= 0x4;
/*      */         onChanged();
/*      */         return (UpLevelHandler.UpData.Builder)getS2CUpDataFieldBuilder().getBuilder();
/*      */       }
/*      */       public UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder() {
/*      */         if (this.s2CUpDataBuilder_ != null)
/*      */           return (UpLevelHandler.UpDataOrBuilder)this.s2CUpDataBuilder_.getMessageOrBuilder(); 
/*      */         return this.s2CUpData_;
/*      */       }
/*      */       private SingleFieldBuilder<UpLevelHandler.UpData, UpLevelHandler.UpData.Builder, UpLevelHandler.UpDataOrBuilder> getS2CUpDataFieldBuilder() {
/*      */         if (this.s2CUpDataBuilder_ == null) {
/*      */           this.s2CUpDataBuilder_ = new SingleFieldBuilder(getS2CUpData(), getParentForChildren(), isClean());
/*      */           this.s2CUpData_ = null;
/*      */         } 
/*      */         return this.s2CUpDataBuilder_;
/*      */       } } }
/* 2684 */   public static final class UpLevelRequest extends GeneratedMessage implements UpLevelRequestOrBuilder { private static final UpLevelRequest defaultInstance = new UpLevelRequest(true); private final UnknownFieldSet unknownFields; private UpLevelRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpLevelRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpLevelRequest getDefaultInstance() { return defaultInstance; } public UpLevelRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpLevelRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpLevelRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelRequest.class, Builder.class); } public static Parser<UpLevelRequest> PARSER = (Parser<UpLevelRequest>)new AbstractParser<UpLevelRequest>() { public UpLevelHandler.UpLevelRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new UpLevelHandler.UpLevelRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpLevelRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpLevelRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpLevelRequest)PARSER.parseFrom(data); } public static UpLevelRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpLevelRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpLevelRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpLevelRequest)PARSER.parseFrom(data); } public static UpLevelRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpLevelRequest)PARSER.parseFrom(data, extensionRegistry); } public static UpLevelRequest parseFrom(InputStream input) throws IOException { return (UpLevelRequest)PARSER.parseFrom(input); } public static UpLevelRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelRequest)PARSER.parseFrom(input, extensionRegistry); } public static UpLevelRequest parseDelimitedFrom(InputStream input) throws IOException { return (UpLevelRequest)PARSER.parseDelimitedFrom(input); } public static UpLevelRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static UpLevelRequest parseFrom(CodedInputStream input) throws IOException { return (UpLevelRequest)PARSER.parseFrom(input); } public static UpLevelRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(UpLevelRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements UpLevelHandler.UpLevelRequestOrBuilder {
/* 2685 */       public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpLevelRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelHandler.UpLevelRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (UpLevelHandler.UpLevelRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return UpLevelHandler.internal_static_pomelo_area_UpLevelRequest_descriptor; } public UpLevelHandler.UpLevelRequest getDefaultInstanceForType() { return UpLevelHandler.UpLevelRequest.getDefaultInstance(); } public UpLevelHandler.UpLevelRequest build() { UpLevelHandler.UpLevelRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public UpLevelHandler.UpLevelRequest buildPartial() { UpLevelHandler.UpLevelRequest result = new UpLevelHandler.UpLevelRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof UpLevelHandler.UpLevelRequest) return mergeFrom((UpLevelHandler.UpLevelRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(UpLevelHandler.UpLevelRequest other) { if (other == UpLevelHandler.UpLevelRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { UpLevelHandler.UpLevelRequest parsedMessage = null; try { parsedMessage = (UpLevelHandler.UpLevelRequest)UpLevelHandler.UpLevelRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (UpLevelHandler.UpLevelRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class UpLevelResponse
/*      */     extends GeneratedMessage
/*      */     implements UpLevelResponseOrBuilder
/*      */   {
/* 3557 */     private static final UpLevelResponse defaultInstance = new UpLevelResponse(true); private final UnknownFieldSet unknownFields; private UpLevelResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private UpLevelResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static UpLevelResponse getDefaultInstance() { return defaultInstance; } public UpLevelResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private UpLevelResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; UpLevelHandler.UpData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 24: this.bitField0_ |= 0x4; this.s2CHasNext_ = input.readInt32(); break;case 34: subBuilder = null; if ((this.bitField0_ & 0x8) == 8) subBuilder = this.s2CUpData_.toBuilder();  this.s2CUpData_ = (UpLevelHandler.UpData)input.readMessage(UpLevelHandler.UpData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.s2CUpData_); this.s2CUpData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x8; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpLevelResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelResponse.class, Builder.class); } public static Parser<UpLevelResponse> PARSER = (Parser<UpLevelResponse>)new AbstractParser<UpLevelResponse>() { public UpLevelHandler.UpLevelResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new UpLevelHandler.UpLevelResponse(input, extensionRegistry); } }
/* 3558 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int S2C_HASNEXT_FIELD_NUMBER = 3; private int s2CHasNext_; public static final int S2C_UPDATA_FIELD_NUMBER = 4; private UpLevelHandler.UpData s2CUpData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<UpLevelResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasS2CHasNext() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CHasNext() { return this.s2CHasNext_; } public boolean hasS2CUpData() { return ((this.bitField0_ & 0x8) == 8); } public UpLevelHandler.UpData getS2CUpData() { return this.s2CUpData_; } public UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder() { return this.s2CUpData_; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; this.s2CHasNext_ = 0; this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  if (hasS2CUpData() && !getS2CUpData().isInitialized()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CHasNext_);  if ((this.bitField0_ & 0x8) == 8) output.writeMessage(4, (MessageLite)this.s2CUpData_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CHasNext_);  if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.s2CUpData_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static UpLevelResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (UpLevelResponse)PARSER.parseFrom(data); } public static UpLevelResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpLevelResponse)PARSER.parseFrom(data, extensionRegistry); } public static UpLevelResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (UpLevelResponse)PARSER.parseFrom(data); } static { defaultInstance.initFields(); }
/*      */     public static UpLevelResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (UpLevelResponse)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static UpLevelResponse parseFrom(InputStream input) throws IOException { return (UpLevelResponse)PARSER.parseFrom(input); }
/*      */     public static UpLevelResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static UpLevelResponse parseDelimitedFrom(InputStream input) throws IOException { return (UpLevelResponse)PARSER.parseDelimitedFrom(input); }
/*      */     public static UpLevelResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static UpLevelResponse parseFrom(CodedInputStream input) throws IOException { return (UpLevelResponse)PARSER.parseFrom(input); }
/*      */     public static UpLevelResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (UpLevelResponse)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(UpLevelResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements UpLevelHandler.UpLevelResponseOrBuilder {
/*      */       private int bitField0_;
/*      */       private int s2CCode_;
/*      */       private Object s2CMsg_;
/*      */       private int s2CHasNext_;
/*      */       private UpLevelHandler.UpData s2CUpData_;
/*      */       private SingleFieldBuilder<UpLevelHandler.UpData, UpLevelHandler.UpData.Builder, UpLevelHandler.UpDataOrBuilder> s2CUpDataBuilder_;
/*      */       public static final Descriptors.Descriptor getDescriptor() { return UpLevelHandler.internal_static_pomelo_area_UpLevelResponse_descriptor; }
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return UpLevelHandler.internal_static_pomelo_area_UpLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpLevelHandler.UpLevelResponse.class, Builder.class); }
/*      */       private Builder() { this.s2CMsg_ = ""; this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*      */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance(); maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (UpLevelHandler.UpLevelResponse.alwaysUseFieldBuilders) getS2CUpDataFieldBuilder();  }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.s2CHasNext_ = 0; this.bitField0_ &= 0xFFFFFFFB; if (this.s2CUpDataBuilder_ == null) { this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance(); } else { this.s2CUpDataBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFF7; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return UpLevelHandler.internal_static_pomelo_area_UpLevelResponse_descriptor; }
/*      */       public UpLevelHandler.UpLevelResponse getDefaultInstanceForType() { return UpLevelHandler.UpLevelResponse.getDefaultInstance(); }
/*      */       public UpLevelHandler.UpLevelResponse build() { UpLevelHandler.UpLevelResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public UpLevelHandler.UpLevelResponse buildPartial() { UpLevelHandler.UpLevelResponse result = new UpLevelHandler.UpLevelResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.s2CHasNext_ = this.s2CHasNext_; if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;  if (this.s2CUpDataBuilder_ == null) { result.s2CUpData_ = this.s2CUpData_; } else { result.s2CUpData_ = (UpLevelHandler.UpData)this.s2CUpDataBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof UpLevelHandler.UpLevelResponse) return mergeFrom((UpLevelHandler.UpLevelResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(UpLevelHandler.UpLevelResponse other) { if (other == UpLevelHandler.UpLevelResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  if (other.hasS2CHasNext()) setS2CHasNext(other.getS2CHasNext());  if (other.hasS2CUpData()) mergeS2CUpData(other.getS2CUpData());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  if (hasS2CUpData() && !getS2CUpData().isInitialized()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { UpLevelHandler.UpLevelResponse parsedMessage = null; try { parsedMessage = (UpLevelHandler.UpLevelResponse)UpLevelHandler.UpLevelResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (UpLevelHandler.UpLevelResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = UpLevelHandler.UpLevelResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public boolean hasS2CHasNext() { return ((this.bitField0_ & 0x4) == 4); } public int getS2CHasNext() { return this.s2CHasNext_; } public Builder setS2CHasNext(int value) { this.bitField0_ |= 0x4; this.s2CHasNext_ = value; onChanged(); return this; } public Builder clearS2CHasNext() { this.bitField0_ &= 0xFFFFFFFB; this.s2CHasNext_ = 0; onChanged(); return this; } public boolean hasS2CUpData() { return ((this.bitField0_ & 0x8) == 8); } public UpLevelHandler.UpData getS2CUpData() { if (this.s2CUpDataBuilder_ == null) return this.s2CUpData_;  return (UpLevelHandler.UpData)this.s2CUpDataBuilder_.getMessage(); } public Builder setS2CUpData(UpLevelHandler.UpData value) { if (this.s2CUpDataBuilder_ == null) { if (value == null) throw new NullPointerException();  this.s2CUpData_ = value; onChanged(); } else { this.s2CUpDataBuilder_.setMessage(value); }  this.bitField0_ |= 0x8; return this; } public Builder setS2CUpData(UpLevelHandler.UpData.Builder builderForValue) { if (this.s2CUpDataBuilder_ == null) { this.s2CUpData_ = builderForValue.build(); onChanged(); } else { this.s2CUpDataBuilder_.setMessage(builderForValue.build()); }  this.bitField0_ |= 0x8; return this; } public Builder mergeS2CUpData(UpLevelHandler.UpData value) { if (this.s2CUpDataBuilder_ == null) { if ((this.bitField0_ & 0x8) == 8 && this.s2CUpData_ != UpLevelHandler.UpData.getDefaultInstance()) { this.s2CUpData_ = UpLevelHandler.UpData.newBuilder(this.s2CUpData_).mergeFrom(value).buildPartial(); } else { this.s2CUpData_ = value; }  onChanged(); } else { this.s2CUpDataBuilder_.mergeFrom(value); }  this.bitField0_ |= 0x8; return this; } public Builder clearS2CUpData() { if (this.s2CUpDataBuilder_ == null) { this.s2CUpData_ = UpLevelHandler.UpData.getDefaultInstance(); onChanged(); } else { this.s2CUpDataBuilder_.clear(); }  this.bitField0_ &= 0xFFFFFFF7; return this; } public UpLevelHandler.UpData.Builder getS2CUpDataBuilder() { this.bitField0_ |= 0x8; onChanged(); return (UpLevelHandler.UpData.Builder)getS2CUpDataFieldBuilder().getBuilder(); } public UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder() { if (this.s2CUpDataBuilder_ != null) return (UpLevelHandler.UpDataOrBuilder)this.s2CUpDataBuilder_.getMessageOrBuilder();  return this.s2CUpData_; } private SingleFieldBuilder<UpLevelHandler.UpData, UpLevelHandler.UpData.Builder, UpLevelHandler.UpDataOrBuilder> getS2CUpDataFieldBuilder() { if (this.s2CUpDataBuilder_ == null) { this.s2CUpDataBuilder_ = new SingleFieldBuilder(getS2CUpData(), getParentForChildren(), isClean()); this.s2CUpData_ = null; }  return this.s2CUpDataBuilder_; } }
/* 3592 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 3597 */     String[] descriptorData = { "\n\024upLevelHandler.proto\022\013pomelo.area\032\fcommon.proto\"s\n\006UpData\022\r\n\005level\030\001 \002(\005\022\017\n\007upLevel\030\002 \002(\005\022\020\n\breqLevel\030\003 \002(\005\022\021\n\tdownLevel\030\004 \002(\005\022$\n\005attrs\030\005 \003(\0132\025.pomelo.AttributeBase\"\017\n\rUpInfoRequest\"\\\n\016UpInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022'\n\ns2c_upData\030\003 \001(\0132\023.pomelo.area.UpData\"\020\n\016UpLevelRequest\"r\n\017UpLevelResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013s2c_hasNext\030\003 \001(\005\022'\n\ns2c_upData\030\004 \001(\0132\023.pomelo.", "area.UpData2§\001\n\016upLevelHandler\022H\n\rupInfoRequest\022\032.pomelo.area.UpInfoRequest\032\033.pomelo.area.UpInfoResponse\022K\n\016upLevelRequest\022\033.pomelo.area.UpLevelRequest\032\034.pomelo.area.UpLevelResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3614 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 3618 */           UpLevelHandler.descriptor = root;
/* 3619 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 3623 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 3625 */           Common.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 3628 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpData_descriptor = getDescriptor().getMessageTypes().get(0);
/* 3629 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpData_descriptor, new String[] { "Level", "UpLevel", "ReqLevel", "DownLevel", "Attrs" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3634 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 3635 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpInfoRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3640 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 3641 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CUpData" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3646 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpLevelRequest_descriptor = getDescriptor().getMessageTypes().get(3);
/* 3647 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpLevelRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpLevelRequest_descriptor, new String[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 3652 */   private static final Descriptors.Descriptor internal_static_pomelo_area_UpLevelResponse_descriptor = getDescriptor().getMessageTypes().get(4);
/* 3653 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpLevelResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpLevelResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "S2CHasNext", "S2CUpData" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 3657 */     Common.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface UpLevelResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CHasNext();
/*      */     
/*      */     int getS2CHasNext();
/*      */     
/*      */     boolean hasS2CUpData();
/*      */     
/*      */     UpLevelHandler.UpData getS2CUpData();
/*      */     
/*      */     UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder();
/*      */   }
/*      */   
/*      */   public static interface UpLevelRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface UpInfoResponseOrBuilder extends MessageOrBuilder {
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
/*      */     boolean hasS2CUpData();
/*      */     
/*      */     UpLevelHandler.UpData getS2CUpData();
/*      */     
/*      */     UpLevelHandler.UpDataOrBuilder getS2CUpDataOrBuilder();
/*      */   }
/*      */   
/*      */   public static interface UpInfoRequestOrBuilder extends MessageOrBuilder {}
/*      */   
/*      */   public static interface UpDataOrBuilder extends MessageOrBuilder {
/*      */     boolean hasLevel();
/*      */     
/*      */     int getLevel();
/*      */     
/*      */     boolean hasUpLevel();
/*      */     
/*      */     int getUpLevel();
/*      */     
/*      */     boolean hasReqLevel();
/*      */     
/*      */     int getReqLevel();
/*      */     
/*      */     boolean hasDownLevel();
/*      */     
/*      */     int getDownLevel();
/*      */     
/*      */     List<Common.AttributeBase> getAttrsList();
/*      */     
/*      */     Common.AttributeBase getAttrs(int param1Int);
/*      */     
/*      */     int getAttrsCount();
/*      */     
/*      */     List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList();
/*      */     
/*      */     Common.AttributeBaseOrBuilder getAttrsOrBuilder(int param1Int);
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\UpLevelHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */