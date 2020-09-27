package pomelo.auction;

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
import pomelo.item.ItemOuterClass;


public final class AuctionHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class SyncAuctionInfoRequest
            extends GeneratedMessage
            implements SyncAuctionInfoRequestOrBuilder {
        private static final SyncAuctionInfoRequest defaultInstance = new SyncAuctionInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private SyncAuctionInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SyncAuctionInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SyncAuctionInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SyncAuctionInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SyncAuctionInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncAuctionInfoRequest.class, Builder.class);
        }

        public static Parser<SyncAuctionInfoRequest> PARSER = (Parser<SyncAuctionInfoRequest>) new AbstractParser<SyncAuctionInfoRequest>() {
            public AuctionHandler.SyncAuctionInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.SyncAuctionInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SyncAuctionInfoRequest> getParserForType() {
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


        public static SyncAuctionInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(data);
        }


        public static SyncAuctionInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SyncAuctionInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(data);
        }


        public static SyncAuctionInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SyncAuctionInfoRequest parseFrom(InputStream input) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(input);
        }


        public static SyncAuctionInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SyncAuctionInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static SyncAuctionInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SyncAuctionInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(input);
        }


        public static SyncAuctionInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SyncAuctionInfoRequest prototype) {
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
                implements AuctionHandler.SyncAuctionInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.SyncAuctionInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.SyncAuctionInfoRequest.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoRequest_descriptor;
            }


            public AuctionHandler.SyncAuctionInfoRequest getDefaultInstanceForType() {
                return AuctionHandler.SyncAuctionInfoRequest.getDefaultInstance();
            }


            public AuctionHandler.SyncAuctionInfoRequest build() {
                AuctionHandler.SyncAuctionInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AuctionHandler.SyncAuctionInfoRequest buildPartial() {
                AuctionHandler.SyncAuctionInfoRequest result = new AuctionHandler.SyncAuctionInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.SyncAuctionInfoRequest) {
                    return mergeFrom((AuctionHandler.SyncAuctionInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AuctionHandler.SyncAuctionInfoRequest other) {
                if (other == AuctionHandler.SyncAuctionInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.SyncAuctionInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.SyncAuctionInfoRequest) AuctionHandler.SyncAuctionInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.SyncAuctionInfoRequest) e.getUnfinishedMessage();
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


    public static final class SyncAuctionInfoResponse
            extends GeneratedMessage
            implements SyncAuctionInfoResponseOrBuilder {
        private static final SyncAuctionInfoResponse defaultInstance = new SyncAuctionInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private SyncAuctionInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SyncAuctionInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SyncAuctionInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SyncAuctionInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SyncAuctionInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncAuctionInfoResponse.class, Builder.class);
        }

        public static Parser<SyncAuctionInfoResponse> PARSER = (Parser<SyncAuctionInfoResponse>) new AbstractParser<SyncAuctionInfoResponse>() {
            public AuctionHandler.SyncAuctionInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.SyncAuctionInfoResponse(input, extensionRegistry);
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

        public Parser<SyncAuctionInfoResponse> getParserForType() {
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

        public static SyncAuctionInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(data);
        }

        public static SyncAuctionInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncAuctionInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(data);
        }

        public static SyncAuctionInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SyncAuctionInfoResponse parseFrom(InputStream input) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(input);
        }

        public static SyncAuctionInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SyncAuctionInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static SyncAuctionInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SyncAuctionInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(input);
        }

        public static SyncAuctionInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SyncAuctionInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SyncAuctionInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.SyncAuctionInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.SyncAuctionInfoResponse.class, Builder.class);
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
                if (AuctionHandler.SyncAuctionInfoResponse.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_SyncAuctionInfoResponse_descriptor;
            }

            public AuctionHandler.SyncAuctionInfoResponse getDefaultInstanceForType() {
                return AuctionHandler.SyncAuctionInfoResponse.getDefaultInstance();
            }

            public AuctionHandler.SyncAuctionInfoResponse build() {
                AuctionHandler.SyncAuctionInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.SyncAuctionInfoResponse buildPartial() {
                AuctionHandler.SyncAuctionInfoResponse result = new AuctionHandler.SyncAuctionInfoResponse(this);
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
                if (other instanceof AuctionHandler.SyncAuctionInfoResponse)
                    return mergeFrom((AuctionHandler.SyncAuctionInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.SyncAuctionInfoResponse other) {
                if (other == AuctionHandler.SyncAuctionInfoResponse.getDefaultInstance())
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
                AuctionHandler.SyncAuctionInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.SyncAuctionInfoResponse) AuctionHandler.SyncAuctionInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.SyncAuctionInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AuctionHandler.SyncAuctionInfoResponse.getDefaultInstance().getS2CMsg();
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

    public static final class CancelSyncAuctionInfoRequest extends GeneratedMessage implements CancelSyncAuctionInfoRequestOrBuilder {
        private static final CancelSyncAuctionInfoRequest defaultInstance = new CancelSyncAuctionInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private CancelSyncAuctionInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CancelSyncAuctionInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CancelSyncAuctionInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CancelSyncAuctionInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CancelSyncAuctionInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CancelSyncAuctionInfoRequest.class, Builder.class);
        }

        public static Parser<CancelSyncAuctionInfoRequest> PARSER = (Parser<CancelSyncAuctionInfoRequest>) new AbstractParser<CancelSyncAuctionInfoRequest>() {
            public AuctionHandler.CancelSyncAuctionInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.CancelSyncAuctionInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CancelSyncAuctionInfoRequest> getParserForType() {
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


        public static CancelSyncAuctionInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(data);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(data);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(InputStream input) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(input);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CancelSyncAuctionInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static CancelSyncAuctionInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(input);
        }


        public static CancelSyncAuctionInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CancelSyncAuctionInfoRequest prototype) {
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
                implements AuctionHandler.CancelSyncAuctionInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.CancelSyncAuctionInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.CancelSyncAuctionInfoRequest.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_descriptor;
            }


            public AuctionHandler.CancelSyncAuctionInfoRequest getDefaultInstanceForType() {
                return AuctionHandler.CancelSyncAuctionInfoRequest.getDefaultInstance();
            }


            public AuctionHandler.CancelSyncAuctionInfoRequest build() {
                AuctionHandler.CancelSyncAuctionInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AuctionHandler.CancelSyncAuctionInfoRequest buildPartial() {
                AuctionHandler.CancelSyncAuctionInfoRequest result = new AuctionHandler.CancelSyncAuctionInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.CancelSyncAuctionInfoRequest) {
                    return mergeFrom((AuctionHandler.CancelSyncAuctionInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AuctionHandler.CancelSyncAuctionInfoRequest other) {
                if (other == AuctionHandler.CancelSyncAuctionInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.CancelSyncAuctionInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.CancelSyncAuctionInfoRequest) AuctionHandler.CancelSyncAuctionInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.CancelSyncAuctionInfoRequest) e.getUnfinishedMessage();
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


    public static final class CancelSyncAuctionInfoResponse
            extends GeneratedMessage
            implements CancelSyncAuctionInfoResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private CancelSyncAuctionInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private CancelSyncAuctionInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static CancelSyncAuctionInfoResponse getDefaultInstance() {
            return defaultInstance;
        }


        public CancelSyncAuctionInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private CancelSyncAuctionInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CancelSyncAuctionInfoResponse.class, Builder.class);
        }


        public static Parser<CancelSyncAuctionInfoResponse> PARSER = (Parser<CancelSyncAuctionInfoResponse>) new AbstractParser<CancelSyncAuctionInfoResponse>() {
            public AuctionHandler.CancelSyncAuctionInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.CancelSyncAuctionInfoResponse(input, extensionRegistry);
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


        public Parser<CancelSyncAuctionInfoResponse> getParserForType() {
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


        public static CancelSyncAuctionInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(data);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(data);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(InputStream input) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(input);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CancelSyncAuctionInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static CancelSyncAuctionInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(input);
        }


        public static CancelSyncAuctionInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelSyncAuctionInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        private static final CancelSyncAuctionInfoResponse defaultInstance = new CancelSyncAuctionInfoResponse(true);

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CancelSyncAuctionInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.CancelSyncAuctionInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.CancelSyncAuctionInfoResponse.class, Builder.class);
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
                if (AuctionHandler.CancelSyncAuctionInfoResponse.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_descriptor;
            }

            public AuctionHandler.CancelSyncAuctionInfoResponse getDefaultInstanceForType() {
                return AuctionHandler.CancelSyncAuctionInfoResponse.getDefaultInstance();
            }

            public AuctionHandler.CancelSyncAuctionInfoResponse build() {
                AuctionHandler.CancelSyncAuctionInfoResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.CancelSyncAuctionInfoResponse buildPartial() {
                AuctionHandler.CancelSyncAuctionInfoResponse result = new AuctionHandler.CancelSyncAuctionInfoResponse(this);
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
                if (other instanceof AuctionHandler.CancelSyncAuctionInfoResponse)
                    return mergeFrom((AuctionHandler.CancelSyncAuctionInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.CancelSyncAuctionInfoResponse other) {
                if (other == AuctionHandler.CancelSyncAuctionInfoResponse.getDefaultInstance()) return this;
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
                AuctionHandler.CancelSyncAuctionInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.CancelSyncAuctionInfoResponse) AuctionHandler.CancelSyncAuctionInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.CancelSyncAuctionInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AuctionHandler.CancelSyncAuctionInfoResponse.getDefaultInstance().getS2CMsg();
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

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AuctionItem
            extends GeneratedMessage
            implements AuctionItemOrBuilder {
        private final UnknownFieldSet unknownFields;


        private AuctionItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private AuctionItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static AuctionItem getDefaultInstance() {
            return defaultInstance;
        }


        public AuctionItem getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private AuctionItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    ItemOuterClass.ItemDetail.Builder subBuilder;
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.id_ = byteString1;
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) {
                                subBuilder = this.detail_.toBuilder();
                            }
                            this.detail_ = (ItemOuterClass.ItemDetail) input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.detail_);
                                this.detail_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.state_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.timeleft_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.curPrice_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.maxPrice_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.self_ = input.readBool();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.num_ = input.readInt32();
                            break;
                        case 74:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x100;
                            this.source_ = bs;
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionItem_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionItem.class, Builder.class);
        }


        public static Parser<AuctionItem> PARSER = (Parser<AuctionItem>) new AbstractParser<AuctionItem>() {
            public AuctionHandler.AuctionItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionItem(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int ID_FIELD_NUMBER = 1;


        private Object id_;


        public static final int DETAIL_FIELD_NUMBER = 2;


        private ItemOuterClass.ItemDetail detail_;


        public static final int STATE_FIELD_NUMBER = 3;


        private int state_;


        public static final int TIMELEFT_FIELD_NUMBER = 4;


        private int timeleft_;


        public static final int CURPRICE_FIELD_NUMBER = 5;


        private int curPrice_;


        public static final int MAXPRICE_FIELD_NUMBER = 6;


        private int maxPrice_;


        public static final int SELF_FIELD_NUMBER = 7;


        private boolean self_;


        public static final int NUM_FIELD_NUMBER = 8;


        private int num_;


        public static final int SOURCE_FIELD_NUMBER = 9;


        private static final AuctionItem defaultInstance = new AuctionItem(true);
        private Object source_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionItem> getParserForType() {
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

        public boolean hasDetail() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public ItemOuterClass.ItemDetail getDetail() {
            return this.detail_;
        }

        public ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder() {
            return (ItemOuterClass.ItemDetailOrBuilder) this.detail_;
        }

        public boolean hasState() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getState() {
            return this.state_;
        }

        public boolean hasTimeleft() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getTimeleft() {
            return this.timeleft_;
        }

        public boolean hasCurPrice() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getCurPrice() {
            return this.curPrice_;
        }

        public boolean hasMaxPrice() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getMaxPrice() {
            return this.maxPrice_;
        }

        public boolean hasSelf() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public boolean getSelf() {
            return this.self_;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getNum() {
            return this.num_;
        }

        public boolean hasSource() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public String getSource() {
            Object ref = this.source_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.source_ = s;
            return s;
        }

        public ByteString getSourceBytes() {
            Object ref = this.source_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.source_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.id_ = "";
            this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
            this.state_ = 0;
            this.timeleft_ = 0;
            this.curPrice_ = 0;
            this.maxPrice_ = 0;
            this.self_ = false;
            this.num_ = 0;
            this.source_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDetail()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasState()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getDetail().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
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
                output.writeBytes(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeMessage(2, (MessageLite) this.detail_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.state_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.timeleft_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.curPrice_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.maxPrice_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeBool(7, this.self_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.num_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeBytes(9, getSourceBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.detail_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.state_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.timeleft_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.curPrice_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.maxPrice_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeBoolSize(7, this.self_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.num_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeBytesSize(9, getSourceBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AuctionItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionItem) PARSER.parseFrom(data);
        }

        public static AuctionItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionItem) PARSER.parseFrom(data);
        }

        public static AuctionItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionItem parseFrom(InputStream input) throws IOException {
            return (AuctionItem) PARSER.parseFrom(input);
        }

        public static AuctionItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AuctionItem parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionItem) PARSER.parseDelimitedFrom(input);
        }

        public static AuctionItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AuctionItem parseFrom(CodedInputStream input) throws IOException {
            return (AuctionItem) PARSER.parseFrom(input);
        }

        public static AuctionItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AuctionItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.AuctionItemOrBuilder {
            private int bitField0_;
            private Object id_;
            private ItemOuterClass.ItemDetail detail_;
            private SingleFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> detailBuilder_;
            private int state_;
            private int timeleft_;
            private int curPrice_;
            private int maxPrice_;
            private boolean self_;
            private int num_;
            private Object source_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionItem.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
                this.source_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
                this.source_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionItem.alwaysUseFieldBuilders)
                    getDetailFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.detailBuilder_ == null) {
                    this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
                } else {
                    this.detailBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.timeleft_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.curPrice_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.maxPrice_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.self_ = false;
                this.bitField0_ &= 0xFFFFFFBF;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.source_ = "";
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItem_descriptor;
            }

            public AuctionHandler.AuctionItem getDefaultInstanceForType() {
                return AuctionHandler.AuctionItem.getDefaultInstance();
            }

            public AuctionHandler.AuctionItem build() {
                AuctionHandler.AuctionItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.AuctionItem buildPartial() {
                AuctionHandler.AuctionItem result = new AuctionHandler.AuctionItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                if (this.detailBuilder_ == null) {
                    result.detail_ = this.detail_;
                } else {
                    result.detail_ = (ItemOuterClass.ItemDetail) this.detailBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.state_ = this.state_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.timeleft_ = this.timeleft_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.curPrice_ = this.curPrice_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.maxPrice_ = this.maxPrice_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.self_ = this.self_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.num_ = this.num_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.source_ = this.source_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionItem)
                    return mergeFrom((AuctionHandler.AuctionItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionItem other) {
                if (other == AuctionHandler.AuctionItem.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasDetail())
                    mergeDetail(other.getDetail());
                if (other.hasState())
                    setState(other.getState());
                if (other.hasTimeleft())
                    setTimeleft(other.getTimeleft());
                if (other.hasCurPrice())
                    setCurPrice(other.getCurPrice());
                if (other.hasMaxPrice())
                    setMaxPrice(other.getMaxPrice());
                if (other.hasSelf())
                    setSelf(other.getSelf());
                if (other.hasNum())
                    setNum(other.getNum());
                if (other.hasSource()) {
                    this.bitField0_ |= 0x100;
                    this.source_ = other.source_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasDetail())
                    return false;
                if (!hasState())
                    return false;
                if (!getDetail().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionItem parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionItem) AuctionHandler.AuctionItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionItem) e.getUnfinishedMessage();
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
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = AuctionHandler.AuctionItem.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public boolean hasDetail() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public ItemOuterClass.ItemDetail getDetail() {
                if (this.detailBuilder_ == null)
                    return this.detail_;
                return (ItemOuterClass.ItemDetail) this.detailBuilder_.getMessage();
            }

            public Builder setDetail(ItemOuterClass.ItemDetail value) {
                if (this.detailBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.detail_ = value;
                    onChanged();
                } else {
                    this.detailBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setDetail(ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.detailBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.detailBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeDetail(ItemOuterClass.ItemDetail value) {
                if (this.detailBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.detail_ != ItemOuterClass.ItemDetail.getDefaultInstance()) {
                        this.detail_ = ItemOuterClass.ItemDetail.newBuilder(this.detail_).mergeFrom(value).buildPartial();
                    } else {
                        this.detail_ = value;
                    }
                    onChanged();
                } else {
                    this.detailBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearDetail() {
                if (this.detailBuilder_ == null) {
                    this.detail_ = ItemOuterClass.ItemDetail.getDefaultInstance();
                    onChanged();
                } else {
                    this.detailBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public ItemOuterClass.ItemDetail.Builder getDetailBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (ItemOuterClass.ItemDetail.Builder) getDetailFieldBuilder().getBuilder();
            }

            public ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder() {
                if (this.detailBuilder_ != null)
                    return (ItemOuterClass.ItemDetailOrBuilder) this.detailBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.ItemDetailOrBuilder) this.detail_;
            }

            private SingleFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getDetailFieldBuilder() {
                if (this.detailBuilder_ == null) {
                    this.detailBuilder_ = new SingleFieldBuilder((GeneratedMessage) getDetail(), getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                return this.detailBuilder_;
            }

            public boolean hasState() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.bitField0_ |= 0x4;
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.state_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTimeleft() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getTimeleft() {
                return this.timeleft_;
            }

            public Builder setTimeleft(int value) {
                this.bitField0_ |= 0x8;
                this.timeleft_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeleft() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.timeleft_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurPrice() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getCurPrice() {
                return this.curPrice_;
            }

            public Builder setCurPrice(int value) {
                this.bitField0_ |= 0x10;
                this.curPrice_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurPrice() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.curPrice_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxPrice() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getMaxPrice() {
                return this.maxPrice_;
            }

            public Builder setMaxPrice(int value) {
                this.bitField0_ |= 0x20;
                this.maxPrice_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxPrice() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.maxPrice_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSelf() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public boolean getSelf() {
                return this.self_;
            }

            public Builder setSelf(boolean value) {
                this.bitField0_ |= 0x40;
                this.self_ = value;
                onChanged();
                return this;
            }

            public Builder clearSelf() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.self_ = false;
                onChanged();
                return this;
            }

            public boolean hasNum() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.bitField0_ |= 0x80;
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.num_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSource() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public String getSource() {
                Object ref = this.source_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.source_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSourceBytes() {
                Object ref = this.source_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.source_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSource(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.source_ = value;
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.source_ = AuctionHandler.AuctionItem.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder setSourceBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.source_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class AuctionListRequest extends GeneratedMessage implements AuctionListRequestOrBuilder {
        private static final AuctionListRequest defaultInstance = new AuctionListRequest(true);
        private final UnknownFieldSet unknownFields;

        private AuctionListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionListRequest.class, Builder.class);
        }

        public static Parser<AuctionListRequest> PARSER = (Parser<AuctionListRequest>) new AbstractParser<AuctionListRequest>() {
            public AuctionHandler.AuctionListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionListRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionListRequest> getParserForType() {
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


        public static AuctionListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionListRequest) PARSER.parseFrom(data);
        }


        public static AuctionListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionListRequest) PARSER.parseFrom(data);
        }


        public static AuctionListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionListRequest parseFrom(InputStream input) throws IOException {
            return (AuctionListRequest) PARSER.parseFrom(input);
        }


        public static AuctionListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AuctionListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static AuctionListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AuctionListRequest parseFrom(CodedInputStream input) throws IOException {
            return (AuctionListRequest) PARSER.parseFrom(input);
        }


        public static AuctionListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AuctionListRequest prototype) {
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
                implements AuctionHandler.AuctionListRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionListRequest.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_AuctionListRequest_descriptor;
            }


            public AuctionHandler.AuctionListRequest getDefaultInstanceForType() {
                return AuctionHandler.AuctionListRequest.getDefaultInstance();
            }


            public AuctionHandler.AuctionListRequest build() {
                AuctionHandler.AuctionListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AuctionHandler.AuctionListRequest buildPartial() {
                AuctionHandler.AuctionListRequest result = new AuctionHandler.AuctionListRequest(this);
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
                if (other instanceof AuctionHandler.AuctionListRequest) {
                    return mergeFrom((AuctionHandler.AuctionListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AuctionHandler.AuctionListRequest other) {
                if (other == AuctionHandler.AuctionListRequest.getDefaultInstance()) {
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
                AuctionHandler.AuctionListRequest parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionListRequest) AuctionHandler.AuctionListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionListRequest) e.getUnfinishedMessage();
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


    public static final class AuctionListResponse
            extends GeneratedMessage
            implements AuctionListResponseOrBuilder {
        private static final AuctionListResponse defaultInstance = new AuctionListResponse(true);
        private final UnknownFieldSet unknownFields;

        private AuctionListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CData_.add(input.readMessage(AuctionHandler.AuctionItem.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CBonus_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionListResponse.class, Builder.class);
        }

        public static Parser<AuctionListResponse> PARSER = (Parser<AuctionListResponse>) new AbstractParser<AuctionListResponse>() {
            public AuctionHandler.AuctionListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private List<AuctionHandler.AuctionItem> s2CData_;
        public static final int S2C_BONUS_FIELD_NUMBER = 4;
        private int s2CBonus_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionListResponse> getParserForType() {
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


        public List<AuctionHandler.AuctionItem> getS2CDataList() {
            return this.s2CData_;
        }


        public List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }


        public int getS2CDataCount() {
            return this.s2CData_.size();
        }


        public AuctionHandler.AuctionItem getS2CData(int index) {
            return this.s2CData_.get(index);
        }


        public AuctionHandler.AuctionItemOrBuilder getS2CDataOrBuilder(int index) {
            return this.s2CData_.get(index);
        }


        public boolean hasS2CBonus() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CBonus() {
            return this.s2CBonus_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = Collections.emptyList();
            this.s2CBonus_ = 0;
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
            for (int i = 0; i < getS2CDataCount(); i++) {
                if (!getS2CData(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CData_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CData_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.s2CBonus_);
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
            for (int i = 0; i < this.s2CData_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CBonus_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AuctionListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionListResponse) PARSER.parseFrom(data);
        }


        public static AuctionListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionListResponse) PARSER.parseFrom(data);
        }


        public static AuctionListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionListResponse parseFrom(InputStream input) throws IOException {
            return (AuctionListResponse) PARSER.parseFrom(input);
        }


        public static AuctionListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AuctionListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionListResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AuctionListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AuctionListResponse parseFrom(CodedInputStream input) throws IOException {
            return (AuctionListResponse) PARSER.parseFrom(input);
        }


        public static AuctionListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AuctionListResponse prototype) {
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
                implements AuctionHandler.AuctionListResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;
            private Object s2CMsg_;
            private List<AuctionHandler.AuctionItem> s2CData_;
            private RepeatedFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> s2CDataBuilder_;
            private int s2CBonus_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionListResponse.alwaysUseFieldBuilders) {
                    getS2CDataFieldBuilder();
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
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.s2CBonus_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionListResponse_descriptor;
            }

            public AuctionHandler.AuctionListResponse getDefaultInstanceForType() {
                return AuctionHandler.AuctionListResponse.getDefaultInstance();
            }

            public AuctionHandler.AuctionListResponse build() {
                AuctionHandler.AuctionListResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AuctionHandler.AuctionListResponse buildPartial() {
                AuctionHandler.AuctionListResponse result = new AuctionHandler.AuctionListResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = this.s2CDataBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CBonus_ = this.s2CBonus_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionListResponse) {
                    return mergeFrom((AuctionHandler.AuctionListResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionListResponse other) {
                if (other == AuctionHandler.AuctionListResponse.getDefaultInstance()) {
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
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CDataIsMutable();
                            this.s2CData_.addAll(other.s2CData_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CData_.isEmpty()) {
                    if (this.s2CDataBuilder_.isEmpty()) {
                        this.s2CDataBuilder_.dispose();
                        this.s2CDataBuilder_ = null;
                        this.s2CData_ = other.s2CData_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CDataBuilder_ = AuctionHandler.AuctionListResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                if (other.hasS2CBonus()) {
                    setS2CBonus(other.getS2CBonus());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CDataCount(); i++) {
                    if (!getS2CData(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionListResponse parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionListResponse) AuctionHandler.AuctionListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AuctionHandler.AuctionListResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AuctionHandler.AuctionItem> getS2CDataList() {
                if (this.s2CDataBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CData_);
                }
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.size();
                }
                return this.s2CDataBuilder_.getCount();
            }

            public AuctionHandler.AuctionItem getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (AuctionHandler.AuctionItem) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, AuctionHandler.AuctionItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CData(int index, AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(AuctionHandler.AuctionItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CData(int index, AuctionHandler.AuctionItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CData(AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends AuctionHandler.AuctionItem> values) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CData_);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.remove(index);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.remove(index);
                }
                return this;
            }

            public AuctionHandler.AuctionItem.Builder getS2CDataBuilder(int index) {
                return (AuctionHandler.AuctionItem.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public AuctionHandler.AuctionItemOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (AuctionHandler.AuctionItemOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CData_);
            }

            public AuctionHandler.AuctionItem.Builder addS2CDataBuilder() {
                return (AuctionHandler.AuctionItem.Builder) getS2CDataFieldBuilder().addBuilder(AuctionHandler.AuctionItem.getDefaultInstance());
            }

            public AuctionHandler.AuctionItem.Builder addS2CDataBuilder(int index) {
                return (AuctionHandler.AuctionItem.Builder) getS2CDataFieldBuilder().addBuilder(index, AuctionHandler.AuctionItem.getDefaultInstance());
            }

            public List<AuctionHandler.AuctionItem.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }

            public boolean hasS2CBonus() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CBonus() {
                return this.s2CBonus_;
            }

            public Builder setS2CBonus(int value) {
                this.bitField0_ |= 0x8;
                this.s2CBonus_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CBonus() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CBonus_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class AuctionRequest
            extends GeneratedMessage
            implements AuctionRequestOrBuilder {
        private static final AuctionRequest defaultInstance = new AuctionRequest(true);
        private final UnknownFieldSet unknownFields;

        private AuctionRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.itemId_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.price_ = input.readInt32();
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionRequest.class, Builder.class);
        }

        public static Parser<AuctionRequest> PARSER = (Parser<AuctionRequest>) new AbstractParser<AuctionRequest>() {
            public AuctionHandler.AuctionRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMID_FIELD_NUMBER = 1;
        private Object itemId_;
        public static final int PRICE_FIELD_NUMBER = 2;
        private int price_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasItemId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getItemId() {
            Object ref = this.itemId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.itemId_ = s;
            return s;
        }

        public ByteString getItemIdBytes() {
            Object ref = this.itemId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasPrice() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getPrice() {
            return this.price_;
        }


        private void initFields() {
            this.itemId_ = "";
            this.price_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPrice()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getItemIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.price_);
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
                size += CodedOutputStream.computeBytesSize(1, getItemIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.price_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AuctionRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionRequest) PARSER.parseFrom(data);
        }


        public static AuctionRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionRequest) PARSER.parseFrom(data);
        }


        public static AuctionRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionRequest parseFrom(InputStream input) throws IOException {
            return (AuctionRequest) PARSER.parseFrom(input);
        }


        public static AuctionRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AuctionRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionRequest) PARSER.parseDelimitedFrom(input);
        }


        public static AuctionRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AuctionRequest parseFrom(CodedInputStream input) throws IOException {
            return (AuctionRequest) PARSER.parseFrom(input);
        }


        public static AuctionRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AuctionRequest prototype) {
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
                implements AuctionHandler.AuctionRequestOrBuilder {
            private int bitField0_;
            private Object itemId_;
            private int price_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionRequest.class, Builder.class);
            }

            private Builder() {
                this.itemId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.itemId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.price_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionRequest_descriptor;
            }

            public AuctionHandler.AuctionRequest getDefaultInstanceForType() {
                return AuctionHandler.AuctionRequest.getDefaultInstance();
            }

            public AuctionHandler.AuctionRequest build() {
                AuctionHandler.AuctionRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AuctionHandler.AuctionRequest buildPartial() {
                AuctionHandler.AuctionRequest result = new AuctionHandler.AuctionRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.itemId_ = this.itemId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.price_ = this.price_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionRequest) {
                    return mergeFrom((AuctionHandler.AuctionRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionRequest other) {
                if (other == AuctionHandler.AuctionRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasItemId()) {
                    this.bitField0_ |= 0x1;
                    this.itemId_ = other.itemId_;
                    onChanged();
                }
                if (other.hasPrice()) {
                    setPrice(other.getPrice());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasItemId()) {
                    return false;
                }
                if (!hasPrice()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionRequest parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionRequest) AuctionHandler.AuctionRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasItemId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getItemId() {
                Object ref = this.itemId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getItemIdBytes() {
                Object ref = this.itemId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setItemId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemId_ = AuctionHandler.AuctionRequest.getDefaultInstance().getItemId();
                onChanged();
                return this;
            }

            public Builder setItemIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public boolean hasPrice() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getPrice() {
                return this.price_;
            }

            public Builder setPrice(int value) {
                this.bitField0_ |= 0x2;
                this.price_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrice() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.price_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class AuctionResponse
            extends GeneratedMessage
            implements AuctionResponseOrBuilder {
        private final UnknownFieldSet unknownFields;

        private AuctionResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionResponse.class, Builder.class);
        }

        public static Parser<AuctionResponse> PARSER = (Parser<AuctionResponse>) new AbstractParser<AuctionResponse>() {
            public AuctionHandler.AuctionResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionResponse(input, extensionRegistry);
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

        public Parser<AuctionResponse> getParserForType() {
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

        public static AuctionResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionResponse) PARSER.parseFrom(data);
        }

        public static AuctionResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionResponse) PARSER.parseFrom(data);
        }

        public static AuctionResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionResponse parseFrom(InputStream input) throws IOException {
            return (AuctionResponse) PARSER.parseFrom(input);
        }

        private static final AuctionResponse defaultInstance = new AuctionResponse(true);

        public static AuctionResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AuctionResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionResponse) PARSER.parseDelimitedFrom(input);
        }

        public static AuctionResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AuctionResponse parseFrom(CodedInputStream input) throws IOException {
            return (AuctionResponse) PARSER.parseFrom(input);
        }

        public static AuctionResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AuctionResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.AuctionResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionResponse.class, Builder.class);
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
                if (AuctionHandler.AuctionResponse.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_AuctionResponse_descriptor;
            }

            public AuctionHandler.AuctionResponse getDefaultInstanceForType() {
                return AuctionHandler.AuctionResponse.getDefaultInstance();
            }

            public AuctionHandler.AuctionResponse build() {
                AuctionHandler.AuctionResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.AuctionResponse buildPartial() {
                AuctionHandler.AuctionResponse result = new AuctionHandler.AuctionResponse(this);
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
                if (other instanceof AuctionHandler.AuctionResponse)
                    return mergeFrom((AuctionHandler.AuctionResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionResponse other) {
                if (other == AuctionHandler.AuctionResponse.getDefaultInstance()) return this;
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
                AuctionHandler.AuctionResponse parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionResponse) AuctionHandler.AuctionResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AuctionHandler.AuctionResponse.getDefaultInstance().getS2CMsg();
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


    public static final class AuctionLog
            extends GeneratedMessage
            implements AuctionLogOrBuilder {
        private static final AuctionLog defaultInstance = new AuctionLog(true);
        private final UnknownFieldSet unknownFields;

        private AuctionLog(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionLog(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionLog getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionLog getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionLog(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.id_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.time_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.role1_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.item_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionLog_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionLog.class, Builder.class);
        }

        public static Parser<AuctionLog> PARSER = (Parser<AuctionLog>) new AbstractParser<AuctionLog>() {
            public AuctionHandler.AuctionLog parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionLog(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int TIME_FIELD_NUMBER = 2;
        private Object time_;
        public static final int ROLE1_FIELD_NUMBER = 3;
        private Object role1_;
        public static final int ITEM_FIELD_NUMBER = 4;
        private Object item_;
        public static final int NUM_FIELD_NUMBER = 5;
        private int num_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionLog> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getTime() {
            Object ref = this.time_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.time_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }

        public ByteString getTimeBytes() {
            Object ref = this.time_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.time_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasRole1() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getRole1() {
            Object ref = this.role1_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.role1_ = s;
            return s;
        }

        public ByteString getRole1Bytes() {
            Object ref = this.role1_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.role1_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasItem() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getItem() {
            Object ref = this.item_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.item_ = s;
            return s;
        }

        public ByteString getItemBytes() {
            Object ref = this.item_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.item_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getNum() {
            return this.num_;
        }

        private void initFields() {
            this.id_ = 0;
            this.time_ = "";
            this.role1_ = "";
            this.item_ = "";
            this.num_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getTimeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getRole1Bytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getItemBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.num_);
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
                size += CodedOutputStream.computeBytesSize(2, getTimeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getRole1Bytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getItemBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.num_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AuctionLog parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionLog) PARSER.parseFrom(data);
        }

        public static AuctionLog parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLog) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionLog parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionLog) PARSER.parseFrom(data);
        }

        public static AuctionLog parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLog) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionLog parseFrom(InputStream input) throws IOException {
            return (AuctionLog) PARSER.parseFrom(input);
        }

        public static AuctionLog parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLog) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AuctionLog parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionLog) PARSER.parseDelimitedFrom(input);
        }

        public static AuctionLog parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLog) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AuctionLog parseFrom(CodedInputStream input) throws IOException {
            return (AuctionLog) PARSER.parseFrom(input);
        }

        public static AuctionLog parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLog) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AuctionLog prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.AuctionLogOrBuilder {
            private int bitField0_;
            private int id_;
            private Object time_;
            private Object role1_;
            private Object item_;
            private int num_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLog_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionLog.class, Builder.class);
            }

            private Builder() {
                this.time_ = "";
                this.role1_ = "";
                this.item_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.time_ = "";
                this.role1_ = "";
                this.item_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionLog.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.role1_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.item_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLog_descriptor;
            }

            public AuctionHandler.AuctionLog getDefaultInstanceForType() {
                return AuctionHandler.AuctionLog.getDefaultInstance();
            }

            public AuctionHandler.AuctionLog build() {
                AuctionHandler.AuctionLog result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.AuctionLog buildPartial() {
                AuctionHandler.AuctionLog result = new AuctionHandler.AuctionLog(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.time_ = this.time_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.role1_ = this.role1_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.item_ = this.item_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.num_ = this.num_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionLog)
                    return mergeFrom((AuctionHandler.AuctionLog) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionLog other) {
                if (other == AuctionHandler.AuctionLog.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasTime()) {
                    this.bitField0_ |= 0x2;
                    this.time_ = other.time_;
                    onChanged();
                }
                if (other.hasRole1()) {
                    this.bitField0_ |= 0x4;
                    this.role1_ = other.role1_;
                    onChanged();
                }
                if (other.hasItem()) {
                    this.bitField0_ |= 0x8;
                    this.item_ = other.item_;
                    onChanged();
                }
                if (other.hasNum())
                    setNum(other.getNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionLog parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionLog) AuctionHandler.AuctionLog.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionLog) e.getUnfinishedMessage();
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

            public boolean hasTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getTime() {
                Object ref = this.time_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.time_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTimeBytes() {
                Object ref = this.time_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.time_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTime(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.time_ = value;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.time_ = AuctionHandler.AuctionLog.getDefaultInstance().getTime();
                onChanged();
                return this;
            }

            public Builder setTimeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.time_ = value;
                onChanged();
                return this;
            }

            public boolean hasRole1() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getRole1() {
                Object ref = this.role1_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.role1_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getRole1Bytes() {
                Object ref = this.role1_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.role1_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setRole1(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.role1_ = value;
                onChanged();
                return this;
            }

            public Builder clearRole1() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.role1_ = AuctionHandler.AuctionLog.getDefaultInstance().getRole1();
                onChanged();
                return this;
            }

            public Builder setRole1Bytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.role1_ = value;
                onChanged();
                return this;
            }

            public boolean hasItem() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getItem() {
                Object ref = this.item_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.item_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getItemBytes() {
                Object ref = this.item_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.item_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setItem(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.item_ = value;
                onChanged();
                return this;
            }

            public Builder clearItem() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.item_ = AuctionHandler.AuctionLog.getDefaultInstance().getItem();
                onChanged();
                return this;
            }

            public Builder setItemBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.item_ = value;
                onChanged();
                return this;
            }

            public boolean hasNum() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.bitField0_ |= 0x10;
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.num_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class AuctionLogRequest extends GeneratedMessage implements AuctionLogRequestOrBuilder {
        private static final AuctionLogRequest defaultInstance = new AuctionLogRequest(true);
        private final UnknownFieldSet unknownFields;

        private AuctionLogRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionLogRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionLogRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionLogRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionLogRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionLogRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionLogRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionLogRequest.class, Builder.class);
        }

        public static Parser<AuctionLogRequest> PARSER = (Parser<AuctionLogRequest>) new AbstractParser<AuctionLogRequest>() {
            public AuctionHandler.AuctionLogRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionLogRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionLogRequest> getParserForType() {
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


        public static AuctionLogRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionLogRequest) PARSER.parseFrom(data);
        }


        public static AuctionLogRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLogRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionLogRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionLogRequest) PARSER.parseFrom(data);
        }


        public static AuctionLogRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLogRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionLogRequest parseFrom(InputStream input) throws IOException {
            return (AuctionLogRequest) PARSER.parseFrom(input);
        }


        public static AuctionLogRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AuctionLogRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionLogRequest) PARSER.parseDelimitedFrom(input);
        }


        public static AuctionLogRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AuctionLogRequest parseFrom(CodedInputStream input) throws IOException {
            return (AuctionLogRequest) PARSER.parseFrom(input);
        }


        public static AuctionLogRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AuctionLogRequest prototype) {
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
                implements AuctionHandler.AuctionLogRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionLogRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionLogRequest.alwaysUseFieldBuilders) ;
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
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogRequest_descriptor;
            }


            public AuctionHandler.AuctionLogRequest getDefaultInstanceForType() {
                return AuctionHandler.AuctionLogRequest.getDefaultInstance();
            }


            public AuctionHandler.AuctionLogRequest build() {
                AuctionHandler.AuctionLogRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AuctionHandler.AuctionLogRequest buildPartial() {
                AuctionHandler.AuctionLogRequest result = new AuctionHandler.AuctionLogRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionLogRequest) {
                    return mergeFrom((AuctionHandler.AuctionLogRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AuctionHandler.AuctionLogRequest other) {
                if (other == AuctionHandler.AuctionLogRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionLogRequest parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionLogRequest) AuctionHandler.AuctionLogRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionLogRequest) e.getUnfinishedMessage();
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


    public static final class AuctionLogResponse
            extends GeneratedMessage
            implements AuctionLogResponseOrBuilder {
        private static final AuctionLogResponse defaultInstance = new AuctionLogResponse(true);
        private final UnknownFieldSet unknownFields;

        private AuctionLogResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionLogResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionLogResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionLogResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionLogResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CLog_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CLog_.add(input.readMessage(AuctionHandler.AuctionLog.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CLog_ = Collections.unmodifiableList(this.s2CLog_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionLogResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionLogResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionLogResponse.class, Builder.class);
        }

        public static Parser<AuctionLogResponse> PARSER = (Parser<AuctionLogResponse>) new AbstractParser<AuctionLogResponse>() {
            public AuctionHandler.AuctionLogResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionLogResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LOG_FIELD_NUMBER = 3;
        private List<AuctionHandler.AuctionLog> s2CLog_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionLogResponse> getParserForType() {
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


        public List<AuctionHandler.AuctionLog> getS2CLogList() {
            return this.s2CLog_;
        }


        public List<? extends AuctionHandler.AuctionLogOrBuilder> getS2CLogOrBuilderList() {
            return (List) this.s2CLog_;
        }


        public int getS2CLogCount() {
            return this.s2CLog_.size();
        }


        public AuctionHandler.AuctionLog getS2CLog(int index) {
            return this.s2CLog_.get(index);
        }


        public AuctionHandler.AuctionLogOrBuilder getS2CLogOrBuilder(int index) {
            return this.s2CLog_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLog_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CLogCount(); i++) {
                if (!getS2CLog(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CLog_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CLog_.get(i));
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
            for (int i = 0; i < this.s2CLog_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLog_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AuctionLogResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionLogResponse) PARSER.parseFrom(data);
        }

        public static AuctionLogResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLogResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionLogResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionLogResponse) PARSER.parseFrom(data);
        }

        public static AuctionLogResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionLogResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuctionLogResponse parseFrom(InputStream input) throws IOException {
            return (AuctionLogResponse) PARSER.parseFrom(input);
        }

        public static AuctionLogResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AuctionLogResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionLogResponse) PARSER.parseDelimitedFrom(input);
        }

        public static AuctionLogResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AuctionLogResponse parseFrom(CodedInputStream input) throws IOException {
            return (AuctionLogResponse) PARSER.parseFrom(input);
        }

        public static AuctionLogResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionLogResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AuctionLogResponse prototype) {
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
                implements AuctionHandler.AuctionLogResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<AuctionHandler.AuctionLog> s2CLog_;
            private RepeatedFieldBuilder<AuctionHandler.AuctionLog, AuctionHandler.AuctionLog.Builder, AuctionHandler.AuctionLogOrBuilder> s2CLogBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionLogResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLog_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLog_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionLogResponse.alwaysUseFieldBuilders) {
                    getS2CLogFieldBuilder();
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
                if (this.s2CLogBuilder_ == null) {
                    this.s2CLog_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CLogBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionLogResponse_descriptor;
            }

            public AuctionHandler.AuctionLogResponse getDefaultInstanceForType() {
                return AuctionHandler.AuctionLogResponse.getDefaultInstance();
            }

            public AuctionHandler.AuctionLogResponse build() {
                AuctionHandler.AuctionLogResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AuctionHandler.AuctionLogResponse buildPartial() {
                AuctionHandler.AuctionLogResponse result = new AuctionHandler.AuctionLogResponse(this);
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
                if (this.s2CLogBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CLog_ = Collections.unmodifiableList(this.s2CLog_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CLog_ = this.s2CLog_;
                } else {
                    result.s2CLog_ = this.s2CLogBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionLogResponse) {
                    return mergeFrom((AuctionHandler.AuctionLogResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AuctionLogResponse other) {
                if (other == AuctionHandler.AuctionLogResponse.getDefaultInstance()) {
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
                if (this.s2CLogBuilder_ == null) {
                    if (!other.s2CLog_.isEmpty()) {
                        if (this.s2CLog_.isEmpty()) {
                            this.s2CLog_ = other.s2CLog_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CLogIsMutable();
                            this.s2CLog_.addAll(other.s2CLog_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CLog_.isEmpty()) {
                    if (this.s2CLogBuilder_.isEmpty()) {
                        this.s2CLogBuilder_.dispose();
                        this.s2CLogBuilder_ = null;
                        this.s2CLog_ = other.s2CLog_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CLogBuilder_ = AuctionHandler.AuctionLogResponse.alwaysUseFieldBuilders ? getS2CLogFieldBuilder() : null;
                    } else {
                        this.s2CLogBuilder_.addAllMessages(other.s2CLog_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CLogCount(); i++) {
                    if (!getS2CLog(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionLogResponse parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionLogResponse) AuctionHandler.AuctionLogResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionLogResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AuctionHandler.AuctionLogResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CLogIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CLog_ = new ArrayList<>(this.s2CLog_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AuctionHandler.AuctionLog> getS2CLogList() {
                if (this.s2CLogBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CLog_);
                }
                return this.s2CLogBuilder_.getMessageList();
            }

            public int getS2CLogCount() {
                if (this.s2CLogBuilder_ == null) {
                    return this.s2CLog_.size();
                }
                return this.s2CLogBuilder_.getCount();
            }

            public AuctionHandler.AuctionLog getS2CLog(int index) {
                if (this.s2CLogBuilder_ == null) {
                    return this.s2CLog_.get(index);
                }
                return (AuctionHandler.AuctionLog) this.s2CLogBuilder_.getMessage(index);
            }

            public Builder setS2CLog(int index, AuctionHandler.AuctionLog value) {
                if (this.s2CLogBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLogIsMutable();
                    this.s2CLog_.set(index, value);
                    onChanged();
                } else {
                    this.s2CLogBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CLog(int index, AuctionHandler.AuctionLog.Builder builderForValue) {
                if (this.s2CLogBuilder_ == null) {
                    ensureS2CLogIsMutable();
                    this.s2CLog_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLogBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLog(AuctionHandler.AuctionLog value) {
                if (this.s2CLogBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLogIsMutable();
                    this.s2CLog_.add(value);
                    onChanged();
                } else {
                    this.s2CLogBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CLog(int index, AuctionHandler.AuctionLog value) {
                if (this.s2CLogBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLogIsMutable();
                    this.s2CLog_.add(index, value);
                    onChanged();
                } else {
                    this.s2CLogBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CLog(AuctionHandler.AuctionLog.Builder builderForValue) {
                if (this.s2CLogBuilder_ == null) {
                    ensureS2CLogIsMutable();
                    this.s2CLog_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLogBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLog(int index, AuctionHandler.AuctionLog.Builder builderForValue) {
                if (this.s2CLogBuilder_ == null) {
                    ensureS2CLogIsMutable();
                    this.s2CLog_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLogBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CLog(Iterable<? extends AuctionHandler.AuctionLog> values) {
                if (this.s2CLogBuilder_ == null) {
                    ensureS2CLogIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CLog_);
                    onChanged();
                } else {
                    this.s2CLogBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CLog() {
                if (this.s2CLogBuilder_ == null) {
                    this.s2CLog_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CLogBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CLog(int index) {
                if (this.s2CLogBuilder_ == null) {
                    ensureS2CLogIsMutable();
                    this.s2CLog_.remove(index);
                    onChanged();
                } else {
                    this.s2CLogBuilder_.remove(index);
                }
                return this;
            }

            public AuctionHandler.AuctionLog.Builder getS2CLogBuilder(int index) {
                return (AuctionHandler.AuctionLog.Builder) getS2CLogFieldBuilder().getBuilder(index);
            }

            public AuctionHandler.AuctionLogOrBuilder getS2CLogOrBuilder(int index) {
                if (this.s2CLogBuilder_ == null) {
                    return this.s2CLog_.get(index);
                }
                return (AuctionHandler.AuctionLogOrBuilder) this.s2CLogBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AuctionHandler.AuctionLogOrBuilder> getS2CLogOrBuilderList() {
                if (this.s2CLogBuilder_ != null) {
                    return this.s2CLogBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CLog_);
            }

            public AuctionHandler.AuctionLog.Builder addS2CLogBuilder() {
                return (AuctionHandler.AuctionLog.Builder) getS2CLogFieldBuilder().addBuilder(AuctionHandler.AuctionLog.getDefaultInstance());
            }

            public AuctionHandler.AuctionLog.Builder addS2CLogBuilder(int index) {
                return (AuctionHandler.AuctionLog.Builder) getS2CLogFieldBuilder().addBuilder(index, AuctionHandler.AuctionLog.getDefaultInstance());
            }

            public List<AuctionHandler.AuctionLog.Builder> getS2CLogBuilderList() {
                return getS2CLogFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AuctionHandler.AuctionLog, AuctionHandler.AuctionLog.Builder, AuctionHandler.AuctionLogOrBuilder> getS2CLogFieldBuilder() {
                if (this.s2CLogBuilder_ == null) {
                    this.s2CLogBuilder_ = new RepeatedFieldBuilder(this.s2CLog_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CLog_ = null;
                }
                return this.s2CLogBuilder_;
            }
        }
    }

    public static final class AuctionItemPush
            extends GeneratedMessage
            implements AuctionItemPushOrBuilder {
        private static final AuctionItemPush defaultInstance = new AuctionItemPush(true);
        private final UnknownFieldSet unknownFields;

        private AuctionItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AuctionItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AuctionItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public AuctionItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AuctionItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    AuctionHandler.AuctionItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.s2CItem_.toBuilder();
                            this.s2CItem_ = (AuctionHandler.AuctionItem) input.readMessage(AuctionHandler.AuctionItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CItem_);
                                this.s2CItem_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
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
            return AuctionHandler.internal_static_pomelo_auction_AuctionItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionItemPush.class, Builder.class);
        }

        public static Parser<AuctionItemPush> PARSER = (Parser<AuctionItemPush>) new AbstractParser<AuctionItemPush>() {
            public AuctionHandler.AuctionItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AuctionItemPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_ITEM_FIELD_NUMBER = 1;
        private AuctionHandler.AuctionItem s2CItem_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AuctionItemPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CItem() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public AuctionHandler.AuctionItem getS2CItem() {
            return this.s2CItem_;
        }

        public AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder() {
            return this.s2CItem_;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.s2CItem_ = AuctionHandler.AuctionItem.getDefaultInstance();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasS2CItem()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CItem().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeMessage(1, (MessageLite) this.s2CItem_);
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
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.s2CItem_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AuctionItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AuctionItemPush) PARSER.parseFrom(data);
        }


        public static AuctionItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AuctionItemPush) PARSER.parseFrom(data);
        }


        public static AuctionItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AuctionItemPush parseFrom(InputStream input) throws IOException {
            return (AuctionItemPush) PARSER.parseFrom(input);
        }


        public static AuctionItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AuctionItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (AuctionItemPush) PARSER.parseDelimitedFrom(input);
        }


        public static AuctionItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AuctionItemPush parseFrom(CodedInputStream input) throws IOException {
            return (AuctionItemPush) PARSER.parseFrom(input);
        }


        public static AuctionItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AuctionItemPush prototype) {
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
                implements AuctionHandler.AuctionItemPushOrBuilder {
            private int bitField0_;


            private AuctionHandler.AuctionItem s2CItem_;


            private SingleFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> s2CItemBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItemPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AuctionItemPush.class, Builder.class);
            }


            private Builder() {
                this.s2CItem_ = AuctionHandler.AuctionItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CItem_ = AuctionHandler.AuctionItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AuctionItemPush.alwaysUseFieldBuilders) {
                    getS2CItemFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = AuctionHandler.AuctionItem.getDefaultInstance();
                } else {
                    this.s2CItemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AuctionItemPush_descriptor;
            }


            public AuctionHandler.AuctionItemPush getDefaultInstanceForType() {
                return AuctionHandler.AuctionItemPush.getDefaultInstance();
            }


            public AuctionHandler.AuctionItemPush build() {
                AuctionHandler.AuctionItemPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AuctionHandler.AuctionItemPush buildPartial() {
                AuctionHandler.AuctionItemPush result = new AuctionHandler.AuctionItemPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                if (this.s2CItemBuilder_ == null) {
                    result.s2CItem_ = this.s2CItem_;
                } else {
                    result.s2CItem_ = (AuctionHandler.AuctionItem) this.s2CItemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AuctionItemPush) {
                    return mergeFrom((AuctionHandler.AuctionItemPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AuctionHandler.AuctionItemPush other) {
                if (other == AuctionHandler.AuctionItemPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CItem()) {
                    mergeS2CItem(other.getS2CItem());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CItem()) {
                    return false;
                }
                if (!getS2CItem().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AuctionItemPush parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AuctionItemPush) AuctionHandler.AuctionItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AuctionItemPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasS2CItem() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public AuctionHandler.AuctionItem getS2CItem() {
                if (this.s2CItemBuilder_ == null) {
                    return this.s2CItem_;
                }
                return (AuctionHandler.AuctionItem) this.s2CItemBuilder_.getMessage();
            }


            public Builder setS2CItem(AuctionHandler.AuctionItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CItem_ = value;
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder setS2CItem(AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder mergeS2CItem(AuctionHandler.AuctionItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.s2CItem_ != AuctionHandler.AuctionItem.getDefaultInstance()) {
                        this.s2CItem_ = AuctionHandler.AuctionItem.newBuilder(this.s2CItem_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CItem_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CItemBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder clearS2CItem() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = AuctionHandler.AuctionItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CItemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public AuctionHandler.AuctionItem.Builder getS2CItemBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (AuctionHandler.AuctionItem.Builder) getS2CItemFieldBuilder().getBuilder();
            }


            public AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder() {
                if (this.s2CItemBuilder_ != null) {
                    return (AuctionHandler.AuctionItemOrBuilder) this.s2CItemBuilder_.getMessageOrBuilder();
                }
                return this.s2CItem_;
            }


            private SingleFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> getS2CItemFieldBuilder() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItemBuilder_ = new SingleFieldBuilder(getS2CItem(), getParentForChildren(), isClean());
                    this.s2CItem_ = null;
                }
                return this.s2CItemBuilder_;
            }
        }
    }


    public static final class AddAuctionItemPush
            extends GeneratedMessage
            implements AddAuctionItemPushOrBuilder {
        private static final AddAuctionItemPush defaultInstance = new AddAuctionItemPush(true);
        private final UnknownFieldSet unknownFields;

        private AddAuctionItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AddAuctionItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AddAuctionItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public AddAuctionItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddAuctionItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 10:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.s2CItem_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.s2CItem_.add(input.readMessage(AuctionHandler.AuctionItem.PARSER, extensionRegistry));
                            break;
                        case 16:
                            this.bitField0_ |= 0x1;
                            this.s2CType_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AuctionHandler.internal_static_pomelo_auction_AddAuctionItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_AddAuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AddAuctionItemPush.class, Builder.class);
        }

        public static Parser<AddAuctionItemPush> PARSER = (Parser<AddAuctionItemPush>) new AbstractParser<AddAuctionItemPush>() {
            public AuctionHandler.AddAuctionItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.AddAuctionItemPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_ITEM_FIELD_NUMBER = 1;
        private List<AuctionHandler.AuctionItem> s2CItem_;
        public static final int S2C_TYPE_FIELD_NUMBER = 2;
        private int s2CType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AddAuctionItemPush> getParserForType() {
            return PARSER;
        }

        public List<AuctionHandler.AuctionItem> getS2CItemList() {
            return this.s2CItem_;
        }

        public List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CItemOrBuilderList() {
            return (List) this.s2CItem_;
        }

        public int getS2CItemCount() {
            return this.s2CItem_.size();
        }

        public AuctionHandler.AuctionItem getS2CItem(int index) {
            return this.s2CItem_.get(index);
        }

        static {
            defaultInstance.initFields();
        }


        public AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder(int index) {
            return this.s2CItem_.get(index);
        }

        public boolean hasS2CType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CType() {
            return this.s2CType_;
        }

        private void initFields() {
            this.s2CItem_ = Collections.emptyList();
            this.s2CType_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i = 0; i < getS2CItemCount(); i++) {
                if (!getS2CItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.s2CItem_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.s2CItem_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(2, this.s2CType_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.s2CItem_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.s2CItem_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.s2CType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AddAuctionItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AddAuctionItemPush) PARSER.parseFrom(data);
        }

        public static AddAuctionItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddAuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddAuctionItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AddAuctionItemPush) PARSER.parseFrom(data);
        }

        public static AddAuctionItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddAuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddAuctionItemPush parseFrom(InputStream input) throws IOException {
            return (AddAuctionItemPush) PARSER.parseFrom(input);
        }

        public static AddAuctionItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddAuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AddAuctionItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (AddAuctionItemPush) PARSER.parseDelimitedFrom(input);
        }

        public static AddAuctionItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddAuctionItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AddAuctionItemPush parseFrom(CodedInputStream input) throws IOException {
            return (AddAuctionItemPush) PARSER.parseFrom(input);
        }

        public static AddAuctionItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddAuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AddAuctionItemPush prototype) {
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
                implements AuctionHandler.AddAuctionItemPushOrBuilder {
            private int bitField0_;
            private List<AuctionHandler.AuctionItem> s2CItem_;
            private RepeatedFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> s2CItemBuilder_;
            private int s2CType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_AddAuctionItemPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_AddAuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.AddAuctionItemPush.class, Builder.class);
            }

            private Builder() {
                this.s2CItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.AddAuctionItemPush.alwaysUseFieldBuilders) {
                    getS2CItemFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.s2CItemBuilder_.clear();
                }
                this.s2CType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_AddAuctionItemPush_descriptor;
            }

            public AuctionHandler.AddAuctionItemPush getDefaultInstanceForType() {
                return AuctionHandler.AddAuctionItemPush.getDefaultInstance();
            }

            public AuctionHandler.AddAuctionItemPush build() {
                AuctionHandler.AddAuctionItemPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AuctionHandler.AddAuctionItemPush buildPartial() {
                AuctionHandler.AddAuctionItemPush result = new AuctionHandler.AddAuctionItemPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.s2CItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.s2CItem_ = this.s2CItem_;
                } else {
                    result.s2CItem_ = this.s2CItemBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CType_ = this.s2CType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.AddAuctionItemPush) {
                    return mergeFrom((AuctionHandler.AddAuctionItemPush) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.AddAuctionItemPush other) {
                if (other == AuctionHandler.AddAuctionItemPush.getDefaultInstance()) {
                    return this;
                }
                if (this.s2CItemBuilder_ == null) {
                    if (!other.s2CItem_.isEmpty()) {
                        if (this.s2CItem_.isEmpty()) {
                            this.s2CItem_ = other.s2CItem_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureS2CItemIsMutable();
                            this.s2CItem_.addAll(other.s2CItem_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CItem_.isEmpty()) {
                    if (this.s2CItemBuilder_.isEmpty()) {
                        this.s2CItemBuilder_.dispose();
                        this.s2CItemBuilder_ = null;
                        this.s2CItem_ = other.s2CItem_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.s2CItemBuilder_ = AuctionHandler.AddAuctionItemPush.alwaysUseFieldBuilders ? getS2CItemFieldBuilder() : null;
                    } else {
                        this.s2CItemBuilder_.addAllMessages(other.s2CItem_);
                    }
                }
                if (other.hasS2CType()) {
                    setS2CType(other.getS2CType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getS2CItemCount(); i++) {
                    if (!getS2CItem(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.AddAuctionItemPush parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.AddAuctionItemPush) AuctionHandler.AddAuctionItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.AddAuctionItemPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureS2CItemIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.s2CItem_ = new ArrayList<>(this.s2CItem_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<AuctionHandler.AuctionItem> getS2CItemList() {
                if (this.s2CItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CItem_);
                }
                return this.s2CItemBuilder_.getMessageList();
            }

            public int getS2CItemCount() {
                if (this.s2CItemBuilder_ == null) {
                    return this.s2CItem_.size();
                }
                return this.s2CItemBuilder_.getCount();
            }

            public AuctionHandler.AuctionItem getS2CItem(int index) {
                if (this.s2CItemBuilder_ == null) {
                    return this.s2CItem_.get(index);
                }
                return (AuctionHandler.AuctionItem) this.s2CItemBuilder_.getMessage(index);
            }

            public Builder setS2CItem(int index, AuctionHandler.AuctionItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CItem(int index, AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItem(AuctionHandler.AuctionItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CItem(int index, AuctionHandler.AuctionItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CItem(AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItem(int index, AuctionHandler.AuctionItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CItem(Iterable<? extends AuctionHandler.AuctionItem> values) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CItem_);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CItem() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.s2CItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CItem(int index) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.remove(index);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.remove(index);
                }
                return this;
            }

            public AuctionHandler.AuctionItem.Builder getS2CItemBuilder(int index) {
                return (AuctionHandler.AuctionItem.Builder) getS2CItemFieldBuilder().getBuilder(index);
            }

            public AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder(int index) {
                if (this.s2CItemBuilder_ == null) {
                    return this.s2CItem_.get(index);
                }
                return (AuctionHandler.AuctionItemOrBuilder) this.s2CItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CItemOrBuilderList() {
                if (this.s2CItemBuilder_ != null) {
                    return this.s2CItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CItem_);
            }

            public AuctionHandler.AuctionItem.Builder addS2CItemBuilder() {
                return (AuctionHandler.AuctionItem.Builder) getS2CItemFieldBuilder().addBuilder(AuctionHandler.AuctionItem.getDefaultInstance());
            }

            public AuctionHandler.AuctionItem.Builder addS2CItemBuilder(int index) {
                return (AuctionHandler.AuctionItem.Builder) getS2CItemFieldBuilder().addBuilder(index, AuctionHandler.AuctionItem.getDefaultInstance());
            }

            public List<AuctionHandler.AuctionItem.Builder> getS2CItemBuilderList() {
                return getS2CItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AuctionHandler.AuctionItem, AuctionHandler.AuctionItem.Builder, AuctionHandler.AuctionItemOrBuilder> getS2CItemFieldBuilder() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItemBuilder_ = new RepeatedFieldBuilder(this.s2CItem_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.s2CItem_ = null;
                }
                return this.s2CItemBuilder_;
            }

            public boolean hasS2CType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CType() {
                return this.s2CType_;
            }

            public Builder setS2CType(int value) {
                this.bitField0_ |= 0x2;
                this.s2CType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CType_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class RemoveAuctionItemPush
            extends GeneratedMessage
            implements RemoveAuctionItemPushOrBuilder {
        private static final RemoveAuctionItemPush defaultInstance = new RemoveAuctionItemPush(true);
        private final UnknownFieldSet unknownFields;

        private RemoveAuctionItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RemoveAuctionItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RemoveAuctionItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public RemoveAuctionItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RemoveAuctionItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AuctionHandler.internal_static_pomelo_auction_RemoveAuctionItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AuctionHandler.internal_static_pomelo_auction_RemoveAuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(RemoveAuctionItemPush.class, Builder.class);
        }

        public static Parser<RemoveAuctionItemPush> PARSER = (Parser<RemoveAuctionItemPush>) new AbstractParser<RemoveAuctionItemPush>() {
            public AuctionHandler.RemoveAuctionItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AuctionHandler.RemoveAuctionItemPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RemoveAuctionItemPush> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }

        private void initFields() {
            this.id_ = "";
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RemoveAuctionItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(data);
        }

        public static RemoveAuctionItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RemoveAuctionItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(data);
        }

        public static RemoveAuctionItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RemoveAuctionItemPush parseFrom(InputStream input) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(input);
        }

        public static RemoveAuctionItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RemoveAuctionItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseDelimitedFrom(input);
        }

        public static RemoveAuctionItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RemoveAuctionItemPush parseFrom(CodedInputStream input) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(input);
        }

        public static RemoveAuctionItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RemoveAuctionItemPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RemoveAuctionItemPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AuctionHandler.RemoveAuctionItemPushOrBuilder {
            private int bitField0_;
            private Object id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AuctionHandler.internal_static_pomelo_auction_RemoveAuctionItemPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AuctionHandler.internal_static_pomelo_auction_RemoveAuctionItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AuctionHandler.RemoveAuctionItemPush.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AuctionHandler.RemoveAuctionItemPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AuctionHandler.internal_static_pomelo_auction_RemoveAuctionItemPush_descriptor;
            }

            public AuctionHandler.RemoveAuctionItemPush getDefaultInstanceForType() {
                return AuctionHandler.RemoveAuctionItemPush.getDefaultInstance();
            }

            public AuctionHandler.RemoveAuctionItemPush build() {
                AuctionHandler.RemoveAuctionItemPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AuctionHandler.RemoveAuctionItemPush buildPartial() {
                AuctionHandler.RemoveAuctionItemPush result = new AuctionHandler.RemoveAuctionItemPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AuctionHandler.RemoveAuctionItemPush)
                    return mergeFrom((AuctionHandler.RemoveAuctionItemPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuctionHandler.RemoveAuctionItemPush other) {
                if (other == AuctionHandler.RemoveAuctionItemPush.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AuctionHandler.RemoveAuctionItemPush parsedMessage = null;
                try {
                    parsedMessage = (AuctionHandler.RemoveAuctionItemPush) AuctionHandler.RemoveAuctionItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AuctionHandler.RemoveAuctionItemPush) e.getUnfinishedMessage();
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
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = AuctionHandler.RemoveAuctionItemPush.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\024auctionHandler.proto\022\016pomelo.auction\032\fcommon.proto\032\nitem.proto\"\030\n\026SyncAuctionInfoRequest\"<\n\027SyncAuctionInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\036\n\034CancelSyncAuctionInfoRequest\"B\n\035CancelSyncAuctionInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"²\001\n\013AuctionItem\022\n\n\002id\030\001 \002(\t\022'\n\006detail\030\002 \002(\0132\027.pomelo.item.ItemDetail\022\r\n\005state\030\003 \002(\005\022\020\n\btimeleft\030\004 \001(\005\022\020\n\bcurPrice\030\005 \001(\005\022\020\n\bmaxPrice\030\006 \001(\005\022\f\n\004self\030\007", " \001(\b\022\013\n\003num\030\b \001(\005\022\016\n\006source\030\t \001(\t\"&\n\022AuctionListRequest\022\020\n\bc2s_type\030\001 \002(\005\"z\n\023AuctionListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_data\030\003 \003(\0132\033.pomelo.auction.AuctionItem\022\021\n\ts2c_bonus\030\004 \001(\005\"/\n\016AuctionRequest\022\016\n\006itemId\030\001 \002(\t\022\r\n\005price\030\002 \002(\005\"4\n\017AuctionResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"P\n\nAuctionLog\022\n\n\002id\030\001 \002(\005\022\f\n\004time\030\002 \001(\t\022\r\n\005role1\030\003 \001(\t\022\f\n\004item\030\004 \001(\t\022\013\n\003num\030\005 \001(\005\"\023\n\021AuctionLogRequ", "est\"d\n\022AuctionLogResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\007s2c_log\030\003 \003(\0132\032.pomelo.auction.AuctionLog\"@\n\017AuctionItemPush\022-\n\bs2c_item\030\001 \002(\0132\033.pomelo.auction.AuctionItem\"U\n\022AddAuctionItemPush\022-\n\bs2c_item\030\001 \003(\0132\033.pomelo.auction.AuctionItem\022\020\n\bs2c_type\030\002 \001(\005\"#\n\025RemoveAuctionItemPush\022\n\n\002id\030\001 \002(\t2\004\n\016auctionHandler\022i\n\026syncAuctionInfoRequest\022&.pomelo.auction.SyncAuctionInfoRequest\032'.pomelo.auction.Sy", "ncAuctionInfoResponse\022{\n\034cancelSyncAuctionInfoRequest\022,.pomelo.auction.CancelSyncAuctionInfoRequest\032-.pomelo.auction.CancelSyncAuctionInfoResponse\022]\n\022auctionListRequest\022\".pomelo.auction.AuctionListRequest\032#.pomelo.auction.AuctionListResponse\022Q\n\016auctionRequest\022\036.pomelo.auction.AuctionRequest\032\037.pomelo.auction.AuctionResponse\022Z\n\021auctionLogRequest\022!.pomelo.auction.AuctionLogRequest\032\".pomelo.auction.Au", "ctionLogResponse2å\001\n\013auctionPush\022@\n\017auctionItemPush\022\037.pomelo.auction.AuctionItemPush\032\f.pomelo.Void\022F\n\022addAuctionItemPush\022\".pomelo.auction.AddAuctionItemPush\032\f.pomelo.Void\022L\n\025removeAuctionItemPush\022%.pomelo.auction.RemoveAuctionItemPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                AuctionHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_auction_SyncAuctionInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_SyncAuctionInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_SyncAuctionInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_auction_SyncAuctionInfoResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_SyncAuctionInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_SyncAuctionInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_CancelSyncAuctionInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_CancelSyncAuctionInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionItem_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionItem_descriptor, new String[]{"Id", "Detail", "State", "Timeleft", "CurPrice", "MaxPrice", "Self", "Num", "Source"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionListRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionListRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionListResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData", "S2CBonus"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionRequest_descriptor, new String[]{"ItemId", "Price"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionLog_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionLog_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionLog_descriptor, new String[]{"Id", "Time", "Role1", "Item", "Num"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionLogRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionLogRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionLogRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionLogResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionLogResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionLogResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLog"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AuctionItemPush_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AuctionItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AuctionItemPush_descriptor, new String[]{"S2CItem"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_AddAuctionItemPush_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_AddAuctionItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_AddAuctionItemPush_descriptor, new String[]{"S2CItem", "S2CType"});


    private static final Descriptors.Descriptor internal_static_pomelo_auction_RemoveAuctionItemPush_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_auction_RemoveAuctionItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_auction_RemoveAuctionItemPush_descriptor, new String[]{"Id"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface RemoveAuctionItemPushOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();
    }

    public static interface AddAuctionItemPushOrBuilder extends MessageOrBuilder {
        List<AuctionHandler.AuctionItem> getS2CItemList();

        AuctionHandler.AuctionItem getS2CItem(int param1Int);

        int getS2CItemCount();

        List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CItemOrBuilderList();

        AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder(int param1Int);

        boolean hasS2CType();

        int getS2CType();
    }

    public static interface AuctionItemPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CItem();

        AuctionHandler.AuctionItem getS2CItem();

        AuctionHandler.AuctionItemOrBuilder getS2CItemOrBuilder();
    }

    public static interface AuctionLogResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<AuctionHandler.AuctionLog> getS2CLogList();

        AuctionHandler.AuctionLog getS2CLog(int param1Int);

        int getS2CLogCount();

        List<? extends AuctionHandler.AuctionLogOrBuilder> getS2CLogOrBuilderList();

        AuctionHandler.AuctionLogOrBuilder getS2CLogOrBuilder(int param1Int);
    }

    public static interface AuctionLogRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface AuctionLogOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasTime();

        String getTime();

        ByteString getTimeBytes();

        boolean hasRole1();

        String getRole1();

        ByteString getRole1Bytes();

        boolean hasItem();

        String getItem();

        ByteString getItemBytes();

        boolean hasNum();

        int getNum();
    }

    public static interface AuctionResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AuctionRequestOrBuilder extends MessageOrBuilder {
        boolean hasItemId();

        String getItemId();

        ByteString getItemIdBytes();

        boolean hasPrice();

        int getPrice();
    }

    public static interface AuctionListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<AuctionHandler.AuctionItem> getS2CDataList();

        AuctionHandler.AuctionItem getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends AuctionHandler.AuctionItemOrBuilder> getS2CDataOrBuilderList();

        AuctionHandler.AuctionItemOrBuilder getS2CDataOrBuilder(int param1Int);

        boolean hasS2CBonus();

        int getS2CBonus();
    }

    public static interface AuctionListRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface AuctionItemOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasDetail();

        ItemOuterClass.ItemDetail getDetail();

        ItemOuterClass.ItemDetailOrBuilder getDetailOrBuilder();

        boolean hasState();

        int getState();

        boolean hasTimeleft();

        int getTimeleft();

        boolean hasCurPrice();

        int getCurPrice();

        boolean hasMaxPrice();

        int getMaxPrice();

        boolean hasSelf();

        boolean getSelf();

        boolean hasNum();

        int getNum();

        boolean hasSource();

        String getSource();

        ByteString getSourceBytes();
    }

    public static interface CancelSyncAuctionInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface CancelSyncAuctionInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface SyncAuctionInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SyncAuctionInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


