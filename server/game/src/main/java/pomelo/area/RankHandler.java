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


public final class RankHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class AwardRank
            extends GeneratedMessage
            implements AwardRankOrBuilder {
        private static final AwardRank defaultInstance = new AwardRank(true);
        private final UnknownFieldSet unknownFields;

        private AwardRank(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AwardRank(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AwardRank getDefaultInstance() {
            return defaultInstance;
        }

        public AwardRank getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AwardRank(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.id_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.invalidTime_ = input.readInt32();
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
            return RankHandler.internal_static_pomelo_area_AwardRank_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RankHandler.internal_static_pomelo_area_AwardRank_fieldAccessorTable.ensureFieldAccessorsInitialized(AwardRank.class, Builder.class);
        }

        public static Parser<AwardRank> PARSER = (Parser<AwardRank>) new AbstractParser<AwardRank>() {
            public RankHandler.AwardRank parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RankHandler.AwardRank(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int INVALIDTIME_FIELD_NUMBER = 2;
        private int invalidTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AwardRank> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasInvalidTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getInvalidTime() {
            return this.invalidTime_;
        }

        private void initFields() {
            this.id_ = 0;
            this.invalidTime_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasInvalidTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.invalidTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.invalidTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AwardRank parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AwardRank) PARSER.parseFrom(data);
        }

        public static AwardRank parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AwardRank) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AwardRank parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AwardRank) PARSER.parseFrom(data);
        }

        public static AwardRank parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AwardRank) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AwardRank parseFrom(InputStream input) throws IOException {
            return (AwardRank) PARSER.parseFrom(input);
        }

        public static AwardRank parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AwardRank) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AwardRank parseDelimitedFrom(InputStream input) throws IOException {
            return (AwardRank) PARSER.parseDelimitedFrom(input);
        }

        public static AwardRank parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AwardRank) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AwardRank parseFrom(CodedInputStream input) throws IOException {
            return (AwardRank) PARSER.parseFrom(input);
        }

        public static AwardRank parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AwardRank) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AwardRank prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RankHandler.AwardRankOrBuilder {
            private int bitField0_;
            private int id_;
            private int invalidTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RankHandler.internal_static_pomelo_area_AwardRank_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RankHandler.internal_static_pomelo_area_AwardRank_fieldAccessorTable.ensureFieldAccessorsInitialized(RankHandler.AwardRank.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RankHandler.AwardRank.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.invalidTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RankHandler.internal_static_pomelo_area_AwardRank_descriptor;
            }

            public RankHandler.AwardRank getDefaultInstanceForType() {
                return RankHandler.AwardRank.getDefaultInstance();
            }

            public RankHandler.AwardRank build() {
                RankHandler.AwardRank result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public RankHandler.AwardRank buildPartial() {
                RankHandler.AwardRank result = new RankHandler.AwardRank(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.invalidTime_ = this.invalidTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RankHandler.AwardRank)
                    return mergeFrom((RankHandler.AwardRank) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RankHandler.AwardRank other) {
                if (other == RankHandler.AwardRank.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasInvalidTime())
                    setInvalidTime(other.getInvalidTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasInvalidTime())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RankHandler.AwardRank parsedMessage = null;
                try {
                    parsedMessage = (RankHandler.AwardRank) RankHandler.AwardRank.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RankHandler.AwardRank) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0;
                onChanged();
                return this;
            }

            public boolean hasInvalidTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getInvalidTime() {
                return this.invalidTime_;
            }

            public Builder setInvalidTime(int value) {
                this.bitField0_ |= 0x2;
                this.invalidTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearInvalidTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.invalidTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetRankInfoRequest extends GeneratedMessage implements GetRankInfoRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private GetRankInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRankInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRankInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetRankInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRankInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RankHandler.internal_static_pomelo_area_GetRankInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RankHandler.internal_static_pomelo_area_GetRankInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRankInfoRequest.class, Builder.class);
        }

        public static Parser<GetRankInfoRequest> PARSER = (Parser<GetRankInfoRequest>) new AbstractParser<GetRankInfoRequest>() {
            public RankHandler.GetRankInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RankHandler.GetRankInfoRequest(input, extensionRegistry);
            }
        };

        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRankInfoRequest> getParserForType() {
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

        private static final GetRankInfoRequest defaultInstance = new GetRankInfoRequest(true);

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetRankInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRankInfoRequest) PARSER.parseFrom(data);
        }

        public static GetRankInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRankInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRankInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRankInfoRequest) PARSER.parseFrom(data);
        }

        public static GetRankInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRankInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRankInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetRankInfoRequest) PARSER.parseFrom(input);
        }

        public static GetRankInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRankInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRankInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetRankInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRankInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetRankInfoRequest) PARSER.parseFrom(input);
        }

        public static GetRankInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRankInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RankHandler.GetRankInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return RankHandler.internal_static_pomelo_area_GetRankInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RankHandler.internal_static_pomelo_area_GetRankInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RankHandler.GetRankInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RankHandler.GetRankInfoRequest.alwaysUseFieldBuilders) ;
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
                return RankHandler.internal_static_pomelo_area_GetRankInfoRequest_descriptor;
            }

            public RankHandler.GetRankInfoRequest getDefaultInstanceForType() {
                return RankHandler.GetRankInfoRequest.getDefaultInstance();
            }

            public RankHandler.GetRankInfoRequest build() {
                RankHandler.GetRankInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RankHandler.GetRankInfoRequest buildPartial() {
                RankHandler.GetRankInfoRequest result = new RankHandler.GetRankInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RankHandler.GetRankInfoRequest)
                    return mergeFrom((RankHandler.GetRankInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RankHandler.GetRankInfoRequest other) {
                if (other == RankHandler.GetRankInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RankHandler.GetRankInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (RankHandler.GetRankInfoRequest) RankHandler.GetRankInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RankHandler.GetRankInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetRankInfoResponse
            extends GeneratedMessage
            implements GetRankInfoResponseOrBuilder {
        private static final GetRankInfoResponse defaultInstance = new GetRankInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetRankInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRankInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRankInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetRankInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRankInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CAwardRanks_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CAwardRanks_.add(input.readMessage(RankHandler.AwardRank.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CSelectedRankId_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.s2CFightPower_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CAwardRanks_ = Collections.unmodifiableList(this.s2CAwardRanks_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RankHandler.internal_static_pomelo_area_GetRankInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RankHandler.internal_static_pomelo_area_GetRankInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRankInfoResponse.class, Builder.class);
        }

        public static Parser<GetRankInfoResponse> PARSER = (Parser<GetRankInfoResponse>) new AbstractParser<GetRankInfoResponse>() {
            public RankHandler.GetRankInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RankHandler.GetRankInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_AWARDRANKS_FIELD_NUMBER = 3;
        private List<RankHandler.AwardRank> s2CAwardRanks_;
        public static final int S2C_SELECTEDRANKID_FIELD_NUMBER = 4;
        private int s2CSelectedRankId_;
        public static final int S2C_FIGHTPOWER_FIELD_NUMBER = 5;
        private int s2CFightPower_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRankInfoResponse> getParserForType() {
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

        public List<RankHandler.AwardRank> getS2CAwardRanksList() {
            return this.s2CAwardRanks_;
        }

        public List<? extends RankHandler.AwardRankOrBuilder> getS2CAwardRanksOrBuilderList() {
            return (List) this.s2CAwardRanks_;
        }

        public int getS2CAwardRanksCount() {
            return this.s2CAwardRanks_.size();
        }

        public RankHandler.AwardRank getS2CAwardRanks(int index) {
            return this.s2CAwardRanks_.get(index);
        }

        public RankHandler.AwardRankOrBuilder getS2CAwardRanksOrBuilder(int index) {
            return this.s2CAwardRanks_.get(index);
        }

        public boolean hasS2CSelectedRankId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CSelectedRankId() {
            return this.s2CSelectedRankId_;
        }

        public boolean hasS2CFightPower() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CFightPower() {
            return this.s2CFightPower_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAwardRanks_ = Collections.emptyList();
            this.s2CSelectedRankId_ = 0;
            this.s2CFightPower_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CAwardRanksCount(); i++) {
                if (!getS2CAwardRanks(i).isInitialized()) {
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
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CAwardRanks_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CAwardRanks_.get(i));
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(4, this.s2CSelectedRankId_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(5, this.s2CFightPower_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CAwardRanks_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAwardRanks_.get(i));
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(4, this.s2CSelectedRankId_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(5, this.s2CFightPower_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetRankInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRankInfoResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static GetRankInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRankInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRankInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRankInfoResponse) PARSER.parseFrom(data);
        }

        public static GetRankInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRankInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRankInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetRankInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRankInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRankInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRankInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetRankInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRankInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetRankInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRankInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRankInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRankInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RankHandler.GetRankInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<RankHandler.AwardRank> s2CAwardRanks_;
            private RepeatedFieldBuilder<RankHandler.AwardRank, RankHandler.AwardRank.Builder, RankHandler.AwardRankOrBuilder> s2CAwardRanksBuilder_;
            private int s2CSelectedRankId_;
            private int s2CFightPower_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RankHandler.internal_static_pomelo_area_GetRankInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RankHandler.internal_static_pomelo_area_GetRankInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RankHandler.GetRankInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAwardRanks_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAwardRanks_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RankHandler.GetRankInfoResponse.alwaysUseFieldBuilders)
                    getS2CAwardRanksFieldBuilder();
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
                if (this.s2CAwardRanksBuilder_ == null) {
                    this.s2CAwardRanks_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CAwardRanksBuilder_.clear();
                }
                this.s2CSelectedRankId_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CFightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RankHandler.internal_static_pomelo_area_GetRankInfoResponse_descriptor;
            }

            public RankHandler.GetRankInfoResponse getDefaultInstanceForType() {
                return RankHandler.GetRankInfoResponse.getDefaultInstance();
            }

            public RankHandler.GetRankInfoResponse build() {
                RankHandler.GetRankInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public RankHandler.GetRankInfoResponse buildPartial() {
                RankHandler.GetRankInfoResponse result = new RankHandler.GetRankInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CAwardRanksBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CAwardRanks_ = Collections.unmodifiableList(this.s2CAwardRanks_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CAwardRanks_ = this.s2CAwardRanks_;
                } else {
                    result.s2CAwardRanks_ = this.s2CAwardRanksBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.s2CSelectedRankId_ = this.s2CSelectedRankId_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x8;
                result.s2CFightPower_ = this.s2CFightPower_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RankHandler.GetRankInfoResponse)
                    return mergeFrom((RankHandler.GetRankInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RankHandler.GetRankInfoResponse other) {
                if (other == RankHandler.GetRankInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CAwardRanksBuilder_ == null) {
                    if (!other.s2CAwardRanks_.isEmpty()) {
                        if (this.s2CAwardRanks_.isEmpty()) {
                            this.s2CAwardRanks_ = other.s2CAwardRanks_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CAwardRanksIsMutable();
                            this.s2CAwardRanks_.addAll(other.s2CAwardRanks_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CAwardRanks_.isEmpty()) {
                    if (this.s2CAwardRanksBuilder_.isEmpty()) {
                        this.s2CAwardRanksBuilder_.dispose();
                        this.s2CAwardRanksBuilder_ = null;
                        this.s2CAwardRanks_ = other.s2CAwardRanks_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CAwardRanksBuilder_ = RankHandler.GetRankInfoResponse.alwaysUseFieldBuilders ? getS2CAwardRanksFieldBuilder() : null;
                    } else {
                        this.s2CAwardRanksBuilder_.addAllMessages(other.s2CAwardRanks_);
                    }
                }
                if (other.hasS2CSelectedRankId())
                    setS2CSelectedRankId(other.getS2CSelectedRankId());
                if (other.hasS2CFightPower())
                    setS2CFightPower(other.getS2CFightPower());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CAwardRanksCount(); i++) {
                    if (!getS2CAwardRanks(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RankHandler.GetRankInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (RankHandler.GetRankInfoResponse) RankHandler.GetRankInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RankHandler.GetRankInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RankHandler.GetRankInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CAwardRanksIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CAwardRanks_ = new ArrayList<>(this.s2CAwardRanks_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<RankHandler.AwardRank> getS2CAwardRanksList() {
                if (this.s2CAwardRanksBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CAwardRanks_);
                return this.s2CAwardRanksBuilder_.getMessageList();
            }

            public int getS2CAwardRanksCount() {
                if (this.s2CAwardRanksBuilder_ == null)
                    return this.s2CAwardRanks_.size();
                return this.s2CAwardRanksBuilder_.getCount();
            }

            public RankHandler.AwardRank getS2CAwardRanks(int index) {
                if (this.s2CAwardRanksBuilder_ == null)
                    return this.s2CAwardRanks_.get(index);
                return (RankHandler.AwardRank) this.s2CAwardRanksBuilder_.getMessage(index);
            }

            public Builder setS2CAwardRanks(int index, RankHandler.AwardRank value) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.set(index, value);
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CAwardRanks(int index, RankHandler.AwardRank.Builder builderForValue) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAwardRanks(RankHandler.AwardRank value) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.add(value);
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CAwardRanks(int index, RankHandler.AwardRank value) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.add(index, value);
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CAwardRanks(RankHandler.AwardRank.Builder builderForValue) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAwardRanks(int index, RankHandler.AwardRank.Builder builderForValue) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CAwardRanks(Iterable<? extends RankHandler.AwardRank> values) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    ensureS2CAwardRanksIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CAwardRanks_);
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CAwardRanks() {
                if (this.s2CAwardRanksBuilder_ == null) {
                    this.s2CAwardRanks_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CAwardRanks(int index) {
                if (this.s2CAwardRanksBuilder_ == null) {
                    ensureS2CAwardRanksIsMutable();
                    this.s2CAwardRanks_.remove(index);
                    onChanged();
                } else {
                    this.s2CAwardRanksBuilder_.remove(index);
                }
                return this;
            }

            public RankHandler.AwardRank.Builder getS2CAwardRanksBuilder(int index) {
                return (RankHandler.AwardRank.Builder) getS2CAwardRanksFieldBuilder().getBuilder(index);
            }

            public RankHandler.AwardRankOrBuilder getS2CAwardRanksOrBuilder(int index) {
                if (this.s2CAwardRanksBuilder_ == null)
                    return this.s2CAwardRanks_.get(index);
                return (RankHandler.AwardRankOrBuilder) this.s2CAwardRanksBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RankHandler.AwardRankOrBuilder> getS2CAwardRanksOrBuilderList() {
                if (this.s2CAwardRanksBuilder_ != null)
                    return this.s2CAwardRanksBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CAwardRanks_);
            }

            public RankHandler.AwardRank.Builder addS2CAwardRanksBuilder() {
                return (RankHandler.AwardRank.Builder) getS2CAwardRanksFieldBuilder().addBuilder(RankHandler.AwardRank.getDefaultInstance());
            }

            public RankHandler.AwardRank.Builder addS2CAwardRanksBuilder(int index) {
                return (RankHandler.AwardRank.Builder) getS2CAwardRanksFieldBuilder().addBuilder(index, RankHandler.AwardRank.getDefaultInstance());
            }

            public List<RankHandler.AwardRank.Builder> getS2CAwardRanksBuilderList() {
                return getS2CAwardRanksFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RankHandler.AwardRank, RankHandler.AwardRank.Builder, RankHandler.AwardRankOrBuilder> getS2CAwardRanksFieldBuilder() {
                if (this.s2CAwardRanksBuilder_ == null) {
                    this.s2CAwardRanksBuilder_ = new RepeatedFieldBuilder(this.s2CAwardRanks_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CAwardRanks_ = null;
                }
                return this.s2CAwardRanksBuilder_;
            }

            public boolean hasS2CSelectedRankId() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CSelectedRankId() {
                return this.s2CSelectedRankId_;
            }

            public Builder setS2CSelectedRankId(int value) {
                this.bitField0_ |= 0x8;
                this.s2CSelectedRankId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSelectedRankId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CSelectedRankId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CFightPower() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CFightPower() {
                return this.s2CFightPower_;
            }

            public Builder setS2CFightPower(int value) {
                this.bitField0_ |= 0x10;
                this.s2CFightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CFightPower() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CFightPower_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class SaveRankNotify extends GeneratedMessage implements SaveRankNotifyOrBuilder {
        private static final SaveRankNotify defaultInstance = new SaveRankNotify(true);
        private final UnknownFieldSet unknownFields;

        private SaveRankNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SaveRankNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SaveRankNotify getDefaultInstance() {
            return defaultInstance;
        }

        public SaveRankNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SaveRankNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SSelectedRankId_ = input.readInt32();
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
            return RankHandler.internal_static_pomelo_area_SaveRankNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RankHandler.internal_static_pomelo_area_SaveRankNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveRankNotify.class, Builder.class);
        }

        public static Parser<SaveRankNotify> PARSER = (Parser<SaveRankNotify>) new AbstractParser<SaveRankNotify>() {
            public RankHandler.SaveRankNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RankHandler.SaveRankNotify(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_SELECTEDRANKID_FIELD_NUMBER = 1;
        private int c2SSelectedRankId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SaveRankNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SSelectedRankId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SSelectedRankId() {
            return this.c2SSelectedRankId_;
        }

        private void initFields() {
            this.c2SSelectedRankId_ = 0;
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
            if (!hasC2SSelectedRankId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SSelectedRankId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SSelectedRankId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SaveRankNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SaveRankNotify) PARSER.parseFrom(data);
        }


        public static SaveRankNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SaveRankNotify) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SaveRankNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SaveRankNotify) PARSER.parseFrom(data);
        }


        public static SaveRankNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SaveRankNotify) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SaveRankNotify parseFrom(InputStream input) throws IOException {
            return (SaveRankNotify) PARSER.parseFrom(input);
        }


        public static SaveRankNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveRankNotify) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SaveRankNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SaveRankNotify) PARSER.parseDelimitedFrom(input);
        }


        public static SaveRankNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveRankNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SaveRankNotify parseFrom(CodedInputStream input) throws IOException {
            return (SaveRankNotify) PARSER.parseFrom(input);
        }


        public static SaveRankNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveRankNotify) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SaveRankNotify prototype) {
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
                implements RankHandler.SaveRankNotifyOrBuilder {
            private int bitField0_;


            private int c2SSelectedRankId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return RankHandler.internal_static_pomelo_area_SaveRankNotify_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RankHandler.internal_static_pomelo_area_SaveRankNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(RankHandler.SaveRankNotify.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (RankHandler.SaveRankNotify.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SSelectedRankId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return RankHandler.internal_static_pomelo_area_SaveRankNotify_descriptor;
            }


            public RankHandler.SaveRankNotify getDefaultInstanceForType() {
                return RankHandler.SaveRankNotify.getDefaultInstance();
            }


            public RankHandler.SaveRankNotify build() {
                RankHandler.SaveRankNotify result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public RankHandler.SaveRankNotify buildPartial() {
                RankHandler.SaveRankNotify result = new RankHandler.SaveRankNotify(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SSelectedRankId_ = this.c2SSelectedRankId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof RankHandler.SaveRankNotify) {
                    return mergeFrom((RankHandler.SaveRankNotify) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(RankHandler.SaveRankNotify other) {
                if (other == RankHandler.SaveRankNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SSelectedRankId()) {
                    setC2SSelectedRankId(other.getC2SSelectedRankId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SSelectedRankId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RankHandler.SaveRankNotify parsedMessage = null;
                try {
                    parsedMessage = (RankHandler.SaveRankNotify) RankHandler.SaveRankNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RankHandler.SaveRankNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SSelectedRankId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SSelectedRankId() {
                return this.c2SSelectedRankId_;
            }


            public Builder setC2SSelectedRankId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SSelectedRankId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SSelectedRankId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SSelectedRankId_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnAwardRankPush
            extends GeneratedMessage
            implements OnAwardRankPushOrBuilder {
        private static final OnAwardRankPush defaultInstance = new OnAwardRankPush(true);
        private final UnknownFieldSet unknownFields;

        private OnAwardRankPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnAwardRankPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnAwardRankPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnAwardRankPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnAwardRankPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CAwardRankId_ = input.readInt32();
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
            return RankHandler.internal_static_pomelo_area_OnAwardRankPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RankHandler.internal_static_pomelo_area_OnAwardRankPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnAwardRankPush.class, Builder.class);
        }

        public static Parser<OnAwardRankPush> PARSER = (Parser<OnAwardRankPush>) new AbstractParser<OnAwardRankPush>() {
            public RankHandler.OnAwardRankPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RankHandler.OnAwardRankPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_AWARDRANKID_FIELD_NUMBER = 2;
        private int s2CAwardRankId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnAwardRankPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CAwardRankId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CAwardRankId() {
            return this.s2CAwardRankId_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CAwardRankId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CAwardRankId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.s2CAwardRankId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.s2CAwardRankId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnAwardRankPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnAwardRankPush) PARSER.parseFrom(data);
        }

        public static OnAwardRankPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnAwardRankPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnAwardRankPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnAwardRankPush) PARSER.parseFrom(data);
        }

        public static OnAwardRankPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnAwardRankPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnAwardRankPush parseFrom(InputStream input) throws IOException {
            return (OnAwardRankPush) PARSER.parseFrom(input);
        }

        static {
            defaultInstance.initFields();
        }

        public static OnAwardRankPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAwardRankPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnAwardRankPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnAwardRankPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnAwardRankPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAwardRankPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnAwardRankPush parseFrom(CodedInputStream input) throws IOException {
            return (OnAwardRankPush) PARSER.parseFrom(input);
        }

        public static OnAwardRankPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAwardRankPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnAwardRankPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RankHandler.OnAwardRankPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CAwardRankId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RankHandler.internal_static_pomelo_area_OnAwardRankPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RankHandler.internal_static_pomelo_area_OnAwardRankPush_fieldAccessorTable.ensureFieldAccessorsInitialized(RankHandler.OnAwardRankPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RankHandler.OnAwardRankPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CAwardRankId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RankHandler.internal_static_pomelo_area_OnAwardRankPush_descriptor;
            }

            public RankHandler.OnAwardRankPush getDefaultInstanceForType() {
                return RankHandler.OnAwardRankPush.getDefaultInstance();
            }

            public RankHandler.OnAwardRankPush build() {
                RankHandler.OnAwardRankPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RankHandler.OnAwardRankPush buildPartial() {
                RankHandler.OnAwardRankPush result = new RankHandler.OnAwardRankPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CAwardRankId_ = this.s2CAwardRankId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RankHandler.OnAwardRankPush) return mergeFrom((RankHandler.OnAwardRankPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RankHandler.OnAwardRankPush other) {
                if (other == RankHandler.OnAwardRankPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CAwardRankId()) setS2CAwardRankId(other.getS2CAwardRankId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasS2CAwardRankId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RankHandler.OnAwardRankPush parsedMessage = null;
                try {
                    parsedMessage = (RankHandler.OnAwardRankPush) RankHandler.OnAwardRankPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RankHandler.OnAwardRankPush) e.getUnfinishedMessage();
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

            public boolean hasS2CAwardRankId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CAwardRankId() {
                return this.s2CAwardRankId_;
            }

            public Builder setS2CAwardRankId(int value) {
                this.bitField0_ |= 0x2;
                this.s2CAwardRankId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CAwardRankId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CAwardRankId_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021rankHandler.proto\022\013pomelo.area\032\fcommon.proto\",\n\tAwardRank\022\n\n\002id\030\001 \002(\005\022\023\n\013invalidTime\030\002 \002(\005\"\024\n\022GetRankInfoRequest\"\001\n\023GetRankInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\016s2c_awardRanks\030\003 \003(\0132\026.pomelo.area.AwardRank\022\032\n\022s2c_selectedRankId\030\004 \001(\005\022\026\n\016s2c_fightPower\030\005 \001(\005\",\n\016SaveRankNotify\022\032\n\022c2s_selectedRankId\030\001 \002(\005\"<\n\017OnAwardRankPush\022\020\n\bs2c_code\030\001 \002(\005\022\027\n\017s2c_awardRankId\030\002 \002(\0052£\001\n\013rankHandler\022W\n", "\022getRankInfoRequest\022\037.pomelo.area.GetRankInfoRequest\032 .pomelo.area.GetRankInfoResponse\022;\n\016saveRankNotify\022\033.pomelo.area.SaveRankNotify\032\f.pomelo.Void2I\n\brankPush\022=\n\017onAwardRankPush\022\034.pomelo.area.OnAwardRankPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                RankHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_AwardRank_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AwardRank_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AwardRank_descriptor, new String[]{"Id", "InvalidTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetRankInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRankInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRankInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetRankInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRankInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRankInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAwardRanks", "S2CSelectedRankId", "S2CFightPower"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SaveRankNotify_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveRankNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveRankNotify_descriptor, new String[]{"C2SSelectedRankId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnAwardRankPush_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnAwardRankPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnAwardRankPush_descriptor, new String[]{"S2CCode", "S2CAwardRankId"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface OnAwardRankPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CAwardRankId();

        int getS2CAwardRankId();
    }

    public static interface SaveRankNotifyOrBuilder extends MessageOrBuilder {
        boolean hasC2SSelectedRankId();

        int getC2SSelectedRankId();
    }

    public static interface GetRankInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<RankHandler.AwardRank> getS2CAwardRanksList();

        RankHandler.AwardRank getS2CAwardRanks(int param1Int);

        int getS2CAwardRanksCount();

        List<? extends RankHandler.AwardRankOrBuilder> getS2CAwardRanksOrBuilderList();

        RankHandler.AwardRankOrBuilder getS2CAwardRanksOrBuilder(int param1Int);

        boolean hasS2CSelectedRankId();

        int getS2CSelectedRankId();

        boolean hasS2CFightPower();

        int getS2CFightPower();
    }

    public static interface GetRankInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface AwardRankOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasInvalidTime();

        int getInvalidTime();
    }
}


