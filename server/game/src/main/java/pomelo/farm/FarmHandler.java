package pomelo.farm;

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


public final class FarmHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class MyFarmInfoRequest
            extends GeneratedMessage
            implements MyFarmInfoRequestOrBuilder {
        private static final MyFarmInfoRequest defaultInstance = new MyFarmInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private MyFarmInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MyFarmInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MyFarmInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MyFarmInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MyFarmInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_MyFarmInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_MyFarmInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MyFarmInfoRequest.class, Builder.class);
        }

        public static Parser<MyFarmInfoRequest> PARSER = (Parser<MyFarmInfoRequest>) new AbstractParser<MyFarmInfoRequest>() {
            public FarmHandler.MyFarmInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.MyFarmInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MyFarmInfoRequest> getParserForType() {
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

        public static MyFarmInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MyFarmInfoRequest) PARSER.parseFrom(data);
        }

        public static MyFarmInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyFarmInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyFarmInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MyFarmInfoRequest) PARSER.parseFrom(data);
        }

        public static MyFarmInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyFarmInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyFarmInfoRequest parseFrom(InputStream input) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseFrom(input);
        }

        public static MyFarmInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MyFarmInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MyFarmInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MyFarmInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseFrom(input);
        }

        public static MyFarmInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MyFarmInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.MyFarmInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.MyFarmInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.MyFarmInfoRequest.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoRequest_descriptor;
            }

            public FarmHandler.MyFarmInfoRequest getDefaultInstanceForType() {
                return FarmHandler.MyFarmInfoRequest.getDefaultInstance();
            }

            public FarmHandler.MyFarmInfoRequest build() {
                FarmHandler.MyFarmInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.MyFarmInfoRequest buildPartial() {
                FarmHandler.MyFarmInfoRequest result = new FarmHandler.MyFarmInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.MyFarmInfoRequest)
                    return mergeFrom((FarmHandler.MyFarmInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.MyFarmInfoRequest other) {
                if (other == FarmHandler.MyFarmInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.MyFarmInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.MyFarmInfoRequest) FarmHandler.MyFarmInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.MyFarmInfoRequest) e.getUnfinishedMessage();
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


    public static final class MyFarmInfoResponse
            extends GeneratedMessage
            implements MyFarmInfoResponseOrBuilder {
        private static final MyFarmInfoResponse defaultInstance = new MyFarmInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private MyFarmInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MyFarmInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MyFarmInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MyFarmInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MyFarmInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Farm.PlayerInfo.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.playerInfo_.toBuilder();
                            this.playerInfo_ = (Farm.PlayerInfo) input.readMessage(Farm.PlayerInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.playerInfo_);
                                this.playerInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.seedLs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.seedLs_.add(input.readMessage(Farm.Seed.PARSER, extensionRegistry));
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.productLs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.productLs_.add(input.readMessage(Farm.Product.PARSER, extensionRegistry));
                            break;
                        case 48:
                            this.bitField0_ |= 0x8;
                            this.exp_ = input.readInt32();
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.recordInfoLs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.recordInfoLs_.add(input.readMessage(Farm.RecordInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.seedLs_ = Collections.unmodifiableList(this.seedLs_);
                if ((mutable_bitField0_ & 0x10) == 16) this.productLs_ = Collections.unmodifiableList(this.productLs_);
                if ((mutable_bitField0_ & 0x40) == 64)
                    this.recordInfoLs_ = Collections.unmodifiableList(this.recordInfoLs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FarmHandler.internal_static_pomelo_farm_MyFarmInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_MyFarmInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MyFarmInfoResponse.class, Builder.class);
        }

        public static Parser<MyFarmInfoResponse> PARSER = (Parser<MyFarmInfoResponse>) new AbstractParser<MyFarmInfoResponse>() {
            public FarmHandler.MyFarmInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.MyFarmInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PLAYERINFO_FIELD_NUMBER = 3;
        private Farm.PlayerInfo playerInfo_;
        public static final int SEEDLS_FIELD_NUMBER = 4;
        private List<Farm.Seed> seedLs_;
        public static final int PRODUCTLS_FIELD_NUMBER = 5;
        private List<Farm.Product> productLs_;
        public static final int EXP_FIELD_NUMBER = 6;
        private int exp_;
        public static final int RECORDINFOLS_FIELD_NUMBER = 7;
        private List<Farm.RecordInfo> recordInfoLs_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MyFarmInfoResponse> getParserForType() {
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

        public boolean hasPlayerInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public Farm.PlayerInfo getPlayerInfo() {
            return this.playerInfo_;
        }

        public Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder() {
            return this.playerInfo_;
        }

        public List<Farm.Seed> getSeedLsList() {
            return this.seedLs_;
        }

        public List<? extends Farm.SeedOrBuilder> getSeedLsOrBuilderList() {
            return (List) this.seedLs_;
        }

        public int getSeedLsCount() {
            return this.seedLs_.size();
        }

        public Farm.Seed getSeedLs(int index) {
            return this.seedLs_.get(index);
        }

        public Farm.SeedOrBuilder getSeedLsOrBuilder(int index) {
            return this.seedLs_.get(index);
        }

        public List<Farm.Product> getProductLsList() {
            return this.productLs_;
        }

        public List<? extends Farm.ProductOrBuilder> getProductLsOrBuilderList() {
            return (List) this.productLs_;
        }

        public int getProductLsCount() {
            return this.productLs_.size();
        }

        public Farm.Product getProductLs(int index) {
            return this.productLs_.get(index);
        }

        public Farm.ProductOrBuilder getProductLsOrBuilder(int index) {
            return this.productLs_.get(index);
        }

        public boolean hasExp() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getExp() {
            return this.exp_;
        }

        public List<Farm.RecordInfo> getRecordInfoLsList() {
            return this.recordInfoLs_;
        }

        public List<? extends Farm.RecordInfoOrBuilder> getRecordInfoLsOrBuilderList() {
            return (List) this.recordInfoLs_;
        }

        public int getRecordInfoLsCount() {
            return this.recordInfoLs_.size();
        }

        public Farm.RecordInfo getRecordInfoLs(int index) {
            return this.recordInfoLs_.get(index);
        }

        public Farm.RecordInfoOrBuilder getRecordInfoLsOrBuilder(int index) {
            return this.recordInfoLs_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
            this.seedLs_ = Collections.emptyList();
            this.productLs_ = Collections.emptyList();
            this.exp_ = 0;
            this.recordInfoLs_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasPlayerInfo() && !getPlayerInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getSeedLsCount(); i++) {
                if (!getSeedLs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getProductLsCount(); i++) {
                if (!getProductLs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getRecordInfoLsCount(); i++) {
                if (!getRecordInfoLs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        static {
            defaultInstance.initFields();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeMessage(3, (MessageLite) this.playerInfo_);
            int i;
            for (i = 0; i < this.seedLs_.size(); i++)
                output.writeMessage(4, (MessageLite) this.seedLs_.get(i));
            for (i = 0; i < this.productLs_.size(); i++)
                output.writeMessage(5, (MessageLite) this.productLs_.get(i));
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(6, this.exp_);
            for (i = 0; i < this.recordInfoLs_.size(); i++)
                output.writeMessage(7, (MessageLite) this.recordInfoLs_.get(i));
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.playerInfo_);
            int i;
            for (i = 0; i < this.seedLs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.seedLs_.get(i));
            for (i = 0; i < this.productLs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.productLs_.get(i));
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(6, this.exp_);
            for (i = 0; i < this.recordInfoLs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.recordInfoLs_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MyFarmInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MyFarmInfoResponse) PARSER.parseFrom(data);
        }

        public static MyFarmInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyFarmInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyFarmInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MyFarmInfoResponse) PARSER.parseFrom(data);
        }

        public static MyFarmInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyFarmInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyFarmInfoResponse parseFrom(InputStream input) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseFrom(input);
        }

        public static MyFarmInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MyFarmInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MyFarmInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MyFarmInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseFrom(input);
        }

        public static MyFarmInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyFarmInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MyFarmInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.MyFarmInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Farm.PlayerInfo playerInfo_;
            private SingleFieldBuilder<Farm.PlayerInfo, Farm.PlayerInfo.Builder, Farm.PlayerInfoOrBuilder> playerInfoBuilder_;
            private List<Farm.Seed> seedLs_;
            private RepeatedFieldBuilder<Farm.Seed, Farm.Seed.Builder, Farm.SeedOrBuilder> seedLsBuilder_;
            private List<Farm.Product> productLs_;
            private RepeatedFieldBuilder<Farm.Product, Farm.Product.Builder, Farm.ProductOrBuilder> productLsBuilder_;
            private int exp_;
            private List<Farm.RecordInfo> recordInfoLs_;
            private RepeatedFieldBuilder<Farm.RecordInfo, Farm.RecordInfo.Builder, Farm.RecordInfoOrBuilder> recordInfoLsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.MyFarmInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                this.seedLs_ = Collections.emptyList();
                this.productLs_ = Collections.emptyList();
                this.recordInfoLs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                this.seedLs_ = Collections.emptyList();
                this.productLs_ = Collections.emptyList();
                this.recordInfoLs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.MyFarmInfoResponse.alwaysUseFieldBuilders) {
                    getPlayerInfoFieldBuilder();
                    getSeedLsFieldBuilder();
                    getProductLsFieldBuilder();
                    getRecordInfoLsFieldBuilder();
                }
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
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                } else {
                    this.playerInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.seedLsBuilder_ == null) {
                    this.seedLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.seedLsBuilder_.clear();
                }
                if (this.productLsBuilder_ == null) {
                    this.productLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.productLsBuilder_.clear();
                }
                this.exp_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.recordInfoLsBuilder_ == null) {
                    this.recordInfoLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                } else {
                    this.recordInfoLsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_MyFarmInfoResponse_descriptor;
            }

            public FarmHandler.MyFarmInfoResponse getDefaultInstanceForType() {
                return FarmHandler.MyFarmInfoResponse.getDefaultInstance();
            }

            public FarmHandler.MyFarmInfoResponse build() {
                FarmHandler.MyFarmInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.MyFarmInfoResponse buildPartial() {
                FarmHandler.MyFarmInfoResponse result = new FarmHandler.MyFarmInfoResponse(this);
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
                if (this.playerInfoBuilder_ == null) {
                    result.playerInfo_ = this.playerInfo_;
                } else {
                    result.playerInfo_ = (Farm.PlayerInfo) this.playerInfoBuilder_.build();
                }
                if (this.seedLsBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.seedLs_ = Collections.unmodifiableList(this.seedLs_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.seedLs_ = this.seedLs_;
                } else {
                    result.seedLs_ = this.seedLsBuilder_.build();
                }
                if (this.productLsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.productLs_ = Collections.unmodifiableList(this.productLs_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.productLs_ = this.productLs_;
                } else {
                    result.productLs_ = this.productLsBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x8;
                result.exp_ = this.exp_;
                if (this.recordInfoLsBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.recordInfoLs_ = Collections.unmodifiableList(this.recordInfoLs_);
                        this.bitField0_ &= 0xFFFFFFBF;
                    }
                    result.recordInfoLs_ = this.recordInfoLs_;
                } else {
                    result.recordInfoLs_ = this.recordInfoLsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.MyFarmInfoResponse)
                    return mergeFrom((FarmHandler.MyFarmInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.MyFarmInfoResponse other) {
                if (other == FarmHandler.MyFarmInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasPlayerInfo())
                    mergePlayerInfo(other.getPlayerInfo());
                if (this.seedLsBuilder_ == null) {
                    if (!other.seedLs_.isEmpty()) {
                        if (this.seedLs_.isEmpty()) {
                            this.seedLs_ = other.seedLs_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureSeedLsIsMutable();
                            this.seedLs_.addAll(other.seedLs_);
                        }
                        onChanged();
                    }
                } else if (!other.seedLs_.isEmpty()) {
                    if (this.seedLsBuilder_.isEmpty()) {
                        this.seedLsBuilder_.dispose();
                        this.seedLsBuilder_ = null;
                        this.seedLs_ = other.seedLs_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.seedLsBuilder_ = FarmHandler.MyFarmInfoResponse.alwaysUseFieldBuilders ? getSeedLsFieldBuilder() : null;
                    } else {
                        this.seedLsBuilder_.addAllMessages(other.seedLs_);
                    }
                }
                if (this.productLsBuilder_ == null) {
                    if (!other.productLs_.isEmpty()) {
                        if (this.productLs_.isEmpty()) {
                            this.productLs_ = other.productLs_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureProductLsIsMutable();
                            this.productLs_.addAll(other.productLs_);
                        }
                        onChanged();
                    }
                } else if (!other.productLs_.isEmpty()) {
                    if (this.productLsBuilder_.isEmpty()) {
                        this.productLsBuilder_.dispose();
                        this.productLsBuilder_ = null;
                        this.productLs_ = other.productLs_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.productLsBuilder_ = FarmHandler.MyFarmInfoResponse.alwaysUseFieldBuilders ? getProductLsFieldBuilder() : null;
                    } else {
                        this.productLsBuilder_.addAllMessages(other.productLs_);
                    }
                }
                if (other.hasExp())
                    setExp(other.getExp());
                if (this.recordInfoLsBuilder_ == null) {
                    if (!other.recordInfoLs_.isEmpty()) {
                        if (this.recordInfoLs_.isEmpty()) {
                            this.recordInfoLs_ = other.recordInfoLs_;
                            this.bitField0_ &= 0xFFFFFFBF;
                        } else {
                            ensureRecordInfoLsIsMutable();
                            this.recordInfoLs_.addAll(other.recordInfoLs_);
                        }
                        onChanged();
                    }
                } else if (!other.recordInfoLs_.isEmpty()) {
                    if (this.recordInfoLsBuilder_.isEmpty()) {
                        this.recordInfoLsBuilder_.dispose();
                        this.recordInfoLsBuilder_ = null;
                        this.recordInfoLs_ = other.recordInfoLs_;
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.recordInfoLsBuilder_ = FarmHandler.MyFarmInfoResponse.alwaysUseFieldBuilders ? getRecordInfoLsFieldBuilder() : null;
                    } else {
                        this.recordInfoLsBuilder_.addAllMessages(other.recordInfoLs_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasPlayerInfo() && !getPlayerInfo().isInitialized())
                    return false;
                int i;
                for (i = 0; i < getSeedLsCount(); i++) {
                    if (!getSeedLs(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getProductLsCount(); i++) {
                    if (!getProductLs(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getRecordInfoLsCount(); i++) {
                    if (!getRecordInfoLs(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.MyFarmInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.MyFarmInfoResponse) FarmHandler.MyFarmInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.MyFarmInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.MyFarmInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPlayerInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public Farm.PlayerInfo getPlayerInfo() {
                if (this.playerInfoBuilder_ == null)
                    return this.playerInfo_;
                return (Farm.PlayerInfo) this.playerInfoBuilder_.getMessage();
            }

            public Builder setPlayerInfo(Farm.PlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.playerInfo_ = value;
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPlayerInfo(Farm.PlayerInfo.Builder builderForValue) {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePlayerInfo(Farm.PlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.playerInfo_ != Farm.PlayerInfo.getDefaultInstance()) {
                        this.playerInfo_ = Farm.PlayerInfo.newBuilder(this.playerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.playerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.playerInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Farm.PlayerInfo.Builder getPlayerInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (Farm.PlayerInfo.Builder) getPlayerInfoFieldBuilder().getBuilder();
            }

            public Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder() {
                if (this.playerInfoBuilder_ != null)
                    return (Farm.PlayerInfoOrBuilder) this.playerInfoBuilder_.getMessageOrBuilder();
                return this.playerInfo_;
            }

            private SingleFieldBuilder<Farm.PlayerInfo, Farm.PlayerInfo.Builder, Farm.PlayerInfoOrBuilder> getPlayerInfoFieldBuilder() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfoBuilder_ = new SingleFieldBuilder(getPlayerInfo(), getParentForChildren(), isClean());
                    this.playerInfo_ = null;
                }
                return this.playerInfoBuilder_;
            }

            private void ensureSeedLsIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.seedLs_ = new ArrayList<>(this.seedLs_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<Farm.Seed> getSeedLsList() {
                if (this.seedLsBuilder_ == null)
                    return Collections.unmodifiableList(this.seedLs_);
                return this.seedLsBuilder_.getMessageList();
            }

            public int getSeedLsCount() {
                if (this.seedLsBuilder_ == null)
                    return this.seedLs_.size();
                return this.seedLsBuilder_.getCount();
            }

            public Farm.Seed getSeedLs(int index) {
                if (this.seedLsBuilder_ == null)
                    return this.seedLs_.get(index);
                return (Farm.Seed) this.seedLsBuilder_.getMessage(index);
            }

            public Builder setSeedLs(int index, Farm.Seed value) {
                if (this.seedLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSeedLsIsMutable();
                    this.seedLs_.set(index, value);
                    onChanged();
                } else {
                    this.seedLsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSeedLs(int index, Farm.Seed.Builder builderForValue) {
                if (this.seedLsBuilder_ == null) {
                    ensureSeedLsIsMutable();
                    this.seedLs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.seedLsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSeedLs(Farm.Seed value) {
                if (this.seedLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSeedLsIsMutable();
                    this.seedLs_.add(value);
                    onChanged();
                } else {
                    this.seedLsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSeedLs(int index, Farm.Seed value) {
                if (this.seedLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSeedLsIsMutable();
                    this.seedLs_.add(index, value);
                    onChanged();
                } else {
                    this.seedLsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSeedLs(Farm.Seed.Builder builderForValue) {
                if (this.seedLsBuilder_ == null) {
                    ensureSeedLsIsMutable();
                    this.seedLs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.seedLsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSeedLs(int index, Farm.Seed.Builder builderForValue) {
                if (this.seedLsBuilder_ == null) {
                    ensureSeedLsIsMutable();
                    this.seedLs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.seedLsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSeedLs(Iterable<? extends Farm.Seed> values) {
                if (this.seedLsBuilder_ == null) {
                    ensureSeedLsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.seedLs_);
                    onChanged();
                } else {
                    this.seedLsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSeedLs() {
                if (this.seedLsBuilder_ == null) {
                    this.seedLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.seedLsBuilder_.clear();
                }
                return this;
            }

            public Builder removeSeedLs(int index) {
                if (this.seedLsBuilder_ == null) {
                    ensureSeedLsIsMutable();
                    this.seedLs_.remove(index);
                    onChanged();
                } else {
                    this.seedLsBuilder_.remove(index);
                }
                return this;
            }

            public Farm.Seed.Builder getSeedLsBuilder(int index) {
                return (Farm.Seed.Builder) getSeedLsFieldBuilder().getBuilder(index);
            }

            public Farm.SeedOrBuilder getSeedLsOrBuilder(int index) {
                if (this.seedLsBuilder_ == null)
                    return this.seedLs_.get(index);
                return (Farm.SeedOrBuilder) this.seedLsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Farm.SeedOrBuilder> getSeedLsOrBuilderList() {
                if (this.seedLsBuilder_ != null)
                    return this.seedLsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.seedLs_);
            }

            public Farm.Seed.Builder addSeedLsBuilder() {
                return (Farm.Seed.Builder) getSeedLsFieldBuilder().addBuilder(Farm.Seed.getDefaultInstance());
            }

            public Farm.Seed.Builder addSeedLsBuilder(int index) {
                return (Farm.Seed.Builder) getSeedLsFieldBuilder().addBuilder(index, Farm.Seed.getDefaultInstance());
            }

            public List<Farm.Seed.Builder> getSeedLsBuilderList() {
                return getSeedLsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Farm.Seed, Farm.Seed.Builder, Farm.SeedOrBuilder> getSeedLsFieldBuilder() {
                if (this.seedLsBuilder_ == null) {
                    this.seedLsBuilder_ = new RepeatedFieldBuilder(this.seedLs_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.seedLs_ = null;
                }
                return this.seedLsBuilder_;
            }

            private void ensureProductLsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.productLs_ = new ArrayList<>(this.productLs_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Farm.Product> getProductLsList() {
                if (this.productLsBuilder_ == null)
                    return Collections.unmodifiableList(this.productLs_);
                return this.productLsBuilder_.getMessageList();
            }

            public int getProductLsCount() {
                if (this.productLsBuilder_ == null)
                    return this.productLs_.size();
                return this.productLsBuilder_.getCount();
            }

            public Farm.Product getProductLs(int index) {
                if (this.productLsBuilder_ == null)
                    return this.productLs_.get(index);
                return (Farm.Product) this.productLsBuilder_.getMessage(index);
            }

            public Builder setProductLs(int index, Farm.Product value) {
                if (this.productLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureProductLsIsMutable();
                    this.productLs_.set(index, value);
                    onChanged();
                } else {
                    this.productLsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setProductLs(int index, Farm.Product.Builder builderForValue) {
                if (this.productLsBuilder_ == null) {
                    ensureProductLsIsMutable();
                    this.productLs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.productLsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addProductLs(Farm.Product value) {
                if (this.productLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureProductLsIsMutable();
                    this.productLs_.add(value);
                    onChanged();
                } else {
                    this.productLsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addProductLs(int index, Farm.Product value) {
                if (this.productLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureProductLsIsMutable();
                    this.productLs_.add(index, value);
                    onChanged();
                } else {
                    this.productLsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addProductLs(Farm.Product.Builder builderForValue) {
                if (this.productLsBuilder_ == null) {
                    ensureProductLsIsMutable();
                    this.productLs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.productLsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addProductLs(int index, Farm.Product.Builder builderForValue) {
                if (this.productLsBuilder_ == null) {
                    ensureProductLsIsMutable();
                    this.productLs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.productLsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllProductLs(Iterable<? extends Farm.Product> values) {
                if (this.productLsBuilder_ == null) {
                    ensureProductLsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.productLs_);
                    onChanged();
                } else {
                    this.productLsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearProductLs() {
                if (this.productLsBuilder_ == null) {
                    this.productLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.productLsBuilder_.clear();
                }
                return this;
            }

            public Builder removeProductLs(int index) {
                if (this.productLsBuilder_ == null) {
                    ensureProductLsIsMutable();
                    this.productLs_.remove(index);
                    onChanged();
                } else {
                    this.productLsBuilder_.remove(index);
                }
                return this;
            }

            public Farm.Product.Builder getProductLsBuilder(int index) {
                return (Farm.Product.Builder) getProductLsFieldBuilder().getBuilder(index);
            }

            public Farm.ProductOrBuilder getProductLsOrBuilder(int index) {
                if (this.productLsBuilder_ == null)
                    return this.productLs_.get(index);
                return (Farm.ProductOrBuilder) this.productLsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Farm.ProductOrBuilder> getProductLsOrBuilderList() {
                if (this.productLsBuilder_ != null)
                    return this.productLsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.productLs_);
            }

            public Farm.Product.Builder addProductLsBuilder() {
                return (Farm.Product.Builder) getProductLsFieldBuilder().addBuilder(Farm.Product.getDefaultInstance());
            }

            public Farm.Product.Builder addProductLsBuilder(int index) {
                return (Farm.Product.Builder) getProductLsFieldBuilder().addBuilder(index, Farm.Product.getDefaultInstance());
            }

            public List<Farm.Product.Builder> getProductLsBuilderList() {
                return getProductLsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Farm.Product, Farm.Product.Builder, Farm.ProductOrBuilder> getProductLsFieldBuilder() {
                if (this.productLsBuilder_ == null) {
                    this.productLsBuilder_ = new RepeatedFieldBuilder(this.productLs_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.productLs_ = null;
                }
                return this.productLsBuilder_;
            }

            public boolean hasExp() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getExp() {
                return this.exp_;
            }

            public Builder setExp(int value) {
                this.bitField0_ |= 0x20;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.exp_ = 0;
                onChanged();
                return this;
            }

            private void ensureRecordInfoLsIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.recordInfoLs_ = new ArrayList<>(this.recordInfoLs_);
                    this.bitField0_ |= 0x40;
                }
            }

            public List<Farm.RecordInfo> getRecordInfoLsList() {
                if (this.recordInfoLsBuilder_ == null)
                    return Collections.unmodifiableList(this.recordInfoLs_);
                return this.recordInfoLsBuilder_.getMessageList();
            }

            public int getRecordInfoLsCount() {
                if (this.recordInfoLsBuilder_ == null)
                    return this.recordInfoLs_.size();
                return this.recordInfoLsBuilder_.getCount();
            }

            public Farm.RecordInfo getRecordInfoLs(int index) {
                if (this.recordInfoLsBuilder_ == null)
                    return this.recordInfoLs_.get(index);
                return (Farm.RecordInfo) this.recordInfoLsBuilder_.getMessage(index);
            }

            public Builder setRecordInfoLs(int index, Farm.RecordInfo value) {
                if (this.recordInfoLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.set(index, value);
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setRecordInfoLs(int index, Farm.RecordInfo.Builder builderForValue) {
                if (this.recordInfoLsBuilder_ == null) {
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRecordInfoLs(Farm.RecordInfo value) {
                if (this.recordInfoLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.add(value);
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addRecordInfoLs(int index, Farm.RecordInfo value) {
                if (this.recordInfoLsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.add(index, value);
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addRecordInfoLs(Farm.RecordInfo.Builder builderForValue) {
                if (this.recordInfoLsBuilder_ == null) {
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRecordInfoLs(int index, Farm.RecordInfo.Builder builderForValue) {
                if (this.recordInfoLsBuilder_ == null) {
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRecordInfoLs(Iterable<? extends Farm.RecordInfo> values) {
                if (this.recordInfoLsBuilder_ == null) {
                    ensureRecordInfoLsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.recordInfoLs_);
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRecordInfoLs() {
                if (this.recordInfoLsBuilder_ == null) {
                    this.recordInfoLs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.clear();
                }
                return this;
            }

            public Builder removeRecordInfoLs(int index) {
                if (this.recordInfoLsBuilder_ == null) {
                    ensureRecordInfoLsIsMutable();
                    this.recordInfoLs_.remove(index);
                    onChanged();
                } else {
                    this.recordInfoLsBuilder_.remove(index);
                }
                return this;
            }

            public Farm.RecordInfo.Builder getRecordInfoLsBuilder(int index) {
                return (Farm.RecordInfo.Builder) getRecordInfoLsFieldBuilder().getBuilder(index);
            }

            public Farm.RecordInfoOrBuilder getRecordInfoLsOrBuilder(int index) {
                if (this.recordInfoLsBuilder_ == null)
                    return this.recordInfoLs_.get(index);
                return (Farm.RecordInfoOrBuilder) this.recordInfoLsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Farm.RecordInfoOrBuilder> getRecordInfoLsOrBuilderList() {
                if (this.recordInfoLsBuilder_ != null)
                    return this.recordInfoLsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.recordInfoLs_);
            }

            public Farm.RecordInfo.Builder addRecordInfoLsBuilder() {
                return (Farm.RecordInfo.Builder) getRecordInfoLsFieldBuilder().addBuilder(Farm.RecordInfo.getDefaultInstance());
            }

            public Farm.RecordInfo.Builder addRecordInfoLsBuilder(int index) {
                return (Farm.RecordInfo.Builder) getRecordInfoLsFieldBuilder().addBuilder(index, Farm.RecordInfo.getDefaultInstance());
            }

            public List<Farm.RecordInfo.Builder> getRecordInfoLsBuilderList() {
                return getRecordInfoLsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Farm.RecordInfo, Farm.RecordInfo.Builder, Farm.RecordInfoOrBuilder> getRecordInfoLsFieldBuilder() {
                if (this.recordInfoLsBuilder_ == null) {
                    this.recordInfoLsBuilder_ = new RepeatedFieldBuilder(this.recordInfoLs_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
                    this.recordInfoLs_ = null;
                }
                return this.recordInfoLsBuilder_;
            }
        }
    }

    public static final class FriendFarmInfoRequest extends GeneratedMessage implements FriendFarmInfoRequestOrBuilder {
        private static final FriendFarmInfoRequest defaultInstance = new FriendFarmInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private FriendFarmInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FriendFarmInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FriendFarmInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FriendFarmInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FriendFarmInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.playerId_ = bs;
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
            return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendFarmInfoRequest.class, Builder.class);
        }

        public static Parser<FriendFarmInfoRequest> PARSER = (Parser<FriendFarmInfoRequest>) new AbstractParser<FriendFarmInfoRequest>() {
            public FarmHandler.FriendFarmInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.FriendFarmInfoRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERID_FIELD_NUMBER = 1;
        private Object playerId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FriendFarmInfoRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerId_ = s;
            return s;
        }

        public ByteString getPlayerIdBytes() {
            Object ref = this.playerId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.playerId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getPlayerIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getPlayerIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FriendFarmInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(data);
        }

        public static FriendFarmInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendFarmInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(data);
        }

        public static FriendFarmInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendFarmInfoRequest parseFrom(InputStream input) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(input);
        }

        public static FriendFarmInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FriendFarmInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static FriendFarmInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FriendFarmInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(input);
        }

        public static FriendFarmInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FriendFarmInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.FriendFarmInfoRequestOrBuilder {
            private int bitField0_;
            private Object playerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.FriendFarmInfoRequest.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.FriendFarmInfoRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoRequest_descriptor;
            }

            public FarmHandler.FriendFarmInfoRequest getDefaultInstanceForType() {
                return FarmHandler.FriendFarmInfoRequest.getDefaultInstance();
            }

            public FarmHandler.FriendFarmInfoRequest build() {
                FarmHandler.FriendFarmInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.FriendFarmInfoRequest buildPartial() {
                FarmHandler.FriendFarmInfoRequest result = new FarmHandler.FriendFarmInfoRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.playerId_ = this.playerId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.FriendFarmInfoRequest)
                    return mergeFrom((FarmHandler.FriendFarmInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.FriendFarmInfoRequest other) {
                if (other == FarmHandler.FriendFarmInfoRequest.getDefaultInstance()) return this;
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.FriendFarmInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.FriendFarmInfoRequest) FarmHandler.FriendFarmInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.FriendFarmInfoRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getPlayerId() {
                Object ref = this.playerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.playerId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPlayerIdBytes() {
                Object ref = this.playerId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPlayerId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = FarmHandler.FriendFarmInfoRequest.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FriendFarmInfoResponse
            extends GeneratedMessage
            implements FriendFarmInfoResponseOrBuilder {
        private static final FriendFarmInfoResponse defaultInstance = new FriendFarmInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private FriendFarmInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FriendFarmInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FriendFarmInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FriendFarmInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FriendFarmInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Farm.PlayerInfo.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.playerInfo_.toBuilder();
                            this.playerInfo_ = (Farm.PlayerInfo) input.readMessage(Farm.PlayerInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.playerInfo_);
                                this.playerInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
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
            return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendFarmInfoResponse.class, Builder.class);
        }

        public static Parser<FriendFarmInfoResponse> PARSER = (Parser<FriendFarmInfoResponse>) new AbstractParser<FriendFarmInfoResponse>() {
            public FarmHandler.FriendFarmInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.FriendFarmInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PLAYERINFO_FIELD_NUMBER = 3;
        private Farm.PlayerInfo playerInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FriendFarmInfoResponse> getParserForType() {
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

        public boolean hasPlayerInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public Farm.PlayerInfo getPlayerInfo() {
            return this.playerInfo_;
        }

        public Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder() {
            return this.playerInfo_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasPlayerInfo() && !getPlayerInfo().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.playerInfo_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.playerInfo_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FriendFarmInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(data);
        }

        public static FriendFarmInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendFarmInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(data);
        }

        public static FriendFarmInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendFarmInfoResponse parseFrom(InputStream input) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(input);
        }

        public static FriendFarmInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FriendFarmInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FriendFarmInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FriendFarmInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(input);
        }

        public static FriendFarmInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendFarmInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FriendFarmInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.FriendFarmInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Farm.PlayerInfo playerInfo_;
            private SingleFieldBuilder<Farm.PlayerInfo, Farm.PlayerInfo.Builder, Farm.PlayerInfoOrBuilder> playerInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.FriendFarmInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.FriendFarmInfoResponse.alwaysUseFieldBuilders) getPlayerInfoFieldBuilder();
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
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                } else {
                    this.playerInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_FriendFarmInfoResponse_descriptor;
            }

            public FarmHandler.FriendFarmInfoResponse getDefaultInstanceForType() {
                return FarmHandler.FriendFarmInfoResponse.getDefaultInstance();
            }

            public FarmHandler.FriendFarmInfoResponse build() {
                FarmHandler.FriendFarmInfoResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.FriendFarmInfoResponse buildPartial() {
                FarmHandler.FriendFarmInfoResponse result = new FarmHandler.FriendFarmInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.playerInfoBuilder_ == null) {
                    result.playerInfo_ = this.playerInfo_;
                } else {
                    result.playerInfo_ = (Farm.PlayerInfo) this.playerInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.FriendFarmInfoResponse)
                    return mergeFrom((FarmHandler.FriendFarmInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.FriendFarmInfoResponse other) {
                if (other == FarmHandler.FriendFarmInfoResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasPlayerInfo()) mergePlayerInfo(other.getPlayerInfo());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasPlayerInfo() && !getPlayerInfo().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.FriendFarmInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.FriendFarmInfoResponse) FarmHandler.FriendFarmInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.FriendFarmInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.FriendFarmInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPlayerInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public Farm.PlayerInfo getPlayerInfo() {
                if (this.playerInfoBuilder_ == null) return this.playerInfo_;
                return (Farm.PlayerInfo) this.playerInfoBuilder_.getMessage();
            }

            public Builder setPlayerInfo(Farm.PlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.playerInfo_ = value;
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPlayerInfo(Farm.PlayerInfo.Builder builderForValue) {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePlayerInfo(Farm.PlayerInfo value) {
                if (this.playerInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.playerInfo_ != Farm.PlayerInfo.getDefaultInstance()) {
                        this.playerInfo_ = Farm.PlayerInfo.newBuilder(this.playerInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.playerInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.playerInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPlayerInfo() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfo_ = Farm.PlayerInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.playerInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Farm.PlayerInfo.Builder getPlayerInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (Farm.PlayerInfo.Builder) getPlayerInfoFieldBuilder().getBuilder();
            }

            public Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder() {
                if (this.playerInfoBuilder_ != null)
                    return (Farm.PlayerInfoOrBuilder) this.playerInfoBuilder_.getMessageOrBuilder();
                return this.playerInfo_;
            }

            private SingleFieldBuilder<Farm.PlayerInfo, Farm.PlayerInfo.Builder, Farm.PlayerInfoOrBuilder> getPlayerInfoFieldBuilder() {
                if (this.playerInfoBuilder_ == null) {
                    this.playerInfoBuilder_ = new SingleFieldBuilder(getPlayerInfo(), getParentForChildren(), isClean());
                    this.playerInfo_ = null;
                }
                return this.playerInfoBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FriendLsRequest
            extends GeneratedMessage
            implements FriendLsRequestOrBuilder {
        private static final FriendLsRequest defaultInstance = new FriendLsRequest(true);
        private final UnknownFieldSet unknownFields;

        private FriendLsRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FriendLsRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FriendLsRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FriendLsRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FriendLsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_FriendLsRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_FriendLsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendLsRequest.class, Builder.class);
        }

        public static Parser<FriendLsRequest> PARSER = (Parser<FriendLsRequest>) new AbstractParser<FriendLsRequest>() {
            public FarmHandler.FriendLsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.FriendLsRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FriendLsRequest> getParserForType() {
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

        public static FriendLsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FriendLsRequest) PARSER.parseFrom(data);
        }

        public static FriendLsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendLsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendLsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FriendLsRequest) PARSER.parseFrom(data);
        }

        public static FriendLsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendLsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendLsRequest parseFrom(InputStream input) throws IOException {
            return (FriendLsRequest) PARSER.parseFrom(input);
        }

        public static FriendLsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FriendLsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FriendLsRequest) PARSER.parseDelimitedFrom(input);
        }

        public static FriendLsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FriendLsRequest parseFrom(CodedInputStream input) throws IOException {
            return (FriendLsRequest) PARSER.parseFrom(input);
        }

        public static FriendLsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FriendLsRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.FriendLsRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_FriendLsRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_FriendLsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.FriendLsRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.FriendLsRequest.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_FriendLsRequest_descriptor;
            }

            public FarmHandler.FriendLsRequest getDefaultInstanceForType() {
                return FarmHandler.FriendLsRequest.getDefaultInstance();
            }

            public FarmHandler.FriendLsRequest build() {
                FarmHandler.FriendLsRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.FriendLsRequest buildPartial() {
                FarmHandler.FriendLsRequest result = new FarmHandler.FriendLsRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.FriendLsRequest) return mergeFrom((FarmHandler.FriendLsRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.FriendLsRequest other) {
                if (other == FarmHandler.FriendLsRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.FriendLsRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.FriendLsRequest) FarmHandler.FriendLsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.FriendLsRequest) e.getUnfinishedMessage();
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


    public static final class FriendLsResponse
            extends GeneratedMessage
            implements FriendLsResponseOrBuilder {
        private static final FriendLsResponse defaultInstance = new FriendLsResponse(true);
        private final UnknownFieldSet unknownFields;

        private FriendLsResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FriendLsResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FriendLsResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FriendLsResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FriendLsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.playerSummary_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.playerSummary_.add(input.readMessage(Farm.PlayerSummary.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.playerSummary_ = Collections.unmodifiableList(this.playerSummary_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FarmHandler.internal_static_pomelo_farm_FriendLsResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_FriendLsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendLsResponse.class, Builder.class);
        }

        public static Parser<FriendLsResponse> PARSER = (Parser<FriendLsResponse>) new AbstractParser<FriendLsResponse>() {
            public FarmHandler.FriendLsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.FriendLsResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PLAYERSUMMARY_FIELD_NUMBER = 3;
        private List<Farm.PlayerSummary> playerSummary_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FriendLsResponse> getParserForType() {
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

        public List<Farm.PlayerSummary> getPlayerSummaryList() {
            return this.playerSummary_;
        }

        public List<? extends Farm.PlayerSummaryOrBuilder> getPlayerSummaryOrBuilderList() {
            return (List) this.playerSummary_;
        }

        public int getPlayerSummaryCount() {
            return this.playerSummary_.size();
        }

        public Farm.PlayerSummary getPlayerSummary(int index) {
            return this.playerSummary_.get(index);
        }

        public Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder(int index) {
            return this.playerSummary_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.playerSummary_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getPlayerSummaryCount(); i++) {
                if (!getPlayerSummary(i).isInitialized()) {
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
            for (int i = 0; i < this.playerSummary_.size(); i++)
                output.writeMessage(3, (MessageLite) this.playerSummary_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.playerSummary_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.playerSummary_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FriendLsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FriendLsResponse) PARSER.parseFrom(data);
        }

        public static FriendLsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendLsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendLsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FriendLsResponse) PARSER.parseFrom(data);
        }

        public static FriendLsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FriendLsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FriendLsResponse parseFrom(InputStream input) throws IOException {
            return (FriendLsResponse) PARSER.parseFrom(input);
        }

        public static FriendLsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FriendLsResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FriendLsResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FriendLsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FriendLsResponse parseFrom(CodedInputStream input) throws IOException {
            return (FriendLsResponse) PARSER.parseFrom(input);
        }

        public static FriendLsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FriendLsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FriendLsResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.FriendLsResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<Farm.PlayerSummary> playerSummary_;
            private RepeatedFieldBuilder<Farm.PlayerSummary, Farm.PlayerSummary.Builder, Farm.PlayerSummaryOrBuilder> playerSummaryBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_FriendLsResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_FriendLsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.FriendLsResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.playerSummary_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.playerSummary_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.FriendLsResponse.alwaysUseFieldBuilders) getPlayerSummaryFieldBuilder();
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
                if (this.playerSummaryBuilder_ == null) {
                    this.playerSummary_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.playerSummaryBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_FriendLsResponse_descriptor;
            }

            public FarmHandler.FriendLsResponse getDefaultInstanceForType() {
                return FarmHandler.FriendLsResponse.getDefaultInstance();
            }

            public FarmHandler.FriendLsResponse build() {
                FarmHandler.FriendLsResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.FriendLsResponse buildPartial() {
                FarmHandler.FriendLsResponse result = new FarmHandler.FriendLsResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.playerSummaryBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.playerSummary_ = Collections.unmodifiableList(this.playerSummary_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.playerSummary_ = this.playerSummary_;
                } else {
                    result.playerSummary_ = this.playerSummaryBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.FriendLsResponse)
                    return mergeFrom((FarmHandler.FriendLsResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.FriendLsResponse other) {
                if (other == FarmHandler.FriendLsResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.playerSummaryBuilder_ == null) {
                    if (!other.playerSummary_.isEmpty()) {
                        if (this.playerSummary_.isEmpty()) {
                            this.playerSummary_ = other.playerSummary_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensurePlayerSummaryIsMutable();
                            this.playerSummary_.addAll(other.playerSummary_);
                        }
                        onChanged();
                    }
                } else if (!other.playerSummary_.isEmpty()) {
                    if (this.playerSummaryBuilder_.isEmpty()) {
                        this.playerSummaryBuilder_.dispose();
                        this.playerSummaryBuilder_ = null;
                        this.playerSummary_ = other.playerSummary_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.playerSummaryBuilder_ = FarmHandler.FriendLsResponse.alwaysUseFieldBuilders ? getPlayerSummaryFieldBuilder() : null;
                    } else {
                        this.playerSummaryBuilder_.addAllMessages(other.playerSummary_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getPlayerSummaryCount(); i++) {
                    if (!getPlayerSummary(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.FriendLsResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.FriendLsResponse) FarmHandler.FriendLsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.FriendLsResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.FriendLsResponse.getDefaultInstance().getS2CMsg();
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

            private void ensurePlayerSummaryIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.playerSummary_ = new ArrayList<>(this.playerSummary_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Farm.PlayerSummary> getPlayerSummaryList() {
                if (this.playerSummaryBuilder_ == null) return Collections.unmodifiableList(this.playerSummary_);
                return this.playerSummaryBuilder_.getMessageList();
            }

            public int getPlayerSummaryCount() {
                if (this.playerSummaryBuilder_ == null) return this.playerSummary_.size();
                return this.playerSummaryBuilder_.getCount();
            }

            public Farm.PlayerSummary getPlayerSummary(int index) {
                if (this.playerSummaryBuilder_ == null) return this.playerSummary_.get(index);
                return (Farm.PlayerSummary) this.playerSummaryBuilder_.getMessage(index);
            }

            public Builder setPlayerSummary(int index, Farm.PlayerSummary value) {
                if (this.playerSummaryBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.set(index, value);
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setPlayerSummary(int index, Farm.PlayerSummary.Builder builderForValue) {
                if (this.playerSummaryBuilder_ == null) {
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerSummary(Farm.PlayerSummary value) {
                if (this.playerSummaryBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.add(value);
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addPlayerSummary(int index, Farm.PlayerSummary value) {
                if (this.playerSummaryBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.add(index, value);
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addPlayerSummary(Farm.PlayerSummary.Builder builderForValue) {
                if (this.playerSummaryBuilder_ == null) {
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerSummary(int index, Farm.PlayerSummary.Builder builderForValue) {
                if (this.playerSummaryBuilder_ == null) {
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerSummary(Iterable<? extends Farm.PlayerSummary> values) {
                if (this.playerSummaryBuilder_ == null) {
                    ensurePlayerSummaryIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.playerSummary_);
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerSummary() {
                if (this.playerSummaryBuilder_ == null) {
                    this.playerSummary_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerSummary(int index) {
                if (this.playerSummaryBuilder_ == null) {
                    ensurePlayerSummaryIsMutable();
                    this.playerSummary_.remove(index);
                    onChanged();
                } else {
                    this.playerSummaryBuilder_.remove(index);
                }
                return this;
            }

            public Farm.PlayerSummary.Builder getPlayerSummaryBuilder(int index) {
                return (Farm.PlayerSummary.Builder) getPlayerSummaryFieldBuilder().getBuilder(index);
            }

            public Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder(int index) {
                if (this.playerSummaryBuilder_ == null) return this.playerSummary_.get(index);
                return (Farm.PlayerSummaryOrBuilder) this.playerSummaryBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Farm.PlayerSummaryOrBuilder> getPlayerSummaryOrBuilderList() {
                if (this.playerSummaryBuilder_ != null) return this.playerSummaryBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.playerSummary_);
            }

            public Farm.PlayerSummary.Builder addPlayerSummaryBuilder() {
                return (Farm.PlayerSummary.Builder) getPlayerSummaryFieldBuilder().addBuilder(Farm.PlayerSummary.getDefaultInstance());
            }

            public Farm.PlayerSummary.Builder addPlayerSummaryBuilder(int index) {
                return (Farm.PlayerSummary.Builder) getPlayerSummaryFieldBuilder().addBuilder(index, Farm.PlayerSummary.getDefaultInstance());
            }

            public List<Farm.PlayerSummary.Builder> getPlayerSummaryBuilderList() {
                return getPlayerSummaryFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Farm.PlayerSummary, Farm.PlayerSummary.Builder, Farm.PlayerSummaryOrBuilder> getPlayerSummaryFieldBuilder() {
                if (this.playerSummaryBuilder_ == null) {
                    this.playerSummaryBuilder_ = new RepeatedFieldBuilder(this.playerSummary_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.playerSummary_ = null;
                }
                return this.playerSummaryBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class OpenRequest
            extends GeneratedMessage
            implements OpenRequestOrBuilder {
        private static final OpenRequest defaultInstance = new OpenRequest(true);
        private final UnknownFieldSet unknownFields;

        private OpenRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenRequest getDefaultInstance() {
            return defaultInstance;
        }

        public OpenRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_OpenRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_OpenRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenRequest.class, Builder.class);
        }

        public static Parser<OpenRequest> PARSER = (Parser<OpenRequest>) new AbstractParser<OpenRequest>() {
            public FarmHandler.OpenRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.OpenRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        private void initFields() {
            this.blockId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OpenRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenRequest) PARSER.parseFrom(data);
        }

        public static OpenRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenRequest) PARSER.parseFrom(data);
        }

        public static OpenRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenRequest parseFrom(InputStream input) throws IOException {
            return (OpenRequest) PARSER.parseFrom(input);
        }

        public static OpenRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OpenRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenRequest) PARSER.parseDelimitedFrom(input);
        }

        public static OpenRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OpenRequest parseFrom(CodedInputStream input) throws IOException {
            return (OpenRequest) PARSER.parseFrom(input);
        }

        public static OpenRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OpenRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.OpenRequestOrBuilder {
            private int bitField0_;
            private int blockId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_OpenRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_OpenRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.OpenRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.OpenRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_OpenRequest_descriptor;
            }

            public FarmHandler.OpenRequest getDefaultInstanceForType() {
                return FarmHandler.OpenRequest.getDefaultInstance();
            }

            public FarmHandler.OpenRequest build() {
                FarmHandler.OpenRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.OpenRequest buildPartial() {
                FarmHandler.OpenRequest result = new FarmHandler.OpenRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.OpenRequest) return mergeFrom((FarmHandler.OpenRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.OpenRequest other) {
                if (other == FarmHandler.OpenRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.OpenRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.OpenRequest) FarmHandler.OpenRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.OpenRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class OpenResponse
            extends GeneratedMessage
            implements OpenResponseOrBuilder {
        private static final OpenResponse defaultInstance = new OpenResponse(true);
        private final UnknownFieldSet unknownFields;

        private OpenResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenResponse getDefaultInstance() {
            return defaultInstance;
        }

        public OpenResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_OpenResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_OpenResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenResponse.class, Builder.class);
        }

        public static Parser<OpenResponse> PARSER = (Parser<OpenResponse>) new AbstractParser<OpenResponse>() {
            public FarmHandler.OpenResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.OpenResponse(input, extensionRegistry);
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

        public Parser<OpenResponse> getParserForType() {
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

        public static OpenResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenResponse) PARSER.parseFrom(data);
        }

        public static OpenResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenResponse) PARSER.parseFrom(data);
        }

        public static OpenResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenResponse parseFrom(InputStream input) throws IOException {
            return (OpenResponse) PARSER.parseFrom(input);
        }

        public static OpenResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OpenResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenResponse) PARSER.parseDelimitedFrom(input);
        }

        public static OpenResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OpenResponse parseFrom(CodedInputStream input) throws IOException {
            return (OpenResponse) PARSER.parseFrom(input);
        }

        public static OpenResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OpenResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.OpenResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_OpenResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_OpenResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.OpenResponse.class, Builder.class);
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
                if (FarmHandler.OpenResponse.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_OpenResponse_descriptor;
            }

            public FarmHandler.OpenResponse getDefaultInstanceForType() {
                return FarmHandler.OpenResponse.getDefaultInstance();
            }

            public FarmHandler.OpenResponse build() {
                FarmHandler.OpenResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.OpenResponse buildPartial() {
                FarmHandler.OpenResponse result = new FarmHandler.OpenResponse(this);
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
                if (other instanceof FarmHandler.OpenResponse) return mergeFrom((FarmHandler.OpenResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.OpenResponse other) {
                if (other == FarmHandler.OpenResponse.getDefaultInstance()) return this;
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
                FarmHandler.OpenResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.OpenResponse) FarmHandler.OpenResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.OpenResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.OpenResponse.getDefaultInstance().getS2CMsg();
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


    public static final class SowRequest
            extends GeneratedMessage
            implements SowRequestOrBuilder {
        private static final SowRequest defaultInstance = new SowRequest(true);
        private final UnknownFieldSet unknownFields;

        private SowRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SowRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SowRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SowRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SowRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.seedCode_ = bs;
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
            return FarmHandler.internal_static_pomelo_farm_SowRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_SowRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SowRequest.class, Builder.class);
        }

        public static Parser<SowRequest> PARSER = (Parser<SowRequest>) new AbstractParser<SowRequest>() {
            public FarmHandler.SowRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.SowRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        public static final int SEEDCODE_FIELD_NUMBER = 2;
        private Object seedCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SowRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        public boolean hasSeedCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getSeedCode() {
            Object ref = this.seedCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.seedCode_ = s;
            return s;
        }

        public ByteString getSeedCodeBytes() {
            Object ref = this.seedCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.seedCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.blockId_ = 0;
            this.seedCode_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSeedCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getSeedCodeBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getSeedCodeBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SowRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SowRequest) PARSER.parseFrom(data);
        }

        public static SowRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SowRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SowRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SowRequest) PARSER.parseFrom(data);
        }

        public static SowRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SowRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SowRequest parseFrom(InputStream input) throws IOException {
            return (SowRequest) PARSER.parseFrom(input);
        }

        public static SowRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SowRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SowRequest) PARSER.parseDelimitedFrom(input);
        }

        public static SowRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SowRequest parseFrom(CodedInputStream input) throws IOException {
            return (SowRequest) PARSER.parseFrom(input);
        }

        public static SowRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SowRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.SowRequestOrBuilder {
            private int bitField0_;
            private int blockId_;
            private Object seedCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_SowRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_SowRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.SowRequest.class, Builder.class);
            }

            private Builder() {
                this.seedCode_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.seedCode_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.SowRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.seedCode_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_SowRequest_descriptor;
            }

            public FarmHandler.SowRequest getDefaultInstanceForType() {
                return FarmHandler.SowRequest.getDefaultInstance();
            }

            public FarmHandler.SowRequest build() {
                FarmHandler.SowRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.SowRequest buildPartial() {
                FarmHandler.SowRequest result = new FarmHandler.SowRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.seedCode_ = this.seedCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.SowRequest) return mergeFrom((FarmHandler.SowRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.SowRequest other) {
                if (other == FarmHandler.SowRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                if (other.hasSeedCode()) {
                    this.bitField0_ |= 0x2;
                    this.seedCode_ = other.seedCode_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                if (!hasSeedCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.SowRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.SowRequest) FarmHandler.SowRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.SowRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSeedCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getSeedCode() {
                Object ref = this.seedCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.seedCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSeedCodeBytes() {
                Object ref = this.seedCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.seedCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSeedCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.seedCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearSeedCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.seedCode_ = FarmHandler.SowRequest.getDefaultInstance().getSeedCode();
                onChanged();
                return this;
            }

            public Builder setSeedCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.seedCode_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class SowResponse
            extends GeneratedMessage
            implements SowResponseOrBuilder {
        private static final SowResponse defaultInstance = new SowResponse(true);
        private final UnknownFieldSet unknownFields;

        private SowResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SowResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SowResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SowResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SowResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_SowResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_SowResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SowResponse.class, Builder.class);
        }

        public static Parser<SowResponse> PARSER = (Parser<SowResponse>) new AbstractParser<SowResponse>() {
            public FarmHandler.SowResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.SowResponse(input, extensionRegistry);
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

        public Parser<SowResponse> getParserForType() {
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

        public static SowResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SowResponse) PARSER.parseFrom(data);
        }

        public static SowResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SowResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SowResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SowResponse) PARSER.parseFrom(data);
        }

        public static SowResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SowResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SowResponse parseFrom(InputStream input) throws IOException {
            return (SowResponse) PARSER.parseFrom(input);
        }

        public static SowResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SowResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SowResponse) PARSER.parseDelimitedFrom(input);
        }

        public static SowResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SowResponse parseFrom(CodedInputStream input) throws IOException {
            return (SowResponse) PARSER.parseFrom(input);
        }

        public static SowResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SowResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SowResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.SowResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_SowResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_SowResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.SowResponse.class, Builder.class);
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
                if (FarmHandler.SowResponse.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_SowResponse_descriptor;
            }

            public FarmHandler.SowResponse getDefaultInstanceForType() {
                return FarmHandler.SowResponse.getDefaultInstance();
            }

            public FarmHandler.SowResponse build() {
                FarmHandler.SowResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.SowResponse buildPartial() {
                FarmHandler.SowResponse result = new FarmHandler.SowResponse(this);
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
                if (other instanceof FarmHandler.SowResponse) return mergeFrom((FarmHandler.SowResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.SowResponse other) {
                if (other == FarmHandler.SowResponse.getDefaultInstance()) return this;
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
                FarmHandler.SowResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.SowResponse) FarmHandler.SowResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.SowResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.SowResponse.getDefaultInstance().getS2CMsg();
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


    public static final class CultivateFriendRequest
            extends GeneratedMessage
            implements CultivateFriendRequestOrBuilder {
        private static final CultivateFriendRequest defaultInstance = new CultivateFriendRequest(true);
        private final UnknownFieldSet unknownFields;

        private CultivateFriendRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CultivateFriendRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CultivateFriendRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CultivateFriendRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CultivateFriendRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.cultivateType_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.friendId_ = bs;
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
            return FarmHandler.internal_static_pomelo_farm_CultivateFriendRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_CultivateFriendRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CultivateFriendRequest.class, Builder.class);
        }

        public static Parser<CultivateFriendRequest> PARSER = (Parser<CultivateFriendRequest>) new AbstractParser<CultivateFriendRequest>() {
            public FarmHandler.CultivateFriendRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.CultivateFriendRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        public static final int CULTIVATETYPE_FIELD_NUMBER = 2;
        private int cultivateType_;
        public static final int FRIENDID_FIELD_NUMBER = 3;
        private Object friendId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CultivateFriendRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        public boolean hasCultivateType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getCultivateType() {
            return this.cultivateType_;
        }

        public boolean hasFriendId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getFriendId() {
            Object ref = this.friendId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.friendId_ = s;
            return s;
        }

        public ByteString getFriendIdBytes() {
            Object ref = this.friendId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.friendId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.blockId_ = 0;
            this.cultivateType_ = 0;
            this.friendId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCultivateType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.cultivateType_);
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getFriendIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.cultivateType_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getFriendIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static CultivateFriendRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CultivateFriendRequest) PARSER.parseFrom(data);
        }

        public static CultivateFriendRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateFriendRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateFriendRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CultivateFriendRequest) PARSER.parseFrom(data);
        }

        public static CultivateFriendRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateFriendRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateFriendRequest parseFrom(InputStream input) throws IOException {
            return (CultivateFriendRequest) PARSER.parseFrom(input);
        }

        public static CultivateFriendRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CultivateFriendRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CultivateFriendRequest) PARSER.parseDelimitedFrom(input);
        }

        public static CultivateFriendRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CultivateFriendRequest parseFrom(CodedInputStream input) throws IOException {
            return (CultivateFriendRequest) PARSER.parseFrom(input);
        }

        public static CultivateFriendRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CultivateFriendRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.CultivateFriendRequestOrBuilder {
            private int bitField0_;
            private int blockId_;
            private int cultivateType_;
            private Object friendId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.CultivateFriendRequest.class, Builder.class);
            }

            private Builder() {
                this.friendId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.friendId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.CultivateFriendRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.cultivateType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.friendId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendRequest_descriptor;
            }

            public FarmHandler.CultivateFriendRequest getDefaultInstanceForType() {
                return FarmHandler.CultivateFriendRequest.getDefaultInstance();
            }

            public FarmHandler.CultivateFriendRequest build() {
                FarmHandler.CultivateFriendRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.CultivateFriendRequest buildPartial() {
                FarmHandler.CultivateFriendRequest result = new FarmHandler.CultivateFriendRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.cultivateType_ = this.cultivateType_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.friendId_ = this.friendId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.CultivateFriendRequest)
                    return mergeFrom((FarmHandler.CultivateFriendRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.CultivateFriendRequest other) {
                if (other == FarmHandler.CultivateFriendRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                if (other.hasCultivateType()) setCultivateType(other.getCultivateType());
                if (other.hasFriendId()) {
                    this.bitField0_ |= 0x4;
                    this.friendId_ = other.friendId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                if (!hasCultivateType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.CultivateFriendRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.CultivateFriendRequest) FarmHandler.CultivateFriendRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.CultivateFriendRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCultivateType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getCultivateType() {
                return this.cultivateType_;
            }

            public Builder setCultivateType(int value) {
                this.bitField0_ |= 0x2;
                this.cultivateType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCultivateType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cultivateType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFriendId() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getFriendId() {
                Object ref = this.friendId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.friendId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFriendIdBytes() {
                Object ref = this.friendId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.friendId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFriendId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.friendId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFriendId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.friendId_ = FarmHandler.CultivateFriendRequest.getDefaultInstance().getFriendId();
                onChanged();
                return this;
            }

            public Builder setFriendIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.friendId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class CultivateFriendResponse
            extends GeneratedMessage
            implements CultivateFriendResponseOrBuilder {
        private static final CultivateFriendResponse defaultInstance = new CultivateFriendResponse(true);
        private final UnknownFieldSet unknownFields;

        private CultivateFriendResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CultivateFriendResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CultivateFriendResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CultivateFriendResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CultivateFriendResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.fate_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_CultivateFriendResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_CultivateFriendResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CultivateFriendResponse.class, Builder.class);
        }

        public static Parser<CultivateFriendResponse> PARSER = (Parser<CultivateFriendResponse>) new AbstractParser<CultivateFriendResponse>() {
            public FarmHandler.CultivateFriendResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.CultivateFriendResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int FATE_FIELD_NUMBER = 3;
        private int fate_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CultivateFriendResponse> getParserForType() {
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

        public boolean hasFate() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getFate() {
            return this.fate_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.fate_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.fate_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.fate_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static CultivateFriendResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CultivateFriendResponse) PARSER.parseFrom(data);
        }

        public static CultivateFriendResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateFriendResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateFriendResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CultivateFriendResponse) PARSER.parseFrom(data);
        }

        public static CultivateFriendResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateFriendResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateFriendResponse parseFrom(InputStream input) throws IOException {
            return (CultivateFriendResponse) PARSER.parseFrom(input);
        }

        public static CultivateFriendResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CultivateFriendResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CultivateFriendResponse) PARSER.parseDelimitedFrom(input);
        }

        public static CultivateFriendResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CultivateFriendResponse parseFrom(CodedInputStream input) throws IOException {
            return (CultivateFriendResponse) PARSER.parseFrom(input);
        }

        public static CultivateFriendResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateFriendResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CultivateFriendResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.CultivateFriendResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int fate_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.CultivateFriendResponse.class, Builder.class);
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
                if (FarmHandler.CultivateFriendResponse.alwaysUseFieldBuilders) ;
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
                this.fate_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_CultivateFriendResponse_descriptor;
            }

            public FarmHandler.CultivateFriendResponse getDefaultInstanceForType() {
                return FarmHandler.CultivateFriendResponse.getDefaultInstance();
            }

            public FarmHandler.CultivateFriendResponse build() {
                FarmHandler.CultivateFriendResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.CultivateFriendResponse buildPartial() {
                FarmHandler.CultivateFriendResponse result = new FarmHandler.CultivateFriendResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.fate_ = this.fate_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.CultivateFriendResponse)
                    return mergeFrom((FarmHandler.CultivateFriendResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.CultivateFriendResponse other) {
                if (other == FarmHandler.CultivateFriendResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasFate()) setFate(other.getFate());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.CultivateFriendResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.CultivateFriendResponse) FarmHandler.CultivateFriendResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.CultivateFriendResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.CultivateFriendResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasFate() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getFate() {
                return this.fate_;
            }

            public Builder setFate(int value) {
                this.bitField0_ |= 0x4;
                this.fate_ = value;
                onChanged();
                return this;
            }

            public Builder clearFate() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.fate_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class CultivateSelfRequest
            extends GeneratedMessage
            implements CultivateSelfRequestOrBuilder {
        private static final CultivateSelfRequest defaultInstance = new CultivateSelfRequest(true);
        private final UnknownFieldSet unknownFields;

        private CultivateSelfRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CultivateSelfRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CultivateSelfRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CultivateSelfRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CultivateSelfRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.cultivateType_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_CultivateSelfRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_CultivateSelfRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CultivateSelfRequest.class, Builder.class);
        }

        public static Parser<CultivateSelfRequest> PARSER = (Parser<CultivateSelfRequest>) new AbstractParser<CultivateSelfRequest>() {
            public FarmHandler.CultivateSelfRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.CultivateSelfRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        public static final int CULTIVATETYPE_FIELD_NUMBER = 2;
        private int cultivateType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CultivateSelfRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        public boolean hasCultivateType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getCultivateType() {
            return this.cultivateType_;
        }

        private void initFields() {
            this.blockId_ = 0;
            this.cultivateType_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCultivateType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.cultivateType_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.cultivateType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static CultivateSelfRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CultivateSelfRequest) PARSER.parseFrom(data);
        }

        public static CultivateSelfRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateSelfRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateSelfRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CultivateSelfRequest) PARSER.parseFrom(data);
        }

        public static CultivateSelfRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateSelfRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateSelfRequest parseFrom(InputStream input) throws IOException {
            return (CultivateSelfRequest) PARSER.parseFrom(input);
        }

        public static CultivateSelfRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CultivateSelfRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CultivateSelfRequest) PARSER.parseDelimitedFrom(input);
        }

        public static CultivateSelfRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CultivateSelfRequest parseFrom(CodedInputStream input) throws IOException {
            return (CultivateSelfRequest) PARSER.parseFrom(input);
        }

        public static CultivateSelfRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CultivateSelfRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.CultivateSelfRequestOrBuilder {
            private int bitField0_;
            private int blockId_;
            private int cultivateType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.CultivateSelfRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.CultivateSelfRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.cultivateType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfRequest_descriptor;
            }

            public FarmHandler.CultivateSelfRequest getDefaultInstanceForType() {
                return FarmHandler.CultivateSelfRequest.getDefaultInstance();
            }

            public FarmHandler.CultivateSelfRequest build() {
                FarmHandler.CultivateSelfRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.CultivateSelfRequest buildPartial() {
                FarmHandler.CultivateSelfRequest result = new FarmHandler.CultivateSelfRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.cultivateType_ = this.cultivateType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.CultivateSelfRequest)
                    return mergeFrom((FarmHandler.CultivateSelfRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.CultivateSelfRequest other) {
                if (other == FarmHandler.CultivateSelfRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                if (other.hasCultivateType()) setCultivateType(other.getCultivateType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                if (!hasCultivateType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.CultivateSelfRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.CultivateSelfRequest) FarmHandler.CultivateSelfRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.CultivateSelfRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCultivateType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getCultivateType() {
                return this.cultivateType_;
            }

            public Builder setCultivateType(int value) {
                this.bitField0_ |= 0x2;
                this.cultivateType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCultivateType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.cultivateType_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class CultivateSelfResponse
            extends GeneratedMessage
            implements CultivateSelfResponseOrBuilder {
        private static final CultivateSelfResponse defaultInstance = new CultivateSelfResponse(true);
        private final UnknownFieldSet unknownFields;

        private CultivateSelfResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CultivateSelfResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CultivateSelfResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CultivateSelfResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CultivateSelfResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_CultivateSelfResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_CultivateSelfResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CultivateSelfResponse.class, Builder.class);
        }

        public static Parser<CultivateSelfResponse> PARSER = (Parser<CultivateSelfResponse>) new AbstractParser<CultivateSelfResponse>() {
            public FarmHandler.CultivateSelfResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.CultivateSelfResponse(input, extensionRegistry);
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

        public Parser<CultivateSelfResponse> getParserForType() {
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

        public static CultivateSelfResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CultivateSelfResponse) PARSER.parseFrom(data);
        }

        public static CultivateSelfResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateSelfResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateSelfResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CultivateSelfResponse) PARSER.parseFrom(data);
        }

        public static CultivateSelfResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CultivateSelfResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CultivateSelfResponse parseFrom(InputStream input) throws IOException {
            return (CultivateSelfResponse) PARSER.parseFrom(input);
        }

        public static CultivateSelfResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CultivateSelfResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CultivateSelfResponse) PARSER.parseDelimitedFrom(input);
        }

        public static CultivateSelfResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CultivateSelfResponse parseFrom(CodedInputStream input) throws IOException {
            return (CultivateSelfResponse) PARSER.parseFrom(input);
        }

        public static CultivateSelfResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CultivateSelfResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CultivateSelfResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.CultivateSelfResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.CultivateSelfResponse.class, Builder.class);
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
                if (FarmHandler.CultivateSelfResponse.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_CultivateSelfResponse_descriptor;
            }

            public FarmHandler.CultivateSelfResponse getDefaultInstanceForType() {
                return FarmHandler.CultivateSelfResponse.getDefaultInstance();
            }

            public FarmHandler.CultivateSelfResponse build() {
                FarmHandler.CultivateSelfResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.CultivateSelfResponse buildPartial() {
                FarmHandler.CultivateSelfResponse result = new FarmHandler.CultivateSelfResponse(this);
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
                if (other instanceof FarmHandler.CultivateSelfResponse)
                    return mergeFrom((FarmHandler.CultivateSelfResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.CultivateSelfResponse other) {
                if (other == FarmHandler.CultivateSelfResponse.getDefaultInstance()) return this;
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
                FarmHandler.CultivateSelfResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.CultivateSelfResponse) FarmHandler.CultivateSelfResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.CultivateSelfResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.CultivateSelfResponse.getDefaultInstance().getS2CMsg();
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


    public static final class HarvestRequest
            extends GeneratedMessage
            implements HarvestRequestOrBuilder {
        private static final HarvestRequest defaultInstance = new HarvestRequest(true);
        private final UnknownFieldSet unknownFields;

        private HarvestRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HarvestRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HarvestRequest getDefaultInstance() {
            return defaultInstance;
        }

        public HarvestRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HarvestRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_HarvestRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_HarvestRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(HarvestRequest.class, Builder.class);
        }

        public static Parser<HarvestRequest> PARSER = (Parser<HarvestRequest>) new AbstractParser<HarvestRequest>() {
            public FarmHandler.HarvestRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.HarvestRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HarvestRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        private void initFields() {
            this.blockId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static HarvestRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HarvestRequest) PARSER.parseFrom(data);
        }

        public static HarvestRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HarvestRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HarvestRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HarvestRequest) PARSER.parseFrom(data);
        }

        public static HarvestRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HarvestRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HarvestRequest parseFrom(InputStream input) throws IOException {
            return (HarvestRequest) PARSER.parseFrom(input);
        }

        public static HarvestRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static HarvestRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (HarvestRequest) PARSER.parseDelimitedFrom(input);
        }

        public static HarvestRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static HarvestRequest parseFrom(CodedInputStream input) throws IOException {
            return (HarvestRequest) PARSER.parseFrom(input);
        }

        public static HarvestRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(HarvestRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.HarvestRequestOrBuilder {
            private int bitField0_;
            private int blockId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_HarvestRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_HarvestRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.HarvestRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.HarvestRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_HarvestRequest_descriptor;
            }

            public FarmHandler.HarvestRequest getDefaultInstanceForType() {
                return FarmHandler.HarvestRequest.getDefaultInstance();
            }

            public FarmHandler.HarvestRequest build() {
                FarmHandler.HarvestRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.HarvestRequest buildPartial() {
                FarmHandler.HarvestRequest result = new FarmHandler.HarvestRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.HarvestRequest) return mergeFrom((FarmHandler.HarvestRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.HarvestRequest other) {
                if (other == FarmHandler.HarvestRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.HarvestRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.HarvestRequest) FarmHandler.HarvestRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.HarvestRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class HarvestResponse
            extends GeneratedMessage
            implements HarvestResponseOrBuilder {
        private static final HarvestResponse defaultInstance = new HarvestResponse(true);
        private final UnknownFieldSet unknownFields;

        private HarvestResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HarvestResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HarvestResponse getDefaultInstance() {
            return defaultInstance;
        }

        public HarvestResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HarvestResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Farm.Block.Builder subBuilder;
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
                            this.exp_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.lv_ = input.readInt32();
                            break;
                        case 42:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) subBuilder = this.block_.toBuilder();
                            this.block_ = (Farm.Block) input.readMessage(Farm.Block.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.block_);
                                this.block_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
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
            return FarmHandler.internal_static_pomelo_farm_HarvestResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_HarvestResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(HarvestResponse.class, Builder.class);
        }

        public static Parser<HarvestResponse> PARSER = (Parser<HarvestResponse>) new AbstractParser<HarvestResponse>() {
            public FarmHandler.HarvestResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.HarvestResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int EXP_FIELD_NUMBER = 3;
        private int exp_;
        public static final int LV_FIELD_NUMBER = 4;
        private int lv_;
        public static final int BLOCK_FIELD_NUMBER = 5;
        private Farm.Block block_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HarvestResponse> getParserForType() {
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

        public boolean hasExp() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getExp() {
            return this.exp_;
        }

        public boolean hasLv() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getLv() {
            return this.lv_;
        }

        public boolean hasBlock() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public Farm.Block getBlock() {
            return this.block_;
        }

        public Farm.BlockOrBuilder getBlockOrBuilder() {
            return this.block_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.exp_ = 0;
            this.lv_ = 0;
            this.block_ = Farm.Block.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasBlock() && !getBlock().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.exp_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.lv_);
            if ((this.bitField0_ & 0x10) == 16) output.writeMessage(5, (MessageLite) this.block_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.exp_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.lv_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.block_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static HarvestResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HarvestResponse) PARSER.parseFrom(data);
        }

        public static HarvestResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HarvestResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HarvestResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HarvestResponse) PARSER.parseFrom(data);
        }

        public static HarvestResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HarvestResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HarvestResponse parseFrom(InputStream input) throws IOException {
            return (HarvestResponse) PARSER.parseFrom(input);
        }

        public static HarvestResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static HarvestResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (HarvestResponse) PARSER.parseDelimitedFrom(input);
        }

        public static HarvestResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static HarvestResponse parseFrom(CodedInputStream input) throws IOException {
            return (HarvestResponse) PARSER.parseFrom(input);
        }

        public static HarvestResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HarvestResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(HarvestResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.HarvestResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int exp_;
            private int lv_;
            private Farm.Block block_;
            private SingleFieldBuilder<Farm.Block, Farm.Block.Builder, Farm.BlockOrBuilder> blockBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_HarvestResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_HarvestResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.HarvestResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.block_ = Farm.Block.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.block_ = Farm.Block.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.HarvestResponse.alwaysUseFieldBuilders) getBlockFieldBuilder();
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
                this.exp_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.lv_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.blockBuilder_ == null) {
                    this.block_ = Farm.Block.getDefaultInstance();
                } else {
                    this.blockBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_HarvestResponse_descriptor;
            }

            public FarmHandler.HarvestResponse getDefaultInstanceForType() {
                return FarmHandler.HarvestResponse.getDefaultInstance();
            }

            public FarmHandler.HarvestResponse build() {
                FarmHandler.HarvestResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.HarvestResponse buildPartial() {
                FarmHandler.HarvestResponse result = new FarmHandler.HarvestResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.exp_ = this.exp_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.lv_ = this.lv_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                if (this.blockBuilder_ == null) {
                    result.block_ = this.block_;
                } else {
                    result.block_ = (Farm.Block) this.blockBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.HarvestResponse) return mergeFrom((FarmHandler.HarvestResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.HarvestResponse other) {
                if (other == FarmHandler.HarvestResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasExp()) setExp(other.getExp());
                if (other.hasLv()) setLv(other.getLv());
                if (other.hasBlock()) mergeBlock(other.getBlock());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasBlock() && !getBlock().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.HarvestResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.HarvestResponse) FarmHandler.HarvestResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.HarvestResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.HarvestResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasExp() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getExp() {
                return this.exp_;
            }

            public Builder setExp(int value) {
                this.bitField0_ |= 0x4;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.exp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLv() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getLv() {
                return this.lv_;
            }

            public Builder setLv(int value) {
                this.bitField0_ |= 0x8;
                this.lv_ = value;
                onChanged();
                return this;
            }

            public Builder clearLv() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.lv_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBlock() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public Farm.Block getBlock() {
                if (this.blockBuilder_ == null) return this.block_;
                return (Farm.Block) this.blockBuilder_.getMessage();
            }

            public Builder setBlock(Farm.Block value) {
                if (this.blockBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.block_ = value;
                    onChanged();
                } else {
                    this.blockBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setBlock(Farm.Block.Builder builderForValue) {
                if (this.blockBuilder_ == null) {
                    this.block_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blockBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeBlock(Farm.Block value) {
                if (this.blockBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16 && this.block_ != Farm.Block.getDefaultInstance()) {
                        this.block_ = Farm.Block.newBuilder(this.block_).mergeFrom(value).buildPartial();
                    } else {
                        this.block_ = value;
                    }
                    onChanged();
                } else {
                    this.blockBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder clearBlock() {
                if (this.blockBuilder_ == null) {
                    this.block_ = Farm.Block.getDefaultInstance();
                    onChanged();
                } else {
                    this.blockBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Farm.Block.Builder getBlockBuilder() {
                this.bitField0_ |= 0x10;
                onChanged();
                return (Farm.Block.Builder) getBlockFieldBuilder().getBuilder();
            }

            public Farm.BlockOrBuilder getBlockOrBuilder() {
                if (this.blockBuilder_ != null) return (Farm.BlockOrBuilder) this.blockBuilder_.getMessageOrBuilder();
                return this.block_;
            }

            private SingleFieldBuilder<Farm.Block, Farm.Block.Builder, Farm.BlockOrBuilder> getBlockFieldBuilder() {
                if (this.blockBuilder_ == null) {
                    this.blockBuilder_ = new SingleFieldBuilder(getBlock(), getParentForChildren(), isClean());
                    this.block_ = null;
                }
                return this.blockBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class StealRequest
            extends GeneratedMessage
            implements StealRequestOrBuilder {
        private static final StealRequest defaultInstance = new StealRequest(true);
        private final UnknownFieldSet unknownFields;

        private StealRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StealRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static StealRequest getDefaultInstance() {
            return defaultInstance;
        }

        public StealRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StealRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.blockId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.friendId_ = bs;
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
            return FarmHandler.internal_static_pomelo_farm_StealRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_StealRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(StealRequest.class, Builder.class);
        }

        public static Parser<StealRequest> PARSER = (Parser<StealRequest>) new AbstractParser<StealRequest>() {
            public FarmHandler.StealRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.StealRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BLOCKID_FIELD_NUMBER = 1;
        private int blockId_;
        public static final int FRIENDID_FIELD_NUMBER = 2;
        private Object friendId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<StealRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasBlockId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBlockId() {
            return this.blockId_;
        }

        public boolean hasFriendId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getFriendId() {
            Object ref = this.friendId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.friendId_ = s;
            return s;
        }

        public ByteString getFriendIdBytes() {
            Object ref = this.friendId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.friendId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.blockId_ = 0;
            this.friendId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasBlockId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFriendId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getFriendIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.blockId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getFriendIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StealRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (StealRequest) PARSER.parseFrom(data);
        }

        public static StealRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StealRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static StealRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (StealRequest) PARSER.parseFrom(data);
        }

        public static StealRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StealRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static StealRequest parseFrom(InputStream input) throws IOException {
            return (StealRequest) PARSER.parseFrom(input);
        }

        public static StealRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static StealRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (StealRequest) PARSER.parseDelimitedFrom(input);
        }

        public static StealRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static StealRequest parseFrom(CodedInputStream input) throws IOException {
            return (StealRequest) PARSER.parseFrom(input);
        }

        public static StealRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StealRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.StealRequestOrBuilder {
            private int bitField0_;
            private int blockId_;
            private Object friendId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_StealRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_StealRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.StealRequest.class, Builder.class);
            }

            private Builder() {
                this.friendId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.friendId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.StealRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.blockId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.friendId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_StealRequest_descriptor;
            }

            public FarmHandler.StealRequest getDefaultInstanceForType() {
                return FarmHandler.StealRequest.getDefaultInstance();
            }

            public FarmHandler.StealRequest build() {
                FarmHandler.StealRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.StealRequest buildPartial() {
                FarmHandler.StealRequest result = new FarmHandler.StealRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.blockId_ = this.blockId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.friendId_ = this.friendId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.StealRequest) return mergeFrom((FarmHandler.StealRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.StealRequest other) {
                if (other == FarmHandler.StealRequest.getDefaultInstance()) return this;
                if (other.hasBlockId()) setBlockId(other.getBlockId());
                if (other.hasFriendId()) {
                    this.bitField0_ |= 0x2;
                    this.friendId_ = other.friendId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasBlockId()) return false;
                if (!hasFriendId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.StealRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.StealRequest) FarmHandler.StealRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.StealRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBlockId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.bitField0_ |= 0x1;
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFriendId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getFriendId() {
                Object ref = this.friendId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.friendId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFriendIdBytes() {
                Object ref = this.friendId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.friendId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFriendId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.friendId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFriendId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.friendId_ = FarmHandler.StealRequest.getDefaultInstance().getFriendId();
                onChanged();
                return this;
            }

            public Builder setFriendIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.friendId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class StealResponse
            extends GeneratedMessage
            implements StealResponseOrBuilder {
        private static final StealResponse defaultInstance = new StealResponse(true);
        private final UnknownFieldSet unknownFields;

        private StealResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private StealResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static StealResponse getDefaultInstance() {
            return defaultInstance;
        }

        public StealResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StealResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.productCode_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.num_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_StealResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_StealResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(StealResponse.class, Builder.class);
        }

        public static Parser<StealResponse> PARSER = (Parser<StealResponse>) new AbstractParser<StealResponse>() {
            public FarmHandler.StealResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.StealResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PRODUCTCODE_FIELD_NUMBER = 3;
        private Object productCode_;
        public static final int NUM_FIELD_NUMBER = 4;
        private int num_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<StealResponse> getParserForType() {
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

        public boolean hasProductCode() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getProductCode() {
            Object ref = this.productCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.productCode_ = s;
            return s;
        }

        public ByteString getProductCodeBytes() {
            Object ref = this.productCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.productCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getNum() {
            return this.num_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.productCode_ = "";
            this.num_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getProductCodeBytes());
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.num_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getProductCodeBytes());
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.num_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StealResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (StealResponse) PARSER.parseFrom(data);
        }

        public static StealResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StealResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static StealResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (StealResponse) PARSER.parseFrom(data);
        }

        public static StealResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StealResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static StealResponse parseFrom(InputStream input) throws IOException {
            return (StealResponse) PARSER.parseFrom(input);
        }

        public static StealResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static StealResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (StealResponse) PARSER.parseDelimitedFrom(input);
        }

        public static StealResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static StealResponse parseFrom(CodedInputStream input) throws IOException {
            return (StealResponse) PARSER.parseFrom(input);
        }

        public static StealResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StealResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(StealResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.StealResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Object productCode_;
            private int num_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_StealResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_StealResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.StealResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.productCode_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.productCode_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.StealResponse.alwaysUseFieldBuilders) ;
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
                this.productCode_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_StealResponse_descriptor;
            }

            public FarmHandler.StealResponse getDefaultInstanceForType() {
                return FarmHandler.StealResponse.getDefaultInstance();
            }

            public FarmHandler.StealResponse build() {
                FarmHandler.StealResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.StealResponse buildPartial() {
                FarmHandler.StealResponse result = new FarmHandler.StealResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.productCode_ = this.productCode_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.num_ = this.num_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.StealResponse) return mergeFrom((FarmHandler.StealResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.StealResponse other) {
                if (other == FarmHandler.StealResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasProductCode()) {
                    this.bitField0_ |= 0x4;
                    this.productCode_ = other.productCode_;
                    onChanged();
                }
                if (other.hasNum()) setNum(other.getNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.StealResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.StealResponse) FarmHandler.StealResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.StealResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.StealResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasProductCode() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getProductCode() {
                Object ref = this.productCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.productCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getProductCodeBytes() {
                Object ref = this.productCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.productCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setProductCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.productCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearProductCode() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.productCode_ = FarmHandler.StealResponse.getDefaultInstance().getProductCode();
                onChanged();
                return this;
            }

            public Builder setProductCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.productCode_ = value;
                onChanged();
                return this;
            }

            public boolean hasNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.bitField0_ |= 0x8;
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.num_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetShopInfoRequest
            extends GeneratedMessage
            implements GetShopInfoRequestOrBuilder {
        private static final GetShopInfoRequest defaultInstance = new GetShopInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetShopInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetShopInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetShopInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetShopInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetShopInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_GetShopInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_GetShopInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetShopInfoRequest.class, Builder.class);
        }

        public static Parser<GetShopInfoRequest> PARSER = (Parser<GetShopInfoRequest>) new AbstractParser<GetShopInfoRequest>() {
            public FarmHandler.GetShopInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.GetShopInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetShopInfoRequest> getParserForType() {
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

        public static GetShopInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetShopInfoRequest) PARSER.parseFrom(data);
        }

        public static GetShopInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetShopInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetShopInfoRequest) PARSER.parseFrom(data);
        }

        public static GetShopInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetShopInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetShopInfoRequest) PARSER.parseFrom(input);
        }

        public static GetShopInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetShopInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetShopInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetShopInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetShopInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetShopInfoRequest) PARSER.parseFrom(input);
        }

        public static GetShopInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetShopInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.GetShopInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.GetShopInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.GetShopInfoRequest.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoRequest_descriptor;
            }

            public FarmHandler.GetShopInfoRequest getDefaultInstanceForType() {
                return FarmHandler.GetShopInfoRequest.getDefaultInstance();
            }

            public FarmHandler.GetShopInfoRequest build() {
                FarmHandler.GetShopInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.GetShopInfoRequest buildPartial() {
                FarmHandler.GetShopInfoRequest result = new FarmHandler.GetShopInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.GetShopInfoRequest)
                    return mergeFrom((FarmHandler.GetShopInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.GetShopInfoRequest other) {
                if (other == FarmHandler.GetShopInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.GetShopInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.GetShopInfoRequest) FarmHandler.GetShopInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.GetShopInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetShopInfoResponse
            extends GeneratedMessage
            implements GetShopInfoResponseOrBuilder {
        private static final GetShopInfoResponse defaultInstance = new GetShopInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetShopInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetShopInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetShopInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetShopInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetShopInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Farm.ShopItemInfo.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.shopItemInfo_.toBuilder();
                            this.shopItemInfo_ = (Farm.ShopItemInfo) input.readMessage(Farm.ShopItemInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.shopItemInfo_);
                                this.shopItemInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
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
            return FarmHandler.internal_static_pomelo_farm_GetShopInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_GetShopInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetShopInfoResponse.class, Builder.class);
        }

        public static Parser<GetShopInfoResponse> PARSER = (Parser<GetShopInfoResponse>) new AbstractParser<GetShopInfoResponse>() {
            public FarmHandler.GetShopInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.GetShopInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int SHOPITEMINFO_FIELD_NUMBER = 3;
        private Farm.ShopItemInfo shopItemInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetShopInfoResponse> getParserForType() {
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

        public boolean hasShopItemInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public Farm.ShopItemInfo getShopItemInfo() {
            return this.shopItemInfo_;
        }

        public Farm.ShopItemInfoOrBuilder getShopItemInfoOrBuilder() {
            return this.shopItemInfo_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.shopItemInfo_ = Farm.ShopItemInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasShopItemInfo() && !getShopItemInfo().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.shopItemInfo_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.shopItemInfo_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetShopInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetShopInfoResponse) PARSER.parseFrom(data);
        }

        public static GetShopInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetShopInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetShopInfoResponse) PARSER.parseFrom(data);
        }

        public static GetShopInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetShopInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetShopInfoResponse) PARSER.parseFrom(input);
        }

        public static GetShopInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetShopInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetShopInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetShopInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetShopInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetShopInfoResponse) PARSER.parseFrom(input);
        }

        public static GetShopInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetShopInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.GetShopInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Farm.ShopItemInfo shopItemInfo_;
            private SingleFieldBuilder<Farm.ShopItemInfo, Farm.ShopItemInfo.Builder, Farm.ShopItemInfoOrBuilder> shopItemInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.GetShopInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.shopItemInfo_ = Farm.ShopItemInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.shopItemInfo_ = Farm.ShopItemInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.GetShopInfoResponse.alwaysUseFieldBuilders) getShopItemInfoFieldBuilder();
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
                if (this.shopItemInfoBuilder_ == null) {
                    this.shopItemInfo_ = Farm.ShopItemInfo.getDefaultInstance();
                } else {
                    this.shopItemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_GetShopInfoResponse_descriptor;
            }

            public FarmHandler.GetShopInfoResponse getDefaultInstanceForType() {
                return FarmHandler.GetShopInfoResponse.getDefaultInstance();
            }

            public FarmHandler.GetShopInfoResponse build() {
                FarmHandler.GetShopInfoResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.GetShopInfoResponse buildPartial() {
                FarmHandler.GetShopInfoResponse result = new FarmHandler.GetShopInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.shopItemInfoBuilder_ == null) {
                    result.shopItemInfo_ = this.shopItemInfo_;
                } else {
                    result.shopItemInfo_ = (Farm.ShopItemInfo) this.shopItemInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.GetShopInfoResponse)
                    return mergeFrom((FarmHandler.GetShopInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.GetShopInfoResponse other) {
                if (other == FarmHandler.GetShopInfoResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasShopItemInfo()) mergeShopItemInfo(other.getShopItemInfo());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasShopItemInfo() && !getShopItemInfo().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.GetShopInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.GetShopInfoResponse) FarmHandler.GetShopInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.GetShopInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.GetShopInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasShopItemInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public Farm.ShopItemInfo getShopItemInfo() {
                if (this.shopItemInfoBuilder_ == null) return this.shopItemInfo_;
                return (Farm.ShopItemInfo) this.shopItemInfoBuilder_.getMessage();
            }

            public Builder setShopItemInfo(Farm.ShopItemInfo value) {
                if (this.shopItemInfoBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.shopItemInfo_ = value;
                    onChanged();
                } else {
                    this.shopItemInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setShopItemInfo(Farm.ShopItemInfo.Builder builderForValue) {
                if (this.shopItemInfoBuilder_ == null) {
                    this.shopItemInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.shopItemInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeShopItemInfo(Farm.ShopItemInfo value) {
                if (this.shopItemInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.shopItemInfo_ != Farm.ShopItemInfo.getDefaultInstance()) {
                        this.shopItemInfo_ = Farm.ShopItemInfo.newBuilder(this.shopItemInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.shopItemInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.shopItemInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearShopItemInfo() {
                if (this.shopItemInfoBuilder_ == null) {
                    this.shopItemInfo_ = Farm.ShopItemInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.shopItemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Farm.ShopItemInfo.Builder getShopItemInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (Farm.ShopItemInfo.Builder) getShopItemInfoFieldBuilder().getBuilder();
            }

            public Farm.ShopItemInfoOrBuilder getShopItemInfoOrBuilder() {
                if (this.shopItemInfoBuilder_ != null)
                    return (Farm.ShopItemInfoOrBuilder) this.shopItemInfoBuilder_.getMessageOrBuilder();
                return this.shopItemInfo_;
            }

            private SingleFieldBuilder<Farm.ShopItemInfo, Farm.ShopItemInfo.Builder, Farm.ShopItemInfoOrBuilder> getShopItemInfoFieldBuilder() {
                if (this.shopItemInfoBuilder_ == null) {
                    this.shopItemInfoBuilder_ = new SingleFieldBuilder(getShopItemInfo(), getParentForChildren(), isClean());
                    this.shopItemInfo_ = null;
                }
                return this.shopItemInfoBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ChangeShopItemRequest
            extends GeneratedMessage
            implements ChangeShopItemRequestOrBuilder {
        private static final ChangeShopItemRequest defaultInstance = new ChangeShopItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private ChangeShopItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangeShopItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangeShopItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ChangeShopItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeShopItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.itemId_ = input.readInt32();
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
            return FarmHandler.internal_static_pomelo_farm_ChangeShopItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_ChangeShopItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeShopItemRequest.class, Builder.class);
        }

        public static Parser<ChangeShopItemRequest> PARSER = (Parser<ChangeShopItemRequest>) new AbstractParser<ChangeShopItemRequest>() {
            public FarmHandler.ChangeShopItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.ChangeShopItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMID_FIELD_NUMBER = 1;
        private int itemId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ChangeShopItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasItemId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getItemId() {
            return this.itemId_;
        }

        private void initFields() {
            this.itemId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.itemId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.itemId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ChangeShopItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangeShopItemRequest) PARSER.parseFrom(data);
        }

        public static ChangeShopItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeShopItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeShopItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangeShopItemRequest) PARSER.parseFrom(data);
        }

        public static ChangeShopItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeShopItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeShopItemRequest parseFrom(InputStream input) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseFrom(input);
        }

        public static ChangeShopItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ChangeShopItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ChangeShopItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ChangeShopItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseFrom(input);
        }

        public static ChangeShopItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ChangeShopItemRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.ChangeShopItemRequestOrBuilder {
            private int bitField0_;
            private int itemId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.ChangeShopItemRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FarmHandler.ChangeShopItemRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.itemId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemRequest_descriptor;
            }

            public FarmHandler.ChangeShopItemRequest getDefaultInstanceForType() {
                return FarmHandler.ChangeShopItemRequest.getDefaultInstance();
            }

            public FarmHandler.ChangeShopItemRequest build() {
                FarmHandler.ChangeShopItemRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.ChangeShopItemRequest buildPartial() {
                FarmHandler.ChangeShopItemRequest result = new FarmHandler.ChangeShopItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.itemId_ = this.itemId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FarmHandler.ChangeShopItemRequest)
                    return mergeFrom((FarmHandler.ChangeShopItemRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.ChangeShopItemRequest other) {
                if (other == FarmHandler.ChangeShopItemRequest.getDefaultInstance()) return this;
                if (other.hasItemId()) setItemId(other.getItemId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasItemId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FarmHandler.ChangeShopItemRequest parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.ChangeShopItemRequest) FarmHandler.ChangeShopItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.ChangeShopItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasItemId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.bitField0_ |= 0x1;
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ChangeShopItemResponse
            extends GeneratedMessage
            implements ChangeShopItemResponseOrBuilder {
        private static final ChangeShopItemResponse defaultInstance = new ChangeShopItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private ChangeShopItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangeShopItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangeShopItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ChangeShopItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeShopItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return FarmHandler.internal_static_pomelo_farm_ChangeShopItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FarmHandler.internal_static_pomelo_farm_ChangeShopItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeShopItemResponse.class, Builder.class);
        }

        public static Parser<ChangeShopItemResponse> PARSER = (Parser<ChangeShopItemResponse>) new AbstractParser<ChangeShopItemResponse>() {
            public FarmHandler.ChangeShopItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FarmHandler.ChangeShopItemResponse(input, extensionRegistry);
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

        public Parser<ChangeShopItemResponse> getParserForType() {
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

        public static ChangeShopItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangeShopItemResponse) PARSER.parseFrom(data);
        }

        public static ChangeShopItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeShopItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeShopItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangeShopItemResponse) PARSER.parseFrom(data);
        }

        public static ChangeShopItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangeShopItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeShopItemResponse parseFrom(InputStream input) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseFrom(input);
        }

        public static ChangeShopItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ChangeShopItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ChangeShopItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ChangeShopItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseFrom(input);
        }

        public static ChangeShopItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeShopItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ChangeShopItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FarmHandler.ChangeShopItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FarmHandler.ChangeShopItemResponse.class, Builder.class);
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
                if (FarmHandler.ChangeShopItemResponse.alwaysUseFieldBuilders) ;
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
                return FarmHandler.internal_static_pomelo_farm_ChangeShopItemResponse_descriptor;
            }

            public FarmHandler.ChangeShopItemResponse getDefaultInstanceForType() {
                return FarmHandler.ChangeShopItemResponse.getDefaultInstance();
            }

            public FarmHandler.ChangeShopItemResponse build() {
                FarmHandler.ChangeShopItemResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FarmHandler.ChangeShopItemResponse buildPartial() {
                FarmHandler.ChangeShopItemResponse result = new FarmHandler.ChangeShopItemResponse(this);
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
                if (other instanceof FarmHandler.ChangeShopItemResponse)
                    return mergeFrom((FarmHandler.ChangeShopItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FarmHandler.ChangeShopItemResponse other) {
                if (other == FarmHandler.ChangeShopItemResponse.getDefaultInstance()) return this;
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
                FarmHandler.ChangeShopItemResponse parsedMessage = null;
                try {
                    parsedMessage = (FarmHandler.ChangeShopItemResponse) FarmHandler.ChangeShopItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FarmHandler.ChangeShopItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = FarmHandler.ChangeShopItemResponse.getDefaultInstance().getS2CMsg();
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


    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021farmHandler.proto\022\013pomelo.farm\032\nfarm.proto\"\023\n\021MyFarmInfoRequest\"ì\001\n\022MyFarmInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\nplayerInfo\030\003 \001(\0132\027.pomelo.farm.PlayerInfo\022!\n\006seedLs\030\004 \003(\0132\021.pomelo.farm.Seed\022'\n\tproductLs\030\005 \003(\0132\024.pomelo.farm.Product\022\013\n\003exp\030\006 \001(\005\022-\n\frecordInfoLs\030\007 \003(\0132\027.pomelo.farm.RecordInfo\")\n\025FriendFarmInfoRequest\022\020\n\bplayerId\030\001 \002(\t\"h\n\026FriendFarmInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_m", "sg\030\002 \001(\t\022+\n\nplayerInfo\030\003 \001(\0132\027.pomelo.farm.PlayerInfo\"\021\n\017FriendLsRequest\"h\n\020FriendLsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0221\n\rplayerSummary\030\003 \003(\0132\032.pomelo.farm.PlayerSummary\"\036\n\013OpenRequest\022\017\n\007blockId\030\001 \002(\005\"1\n\fOpenResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"/\n\nSowRequest\022\017\n\007blockId\030\001 \002(\005\022\020\n\bseedCode\030\002 \002(\t\"0\n\013SowResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"R\n\026CultivateFriendRequest\022\017\n\007blockId\030\001 ", "\002(\005\022\025\n\rcultivateType\030\002 \002(\005\022\020\n\bfriendId\030\003 \001(\t\"J\n\027CultivateFriendResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004fate\030\003 \001(\005\">\n\024CultivateSelfRequest\022\017\n\007blockId\030\001 \002(\005\022\025\n\rcultivateType\030\002 \002(\005\":\n\025CultivateSelfResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"!\n\016HarvestRequest\022\017\n\007blockId\030\001 \002(\005\"p\n\017HarvestResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\013\n\003exp\030\003 \001(\005\022\n\n\002lv\030\004 \001(\005\022!\n\005block\030\005 \001(\0132\022.pomelo.farm.Block\"1\n\fSte", "alRequest\022\017\n\007blockId\030\001 \002(\005\022\020\n\bfriendId\030\002 \002(\t\"T\n\rStealResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013productCode\030\003 \001(\t\022\013\n\003num\030\004 \001(\005\"\024\n\022GetShopInfoRequest\"i\n\023GetShopInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\fshopItemInfo\030\003 \001(\0132\031.pomelo.farm.ShopItemInfo\"'\n\025ChangeShopItemRequest\022\016\n\006itemId\030\001 \002(\005\";\n\026ChangeShopItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2­\007\n\013farmHandler\022T\n\021myFarmInfoRequest\022\036", ".pomelo.farm.MyFarmInfoRequest\032\037.pomelo.farm.MyFarmInfoResponse\022`\n\025friendFarmInfoRequest\022\".pomelo.farm.FriendFarmInfoRequest\032#.pomelo.farm.FriendFarmInfoResponse\022N\n\017friendLsRequest\022\034.pomelo.farm.FriendLsRequest\032\035.pomelo.farm.FriendLsResponse\022B\n\013openRequest\022\030.pomelo.farm.OpenRequest\032\031.pomelo.farm.OpenResponse\022?\n\nsowRequest\022\027.pomelo.farm.SowRequest\032\030.pomelo.farm.SowResponse\022c\n\026cultivateFriendRequest", "\022#.pomelo.farm.CultivateFriendRequest\032$.pomelo.farm.CultivateFriendResponse\022]\n\024cultivateSelfRequest\022!.pomelo.farm.CultivateSelfRequest\032\".pomelo.farm.CultivateSelfResponse\022E\n\fstealRequest\022\031.pomelo.farm.StealRequest\032\032.pomelo.farm.StealResponse\022K\n\016harvestRequest\022\033.pomelo.farm.HarvestRequest\032\034.pomelo.farm.HarvestResponse\022W\n\022getShopInfoRequest\022\037.pomelo.farm.GetShopInfoRequest\032 .pomelo.farm.GetShopInfoR", "esponse\022`\n\025changeShopItemRequest\022\".pomelo.farm.ChangeShopItemRequest\032#.pomelo.farm.ChangeShopItemResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                FarmHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Farm.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_farm_MyFarmInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_MyFarmInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_MyFarmInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_farm_MyFarmInfoResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_MyFarmInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_MyFarmInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PlayerInfo", "SeedLs", "ProductLs", "Exp", "RecordInfoLs"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_FriendFarmInfoRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_FriendFarmInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_FriendFarmInfoRequest_descriptor, new String[]{"PlayerId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_FriendFarmInfoResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_FriendFarmInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_FriendFarmInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PlayerInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_FriendLsRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_FriendLsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_FriendLsRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_farm_FriendLsResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_FriendLsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_FriendLsResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PlayerSummary"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_OpenRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_OpenRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_OpenRequest_descriptor, new String[]{"BlockId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_OpenResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_OpenResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_OpenResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_SowRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_SowRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_SowRequest_descriptor, new String[]{"BlockId", "SeedCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_SowResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_SowResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_SowResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_CultivateFriendRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_CultivateFriendRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_CultivateFriendRequest_descriptor, new String[]{"BlockId", "CultivateType", "FriendId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_CultivateFriendResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_CultivateFriendResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_CultivateFriendResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Fate"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_CultivateSelfRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_CultivateSelfRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_CultivateSelfRequest_descriptor, new String[]{"BlockId", "CultivateType"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_CultivateSelfResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_CultivateSelfResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_CultivateSelfResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_HarvestRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_HarvestRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_HarvestRequest_descriptor, new String[]{"BlockId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_HarvestResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_HarvestResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_HarvestResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Exp", "Lv", "Block"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_StealRequest_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_StealRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_StealRequest_descriptor, new String[]{"BlockId", "FriendId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_StealResponse_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_StealResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_StealResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "ProductCode", "Num"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_GetShopInfoRequest_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_GetShopInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_GetShopInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_farm_GetShopInfoResponse_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_GetShopInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_GetShopInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "ShopItemInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_ChangeShopItemRequest_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_ChangeShopItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_ChangeShopItemRequest_descriptor, new String[]{"ItemId"});


    private static final Descriptors.Descriptor internal_static_pomelo_farm_ChangeShopItemResponse_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_farm_ChangeShopItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_farm_ChangeShopItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Farm.getDescriptor();
    }

    public static interface ChangeShopItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ChangeShopItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasItemId();

        int getItemId();
    }

    public static interface GetShopInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasShopItemInfo();

        Farm.ShopItemInfo getShopItemInfo();

        Farm.ShopItemInfoOrBuilder getShopItemInfoOrBuilder();
    }

    public static interface GetShopInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface StealResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasProductCode();

        String getProductCode();

        ByteString getProductCodeBytes();

        boolean hasNum();

        int getNum();
    }

    public static interface StealRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();

        boolean hasFriendId();

        String getFriendId();

        ByteString getFriendIdBytes();
    }

    public static interface HarvestResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasExp();

        int getExp();

        boolean hasLv();

        int getLv();

        boolean hasBlock();

        Farm.Block getBlock();

        Farm.BlockOrBuilder getBlockOrBuilder();
    }

    public static interface HarvestRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();
    }

    public static interface CultivateSelfResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface CultivateSelfRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();

        boolean hasCultivateType();

        int getCultivateType();
    }

    public static interface CultivateFriendResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasFate();

        int getFate();
    }

    public static interface CultivateFriendRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();

        boolean hasCultivateType();

        int getCultivateType();

        boolean hasFriendId();

        String getFriendId();

        ByteString getFriendIdBytes();
    }

    public static interface SowResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SowRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();

        boolean hasSeedCode();

        String getSeedCode();

        ByteString getSeedCodeBytes();
    }

    public static interface OpenResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface OpenRequestOrBuilder extends MessageOrBuilder {
        boolean hasBlockId();

        int getBlockId();
    }

    public static interface FriendLsResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<Farm.PlayerSummary> getPlayerSummaryList();

        Farm.PlayerSummary getPlayerSummary(int param1Int);

        int getPlayerSummaryCount();

        List<? extends Farm.PlayerSummaryOrBuilder> getPlayerSummaryOrBuilderList();

        Farm.PlayerSummaryOrBuilder getPlayerSummaryOrBuilder(int param1Int);
    }

    public static interface FriendLsRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface FriendFarmInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPlayerInfo();

        Farm.PlayerInfo getPlayerInfo();

        Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder();
    }

    public static interface FriendFarmInfoRequestOrBuilder extends MessageOrBuilder {
        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();
    }

    public static interface MyFarmInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPlayerInfo();

        Farm.PlayerInfo getPlayerInfo();

        Farm.PlayerInfoOrBuilder getPlayerInfoOrBuilder();

        List<Farm.Seed> getSeedLsList();

        Farm.Seed getSeedLs(int param1Int);

        int getSeedLsCount();

        List<? extends Farm.SeedOrBuilder> getSeedLsOrBuilderList();

        Farm.SeedOrBuilder getSeedLsOrBuilder(int param1Int);

        List<Farm.Product> getProductLsList();

        Farm.Product getProductLs(int param1Int);

        int getProductLsCount();

        List<? extends Farm.ProductOrBuilder> getProductLsOrBuilderList();

        Farm.ProductOrBuilder getProductLsOrBuilder(int param1Int);

        boolean hasExp();

        int getExp();

        List<Farm.RecordInfo> getRecordInfoLsList();

        Farm.RecordInfo getRecordInfoLs(int param1Int);

        int getRecordInfoLsCount();

        List<? extends Farm.RecordInfoOrBuilder> getRecordInfoLsOrBuilderList();

        Farm.RecordInfoOrBuilder getRecordInfoLsOrBuilder(int param1Int);
    }

    public static interface MyFarmInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


