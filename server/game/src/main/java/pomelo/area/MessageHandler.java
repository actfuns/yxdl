package pomelo.area;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

import pomelo.Common;


public final class MessageHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Message
            extends GeneratedMessage
            implements MessageOrBuilder {
        private static final Message defaultInstance = new Message(true);
        private final UnknownFieldSet unknownFields;

        private Message(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Message(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Message getDefaultInstance() {
            return defaultInstance;
        }

        public Message getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Message(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.id_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.relationId_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.messageType_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.remainTime_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.strMsg_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageHandler.internal_static_pomelo_area_Message_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageHandler.internal_static_pomelo_area_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(Message.class, Builder.class);
        }

        public static Parser<Message> PARSER = (Parser<Message>) new AbstractParser<Message>() {
            public MessageHandler.Message parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MessageHandler.Message(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int RELATIONID_FIELD_NUMBER = 2;
        private Object relationId_;
        public static final int MESSAGETYPE_FIELD_NUMBER = 3;
        private int messageType_;
        public static final int REMAINTIME_FIELD_NUMBER = 4;
        private int remainTime_;
        public static final int STRMSG_FIELD_NUMBER = 5;
        private Object strMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Message> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.id_ = s;
            return s;
        }

        public ByteString getIdBytes() {
            Object ref = this.id_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.id_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasRelationId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getRelationId() {
            Object ref = this.relationId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.relationId_ = s;
            }
            return s;
        }


        public ByteString getRelationIdBytes() {
            Object ref = this.relationId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.relationId_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasMessageType() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getMessageType() {
            return this.messageType_;
        }


        public boolean hasRemainTime() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getRemainTime() {
            return this.remainTime_;
        }


        public boolean hasStrMsg() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public String getStrMsg() {
            Object ref = this.strMsg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.strMsg_ = s;
            }
            return s;
        }


        public ByteString getStrMsgBytes() {
            Object ref = this.strMsg_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.strMsg_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.id_ = "";
            this.relationId_ = "";
            this.messageType_ = 0;
            this.remainTime_ = 0;
            this.strMsg_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMessageType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRemainTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStrMsg()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getRelationIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.messageType_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.remainTime_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getStrMsgBytes());
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getRelationIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.messageType_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.remainTime_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeBytesSize(5, getStrMsgBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Message parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Message) PARSER.parseFrom(data);
        }


        public static Message parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Message) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Message parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Message) PARSER.parseFrom(data);
        }


        public static Message parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Message) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Message parseFrom(InputStream input) throws IOException {
            return (Message) PARSER.parseFrom(input);
        }


        public static Message parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Message) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Message parseDelimitedFrom(InputStream input) throws IOException {
            return (Message) PARSER.parseDelimitedFrom(input);
        }


        public static Message parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Message) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Message parseFrom(CodedInputStream input) throws IOException {
            return (Message) PARSER.parseFrom(input);
        }


        public static Message parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Message) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Message prototype) {
            return newBuilder().mergeFrom(prototype);
        }


        public Builder toBuilder() {
            return newBuilder(this);
        }


        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements MessageHandler.MessageOrBuilder {
            private int bitField0_;

            private Object id_;

            private Object relationId_;

            private int messageType_;

            private int remainTime_;

            private Object strMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MessageHandler.internal_static_pomelo_area_Message_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageHandler.internal_static_pomelo_area_Message_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageHandler.Message.class, Builder.class);
            }


            private Builder() {
                this.id_ = "";
                this.relationId_ = "";
                this.strMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.relationId_ = "";
                this.strMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MessageHandler.Message.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.relationId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.messageType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.remainTime_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.strMsg_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MessageHandler.internal_static_pomelo_area_Message_descriptor;
            }


            public MessageHandler.Message getDefaultInstanceForType() {
                return MessageHandler.Message.getDefaultInstance();
            }


            public MessageHandler.Message build() {
                MessageHandler.Message result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MessageHandler.Message buildPartial() {
                MessageHandler.Message result = new MessageHandler.Message(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.relationId_ = this.relationId_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.messageType_ = this.messageType_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.remainTime_ = this.remainTime_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.strMsg_ = this.strMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof MessageHandler.Message) {
                    return mergeFrom((MessageHandler.Message) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MessageHandler.Message other) {
                if (other == MessageHandler.Message.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasRelationId()) {
                    this.bitField0_ |= 0x2;
                    this.relationId_ = other.relationId_;
                    onChanged();
                }
                if (other.hasMessageType()) {
                    setMessageType(other.getMessageType());
                }
                if (other.hasRemainTime()) {
                    setRemainTime(other.getRemainTime());
                }
                if (other.hasStrMsg()) {
                    this.bitField0_ |= 0x10;
                    this.strMsg_ = other.strMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasMessageType()) {
                    return false;
                }
                if (!hasRemainTime()) {
                    return false;
                }
                if (!hasStrMsg()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MessageHandler.Message parsedMessage = null;
                try {
                    parsedMessage = (MessageHandler.Message) MessageHandler.Message.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MessageHandler.Message) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getId() {
                Object ref = this.id_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.id_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getIdBytes() {
                Object ref = this.id_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.id_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = MessageHandler.Message.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public boolean hasRelationId() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getRelationId() {
                Object ref = this.relationId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.relationId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getRelationIdBytes() {
                Object ref = this.relationId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.relationId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setRelationId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.relationId_ = value;
                onChanged();
                return this;
            }


            public Builder clearRelationId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.relationId_ = MessageHandler.Message.getDefaultInstance().getRelationId();
                onChanged();
                return this;
            }


            public Builder setRelationIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.relationId_ = value;
                onChanged();
                return this;
            }


            public boolean hasMessageType() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getMessageType() {
                return this.messageType_;
            }


            public Builder setMessageType(int value) {
                this.bitField0_ |= 0x4;
                this.messageType_ = value;
                onChanged();
                return this;
            }


            public Builder clearMessageType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.messageType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasRemainTime() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getRemainTime() {
                return this.remainTime_;
            }


            public Builder setRemainTime(int value) {
                this.bitField0_ |= 0x8;
                this.remainTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearRemainTime() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.remainTime_ = 0;
                onChanged();
                return this;
            }


            public boolean hasStrMsg() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getStrMsg() {
                Object ref = this.strMsg_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.strMsg_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getStrMsgBytes() {
                Object ref = this.strMsg_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.strMsg_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setStrMsg(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.strMsg_ = value;
                onChanged();
                return this;
            }


            public Builder clearStrMsg() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.strMsg_ = MessageHandler.Message.getDefaultInstance().getStrMsg();
                onChanged();
                return this;
            }


            public Builder setStrMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.strMsg_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class HandleMessageRequest
            extends GeneratedMessage
            implements HandleMessageRequestOrBuilder {
        private static final HandleMessageRequest defaultInstance = new HandleMessageRequest(true);
        private final UnknownFieldSet unknownFields;

        private HandleMessageRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HandleMessageRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HandleMessageRequest getDefaultInstance() {
            return defaultInstance;
        }

        public HandleMessageRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HandleMessageRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.c2SId_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SType_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SOperate_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageHandler.internal_static_pomelo_area_HandleMessageRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageHandler.internal_static_pomelo_area_HandleMessageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(HandleMessageRequest.class, Builder.class);
        }

        public static Parser<HandleMessageRequest> PARSER = (Parser<HandleMessageRequest>) new AbstractParser<HandleMessageRequest>() {
            public MessageHandler.HandleMessageRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MessageHandler.HandleMessageRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private Object c2SId_;
        public static final int C2S_TYPE_FIELD_NUMBER = 2;
        private int c2SType_;
        public static final int C2S_OPERATE_FIELD_NUMBER = 3;
        private int c2SOperate_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HandleMessageRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SId() {
            Object ref = this.c2SId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SId_ = s;
            return s;
        }

        public ByteString getC2SIdBytes() {
            Object ref = this.c2SId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getC2SType() {
            return this.c2SType_;
        }


        public boolean hasC2SOperate() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SOperate() {
            return this.c2SOperate_;
        }


        private void initFields() {
            this.c2SId_ = "";
            this.c2SType_ = 0;
            this.c2SOperate_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SOperate()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SType_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SOperate_);
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SType_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SOperate_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static HandleMessageRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HandleMessageRequest) PARSER.parseFrom(data);
        }


        public static HandleMessageRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandleMessageRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HandleMessageRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HandleMessageRequest) PARSER.parseFrom(data);
        }


        public static HandleMessageRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandleMessageRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HandleMessageRequest parseFrom(InputStream input) throws IOException {
            return (HandleMessageRequest) PARSER.parseFrom(input);
        }


        public static HandleMessageRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static HandleMessageRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (HandleMessageRequest) PARSER.parseDelimitedFrom(input);
        }


        public static HandleMessageRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static HandleMessageRequest parseFrom(CodedInputStream input) throws IOException {
            return (HandleMessageRequest) PARSER.parseFrom(input);
        }


        public static HandleMessageRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(HandleMessageRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }


        public Builder toBuilder() {
            return newBuilder(this);
        }


        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements MessageHandler.HandleMessageRequestOrBuilder {
            private int bitField0_;


            private Object c2SId_;


            private int c2SType_;


            private int c2SOperate_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageHandler.HandleMessageRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MessageHandler.HandleMessageRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SOperate_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageRequest_descriptor;
            }


            public MessageHandler.HandleMessageRequest getDefaultInstanceForType() {
                return MessageHandler.HandleMessageRequest.getDefaultInstance();
            }


            public MessageHandler.HandleMessageRequest build() {
                MessageHandler.HandleMessageRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MessageHandler.HandleMessageRequest buildPartial() {
                MessageHandler.HandleMessageRequest result = new MessageHandler.HandleMessageRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SType_ = this.c2SType_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SOperate_ = this.c2SOperate_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof MessageHandler.HandleMessageRequest) {
                    return mergeFrom((MessageHandler.HandleMessageRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MessageHandler.HandleMessageRequest other) {
                if (other == MessageHandler.HandleMessageRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SId_ = other.c2SId_;
                    onChanged();
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                if (other.hasC2SOperate()) {
                    setC2SOperate(other.getC2SOperate());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                if (!hasC2SType()) {
                    return false;
                }
                if (!hasC2SOperate()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MessageHandler.HandleMessageRequest parsedMessage = null;
                try {
                    parsedMessage = (MessageHandler.HandleMessageRequest) MessageHandler.HandleMessageRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MessageHandler.HandleMessageRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SId() {
                Object ref = this.c2SId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SIdBytes() {
                Object ref = this.c2SId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = MessageHandler.HandleMessageRequest.getDefaultInstance().getC2SId();
                onChanged();
                return this;
            }


            public Builder setC2SIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SType() {
                return this.c2SType_;
            }


            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x2;
                this.c2SType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SOperate() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SOperate() {
                return this.c2SOperate_;
            }


            public Builder setC2SOperate(int value) {
                this.bitField0_ |= 0x4;
                this.c2SOperate_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SOperate() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SOperate_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class HandleMessageResponse
            extends GeneratedMessage
            implements HandleMessageResponseOrBuilder {
        private static final HandleMessageResponse defaultInstance = new HandleMessageResponse(true);
        private final UnknownFieldSet unknownFields;

        private HandleMessageResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HandleMessageResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HandleMessageResponse getDefaultInstance() {
            return defaultInstance;
        }

        public HandleMessageResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HandleMessageResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.s2CCode_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.s2CIsClear_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.s2CMsg_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageHandler.internal_static_pomelo_area_HandleMessageResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageHandler.internal_static_pomelo_area_HandleMessageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(HandleMessageResponse.class, Builder.class);
        }

        public static Parser<HandleMessageResponse> PARSER = (Parser<HandleMessageResponse>) new AbstractParser<HandleMessageResponse>() {
            public MessageHandler.HandleMessageResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MessageHandler.HandleMessageResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_ISCLEAR_FIELD_NUMBER = 2;
        private int s2CIsClear_;
        public static final int S2C_MSG_FIELD_NUMBER = 3;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HandleMessageResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CIsClear() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getS2CIsClear() {
            return this.s2CIsClear_;
        }


        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getS2CMsg() {
            Object ref = this.s2CMsg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.s2CMsg_ = s;
            }
            return s;
        }


        public ByteString getS2CMsgBytes() {
            Object ref = this.s2CMsg_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CMsg_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CIsClear_ = 0;
            this.s2CMsg_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.s2CIsClear_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getS2CMsgBytes());
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.s2CIsClear_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getS2CMsgBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static HandleMessageResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HandleMessageResponse) PARSER.parseFrom(data);
        }


        public static HandleMessageResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandleMessageResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HandleMessageResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HandleMessageResponse) PARSER.parseFrom(data);
        }


        public static HandleMessageResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandleMessageResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HandleMessageResponse parseFrom(InputStream input) throws IOException {
            return (HandleMessageResponse) PARSER.parseFrom(input);
        }


        public static HandleMessageResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static HandleMessageResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (HandleMessageResponse) PARSER.parseDelimitedFrom(input);
        }


        public static HandleMessageResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static HandleMessageResponse parseFrom(CodedInputStream input) throws IOException {
            return (HandleMessageResponse) PARSER.parseFrom(input);
        }


        public static HandleMessageResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandleMessageResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(HandleMessageResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }


        public Builder toBuilder() {
            return newBuilder(this);
        }


        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements MessageHandler.HandleMessageResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private int s2CIsClear_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageHandler.HandleMessageResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MessageHandler.HandleMessageResponse.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CIsClear_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MessageHandler.internal_static_pomelo_area_HandleMessageResponse_descriptor;
            }


            public MessageHandler.HandleMessageResponse getDefaultInstanceForType() {
                return MessageHandler.HandleMessageResponse.getDefaultInstance();
            }


            public MessageHandler.HandleMessageResponse build() {
                MessageHandler.HandleMessageResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MessageHandler.HandleMessageResponse buildPartial() {
                MessageHandler.HandleMessageResponse result = new MessageHandler.HandleMessageResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CIsClear_ = this.s2CIsClear_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof MessageHandler.HandleMessageResponse) {
                    return mergeFrom((MessageHandler.HandleMessageResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MessageHandler.HandleMessageResponse other) {
                if (other == MessageHandler.HandleMessageResponse.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CIsClear()) {
                    setS2CIsClear(other.getS2CIsClear());
                }
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x4;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MessageHandler.HandleMessageResponse parsedMessage = null;
                try {
                    parsedMessage = (MessageHandler.HandleMessageResponse) MessageHandler.HandleMessageResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MessageHandler.HandleMessageResponse) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasS2CCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getS2CCode() {
                return this.s2CCode_;
            }


            public Builder setS2CCode(int value) {
                this.bitField0_ |= 0x1;
                this.s2CCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CCode_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CIsClear() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getS2CIsClear() {
                return this.s2CIsClear_;
            }


            public Builder setS2CIsClear(int value) {
                this.bitField0_ |= 0x2;
                this.s2CIsClear_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CIsClear() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CIsClear_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getS2CMsg() {
                Object ref = this.s2CMsg_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.s2CMsg_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getS2CMsgBytes() {
                Object ref = this.s2CMsg_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CMsg_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setS2CMsg(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CMsg_ = MessageHandler.HandleMessageResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }


            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnMessageAddPush
            extends GeneratedMessage
            implements OnMessageAddPushOrBuilder {
        private static final OnMessageAddPush defaultInstance = new OnMessageAddPush(true);
        private final UnknownFieldSet unknownFields;

        private OnMessageAddPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnMessageAddPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnMessageAddPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnMessageAddPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnMessageAddPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    MessageHandler.Message.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.s2CCode_ = input.readInt32();
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.s2CData_.toBuilder();
                            this.s2CData_ = (MessageHandler.Message) input.readMessage(MessageHandler.Message.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CData_);
                                this.s2CData_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageHandler.internal_static_pomelo_area_OnMessageAddPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageHandler.internal_static_pomelo_area_OnMessageAddPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnMessageAddPush.class, Builder.class);
        }

        public static Parser<OnMessageAddPush> PARSER = (Parser<OnMessageAddPush>) new AbstractParser<OnMessageAddPush>() {
            public MessageHandler.OnMessageAddPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MessageHandler.OnMessageAddPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private MessageHandler.Message s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnMessageAddPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public MessageHandler.Message getS2CData() {
            return this.s2CData_;
        }

        public MessageHandler.MessageOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CData_ = MessageHandler.Message.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CData()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CData().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.s2CData_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnMessageAddPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnMessageAddPush) PARSER.parseFrom(data);
        }

        public static OnMessageAddPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnMessageAddPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnMessageAddPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnMessageAddPush) PARSER.parseFrom(data);
        }

        public static OnMessageAddPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnMessageAddPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnMessageAddPush parseFrom(InputStream input) throws IOException {
            return (OnMessageAddPush) PARSER.parseFrom(input);
        }

        static {
            defaultInstance.initFields();
        }

        public static OnMessageAddPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnMessageAddPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnMessageAddPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnMessageAddPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnMessageAddPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnMessageAddPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnMessageAddPush parseFrom(CodedInputStream input) throws IOException {
            return (OnMessageAddPush) PARSER.parseFrom(input);
        }

        public static OnMessageAddPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnMessageAddPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnMessageAddPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MessageHandler.OnMessageAddPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private MessageHandler.Message s2CData_;
            private SingleFieldBuilder<MessageHandler.Message, MessageHandler.Message.Builder, MessageHandler.MessageOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageHandler.internal_static_pomelo_area_OnMessageAddPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageHandler.internal_static_pomelo_area_OnMessageAddPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageHandler.OnMessageAddPush.class, Builder.class);
            }

            private Builder() {
                this.s2CData_ = MessageHandler.Message.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = MessageHandler.Message.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MessageHandler.OnMessageAddPush.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = MessageHandler.Message.getDefaultInstance();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MessageHandler.internal_static_pomelo_area_OnMessageAddPush_descriptor;
            }

            public MessageHandler.OnMessageAddPush getDefaultInstanceForType() {
                return MessageHandler.OnMessageAddPush.getDefaultInstance();
            }

            public MessageHandler.OnMessageAddPush build() {
                MessageHandler.OnMessageAddPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MessageHandler.OnMessageAddPush buildPartial() {
                MessageHandler.OnMessageAddPush result = new MessageHandler.OnMessageAddPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (MessageHandler.Message) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof MessageHandler.OnMessageAddPush)
                    return mergeFrom((MessageHandler.OnMessageAddPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MessageHandler.OnMessageAddPush other) {
                if (other == MessageHandler.OnMessageAddPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasS2CData()) return false;
                if (!getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MessageHandler.OnMessageAddPush parsedMessage = null;
                try {
                    parsedMessage = (MessageHandler.OnMessageAddPush) MessageHandler.OnMessageAddPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MessageHandler.OnMessageAddPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasS2CCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getS2CCode() {
                return this.s2CCode_;
            }

            public Builder setS2CCode(int value) {
                this.bitField0_ |= 0x1;
                this.s2CCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CCode_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public MessageHandler.Message getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (MessageHandler.Message) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(MessageHandler.Message value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setS2CData(MessageHandler.Message.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeS2CData(MessageHandler.Message value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.s2CData_ != MessageHandler.Message.getDefaultInstance()) {
                        this.s2CData_ = MessageHandler.Message.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = MessageHandler.Message.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public MessageHandler.Message.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (MessageHandler.Message.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public MessageHandler.MessageOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (MessageHandler.MessageOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<MessageHandler.Message, MessageHandler.Message.Builder, MessageHandler.MessageOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\024messageHandler.proto\022\013pomelo.area\032\fcommon.proto\"b\n\007Message\022\n\n\002id\030\001 \002(\t\022\022\n\nrelationId\030\002 \001(\t\022\023\n\013messageType\030\003 \002(\005\022\022\n\nremainTime\030\004 \002(\005\022\016\n\006strMsg\030\005 \002(\t\"M\n\024HandleMessageRequest\022\016\n\006c2s_id\030\001 \002(\t\022\020\n\bc2s_type\030\002 \002(\005\022\023\n\013c2s_operate\030\003 \002(\005\"O\n\025HandleMessageResponse\022\020\n\bs2c_code\030\001 \002(\005\022\023\n\013s2c_isClear\030\002 \001(\005\022\017\n\007s2c_msg\030\003 \001(\t\"L\n\020OnMessageAddPush\022\020\n\bs2c_code\030\001 \002(\005\022&\n\bs2c_data\030\002 \002(\0132\024.pomelo.area.Message2o\n\016messageHa", "ndler\022]\n\024handleMessageRequest\022!.pomelo.area.HandleMessageRequest\032\".pomelo.area.HandleMessageResponse2N\n\013messagePush\022?\n\020onMessageAddPush\022\035.pomelo.area.OnMessageAddPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                MessageHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_Message_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Message_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Message_descriptor, new String[]{"Id", "RelationId", "MessageType", "RemainTime", "StrMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_HandleMessageRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_HandleMessageRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_HandleMessageRequest_descriptor, new String[]{"C2SId", "C2SType", "C2SOperate"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_HandleMessageResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_HandleMessageResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_HandleMessageResponse_descriptor, new String[]{"S2CCode", "S2CIsClear", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnMessageAddPush_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnMessageAddPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnMessageAddPush_descriptor, new String[]{"S2CCode", "S2CData"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface OnMessageAddPushOrBuilder extends com.google.protobuf.MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CData();

        MessageHandler.Message getS2CData();

        MessageHandler.MessageOrBuilder getS2CDataOrBuilder();
    }

    public static interface HandleMessageResponseOrBuilder extends com.google.protobuf.MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CIsClear();

        int getS2CIsClear();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface HandleMessageRequestOrBuilder extends com.google.protobuf.MessageOrBuilder {
        boolean hasC2SId();

        String getC2SId();

        ByteString getC2SIdBytes();

        boolean hasC2SType();

        int getC2SType();

        boolean hasC2SOperate();

        int getC2SOperate();
    }

    public static interface MessageOrBuilder extends com.google.protobuf.MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasRelationId();

        String getRelationId();

        ByteString getRelationIdBytes();

        boolean hasMessageType();

        int getMessageType();

        boolean hasRemainTime();

        int getRemainTime();

        boolean hasStrMsg();

        String getStrMsg();

        ByteString getStrMsgBytes();
    }
}


