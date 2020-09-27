/*      */ package pomelo.dailyActivity;
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
/*      */ import pomelo.item.ItemOuterClass;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class DailyActivity
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class DailyInfo
/*      */     extends GeneratedMessage
/*      */     implements DailyInfoOrBuilder
/*      */   {
/* 1688 */     private static final DailyInfo defaultInstance = new DailyInfo(true); private final UnknownFieldSet unknownFields; private DailyInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DailyInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DailyInfo getDefaultInstance() { return defaultInstance; } public DailyInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DailyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.curNum_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.maxNum_ = input.readInt32(); break;case 32: this.bitField0_ |= 0x8; this.perDegree_ = input.readInt32(); break;case 40: this.bitField0_ |= 0x10; this.lvLimit_ = input.readInt32(); break;case 50: bs = input.readBytes(); this.bitField0_ |= 0x20; this.openPeriod_ = bs; break;case 56: this.bitField0_ |= 0x40; this.isOver_ = input.readInt32(); break;case 66: if ((mutable_bitField0_ & 0x80) != 128) { this.awardItem_ = new ArrayList<>(); mutable_bitField0_ |= 0x80; }  this.awardItem_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x80) == 128) this.awardItem_ = Collections.unmodifiableList(this.awardItem_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivity.internal_static_pomelo_dailyActivity_DailyInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivity.internal_static_pomelo_dailyActivity_DailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyInfo.class, Builder.class); } public static Parser<DailyInfo> PARSER = (Parser<DailyInfo>)new AbstractParser<DailyInfo>() { public DailyActivity.DailyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivity.DailyInfo(input, extensionRegistry); } }
/* 1689 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int CUR_NUM_FIELD_NUMBER = 2; private int curNum_; public static final int MAX_NUM_FIELD_NUMBER = 3; private int maxNum_; public static final int PERDEGREE_FIELD_NUMBER = 4; private int perDegree_; public static final int LVLIMIT_FIELD_NUMBER = 5; private int lvLimit_; public static final int OPENPERIOD_FIELD_NUMBER = 6; private Object openPeriod_; public static final int ISOVER_FIELD_NUMBER = 7; private int isOver_; public static final int AWARDITEM_FIELD_NUMBER = 8; private List<ItemOuterClass.ItemDetail> awardItem_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DailyInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasCurNum() { return ((this.bitField0_ & 0x2) == 2); } public int getCurNum() { return this.curNum_; } public boolean hasMaxNum() { return ((this.bitField0_ & 0x4) == 4); } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getMaxNum() {
/*      */       return this.maxNum_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasPerDegree() {
/*      */       return ((this.bitField0_ & 0x8) == 8);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getPerDegree() {
/*      */       return this.perDegree_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasLvLimit() {
/*      */       return ((this.bitField0_ & 0x10) == 16);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLvLimit() {
/*      */       return this.lvLimit_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasOpenPeriod() {
/*      */       return ((this.bitField0_ & 0x20) == 32);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getOpenPeriod() {
/*      */       Object ref = this.openPeriod_;
/*      */       if (ref instanceof String) {
/*      */         return (String)ref;
/*      */       }
/*      */       ByteString bs = (ByteString)ref;
/*      */       String s = bs.toStringUtf8();
/*      */       if (bs.isValidUtf8()) {
/*      */         this.openPeriod_ = s;
/*      */       }
/*      */       return s;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ByteString getOpenPeriodBytes() {
/*      */       Object ref = this.openPeriod_;
/*      */       if (ref instanceof String) {
/*      */         ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */         this.openPeriod_ = b;
/*      */         return b;
/*      */       } 
/*      */       return (ByteString)ref;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasIsOver() {
/*      */       return ((this.bitField0_ & 0x40) == 64);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getIsOver() {
/*      */       return this.isOver_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<ItemOuterClass.ItemDetail> getAwardItemList() {
/*      */       return this.awardItem_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList() {
/*      */       return (List)this.awardItem_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getAwardItemCount() {
/*      */       return this.awardItem_.size();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ItemOuterClass.ItemDetail getAwardItem(int index) {
/*      */       return this.awardItem_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int index) {
/*      */       return (ItemOuterClass.ItemDetailOrBuilder)this.awardItem_.get(index);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.id_ = 0;
/*      */       this.curNum_ = 0;
/*      */       this.maxNum_ = 0;
/*      */       this.perDegree_ = 0;
/*      */       this.lvLimit_ = 0;
/*      */       this.openPeriod_ = "";
/*      */       this.isOver_ = 0;
/*      */       this.awardItem_ = Collections.emptyList();
/*      */     }
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
/*      */       if (!hasId()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       for (int i = 0; i < getAwardItemCount(); i++) {
/*      */         if (!getAwardItem(i).isInitialized()) {
/*      */           this.memoizedIsInitialized = 0;
/*      */           return false;
/*      */         } 
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeInt32(1, this.id_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         output.writeInt32(2, this.curNum_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         output.writeInt32(3, this.maxNum_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         output.writeInt32(4, this.perDegree_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         output.writeInt32(5, this.lvLimit_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         output.writeBytes(6, getOpenPeriodBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x40) == 64) {
/*      */         output.writeInt32(7, this.isOver_);
/*      */       }
/*      */       for (int i = 0; i < this.awardItem_.size(); i++) {
/*      */         output.writeMessage(8, (MessageLite)this.awardItem_.get(i));
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
/*      */         size += CodedOutputStream.computeInt32Size(1, this.id_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x2) == 2) {
/*      */         size += CodedOutputStream.computeInt32Size(2, this.curNum_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x4) == 4) {
/*      */         size += CodedOutputStream.computeInt32Size(3, this.maxNum_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x8) == 8) {
/*      */         size += CodedOutputStream.computeInt32Size(4, this.perDegree_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x10) == 16) {
/*      */         size += CodedOutputStream.computeInt32Size(5, this.lvLimit_);
/*      */       }
/*      */       if ((this.bitField0_ & 0x20) == 32) {
/*      */         size += CodedOutputStream.computeBytesSize(6, getOpenPeriodBytes());
/*      */       }
/*      */       if ((this.bitField0_ & 0x40) == 64) {
/*      */         size += CodedOutputStream.computeInt32Size(7, this.isOver_);
/*      */       }
/*      */       for (int i = 0; i < this.awardItem_.size(); i++) {
/*      */         size += CodedOutputStream.computeMessageSize(8, (MessageLite)this.awardItem_.get(i));
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
/*      */     public static DailyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (DailyInfo)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DailyInfo)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (DailyInfo)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (DailyInfo)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(InputStream input) throws IOException {
/*      */       return (DailyInfo)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DailyInfo)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (DailyInfo)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DailyInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(CodedInputStream input) throws IOException {
/*      */       return (DailyInfo)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static DailyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (DailyInfo)PARSER.parseFrom(input, extensionRegistry);
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
/*      */     public static Builder newBuilder(DailyInfo prototype) {
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
/*      */       implements DailyActivity.DailyInfoOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int id_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int curNum_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int maxNum_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int perDegree_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int lvLimit_;
/*      */ 
/*      */ 
/*      */       
/*      */       private Object openPeriod_;
/*      */ 
/*      */ 
/*      */       
/*      */       private int isOver_;
/*      */ 
/*      */ 
/*      */       
/*      */       private List<ItemOuterClass.ItemDetail> awardItem_;
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> awardItemBuilder_;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return DailyActivity.internal_static_pomelo_dailyActivity_DailyInfo_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return DailyActivity.internal_static_pomelo_dailyActivity_DailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivity.DailyInfo.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.openPeriod_ = "";
/*      */         this.awardItem_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.openPeriod_ = "";
/*      */         this.awardItem_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (DailyActivity.DailyInfo.alwaysUseFieldBuilders) {
/*      */           getAwardItemFieldBuilder();
/*      */         }
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
/*      */         this.id_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.curNum_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.maxNum_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.perDegree_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.lvLimit_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.openPeriod_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.isOver_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           this.awardItem_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFF7F;
/*      */         } else {
/*      */           this.awardItemBuilder_.clear();
/*      */         } 
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
/*      */         return DailyActivity.internal_static_pomelo_dailyActivity_DailyInfo_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DailyActivity.DailyInfo getDefaultInstanceForType() {
/*      */         return DailyActivity.DailyInfo.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DailyActivity.DailyInfo build() {
/*      */         DailyActivity.DailyInfo result = buildPartial();
/*      */         if (!result.isInitialized()) {
/*      */           throw newUninitializedMessageException(result);
/*      */         }
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public DailyActivity.DailyInfo buildPartial() {
/*      */         DailyActivity.DailyInfo result = new DailyActivity.DailyInfo(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         result.id_ = this.id_;
/*      */         if ((from_bitField0_ & 0x2) == 2) {
/*      */           to_bitField0_ |= 0x2;
/*      */         }
/*      */         result.curNum_ = this.curNum_;
/*      */         if ((from_bitField0_ & 0x4) == 4) {
/*      */           to_bitField0_ |= 0x4;
/*      */         }
/*      */         result.maxNum_ = this.maxNum_;
/*      */         if ((from_bitField0_ & 0x8) == 8) {
/*      */           to_bitField0_ |= 0x8;
/*      */         }
/*      */         result.perDegree_ = this.perDegree_;
/*      */         if ((from_bitField0_ & 0x10) == 16) {
/*      */           to_bitField0_ |= 0x10;
/*      */         }
/*      */         result.lvLimit_ = this.lvLimit_;
/*      */         if ((from_bitField0_ & 0x20) == 32) {
/*      */           to_bitField0_ |= 0x20;
/*      */         }
/*      */         result.openPeriod_ = this.openPeriod_;
/*      */         if ((from_bitField0_ & 0x40) == 64) {
/*      */           to_bitField0_ |= 0x40;
/*      */         }
/*      */         result.isOver_ = this.isOver_;
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x80) == 128) {
/*      */             this.awardItem_ = Collections.unmodifiableList(this.awardItem_);
/*      */             this.bitField0_ &= 0xFFFFFF7F;
/*      */           } 
/*      */           result.awardItem_ = this.awardItem_;
/*      */         } else {
/*      */           result.awardItem_ = this.awardItemBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof DailyActivity.DailyInfo) {
/*      */           return mergeFrom((DailyActivity.DailyInfo)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(DailyActivity.DailyInfo other) {
/*      */         if (other == DailyActivity.DailyInfo.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasId()) {
/*      */           setId(other.getId());
/*      */         }
/*      */         if (other.hasCurNum()) {
/*      */           setCurNum(other.getCurNum());
/*      */         }
/*      */         if (other.hasMaxNum()) {
/*      */           setMaxNum(other.getMaxNum());
/*      */         }
/*      */         if (other.hasPerDegree()) {
/*      */           setPerDegree(other.getPerDegree());
/*      */         }
/*      */         if (other.hasLvLimit()) {
/*      */           setLvLimit(other.getLvLimit());
/*      */         }
/*      */         if (other.hasOpenPeriod()) {
/*      */           this.bitField0_ |= 0x20;
/*      */           this.openPeriod_ = other.openPeriod_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasIsOver()) {
/*      */           setIsOver(other.getIsOver());
/*      */         }
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           if (!other.awardItem_.isEmpty()) {
/*      */             if (this.awardItem_.isEmpty()) {
/*      */               this.awardItem_ = other.awardItem_;
/*      */               this.bitField0_ &= 0xFFFFFF7F;
/*      */             } else {
/*      */               ensureAwardItemIsMutable();
/*      */               this.awardItem_.addAll(other.awardItem_);
/*      */             } 
/*      */             onChanged();
/*      */           } 
/*      */         } else if (!other.awardItem_.isEmpty()) {
/*      */           if (this.awardItemBuilder_.isEmpty()) {
/*      */             this.awardItemBuilder_.dispose();
/*      */             this.awardItemBuilder_ = null;
/*      */             this.awardItem_ = other.awardItem_;
/*      */             this.bitField0_ &= 0xFFFFFF7F;
/*      */             this.awardItemBuilder_ = DailyActivity.DailyInfo.alwaysUseFieldBuilders ? getAwardItemFieldBuilder() : null;
/*      */           } else {
/*      */             this.awardItemBuilder_.addAllMessages(other.awardItem_);
/*      */           } 
/*      */         } 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasId()) {
/*      */           return false;
/*      */         }
/*      */         for (int i = 0; i < getAwardItemCount(); i++) {
/*      */           if (!getAwardItem(i).isInitialized()) {
/*      */             return false;
/*      */           }
/*      */         } 
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         DailyActivity.DailyInfo parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (DailyActivity.DailyInfo)DailyActivity.DailyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (DailyActivity.DailyInfo)e.getUnfinishedMessage();
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
/*      */       public boolean hasId() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getId() {
/*      */         return this.id_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setId(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.id_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearId() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.id_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasCurNum() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getCurNum() {
/*      */         return this.curNum_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setCurNum(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.curNum_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearCurNum() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.curNum_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasMaxNum() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getMaxNum() {
/*      */         return this.maxNum_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setMaxNum(int value) {
/*      */         this.bitField0_ |= 0x4;
/*      */         this.maxNum_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearMaxNum() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.maxNum_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasPerDegree() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getPerDegree() {
/*      */         return this.perDegree_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setPerDegree(int value) {
/*      */         this.bitField0_ |= 0x8;
/*      */         this.perDegree_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearPerDegree() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.perDegree_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasLvLimit() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getLvLimit() {
/*      */         return this.lvLimit_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setLvLimit(int value) {
/*      */         this.bitField0_ |= 0x10;
/*      */         this.lvLimit_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearLvLimit() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.lvLimit_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasOpenPeriod() {
/*      */         return ((this.bitField0_ & 0x20) == 32);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getOpenPeriod() {
/*      */         Object ref = this.openPeriod_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8()) {
/*      */             this.openPeriod_ = s;
/*      */           }
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public ByteString getOpenPeriodBytes() {
/*      */         Object ref = this.openPeriod_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.openPeriod_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setOpenPeriod(String value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x20;
/*      */         this.openPeriod_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearOpenPeriod() {
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.openPeriod_ = DailyActivity.DailyInfo.getDefaultInstance().getOpenPeriod();
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setOpenPeriodBytes(ByteString value) {
/*      */         if (value == null) {
/*      */           throw new NullPointerException();
/*      */         }
/*      */         this.bitField0_ |= 0x20;
/*      */         this.openPeriod_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean hasIsOver() {
/*      */         return ((this.bitField0_ & 0x40) == 64);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int getIsOver() {
/*      */         return this.isOver_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setIsOver(int value) {
/*      */         this.bitField0_ |= 0x40;
/*      */         this.isOver_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearIsOver() {
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.isOver_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void ensureAwardItemIsMutable() {
/*      */         if ((this.bitField0_ & 0x80) != 128) {
/*      */           this.awardItem_ = new ArrayList<>(this.awardItem_);
/*      */           this.bitField0_ |= 0x80;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public List<ItemOuterClass.ItemDetail> getAwardItemList() {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           return Collections.unmodifiableList(this.awardItem_);
/*      */         }
/*      */         return this.awardItemBuilder_.getMessageList();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int getAwardItemCount() {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           return this.awardItem_.size();
/*      */         }
/*      */         return this.awardItemBuilder_.getCount();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ItemOuterClass.ItemDetail getAwardItem(int index) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           return this.awardItem_.get(index);
/*      */         }
/*      */         return (ItemOuterClass.ItemDetail)this.awardItemBuilder_.getMessage(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setAwardItem(int index, ItemOuterClass.ItemDetail value) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.set(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.setMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setAwardItem(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.set(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAwardItem(ItemOuterClass.ItemDetail value) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.add(value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.addMessage((GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAwardItem(int index, ItemOuterClass.ItemDetail value) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.add(index, value);
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.addMessage(index, (GeneratedMessage)value);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAwardItem(ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.add(builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.addMessage((GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAwardItem(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.add(index, builderForValue.build());
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build());
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder addAllAwardItem(Iterable<? extends ItemOuterClass.ItemDetail> values) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           ensureAwardItemIsMutable();
/*      */           AbstractMessageLite.Builder.addAll(values, this.awardItem_);
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.addAllMessages(values);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearAwardItem() {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           this.awardItem_ = Collections.emptyList();
/*      */           this.bitField0_ &= 0xFFFFFF7F;
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.clear();
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder removeAwardItem(int index) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           ensureAwardItemIsMutable();
/*      */           this.awardItem_.remove(index);
/*      */           onChanged();
/*      */         } else {
/*      */           this.awardItemBuilder_.remove(index);
/*      */         } 
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ItemOuterClass.ItemDetail.Builder getAwardItemBuilder(int index) {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().getBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int index) {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           return (ItemOuterClass.ItemDetailOrBuilder)this.awardItem_.get(index);
/*      */         }
/*      */         return (ItemOuterClass.ItemDetailOrBuilder)this.awardItemBuilder_.getMessageOrBuilder(index);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList() {
/*      */         if (this.awardItemBuilder_ != null) {
/*      */           return this.awardItemBuilder_.getMessageOrBuilderList();
/*      */         }
/*      */         return (List)Collections.unmodifiableList(this.awardItem_);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ItemOuterClass.ItemDetail.Builder addAwardItemBuilder() {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ItemOuterClass.ItemDetail.Builder addAwardItemBuilder(int index) {
/*      */         return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public List<ItemOuterClass.ItemDetail.Builder> getAwardItemBuilderList() {
/*      */         return getAwardItemFieldBuilder().getBuilderList();
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getAwardItemFieldBuilder() {
/*      */         if (this.awardItemBuilder_ == null) {
/*      */           this.awardItemBuilder_ = new RepeatedFieldBuilder(this.awardItem_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
/*      */           this.awardItem_ = null;
/*      */         } 
/*      */         return this.awardItemBuilder_;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DegreeInfo
/*      */     extends GeneratedMessage
/*      */     implements DegreeInfoOrBuilder
/*      */   {
/* 2837 */     private static final DegreeInfo defaultInstance = new DegreeInfo(true); private final UnknownFieldSet unknownFields; private DegreeInfo(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private DegreeInfo(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static DegreeInfo getDefaultInstance() { return defaultInstance; } public DegreeInfo getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private DegreeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.id_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.needDegree_ = input.readInt32(); break;case 24: this.bitField0_ |= 0x4; this.state_ = input.readInt32(); break;case 34: if ((mutable_bitField0_ & 0x8) != 8) { this.awardItem_ = new ArrayList<>(); mutable_bitField0_ |= 0x8; }  this.awardItem_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry)); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x8) == 8) this.awardItem_ = Collections.unmodifiableList(this.awardItem_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return DailyActivity.internal_static_pomelo_dailyActivity_DegreeInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivity.internal_static_pomelo_dailyActivity_DegreeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DegreeInfo.class, Builder.class); } public static Parser<DegreeInfo> PARSER = (Parser<DegreeInfo>)new AbstractParser<DegreeInfo>() { public DailyActivity.DegreeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new DailyActivity.DegreeInfo(input, extensionRegistry); } }
/* 2838 */     ; private int bitField0_; public static final int ID_FIELD_NUMBER = 1; private int id_; public static final int NEEDDEGREE_FIELD_NUMBER = 2; private int needDegree_; public static final int STATE_FIELD_NUMBER = 3; private int state_; public static final int AWARDITEM_FIELD_NUMBER = 4; private List<ItemOuterClass.ItemDetail> awardItem_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<DegreeInfo> getParserForType() { return PARSER; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public boolean hasNeedDegree() { return ((this.bitField0_ & 0x2) == 2); } public int getNeedDegree() { return this.needDegree_; } public boolean hasState() { return ((this.bitField0_ & 0x4) == 4); } public int getState() { return this.state_; } public List<ItemOuterClass.ItemDetail> getAwardItemList() { return this.awardItem_; } public List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList() { return (List)this.awardItem_; } public int getAwardItemCount() { return this.awardItem_.size(); } public ItemOuterClass.ItemDetail getAwardItem(int index) { return this.awardItem_.get(index); } public ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int index) { return (ItemOuterClass.ItemDetailOrBuilder)this.awardItem_.get(index); } private void initFields() { this.id_ = 0; this.needDegree_ = 0; this.state_ = 0; this.awardItem_ = Collections.emptyList(); } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasId()) { this.memoizedIsInitialized = 0; return false; }  for (int i = 0; i < getAwardItemCount(); i++) { if (!getAwardItem(i).isInitialized()) { this.memoizedIsInitialized = 0; return false; }  }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.needDegree_);  if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.state_);  for (int i = 0; i < this.awardItem_.size(); i++) output.writeMessage(4, (MessageLite)this.awardItem_.get(i));  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.needDegree_);  if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.state_);  for (int i = 0; i < this.awardItem_.size(); i++) size += CodedOutputStream.computeMessageSize(4, (MessageLite)this.awardItem_.get(i));  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static DegreeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException { return (DegreeInfo)PARSER.parseFrom(data); } public static DegreeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DegreeInfo)PARSER.parseFrom(data, extensionRegistry); } static { defaultInstance.initFields(); }
/*      */     public static DegreeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException { return (DegreeInfo)PARSER.parseFrom(data); }
/*      */     public static DegreeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (DegreeInfo)PARSER.parseFrom(data, extensionRegistry); }
/*      */     public static DegreeInfo parseFrom(InputStream input) throws IOException { return (DegreeInfo)PARSER.parseFrom(input); }
/*      */     public static DegreeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DegreeInfo)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static DegreeInfo parseDelimitedFrom(InputStream input) throws IOException { return (DegreeInfo)PARSER.parseDelimitedFrom(input); }
/*      */     public static DegreeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DegreeInfo)PARSER.parseDelimitedFrom(input, extensionRegistry); }
/*      */     public static DegreeInfo parseFrom(CodedInputStream input) throws IOException { return (DegreeInfo)PARSER.parseFrom(input); }
/*      */     public static DegreeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (DegreeInfo)PARSER.parseFrom(input, extensionRegistry); }
/*      */     public static Builder newBuilder() { return Builder.create(); }
/*      */     public Builder newBuilderForType() { return newBuilder(); }
/*      */     public static Builder newBuilder(DegreeInfo prototype) { return newBuilder().mergeFrom(prototype); }
/*      */     public Builder toBuilder() { return newBuilder(this); }
/*      */     protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; }
/*      */     public static final class Builder extends GeneratedMessage.Builder<Builder> implements DailyActivity.DegreeInfoOrBuilder {
/*      */       private int bitField0_;
/*      */       private int id_;
/*      */       private int needDegree_;
/*      */       private int state_; private List<ItemOuterClass.ItemDetail> awardItem_; private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> awardItemBuilder_; public static final Descriptors.Descriptor getDescriptor() { return DailyActivity.internal_static_pomelo_dailyActivity_DegreeInfo_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return DailyActivity.internal_static_pomelo_dailyActivity_DegreeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyActivity.DegreeInfo.class, Builder.class); } private Builder() { this.awardItem_ = Collections.emptyList(); maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.awardItem_ = Collections.emptyList(); maybeForceBuilderInitialization(); } private void maybeForceBuilderInitialization() { if (DailyActivity.DegreeInfo.alwaysUseFieldBuilders) getAwardItemFieldBuilder();  } private static Builder create() { return new Builder(); } public Builder clear() { super.clear(); this.id_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.needDegree_ = 0; this.bitField0_ &= 0xFFFFFFFD; this.state_ = 0; this.bitField0_ &= 0xFFFFFFFB; if (this.awardItemBuilder_ == null) { this.awardItem_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; } else { this.awardItemBuilder_.clear(); }  return this; } public Builder clone() { return create().mergeFrom(buildPartial()); } public Descriptors.Descriptor getDescriptorForType() { return DailyActivity.internal_static_pomelo_dailyActivity_DegreeInfo_descriptor; } public DailyActivity.DegreeInfo getDefaultInstanceForType() { return DailyActivity.DegreeInfo.getDefaultInstance(); } public DailyActivity.DegreeInfo build() { DailyActivity.DegreeInfo result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; } public DailyActivity.DegreeInfo buildPartial() { DailyActivity.DegreeInfo result = new DailyActivity.DegreeInfo(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.id_ = this.id_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.needDegree_ = this.needDegree_; if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;  result.state_ = this.state_; if (this.awardItemBuilder_ == null) { if ((this.bitField0_ & 0x8) == 8) { this.awardItem_ = Collections.unmodifiableList(this.awardItem_); this.bitField0_ &= 0xFFFFFFF7; }  result.awardItem_ = this.awardItem_; } else { result.awardItem_ = this.awardItemBuilder_.build(); }  result.bitField0_ = to_bitField0_; onBuilt(); return result; } public Builder mergeFrom(Message other) { if (other instanceof DailyActivity.DegreeInfo) return mergeFrom((DailyActivity.DegreeInfo)other);  super.mergeFrom(other); return this; } public Builder mergeFrom(DailyActivity.DegreeInfo other) { if (other == DailyActivity.DegreeInfo.getDefaultInstance()) return this;  if (other.hasId()) setId(other.getId());  if (other.hasNeedDegree()) setNeedDegree(other.getNeedDegree());  if (other.hasState()) setState(other.getState());  if (this.awardItemBuilder_ == null) { if (!other.awardItem_.isEmpty()) { if (this.awardItem_.isEmpty()) { this.awardItem_ = other.awardItem_; this.bitField0_ &= 0xFFFFFFF7; } else { ensureAwardItemIsMutable(); this.awardItem_.addAll(other.awardItem_); }  onChanged(); }  } else if (!other.awardItem_.isEmpty()) { if (this.awardItemBuilder_.isEmpty()) { this.awardItemBuilder_.dispose(); this.awardItemBuilder_ = null; this.awardItem_ = other.awardItem_; this.bitField0_ &= 0xFFFFFFF7; this.awardItemBuilder_ = DailyActivity.DegreeInfo.alwaysUseFieldBuilders ? getAwardItemFieldBuilder() : null; } else { this.awardItemBuilder_.addAllMessages(other.awardItem_); }  }  mergeUnknownFields(other.getUnknownFields()); return this; } public final boolean isInitialized() { if (!hasId()) return false;  for (int i = 0; i < getAwardItemCount(); i++) { if (!getAwardItem(i).isInitialized()) return false;  }  return true; } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { DailyActivity.DegreeInfo parsedMessage = null; try { parsedMessage = (DailyActivity.DegreeInfo)DailyActivity.DegreeInfo.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (DailyActivity.DegreeInfo)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; } public boolean hasId() { return ((this.bitField0_ & 0x1) == 1); } public int getId() { return this.id_; } public Builder setId(int value) { this.bitField0_ |= 0x1; this.id_ = value; onChanged(); return this; } public Builder clearId() { this.bitField0_ &= 0xFFFFFFFE; this.id_ = 0; onChanged(); return this; } public boolean hasNeedDegree() { return ((this.bitField0_ & 0x2) == 2); } public int getNeedDegree() { return this.needDegree_; } public Builder setNeedDegree(int value) { this.bitField0_ |= 0x2; this.needDegree_ = value; onChanged(); return this; } public Builder clearNeedDegree() { this.bitField0_ &= 0xFFFFFFFD; this.needDegree_ = 0; onChanged(); return this; } public boolean hasState() { return ((this.bitField0_ & 0x4) == 4); } public int getState() { return this.state_; } public Builder setState(int value) { this.bitField0_ |= 0x4; this.state_ = value; onChanged(); return this; } public Builder clearState() { this.bitField0_ &= 0xFFFFFFFB; this.state_ = 0; onChanged(); return this; } private void ensureAwardItemIsMutable() { if ((this.bitField0_ & 0x8) != 8) { this.awardItem_ = new ArrayList<>(this.awardItem_); this.bitField0_ |= 0x8; }  } public List<ItemOuterClass.ItemDetail> getAwardItemList() { if (this.awardItemBuilder_ == null) return Collections.unmodifiableList(this.awardItem_);  return this.awardItemBuilder_.getMessageList(); } public int getAwardItemCount() { if (this.awardItemBuilder_ == null) return this.awardItem_.size();  return this.awardItemBuilder_.getCount(); } public ItemOuterClass.ItemDetail getAwardItem(int index) { if (this.awardItemBuilder_ == null) return this.awardItem_.get(index);  return (ItemOuterClass.ItemDetail)this.awardItemBuilder_.getMessage(index); } public Builder setAwardItem(int index, ItemOuterClass.ItemDetail value) { if (this.awardItemBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardItemIsMutable(); this.awardItem_.set(index, value); onChanged(); } else { this.awardItemBuilder_.setMessage(index, (GeneratedMessage)value); }  return this; } public Builder setAwardItem(int index, ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.awardItemBuilder_ == null) { ensureAwardItemIsMutable(); this.awardItem_.set(index, builderForValue.build()); onChanged(); } else { this.awardItemBuilder_.setMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAwardItem(ItemOuterClass.ItemDetail value) { if (this.awardItemBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardItemIsMutable(); this.awardItem_.add(value); onChanged(); } else { this.awardItemBuilder_.addMessage((GeneratedMessage)value); }  return this; } public Builder addAwardItem(int index, ItemOuterClass.ItemDetail value) { if (this.awardItemBuilder_ == null) { if (value == null) throw new NullPointerException();  ensureAwardItemIsMutable(); this.awardItem_.add(index, value); onChanged(); } else { this.awardItemBuilder_.addMessage(index, (GeneratedMessage)value); }  return this; } public Builder addAwardItem(ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.awardItemBuilder_ == null) { ensureAwardItemIsMutable(); this.awardItem_.add(builderForValue.build()); onChanged(); } else { this.awardItemBuilder_.addMessage((GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAwardItem(int index, ItemOuterClass.ItemDetail.Builder builderForValue) { if (this.awardItemBuilder_ == null) { ensureAwardItemIsMutable(); this.awardItem_.add(index, builderForValue.build()); onChanged(); } else { this.awardItemBuilder_.addMessage(index, (GeneratedMessage)builderForValue.build()); }  return this; } public Builder addAllAwardItem(Iterable<? extends ItemOuterClass.ItemDetail> values) { if (this.awardItemBuilder_ == null) { ensureAwardItemIsMutable(); AbstractMessageLite.Builder.addAll(values, this.awardItem_); onChanged(); } else { this.awardItemBuilder_.addAllMessages(values); }  return this; } public Builder clearAwardItem() { if (this.awardItemBuilder_ == null) { this.awardItem_ = Collections.emptyList(); this.bitField0_ &= 0xFFFFFFF7; onChanged(); } else { this.awardItemBuilder_.clear(); }  return this; } public Builder removeAwardItem(int index) { if (this.awardItemBuilder_ == null) { ensureAwardItemIsMutable(); this.awardItem_.remove(index); onChanged(); } else { this.awardItemBuilder_.remove(index); }  return this; } public ItemOuterClass.ItemDetail.Builder getAwardItemBuilder(int index) { return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().getBuilder(index); } public ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int index) { if (this.awardItemBuilder_ == null) return (ItemOuterClass.ItemDetailOrBuilder)this.awardItem_.get(index);  return (ItemOuterClass.ItemDetailOrBuilder)this.awardItemBuilder_.getMessageOrBuilder(index); } public List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList() { if (this.awardItemBuilder_ != null) return this.awardItemBuilder_.getMessageOrBuilderList();  return (List)Collections.unmodifiableList(this.awardItem_); } public ItemOuterClass.ItemDetail.Builder addAwardItemBuilder() { return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().addBuilder((GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance()); } public ItemOuterClass.ItemDetail.Builder addAwardItemBuilder(int index) { return (ItemOuterClass.ItemDetail.Builder)getAwardItemFieldBuilder().addBuilder(index, (GeneratedMessage)ItemOuterClass.ItemDetail.getDefaultInstance()); } public List<ItemOuterClass.ItemDetail.Builder> getAwardItemBuilderList() { return getAwardItemFieldBuilder().getBuilderList(); } private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getAwardItemFieldBuilder() { if (this.awardItemBuilder_ == null) { this.awardItemBuilder_ = new RepeatedFieldBuilder(this.awardItem_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean()); this.awardItem_ = null; }  return this.awardItemBuilder_; } }
/* 2857 */   } public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 2862 */     String[] descriptorData = { "\n\023dailyActivity.proto\022\024pomelo.dailyActivity\032\nitem.proto\"­\001\n\tDailyInfo\022\n\n\002id\030\001 \002(\005\022\017\n\007cur_num\030\002 \001(\005\022\017\n\007max_num\030\003 \001(\005\022\021\n\tperDegree\030\004 \001(\005\022\017\n\007lvLimit\030\005 \001(\005\022\022\n\nopenPeriod\030\006 \001(\t\022\016\n\006isOver\030\007 \001(\005\022*\n\tawardItem\030\b \003(\0132\027.pomelo.item.ItemDetail\"g\n\nDegreeInfo\022\n\n\002id\030\001 \002(\005\022\022\n\nneedDegree\030\002 \001(\005\022\r\n\005state\030\003 \001(\005\022*\n\tawardItem\030\004 \003(\0132\027.pomelo.item.ItemDetail" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2873 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 2877 */           DailyActivity.descriptor = root;
/* 2878 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 2882 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[] {
/*      */           
/* 2884 */           ItemOuterClass.getDescriptor() }, assigner);
/*      */   }
/*      */   
/* 2887 */   private static final Descriptors.Descriptor internal_static_pomelo_dailyActivity_DailyInfo_descriptor = getDescriptor().getMessageTypes().get(0);
/* 2888 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_dailyActivity_DailyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_dailyActivity_DailyInfo_descriptor, new String[] { "Id", "CurNum", "MaxNum", "PerDegree", "LvLimit", "OpenPeriod", "IsOver", "AwardItem" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2893 */   private static final Descriptors.Descriptor internal_static_pomelo_dailyActivity_DegreeInfo_descriptor = getDescriptor().getMessageTypes().get(1);
/* 2894 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_dailyActivity_DegreeInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_dailyActivity_DegreeInfo_descriptor, new String[] { "Id", "NeedDegree", "State", "AwardItem" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   static {
/* 2898 */     ItemOuterClass.getDescriptor();
/*      */   }
/*      */   
/*      */   public static interface DegreeInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasNeedDegree();
/*      */     
/*      */     int getNeedDegree();
/*      */     
/*      */     boolean hasState();
/*      */     
/*      */     int getState();
/*      */     
/*      */     List<ItemOuterClass.ItemDetail> getAwardItemList();
/*      */     
/*      */     ItemOuterClass.ItemDetail getAwardItem(int param1Int);
/*      */     
/*      */     int getAwardItemCount();
/*      */     
/*      */     List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList();
/*      */     
/*      */     ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int param1Int);
/*      */   }
/*      */   
/*      */   public static interface DailyInfoOrBuilder extends MessageOrBuilder {
/*      */     boolean hasId();
/*      */     
/*      */     int getId();
/*      */     
/*      */     boolean hasCurNum();
/*      */     
/*      */     int getCurNum();
/*      */     
/*      */     boolean hasMaxNum();
/*      */     
/*      */     int getMaxNum();
/*      */     
/*      */     boolean hasPerDegree();
/*      */     
/*      */     int getPerDegree();
/*      */     
/*      */     boolean hasLvLimit();
/*      */     
/*      */     int getLvLimit();
/*      */     
/*      */     boolean hasOpenPeriod();
/*      */     
/*      */     String getOpenPeriod();
/*      */     
/*      */     ByteString getOpenPeriodBytes();
/*      */     
/*      */     boolean hasIsOver();
/*      */     
/*      */     int getIsOver();
/*      */     
/*      */     List<ItemOuterClass.ItemDetail> getAwardItemList();
/*      */     
/*      */     ItemOuterClass.ItemDetail getAwardItem(int param1Int);
/*      */     
/*      */     int getAwardItemCount();
/*      */     
/*      */     List<? extends ItemOuterClass.ItemDetailOrBuilder> getAwardItemOrBuilderList();
/*      */     
/*      */     ItemOuterClass.ItemDetailOrBuilder getAwardItemOrBuilder(int param1Int);
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\dailyActivity\DailyActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */