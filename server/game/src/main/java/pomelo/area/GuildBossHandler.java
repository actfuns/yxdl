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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pomelo.Common;


public final class GuildBossHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class EnterGuildBossAreaRequest
            extends GeneratedMessage
            implements EnterGuildBossAreaRequestOrBuilder {
        private static final EnterGuildBossAreaRequest defaultInstance = new EnterGuildBossAreaRequest(true);
        private final UnknownFieldSet unknownFields;

        private EnterGuildBossAreaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EnterGuildBossAreaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EnterGuildBossAreaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public EnterGuildBossAreaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterGuildBossAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterGuildBossAreaRequest.class, Builder.class);
        }

        public static Parser<EnterGuildBossAreaRequest> PARSER = (Parser<EnterGuildBossAreaRequest>) new AbstractParser<EnterGuildBossAreaRequest>() {
            public GuildBossHandler.EnterGuildBossAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.EnterGuildBossAreaRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<EnterGuildBossAreaRequest> getParserForType() {
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

        public static EnterGuildBossAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(data);
        }

        public static EnterGuildBossAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterGuildBossAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(data);
        }

        public static EnterGuildBossAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterGuildBossAreaRequest parseFrom(InputStream input) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(input);
        }

        public static EnterGuildBossAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EnterGuildBossAreaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseDelimitedFrom(input);
        }

        public static EnterGuildBossAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EnterGuildBossAreaRequest parseFrom(CodedInputStream input) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(input);
        }

        public static EnterGuildBossAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnterGuildBossAreaRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.EnterGuildBossAreaRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.EnterGuildBossAreaRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.EnterGuildBossAreaRequest.alwaysUseFieldBuilders) ;
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
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaRequest_descriptor;
            }

            public GuildBossHandler.EnterGuildBossAreaRequest getDefaultInstanceForType() {
                return GuildBossHandler.EnterGuildBossAreaRequest.getDefaultInstance();
            }

            public GuildBossHandler.EnterGuildBossAreaRequest build() {
                GuildBossHandler.EnterGuildBossAreaRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.EnterGuildBossAreaRequest buildPartial() {
                GuildBossHandler.EnterGuildBossAreaRequest result = new GuildBossHandler.EnterGuildBossAreaRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.EnterGuildBossAreaRequest)
                    return mergeFrom((GuildBossHandler.EnterGuildBossAreaRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.EnterGuildBossAreaRequest other) {
                if (other == GuildBossHandler.EnterGuildBossAreaRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.EnterGuildBossAreaRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.EnterGuildBossAreaRequest) GuildBossHandler.EnterGuildBossAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.EnterGuildBossAreaRequest) e.getUnfinishedMessage();
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


    public static final class EnterGuildBossAreaResponse
            extends GeneratedMessage
            implements EnterGuildBossAreaResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private EnterGuildBossAreaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private EnterGuildBossAreaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static EnterGuildBossAreaResponse getDefaultInstance() {
            return defaultInstance;
        }


        public EnterGuildBossAreaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private EnterGuildBossAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterGuildBossAreaResponse.class, Builder.class);
        }


        public static Parser<EnterGuildBossAreaResponse> PARSER = (Parser<EnterGuildBossAreaResponse>) new AbstractParser<EnterGuildBossAreaResponse>() {
            public GuildBossHandler.EnterGuildBossAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.EnterGuildBossAreaResponse(input, extensionRegistry);
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


        public Parser<EnterGuildBossAreaResponse> getParserForType() {
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


        private static final EnterGuildBossAreaResponse defaultInstance = new EnterGuildBossAreaResponse(true);

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
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnterGuildBossAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(data);
        }

        public static EnterGuildBossAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterGuildBossAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(data);
        }

        public static EnterGuildBossAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterGuildBossAreaResponse parseFrom(InputStream input) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(input);
        }

        public static EnterGuildBossAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EnterGuildBossAreaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseDelimitedFrom(input);
        }

        public static EnterGuildBossAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EnterGuildBossAreaResponse parseFrom(CodedInputStream input) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(input);
        }

        public static EnterGuildBossAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterGuildBossAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnterGuildBossAreaResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.EnterGuildBossAreaResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.EnterGuildBossAreaResponse.class, Builder.class);
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
                if (GuildBossHandler.EnterGuildBossAreaResponse.alwaysUseFieldBuilders) ;
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
                return GuildBossHandler.internal_static_pomelo_area_EnterGuildBossAreaResponse_descriptor;
            }

            public GuildBossHandler.EnterGuildBossAreaResponse getDefaultInstanceForType() {
                return GuildBossHandler.EnterGuildBossAreaResponse.getDefaultInstance();
            }

            public GuildBossHandler.EnterGuildBossAreaResponse build() {
                GuildBossHandler.EnterGuildBossAreaResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.EnterGuildBossAreaResponse buildPartial() {
                GuildBossHandler.EnterGuildBossAreaResponse result = new GuildBossHandler.EnterGuildBossAreaResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.EnterGuildBossAreaResponse)
                    return mergeFrom((GuildBossHandler.EnterGuildBossAreaResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.EnterGuildBossAreaResponse other) {
                if (other == GuildBossHandler.EnterGuildBossAreaResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.EnterGuildBossAreaResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.EnterGuildBossAreaResponse) GuildBossHandler.EnterGuildBossAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.EnterGuildBossAreaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBossHandler.EnterGuildBossAreaResponse.getDefaultInstance().getS2CMsg();
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
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GuildBossRankInfo
            extends GeneratedMessage
            implements GuildBossRankInfoOrBuilder {
        private static final GuildBossRankInfo defaultInstance = new GuildBossRankInfo(true);
        private final UnknownFieldSet unknownFields;

        private GuildBossRankInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildBossRankInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildBossRankInfo getDefaultInstance() {
            return defaultInstance;
        }

        public GuildBossRankInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildBossRankInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rank_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.id_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.pro_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.name_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.damage_ = input.readInt64();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.level_ = input.readInt32();
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
            return GuildBossHandler.internal_static_pomelo_area_GuildBossRankInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_GuildBossRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossRankInfo.class, Builder.class);
        }

        public static Parser<GuildBossRankInfo> PARSER = (Parser<GuildBossRankInfo>) new AbstractParser<GuildBossRankInfo>() {
            public GuildBossHandler.GuildBossRankInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.GuildBossRankInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RANK_FIELD_NUMBER = 1;
        private int rank_;
        public static final int ID_FIELD_NUMBER = 2;
        private Object id_;
        public static final int PRO_FIELD_NUMBER = 3;
        private int pro_;
        public static final int NAME_FIELD_NUMBER = 4;
        private Object name_;
        public static final int DAMAGE_FIELD_NUMBER = 5;
        private long damage_;
        public static final int LEVEL_FIELD_NUMBER = 6;
        private int level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildBossRankInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasRank() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRank() {
            return this.rank_;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.id_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
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

        public boolean hasPro() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.name_ = s;
            return s;
        }

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasDamage() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public long getDamage() {
            return this.damage_;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getLevel() {
            return this.level_;
        }

        private void initFields() {
            this.rank_ = 0;
            this.id_ = "";
            this.pro_ = 0;
            this.name_ = "";
            this.damage_ = 0L;
            this.level_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasRank()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDamage()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getIdBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.pro_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt64(5, this.damage_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.level_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getIdBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.pro_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt64Size(5, this.damage_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.level_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GuildBossRankInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildBossRankInfo) PARSER.parseFrom(data);
        }

        public static GuildBossRankInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildBossRankInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildBossRankInfo) PARSER.parseFrom(data);
        }

        public static GuildBossRankInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildBossRankInfo parseFrom(InputStream input) throws IOException {
            return (GuildBossRankInfo) PARSER.parseFrom(input);
        }

        public static GuildBossRankInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GuildBossRankInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildBossRankInfo) PARSER.parseDelimitedFrom(input);
        }

        public static GuildBossRankInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossRankInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GuildBossRankInfo parseFrom(CodedInputStream input) throws IOException {
            return (GuildBossRankInfo) PARSER.parseFrom(input);
        }

        public static GuildBossRankInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GuildBossRankInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.GuildBossRankInfoOrBuilder {
            private int bitField0_;
            private int rank_;
            private Object id_;
            private int pro_;
            private Object name_;
            private long damage_;
            private int level_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossRankInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.GuildBossRankInfo.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.GuildBossRankInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rank_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.damage_ = 0L;
                this.bitField0_ &= 0xFFFFFFEF;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossRankInfo_descriptor;
            }

            public GuildBossHandler.GuildBossRankInfo getDefaultInstanceForType() {
                return GuildBossHandler.GuildBossRankInfo.getDefaultInstance();
            }

            public GuildBossHandler.GuildBossRankInfo build() {
                GuildBossHandler.GuildBossRankInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.GuildBossRankInfo buildPartial() {
                GuildBossHandler.GuildBossRankInfo result = new GuildBossHandler.GuildBossRankInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.rank_ = this.rank_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.damage_ = this.damage_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.level_ = this.level_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.GuildBossRankInfo)
                    return mergeFrom((GuildBossHandler.GuildBossRankInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.GuildBossRankInfo other) {
                if (other == GuildBossHandler.GuildBossRankInfo.getDefaultInstance())
                    return this;
                if (other.hasRank())
                    setRank(other.getRank());
                if (other.hasId()) {
                    this.bitField0_ |= 0x2;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasPro())
                    setPro(other.getPro());
                if (other.hasName()) {
                    this.bitField0_ |= 0x8;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasDamage())
                    setDamage(other.getDamage());
                if (other.hasLevel())
                    setLevel(other.getLevel());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRank())
                    return false;
                if (!hasId())
                    return false;
                if (!hasPro())
                    return false;
                if (!hasName())
                    return false;
                if (!hasDamage())
                    return false;
                if (!hasLevel())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.GuildBossRankInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.GuildBossRankInfo) GuildBossHandler.GuildBossRankInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.GuildBossRankInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRank() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRank() {
                return this.rank_;
            }

            public Builder setRank(int value) {
                this.bitField0_ |= 0x1;
                this.rank_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getId() {
                Object ref = this.id_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.id_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.id_ = GuildBossHandler.GuildBossRankInfo.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.id_ = value;
                onChanged();
                return this;
            }

            public boolean hasPro() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getPro() {
                return this.pro_;
            }

            public Builder setPro(int value) {
                this.bitField0_ |= 0x4;
                this.pro_ = value;
                onChanged();
                return this;
            }

            public Builder clearPro() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.pro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.name_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.name_ = GuildBossHandler.GuildBossRankInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasDamage() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public long getDamage() {
                return this.damage_;
            }

            public Builder setDamage(long value) {
                this.bitField0_ |= 0x10;
                this.damage_ = value;
                onChanged();
                return this;
            }

            public Builder clearDamage() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.damage_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x20;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.level_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetGuildBossInfoRequest extends GeneratedMessage implements GetGuildBossInfoRequestOrBuilder {
        private static final GetGuildBossInfoRequest defaultInstance = new GetGuildBossInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildBossInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildBossInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildBossInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildBossInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildBossInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildBossInfoRequest.class, Builder.class);
        }

        public static Parser<GetGuildBossInfoRequest> PARSER = (Parser<GetGuildBossInfoRequest>) new AbstractParser<GetGuildBossInfoRequest>() {
            public GuildBossHandler.GetGuildBossInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.GetGuildBossInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildBossInfoRequest> getParserForType() {
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

        public static GetGuildBossInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGuildBossInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildBossInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGuildBossInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildBossInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGuildBossInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetGuildBossInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetGuildBossInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetGuildBossInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGuildBossInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetGuildBossInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.GetGuildBossInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.GetGuildBossInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.GetGuildBossInfoRequest.alwaysUseFieldBuilders) ;
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
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoRequest_descriptor;
            }

            public GuildBossHandler.GetGuildBossInfoRequest getDefaultInstanceForType() {
                return GuildBossHandler.GetGuildBossInfoRequest.getDefaultInstance();
            }

            public GuildBossHandler.GetGuildBossInfoRequest build() {
                GuildBossHandler.GetGuildBossInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.GetGuildBossInfoRequest buildPartial() {
                GuildBossHandler.GetGuildBossInfoRequest result = new GuildBossHandler.GetGuildBossInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.GetGuildBossInfoRequest)
                    return mergeFrom((GuildBossHandler.GetGuildBossInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.GetGuildBossInfoRequest other) {
                if (other == GuildBossHandler.GetGuildBossInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.GetGuildBossInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.GetGuildBossInfoRequest) GuildBossHandler.GetGuildBossInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.GetGuildBossInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetGuildBossInfoResponse
            extends GeneratedMessage
            implements GetGuildBossInfoResponseOrBuilder {
        private static final GetGuildBossInfoResponse defaultInstance = new GetGuildBossInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildBossInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildBossInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildBossInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildBossInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildBossInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.killed_ = input.readBool();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.rankList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.rankList_.add(input.readMessage(GuildBossHandler.GuildBossRankInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.rankList_ = Collections.unmodifiableList(this.rankList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildBossInfoResponse.class, Builder.class);
        }

        public static Parser<GetGuildBossInfoResponse> PARSER = (Parser<GetGuildBossInfoResponse>) new AbstractParser<GetGuildBossInfoResponse>() {
            public GuildBossHandler.GetGuildBossInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.GetGuildBossInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int KILLED_FIELD_NUMBER = 3;
        private boolean killed_;
        public static final int RANKLIST_FIELD_NUMBER = 4;
        private List<GuildBossHandler.GuildBossRankInfo> rankList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildBossInfoResponse> getParserForType() {
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

        public boolean hasKilled() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public boolean getKilled() {
            return this.killed_;
        }

        public List<GuildBossHandler.GuildBossRankInfo> getRankListList() {
            return this.rankList_;
        }

        public List<? extends GuildBossHandler.GuildBossRankInfoOrBuilder> getRankListOrBuilderList() {
            return (List) this.rankList_;
        }

        public int getRankListCount() {
            return this.rankList_.size();
        }

        public GuildBossHandler.GuildBossRankInfo getRankList(int index) {
            return this.rankList_.get(index);
        }

        public GuildBossHandler.GuildBossRankInfoOrBuilder getRankListOrBuilder(int index) {
            return this.rankList_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.killed_ = false;
            this.rankList_ = Collections.emptyList();
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
            for (int i = 0; i < getRankListCount(); i++) {
                if (!getRankList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
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
                output.writeBool(3, this.killed_);
            for (int i = 0; i < this.rankList_.size(); i++)
                output.writeMessage(4, (MessageLite) this.rankList_.get(i));
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
                size += CodedOutputStream.computeBoolSize(3, this.killed_);
            for (int i = 0; i < this.rankList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.rankList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetGuildBossInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(data);
        }

        public static GetGuildBossInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildBossInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(data);
        }

        public static GetGuildBossInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildBossInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(input);
        }

        public static GetGuildBossInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetGuildBossInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetGuildBossInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetGuildBossInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(input);
        }

        public static GetGuildBossInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildBossInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetGuildBossInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.GetGuildBossInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private boolean killed_;
            private List<GuildBossHandler.GuildBossRankInfo> rankList_;
            private RepeatedFieldBuilder<GuildBossHandler.GuildBossRankInfo, GuildBossHandler.GuildBossRankInfo.Builder, GuildBossHandler.GuildBossRankInfoOrBuilder> rankListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.GetGuildBossInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.rankList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.rankList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.GetGuildBossInfoResponse.alwaysUseFieldBuilders)
                    getRankListFieldBuilder();
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
                this.killed_ = false;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.rankListBuilder_ == null) {
                    this.rankList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.rankListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_GetGuildBossInfoResponse_descriptor;
            }

            public GuildBossHandler.GetGuildBossInfoResponse getDefaultInstanceForType() {
                return GuildBossHandler.GetGuildBossInfoResponse.getDefaultInstance();
            }

            public GuildBossHandler.GetGuildBossInfoResponse build() {
                GuildBossHandler.GetGuildBossInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.GetGuildBossInfoResponse buildPartial() {
                GuildBossHandler.GetGuildBossInfoResponse result = new GuildBossHandler.GetGuildBossInfoResponse(this);
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
                result.killed_ = this.killed_;
                if (this.rankListBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.rankList_ = Collections.unmodifiableList(this.rankList_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.rankList_ = this.rankList_;
                } else {
                    result.rankList_ = this.rankListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.GetGuildBossInfoResponse)
                    return mergeFrom((GuildBossHandler.GetGuildBossInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.GetGuildBossInfoResponse other) {
                if (other == GuildBossHandler.GetGuildBossInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasKilled())
                    setKilled(other.getKilled());
                if (this.rankListBuilder_ == null) {
                    if (!other.rankList_.isEmpty()) {
                        if (this.rankList_.isEmpty()) {
                            this.rankList_ = other.rankList_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureRankListIsMutable();
                            this.rankList_.addAll(other.rankList_);
                        }
                        onChanged();
                    }
                } else if (!other.rankList_.isEmpty()) {
                    if (this.rankListBuilder_.isEmpty()) {
                        this.rankListBuilder_.dispose();
                        this.rankListBuilder_ = null;
                        this.rankList_ = other.rankList_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.rankListBuilder_ = GuildBossHandler.GetGuildBossInfoResponse.alwaysUseFieldBuilders ? getRankListFieldBuilder() : null;
                    } else {
                        this.rankListBuilder_.addAllMessages(other.rankList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getRankListCount(); i++) {
                    if (!getRankList(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.GetGuildBossInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.GetGuildBossInfoResponse) GuildBossHandler.GetGuildBossInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.GetGuildBossInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBossHandler.GetGuildBossInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasKilled() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public boolean getKilled() {
                return this.killed_;
            }

            public Builder setKilled(boolean value) {
                this.bitField0_ |= 0x4;
                this.killed_ = value;
                onChanged();
                return this;
            }

            public Builder clearKilled() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.killed_ = false;
                onChanged();
                return this;
            }

            private void ensureRankListIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.rankList_ = new ArrayList<>(this.rankList_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<GuildBossHandler.GuildBossRankInfo> getRankListList() {
                if (this.rankListBuilder_ == null)
                    return Collections.unmodifiableList(this.rankList_);
                return this.rankListBuilder_.getMessageList();
            }

            public int getRankListCount() {
                if (this.rankListBuilder_ == null)
                    return this.rankList_.size();
                return this.rankListBuilder_.getCount();
            }

            public GuildBossHandler.GuildBossRankInfo getRankList(int index) {
                if (this.rankListBuilder_ == null)
                    return this.rankList_.get(index);
                return (GuildBossHandler.GuildBossRankInfo) this.rankListBuilder_.getMessage(index);
            }

            public Builder setRankList(int index, GuildBossHandler.GuildBossRankInfo value) {
                if (this.rankListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRankListIsMutable();
                    this.rankList_.set(index, value);
                    onChanged();
                } else {
                    this.rankListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setRankList(int index, GuildBossHandler.GuildBossRankInfo.Builder builderForValue) {
                if (this.rankListBuilder_ == null) {
                    ensureRankListIsMutable();
                    this.rankList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rankListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRankList(GuildBossHandler.GuildBossRankInfo value) {
                if (this.rankListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRankListIsMutable();
                    this.rankList_.add(value);
                    onChanged();
                } else {
                    this.rankListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addRankList(int index, GuildBossHandler.GuildBossRankInfo value) {
                if (this.rankListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRankListIsMutable();
                    this.rankList_.add(index, value);
                    onChanged();
                } else {
                    this.rankListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addRankList(GuildBossHandler.GuildBossRankInfo.Builder builderForValue) {
                if (this.rankListBuilder_ == null) {
                    ensureRankListIsMutable();
                    this.rankList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rankListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRankList(int index, GuildBossHandler.GuildBossRankInfo.Builder builderForValue) {
                if (this.rankListBuilder_ == null) {
                    ensureRankListIsMutable();
                    this.rankList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rankListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRankList(Iterable<? extends GuildBossHandler.GuildBossRankInfo> values) {
                if (this.rankListBuilder_ == null) {
                    ensureRankListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.rankList_);
                    onChanged();
                } else {
                    this.rankListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRankList() {
                if (this.rankListBuilder_ == null) {
                    this.rankList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.rankListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRankList(int index) {
                if (this.rankListBuilder_ == null) {
                    ensureRankListIsMutable();
                    this.rankList_.remove(index);
                    onChanged();
                } else {
                    this.rankListBuilder_.remove(index);
                }
                return this;
            }

            public GuildBossHandler.GuildBossRankInfo.Builder getRankListBuilder(int index) {
                return (GuildBossHandler.GuildBossRankInfo.Builder) getRankListFieldBuilder().getBuilder(index);
            }

            public GuildBossHandler.GuildBossRankInfoOrBuilder getRankListOrBuilder(int index) {
                if (this.rankListBuilder_ == null)
                    return this.rankList_.get(index);
                return (GuildBossHandler.GuildBossRankInfoOrBuilder) this.rankListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildBossHandler.GuildBossRankInfoOrBuilder> getRankListOrBuilderList() {
                if (this.rankListBuilder_ != null)
                    return this.rankListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.rankList_);
            }

            public GuildBossHandler.GuildBossRankInfo.Builder addRankListBuilder() {
                return (GuildBossHandler.GuildBossRankInfo.Builder) getRankListFieldBuilder().addBuilder(GuildBossHandler.GuildBossRankInfo.getDefaultInstance());
            }

            public GuildBossHandler.GuildBossRankInfo.Builder addRankListBuilder(int index) {
                return (GuildBossHandler.GuildBossRankInfo.Builder) getRankListFieldBuilder().addBuilder(index, GuildBossHandler.GuildBossRankInfo.getDefaultInstance());
            }

            public List<GuildBossHandler.GuildBossRankInfo.Builder> getRankListBuilderList() {
                return getRankListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildBossHandler.GuildBossRankInfo, GuildBossHandler.GuildBossRankInfo.Builder, GuildBossHandler.GuildBossRankInfoOrBuilder> getRankListFieldBuilder() {
                if (this.rankListBuilder_ == null) {
                    this.rankListBuilder_ = new RepeatedFieldBuilder(this.rankList_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.rankList_ = null;
                }
                return this.rankListBuilder_;
            }
        }
    }

    public static final class GuildBossInspireRequest extends GeneratedMessage implements GuildBossInspireRequestOrBuilder {
        private static final GuildBossInspireRequest defaultInstance = new GuildBossInspireRequest(true);
        private final UnknownFieldSet unknownFields;

        private GuildBossInspireRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildBossInspireRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildBossInspireRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GuildBossInspireRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildBossInspireRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SIndex_ = input.readInt32();
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
            return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossInspireRequest.class, Builder.class);
        }

        public static Parser<GuildBossInspireRequest> PARSER = (Parser<GuildBossInspireRequest>) new AbstractParser<GuildBossInspireRequest>() {
            public GuildBossHandler.GuildBossInspireRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.GuildBossInspireRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_INDEX_FIELD_NUMBER = 1;
        private int c2SIndex_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildBossInspireRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SIndex() {
            return this.c2SIndex_;
        }

        private void initFields() {
            this.c2SIndex_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SIndex_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SIndex_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GuildBossInspireRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildBossInspireRequest) PARSER.parseFrom(data);
        }

        public static GuildBossInspireRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossInspireRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildBossInspireRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildBossInspireRequest) PARSER.parseFrom(data);
        }

        public static GuildBossInspireRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossInspireRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildBossInspireRequest parseFrom(InputStream input) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseFrom(input);
        }

        public static GuildBossInspireRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GuildBossInspireRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GuildBossInspireRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GuildBossInspireRequest parseFrom(CodedInputStream input) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseFrom(input);
        }

        public static GuildBossInspireRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GuildBossInspireRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.GuildBossInspireRequestOrBuilder {
            private int bitField0_;
            private int c2SIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.GuildBossInspireRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.GuildBossInspireRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireRequest_descriptor;
            }

            public GuildBossHandler.GuildBossInspireRequest getDefaultInstanceForType() {
                return GuildBossHandler.GuildBossInspireRequest.getDefaultInstance();
            }

            public GuildBossHandler.GuildBossInspireRequest build() {
                GuildBossHandler.GuildBossInspireRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.GuildBossInspireRequest buildPartial() {
                GuildBossHandler.GuildBossInspireRequest result = new GuildBossHandler.GuildBossInspireRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SIndex_ = this.c2SIndex_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.GuildBossInspireRequest)
                    return mergeFrom((GuildBossHandler.GuildBossInspireRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.GuildBossInspireRequest other) {
                if (other == GuildBossHandler.GuildBossInspireRequest.getDefaultInstance()) return this;
                if (other.hasC2SIndex()) setC2SIndex(other.getC2SIndex());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SIndex()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.GuildBossInspireRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.GuildBossInspireRequest) GuildBossHandler.GuildBossInspireRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.GuildBossInspireRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SIndex() {
                return this.c2SIndex_;
            }

            public Builder setC2SIndex(int value) {
                this.bitField0_ |= 0x1;
                this.c2SIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SIndex_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class GuildBossInspireResponse
            extends GeneratedMessage
            implements GuildBossInspireResponseOrBuilder {
        private static final GuildBossInspireResponse defaultInstance = new GuildBossInspireResponse(true);
        private final UnknownFieldSet unknownFields;

        private GuildBossInspireResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildBossInspireResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildBossInspireResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GuildBossInspireResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildBossInspireResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossInspireResponse.class, Builder.class);
        }

        public static Parser<GuildBossInspireResponse> PARSER = (Parser<GuildBossInspireResponse>) new AbstractParser<GuildBossInspireResponse>() {
            public GuildBossHandler.GuildBossInspireResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.GuildBossInspireResponse(input, extensionRegistry);
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

        public Parser<GuildBossInspireResponse> getParserForType() {
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


        public static GuildBossInspireResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildBossInspireResponse) PARSER.parseFrom(data);
        }


        public static GuildBossInspireResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossInspireResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildBossInspireResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildBossInspireResponse) PARSER.parseFrom(data);
        }


        public static GuildBossInspireResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBossInspireResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildBossInspireResponse parseFrom(InputStream input) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseFrom(input);
        }


        public static GuildBossInspireResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildBossInspireResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GuildBossInspireResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildBossInspireResponse parseFrom(CodedInputStream input) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseFrom(input);
        }


        public static GuildBossInspireResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBossInspireResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildBossInspireResponse prototype) {
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
                implements GuildBossHandler.GuildBossInspireResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.GuildBossInspireResponse.class, Builder.class);
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
                if (GuildBossHandler.GuildBossInspireResponse.alwaysUseFieldBuilders) ;
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
                return GuildBossHandler.internal_static_pomelo_area_GuildBossInspireResponse_descriptor;
            }


            public GuildBossHandler.GuildBossInspireResponse getDefaultInstanceForType() {
                return GuildBossHandler.GuildBossInspireResponse.getDefaultInstance();
            }


            public GuildBossHandler.GuildBossInspireResponse build() {
                GuildBossHandler.GuildBossInspireResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBossHandler.GuildBossInspireResponse buildPartial() {
                GuildBossHandler.GuildBossInspireResponse result = new GuildBossHandler.GuildBossInspireResponse(this);
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
                if (other instanceof GuildBossHandler.GuildBossInspireResponse) {
                    return mergeFrom((GuildBossHandler.GuildBossInspireResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBossHandler.GuildBossInspireResponse other) {
                if (other == GuildBossHandler.GuildBossInspireResponse.getDefaultInstance()) {
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
                GuildBossHandler.GuildBossInspireResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.GuildBossInspireResponse) GuildBossHandler.GuildBossInspireResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.GuildBossInspireResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildBossHandler.GuildBossInspireResponse.getDefaultInstance().getS2CMsg();
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


    public static final class HurtRankInfo
            extends GeneratedMessage
            implements HurtRankInfoOrBuilder {
        private static final HurtRankInfo defaultInstance = new HurtRankInfo(true);
        private final UnknownFieldSet unknownFields;

        private HurtRankInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HurtRankInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HurtRankInfo getDefaultInstance() {
            return defaultInstance;
        }

        public HurtRankInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HurtRankInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rank_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.id_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.name_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.hurt_ = input.readInt64();
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
            return GuildBossHandler.internal_static_pomelo_area_HurtRankInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_HurtRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HurtRankInfo.class, Builder.class);
        }

        public static Parser<HurtRankInfo> PARSER = (Parser<HurtRankInfo>) new AbstractParser<HurtRankInfo>() {
            public GuildBossHandler.HurtRankInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.HurtRankInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RANK_FIELD_NUMBER = 1;
        private int rank_;
        public static final int ID_FIELD_NUMBER = 2;
        private Object id_;
        public static final int NAME_FIELD_NUMBER = 3;
        private Object name_;
        public static final int HURT_FIELD_NUMBER = 4;
        private long hurt_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HurtRankInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasRank() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRank() {
            return this.rank_;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.id_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
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


        public boolean hasName() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.name_ = s;
            }
            return s;
        }


        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasHurt() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public long getHurt() {
            return this.hurt_;
        }


        private void initFields() {
            this.rank_ = 0;
            this.id_ = "";
            this.name_ = "";
            this.hurt_ = 0L;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasRank()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHurt()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.rank_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt64(4, this.hurt_);
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
                size += CodedOutputStream.computeInt32Size(1, this.rank_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt64Size(4, this.hurt_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static HurtRankInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HurtRankInfo) PARSER.parseFrom(data);
        }


        public static HurtRankInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HurtRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HurtRankInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HurtRankInfo) PARSER.parseFrom(data);
        }


        public static HurtRankInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HurtRankInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static HurtRankInfo parseFrom(InputStream input) throws IOException {
            return (HurtRankInfo) PARSER.parseFrom(input);
        }


        public static HurtRankInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HurtRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static HurtRankInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HurtRankInfo) PARSER.parseDelimitedFrom(input);
        }


        public static HurtRankInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HurtRankInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static HurtRankInfo parseFrom(CodedInputStream input) throws IOException {
            return (HurtRankInfo) PARSER.parseFrom(input);
        }


        public static HurtRankInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HurtRankInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(HurtRankInfo prototype) {
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
                implements GuildBossHandler.HurtRankInfoOrBuilder {
            private int bitField0_;


            private int rank_;


            private Object id_;


            private Object name_;


            private long hurt_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_HurtRankInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_HurtRankInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.HurtRankInfo.class, Builder.class);
            }


            private Builder() {
                this.id_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.HurtRankInfo.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.rank_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.hurt_ = 0L;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_HurtRankInfo_descriptor;
            }


            public GuildBossHandler.HurtRankInfo getDefaultInstanceForType() {
                return GuildBossHandler.HurtRankInfo.getDefaultInstance();
            }


            public GuildBossHandler.HurtRankInfo build() {
                GuildBossHandler.HurtRankInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBossHandler.HurtRankInfo buildPartial() {
                GuildBossHandler.HurtRankInfo result = new GuildBossHandler.HurtRankInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.rank_ = this.rank_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.hurt_ = this.hurt_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.HurtRankInfo) {
                    return mergeFrom((GuildBossHandler.HurtRankInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBossHandler.HurtRankInfo other) {
                if (other == GuildBossHandler.HurtRankInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRank()) {
                    setRank(other.getRank());
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x2;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x4;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasHurt()) {
                    setHurt(other.getHurt());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasRank()) {
                    return false;
                }
                if (!hasId()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasHurt()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.HurtRankInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.HurtRankInfo) GuildBossHandler.HurtRankInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.HurtRankInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasRank() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getRank() {
                return this.rank_;
            }


            public Builder setRank(int value) {
                this.bitField0_ |= 0x1;
                this.rank_ = value;
                onChanged();
                return this;
            }


            public Builder clearRank() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rank_ = 0;
                onChanged();
                return this;
            }


            public boolean hasId() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.id_ = GuildBossHandler.HurtRankInfo.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.id_ = value;
                onChanged();
                return this;
            }


            public boolean hasName() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.name_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }


            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = GuildBossHandler.HurtRankInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }


            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }


            public boolean hasHurt() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public long getHurt() {
                return this.hurt_;
            }


            public Builder setHurt(long value) {
                this.bitField0_ |= 0x8;
                this.hurt_ = value;
                onChanged();
                return this;
            }


            public Builder clearHurt() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.hurt_ = 0L;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnHurtRankChangePush
            extends GeneratedMessage
            implements OnHurtRankChangePushOrBuilder {
        private static final OnHurtRankChangePush defaultInstance = new OnHurtRankChangePush(true);
        private final UnknownFieldSet unknownFields;

        private OnHurtRankChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnHurtRankChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnHurtRankChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public OnHurtRankChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnHurtRankChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    GuildBossHandler.HurtRankInfo.Builder subBuilder;
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
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.otherInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.otherInfo_.add(input.readMessage(GuildBossHandler.HurtRankInfo.PARSER, extensionRegistry));
                            break;
                        case 26:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.myInfo_.toBuilder();
                            this.myInfo_ = (GuildBossHandler.HurtRankInfo) input.readMessage(GuildBossHandler.HurtRankInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.myInfo_);
                                this.myInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.otherGuildInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.otherGuildInfo_.add(input.readMessage(GuildBossHandler.HurtRankInfo.PARSER, extensionRegistry));
                            break;
                        case 42:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.myGuildInfo_.toBuilder();
                            this.myGuildInfo_ = (GuildBossHandler.HurtRankInfo) input.readMessage(GuildBossHandler.HurtRankInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.myGuildInfo_);
                                this.myGuildInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 48:
                            this.bitField0_ |= 0x8;
                            this.joinCount_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.otherInfo_ = Collections.unmodifiableList(this.otherInfo_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.otherGuildInfo_ = Collections.unmodifiableList(this.otherGuildInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildBossHandler.internal_static_pomelo_area_OnHurtRankChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_OnHurtRankChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnHurtRankChangePush.class, Builder.class);
        }

        public static Parser<OnHurtRankChangePush> PARSER = (Parser<OnHurtRankChangePush>) new AbstractParser<OnHurtRankChangePush>() {
            public GuildBossHandler.OnHurtRankChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.OnHurtRankChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int OTHERINFO_FIELD_NUMBER = 2;
        private List<GuildBossHandler.HurtRankInfo> otherInfo_;
        public static final int MYINFO_FIELD_NUMBER = 3;
        private GuildBossHandler.HurtRankInfo myInfo_;
        public static final int OTHERGUILDINFO_FIELD_NUMBER = 4;
        private List<GuildBossHandler.HurtRankInfo> otherGuildInfo_;
        public static final int MYGUILDINFO_FIELD_NUMBER = 5;
        private GuildBossHandler.HurtRankInfo myGuildInfo_;
        public static final int JOIN_COUNT_FIELD_NUMBER = 6;
        private int joinCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnHurtRankChangePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<GuildBossHandler.HurtRankInfo> getOtherInfoList() {
            return this.otherInfo_;
        }

        public List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherInfoOrBuilderList() {
            return (List) this.otherInfo_;
        }

        public int getOtherInfoCount() {
            return this.otherInfo_.size();
        }

        public GuildBossHandler.HurtRankInfo getOtherInfo(int index) {
            return this.otherInfo_.get(index);
        }

        public GuildBossHandler.HurtRankInfoOrBuilder getOtherInfoOrBuilder(int index) {
            return this.otherInfo_.get(index);
        }

        public boolean hasMyInfo() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public GuildBossHandler.HurtRankInfo getMyInfo() {
            return this.myInfo_;
        }

        public GuildBossHandler.HurtRankInfoOrBuilder getMyInfoOrBuilder() {
            return this.myInfo_;
        }

        public List<GuildBossHandler.HurtRankInfo> getOtherGuildInfoList() {
            return this.otherGuildInfo_;
        }

        public List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherGuildInfoOrBuilderList() {
            return (List) this.otherGuildInfo_;
        }

        public int getOtherGuildInfoCount() {
            return this.otherGuildInfo_.size();
        }

        public GuildBossHandler.HurtRankInfo getOtherGuildInfo(int index) {
            return this.otherGuildInfo_.get(index);
        }

        public GuildBossHandler.HurtRankInfoOrBuilder getOtherGuildInfoOrBuilder(int index) {
            return this.otherGuildInfo_.get(index);
        }

        public boolean hasMyGuildInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public GuildBossHandler.HurtRankInfo getMyGuildInfo() {
            return this.myGuildInfo_;
        }

        public GuildBossHandler.HurtRankInfoOrBuilder getMyGuildInfoOrBuilder() {
            return this.myGuildInfo_;
        }

        public boolean hasJoinCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getJoinCount() {
            return this.joinCount_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.otherInfo_ = Collections.emptyList();
            this.myInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
            this.otherGuildInfo_ = Collections.emptyList();
            this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
            this.joinCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasJoinCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getOtherInfoCount(); i++) {
                if (!getOtherInfo(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasMyInfo() && !getMyInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < getOtherGuildInfoCount(); i++) {
                if (!getOtherGuildInfo(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasMyGuildInfo() && !getMyGuildInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            int i;
            for (i = 0; i < this.otherInfo_.size(); i++) output.writeMessage(2, (MessageLite) this.otherInfo_.get(i));
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(3, (MessageLite) this.myInfo_);
            for (i = 0; i < this.otherGuildInfo_.size(); i++)
                output.writeMessage(4, (MessageLite) this.otherGuildInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(5, (MessageLite) this.myGuildInfo_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(6, this.joinCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            int i;
            for (i = 0; i < this.otherInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.otherInfo_.get(i));
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.myInfo_);
            for (i = 0; i < this.otherGuildInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.otherGuildInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.myGuildInfo_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(6, this.joinCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnHurtRankChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnHurtRankChangePush) PARSER.parseFrom(data);
        }

        public static OnHurtRankChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnHurtRankChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnHurtRankChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnHurtRankChangePush) PARSER.parseFrom(data);
        }

        public static OnHurtRankChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnHurtRankChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnHurtRankChangePush parseFrom(InputStream input) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseFrom(input);
        }

        public static OnHurtRankChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnHurtRankChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseDelimitedFrom(input);
        }

        public static OnHurtRankChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnHurtRankChangePush parseFrom(CodedInputStream input) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseFrom(input);
        }

        public static OnHurtRankChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnHurtRankChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnHurtRankChangePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        static {
            defaultInstance.initFields();
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.OnHurtRankChangePushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<GuildBossHandler.HurtRankInfo> otherInfo_;
            private RepeatedFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> otherInfoBuilder_;
            private GuildBossHandler.HurtRankInfo myInfo_;
            private SingleFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> myInfoBuilder_;
            private List<GuildBossHandler.HurtRankInfo> otherGuildInfo_;
            private RepeatedFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> otherGuildInfoBuilder_;
            private GuildBossHandler.HurtRankInfo myGuildInfo_;
            private SingleFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> myGuildInfoBuilder_;
            private int joinCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_OnHurtRankChangePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_OnHurtRankChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.OnHurtRankChangePush.class, Builder.class);
            }

            private Builder() {
                this.otherInfo_ = Collections.emptyList();
                this.myInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                this.otherGuildInfo_ = Collections.emptyList();
                this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.otherInfo_ = Collections.emptyList();
                this.myInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                this.otherGuildInfo_ = Collections.emptyList();
                this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.OnHurtRankChangePush.alwaysUseFieldBuilders) {
                    getOtherInfoFieldBuilder();
                    getMyInfoFieldBuilder();
                    getOtherGuildInfoFieldBuilder();
                    getMyGuildInfoFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.otherInfoBuilder_ == null) {
                    this.otherInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.otherInfoBuilder_.clear();
                }
                if (this.myInfoBuilder_ == null) {
                    this.myInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                } else {
                    this.myInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.otherGuildInfoBuilder_ == null) {
                    this.otherGuildInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.otherGuildInfoBuilder_.clear();
                }
                if (this.myGuildInfoBuilder_ == null) {
                    this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                } else {
                    this.myGuildInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                this.joinCount_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_OnHurtRankChangePush_descriptor;
            }

            public GuildBossHandler.OnHurtRankChangePush getDefaultInstanceForType() {
                return GuildBossHandler.OnHurtRankChangePush.getDefaultInstance();
            }

            public GuildBossHandler.OnHurtRankChangePush build() {
                GuildBossHandler.OnHurtRankChangePush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.OnHurtRankChangePush buildPartial() {
                GuildBossHandler.OnHurtRankChangePush result = new GuildBossHandler.OnHurtRankChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.otherInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.otherInfo_ = Collections.unmodifiableList(this.otherInfo_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.otherInfo_ = this.otherInfo_;
                } else {
                    result.otherInfo_ = this.otherInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x2;
                if (this.myInfoBuilder_ == null) {
                    result.myInfo_ = this.myInfo_;
                } else {
                    result.myInfo_ = (GuildBossHandler.HurtRankInfo) this.myInfoBuilder_.build();
                }
                if (this.otherGuildInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.otherGuildInfo_ = Collections.unmodifiableList(this.otherGuildInfo_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.otherGuildInfo_ = this.otherGuildInfo_;
                } else {
                    result.otherGuildInfo_ = this.otherGuildInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x4;
                if (this.myGuildInfoBuilder_ == null) {
                    result.myGuildInfo_ = this.myGuildInfo_;
                } else {
                    result.myGuildInfo_ = (GuildBossHandler.HurtRankInfo) this.myGuildInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x8;
                result.joinCount_ = this.joinCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.OnHurtRankChangePush)
                    return mergeFrom((GuildBossHandler.OnHurtRankChangePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.OnHurtRankChangePush other) {
                if (other == GuildBossHandler.OnHurtRankChangePush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (this.otherInfoBuilder_ == null) {
                    if (!other.otherInfo_.isEmpty()) {
                        if (this.otherInfo_.isEmpty()) {
                            this.otherInfo_ = other.otherInfo_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureOtherInfoIsMutable();
                            this.otherInfo_.addAll(other.otherInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.otherInfo_.isEmpty()) {
                    if (this.otherInfoBuilder_.isEmpty()) {
                        this.otherInfoBuilder_.dispose();
                        this.otherInfoBuilder_ = null;
                        this.otherInfo_ = other.otherInfo_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.otherInfoBuilder_ = GuildBossHandler.OnHurtRankChangePush.alwaysUseFieldBuilders ? getOtherInfoFieldBuilder() : null;
                    } else {
                        this.otherInfoBuilder_.addAllMessages(other.otherInfo_);
                    }
                }
                if (other.hasMyInfo())
                    mergeMyInfo(other.getMyInfo());
                if (this.otherGuildInfoBuilder_ == null) {
                    if (!other.otherGuildInfo_.isEmpty()) {
                        if (this.otherGuildInfo_.isEmpty()) {
                            this.otherGuildInfo_ = other.otherGuildInfo_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureOtherGuildInfoIsMutable();
                            this.otherGuildInfo_.addAll(other.otherGuildInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.otherGuildInfo_.isEmpty()) {
                    if (this.otherGuildInfoBuilder_.isEmpty()) {
                        this.otherGuildInfoBuilder_.dispose();
                        this.otherGuildInfoBuilder_ = null;
                        this.otherGuildInfo_ = other.otherGuildInfo_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.otherGuildInfoBuilder_ = GuildBossHandler.OnHurtRankChangePush.alwaysUseFieldBuilders ? getOtherGuildInfoFieldBuilder() : null;
                    } else {
                        this.otherGuildInfoBuilder_.addAllMessages(other.otherGuildInfo_);
                    }
                }
                if (other.hasMyGuildInfo())
                    mergeMyGuildInfo(other.getMyGuildInfo());
                if (other.hasJoinCount())
                    setJoinCount(other.getJoinCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasJoinCount())
                    return false;
                int i;
                for (i = 0; i < getOtherInfoCount(); i++) {
                    if (!getOtherInfo(i).isInitialized())
                        return false;
                }
                if (hasMyInfo() && !getMyInfo().isInitialized())
                    return false;
                for (i = 0; i < getOtherGuildInfoCount(); i++) {
                    if (!getOtherGuildInfo(i).isInitialized())
                        return false;
                }
                if (hasMyGuildInfo() && !getMyGuildInfo().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.OnHurtRankChangePush parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.OnHurtRankChangePush) GuildBossHandler.OnHurtRankChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.OnHurtRankChangePush) e.getUnfinishedMessage();
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

            private void ensureOtherInfoIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.otherInfo_ = new ArrayList<>(this.otherInfo_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<GuildBossHandler.HurtRankInfo> getOtherInfoList() {
                if (this.otherInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.otherInfo_);
                return this.otherInfoBuilder_.getMessageList();
            }

            public int getOtherInfoCount() {
                if (this.otherInfoBuilder_ == null)
                    return this.otherInfo_.size();
                return this.otherInfoBuilder_.getCount();
            }

            public GuildBossHandler.HurtRankInfo getOtherInfo(int index) {
                if (this.otherInfoBuilder_ == null)
                    return this.otherInfo_.get(index);
                return (GuildBossHandler.HurtRankInfo) this.otherInfoBuilder_.getMessage(index);
            }

            public Builder setOtherInfo(int index, GuildBossHandler.HurtRankInfo value) {
                if (this.otherInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.set(index, value);
                    onChanged();
                } else {
                    this.otherInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setOtherInfo(int index, GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherInfoBuilder_ == null) {
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.otherInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOtherInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.otherInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.add(value);
                    onChanged();
                } else {
                    this.otherInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addOtherInfo(int index, GuildBossHandler.HurtRankInfo value) {
                if (this.otherInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.add(index, value);
                    onChanged();
                } else {
                    this.otherInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addOtherInfo(GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherInfoBuilder_ == null) {
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.otherInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOtherInfo(int index, GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherInfoBuilder_ == null) {
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.otherInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOtherInfo(Iterable<? extends GuildBossHandler.HurtRankInfo> values) {
                if (this.otherInfoBuilder_ == null) {
                    ensureOtherInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.otherInfo_);
                    onChanged();
                } else {
                    this.otherInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOtherInfo() {
                if (this.otherInfoBuilder_ == null) {
                    this.otherInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.otherInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeOtherInfo(int index) {
                if (this.otherInfoBuilder_ == null) {
                    ensureOtherInfoIsMutable();
                    this.otherInfo_.remove(index);
                    onChanged();
                } else {
                    this.otherInfoBuilder_.remove(index);
                }
                return this;
            }

            public GuildBossHandler.HurtRankInfo.Builder getOtherInfoBuilder(int index) {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherInfoFieldBuilder().getBuilder(index);
            }

            public GuildBossHandler.HurtRankInfoOrBuilder getOtherInfoOrBuilder(int index) {
                if (this.otherInfoBuilder_ == null)
                    return this.otherInfo_.get(index);
                return (GuildBossHandler.HurtRankInfoOrBuilder) this.otherInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherInfoOrBuilderList() {
                if (this.otherInfoBuilder_ != null)
                    return this.otherInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.otherInfo_);
            }

            public GuildBossHandler.HurtRankInfo.Builder addOtherInfoBuilder() {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherInfoFieldBuilder().addBuilder(GuildBossHandler.HurtRankInfo.getDefaultInstance());
            }

            public GuildBossHandler.HurtRankInfo.Builder addOtherInfoBuilder(int index) {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherInfoFieldBuilder().addBuilder(index, GuildBossHandler.HurtRankInfo.getDefaultInstance());
            }

            public List<GuildBossHandler.HurtRankInfo.Builder> getOtherInfoBuilderList() {
                return getOtherInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> getOtherInfoFieldBuilder() {
                if (this.otherInfoBuilder_ == null) {
                    this.otherInfoBuilder_ = new RepeatedFieldBuilder(this.otherInfo_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.otherInfo_ = null;
                }
                return this.otherInfoBuilder_;
            }

            public boolean hasMyInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public GuildBossHandler.HurtRankInfo getMyInfo() {
                if (this.myInfoBuilder_ == null)
                    return this.myInfo_;
                return (GuildBossHandler.HurtRankInfo) this.myInfoBuilder_.getMessage();
            }

            public Builder setMyInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.myInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.myInfo_ = value;
                    onChanged();
                } else {
                    this.myInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setMyInfo(GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.myInfoBuilder_ == null) {
                    this.myInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.myInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeMyInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.myInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.myInfo_ != GuildBossHandler.HurtRankInfo.getDefaultInstance()) {
                        this.myInfo_ = GuildBossHandler.HurtRankInfo.newBuilder(this.myInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.myInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.myInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearMyInfo() {
                if (this.myInfoBuilder_ == null) {
                    this.myInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.myInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public GuildBossHandler.HurtRankInfo.Builder getMyInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildBossHandler.HurtRankInfo.Builder) getMyInfoFieldBuilder().getBuilder();
            }

            public GuildBossHandler.HurtRankInfoOrBuilder getMyInfoOrBuilder() {
                if (this.myInfoBuilder_ != null)
                    return (GuildBossHandler.HurtRankInfoOrBuilder) this.myInfoBuilder_.getMessageOrBuilder();
                return this.myInfo_;
            }

            private SingleFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> getMyInfoFieldBuilder() {
                if (this.myInfoBuilder_ == null) {
                    this.myInfoBuilder_ = new SingleFieldBuilder(getMyInfo(), getParentForChildren(), isClean());
                    this.myInfo_ = null;
                }
                return this.myInfoBuilder_;
            }

            private void ensureOtherGuildInfoIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.otherGuildInfo_ = new ArrayList<>(this.otherGuildInfo_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<GuildBossHandler.HurtRankInfo> getOtherGuildInfoList() {
                if (this.otherGuildInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.otherGuildInfo_);
                return this.otherGuildInfoBuilder_.getMessageList();
            }

            public int getOtherGuildInfoCount() {
                if (this.otherGuildInfoBuilder_ == null)
                    return this.otherGuildInfo_.size();
                return this.otherGuildInfoBuilder_.getCount();
            }

            public GuildBossHandler.HurtRankInfo getOtherGuildInfo(int index) {
                if (this.otherGuildInfoBuilder_ == null)
                    return this.otherGuildInfo_.get(index);
                return (GuildBossHandler.HurtRankInfo) this.otherGuildInfoBuilder_.getMessage(index);
            }

            public Builder setOtherGuildInfo(int index, GuildBossHandler.HurtRankInfo value) {
                if (this.otherGuildInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.set(index, value);
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setOtherGuildInfo(int index, GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherGuildInfoBuilder_ == null) {
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOtherGuildInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.otherGuildInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.add(value);
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addOtherGuildInfo(int index, GuildBossHandler.HurtRankInfo value) {
                if (this.otherGuildInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.add(index, value);
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addOtherGuildInfo(GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherGuildInfoBuilder_ == null) {
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOtherGuildInfo(int index, GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.otherGuildInfoBuilder_ == null) {
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOtherGuildInfo(Iterable<? extends GuildBossHandler.HurtRankInfo> values) {
                if (this.otherGuildInfoBuilder_ == null) {
                    ensureOtherGuildInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.otherGuildInfo_);
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOtherGuildInfo() {
                if (this.otherGuildInfoBuilder_ == null) {
                    this.otherGuildInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeOtherGuildInfo(int index) {
                if (this.otherGuildInfoBuilder_ == null) {
                    ensureOtherGuildInfoIsMutable();
                    this.otherGuildInfo_.remove(index);
                    onChanged();
                } else {
                    this.otherGuildInfoBuilder_.remove(index);
                }
                return this;
            }

            public GuildBossHandler.HurtRankInfo.Builder getOtherGuildInfoBuilder(int index) {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherGuildInfoFieldBuilder().getBuilder(index);
            }

            public GuildBossHandler.HurtRankInfoOrBuilder getOtherGuildInfoOrBuilder(int index) {
                if (this.otherGuildInfoBuilder_ == null)
                    return this.otherGuildInfo_.get(index);
                return (GuildBossHandler.HurtRankInfoOrBuilder) this.otherGuildInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherGuildInfoOrBuilderList() {
                if (this.otherGuildInfoBuilder_ != null)
                    return this.otherGuildInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.otherGuildInfo_);
            }

            public GuildBossHandler.HurtRankInfo.Builder addOtherGuildInfoBuilder() {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherGuildInfoFieldBuilder().addBuilder(GuildBossHandler.HurtRankInfo.getDefaultInstance());
            }

            public GuildBossHandler.HurtRankInfo.Builder addOtherGuildInfoBuilder(int index) {
                return (GuildBossHandler.HurtRankInfo.Builder) getOtherGuildInfoFieldBuilder().addBuilder(index, GuildBossHandler.HurtRankInfo.getDefaultInstance());
            }

            public List<GuildBossHandler.HurtRankInfo.Builder> getOtherGuildInfoBuilderList() {
                return getOtherGuildInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> getOtherGuildInfoFieldBuilder() {
                if (this.otherGuildInfoBuilder_ == null) {
                    this.otherGuildInfoBuilder_ = new RepeatedFieldBuilder(this.otherGuildInfo_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.otherGuildInfo_ = null;
                }
                return this.otherGuildInfoBuilder_;
            }

            public boolean hasMyGuildInfo() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public GuildBossHandler.HurtRankInfo getMyGuildInfo() {
                if (this.myGuildInfoBuilder_ == null)
                    return this.myGuildInfo_;
                return (GuildBossHandler.HurtRankInfo) this.myGuildInfoBuilder_.getMessage();
            }

            public Builder setMyGuildInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.myGuildInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.myGuildInfo_ = value;
                    onChanged();
                } else {
                    this.myGuildInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setMyGuildInfo(GuildBossHandler.HurtRankInfo.Builder builderForValue) {
                if (this.myGuildInfoBuilder_ == null) {
                    this.myGuildInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.myGuildInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeMyGuildInfo(GuildBossHandler.HurtRankInfo value) {
                if (this.myGuildInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16 && this.myGuildInfo_ != GuildBossHandler.HurtRankInfo.getDefaultInstance()) {
                        this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.newBuilder(this.myGuildInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.myGuildInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.myGuildInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder clearMyGuildInfo() {
                if (this.myGuildInfoBuilder_ == null) {
                    this.myGuildInfo_ = GuildBossHandler.HurtRankInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.myGuildInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public GuildBossHandler.HurtRankInfo.Builder getMyGuildInfoBuilder() {
                this.bitField0_ |= 0x10;
                onChanged();
                return (GuildBossHandler.HurtRankInfo.Builder) getMyGuildInfoFieldBuilder().getBuilder();
            }

            public GuildBossHandler.HurtRankInfoOrBuilder getMyGuildInfoOrBuilder() {
                if (this.myGuildInfoBuilder_ != null)
                    return (GuildBossHandler.HurtRankInfoOrBuilder) this.myGuildInfoBuilder_.getMessageOrBuilder();
                return this.myGuildInfo_;
            }

            private SingleFieldBuilder<GuildBossHandler.HurtRankInfo, GuildBossHandler.HurtRankInfo.Builder, GuildBossHandler.HurtRankInfoOrBuilder> getMyGuildInfoFieldBuilder() {
                if (this.myGuildInfoBuilder_ == null) {
                    this.myGuildInfoBuilder_ = new SingleFieldBuilder(getMyGuildInfo(), getParentForChildren(), isClean());
                    this.myGuildInfo_ = null;
                }
                return this.myGuildInfoBuilder_;
            }

            public boolean hasJoinCount() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getJoinCount() {
                return this.joinCount_;
            }

            public Builder setJoinCount(int value) {
                this.bitField0_ |= 0x20;
                this.joinCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearJoinCount() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.joinCount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class OnQuitGuildBossPush extends GeneratedMessage implements OnQuitGuildBossPushOrBuilder {
        private static final OnQuitGuildBossPush defaultInstance = new OnQuitGuildBossPush(true);
        private final UnknownFieldSet unknownFields;

        private OnQuitGuildBossPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnQuitGuildBossPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnQuitGuildBossPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnQuitGuildBossPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnQuitGuildBossPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.endSeconds_ = input.readInt32();
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
            return GuildBossHandler.internal_static_pomelo_area_OnQuitGuildBossPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_OnQuitGuildBossPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnQuitGuildBossPush.class, Builder.class);
        }

        public static Parser<OnQuitGuildBossPush> PARSER = (Parser<OnQuitGuildBossPush>) new AbstractParser<OnQuitGuildBossPush>() {
            public GuildBossHandler.OnQuitGuildBossPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.OnQuitGuildBossPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ENDSECONDS_FIELD_NUMBER = 1;
        private int endSeconds_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnQuitGuildBossPush> getParserForType() {
            return PARSER;
        }

        public boolean hasEndSeconds() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getEndSeconds() {
            return this.endSeconds_;
        }

        private void initFields() {
            this.endSeconds_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasEndSeconds()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.endSeconds_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.endSeconds_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnQuitGuildBossPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(data);
        }

        public static OnQuitGuildBossPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnQuitGuildBossPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(data);
        }

        public static OnQuitGuildBossPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnQuitGuildBossPush parseFrom(InputStream input) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(input);
        }

        public static OnQuitGuildBossPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnQuitGuildBossPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnQuitGuildBossPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnQuitGuildBossPush parseFrom(CodedInputStream input) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(input);
        }

        public static OnQuitGuildBossPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnQuitGuildBossPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnQuitGuildBossPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.OnQuitGuildBossPushOrBuilder {
            private int bitField0_;
            private int endSeconds_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_OnQuitGuildBossPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_OnQuitGuildBossPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.OnQuitGuildBossPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.OnQuitGuildBossPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.endSeconds_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_OnQuitGuildBossPush_descriptor;
            }

            public GuildBossHandler.OnQuitGuildBossPush getDefaultInstanceForType() {
                return GuildBossHandler.OnQuitGuildBossPush.getDefaultInstance();
            }

            public GuildBossHandler.OnQuitGuildBossPush build() {
                GuildBossHandler.OnQuitGuildBossPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.OnQuitGuildBossPush buildPartial() {
                GuildBossHandler.OnQuitGuildBossPush result = new GuildBossHandler.OnQuitGuildBossPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.endSeconds_ = this.endSeconds_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.OnQuitGuildBossPush)
                    return mergeFrom((GuildBossHandler.OnQuitGuildBossPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.OnQuitGuildBossPush other) {
                if (other == GuildBossHandler.OnQuitGuildBossPush.getDefaultInstance()) return this;
                if (other.hasEndSeconds()) setEndSeconds(other.getEndSeconds());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasEndSeconds()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.OnQuitGuildBossPush parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.OnQuitGuildBossPush) GuildBossHandler.OnQuitGuildBossPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.OnQuitGuildBossPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasEndSeconds() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getEndSeconds() {
                return this.endSeconds_;
            }

            public Builder setEndSeconds(int value) {
                this.bitField0_ |= 0x1;
                this.endSeconds_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndSeconds() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.endSeconds_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class OnInspireChangePush
            extends GeneratedMessage
            implements OnInspireChangePushOrBuilder {
        private static final OnInspireChangePush defaultInstance = new OnInspireChangePush(true);
        private final UnknownFieldSet unknownFields;

        private OnInspireChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnInspireChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnInspireChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public OnInspireChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnInspireChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CCode_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.totalTimes_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.totalValue_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.index_ = input.readInt32();
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
            return GuildBossHandler.internal_static_pomelo_area_OnInspireChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_OnInspireChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnInspireChangePush.class, Builder.class);
        }

        public static Parser<OnInspireChangePush> PARSER = (Parser<OnInspireChangePush>) new AbstractParser<OnInspireChangePush>() {
            public GuildBossHandler.OnInspireChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.OnInspireChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int TOTALTIMES_FIELD_NUMBER = 2;
        private int totalTimes_;
        public static final int TOTALVALUE_FIELD_NUMBER = 3;
        private int totalValue_;
        public static final int INDEX_FIELD_NUMBER = 4;
        private int index_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnInspireChangePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasTotalTimes() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getTotalTimes() {
            return this.totalTimes_;
        }


        public boolean hasTotalValue() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getTotalValue() {
            return this.totalValue_;
        }


        public boolean hasIndex() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getIndex() {
            return this.index_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.totalTimes_ = 0;
            this.totalValue_ = 0;
            this.index_ = 0;
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
                output.writeInt32(2, this.totalTimes_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.totalValue_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.index_);
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
                size += CodedOutputStream.computeInt32Size(2, this.totalTimes_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.totalValue_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.index_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnInspireChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnInspireChangePush) PARSER.parseFrom(data);
        }


        public static OnInspireChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnInspireChangePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnInspireChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnInspireChangePush) PARSER.parseFrom(data);
        }


        public static OnInspireChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnInspireChangePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnInspireChangePush parseFrom(InputStream input) throws IOException {
            return (OnInspireChangePush) PARSER.parseFrom(input);
        }


        public static OnInspireChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnInspireChangePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnInspireChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnInspireChangePush) PARSER.parseDelimitedFrom(input);
        }


        public static OnInspireChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnInspireChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OnInspireChangePush parseFrom(CodedInputStream input) throws IOException {
            return (OnInspireChangePush) PARSER.parseFrom(input);
        }


        public static OnInspireChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnInspireChangePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OnInspireChangePush prototype) {
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
                implements GuildBossHandler.OnInspireChangePushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private int totalTimes_;


            private int totalValue_;


            private int index_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_OnInspireChangePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_OnInspireChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.OnInspireChangePush.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.OnInspireChangePush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.totalTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.totalValue_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.index_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_OnInspireChangePush_descriptor;
            }


            public GuildBossHandler.OnInspireChangePush getDefaultInstanceForType() {
                return GuildBossHandler.OnInspireChangePush.getDefaultInstance();
            }


            public GuildBossHandler.OnInspireChangePush build() {
                GuildBossHandler.OnInspireChangePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildBossHandler.OnInspireChangePush buildPartial() {
                GuildBossHandler.OnInspireChangePush result = new GuildBossHandler.OnInspireChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.totalTimes_ = this.totalTimes_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.totalValue_ = this.totalValue_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.index_ = this.index_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.OnInspireChangePush) {
                    return mergeFrom((GuildBossHandler.OnInspireChangePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildBossHandler.OnInspireChangePush other) {
                if (other == GuildBossHandler.OnInspireChangePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasTotalTimes()) {
                    setTotalTimes(other.getTotalTimes());
                }
                if (other.hasTotalValue()) {
                    setTotalValue(other.getTotalValue());
                }
                if (other.hasIndex()) {
                    setIndex(other.getIndex());
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
                GuildBossHandler.OnInspireChangePush parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.OnInspireChangePush) GuildBossHandler.OnInspireChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.OnInspireChangePush) e.getUnfinishedMessage();
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


            public boolean hasTotalTimes() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getTotalTimes() {
                return this.totalTimes_;
            }


            public Builder setTotalTimes(int value) {
                this.bitField0_ |= 0x2;
                this.totalTimes_ = value;
                onChanged();
                return this;
            }


            public Builder clearTotalTimes() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.totalTimes_ = 0;
                onChanged();
                return this;
            }


            public boolean hasTotalValue() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getTotalValue() {
                return this.totalValue_;
            }


            public Builder setTotalValue(int value) {
                this.bitField0_ |= 0x4;
                this.totalValue_ = value;
                onChanged();
                return this;
            }


            public Builder clearTotalValue() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.totalValue_ = 0;
                onChanged();
                return this;
            }


            public boolean hasIndex() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getIndex() {
                return this.index_;
            }


            public Builder setIndex(int value) {
                this.bitField0_ |= 0x8;
                this.index_ = value;
                onChanged();
                return this;
            }


            public Builder clearIndex() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.index_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnEndGuildBossPush
            extends GeneratedMessage
            implements OnEndGuildBossPushOrBuilder {
        private static final OnEndGuildBossPush defaultInstance = new OnEndGuildBossPush(true);
        private final UnknownFieldSet unknownFields;

        private OnEndGuildBossPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnEndGuildBossPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnEndGuildBossPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnEndGuildBossPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnEndGuildBossPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.info_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.sec_ = input.readInt32();
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
            return GuildBossHandler.internal_static_pomelo_area_OnEndGuildBossPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildBossHandler.internal_static_pomelo_area_OnEndGuildBossPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnEndGuildBossPush.class, Builder.class);
        }

        public static Parser<OnEndGuildBossPush> PARSER = (Parser<OnEndGuildBossPush>) new AbstractParser<OnEndGuildBossPush>() {
            public GuildBossHandler.OnEndGuildBossPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildBossHandler.OnEndGuildBossPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INFO_FIELD_NUMBER = 1;
        private Object info_;
        public static final int SEC_FIELD_NUMBER = 2;
        private int sec_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnEndGuildBossPush> getParserForType() {
            return PARSER;
        }

        public boolean hasInfo() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getInfo() {
            Object ref = this.info_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.info_ = s;
            return s;
        }

        public ByteString getInfoBytes() {
            Object ref = this.info_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.info_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasSec() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getSec() {
            return this.sec_;
        }

        private void initFields() {
            this.info_ = "";
            this.sec_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasInfo()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSec()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getInfoBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.sec_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getInfoBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.sec_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnEndGuildBossPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnEndGuildBossPush) PARSER.parseFrom(data);
        }

        public static OnEndGuildBossPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnEndGuildBossPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnEndGuildBossPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnEndGuildBossPush) PARSER.parseFrom(data);
        }

        public static OnEndGuildBossPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnEndGuildBossPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnEndGuildBossPush parseFrom(InputStream input) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseFrom(input);
        }

        public static OnEndGuildBossPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnEndGuildBossPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnEndGuildBossPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnEndGuildBossPush parseFrom(CodedInputStream input) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseFrom(input);
        }

        public static OnEndGuildBossPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnEndGuildBossPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnEndGuildBossPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildBossHandler.OnEndGuildBossPushOrBuilder {
            private int bitField0_;
            private Object info_;
            private int sec_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildBossHandler.internal_static_pomelo_area_OnEndGuildBossPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildBossHandler.internal_static_pomelo_area_OnEndGuildBossPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBossHandler.OnEndGuildBossPush.class, Builder.class);
            }

            private Builder() {
                this.info_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.info_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildBossHandler.OnEndGuildBossPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.info_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.sec_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildBossHandler.internal_static_pomelo_area_OnEndGuildBossPush_descriptor;
            }

            public GuildBossHandler.OnEndGuildBossPush getDefaultInstanceForType() {
                return GuildBossHandler.OnEndGuildBossPush.getDefaultInstance();
            }

            public GuildBossHandler.OnEndGuildBossPush build() {
                GuildBossHandler.OnEndGuildBossPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildBossHandler.OnEndGuildBossPush buildPartial() {
                GuildBossHandler.OnEndGuildBossPush result = new GuildBossHandler.OnEndGuildBossPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.info_ = this.info_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.sec_ = this.sec_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildBossHandler.OnEndGuildBossPush)
                    return mergeFrom((GuildBossHandler.OnEndGuildBossPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildBossHandler.OnEndGuildBossPush other) {
                if (other == GuildBossHandler.OnEndGuildBossPush.getDefaultInstance())
                    return this;
                if (other.hasInfo()) {
                    this.bitField0_ |= 0x1;
                    this.info_ = other.info_;
                    onChanged();
                }
                if (other.hasSec())
                    setSec(other.getSec());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasInfo())
                    return false;
                if (!hasSec())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildBossHandler.OnEndGuildBossPush parsedMessage = null;
                try {
                    parsedMessage = (GuildBossHandler.OnEndGuildBossPush) GuildBossHandler.OnEndGuildBossPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildBossHandler.OnEndGuildBossPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasInfo() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getInfo() {
                Object ref = this.info_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.info_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getInfoBytes() {
                Object ref = this.info_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.info_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setInfo(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.info_ = value;
                onChanged();
                return this;
            }

            public Builder clearInfo() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.info_ = GuildBossHandler.OnEndGuildBossPush.getDefaultInstance().getInfo();
                onChanged();
                return this;
            }

            public Builder setInfoBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.info_ = value;
                onChanged();
                return this;
            }

            public boolean hasSec() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getSec() {
                return this.sec_;
            }

            public Builder setSec(int value) {
                this.bitField0_ |= 0x2;
                this.sec_ = value;
                onChanged();
                return this;
            }

            public Builder clearSec() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.sec_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\026guildBossHandler.proto\022\013pomelo.area\032\fcommon.proto\"\033\n\031EnterGuildBossAreaRequest\"?\n\032EnterGuildBossAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"g\n\021GuildBossRankInfo\022\f\n\004rank\030\001 \002(\005\022\n\n\002id\030\002 \002(\t\022\013\n\003pro\030\003 \002(\005\022\f\n\004name\030\004 \002(\t\022\016\n\006damage\030\005 \002(\003\022\r\n\005level\030\006 \002(\005\"\031\n\027GetGuildBossInfoRequest\"\n\030GetGuildBossInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\016\n\006killed\030\003 \001(\b\0220\n\brankList\030\004 \003(\0132\036.pomelo.area.GuildBossRa", "nkInfo\",\n\027GuildBossInspireRequest\022\021\n\tc2s_index\030\001 \002(\005\"=\n\030GuildBossInspireResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"D\n\fHurtRankInfo\022\f\n\004rank\030\001 \002(\005\022\n\n\002id\030\002 \002(\t\022\f\n\004name\030\003 \002(\t\022\f\n\004hurt\030\004 \002(\003\"ø\001\n\024OnHurtRankChangePush\022\020\n\bs2c_code\030\001 \002(\005\022,\n\totherInfo\030\002 \003(\0132\031.pomelo.area.HurtRankInfo\022)\n\006myInfo\030\003 \001(\0132\031.pomelo.area.HurtRankInfo\0221\n\016otherGuildInfo\030\004 \003(\0132\031.pomelo.area.HurtRankInfo\022.\n\013myGuildInfo\030\005 \001(\0132\031.pomelo.a", "rea.HurtRankInfo\022\022\n\njoin_count\030\006 \002(\005\")\n\023OnQuitGuildBossPush\022\022\n\nendSeconds\030\001 \002(\005\"^\n\023OnInspireChangePush\022\020\n\bs2c_code\030\001 \002(\005\022\022\n\ntotalTimes\030\002 \001(\005\022\022\n\ntotalValue\030\003 \001(\005\022\r\n\005index\030\004 \001(\005\"/\n\022OnEndGuildBossPush\022\f\n\004info\030\001 \002(\t\022\013\n\003sec\030\002 \002(\0052Ð\002\n\020guildBossHandler\022l\n\031enterGuildBossAreaRequest\022&.pomelo.area.EnterGuildBossAreaRequest\032'.pomelo.area.EnterGuildBossAreaResponse\022f\n\027getGuildBossInfoRequest\022$.pomelo.area.Get", "GuildBossInfoRequest\032%.pomelo.area.GetGuildBossInfoResponse\022f\n\027guildBossInspireRequest\022$.pomelo.area.GuildBossInspireRequest\032%.pomelo.area.GuildBossInspireResponse2«\002\n\rguildBossPush\022G\n\024onHurtRankChangePush\022!.pomelo.area.OnHurtRankChangePush\032\f.pomelo.Void\022E\n\023onInspireChangePush\022 .pomelo.area.OnInspireChangePush\032\f.pomelo.Void\022E\n\023onQuitGuildBossPush\022 .pomelo.area.OnQuitGuildBossPush\032\f.pomelo.Void\022C\n\022", "onEndGuildBossPush\022\037.pomelo.area.OnEndGuildBossPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                GuildBossHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_EnterGuildBossAreaRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterGuildBossAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterGuildBossAreaRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_EnterGuildBossAreaResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterGuildBossAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterGuildBossAreaResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildBossRankInfo_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildBossRankInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildBossRankInfo_descriptor, new String[]{"Rank", "Id", "Pro", "Name", "Damage", "Level"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildBossInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildBossInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildBossInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildBossInfoResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildBossInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildBossInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Killed", "RankList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildBossInspireRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildBossInspireRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildBossInspireRequest_descriptor, new String[]{"C2SIndex"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildBossInspireResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildBossInspireResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildBossInspireResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_HurtRankInfo_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_HurtRankInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_HurtRankInfo_descriptor, new String[]{"Rank", "Id", "Name", "Hurt"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnHurtRankChangePush_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnHurtRankChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnHurtRankChangePush_descriptor, new String[]{"S2CCode", "OtherInfo", "MyInfo", "OtherGuildInfo", "MyGuildInfo", "JoinCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnQuitGuildBossPush_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnQuitGuildBossPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnQuitGuildBossPush_descriptor, new String[]{"EndSeconds"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnInspireChangePush_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnInspireChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnInspireChangePush_descriptor, new String[]{"S2CCode", "TotalTimes", "TotalValue", "Index"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnEndGuildBossPush_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnEndGuildBossPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnEndGuildBossPush_descriptor, new String[]{"Info", "Sec"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface OnEndGuildBossPushOrBuilder extends MessageOrBuilder {
        boolean hasInfo();

        String getInfo();

        ByteString getInfoBytes();

        boolean hasSec();

        int getSec();
    }

    public static interface OnInspireChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasTotalTimes();

        int getTotalTimes();

        boolean hasTotalValue();

        int getTotalValue();

        boolean hasIndex();

        int getIndex();
    }

    public static interface OnQuitGuildBossPushOrBuilder extends MessageOrBuilder {
        boolean hasEndSeconds();

        int getEndSeconds();
    }

    public static interface OnHurtRankChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<GuildBossHandler.HurtRankInfo> getOtherInfoList();

        GuildBossHandler.HurtRankInfo getOtherInfo(int param1Int);

        int getOtherInfoCount();

        List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherInfoOrBuilderList();

        GuildBossHandler.HurtRankInfoOrBuilder getOtherInfoOrBuilder(int param1Int);

        boolean hasMyInfo();

        GuildBossHandler.HurtRankInfo getMyInfo();

        GuildBossHandler.HurtRankInfoOrBuilder getMyInfoOrBuilder();

        List<GuildBossHandler.HurtRankInfo> getOtherGuildInfoList();

        GuildBossHandler.HurtRankInfo getOtherGuildInfo(int param1Int);

        int getOtherGuildInfoCount();

        List<? extends GuildBossHandler.HurtRankInfoOrBuilder> getOtherGuildInfoOrBuilderList();

        GuildBossHandler.HurtRankInfoOrBuilder getOtherGuildInfoOrBuilder(int param1Int);

        boolean hasMyGuildInfo();

        GuildBossHandler.HurtRankInfo getMyGuildInfo();

        GuildBossHandler.HurtRankInfoOrBuilder getMyGuildInfoOrBuilder();

        boolean hasJoinCount();

        int getJoinCount();
    }

    public static interface HurtRankInfoOrBuilder extends MessageOrBuilder {
        boolean hasRank();

        int getRank();

        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasHurt();

        long getHurt();
    }

    public static interface GuildBossInspireResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GuildBossInspireRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SIndex();

        int getC2SIndex();
    }

    public static interface GetGuildBossInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasKilled();

        boolean getKilled();

        List<GuildBossHandler.GuildBossRankInfo> getRankListList();

        GuildBossHandler.GuildBossRankInfo getRankList(int param1Int);

        int getRankListCount();

        List<? extends GuildBossHandler.GuildBossRankInfoOrBuilder> getRankListOrBuilderList();

        GuildBossHandler.GuildBossRankInfoOrBuilder getRankListOrBuilder(int param1Int);
    }

    public static interface GetGuildBossInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GuildBossRankInfoOrBuilder extends MessageOrBuilder {
        boolean hasRank();

        int getRank();

        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasPro();

        int getPro();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasDamage();

        long getDamage();

        boolean hasLevel();

        int getLevel();
    }

    public static interface EnterGuildBossAreaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface EnterGuildBossAreaRequestOrBuilder extends MessageOrBuilder {
    }
}


