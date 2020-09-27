/*       */ package pomelo.revelry;
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
/*       */ import com.google.protobuf.LazyStringArrayList;
/*       */ import com.google.protobuf.LazyStringList;
/*       */ import com.google.protobuf.Message;
/*       */ import com.google.protobuf.MessageLite;
/*       */ import com.google.protobuf.MessageOrBuilder;
/*       */ import com.google.protobuf.Parser;
/*       */ import com.google.protobuf.ProtocolStringList;
/*       */ import com.google.protobuf.RepeatedFieldBuilder;
/*       */ import com.google.protobuf.SingleFieldBuilder;
/*       */ import com.google.protobuf.UnknownFieldSet;
/*       */ import java.io.IOException;
/*       */ import java.io.InputStream;
/*       */ import java.io.ObjectStreamException;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Collection;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ public final class ActivityRevelryHandler
/*       */ {
/*       */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*       */   
/*       */   public static final class RevelryColumnInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryColumnInfoOrBuilder
/*       */   {
/*  1489 */     private static final RevelryColumnInfo defaultInstance = new RevelryColumnInfo(true); private final UnknownFieldSet unknownFields; private RevelryColumnInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryColumnInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryColumnInfo getDefaultInstance() { return defaultInstance; } public RevelryColumnInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryColumnInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.id_ = bs; break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.label_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.goto1_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.goto2_ = bs; break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.tip_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryColumnInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryColumnInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryColumnInfo.class, Builder.class); } public static Parser<RevelryColumnInfo> PARSER = (Parser<RevelryColumnInfo>)new AbstractParser<RevelryColumnInfo>() { public ActivityRevelryHandler.RevelryColumnInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryColumnInfo(input, extensionRegistry); } }
/*  1490 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private Object id_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; public static final int LABEL_FIELD_NUMBER = 3; private Object label_; public static final int GOTO1_FIELD_NUMBER = 4; private Object goto1_; public static final int GOTO2_FIELD_NUMBER = 5; private Object goto2_; public static final int TIP_FIELD_NUMBER = 6; private Object tip_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryColumnInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public String getId() { Object ref = this.id_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.id_ = s;  return s; } public ByteString getIdBytes() { Object ref = this.id_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.id_ = b; return b; }  return (ByteString)ref; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasLabel() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */     
/*       */     public String getLabel() {
/*       */       Object ref = this.label_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.label_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */     
/*       */     public ByteString getLabelBytes() {
/*       */       Object ref = this.label_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.label_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasGoto1() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     }
/*       */ 
/*       */     
/*       */     public String getGoto1() {
/*       */       Object ref = this.goto1_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.goto1_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */     
/*       */     public ByteString getGoto1Bytes() {
/*       */       Object ref = this.goto1_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.goto1_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasGoto2() {
/*       */       return ((this.bitField0_ & 0x10) == 16);
/*       */     }
/*       */ 
/*       */     
/*       */     public String getGoto2() {
/*       */       Object ref = this.goto2_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.goto2_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */     
/*       */     public ByteString getGoto2Bytes() {
/*       */       Object ref = this.goto2_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.goto2_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */     
/*       */     public boolean hasTip() {
/*       */       return ((this.bitField0_ & 0x20) == 32);
/*       */     }
/*       */ 
/*       */     
/*       */     public String getTip() {
/*       */       Object ref = this.tip_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.tip_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */     
/*       */     public ByteString getTipBytes() {
/*       */       Object ref = this.tip_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.tip_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = "";
/*       */       this.name_ = "";
/*       */       this.label_ = "";
/*       */       this.goto1_ = "";
/*       */       this.goto2_ = "";
/*       */       this.tip_ = "";
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
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasLabel()) {
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
/*       */         output.writeBytes(1, getIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeBytes(3, getLabelBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         output.writeBytes(4, getGoto1Bytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         output.writeBytes(5, getGoto2Bytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         output.writeBytes(6, getTipBytes());
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getIdBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeBytesSize(3, getLabelBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x8) == 8) {
/*       */         size += CodedOutputStream.computeBytesSize(4, getGoto1Bytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x10) == 16) {
/*       */         size += CodedOutputStream.computeBytesSize(5, getGoto2Bytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x20) == 32) {
/*       */         size += CodedOutputStream.computeBytesSize(6, getTipBytes());
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
/*       */     public static RevelryColumnInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */     
/*       */     public static RevelryColumnInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryColumnInfo)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RevelryColumnInfo prototype) {
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
/*       */       implements ActivityRevelryHandler.RevelryColumnInfoOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */       
/*       */       private Object id_;
/*       */       
/*       */       private Object name_;
/*       */       
/*       */       private Object label_;
/*       */       
/*       */       private Object goto1_;
/*       */       
/*       */       private Object goto2_;
/*       */       
/*       */       private Object tip_;
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryColumnInfo_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryColumnInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryColumnInfo.class, Builder.class);
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.id_ = "";
/*       */         this.name_ = "";
/*       */         this.label_ = "";
/*       */         this.goto1_ = "";
/*       */         this.goto2_ = "";
/*       */         this.tip_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.id_ = "";
/*       */         this.name_ = "";
/*       */         this.label_ = "";
/*       */         this.goto1_ = "";
/*       */         this.goto2_ = "";
/*       */         this.tip_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryColumnInfo.alwaysUseFieldBuilders);
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
/*       */         this.id_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.label_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.goto1_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.goto2_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.tip_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFDF;
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryColumnInfo_descriptor;
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance();
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo build() {
/*       */         ActivityRevelryHandler.RevelryColumnInfo result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryColumnInfo result = new ActivityRevelryHandler.RevelryColumnInfo(this);
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
/*       */         result.label_ = this.label_;
/*       */         if ((from_bitField0_ & 0x8) == 8) {
/*       */           to_bitField0_ |= 0x8;
/*       */         }
/*       */         result.goto1_ = this.goto1_;
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x10;
/*       */         }
/*       */         result.goto2_ = this.goto2_;
/*       */         if ((from_bitField0_ & 0x20) == 32) {
/*       */           to_bitField0_ |= 0x20;
/*       */         }
/*       */         result.tip_ = this.tip_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryColumnInfo) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryColumnInfo)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryColumnInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.id_ = other.id_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasLabel()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.label_ = other.label_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasGoto1()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.goto1_ = other.goto1_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasGoto2()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.goto2_ = other.goto2_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasTip()) {
/*       */           this.bitField0_ |= 0x20;
/*       */           this.tip_ = other.tip_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasLabel()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryColumnInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryColumnInfo)ActivityRevelryHandler.RevelryColumnInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryColumnInfo)e.getUnfinishedMessage();
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */       
/*       */       public String getId() {
/*       */         Object ref = this.id_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.id_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public ByteString getIdBytes() {
/*       */         Object ref = this.id_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.id_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getId();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
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
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
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
/*       */       public boolean hasLabel() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       }
/*       */ 
/*       */       
/*       */       public String getLabel() {
/*       */         Object ref = this.label_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.label_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public ByteString getLabelBytes() {
/*       */         Object ref = this.label_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.label_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setLabel(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.label_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearLabel() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.label_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getLabel();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setLabelBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x4;
/*       */         this.label_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasGoto1() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */ 
/*       */       
/*       */       public String getGoto1() {
/*       */         Object ref = this.goto1_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.goto1_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public ByteString getGoto1Bytes() {
/*       */         Object ref = this.goto1_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.goto1_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setGoto1(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.goto1_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearGoto1() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.goto1_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getGoto1();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setGoto1Bytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x8;
/*       */         this.goto1_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasGoto2() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       
/*       */       public String getGoto2() {
/*       */         Object ref = this.goto2_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.goto2_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getGoto2Bytes() {
/*       */         Object ref = this.goto2_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.goto2_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setGoto2(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.goto2_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearGoto2() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.goto2_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getGoto2();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setGoto2Bytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x10;
/*       */         this.goto2_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasTip() {
/*       */         return ((this.bitField0_ & 0x20) == 32);
/*       */       }
/*       */       
/*       */       public String getTip() {
/*       */         Object ref = this.tip_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.tip_ = s;
/*       */           }
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       
/*       */       public ByteString getTipBytes() {
/*       */         Object ref = this.tip_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.tip_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       
/*       */       public Builder setTip(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.tip_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearTip() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.tip_ = ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance().getTip();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setTipBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x20;
/*       */         this.tip_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public static final class RevelryTodayInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryTodayInfoOrBuilder
/*       */   {
/*  2353 */     private static final RevelryTodayInfo defaultInstance = new RevelryTodayInfo(true); private final UnknownFieldSet unknownFields; private RevelryTodayInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryTodayInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryTodayInfo getDefaultInstance() { return defaultInstance; } public RevelryTodayInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryTodayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.name_ = bs; break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.column_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.column_.add(input.readMessage(ActivityRevelryHandler.RevelryColumnInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.column_ = Collections.unmodifiableList(this.column_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTodayInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTodayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryTodayInfo.class, Builder.class); } public static Parser<RevelryTodayInfo> PARSER = (Parser<RevelryTodayInfo>)new AbstractParser<RevelryTodayInfo>() { public ActivityRevelryHandler.RevelryTodayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryTodayInfo(input, extensionRegistry); } }
/*  2354 */     ; private int bitField0_; public static final int NAME_FIELD_NUMBER = 1; private Object name_; public static final int COLUMN_FIELD_NUMBER = 2; private List<ActivityRevelryHandler.RevelryColumnInfo> column_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryTodayInfo> getParserForType() { return PARSER; } public boolean hasName() { return ((this.bitField0_ & 0x1) == 1); } public String getName() { Object ref = this.name_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.name_ = s;  return s; } public ByteString getNameBytes() { Object ref = this.name_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.name_ = b; return b; }  return (ByteString)ref; } public List<ActivityRevelryHandler.RevelryColumnInfo> getColumnList() { return this.column_; } public List<? extends ActivityRevelryHandler.RevelryColumnInfoOrBuilder> getColumnOrBuilderList() { return (List)this.column_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getColumnCount() {
/*       */       return this.column_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.RevelryColumnInfo getColumn(int index) {
/*       */       return this.column_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.RevelryColumnInfoOrBuilder getColumnOrBuilder(int index) {
/*       */       return this.column_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.name_ = "";
/*       */       this.column_ = Collections.emptyList();
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
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getColumnCount(); i++) {
/*       */         if (!getColumn(i).isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getNameBytes());
/*       */       }
/*       */       for (int i = 0; i < this.column_.size(); i++) {
/*       */         output.writeMessage(2, (MessageLite)this.column_.get(i));
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getNameBytes());
/*       */       }
/*       */       for (int i = 0; i < this.column_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.column_.get(i));
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
/*       */     public static RevelryTodayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTodayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTodayInfo)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RevelryTodayInfo prototype) {
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
/*       */       implements ActivityRevelryHandler.RevelryTodayInfoOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private Object name_;
/*       */ 
/*       */       
/*       */       private List<ActivityRevelryHandler.RevelryColumnInfo> column_;
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryColumnInfo, ActivityRevelryHandler.RevelryColumnInfo.Builder, ActivityRevelryHandler.RevelryColumnInfoOrBuilder> columnBuilder_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTodayInfo_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTodayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryTodayInfo.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         this.column_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.name_ = "";
/*       */         this.column_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryTodayInfo.alwaysUseFieldBuilders) {
/*       */           getColumnFieldBuilder();
/*       */         }
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.column_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.columnBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTodayInfo_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryTodayInfo.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo build() {
/*       */         ActivityRevelryHandler.RevelryTodayInfo result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryTodayInfo result = new ActivityRevelryHandler.RevelryTodayInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if (this.columnBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.column_ = Collections.unmodifiableList(this.column_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.column_ = this.column_;
/*       */         } else {
/*       */           result.column_ = this.columnBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryTodayInfo) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryTodayInfo)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryTodayInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryTodayInfo.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.columnBuilder_ == null) {
/*       */           if (!other.column_.isEmpty()) {
/*       */             if (this.column_.isEmpty()) {
/*       */               this.column_ = other.column_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureColumnIsMutable();
/*       */               this.column_.addAll(other.column_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.column_.isEmpty()) {
/*       */           if (this.columnBuilder_.isEmpty()) {
/*       */             this.columnBuilder_.dispose();
/*       */             this.columnBuilder_ = null;
/*       */             this.column_ = other.column_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.columnBuilder_ = ActivityRevelryHandler.RevelryTodayInfo.alwaysUseFieldBuilders ? getColumnFieldBuilder() : null;
/*       */           } else {
/*       */             this.columnBuilder_.addAllMessages(other.column_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getColumnCount(); i++) {
/*       */           if (!getColumn(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryTodayInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryTodayInfo)ActivityRevelryHandler.RevelryTodayInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryTodayInfo)e.getUnfinishedMessage();
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
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
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
/*       */       public Builder setName(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = ActivityRevelryHandler.RevelryTodayInfo.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureColumnIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.column_ = new ArrayList<>(this.column_);
/*       */           this.bitField0_ |= 0x2;
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryColumnInfo> getColumnList() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.column_);
/*       */         }
/*       */         return this.columnBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getColumnCount() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           return this.column_.size();
/*       */         }
/*       */         return this.columnBuilder_.getCount();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo getColumn(int index) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           return this.column_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryColumnInfo)this.columnBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setColumn(int index, ActivityRevelryHandler.RevelryColumnInfo value) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureColumnIsMutable();
/*       */           this.column_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setColumn(int index, ActivityRevelryHandler.RevelryColumnInfo.Builder builderForValue) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addColumn(ActivityRevelryHandler.RevelryColumnInfo value) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addColumn(int index, ActivityRevelryHandler.RevelryColumnInfo value) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addColumn(ActivityRevelryHandler.RevelryColumnInfo.Builder builderForValue) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addColumn(int index, ActivityRevelryHandler.RevelryColumnInfo.Builder builderForValue) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllColumn(Iterable<? extends ActivityRevelryHandler.RevelryColumnInfo> values) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.column_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearColumn() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.column_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeColumn(int index) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo.Builder getColumnBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryColumnInfo.Builder)getColumnFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfoOrBuilder getColumnOrBuilder(int index) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           return this.column_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryColumnInfoOrBuilder)this.columnBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends ActivityRevelryHandler.RevelryColumnInfoOrBuilder> getColumnOrBuilderList() {
/*       */         if (this.columnBuilder_ != null) {
/*       */           return this.columnBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.column_);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo.Builder addColumnBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryColumnInfo.Builder)getColumnFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryColumnInfo.Builder addColumnBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryColumnInfo.Builder)getColumnFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryColumnInfo.getDefaultInstance());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryColumnInfo.Builder> getColumnBuilderList() {
/*       */         return getColumnFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryColumnInfo, ActivityRevelryHandler.RevelryColumnInfo.Builder, ActivityRevelryHandler.RevelryColumnInfoOrBuilder> getColumnFieldBuilder() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.columnBuilder_ = new RepeatedFieldBuilder(this.column_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.column_ = null;
/*       */         } 
/*       */         return this.columnBuilder_;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryTabInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryTabInfoOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryTabInfo(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryTabInfo(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public RevelryTabInfo getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryTabInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */             case 10:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x1;
/*       */               this.name_ = bs;
/*       */               break;
/*       */             case 18:
/*       */               if ((mutable_bitField0_ & 0x2) != 2) {
/*       */                 this.today_ = new ArrayList<>();
/*       */                 mutable_bitField0_ |= 0x2;
/*       */               } 
/*       */               this.today_.add(input.readMessage(ActivityRevelryHandler.RevelryTodayInfo.PARSER, extensionRegistry));
/*       */               break;
/*       */           } 
/*       */         } 
/*       */       } catch (InvalidProtocolBufferException e) {
/*       */         throw e.setUnfinishedMessage(this);
/*       */       } catch (IOException e) {
/*       */         throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
/*       */       } finally {
/*       */         if ((mutable_bitField0_ & 0x2) == 2) {
/*       */           this.today_ = Collections.unmodifiableList(this.today_);
/*       */         }
/*       */         this.unknownFields = unknownFields.build();
/*       */         makeExtensionsImmutable();
/*       */       } 
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTabInfo_descriptor;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTabInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryTabInfo.class, Builder.class);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<RevelryTabInfo> PARSER = (Parser<RevelryTabInfo>)new AbstractParser<RevelryTabInfo>()
/*       */       {
/*       */         public ActivityRevelryHandler.RevelryTabInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ActivityRevelryHandler.RevelryTabInfo(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */ 
/*       */     
/*       */     public static final int NAME_FIELD_NUMBER = 1;
/*       */ 
/*       */     
/*       */     private Object name_;
/*       */ 
/*       */     
/*       */     public static final int TODAY_FIELD_NUMBER = 2;
/*       */ 
/*       */     
/*       */     private List<ActivityRevelryHandler.RevelryTodayInfo> today_;
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */ 
/*       */     
/*       */     public Parser<RevelryTabInfo> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasName() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public String getName() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         return (String)ref;
/*       */       }
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8()) {
/*       */         this.name_ = s;
/*       */       }
/*       */       return s;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ByteString getNameBytes() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.name_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public List<ActivityRevelryHandler.RevelryTodayInfo> getTodayList() {
/*       */       return this.today_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends ActivityRevelryHandler.RevelryTodayInfoOrBuilder> getTodayOrBuilderList() {
/*       */       return (List)this.today_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*  3217 */     private static final RevelryTabInfo defaultInstance = new RevelryTabInfo(true); public int getTodayCount() { return this.today_.size(); } public ActivityRevelryHandler.RevelryTodayInfo getToday(int index) { return this.today_.get(index); } public ActivityRevelryHandler.RevelryTodayInfoOrBuilder getTodayOrBuilder(int index) { return this.today_.get(index); } private void initFields() { this.name_ = ""; this.today_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasName()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getTodayCount(); i++) { if (!getToday(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getNameBytes());  for (int i = 0; i < this.today_.size(); i++) output.writeMessage(2, (MessageLite)this.today_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getNameBytes());  for (int i = 0; i < this.today_.size(); i++) size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.today_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryTabInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryTabInfo)PARSER.parseFrom(data); } public static RevelryTabInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryTabInfo)PARSER.parseFrom(data, extensionRegistry); } public static RevelryTabInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryTabInfo)PARSER.parseFrom(data); } public static RevelryTabInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryTabInfo)PARSER.parseFrom(data, extensionRegistry); }
/*  3218 */     static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseDelimitedFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryTabInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryTabInfo)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(RevelryTabInfo prototype) {
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */       implements ActivityRevelryHandler.RevelryTabInfoOrBuilder
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private List<ActivityRevelryHandler.RevelryTodayInfo> today_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryTodayInfo, ActivityRevelryHandler.RevelryTodayInfo.Builder, ActivityRevelryHandler.RevelryTodayInfoOrBuilder> todayBuilder_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTabInfo_descriptor;
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
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTabInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryTabInfo.class, Builder.class);
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
/*       */ 
/*       */ 
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
/*       */         this.name_ = "";
/*       */         this.today_ = Collections.emptyList();
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
/*       */ 
/*       */ 
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
/*       */         this.name_ = "";
/*       */         this.today_ = Collections.emptyList();
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
/*       */ 
/*       */ 
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
/*       */         if (ActivityRevelryHandler.RevelryTabInfo.alwaysUseFieldBuilders) {
/*       */           getTodayFieldBuilder();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.todayBuilder_ == null) {
/*       */           this.today_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.todayBuilder_.clear();
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
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryTabInfo_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryTabInfo.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo build() {
/*       */         ActivityRevelryHandler.RevelryTabInfo result = buildPartial();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryTabInfo result = new ActivityRevelryHandler.RevelryTabInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.name_ = this.name_;
/*       */         if (this.todayBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.today_ = Collections.unmodifiableList(this.today_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.today_ = this.today_;
/*       */         } else {
/*       */           result.today_ = this.todayBuilder_.build();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         if (other instanceof ActivityRevelryHandler.RevelryTabInfo) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryTabInfo)other);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryTabInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryTabInfo.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.todayBuilder_ == null) {
/*       */           if (!other.today_.isEmpty()) {
/*       */             if (this.today_.isEmpty()) {
/*       */               this.today_ = other.today_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureTodayIsMutable();
/*       */               this.today_.addAll(other.today_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.today_.isEmpty()) {
/*       */           if (this.todayBuilder_.isEmpty()) {
/*       */             this.todayBuilder_.dispose();
/*       */             this.todayBuilder_ = null;
/*       */             this.today_ = other.today_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.todayBuilder_ = ActivityRevelryHandler.RevelryTabInfo.alwaysUseFieldBuilders ? getTodayFieldBuilder() : null;
/*       */           } else {
/*       */             this.todayBuilder_.addAllMessages(other.today_);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         if (!hasName()) {
/*       */           return false;
/*       */         }
/*       */         for (int i = 0; i < getTodayCount(); i++) {
/*       */           if (!getToday(i).isInitialized()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         ActivityRevelryHandler.RevelryTabInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryTabInfo)ActivityRevelryHandler.RevelryTabInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryTabInfo)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasName() {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.bitField0_ |= 0x1;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = ActivityRevelryHandler.RevelryTabInfo.getDefaultInstance().getName();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.bitField0_ |= 0x1;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void ensureTodayIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.today_ = new ArrayList<>(this.today_);
/*       */           this.bitField0_ |= 0x2;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryTodayInfo> getTodayList() {
/*       */         if (this.todayBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.today_);
/*       */         }
/*       */         return this.todayBuilder_.getMessageList();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public int getTodayCount() {
/*       */         if (this.todayBuilder_ == null) {
/*       */           return this.today_.size();
/*       */         }
/*       */         return this.todayBuilder_.getCount();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo getToday(int index) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           return this.today_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryTodayInfo)this.todayBuilder_.getMessage(index);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setToday(int index, ActivityRevelryHandler.RevelryTodayInfo value) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureTodayIsMutable();
/*       */           this.today_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.setMessage(index, value);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setToday(int index, ActivityRevelryHandler.RevelryTodayInfo.Builder builderForValue) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           ensureTodayIsMutable();
/*       */           this.today_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.setMessage(index, builderForValue.build());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addToday(ActivityRevelryHandler.RevelryTodayInfo value) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureTodayIsMutable();
/*       */           this.today_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.addMessage(value);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addToday(int index, ActivityRevelryHandler.RevelryTodayInfo value) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureTodayIsMutable();
/*       */           this.today_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.addMessage(index, value);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addToday(ActivityRevelryHandler.RevelryTodayInfo.Builder builderForValue) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           ensureTodayIsMutable();
/*       */           this.today_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.addMessage(builderForValue.build());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addToday(int index, ActivityRevelryHandler.RevelryTodayInfo.Builder builderForValue) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           ensureTodayIsMutable();
/*       */           this.today_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.addMessage(index, builderForValue.build());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder addAllToday(Iterable<? extends ActivityRevelryHandler.RevelryTodayInfo> values) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           ensureTodayIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.today_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.addAllMessages(values);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearToday() {
/*       */         if (this.todayBuilder_ == null) {
/*       */           this.today_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.clear();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder removeToday(int index) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           ensureTodayIsMutable();
/*       */           this.today_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.todayBuilder_.remove(index);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo.Builder getTodayBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryTodayInfo.Builder)getTodayFieldBuilder().getBuilder(index);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfoOrBuilder getTodayOrBuilder(int index) {
/*       */         if (this.todayBuilder_ == null) {
/*       */           return this.today_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryTodayInfoOrBuilder)this.todayBuilder_.getMessageOrBuilder(index);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<? extends ActivityRevelryHandler.RevelryTodayInfoOrBuilder> getTodayOrBuilderList() {
/*       */         if (this.todayBuilder_ != null) {
/*       */           return this.todayBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.today_);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo.Builder addTodayBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryTodayInfo.Builder)getTodayFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryTodayInfo.getDefaultInstance());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTodayInfo.Builder addTodayBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryTodayInfo.Builder)getTodayFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryTodayInfo.getDefaultInstance());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryTodayInfo.Builder> getTodayBuilderList() {
/*       */         return getTodayFieldBuilder().getBuilderList();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryTodayInfo, ActivityRevelryHandler.RevelryTodayInfo.Builder, ActivityRevelryHandler.RevelryTodayInfoOrBuilder> getTodayFieldBuilder() {
/*       */         if (this.todayBuilder_ == null) {
/*       */           this.todayBuilder_ = new RepeatedFieldBuilder(this.today_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.today_ = null;
/*       */         } 
/*       */         return this.todayBuilder_;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class KingExchange
/*       */     extends GeneratedMessage
/*       */     implements KingExchangeOrBuilder
/*       */   {
/*  4985 */     private static final KingExchange defaultInstance = new KingExchange(true); private final UnknownFieldSet unknownFields; private KingExchange(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private KingExchange(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static KingExchange getDefaultInstance() { return defaultInstance; } public KingExchange getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private KingExchange(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.tabId_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.tabName_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.item1Code_ = bs; break;case 32: this.bitField0_ |= 0x8; this.item1Num_ = input.readInt32(); break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.item2Code_ = bs; break;case 48: this.bitField0_ |= 0x20; this.item2Num_ = input.readInt32(); break;case 58: bs = input.readBytes(); this.bitField0_ |= 0x40; this.avatarId_ = bs; break;case 66: bs = input.readBytes(); this.bitField0_ |= 0x80; this.tip_ = bs; break;case 72: this.bitField0_ |= 0x100; this.showType_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_KingExchange_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_KingExchange_fieldAccessorTable.ensureFieldAccessorsInitialized(KingExchange.class, Builder.class); } public static Parser<KingExchange> PARSER = (Parser<KingExchange>)new AbstractParser<KingExchange>() { public ActivityRevelryHandler.KingExchange parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.KingExchange(input, extensionRegistry); } }
/*  4986 */     ; private int bitField0_; public static final int TABID_FIELD_NUMBER = 1; private int tabId_; public static final int TABNAME_FIELD_NUMBER = 2; private Object tabName_; public static final int ITEM1CODE_FIELD_NUMBER = 3; private Object item1Code_; public static final int ITEM1NUM_FIELD_NUMBER = 4; private int item1Num_; public static final int ITEM2CODE_FIELD_NUMBER = 5; private Object item2Code_; public static final int ITEM2NUM_FIELD_NUMBER = 6; private int item2Num_; public static final int AVATARID_FIELD_NUMBER = 7; private Object avatarId_; public static final int TIP_FIELD_NUMBER = 8; private Object tip_; public static final int SHOWTYPE_FIELD_NUMBER = 9; private int showType_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<KingExchange> getParserForType() { return PARSER; } public boolean hasTabId() { return ((this.bitField0_ & 0x1) == 1); } public int getTabId() { return this.tabId_; } public boolean hasTabName() { return ((this.bitField0_ & 0x2) == 2); } public String getTabName() { Object ref = this.tabName_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.tabName_ = s;  return s; } public ByteString getTabNameBytes() { Object ref = this.tabName_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.tabName_ = b; return b; }  return (ByteString)ref; } public boolean hasItem1Code() { return ((this.bitField0_ & 0x4) == 4); } public String getItem1Code() { Object ref = this.item1Code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.item1Code_ = s;  return s; } public ByteString getItem1CodeBytes() { Object ref = this.item1Code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.item1Code_ = b; return b; }  return (ByteString)ref; } public boolean hasItem1Num() { return ((this.bitField0_ & 0x8) == 8); } public int getItem1Num() { return this.item1Num_; } public boolean hasItem2Code() { return ((this.bitField0_ & 0x10) == 16); } public String getItem2Code() { Object ref = this.item2Code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.item2Code_ = s;  return s; } public ByteString getItem2CodeBytes() { Object ref = this.item2Code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.item2Code_ = b; return b; }  return (ByteString)ref; } public boolean hasItem2Num() { return ((this.bitField0_ & 0x20) == 32); } public int getItem2Num() { return this.item2Num_; } public boolean hasAvatarId() { return ((this.bitField0_ & 0x40) == 64); } public String getAvatarId() { Object ref = this.avatarId_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.avatarId_ = s;  return s; } public ByteString getAvatarIdBytes() { Object ref = this.avatarId_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.avatarId_ = b; return b; }  return (ByteString)ref; } public boolean hasTip() { return ((this.bitField0_ & 0x80) == 128); } public String getTip() { Object ref = this.tip_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.tip_ = s;  return s; } public ByteString getTipBytes() { Object ref = this.tip_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.tip_ = b; return b; }  return (ByteString)ref; } public boolean hasShowType() { return ((this.bitField0_ & 0x100) == 256); } public int getShowType() { return this.showType_; } private void initFields() { this.tabId_ = 0; this.tabName_ = ""; this.item1Code_ = ""; this.item1Num_ = 0; this.item2Code_ = ""; this.item2Num_ = 0; this.avatarId_ = ""; this.tip_ = ""; this.showType_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasTabId()) { this.memoizedIsInitialized = 0; return false; }  if (!hasTabName()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItem1Code()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItem1Num()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItem2Code()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItem2Num()) { this.memoizedIsInitialized = 0; return false; }  if (!hasAvatarId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } static { defaultInstance.initFields(); } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.tabId_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getTabNameBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeBytes(3, getItem1CodeBytes());  if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(4, this.item1Num_);  if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeBytes(5, getItem2CodeBytes());  if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeInt32(6, this.item2Num_);  if ((this.bitField0_ & 0x40) == 64)
/*       */         output.writeBytes(7, getAvatarIdBytes());  if ((this.bitField0_ & 0x80) == 128)
/*       */         output.writeBytes(8, getTipBytes());  if ((this.bitField0_ & 0x100) == 256)
/*       */         output.writeInt32(9, this.showType_);  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.tabId_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getTabNameBytes());  if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBytesSize(3, getItem1CodeBytes());  if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.item1Num_);  if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeBytesSize(5, getItem2CodeBytes());  if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.item2Num_);  if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeBytesSize(7, getAvatarIdBytes());  if ((this.bitField0_ & 0x80) == 128)
/*       */         size += CodedOutputStream.computeBytesSize(8, getTipBytes());  if ((this.bitField0_ & 0x100) == 256)
/*       */         size += CodedOutputStream.computeInt32Size(9, this.showType_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static KingExchange parseFrom(ByteString data) throws InvalidProtocolBufferException { return (KingExchange)PARSER.parseFrom(data); }
/*       */     public static KingExchange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (KingExchange)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static KingExchange parseFrom(byte[] data) throws InvalidProtocolBufferException { return (KingExchange)PARSER.parseFrom(data); }
/*       */     public static KingExchange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (KingExchange)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static KingExchange parseFrom(InputStream input) throws IOException { return (KingExchange)PARSER.parseFrom(input); }
/*       */     public static KingExchange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (KingExchange)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static KingExchange parseDelimitedFrom(InputStream input) throws IOException { return (KingExchange)PARSER.parseDelimitedFrom(input); }
/*       */     public static KingExchange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (KingExchange)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static KingExchange parseFrom(CodedInputStream input) throws IOException { return (KingExchange)PARSER.parseFrom(input); }
/*       */     public static KingExchange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (KingExchange)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(KingExchange prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.KingExchangeOrBuilder { private int bitField0_; private int tabId_; private Object tabName_; private Object item1Code_; private int item1Num_; private Object item2Code_; private int item2Num_; private Object avatarId_; private Object tip_; private int showType_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_KingExchange_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_KingExchange_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.KingExchange.class, Builder.class); }
/*       */       private Builder() { this.tabName_ = ""; this.item1Code_ = ""; this.item2Code_ = ""; this.avatarId_ = ""; this.tip_ = ""; maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.tabName_ = ""; this.item1Code_ = ""; this.item2Code_ = ""; this.avatarId_ = ""; this.tip_ = ""; maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.KingExchange.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.tabId_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.tabName_ = ""; this.bitField0_ &= 0xFFFFFFFD; this.item1Code_ = ""; this.bitField0_ &= 0xFFFFFFFB; this.item1Num_ = 0; this.bitField0_ &= 0xFFFFFFF7; this.item2Code_ = ""; this.bitField0_ &= 0xFFFFFFEF; this.item2Num_ = 0; this.bitField0_ &= 0xFFFFFFDF; this.avatarId_ = ""; this.bitField0_ &= 0xFFFFFFBF; this.tip_ = ""; this.bitField0_ &= 0xFFFFFF7F; this.showType_ = 0; this.bitField0_ &= 0xFFFFFEFF; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_KingExchange_descriptor; }
/*       */       public ActivityRevelryHandler.KingExchange getDefaultInstanceForType() { return ActivityRevelryHandler.KingExchange.getDefaultInstance(); }
/*       */       public ActivityRevelryHandler.KingExchange build() { ActivityRevelryHandler.KingExchange result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public ActivityRevelryHandler.KingExchange buildPartial() { ActivityRevelryHandler.KingExchange result = new ActivityRevelryHandler.KingExchange(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.tabId_ = this.tabId_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.tabName_ = this.tabName_; if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x4;  result.item1Code_ = this.item1Code_; if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8;  result.item1Num_ = this.item1Num_; if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10;  result.item2Code_ = this.item2Code_; if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20;  result.item2Num_ = this.item2Num_; if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x40;  result.avatarId_ = this.avatarId_; if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x80;  result.tip_ = this.tip_; if ((from_bitField0_ & 0x100) == 256)
/*       */           to_bitField0_ |= 0x100;  result.showType_ = this.showType_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.KingExchange)
/*       */           return mergeFrom((ActivityRevelryHandler.KingExchange)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.KingExchange other) { if (other == ActivityRevelryHandler.KingExchange.getDefaultInstance())
/*       */           return this;  if (other.hasTabId())
/*       */           setTabId(other.getTabId());  if (other.hasTabName()) {
/*       */           this.bitField0_ |= 0x2; this.tabName_ = other.tabName_; onChanged();
/*       */         }  if (other.hasItem1Code()) {
/*       */           this.bitField0_ |= 0x4; this.item1Code_ = other.item1Code_; onChanged();
/*       */         }  if (other.hasItem1Num())
/*       */           setItem1Num(other.getItem1Num());  if (other.hasItem2Code()) {
/*       */           this.bitField0_ |= 0x10; this.item2Code_ = other.item2Code_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasItem2Num())
/*       */           setItem2Num(other.getItem2Num()); 
/*       */         if (other.hasAvatarId()) {
/*       */           this.bitField0_ |= 0x40;
/*       */           this.avatarId_ = other.avatarId_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasTip()) {
/*       */           this.bitField0_ |= 0x80;
/*       */           this.tip_ = other.tip_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasShowType())
/*       */           setShowType(other.getShowType()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasTabId())
/*       */           return false; 
/*       */         if (!hasTabName())
/*       */           return false; 
/*       */         if (!hasItem1Code())
/*       */           return false; 
/*       */         if (!hasItem1Num())
/*       */           return false; 
/*       */         if (!hasItem2Code())
/*       */           return false; 
/*       */         if (!hasItem2Num())
/*       */           return false; 
/*       */         if (!hasAvatarId())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.KingExchange parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.KingExchange)ActivityRevelryHandler.KingExchange.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.KingExchange)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this; }
/*       */       public boolean hasTabId() { return ((this.bitField0_ & 0x1) == 1); }
/*       */       public int getTabId() { return this.tabId_; }
/*       */       public Builder setTabId(int value) { this.bitField0_ |= 0x1;
/*       */         this.tabId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearTabId() { this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.tabId_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasTabName() { return ((this.bitField0_ & 0x2) == 2); }
/*       */       public String getTabName() { Object ref = this.tabName_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.tabName_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getTabNameBytes() { Object ref = this.tabName_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.tabName_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setTabName(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.tabName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearTabName() { this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.tabName_ = ActivityRevelryHandler.KingExchange.getDefaultInstance().getTabName();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setTabNameBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.tabName_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasItem1Code() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public String getItem1Code() { Object ref = this.item1Code_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.item1Code_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getItem1CodeBytes() { Object ref = this.item1Code_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.item1Code_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setItem1Code(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.item1Code_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearItem1Code() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.item1Code_ = ActivityRevelryHandler.KingExchange.getDefaultInstance().getItem1Code();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setItem1CodeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.item1Code_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasItem1Num() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public int getItem1Num() { return this.item1Num_; }
/*       */       public Builder setItem1Num(int value) { this.bitField0_ |= 0x8;
/*       */         this.item1Num_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearItem1Num() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.item1Num_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasItem2Code() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public String getItem2Code() { Object ref = this.item2Code_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.item2Code_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getItem2CodeBytes() { Object ref = this.item2Code_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.item2Code_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setItem2Code(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.item2Code_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearItem2Code() { this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.item2Code_ = ActivityRevelryHandler.KingExchange.getDefaultInstance().getItem2Code();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setItem2CodeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.item2Code_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasItem2Num() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public int getItem2Num() { return this.item2Num_; }
/*       */       public Builder setItem2Num(int value) { this.bitField0_ |= 0x20;
/*       */         this.item2Num_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearItem2Num() { this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.item2Num_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasAvatarId() { return ((this.bitField0_ & 0x40) == 64); }
/*       */       public String getAvatarId() { Object ref = this.avatarId_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.avatarId_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getAvatarIdBytes() { Object ref = this.avatarId_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.avatarId_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setAvatarId(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.avatarId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearAvatarId() { this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.avatarId_ = ActivityRevelryHandler.KingExchange.getDefaultInstance().getAvatarId();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setAvatarIdBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.avatarId_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasTip() { return ((this.bitField0_ & 0x80) == 128); }
/*       */       public String getTip() { Object ref = this.tip_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.tip_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getTipBytes() { Object ref = this.tip_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.tip_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setTip(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x80;
/*       */         this.tip_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearTip() { this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.tip_ = ActivityRevelryHandler.KingExchange.getDefaultInstance().getTip();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setTipBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x80;
/*       */         this.tip_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasShowType() { return ((this.bitField0_ & 0x100) == 256); }
/*       */       public int getShowType() { return this.showType_; }
/*       */       public Builder setShowType(int value) { this.bitField0_ |= 0x100;
/*       */         this.showType_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearShowType() { this.bitField0_ &= 0xFFFFFEFF;
/*       */         this.showType_ = 0;
/*       */         onChanged();
/*       */         return this; } } }
/*  5306 */   public static final class RevelryGetColumnRequest extends GeneratedMessage implements RevelryGetColumnRequestOrBuilder { private static final RevelryGetColumnRequest defaultInstance = new RevelryGetColumnRequest(true); private final UnknownFieldSet unknownFields; private RevelryGetColumnRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryGetColumnRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryGetColumnRequest getDefaultInstance() { return defaultInstance; } public RevelryGetColumnRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryGetColumnRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryGetColumnRequest.class, Builder.class); } public static Parser<RevelryGetColumnRequest> PARSER = (Parser<RevelryGetColumnRequest>)new AbstractParser<RevelryGetColumnRequest>() { public ActivityRevelryHandler.RevelryGetColumnRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryGetColumnRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryGetColumnRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryGetColumnRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryGetColumnRequest)PARSER.parseFrom(data); } public static RevelryGetColumnRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryGetColumnRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryGetColumnRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryGetColumnRequest)PARSER.parseFrom(data); } public static RevelryGetColumnRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryGetColumnRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryGetColumnRequest parseFrom(InputStream input) throws IOException { return (RevelryGetColumnRequest)PARSER.parseFrom(input); } public static RevelryGetColumnRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetColumnRequest)PARSER.parseFrom(input, extensionRegistry); } public static RevelryGetColumnRequest parseDelimitedFrom(InputStream input) throws IOException { return (RevelryGetColumnRequest)PARSER.parseDelimitedFrom(input); } public static RevelryGetColumnRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetColumnRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryGetColumnRequest parseFrom(CodedInputStream input) throws IOException { return (RevelryGetColumnRequest)PARSER.parseFrom(input); } public static RevelryGetColumnRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetColumnRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryGetColumnRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryGetColumnRequestOrBuilder {
/*  5307 */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryGetColumnRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryGetColumnRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnRequest_descriptor; } public ActivityRevelryHandler.RevelryGetColumnRequest getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryGetColumnRequest.getDefaultInstance(); } public ActivityRevelryHandler.RevelryGetColumnRequest build() { ActivityRevelryHandler.RevelryGetColumnRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryGetColumnRequest buildPartial() { ActivityRevelryHandler.RevelryGetColumnRequest result = new ActivityRevelryHandler.RevelryGetColumnRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryGetColumnRequest) return mergeFrom((ActivityRevelryHandler.RevelryGetColumnRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryGetColumnRequest other) { if (other == ActivityRevelryHandler.RevelryGetColumnRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryGetColumnRequest parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryGetColumnRequest)ActivityRevelryHandler.RevelryGetColumnRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryGetColumnRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryGetColumnResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryGetColumnResponseOrBuilder
/*       */   {
/*  6842 */     private static final RevelryGetColumnResponse defaultInstance = new RevelryGetColumnResponse(true); private final UnknownFieldSet unknownFields; private RevelryGetColumnResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryGetColumnResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryGetColumnResponse getDefaultInstance() { return defaultInstance; } public RevelryGetColumnResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryGetColumnResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.info_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.info_.add(input.readMessage(ActivityRevelryHandler.RevelryTabInfo.PARSER, extensionRegistry)); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.exchange_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.exchange_.add(input.readMessage(ActivityRevelryHandler.KingExchange.PARSER, extensionRegistry)); break;case 40: this.bitField0_ |= 0x4; this.selectedIndex_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.info_ = Collections.unmodifiableList(this.info_);  if ((mutable_bitField0_ & 0x8) == 8) this.exchange_ = Collections.unmodifiableList(this.exchange_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryGetColumnResponse.class, Builder.class); } public static Parser<RevelryGetColumnResponse> PARSER = (Parser<RevelryGetColumnResponse>)new AbstractParser<RevelryGetColumnResponse>() { public ActivityRevelryHandler.RevelryGetColumnResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryGetColumnResponse(input, extensionRegistry); } }
/*  6843 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int INFO_FIELD_NUMBER = 3; private List<ActivityRevelryHandler.RevelryTabInfo> info_; public static final int EXCHANGE_FIELD_NUMBER = 4; private List<ActivityRevelryHandler.KingExchange> exchange_; public static final int SELECTEDINDEX_FIELD_NUMBER = 5; private int selectedIndex_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryGetColumnResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public List<ActivityRevelryHandler.RevelryTabInfo> getInfoList() { return this.info_; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends ActivityRevelryHandler.RevelryTabInfoOrBuilder> getInfoOrBuilderList() {
/*       */       return (List)this.info_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getInfoCount() {
/*       */       return this.info_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.RevelryTabInfo getInfo(int index) {
/*       */       return this.info_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.RevelryTabInfoOrBuilder getInfoOrBuilder(int index) {
/*       */       return this.info_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public List<ActivityRevelryHandler.KingExchange> getExchangeList() {
/*       */       return this.exchange_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public List<? extends ActivityRevelryHandler.KingExchangeOrBuilder> getExchangeOrBuilderList() {
/*       */       return (List)this.exchange_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getExchangeCount() {
/*       */       return this.exchange_.size();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.KingExchange getExchange(int index) {
/*       */       return this.exchange_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public ActivityRevelryHandler.KingExchangeOrBuilder getExchangeOrBuilder(int index) {
/*       */       return this.exchange_.get(index);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasSelectedIndex() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getSelectedIndex() {
/*       */       return this.selectedIndex_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.info_ = Collections.emptyList();
/*       */       this.exchange_ = Collections.emptyList();
/*       */       this.selectedIndex_ = 0;
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
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       int i;
/*       */       for (i = 0; i < getInfoCount(); i++) {
/*       */         if (!getInfo(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       for (i = 0; i < getExchangeCount(); i++) {
/*       */         if (!getExchange(i).isInitialized()) {
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
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeInt32(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeBytes(2, getS2CMsgBytes());
/*       */       }
/*       */       int i;
/*       */       for (i = 0; i < this.info_.size(); i++) {
/*       */         output.writeMessage(3, (MessageLite)this.info_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.exchange_.size(); i++) {
/*       */         output.writeMessage(4, (MessageLite)this.exchange_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         output.writeInt32(5, this.selectedIndex_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
/*       */       }
/*       */       int i;
/*       */       for (i = 0; i < this.info_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.info_.get(i));
/*       */       }
/*       */       for (i = 0; i < this.exchange_.size(); i++) {
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.exchange_.get(i));
/*       */       }
/*       */       if ((this.bitField0_ & 0x4) == 4) {
/*       */         size += CodedOutputStream.computeInt32Size(5, this.selectedIndex_);
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
/*       */     public static RevelryGetColumnResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetColumnResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetColumnResponse)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RevelryGetColumnResponse prototype) {
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
/*       */       implements ActivityRevelryHandler.RevelryGetColumnResponseOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int s2CCode_;
/*       */ 
/*       */       
/*       */       private Object s2CMsg_;
/*       */ 
/*       */       
/*       */       private List<ActivityRevelryHandler.RevelryTabInfo> info_;
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryTabInfo, ActivityRevelryHandler.RevelryTabInfo.Builder, ActivityRevelryHandler.RevelryTabInfoOrBuilder> infoBuilder_;
/*       */ 
/*       */       
/*       */       private List<ActivityRevelryHandler.KingExchange> exchange_;
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.KingExchange, ActivityRevelryHandler.KingExchange.Builder, ActivityRevelryHandler.KingExchangeOrBuilder> exchangeBuilder_;
/*       */ 
/*       */       
/*       */       private int selectedIndex_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryGetColumnResponse.class, Builder.class);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.info_ = Collections.emptyList();
/*       */         this.exchange_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.info_ = Collections.emptyList();
/*       */         this.exchange_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryGetColumnResponse.alwaysUseFieldBuilders) {
/*       */           getInfoFieldBuilder();
/*       */           getExchangeFieldBuilder();
/*       */         } 
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.info_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.infoBuilder_.clear();
/*       */         } 
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           this.exchange_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.exchangeBuilder_.clear();
/*       */         } 
/*       */         this.selectedIndex_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetColumnResponse_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetColumnResponse getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryGetColumnResponse.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetColumnResponse build() {
/*       */         ActivityRevelryHandler.RevelryGetColumnResponse result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetColumnResponse buildPartial() {
/*       */         ActivityRevelryHandler.RevelryGetColumnResponse result = new ActivityRevelryHandler.RevelryGetColumnResponse(this);
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
/*       */         if (this.infoBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.info_ = Collections.unmodifiableList(this.info_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.info_ = this.info_;
/*       */         } else {
/*       */           result.info_ = this.infoBuilder_.build();
/*       */         } 
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.exchange_ = Collections.unmodifiableList(this.exchange_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.exchange_ = this.exchange_;
/*       */         } else {
/*       */           result.exchange_ = this.exchangeBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x10) == 16) {
/*       */           to_bitField0_ |= 0x4;
/*       */         }
/*       */         result.selectedIndex_ = this.selectedIndex_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryGetColumnResponse) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryGetColumnResponse)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryGetColumnResponse other) {
/*       */         if (other == ActivityRevelryHandler.RevelryGetColumnResponse.getDefaultInstance()) {
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
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (!other.info_.isEmpty()) {
/*       */             if (this.info_.isEmpty()) {
/*       */               this.info_ = other.info_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureInfoIsMutable();
/*       */               this.info_.addAll(other.info_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.info_.isEmpty()) {
/*       */           if (this.infoBuilder_.isEmpty()) {
/*       */             this.infoBuilder_.dispose();
/*       */             this.infoBuilder_ = null;
/*       */             this.info_ = other.info_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.infoBuilder_ = ActivityRevelryHandler.RevelryGetColumnResponse.alwaysUseFieldBuilders ? getInfoFieldBuilder() : null;
/*       */           } else {
/*       */             this.infoBuilder_.addAllMessages(other.info_);
/*       */           } 
/*       */         } 
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           if (!other.exchange_.isEmpty()) {
/*       */             if (this.exchange_.isEmpty()) {
/*       */               this.exchange_ = other.exchange_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureExchangeIsMutable();
/*       */               this.exchange_.addAll(other.exchange_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.exchange_.isEmpty()) {
/*       */           if (this.exchangeBuilder_.isEmpty()) {
/*       */             this.exchangeBuilder_.dispose();
/*       */             this.exchangeBuilder_ = null;
/*       */             this.exchange_ = other.exchange_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.exchangeBuilder_ = ActivityRevelryHandler.RevelryGetColumnResponse.alwaysUseFieldBuilders ? getExchangeFieldBuilder() : null;
/*       */           } else {
/*       */             this.exchangeBuilder_.addAllMessages(other.exchange_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasSelectedIndex()) {
/*       */           setSelectedIndex(other.getSelectedIndex());
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
/*       */         int i;
/*       */         for (i = 0; i < getInfoCount(); i++) {
/*       */           if (!getInfo(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         for (i = 0; i < getExchangeCount(); i++) {
/*       */           if (!getExchange(i).isInitialized()) {
/*       */             return false;
/*       */           }
/*       */         } 
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryGetColumnResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetColumnResponse)ActivityRevelryHandler.RevelryGetColumnResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetColumnResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ActivityRevelryHandler.RevelryGetColumnResponse.getDefaultInstance().getS2CMsg();
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
/*       */       private void ensureInfoIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.info_ = new ArrayList<>(this.info_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryTabInfo> getInfoList() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.info_);
/*       */         }
/*       */         return this.infoBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */       
/*       */       public int getInfoCount() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           return this.info_.size();
/*       */         }
/*       */         return this.infoBuilder_.getCount();
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo getInfo(int index) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           return this.info_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryTabInfo)this.infoBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setInfo(int index, ActivityRevelryHandler.RevelryTabInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureInfoIsMutable();
/*       */           this.info_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setInfo(int index, ActivityRevelryHandler.RevelryTabInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addInfo(ActivityRevelryHandler.RevelryTabInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addInfo(int index, ActivityRevelryHandler.RevelryTabInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addInfo(ActivityRevelryHandler.RevelryTabInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addInfo(int index, ActivityRevelryHandler.RevelryTabInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addAllInfo(Iterable<? extends ActivityRevelryHandler.RevelryTabInfo> values) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.info_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearInfo() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.info_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder removeInfo(int index) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo.Builder getInfoBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryTabInfo.Builder)getInfoFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfoOrBuilder getInfoOrBuilder(int index) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           return this.info_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.RevelryTabInfoOrBuilder)this.infoBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public List<? extends ActivityRevelryHandler.RevelryTabInfoOrBuilder> getInfoOrBuilderList() {
/*       */         if (this.infoBuilder_ != null) {
/*       */           return this.infoBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.info_);
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo.Builder addInfoBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryTabInfo.Builder)getInfoFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryTabInfo.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryTabInfo.Builder addInfoBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryTabInfo.Builder)getInfoFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryTabInfo.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.RevelryTabInfo.Builder> getInfoBuilderList() {
/*       */         return getInfoFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryTabInfo, ActivityRevelryHandler.RevelryTabInfo.Builder, ActivityRevelryHandler.RevelryTabInfoOrBuilder> getInfoFieldBuilder() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.infoBuilder_ = new RepeatedFieldBuilder(this.info_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.info_ = null;
/*       */         } 
/*       */         return this.infoBuilder_;
/*       */       }
/*       */ 
/*       */       
/*       */       private void ensureExchangeIsMutable() {
/*       */         if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.exchange_ = new ArrayList<>(this.exchange_);
/*       */           this.bitField0_ |= 0x8;
/*       */         } 
/*       */       }
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.KingExchange> getExchangeList() {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           return Collections.unmodifiableList(this.exchange_);
/*       */         }
/*       */         return this.exchangeBuilder_.getMessageList();
/*       */       }
/*       */ 
/*       */       
/*       */       public int getExchangeCount() {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           return this.exchange_.size();
/*       */         }
/*       */         return this.exchangeBuilder_.getCount();
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.KingExchange getExchange(int index) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           return this.exchange_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.KingExchange)this.exchangeBuilder_.getMessage(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setExchange(int index, ActivityRevelryHandler.KingExchange value) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setExchange(int index, ActivityRevelryHandler.KingExchange.Builder builderForValue) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addExchange(ActivityRevelryHandler.KingExchange value) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addExchange(int index, ActivityRevelryHandler.KingExchange value) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           if (value == null) {
/*       */             throw new NullPointerException();
/*       */           }
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addExchange(ActivityRevelryHandler.KingExchange.Builder builderForValue) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addExchange(int index, ActivityRevelryHandler.KingExchange.Builder builderForValue) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder addAllExchange(Iterable<? extends ActivityRevelryHandler.KingExchange> values) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           ensureExchangeIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.exchange_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearExchange() {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           this.exchange_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder removeExchange(int index) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           ensureExchangeIsMutable();
/*       */           this.exchange_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.exchangeBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.KingExchange.Builder getExchangeBuilder(int index) {
/*       */         return (ActivityRevelryHandler.KingExchange.Builder)getExchangeFieldBuilder().getBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.KingExchangeOrBuilder getExchangeOrBuilder(int index) {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           return this.exchange_.get(index);
/*       */         }
/*       */         return (ActivityRevelryHandler.KingExchangeOrBuilder)this.exchangeBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */ 
/*       */       
/*       */       public List<? extends ActivityRevelryHandler.KingExchangeOrBuilder> getExchangeOrBuilderList() {
/*       */         if (this.exchangeBuilder_ != null) {
/*       */           return this.exchangeBuilder_.getMessageOrBuilderList();
/*       */         }
/*       */         return Collections.unmodifiableList((List)this.exchange_);
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.KingExchange.Builder addExchangeBuilder() {
/*       */         return (ActivityRevelryHandler.KingExchange.Builder)getExchangeFieldBuilder().addBuilder(ActivityRevelryHandler.KingExchange.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.KingExchange.Builder addExchangeBuilder(int index) {
/*       */         return (ActivityRevelryHandler.KingExchange.Builder)getExchangeFieldBuilder().addBuilder(index, ActivityRevelryHandler.KingExchange.getDefaultInstance());
/*       */       }
/*       */ 
/*       */       
/*       */       public List<ActivityRevelryHandler.KingExchange.Builder> getExchangeBuilderList() {
/*       */         return getExchangeFieldBuilder().getBuilderList();
/*       */       }
/*       */ 
/*       */       
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.KingExchange, ActivityRevelryHandler.KingExchange.Builder, ActivityRevelryHandler.KingExchangeOrBuilder> getExchangeFieldBuilder() {
/*       */         if (this.exchangeBuilder_ == null) {
/*       */           this.exchangeBuilder_ = new RepeatedFieldBuilder(this.exchange_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.exchange_ = null;
/*       */         } 
/*       */         return this.exchangeBuilder_;
/*       */       }
/*       */ 
/*       */       
/*       */       public boolean hasSelectedIndex() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */ 
/*       */       
/*       */       public int getSelectedIndex() {
/*       */         return this.selectedIndex_;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder setSelectedIndex(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.selectedIndex_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */       
/*       */       public Builder clearSelectedIndex() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.selectedIndex_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static final class RevelryRankInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryRankInfoOrBuilder
/*       */   {
/*  7901 */     private static final RevelryRankInfo defaultInstance = new RevelryRankInfo(true); private final UnknownFieldSet unknownFields; private RevelryRankInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRankInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRankInfo getDefaultInstance() { return defaultInstance; } public RevelryRankInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRankInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); if ((mutable_bitField0_ & 0x1) != 1) { this.contents_ = (LazyStringList)new LazyStringArrayList(); mutable_bitField0_ |= 0x1; }  this.contents_.add(bs); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.avatars_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.avatars_.add(input.readMessage(Common.Avatar.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x1) == 1) this.contents_ = this.contents_.getUnmodifiableView();  if ((mutable_bitField0_ & 0x2) == 2) this.avatars_ = Collections.unmodifiableList(this.avatars_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRankInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRankInfo.class, Builder.class); } public static Parser<RevelryRankInfo> PARSER = (Parser<RevelryRankInfo>)new AbstractParser<RevelryRankInfo>() { public ActivityRevelryHandler.RevelryRankInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRankInfo(input, extensionRegistry); } }
/*  7902 */     ; public static final int CONTENTS_FIELD_NUMBER = 1; private LazyStringList contents_; public static final int AVATARS_FIELD_NUMBER = 2; private List<Common.Avatar> avatars_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRankInfo> getParserForType() { return PARSER; } public ProtocolStringList getContentsList() { return (ProtocolStringList)this.contents_; } public int getContentsCount() { return this.contents_.size(); } public String getContents(int index) { return (String)this.contents_.get(index); } public ByteString getContentsBytes(int index) { return this.contents_.getByteString(index); } public List<Common.Avatar> getAvatarsList() { return this.avatars_; } public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() { return (List)this.avatars_; } static { defaultInstance.initFields(); }
/*       */     
/*       */     public int getAvatarsCount() {
/*       */       return this.avatars_.size();
/*       */     }
/*       */     public Common.Avatar getAvatars(int index) {
/*       */       return this.avatars_.get(index);
/*       */     }
/*       */     public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
/*       */       return (Common.AvatarOrBuilder)this.avatars_.get(index);
/*       */     }
/*       */     private void initFields() {
/*       */       this.contents_ = LazyStringArrayList.EMPTY;
/*       */       this.avatars_ = Collections.emptyList();
/*       */     }
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       for (int i = 0; i < getAvatarsCount(); i++) {
/*       */         if (!getAvatars(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       int i;
/*       */       for (i = 0; i < this.contents_.size(); i++)
/*       */         output.writeBytes(1, this.contents_.getByteString(i)); 
/*       */       for (i = 0; i < this.avatars_.size(); i++)
/*       */         output.writeMessage(2, (MessageLite)this.avatars_.get(i)); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       int dataSize = 0;
/*       */       for (int j = 0; j < this.contents_.size(); j++)
/*       */         dataSize += CodedOutputStream.computeBytesSizeNoTag(this.contents_.getByteString(j)); 
/*       */       size += dataSize;
/*       */       size += 1 * getContentsList().size();
/*       */       for (int i = 0; i < this.avatars_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.avatars_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(data);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(data);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(input);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static RevelryRankInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static RevelryRankInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(input);
/*       */     }
/*       */     public static RevelryRankInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRankInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(RevelryRankInfo prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRankInfoOrBuilder { private int bitField0_; private LazyStringList contents_; private List<Common.Avatar> avatars_; private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> avatarsBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRankInfo_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRankInfo.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.contents_ = LazyStringArrayList.EMPTY;
/*       */         this.avatars_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.contents_ = LazyStringArrayList.EMPTY;
/*       */         this.avatars_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryRankInfo.alwaysUseFieldBuilders)
/*       */           getAvatarsFieldBuilder(); 
/*       */       }
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.contents_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           this.avatars_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.avatarsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRankInfo_descriptor;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfo build() {
/*       */         ActivityRevelryHandler.RevelryRankInfo result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryRankInfo result = new ActivityRevelryHandler.RevelryRankInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         if ((this.bitField0_ & 0x1) == 1) {
/*       */           this.contents_ = this.contents_.getUnmodifiableView();
/*       */           this.bitField0_ &= 0xFFFFFFFE;
/*       */         } 
/*       */         result.contents_ = this.contents_;
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.avatars_ = Collections.unmodifiableList(this.avatars_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.avatars_ = this.avatars_;
/*       */         } else {
/*       */           result.avatars_ = this.avatarsBuilder_.build();
/*       */         } 
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryRankInfo)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRankInfo)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryRankInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance())
/*       */           return this; 
/*       */         if (!other.contents_.isEmpty()) {
/*       */           if (this.contents_.isEmpty()) {
/*       */             this.contents_ = other.contents_;
/*       */             this.bitField0_ &= 0xFFFFFFFE;
/*       */           } else {
/*       */             ensureContentsIsMutable();
/*       */             this.contents_.addAll((Collection)other.contents_);
/*       */           } 
/*       */           onChanged();
/*       */         } 
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           if (!other.avatars_.isEmpty()) {
/*       */             if (this.avatars_.isEmpty()) {
/*       */               this.avatars_ = other.avatars_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureAvatarsIsMutable();
/*       */               this.avatars_.addAll(other.avatars_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.avatars_.isEmpty()) {
/*       */           if (this.avatarsBuilder_.isEmpty()) {
/*       */             this.avatarsBuilder_.dispose();
/*       */             this.avatarsBuilder_ = null;
/*       */             this.avatars_ = other.avatars_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.avatarsBuilder_ = ActivityRevelryHandler.RevelryRankInfo.alwaysUseFieldBuilders ? getAvatarsFieldBuilder() : null;
/*       */           } else {
/*       */             this.avatarsBuilder_.addAllMessages(other.avatars_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         for (int i = 0; i < getAvatarsCount(); i++) {
/*       */           if (!getAvatars(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryRankInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRankInfo)ActivityRevelryHandler.RevelryRankInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRankInfo)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       private void ensureContentsIsMutable() {
/*       */         if ((this.bitField0_ & 0x1) != 1) {
/*       */           this.contents_ = (LazyStringList)new LazyStringArrayList(this.contents_);
/*       */           this.bitField0_ |= 0x1;
/*       */         } 
/*       */       }
/*       */       public ProtocolStringList getContentsList() {
/*       */         return (ProtocolStringList)this.contents_.getUnmodifiableView();
/*       */       }
/*       */       public int getContentsCount() {
/*       */         return this.contents_.size();
/*       */       }
/*       */       public String getContents(int index) {
/*       */         return (String)this.contents_.get(index);
/*       */       }
/*       */       public ByteString getContentsBytes(int index) {
/*       */         return this.contents_.getByteString(index);
/*       */       }
/*       */       public Builder setContents(int index, String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureContentsIsMutable();
/*       */         this.contents_.set(index, value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder addContents(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureContentsIsMutable();
/*       */         this.contents_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder addAllContents(Iterable<String> values) {
/*       */         ensureContentsIsMutable();
/*       */         AbstractMessageLite.Builder.addAll(values, (Collection)this.contents_);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearContents() {
/*       */         this.contents_ = LazyStringArrayList.EMPTY;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder addContentsBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         ensureContentsIsMutable();
/*       */         this.contents_.add(value);
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       private void ensureAvatarsIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.avatars_ = new ArrayList<>(this.avatars_);
/*       */           this.bitField0_ |= 0x2;
/*       */         } 
/*       */       }
/*       */       public List<Common.Avatar> getAvatarsList() {
/*       */         if (this.avatarsBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.avatars_); 
/*       */         return this.avatarsBuilder_.getMessageList();
/*       */       }
/*       */       
/*       */       public int getAvatarsCount() {
/*       */         if (this.avatarsBuilder_ == null)
/*       */           return this.avatars_.size(); 
/*       */         return this.avatarsBuilder_.getCount();
/*       */       }
/*       */       
/*       */       public Common.Avatar getAvatars(int index) {
/*       */         if (this.avatarsBuilder_ == null)
/*       */           return this.avatars_.get(index); 
/*       */         return (Common.Avatar)this.avatarsBuilder_.getMessage(index);
/*       */       }
/*       */       
/*       */       public Builder setAvatars(int index, Common.Avatar value) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.setMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setAvatars(int index, Common.Avatar.Builder builderForValue) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAvatars(Common.Avatar value) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.addMessage((GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAvatars(int index, Common.Avatar value) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.addMessage(index, (GeneratedMessage)value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAvatars(Common.Avatar.Builder builderForValue) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAvatars(int index, Common.Avatar.Builder builderForValue) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder addAllAvatars(Iterable<? extends Common.Avatar> values) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           ensureAvatarsIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.avatars_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearAvatars() {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           this.avatars_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder removeAvatars(int index) {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           ensureAvatarsIsMutable();
/*       */           this.avatars_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.avatarsBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Common.Avatar.Builder getAvatarsBuilder(int index) {
/*       */         return (Common.Avatar.Builder)getAvatarsFieldBuilder().getBuilder(index);
/*       */       }
/*       */       
/*       */       public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
/*       */         if (this.avatarsBuilder_ == null)
/*       */           return (Common.AvatarOrBuilder)this.avatars_.get(index); 
/*       */         return (Common.AvatarOrBuilder)this.avatarsBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       
/*       */       public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
/*       */         if (this.avatarsBuilder_ != null)
/*       */           return this.avatarsBuilder_.getMessageOrBuilderList(); 
/*       */         return (List)Collections.unmodifiableList(this.avatars_);
/*       */       }
/*       */       
/*       */       public Common.Avatar.Builder addAvatarsBuilder() {
/*       */         return (Common.Avatar.Builder)getAvatarsFieldBuilder().addBuilder((GeneratedMessage)Common.Avatar.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public Common.Avatar.Builder addAvatarsBuilder(int index) {
/*       */         return (Common.Avatar.Builder)getAvatarsFieldBuilder().addBuilder(index, (GeneratedMessage)Common.Avatar.getDefaultInstance());
/*       */       }
/*       */       
/*       */       public List<Common.Avatar.Builder> getAvatarsBuilderList() {
/*       */         return getAvatarsFieldBuilder().getBuilderList();
/*       */       }
/*       */       
/*       */       private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getAvatarsFieldBuilder() {
/*       */         if (this.avatarsBuilder_ == null) {
/*       */           this.avatarsBuilder_ = new RepeatedFieldBuilder(this.avatars_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.avatars_ = null;
/*       */         } 
/*       */         return this.avatarsBuilder_;
/*       */       } } }
/*       */   
/*       */   public static final class RevelryAwardInfo extends GeneratedMessage implements RevelryAwardInfoOrBuilder { private final UnknownFieldSet unknownFields;
/*       */     
/*       */     private RevelryAwardInfo(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */     
/*       */     private RevelryAwardInfo(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */     
/*       */     public static RevelryAwardInfo getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public RevelryAwardInfo getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */     
/*       */     private RevelryAwardInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */             case 10:
/*       */               bs = input.readBytes();
/*       */               this.bitField0_ |= 0x1;
/*       */               this.itemcode_ = bs;
/*       */               break;
/*       */             case 16:
/*       */               this.bitField0_ |= 0x2;
/*       */               this.itemcount_ = input.readInt32();
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
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryAwardInfo_descriptor;
/*       */     }
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryAwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryAwardInfo.class, Builder.class);
/*       */     }
/*       */     
/*       */     public static Parser<RevelryAwardInfo> PARSER = (Parser<RevelryAwardInfo>)new AbstractParser<RevelryAwardInfo>() { public ActivityRevelryHandler.RevelryAwardInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ActivityRevelryHandler.RevelryAwardInfo(input, extensionRegistry);
/*       */         } }
/*       */     ;
/*       */     
/*       */     private int bitField0_;
/*       */     public static final int ITEMCODE_FIELD_NUMBER = 1;
/*       */     private Object itemcode_;
/*       */     public static final int ITEMCOUNT_FIELD_NUMBER = 2;
/*       */     private int itemcount_;
/*       */     private byte memoizedIsInitialized;
/*       */     private int memoizedSerializedSize;
/*       */     private static final long serialVersionUID = 0L;
/*       */     
/*       */     public Parser<RevelryAwardInfo> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */     
/*       */     public boolean hasItemcode() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */     
/*       */     public String getItemcode() {
/*       */       Object ref = this.itemcode_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.itemcode_ = s; 
/*       */       return s;
/*       */     }
/*       */     
/*       */     public ByteString getItemcodeBytes() {
/*       */       Object ref = this.itemcode_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.itemcode_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     
/*       */     public boolean hasItemcount() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
/*       */     
/*  8479 */     private static final RevelryAwardInfo defaultInstance = new RevelryAwardInfo(true); public int getItemcount() { return this.itemcount_; } private void initFields() { this.itemcode_ = ""; this.itemcount_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasItemcode()) { this.memoizedIsInitialized = 0; return false; }  if (!hasItemcount()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getItemcodeBytes());  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.itemcount_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getItemcodeBytes());  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.itemcount_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryAwardInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryAwardInfo)PARSER.parseFrom(data); } public static RevelryAwardInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryAwardInfo)PARSER.parseFrom(data, extensionRegistry); } public static RevelryAwardInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryAwardInfo)PARSER.parseFrom(data); } public static RevelryAwardInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryAwardInfo)PARSER.parseFrom(data, extensionRegistry); } public static RevelryAwardInfo parseFrom(InputStream input) throws IOException { return (RevelryAwardInfo)PARSER.parseFrom(input); } public static RevelryAwardInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryAwardInfo)PARSER.parseFrom(input, extensionRegistry); } public static RevelryAwardInfo parseDelimitedFrom(InputStream input) throws IOException { return (RevelryAwardInfo)PARSER.parseDelimitedFrom(input); } public static RevelryAwardInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryAwardInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryAwardInfo parseFrom(CodedInputStream input) throws IOException { return (RevelryAwardInfo)PARSER.parseFrom(input); } public static RevelryAwardInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryAwardInfo)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryAwardInfo prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryAwardInfoOrBuilder {
/*  8480 */       private int bitField0_; private Object itemcode_; private int itemcount_; public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryAwardInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryAwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryAwardInfo.class, Builder.class); } private Builder() { this.itemcode_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.itemcode_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryAwardInfo.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.itemcode_ = ""; this.bitField0_ &= 0xFFFFFFFE; this.itemcount_ = 0; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryAwardInfo_descriptor; } public ActivityRevelryHandler.RevelryAwardInfo getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryAwardInfo.getDefaultInstance(); } public ActivityRevelryHandler.RevelryAwardInfo build() { ActivityRevelryHandler.RevelryAwardInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryAwardInfo buildPartial() { ActivityRevelryHandler.RevelryAwardInfo result = new ActivityRevelryHandler.RevelryAwardInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.itemcode_ = this.itemcode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.itemcount_ = this.itemcount_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryAwardInfo) return mergeFrom((ActivityRevelryHandler.RevelryAwardInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryAwardInfo other) { if (other == ActivityRevelryHandler.RevelryAwardInfo.getDefaultInstance()) return this;  if (other.hasItemcode()) { this.bitField0_ |= 0x1; this.itemcode_ = other.itemcode_; onChanged(); }  if (other.hasItemcount()) setItemcount(other.getItemcount());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasItemcode()) return false;  if (!hasItemcount()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryAwardInfo parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryAwardInfo)ActivityRevelryHandler.RevelryAwardInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryAwardInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasItemcode() { return ((this.bitField0_ & 0x1) == 1); } public String getItemcode() { Object ref = this.itemcode_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.itemcode_ = s;  return s; }  return (String)ref; } public ByteString getItemcodeBytes() { Object ref = this.itemcode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.itemcode_ = b; return b; }  return (ByteString)ref; } public Builder setItemcode(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.itemcode_ = value; onChanged(); return this; } public Builder clearItemcode() { this.bitField0_ &= 0xFFFFFFFE; this.itemcode_ = ActivityRevelryHandler.RevelryAwardInfo.getDefaultInstance().getItemcode(); onChanged(); return this; } public Builder setItemcodeBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x1; this.itemcode_ = value; onChanged(); return this; } public boolean hasItemcount() { return ((this.bitField0_ & 0x2) == 2); } public int getItemcount() { return this.itemcount_; } public Builder setItemcount(int value) { this.bitField0_ |= 0x2; this.itemcount_ = value; onChanged(); return this; } public Builder clearItemcount() { this.bitField0_ &= 0xFFFFFFFD; this.itemcount_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryConfigInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryConfigInfoOrBuilder
/*       */   {
/*  9787 */     private static final RevelryConfigInfo defaultInstance = new RevelryConfigInfo(true); private final UnknownFieldSet unknownFields; private RevelryConfigInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryConfigInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryConfigInfo getDefaultInstance() { return defaultInstance; } public RevelryConfigInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryConfigInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ActivityRevelryHandler.RevelryRankInfo.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.minRank_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.maxRank_ = input.readInt32(); break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.award_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.award_.add(input.readMessage(ActivityRevelryHandler.RevelryAwardInfo.PARSER, extensionRegistry)); break;case 34: subBuilder = null; if ((this.bitField0_ & 0x4) == 4) subBuilder = this.player_.toBuilder();  this.player_ = (ActivityRevelryHandler.RevelryRankInfo)input.readMessage(ActivityRevelryHandler.RevelryRankInfo.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.player_); this.player_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x4; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.award_ = Collections.unmodifiableList(this.award_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryConfigInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryConfigInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryConfigInfo.class, Builder.class); } public static Parser<RevelryConfigInfo> PARSER = (Parser<RevelryConfigInfo>)new AbstractParser<RevelryConfigInfo>() { public ActivityRevelryHandler.RevelryConfigInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryConfigInfo(input, extensionRegistry); } }
/*  9788 */     ; private int bitField0_; public static final int MINRANK_FIELD_NUMBER = 1; private int minRank_; public static final int MAXRANK_FIELD_NUMBER = 2; private int maxRank_; public static final int AWARD_FIELD_NUMBER = 3; private List<ActivityRevelryHandler.RevelryAwardInfo> award_; public static final int PLAYER_FIELD_NUMBER = 4; private ActivityRevelryHandler.RevelryRankInfo player_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryConfigInfo> getParserForType() { return PARSER; } public boolean hasMinRank() { return ((this.bitField0_ & 0x1) == 1); } public int getMinRank() { return this.minRank_; } public boolean hasMaxRank() { return ((this.bitField0_ & 0x2) == 2); } public int getMaxRank() { return this.maxRank_; } public List<ActivityRevelryHandler.RevelryAwardInfo> getAwardList() { return this.award_; } static { defaultInstance.initFields(); }
/*       */      public List<? extends ActivityRevelryHandler.RevelryAwardInfoOrBuilder> getAwardOrBuilderList() {
/*       */       return (List)this.award_;
/*       */     } public int getAwardCount() {
/*       */       return this.award_.size();
/*       */     } public ActivityRevelryHandler.RevelryAwardInfo getAward(int index) {
/*       */       return this.award_.get(index);
/*       */     } public ActivityRevelryHandler.RevelryAwardInfoOrBuilder getAwardOrBuilder(int index) {
/*       */       return this.award_.get(index);
/*       */     } public boolean hasPlayer() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public ActivityRevelryHandler.RevelryRankInfo getPlayer() {
/*       */       return this.player_;
/*       */     }
/*       */     public ActivityRevelryHandler.RevelryRankInfoOrBuilder getPlayerOrBuilder() {
/*       */       return this.player_;
/*       */     }
/*       */     private void initFields() {
/*       */       this.minRank_ = 0;
/*       */       this.maxRank_ = 0;
/*       */       this.award_ = Collections.emptyList();
/*       */       this.player_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */     }
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasMinRank()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasMaxRank()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getAwardCount(); i++) {
/*       */         if (!getAward(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       if (hasPlayer() && !getPlayer().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.minRank_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeInt32(2, this.maxRank_); 
/*       */       for (int i = 0; i < this.award_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.award_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeMessage(4, (MessageLite)this.player_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.minRank_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeInt32Size(2, this.maxRank_); 
/*       */       for (int i = 0; i < this.award_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.award_.get(i)); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.player_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(data);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(data);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(input);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static RevelryConfigInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     public static RevelryConfigInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(input);
/*       */     }
/*       */     public static RevelryConfigInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryConfigInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     }
/*       */     public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     }
/*       */     public static Builder newBuilder(RevelryConfigInfo prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     }
/*       */     public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryConfigInfoOrBuilder { private int bitField0_; private int minRank_; private int maxRank_; private List<ActivityRevelryHandler.RevelryAwardInfo> award_; private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryAwardInfo, ActivityRevelryHandler.RevelryAwardInfo.Builder, ActivityRevelryHandler.RevelryAwardInfoOrBuilder> awardBuilder_; private ActivityRevelryHandler.RevelryRankInfo player_; private SingleFieldBuilder<ActivityRevelryHandler.RevelryRankInfo, ActivityRevelryHandler.RevelryRankInfo.Builder, ActivityRevelryHandler.RevelryRankInfoOrBuilder> playerBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryConfigInfo_descriptor;
/*       */       }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryConfigInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryConfigInfo.class, Builder.class);
/*       */       }
/*       */       private Builder() {
/*       */         this.award_ = Collections.emptyList();
/*       */         this.player_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.award_ = Collections.emptyList();
/*       */         this.player_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryConfigInfo.alwaysUseFieldBuilders) {
/*       */           getAwardFieldBuilder();
/*       */           getPlayerFieldBuilder();
/*       */         } 
/*       */       }
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.minRank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.maxRank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.awardBuilder_ == null) {
/*       */           this.award_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.awardBuilder_.clear();
/*       */         } 
/*       */         if (this.playerBuilder_ == null) {
/*       */           this.player_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         } else {
/*       */           this.playerBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryConfigInfo_descriptor;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryConfigInfo.getDefaultInstance();
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo build() {
/*       */         ActivityRevelryHandler.RevelryConfigInfo result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryConfigInfo result = new ActivityRevelryHandler.RevelryConfigInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.minRank_ = this.minRank_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.maxRank_ = this.maxRank_;
/*       */         if (this.awardBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.award_ = Collections.unmodifiableList(this.award_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.award_ = this.award_;
/*       */         } else {
/*       */           result.award_ = this.awardBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x4; 
/*       */         if (this.playerBuilder_ == null) {
/*       */           result.player_ = this.player_;
/*       */         } else {
/*       */           result.player_ = (ActivityRevelryHandler.RevelryRankInfo)this.playerBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryConfigInfo)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryConfigInfo)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryConfigInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryConfigInfo.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasMinRank())
/*       */           setMinRank(other.getMinRank()); 
/*       */         if (other.hasMaxRank())
/*       */           setMaxRank(other.getMaxRank()); 
/*       */         if (this.awardBuilder_ == null) {
/*       */           if (!other.award_.isEmpty()) {
/*       */             if (this.award_.isEmpty()) {
/*       */               this.award_ = other.award_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureAwardIsMutable();
/*       */               this.award_.addAll(other.award_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.award_.isEmpty()) {
/*       */           if (this.awardBuilder_.isEmpty()) {
/*       */             this.awardBuilder_.dispose();
/*       */             this.awardBuilder_ = null;
/*       */             this.award_ = other.award_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.awardBuilder_ = ActivityRevelryHandler.RevelryConfigInfo.alwaysUseFieldBuilders ? getAwardFieldBuilder() : null;
/*       */           } else {
/*       */             this.awardBuilder_.addAllMessages(other.award_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasPlayer())
/*       */           mergePlayer(other.getPlayer()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       public final boolean isInitialized() {
/*       */         if (!hasMinRank())
/*       */           return false; 
/*       */         if (!hasMaxRank())
/*       */           return false; 
/*       */         for (int i = 0; i < getAwardCount(); i++) {
/*       */           if (!getAward(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         if (hasPlayer() && !getPlayer().isInitialized())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryConfigInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryConfigInfo)ActivityRevelryHandler.RevelryConfigInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryConfigInfo)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public boolean hasMinRank() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       public int getMinRank() {
/*       */         return this.minRank_;
/*       */       }
/*       */       public Builder setMinRank(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.minRank_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMinRank() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.minRank_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasMaxRank() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       public int getMaxRank() {
/*       */         return this.maxRank_;
/*       */       }
/*       */       public Builder setMaxRank(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.maxRank_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearMaxRank() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.maxRank_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       private void ensureAwardIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.award_ = new ArrayList<>(this.award_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       public List<ActivityRevelryHandler.RevelryAwardInfo> getAwardList() {
/*       */         if (this.awardBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.award_); 
/*       */         return this.awardBuilder_.getMessageList();
/*       */       }
/*       */       public int getAwardCount() {
/*       */         if (this.awardBuilder_ == null)
/*       */           return this.award_.size(); 
/*       */         return this.awardBuilder_.getCount();
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryAwardInfo getAward(int index) {
/*       */         if (this.awardBuilder_ == null)
/*       */           return this.award_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryAwardInfo)this.awardBuilder_.getMessage(index);
/*       */       }
/*       */       public Builder setAward(int index, ActivityRevelryHandler.RevelryAwardInfo value) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAwardIsMutable();
/*       */           this.award_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder setAward(int index, ActivityRevelryHandler.RevelryAwardInfo.Builder builderForValue) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           ensureAwardIsMutable();
/*       */           this.award_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAward(ActivityRevelryHandler.RevelryAwardInfo value) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAwardIsMutable();
/*       */           this.award_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAward(int index, ActivityRevelryHandler.RevelryAwardInfo value) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureAwardIsMutable();
/*       */           this.award_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAward(ActivityRevelryHandler.RevelryAwardInfo.Builder builderForValue) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           ensureAwardIsMutable();
/*       */           this.award_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAward(int index, ActivityRevelryHandler.RevelryAwardInfo.Builder builderForValue) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           ensureAwardIsMutable();
/*       */           this.award_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAllAward(Iterable<? extends ActivityRevelryHandler.RevelryAwardInfo> values) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           ensureAwardIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.award_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearAward() {
/*       */         if (this.awardBuilder_ == null) {
/*       */           this.award_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeAward(int index) {
/*       */         if (this.awardBuilder_ == null) {
/*       */           ensureAwardIsMutable();
/*       */           this.award_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.awardBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryAwardInfo.Builder getAwardBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryAwardInfo.Builder)getAwardFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryAwardInfoOrBuilder getAwardOrBuilder(int index) {
/*       */         if (this.awardBuilder_ == null)
/*       */           return this.award_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryAwardInfoOrBuilder)this.awardBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends ActivityRevelryHandler.RevelryAwardInfoOrBuilder> getAwardOrBuilderList() {
/*       */         if (this.awardBuilder_ != null)
/*       */           return this.awardBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.award_);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryAwardInfo.Builder addAwardBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryAwardInfo.Builder)getAwardFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryAwardInfo.getDefaultInstance());
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryAwardInfo.Builder addAwardBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryAwardInfo.Builder)getAwardFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryAwardInfo.getDefaultInstance());
/*       */       }
/*       */       public List<ActivityRevelryHandler.RevelryAwardInfo.Builder> getAwardBuilderList() {
/*       */         return getAwardFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryAwardInfo, ActivityRevelryHandler.RevelryAwardInfo.Builder, ActivityRevelryHandler.RevelryAwardInfoOrBuilder> getAwardFieldBuilder() {
/*       */         if (this.awardBuilder_ == null) {
/*       */           this.awardBuilder_ = new RepeatedFieldBuilder(this.award_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.award_ = null;
/*       */         } 
/*       */         return this.awardBuilder_;
/*       */       }
/*       */       public boolean hasPlayer() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfo getPlayer() {
/*       */         if (this.playerBuilder_ == null)
/*       */           return this.player_; 
/*       */         return (ActivityRevelryHandler.RevelryRankInfo)this.playerBuilder_.getMessage();
/*       */       }
/*       */       public Builder setPlayer(ActivityRevelryHandler.RevelryRankInfo value) {
/*       */         if (this.playerBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.player_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.playerBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x8;
/*       */         return this;
/*       */       }
/*       */       public Builder setPlayer(ActivityRevelryHandler.RevelryRankInfo.Builder builderForValue) {
/*       */         if (this.playerBuilder_ == null) {
/*       */           this.player_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.playerBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x8;
/*       */         return this;
/*       */       }
/*       */       public Builder mergePlayer(ActivityRevelryHandler.RevelryRankInfo value) {
/*       */         if (this.playerBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8 && this.player_ != ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance()) {
/*       */             this.player_ = ActivityRevelryHandler.RevelryRankInfo.newBuilder(this.player_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.player_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.playerBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x8;
/*       */         return this;
/*       */       }
/*       */       public Builder clearPlayer() {
/*       */         if (this.playerBuilder_ == null) {
/*       */           this.player_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.playerBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         return this;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfo.Builder getPlayerBuilder() {
/*       */         this.bitField0_ |= 0x8;
/*       */         onChanged();
/*       */         return (ActivityRevelryHandler.RevelryRankInfo.Builder)getPlayerFieldBuilder().getBuilder();
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRankInfoOrBuilder getPlayerOrBuilder() {
/*       */         if (this.playerBuilder_ != null)
/*       */           return (ActivityRevelryHandler.RevelryRankInfoOrBuilder)this.playerBuilder_.getMessageOrBuilder(); 
/*       */         return this.player_;
/*       */       }
/*       */       private SingleFieldBuilder<ActivityRevelryHandler.RevelryRankInfo, ActivityRevelryHandler.RevelryRankInfo.Builder, ActivityRevelryHandler.RevelryRankInfoOrBuilder> getPlayerFieldBuilder() {
/*       */         if (this.playerBuilder_ == null) {
/*       */           this.playerBuilder_ = new SingleFieldBuilder(getPlayer(), getParentForChildren(), isClean());
/*       */           this.player_ = null;
/*       */         } 
/*       */         return this.playerBuilder_;
/*       */       } } }
/* 10327 */   public static final class RevelryGetRankInfoRequest extends GeneratedMessage implements RevelryGetRankInfoRequestOrBuilder { private static final RevelryGetRankInfoRequest defaultInstance = new RevelryGetRankInfoRequest(true); private final UnknownFieldSet unknownFields; private RevelryGetRankInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryGetRankInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryGetRankInfoRequest getDefaultInstance() { return defaultInstance; } public RevelryGetRankInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryGetRankInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.id_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryGetRankInfoRequest.class, Builder.class); } public static Parser<RevelryGetRankInfoRequest> PARSER = (Parser<RevelryGetRankInfoRequest>)new AbstractParser<RevelryGetRankInfoRequest>() { public ActivityRevelryHandler.RevelryGetRankInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryGetRankInfoRequest(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private Object id_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryGetRankInfoRequest> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public String getId() { Object ref = this.id_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/* 10328 */         this.id_ = s;  return s; } public ByteString getIdBytes() { Object ref = this.id_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.id_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       this.id_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       if (!hasId()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         output.writeBytes(1, getIdBytes());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getIdBytes());
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(data);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(data);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(data, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseDelimitedFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryGetRankInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryGetRankInfoRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(RevelryGetRankInfoRequest prototype) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */       implements ActivityRevelryHandler.RevelryGetRankInfoRequestOrBuilder
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object id_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryGetRankInfoRequest.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.id_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.id_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         if (ActivityRevelryHandler.RevelryGetRankInfoRequest.alwaysUseFieldBuilders);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         this.id_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoRequest_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoRequest getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryGetRankInfoRequest.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoRequest build() {
/*       */         ActivityRevelryHandler.RevelryGetRankInfoRequest result = buildPartial();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoRequest buildPartial() {
/*       */         ActivityRevelryHandler.RevelryGetRankInfoRequest result = new ActivityRevelryHandler.RevelryGetRankInfoRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.id_ = this.id_;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         if (other instanceof ActivityRevelryHandler.RevelryGetRankInfoRequest) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryGetRankInfoRequest)other);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryGetRankInfoRequest other) {
/*       */         if (other == ActivityRevelryHandler.RevelryGetRankInfoRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.id_ = other.id_;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         if (!hasId()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         ActivityRevelryHandler.RevelryGetRankInfoRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetRankInfoRequest)ActivityRevelryHandler.RevelryGetRankInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetRankInfoRequest)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public String getId() {
/*       */         Object ref = this.id_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.id_ = s;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getIdBytes() {
/*       */         Object ref = this.id_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.id_ = b;
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setId(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = ActivityRevelryHandler.RevelryGetRankInfoRequest.getDefaultInstance().getId();
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setIdBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryGetRankInfoResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryGetRankInfoResponseOrBuilder
/*       */   {
/* 12073 */     private static final RevelryGetRankInfoResponse defaultInstance = new RevelryGetRankInfoResponse(true); private final UnknownFieldSet unknownFields; private RevelryGetRankInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryGetRankInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryGetRankInfoResponse getDefaultInstance() { return defaultInstance; } public RevelryGetRankInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryGetRankInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString byteString1; ActivityRevelryHandler.RevelryRankInfo.Builder subBuilder; ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: byteString1 = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = byteString1; break;case 24: this.bitField0_ |= 0x4; this.rankKey_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.config_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.config_.add(input.readMessage(ActivityRevelryHandler.RevelryConfigInfo.PARSER, extensionRegistry)); break;case 42: subBuilder = null; if ((this.bitField0_ & 0x8) == 8) subBuilder = this.self_.toBuilder();  this.self_ = (ActivityRevelryHandler.RevelryRankInfo)input.readMessage(ActivityRevelryHandler.RevelryRankInfo.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.self_); this.self_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x8; break;case 48: this.bitField0_ |= 0x10; this.selfRank_ = input.readInt32(); break;case 58: bs = input.readBytes(); this.bitField0_ |= 0x20; this.title_ = bs; break;case 64: this.bitField0_ |= 0x40; this.timeleft_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.config_ = Collections.unmodifiableList(this.config_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryGetRankInfoResponse.class, Builder.class); } public static Parser<RevelryGetRankInfoResponse> PARSER = (Parser<RevelryGetRankInfoResponse>)new AbstractParser<RevelryGetRankInfoResponse>() { public ActivityRevelryHandler.RevelryGetRankInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryGetRankInfoResponse(input, extensionRegistry); } }
/* 12074 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int RANKKEY_FIELD_NUMBER = 3; private int rankKey_; public static final int CONFIG_FIELD_NUMBER = 4; private List<ActivityRevelryHandler.RevelryConfigInfo> config_; public static final int SELF_FIELD_NUMBER = 5; private ActivityRevelryHandler.RevelryRankInfo self_; public static final int SELFRANK_FIELD_NUMBER = 6; private int selfRank_; public static final int TITLE_FIELD_NUMBER = 7; private Object title_; public static final int TIMELEFT_FIELD_NUMBER = 8; private int timeleft_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryGetRankInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasRankKey() { return ((this.bitField0_ & 0x4) == 4); } static { defaultInstance.initFields(); } public int getRankKey() { return this.rankKey_; } public List<ActivityRevelryHandler.RevelryConfigInfo> getConfigList() { return this.config_; } public List<? extends ActivityRevelryHandler.RevelryConfigInfoOrBuilder> getConfigOrBuilderList() { return (List)this.config_; } public int getConfigCount() { return this.config_.size(); } public ActivityRevelryHandler.RevelryConfigInfo getConfig(int index) { return this.config_.get(index); } public ActivityRevelryHandler.RevelryConfigInfoOrBuilder getConfigOrBuilder(int index) { return this.config_.get(index); } public boolean hasSelf() { return ((this.bitField0_ & 0x8) == 8); } public ActivityRevelryHandler.RevelryRankInfo getSelf() { return this.self_; } public ActivityRevelryHandler.RevelryRankInfoOrBuilder getSelfOrBuilder() { return this.self_; } public boolean hasSelfRank() { return ((this.bitField0_ & 0x10) == 16); } public int getSelfRank() { return this.selfRank_; } public boolean hasTitle() { return ((this.bitField0_ & 0x20) == 32); } public String getTitle() { Object ref = this.title_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.title_ = s; 
/*       */       return s; } public ByteString getTitleBytes() { Object ref = this.title_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.title_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; }
/*       */     public boolean hasTimeleft() { return ((this.bitField0_ & 0x40) == 64); }
/*       */     public int getTimeleft() { return this.timeleft_; }
/*       */     private void initFields() { this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.rankKey_ = 0;
/*       */       this.config_ = Collections.emptyList();
/*       */       this.self_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */       this.selfRank_ = 0;
/*       */       this.title_ = "";
/*       */       this.timeleft_ = 0; }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasRankKey()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getConfigCount(); i++) {
/*       */         if (!getConfig(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       if (hasSelf() && !getSelf().isInitialized()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(3, this.rankKey_); 
/*       */       for (int i = 0; i < this.config_.size(); i++)
/*       */         output.writeMessage(4, (MessageLite)this.config_.get(i)); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeMessage(5, (MessageLite)this.self_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeInt32(6, this.selfRank_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeBytes(7, getTitleBytes()); 
/*       */       if ((this.bitField0_ & 0x40) == 64)
/*       */         output.writeInt32(8, this.timeleft_); 
/*       */       getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.rankKey_); 
/*       */       for (int i = 0; i < this.config_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.config_.get(i)); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.self_); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.selfRank_); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeBytesSize(7, getTitleBytes()); 
/*       */       if ((this.bitField0_ & 0x40) == 64)
/*       */         size += CodedOutputStream.computeInt32Size(8, this.timeleft_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(InputStream input) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static RevelryGetRankInfoResponse parseDelimitedFrom(InputStream input) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static RevelryGetRankInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(CodedInputStream input) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryGetRankInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryGetRankInfoResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(RevelryGetRankInfoResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryGetRankInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private int rankKey_; private List<ActivityRevelryHandler.RevelryConfigInfo> config_; private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryConfigInfo, ActivityRevelryHandler.RevelryConfigInfo.Builder, ActivityRevelryHandler.RevelryConfigInfoOrBuilder> configBuilder_; private ActivityRevelryHandler.RevelryRankInfo self_; private SingleFieldBuilder<ActivityRevelryHandler.RevelryRankInfo, ActivityRevelryHandler.RevelryRankInfo.Builder, ActivityRevelryHandler.RevelryRankInfoOrBuilder> selfBuilder_; private int selfRank_; private Object title_; private int timeleft_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryGetRankInfoResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = "";
/*       */         this.config_ = Collections.emptyList();
/*       */         this.self_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         this.title_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.config_ = Collections.emptyList();
/*       */         this.self_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         this.title_ = "";
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryGetRankInfoResponse.alwaysUseFieldBuilders) {
/*       */           getConfigFieldBuilder();
/*       */           getSelfFieldBuilder();
/*       */         }  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.rankKey_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         if (this.configBuilder_ == null) {
/*       */           this.config_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */         } else {
/*       */           this.configBuilder_.clear();
/*       */         } 
/*       */         if (this.selfBuilder_ == null) {
/*       */           this.self_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */         } else {
/*       */           this.selfBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.selfRank_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.title_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.timeleft_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryGetRankInfoResponse_descriptor; }
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoResponse getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryGetRankInfoResponse.getDefaultInstance(); }
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoResponse build() { ActivityRevelryHandler.RevelryGetRankInfoResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public ActivityRevelryHandler.RevelryGetRankInfoResponse buildPartial() { ActivityRevelryHandler.RevelryGetRankInfoResponse result = new ActivityRevelryHandler.RevelryGetRankInfoResponse(this);
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
/*       */         result.rankKey_ = this.rankKey_;
/*       */         if (this.configBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x8) == 8) {
/*       */             this.config_ = Collections.unmodifiableList(this.config_);
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */           } 
/*       */           result.config_ = this.config_;
/*       */         } else {
/*       */           result.config_ = this.configBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x8; 
/*       */         if (this.selfBuilder_ == null) {
/*       */           result.self_ = this.self_;
/*       */         } else {
/*       */           result.self_ = (ActivityRevelryHandler.RevelryRankInfo)this.selfBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.selfRank_ = this.selfRank_;
/*       */         if ((from_bitField0_ & 0x40) == 64)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.title_ = this.title_;
/*       */         if ((from_bitField0_ & 0x80) == 128)
/*       */           to_bitField0_ |= 0x40; 
/*       */         result.timeleft_ = this.timeleft_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryGetRankInfoResponse)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryGetRankInfoResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryGetRankInfoResponse other) { if (other == ActivityRevelryHandler.RevelryGetRankInfoResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasRankKey())
/*       */           setRankKey(other.getRankKey()); 
/*       */         if (this.configBuilder_ == null) {
/*       */           if (!other.config_.isEmpty()) {
/*       */             if (this.config_.isEmpty()) {
/*       */               this.config_ = other.config_;
/*       */               this.bitField0_ &= 0xFFFFFFF7;
/*       */             } else {
/*       */               ensureConfigIsMutable();
/*       */               this.config_.addAll(other.config_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.config_.isEmpty()) {
/*       */           if (this.configBuilder_.isEmpty()) {
/*       */             this.configBuilder_.dispose();
/*       */             this.configBuilder_ = null;
/*       */             this.config_ = other.config_;
/*       */             this.bitField0_ &= 0xFFFFFFF7;
/*       */             this.configBuilder_ = ActivityRevelryHandler.RevelryGetRankInfoResponse.alwaysUseFieldBuilders ? getConfigFieldBuilder() : null;
/*       */           } else {
/*       */             this.configBuilder_.addAllMessages(other.config_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasSelf())
/*       */           mergeSelf(other.getSelf()); 
/*       */         if (other.hasSelfRank())
/*       */           setSelfRank(other.getSelfRank()); 
/*       */         if (other.hasTitle()) {
/*       */           this.bitField0_ |= 0x40;
/*       */           this.title_ = other.title_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasTimeleft())
/*       */           setTimeleft(other.getTimeleft()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         if (!hasRankKey())
/*       */           return false; 
/*       */         for (int i = 0; i < getConfigCount(); i++) {
/*       */           if (!getConfig(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         if (hasSelf() && !getSelf().isInitialized())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryGetRankInfoResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetRankInfoResponse)ActivityRevelryHandler.RevelryGetRankInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryGetRankInfoResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ActivityRevelryHandler.RevelryGetRankInfoResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasRankKey() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public int getRankKey() { return this.rankKey_; }
/*       */       public Builder setRankKey(int value) { this.bitField0_ |= 0x4;
/*       */         this.rankKey_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearRankKey() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.rankKey_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureConfigIsMutable() { if ((this.bitField0_ & 0x8) != 8) {
/*       */           this.config_ = new ArrayList<>(this.config_);
/*       */           this.bitField0_ |= 0x8;
/*       */         }  }
/*       */       public List<ActivityRevelryHandler.RevelryConfigInfo> getConfigList() { if (this.configBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.config_); 
/*       */         return this.configBuilder_.getMessageList(); }
/*       */       public int getConfigCount() { if (this.configBuilder_ == null)
/*       */           return this.config_.size(); 
/*       */         return this.configBuilder_.getCount(); }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo getConfig(int index) { if (this.configBuilder_ == null)
/*       */           return this.config_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryConfigInfo)this.configBuilder_.getMessage(index); }
/*       */       public Builder setConfig(int index, ActivityRevelryHandler.RevelryConfigInfo value) { if (this.configBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureConfigIsMutable();
/*       */           this.config_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setConfig(int index, ActivityRevelryHandler.RevelryConfigInfo.Builder builderForValue) { if (this.configBuilder_ == null) {
/*       */           ensureConfigIsMutable();
/*       */           this.config_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addConfig(ActivityRevelryHandler.RevelryConfigInfo value) { if (this.configBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureConfigIsMutable();
/*       */           this.config_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addConfig(int index, ActivityRevelryHandler.RevelryConfigInfo value) { if (this.configBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureConfigIsMutable();
/*       */           this.config_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addConfig(ActivityRevelryHandler.RevelryConfigInfo.Builder builderForValue) { if (this.configBuilder_ == null) {
/*       */           ensureConfigIsMutable();
/*       */           this.config_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addConfig(int index, ActivityRevelryHandler.RevelryConfigInfo.Builder builderForValue) { if (this.configBuilder_ == null) {
/*       */           ensureConfigIsMutable();
/*       */           this.config_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllConfig(Iterable<? extends ActivityRevelryHandler.RevelryConfigInfo> values) { if (this.configBuilder_ == null) {
/*       */           ensureConfigIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.config_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this; }
/*       */       public Builder clearConfig() { if (this.configBuilder_ == null) {
/*       */           this.config_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFF7;
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder removeConfig(int index) { if (this.configBuilder_ == null) {
/*       */           ensureConfigIsMutable();
/*       */           this.config_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.configBuilder_.remove(index);
/*       */         } 
/*       */         return this; }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo.Builder getConfigBuilder(int index) { return (ActivityRevelryHandler.RevelryConfigInfo.Builder)getConfigFieldBuilder().getBuilder(index); }
/*       */       public ActivityRevelryHandler.RevelryConfigInfoOrBuilder getConfigOrBuilder(int index) { if (this.configBuilder_ == null)
/*       */           return this.config_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryConfigInfoOrBuilder)this.configBuilder_.getMessageOrBuilder(index); }
/*       */       public List<? extends ActivityRevelryHandler.RevelryConfigInfoOrBuilder> getConfigOrBuilderList() { if (this.configBuilder_ != null)
/*       */           return this.configBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.config_); }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo.Builder addConfigBuilder() { return (ActivityRevelryHandler.RevelryConfigInfo.Builder)getConfigFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryConfigInfo.getDefaultInstance()); }
/*       */       public ActivityRevelryHandler.RevelryConfigInfo.Builder addConfigBuilder(int index) { return (ActivityRevelryHandler.RevelryConfigInfo.Builder)getConfigFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryConfigInfo.getDefaultInstance()); }
/*       */       public List<ActivityRevelryHandler.RevelryConfigInfo.Builder> getConfigBuilderList() { return getConfigFieldBuilder().getBuilderList(); }
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryConfigInfo, ActivityRevelryHandler.RevelryConfigInfo.Builder, ActivityRevelryHandler.RevelryConfigInfoOrBuilder> getConfigFieldBuilder() { if (this.configBuilder_ == null) {
/*       */           this.configBuilder_ = new RepeatedFieldBuilder(this.config_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
/*       */           this.config_ = null;
/*       */         } 
/*       */         return this.configBuilder_; }
/*       */       public boolean hasSelf() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public ActivityRevelryHandler.RevelryRankInfo getSelf() { if (this.selfBuilder_ == null)
/*       */           return this.self_; 
/*       */         return (ActivityRevelryHandler.RevelryRankInfo)this.selfBuilder_.getMessage(); }
/*       */       public Builder setSelf(ActivityRevelryHandler.RevelryRankInfo value) { if (this.selfBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           this.self_ = value;
/*       */           onChanged();
/*       */         } else {
/*       */           this.selfBuilder_.setMessage(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x10;
/*       */         return this; }
/*       */       public Builder setSelf(ActivityRevelryHandler.RevelryRankInfo.Builder builderForValue) { if (this.selfBuilder_ == null) {
/*       */           this.self_ = builderForValue.build();
/*       */           onChanged();
/*       */         } else {
/*       */           this.selfBuilder_.setMessage(builderForValue.build());
/*       */         } 
/*       */         this.bitField0_ |= 0x10;
/*       */         return this; }
/*       */       public Builder mergeSelf(ActivityRevelryHandler.RevelryRankInfo value) { if (this.selfBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x10) == 16 && this.self_ != ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance()) {
/*       */             this.self_ = ActivityRevelryHandler.RevelryRankInfo.newBuilder(this.self_).mergeFrom(value).buildPartial();
/*       */           } else {
/*       */             this.self_ = value;
/*       */           } 
/*       */           onChanged();
/*       */         } else {
/*       */           this.selfBuilder_.mergeFrom(value);
/*       */         } 
/*       */         this.bitField0_ |= 0x10;
/*       */         return this; }
/*       */       public Builder clearSelf() { if (this.selfBuilder_ == null) {
/*       */           this.self_ = ActivityRevelryHandler.RevelryRankInfo.getDefaultInstance();
/*       */           onChanged();
/*       */         } else {
/*       */           this.selfBuilder_.clear();
/*       */         } 
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         return this; }
/*       */       public ActivityRevelryHandler.RevelryRankInfo.Builder getSelfBuilder() { this.bitField0_ |= 0x10;
/*       */         onChanged();
/*       */         return (ActivityRevelryHandler.RevelryRankInfo.Builder)getSelfFieldBuilder().getBuilder(); }
/*       */       public ActivityRevelryHandler.RevelryRankInfoOrBuilder getSelfOrBuilder() { if (this.selfBuilder_ != null)
/*       */           return (ActivityRevelryHandler.RevelryRankInfoOrBuilder)this.selfBuilder_.getMessageOrBuilder(); 
/*       */         return this.self_; }
/*       */       private SingleFieldBuilder<ActivityRevelryHandler.RevelryRankInfo, ActivityRevelryHandler.RevelryRankInfo.Builder, ActivityRevelryHandler.RevelryRankInfoOrBuilder> getSelfFieldBuilder() { if (this.selfBuilder_ == null) {
/*       */           this.selfBuilder_ = new SingleFieldBuilder(getSelf(), getParentForChildren(), isClean());
/*       */           this.self_ = null;
/*       */         } 
/*       */         return this.selfBuilder_; }
/*       */       public boolean hasSelfRank() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public int getSelfRank() {
/*       */         return this.selfRank_;
/*       */       }
/*       */       public Builder setSelfRank(int value) {
/*       */         this.bitField0_ |= 0x20;
/*       */         this.selfRank_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearSelfRank() {
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.selfRank_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasTitle() {
/*       */         return ((this.bitField0_ & 0x40) == 64);
/*       */       }
/*       */       public String getTitle() {
/*       */         Object ref = this.title_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.title_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
/*       */       public ByteString getTitleBytes() {
/*       */         Object ref = this.title_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.title_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       }
/*       */       public Builder setTitle(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.title_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearTitle() {
/*       */         this.bitField0_ &= 0xFFFFFFBF;
/*       */         this.title_ = ActivityRevelryHandler.RevelryGetRankInfoResponse.getDefaultInstance().getTitle();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder setTitleBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x40;
/*       */         this.title_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasTimeleft() {
/*       */         return ((this.bitField0_ & 0x80) == 128);
/*       */       }
/*       */       public int getTimeleft() {
/*       */         return this.timeleft_;
/*       */       }
/*       */       public Builder setTimeleft(int value) {
/*       */         this.bitField0_ |= 0x80;
/*       */         this.timeleft_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearTimeleft() {
/*       */         this.bitField0_ &= 0xFFFFFF7F;
/*       */         this.timeleft_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/* 12636 */   public static final class RevelryExchangeRequest extends GeneratedMessage implements RevelryExchangeRequestOrBuilder { private static final RevelryExchangeRequest defaultInstance = new RevelryExchangeRequest(true); private final UnknownFieldSet unknownFields; private RevelryExchangeRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryExchangeRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryExchangeRequest getDefaultInstance() { return defaultInstance; } public RevelryExchangeRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryExchangeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.num_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryExchangeRequest.class, Builder.class); } public static Parser<RevelryExchangeRequest> PARSER = (Parser<RevelryExchangeRequest>)new AbstractParser<RevelryExchangeRequest>() { public ActivityRevelryHandler.RevelryExchangeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryExchangeRequest(input, extensionRegistry); } }
/* 12637 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int NUM_FIELD_NUMBER = 2; private int num_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryExchangeRequest> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasNum() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public int getNum() {
/*       */       return this.num_;
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.id_ = 0;
/*       */       this.num_ = 0;
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
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasNum()) {
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
/*       */         output.writeInt32(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.num_);
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
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_);
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.num_);
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
/*       */     public static RevelryExchangeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(data);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(input);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryExchangeRequest)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RevelryExchangeRequest prototype) {
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
/*       */       implements ActivityRevelryHandler.RevelryExchangeRequestOrBuilder
/*       */     {
/*       */       private int bitField0_;
/*       */ 
/*       */       
/*       */       private int id_;
/*       */ 
/*       */       
/*       */       private int num_;
/*       */ 
/*       */ 
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryExchangeRequest.class, Builder.class);
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
/*       */         if (ActivityRevelryHandler.RevelryExchangeRequest.alwaysUseFieldBuilders);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.num_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeRequest_descriptor;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryExchangeRequest getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryExchangeRequest.getDefaultInstance();
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryExchangeRequest build() {
/*       */         ActivityRevelryHandler.RevelryExchangeRequest result = buildPartial();
/*       */         if (!result.isInitialized()) {
/*       */           throw newUninitializedMessageException(result);
/*       */         }
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryExchangeRequest buildPartial() {
/*       */         ActivityRevelryHandler.RevelryExchangeRequest result = new ActivityRevelryHandler.RevelryExchangeRequest(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.id_ = this.id_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.num_ = this.num_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryExchangeRequest) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryExchangeRequest)other);
/*       */         }
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryExchangeRequest other) {
/*       */         if (other == ActivityRevelryHandler.RevelryExchangeRequest.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasId()) {
/*       */           setId(other.getId());
/*       */         }
/*       */         if (other.hasNum()) {
/*       */           setNum(other.getNum());
/*       */         }
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasId()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasNum()) {
/*       */           return false;
/*       */         }
/*       */         return true;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryExchangeRequest parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryExchangeRequest)ActivityRevelryHandler.RevelryExchangeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryExchangeRequest)e.getUnfinishedMessage();
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
/*       */       public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getId() {
/*       */         return this.id_;
/*       */       }
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
/*       */       public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasNum() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public int getNum() {
/*       */         return this.num_;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setNum(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.num_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearNum() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.num_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryExchangeResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryExchangeResponseOrBuilder
/*       */   {
/*       */     private final UnknownFieldSet unknownFields;
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryExchangeResponse(GeneratedMessage.Builder<?> builder) {
/*       */       super(builder);
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = builder.getUnknownFields();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryExchangeResponse(boolean noInit) {
/*       */       this.memoizedIsInitialized = -1;
/*       */       this.memoizedSerializedSize = -1;
/*       */       this.unknownFields = UnknownFieldSet.getDefaultInstance();
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryExchangeResponse getDefaultInstance() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public RevelryExchangeResponse getDefaultInstanceForType() {
/*       */       return defaultInstance;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public final UnknownFieldSet getUnknownFields() {
/*       */       return this.unknownFields;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     private RevelryExchangeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
/*       */ 
/*       */     
/*       */     public static final Descriptors.Descriptor getDescriptor() {
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeResponse_descriptor;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */       return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryExchangeResponse.class, Builder.class);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public static Parser<RevelryExchangeResponse> PARSER = (Parser<RevelryExchangeResponse>)new AbstractParser<RevelryExchangeResponse>()
/*       */       {
/*       */         public ActivityRevelryHandler.RevelryExchangeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */           return new ActivityRevelryHandler.RevelryExchangeResponse(input, extensionRegistry);
/*       */         }
/*       */       };
/*       */ 
/*       */ 
/*       */     
/*       */     private int bitField0_;
/*       */ 
/*       */     
/*       */     public static final int S2C_CODE_FIELD_NUMBER = 1;
/*       */ 
/*       */     
/*       */     private int s2CCode_;
/*       */ 
/*       */     
/*       */     public static final int S2C_MSG_FIELD_NUMBER = 2;
/*       */ 
/*       */     
/*       */     private Object s2CMsg_;
/*       */ 
/*       */     
/*       */     private byte memoizedIsInitialized;
/*       */ 
/*       */     
/*       */     private int memoizedSerializedSize;
/*       */ 
/*       */     
/*       */     private static final long serialVersionUID = 0L;
/*       */ 
/*       */ 
/*       */     
/*       */     public Parser<RevelryExchangeResponse> getParserForType() {
/*       */       return PARSER;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasS2CCode() {
/*       */       return ((this.bitField0_ & 0x1) == 1);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public int getS2CCode() {
/*       */       return this.s2CCode_;
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasS2CMsg() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     }
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
/* 13206 */     private static final RevelryExchangeResponse defaultInstance = new RevelryExchangeResponse(true); public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryExchangeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryExchangeResponse)PARSER.parseFrom(data); } public static RevelryExchangeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryExchangeResponse)PARSER.parseFrom(data, extensionRegistry); } public static RevelryExchangeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryExchangeResponse)PARSER.parseFrom(data); } public static RevelryExchangeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryExchangeResponse)PARSER.parseFrom(data, extensionRegistry); } public static RevelryExchangeResponse parseFrom(InputStream input) throws IOException { return (RevelryExchangeResponse)PARSER.parseFrom(input); } public static RevelryExchangeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryExchangeResponse)PARSER.parseFrom(input, extensionRegistry); } public static RevelryExchangeResponse parseDelimitedFrom(InputStream input) throws IOException { return (RevelryExchangeResponse)PARSER.parseDelimitedFrom(input); } public static RevelryExchangeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryExchangeResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryExchangeResponse parseFrom(CodedInputStream input) throws IOException { return (RevelryExchangeResponse)PARSER.parseFrom(input); } public static RevelryExchangeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryExchangeResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryExchangeResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryExchangeResponseOrBuilder {
/* 13207 */       private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryExchangeResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryExchangeResponse.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryExchangeResponse_descriptor; } public ActivityRevelryHandler.RevelryExchangeResponse getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryExchangeResponse.getDefaultInstance(); } public ActivityRevelryHandler.RevelryExchangeResponse build() { ActivityRevelryHandler.RevelryExchangeResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryExchangeResponse buildPartial() { ActivityRevelryHandler.RevelryExchangeResponse result = new ActivityRevelryHandler.RevelryExchangeResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryExchangeResponse) return mergeFrom((ActivityRevelryHandler.RevelryExchangeResponse)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryExchangeResponse other) { if (other == ActivityRevelryHandler.RevelryExchangeResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryExchangeResponse parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryExchangeResponse)ActivityRevelryHandler.RevelryExchangeResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryExchangeResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; } public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = ActivityRevelryHandler.RevelryExchangeResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; } public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class RevelryRechargeColumn
/*       */     extends GeneratedMessage
/*       */     implements RevelryRechargeColumnOrBuilder
/*       */   {
/* 13784 */     private static final RevelryRechargeColumn defaultInstance = new RevelryRechargeColumn(true); private final UnknownFieldSet unknownFields; private RevelryRechargeColumn(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeColumn(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeColumn getDefaultInstance() { return defaultInstance; } public RevelryRechargeColumn getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeColumn(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.day_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.name_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeColumn_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeColumn_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeColumn.class, Builder.class); } public static Parser<RevelryRechargeColumn> PARSER = (Parser<RevelryRechargeColumn>)new AbstractParser<RevelryRechargeColumn>() { public ActivityRevelryHandler.RevelryRechargeColumn parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeColumn(input, extensionRegistry); } }
/* 13785 */     ; private int bitField0_; public static final int DAY_FIELD_NUMBER = 1; private int day_; public static final int NAME_FIELD_NUMBER = 2; private Object name_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeColumn> getParserForType() { return PARSER; } public boolean hasDay() { return ((this.bitField0_ & 0x1) == 1); } public int getDay() { return this.day_; } public boolean hasName() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); }
/*       */     
/*       */     public String getName() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.name_ = s; 
/*       */       return s;
/*       */     }
/*       */     public ByteString getNameBytes() {
/*       */       Object ref = this.name_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.name_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref;
/*       */     }
/*       */     private void initFields() {
/*       */       this.day_ = 0;
/*       */       this.name_ = "";
/*       */     }
/*       */     public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasDay()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasName()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     }
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.day_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getNameBytes()); 
/*       */       getUnknownFields().writeTo(output);
/*       */     }
/*       */     
/*       */     public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.day_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getNameBytes()); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     }
/*       */     
/*       */     protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(data);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(data, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseDelimitedFrom(input);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(input);
/*       */     }
/*       */     
/*       */     public static RevelryRechargeColumn parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeColumn)PARSER.parseFrom(input, extensionRegistry);
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
/*       */     public static Builder newBuilder(RevelryRechargeColumn prototype) {
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
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeColumnOrBuilder { private int bitField0_;
/*       */       private int day_;
/*       */       private Object name_;
/*       */       
/*       */       public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeColumn_descriptor;
/*       */       }
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeColumn_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeColumn.class, Builder.class);
/*       */       }
/*       */       
/*       */       private Builder() {
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.name_ = "";
/*       */         maybeForceBuilderInitialization();
/*       */       }
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryRechargeColumn.alwaysUseFieldBuilders);
/*       */       }
/*       */       
/*       */       private static Builder create() {
/*       */         return new Builder();
/*       */       }
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.day_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.name_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       }
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeColumn_descriptor;
/*       */       }
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryRechargeColumn.getDefaultInstance();
/*       */       }
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn build() {
/*       */         ActivityRevelryHandler.RevelryRechargeColumn result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       }
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn buildPartial() {
/*       */         ActivityRevelryHandler.RevelryRechargeColumn result = new ActivityRevelryHandler.RevelryRechargeColumn(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.day_ = this.day_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.name_ = this.name_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryRechargeColumn)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeColumn)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeColumn other) {
/*       */         if (other == ActivityRevelryHandler.RevelryRechargeColumn.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasDay())
/*       */           setDay(other.getDay()); 
/*       */         if (other.hasName()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.name_ = other.name_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       }
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasDay())
/*       */           return false; 
/*       */         if (!hasName())
/*       */           return false; 
/*       */         return true;
/*       */       }
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryRechargeColumn parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeColumn)ActivityRevelryHandler.RevelryRechargeColumn.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeColumn)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasDay() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       }
/*       */       
/*       */       public int getDay() {
/*       */         return this.day_;
/*       */       }
/*       */       
/*       */       public Builder setDay(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.day_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearDay() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.day_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public boolean hasName() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       }
/*       */       
/*       */       public String getName() {
/*       */         Object ref = this.name_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.name_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       }
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
/*       */       public Builder setName(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder clearName() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.name_ = ActivityRevelryHandler.RevelryRechargeColumn.getDefaultInstance().getName();
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       
/*       */       public Builder setNameBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.name_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/*       */   
/* 14105 */   public static final class RevelryRechargeGetColumnRequest extends GeneratedMessage implements RevelryRechargeGetColumnRequestOrBuilder { private static final RevelryRechargeGetColumnRequest defaultInstance = new RevelryRechargeGetColumnRequest(true); private final UnknownFieldSet unknownFields; private RevelryRechargeGetColumnRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeGetColumnRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeGetColumnRequest getDefaultInstance() { return defaultInstance; } public RevelryRechargeGetColumnRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeGetColumnRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; continue; }  if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeGetColumnRequest.class, Builder.class); } public static Parser<RevelryRechargeGetColumnRequest> PARSER = (Parser<RevelryRechargeGetColumnRequest>)new AbstractParser<RevelryRechargeGetColumnRequest>() { public ActivityRevelryHandler.RevelryRechargeGetColumnRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeGetColumnRequest(input, extensionRegistry); } }; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeGetColumnRequest> getParserForType() { return PARSER; } private void initFields() {} public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryRechargeGetColumnRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(data); } public static RevelryRechargeGetColumnRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeGetColumnRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(data); } public static RevelryRechargeGetColumnRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeGetColumnRequest parseFrom(InputStream input) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(input); } public static RevelryRechargeGetColumnRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(input, extensionRegistry); } public static RevelryRechargeGetColumnRequest parseDelimitedFrom(InputStream input) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseDelimitedFrom(input); } public static RevelryRechargeGetColumnRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryRechargeGetColumnRequest parseFrom(CodedInputStream input) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(input); } public static RevelryRechargeGetColumnRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryRechargeGetColumnRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeGetColumnRequestOrBuilder {
/* 14106 */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeGetColumnRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryRechargeGetColumnRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_descriptor; } public ActivityRevelryHandler.RevelryRechargeGetColumnRequest getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryRechargeGetColumnRequest.getDefaultInstance(); } public ActivityRevelryHandler.RevelryRechargeGetColumnRequest build() { ActivityRevelryHandler.RevelryRechargeGetColumnRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryRechargeGetColumnRequest buildPartial() { ActivityRevelryHandler.RevelryRechargeGetColumnRequest result = new ActivityRevelryHandler.RevelryRechargeGetColumnRequest(this); onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryRechargeGetColumnRequest) return mergeFrom((ActivityRevelryHandler.RevelryRechargeGetColumnRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeGetColumnRequest other) { if (other == ActivityRevelryHandler.RevelryRechargeGetColumnRequest.getDefaultInstance()) return this;  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryRechargeGetColumnRequest parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetColumnRequest)ActivityRevelryHandler.RevelryRechargeGetColumnRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetColumnRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } } static { defaultInstance.initFields(); }
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryRechargeGetColumnResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryRechargeGetColumnResponseOrBuilder
/*       */   {
/* 15652 */     private static final RevelryRechargeGetColumnResponse defaultInstance = new RevelryRechargeGetColumnResponse(true); private final UnknownFieldSet unknownFields; private RevelryRechargeGetColumnResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeGetColumnResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeGetColumnResponse getDefaultInstance() { return defaultInstance; } public RevelryRechargeGetColumnResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeGetColumnResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.beginTime_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.endTime_ = bs; break;case 42: bs = input.readBytes(); this.bitField0_ |= 0x10; this.describe_ = bs; break;case 48: this.bitField0_ |= 0x20; this.today_ = input.readInt32(); break;case 58: if ((mutable_bitField0_ & 0x40) != 64) { this.column_ = new ArrayList<>(); mutable_bitField0_ |= 0x40; }  this.column_.add(input.readMessage(ActivityRevelryHandler.RevelryRechargeColumn.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x40) == 64) this.column_ = Collections.unmodifiableList(this.column_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeGetColumnResponse.class, Builder.class); } public static Parser<RevelryRechargeGetColumnResponse> PARSER = (Parser<RevelryRechargeGetColumnResponse>)new AbstractParser<RevelryRechargeGetColumnResponse>() { public ActivityRevelryHandler.RevelryRechargeGetColumnResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeGetColumnResponse(input, extensionRegistry); } }
/* 15653 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int BEGINTIME_FIELD_NUMBER = 3; private Object beginTime_; public static final int ENDTIME_FIELD_NUMBER = 4; private Object endTime_; public static final int DESCRIBE_FIELD_NUMBER = 5; private Object describe_; public static final int TODAY_FIELD_NUMBER = 6; private int today_; public static final int COLUMN_FIELD_NUMBER = 7; private List<ActivityRevelryHandler.RevelryRechargeColumn> column_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeGetColumnResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } public boolean hasBeginTime() { return ((this.bitField0_ & 0x4) == 4); } static { defaultInstance.initFields(); } public String getBeginTime() { Object ref = this.beginTime_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.beginTime_ = s; 
/*       */       return s; } public ByteString getBeginTimeBytes() { Object ref = this.beginTime_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.beginTime_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasEndTime() { return ((this.bitField0_ & 0x8) == 8); } public String getEndTime() { Object ref = this.endTime_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.endTime_ = s; 
/*       */       return s; } public ByteString getEndTimeBytes() { Object ref = this.endTime_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.endTime_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasDescribe() { return ((this.bitField0_ & 0x10) == 16); } public String getDescribe() { Object ref = this.describe_;
/*       */       if (ref instanceof String)
/*       */         return (String)ref; 
/*       */       ByteString bs = (ByteString)ref;
/*       */       String s = bs.toStringUtf8();
/*       */       if (bs.isValidUtf8())
/*       */         this.describe_ = s; 
/*       */       return s; } public ByteString getDescribeBytes() { Object ref = this.describe_;
/*       */       if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */         this.describe_ = b;
/*       */         return b;
/*       */       } 
/*       */       return (ByteString)ref; } public boolean hasToday() { return ((this.bitField0_ & 0x20) == 32); } public int getToday() { return this.today_; } public List<ActivityRevelryHandler.RevelryRechargeColumn> getColumnList() { return this.column_; }
/*       */     public List<? extends ActivityRevelryHandler.RevelryRechargeColumnOrBuilder> getColumnOrBuilderList() { return (List)this.column_; }
/*       */     public int getColumnCount() { return this.column_.size(); }
/*       */     public ActivityRevelryHandler.RevelryRechargeColumn getColumn(int index) { return this.column_.get(index); }
/*       */     public ActivityRevelryHandler.RevelryRechargeColumnOrBuilder getColumnOrBuilder(int index) { return this.column_.get(index); }
/*       */     private void initFields() { this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.beginTime_ = "";
/*       */       this.endTime_ = "";
/*       */       this.describe_ = "";
/*       */       this.today_ = 0;
/*       */       this.column_ = Collections.emptyList(); }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasBeginTime()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasEndTime()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasDescribe()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getColumnCount(); i++) {
/*       */         if (!getColumn(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeBytes(3, getBeginTimeBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeBytes(4, getEndTimeBytes()); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         output.writeBytes(5, getDescribeBytes()); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         output.writeInt32(6, this.today_); 
/*       */       for (int i = 0; i < this.column_.size(); i++)
/*       */         output.writeMessage(7, (MessageLite)this.column_.get(i)); 
/*       */       getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes()); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeBytesSize(3, getBeginTimeBytes()); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeBytesSize(4, getEndTimeBytes()); 
/*       */       if ((this.bitField0_ & 0x10) == 16)
/*       */         size += CodedOutputStream.computeBytesSize(5, getDescribeBytes()); 
/*       */       if ((this.bitField0_ & 0x20) == 32)
/*       */         size += CodedOutputStream.computeInt32Size(6, this.today_); 
/*       */       for (int i = 0; i < this.column_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(7, (MessageLite)this.column_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(InputStream input) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static RevelryRechargeGetColumnResponse parseDelimitedFrom(InputStream input) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static RevelryRechargeGetColumnResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(CodedInputStream input) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryRechargeGetColumnResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetColumnResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(RevelryRechargeGetColumnResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent);
/*       */       return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeGetColumnResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private Object beginTime_; private Object endTime_; private Object describe_; private int today_; private List<ActivityRevelryHandler.RevelryRechargeColumn> column_; private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeColumn, ActivityRevelryHandler.RevelryRechargeColumn.Builder, ActivityRevelryHandler.RevelryRechargeColumnOrBuilder> columnBuilder_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeGetColumnResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = "";
/*       */         this.beginTime_ = "";
/*       */         this.endTime_ = "";
/*       */         this.describe_ = "";
/*       */         this.column_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.beginTime_ = "";
/*       */         this.endTime_ = "";
/*       */         this.describe_ = "";
/*       */         this.column_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryRechargeGetColumnResponse.alwaysUseFieldBuilders)
/*       */           getColumnFieldBuilder();  }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.beginTime_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.endTime_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.describe_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.today_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFDF;
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.column_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */         } else {
/*       */           this.columnBuilder_.clear();
/*       */         } 
/*       */         return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_descriptor; }
/*       */       public ActivityRevelryHandler.RevelryRechargeGetColumnResponse getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance(); }
/*       */       public ActivityRevelryHandler.RevelryRechargeGetColumnResponse build() { ActivityRevelryHandler.RevelryRechargeGetColumnResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result; }
/*       */       public ActivityRevelryHandler.RevelryRechargeGetColumnResponse buildPartial() { ActivityRevelryHandler.RevelryRechargeGetColumnResponse result = new ActivityRevelryHandler.RevelryRechargeGetColumnResponse(this);
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
/*       */         result.beginTime_ = this.beginTime_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.endTime_ = this.endTime_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x10; 
/*       */         result.describe_ = this.describe_;
/*       */         if ((from_bitField0_ & 0x20) == 32)
/*       */           to_bitField0_ |= 0x20; 
/*       */         result.today_ = this.today_;
/*       */         if (this.columnBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x40) == 64) {
/*       */             this.column_ = Collections.unmodifiableList(this.column_);
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */           } 
/*       */           result.column_ = this.column_;
/*       */         } else {
/*       */           result.column_ = this.columnBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryRechargeGetColumnResponse)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeGetColumnResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this; }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeGetColumnResponse other) { if (other == ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasBeginTime()) {
/*       */           this.bitField0_ |= 0x4;
/*       */           this.beginTime_ = other.beginTime_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasEndTime()) {
/*       */           this.bitField0_ |= 0x8;
/*       */           this.endTime_ = other.endTime_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasDescribe()) {
/*       */           this.bitField0_ |= 0x10;
/*       */           this.describe_ = other.describe_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasToday())
/*       */           setToday(other.getToday()); 
/*       */         if (this.columnBuilder_ == null) {
/*       */           if (!other.column_.isEmpty()) {
/*       */             if (this.column_.isEmpty()) {
/*       */               this.column_ = other.column_;
/*       */               this.bitField0_ &= 0xFFFFFFBF;
/*       */             } else {
/*       */               ensureColumnIsMutable();
/*       */               this.column_.addAll(other.column_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.column_.isEmpty()) {
/*       */           if (this.columnBuilder_.isEmpty()) {
/*       */             this.columnBuilder_.dispose();
/*       */             this.columnBuilder_ = null;
/*       */             this.column_ = other.column_;
/*       */             this.bitField0_ &= 0xFFFFFFBF;
/*       */             this.columnBuilder_ = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.alwaysUseFieldBuilders ? getColumnFieldBuilder() : null;
/*       */           } else {
/*       */             this.columnBuilder_.addAllMessages(other.column_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         if (!hasBeginTime())
/*       */           return false; 
/*       */         if (!hasEndTime())
/*       */           return false; 
/*       */         if (!hasDescribe())
/*       */           return false; 
/*       */         for (int i = 0; i < getColumnCount(); i++) {
/*       */           if (!getColumn(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryRechargeGetColumnResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetColumnResponse)ActivityRevelryHandler.RevelryRechargeGetColumnResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetColumnResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasBeginTime() { return ((this.bitField0_ & 0x4) == 4); }
/*       */       public String getBeginTime() { Object ref = this.beginTime_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.beginTime_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getBeginTimeBytes() { Object ref = this.beginTime_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.beginTime_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setBeginTime(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.beginTime_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearBeginTime() { this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.beginTime_ = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance().getBeginTime();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setBeginTimeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x4;
/*       */         this.beginTime_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasEndTime() { return ((this.bitField0_ & 0x8) == 8); }
/*       */       public String getEndTime() { Object ref = this.endTime_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.endTime_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getEndTimeBytes() { Object ref = this.endTime_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.endTime_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setEndTime(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.endTime_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearEndTime() { this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.endTime_ = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance().getEndTime();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setEndTimeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x8;
/*       */         this.endTime_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasDescribe() { return ((this.bitField0_ & 0x10) == 16); }
/*       */       public String getDescribe() { Object ref = this.describe_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.describe_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref; }
/*       */       public ByteString getDescribeBytes() { Object ref = this.describe_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.describe_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref; }
/*       */       public Builder setDescribe(String value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.describe_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearDescribe() { this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.describe_ = ActivityRevelryHandler.RevelryRechargeGetColumnResponse.getDefaultInstance().getDescribe();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setDescribeBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x10;
/*       */         this.describe_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public boolean hasToday() { return ((this.bitField0_ & 0x20) == 32); }
/*       */       public int getToday() { return this.today_; }
/*       */       public Builder setToday(int value) { this.bitField0_ |= 0x20;
/*       */         this.today_ = value;
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder clearToday() { this.bitField0_ &= 0xFFFFFFDF;
/*       */         this.today_ = 0;
/*       */         onChanged();
/*       */         return this; }
/*       */       private void ensureColumnIsMutable() { if ((this.bitField0_ & 0x40) != 64) {
/*       */           this.column_ = new ArrayList<>(this.column_);
/*       */           this.bitField0_ |= 0x40;
/*       */         }  }
/*       */       public List<ActivityRevelryHandler.RevelryRechargeColumn> getColumnList() { if (this.columnBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.column_); 
/*       */         return this.columnBuilder_.getMessageList(); }
/*       */       public int getColumnCount() { if (this.columnBuilder_ == null)
/*       */           return this.column_.size(); 
/*       */         return this.columnBuilder_.getCount(); }
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn getColumn(int index) { if (this.columnBuilder_ == null)
/*       */           return this.column_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeColumn)this.columnBuilder_.getMessage(index); }
/*       */       public Builder setColumn(int index, ActivityRevelryHandler.RevelryRechargeColumn value) { if (this.columnBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureColumnIsMutable();
/*       */           this.column_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder setColumn(int index, ActivityRevelryHandler.RevelryRechargeColumn.Builder builderForValue) { if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addColumn(ActivityRevelryHandler.RevelryRechargeColumn value) { if (this.columnBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addColumn(int index, ActivityRevelryHandler.RevelryRechargeColumn value) { if (this.columnBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this; }
/*       */       public Builder addColumn(ActivityRevelryHandler.RevelryRechargeColumn.Builder builderForValue) { if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addColumn(int index, ActivityRevelryHandler.RevelryRechargeColumn.Builder builderForValue) { if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this; }
/*       */       public Builder addAllColumn(Iterable<? extends ActivityRevelryHandler.RevelryRechargeColumn> values) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.column_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearColumn() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.column_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFBF;
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeColumn(int index) {
/*       */         if (this.columnBuilder_ == null) {
/*       */           ensureColumnIsMutable();
/*       */           this.column_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.columnBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn.Builder getColumnBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeColumn.Builder)getColumnFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeColumnOrBuilder getColumnOrBuilder(int index) {
/*       */         if (this.columnBuilder_ == null)
/*       */           return this.column_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeColumnOrBuilder)this.columnBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends ActivityRevelryHandler.RevelryRechargeColumnOrBuilder> getColumnOrBuilderList() {
/*       */         if (this.columnBuilder_ != null)
/*       */           return this.columnBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.column_);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn.Builder addColumnBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryRechargeColumn.Builder)getColumnFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryRechargeColumn.getDefaultInstance());
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeColumn.Builder addColumnBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeColumn.Builder)getColumnFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryRechargeColumn.getDefaultInstance());
/*       */       }
/*       */       public List<ActivityRevelryHandler.RevelryRechargeColumn.Builder> getColumnBuilderList() {
/*       */         return getColumnFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeColumn, ActivityRevelryHandler.RevelryRechargeColumn.Builder, ActivityRevelryHandler.RevelryRechargeColumnOrBuilder> getColumnFieldBuilder() {
/*       */         if (this.columnBuilder_ == null) {
/*       */           this.columnBuilder_ = new RepeatedFieldBuilder(this.column_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
/*       */           this.column_ = null;
/*       */         } 
/*       */         return this.columnBuilder_;
/*       */       } } }
/* 16222 */   public static final class RevelryRechargeItem extends GeneratedMessage implements RevelryRechargeItemOrBuilder { private static final RevelryRechargeItem defaultInstance = new RevelryRechargeItem(true); private final UnknownFieldSet unknownFields; private RevelryRechargeItem(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeItem(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeItem getDefaultInstance() { return defaultInstance; } public RevelryRechargeItem getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: bs = input.readBytes(); this.bitField0_ |= 0x1; this.code_ = bs; break;case 16: this.bitField0_ |= 0x2; this.groupCount_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeItem_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeItem.class, Builder.class); } public static Parser<RevelryRechargeItem> PARSER = (Parser<RevelryRechargeItem>)new AbstractParser<RevelryRechargeItem>() { public ActivityRevelryHandler.RevelryRechargeItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeItem(input, extensionRegistry); } }
/* 16223 */     ; private int bitField0_; public static final int CODE_FIELD_NUMBER = 1; private Object code_; public static final int GROUPCOUNT_FIELD_NUMBER = 2; private int groupCount_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeItem> getParserForType() { return PARSER; } public boolean hasCode() { return ((this.bitField0_ & 0x1) == 1); } public String getCode() { Object ref = this.code_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.code_ = s;  return s; } public ByteString getCodeBytes() { Object ref = this.code_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.code_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public boolean hasGroupCount() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public int getGroupCount() {
/*       */       return this.groupCount_;
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
/*       */ 
/*       */ 
/*       */     
/*       */     private void initFields() {
/*       */       this.code_ = "";
/*       */       this.groupCount_ = 0;
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
/*       */       if (!hasCode()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasGroupCount()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1) {
/*       */         output.writeBytes(1, getCodeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         output.writeInt32(2, this.groupCount_);
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
/*       */         size += CodedOutputStream.computeBytesSize(1, getCodeBytes());
/*       */       }
/*       */       if ((this.bitField0_ & 0x2) == 2) {
/*       */         size += CodedOutputStream.computeInt32Size(2, this.groupCount_);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(data);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(data, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(data);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(data, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseDelimitedFrom(input);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseDelimitedFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(input);
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
/*       */ 
/*       */ 
/*       */     
/*       */     public static RevelryRechargeItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeItem)PARSER.parseFrom(input, extensionRegistry);
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static Builder newBuilder(RevelryRechargeItem prototype) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public static final class Builder
/*       */       extends GeneratedMessage.Builder<Builder>
/*       */       implements ActivityRevelryHandler.RevelryRechargeItemOrBuilder
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Object code_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private int groupCount_;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
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
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeItem_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeItem.class, Builder.class);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder() {
/*       */         this.code_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.code_ = "";
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryRechargeItem.alwaysUseFieldBuilders);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clear() {
/*       */         super.clear();
/*       */         this.code_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.groupCount_ = 0;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeItem_descriptor;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeItem getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryRechargeItem.getDefaultInstance();
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeItem build() {
/*       */         ActivityRevelryHandler.RevelryRechargeItem result = buildPartial();
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public ActivityRevelryHandler.RevelryRechargeItem buildPartial() {
/*       */         ActivityRevelryHandler.RevelryRechargeItem result = new ActivityRevelryHandler.RevelryRechargeItem(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1) {
/*       */           to_bitField0_ |= 0x1;
/*       */         }
/*       */         result.code_ = this.code_;
/*       */         if ((from_bitField0_ & 0x2) == 2) {
/*       */           to_bitField0_ |= 0x2;
/*       */         }
/*       */         result.groupCount_ = this.groupCount_;
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryRechargeItem) {
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeItem)other);
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeItem other) {
/*       */         if (other == ActivityRevelryHandler.RevelryRechargeItem.getDefaultInstance()) {
/*       */           return this;
/*       */         }
/*       */         if (other.hasCode()) {
/*       */           this.bitField0_ |= 0x1;
/*       */           this.code_ = other.code_;
/*       */           onChanged();
/*       */         } 
/*       */         if (other.hasGroupCount()) {
/*       */           setGroupCount(other.getGroupCount());
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public final boolean isInitialized() {
/*       */         if (!hasCode()) {
/*       */           return false;
/*       */         }
/*       */         if (!hasGroupCount()) {
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
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryRechargeItem parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeItem)ActivityRevelryHandler.RevelryRechargeItem.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeItem)e.getUnfinishedMessage();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasCode() {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public String getCode() {
/*       */         Object ref = this.code_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8()) {
/*       */             this.code_ = s;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public ByteString getCodeBytes() {
/*       */         Object ref = this.code_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.code_ = b;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCode(String value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.code_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.code_ = ActivityRevelryHandler.RevelryRechargeItem.getDefaultInstance().getCode();
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setCodeBytes(ByteString value) {
/*       */         if (value == null) {
/*       */           throw new NullPointerException();
/*       */         }
/*       */         this.bitField0_ |= 0x1;
/*       */         this.code_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public boolean hasGroupCount() {
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
/*       */ 
/*       */ 
/*       */       
/*       */       public int getGroupCount() {
/*       */         return this.groupCount_;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder setGroupCount(int value) {
/*       */         this.bitField0_ |= 0x2;
/*       */         this.groupCount_ = value;
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
/*       */ 
/*       */ 
/*       */       
/*       */       public Builder clearGroupCount() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.groupCount_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public static final class RevelryRechargeAwardInfo
/*       */     extends GeneratedMessage
/*       */     implements RevelryRechargeAwardInfoOrBuilder
/*       */   {
/* 17385 */     private static final RevelryRechargeAwardInfo defaultInstance = new RevelryRechargeAwardInfo(true); private final UnknownFieldSet unknownFields; private RevelryRechargeAwardInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeAwardInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeAwardInfo getDefaultInstance() { return defaultInstance; } public RevelryRechargeAwardInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeAwardInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 18: if ((mutable_bitField0_ & 0x2) != 2) { this.item_ = new ArrayList<>(); mutable_bitField0_ |= 0x2; }  this.item_.add(input.readMessage(ActivityRevelryHandler.RevelryRechargeItem.PARSER, extensionRegistry)); break;case 24: this.bitField0_ |= 0x2; this.state_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x4; this.currNum_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x8; this.needNum_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x2) == 2) this.item_ = Collections.unmodifiableList(this.item_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeAwardInfo.class, Builder.class); } public static Parser<RevelryRechargeAwardInfo> PARSER = (Parser<RevelryRechargeAwardInfo>)new AbstractParser<RevelryRechargeAwardInfo>() { public ActivityRevelryHandler.RevelryRechargeAwardInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeAwardInfo(input, extensionRegistry); } }
/* 17386 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int ITEM_FIELD_NUMBER = 2; private List<ActivityRevelryHandler.RevelryRechargeItem> item_; public static final int STATE_FIELD_NUMBER = 3; private int state_; public static final int CURRNUM_FIELD_NUMBER = 4; private int currNum_; public static final int NEEDNUM_FIELD_NUMBER = 5; private int needNum_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeAwardInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public List<ActivityRevelryHandler.RevelryRechargeItem> getItemList() { return this.item_; } public List<? extends ActivityRevelryHandler.RevelryRechargeItemOrBuilder> getItemOrBuilderList() { return (List)this.item_; } static { defaultInstance.initFields(); }
/*       */      public int getItemCount() {
/*       */       return this.item_.size();
/*       */     } public ActivityRevelryHandler.RevelryRechargeItem getItem(int index) {
/*       */       return this.item_.get(index);
/*       */     } public ActivityRevelryHandler.RevelryRechargeItemOrBuilder getItemOrBuilder(int index) {
/*       */       return this.item_.get(index);
/*       */     } public boolean hasState() {
/*       */       return ((this.bitField0_ & 0x2) == 2);
/*       */     } public int getState() {
/*       */       return this.state_;
/*       */     } public boolean hasCurrNum() {
/*       */       return ((this.bitField0_ & 0x4) == 4);
/*       */     } public int getCurrNum() {
/*       */       return this.currNum_;
/*       */     } public boolean hasNeedNum() {
/*       */       return ((this.bitField0_ & 0x8) == 8);
/*       */     } public int getNeedNum() {
/*       */       return this.needNum_;
/*       */     } private void initFields() {
/*       */       this.id_ = 0;
/*       */       this.item_ = Collections.emptyList();
/*       */       this.state_ = 0;
/*       */       this.currNum_ = 0;
/*       */       this.needNum_ = 0;
/*       */     } public final boolean isInitialized() {
/*       */       byte isInitialized = this.memoizedIsInitialized;
/*       */       if (isInitialized == 1)
/*       */         return true; 
/*       */       if (isInitialized == 0)
/*       */         return false; 
/*       */       if (!hasId()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasState()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasCurrNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       if (!hasNeedNum()) {
/*       */         this.memoizedIsInitialized = 0;
/*       */         return false;
/*       */       } 
/*       */       for (int i = 0; i < getItemCount(); i++) {
/*       */         if (!getItem(i).isInitialized()) {
/*       */           this.memoizedIsInitialized = 0;
/*       */           return false;
/*       */         } 
/*       */       } 
/*       */       this.memoizedIsInitialized = 1;
/*       */       return true;
/*       */     } public void writeTo(CodedOutputStream output) throws IOException {
/*       */       getSerializedSize();
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.id_); 
/*       */       for (int i = 0; i < this.item_.size(); i++)
/*       */         output.writeMessage(2, (MessageLite)this.item_.get(i)); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeInt32(3, this.state_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         output.writeInt32(4, this.currNum_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         output.writeInt32(5, this.needNum_); 
/*       */       getUnknownFields().writeTo(output);
/*       */     } public int getSerializedSize() {
/*       */       int size = this.memoizedSerializedSize;
/*       */       if (size != -1)
/*       */         return size; 
/*       */       size = 0;
/*       */       if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.id_); 
/*       */       for (int i = 0; i < this.item_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.item_.get(i)); 
/*       */       if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeInt32Size(3, this.state_); 
/*       */       if ((this.bitField0_ & 0x4) == 4)
/*       */         size += CodedOutputStream.computeInt32Size(4, this.currNum_); 
/*       */       if ((this.bitField0_ & 0x8) == 8)
/*       */         size += CodedOutputStream.computeInt32Size(5, this.needNum_); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static RevelryRechargeAwardInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(data);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(data);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(input);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static RevelryRechargeAwardInfo parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseDelimitedFrom(input);
/*       */     } public static RevelryRechargeAwardInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(input);
/*       */     } public static RevelryRechargeAwardInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeAwardInfo)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     } public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     } public static Builder newBuilder(RevelryRechargeAwardInfo prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     } public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder { private int bitField0_; private int id_; private List<ActivityRevelryHandler.RevelryRechargeItem> item_; private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeItem, ActivityRevelryHandler.RevelryRechargeItem.Builder, ActivityRevelryHandler.RevelryRechargeItemOrBuilder> itemBuilder_; private int state_; private int currNum_; private int needNum_; public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardInfo_descriptor;
/*       */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeAwardInfo.class, Builder.class);
/*       */       } private Builder() {
/*       */         this.item_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.item_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryRechargeAwardInfo.alwaysUseFieldBuilders)
/*       */           getItemFieldBuilder(); 
/*       */       } private static Builder create() {
/*       */         return new Builder();
/*       */       } public Builder clear() {
/*       */         super.clear();
/*       */         this.id_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         if (this.itemBuilder_ == null) {
/*       */           this.item_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */         } else {
/*       */           this.itemBuilder_.clear();
/*       */         } 
/*       */         this.state_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.currNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.needNum_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         return this;
/*       */       } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardInfo_descriptor;
/*       */       } public ActivityRevelryHandler.RevelryRechargeAwardInfo getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryRechargeAwardInfo.getDefaultInstance();
/*       */       } public ActivityRevelryHandler.RevelryRechargeAwardInfo build() {
/*       */         ActivityRevelryHandler.RevelryRechargeAwardInfo result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       } public ActivityRevelryHandler.RevelryRechargeAwardInfo buildPartial() {
/*       */         ActivityRevelryHandler.RevelryRechargeAwardInfo result = new ActivityRevelryHandler.RevelryRechargeAwardInfo(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.id_ = this.id_;
/*       */         if (this.itemBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x2) == 2) {
/*       */             this.item_ = Collections.unmodifiableList(this.item_);
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */           } 
/*       */           result.item_ = this.item_;
/*       */         } else {
/*       */           result.item_ = this.itemBuilder_.build();
/*       */         } 
/*       */         if ((from_bitField0_ & 0x4) == 4)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.state_ = this.state_;
/*       */         if ((from_bitField0_ & 0x8) == 8)
/*       */           to_bitField0_ |= 0x4; 
/*       */         result.currNum_ = this.currNum_;
/*       */         if ((from_bitField0_ & 0x10) == 16)
/*       */           to_bitField0_ |= 0x8; 
/*       */         result.needNum_ = this.needNum_;
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       } public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryRechargeAwardInfo)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeAwardInfo)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       } public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeAwardInfo other) {
/*       */         if (other == ActivityRevelryHandler.RevelryRechargeAwardInfo.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasId())
/*       */           setId(other.getId()); 
/*       */         if (this.itemBuilder_ == null) {
/*       */           if (!other.item_.isEmpty()) {
/*       */             if (this.item_.isEmpty()) {
/*       */               this.item_ = other.item_;
/*       */               this.bitField0_ &= 0xFFFFFFFD;
/*       */             } else {
/*       */               ensureItemIsMutable();
/*       */               this.item_.addAll(other.item_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.item_.isEmpty()) {
/*       */           if (this.itemBuilder_.isEmpty()) {
/*       */             this.itemBuilder_.dispose();
/*       */             this.itemBuilder_ = null;
/*       */             this.item_ = other.item_;
/*       */             this.bitField0_ &= 0xFFFFFFFD;
/*       */             this.itemBuilder_ = ActivityRevelryHandler.RevelryRechargeAwardInfo.alwaysUseFieldBuilders ? getItemFieldBuilder() : null;
/*       */           } else {
/*       */             this.itemBuilder_.addAllMessages(other.item_);
/*       */           } 
/*       */         } 
/*       */         if (other.hasState())
/*       */           setState(other.getState()); 
/*       */         if (other.hasCurrNum())
/*       */           setCurrNum(other.getCurrNum()); 
/*       */         if (other.hasNeedNum())
/*       */           setNeedNum(other.getNeedNum()); 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       } public final boolean isInitialized() {
/*       */         if (!hasId())
/*       */           return false; 
/*       */         if (!hasState())
/*       */           return false; 
/*       */         if (!hasCurrNum())
/*       */           return false; 
/*       */         if (!hasNeedNum())
/*       */           return false; 
/*       */         for (int i = 0; i < getItemCount(); i++) {
/*       */           if (!getItem(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryRechargeAwardInfo parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardInfo)ActivityRevelryHandler.RevelryRechargeAwardInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardInfo)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       } public boolean hasId() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       } public int getId() {
/*       */         return this.id_;
/*       */       } public Builder setId(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.id_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearId() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.id_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } private void ensureItemIsMutable() {
/*       */         if ((this.bitField0_ & 0x2) != 2) {
/*       */           this.item_ = new ArrayList<>(this.item_);
/*       */           this.bitField0_ |= 0x2;
/*       */         } 
/*       */       } public List<ActivityRevelryHandler.RevelryRechargeItem> getItemList() {
/*       */         if (this.itemBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.item_); 
/*       */         return this.itemBuilder_.getMessageList();
/*       */       } public int getItemCount() {
/*       */         if (this.itemBuilder_ == null)
/*       */           return this.item_.size(); 
/*       */         return this.itemBuilder_.getCount();
/*       */       } public ActivityRevelryHandler.RevelryRechargeItem getItem(int index) {
/*       */         if (this.itemBuilder_ == null)
/*       */           return this.item_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeItem)this.itemBuilder_.getMessage(index);
/*       */       } public Builder setItem(int index, ActivityRevelryHandler.RevelryRechargeItem value) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureItemIsMutable();
/*       */           this.item_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder setItem(int index, ActivityRevelryHandler.RevelryRechargeItem.Builder builderForValue) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           ensureItemIsMutable();
/*       */           this.item_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addItem(ActivityRevelryHandler.RevelryRechargeItem value) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureItemIsMutable();
/*       */           this.item_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addItem(int index, ActivityRevelryHandler.RevelryRechargeItem value) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureItemIsMutable();
/*       */           this.item_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       } public Builder addItem(ActivityRevelryHandler.RevelryRechargeItem.Builder builderForValue) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           ensureItemIsMutable();
/*       */           this.item_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addItem(int index, ActivityRevelryHandler.RevelryRechargeItem.Builder builderForValue) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           ensureItemIsMutable();
/*       */           this.item_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       } public Builder addAllItem(Iterable<? extends ActivityRevelryHandler.RevelryRechargeItem> values) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           ensureItemIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.item_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       } public Builder clearItem() {
/*       */         if (this.itemBuilder_ == null) {
/*       */           this.item_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFD;
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder removeItem(int index) {
/*       */         if (this.itemBuilder_ == null) {
/*       */           ensureItemIsMutable();
/*       */           this.item_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.itemBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       } public ActivityRevelryHandler.RevelryRechargeItem.Builder getItemBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeItem.Builder)getItemFieldBuilder().getBuilder(index);
/*       */       } public ActivityRevelryHandler.RevelryRechargeItemOrBuilder getItemOrBuilder(int index) {
/*       */         if (this.itemBuilder_ == null)
/*       */           return this.item_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeItemOrBuilder)this.itemBuilder_.getMessageOrBuilder(index);
/*       */       } public List<? extends ActivityRevelryHandler.RevelryRechargeItemOrBuilder> getItemOrBuilderList() {
/*       */         if (this.itemBuilder_ != null)
/*       */           return this.itemBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.item_);
/*       */       } public ActivityRevelryHandler.RevelryRechargeItem.Builder addItemBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryRechargeItem.Builder)getItemFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryRechargeItem.getDefaultInstance());
/*       */       } public ActivityRevelryHandler.RevelryRechargeItem.Builder addItemBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeItem.Builder)getItemFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryRechargeItem.getDefaultInstance());
/*       */       } public List<ActivityRevelryHandler.RevelryRechargeItem.Builder> getItemBuilderList() {
/*       */         return getItemFieldBuilder().getBuilderList();
/*       */       } private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeItem, ActivityRevelryHandler.RevelryRechargeItem.Builder, ActivityRevelryHandler.RevelryRechargeItemOrBuilder> getItemFieldBuilder() {
/*       */         if (this.itemBuilder_ == null) {
/*       */           this.itemBuilder_ = new RepeatedFieldBuilder(this.item_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
/*       */           this.item_ = null;
/*       */         } 
/*       */         return this.itemBuilder_;
/*       */       } public boolean hasState() {
/*       */         return ((this.bitField0_ & 0x4) == 4);
/*       */       } public int getState() {
/*       */         return this.state_;
/*       */       } public Builder setState(int value) {
/*       */         this.bitField0_ |= 0x4;
/*       */         this.state_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearState() {
/*       */         this.bitField0_ &= 0xFFFFFFFB;
/*       */         this.state_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasCurrNum() {
/*       */         return ((this.bitField0_ & 0x8) == 8);
/*       */       } public int getCurrNum() {
/*       */         return this.currNum_;
/*       */       } public Builder setCurrNum(int value) {
/*       */         this.bitField0_ |= 0x8;
/*       */         this.currNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearCurrNum() {
/*       */         this.bitField0_ &= 0xFFFFFFF7;
/*       */         this.currNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public boolean hasNeedNum() {
/*       */         return ((this.bitField0_ & 0x10) == 16);
/*       */       }
/*       */       public int getNeedNum() {
/*       */         return this.needNum_;
/*       */       }
/*       */       public Builder setNeedNum(int value) {
/*       */         this.bitField0_ |= 0x10;
/*       */         this.needNum_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       public Builder clearNeedNum() {
/*       */         this.bitField0_ &= 0xFFFFFFEF;
/*       */         this.needNum_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } } }
/* 17830 */   public static final class RevelryRechargeGetInfoRequest extends GeneratedMessage implements RevelryRechargeGetInfoRequestOrBuilder { private static final RevelryRechargeGetInfoRequest defaultInstance = new RevelryRechargeGetInfoRequest(true); private final UnknownFieldSet unknownFields; private RevelryRechargeGetInfoRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeGetInfoRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeGetInfoRequest getDefaultInstance() { return defaultInstance; } public RevelryRechargeGetInfoRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeGetInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.day_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeGetInfoRequest.class, Builder.class); } public static Parser<RevelryRechargeGetInfoRequest> PARSER = (Parser<RevelryRechargeGetInfoRequest>)new AbstractParser<RevelryRechargeGetInfoRequest>() { public ActivityRevelryHandler.RevelryRechargeGetInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeGetInfoRequest(input, extensionRegistry); } }; private int bitField0_; public static final int DAY_FIELD_NUMBER = 1; private int day_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeGetInfoRequest> getParserForType() { return PARSER; } public boolean hasDay() { return ((this.bitField0_ & 0x1) == 1); } public int getDay() { return this.day_; } private void initFields() { this.day_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasDay()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.day_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.day_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryRechargeGetInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(data); } public static RevelryRechargeGetInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeGetInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(data); } public static RevelryRechargeGetInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeGetInfoRequest parseFrom(InputStream input) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(input); } public static RevelryRechargeGetInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static RevelryRechargeGetInfoRequest parseDelimitedFrom(InputStream input) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseDelimitedFrom(input); } public static RevelryRechargeGetInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryRechargeGetInfoRequest parseFrom(CodedInputStream input) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(input); } public static RevelryRechargeGetInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeGetInfoRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryRechargeGetInfoRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeGetInfoRequestOrBuilder {
/* 17831 */       private int bitField0_; private int day_; public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeGetInfoRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryRechargeGetInfoRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.day_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_descriptor; } public ActivityRevelryHandler.RevelryRechargeGetInfoRequest getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryRechargeGetInfoRequest.getDefaultInstance(); } public ActivityRevelryHandler.RevelryRechargeGetInfoRequest build() { ActivityRevelryHandler.RevelryRechargeGetInfoRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryRechargeGetInfoRequest buildPartial() { ActivityRevelryHandler.RevelryRechargeGetInfoRequest result = new ActivityRevelryHandler.RevelryRechargeGetInfoRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.day_ = this.day_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryRechargeGetInfoRequest) return mergeFrom((ActivityRevelryHandler.RevelryRechargeGetInfoRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeGetInfoRequest other) { if (other == ActivityRevelryHandler.RevelryRechargeGetInfoRequest.getDefaultInstance()) return this;  if (other.hasDay()) setDay(other.getDay());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasDay()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryRechargeGetInfoRequest parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetInfoRequest)ActivityRevelryHandler.RevelryRechargeGetInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetInfoRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasDay() { return ((this.bitField0_ & 0x1) == 1); } public int getDay() { return this.day_; } public Builder setDay(int value) { this.bitField0_ |= 0x1; this.day_ = value; onChanged(); return this; } public Builder clearDay() { this.bitField0_ &= 0xFFFFFFFE; this.day_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class RevelryRechargeGetInfoResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryRechargeGetInfoResponseOrBuilder
/*       */   {
/* 18772 */     private static final RevelryRechargeGetInfoResponse defaultInstance = new RevelryRechargeGetInfoResponse(true); private final UnknownFieldSet unknownFields; private RevelryRechargeGetInfoResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeGetInfoResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeGetInfoResponse getDefaultInstance() { return defaultInstance; } public RevelryRechargeGetInfoResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeGetInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break;case 26: if ((mutable_bitField0_ & 0x4) != 4) { this.info_ = new ArrayList<>(); mutable_bitField0_ |= 0x4; }  this.info_.add(input.readMessage(ActivityRevelryHandler.RevelryRechargeAwardInfo.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x4) == 4) this.info_ = Collections.unmodifiableList(this.info_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeGetInfoResponse.class, Builder.class); } public static Parser<RevelryRechargeGetInfoResponse> PARSER = (Parser<RevelryRechargeGetInfoResponse>)new AbstractParser<RevelryRechargeGetInfoResponse>() { public ActivityRevelryHandler.RevelryRechargeGetInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeGetInfoResponse(input, extensionRegistry); } }
/* 18773 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; public static final int INFO_FIELD_NUMBER = 3; private List<ActivityRevelryHandler.RevelryRechargeAwardInfo> info_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeGetInfoResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } static { defaultInstance.initFields(); }
/*       */      public List<ActivityRevelryHandler.RevelryRechargeAwardInfo> getInfoList() {
/*       */       return this.info_;
/*       */     } public List<? extends ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder> getInfoOrBuilderList() {
/*       */       return (List)this.info_;
/*       */     } public int getInfoCount() {
/*       */       return this.info_.size();
/*       */     } public ActivityRevelryHandler.RevelryRechargeAwardInfo getInfo(int index) {
/*       */       return this.info_.get(index);
/*       */     } public ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder getInfoOrBuilder(int index) {
/*       */       return this.info_.get(index);
/*       */     } private void initFields() {
/*       */       this.s2CCode_ = 0;
/*       */       this.s2CMsg_ = "";
/*       */       this.info_ = Collections.emptyList();
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
/*       */       for (int i = 0; i < getInfoCount(); i++) {
/*       */         if (!getInfo(i).isInitialized()) {
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
/*       */       for (int i = 0; i < this.info_.size(); i++)
/*       */         output.writeMessage(3, (MessageLite)this.info_.get(i)); 
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
/*       */       for (int i = 0; i < this.info_.size(); i++)
/*       */         size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.info_.get(i)); 
/*       */       size += getUnknownFields().getSerializedSize();
/*       */       this.memoizedSerializedSize = size;
/*       */       return size;
/*       */     } protected Object writeReplace() throws ObjectStreamException {
/*       */       return super.writeReplace();
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(data);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(data);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(data, extensionRegistry);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(input);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static RevelryRechargeGetInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseDelimitedFrom(input);
/*       */     } public static RevelryRechargeGetInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(CodedInputStream input) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(input);
/*       */     } public static RevelryRechargeGetInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */       return (RevelryRechargeGetInfoResponse)PARSER.parseFrom(input, extensionRegistry);
/*       */     } public static Builder newBuilder() {
/*       */       return Builder.create();
/*       */     } public Builder newBuilderForType() {
/*       */       return newBuilder();
/*       */     } public static Builder newBuilder(RevelryRechargeGetInfoResponse prototype) {
/*       */       return newBuilder().mergeFrom(prototype);
/*       */     } public Builder toBuilder() {
/*       */       return newBuilder(this);
/*       */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*       */       Builder builder = new Builder(parent);
/*       */       return builder;
/*       */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeGetInfoResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; private List<ActivityRevelryHandler.RevelryRechargeAwardInfo> info_; private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeAwardInfo, ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder, ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder> infoBuilder_; public static final Descriptors.Descriptor getDescriptor() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_descriptor;
/*       */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeGetInfoResponse.class, Builder.class);
/*       */       } private Builder() {
/*       */         this.s2CMsg_ = "";
/*       */         this.info_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*       */         super(parent);
/*       */         this.s2CMsg_ = "";
/*       */         this.info_ = Collections.emptyList();
/*       */         maybeForceBuilderInitialization();
/*       */       } private void maybeForceBuilderInitialization() {
/*       */         if (ActivityRevelryHandler.RevelryRechargeGetInfoResponse.alwaysUseFieldBuilders)
/*       */           getInfoFieldBuilder(); 
/*       */       } private static Builder create() {
/*       */         return new Builder();
/*       */       } public Builder clear() {
/*       */         super.clear();
/*       */         this.s2CCode_ = 0;
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CMsg_ = "";
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.info_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */         } else {
/*       */           this.infoBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       } public Builder clone() {
/*       */         return create().mergeFrom(buildPartial());
/*       */       } public Descriptors.Descriptor getDescriptorForType() {
/*       */         return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_descriptor;
/*       */       } public ActivityRevelryHandler.RevelryRechargeGetInfoResponse getDefaultInstanceForType() {
/*       */         return ActivityRevelryHandler.RevelryRechargeGetInfoResponse.getDefaultInstance();
/*       */       } public ActivityRevelryHandler.RevelryRechargeGetInfoResponse build() {
/*       */         ActivityRevelryHandler.RevelryRechargeGetInfoResponse result = buildPartial();
/*       */         if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result); 
/*       */         return result;
/*       */       } public ActivityRevelryHandler.RevelryRechargeGetInfoResponse buildPartial() {
/*       */         ActivityRevelryHandler.RevelryRechargeGetInfoResponse result = new ActivityRevelryHandler.RevelryRechargeGetInfoResponse(this);
/*       */         int from_bitField0_ = this.bitField0_;
/*       */         int to_bitField0_ = 0;
/*       */         if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1; 
/*       */         result.s2CCode_ = this.s2CCode_;
/*       */         if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2; 
/*       */         result.s2CMsg_ = this.s2CMsg_;
/*       */         if (this.infoBuilder_ == null) {
/*       */           if ((this.bitField0_ & 0x4) == 4) {
/*       */             this.info_ = Collections.unmodifiableList(this.info_);
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */           } 
/*       */           result.info_ = this.info_;
/*       */         } else {
/*       */           result.info_ = this.infoBuilder_.build();
/*       */         } 
/*       */         result.bitField0_ = to_bitField0_;
/*       */         onBuilt();
/*       */         return result;
/*       */       } public Builder mergeFrom(Message other) {
/*       */         if (other instanceof ActivityRevelryHandler.RevelryRechargeGetInfoResponse)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeGetInfoResponse)other); 
/*       */         super.mergeFrom(other);
/*       */         return this;
/*       */       } public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeGetInfoResponse other) {
/*       */         if (other == ActivityRevelryHandler.RevelryRechargeGetInfoResponse.getDefaultInstance())
/*       */           return this; 
/*       */         if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode()); 
/*       */         if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (!other.info_.isEmpty()) {
/*       */             if (this.info_.isEmpty()) {
/*       */               this.info_ = other.info_;
/*       */               this.bitField0_ &= 0xFFFFFFFB;
/*       */             } else {
/*       */               ensureInfoIsMutable();
/*       */               this.info_.addAll(other.info_);
/*       */             } 
/*       */             onChanged();
/*       */           } 
/*       */         } else if (!other.info_.isEmpty()) {
/*       */           if (this.infoBuilder_.isEmpty()) {
/*       */             this.infoBuilder_.dispose();
/*       */             this.infoBuilder_ = null;
/*       */             this.info_ = other.info_;
/*       */             this.bitField0_ &= 0xFFFFFFFB;
/*       */             this.infoBuilder_ = ActivityRevelryHandler.RevelryRechargeGetInfoResponse.alwaysUseFieldBuilders ? getInfoFieldBuilder() : null;
/*       */           } else {
/*       */             this.infoBuilder_.addAllMessages(other.info_);
/*       */           } 
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this;
/*       */       } public final boolean isInitialized() {
/*       */         if (!hasS2CCode())
/*       */           return false; 
/*       */         for (int i = 0; i < getInfoCount(); i++) {
/*       */           if (!getInfo(i).isInitialized())
/*       */             return false; 
/*       */         } 
/*       */         return true;
/*       */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*       */         ActivityRevelryHandler.RevelryRechargeGetInfoResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetInfoResponse)ActivityRevelryHandler.RevelryRechargeGetInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeGetInfoResponse)e.getUnfinishedMessage();
/*       */           throw e;
/*       */         } finally {
/*       */           if (parsedMessage != null)
/*       */             mergeFrom(parsedMessage); 
/*       */         } 
/*       */         return this;
/*       */       } public boolean hasS2CCode() {
/*       */         return ((this.bitField0_ & 0x1) == 1);
/*       */       } public int getS2CCode() {
/*       */         return this.s2CCode_;
/*       */       } public Builder setS2CCode(int value) {
/*       */         this.bitField0_ |= 0x1;
/*       */         this.s2CCode_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearS2CCode() {
/*       */         this.bitField0_ &= 0xFFFFFFFE;
/*       */         this.s2CCode_ = 0;
/*       */         onChanged();
/*       */         return this;
/*       */       } public boolean hasS2CMsg() {
/*       */         return ((this.bitField0_ & 0x2) == 2);
/*       */       } public String getS2CMsg() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (!(ref instanceof String)) {
/*       */           ByteString bs = (ByteString)ref;
/*       */           String s = bs.toStringUtf8();
/*       */           if (bs.isValidUtf8())
/*       */             this.s2CMsg_ = s; 
/*       */           return s;
/*       */         } 
/*       */         return (String)ref;
/*       */       } public ByteString getS2CMsgBytes() {
/*       */         Object ref = this.s2CMsg_;
/*       */         if (ref instanceof String) {
/*       */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*       */           this.s2CMsg_ = b;
/*       */           return b;
/*       */         } 
/*       */         return (ByteString)ref;
/*       */       } public Builder setS2CMsg(String value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder clearS2CMsg() {
/*       */         this.bitField0_ &= 0xFFFFFFFD;
/*       */         this.s2CMsg_ = ActivityRevelryHandler.RevelryRechargeGetInfoResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this;
/*       */       } public Builder setS2CMsgBytes(ByteString value) {
/*       */         if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this;
/*       */       }
/*       */       private void ensureInfoIsMutable() {
/*       */         if ((this.bitField0_ & 0x4) != 4) {
/*       */           this.info_ = new ArrayList<>(this.info_);
/*       */           this.bitField0_ |= 0x4;
/*       */         } 
/*       */       }
/*       */       public List<ActivityRevelryHandler.RevelryRechargeAwardInfo> getInfoList() {
/*       */         if (this.infoBuilder_ == null)
/*       */           return Collections.unmodifiableList(this.info_); 
/*       */         return this.infoBuilder_.getMessageList();
/*       */       }
/*       */       public int getInfoCount() {
/*       */         if (this.infoBuilder_ == null)
/*       */           return this.info_.size(); 
/*       */         return this.infoBuilder_.getCount();
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardInfo getInfo(int index) {
/*       */         if (this.infoBuilder_ == null)
/*       */           return this.info_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeAwardInfo)this.infoBuilder_.getMessage(index);
/*       */       }
/*       */       public Builder setInfo(int index, ActivityRevelryHandler.RevelryRechargeAwardInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureInfoIsMutable();
/*       */           this.info_.set(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.setMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder setInfo(int index, ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.set(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.setMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addInfo(ActivityRevelryHandler.RevelryRechargeAwardInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addInfo(int index, ActivityRevelryHandler.RevelryRechargeAwardInfo value) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           if (value == null)
/*       */             throw new NullPointerException(); 
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(index, value);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(index, value);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addInfo(ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addInfo(int index, ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder builderForValue) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.add(index, builderForValue.build());
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addMessage(index, builderForValue.build());
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder addAllInfo(Iterable<? extends ActivityRevelryHandler.RevelryRechargeAwardInfo> values) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           AbstractMessageLite.Builder.addAll(values, this.info_);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.addAllMessages(values);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder clearInfo() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.info_ = Collections.emptyList();
/*       */           this.bitField0_ &= 0xFFFFFFFB;
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.clear();
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public Builder removeInfo(int index) {
/*       */         if (this.infoBuilder_ == null) {
/*       */           ensureInfoIsMutable();
/*       */           this.info_.remove(index);
/*       */           onChanged();
/*       */         } else {
/*       */           this.infoBuilder_.remove(index);
/*       */         } 
/*       */         return this;
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder getInfoBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder)getInfoFieldBuilder().getBuilder(index);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder getInfoOrBuilder(int index) {
/*       */         if (this.infoBuilder_ == null)
/*       */           return this.info_.get(index); 
/*       */         return (ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder)this.infoBuilder_.getMessageOrBuilder(index);
/*       */       }
/*       */       public List<? extends ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder> getInfoOrBuilderList() {
/*       */         if (this.infoBuilder_ != null)
/*       */           return this.infoBuilder_.getMessageOrBuilderList(); 
/*       */         return Collections.unmodifiableList((List)this.info_);
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder addInfoBuilder() {
/*       */         return (ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder)getInfoFieldBuilder().addBuilder(ActivityRevelryHandler.RevelryRechargeAwardInfo.getDefaultInstance());
/*       */       }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder addInfoBuilder(int index) {
/*       */         return (ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder)getInfoFieldBuilder().addBuilder(index, ActivityRevelryHandler.RevelryRechargeAwardInfo.getDefaultInstance());
/*       */       }
/*       */       public List<ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder> getInfoBuilderList() {
/*       */         return getInfoFieldBuilder().getBuilderList();
/*       */       }
/*       */       private RepeatedFieldBuilder<ActivityRevelryHandler.RevelryRechargeAwardInfo, ActivityRevelryHandler.RevelryRechargeAwardInfo.Builder, ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder> getInfoFieldBuilder() {
/*       */         if (this.infoBuilder_ == null) {
/*       */           this.infoBuilder_ = new RepeatedFieldBuilder(this.info_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
/*       */           this.info_ = null;
/*       */         } 
/*       */         return this.infoBuilder_;
/*       */       } } }
/* 19185 */   public static final class RevelryRechargeAwardRequest extends GeneratedMessage implements RevelryRechargeAwardRequestOrBuilder { private static final RevelryRechargeAwardRequest defaultInstance = new RevelryRechargeAwardRequest(true); private final UnknownFieldSet unknownFields; private RevelryRechargeAwardRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeAwardRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeAwardRequest getDefaultInstance() { return defaultInstance; } public RevelryRechargeAwardRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeAwardRequest.class, Builder.class); } public static Parser<RevelryRechargeAwardRequest> PARSER = (Parser<RevelryRechargeAwardRequest>)new AbstractParser<RevelryRechargeAwardRequest>() { public ActivityRevelryHandler.RevelryRechargeAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeAwardRequest(input, extensionRegistry); } }; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeAwardRequest> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } private void initFields() { this.id_ = 0; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static RevelryRechargeAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(data); } public static RevelryRechargeAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(data); } public static RevelryRechargeAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(data, extensionRegistry); } public static RevelryRechargeAwardRequest parseFrom(InputStream input) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(input); } public static RevelryRechargeAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static RevelryRechargeAwardRequest parseDelimitedFrom(InputStream input) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseDelimitedFrom(input); } public static RevelryRechargeAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static RevelryRechargeAwardRequest parseFrom(CodedInputStream input) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(input); } public static RevelryRechargeAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardRequest)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(RevelryRechargeAwardRequest prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeAwardRequestOrBuilder {
/* 19186 */       private int bitField0_; private int id_; public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeAwardRequest.class, Builder.class); } private Builder() { maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryRechargeAwardRequest.alwaysUseFieldBuilders); } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardRequest_descriptor; } public ActivityRevelryHandler.RevelryRechargeAwardRequest getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryRechargeAwardRequest.getDefaultInstance(); } public ActivityRevelryHandler.RevelryRechargeAwardRequest build() { ActivityRevelryHandler.RevelryRechargeAwardRequest result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public ActivityRevelryHandler.RevelryRechargeAwardRequest buildPartial() { ActivityRevelryHandler.RevelryRechargeAwardRequest result = new ActivityRevelryHandler.RevelryRechargeAwardRequest(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryRechargeAwardRequest) return mergeFrom((ActivityRevelryHandler.RevelryRechargeAwardRequest)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeAwardRequest other) { if (other == ActivityRevelryHandler.RevelryRechargeAwardRequest.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryRechargeAwardRequest parsedMessage = null; try { parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardRequest)ActivityRevelryHandler.RevelryRechargeAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardRequest)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } } static { defaultInstance.initFields(); }
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
/*       */   public static final class RevelryRechargeAwardResponse
/*       */     extends GeneratedMessage
/*       */     implements RevelryRechargeAwardResponseOrBuilder
/*       */   {
/* 19747 */     private static final RevelryRechargeAwardResponse defaultInstance = new RevelryRechargeAwardResponse(true); private final UnknownFieldSet unknownFields; private RevelryRechargeAwardResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private RevelryRechargeAwardResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static RevelryRechargeAwardResponse getDefaultInstance() { return defaultInstance; } public RevelryRechargeAwardResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private RevelryRechargeAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RevelryRechargeAwardResponse.class, Builder.class); } public static Parser<RevelryRechargeAwardResponse> PARSER = (Parser<RevelryRechargeAwardResponse>)new AbstractParser<RevelryRechargeAwardResponse>() { public ActivityRevelryHandler.RevelryRechargeAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new ActivityRevelryHandler.RevelryRechargeAwardResponse(input, extensionRegistry); } }
/* 19748 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<RevelryRechargeAwardResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } static { defaultInstance.initFields(); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String)
/*       */         return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8())
/*       */         this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) {
/*       */         ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b;
/*       */       }  return (ByteString)ref; }
/*       */     private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; }
/*       */     public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1)
/*       */         return true;  if (isInitialized == 0)
/*       */         return false;  if (!hasS2CCode()) {
/*       */         this.memoizedIsInitialized = 0; return false;
/*       */       }  this.memoizedIsInitialized = 1; return true; }
/*       */     public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1)
/*       */         output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); }
/*       */     public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1)
/*       */         return size;  size = 0; if ((this.bitField0_ & 0x1) == 1)
/*       */         size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2)
/*       */         size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; }
/*       */     protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(data); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(data, extensionRegistry); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(InputStream input) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static RevelryRechargeAwardResponse parseDelimitedFrom(InputStream input) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseDelimitedFrom(input); }
/*       */     public static RevelryRechargeAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(CodedInputStream input) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(input); }
/*       */     public static RevelryRechargeAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (RevelryRechargeAwardResponse)PARSER.parseFrom(input, extensionRegistry); }
/*       */     public static Builder newBuilder() { return Builder.create(); }
/*       */     public Builder newBuilderForType() { return newBuilder(); }
/*       */     public static Builder newBuilder(RevelryRechargeAwardResponse prototype) { return newBuilder().mergeFrom(prototype); }
/*       */     public Builder toBuilder() { return newBuilder(this); }
/*       */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*       */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActivityRevelryHandler.RevelryRechargeAwardResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_;
/*       */       public static final Descriptors.Descriptor getDescriptor() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardResponse_descriptor; }
/*       */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityRevelryHandler.RevelryRechargeAwardResponse.class, Builder.class); }
/*       */       private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*       */       private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*       */       private void maybeForceBuilderInitialization() { if (ActivityRevelryHandler.RevelryRechargeAwardResponse.alwaysUseFieldBuilders); }
/*       */       private static Builder create() { return new Builder(); }
/*       */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*       */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*       */       public Descriptors.Descriptor getDescriptorForType() { return ActivityRevelryHandler.internal_static_pomelo_revelry_RevelryRechargeAwardResponse_descriptor; }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardResponse getDefaultInstanceForType() { return ActivityRevelryHandler.RevelryRechargeAwardResponse.getDefaultInstance(); }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardResponse build() { ActivityRevelryHandler.RevelryRechargeAwardResponse result = buildPartial(); if (!result.isInitialized())
/*       */           throw newUninitializedMessageException(result);  return result; }
/*       */       public ActivityRevelryHandler.RevelryRechargeAwardResponse buildPartial() { ActivityRevelryHandler.RevelryRechargeAwardResponse result = new ActivityRevelryHandler.RevelryRechargeAwardResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1)
/*       */           to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2)
/*       */           to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*       */       public Builder mergeFrom(Message other) { if (other instanceof ActivityRevelryHandler.RevelryRechargeAwardResponse)
/*       */           return mergeFrom((ActivityRevelryHandler.RevelryRechargeAwardResponse)other);  super.mergeFrom(other); return this; }
/*       */       public Builder mergeFrom(ActivityRevelryHandler.RevelryRechargeAwardResponse other) { if (other == ActivityRevelryHandler.RevelryRechargeAwardResponse.getDefaultInstance())
/*       */           return this;  if (other.hasS2CCode())
/*       */           setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) {
/*       */           this.bitField0_ |= 0x2;
/*       */           this.s2CMsg_ = other.s2CMsg_;
/*       */           onChanged();
/*       */         } 
/*       */         mergeUnknownFields(other.getUnknownFields());
/*       */         return this; }
/*       */       public final boolean isInitialized() { if (!hasS2CCode())
/*       */           return false; 
/*       */         return true; }
/*       */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { ActivityRevelryHandler.RevelryRechargeAwardResponse parsedMessage = null;
/*       */         try {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardResponse)ActivityRevelryHandler.RevelryRechargeAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
/*       */         } catch (InvalidProtocolBufferException e) {
/*       */           parsedMessage = (ActivityRevelryHandler.RevelryRechargeAwardResponse)e.getUnfinishedMessage();
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
/*       */         this.s2CMsg_ = ActivityRevelryHandler.RevelryRechargeAwardResponse.getDefaultInstance().getS2CMsg();
/*       */         onChanged();
/*       */         return this; }
/*       */       public Builder setS2CMsgBytes(ByteString value) { if (value == null)
/*       */           throw new NullPointerException(); 
/*       */         this.bitField0_ |= 0x2;
/*       */         this.s2CMsg_ = value;
/*       */         onChanged();
/*       */         return this; } }
/*       */   }
/* 19867 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*       */ 
/*       */ 
/*       */   
/*       */   static {
/* 19872 */     String[] descriptorData = { "\n\034activityRevelryHandler.proto\022\016pomelo.revelry\032\fcommon.proto\"g\n\021RevelryColumnInfo\022\n\n\002id\030\001 \002(\t\022\f\n\004name\030\002 \002(\t\022\r\n\005label\030\003 \002(\t\022\r\n\005goto1\030\004 \001(\t\022\r\n\005goto2\030\005 \001(\t\022\013\n\003tip\030\006 \001(\t\"S\n\020RevelryTodayInfo\022\f\n\004name\030\001 \002(\t\0221\n\006column\030\002 \003(\0132!.pomelo.revelry.RevelryColumnInfo\"O\n\016RevelryTabInfo\022\f\n\004name\030\001 \002(\t\022/\n\005today\030\002 \003(\0132 .pomelo.revelry.RevelryTodayInfo\"©\001\n\fKingExchange\022\r\n\005tabId\030\001 \002(\005\022\017\n\007tabName\030\002 \002(\t\022\021\n\titem1code\030\003 \002(\t\022", "\020\n\bitem1num\030\004 \002(\005\022\021\n\titem2code\030\005 \002(\t\022\020\n\bitem2num\030\006 \002(\005\022\020\n\bavatarId\030\007 \002(\t\022\013\n\003tip\030\b \001(\t\022\020\n\bshowType\030\t \001(\005\"\031\n\027RevelryGetColumnRequest\"²\001\n\030RevelryGetColumnResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\004info\030\003 \003(\0132\036.pomelo.revelry.RevelryTabInfo\022.\n\bexchange\030\004 \003(\0132\034.pomelo.revelry.KingExchange\022\025\n\rselectedIndex\030\005 \001(\005\"D\n\017RevelryRankInfo\022\020\n\bcontents\030\001 \003(\t\022\037\n\007avatars\030\002 \003(\0132\016.pomelo.Avatar\"7\n\020RevelryAwardInf", "o\022\020\n\bitemcode\030\001 \002(\t\022\021\n\titemcount\030\002 \002(\005\"\001\n\021RevelryConfigInfo\022\017\n\007minRank\030\001 \002(\005\022\017\n\007maxRank\030\002 \002(\005\022/\n\005award\030\003 \003(\0132 .pomelo.revelry.RevelryAwardInfo\022/\n\006player\030\004 \001(\0132\037.pomelo.revelry.RevelryRankInfo\"'\n\031RevelryGetRankInfoRequest\022\n\n\002id\030\001 \002(\t\"å\001\n\032RevelryGetRankInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\017\n\007rankKey\030\003 \002(\005\0221\n\006config\030\004 \003(\0132!.pomelo.revelry.RevelryConfigInfo\022-\n\004self\030\005 \001(\0132\037.pomelo.revelry.R", "evelryRankInfo\022\020\n\bselfRank\030\006 \001(\005\022\r\n\005title\030\007 \001(\t\022\020\n\btimeleft\030\b \001(\005\"1\n\026RevelryExchangeRequest\022\n\n\002id\030\001 \002(\005\022\013\n\003num\030\002 \002(\005\"<\n\027RevelryExchangeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"2\n\025RevelryRechargeColumn\022\013\n\003day\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\"!\n\037RevelryRechargeGetColumnRequest\"Á\001\n RevelryRechargeGetColumnResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\tbeginTime\030\003 \002(\t\022\017\n\007endTime\030\004 \002(\t\022\020\n\bdescribe\030\005 \002(\t\022\r\n\005today", "\030\006 \001(\005\0225\n\006column\030\007 \003(\0132%.pomelo.revelry.RevelryRechargeColumn\"7\n\023RevelryRechargeItem\022\f\n\004code\030\001 \002(\t\022\022\n\ngroupCount\030\002 \002(\005\"\001\n\030RevelryRechargeAwardInfo\022\n\n\002id\030\001 \002(\005\0221\n\004item\030\002 \003(\0132#.pomelo.revelry.RevelryRechargeItem\022\r\n\005state\030\003 \002(\005\022\017\n\007currNum\030\004 \002(\005\022\017\n\007needNum\030\005 \002(\005\",\n\035RevelryRechargeGetInfoRequest\022\013\n\003day\030\001 \002(\005\"{\n\036RevelryRechargeGetInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0226\n\004info\030\003 \003(\0132(.pomelo.re", "velry.RevelryRechargeAwardInfo\")\n\033RevelryRechargeAwardRequest\022\n\n\002id\030\001 \002(\005\"A\n\034RevelryRechargeAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2æ\005\n\026activityRevelryHandler\022l\n\027revelryGetColumnRequest\022'.pomelo.revelry.RevelryGetColumnRequest\032(.pomelo.revelry.RevelryGetColumnResponse\022r\n\031revelryGetRankInfoRequest\022).pomelo.revelry.RevelryGetRankInfoRequest\032*.pomelo.revelry.RevelryGetRankInfoResponse\022i\n\026rev", "elryExchangeRequest\022&.pomelo.revelry.RevelryExchangeRequest\032'.pomelo.revelry.RevelryExchangeResponse\022\001\n\037revelryRechargeGetColumnRequest\022/.pomelo.revelry.RevelryRechargeGetColumnRequest\0320.pomelo.revelry.RevelryRechargeGetColumnResponse\022~\n\035revelryRechargeGetInfoRequest\022-.pomelo.revelry.RevelryRechargeGetInfoRequest\032..pomelo.revelry.RevelryRechargeGetInfoResponse\022x\n\033revelryRechargeAwardRequest\022+.pom", "elo.revelry.RevelryRechargeAwardRequest\032,.pomelo.revelry.RevelryRechargeAwardResponse" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 19947 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*       */       {
/*       */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*       */         {
/* 19951 */           ActivityRevelryHandler.descriptor = root;
/* 19952 */           return null;
/*       */         }
/*       */       };
/*       */     
/* 19956 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*       */           
/* 19958 */           Common.getDescriptor() }, assigner);
/*       */   }
/*       */   
/* 19961 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryColumnInfo_descriptor = getDescriptor().getMessageTypes().get(0);
/* 19962 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryColumnInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryColumnInfo_descriptor, new String[] { "Id", "Name", "Label", "Goto1", "Goto2", "Tip" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19967 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryTodayInfo_descriptor = getDescriptor().getMessageTypes().get(1);
/* 19968 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryTodayInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryTodayInfo_descriptor, new String[] { "Name", "Column" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19973 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryTabInfo_descriptor = getDescriptor().getMessageTypes().get(2);
/* 19974 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryTabInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryTabInfo_descriptor, new String[] { "Name", "Today" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19979 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_KingExchange_descriptor = getDescriptor().getMessageTypes().get(3);
/* 19980 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_KingExchange_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_KingExchange_descriptor, new String[] { "TabId", "TabName", "Item1Code", "Item1Num", "Item2Code", "Item2Num", "AvatarId", "Tip", "ShowType" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19985 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryGetColumnRequest_descriptor = getDescriptor().getMessageTypes().get(4);
/* 19986 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryGetColumnRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryGetColumnRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19991 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryGetColumnResponse_descriptor = getDescriptor().getMessageTypes().get(5);
/* 19992 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryGetColumnResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryGetColumnResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Info", "Exchange", "SelectedIndex" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 19997 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRankInfo_descriptor = getDescriptor().getMessageTypes().get(6);
/* 19998 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRankInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRankInfo_descriptor, new String[] { "Contents", "Avatars" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20003 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryAwardInfo_descriptor = getDescriptor().getMessageTypes().get(7);
/* 20004 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryAwardInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryAwardInfo_descriptor, new String[] { "Itemcode", "Itemcount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20009 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryConfigInfo_descriptor = getDescriptor().getMessageTypes().get(8);
/* 20010 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryConfigInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryConfigInfo_descriptor, new String[] { "MinRank", "MaxRank", "Award", "Player" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20015 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryGetRankInfoRequest_descriptor = getDescriptor().getMessageTypes().get(9);
/* 20016 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryGetRankInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryGetRankInfoRequest_descriptor, new String[] { "Id" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20021 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryGetRankInfoResponse_descriptor = getDescriptor().getMessageTypes().get(10);
/* 20022 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryGetRankInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryGetRankInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "RankKey", "Config", "Self", "SelfRank", "Title", "Timeleft" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20027 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryExchangeRequest_descriptor = getDescriptor().getMessageTypes().get(11);
/* 20028 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryExchangeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryExchangeRequest_descriptor, new String[] { "Id", "Num" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20033 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryExchangeResponse_descriptor = getDescriptor().getMessageTypes().get(12);
/* 20034 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryExchangeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryExchangeResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20039 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeColumn_descriptor = getDescriptor().getMessageTypes().get(13);
/* 20040 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeColumn_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeColumn_descriptor, new String[] { "Day", "Name" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20045 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_descriptor = getDescriptor().getMessageTypes().get(14);
/* 20046 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeGetColumnRequest_descriptor, new String[0]);
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20051 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_descriptor = getDescriptor().getMessageTypes().get(15);
/* 20052 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeGetColumnResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "BeginTime", "EndTime", "Describe", "Today", "Column" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20057 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeItem_descriptor = getDescriptor().getMessageTypes().get(16);
/* 20058 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeItem_descriptor, new String[] { "Code", "GroupCount" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20063 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeAwardInfo_descriptor = getDescriptor().getMessageTypes().get(17);
/* 20064 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeAwardInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeAwardInfo_descriptor, new String[] { "Id", "Item", "State", "CurrNum", "NeedNum" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20069 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_descriptor = getDescriptor().getMessageTypes().get(18);
/* 20070 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeGetInfoRequest_descriptor, new String[] { "Day" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20075 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_descriptor = getDescriptor().getMessageTypes().get(19);
/* 20076 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeGetInfoResponse_descriptor, new String[] { "S2CCode", "S2CMsg", "Info" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20081 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeAwardRequest_descriptor = getDescriptor().getMessageTypes().get(20);
/* 20082 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeAwardRequest_descriptor, new String[] { "Id" });
/*       */ 
/*       */ 
/*       */ 
/*       */   
/* 20087 */   private static final Descriptors.Descriptor internal_static_pomelo_revelry_RevelryRechargeAwardResponse_descriptor = getDescriptor().getMessageTypes().get(21);
/* 20088 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_revelry_RevelryRechargeAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_revelry_RevelryRechargeAwardResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*       */   private static Descriptors.FileDescriptor descriptor;
/*       */   
/*       */   static {
/* 20092 */     Common.getDescriptor();
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeAwardResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface RevelryRechargeAwardRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeGetInfoResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<ActivityRevelryHandler.RevelryRechargeAwardInfo> getInfoList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeAwardInfo getInfo(int param1Int);
/*       */     
/*       */     int getInfoCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder> getInfoOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeAwardInfoOrBuilder getInfoOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeGetInfoRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasDay();
/*       */     
/*       */     int getDay();
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeAwardInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryRechargeItem> getItemList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeItem getItem(int param1Int);
/*       */     
/*       */     int getItemCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryRechargeItemOrBuilder> getItemOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeItemOrBuilder getItemOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasState();
/*       */     
/*       */     int getState();
/*       */     
/*       */     boolean hasCurrNum();
/*       */     
/*       */     int getCurrNum();
/*       */     
/*       */     boolean hasNeedNum();
/*       */     
/*       */     int getNeedNum();
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeItemOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface RevelryRechargeGetColumnResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasBeginTime();
/*       */     
/*       */     String getBeginTime();
/*       */     
/*       */     ByteString getBeginTimeBytes();
/*       */     
/*       */     boolean hasEndTime();
/*       */     
/*       */     String getEndTime();
/*       */     
/*       */     ByteString getEndTimeBytes();
/*       */     
/*       */     boolean hasDescribe();
/*       */     
/*       */     String getDescribe();
/*       */     
/*       */     ByteString getDescribeBytes();
/*       */     
/*       */     boolean hasToday();
/*       */     
/*       */     int getToday();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryRechargeColumn> getColumnList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeColumn getColumn(int param1Int);
/*       */     
/*       */     int getColumnCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryRechargeColumnOrBuilder> getColumnOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRechargeColumnOrBuilder getColumnOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RevelryRechargeGetColumnRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface RevelryRechargeColumnOrBuilder extends MessageOrBuilder {
/*       */     boolean hasDay();
/*       */     
/*       */     int getDay();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */   }
/*       */   
/*       */   public static interface RevelryExchangeResponseOrBuilder extends MessageOrBuilder {
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
/*       */   public static interface RevelryExchangeRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     int getId();
/*       */     
/*       */     boolean hasNum();
/*       */     
/*       */     int getNum();
/*       */   }
/*       */   
/*       */   public static interface RevelryGetRankInfoResponseOrBuilder extends MessageOrBuilder {
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
/*       */     boolean hasRankKey();
/*       */     
/*       */     int getRankKey();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryConfigInfo> getConfigList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryConfigInfo getConfig(int param1Int);
/*       */     
/*       */     int getConfigCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryConfigInfoOrBuilder> getConfigOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryConfigInfoOrBuilder getConfigOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasSelf();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRankInfo getSelf();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRankInfoOrBuilder getSelfOrBuilder();
/*       */     
/*       */     boolean hasSelfRank();
/*       */     
/*       */     int getSelfRank();
/*       */     
/*       */     boolean hasTitle();
/*       */     
/*       */     String getTitle();
/*       */     
/*       */     ByteString getTitleBytes();
/*       */     
/*       */     boolean hasTimeleft();
/*       */     
/*       */     int getTimeleft();
/*       */   }
/*       */   
/*       */   public static interface RevelryGetRankInfoRequestOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     String getId();
/*       */     
/*       */     ByteString getIdBytes();
/*       */   }
/*       */   
/*       */   public static interface RevelryConfigInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasMinRank();
/*       */     
/*       */     int getMinRank();
/*       */     
/*       */     boolean hasMaxRank();
/*       */     
/*       */     int getMaxRank();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryAwardInfo> getAwardList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryAwardInfo getAward(int param1Int);
/*       */     
/*       */     int getAwardCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryAwardInfoOrBuilder> getAwardOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryAwardInfoOrBuilder getAwardOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasPlayer();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRankInfo getPlayer();
/*       */     
/*       */     ActivityRevelryHandler.RevelryRankInfoOrBuilder getPlayerOrBuilder();
/*       */   }
/*       */   
/*       */   public static interface RevelryAwardInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasItemcode();
/*       */     
/*       */     String getItemcode();
/*       */     
/*       */     ByteString getItemcodeBytes();
/*       */     
/*       */     boolean hasItemcount();
/*       */     
/*       */     int getItemcount();
/*       */   }
/*       */   
/*       */   public static interface RevelryRankInfoOrBuilder extends MessageOrBuilder {
/*       */     ProtocolStringList getContentsList();
/*       */     
/*       */     int getContentsCount();
/*       */     
/*       */     String getContents(int param1Int);
/*       */     
/*       */     ByteString getContentsBytes(int param1Int);
/*       */     
/*       */     List<Common.Avatar> getAvatarsList();
/*       */     
/*       */     Common.Avatar getAvatars(int param1Int);
/*       */     
/*       */     int getAvatarsCount();
/*       */     
/*       */     List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList();
/*       */     
/*       */     Common.AvatarOrBuilder getAvatarsOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RevelryGetColumnResponseOrBuilder extends MessageOrBuilder {
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
/*       */     List<ActivityRevelryHandler.RevelryTabInfo> getInfoList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryTabInfo getInfo(int param1Int);
/*       */     
/*       */     int getInfoCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryTabInfoOrBuilder> getInfoOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryTabInfoOrBuilder getInfoOrBuilder(int param1Int);
/*       */     
/*       */     List<ActivityRevelryHandler.KingExchange> getExchangeList();
/*       */     
/*       */     ActivityRevelryHandler.KingExchange getExchange(int param1Int);
/*       */     
/*       */     int getExchangeCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.KingExchangeOrBuilder> getExchangeOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.KingExchangeOrBuilder getExchangeOrBuilder(int param1Int);
/*       */     
/*       */     boolean hasSelectedIndex();
/*       */     
/*       */     int getSelectedIndex();
/*       */   }
/*       */   
/*       */   public static interface RevelryGetColumnRequestOrBuilder extends MessageOrBuilder {}
/*       */   
/*       */   public static interface KingExchangeOrBuilder extends MessageOrBuilder {
/*       */     boolean hasTabId();
/*       */     
/*       */     int getTabId();
/*       */     
/*       */     boolean hasTabName();
/*       */     
/*       */     String getTabName();
/*       */     
/*       */     ByteString getTabNameBytes();
/*       */     
/*       */     boolean hasItem1Code();
/*       */     
/*       */     String getItem1Code();
/*       */     
/*       */     ByteString getItem1CodeBytes();
/*       */     
/*       */     boolean hasItem1Num();
/*       */     
/*       */     int getItem1Num();
/*       */     
/*       */     boolean hasItem2Code();
/*       */     
/*       */     String getItem2Code();
/*       */     
/*       */     ByteString getItem2CodeBytes();
/*       */     
/*       */     boolean hasItem2Num();
/*       */     
/*       */     int getItem2Num();
/*       */     
/*       */     boolean hasAvatarId();
/*       */     
/*       */     String getAvatarId();
/*       */     
/*       */     ByteString getAvatarIdBytes();
/*       */     
/*       */     boolean hasTip();
/*       */     
/*       */     String getTip();
/*       */     
/*       */     ByteString getTipBytes();
/*       */     
/*       */     boolean hasShowType();
/*       */     
/*       */     int getShowType();
/*       */   }
/*       */   
/*       */   public static interface RevelryTabInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryTodayInfo> getTodayList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryTodayInfo getToday(int param1Int);
/*       */     
/*       */     int getTodayCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryTodayInfoOrBuilder> getTodayOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryTodayInfoOrBuilder getTodayOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RevelryTodayInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     List<ActivityRevelryHandler.RevelryColumnInfo> getColumnList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryColumnInfo getColumn(int param1Int);
/*       */     
/*       */     int getColumnCount();
/*       */     
/*       */     List<? extends ActivityRevelryHandler.RevelryColumnInfoOrBuilder> getColumnOrBuilderList();
/*       */     
/*       */     ActivityRevelryHandler.RevelryColumnInfoOrBuilder getColumnOrBuilder(int param1Int);
/*       */   }
/*       */   
/*       */   public static interface RevelryColumnInfoOrBuilder extends MessageOrBuilder {
/*       */     boolean hasId();
/*       */     
/*       */     String getId();
/*       */     
/*       */     ByteString getIdBytes();
/*       */     
/*       */     boolean hasName();
/*       */     
/*       */     String getName();
/*       */     
/*       */     ByteString getNameBytes();
/*       */     
/*       */     boolean hasLabel();
/*       */     
/*       */     String getLabel();
/*       */     
/*       */     ByteString getLabelBytes();
/*       */     
/*       */     boolean hasGoto1();
/*       */     
/*       */     String getGoto1();
/*       */     
/*       */     ByteString getGoto1Bytes();
/*       */     
/*       */     boolean hasGoto2();
/*       */     
/*       */     String getGoto2();
/*       */     
/*       */     ByteString getGoto2Bytes();
/*       */     
/*       */     boolean hasTip();
/*       */     
/*       */     String getTip();
/*       */     
/*       */     ByteString getTipBytes();
/*       */   }
/*       */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\revelry\ActivityRevelryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */