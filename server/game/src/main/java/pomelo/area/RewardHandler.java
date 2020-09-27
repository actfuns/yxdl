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

import pomelo.item.ItemOuterClass;


public final class RewardHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class RewardDeskRequest
            extends GeneratedMessage
            implements RewardDeskRequestOrBuilder {
        private static final RewardDeskRequest defaultInstance = new RewardDeskRequest(true);
        private final UnknownFieldSet unknownFields;

        private RewardDeskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardDeskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardDeskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RewardDeskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardDeskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RewardHandler.internal_static_pomelo_area_RewardDeskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_RewardDeskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardDeskRequest.class, Builder.class);
        }

        public static Parser<RewardDeskRequest> PARSER = (Parser<RewardDeskRequest>) new AbstractParser<RewardDeskRequest>() {
            public RewardHandler.RewardDeskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.RewardDeskRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardDeskRequest> getParserForType() {
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

        public static RewardDeskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardDeskRequest) PARSER.parseFrom(data);
        }

        public static RewardDeskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardDeskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardDeskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardDeskRequest) PARSER.parseFrom(data);
        }

        public static RewardDeskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardDeskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardDeskRequest parseFrom(InputStream input) throws IOException {
            return (RewardDeskRequest) PARSER.parseFrom(input);
        }

        public static RewardDeskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RewardDeskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardDeskRequest) PARSER.parseDelimitedFrom(input);
        }

        public static RewardDeskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RewardDeskRequest parseFrom(CodedInputStream input) throws IOException {
            return (RewardDeskRequest) PARSER.parseFrom(input);
        }

        public static RewardDeskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RewardDeskRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.RewardDeskRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_RewardDeskRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_RewardDeskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.RewardDeskRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RewardHandler.RewardDeskRequest.alwaysUseFieldBuilders) ;
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
                return RewardHandler.internal_static_pomelo_area_RewardDeskRequest_descriptor;
            }

            public RewardHandler.RewardDeskRequest getDefaultInstanceForType() {
                return RewardHandler.RewardDeskRequest.getDefaultInstance();
            }

            public RewardHandler.RewardDeskRequest build() {
                RewardHandler.RewardDeskRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.RewardDeskRequest buildPartial() {
                RewardHandler.RewardDeskRequest result = new RewardHandler.RewardDeskRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.RewardDeskRequest)
                    return mergeFrom((RewardHandler.RewardDeskRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.RewardDeskRequest other) {
                if (other == RewardHandler.RewardDeskRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.RewardDeskRequest parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.RewardDeskRequest) RewardHandler.RewardDeskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.RewardDeskRequest) e.getUnfinishedMessage();
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


    public static final class RewardDeskResponse
            extends GeneratedMessage
            implements RewardDeskResponseOrBuilder {
        private static final RewardDeskResponse defaultInstance = new RewardDeskResponse(true);
        private final UnknownFieldSet unknownFields;

        private RewardDeskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardDeskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardDeskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public RewardDeskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardDeskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ItemOuterClass.MiniItem.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CItemInfo_.toBuilder();
                            this.s2CItemInfo_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CItemInfo_);
                                this.s2CItemInfo_ = subBuilder.buildPartial();
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
            return RewardHandler.internal_static_pomelo_area_RewardDeskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_RewardDeskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardDeskResponse.class, Builder.class);
        }

        public static Parser<RewardDeskResponse> PARSER = (Parser<RewardDeskResponse>) new AbstractParser<RewardDeskResponse>() {
            public RewardHandler.RewardDeskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.RewardDeskResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ITEMINFO_FIELD_NUMBER = 3;
        private ItemOuterClass.MiniItem s2CItemInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardDeskResponse> getParserForType() {
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


        public boolean hasS2CItemInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public ItemOuterClass.MiniItem getS2CItemInfo() {
            return this.s2CItemInfo_;
        }


        public ItemOuterClass.MiniItemOrBuilder getS2CItemInfoOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CItemInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CItemInfo_ = ItemOuterClass.MiniItem.getDefaultInstance();
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
            if (!hasS2CItemInfo()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CItemInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CItemInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CItemInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static RewardDeskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardDeskResponse) PARSER.parseFrom(data);
        }


        public static RewardDeskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardDeskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RewardDeskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardDeskResponse) PARSER.parseFrom(data);
        }


        public static RewardDeskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardDeskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RewardDeskResponse parseFrom(InputStream input) throws IOException {
            return (RewardDeskResponse) PARSER.parseFrom(input);
        }


        public static RewardDeskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static RewardDeskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardDeskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static RewardDeskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static RewardDeskResponse parseFrom(CodedInputStream input) throws IOException {
            return (RewardDeskResponse) PARSER.parseFrom(input);
        }


        public static RewardDeskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardDeskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(RewardDeskResponse prototype) {
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
                implements RewardHandler.RewardDeskResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private ItemOuterClass.MiniItem s2CItemInfo_;

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CItemInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_RewardDeskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_RewardDeskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.RewardDeskResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CItemInfo_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CItemInfo_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (RewardHandler.RewardDeskResponse.alwaysUseFieldBuilders) {
                    getS2CItemInfoFieldBuilder();
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
                if (this.s2CItemInfoBuilder_ == null) {
                    this.s2CItemInfo_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.s2CItemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_RewardDeskResponse_descriptor;
            }


            public RewardHandler.RewardDeskResponse getDefaultInstanceForType() {
                return RewardHandler.RewardDeskResponse.getDefaultInstance();
            }


            public RewardHandler.RewardDeskResponse build() {
                RewardHandler.RewardDeskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public RewardHandler.RewardDeskResponse buildPartial() {
                RewardHandler.RewardDeskResponse result = new RewardHandler.RewardDeskResponse(this);
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
                if (this.s2CItemInfoBuilder_ == null) {
                    result.s2CItemInfo_ = this.s2CItemInfo_;
                } else {
                    result.s2CItemInfo_ = (ItemOuterClass.MiniItem) this.s2CItemInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.RewardDeskResponse) {
                    return mergeFrom((RewardHandler.RewardDeskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(RewardHandler.RewardDeskResponse other) {
                if (other == RewardHandler.RewardDeskResponse.getDefaultInstance()) {
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
                if (other.hasS2CItemInfo()) {
                    mergeS2CItemInfo(other.getS2CItemInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasS2CItemInfo()) {
                    return false;
                }
                if (!getS2CItemInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.RewardDeskResponse parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.RewardDeskResponse) RewardHandler.RewardDeskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.RewardDeskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RewardHandler.RewardDeskResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CItemInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public ItemOuterClass.MiniItem getS2CItemInfo() {
                if (this.s2CItemInfoBuilder_ == null) {
                    return this.s2CItemInfo_;
                }
                return (ItemOuterClass.MiniItem) this.s2CItemInfoBuilder_.getMessage();
            }

            public Builder setS2CItemInfo(ItemOuterClass.MiniItem value) {
                if (this.s2CItemInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CItemInfo_ = value;
                    onChanged();
                } else {
                    this.s2CItemInfoBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CItemInfo(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemInfoBuilder_ == null) {
                    this.s2CItemInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CItemInfoBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CItemInfo(ItemOuterClass.MiniItem value) {
                if (this.s2CItemInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CItemInfo_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.s2CItemInfo_ = ItemOuterClass.MiniItem.newBuilder(this.s2CItemInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CItemInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CItemInfoBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CItemInfo() {
                if (this.s2CItemInfoBuilder_ == null) {
                    this.s2CItemInfo_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CItemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getS2CItemInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getS2CItemInfoFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getS2CItemInfoOrBuilder() {
                if (this.s2CItemInfoBuilder_ != null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CItemInfoBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CItemInfo_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CItemInfoFieldBuilder() {
                if (this.s2CItemInfoBuilder_ == null) {
                    this.s2CItemInfoBuilder_ = new SingleFieldBuilder((GeneratedMessage) getS2CItemInfo(), getParentForChildren(), isClean());
                    this.s2CItemInfo_ = null;
                }
                return this.s2CItemInfoBuilder_;
            }
        }
    }

    public static final class RewardRequest
            extends GeneratedMessage
            implements RewardRequestOrBuilder {
        private static final RewardRequest defaultInstance = new RewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private RewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPlayerName_ = bs;
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
            return RewardHandler.internal_static_pomelo_area_RewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_RewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardRequest.class, Builder.class);
        }

        public static Parser<RewardRequest> PARSER = (Parser<RewardRequest>) new AbstractParser<RewardRequest>() {
            public RewardHandler.RewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.RewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_PLAYERNAME_FIELD_NUMBER = 1;
        private Object c2SPlayerName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPlayerName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SPlayerName() {
            Object ref = this.c2SPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SPlayerName_ = s;
            return s;
        }

        public ByteString getC2SPlayerNameBytes() {
            Object ref = this.c2SPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SPlayerName_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SPlayerNameBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SPlayerNameBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static RewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardRequest) PARSER.parseFrom(data);
        }


        public static RewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardRequest) PARSER.parseFrom(data);
        }


        public static RewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RewardRequest parseFrom(InputStream input) throws IOException {
            return (RewardRequest) PARSER.parseFrom(input);
        }


        public static RewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static RewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static RewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static RewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (RewardRequest) PARSER.parseFrom(input);
        }


        public static RewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(RewardRequest prototype) {
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
                implements RewardHandler.RewardRequestOrBuilder {
            private int bitField0_;


            private Object c2SPlayerName_;


            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_RewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_RewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.RewardRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SPlayerName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SPlayerName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (RewardHandler.RewardRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_RewardRequest_descriptor;
            }


            public RewardHandler.RewardRequest getDefaultInstanceForType() {
                return RewardHandler.RewardRequest.getDefaultInstance();
            }


            public RewardHandler.RewardRequest build() {
                RewardHandler.RewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public RewardHandler.RewardRequest buildPartial() {
                RewardHandler.RewardRequest result = new RewardHandler.RewardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SPlayerName_ = this.c2SPlayerName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.RewardRequest) {
                    return mergeFrom((RewardHandler.RewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(RewardHandler.RewardRequest other) {
                if (other == RewardHandler.RewardRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SPlayerName()) {
                    this.bitField0_ |= 0x1;
                    this.c2SPlayerName_ = other.c2SPlayerName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SPlayerName()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.RewardRequest parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.RewardRequest) RewardHandler.RewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.RewardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SPlayerName() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SPlayerName() {
                Object ref = this.c2SPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SPlayerName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SPlayerNameBytes() {
                Object ref = this.c2SPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SPlayerName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SPlayerName_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPlayerName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPlayerName_ = RewardHandler.RewardRequest.getDefaultInstance().getC2SPlayerName();
                onChanged();
                return this;
            }


            public Builder setC2SPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SPlayerName_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class RewardResponse
            extends GeneratedMessage
            implements RewardResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private RewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private RewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static RewardResponse getDefaultInstance() {
            return defaultInstance;
        }


        public RewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private RewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RewardHandler.internal_static_pomelo_area_RewardResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_RewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardResponse.class, Builder.class);
        }


        public static Parser<RewardResponse> PARSER = (Parser<RewardResponse>) new AbstractParser<RewardResponse>() {
            public RewardHandler.RewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.RewardResponse(input, extensionRegistry);
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


        public Parser<RewardResponse> getParserForType() {
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


        private static final RewardResponse defaultInstance = new RewardResponse(true);

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

        public static RewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardResponse) PARSER.parseFrom(data);
        }

        public static RewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardResponse) PARSER.parseFrom(data);
        }

        public static RewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardResponse parseFrom(InputStream input) throws IOException {
            return (RewardResponse) PARSER.parseFrom(input);
        }

        public static RewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (RewardResponse) PARSER.parseFrom(input);
        }

        public static RewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.RewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_RewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_RewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.RewardResponse.class, Builder.class);
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
                if (RewardHandler.RewardResponse.alwaysUseFieldBuilders) ;
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
                return RewardHandler.internal_static_pomelo_area_RewardResponse_descriptor;
            }

            public RewardHandler.RewardResponse getDefaultInstanceForType() {
                return RewardHandler.RewardResponse.getDefaultInstance();
            }

            public RewardHandler.RewardResponse build() {
                RewardHandler.RewardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.RewardResponse buildPartial() {
                RewardHandler.RewardResponse result = new RewardHandler.RewardResponse(this);
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
                if (other instanceof RewardHandler.RewardResponse)
                    return mergeFrom((RewardHandler.RewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.RewardResponse other) {
                if (other == RewardHandler.RewardResponse.getDefaultInstance()) return this;
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
                RewardHandler.RewardResponse parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.RewardResponse) RewardHandler.RewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.RewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RewardHandler.RewardResponse.getDefaultInstance().getS2CMsg();
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


    public static final class BountyInfo
            extends GeneratedMessage
            implements BountyInfoOrBuilder {
        private static final BountyInfo defaultInstance = new BountyInfo(true);
        private final UnknownFieldSet unknownFields;

        private BountyInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BountyInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BountyInfo getDefaultInstance() {
            return defaultInstance;
        }

        public BountyInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BountyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    ItemOuterClass.CountItem.Builder subBuilder;
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.playerName_ = byteString1;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.bounty_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.pro_ = input.readInt32();
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x8) == 8) subBuilder = this.itemInfo_.toBuilder();
                            this.itemInfo_ = (ItemOuterClass.CountItem) input.readMessage(ItemOuterClass.CountItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.itemInfo_);
                                this.itemInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x8;
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.preyId_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.hunterId_ = bs;
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.isFinish_ = input.readInt32();
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
            return RewardHandler.internal_static_pomelo_area_BountyInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_BountyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BountyInfo.class, Builder.class);
        }

        public static Parser<BountyInfo> PARSER = (Parser<BountyInfo>) new AbstractParser<BountyInfo>() {
            public RewardHandler.BountyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.BountyInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PLAYERNAME_FIELD_NUMBER = 1;
        private Object playerName_;
        public static final int BOUNTY_FIELD_NUMBER = 2;
        private int bounty_;
        public static final int PRO_FIELD_NUMBER = 3;
        private int pro_;
        public static final int ITEMINFO_FIELD_NUMBER = 4;
        private ItemOuterClass.CountItem itemInfo_;
        public static final int PREYID_FIELD_NUMBER = 5;
        private Object preyId_;
        public static final int HUNTERID_FIELD_NUMBER = 6;
        private Object hunterId_;
        public static final int ISFINISH_FIELD_NUMBER = 7;
        private int isFinish_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BountyInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasPlayerName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getPlayerName() {
            Object ref = this.playerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.playerName_ = s;
            return s;
        }

        public ByteString getPlayerNameBytes() {
            Object ref = this.playerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasBounty() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getBounty() {
            return this.bounty_;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasPro() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasItemInfo() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public ItemOuterClass.CountItem getItemInfo() {
            return this.itemInfo_;
        }

        public ItemOuterClass.CountItemOrBuilder getItemInfoOrBuilder() {
            return (ItemOuterClass.CountItemOrBuilder) this.itemInfo_;
        }

        public boolean hasPreyId() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getPreyId() {
            Object ref = this.preyId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.preyId_ = s;
            return s;
        }

        public ByteString getPreyIdBytes() {
            Object ref = this.preyId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.preyId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasHunterId() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getHunterId() {
            Object ref = this.hunterId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.hunterId_ = s;
            return s;
        }

        public ByteString getHunterIdBytes() {
            Object ref = this.hunterId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.hunterId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasIsFinish() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getIsFinish() {
            return this.isFinish_;
        }

        private void initFields() {
            this.playerName_ = "";
            this.bounty_ = 0;
            this.pro_ = 0;
            this.itemInfo_ = ItemOuterClass.CountItem.getDefaultInstance();
            this.preyId_ = "";
            this.hunterId_ = "";
            this.isFinish_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBounty()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemInfo()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPreyId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHunterId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getItemInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getPlayerNameBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.bounty_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.pro_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeMessage(4, (MessageLite) this.itemInfo_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getPreyIdBytes());
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(6, getHunterIdBytes());
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.isFinish_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getPlayerNameBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.bounty_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.pro_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.itemInfo_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getPreyIdBytes());
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(6, getHunterIdBytes());
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.isFinish_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BountyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BountyInfo) PARSER.parseFrom(data);
        }

        public static BountyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BountyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BountyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BountyInfo) PARSER.parseFrom(data);
        }

        public static BountyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BountyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BountyInfo parseFrom(InputStream input) throws IOException {
            return (BountyInfo) PARSER.parseFrom(input);
        }

        public static BountyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BountyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BountyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BountyInfo) PARSER.parseDelimitedFrom(input);
        }

        public static BountyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BountyInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BountyInfo parseFrom(CodedInputStream input) throws IOException {
            return (BountyInfo) PARSER.parseFrom(input);
        }

        public static BountyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BountyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BountyInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.BountyInfoOrBuilder {
            private int bitField0_;
            private Object playerName_;
            private int bounty_;
            private int pro_;
            private ItemOuterClass.CountItem itemInfo_;
            private SingleFieldBuilder<ItemOuterClass.CountItem, ItemOuterClass.CountItem.Builder, ItemOuterClass.CountItemOrBuilder> itemInfoBuilder_;
            private Object preyId_;
            private Object hunterId_;
            private int isFinish_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_BountyInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_BountyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.BountyInfo.class, Builder.class);
            }

            private Builder() {
                this.playerName_ = "";
                this.itemInfo_ = ItemOuterClass.CountItem.getDefaultInstance();
                this.preyId_ = "";
                this.hunterId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerName_ = "";
                this.itemInfo_ = ItemOuterClass.CountItem.getDefaultInstance();
                this.preyId_ = "";
                this.hunterId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RewardHandler.BountyInfo.alwaysUseFieldBuilders)
                    getItemInfoFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.playerName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.bounty_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.itemInfoBuilder_ == null) {
                    this.itemInfo_ = ItemOuterClass.CountItem.getDefaultInstance();
                } else {
                    this.itemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                this.preyId_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.hunterId_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.isFinish_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_BountyInfo_descriptor;
            }

            public RewardHandler.BountyInfo getDefaultInstanceForType() {
                return RewardHandler.BountyInfo.getDefaultInstance();
            }

            public RewardHandler.BountyInfo build() {
                RewardHandler.BountyInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.BountyInfo buildPartial() {
                RewardHandler.BountyInfo result = new RewardHandler.BountyInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.playerName_ = this.playerName_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.bounty_ = this.bounty_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                if (this.itemInfoBuilder_ == null) {
                    result.itemInfo_ = this.itemInfo_;
                } else {
                    result.itemInfo_ = (ItemOuterClass.CountItem) this.itemInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.preyId_ = this.preyId_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.hunterId_ = this.hunterId_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.isFinish_ = this.isFinish_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.BountyInfo)
                    return mergeFrom((RewardHandler.BountyInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.BountyInfo other) {
                if (other == RewardHandler.BountyInfo.getDefaultInstance())
                    return this;
                if (other.hasPlayerName()) {
                    this.bitField0_ |= 0x1;
                    this.playerName_ = other.playerName_;
                    onChanged();
                }
                if (other.hasBounty())
                    setBounty(other.getBounty());
                if (other.hasPro())
                    setPro(other.getPro());
                if (other.hasItemInfo())
                    mergeItemInfo(other.getItemInfo());
                if (other.hasPreyId()) {
                    this.bitField0_ |= 0x10;
                    this.preyId_ = other.preyId_;
                    onChanged();
                }
                if (other.hasHunterId()) {
                    this.bitField0_ |= 0x20;
                    this.hunterId_ = other.hunterId_;
                    onChanged();
                }
                if (other.hasIsFinish())
                    setIsFinish(other.getIsFinish());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPlayerName())
                    return false;
                if (!hasBounty())
                    return false;
                if (!hasPro())
                    return false;
                if (!hasItemInfo())
                    return false;
                if (!hasPreyId())
                    return false;
                if (!hasHunterId())
                    return false;
                if (!getItemInfo().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.BountyInfo parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.BountyInfo) RewardHandler.BountyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.BountyInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPlayerName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getPlayerName() {
                Object ref = this.playerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.playerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPlayerNameBytes() {
                Object ref = this.playerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerName_ = RewardHandler.BountyInfo.getDefaultInstance().getPlayerName();
                onChanged();
                return this;
            }

            public Builder setPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.playerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasBounty() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getBounty() {
                return this.bounty_;
            }

            public Builder setBounty(int value) {
                this.bitField0_ |= 0x2;
                this.bounty_ = value;
                onChanged();
                return this;
            }

            public Builder clearBounty() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.bounty_ = 0;
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

            public boolean hasItemInfo() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public ItemOuterClass.CountItem getItemInfo() {
                if (this.itemInfoBuilder_ == null)
                    return this.itemInfo_;
                return (ItemOuterClass.CountItem) this.itemInfoBuilder_.getMessage();
            }

            public Builder setItemInfo(ItemOuterClass.CountItem value) {
                if (this.itemInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.itemInfo_ = value;
                    onChanged();
                } else {
                    this.itemInfoBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder setItemInfo(ItemOuterClass.CountItem.Builder builderForValue) {
                if (this.itemInfoBuilder_ == null) {
                    this.itemInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemInfoBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder mergeItemInfo(ItemOuterClass.CountItem value) {
                if (this.itemInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.itemInfo_ != ItemOuterClass.CountItem.getDefaultInstance()) {
                        this.itemInfo_ = ItemOuterClass.CountItem.newBuilder(this.itemInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.itemInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.itemInfoBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder clearItemInfo() {
                if (this.itemInfoBuilder_ == null) {
                    this.itemInfo_ = ItemOuterClass.CountItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public ItemOuterClass.CountItem.Builder getItemInfoBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (ItemOuterClass.CountItem.Builder) getItemInfoFieldBuilder().getBuilder();
            }

            public ItemOuterClass.CountItemOrBuilder getItemInfoOrBuilder() {
                if (this.itemInfoBuilder_ != null)
                    return (ItemOuterClass.CountItemOrBuilder) this.itemInfoBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.CountItemOrBuilder) this.itemInfo_;
            }

            private SingleFieldBuilder<ItemOuterClass.CountItem, ItemOuterClass.CountItem.Builder, ItemOuterClass.CountItemOrBuilder> getItemInfoFieldBuilder() {
                if (this.itemInfoBuilder_ == null) {
                    this.itemInfoBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItemInfo(), getParentForChildren(), isClean());
                    this.itemInfo_ = null;
                }
                return this.itemInfoBuilder_;
            }

            public boolean hasPreyId() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getPreyId() {
                Object ref = this.preyId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.preyId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPreyIdBytes() {
                Object ref = this.preyId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.preyId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPreyId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.preyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPreyId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.preyId_ = RewardHandler.BountyInfo.getDefaultInstance().getPreyId();
                onChanged();
                return this;
            }

            public Builder setPreyIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.preyId_ = value;
                onChanged();
                return this;
            }

            public boolean hasHunterId() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getHunterId() {
                Object ref = this.hunterId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.hunterId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getHunterIdBytes() {
                Object ref = this.hunterId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.hunterId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setHunterId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.hunterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearHunterId() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.hunterId_ = RewardHandler.BountyInfo.getDefaultInstance().getHunterId();
                onChanged();
                return this;
            }

            public Builder setHunterIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.hunterId_ = value;
                onChanged();
                return this;
            }

            public boolean hasIsFinish() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(int value) {
                this.bitField0_ |= 0x40;
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.isFinish_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class CheckBountyRequest extends GeneratedMessage implements CheckBountyRequestOrBuilder {
        private static final CheckBountyRequest defaultInstance = new CheckBountyRequest(true);
        private final UnknownFieldSet unknownFields;

        private CheckBountyRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CheckBountyRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CheckBountyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CheckBountyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CheckBountyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RewardHandler.internal_static_pomelo_area_CheckBountyRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_CheckBountyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CheckBountyRequest.class, Builder.class);
        }

        public static Parser<CheckBountyRequest> PARSER = (Parser<CheckBountyRequest>) new AbstractParser<CheckBountyRequest>() {
            public RewardHandler.CheckBountyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.CheckBountyRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_INDEX_FIELD_NUMBER = 1;
        private int c2SIndex_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CheckBountyRequest> getParserForType() {
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

        public static CheckBountyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CheckBountyRequest) PARSER.parseFrom(data);
        }

        public static CheckBountyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CheckBountyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CheckBountyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CheckBountyRequest) PARSER.parseFrom(data);
        }

        public static CheckBountyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CheckBountyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CheckBountyRequest parseFrom(InputStream input) throws IOException {
            return (CheckBountyRequest) PARSER.parseFrom(input);
        }

        public static CheckBountyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CheckBountyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CheckBountyRequest) PARSER.parseDelimitedFrom(input);
        }

        public static CheckBountyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CheckBountyRequest parseFrom(CodedInputStream input) throws IOException {
            return (CheckBountyRequest) PARSER.parseFrom(input);
        }

        public static CheckBountyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CheckBountyRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.CheckBountyRequestOrBuilder {
            private int bitField0_;
            private int c2SIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_CheckBountyRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_CheckBountyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.CheckBountyRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RewardHandler.CheckBountyRequest.alwaysUseFieldBuilders) ;
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
                return RewardHandler.internal_static_pomelo_area_CheckBountyRequest_descriptor;
            }

            public RewardHandler.CheckBountyRequest getDefaultInstanceForType() {
                return RewardHandler.CheckBountyRequest.getDefaultInstance();
            }

            public RewardHandler.CheckBountyRequest build() {
                RewardHandler.CheckBountyRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.CheckBountyRequest buildPartial() {
                RewardHandler.CheckBountyRequest result = new RewardHandler.CheckBountyRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SIndex_ = this.c2SIndex_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.CheckBountyRequest)
                    return mergeFrom((RewardHandler.CheckBountyRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.CheckBountyRequest other) {
                if (other == RewardHandler.CheckBountyRequest.getDefaultInstance()) return this;
                if (other.hasC2SIndex()) setC2SIndex(other.getC2SIndex());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SIndex()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.CheckBountyRequest parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.CheckBountyRequest) RewardHandler.CheckBountyRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.CheckBountyRequest) e.getUnfinishedMessage();
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


    public static final class CheckBountyResponse
            extends GeneratedMessage
            implements CheckBountyResponseOrBuilder {
        private static final CheckBountyResponse defaultInstance = new CheckBountyResponse(true);
        private final UnknownFieldSet unknownFields;

        private CheckBountyResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CheckBountyResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CheckBountyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CheckBountyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CheckBountyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CBounty_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CBounty_.add(input.readMessage(RewardHandler.BountyInfo.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CRewardNum_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CBounty_ = Collections.unmodifiableList(this.s2CBounty_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RewardHandler.internal_static_pomelo_area_CheckBountyResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_CheckBountyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CheckBountyResponse.class, Builder.class);
        }

        public static Parser<CheckBountyResponse> PARSER = (Parser<CheckBountyResponse>) new AbstractParser<CheckBountyResponse>() {
            public RewardHandler.CheckBountyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.CheckBountyResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_BOUNTY_FIELD_NUMBER = 3;
        private List<RewardHandler.BountyInfo> s2CBounty_;
        public static final int S2C_REWARDNUM_FIELD_NUMBER = 4;
        private int s2CRewardNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CheckBountyResponse> getParserForType() {
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


        public List<RewardHandler.BountyInfo> getS2CBountyList() {
            return this.s2CBounty_;
        }


        public List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList() {
            return (List) this.s2CBounty_;
        }


        public int getS2CBountyCount() {
            return this.s2CBounty_.size();
        }


        public RewardHandler.BountyInfo getS2CBounty(int index) {
            return this.s2CBounty_.get(index);
        }


        public RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int index) {
            return this.s2CBounty_.get(index);
        }


        public boolean hasS2CRewardNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CRewardNum() {
            return this.s2CRewardNum_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CBounty_ = Collections.emptyList();
            this.s2CRewardNum_ = 0;
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
            for (int i = 0; i < getS2CBountyCount(); i++) {
                if (!getS2CBounty(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
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
            for (int i = 0; i < this.s2CBounty_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CBounty_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.s2CRewardNum_);
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
            for (int i = 0; i < this.s2CBounty_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CBounty_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CRewardNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static CheckBountyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CheckBountyResponse) PARSER.parseFrom(data);
        }


        public static CheckBountyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CheckBountyResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CheckBountyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CheckBountyResponse) PARSER.parseFrom(data);
        }


        public static CheckBountyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CheckBountyResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CheckBountyResponse parseFrom(InputStream input) throws IOException {
            return (CheckBountyResponse) PARSER.parseFrom(input);
        }


        public static CheckBountyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CheckBountyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CheckBountyResponse) PARSER.parseDelimitedFrom(input);
        }


        public static CheckBountyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CheckBountyResponse parseFrom(CodedInputStream input) throws IOException {
            return (CheckBountyResponse) PARSER.parseFrom(input);
        }


        public static CheckBountyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CheckBountyResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CheckBountyResponse prototype) {
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
                implements RewardHandler.CheckBountyResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private List<RewardHandler.BountyInfo> s2CBounty_;


            private RepeatedFieldBuilder<RewardHandler.BountyInfo, RewardHandler.BountyInfo.Builder, RewardHandler.BountyInfoOrBuilder> s2CBountyBuilder_;


            private int s2CRewardNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_CheckBountyResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_CheckBountyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.CheckBountyResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBounty_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBounty_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (RewardHandler.CheckBountyResponse.alwaysUseFieldBuilders) {
                    getS2CBountyFieldBuilder();
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
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBounty_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CBountyBuilder_.clear();
                }
                this.s2CRewardNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_CheckBountyResponse_descriptor;
            }


            public RewardHandler.CheckBountyResponse getDefaultInstanceForType() {
                return RewardHandler.CheckBountyResponse.getDefaultInstance();
            }


            public RewardHandler.CheckBountyResponse build() {
                RewardHandler.CheckBountyResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public RewardHandler.CheckBountyResponse buildPartial() {
                RewardHandler.CheckBountyResponse result = new RewardHandler.CheckBountyResponse(this);
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
                if (this.s2CBountyBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CBounty_ = Collections.unmodifiableList(this.s2CBounty_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CBounty_ = this.s2CBounty_;
                } else {
                    result.s2CBounty_ = this.s2CBountyBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CRewardNum_ = this.s2CRewardNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.CheckBountyResponse) {
                    return mergeFrom((RewardHandler.CheckBountyResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(RewardHandler.CheckBountyResponse other) {
                if (other == RewardHandler.CheckBountyResponse.getDefaultInstance()) {
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
                if (this.s2CBountyBuilder_ == null) {
                    if (!other.s2CBounty_.isEmpty()) {
                        if (this.s2CBounty_.isEmpty()) {
                            this.s2CBounty_ = other.s2CBounty_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CBountyIsMutable();
                            this.s2CBounty_.addAll(other.s2CBounty_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBounty_.isEmpty()) {
                    if (this.s2CBountyBuilder_.isEmpty()) {
                        this.s2CBountyBuilder_.dispose();
                        this.s2CBountyBuilder_ = null;
                        this.s2CBounty_ = other.s2CBounty_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CBountyBuilder_ = RewardHandler.CheckBountyResponse.alwaysUseFieldBuilders ? getS2CBountyFieldBuilder() : null;
                    } else {
                        this.s2CBountyBuilder_.addAllMessages(other.s2CBounty_);
                    }
                }
                if (other.hasS2CRewardNum()) {
                    setS2CRewardNum(other.getS2CRewardNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CBountyCount(); i++) {
                    if (!getS2CBounty(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.CheckBountyResponse parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.CheckBountyResponse) RewardHandler.CheckBountyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.CheckBountyResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RewardHandler.CheckBountyResponse.getDefaultInstance().getS2CMsg();
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


            private void ensureS2CBountyIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CBounty_ = new ArrayList<>(this.s2CBounty_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<RewardHandler.BountyInfo> getS2CBountyList() {
                if (this.s2CBountyBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CBounty_);
                }
                return this.s2CBountyBuilder_.getMessageList();
            }


            public int getS2CBountyCount() {
                if (this.s2CBountyBuilder_ == null) {
                    return this.s2CBounty_.size();
                }
                return this.s2CBountyBuilder_.getCount();
            }


            public RewardHandler.BountyInfo getS2CBounty(int index) {
                if (this.s2CBountyBuilder_ == null) {
                    return this.s2CBounty_.get(index);
                }
                return (RewardHandler.BountyInfo) this.s2CBountyBuilder_.getMessage(index);
            }


            public Builder setS2CBounty(int index, RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setS2CBounty(int index, RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addS2CBounty(RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addS2CBounty(int index, RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addS2CBounty(RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addS2CBounty(int index, RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CBounty(Iterable<? extends RewardHandler.BountyInfo> values) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBounty_);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearS2CBounty() {
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBounty_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.clear();
                }
                return this;
            }


            public Builder removeS2CBounty(int index) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.remove(index);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.remove(index);
                }
                return this;
            }


            public RewardHandler.BountyInfo.Builder getS2CBountyBuilder(int index) {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().getBuilder(index);
            }


            public RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int index) {
                if (this.s2CBountyBuilder_ == null) {
                    return this.s2CBounty_.get(index);
                }
                return (RewardHandler.BountyInfoOrBuilder) this.s2CBountyBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList() {
                if (this.s2CBountyBuilder_ != null) {
                    return this.s2CBountyBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CBounty_);
            }


            public RewardHandler.BountyInfo.Builder addS2CBountyBuilder() {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().addBuilder(RewardHandler.BountyInfo.getDefaultInstance());
            }


            public RewardHandler.BountyInfo.Builder addS2CBountyBuilder(int index) {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().addBuilder(index, RewardHandler.BountyInfo.getDefaultInstance());
            }


            public List<RewardHandler.BountyInfo.Builder> getS2CBountyBuilderList() {
                return getS2CBountyFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<RewardHandler.BountyInfo, RewardHandler.BountyInfo.Builder, RewardHandler.BountyInfoOrBuilder> getS2CBountyFieldBuilder() {
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBountyBuilder_ = new RepeatedFieldBuilder(this.s2CBounty_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CBounty_ = null;
                }
                return this.s2CBountyBuilder_;
            }


            public boolean hasS2CRewardNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CRewardNum() {
                return this.s2CRewardNum_;
            }


            public Builder setS2CRewardNum(int value) {
                this.bitField0_ |= 0x8;
                this.s2CRewardNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CRewardNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CRewardNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetAwardBountyRequest
            extends GeneratedMessage
            implements GetAwardBountyRequestOrBuilder {
        private static final GetAwardBountyRequest defaultInstance = new GetAwardBountyRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetAwardBountyRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAwardBountyRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAwardBountyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetAwardBountyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAwardBountyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPreyId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2SHunterId_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SBounty_ = input.readInt32();
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
            return RewardHandler.internal_static_pomelo_area_GetAwardBountyRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_GetAwardBountyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAwardBountyRequest.class, Builder.class);
        }

        public static Parser<GetAwardBountyRequest> PARSER = (Parser<GetAwardBountyRequest>) new AbstractParser<GetAwardBountyRequest>() {
            public RewardHandler.GetAwardBountyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.GetAwardBountyRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_PREYID_FIELD_NUMBER = 1;
        private Object c2SPreyId_;
        public static final int C2S_HUNTERID_FIELD_NUMBER = 2;
        private Object c2SHunterId_;
        public static final int C2S_BOUNTY_FIELD_NUMBER = 3;
        private int c2SBounty_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAwardBountyRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPreyId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SPreyId() {
            Object ref = this.c2SPreyId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SPreyId_ = s;
            return s;
        }

        public ByteString getC2SPreyIdBytes() {
            Object ref = this.c2SPreyId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SPreyId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasC2SHunterId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getC2SHunterId() {
            Object ref = this.c2SHunterId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SHunterId_ = s;
            }
            return s;
        }


        public ByteString getC2SHunterIdBytes() {
            Object ref = this.c2SHunterId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SHunterId_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SBounty() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SBounty() {
            return this.c2SBounty_;
        }


        private void initFields() {
            this.c2SPreyId_ = "";
            this.c2SHunterId_ = "";
            this.c2SBounty_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SPreyId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SHunterId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SBounty()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SPreyIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getC2SHunterIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SBounty_);
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
                size += CodedOutputStream.computeBytesSize(1, getC2SPreyIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getC2SHunterIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SBounty_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetAwardBountyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAwardBountyRequest) PARSER.parseFrom(data);
        }


        public static GetAwardBountyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAwardBountyRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAwardBountyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAwardBountyRequest) PARSER.parseFrom(data);
        }


        public static GetAwardBountyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAwardBountyRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAwardBountyRequest parseFrom(InputStream input) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseFrom(input);
        }


        public static GetAwardBountyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetAwardBountyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetAwardBountyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetAwardBountyRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseFrom(input);
        }


        public static GetAwardBountyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetAwardBountyRequest prototype) {
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
                implements RewardHandler.GetAwardBountyRequestOrBuilder {
            private int bitField0_;


            private Object c2SPreyId_;


            private Object c2SHunterId_;


            private int c2SBounty_;


            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.GetAwardBountyRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SPreyId_ = "";
                this.c2SHunterId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SPreyId_ = "";
                this.c2SHunterId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (RewardHandler.GetAwardBountyRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SPreyId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SHunterId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SBounty_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyRequest_descriptor;
            }


            public RewardHandler.GetAwardBountyRequest getDefaultInstanceForType() {
                return RewardHandler.GetAwardBountyRequest.getDefaultInstance();
            }


            public RewardHandler.GetAwardBountyRequest build() {
                RewardHandler.GetAwardBountyRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public RewardHandler.GetAwardBountyRequest buildPartial() {
                RewardHandler.GetAwardBountyRequest result = new RewardHandler.GetAwardBountyRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SPreyId_ = this.c2SPreyId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SHunterId_ = this.c2SHunterId_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SBounty_ = this.c2SBounty_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.GetAwardBountyRequest) {
                    return mergeFrom((RewardHandler.GetAwardBountyRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(RewardHandler.GetAwardBountyRequest other) {
                if (other == RewardHandler.GetAwardBountyRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SPreyId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SPreyId_ = other.c2SPreyId_;
                    onChanged();
                }
                if (other.hasC2SHunterId()) {
                    this.bitField0_ |= 0x2;
                    this.c2SHunterId_ = other.c2SHunterId_;
                    onChanged();
                }
                if (other.hasC2SBounty()) {
                    setC2SBounty(other.getC2SBounty());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SPreyId()) {
                    return false;
                }
                if (!hasC2SHunterId()) {
                    return false;
                }
                if (!hasC2SBounty()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.GetAwardBountyRequest parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.GetAwardBountyRequest) RewardHandler.GetAwardBountyRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.GetAwardBountyRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SPreyId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SPreyId() {
                Object ref = this.c2SPreyId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SPreyId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SPreyIdBytes() {
                Object ref = this.c2SPreyId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SPreyId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SPreyId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SPreyId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPreyId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPreyId_ = RewardHandler.GetAwardBountyRequest.getDefaultInstance().getC2SPreyId();
                onChanged();
                return this;
            }


            public Builder setC2SPreyIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SPreyId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SHunterId() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getC2SHunterId() {
                Object ref = this.c2SHunterId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SHunterId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SHunterIdBytes() {
                Object ref = this.c2SHunterId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SHunterId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SHunterId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SHunterId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SHunterId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SHunterId_ = RewardHandler.GetAwardBountyRequest.getDefaultInstance().getC2SHunterId();
                onChanged();
                return this;
            }


            public Builder setC2SHunterIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SHunterId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SBounty() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SBounty() {
                return this.c2SBounty_;
            }


            public Builder setC2SBounty(int value) {
                this.bitField0_ |= 0x4;
                this.c2SBounty_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SBounty() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SBounty_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetAwardBountyResponse
            extends GeneratedMessage
            implements GetAwardBountyResponseOrBuilder {
        private static final GetAwardBountyResponse defaultInstance = new GetAwardBountyResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetAwardBountyResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAwardBountyResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAwardBountyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetAwardBountyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAwardBountyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RewardHandler.internal_static_pomelo_area_GetAwardBountyResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_GetAwardBountyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAwardBountyResponse.class, Builder.class);
        }

        public static Parser<GetAwardBountyResponse> PARSER = (Parser<GetAwardBountyResponse>) new AbstractParser<GetAwardBountyResponse>() {
            public RewardHandler.GetAwardBountyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.GetAwardBountyResponse(input, extensionRegistry);
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

        public Parser<GetAwardBountyResponse> getParserForType() {
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

        public static GetAwardBountyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAwardBountyResponse) PARSER.parseFrom(data);
        }

        public static GetAwardBountyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAwardBountyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAwardBountyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAwardBountyResponse) PARSER.parseFrom(data);
        }

        public static GetAwardBountyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAwardBountyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAwardBountyResponse parseFrom(InputStream input) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseFrom(input);
        }

        public static GetAwardBountyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAwardBountyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetAwardBountyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAwardBountyResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseFrom(input);
        }

        public static GetAwardBountyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAwardBountyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAwardBountyResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.GetAwardBountyResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.GetAwardBountyResponse.class, Builder.class);
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
                if (RewardHandler.GetAwardBountyResponse.alwaysUseFieldBuilders) ;
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
                return RewardHandler.internal_static_pomelo_area_GetAwardBountyResponse_descriptor;
            }

            public RewardHandler.GetAwardBountyResponse getDefaultInstanceForType() {
                return RewardHandler.GetAwardBountyResponse.getDefaultInstance();
            }

            public RewardHandler.GetAwardBountyResponse build() {
                RewardHandler.GetAwardBountyResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.GetAwardBountyResponse buildPartial() {
                RewardHandler.GetAwardBountyResponse result = new RewardHandler.GetAwardBountyResponse(this);
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
                if (other instanceof RewardHandler.GetAwardBountyResponse)
                    return mergeFrom((RewardHandler.GetAwardBountyResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.GetAwardBountyResponse other) {
                if (other == RewardHandler.GetAwardBountyResponse.getDefaultInstance())
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
                RewardHandler.GetAwardBountyResponse parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.GetAwardBountyResponse) RewardHandler.GetAwardBountyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.GetAwardBountyResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RewardHandler.GetAwardBountyResponse.getDefaultInstance().getS2CMsg();
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

    public static final class FinishRewardRequest extends GeneratedMessage implements FinishRewardRequestOrBuilder {
        private static final FinishRewardRequest defaultInstance = new FinishRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private FinishRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FinishRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FinishRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FinishRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FinishRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RewardHandler.internal_static_pomelo_area_FinishRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_FinishRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishRewardRequest.class, Builder.class);
        }

        public static Parser<FinishRewardRequest> PARSER = (Parser<FinishRewardRequest>) new AbstractParser<FinishRewardRequest>() {
            public RewardHandler.FinishRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.FinishRewardRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FinishRewardRequest> getParserForType() {
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

        public static FinishRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FinishRewardRequest) PARSER.parseFrom(data);
        }

        public static FinishRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FinishRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FinishRewardRequest) PARSER.parseFrom(data);
        }

        public static FinishRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FinishRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishRewardRequest parseFrom(InputStream input) throws IOException {
            return (FinishRewardRequest) PARSER.parseFrom(input);
        }

        public static FinishRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FinishRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FinishRewardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static FinishRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FinishRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (FinishRewardRequest) PARSER.parseFrom(input);
        }

        public static FinishRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FinishRewardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.FinishRewardRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_FinishRewardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_FinishRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.FinishRewardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RewardHandler.FinishRewardRequest.alwaysUseFieldBuilders) ;
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
                return RewardHandler.internal_static_pomelo_area_FinishRewardRequest_descriptor;
            }

            public RewardHandler.FinishRewardRequest getDefaultInstanceForType() {
                return RewardHandler.FinishRewardRequest.getDefaultInstance();
            }

            public RewardHandler.FinishRewardRequest build() {
                RewardHandler.FinishRewardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.FinishRewardRequest buildPartial() {
                RewardHandler.FinishRewardRequest result = new RewardHandler.FinishRewardRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.FinishRewardRequest)
                    return mergeFrom((RewardHandler.FinishRewardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.FinishRewardRequest other) {
                if (other == RewardHandler.FinishRewardRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.FinishRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.FinishRewardRequest) RewardHandler.FinishRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.FinishRewardRequest) e.getUnfinishedMessage();
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


    public static final class FinishRewardResponse
            extends GeneratedMessage
            implements FinishRewardResponseOrBuilder {
        private static final FinishRewardResponse defaultInstance = new FinishRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private FinishRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FinishRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FinishRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FinishRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FinishRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CBounty_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CBounty_.add(input.readMessage(RewardHandler.BountyInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CBounty_ = Collections.unmodifiableList(this.s2CBounty_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RewardHandler.internal_static_pomelo_area_FinishRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RewardHandler.internal_static_pomelo_area_FinishRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishRewardResponse.class, Builder.class);
        }

        public static Parser<FinishRewardResponse> PARSER = (Parser<FinishRewardResponse>) new AbstractParser<FinishRewardResponse>() {
            public RewardHandler.FinishRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RewardHandler.FinishRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_BOUNTY_FIELD_NUMBER = 3;
        private List<RewardHandler.BountyInfo> s2CBounty_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FinishRewardResponse> getParserForType() {
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

        public List<RewardHandler.BountyInfo> getS2CBountyList() {
            return this.s2CBounty_;
        }

        public List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList() {
            return (List) this.s2CBounty_;
        }

        public int getS2CBountyCount() {
            return this.s2CBounty_.size();
        }

        public RewardHandler.BountyInfo getS2CBounty(int index) {
            return this.s2CBounty_.get(index);
        }

        public RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int index) {
            return this.s2CBounty_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CBounty_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CBountyCount(); i++) {
                if (!getS2CBounty(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CBounty_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CBounty_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CBounty_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CBounty_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FinishRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FinishRewardResponse) PARSER.parseFrom(data);
        }

        public static FinishRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FinishRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FinishRewardResponse) PARSER.parseFrom(data);
        }

        public static FinishRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FinishRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishRewardResponse parseFrom(InputStream input) throws IOException {
            return (FinishRewardResponse) PARSER.parseFrom(input);
        }

        public static FinishRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FinishRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FinishRewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FinishRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FinishRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (FinishRewardResponse) PARSER.parseFrom(input);
        }

        public static FinishRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FinishRewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        static {
            defaultInstance.initFields();
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RewardHandler.FinishRewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<RewardHandler.BountyInfo> s2CBounty_;
            private RepeatedFieldBuilder<RewardHandler.BountyInfo, RewardHandler.BountyInfo.Builder, RewardHandler.BountyInfoOrBuilder> s2CBountyBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RewardHandler.internal_static_pomelo_area_FinishRewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RewardHandler.internal_static_pomelo_area_FinishRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardHandler.FinishRewardResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBounty_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBounty_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RewardHandler.FinishRewardResponse.alwaysUseFieldBuilders) getS2CBountyFieldBuilder();
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
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBounty_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CBountyBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RewardHandler.internal_static_pomelo_area_FinishRewardResponse_descriptor;
            }

            public RewardHandler.FinishRewardResponse getDefaultInstanceForType() {
                return RewardHandler.FinishRewardResponse.getDefaultInstance();
            }

            public RewardHandler.FinishRewardResponse build() {
                RewardHandler.FinishRewardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RewardHandler.FinishRewardResponse buildPartial() {
                RewardHandler.FinishRewardResponse result = new RewardHandler.FinishRewardResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CBountyBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CBounty_ = Collections.unmodifiableList(this.s2CBounty_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CBounty_ = this.s2CBounty_;
                } else {
                    result.s2CBounty_ = this.s2CBountyBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RewardHandler.FinishRewardResponse)
                    return mergeFrom((RewardHandler.FinishRewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RewardHandler.FinishRewardResponse other) {
                if (other == RewardHandler.FinishRewardResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CBountyBuilder_ == null) {
                    if (!other.s2CBounty_.isEmpty()) {
                        if (this.s2CBounty_.isEmpty()) {
                            this.s2CBounty_ = other.s2CBounty_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CBountyIsMutable();
                            this.s2CBounty_.addAll(other.s2CBounty_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBounty_.isEmpty()) {
                    if (this.s2CBountyBuilder_.isEmpty()) {
                        this.s2CBountyBuilder_.dispose();
                        this.s2CBountyBuilder_ = null;
                        this.s2CBounty_ = other.s2CBounty_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CBountyBuilder_ = RewardHandler.FinishRewardResponse.alwaysUseFieldBuilders ? getS2CBountyFieldBuilder() : null;
                    } else {
                        this.s2CBountyBuilder_.addAllMessages(other.s2CBounty_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CBountyCount(); i++) {
                    if (!getS2CBounty(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RewardHandler.FinishRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (RewardHandler.FinishRewardResponse) RewardHandler.FinishRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RewardHandler.FinishRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RewardHandler.FinishRewardResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CBountyIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CBounty_ = new ArrayList<>(this.s2CBounty_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<RewardHandler.BountyInfo> getS2CBountyList() {
                if (this.s2CBountyBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CBounty_);
                return this.s2CBountyBuilder_.getMessageList();
            }

            public int getS2CBountyCount() {
                if (this.s2CBountyBuilder_ == null)
                    return this.s2CBounty_.size();
                return this.s2CBountyBuilder_.getCount();
            }

            public RewardHandler.BountyInfo getS2CBounty(int index) {
                if (this.s2CBountyBuilder_ == null)
                    return this.s2CBounty_.get(index);
                return (RewardHandler.BountyInfo) this.s2CBountyBuilder_.getMessage(index);
            }

            public Builder setS2CBounty(int index, RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CBounty(int index, RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBounty(RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CBounty(int index, RewardHandler.BountyInfo value) {
                if (this.s2CBountyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CBounty(RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBounty(int index, RewardHandler.BountyInfo.Builder builderForValue) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CBounty(Iterable<? extends RewardHandler.BountyInfo> values) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBounty_);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CBounty() {
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBounty_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CBounty(int index) {
                if (this.s2CBountyBuilder_ == null) {
                    ensureS2CBountyIsMutable();
                    this.s2CBounty_.remove(index);
                    onChanged();
                } else {
                    this.s2CBountyBuilder_.remove(index);
                }
                return this;
            }

            public RewardHandler.BountyInfo.Builder getS2CBountyBuilder(int index) {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().getBuilder(index);
            }

            public RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int index) {
                if (this.s2CBountyBuilder_ == null)
                    return this.s2CBounty_.get(index);
                return (RewardHandler.BountyInfoOrBuilder) this.s2CBountyBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList() {
                if (this.s2CBountyBuilder_ != null)
                    return this.s2CBountyBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CBounty_);
            }

            public RewardHandler.BountyInfo.Builder addS2CBountyBuilder() {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().addBuilder(RewardHandler.BountyInfo.getDefaultInstance());
            }

            public RewardHandler.BountyInfo.Builder addS2CBountyBuilder(int index) {
                return (RewardHandler.BountyInfo.Builder) getS2CBountyFieldBuilder().addBuilder(index, RewardHandler.BountyInfo.getDefaultInstance());
            }

            public List<RewardHandler.BountyInfo.Builder> getS2CBountyBuilderList() {
                return getS2CBountyFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RewardHandler.BountyInfo, RewardHandler.BountyInfo.Builder, RewardHandler.BountyInfoOrBuilder> getS2CBountyFieldBuilder() {
                if (this.s2CBountyBuilder_ == null) {
                    this.s2CBountyBuilder_ = new RepeatedFieldBuilder(this.s2CBounty_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CBounty_ = null;
                }
                return this.s2CBountyBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\023rewardHandler.proto\022\013pomelo.area\032\nitem.proto\"\023\n\021RewardDeskRequest\"d\n\022RewardDeskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\fs2c_itemInfo\030\003 \002(\0132\025.pomelo.item.MiniItem\"'\n\rRewardRequest\022\026\n\016c2s_playerName\030\001 \002(\t\"3\n\016RewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\001\n\nBountyInfo\022\022\n\nplayerName\030\001 \002(\t\022\016\n\006bounty\030\002 \002(\005\022\013\n\003pro\030\003 \002(\005\022(\n\bitemInfo\030\004 \002(\0132\026.pomelo.item.CountItem\022\016\n\006preyId\030\005 \002(\t\022\020\n\bhunterId\030\006 ", "\002(\t\022\020\n\bisFinish\030\007 \001(\005\"'\n\022CheckBountyRequest\022\021\n\tc2s_index\030\001 \002(\005\"|\n\023CheckBountyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\ns2c_bounty\030\003 \003(\0132\027.pomelo.area.BountyInfo\022\025\n\rs2c_rewardNum\030\004 \001(\005\"U\n\025GetAwardBountyRequest\022\022\n\nc2s_preyId\030\001 \002(\t\022\024\n\fc2s_hunterId\030\002 \002(\t\022\022\n\nc2s_bounty\030\003 \002(\005\";\n\026GetAwardBountyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\025\n\023FinishRewardRequest\"f\n\024FinishRewardResponse\022\020\n\bs2c_code\030\001 \002(", "\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\ns2c_bounty\030\003 \003(\0132\027.pomelo.area.BountyInfo2Æ\003\n\rrewardHandler\022T\n\021rewardDeskRequest\022\036.pomelo.area.RewardDeskRequest\032\037.pomelo.area.RewardDeskResponse\022H\n\rrewardRequest\022\032.pomelo.area.RewardRequest\032\033.pomelo.area.RewardResponse\022W\n\022checkBountyRequest\022\037.pomelo.area.CheckBountyRequest\032 .pomelo.area.CheckBountyResponse\022Z\n\023getHasFinishRequest\022 .pomelo.area.FinishRewardRequest\032!.pomelo.are", "a.FinishRewardResponse\022`\n\025getAwardBountyRequest\022\".pomelo.area.GetAwardBountyRequest\032#.pomelo.area.GetAwardBountyResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                RewardHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardDeskRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardDeskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardDeskRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardDeskResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardDeskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardDeskResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CItemInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardRequest_descriptor, new String[]{"C2SPlayerName"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BountyInfo_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BountyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BountyInfo_descriptor, new String[]{"PlayerName", "Bounty", "Pro", "ItemInfo", "PreyId", "HunterId", "IsFinish"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CheckBountyRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CheckBountyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CheckBountyRequest_descriptor, new String[]{"C2SIndex"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CheckBountyResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CheckBountyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CheckBountyResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CBounty", "S2CRewardNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAwardBountyRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAwardBountyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAwardBountyRequest_descriptor, new String[]{"C2SPreyId", "C2SHunterId", "C2SBounty"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAwardBountyResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAwardBountyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAwardBountyResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_FinishRewardRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FinishRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FinishRewardRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_FinishRewardResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FinishRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FinishRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CBounty"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
    }

    public static interface FinishRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<RewardHandler.BountyInfo> getS2CBountyList();

        RewardHandler.BountyInfo getS2CBounty(int param1Int);

        int getS2CBountyCount();

        List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList();

        RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int param1Int);
    }

    public static interface FinishRewardRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetAwardBountyResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GetAwardBountyRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPreyId();

        String getC2SPreyId();

        ByteString getC2SPreyIdBytes();

        boolean hasC2SHunterId();

        String getC2SHunterId();

        ByteString getC2SHunterIdBytes();

        boolean hasC2SBounty();

        int getC2SBounty();
    }

    public static interface CheckBountyResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<RewardHandler.BountyInfo> getS2CBountyList();

        RewardHandler.BountyInfo getS2CBounty(int param1Int);

        int getS2CBountyCount();

        List<? extends RewardHandler.BountyInfoOrBuilder> getS2CBountyOrBuilderList();

        RewardHandler.BountyInfoOrBuilder getS2CBountyOrBuilder(int param1Int);

        boolean hasS2CRewardNum();

        int getS2CRewardNum();
    }

    public static interface CheckBountyRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SIndex();

        int getC2SIndex();
    }

    public static interface BountyInfoOrBuilder extends MessageOrBuilder {
        boolean hasPlayerName();

        String getPlayerName();

        ByteString getPlayerNameBytes();

        boolean hasBounty();

        int getBounty();

        boolean hasPro();

        int getPro();

        boolean hasItemInfo();

        ItemOuterClass.CountItem getItemInfo();

        ItemOuterClass.CountItemOrBuilder getItemInfoOrBuilder();

        boolean hasPreyId();

        String getPreyId();

        ByteString getPreyIdBytes();

        boolean hasHunterId();

        String getHunterId();

        ByteString getHunterIdBytes();

        boolean hasIsFinish();

        int getIsFinish();
    }

    public static interface RewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface RewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPlayerName();

        String getC2SPlayerName();

        ByteString getC2SPlayerNameBytes();
    }

    public static interface RewardDeskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CItemInfo();

        ItemOuterClass.MiniItem getS2CItemInfo();

        ItemOuterClass.MiniItemOrBuilder getS2CItemInfoOrBuilder();
    }

    public static interface RewardDeskRequestOrBuilder extends MessageOrBuilder {
    }
}


