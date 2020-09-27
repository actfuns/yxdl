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
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pomelo.Common;


public final class ArenaHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class ArenaInfoRequest
            extends GeneratedMessage
            implements ArenaInfoRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private ArenaInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ArenaInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ArenaInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ArenaInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ArenaInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                    if (!parseUnknownField(input, unknownFields, extensionRegistry, tag))
                        done = true;
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
            return ArenaHandler.internal_static_pomelo_area_ArenaInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_ArenaInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaInfoRequest.class, Builder.class);
        }

        public static Parser<ArenaInfoRequest> PARSER = (Parser<ArenaInfoRequest>) new AbstractParser<ArenaInfoRequest>() {
            public ArenaHandler.ArenaInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.ArenaInfoRequest(input, extensionRegistry);
            }
        };

        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ArenaInfoRequest> getParserForType() {
            return PARSER;
        }

        private void initFields() {
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        private static final ArenaInfoRequest defaultInstance = new ArenaInfoRequest(true);

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ArenaInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ArenaInfoRequest) PARSER.parseFrom(data);
        }

        public static ArenaInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ArenaInfoRequest) PARSER.parseFrom(data);
        }

        public static ArenaInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaInfoRequest parseFrom(InputStream input) throws IOException {
            return (ArenaInfoRequest) PARSER.parseFrom(input);
        }

        public static ArenaInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ArenaInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ArenaInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ArenaInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (ArenaInfoRequest) PARSER.parseFrom(input);
        }

        public static ArenaInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ArenaInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArenaHandler.ArenaInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.ArenaInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.ArenaInfoRequest.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoRequest_descriptor;
            }

            public ArenaHandler.ArenaInfoRequest getDefaultInstanceForType() {
                return ArenaHandler.ArenaInfoRequest.getDefaultInstance();
            }

            public ArenaHandler.ArenaInfoRequest build() {
                ArenaHandler.ArenaInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ArenaHandler.ArenaInfoRequest buildPartial() {
                ArenaHandler.ArenaInfoRequest result = new ArenaHandler.ArenaInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.ArenaInfoRequest)
                    return mergeFrom((ArenaHandler.ArenaInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaHandler.ArenaInfoRequest other) {
                if (other == ArenaHandler.ArenaInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.ArenaInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.ArenaInfoRequest) ArenaHandler.ArenaInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.ArenaInfoRequest) e.getUnfinishedMessage();
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


    public static final class ArenaInfoResponse
            extends GeneratedMessage
            implements ArenaInfoResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private ArenaInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private ArenaInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static ArenaInfoResponse getDefaultInstance() {
            return defaultInstance;
        }


        public ArenaInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private ArenaInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CSingleRank_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CTotalRank_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.s2CSingleReward_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.s2CTotalReward_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.s2CCurrentTotalRank_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.s2CCurrentTotalScore_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.s2CSeasonEndTime_ = input.readInt64();
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
            return ArenaHandler.internal_static_pomelo_area_ArenaInfoResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_ArenaInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaInfoResponse.class, Builder.class);
        }


        public static Parser<ArenaInfoResponse> PARSER = (Parser<ArenaInfoResponse>) new AbstractParser<ArenaInfoResponse>() {
            public ArenaHandler.ArenaInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.ArenaInfoResponse(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        public static final int S2C_SINGLERANK_FIELD_NUMBER = 3;


        private int s2CSingleRank_;


        public static final int S2C_TOTALRANK_FIELD_NUMBER = 4;


        private int s2CTotalRank_;


        public static final int S2C_SINGLEREWARD_FIELD_NUMBER = 5;


        private int s2CSingleReward_;


        public static final int S2C_TOTALREWARD_FIELD_NUMBER = 6;


        private int s2CTotalReward_;


        public static final int S2C_CURRENTTOTALRANK_FIELD_NUMBER = 7;


        private int s2CCurrentTotalRank_;


        public static final int S2C_CURRENTTOTALSCORE_FIELD_NUMBER = 8;


        private int s2CCurrentTotalScore_;


        public static final int S2C_SEASONENDTIME_FIELD_NUMBER = 9;


        private static final ArenaInfoResponse defaultInstance = new ArenaInfoResponse(true);
        private long s2CSeasonEndTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ArenaInfoResponse> getParserForType() {
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

        public boolean hasS2CSingleRank() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CSingleRank() {
            return this.s2CSingleRank_;
        }

        public boolean hasS2CTotalRank() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CTotalRank() {
            return this.s2CTotalRank_;
        }

        public boolean hasS2CSingleReward() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getS2CSingleReward() {
            return this.s2CSingleReward_;
        }

        public boolean hasS2CTotalReward() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getS2CTotalReward() {
            return this.s2CTotalReward_;
        }

        public boolean hasS2CCurrentTotalRank() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getS2CCurrentTotalRank() {
            return this.s2CCurrentTotalRank_;
        }

        public boolean hasS2CCurrentTotalScore() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getS2CCurrentTotalScore() {
            return this.s2CCurrentTotalScore_;
        }

        public boolean hasS2CSeasonEndTime() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public long getS2CSeasonEndTime() {
            return this.s2CSeasonEndTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CSingleRank_ = 0;
            this.s2CTotalRank_ = 0;
            this.s2CSingleReward_ = 0;
            this.s2CTotalReward_ = 0;
            this.s2CCurrentTotalRank_ = 0;
            this.s2CCurrentTotalScore_ = 0;
            this.s2CSeasonEndTime_ = 0L;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CSingleRank_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CTotalRank_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.s2CSingleReward_);
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.s2CTotalReward_);
            if ((this.bitField0_ & 0x40) == 64) output.writeInt32(7, this.s2CCurrentTotalRank_);
            if ((this.bitField0_ & 0x80) == 128) output.writeInt32(8, this.s2CCurrentTotalScore_);
            if ((this.bitField0_ & 0x100) == 256) output.writeInt64(9, this.s2CSeasonEndTime_);
            getUnknownFields().writeTo(output);
        }

        static {
            defaultInstance.initFields();
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CSingleRank_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CTotalRank_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.s2CSingleReward_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.s2CTotalReward_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.s2CCurrentTotalRank_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.s2CCurrentTotalScore_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt64Size(9, this.s2CSeasonEndTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ArenaInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ArenaInfoResponse) PARSER.parseFrom(data);
        }

        public static ArenaInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ArenaInfoResponse) PARSER.parseFrom(data);
        }

        public static ArenaInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaInfoResponse parseFrom(InputStream input) throws IOException {
            return (ArenaInfoResponse) PARSER.parseFrom(input);
        }

        public static ArenaInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ArenaInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ArenaInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ArenaInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (ArenaInfoResponse) PARSER.parseFrom(input);
        }

        public static ArenaInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ArenaInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArenaHandler.ArenaInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CSingleRank_;
            private int s2CTotalRank_;
            private int s2CSingleReward_;
            private int s2CTotalReward_;
            private int s2CCurrentTotalRank_;
            private int s2CCurrentTotalScore_;
            private long s2CSeasonEndTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.ArenaInfoResponse.class, Builder.class);
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
                if (ArenaHandler.ArenaInfoResponse.alwaysUseFieldBuilders) ;
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
                this.s2CSingleRank_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CTotalRank_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CSingleReward_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CTotalReward_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CCurrentTotalRank_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.s2CCurrentTotalScore_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.s2CSeasonEndTime_ = 0L;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaHandler.internal_static_pomelo_area_ArenaInfoResponse_descriptor;
            }

            public ArenaHandler.ArenaInfoResponse getDefaultInstanceForType() {
                return ArenaHandler.ArenaInfoResponse.getDefaultInstance();
            }

            public ArenaHandler.ArenaInfoResponse build() {
                ArenaHandler.ArenaInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ArenaHandler.ArenaInfoResponse buildPartial() {
                ArenaHandler.ArenaInfoResponse result = new ArenaHandler.ArenaInfoResponse(this);
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
                result.s2CSingleRank_ = this.s2CSingleRank_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CTotalRank_ = this.s2CTotalRank_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.s2CSingleReward_ = this.s2CSingleReward_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.s2CTotalReward_ = this.s2CTotalReward_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.s2CCurrentTotalRank_ = this.s2CCurrentTotalRank_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.s2CCurrentTotalScore_ = this.s2CCurrentTotalScore_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.s2CSeasonEndTime_ = this.s2CSeasonEndTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.ArenaInfoResponse)
                    return mergeFrom((ArenaHandler.ArenaInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaHandler.ArenaInfoResponse other) {
                if (other == ArenaHandler.ArenaInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CSingleRank())
                    setS2CSingleRank(other.getS2CSingleRank());
                if (other.hasS2CTotalRank())
                    setS2CTotalRank(other.getS2CTotalRank());
                if (other.hasS2CSingleReward())
                    setS2CSingleReward(other.getS2CSingleReward());
                if (other.hasS2CTotalReward())
                    setS2CTotalReward(other.getS2CTotalReward());
                if (other.hasS2CCurrentTotalRank())
                    setS2CCurrentTotalRank(other.getS2CCurrentTotalRank());
                if (other.hasS2CCurrentTotalScore())
                    setS2CCurrentTotalScore(other.getS2CCurrentTotalScore());
                if (other.hasS2CSeasonEndTime())
                    setS2CSeasonEndTime(other.getS2CSeasonEndTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.ArenaInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.ArenaInfoResponse) ArenaHandler.ArenaInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.ArenaInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ArenaHandler.ArenaInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CSingleRank() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CSingleRank() {
                return this.s2CSingleRank_;
            }

            public Builder setS2CSingleRank(int value) {
                this.bitField0_ |= 0x4;
                this.s2CSingleRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSingleRank() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CSingleRank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CTotalRank() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CTotalRank() {
                return this.s2CTotalRank_;
            }

            public Builder setS2CTotalRank(int value) {
                this.bitField0_ |= 0x8;
                this.s2CTotalRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CTotalRank() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CTotalRank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CSingleReward() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CSingleReward() {
                return this.s2CSingleReward_;
            }

            public Builder setS2CSingleReward(int value) {
                this.bitField0_ |= 0x10;
                this.s2CSingleReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSingleReward() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CSingleReward_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CTotalReward() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getS2CTotalReward() {
                return this.s2CTotalReward_;
            }

            public Builder setS2CTotalReward(int value) {
                this.bitField0_ |= 0x20;
                this.s2CTotalReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CTotalReward() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CTotalReward_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CCurrentTotalRank() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getS2CCurrentTotalRank() {
                return this.s2CCurrentTotalRank_;
            }

            public Builder setS2CCurrentTotalRank(int value) {
                this.bitField0_ |= 0x40;
                this.s2CCurrentTotalRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CCurrentTotalRank() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.s2CCurrentTotalRank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CCurrentTotalScore() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getS2CCurrentTotalScore() {
                return this.s2CCurrentTotalScore_;
            }

            public Builder setS2CCurrentTotalScore(int value) {
                this.bitField0_ |= 0x80;
                this.s2CCurrentTotalScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CCurrentTotalScore() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.s2CCurrentTotalScore_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CSeasonEndTime() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public long getS2CSeasonEndTime() {
                return this.s2CSeasonEndTime_;
            }

            public Builder setS2CSeasonEndTime(long value) {
                this.bitField0_ |= 0x100;
                this.s2CSeasonEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSeasonEndTime() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.s2CSeasonEndTime_ = 0L;
                onChanged();
                return this;
            }
        }
    }

    public static final class EnterArenaAreaRequest extends GeneratedMessage implements EnterArenaAreaRequestOrBuilder {
        private static final EnterArenaAreaRequest defaultInstance = new EnterArenaAreaRequest(true);
        private final UnknownFieldSet unknownFields;

        private EnterArenaAreaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EnterArenaAreaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EnterArenaAreaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public EnterArenaAreaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterArenaAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterArenaAreaRequest.class, Builder.class);
        }

        public static Parser<EnterArenaAreaRequest> PARSER = (Parser<EnterArenaAreaRequest>) new AbstractParser<EnterArenaAreaRequest>() {
            public ArenaHandler.EnterArenaAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.EnterArenaAreaRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<EnterArenaAreaRequest> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static EnterArenaAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(data);
        }


        public static EnterArenaAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static EnterArenaAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(data);
        }


        public static EnterArenaAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static EnterArenaAreaRequest parseFrom(InputStream input) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(input);
        }


        public static EnterArenaAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static EnterArenaAreaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseDelimitedFrom(input);
        }


        public static EnterArenaAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static EnterArenaAreaRequest parseFrom(CodedInputStream input) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(input);
        }


        public static EnterArenaAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(EnterArenaAreaRequest prototype) {
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
                implements ArenaHandler.EnterArenaAreaRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.EnterArenaAreaRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.EnterArenaAreaRequest.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaRequest_descriptor;
            }


            public ArenaHandler.EnterArenaAreaRequest getDefaultInstanceForType() {
                return ArenaHandler.EnterArenaAreaRequest.getDefaultInstance();
            }


            public ArenaHandler.EnterArenaAreaRequest build() {
                ArenaHandler.EnterArenaAreaRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.EnterArenaAreaRequest buildPartial() {
                ArenaHandler.EnterArenaAreaRequest result = new ArenaHandler.EnterArenaAreaRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.EnterArenaAreaRequest) {
                    return mergeFrom((ArenaHandler.EnterArenaAreaRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.EnterArenaAreaRequest other) {
                if (other == ArenaHandler.EnterArenaAreaRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.EnterArenaAreaRequest parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.EnterArenaAreaRequest) ArenaHandler.EnterArenaAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.EnterArenaAreaRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
        }
    }


    public static final class EnterArenaAreaResponse
            extends GeneratedMessage
            implements EnterArenaAreaResponseOrBuilder {
        private static final EnterArenaAreaResponse defaultInstance = new EnterArenaAreaResponse(true);
        private final UnknownFieldSet unknownFields;

        private EnterArenaAreaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EnterArenaAreaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EnterArenaAreaResponse getDefaultInstance() {
            return defaultInstance;
        }

        public EnterArenaAreaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterArenaAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterArenaAreaResponse.class, Builder.class);
        }

        public static Parser<EnterArenaAreaResponse> PARSER = (Parser<EnterArenaAreaResponse>) new AbstractParser<EnterArenaAreaResponse>() {
            public ArenaHandler.EnterArenaAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.EnterArenaAreaResponse(input, extensionRegistry);
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

        public Parser<EnterArenaAreaResponse> getParserForType() {
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
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.s2CMsg_ = s;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnterArenaAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(data);
        }

        public static EnterArenaAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterArenaAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(data);
        }

        public static EnterArenaAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterArenaAreaResponse parseFrom(InputStream input) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(input);
        }

        public static EnterArenaAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EnterArenaAreaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseDelimitedFrom(input);
        }

        public static EnterArenaAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EnterArenaAreaResponse parseFrom(CodedInputStream input) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(input);
        }

        public static EnterArenaAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterArenaAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnterArenaAreaResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArenaHandler.EnterArenaAreaResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.EnterArenaAreaResponse.class, Builder.class);
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
                if (ArenaHandler.EnterArenaAreaResponse.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_EnterArenaAreaResponse_descriptor;
            }

            public ArenaHandler.EnterArenaAreaResponse getDefaultInstanceForType() {
                return ArenaHandler.EnterArenaAreaResponse.getDefaultInstance();
            }

            public ArenaHandler.EnterArenaAreaResponse build() {
                ArenaHandler.EnterArenaAreaResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ArenaHandler.EnterArenaAreaResponse buildPartial() {
                ArenaHandler.EnterArenaAreaResponse result = new ArenaHandler.EnterArenaAreaResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.EnterArenaAreaResponse)
                    return mergeFrom((ArenaHandler.EnterArenaAreaResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaHandler.EnterArenaAreaResponse other) {
                if (other == ArenaHandler.EnterArenaAreaResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
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
                ArenaHandler.EnterArenaAreaResponse parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.EnterArenaAreaResponse) ArenaHandler.EnterArenaAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.EnterArenaAreaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ArenaHandler.EnterArenaAreaResponse.getDefaultInstance().getS2CMsg();
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
        }
    }

    public static final class LeaveArenaAreaRequest extends GeneratedMessage implements LeaveArenaAreaRequestOrBuilder {
        private static final LeaveArenaAreaRequest defaultInstance = new LeaveArenaAreaRequest(true);
        private final UnknownFieldSet unknownFields;

        private LeaveArenaAreaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaveArenaAreaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaveArenaAreaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public LeaveArenaAreaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaveArenaAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveArenaAreaRequest.class, Builder.class);
        }

        public static Parser<LeaveArenaAreaRequest> PARSER = (Parser<LeaveArenaAreaRequest>) new AbstractParser<LeaveArenaAreaRequest>() {
            public ArenaHandler.LeaveArenaAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.LeaveArenaAreaRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeaveArenaAreaRequest> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static LeaveArenaAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(data);
        }


        public static LeaveArenaAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaveArenaAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(data);
        }


        public static LeaveArenaAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaveArenaAreaRequest parseFrom(InputStream input) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(input);
        }


        public static LeaveArenaAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LeaveArenaAreaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseDelimitedFrom(input);
        }


        public static LeaveArenaAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LeaveArenaAreaRequest parseFrom(CodedInputStream input) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(input);
        }


        public static LeaveArenaAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LeaveArenaAreaRequest prototype) {
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
                implements ArenaHandler.LeaveArenaAreaRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.LeaveArenaAreaRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.LeaveArenaAreaRequest.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaRequest_descriptor;
            }


            public ArenaHandler.LeaveArenaAreaRequest getDefaultInstanceForType() {
                return ArenaHandler.LeaveArenaAreaRequest.getDefaultInstance();
            }


            public ArenaHandler.LeaveArenaAreaRequest build() {
                ArenaHandler.LeaveArenaAreaRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.LeaveArenaAreaRequest buildPartial() {
                ArenaHandler.LeaveArenaAreaRequest result = new ArenaHandler.LeaveArenaAreaRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.LeaveArenaAreaRequest) {
                    return mergeFrom((ArenaHandler.LeaveArenaAreaRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.LeaveArenaAreaRequest other) {
                if (other == ArenaHandler.LeaveArenaAreaRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.LeaveArenaAreaRequest parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.LeaveArenaAreaRequest) ArenaHandler.LeaveArenaAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.LeaveArenaAreaRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
        }
    }


    public static final class LeaveArenaAreaResponse
            extends GeneratedMessage
            implements LeaveArenaAreaResponseOrBuilder {
        private static final LeaveArenaAreaResponse defaultInstance = new LeaveArenaAreaResponse(true);
        private final UnknownFieldSet unknownFields;

        private LeaveArenaAreaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaveArenaAreaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaveArenaAreaResponse getDefaultInstance() {
            return defaultInstance;
        }

        public LeaveArenaAreaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaveArenaAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveArenaAreaResponse.class, Builder.class);
        }

        public static Parser<LeaveArenaAreaResponse> PARSER = (Parser<LeaveArenaAreaResponse>) new AbstractParser<LeaveArenaAreaResponse>() {
            public ArenaHandler.LeaveArenaAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.LeaveArenaAreaResponse(input, extensionRegistry);
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

        public Parser<LeaveArenaAreaResponse> getParserForType() {
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


        public static LeaveArenaAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(data);
        }


        public static LeaveArenaAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaveArenaAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(data);
        }


        public static LeaveArenaAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaveArenaAreaResponse parseFrom(InputStream input) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(input);
        }


        public static LeaveArenaAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LeaveArenaAreaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseDelimitedFrom(input);
        }


        public static LeaveArenaAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LeaveArenaAreaResponse parseFrom(CodedInputStream input) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(input);
        }


        public static LeaveArenaAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveArenaAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LeaveArenaAreaResponse prototype) {
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
                implements ArenaHandler.LeaveArenaAreaResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.LeaveArenaAreaResponse.class, Builder.class);
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
                if (ArenaHandler.LeaveArenaAreaResponse.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_LeaveArenaAreaResponse_descriptor;
            }


            public ArenaHandler.LeaveArenaAreaResponse getDefaultInstanceForType() {
                return ArenaHandler.LeaveArenaAreaResponse.getDefaultInstance();
            }


            public ArenaHandler.LeaveArenaAreaResponse build() {
                ArenaHandler.LeaveArenaAreaResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.LeaveArenaAreaResponse buildPartial() {
                ArenaHandler.LeaveArenaAreaResponse result = new ArenaHandler.LeaveArenaAreaResponse(this);
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
                if (other instanceof ArenaHandler.LeaveArenaAreaResponse) {
                    return mergeFrom((ArenaHandler.LeaveArenaAreaResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.LeaveArenaAreaResponse other) {
                if (other == ArenaHandler.LeaveArenaAreaResponse.getDefaultInstance()) {
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
                ArenaHandler.LeaveArenaAreaResponse parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.LeaveArenaAreaResponse) ArenaHandler.LeaveArenaAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.LeaveArenaAreaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ArenaHandler.LeaveArenaAreaResponse.getDefaultInstance().getS2CMsg();
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


    public static final class ArenaRewardRequest
            extends GeneratedMessage
            implements ArenaRewardRequestOrBuilder {
        private static final ArenaRewardRequest defaultInstance = new ArenaRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private ArenaRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ArenaRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ArenaRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ArenaRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ArenaRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SType_ = input.readInt32();
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
            return ArenaHandler.internal_static_pomelo_area_ArenaRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_ArenaRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaRewardRequest.class, Builder.class);
        }

        public static Parser<ArenaRewardRequest> PARSER = (Parser<ArenaRewardRequest>) new AbstractParser<ArenaRewardRequest>() {
            public ArenaHandler.ArenaRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.ArenaRewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ArenaRewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SType() {
            return this.c2SType_;
        }

        private void initFields() {
            this.c2SType_ = 0;
        }

        static {
            defaultInstance.initFields();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ArenaRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ArenaRewardRequest) PARSER.parseFrom(data);
        }


        public static ArenaRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ArenaRewardRequest) PARSER.parseFrom(data);
        }


        public static ArenaRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaRewardRequest parseFrom(InputStream input) throws IOException {
            return (ArenaRewardRequest) PARSER.parseFrom(input);
        }


        public static ArenaRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ArenaRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaRewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ArenaRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ArenaRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (ArenaRewardRequest) PARSER.parseFrom(input);
        }


        public static ArenaRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ArenaRewardRequest prototype) {
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
                implements ArenaHandler.ArenaRewardRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.ArenaRewardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.ArenaRewardRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardRequest_descriptor;
            }


            public ArenaHandler.ArenaRewardRequest getDefaultInstanceForType() {
                return ArenaHandler.ArenaRewardRequest.getDefaultInstance();
            }


            public ArenaHandler.ArenaRewardRequest build() {
                ArenaHandler.ArenaRewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.ArenaRewardRequest buildPartial() {
                ArenaHandler.ArenaRewardRequest result = new ArenaHandler.ArenaRewardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.ArenaRewardRequest) {
                    return mergeFrom((ArenaHandler.ArenaRewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.ArenaRewardRequest other) {
                if (other == ArenaHandler.ArenaRewardRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.ArenaRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.ArenaRewardRequest) ArenaHandler.ArenaRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.ArenaRewardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SType() {
                return this.c2SType_;
            }


            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x1;
                this.c2SType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SType_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ArenaRewardResponse
            extends GeneratedMessage
            implements ArenaRewardResponseOrBuilder {
        private static final ArenaRewardResponse defaultInstance = new ArenaRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private ArenaRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ArenaRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ArenaRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ArenaRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ArenaRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ArenaHandler.internal_static_pomelo_area_ArenaRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_ArenaRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaRewardResponse.class, Builder.class);
        }

        public static Parser<ArenaRewardResponse> PARSER = (Parser<ArenaRewardResponse>) new AbstractParser<ArenaRewardResponse>() {
            public ArenaHandler.ArenaRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.ArenaRewardResponse(input, extensionRegistry);
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

        public Parser<ArenaRewardResponse> getParserForType() {
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


        public static ArenaRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ArenaRewardResponse) PARSER.parseFrom(data);
        }


        public static ArenaRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ArenaRewardResponse) PARSER.parseFrom(data);
        }


        public static ArenaRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaRewardResponse parseFrom(InputStream input) throws IOException {
            return (ArenaRewardResponse) PARSER.parseFrom(input);
        }


        public static ArenaRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ArenaRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaRewardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ArenaRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ArenaRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (ArenaRewardResponse) PARSER.parseFrom(input);
        }


        public static ArenaRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ArenaRewardResponse prototype) {
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
                implements ArenaHandler.ArenaRewardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.ArenaRewardResponse.class, Builder.class);
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
                if (ArenaHandler.ArenaRewardResponse.alwaysUseFieldBuilders) ;
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
                return ArenaHandler.internal_static_pomelo_area_ArenaRewardResponse_descriptor;
            }


            public ArenaHandler.ArenaRewardResponse getDefaultInstanceForType() {
                return ArenaHandler.ArenaRewardResponse.getDefaultInstance();
            }


            public ArenaHandler.ArenaRewardResponse build() {
                ArenaHandler.ArenaRewardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.ArenaRewardResponse buildPartial() {
                ArenaHandler.ArenaRewardResponse result = new ArenaHandler.ArenaRewardResponse(this);
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
                if (other instanceof ArenaHandler.ArenaRewardResponse) {
                    return mergeFrom((ArenaHandler.ArenaRewardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.ArenaRewardResponse other) {
                if (other == ArenaHandler.ArenaRewardResponse.getDefaultInstance()) {
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
                ArenaHandler.ArenaRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.ArenaRewardResponse) ArenaHandler.ArenaRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.ArenaRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ArenaHandler.ArenaRewardResponse.getDefaultInstance().getS2CMsg();
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


    public static final class ArenaBattleScore
            extends GeneratedMessage
            implements ArenaBattleScoreOrBuilder {
        private static final ArenaBattleScore defaultInstance = new ArenaBattleScore(true);
        private final UnknownFieldSet unknownFields;

        private ArenaBattleScore(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ArenaBattleScore(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ArenaBattleScore getDefaultInstance() {
            return defaultInstance;
        }

        public ArenaBattleScore getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ArenaBattleScore(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.name_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.score_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.pro_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.id_ = bs;
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
            return ArenaHandler.internal_static_pomelo_area_ArenaBattleScore_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_ArenaBattleScore_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaBattleScore.class, Builder.class);
        }

        public static Parser<ArenaBattleScore> PARSER = (Parser<ArenaBattleScore>) new AbstractParser<ArenaBattleScore>() {
            public ArenaHandler.ArenaBattleScore parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.ArenaBattleScore(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private Object name_;
        public static final int SCORE_FIELD_NUMBER = 2;
        private int score_;
        public static final int PRO_FIELD_NUMBER = 3;
        private int pro_;
        public static final int ID_FIELD_NUMBER = 4;
        private Object id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ArenaBattleScore> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.name_ = s;
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

        public boolean hasScore() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getScore() {
            return this.score_;
        }


        public boolean hasPro() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getPro() {
            return this.pro_;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.id_ = s;
            }
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


        private void initFields() {
            this.name_ = "";
            this.score_ = 0;
            this.pro_ = 0;
            this.id_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.score_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.pro_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getNameBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.score_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.pro_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ArenaBattleScore parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ArenaBattleScore) PARSER.parseFrom(data);
        }


        public static ArenaBattleScore parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaBattleScore) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaBattleScore parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ArenaBattleScore) PARSER.parseFrom(data);
        }


        public static ArenaBattleScore parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ArenaBattleScore) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ArenaBattleScore parseFrom(InputStream input) throws IOException {
            return (ArenaBattleScore) PARSER.parseFrom(input);
        }


        public static ArenaBattleScore parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaBattleScore) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ArenaBattleScore parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaBattleScore) PARSER.parseDelimitedFrom(input);
        }


        public static ArenaBattleScore parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaBattleScore) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ArenaBattleScore parseFrom(CodedInputStream input) throws IOException {
            return (ArenaBattleScore) PARSER.parseFrom(input);
        }


        public static ArenaBattleScore parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaBattleScore) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ArenaBattleScore prototype) {
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
                implements ArenaHandler.ArenaBattleScoreOrBuilder {
            private int bitField0_;


            private Object name_;


            private int score_;


            private int pro_;


            private Object id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_ArenaBattleScore_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_ArenaBattleScore_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.ArenaBattleScore.class, Builder.class);
            }


            private Builder() {
                this.name_ = "";
                this.id_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.id_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.ArenaBattleScore.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaHandler.internal_static_pomelo_area_ArenaBattleScore_descriptor;
            }


            public ArenaHandler.ArenaBattleScore getDefaultInstanceForType() {
                return ArenaHandler.ArenaBattleScore.getDefaultInstance();
            }


            public ArenaHandler.ArenaBattleScore build() {
                ArenaHandler.ArenaBattleScore result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ArenaHandler.ArenaBattleScore buildPartial() {
                ArenaHandler.ArenaBattleScore result = new ArenaHandler.ArenaBattleScore(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.score_ = this.score_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.ArenaBattleScore) {
                    return mergeFrom((ArenaHandler.ArenaBattleScore) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ArenaHandler.ArenaBattleScore other) {
                if (other == ArenaHandler.ArenaBattleScore.getDefaultInstance()) {
                    return this;
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x1;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasScore()) {
                    setScore(other.getScore());
                }
                if (other.hasPro()) {
                    setPro(other.getPro());
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x8;
                    this.id_ = other.id_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (!hasScore()) {
                    return false;
                }
                if (!hasPro()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.ArenaBattleScore parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.ArenaBattleScore) ArenaHandler.ArenaBattleScore.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.ArenaBattleScore) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasName() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.name_ = value;
                onChanged();
                return this;
            }


            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = ArenaHandler.ArenaBattleScore.getDefaultInstance().getName();
                onChanged();
                return this;
            }


            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.name_ = value;
                onChanged();
                return this;
            }


            public boolean hasScore() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getScore() {
                return this.score_;
            }


            public Builder setScore(int value) {
                this.bitField0_ |= 0x2;
                this.score_ = value;
                onChanged();
                return this;
            }


            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.score_ = 0;
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


            public boolean hasId() {
                return ((this.bitField0_ & 0x8) == 8);
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
                this.bitField0_ |= 0x8;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.id_ = ArenaHandler.ArenaBattleScore.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.id_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnArenaBattleInfoPush
            extends GeneratedMessage
            implements OnArenaBattleInfoPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private OnArenaBattleInfoPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private OnArenaBattleInfoPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static OnArenaBattleInfoPush getDefaultInstance() {
            return defaultInstance;
        }


        public OnArenaBattleInfoPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private OnArenaBattleInfoPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CKillCount_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.s2CIndex_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CScore_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.s2CScores_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.s2CScores_.add(input.readMessage(ArenaHandler.ArenaBattleScore.PARSER, extensionRegistry));
                            break;
                        case 48:
                            this.bitField0_ |= 0x10;
                            this.s2CPlayerCount_ = input.readInt32();
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.s2CKillCountList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.s2CKillCountList_.add(input.readMessage(ArenaHandler.ArenaBattleScore.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.s2CScores_ = Collections.unmodifiableList(this.s2CScores_);
                }
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.s2CKillCountList_ = Collections.unmodifiableList(this.s2CKillCountList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }


        public static final Descriptors.Descriptor getDescriptor() {
            return ArenaHandler.internal_static_pomelo_area_OnArenaBattleInfoPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_OnArenaBattleInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnArenaBattleInfoPush.class, Builder.class);
        }


        public static Parser<OnArenaBattleInfoPush> PARSER = (Parser<OnArenaBattleInfoPush>) new AbstractParser<OnArenaBattleInfoPush>() {
            public ArenaHandler.OnArenaBattleInfoPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.OnArenaBattleInfoPush(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_KILLCOUNT_FIELD_NUMBER = 2;


        private int s2CKillCount_;


        public static final int S2C_INDEX_FIELD_NUMBER = 3;


        private int s2CIndex_;


        public static final int S2C_SCORE_FIELD_NUMBER = 4;


        private int s2CScore_;


        public static final int S2C_SCORES_FIELD_NUMBER = 5;


        private List<ArenaHandler.ArenaBattleScore> s2CScores_;


        public static final int S2C_PLAYERCOUNT_FIELD_NUMBER = 6;


        private int s2CPlayerCount_;


        public static final int S2C_KILLCOUNTLIST_FIELD_NUMBER = 7;


        private List<ArenaHandler.ArenaBattleScore> s2CKillCountList_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final OnArenaBattleInfoPush defaultInstance = new OnArenaBattleInfoPush(true);
        private static final long serialVersionUID = 0L;

        public Parser<OnArenaBattleInfoPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CKillCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CKillCount() {
            return this.s2CKillCount_;
        }

        public boolean hasS2CIndex() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CIndex() {
            return this.s2CIndex_;
        }

        public boolean hasS2CScore() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CScore() {
            return this.s2CScore_;
        }

        public List<ArenaHandler.ArenaBattleScore> getS2CScoresList() {
            return this.s2CScores_;
        }

        public List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CScoresOrBuilderList() {
            return (List) this.s2CScores_;
        }

        public int getS2CScoresCount() {
            return this.s2CScores_.size();
        }

        public ArenaHandler.ArenaBattleScore getS2CScores(int index) {
            return this.s2CScores_.get(index);
        }

        public ArenaHandler.ArenaBattleScoreOrBuilder getS2CScoresOrBuilder(int index) {
            return this.s2CScores_.get(index);
        }

        public boolean hasS2CPlayerCount() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getS2CPlayerCount() {
            return this.s2CPlayerCount_;
        }

        public List<ArenaHandler.ArenaBattleScore> getS2CKillCountListList() {
            return this.s2CKillCountList_;
        }

        public List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CKillCountListOrBuilderList() {
            return (List) this.s2CKillCountList_;
        }

        public int getS2CKillCountListCount() {
            return this.s2CKillCountList_.size();
        }

        public ArenaHandler.ArenaBattleScore getS2CKillCountList(int index) {
            return this.s2CKillCountList_.get(index);
        }

        public ArenaHandler.ArenaBattleScoreOrBuilder getS2CKillCountListOrBuilder(int index) {
            return this.s2CKillCountList_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CKillCount_ = 0;
            this.s2CIndex_ = 0;
            this.s2CScore_ = 0;
            this.s2CScores_ = Collections.emptyList();
            this.s2CPlayerCount_ = 0;
            this.s2CKillCountList_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CKillCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CPlayerCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getS2CScoresCount(); i++) {
                if (!getS2CScores(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getS2CKillCountListCount(); i++) {
                if (!getS2CKillCountList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.s2CKillCount_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CIndex_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CScore_);
            int i;
            for (i = 0; i < this.s2CScores_.size(); i++) output.writeMessage(5, (MessageLite) this.s2CScores_.get(i));
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(6, this.s2CPlayerCount_);
            for (i = 0; i < this.s2CKillCountList_.size(); i++)
                output.writeMessage(7, (MessageLite) this.s2CKillCountList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.s2CKillCount_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CIndex_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CScore_);
            int i;
            for (i = 0; i < this.s2CScores_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.s2CScores_.get(i));
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(6, this.s2CPlayerCount_);
            for (i = 0; i < this.s2CKillCountList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.s2CKillCountList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnArenaBattleInfoPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(data);
        }

        public static OnArenaBattleInfoPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnArenaBattleInfoPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(data);
        }

        public static OnArenaBattleInfoPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnArenaBattleInfoPush parseFrom(InputStream input) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(input);
        }

        public static OnArenaBattleInfoPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnArenaBattleInfoPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnArenaBattleInfoPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static OnArenaBattleInfoPush parseFrom(CodedInputStream input) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(input);
        }

        public static OnArenaBattleInfoPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnArenaBattleInfoPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArenaHandler.OnArenaBattleInfoPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CKillCount_;
            private int s2CIndex_;
            private int s2CScore_;
            private List<ArenaHandler.ArenaBattleScore> s2CScores_;
            private RepeatedFieldBuilder<ArenaHandler.ArenaBattleScore, ArenaHandler.ArenaBattleScore.Builder, ArenaHandler.ArenaBattleScoreOrBuilder> s2CScoresBuilder_;
            private int s2CPlayerCount_;
            private List<ArenaHandler.ArenaBattleScore> s2CKillCountList_;
            private RepeatedFieldBuilder<ArenaHandler.ArenaBattleScore, ArenaHandler.ArenaBattleScore.Builder, ArenaHandler.ArenaBattleScoreOrBuilder> s2CKillCountListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleInfoPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.OnArenaBattleInfoPush.class, Builder.class);
            }

            private Builder() {
                this.s2CScores_ = Collections.emptyList();
                this.s2CKillCountList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CScores_ = Collections.emptyList();
                this.s2CKillCountList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.OnArenaBattleInfoPush.alwaysUseFieldBuilders) {
                    getS2CScoresFieldBuilder();
                    getS2CKillCountListFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CKillCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CScore_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.s2CScoresBuilder_ == null) {
                    this.s2CScores_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.s2CScoresBuilder_.clear();
                }
                this.s2CPlayerCount_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.s2CKillCountListBuilder_ == null) {
                    this.s2CKillCountList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                } else {
                    this.s2CKillCountListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleInfoPush_descriptor;
            }

            public ArenaHandler.OnArenaBattleInfoPush getDefaultInstanceForType() {
                return ArenaHandler.OnArenaBattleInfoPush.getDefaultInstance();
            }

            public ArenaHandler.OnArenaBattleInfoPush build() {
                ArenaHandler.OnArenaBattleInfoPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ArenaHandler.OnArenaBattleInfoPush buildPartial() {
                ArenaHandler.OnArenaBattleInfoPush result = new ArenaHandler.OnArenaBattleInfoPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CKillCount_ = this.s2CKillCount_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.s2CIndex_ = this.s2CIndex_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CScore_ = this.s2CScore_;
                if (this.s2CScoresBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.s2CScores_ = Collections.unmodifiableList(this.s2CScores_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.s2CScores_ = this.s2CScores_;
                } else {
                    result.s2CScores_ = this.s2CScoresBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x10;
                result.s2CPlayerCount_ = this.s2CPlayerCount_;
                if (this.s2CKillCountListBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.s2CKillCountList_ = Collections.unmodifiableList(this.s2CKillCountList_);
                        this.bitField0_ &= 0xFFFFFFBF;
                    }
                    result.s2CKillCountList_ = this.s2CKillCountList_;
                } else {
                    result.s2CKillCountList_ = this.s2CKillCountListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.OnArenaBattleInfoPush)
                    return mergeFrom((ArenaHandler.OnArenaBattleInfoPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaHandler.OnArenaBattleInfoPush other) {
                if (other == ArenaHandler.OnArenaBattleInfoPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CKillCount())
                    setS2CKillCount(other.getS2CKillCount());
                if (other.hasS2CIndex())
                    setS2CIndex(other.getS2CIndex());
                if (other.hasS2CScore())
                    setS2CScore(other.getS2CScore());
                if (this.s2CScoresBuilder_ == null) {
                    if (!other.s2CScores_.isEmpty()) {
                        if (this.s2CScores_.isEmpty()) {
                            this.s2CScores_ = other.s2CScores_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureS2CScoresIsMutable();
                            this.s2CScores_.addAll(other.s2CScores_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CScores_.isEmpty()) {
                    if (this.s2CScoresBuilder_.isEmpty()) {
                        this.s2CScoresBuilder_.dispose();
                        this.s2CScoresBuilder_ = null;
                        this.s2CScores_ = other.s2CScores_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.s2CScoresBuilder_ = ArenaHandler.OnArenaBattleInfoPush.alwaysUseFieldBuilders ? getS2CScoresFieldBuilder() : null;
                    } else {
                        this.s2CScoresBuilder_.addAllMessages(other.s2CScores_);
                    }
                }
                if (other.hasS2CPlayerCount())
                    setS2CPlayerCount(other.getS2CPlayerCount());
                if (this.s2CKillCountListBuilder_ == null) {
                    if (!other.s2CKillCountList_.isEmpty()) {
                        if (this.s2CKillCountList_.isEmpty()) {
                            this.s2CKillCountList_ = other.s2CKillCountList_;
                            this.bitField0_ &= 0xFFFFFFBF;
                        } else {
                            ensureS2CKillCountListIsMutable();
                            this.s2CKillCountList_.addAll(other.s2CKillCountList_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CKillCountList_.isEmpty()) {
                    if (this.s2CKillCountListBuilder_.isEmpty()) {
                        this.s2CKillCountListBuilder_.dispose();
                        this.s2CKillCountListBuilder_ = null;
                        this.s2CKillCountList_ = other.s2CKillCountList_;
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.s2CKillCountListBuilder_ = ArenaHandler.OnArenaBattleInfoPush.alwaysUseFieldBuilders ? getS2CKillCountListFieldBuilder() : null;
                    } else {
                        this.s2CKillCountListBuilder_.addAllMessages(other.s2CKillCountList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CKillCount())
                    return false;
                if (!hasS2CIndex())
                    return false;
                if (!hasS2CScore())
                    return false;
                if (!hasS2CPlayerCount())
                    return false;
                int i;
                for (i = 0; i < getS2CScoresCount(); i++) {
                    if (!getS2CScores(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getS2CKillCountListCount(); i++) {
                    if (!getS2CKillCountList(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.OnArenaBattleInfoPush parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.OnArenaBattleInfoPush) ArenaHandler.OnArenaBattleInfoPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.OnArenaBattleInfoPush) e.getUnfinishedMessage();
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

            public boolean hasS2CKillCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CKillCount() {
                return this.s2CKillCount_;
            }

            public Builder setS2CKillCount(int value) {
                this.bitField0_ |= 0x2;
                this.s2CKillCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CKillCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CKillCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CIndex() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CIndex() {
                return this.s2CIndex_;
            }

            public Builder setS2CIndex(int value) {
                this.bitField0_ |= 0x4;
                this.s2CIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CIndex() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CIndex_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CScore() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CScore() {
                return this.s2CScore_;
            }

            public Builder setS2CScore(int value) {
                this.bitField0_ |= 0x8;
                this.s2CScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CScore() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CScore_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CScoresIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.s2CScores_ = new ArrayList<>(this.s2CScores_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<ArenaHandler.ArenaBattleScore> getS2CScoresList() {
                if (this.s2CScoresBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CScores_);
                return this.s2CScoresBuilder_.getMessageList();
            }

            public int getS2CScoresCount() {
                if (this.s2CScoresBuilder_ == null)
                    return this.s2CScores_.size();
                return this.s2CScoresBuilder_.getCount();
            }

            public ArenaHandler.ArenaBattleScore getS2CScores(int index) {
                if (this.s2CScoresBuilder_ == null)
                    return this.s2CScores_.get(index);
                return (ArenaHandler.ArenaBattleScore) this.s2CScoresBuilder_.getMessage(index);
            }

            public Builder setS2CScores(int index, ArenaHandler.ArenaBattleScore value) {
                if (this.s2CScoresBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.set(index, value);
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CScores(int index, ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CScoresBuilder_ == null) {
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CScores(ArenaHandler.ArenaBattleScore value) {
                if (this.s2CScoresBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.add(value);
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CScores(int index, ArenaHandler.ArenaBattleScore value) {
                if (this.s2CScoresBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.add(index, value);
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CScores(ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CScoresBuilder_ == null) {
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CScores(int index, ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CScoresBuilder_ == null) {
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CScores(Iterable<? extends ArenaHandler.ArenaBattleScore> values) {
                if (this.s2CScoresBuilder_ == null) {
                    ensureS2CScoresIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CScores_);
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CScores() {
                if (this.s2CScoresBuilder_ == null) {
                    this.s2CScores_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CScores(int index) {
                if (this.s2CScoresBuilder_ == null) {
                    ensureS2CScoresIsMutable();
                    this.s2CScores_.remove(index);
                    onChanged();
                } else {
                    this.s2CScoresBuilder_.remove(index);
                }
                return this;
            }

            public ArenaHandler.ArenaBattleScore.Builder getS2CScoresBuilder(int index) {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CScoresFieldBuilder().getBuilder(index);
            }

            public ArenaHandler.ArenaBattleScoreOrBuilder getS2CScoresOrBuilder(int index) {
                if (this.s2CScoresBuilder_ == null)
                    return this.s2CScores_.get(index);
                return (ArenaHandler.ArenaBattleScoreOrBuilder) this.s2CScoresBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CScoresOrBuilderList() {
                if (this.s2CScoresBuilder_ != null)
                    return this.s2CScoresBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CScores_);
            }

            public ArenaHandler.ArenaBattleScore.Builder addS2CScoresBuilder() {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CScoresFieldBuilder().addBuilder(ArenaHandler.ArenaBattleScore.getDefaultInstance());
            }

            public ArenaHandler.ArenaBattleScore.Builder addS2CScoresBuilder(int index) {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CScoresFieldBuilder().addBuilder(index, ArenaHandler.ArenaBattleScore.getDefaultInstance());
            }

            public List<ArenaHandler.ArenaBattleScore.Builder> getS2CScoresBuilderList() {
                return getS2CScoresFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ArenaHandler.ArenaBattleScore, ArenaHandler.ArenaBattleScore.Builder, ArenaHandler.ArenaBattleScoreOrBuilder> getS2CScoresFieldBuilder() {
                if (this.s2CScoresBuilder_ == null) {
                    this.s2CScoresBuilder_ = new RepeatedFieldBuilder(this.s2CScores_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.s2CScores_ = null;
                }
                return this.s2CScoresBuilder_;
            }

            public boolean hasS2CPlayerCount() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getS2CPlayerCount() {
                return this.s2CPlayerCount_;
            }

            public Builder setS2CPlayerCount(int value) {
                this.bitField0_ |= 0x20;
                this.s2CPlayerCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CPlayerCount() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CPlayerCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CKillCountListIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.s2CKillCountList_ = new ArrayList<>(this.s2CKillCountList_);
                    this.bitField0_ |= 0x40;
                }
            }

            public List<ArenaHandler.ArenaBattleScore> getS2CKillCountListList() {
                if (this.s2CKillCountListBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CKillCountList_);
                return this.s2CKillCountListBuilder_.getMessageList();
            }

            public int getS2CKillCountListCount() {
                if (this.s2CKillCountListBuilder_ == null)
                    return this.s2CKillCountList_.size();
                return this.s2CKillCountListBuilder_.getCount();
            }

            public ArenaHandler.ArenaBattleScore getS2CKillCountList(int index) {
                if (this.s2CKillCountListBuilder_ == null)
                    return this.s2CKillCountList_.get(index);
                return (ArenaHandler.ArenaBattleScore) this.s2CKillCountListBuilder_.getMessage(index);
            }

            public Builder setS2CKillCountList(int index, ArenaHandler.ArenaBattleScore value) {
                if (this.s2CKillCountListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.set(index, value);
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CKillCountList(int index, ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CKillCountListBuilder_ == null) {
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CKillCountList(ArenaHandler.ArenaBattleScore value) {
                if (this.s2CKillCountListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.add(value);
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CKillCountList(int index, ArenaHandler.ArenaBattleScore value) {
                if (this.s2CKillCountListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.add(index, value);
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CKillCountList(ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CKillCountListBuilder_ == null) {
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CKillCountList(int index, ArenaHandler.ArenaBattleScore.Builder builderForValue) {
                if (this.s2CKillCountListBuilder_ == null) {
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CKillCountList(Iterable<? extends ArenaHandler.ArenaBattleScore> values) {
                if (this.s2CKillCountListBuilder_ == null) {
                    ensureS2CKillCountListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CKillCountList_);
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CKillCountList() {
                if (this.s2CKillCountListBuilder_ == null) {
                    this.s2CKillCountList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CKillCountList(int index) {
                if (this.s2CKillCountListBuilder_ == null) {
                    ensureS2CKillCountListIsMutable();
                    this.s2CKillCountList_.remove(index);
                    onChanged();
                } else {
                    this.s2CKillCountListBuilder_.remove(index);
                }
                return this;
            }

            public ArenaHandler.ArenaBattleScore.Builder getS2CKillCountListBuilder(int index) {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CKillCountListFieldBuilder().getBuilder(index);
            }

            public ArenaHandler.ArenaBattleScoreOrBuilder getS2CKillCountListOrBuilder(int index) {
                if (this.s2CKillCountListBuilder_ == null)
                    return this.s2CKillCountList_.get(index);
                return (ArenaHandler.ArenaBattleScoreOrBuilder) this.s2CKillCountListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CKillCountListOrBuilderList() {
                if (this.s2CKillCountListBuilder_ != null)
                    return this.s2CKillCountListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CKillCountList_);
            }

            public ArenaHandler.ArenaBattleScore.Builder addS2CKillCountListBuilder() {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CKillCountListFieldBuilder().addBuilder(ArenaHandler.ArenaBattleScore.getDefaultInstance());
            }

            public ArenaHandler.ArenaBattleScore.Builder addS2CKillCountListBuilder(int index) {
                return (ArenaHandler.ArenaBattleScore.Builder) getS2CKillCountListFieldBuilder().addBuilder(index, ArenaHandler.ArenaBattleScore.getDefaultInstance());
            }

            public List<ArenaHandler.ArenaBattleScore.Builder> getS2CKillCountListBuilderList() {
                return getS2CKillCountListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ArenaHandler.ArenaBattleScore, ArenaHandler.ArenaBattleScore.Builder, ArenaHandler.ArenaBattleScoreOrBuilder> getS2CKillCountListFieldBuilder() {
                if (this.s2CKillCountListBuilder_ == null) {
                    this.s2CKillCountListBuilder_ = new RepeatedFieldBuilder(this.s2CKillCountList_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
                    this.s2CKillCountList_ = null;
                }
                return this.s2CKillCountListBuilder_;
            }
        }
    }

    public static final class OnArenaBattleEndPush extends GeneratedMessage implements OnArenaBattleEndPushOrBuilder {
        private static final OnArenaBattleEndPush defaultInstance = new OnArenaBattleEndPush(true);
        private final UnknownFieldSet unknownFields;

        private OnArenaBattleEndPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnArenaBattleEndPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnArenaBattleEndPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnArenaBattleEndPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnArenaBattleEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.outtime_ = input.readInt32();
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
            return ArenaHandler.internal_static_pomelo_area_OnArenaBattleEndPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaHandler.internal_static_pomelo_area_OnArenaBattleEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnArenaBattleEndPush.class, Builder.class);
        }

        public static Parser<OnArenaBattleEndPush> PARSER = (Parser<OnArenaBattleEndPush>) new AbstractParser<OnArenaBattleEndPush>() {
            public ArenaHandler.OnArenaBattleEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaHandler.OnArenaBattleEndPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int OUTTIME_FIELD_NUMBER = 2;
        private int outtime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnArenaBattleEndPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasOuttime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getOuttime() {
            return this.outtime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.outtime_ = 0;
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
            if (!hasOuttime()) {
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
                output.writeInt32(2, this.outtime_);
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
                size += CodedOutputStream.computeInt32Size(2, this.outtime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnArenaBattleEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(data);
        }

        public static OnArenaBattleEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnArenaBattleEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(data);
        }

        public static OnArenaBattleEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnArenaBattleEndPush parseFrom(InputStream input) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(input);
        }

        public static OnArenaBattleEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnArenaBattleEndPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnArenaBattleEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnArenaBattleEndPush parseFrom(CodedInputStream input) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(input);
        }

        public static OnArenaBattleEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnArenaBattleEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnArenaBattleEndPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArenaHandler.OnArenaBattleEndPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int outtime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleEndPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaHandler.OnArenaBattleEndPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ArenaHandler.OnArenaBattleEndPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.outtime_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaHandler.internal_static_pomelo_area_OnArenaBattleEndPush_descriptor;
            }

            public ArenaHandler.OnArenaBattleEndPush getDefaultInstanceForType() {
                return ArenaHandler.OnArenaBattleEndPush.getDefaultInstance();
            }

            public ArenaHandler.OnArenaBattleEndPush build() {
                ArenaHandler.OnArenaBattleEndPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ArenaHandler.OnArenaBattleEndPush buildPartial() {
                ArenaHandler.OnArenaBattleEndPush result = new ArenaHandler.OnArenaBattleEndPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.outtime_ = this.outtime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ArenaHandler.OnArenaBattleEndPush)
                    return mergeFrom((ArenaHandler.OnArenaBattleEndPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaHandler.OnArenaBattleEndPush other) {
                if (other == ArenaHandler.OnArenaBattleEndPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasOuttime())
                    setOuttime(other.getOuttime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasOuttime())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ArenaHandler.OnArenaBattleEndPush parsedMessage = null;
                try {
                    parsedMessage = (ArenaHandler.OnArenaBattleEndPush) ArenaHandler.OnArenaBattleEndPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ArenaHandler.OnArenaBattleEndPush) e.getUnfinishedMessage();
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

            public boolean hasOuttime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getOuttime() {
                return this.outtime_;
            }

            public Builder setOuttime(int value) {
                this.bitField0_ |= 0x2;
                this.outtime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOuttime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.outtime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\022arenaHandler.proto\022\013pomelo.area\032\fcommon.proto\"\022\n\020ArenaInfoRequest\"ð\001\n\021ArenaInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_singleRank\030\003 \001(\005\022\025\n\rs2c_totalRank\030\004 \001(\005\022\030\n\020s2c_singleReward\030\005 \001(\005\022\027\n\017s2c_totalReward\030\006 \001(\005\022\034\n\024s2c_currentTotalRank\030\007 \001(\005\022\035\n\025s2c_currentTotalScore\030\b \001(\005\022\031\n\021s2c_seasonEndTime\030\t \001(\003\"\027\n\025EnterArenaAreaRequest\";\n\026EnterArenaAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\027\n\025", "LeaveArenaAreaRequest\";\n\026LeaveArenaAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"&\n\022ArenaRewardRequest\022\020\n\bc2s_type\030\001 \002(\005\"8\n\023ArenaRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"H\n\020ArenaBattleScore\022\f\n\004name\030\001 \002(\t\022\r\n\005score\030\002 \002(\005\022\013\n\003pro\030\003 \002(\005\022\n\n\002id\030\004 \001(\t\"ì\001\n\025OnArenaBattleInfoPush\022\020\n\bs2c_code\030\001 \002(\005\022\025\n\rs2c_killCount\030\002 \002(\005\022\021\n\ts2c_index\030\003 \002(\005\022\021\n\ts2c_score\030\004 \002(\005\0221\n\ns2c_scores\030\005 \003(\0132\035.pomelo.area.ArenaB", "attleScore\022\027\n\017s2c_playerCount\030\006 \002(\005\0228\n\021s2c_killCountList\030\007 \003(\0132\035.pomelo.area.ArenaBattleScore\"9\n\024OnArenaBattleEndPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007outtime\030\002 \002(\0052þ\002\n\farenaHandler\022Q\n\020arenaInfoRequest\022\035.pomelo.area.ArenaInfoRequest\032\036.pomelo.area.ArenaInfoResponse\022`\n\025enterArenaAreaRequest\022\".pomelo.area.EnterArenaAreaRequest\032#.pomelo.area.EnterArenaAreaResponse\022`\n\025leaveArenaAreaRequest\022\".pomelo.area.LeaveArena", "AreaRequest\032#.pomelo.area.LeaveArenaAreaResponse\022W\n\022arenaRewardRequest\022\037.pomelo.area.ArenaRewardRequest\032 .pomelo.area.ArenaRewardResponse2\001\n\tarenaPush\022I\n\025onArenaBattleInfoPush\022\".pomelo.area.OnArenaBattleInfoPush\032\f.pomelo.Void\022G\n\024onArenaBattleEndPush\022!.pomelo.area.OnArenaBattleEndPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ArenaHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_ArenaInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ArenaInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ArenaInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_ArenaInfoResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ArenaInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ArenaInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CSingleRank", "S2CTotalRank", "S2CSingleReward", "S2CTotalReward", "S2CCurrentTotalRank", "S2CCurrentTotalScore", "S2CSeasonEndTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_EnterArenaAreaRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterArenaAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterArenaAreaRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_EnterArenaAreaResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_EnterArenaAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_EnterArenaAreaResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaveArenaAreaRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaveArenaAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaveArenaAreaRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaveArenaAreaResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaveArenaAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaveArenaAreaResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ArenaRewardRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ArenaRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ArenaRewardRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ArenaRewardResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ArenaRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ArenaRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ArenaBattleScore_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ArenaBattleScore_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ArenaBattleScore_descriptor, new String[]{"Name", "Score", "Pro", "Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnArenaBattleInfoPush_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnArenaBattleInfoPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnArenaBattleInfoPush_descriptor, new String[]{"S2CCode", "S2CKillCount", "S2CIndex", "S2CScore", "S2CScores", "S2CPlayerCount", "S2CKillCountList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnArenaBattleEndPush_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnArenaBattleEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnArenaBattleEndPush_descriptor, new String[]{"S2CCode", "Outtime"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface OnArenaBattleEndPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasOuttime();

        int getOuttime();
    }

    public static interface OnArenaBattleInfoPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CKillCount();

        int getS2CKillCount();

        boolean hasS2CIndex();

        int getS2CIndex();

        boolean hasS2CScore();

        int getS2CScore();

        List<ArenaHandler.ArenaBattleScore> getS2CScoresList();

        ArenaHandler.ArenaBattleScore getS2CScores(int param1Int);

        int getS2CScoresCount();

        List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CScoresOrBuilderList();

        ArenaHandler.ArenaBattleScoreOrBuilder getS2CScoresOrBuilder(int param1Int);

        boolean hasS2CPlayerCount();

        int getS2CPlayerCount();

        List<ArenaHandler.ArenaBattleScore> getS2CKillCountListList();

        ArenaHandler.ArenaBattleScore getS2CKillCountList(int param1Int);

        int getS2CKillCountListCount();

        List<? extends ArenaHandler.ArenaBattleScoreOrBuilder> getS2CKillCountListOrBuilderList();

        ArenaHandler.ArenaBattleScoreOrBuilder getS2CKillCountListOrBuilder(int param1Int);
    }

    public static interface ArenaBattleScoreOrBuilder extends MessageOrBuilder {
        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasScore();

        int getScore();

        boolean hasPro();

        int getPro();

        boolean hasId();

        String getId();

        ByteString getIdBytes();
    }

    public static interface ArenaRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ArenaRewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface LeaveArenaAreaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface LeaveArenaAreaRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface EnterArenaAreaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface EnterArenaAreaRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface ArenaInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CSingleRank();

        int getS2CSingleRank();

        boolean hasS2CTotalRank();

        int getS2CTotalRank();

        boolean hasS2CSingleReward();

        int getS2CSingleReward();

        boolean hasS2CTotalReward();

        int getS2CTotalReward();

        boolean hasS2CCurrentTotalRank();

        int getS2CCurrentTotalRank();

        boolean hasS2CCurrentTotalScore();

        int getS2CCurrentTotalScore();

        boolean hasS2CSeasonEndTime();

        long getS2CSeasonEndTime();
    }

    public static interface ArenaInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


