package pomelo.xianyuan;

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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class XianYuanHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class XianYuanRequest
            extends GeneratedMessage
            implements XianYuanRequestOrBuilder {
        private static final XianYuanRequest defaultInstance = new XianYuanRequest(true);
        private final UnknownFieldSet unknownFields;

        private XianYuanRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private XianYuanRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static XianYuanRequest getDefaultInstance() {
            return defaultInstance;
        }

        public XianYuanRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private XianYuanRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanRequest.class, Builder.class);
        }

        public static Parser<XianYuanRequest> PARSER = (Parser<XianYuanRequest>) new AbstractParser<XianYuanRequest>() {
            public XianYuanHandler.XianYuanRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new XianYuanHandler.XianYuanRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<XianYuanRequest> getParserForType() {
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

        public static XianYuanRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (XianYuanRequest) PARSER.parseFrom(data);
        }

        public static XianYuanRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static XianYuanRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (XianYuanRequest) PARSER.parseFrom(data);
        }

        public static XianYuanRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static XianYuanRequest parseFrom(InputStream input) throws IOException {
            return (XianYuanRequest) PARSER.parseFrom(input);
        }

        public static XianYuanRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static XianYuanRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (XianYuanRequest) PARSER.parseDelimitedFrom(input);
        }

        public static XianYuanRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static XianYuanRequest parseFrom(CodedInputStream input) throws IOException {
            return (XianYuanRequest) PARSER.parseFrom(input);
        }

        public static XianYuanRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(XianYuanRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements XianYuanHandler.XianYuanRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanHandler.XianYuanRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (XianYuanHandler.XianYuanRequest.alwaysUseFieldBuilders) ;
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
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanRequest_descriptor;
            }

            public XianYuanHandler.XianYuanRequest getDefaultInstanceForType() {
                return XianYuanHandler.XianYuanRequest.getDefaultInstance();
            }

            public XianYuanHandler.XianYuanRequest build() {
                XianYuanHandler.XianYuanRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public XianYuanHandler.XianYuanRequest buildPartial() {
                XianYuanHandler.XianYuanRequest result = new XianYuanHandler.XianYuanRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof XianYuanHandler.XianYuanRequest)
                    return mergeFrom((XianYuanHandler.XianYuanRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(XianYuanHandler.XianYuanRequest other) {
                if (other == XianYuanHandler.XianYuanRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                XianYuanHandler.XianYuanRequest parsedMessage = null;
                try {
                    parsedMessage = (XianYuanHandler.XianYuanRequest) XianYuanHandler.XianYuanRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (XianYuanHandler.XianYuanRequest) e.getUnfinishedMessage();
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


    public static final class XianYuanGetInfo
            extends GeneratedMessage
            implements XianYuanGetInfoOrBuilder {
        private static final XianYuanGetInfo defaultInstance = new XianYuanGetInfo(true);
        private final UnknownFieldSet unknownFields;

        private XianYuanGetInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private XianYuanGetInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static XianYuanGetInfo getDefaultInstance() {
            return defaultInstance;
        }

        public XianYuanGetInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private XianYuanGetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.configId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.todayRecive_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.todayLimite_ = input.readInt32();
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
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanGetInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanGetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanGetInfo.class, Builder.class);
        }

        public static Parser<XianYuanGetInfo> PARSER = (Parser<XianYuanGetInfo>) new AbstractParser<XianYuanGetInfo>() {
            public XianYuanHandler.XianYuanGetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new XianYuanHandler.XianYuanGetInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int CONFIGID_FIELD_NUMBER = 1;
        private int configId_;
        public static final int TODAYRECIVE_FIELD_NUMBER = 2;
        private int todayRecive_;
        public static final int TODAYLIMITE_FIELD_NUMBER = 3;
        private int todayLimite_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<XianYuanGetInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasConfigId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getConfigId() {
            return this.configId_;
        }

        public boolean hasTodayRecive() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTodayRecive() {
            return this.todayRecive_;
        }

        public boolean hasTodayLimite() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getTodayLimite() {
            return this.todayLimite_;
        }

        private void initFields() {
            this.configId_ = 0;
            this.todayRecive_ = 0;
            this.todayLimite_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.configId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.todayRecive_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.todayLimite_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.configId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.todayRecive_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.todayLimite_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static XianYuanGetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (XianYuanGetInfo) PARSER.parseFrom(data);
        }

        public static XianYuanGetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanGetInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static XianYuanGetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (XianYuanGetInfo) PARSER.parseFrom(data);
        }

        public static XianYuanGetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanGetInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static XianYuanGetInfo parseFrom(InputStream input) throws IOException {
            return (XianYuanGetInfo) PARSER.parseFrom(input);
        }

        public static XianYuanGetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanGetInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static XianYuanGetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (XianYuanGetInfo) PARSER.parseDelimitedFrom(input);
        }

        public static XianYuanGetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanGetInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static XianYuanGetInfo parseFrom(CodedInputStream input) throws IOException {
            return (XianYuanGetInfo) PARSER.parseFrom(input);
        }

        public static XianYuanGetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanGetInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(XianYuanGetInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements XianYuanHandler.XianYuanGetInfoOrBuilder {
            private int bitField0_;
            private int configId_;
            private int todayRecive_;
            private int todayLimite_;

            public static final Descriptors.Descriptor getDescriptor() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanGetInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanGetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanHandler.XianYuanGetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (XianYuanHandler.XianYuanGetInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.configId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.todayRecive_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.todayLimite_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanGetInfo_descriptor;
            }

            public XianYuanHandler.XianYuanGetInfo getDefaultInstanceForType() {
                return XianYuanHandler.XianYuanGetInfo.getDefaultInstance();
            }

            public XianYuanHandler.XianYuanGetInfo build() {
                XianYuanHandler.XianYuanGetInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public XianYuanHandler.XianYuanGetInfo buildPartial() {
                XianYuanHandler.XianYuanGetInfo result = new XianYuanHandler.XianYuanGetInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.configId_ = this.configId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.todayRecive_ = this.todayRecive_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.todayLimite_ = this.todayLimite_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof XianYuanHandler.XianYuanGetInfo)
                    return mergeFrom((XianYuanHandler.XianYuanGetInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(XianYuanHandler.XianYuanGetInfo other) {
                if (other == XianYuanHandler.XianYuanGetInfo.getDefaultInstance()) return this;
                if (other.hasConfigId()) setConfigId(other.getConfigId());
                if (other.hasTodayRecive()) setTodayRecive(other.getTodayRecive());
                if (other.hasTodayLimite()) setTodayLimite(other.getTodayLimite());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                XianYuanHandler.XianYuanGetInfo parsedMessage = null;
                try {
                    parsedMessage = (XianYuanHandler.XianYuanGetInfo) XianYuanHandler.XianYuanGetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (XianYuanHandler.XianYuanGetInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasConfigId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.bitField0_ |= 0x1;
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.configId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTodayRecive() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getTodayRecive() {
                return this.todayRecive_;
            }

            public Builder setTodayRecive(int value) {
                this.bitField0_ |= 0x2;
                this.todayRecive_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodayRecive() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.todayRecive_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTodayLimite() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getTodayLimite() {
                return this.todayLimite_;
            }

            public Builder setTodayLimite(int value) {
                this.bitField0_ |= 0x4;
                this.todayLimite_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodayLimite() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.todayLimite_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class XianYuanResponse
            extends GeneratedMessage
            implements XianYuanResponseOrBuilder {
        private static final XianYuanResponse defaultInstance = new XianYuanResponse(true);
        private final UnknownFieldSet unknownFields;

        private XianYuanResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private XianYuanResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static XianYuanResponse getDefaultInstance() {
            return defaultInstance;
        }

        public XianYuanResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private XianYuanResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.totalXianYuan_ = input.readInt32();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.xianYuanGetInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.xianYuanGetInfo_.add(input.readMessage(XianYuanHandler.XianYuanGetInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.xianYuanGetInfo_ = Collections.unmodifiableList(this.xianYuanGetInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanResponse.class, Builder.class);
        }

        public static Parser<XianYuanResponse> PARSER = (Parser<XianYuanResponse>) new AbstractParser<XianYuanResponse>() {
            public XianYuanHandler.XianYuanResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new XianYuanHandler.XianYuanResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TOTALXIANYUAN_FIELD_NUMBER = 3;
        private int totalXianYuan_;
        public static final int XIANYUANGETINFO_FIELD_NUMBER = 4;
        private List<XianYuanHandler.XianYuanGetInfo> xianYuanGetInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<XianYuanResponse> getParserForType() {
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

        public boolean hasTotalXianYuan() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getTotalXianYuan() {
            return this.totalXianYuan_;
        }

        public List<XianYuanHandler.XianYuanGetInfo> getXianYuanGetInfoList() {
            return this.xianYuanGetInfo_;
        }

        public List<? extends XianYuanHandler.XianYuanGetInfoOrBuilder> getXianYuanGetInfoOrBuilderList() {
            return (List) this.xianYuanGetInfo_;
        }

        public int getXianYuanGetInfoCount() {
            return this.xianYuanGetInfo_.size();
        }

        public XianYuanHandler.XianYuanGetInfo getXianYuanGetInfo(int index) {
            return this.xianYuanGetInfo_.get(index);
        }

        public XianYuanHandler.XianYuanGetInfoOrBuilder getXianYuanGetInfoOrBuilder(int index) {
            return this.xianYuanGetInfo_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.totalXianYuan_ = 0;
            this.xianYuanGetInfo_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.totalXianYuan_);
            for (int i = 0; i < this.xianYuanGetInfo_.size(); i++)
                output.writeMessage(4, (MessageLite) this.xianYuanGetInfo_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.totalXianYuan_);
            for (int i = 0; i < this.xianYuanGetInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.xianYuanGetInfo_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static XianYuanResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (XianYuanResponse) PARSER.parseFrom(data);
        }

        public static XianYuanResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static XianYuanResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (XianYuanResponse) PARSER.parseFrom(data);
        }

        public static XianYuanResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (XianYuanResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static XianYuanResponse parseFrom(InputStream input) throws IOException {
            return (XianYuanResponse) PARSER.parseFrom(input);
        }

        public static XianYuanResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static XianYuanResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (XianYuanResponse) PARSER.parseDelimitedFrom(input);
        }

        public static XianYuanResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static XianYuanResponse parseFrom(CodedInputStream input) throws IOException {
            return (XianYuanResponse) PARSER.parseFrom(input);
        }

        public static XianYuanResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (XianYuanResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(XianYuanResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements XianYuanHandler.XianYuanResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int totalXianYuan_;
            private List<XianYuanHandler.XianYuanGetInfo> xianYuanGetInfo_;
            private RepeatedFieldBuilder<XianYuanHandler.XianYuanGetInfo, XianYuanHandler.XianYuanGetInfo.Builder, XianYuanHandler.XianYuanGetInfoOrBuilder> xianYuanGetInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(XianYuanHandler.XianYuanResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.xianYuanGetInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.xianYuanGetInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (XianYuanHandler.XianYuanResponse.alwaysUseFieldBuilders) getXianYuanGetInfoFieldBuilder();
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
                this.totalXianYuan_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.xianYuanGetInfoBuilder_ == null) {
                    this.xianYuanGetInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.xianYuanGetInfoBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return XianYuanHandler.internal_static_pomelo_xianyuan_XianYuanResponse_descriptor;
            }

            public XianYuanHandler.XianYuanResponse getDefaultInstanceForType() {
                return XianYuanHandler.XianYuanResponse.getDefaultInstance();
            }

            public XianYuanHandler.XianYuanResponse build() {
                XianYuanHandler.XianYuanResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public XianYuanHandler.XianYuanResponse buildPartial() {
                XianYuanHandler.XianYuanResponse result = new XianYuanHandler.XianYuanResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.totalXianYuan_ = this.totalXianYuan_;
                if (this.xianYuanGetInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.xianYuanGetInfo_ = Collections.unmodifiableList(this.xianYuanGetInfo_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.xianYuanGetInfo_ = this.xianYuanGetInfo_;
                } else {
                    result.xianYuanGetInfo_ = this.xianYuanGetInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof XianYuanHandler.XianYuanResponse)
                    return mergeFrom((XianYuanHandler.XianYuanResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(XianYuanHandler.XianYuanResponse other) {
                if (other == XianYuanHandler.XianYuanResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasTotalXianYuan()) setTotalXianYuan(other.getTotalXianYuan());
                if (this.xianYuanGetInfoBuilder_ == null) {
                    if (!other.xianYuanGetInfo_.isEmpty()) {
                        if (this.xianYuanGetInfo_.isEmpty()) {
                            this.xianYuanGetInfo_ = other.xianYuanGetInfo_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureXianYuanGetInfoIsMutable();
                            this.xianYuanGetInfo_.addAll(other.xianYuanGetInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.xianYuanGetInfo_.isEmpty()) {
                    if (this.xianYuanGetInfoBuilder_.isEmpty()) {
                        this.xianYuanGetInfoBuilder_.dispose();
                        this.xianYuanGetInfoBuilder_ = null;
                        this.xianYuanGetInfo_ = other.xianYuanGetInfo_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.xianYuanGetInfoBuilder_ = XianYuanHandler.XianYuanResponse.alwaysUseFieldBuilders ? getXianYuanGetInfoFieldBuilder() : null;
                    } else {
                        this.xianYuanGetInfoBuilder_.addAllMessages(other.xianYuanGetInfo_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                XianYuanHandler.XianYuanResponse parsedMessage = null;
                try {
                    parsedMessage = (XianYuanHandler.XianYuanResponse) XianYuanHandler.XianYuanResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (XianYuanHandler.XianYuanResponse) e.getUnfinishedMessage();
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

            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = XianYuanHandler.XianYuanResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }

            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public boolean hasTotalXianYuan() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getTotalXianYuan() {
                return this.totalXianYuan_;
            }

            public Builder setTotalXianYuan(int value) {
                this.bitField0_ |= 0x4;
                this.totalXianYuan_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalXianYuan() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.totalXianYuan_ = 0;
                onChanged();
                return this;
            }

            private void ensureXianYuanGetInfoIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.xianYuanGetInfo_ = new ArrayList<>(this.xianYuanGetInfo_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<XianYuanHandler.XianYuanGetInfo> getXianYuanGetInfoList() {
                if (this.xianYuanGetInfoBuilder_ == null) return Collections.unmodifiableList(this.xianYuanGetInfo_);
                return this.xianYuanGetInfoBuilder_.getMessageList();
            }

            public int getXianYuanGetInfoCount() {
                if (this.xianYuanGetInfoBuilder_ == null) return this.xianYuanGetInfo_.size();
                return this.xianYuanGetInfoBuilder_.getCount();
            }

            public XianYuanHandler.XianYuanGetInfo getXianYuanGetInfo(int index) {
                if (this.xianYuanGetInfoBuilder_ == null) return this.xianYuanGetInfo_.get(index);
                return (XianYuanHandler.XianYuanGetInfo) this.xianYuanGetInfoBuilder_.getMessage(index);
            }

            public Builder setXianYuanGetInfo(int index, XianYuanHandler.XianYuanGetInfo value) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.set(index, value);
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setXianYuanGetInfo(int index, XianYuanHandler.XianYuanGetInfo.Builder builderForValue) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addXianYuanGetInfo(XianYuanHandler.XianYuanGetInfo value) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.add(value);
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addXianYuanGetInfo(int index, XianYuanHandler.XianYuanGetInfo value) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.add(index, value);
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addXianYuanGetInfo(XianYuanHandler.XianYuanGetInfo.Builder builderForValue) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addXianYuanGetInfo(int index, XianYuanHandler.XianYuanGetInfo.Builder builderForValue) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllXianYuanGetInfo(Iterable<? extends XianYuanHandler.XianYuanGetInfo> values) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    ensureXianYuanGetInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.xianYuanGetInfo_);
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearXianYuanGetInfo() {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    this.xianYuanGetInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeXianYuanGetInfo(int index) {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    ensureXianYuanGetInfoIsMutable();
                    this.xianYuanGetInfo_.remove(index);
                    onChanged();
                } else {
                    this.xianYuanGetInfoBuilder_.remove(index);
                }
                return this;
            }

            public XianYuanHandler.XianYuanGetInfo.Builder getXianYuanGetInfoBuilder(int index) {
                return (XianYuanHandler.XianYuanGetInfo.Builder) getXianYuanGetInfoFieldBuilder().getBuilder(index);
            }

            public XianYuanHandler.XianYuanGetInfoOrBuilder getXianYuanGetInfoOrBuilder(int index) {
                if (this.xianYuanGetInfoBuilder_ == null) return this.xianYuanGetInfo_.get(index);
                return (XianYuanHandler.XianYuanGetInfoOrBuilder) this.xianYuanGetInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends XianYuanHandler.XianYuanGetInfoOrBuilder> getXianYuanGetInfoOrBuilderList() {
                if (this.xianYuanGetInfoBuilder_ != null) return this.xianYuanGetInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.xianYuanGetInfo_);
            }

            public XianYuanHandler.XianYuanGetInfo.Builder addXianYuanGetInfoBuilder() {
                return (XianYuanHandler.XianYuanGetInfo.Builder) getXianYuanGetInfoFieldBuilder().addBuilder(XianYuanHandler.XianYuanGetInfo.getDefaultInstance());
            }

            public XianYuanHandler.XianYuanGetInfo.Builder addXianYuanGetInfoBuilder(int index) {
                return (XianYuanHandler.XianYuanGetInfo.Builder) getXianYuanGetInfoFieldBuilder().addBuilder(index, XianYuanHandler.XianYuanGetInfo.getDefaultInstance());
            }

            public List<XianYuanHandler.XianYuanGetInfo.Builder> getXianYuanGetInfoBuilderList() {
                return getXianYuanGetInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<XianYuanHandler.XianYuanGetInfo, XianYuanHandler.XianYuanGetInfo.Builder, XianYuanHandler.XianYuanGetInfoOrBuilder> getXianYuanGetInfoFieldBuilder() {
                if (this.xianYuanGetInfoBuilder_ == null) {
                    this.xianYuanGetInfoBuilder_ = new RepeatedFieldBuilder(this.xianYuanGetInfo_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.xianYuanGetInfo_ = null;
                }
                return this.xianYuanGetInfoBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025xianYuanHandler.proto\022\017pomelo.xianyuan\"\021\n\017XianYuanRequest\"M\n\017XianYuanGetInfo\022\020\n\bconfigId\030\001 \001(\005\022\023\n\013todayRecive\030\002 \001(\005\022\023\n\013todayLimite\030\003 \001(\005\"\001\n\020XianYuanResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\025\n\rtotalXianYuan\030\003 \001(\005\0229\n\017xianYuanGetInfo\030\004 \003(\0132 .pomelo.xianyuan.XianYuanGetInfo2n\n\017xianYuanHandler\022[\n\024applyXianYuanRequest\022 .pomelo.xianyuan.XianYuanRequest\032!.pomelo.xianyuan.XianYuanResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                XianYuanHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_xianyuan_XianYuanRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_xianyuan_XianYuanRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_xianyuan_XianYuanRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_xianyuan_XianYuanGetInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_xianyuan_XianYuanGetInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_xianyuan_XianYuanGetInfo_descriptor, new String[]{"ConfigId", "TodayRecive", "TodayLimite"});


    private static final Descriptors.Descriptor internal_static_pomelo_xianyuan_XianYuanResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_xianyuan_XianYuanResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_xianyuan_XianYuanResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "TotalXianYuan", "XianYuanGetInfo"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface XianYuanResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasTotalXianYuan();

        int getTotalXianYuan();

        List<XianYuanHandler.XianYuanGetInfo> getXianYuanGetInfoList();

        XianYuanHandler.XianYuanGetInfo getXianYuanGetInfo(int param1Int);

        int getXianYuanGetInfoCount();

        List<? extends XianYuanHandler.XianYuanGetInfoOrBuilder> getXianYuanGetInfoOrBuilderList();

        XianYuanHandler.XianYuanGetInfoOrBuilder getXianYuanGetInfoOrBuilder(int param1Int);
    }

    public static interface XianYuanGetInfoOrBuilder extends MessageOrBuilder {
        boolean hasConfigId();

        int getConfigId();

        boolean hasTodayRecive();

        int getTodayRecive();

        boolean hasTodayLimite();

        int getTodayLimite();
    }

    public static interface XianYuanRequestOrBuilder extends MessageOrBuilder {
    }
}


