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
/*      */ import com.google.protobuf.SingleFieldBuilder;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class HookSetHandler
/*      */ {
/*      */   public static void registerAllExtensions(ExtensionRegistry registry) {}
/*      */   
/*      */   public static final class HookSetData
/*      */     extends GeneratedMessage
/*      */     implements HookSetDataOrBuilder
/*      */   {
/* 1702 */     private static final HookSetData defaultInstance = new HookSetData(true); private final UnknownFieldSet unknownFields; private HookSetData(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private HookSetData(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static HookSetData getDefaultInstance() { return defaultInstance; } public HookSetData getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private HookSetData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int length, limit, tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.hpPercent_ = input.readInt32(); break;case 16: this.bitField0_ |= 0x2; this.mpPercent_ = input.readInt32(); break;case 26: bs = input.readBytes(); this.bitField0_ |= 0x4; this.hpItemCode_ = bs; break;case 34: bs = input.readBytes(); this.bitField0_ |= 0x8; this.mpItemCode_ = bs; break;case 40: this.bitField0_ |= 0x10; this.pkSet_ = input.readInt32(); break;case 48: if ((mutable_bitField0_ & 0x20) != 32) { this.meltQcolor_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  this.meltQcolor_.add(Integer.valueOf(input.readInt32())); break;case 50: length = input.readRawVarint32(); limit = input.pushLimit(length); if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) { this.meltQcolor_ = new ArrayList<>(); mutable_bitField0_ |= 0x20; }  while (input.getBytesUntilLimit() > 0) this.meltQcolor_.add(Integer.valueOf(input.readInt32()));  input.popLimit(limit); break;case 56: this.bitField0_ |= 0x20; this.autoBuyHpItem_ = input.readInt32(); break;case 64: this.bitField0_ |= 0x40; this.autoBuyMpItem_ = input.readInt32(); break;case 72: this.bitField0_ |= 0x80; this.fieldMaphook_ = input.readInt32(); break;case 80: this.bitField0_ |= 0x100; this.areaMaphook_ = input.readInt32(); break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { if ((mutable_bitField0_ & 0x20) == 32) this.meltQcolor_ = Collections.unmodifiableList(this.meltQcolor_);  this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return HookSetHandler.internal_static_pomelo_area_HookSetData_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return HookSetHandler.internal_static_pomelo_area_HookSetData_fieldAccessorTable.ensureFieldAccessorsInitialized(HookSetData.class, Builder.class); } public static Parser<HookSetData> PARSER = (Parser<HookSetData>)new AbstractParser<HookSetData>() { public HookSetHandler.HookSetData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new HookSetHandler.HookSetData(input, extensionRegistry); } }
/* 1703 */     ; private int bitField0_; public static final int HPPERCENT_FIELD_NUMBER = 1; private int hpPercent_; public static final int MPPERCENT_FIELD_NUMBER = 2; private int mpPercent_; public static final int HPITEMCODE_FIELD_NUMBER = 3; private Object hpItemCode_; public static final int MPITEMCODE_FIELD_NUMBER = 4; private Object mpItemCode_; public static final int PKSET_FIELD_NUMBER = 5; private int pkSet_; public static final int MELTQCOLOR_FIELD_NUMBER = 6; private List<Integer> meltQcolor_; public static final int AUTOBUYHPITEM_FIELD_NUMBER = 7; private int autoBuyHpItem_; public static final int AUTOBUYMPITEM_FIELD_NUMBER = 8; private int autoBuyMpItem_; public static final int FIELDMAPHOOK_FIELD_NUMBER = 9; private int fieldMaphook_; public static final int AREAMAPHOOK_FIELD_NUMBER = 10; private int areaMaphook_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<HookSetData> getParserForType() { return PARSER; } public boolean hasHpPercent() { return ((this.bitField0_ & 0x1) == 1); } public int getHpPercent() { return this.hpPercent_; } public boolean hasMpPercent() { return ((this.bitField0_ & 0x2) == 2); } public int getMpPercent() { return this.mpPercent_; } public boolean hasHpItemCode() { return ((this.bitField0_ & 0x4) == 4); } public String getHpItemCode() { Object ref = this.hpItemCode_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.hpItemCode_ = s;  return s; } public ByteString getHpItemCodeBytes() { Object ref = this.hpItemCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.hpItemCode_ = b; return b; }  return (ByteString)ref; } public boolean hasMpItemCode() { return ((this.bitField0_ & 0x8) == 8); } public String getMpItemCode() { Object ref = this.mpItemCode_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.mpItemCode_ = s;  return s; } public ByteString getMpItemCodeBytes() { Object ref = this.mpItemCode_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.mpItemCode_ = b; return b; }  return (ByteString)ref; } public boolean hasPkSet() { return ((this.bitField0_ & 0x10) == 16); } public int getPkSet() { return this.pkSet_; } public List<Integer> getMeltQcolorList() { return this.meltQcolor_; } public int getMeltQcolorCount() { return this.meltQcolor_.size(); } public int getMeltQcolor(int index) { return ((Integer)this.meltQcolor_.get(index)).intValue(); } public boolean hasAutoBuyHpItem() { return ((this.bitField0_ & 0x20) == 32); } public int getAutoBuyHpItem() { return this.autoBuyHpItem_; } public boolean hasAutoBuyMpItem() { return ((this.bitField0_ & 0x40) == 64); } public int getAutoBuyMpItem() { return this.autoBuyMpItem_; } public boolean hasFieldMaphook() { return ((this.bitField0_ & 0x80) == 128); } public int getFieldMaphook() { return this.fieldMaphook_; } public boolean hasAreaMaphook() { return ((this.bitField0_ & 0x100) == 256); } public int getAreaMaphook() { return this.areaMaphook_; } private void initFields() { this.hpPercent_ = 0; this.mpPercent_ = 0; this.hpItemCode_ = ""; this.mpItemCode_ = ""; this.pkSet_ = 0; this.meltQcolor_ = Collections.emptyList(); this.autoBuyHpItem_ = 0; this.autoBuyMpItem_ = 0; this.fieldMaphook_ = 0; this.areaMaphook_ = 0; } static { defaultInstance.initFields(); }
/*      */      public final boolean isInitialized() {
/*      */       byte isInitialized = this.memoizedIsInitialized;
/*      */       if (isInitialized == 1)
/*      */         return true; 
/*      */       if (isInitialized == 0)
/*      */         return false; 
/*      */       if (!hasHpPercent()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasMpPercent()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasHpItemCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasMpItemCode()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasPkSet()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasFieldMaphook()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!hasAreaMaphook()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       this.memoizedIsInitialized = 1;
/*      */       return true;
/*      */     } public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         output.writeInt32(1, this.hpPercent_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         output.writeInt32(2, this.mpPercent_); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         output.writeBytes(3, getHpItemCodeBytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         output.writeBytes(4, getMpItemCodeBytes()); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         output.writeInt32(5, this.pkSet_); 
/*      */       for (int i = 0; i < this.meltQcolor_.size(); i++)
/*      */         output.writeInt32(6, ((Integer)this.meltQcolor_.get(i)).intValue()); 
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         output.writeInt32(7, this.autoBuyHpItem_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         output.writeInt32(8, this.autoBuyMpItem_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         output.writeInt32(9, this.fieldMaphook_); 
/*      */       if ((this.bitField0_ & 0x100) == 256)
/*      */         output.writeInt32(10, this.areaMaphook_); 
/*      */       getUnknownFields().writeTo(output);
/*      */     } public int getSerializedSize() {
/*      */       int size = this.memoizedSerializedSize;
/*      */       if (size != -1)
/*      */         return size; 
/*      */       size = 0;
/*      */       if ((this.bitField0_ & 0x1) == 1)
/*      */         size += CodedOutputStream.computeInt32Size(1, this.hpPercent_); 
/*      */       if ((this.bitField0_ & 0x2) == 2)
/*      */         size += CodedOutputStream.computeInt32Size(2, this.mpPercent_); 
/*      */       if ((this.bitField0_ & 0x4) == 4)
/*      */         size += CodedOutputStream.computeBytesSize(3, getHpItemCodeBytes()); 
/*      */       if ((this.bitField0_ & 0x8) == 8)
/*      */         size += CodedOutputStream.computeBytesSize(4, getMpItemCodeBytes()); 
/*      */       if ((this.bitField0_ & 0x10) == 16)
/*      */         size += CodedOutputStream.computeInt32Size(5, this.pkSet_); 
/*      */       int dataSize = 0;
/*      */       for (int i = 0; i < this.meltQcolor_.size(); i++)
/*      */         dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.meltQcolor_.get(i)).intValue()); 
/*      */       size += dataSize;
/*      */       size += 1 * getMeltQcolorList().size();
/*      */       if ((this.bitField0_ & 0x20) == 32)
/*      */         size += CodedOutputStream.computeInt32Size(7, this.autoBuyHpItem_); 
/*      */       if ((this.bitField0_ & 0x40) == 64)
/*      */         size += CodedOutputStream.computeInt32Size(8, this.autoBuyMpItem_); 
/*      */       if ((this.bitField0_ & 0x80) == 128)
/*      */         size += CodedOutputStream.computeInt32Size(9, this.fieldMaphook_); 
/*      */       if ((this.bitField0_ & 0x100) == 256)
/*      */         size += CodedOutputStream.computeInt32Size(10, this.areaMaphook_); 
/*      */       size += getUnknownFields().getSerializedSize();
/*      */       this.memoizedSerializedSize = size;
/*      */       return size;
/*      */     } protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     } public static HookSetData parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (HookSetData)PARSER.parseFrom(data);
/*      */     } public static HookSetData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (HookSetData)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static HookSetData parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (HookSetData)PARSER.parseFrom(data);
/*      */     } public static HookSetData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (HookSetData)PARSER.parseFrom(data, extensionRegistry);
/*      */     } public static HookSetData parseFrom(InputStream input) throws IOException {
/*      */       return (HookSetData)PARSER.parseFrom(input);
/*      */     } public static HookSetData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (HookSetData)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static HookSetData parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (HookSetData)PARSER.parseDelimitedFrom(input);
/*      */     } public static HookSetData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (HookSetData)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     } public static HookSetData parseFrom(CodedInputStream input) throws IOException {
/*      */       return (HookSetData)PARSER.parseFrom(input);
/*      */     } public static HookSetData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (HookSetData)PARSER.parseFrom(input, extensionRegistry);
/*      */     } public static Builder newBuilder() {
/*      */       return Builder.create();
/*      */     } public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     } public static Builder newBuilder(HookSetData prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     } public Builder toBuilder() {
/*      */       return newBuilder(this);
/*      */     } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
/*      */       Builder builder = new Builder(parent);
/*      */       return builder;
/*      */     } public static final class Builder extends GeneratedMessage.Builder<Builder> implements HookSetHandler.HookSetDataOrBuilder {
/*      */       private int bitField0_; private int hpPercent_; private int mpPercent_; private Object hpItemCode_; private Object mpItemCode_; private int pkSet_; private List<Integer> meltQcolor_; private int autoBuyHpItem_; private int autoBuyMpItem_; private int fieldMaphook_; private int areaMaphook_; public static final Descriptors.Descriptor getDescriptor() {
/*      */         return HookSetHandler.internal_static_pomelo_area_HookSetData_descriptor;
/*      */       } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return HookSetHandler.internal_static_pomelo_area_HookSetData_fieldAccessorTable.ensureFieldAccessorsInitialized(HookSetHandler.HookSetData.class, Builder.class);
/*      */       } private Builder() {
/*      */         this.hpItemCode_ = "";
/*      */         this.mpItemCode_ = "";
/*      */         this.meltQcolor_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.hpItemCode_ = "";
/*      */         this.mpItemCode_ = "";
/*      */         this.meltQcolor_ = Collections.emptyList();
/*      */         maybeForceBuilderInitialization();
/*      */       } private void maybeForceBuilderInitialization() {
/*      */         if (HookSetHandler.HookSetData.alwaysUseFieldBuilders);
/*      */       } private static Builder create() {
/*      */         return new Builder();
/*      */       } public Builder clear() {
/*      */         super.clear();
/*      */         this.hpPercent_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.mpPercent_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.hpItemCode_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.mpItemCode_ = "";
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.pkSet_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.meltQcolor_ = Collections.emptyList();
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         this.autoBuyHpItem_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.autoBuyMpItem_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.fieldMaphook_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFEFF;
/*      */         this.areaMaphook_ = 0;
/*      */         this.bitField0_ &= 0xFFFFFDFF;
/*      */         return this;
/*      */       } public Builder clone() {
/*      */         return create().mergeFrom(buildPartial());
/*      */       } public Descriptors.Descriptor getDescriptorForType() {
/*      */         return HookSetHandler.internal_static_pomelo_area_HookSetData_descriptor;
/*      */       } public HookSetHandler.HookSetData getDefaultInstanceForType() {
/*      */         return HookSetHandler.HookSetData.getDefaultInstance();
/*      */       } public HookSetHandler.HookSetData build() {
/*      */         HookSetHandler.HookSetData result = buildPartial();
/*      */         if (!result.isInitialized())
/*      */           throw newUninitializedMessageException(result); 
/*      */         return result;
/*      */       } public HookSetHandler.HookSetData buildPartial() {
/*      */         HookSetHandler.HookSetData result = new HookSetHandler.HookSetData(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1)
/*      */           to_bitField0_ |= 0x1; 
/*      */         result.hpPercent_ = this.hpPercent_;
/*      */         if ((from_bitField0_ & 0x2) == 2)
/*      */           to_bitField0_ |= 0x2; 
/*      */         result.mpPercent_ = this.mpPercent_;
/*      */         if ((from_bitField0_ & 0x4) == 4)
/*      */           to_bitField0_ |= 0x4; 
/*      */         result.hpItemCode_ = this.hpItemCode_;
/*      */         if ((from_bitField0_ & 0x8) == 8)
/*      */           to_bitField0_ |= 0x8; 
/*      */         result.mpItemCode_ = this.mpItemCode_;
/*      */         if ((from_bitField0_ & 0x10) == 16)
/*      */           to_bitField0_ |= 0x10; 
/*      */         result.pkSet_ = this.pkSet_;
/*      */         if ((this.bitField0_ & 0x20) == 32) {
/*      */           this.meltQcolor_ = Collections.unmodifiableList(this.meltQcolor_);
/*      */           this.bitField0_ &= 0xFFFFFFDF;
/*      */         } 
/*      */         result.meltQcolor_ = this.meltQcolor_;
/*      */         if ((from_bitField0_ & 0x40) == 64)
/*      */           to_bitField0_ |= 0x20; 
/*      */         result.autoBuyHpItem_ = this.autoBuyHpItem_;
/*      */         if ((from_bitField0_ & 0x80) == 128)
/*      */           to_bitField0_ |= 0x40; 
/*      */         result.autoBuyMpItem_ = this.autoBuyMpItem_;
/*      */         if ((from_bitField0_ & 0x100) == 256)
/*      */           to_bitField0_ |= 0x80; 
/*      */         result.fieldMaphook_ = this.fieldMaphook_;
/*      */         if ((from_bitField0_ & 0x200) == 512)
/*      */           to_bitField0_ |= 0x100; 
/*      */         result.areaMaphook_ = this.areaMaphook_;
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       } public Builder mergeFrom(Message other) {
/*      */         if (other instanceof HookSetHandler.HookSetData)
/*      */           return mergeFrom((HookSetHandler.HookSetData)other); 
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       } public Builder mergeFrom(HookSetHandler.HookSetData other) {
/*      */         if (other == HookSetHandler.HookSetData.getDefaultInstance())
/*      */           return this; 
/*      */         if (other.hasHpPercent())
/*      */           setHpPercent(other.getHpPercent()); 
/*      */         if (other.hasMpPercent())
/*      */           setMpPercent(other.getMpPercent()); 
/*      */         if (other.hasHpItemCode()) {
/*      */           this.bitField0_ |= 0x4;
/*      */           this.hpItemCode_ = other.hpItemCode_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasMpItemCode()) {
/*      */           this.bitField0_ |= 0x8;
/*      */           this.mpItemCode_ = other.mpItemCode_;
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasPkSet())
/*      */           setPkSet(other.getPkSet()); 
/*      */         if (!other.meltQcolor_.isEmpty()) {
/*      */           if (this.meltQcolor_.isEmpty()) {
/*      */             this.meltQcolor_ = other.meltQcolor_;
/*      */             this.bitField0_ &= 0xFFFFFFDF;
/*      */           } else {
/*      */             ensureMeltQcolorIsMutable();
/*      */             this.meltQcolor_.addAll(other.meltQcolor_);
/*      */           } 
/*      */           onChanged();
/*      */         } 
/*      */         if (other.hasAutoBuyHpItem())
/*      */           setAutoBuyHpItem(other.getAutoBuyHpItem()); 
/*      */         if (other.hasAutoBuyMpItem())
/*      */           setAutoBuyMpItem(other.getAutoBuyMpItem()); 
/*      */         if (other.hasFieldMaphook())
/*      */           setFieldMaphook(other.getFieldMaphook()); 
/*      */         if (other.hasAreaMaphook())
/*      */           setAreaMaphook(other.getAreaMaphook()); 
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       } public final boolean isInitialized() {
/*      */         if (!hasHpPercent())
/*      */           return false; 
/*      */         if (!hasMpPercent())
/*      */           return false; 
/*      */         if (!hasHpItemCode())
/*      */           return false; 
/*      */         if (!hasMpItemCode())
/*      */           return false; 
/*      */         if (!hasPkSet())
/*      */           return false; 
/*      */         if (!hasFieldMaphook())
/*      */           return false; 
/*      */         if (!hasAreaMaphook())
/*      */           return false; 
/*      */         return true;
/*      */       } public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         HookSetHandler.HookSetData parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (HookSetHandler.HookSetData)HookSetHandler.HookSetData.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (HookSetHandler.HookSetData)e.getUnfinishedMessage();
/*      */           throw e;
/*      */         } finally {
/*      */           if (parsedMessage != null)
/*      */             mergeFrom(parsedMessage); 
/*      */         } 
/*      */         return this;
/*      */       } public boolean hasHpPercent() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       } public int getHpPercent() {
/*      */         return this.hpPercent_;
/*      */       } public Builder setHpPercent(int value) {
/*      */         this.bitField0_ |= 0x1;
/*      */         this.hpPercent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearHpPercent() {
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         this.hpPercent_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasMpPercent() {
/*      */         return ((this.bitField0_ & 0x2) == 2);
/*      */       } public int getMpPercent() {
/*      */         return this.mpPercent_;
/*      */       } public Builder setMpPercent(int value) {
/*      */         this.bitField0_ |= 0x2;
/*      */         this.mpPercent_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearMpPercent() {
/*      */         this.bitField0_ &= 0xFFFFFFFD;
/*      */         this.mpPercent_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasHpItemCode() {
/*      */         return ((this.bitField0_ & 0x4) == 4);
/*      */       } public String getHpItemCode() {
/*      */         Object ref = this.hpItemCode_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.hpItemCode_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getHpItemCodeBytes() {
/*      */         Object ref = this.hpItemCode_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.hpItemCode_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setHpItemCode(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.hpItemCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearHpItemCode() {
/*      */         this.bitField0_ &= 0xFFFFFFFB;
/*      */         this.hpItemCode_ = HookSetHandler.HookSetData.getDefaultInstance().getHpItemCode();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setHpItemCodeBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x4;
/*      */         this.hpItemCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasMpItemCode() {
/*      */         return ((this.bitField0_ & 0x8) == 8);
/*      */       } public String getMpItemCode() {
/*      */         Object ref = this.mpItemCode_;
/*      */         if (!(ref instanceof String)) {
/*      */           ByteString bs = (ByteString)ref;
/*      */           String s = bs.toStringUtf8();
/*      */           if (bs.isValidUtf8())
/*      */             this.mpItemCode_ = s; 
/*      */           return s;
/*      */         } 
/*      */         return (String)ref;
/*      */       } public ByteString getMpItemCodeBytes() {
/*      */         Object ref = this.mpItemCode_;
/*      */         if (ref instanceof String) {
/*      */           ByteString b = ByteString.copyFromUtf8((String)ref);
/*      */           this.mpItemCode_ = b;
/*      */           return b;
/*      */         } 
/*      */         return (ByteString)ref;
/*      */       } public Builder setMpItemCode(String value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x8;
/*      */         this.mpItemCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder clearMpItemCode() {
/*      */         this.bitField0_ &= 0xFFFFFFF7;
/*      */         this.mpItemCode_ = HookSetHandler.HookSetData.getDefaultInstance().getMpItemCode();
/*      */         onChanged();
/*      */         return this;
/*      */       } public Builder setMpItemCodeBytes(ByteString value) {
/*      */         if (value == null)
/*      */           throw new NullPointerException(); 
/*      */         this.bitField0_ |= 0x8;
/*      */         this.mpItemCode_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       } public boolean hasPkSet() {
/*      */         return ((this.bitField0_ & 0x10) == 16);
/*      */       } public int getPkSet() {
/*      */         return this.pkSet_;
/*      */       }
/*      */       public Builder setPkSet(int value) {
/*      */         this.bitField0_ |= 0x10;
/*      */         this.pkSet_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearPkSet() {
/*      */         this.bitField0_ &= 0xFFFFFFEF;
/*      */         this.pkSet_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       private void ensureMeltQcolorIsMutable() {
/*      */         if ((this.bitField0_ & 0x20) != 32) {
/*      */           this.meltQcolor_ = new ArrayList<>(this.meltQcolor_);
/*      */           this.bitField0_ |= 0x20;
/*      */         } 
/*      */       }
/*      */       public List<Integer> getMeltQcolorList() {
/*      */         return Collections.unmodifiableList(this.meltQcolor_);
/*      */       }
/*      */       public int getMeltQcolorCount() {
/*      */         return this.meltQcolor_.size();
/*      */       }
/*      */       public int getMeltQcolor(int index) {
/*      */         return ((Integer)this.meltQcolor_.get(index)).intValue();
/*      */       }
/*      */       public Builder setMeltQcolor(int index, int value) {
/*      */         ensureMeltQcolorIsMutable();
/*      */         this.meltQcolor_.set(index, Integer.valueOf(value));
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder addMeltQcolor(int value) {
/*      */         ensureMeltQcolorIsMutable();
/*      */         this.meltQcolor_.add(Integer.valueOf(value));
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder addAllMeltQcolor(Iterable<? extends Integer> values) {
/*      */         ensureMeltQcolorIsMutable();
/*      */         AbstractMessageLite.Builder.addAll(values, this.meltQcolor_);
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearMeltQcolor() {
/*      */         this.meltQcolor_ = Collections.emptyList();
/*      */         this.bitField0_ &= 0xFFFFFFDF;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasAutoBuyHpItem() {
/*      */         return ((this.bitField0_ & 0x40) == 64);
/*      */       }
/*      */       public int getAutoBuyHpItem() {
/*      */         return this.autoBuyHpItem_;
/*      */       }
/*      */       public Builder setAutoBuyHpItem(int value) {
/*      */         this.bitField0_ |= 0x40;
/*      */         this.autoBuyHpItem_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearAutoBuyHpItem() {
/*      */         this.bitField0_ &= 0xFFFFFFBF;
/*      */         this.autoBuyHpItem_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasAutoBuyMpItem() {
/*      */         return ((this.bitField0_ & 0x80) == 128);
/*      */       }
/*      */       public int getAutoBuyMpItem() {
/*      */         return this.autoBuyMpItem_;
/*      */       }
/*      */       public Builder setAutoBuyMpItem(int value) {
/*      */         this.bitField0_ |= 0x80;
/*      */         this.autoBuyMpItem_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearAutoBuyMpItem() {
/*      */         this.bitField0_ &= 0xFFFFFF7F;
/*      */         this.autoBuyMpItem_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasFieldMaphook() {
/*      */         return ((this.bitField0_ & 0x100) == 256);
/*      */       }
/*      */       public int getFieldMaphook() {
/*      */         return this.fieldMaphook_;
/*      */       }
/*      */       public Builder setFieldMaphook(int value) {
/*      */         this.bitField0_ |= 0x100;
/*      */         this.fieldMaphook_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearFieldMaphook() {
/*      */         this.bitField0_ &= 0xFFFFFEFF;
/*      */         this.fieldMaphook_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public boolean hasAreaMaphook() {
/*      */         return ((this.bitField0_ & 0x200) == 512);
/*      */       }
/*      */       public int getAreaMaphook() {
/*      */         return this.areaMaphook_;
/*      */       }
/*      */       public Builder setAreaMaphook(int value) {
/*      */         this.bitField0_ |= 0x200;
/*      */         this.areaMaphook_ = value;
/*      */         onChanged();
/*      */         return this;
/*      */       }
/*      */       public Builder clearAreaMaphook() {
/*      */         this.bitField0_ &= 0xFFFFFDFF;
/*      */         this.areaMaphook_ = 0;
/*      */         onChanged();
/*      */         return this;
/*      */       } } }
/* 2226 */   public static final class ChangeHookSetRequest extends GeneratedMessage implements ChangeHookSetRequestOrBuilder { private static final ChangeHookSetRequest defaultInstance = new ChangeHookSetRequest(true); private final UnknownFieldSet unknownFields; private ChangeHookSetRequest(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChangeHookSetRequest(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChangeHookSetRequest getDefaultInstance() { return defaultInstance; } public ChangeHookSetRequest getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChangeHookSetRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { HookSetHandler.HookSetData.Builder subBuilder; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 10: subBuilder = null; if ((this.bitField0_ & 0x1) == 1) subBuilder = this.c2SHookSetData_.toBuilder();  this.c2SHookSetData_ = (HookSetHandler.HookSetData)input.readMessage(HookSetHandler.HookSetData.PARSER, extensionRegistry); if (subBuilder != null) { subBuilder.mergeFrom(this.c2SHookSetData_); this.c2SHookSetData_ = subBuilder.buildPartial(); }  this.bitField0_ |= 0x1; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetRequest_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeHookSetRequest.class, Builder.class); } public static Parser<ChangeHookSetRequest> PARSER = (Parser<ChangeHookSetRequest>)new AbstractParser<ChangeHookSetRequest>() { public HookSetHandler.ChangeHookSetRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new HookSetHandler.ChangeHookSetRequest(input, extensionRegistry); } }
/* 2227 */     ; private int bitField0_; public static final int C2S_HOOKSETDATA_FIELD_NUMBER = 1; private HookSetHandler.HookSetData c2SHookSetData_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChangeHookSetRequest> getParserForType() { return PARSER; } public boolean hasC2SHookSetData() { return ((this.bitField0_ & 0x1) == 1); } public HookSetHandler.HookSetData getC2SHookSetData() { return this.c2SHookSetData_; } public HookSetHandler.HookSetDataOrBuilder getC2SHookSetDataOrBuilder() { return this.c2SHookSetData_; } static { defaultInstance.initFields(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void initFields() {
/*      */       this.c2SHookSetData_ = HookSetHandler.HookSetData.getDefaultInstance();
/*      */     }
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
/*      */       if (!hasC2SHookSetData()) {
/*      */         this.memoizedIsInitialized = 0;
/*      */         return false;
/*      */       } 
/*      */       if (!getC2SHookSetData().isInitialized()) {
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
/*      */     public void writeTo(CodedOutputStream output) throws IOException {
/*      */       getSerializedSize();
/*      */       if ((this.bitField0_ & 0x1) == 1) {
/*      */         output.writeMessage(1, (MessageLite)this.c2SHookSetData_);
/*      */       }
/*      */       getUnknownFields().writeTo(output);
/*      */     }
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
/*      */         size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.c2SHookSetData_);
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
/*      */     protected Object writeReplace() throws ObjectStreamException {
/*      */       return super.writeReplace();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(data);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(data, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(InputStream input) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseDelimitedFrom(InputStream input) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseDelimitedFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseDelimitedFrom(input, extensionRegistry);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(CodedInputStream input) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(input);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChangeHookSetRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */       return (ChangeHookSetRequest)PARSER.parseFrom(input, extensionRegistry);
/*      */     }
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
/*      */     public Builder newBuilderForType() {
/*      */       return newBuilder();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder newBuilder(ChangeHookSetRequest prototype) {
/*      */       return newBuilder().mergeFrom(prototype);
/*      */     }
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
/*      */     public static final class Builder
/*      */       extends GeneratedMessage.Builder<Builder>
/*      */       implements HookSetHandler.ChangeHookSetRequestOrBuilder
/*      */     {
/*      */       private int bitField0_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private HookSetHandler.HookSetData c2SHookSetData_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private SingleFieldBuilder<HookSetHandler.HookSetData, HookSetHandler.HookSetData.Builder, HookSetHandler.HookSetDataOrBuilder> c2SHookSetDataBuilder_;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public static final Descriptors.Descriptor getDescriptor() {
/*      */         return HookSetHandler.internal_static_pomelo_area_ChangeHookSetRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
/*      */         return HookSetHandler.internal_static_pomelo_area_ChangeHookSetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(HookSetHandler.ChangeHookSetRequest.class, Builder.class);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder() {
/*      */         this.c2SHookSetData_ = HookSetHandler.HookSetData.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private Builder(GeneratedMessage.BuilderParent parent) {
/*      */         super(parent);
/*      */         this.c2SHookSetData_ = HookSetHandler.HookSetData.getDefaultInstance();
/*      */         maybeForceBuilderInitialization();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void maybeForceBuilderInitialization() {
/*      */         if (HookSetHandler.ChangeHookSetRequest.alwaysUseFieldBuilders) {
/*      */           getC2SHookSetDataFieldBuilder();
/*      */         }
/*      */       }
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
/*      */       public Builder clear() {
/*      */         super.clear();
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           this.c2SHookSetData_ = HookSetHandler.HookSetData.getDefaultInstance();
/*      */         } else {
/*      */           this.c2SHookSetDataBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         return this;
/*      */       }
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
/*      */       public Descriptors.Descriptor getDescriptorForType() {
/*      */         return HookSetHandler.internal_static_pomelo_area_ChangeHookSetRequest_descriptor;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public HookSetHandler.ChangeHookSetRequest getDefaultInstanceForType() {
/*      */         return HookSetHandler.ChangeHookSetRequest.getDefaultInstance();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public HookSetHandler.ChangeHookSetRequest build() {
/*      */         HookSetHandler.ChangeHookSetRequest result = buildPartial();
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
/*      */       public HookSetHandler.ChangeHookSetRequest buildPartial() {
/*      */         HookSetHandler.ChangeHookSetRequest result = new HookSetHandler.ChangeHookSetRequest(this);
/*      */         int from_bitField0_ = this.bitField0_;
/*      */         int to_bitField0_ = 0;
/*      */         if ((from_bitField0_ & 0x1) == 1) {
/*      */           to_bitField0_ |= 0x1;
/*      */         }
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           result.c2SHookSetData_ = this.c2SHookSetData_;
/*      */         } else {
/*      */           result.c2SHookSetData_ = (HookSetHandler.HookSetData)this.c2SHookSetDataBuilder_.build();
/*      */         } 
/*      */         result.bitField0_ = to_bitField0_;
/*      */         onBuilt();
/*      */         return result;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(Message other) {
/*      */         if (other instanceof HookSetHandler.ChangeHookSetRequest) {
/*      */           return mergeFrom((HookSetHandler.ChangeHookSetRequest)other);
/*      */         }
/*      */         super.mergeFrom(other);
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(HookSetHandler.ChangeHookSetRequest other) {
/*      */         if (other == HookSetHandler.ChangeHookSetRequest.getDefaultInstance()) {
/*      */           return this;
/*      */         }
/*      */         if (other.hasC2SHookSetData()) {
/*      */           mergeC2SHookSetData(other.getC2SHookSetData());
/*      */         }
/*      */         mergeUnknownFields(other.getUnknownFields());
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public final boolean isInitialized() {
/*      */         if (!hasC2SHookSetData()) {
/*      */           return false;
/*      */         }
/*      */         if (!getC2SHookSetData().isInitialized()) {
/*      */           return false;
/*      */         }
/*      */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
/*      */         HookSetHandler.ChangeHookSetRequest parsedMessage = null;
/*      */         try {
/*      */           parsedMessage = (HookSetHandler.ChangeHookSetRequest)HookSetHandler.ChangeHookSetRequest.PARSER.parsePartialFrom(input, extensionRegistry);
/*      */         } catch (InvalidProtocolBufferException e) {
/*      */           parsedMessage = (HookSetHandler.ChangeHookSetRequest)e.getUnfinishedMessage();
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
/*      */       public boolean hasC2SHookSetData() {
/*      */         return ((this.bitField0_ & 0x1) == 1);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public HookSetHandler.HookSetData getC2SHookSetData() {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           return this.c2SHookSetData_;
/*      */         }
/*      */         return (HookSetHandler.HookSetData)this.c2SHookSetDataBuilder_.getMessage();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SHookSetData(HookSetHandler.HookSetData value) {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           if (value == null) {
/*      */             throw new NullPointerException();
/*      */           }
/*      */           this.c2SHookSetData_ = value;
/*      */           onChanged();
/*      */         } else {
/*      */           this.c2SHookSetDataBuilder_.setMessage(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x1;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder setC2SHookSetData(HookSetHandler.HookSetData.Builder builderForValue) {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           this.c2SHookSetData_ = builderForValue.build();
/*      */           onChanged();
/*      */         } else {
/*      */           this.c2SHookSetDataBuilder_.setMessage(builderForValue.build());
/*      */         } 
/*      */         this.bitField0_ |= 0x1;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder mergeC2SHookSetData(HookSetHandler.HookSetData value) {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           if ((this.bitField0_ & 0x1) == 1 && this.c2SHookSetData_ != HookSetHandler.HookSetData.getDefaultInstance()) {
/*      */             this.c2SHookSetData_ = HookSetHandler.HookSetData.newBuilder(this.c2SHookSetData_).mergeFrom(value).buildPartial();
/*      */           } else {
/*      */             this.c2SHookSetData_ = value;
/*      */           } 
/*      */           onChanged();
/*      */         } else {
/*      */           this.c2SHookSetDataBuilder_.mergeFrom(value);
/*      */         } 
/*      */         this.bitField0_ |= 0x1;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Builder clearC2SHookSetData() {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           this.c2SHookSetData_ = HookSetHandler.HookSetData.getDefaultInstance();
/*      */           onChanged();
/*      */         } else {
/*      */           this.c2SHookSetDataBuilder_.clear();
/*      */         } 
/*      */         this.bitField0_ &= 0xFFFFFFFE;
/*      */         return this;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public HookSetHandler.HookSetData.Builder getC2SHookSetDataBuilder() {
/*      */         this.bitField0_ |= 0x1;
/*      */         onChanged();
/*      */         return (HookSetHandler.HookSetData.Builder)getC2SHookSetDataFieldBuilder().getBuilder();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public HookSetHandler.HookSetDataOrBuilder getC2SHookSetDataOrBuilder() {
/*      */         if (this.c2SHookSetDataBuilder_ != null) {
/*      */           return (HookSetHandler.HookSetDataOrBuilder)this.c2SHookSetDataBuilder_.getMessageOrBuilder();
/*      */         }
/*      */         return this.c2SHookSetData_;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private SingleFieldBuilder<HookSetHandler.HookSetData, HookSetHandler.HookSetData.Builder, HookSetHandler.HookSetDataOrBuilder> getC2SHookSetDataFieldBuilder() {
/*      */         if (this.c2SHookSetDataBuilder_ == null) {
/*      */           this.c2SHookSetDataBuilder_ = new SingleFieldBuilder(getC2SHookSetData(), getParentForChildren(), isClean());
/*      */           this.c2SHookSetData_ = null;
/*      */         } 
/*      */         return this.c2SHookSetDataBuilder_;
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ChangeHookSetResponse
/*      */     extends GeneratedMessage
/*      */     implements ChangeHookSetResponseOrBuilder
/*      */   {
/* 2788 */     private static final ChangeHookSetResponse defaultInstance = new ChangeHookSetResponse(true); private final UnknownFieldSet unknownFields; private ChangeHookSetResponse(GeneratedMessage.Builder<?> builder) { super(builder); this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = builder.getUnknownFields(); } private ChangeHookSetResponse(boolean noInit) { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; this.unknownFields = UnknownFieldSet.getDefaultInstance(); } public static ChangeHookSetResponse getDefaultInstance() { return defaultInstance; } public ChangeHookSetResponse getDefaultInstanceForType() { return defaultInstance; } public final UnknownFieldSet getUnknownFields() { return this.unknownFields; } private ChangeHookSetResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { this.memoizedIsInitialized = -1; this.memoizedSerializedSize = -1; initFields(); int mutable_bitField0_ = 0; UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(); try { boolean done = false; while (!done) { ByteString bs; int tag = input.readTag(); switch (tag) { case 0: done = true; break;case 8: this.bitField0_ |= 0x1; this.s2CCode_ = input.readInt32(); break;case 18: bs = input.readBytes(); this.bitField0_ |= 0x2; this.s2CMsg_ = bs; break; }  }  } catch (InvalidProtocolBufferException e) { throw e.setUnfinishedMessage(this); } catch (IOException e) { throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this); } finally { this.unknownFields = unknownFields.build(); makeExtensionsImmutable(); }  } public static final Descriptors.Descriptor getDescriptor() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeHookSetResponse.class, Builder.class); } public static Parser<ChangeHookSetResponse> PARSER = (Parser<ChangeHookSetResponse>)new AbstractParser<ChangeHookSetResponse>() { public HookSetHandler.ChangeHookSetResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return new HookSetHandler.ChangeHookSetResponse(input, extensionRegistry); } }
/* 2789 */     ; private int bitField0_; public static final int S2C_CODE_FIELD_NUMBER = 1; private int s2CCode_; public static final int S2C_MSG_FIELD_NUMBER = 2; private Object s2CMsg_; private byte memoizedIsInitialized; private int memoizedSerializedSize; private static final long serialVersionUID = 0L; public Parser<ChangeHookSetResponse> getParserForType() { return PARSER; } public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); } public int getS2CCode() { return this.s2CCode_; } public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); } public String getS2CMsg() { Object ref = this.s2CMsg_; if (ref instanceof String) return (String)ref;  ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; } public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; } private void initFields() { this.s2CCode_ = 0; this.s2CMsg_ = ""; } public final boolean isInitialized() { byte isInitialized = this.memoizedIsInitialized; if (isInitialized == 1) return true;  if (isInitialized == 0) return false;  if (!hasS2CCode()) { this.memoizedIsInitialized = 0; return false; }  this.memoizedIsInitialized = 1; return true; } public void writeTo(CodedOutputStream output) throws IOException { getSerializedSize(); if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());  getUnknownFields().writeTo(output); } public int getSerializedSize() { int size = this.memoizedSerializedSize; if (size != -1) return size;  size = 0; if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);  if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());  size += getUnknownFields().getSerializedSize(); this.memoizedSerializedSize = size; return size; } protected Object writeReplace() throws ObjectStreamException { return super.writeReplace(); } public static ChangeHookSetResponse parseFrom(ByteString data) throws InvalidProtocolBufferException { return (ChangeHookSetResponse)PARSER.parseFrom(data); } public static ChangeHookSetResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ChangeHookSetResponse)PARSER.parseFrom(data, extensionRegistry); } public static ChangeHookSetResponse parseFrom(byte[] data) throws InvalidProtocolBufferException { return (ChangeHookSetResponse)PARSER.parseFrom(data); } public static ChangeHookSetResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException { return (ChangeHookSetResponse)PARSER.parseFrom(data, extensionRegistry); } public static ChangeHookSetResponse parseFrom(InputStream input) throws IOException { return (ChangeHookSetResponse)PARSER.parseFrom(input); } static { defaultInstance.initFields(); } public static ChangeHookSetResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChangeHookSetResponse)PARSER.parseFrom(input, extensionRegistry); } public static ChangeHookSetResponse parseDelimitedFrom(InputStream input) throws IOException { return (ChangeHookSetResponse)PARSER.parseDelimitedFrom(input); } public static ChangeHookSetResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChangeHookSetResponse)PARSER.parseDelimitedFrom(input, extensionRegistry); } public static ChangeHookSetResponse parseFrom(CodedInputStream input) throws IOException { return (ChangeHookSetResponse)PARSER.parseFrom(input); } public static ChangeHookSetResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { return (ChangeHookSetResponse)PARSER.parseFrom(input, extensionRegistry); } public static Builder newBuilder() { return Builder.create(); } public Builder newBuilderForType() { return newBuilder(); } public static Builder newBuilder(ChangeHookSetResponse prototype) { return newBuilder().mergeFrom(prototype); } public Builder toBuilder() { return newBuilder(this); } protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) { Builder builder = new Builder(parent); return builder; } public static final class Builder extends GeneratedMessage.Builder<Builder> implements HookSetHandler.ChangeHookSetResponseOrBuilder { private int bitField0_; private int s2CCode_; private Object s2CMsg_; public static final Descriptors.Descriptor getDescriptor() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetResponse_descriptor; } protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(HookSetHandler.ChangeHookSetResponse.class, Builder.class); } private Builder() { this.s2CMsg_ = ""; maybeForceBuilderInitialization(); } private Builder(GeneratedMessage.BuilderParent parent) { super(parent); this.s2CMsg_ = ""; maybeForceBuilderInitialization(); }
/*      */       private void maybeForceBuilderInitialization() { if (HookSetHandler.ChangeHookSetResponse.alwaysUseFieldBuilders); }
/*      */       private static Builder create() { return new Builder(); }
/*      */       public Builder clear() { super.clear(); this.s2CCode_ = 0; this.bitField0_ &= 0xFFFFFFFE; this.s2CMsg_ = ""; this.bitField0_ &= 0xFFFFFFFD; return this; }
/*      */       public Builder clone() { return create().mergeFrom(buildPartial()); }
/*      */       public Descriptors.Descriptor getDescriptorForType() { return HookSetHandler.internal_static_pomelo_area_ChangeHookSetResponse_descriptor; }
/*      */       public HookSetHandler.ChangeHookSetResponse getDefaultInstanceForType() { return HookSetHandler.ChangeHookSetResponse.getDefaultInstance(); }
/*      */       public HookSetHandler.ChangeHookSetResponse build() { HookSetHandler.ChangeHookSetResponse result = buildPartial(); if (!result.isInitialized()) throw newUninitializedMessageException(result);  return result; }
/*      */       public HookSetHandler.ChangeHookSetResponse buildPartial() { HookSetHandler.ChangeHookSetResponse result = new HookSetHandler.ChangeHookSetResponse(this); int from_bitField0_ = this.bitField0_; int to_bitField0_ = 0; if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;  result.s2CCode_ = this.s2CCode_; if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;  result.s2CMsg_ = this.s2CMsg_; result.bitField0_ = to_bitField0_; onBuilt(); return result; }
/*      */       public Builder mergeFrom(Message other) { if (other instanceof HookSetHandler.ChangeHookSetResponse) return mergeFrom((HookSetHandler.ChangeHookSetResponse)other);  super.mergeFrom(other); return this; }
/*      */       public Builder mergeFrom(HookSetHandler.ChangeHookSetResponse other) { if (other == HookSetHandler.ChangeHookSetResponse.getDefaultInstance()) return this;  if (other.hasS2CCode()) setS2CCode(other.getS2CCode());  if (other.hasS2CMsg()) { this.bitField0_ |= 0x2; this.s2CMsg_ = other.s2CMsg_; onChanged(); }  mergeUnknownFields(other.getUnknownFields()); return this; }
/*      */       public final boolean isInitialized() { if (!hasS2CCode()) return false;  return true; }
/*      */       public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException { HookSetHandler.ChangeHookSetResponse parsedMessage = null; try { parsedMessage = (HookSetHandler.ChangeHookSetResponse)HookSetHandler.ChangeHookSetResponse.PARSER.parsePartialFrom(input, extensionRegistry); } catch (InvalidProtocolBufferException e) { parsedMessage = (HookSetHandler.ChangeHookSetResponse)e.getUnfinishedMessage(); throw e; } finally { if (parsedMessage != null) mergeFrom(parsedMessage);  }  return this; }
/*      */       public boolean hasS2CCode() { return ((this.bitField0_ & 0x1) == 1); }
/*      */       public int getS2CCode() { return this.s2CCode_; }
/*      */       public Builder setS2CCode(int value) { this.bitField0_ |= 0x1; this.s2CCode_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CCode() { this.bitField0_ &= 0xFFFFFFFE; this.s2CCode_ = 0; onChanged(); return this; }
/*      */       public boolean hasS2CMsg() { return ((this.bitField0_ & 0x2) == 2); }
/*      */       public String getS2CMsg() { Object ref = this.s2CMsg_; if (!(ref instanceof String)) { ByteString bs = (ByteString)ref; String s = bs.toStringUtf8(); if (bs.isValidUtf8()) this.s2CMsg_ = s;  return s; }  return (String)ref; }
/*      */       public ByteString getS2CMsgBytes() { Object ref = this.s2CMsg_; if (ref instanceof String) { ByteString b = ByteString.copyFromUtf8((String)ref); this.s2CMsg_ = b; return b; }  return (ByteString)ref; }
/*      */       public Builder setS2CMsg(String value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; }
/*      */       public Builder clearS2CMsg() { this.bitField0_ &= 0xFFFFFFFD; this.s2CMsg_ = HookSetHandler.ChangeHookSetResponse.getDefaultInstance().getS2CMsg(); onChanged(); return this; }
/*      */       public Builder setS2CMsgBytes(ByteString value) { if (value == null) throw new NullPointerException();  this.bitField0_ |= 0x2; this.s2CMsg_ = value; onChanged(); return this; } }
/*      */   }
/* 2813 */   public static Descriptors.FileDescriptor getDescriptor() { return descriptor; }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 2818 */     String[] descriptorData = { "\n\024hookSetHandler.proto\022\013pomelo.area\"×\001\n\013HookSetData\022\021\n\thpPercent\030\001 \002(\005\022\021\n\tmpPercent\030\002 \002(\005\022\022\n\nhpItemCode\030\003 \002(\t\022\022\n\nmpItemCode\030\004 \002(\t\022\r\n\005pkSet\030\005 \002(\005\022\022\n\nmeltQcolor\030\006 \003(\005\022\025\n\rautoBuyHpItem\030\007 \001(\005\022\025\n\rautoBuyMpItem\030\b \001(\005\022\024\n\ffieldMaphook\030\t \002(\005\022\023\n\013areaMaphook\030\n \002(\005\"I\n\024ChangeHookSetRequest\0221\n\017c2s_hookSetData\030\001 \002(\0132\030.pomelo.area.HookSetData\":\n\025ChangeHookSetResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2o\n\016hookSetH", "andler\022]\n\024changeHookSetRequest\022!.pomelo.area.ChangeHookSetRequest\032\".pomelo.area.ChangeHookSetResponse" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2833 */     Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
/*      */       {
/*      */         public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
/*      */         {
/* 2837 */           HookSetHandler.descriptor = root;
/* 2838 */           return null;
/*      */         }
/*      */       };
/*      */     
/* 2842 */     Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
/*      */   }
/*      */ 
/*      */   
/* 2846 */   private static final Descriptors.Descriptor internal_static_pomelo_area_HookSetData_descriptor = getDescriptor().getMessageTypes().get(0);
/* 2847 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_HookSetData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_HookSetData_descriptor, new String[] { "HpPercent", "MpPercent", "HpItemCode", "MpItemCode", "PkSet", "MeltQcolor", "AutoBuyHpItem", "AutoBuyMpItem", "FieldMaphook", "AreaMaphook" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2852 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ChangeHookSetRequest_descriptor = getDescriptor().getMessageTypes().get(1);
/* 2853 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangeHookSetRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangeHookSetRequest_descriptor, new String[] { "C2SHookSetData" });
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2858 */   private static final Descriptors.Descriptor internal_static_pomelo_area_ChangeHookSetResponse_descriptor = getDescriptor().getMessageTypes().get(2);
/* 2859 */   private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangeHookSetResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangeHookSetResponse_descriptor, new String[] { "S2CCode", "S2CMsg" });
/*      */   private static Descriptors.FileDescriptor descriptor;
/*      */   
/*      */   public static interface ChangeHookSetResponseOrBuilder extends MessageOrBuilder {
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
/*      */   public static interface ChangeHookSetRequestOrBuilder extends MessageOrBuilder {
/*      */     boolean hasC2SHookSetData();
/*      */     
/*      */     HookSetHandler.HookSetData getC2SHookSetData();
/*      */     
/*      */     HookSetHandler.HookSetDataOrBuilder getC2SHookSetDataOrBuilder();
/*      */   }
/*      */   
/*      */   public static interface HookSetDataOrBuilder extends MessageOrBuilder {
/*      */     boolean hasHpPercent();
/*      */     
/*      */     int getHpPercent();
/*      */     
/*      */     boolean hasMpPercent();
/*      */     
/*      */     int getMpPercent();
/*      */     
/*      */     boolean hasHpItemCode();
/*      */     
/*      */     String getHpItemCode();
/*      */     
/*      */     ByteString getHpItemCodeBytes();
/*      */     
/*      */     boolean hasMpItemCode();
/*      */     
/*      */     String getMpItemCode();
/*      */     
/*      */     ByteString getMpItemCodeBytes();
/*      */     
/*      */     boolean hasPkSet();
/*      */     
/*      */     int getPkSet();
/*      */     
/*      */     List<Integer> getMeltQcolorList();
/*      */     
/*      */     int getMeltQcolorCount();
/*      */     
/*      */     int getMeltQcolor(int param1Int);
/*      */     
/*      */     boolean hasAutoBuyHpItem();
/*      */     
/*      */     int getAutoBuyHpItem();
/*      */     
/*      */     boolean hasAutoBuyMpItem();
/*      */     
/*      */     int getAutoBuyMpItem();
/*      */     
/*      */     boolean hasFieldMaphook();
/*      */     
/*      */     int getFieldMaphook();
/*      */     
/*      */     boolean hasAreaMaphook();
/*      */     
/*      */     int getAreaMaphook();
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\pomelo\area\HookSetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */