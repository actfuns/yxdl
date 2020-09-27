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


public final class LoginHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class LoginRequest
            extends GeneratedMessage
            implements LoginRequestOrBuilder {
        private static final LoginRequest defaultInstance = new LoginRequest(true);
        private final UnknownFieldSet unknownFields;

        private LoginRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LoginRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LoginRequest getDefaultInstance() {
            return defaultInstance;
        }

        public LoginRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LoginRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.appId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.uid_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.token_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.channel_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.os_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.imei_ = bs;
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.version_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.channelUid_ = bs;
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
            return LoginHandler.internal_static_pomelo_login_LoginRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginHandler.internal_static_pomelo_login_LoginRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginRequest.class, Builder.class);
        }

        public static Parser<LoginRequest> PARSER = (Parser<LoginRequest>) new AbstractParser<LoginRequest>() {
            public LoginHandler.LoginRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LoginHandler.LoginRequest(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int APPID_FIELD_NUMBER = 1;
        private Object appId_;
        public static final int UID_FIELD_NUMBER = 2;
        private Object uid_;
        public static final int TOKEN_FIELD_NUMBER = 3;
        private Object token_;
        public static final int CHANNEL_FIELD_NUMBER = 4;
        private Object channel_;
        public static final int OS_FIELD_NUMBER = 5;
        private int os_;
        public static final int IMEI_FIELD_NUMBER = 6;
        private Object imei_;
        public static final int VERSION_FIELD_NUMBER = 7;
        private Object version_;
        public static final int CHANNELUID_FIELD_NUMBER = 8;
        private Object channelUid_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LoginRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasAppId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getAppId() {
            Object ref = this.appId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.appId_ = s;
            return s;
        }

        public ByteString getAppIdBytes() {
            Object ref = this.appId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.appId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasUid() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getUid() {
            Object ref = this.uid_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.uid_ = s;
            return s;
        }

        public ByteString getUidBytes() {
            Object ref = this.uid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.uid_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasToken() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getToken() {
            Object ref = this.token_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.token_ = s;
            }
            return s;
        }


        public ByteString getTokenBytes() {
            Object ref = this.token_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.token_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasChannel() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getChannel() {
            Object ref = this.channel_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.channel_ = s;
            }
            return s;
        }


        public ByteString getChannelBytes() {
            Object ref = this.channel_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.channel_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasOs() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getOs() {
            return this.os_;
        }


        public boolean hasImei() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getImei() {
            Object ref = this.imei_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.imei_ = s;
            }
            return s;
        }


        public ByteString getImeiBytes() {
            Object ref = this.imei_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.imei_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasVersion() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public String getVersion() {
            Object ref = this.version_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.version_ = s;
            }
            return s;
        }


        public ByteString getVersionBytes() {
            Object ref = this.version_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.version_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasChannelUid() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public String getChannelUid() {
            Object ref = this.channelUid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.channelUid_ = s;
            }
            return s;
        }


        public ByteString getChannelUidBytes() {
            Object ref = this.channelUid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.channelUid_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.appId_ = "";
            this.uid_ = "";
            this.token_ = "";
            this.channel_ = "";
            this.os_ = 0;
            this.imei_ = "";
            this.version_ = "";
            this.channelUid_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasAppId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUid()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasChannel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasOs()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasChannelUid()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getAppIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getUidBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getTokenBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getChannelBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.os_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getImeiBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBytes(7, getVersionBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBytes(8, getChannelUidBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getAppIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getUidBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getTokenBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getChannelBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.os_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getImeiBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeBytesSize(7, getVersionBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeBytesSize(8, getChannelUidBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static LoginRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LoginRequest) PARSER.parseFrom(data);
        }


        public static LoginRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LoginRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LoginRequest) PARSER.parseFrom(data);
        }


        public static LoginRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LoginRequest parseFrom(InputStream input) throws IOException {
            return (LoginRequest) PARSER.parseFrom(input);
        }


        public static LoginRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LoginRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (LoginRequest) PARSER.parseDelimitedFrom(input);
        }


        public static LoginRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LoginRequest parseFrom(CodedInputStream input) throws IOException {
            return (LoginRequest) PARSER.parseFrom(input);
        }


        public static LoginRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LoginRequest prototype) {
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
                implements LoginHandler.LoginRequestOrBuilder {
            private int bitField0_;


            private Object appId_;


            private Object uid_;


            private Object token_;


            private Object channel_;


            private int os_;


            private Object imei_;


            private Object version_;


            private Object channelUid_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LoginHandler.internal_static_pomelo_login_LoginRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginHandler.internal_static_pomelo_login_LoginRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginHandler.LoginRequest.class, Builder.class);
            }


            private Builder() {
                this.appId_ = "";
                this.uid_ = "";
                this.token_ = "";
                this.channel_ = "";
                this.imei_ = "";
                this.version_ = "";
                this.channelUid_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.appId_ = "";
                this.uid_ = "";
                this.token_ = "";
                this.channel_ = "";
                this.imei_ = "";
                this.version_ = "";
                this.channelUid_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                LoginHandler.LoginRequest.alwaysUseFieldBuilders;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.appId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.uid_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.token_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.channel_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.os_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.imei_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.version_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.channelUid_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return LoginHandler.internal_static_pomelo_login_LoginRequest_descriptor;
            }


            public LoginHandler.LoginRequest getDefaultInstanceForType() {
                return LoginHandler.LoginRequest.getDefaultInstance();
            }


            public LoginHandler.LoginRequest build() {
                LoginHandler.LoginRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LoginHandler.LoginRequest buildPartial() {
                LoginHandler.LoginRequest result = new LoginHandler.LoginRequest(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.appId_ = this.appId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.uid_ = this.uid_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.token_ = this.token_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.channel_ = this.channel_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.os_ = this.os_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.imei_ = this.imei_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.version_ = this.version_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.channelUid_ = this.channelUid_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LoginHandler.LoginRequest) {
                    return mergeFrom((LoginHandler.LoginRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LoginHandler.LoginRequest other) {
                if (other == LoginHandler.LoginRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAppId()) {
                    this.bitField0_ |= 0x1;
                    this.appId_ = other.appId_;
                    onChanged();
                }
                if (other.hasUid()) {
                    this.bitField0_ |= 0x2;
                    this.uid_ = other.uid_;
                    onChanged();
                }
                if (other.hasToken()) {
                    this.bitField0_ |= 0x4;
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.hasChannel()) {
                    this.bitField0_ |= 0x8;
                    this.channel_ = other.channel_;
                    onChanged();
                }
                if (other.hasOs()) {
                    setOs(other.getOs());
                }
                if (other.hasImei()) {
                    this.bitField0_ |= 0x20;
                    this.imei_ = other.imei_;
                    onChanged();
                }
                if (other.hasVersion()) {
                    this.bitField0_ |= 0x40;
                    this.version_ = other.version_;
                    onChanged();
                }
                if (other.hasChannelUid()) {
                    this.bitField0_ |= 0x80;
                    this.channelUid_ = other.channelUid_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasAppId()) {
                    return false;
                }
                if (!hasUid()) {
                    return false;
                }
                if (!hasToken()) {
                    return false;
                }
                if (!hasChannel()) {
                    return false;
                }
                if (!hasOs()) {
                    return false;
                }
                if (!hasChannelUid()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LoginHandler.LoginRequest parsedMessage = null;
                try {
                    parsedMessage = (LoginHandler.LoginRequest) LoginHandler.LoginRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LoginHandler.LoginRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasAppId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getAppId() {
                Object ref = this.appId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.appId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getAppIdBytes() {
                Object ref = this.appId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.appId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setAppId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.appId_ = value;
                onChanged();
                return this;
            }


            public Builder clearAppId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.appId_ = LoginHandler.LoginRequest.getDefaultInstance().getAppId();
                onChanged();
                return this;
            }


            public Builder setAppIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.appId_ = value;
                onChanged();
                return this;
            }


            public boolean hasUid() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getUid() {
                Object ref = this.uid_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.uid_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getUidBytes() {
                Object ref = this.uid_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.uid_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setUid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.uid_ = value;
                onChanged();
                return this;
            }


            public Builder clearUid() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.uid_ = LoginHandler.LoginRequest.getDefaultInstance().getUid();
                onChanged();
                return this;
            }


            public Builder setUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.uid_ = value;
                onChanged();
                return this;
            }


            public boolean hasToken() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getToken() {
                Object ref = this.token_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.token_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getTokenBytes() {
                Object ref = this.token_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.token_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }


            public Builder clearToken() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.token_ = LoginHandler.LoginRequest.getDefaultInstance().getToken();
                onChanged();
                return this;
            }


            public Builder setTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }


            public boolean hasChannel() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public String getChannel() {
                Object ref = this.channel_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.channel_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getChannelBytes() {
                Object ref = this.channel_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.channel_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setChannel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.channel_ = value;
                onChanged();
                return this;
            }


            public Builder clearChannel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.channel_ = LoginHandler.LoginRequest.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }


            public Builder setChannelBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.channel_ = value;
                onChanged();
                return this;
            }


            public boolean hasOs() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getOs() {
                return this.os_;
            }


            public Builder setOs(int value) {
                this.bitField0_ |= 0x10;
                this.os_ = value;
                onChanged();
                return this;
            }


            public Builder clearOs() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.os_ = 0;
                onChanged();
                return this;
            }


            public boolean hasImei() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public String getImei() {
                Object ref = this.imei_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.imei_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getImeiBytes() {
                Object ref = this.imei_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.imei_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setImei(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.imei_ = value;
                onChanged();
                return this;
            }


            public Builder clearImei() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.imei_ = LoginHandler.LoginRequest.getDefaultInstance().getImei();
                onChanged();
                return this;
            }


            public Builder setImeiBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.imei_ = value;
                onChanged();
                return this;
            }


            public boolean hasVersion() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public String getVersion() {
                Object ref = this.version_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.version_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getVersionBytes() {
                Object ref = this.version_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.version_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.version_ = value;
                onChanged();
                return this;
            }


            public Builder clearVersion() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.version_ = LoginHandler.LoginRequest.getDefaultInstance().getVersion();
                onChanged();
                return this;
            }


            public Builder setVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.version_ = value;
                onChanged();
                return this;
            }


            public boolean hasChannelUid() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public String getChannelUid() {
                Object ref = this.channelUid_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.channelUid_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getChannelUidBytes() {
                Object ref = this.channelUid_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.channelUid_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setChannelUid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.channelUid_ = value;
                onChanged();
                return this;
            }


            public Builder clearChannelUid() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.channelUid_ = LoginHandler.LoginRequest.getDefaultInstance().getChannelUid();
                onChanged();
                return this;
            }


            public Builder setChannelUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.channelUid_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class LoginResponse
            extends GeneratedMessage
            implements LoginResponseOrBuilder {
        private static final LoginResponse defaultInstance = new LoginResponse(true);
        private final UnknownFieldSet unknownFields;

        private LoginResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LoginResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LoginResponse getDefaultInstance() {
            return defaultInstance;
        }

        public LoginResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LoginResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.token_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.board_ = bs;
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.newUid_ = bs;
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
            return LoginHandler.internal_static_pomelo_login_LoginResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginHandler.internal_static_pomelo_login_LoginResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginResponse.class, Builder.class);
        }

        public static Parser<LoginResponse> PARSER = (Parser<LoginResponse>) new AbstractParser<LoginResponse>() {
            public LoginHandler.LoginResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LoginHandler.LoginResponse(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TOKEN_FIELD_NUMBER = 3;
        private Object token_;
        public static final int BOARD_FIELD_NUMBER = 4;
        private Object board_;
        public static final int NEWUID_FIELD_NUMBER = 5;
        private Object newUid_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LoginResponse> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }


        public boolean hasToken() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getToken() {
            Object ref = this.token_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.token_ = s;
            }
            return s;
        }


        public ByteString getTokenBytes() {
            Object ref = this.token_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.token_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasBoard() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getBoard() {
            Object ref = this.board_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.board_ = s;
            }
            return s;
        }


        public ByteString getBoardBytes() {
            Object ref = this.board_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.board_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasNewUid() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public String getNewUid() {
            Object ref = this.newUid_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.newUid_ = s;
            }
            return s;
        }


        public ByteString getNewUidBytes() {
            Object ref = this.newUid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.newUid_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.token_ = "";
            this.board_ = "";
            this.newUid_ = "";
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
            if (!hasNewUid()) {
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
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getTokenBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getBoardBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getNewUidBytes());
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
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getTokenBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getBoardBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeBytesSize(5, getNewUidBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static LoginResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LoginResponse) PARSER.parseFrom(data);
        }


        public static LoginResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LoginResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LoginResponse) PARSER.parseFrom(data);
        }


        public static LoginResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LoginResponse parseFrom(InputStream input) throws IOException {
            return (LoginResponse) PARSER.parseFrom(input);
        }


        public static LoginResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LoginResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (LoginResponse) PARSER.parseDelimitedFrom(input);
        }


        public static LoginResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LoginResponse parseFrom(CodedInputStream input) throws IOException {
            return (LoginResponse) PARSER.parseFrom(input);
        }


        public static LoginResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LoginResponse prototype) {
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
                implements LoginHandler.LoginResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private Object token_;


            private Object board_;


            private Object newUid_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LoginHandler.internal_static_pomelo_login_LoginResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginHandler.internal_static_pomelo_login_LoginResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginHandler.LoginResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.token_ = "";
                this.board_ = "";
                this.newUid_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.token_ = "";
                this.board_ = "";
                this.newUid_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                LoginHandler.LoginResponse.alwaysUseFieldBuilders;
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
                this.token_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.board_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.newUid_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return LoginHandler.internal_static_pomelo_login_LoginResponse_descriptor;
            }


            public LoginHandler.LoginResponse getDefaultInstanceForType() {
                return LoginHandler.LoginResponse.getDefaultInstance();
            }


            public LoginHandler.LoginResponse build() {
                LoginHandler.LoginResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LoginHandler.LoginResponse buildPartial() {
                LoginHandler.LoginResponse result = new LoginHandler.LoginResponse(this, null);
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
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.token_ = this.token_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.board_ = this.board_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.newUid_ = this.newUid_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LoginHandler.LoginResponse) {
                    return mergeFrom((LoginHandler.LoginResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LoginHandler.LoginResponse other) {
                if (other == LoginHandler.LoginResponse.getDefaultInstance()) {
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
                if (other.hasToken()) {
                    this.bitField0_ |= 0x4;
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.hasBoard()) {
                    this.bitField0_ |= 0x8;
                    this.board_ = other.board_;
                    onChanged();
                }
                if (other.hasNewUid()) {
                    this.bitField0_ |= 0x10;
                    this.newUid_ = other.newUid_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasNewUid()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LoginHandler.LoginResponse parsedMessage = null;
                try {
                    parsedMessage = (LoginHandler.LoginResponse) LoginHandler.LoginResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LoginHandler.LoginResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LoginHandler.LoginResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasToken() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getToken() {
                Object ref = this.token_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.token_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getTokenBytes() {
                Object ref = this.token_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.token_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }


            public Builder clearToken() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.token_ = LoginHandler.LoginResponse.getDefaultInstance().getToken();
                onChanged();
                return this;
            }


            public Builder setTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }


            public boolean hasBoard() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public String getBoard() {
                Object ref = this.board_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.board_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getBoardBytes() {
                Object ref = this.board_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.board_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setBoard(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.board_ = value;
                onChanged();
                return this;
            }


            public Builder clearBoard() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.board_ = LoginHandler.LoginResponse.getDefaultInstance().getBoard();
                onChanged();
                return this;
            }


            public Builder setBoardBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.board_ = value;
                onChanged();
                return this;
            }


            public boolean hasNewUid() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getNewUid() {
                Object ref = this.newUid_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.newUid_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getNewUidBytes() {
                Object ref = this.newUid_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.newUid_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setNewUid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.newUid_ = value;
                onChanged();
                return this;
            }


            public Builder clearNewUid() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.newUid_ = LoginHandler.LoginResponse.getDefaultInstance().getNewUid();
                onChanged();
                return this;
            }


            public Builder setNewUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.newUid_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class RegisterRequest
            extends GeneratedMessage
            implements RegisterRequestOrBuilder {
        private static final RegisterRequest defaultInstance = new RegisterRequest(true);
        private final UnknownFieldSet unknownFields;

        private RegisterRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RegisterRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RegisterRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RegisterRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RegisterRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.appId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.account_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.password_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.channel_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.os_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.model_ = bs;
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.imei_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.version_ = bs;
                            break;
                        case 74:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x100;
                            this.tel_ = bs;
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
            return LoginHandler.internal_static_pomelo_login_RegisterRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginHandler.internal_static_pomelo_login_RegisterRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RegisterRequest.class, Builder.class);
        }

        public static Parser<RegisterRequest> PARSER = (Parser<RegisterRequest>) new AbstractParser<RegisterRequest>() {
            public LoginHandler.RegisterRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LoginHandler.RegisterRequest(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int APPID_FIELD_NUMBER = 1;
        private int appId_;
        public static final int ACCOUNT_FIELD_NUMBER = 2;
        private Object account_;
        public static final int PASSWORD_FIELD_NUMBER = 3;
        private Object password_;
        public static final int CHANNEL_FIELD_NUMBER = 4;
        private int channel_;
        public static final int OS_FIELD_NUMBER = 5;
        private int os_;
        public static final int MODEL_FIELD_NUMBER = 6;
        private Object model_;
        public static final int IMEI_FIELD_NUMBER = 7;
        private Object imei_;
        public static final int VERSION_FIELD_NUMBER = 8;
        private Object version_;
        public static final int TEL_FIELD_NUMBER = 9;
        private Object tel_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RegisterRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasAppId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getAppId() {
            return this.appId_;
        }

        public boolean hasAccount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getAccount() {
            Object ref = this.account_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.account_ = s;
            return s;
        }

        public ByteString getAccountBytes() {
            Object ref = this.account_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.account_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasPassword() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        static {
            defaultInstance.initFields();
        }


        public String getPassword() {
            Object ref = this.password_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.password_ = s;
            }
            return s;
        }


        public ByteString getPasswordBytes() {
            Object ref = this.password_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.password_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasChannel() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getChannel() {
            return this.channel_;
        }


        public boolean hasOs() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getOs() {
            return this.os_;
        }


        public boolean hasModel() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getModel() {
            Object ref = this.model_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.model_ = s;
            }
            return s;
        }


        public ByteString getModelBytes() {
            Object ref = this.model_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.model_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasImei() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public String getImei() {
            Object ref = this.imei_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.imei_ = s;
            }
            return s;
        }


        public ByteString getImeiBytes() {
            Object ref = this.imei_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.imei_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasVersion() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public String getVersion() {
            Object ref = this.version_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.version_ = s;
            }
            return s;
        }


        public ByteString getVersionBytes() {
            Object ref = this.version_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.version_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasTel() {
            return ((this.bitField0_ & 0x100) == 256);
        }


        public String getTel() {
            Object ref = this.tel_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.tel_ = s;
            }
            return s;
        }

        public ByteString getTelBytes() {
            Object ref = this.tel_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.tel_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.appId_ = 0;
            this.account_ = "";
            this.password_ = "";
            this.channel_ = 0;
            this.os_ = 0;
            this.model_ = "";
            this.imei_ = "";
            this.version_ = "";
            this.tel_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasAppId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAccount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPassword()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasChannel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasOs()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.appId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getAccountBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getPasswordBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.channel_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.os_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getModelBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBytes(7, getImeiBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBytes(8, getVersionBytes());
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeBytes(9, getTelBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.appId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getAccountBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getPasswordBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.channel_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.os_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getModelBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeBytesSize(7, getImeiBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeBytesSize(8, getVersionBytes());
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeBytesSize(9, getTelBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RegisterRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RegisterRequest) PARSER.parseFrom(data);
        }

        public static RegisterRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RegisterRequest) PARSER.parseFrom(data);
        }

        public static RegisterRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterRequest parseFrom(InputStream input) throws IOException {
            return (RegisterRequest) PARSER.parseFrom(input);
        }

        public static RegisterRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RegisterRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RegisterRequest) PARSER.parseDelimitedFrom(input);
        }

        public static RegisterRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RegisterRequest parseFrom(CodedInputStream input) throws IOException {
            return (RegisterRequest) PARSER.parseFrom(input);
        }

        public static RegisterRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RegisterRequest prototype) {
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
                implements LoginHandler.RegisterRequestOrBuilder {
            private int bitField0_;
            private int appId_;
            private Object account_;
            private Object password_;
            private int channel_;
            private int os_;
            private Object model_;
            private Object imei_;
            private Object version_;
            private Object tel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LoginHandler.internal_static_pomelo_login_RegisterRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginHandler.internal_static_pomelo_login_RegisterRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginHandler.RegisterRequest.class, Builder.class);
            }

            private Builder() {
                this.account_ = "";
                this.password_ = "";
                this.model_ = "";
                this.imei_ = "";
                this.version_ = "";
                this.tel_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.account_ = "";
                this.password_ = "";
                this.model_ = "";
                this.imei_ = "";
                this.version_ = "";
                this.tel_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                LoginHandler.RegisterRequest.alwaysUseFieldBuilders;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.appId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.account_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.password_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.channel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.os_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.model_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.imei_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.version_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                this.tel_ = "";
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LoginHandler.internal_static_pomelo_login_RegisterRequest_descriptor;
            }

            public LoginHandler.RegisterRequest getDefaultInstanceForType() {
                return LoginHandler.RegisterRequest.getDefaultInstance();
            }

            public LoginHandler.RegisterRequest build() {
                LoginHandler.RegisterRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public LoginHandler.RegisterRequest buildPartial() {
                LoginHandler.RegisterRequest result = new LoginHandler.RegisterRequest(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.appId_ = this.appId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.account_ = this.account_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.password_ = this.password_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.channel_ = this.channel_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.os_ = this.os_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.model_ = this.model_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.imei_ = this.imei_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.version_ = this.version_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x100;
                }
                result.tel_ = this.tel_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LoginHandler.RegisterRequest) {
                    return mergeFrom((LoginHandler.RegisterRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LoginHandler.RegisterRequest other) {
                if (other == LoginHandler.RegisterRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAppId()) {
                    setAppId(other.getAppId());
                }
                if (other.hasAccount()) {
                    this.bitField0_ |= 0x2;
                    this.account_ = other.account_;
                    onChanged();
                }
                if (other.hasPassword()) {
                    this.bitField0_ |= 0x4;
                    this.password_ = other.password_;
                    onChanged();
                }
                if (other.hasChannel()) {
                    setChannel(other.getChannel());
                }
                if (other.hasOs()) {
                    setOs(other.getOs());
                }
                if (other.hasModel()) {
                    this.bitField0_ |= 0x20;
                    this.model_ = other.model_;
                    onChanged();
                }
                if (other.hasImei()) {
                    this.bitField0_ |= 0x40;
                    this.imei_ = other.imei_;
                    onChanged();
                }
                if (other.hasVersion()) {
                    this.bitField0_ |= 0x80;
                    this.version_ = other.version_;
                    onChanged();
                }
                if (other.hasTel()) {
                    this.bitField0_ |= 0x100;
                    this.tel_ = other.tel_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasAppId()) {
                    return false;
                }
                if (!hasAccount()) {
                    return false;
                }
                if (!hasPassword()) {
                    return false;
                }
                if (!hasChannel()) {
                    return false;
                }
                if (!hasOs()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LoginHandler.RegisterRequest parsedMessage = null;
                try {
                    parsedMessage = (LoginHandler.RegisterRequest) LoginHandler.RegisterRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LoginHandler.RegisterRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasAppId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getAppId() {
                return this.appId_;
            }

            public Builder setAppId(int value) {
                this.bitField0_ |= 0x1;
                this.appId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAppId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.appId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAccount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getAccount() {
                Object ref = this.account_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.account_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getAccountBytes() {
                Object ref = this.account_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.account_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setAccount(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.account_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.account_ = LoginHandler.RegisterRequest.getDefaultInstance().getAccount();
                onChanged();
                return this;
            }

            public Builder setAccountBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.account_ = value;
                onChanged();
                return this;
            }

            public boolean hasPassword() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getPassword() {
                Object ref = this.password_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.password_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPasswordBytes() {
                Object ref = this.password_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.password_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPassword(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.password_ = value;
                onChanged();
                return this;
            }

            public Builder clearPassword() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.password_ = LoginHandler.RegisterRequest.getDefaultInstance().getPassword();
                onChanged();
                return this;
            }

            public Builder setPasswordBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.password_ = value;
                onChanged();
                return this;
            }

            public boolean hasChannel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getChannel() {
                return this.channel_;
            }

            public Builder setChannel(int value) {
                this.bitField0_ |= 0x8;
                this.channel_ = value;
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.channel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasOs() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getOs() {
                return this.os_;
            }

            public Builder setOs(int value) {
                this.bitField0_ |= 0x10;
                this.os_ = value;
                onChanged();
                return this;
            }

            public Builder clearOs() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.os_ = 0;
                onChanged();
                return this;
            }

            public boolean hasModel() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getModel() {
                Object ref = this.model_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.model_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getModelBytes() {
                Object ref = this.model_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.model_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setModel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.model_ = value;
                onChanged();
                return this;
            }

            public Builder clearModel() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.model_ = LoginHandler.RegisterRequest.getDefaultInstance().getModel();
                onChanged();
                return this;
            }

            public Builder setModelBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.model_ = value;
                onChanged();
                return this;
            }

            public boolean hasImei() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getImei() {
                Object ref = this.imei_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.imei_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getImeiBytes() {
                Object ref = this.imei_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.imei_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setImei(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.imei_ = value;
                onChanged();
                return this;
            }

            public Builder clearImei() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.imei_ = LoginHandler.RegisterRequest.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public Builder setImeiBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.imei_ = value;
                onChanged();
                return this;
            }

            public boolean hasVersion() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getVersion() {
                Object ref = this.version_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.version_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getVersionBytes() {
                Object ref = this.version_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.version_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.version_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.version_ = LoginHandler.RegisterRequest.getDefaultInstance().getVersion();
                onChanged();
                return this;
            }

            public Builder setVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.version_ = value;
                onChanged();
                return this;
            }

            public boolean hasTel() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public String getTel() {
                Object ref = this.tel_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.tel_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTelBytes() {
                Object ref = this.tel_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.tel_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x100;
                this.tel_ = value;
                onChanged();
                return this;
            }

            public Builder clearTel() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.tel_ = LoginHandler.RegisterRequest.getDefaultInstance().getTel();
                onChanged();
                return this;
            }

            public Builder setTelBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x100;
                this.tel_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class RegisterResponse
            extends GeneratedMessage
            implements RegisterResponseOrBuilder {
        private static final RegisterResponse defaultInstance = new RegisterResponse(true);
        private final UnknownFieldSet unknownFields;

        private RegisterResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RegisterResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RegisterResponse getDefaultInstance() {
            return defaultInstance;
        }

        public RegisterResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RegisterResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.token_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.board_ = bs;
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
            return LoginHandler.internal_static_pomelo_login_RegisterResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginHandler.internal_static_pomelo_login_RegisterResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RegisterResponse.class, Builder.class);
        }

        public static Parser<RegisterResponse> PARSER = (Parser<RegisterResponse>) new AbstractParser<RegisterResponse>() {
            public LoginHandler.RegisterResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LoginHandler.RegisterResponse(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TOKEN_FIELD_NUMBER = 3;
        private Object token_;
        public static final int BOARD_FIELD_NUMBER = 4;
        private Object board_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RegisterResponse> getParserForType() {
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

        public String getS2CMsg() {
            Object ref = this.s2CMsg_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CMsg_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
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

        public boolean hasToken() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getToken() {
            Object ref = this.token_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.token_ = s;
            return s;
        }

        public ByteString getTokenBytes() {
            Object ref = this.token_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.token_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasBoard() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getBoard() {
            Object ref = this.board_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.board_ = s;
            return s;
        }

        public ByteString getBoardBytes() {
            Object ref = this.board_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.board_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.token_ = "";
            this.board_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getTokenBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getBoardBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getTokenBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getBoardBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RegisterResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RegisterResponse) PARSER.parseFrom(data);
        }

        public static RegisterResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RegisterResponse) PARSER.parseFrom(data);
        }

        public static RegisterResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegisterResponse parseFrom(InputStream input) throws IOException {
            return (RegisterResponse) PARSER.parseFrom(input);
        }

        public static RegisterResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RegisterResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RegisterResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RegisterResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RegisterResponse parseFrom(CodedInputStream input) throws IOException {
            return (RegisterResponse) PARSER.parseFrom(input);
        }

        public static RegisterResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RegisterResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LoginHandler.RegisterResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Object token_;
            private Object board_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LoginHandler.internal_static_pomelo_login_RegisterResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginHandler.internal_static_pomelo_login_RegisterResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginHandler.RegisterResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.token_ = "";
                this.board_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.token_ = "";
                this.board_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                LoginHandler.RegisterResponse.alwaysUseFieldBuilders;
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
                this.token_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.board_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LoginHandler.internal_static_pomelo_login_RegisterResponse_descriptor;
            }

            public LoginHandler.RegisterResponse getDefaultInstanceForType() {
                return LoginHandler.RegisterResponse.getDefaultInstance();
            }

            public LoginHandler.RegisterResponse build() {
                LoginHandler.RegisterResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LoginHandler.RegisterResponse buildPartial() {
                LoginHandler.RegisterResponse result = new LoginHandler.RegisterResponse(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.token_ = this.token_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.board_ = this.board_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LoginHandler.RegisterResponse)
                    return mergeFrom((LoginHandler.RegisterResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LoginHandler.RegisterResponse other) {
                if (other == LoginHandler.RegisterResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasToken()) {
                    this.bitField0_ |= 0x4;
                    this.token_ = other.token_;
                    onChanged();
                }
                if (other.hasBoard()) {
                    this.bitField0_ |= 0x8;
                    this.board_ = other.board_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LoginHandler.RegisterResponse parsedMessage = null;
                try {
                    parsedMessage = (LoginHandler.RegisterResponse) LoginHandler.RegisterResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LoginHandler.RegisterResponse) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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
                    if (bs.isValidUtf8())
                        this.s2CMsg_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = LoginHandler.RegisterResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }

            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public boolean hasToken() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getToken() {
                Object ref = this.token_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.token_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTokenBytes() {
                Object ref = this.token_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.token_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setToken(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }

            public Builder clearToken() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.token_ = LoginHandler.RegisterResponse.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            public Builder setTokenBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.token_ = value;
                onChanged();
                return this;
            }

            public boolean hasBoard() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getBoard() {
                Object ref = this.board_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.board_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getBoardBytes() {
                Object ref = this.board_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.board_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setBoard(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.board_ = value;
                onChanged();
                return this;
            }

            public Builder clearBoard() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.board_ = LoginHandler.RegisterResponse.getDefaultInstance().getBoard();
                onChanged();
                return this;
            }

            public Builder setBoardBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.board_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class ServerStatePush extends GeneratedMessage implements ServerStatePushOrBuilder {
        private static final ServerStatePush defaultInstance = new ServerStatePush(true);
        private final UnknownFieldSet unknownFields;

        private ServerStatePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ServerStatePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ServerStatePush getDefaultInstance() {
            return defaultInstance;
        }

        public ServerStatePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ServerStatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.sid_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.state_ = input.readInt32();
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
            return LoginHandler.internal_static_pomelo_login_ServerStatePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LoginHandler.internal_static_pomelo_login_ServerStatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerStatePush.class, Builder.class);
        }

        public static Parser<ServerStatePush> PARSER = (Parser<ServerStatePush>) new AbstractParser<ServerStatePush>() {
            public LoginHandler.ServerStatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LoginHandler.ServerStatePush(input, extensionRegistry, null);
            }
        };
        private int bitField0_;
        public static final int SID_FIELD_NUMBER = 1;
        private int sid_;
        public static final int STATE_FIELD_NUMBER = 2;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ServerStatePush> getParserForType() {
            return PARSER;
        }

        public boolean hasSid() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getSid() {
            return this.sid_;
        }

        public boolean hasState() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getState() {
            return this.state_;
        }

        private void initFields() {
            this.sid_ = 0;
            this.state_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasSid()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasState()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.sid_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.state_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.sid_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.state_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ServerStatePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ServerStatePush) PARSER.parseFrom(data);
        }

        public static ServerStatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServerStatePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerStatePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ServerStatePush) PARSER.parseFrom(data);
        }

        public static ServerStatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ServerStatePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerStatePush parseFrom(InputStream input) throws IOException {
            return (ServerStatePush) PARSER.parseFrom(input);
        }

        static {
            defaultInstance.initFields();
        }

        public static ServerStatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerStatePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ServerStatePush parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerStatePush) PARSER.parseDelimitedFrom(input);
        }

        public static ServerStatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerStatePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ServerStatePush parseFrom(CodedInputStream input) throws IOException {
            return (ServerStatePush) PARSER.parseFrom(input);
        }

        public static ServerStatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerStatePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServerStatePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LoginHandler.ServerStatePushOrBuilder {
            private int bitField0_;
            private int sid_;
            private int state_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LoginHandler.internal_static_pomelo_login_ServerStatePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LoginHandler.internal_static_pomelo_login_ServerStatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginHandler.ServerStatePush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                LoginHandler.ServerStatePush.alwaysUseFieldBuilders;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.sid_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LoginHandler.internal_static_pomelo_login_ServerStatePush_descriptor;
            }

            public LoginHandler.ServerStatePush getDefaultInstanceForType() {
                return LoginHandler.ServerStatePush.getDefaultInstance();
            }

            public LoginHandler.ServerStatePush build() {
                LoginHandler.ServerStatePush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public LoginHandler.ServerStatePush buildPartial() {
                LoginHandler.ServerStatePush result = new LoginHandler.ServerStatePush(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.sid_ = this.sid_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LoginHandler.ServerStatePush)
                    return mergeFrom((LoginHandler.ServerStatePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LoginHandler.ServerStatePush other) {
                if (other == LoginHandler.ServerStatePush.getDefaultInstance()) return this;
                if (other.hasSid()) setSid(other.getSid());
                if (other.hasState()) setState(other.getState());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasSid()) return false;
                if (!hasState()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LoginHandler.ServerStatePush parsedMessage = null;
                try {
                    parsedMessage = (LoginHandler.ServerStatePush) LoginHandler.ServerStatePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LoginHandler.ServerStatePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasSid() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getSid() {
                return this.sid_;
            }

            public Builder setSid(int value) {
                this.bitField0_ |= 0x1;
                this.sid_ = value;
                onChanged();
                return this;
            }

            public Builder clearSid() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.sid_ = 0;
                onChanged();
                return this;
            }

            public boolean hasState() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.bitField0_ |= 0x2;
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.state_ = 0;
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
                "\n\022loginHandler.proto\022\fpomelo.login\032\fcommon.proto\"\001\n\fLoginRequest\022\r\n\005appId\030\001 \002(\t\022\013\n\003uid\030\002 \002(\t\022\r\n\005token\030\003 \002(\t\022\017\n\007channel\030\004 \002(\t\022\n\n\002os\030\005 \002(\005\022\f\n\004imei\030\006 \001(\t\022\017\n\007version\030\007 \001(\t\022\022\n\nchannelUid\030\b \002(\t\"`\n\rLoginResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\r\n\005token\030\003 \001(\t\022\r\n\005board\030\004 \001(\t\022\016\n\006newUid\030\005 \002(\t\"\001\n\017RegisterRequest\022\r\n\005appId\030\001 \002(\005\022\017\n\007account\030\002 \002(\t\022\020\n\bpassword\030\003 \002(\t\022\017\n\007channel\030\004 \002(\005\022\n\n\002os\030\005 \002(\005\022\r\n\005model\030\006 \001(\t",


                "\022\f\n\004imei\030\007 \001(\t\022\017\n\007version\030\b \001(\t\022\013\n\003tel\030\t \001(\t\"S\n\020RegisterResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\r\n\005token\030\003 \001(\t\022\r\n\005board\030\004 \001(\t\"-\n\017ServerStatePush\022\013\n\003sid\030\001 \002(\005\022\r\n\005state\030\002 \002(\0052©\001\n\floginHandler\022G\n\floginRequest\022\032.pomelo.login.LoginRequest\032\033.pomelo.login.LoginResponse\022P\n\017registerRequest\022\035.pomelo.login.RegisterRequest\032\036.pomelo.login.RegisterResponse2K\n\tloginPush\022>\n\017serverStatePush\022\035.pomelo.login.Serv",


                "erStatePush\032\f.pomelo.VoidB\030\n\026com.wanniu.login.proto"
        };

        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                        LoginHandler.descriptor = root;
                        return null;
                    }
                };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new Descriptors.FileDescriptor[]{
                        Common.getDescriptor()
                }, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_login_LoginRequest_descriptor = getDescriptor().getMessageTypes().get(0);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_login_LoginRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_login_LoginRequest_descriptor,
            new String[]{"AppId", "Uid", "Token", "Channel", "Os", "Imei", "Version", "ChannelUid"});

    private static final Descriptors.Descriptor internal_static_pomelo_login_LoginResponse_descriptor = getDescriptor().getMessageTypes().get(1);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_login_LoginResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_login_LoginResponse_descriptor,
            new String[]{"S2CCode", "S2CMsg", "Token", "Board", "NewUid"});

    private static final Descriptors.Descriptor internal_static_pomelo_login_RegisterRequest_descriptor = getDescriptor().getMessageTypes().get(2);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_login_RegisterRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_login_RegisterRequest_descriptor,
            new String[]{"AppId", "Account", "Password", "Channel", "Os", "Model", "Imei", "Version", "Tel"});

    private static final Descriptors.Descriptor internal_static_pomelo_login_RegisterResponse_descriptor = getDescriptor().getMessageTypes().get(3);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_login_RegisterResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_login_RegisterResponse_descriptor,
            new String[]{"S2CCode", "S2CMsg", "Token", "Board"});

    private static final Descriptors.Descriptor internal_static_pomelo_login_ServerStatePush_descriptor = getDescriptor().getMessageTypes().get(4);

    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_login_ServerStatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(
            internal_static_pomelo_login_ServerStatePush_descriptor,
            new String[]{"Sid", "State"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface LoginRequestOrBuilder extends MessageOrBuilder {
        boolean hasAppId();

        String getAppId();

        ByteString getAppIdBytes();

        boolean hasUid();

        String getUid();

        ByteString getUidBytes();

        boolean hasToken();

        String getToken();

        ByteString getTokenBytes();

        boolean hasChannel();

        String getChannel();

        ByteString getChannelBytes();

        boolean hasOs();

        int getOs();

        boolean hasImei();

        String getImei();

        ByteString getImeiBytes();

        boolean hasVersion();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasChannelUid();

        String getChannelUid();

        ByteString getChannelUidBytes();
    }

    public static interface LoginResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasToken();

        String getToken();

        ByteString getTokenBytes();

        boolean hasBoard();

        String getBoard();

        ByteString getBoardBytes();

        boolean hasNewUid();

        String getNewUid();

        ByteString getNewUidBytes();
    }

    public static interface RegisterRequestOrBuilder extends MessageOrBuilder {
        boolean hasAppId();

        int getAppId();

        boolean hasAccount();

        String getAccount();

        ByteString getAccountBytes();

        boolean hasPassword();

        String getPassword();

        ByteString getPasswordBytes();

        boolean hasChannel();

        int getChannel();

        boolean hasOs();

        int getOs();

        boolean hasModel();

        String getModel();

        ByteString getModelBytes();

        boolean hasImei();

        String getImei();

        ByteString getImeiBytes();

        boolean hasVersion();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasTel();

        String getTel();

        ByteString getTelBytes();
    }

    public static interface RegisterResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasToken();

        String getToken();

        ByteString getTokenBytes();

        boolean hasBoard();

        String getBoard();

        ByteString getBoardBytes();
    }

    public static interface ServerStatePushOrBuilder extends MessageOrBuilder {
        boolean hasSid();

        int getSid();

        boolean hasState();

        int getState();
    }
}


