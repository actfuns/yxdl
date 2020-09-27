package com.wanniu.login.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;


public final class Common {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Void
            extends GeneratedMessage
            implements VoidOrBuilder {
        private static final Void defaultInstance = new Void(true);
        private final UnknownFieldSet unknownFields;

        private Void(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Void(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Void getDefaultInstance() {
            return defaultInstance;
        }

        public Void getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Void(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            continue;
                    }
                    if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) done = true;
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
            return Common.internal_static_pomelo_Void_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_Void_fieldAccessorTable.ensureFieldAccessorsInitialized(Void.class, Builder.class);
        }

        public static Parser<Void> PARSER = (Parser<Void>) new AbstractParser<Void>() {
            public Common.Void parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.Void(input, extensionRegistry, null);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Void> getParserForType() {
            return PARSER;
        }

        private void initFields() {
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Void parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data);
        }

        public static Void parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Void parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data);
        }

        public static Void parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Void) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Void parseFrom(InputStream input) throws IOException {
            return (Void) PARSER.parseFrom(input);
        }

        public static Void parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Void parseDelimitedFrom(InputStream input) throws IOException {
            return (Void) PARSER.parseDelimitedFrom(input);
        }

        public static Void parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Void parseFrom(CodedInputStream input) throws IOException {
            return (Void) PARSER.parseFrom(input);
        }

        public static Void parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Void) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Void prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.VoidOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_Void_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_Void_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.Void.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                Common.Void.alwaysUseFieldBuilders;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_Void_descriptor;
            }

            public Common.Void getDefaultInstanceForType() {
                return Common.Void.getDefaultInstance();
            }

            public Common.Void build() {
                Common.Void result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Common.Void buildPartial() {
                Common.Void result = new Common.Void(this, null);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.Void) return mergeFrom((Common.Void) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.Void other) {
                if (other == Common.Void.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.Void parsedMessage = null;
                try {
                    parsedMessage = (Common.Void) Common.Void.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.Void) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ErrMsg
            extends GeneratedMessage
            implements ErrMsgOrBuilder {
        private static final ErrMsg defaultInstance = new ErrMsg(true);
        private final UnknownFieldSet unknownFields;

        private ErrMsg(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ErrMsg(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ErrMsg getDefaultInstance() {
            return defaultInstance;
        }

        public ErrMsg getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ErrMsg(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
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
            return Common.internal_static_pomelo_ErrMsg_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_ErrMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrMsg.class, Builder.class);
        }

        public static Parser<ErrMsg> PARSER = (Parser<ErrMsg>) new AbstractParser<ErrMsg>() {
            public Common.ErrMsg parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.ErrMsg(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ErrMsg> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
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
                output.writeBytes(2, getS2CMsgBytes());
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
                size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ErrMsg parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data);
        }


        public static ErrMsg parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ErrMsg parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data);
        }


        public static ErrMsg parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrMsg) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ErrMsg parseFrom(InputStream input) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input);
        }


        public static ErrMsg parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ErrMsg parseDelimitedFrom(InputStream input) throws IOException {
            return (ErrMsg) PARSER.parseDelimitedFrom(input);
        }


        public static ErrMsg parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ErrMsg parseFrom(CodedInputStream input) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input);
        }


        public static ErrMsg parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrMsg) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ErrMsg prototype) {
            return newBuilder().mergeFrom(prototype);
        }


        public Builder toBuilder() {
            return newBuilder(this);
        }


        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }


        public static final class Builder
                extends GeneratedMessage.Builder<Builder>
                implements Common.ErrMsgOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_ErrMsg_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_ErrMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.ErrMsg.class, Builder.class);
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
                Common.ErrMsg.alwaysUseFieldBuilders;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_ErrMsg_descriptor;
            }


            public Common.ErrMsg getDefaultInstanceForType() {
                return Common.ErrMsg.getDefaultInstance();
            }


            public Common.ErrMsg build() {
                Common.ErrMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public Common.ErrMsg buildPartial() {
                Common.ErrMsg result = new Common.ErrMsg(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof Common.ErrMsg) {
                    return mergeFrom((Common.ErrMsg) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(Common.ErrMsg other) {
                if (other == Common.ErrMsg.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
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
                Common.ErrMsg parsedMessage = null;
                try {
                    parsedMessage = (Common.ErrMsg) Common.ErrMsg.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.ErrMsg) e.getUnfinishedMessage();
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


            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = Common.ErrMsg.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }


            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class SysTimeResponse
            extends GeneratedMessage
            implements SysTimeResponseOrBuilder {
        private static final SysTimeResponse defaultInstance = new SysTimeResponse(true);
        private final UnknownFieldSet unknownFields;

        private SysTimeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SysTimeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SysTimeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SysTimeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SysTimeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.s2CTime_ = bs;
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
            return Common.internal_static_pomelo_SysTimeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Common.internal_static_pomelo_SysTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SysTimeResponse.class, Builder.class);
        }

        public static Parser<SysTimeResponse> PARSER = (Parser<SysTimeResponse>) new AbstractParser<SysTimeResponse>() {
            public Common.SysTimeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Common.SysTimeResponse(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_TIME_FIELD_NUMBER = 2;
        private Object s2CTime_;
        public static final int S2C_MSG_FIELD_NUMBER = 3;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SysTimeResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getS2CTime() {
            Object ref = this.s2CTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CTime_ = s;
            return s;
        }

        public ByteString getS2CTimeBytes() {
            Object ref = this.s2CTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getS2CMsg() {
            Object ref = this.s2CMsg_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CMsg_ = s;
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
            this.s2CTime_ = "";
            this.s2CMsg_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CTimeBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getS2CMsgBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CTimeBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getS2CMsgBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SysTimeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SysTimeResponse) PARSER.parseFrom(data);
        }

        public static SysTimeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SysTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SysTimeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SysTimeResponse) PARSER.parseFrom(data);
        }

        public static SysTimeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SysTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SysTimeResponse parseFrom(InputStream input) throws IOException {
            return (SysTimeResponse) PARSER.parseFrom(input);
        }

        public static SysTimeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SysTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SysTimeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SysTimeResponse) PARSER.parseDelimitedFrom(input);
        }

        public static SysTimeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SysTimeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SysTimeResponse parseFrom(CodedInputStream input) throws IOException {
            return (SysTimeResponse) PARSER.parseFrom(input);
        }

        public static SysTimeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SysTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SysTimeResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements Common.SysTimeResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CTime_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Common.internal_static_pomelo_SysTimeResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Common.internal_static_pomelo_SysTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.SysTimeResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CTime_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CTime_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                Common.SysTimeResponse.alwaysUseFieldBuilders;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CTime_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return Common.internal_static_pomelo_SysTimeResponse_descriptor;
            }

            public Common.SysTimeResponse getDefaultInstanceForType() {
                return Common.SysTimeResponse.getDefaultInstance();
            }

            public Common.SysTimeResponse build() {
                Common.SysTimeResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public Common.SysTimeResponse buildPartial() {
                Common.SysTimeResponse result = new Common.SysTimeResponse(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CTime_ = this.s2CTime_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof Common.SysTimeResponse) return mergeFrom((Common.SysTimeResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Common.SysTimeResponse other) {
                if (other == Common.SysTimeResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CTime()) {
                    this.bitField0_ |= 0x2;
                    this.s2CTime_ = other.s2CTime_;
                    onChanged();
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
                if (!hasS2CCode()) return false;
                if (!hasS2CTime()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Common.SysTimeResponse parsedMessage = null;
                try {
                    parsedMessage = (Common.SysTimeResponse) Common.SysTimeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Common.SysTimeResponse) e.getUnfinishedMessage();
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

            public boolean hasS2CTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getS2CTime() {
                Object ref = this.s2CTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.s2CTime_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getS2CTimeBytes() {
                Object ref = this.s2CTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setS2CTime(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CTime_ = Common.SysTimeResponse.getDefaultInstance().getS2CTime();
                onChanged();
                return this;
            }

            public Builder setS2CTimeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CTime_ = value;
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
                    if (bs.isValidUtf8()) this.s2CMsg_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CMsg_ = Common.SysTimeResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }

            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {
                "\n\fcommon.proto\022\006pomelo\"\006\n\004Void\"+\n\006ErrMsg\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"F\n\017SysTimeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\020\n\bs2c_time\030\002 \002(\t\022\017\n\007s2c_msg\030\003 \001(\tB\030\n\026com.wanniu.login.proto"
        };


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                        Common.descriptor = root;
                        return null;
                    }
                };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new Descriptors.FileDescriptor[0],
                assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_Void_descriptor = getDescriptor().getMessageTypes().get(0);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_Void_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_Void_descriptor,
            new String[0]);

    private static final Descriptors.Descriptor internal_static_pomelo_ErrMsg_descriptor = getDescriptor().getMessageTypes().get(1);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_ErrMsg_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_ErrMsg_descriptor,
            new String[]{"S2CCode", "S2CMsg"});

    private static final Descriptors.Descriptor internal_static_pomelo_SysTimeResponse_descriptor = getDescriptor().getMessageTypes().get(2);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_SysTimeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_SysTimeResponse_descriptor,
            new String[]{"S2CCode", "S2CTime", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface ErrMsgOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SysTimeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CTime();

        String getS2CTime();

        ByteString getS2CTimeBytes();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface VoidOrBuilder extends MessageOrBuilder {
    }
}


