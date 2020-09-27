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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pomelo.Common;
import pomelo.item.ItemOuterClass;


public final class BagHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class PackUpBagRequest
            extends GeneratedMessage
            implements PackUpBagRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private PackUpBagRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PackUpBagRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PackUpBagRequest getDefaultInstance() {
            return defaultInstance;
        }

        public PackUpBagRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PackUpBagRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BagHandler.internal_static_pomelo_area_PackUpBagRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_PackUpBagRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PackUpBagRequest.class, Builder.class);
        }

        public static Parser<PackUpBagRequest> PARSER = (Parser<PackUpBagRequest>) new AbstractParser<PackUpBagRequest>() {
            public BagHandler.PackUpBagRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.PackUpBagRequest(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PackUpBagRequest> getParserForType() {
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

        private static final PackUpBagRequest defaultInstance = new PackUpBagRequest(true);

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SType_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackUpBagRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PackUpBagRequest) PARSER.parseFrom(data);
        }

        public static PackUpBagRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PackUpBagRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PackUpBagRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PackUpBagRequest) PARSER.parseFrom(data);
        }

        public static PackUpBagRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PackUpBagRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PackUpBagRequest parseFrom(InputStream input) throws IOException {
            return (PackUpBagRequest) PARSER.parseFrom(input);
        }

        public static PackUpBagRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PackUpBagRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (PackUpBagRequest) PARSER.parseDelimitedFrom(input);
        }

        public static PackUpBagRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PackUpBagRequest parseFrom(CodedInputStream input) throws IOException {
            return (PackUpBagRequest) PARSER.parseFrom(input);
        }

        public static PackUpBagRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackUpBagRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BagHandler.PackUpBagRequestOrBuilder {
            private int bitField0_;
            private int c2SType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_PackUpBagRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_PackUpBagRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.PackUpBagRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BagHandler.PackUpBagRequest.alwaysUseFieldBuilders) ;
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
                return BagHandler.internal_static_pomelo_area_PackUpBagRequest_descriptor;
            }

            public BagHandler.PackUpBagRequest getDefaultInstanceForType() {
                return BagHandler.PackUpBagRequest.getDefaultInstance();
            }

            public BagHandler.PackUpBagRequest build() {
                BagHandler.PackUpBagRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public BagHandler.PackUpBagRequest buildPartial() {
                BagHandler.PackUpBagRequest result = new BagHandler.PackUpBagRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.PackUpBagRequest) return mergeFrom((BagHandler.PackUpBagRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BagHandler.PackUpBagRequest other) {
                if (other == BagHandler.PackUpBagRequest.getDefaultInstance()) return this;
                if (other.hasC2SType()) setC2SType(other.getC2SType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.PackUpBagRequest parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.PackUpBagRequest) BagHandler.PackUpBagRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.PackUpBagRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
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

        static {
            defaultInstance.initFields();
        }

    }


    public static final class PackUpBagResponse
            extends GeneratedMessage
            implements PackUpBagResponseOrBuilder {
        private static final PackUpBagResponse defaultInstance = new PackUpBagResponse(true);
        private final UnknownFieldSet unknownFields;

        private PackUpBagResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PackUpBagResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PackUpBagResponse getDefaultInstance() {
            return defaultInstance;
        }

        public PackUpBagResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PackUpBagResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CType_ = input.readInt32();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.s2CBagGrids_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.s2CBagGrids_.add(input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.s2CBagGrids_ = Collections.unmodifiableList(this.s2CBagGrids_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_PackUpBagResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_PackUpBagResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PackUpBagResponse.class, Builder.class);
        }

        public static Parser<PackUpBagResponse> PARSER = (Parser<PackUpBagResponse>) new AbstractParser<PackUpBagResponse>() {
            public BagHandler.PackUpBagResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.PackUpBagResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TYPE_FIELD_NUMBER = 3;
        private int s2CType_;
        public static final int S2C_BAGGRIDS_FIELD_NUMBER = 4;
        private List<ItemOuterClass.Grid> s2CBagGrids_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PackUpBagResponse> getParserForType() {
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

        public boolean hasS2CType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CType() {
            return this.s2CType_;
        }

        public List<ItemOuterClass.Grid> getS2CBagGridsList() {
            return this.s2CBagGrids_;
        }

        public List<? extends ItemOuterClass.GridOrBuilder> getS2CBagGridsOrBuilderList() {
            return (List) this.s2CBagGrids_;
        }

        public int getS2CBagGridsCount() {
            return this.s2CBagGrids_.size();
        }

        public ItemOuterClass.Grid getS2CBagGrids(int index) {
            return this.s2CBagGrids_.get(index);
        }

        public ItemOuterClass.GridOrBuilder getS2CBagGridsOrBuilder(int index) {
            return (ItemOuterClass.GridOrBuilder) this.s2CBagGrids_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CType_ = 0;
            this.s2CBagGrids_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CBagGridsCount(); i++) {
                if (!getS2CBagGrids(i).isInitialized()) {
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
                output.writeInt32(3, this.s2CType_);
            for (int i = 0; i < this.s2CBagGrids_.size(); i++)
                output.writeMessage(4, (MessageLite) this.s2CBagGrids_.get(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CType_);
            for (int i = 0; i < this.s2CBagGrids_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.s2CBagGrids_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackUpBagResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PackUpBagResponse) PARSER.parseFrom(data);
        }

        public static PackUpBagResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PackUpBagResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PackUpBagResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PackUpBagResponse) PARSER.parseFrom(data);
        }

        public static PackUpBagResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PackUpBagResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PackUpBagResponse parseFrom(InputStream input) throws IOException {
            return (PackUpBagResponse) PARSER.parseFrom(input);
        }

        public static PackUpBagResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PackUpBagResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (PackUpBagResponse) PARSER.parseDelimitedFrom(input);
        }

        public static PackUpBagResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PackUpBagResponse parseFrom(CodedInputStream input) throws IOException {
            return (PackUpBagResponse) PARSER.parseFrom(input);
        }

        public static PackUpBagResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PackUpBagResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PackUpBagResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BagHandler.PackUpBagResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CType_;
            private List<ItemOuterClass.Grid> s2CBagGrids_;
            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> s2CBagGridsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_PackUpBagResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_PackUpBagResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.PackUpBagResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBagGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBagGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BagHandler.PackUpBagResponse.alwaysUseFieldBuilders)
                    getS2CBagGridsFieldBuilder();
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
                this.s2CType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.s2CBagGridsBuilder_ == null) {
                    this.s2CBagGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.s2CBagGridsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_PackUpBagResponse_descriptor;
            }

            public BagHandler.PackUpBagResponse getDefaultInstanceForType() {
                return BagHandler.PackUpBagResponse.getDefaultInstance();
            }

            public BagHandler.PackUpBagResponse build() {
                BagHandler.PackUpBagResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BagHandler.PackUpBagResponse buildPartial() {
                BagHandler.PackUpBagResponse result = new BagHandler.PackUpBagResponse(this);
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
                result.s2CType_ = this.s2CType_;
                if (this.s2CBagGridsBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.s2CBagGrids_ = Collections.unmodifiableList(this.s2CBagGrids_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.s2CBagGrids_ = this.s2CBagGrids_;
                } else {
                    result.s2CBagGrids_ = this.s2CBagGridsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.PackUpBagResponse)
                    return mergeFrom((BagHandler.PackUpBagResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BagHandler.PackUpBagResponse other) {
                if (other == BagHandler.PackUpBagResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CType())
                    setS2CType(other.getS2CType());
                if (this.s2CBagGridsBuilder_ == null) {
                    if (!other.s2CBagGrids_.isEmpty()) {
                        if (this.s2CBagGrids_.isEmpty()) {
                            this.s2CBagGrids_ = other.s2CBagGrids_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureS2CBagGridsIsMutable();
                            this.s2CBagGrids_.addAll(other.s2CBagGrids_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBagGrids_.isEmpty()) {
                    if (this.s2CBagGridsBuilder_.isEmpty()) {
                        this.s2CBagGridsBuilder_.dispose();
                        this.s2CBagGridsBuilder_ = null;
                        this.s2CBagGrids_ = other.s2CBagGrids_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.s2CBagGridsBuilder_ = BagHandler.PackUpBagResponse.alwaysUseFieldBuilders ? getS2CBagGridsFieldBuilder() : null;
                    } else {
                        this.s2CBagGridsBuilder_.addAllMessages(other.s2CBagGrids_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CBagGridsCount(); i++) {
                    if (!getS2CBagGrids(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.PackUpBagResponse parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.PackUpBagResponse) BagHandler.PackUpBagResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.PackUpBagResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BagHandler.PackUpBagResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CType() {
                return this.s2CType_;
            }

            public Builder setS2CType(int value) {
                this.bitField0_ |= 0x4;
                this.s2CType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CType_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CBagGridsIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.s2CBagGrids_ = new ArrayList<>(this.s2CBagGrids_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<ItemOuterClass.Grid> getS2CBagGridsList() {
                if (this.s2CBagGridsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CBagGrids_);
                return this.s2CBagGridsBuilder_.getMessageList();
            }

            public int getS2CBagGridsCount() {
                if (this.s2CBagGridsBuilder_ == null)
                    return this.s2CBagGrids_.size();
                return this.s2CBagGridsBuilder_.getCount();
            }

            public ItemOuterClass.Grid getS2CBagGrids(int index) {
                if (this.s2CBagGridsBuilder_ == null)
                    return this.s2CBagGrids_.get(index);
                return (ItemOuterClass.Grid) this.s2CBagGridsBuilder_.getMessage(index);
            }

            public Builder setS2CBagGrids(int index, ItemOuterClass.Grid value) {
                if (this.s2CBagGridsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CBagGrids(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CBagGridsBuilder_ == null) {
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBagGrids(ItemOuterClass.Grid value) {
                if (this.s2CBagGridsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.add(value);
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CBagGrids(int index, ItemOuterClass.Grid value) {
                if (this.s2CBagGridsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CBagGrids(ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CBagGridsBuilder_ == null) {
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBagGrids(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CBagGridsBuilder_ == null) {
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CBagGrids(Iterable<? extends ItemOuterClass.Grid> values) {
                if (this.s2CBagGridsBuilder_ == null) {
                    ensureS2CBagGridsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBagGrids_);
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CBagGrids() {
                if (this.s2CBagGridsBuilder_ == null) {
                    this.s2CBagGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CBagGrids(int index) {
                if (this.s2CBagGridsBuilder_ == null) {
                    ensureS2CBagGridsIsMutable();
                    this.s2CBagGrids_.remove(index);
                    onChanged();
                } else {
                    this.s2CBagGridsBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.Grid.Builder getS2CBagGridsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getS2CBagGridsFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.GridOrBuilder getS2CBagGridsOrBuilder(int index) {
                if (this.s2CBagGridsBuilder_ == null)
                    return (ItemOuterClass.GridOrBuilder) this.s2CBagGrids_.get(index);
                return (ItemOuterClass.GridOrBuilder) this.s2CBagGridsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.GridOrBuilder> getS2CBagGridsOrBuilderList() {
                if (this.s2CBagGridsBuilder_ != null)
                    return this.s2CBagGridsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CBagGrids_);
            }

            public ItemOuterClass.Grid.Builder addS2CBagGridsBuilder() {
                return (ItemOuterClass.Grid.Builder) getS2CBagGridsFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public ItemOuterClass.Grid.Builder addS2CBagGridsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getS2CBagGridsFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public List<ItemOuterClass.Grid.Builder> getS2CBagGridsBuilderList() {
                return getS2CBagGridsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getS2CBagGridsFieldBuilder() {
                if (this.s2CBagGridsBuilder_ == null) {
                    this.s2CBagGridsBuilder_ = new RepeatedFieldBuilder(this.s2CBagGrids_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.s2CBagGrids_ = null;
                }
                return this.s2CBagGridsBuilder_;
            }
        }
    }

    public static final class OpenBagGridRequest extends GeneratedMessage implements OpenBagGridRequestOrBuilder {
        private static final OpenBagGridRequest defaultInstance = new OpenBagGridRequest(true);
        private final UnknownFieldSet unknownFields;

        private OpenBagGridRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenBagGridRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenBagGridRequest getDefaultInstance() {
            return defaultInstance;
        }

        public OpenBagGridRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenBagGridRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SNumber_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_OpenBagGridRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_OpenBagGridRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenBagGridRequest.class, Builder.class);
        }

        public static Parser<OpenBagGridRequest> PARSER = (Parser<OpenBagGridRequest>) new AbstractParser<OpenBagGridRequest>() {
            public BagHandler.OpenBagGridRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.OpenBagGridRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        public static final int C2S_NUMBER_FIELD_NUMBER = 2;
        private int c2SNumber_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenBagGridRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SType() {
            return this.c2SType_;
        }

        public boolean hasC2SNumber() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SNumber() {
            return this.c2SNumber_;
        }


        private void initFields() {
            this.c2SType_ = 0;
            this.c2SNumber_ = 0;
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
            if (!hasC2SNumber()) {
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
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SNumber_);
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
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SNumber_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OpenBagGridRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenBagGridRequest) PARSER.parseFrom(data);
        }


        public static OpenBagGridRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenBagGridRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenBagGridRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenBagGridRequest) PARSER.parseFrom(data);
        }


        public static OpenBagGridRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenBagGridRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenBagGridRequest parseFrom(InputStream input) throws IOException {
            return (OpenBagGridRequest) PARSER.parseFrom(input);
        }


        public static OpenBagGridRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OpenBagGridRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenBagGridRequest) PARSER.parseDelimitedFrom(input);
        }


        public static OpenBagGridRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OpenBagGridRequest parseFrom(CodedInputStream input) throws IOException {
            return (OpenBagGridRequest) PARSER.parseFrom(input);
        }


        public static OpenBagGridRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OpenBagGridRequest prototype) {
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
                implements BagHandler.OpenBagGridRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            private int c2SNumber_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.OpenBagGridRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.OpenBagGridRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNumber_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridRequest_descriptor;
            }


            public BagHandler.OpenBagGridRequest getDefaultInstanceForType() {
                return BagHandler.OpenBagGridRequest.getDefaultInstance();
            }


            public BagHandler.OpenBagGridRequest build() {
                BagHandler.OpenBagGridRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.OpenBagGridRequest buildPartial() {
                BagHandler.OpenBagGridRequest result = new BagHandler.OpenBagGridRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SType_ = this.c2SType_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNumber_ = this.c2SNumber_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.OpenBagGridRequest) {
                    return mergeFrom((BagHandler.OpenBagGridRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.OpenBagGridRequest other) {
                if (other == BagHandler.OpenBagGridRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                if (other.hasC2SNumber()) {
                    setC2SNumber(other.getC2SNumber());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SType()) {
                    return false;
                }
                if (!hasC2SNumber()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.OpenBagGridRequest parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.OpenBagGridRequest) BagHandler.OpenBagGridRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.OpenBagGridRequest) e.getUnfinishedMessage();
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


            public boolean hasC2SNumber() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SNumber() {
                return this.c2SNumber_;
            }


            public Builder setC2SNumber(int value) {
                this.bitField0_ |= 0x2;
                this.c2SNumber_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNumber() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNumber_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OpenBagGridResponse
            extends GeneratedMessage
            implements OpenBagGridResponseOrBuilder {
        private static final OpenBagGridResponse defaultInstance = new OpenBagGridResponse(true);
        private final UnknownFieldSet unknownFields;

        private OpenBagGridResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenBagGridResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenBagGridResponse getDefaultInstance() {
            return defaultInstance;
        }

        public OpenBagGridResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenBagGridResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CType_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CBagGridCount_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_OpenBagGridResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_OpenBagGridResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenBagGridResponse.class, Builder.class);
        }

        public static Parser<OpenBagGridResponse> PARSER = (Parser<OpenBagGridResponse>) new AbstractParser<OpenBagGridResponse>() {
            public BagHandler.OpenBagGridResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.OpenBagGridResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TYPE_FIELD_NUMBER = 3;
        private int s2CType_;
        public static final int S2C_BAGGRIDCOUNT_FIELD_NUMBER = 4;
        private int s2CBagGridCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenBagGridResponse> getParserForType() {
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

        public boolean hasS2CType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CType() {
            return this.s2CType_;
        }

        public boolean hasS2CBagGridCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CBagGridCount() {
            return this.s2CBagGridCount_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CType_ = 0;
            this.s2CBagGridCount_ = 0;
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
                output.writeInt32(3, this.s2CType_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.s2CBagGridCount_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CType_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CBagGridCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OpenBagGridResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenBagGridResponse) PARSER.parseFrom(data);
        }

        public static OpenBagGridResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenBagGridResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenBagGridResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenBagGridResponse) PARSER.parseFrom(data);
        }

        public static OpenBagGridResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenBagGridResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenBagGridResponse parseFrom(InputStream input) throws IOException {
            return (OpenBagGridResponse) PARSER.parseFrom(input);
        }

        public static OpenBagGridResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OpenBagGridResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenBagGridResponse) PARSER.parseDelimitedFrom(input);
        }

        public static OpenBagGridResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OpenBagGridResponse parseFrom(CodedInputStream input) throws IOException {
            return (OpenBagGridResponse) PARSER.parseFrom(input);
        }

        public static OpenBagGridResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenBagGridResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OpenBagGridResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BagHandler.OpenBagGridResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CType_;
            private int s2CBagGridCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.OpenBagGridResponse.class, Builder.class);
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
                if (BagHandler.OpenBagGridResponse.alwaysUseFieldBuilders) ;
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
                this.s2CType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CBagGridCount_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_OpenBagGridResponse_descriptor;
            }

            public BagHandler.OpenBagGridResponse getDefaultInstanceForType() {
                return BagHandler.OpenBagGridResponse.getDefaultInstance();
            }

            public BagHandler.OpenBagGridResponse build() {
                BagHandler.OpenBagGridResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BagHandler.OpenBagGridResponse buildPartial() {
                BagHandler.OpenBagGridResponse result = new BagHandler.OpenBagGridResponse(this);
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
                result.s2CType_ = this.s2CType_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CBagGridCount_ = this.s2CBagGridCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.OpenBagGridResponse)
                    return mergeFrom((BagHandler.OpenBagGridResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BagHandler.OpenBagGridResponse other) {
                if (other == BagHandler.OpenBagGridResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CType())
                    setS2CType(other.getS2CType());
                if (other.hasS2CBagGridCount())
                    setS2CBagGridCount(other.getS2CBagGridCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.OpenBagGridResponse parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.OpenBagGridResponse) BagHandler.OpenBagGridResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.OpenBagGridResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BagHandler.OpenBagGridResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CType() {
                return this.s2CType_;
            }

            public Builder setS2CType(int value) {
                this.bitField0_ |= 0x4;
                this.s2CType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CBagGridCount() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CBagGridCount() {
                return this.s2CBagGridCount_;
            }

            public Builder setS2CBagGridCount(int value) {
                this.bitField0_ |= 0x8;
                this.s2CBagGridCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CBagGridCount() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CBagGridCount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class AddBagItemTestNotify extends GeneratedMessage implements AddBagItemTestNotifyOrBuilder {
        private static final AddBagItemTestNotify defaultInstance = new AddBagItemTestNotify(true);
        private final UnknownFieldSet unknownFields;

        private AddBagItemTestNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AddBagItemTestNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AddBagItemTestNotify getDefaultInstance() {
            return defaultInstance;
        }

        public AddBagItemTestNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddBagItemTestNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BagHandler.internal_static_pomelo_area_AddBagItemTestNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_AddBagItemTestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AddBagItemTestNotify.class, Builder.class);
        }

        public static Parser<AddBagItemTestNotify> PARSER = (Parser<AddBagItemTestNotify>) new AbstractParser<AddBagItemTestNotify>() {
            public BagHandler.AddBagItemTestNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.AddBagItemTestNotify(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AddBagItemTestNotify> getParserForType() {
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


        public static AddBagItemTestNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AddBagItemTestNotify) PARSER.parseFrom(data);
        }


        public static AddBagItemTestNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddBagItemTestNotify) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AddBagItemTestNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AddBagItemTestNotify) PARSER.parseFrom(data);
        }


        public static AddBagItemTestNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddBagItemTestNotify) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AddBagItemTestNotify parseFrom(InputStream input) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseFrom(input);
        }


        public static AddBagItemTestNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AddBagItemTestNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseDelimitedFrom(input);
        }


        public static AddBagItemTestNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AddBagItemTestNotify parseFrom(CodedInputStream input) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseFrom(input);
        }


        public static AddBagItemTestNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddBagItemTestNotify) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AddBagItemTestNotify prototype) {
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
                implements BagHandler.AddBagItemTestNotifyOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_AddBagItemTestNotify_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_AddBagItemTestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.AddBagItemTestNotify.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.AddBagItemTestNotify.alwaysUseFieldBuilders) ;
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
                return BagHandler.internal_static_pomelo_area_AddBagItemTestNotify_descriptor;
            }


            public BagHandler.AddBagItemTestNotify getDefaultInstanceForType() {
                return BagHandler.AddBagItemTestNotify.getDefaultInstance();
            }


            public BagHandler.AddBagItemTestNotify build() {
                BagHandler.AddBagItemTestNotify result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.AddBagItemTestNotify buildPartial() {
                BagHandler.AddBagItemTestNotify result = new BagHandler.AddBagItemTestNotify(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.AddBagItemTestNotify) {
                    return mergeFrom((BagHandler.AddBagItemTestNotify) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.AddBagItemTestNotify other) {
                if (other == BagHandler.AddBagItemTestNotify.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.AddBagItemTestNotify parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.AddBagItemTestNotify) BagHandler.AddBagItemTestNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.AddBagItemTestNotify) e.getUnfinishedMessage();
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


    public static final class TransferItemRequest
            extends GeneratedMessage
            implements TransferItemRequestOrBuilder {
        private static final TransferItemRequest defaultInstance = new TransferItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private TransferItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TransferItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TransferItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public TransferItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TransferItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SFromType_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SFromIndex_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SToType_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.c2SNum_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_TransferItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_TransferItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TransferItemRequest.class, Builder.class);
        }

        public static Parser<TransferItemRequest> PARSER = (Parser<TransferItemRequest>) new AbstractParser<TransferItemRequest>() {
            public BagHandler.TransferItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.TransferItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_FROMTYPE_FIELD_NUMBER = 1;
        private int c2SFromType_;
        public static final int C2S_FROMINDEX_FIELD_NUMBER = 2;
        private int c2SFromIndex_;
        public static final int C2S_TOTYPE_FIELD_NUMBER = 3;
        private int c2SToType_;
        public static final int C2S_NUM_FIELD_NUMBER = 4;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TransferItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SFromType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SFromType() {
            return this.c2SFromType_;
        }

        public boolean hasC2SFromIndex() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SFromIndex() {
            return this.c2SFromIndex_;
        }


        public boolean hasC2SToType() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SToType() {
            return this.c2SToType_;
        }


        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2SFromType_ = 0;
            this.c2SFromIndex_ = 0;
            this.c2SToType_ = 0;
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SFromType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SFromIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SToType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SFromType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SFromIndex_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SToType_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.c2SNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SFromType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SFromIndex_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SToType_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static TransferItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TransferItemRequest) PARSER.parseFrom(data);
        }


        public static TransferItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TransferItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TransferItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TransferItemRequest) PARSER.parseFrom(data);
        }


        public static TransferItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TransferItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TransferItemRequest parseFrom(InputStream input) throws IOException {
            return (TransferItemRequest) PARSER.parseFrom(input);
        }


        public static TransferItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TransferItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (TransferItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static TransferItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TransferItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (TransferItemRequest) PARSER.parseFrom(input);
        }


        public static TransferItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TransferItemRequest prototype) {
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
                implements BagHandler.TransferItemRequestOrBuilder {
            private int bitField0_;


            private int c2SFromType_;


            private int c2SFromIndex_;


            private int c2SToType_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_TransferItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_TransferItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.TransferItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.TransferItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SFromType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SFromIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SToType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_TransferItemRequest_descriptor;
            }


            public BagHandler.TransferItemRequest getDefaultInstanceForType() {
                return BagHandler.TransferItemRequest.getDefaultInstance();
            }


            public BagHandler.TransferItemRequest build() {
                BagHandler.TransferItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.TransferItemRequest buildPartial() {
                BagHandler.TransferItemRequest result = new BagHandler.TransferItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SFromType_ = this.c2SFromType_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SFromIndex_ = this.c2SFromIndex_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SToType_ = this.c2SToType_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.TransferItemRequest) {
                    return mergeFrom((BagHandler.TransferItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.TransferItemRequest other) {
                if (other == BagHandler.TransferItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SFromType()) {
                    setC2SFromType(other.getC2SFromType());
                }
                if (other.hasC2SFromIndex()) {
                    setC2SFromIndex(other.getC2SFromIndex());
                }
                if (other.hasC2SToType()) {
                    setC2SToType(other.getC2SToType());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SFromType()) {
                    return false;
                }
                if (!hasC2SFromIndex()) {
                    return false;
                }
                if (!hasC2SToType()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.TransferItemRequest parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.TransferItemRequest) BagHandler.TransferItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.TransferItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SFromType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SFromType() {
                return this.c2SFromType_;
            }


            public Builder setC2SFromType(int value) {
                this.bitField0_ |= 0x1;
                this.c2SFromType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SFromType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SFromType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SFromIndex() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SFromIndex() {
                return this.c2SFromIndex_;
            }


            public Builder setC2SFromIndex(int value) {
                this.bitField0_ |= 0x2;
                this.c2SFromIndex_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SFromIndex() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SFromIndex_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SToType() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SToType() {
                return this.c2SToType_;
            }


            public Builder setC2SToType(int value) {
                this.bitField0_ |= 0x4;
                this.c2SToType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SToType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SToType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x8;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class TransferItemResponse
            extends GeneratedMessage
            implements TransferItemResponseOrBuilder {
        private static final TransferItemResponse defaultInstance = new TransferItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private TransferItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TransferItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TransferItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public TransferItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TransferItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BagHandler.internal_static_pomelo_area_TransferItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_TransferItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TransferItemResponse.class, Builder.class);
        }

        public static Parser<TransferItemResponse> PARSER = (Parser<TransferItemResponse>) new AbstractParser<TransferItemResponse>() {
            public BagHandler.TransferItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.TransferItemResponse(input, extensionRegistry);
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

        public Parser<TransferItemResponse> getParserForType() {
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


        public static TransferItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TransferItemResponse) PARSER.parseFrom(data);
        }


        public static TransferItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TransferItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TransferItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TransferItemResponse) PARSER.parseFrom(data);
        }


        public static TransferItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TransferItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TransferItemResponse parseFrom(InputStream input) throws IOException {
            return (TransferItemResponse) PARSER.parseFrom(input);
        }


        public static TransferItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TransferItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (TransferItemResponse) PARSER.parseDelimitedFrom(input);
        }


        public static TransferItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TransferItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (TransferItemResponse) PARSER.parseFrom(input);
        }


        public static TransferItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TransferItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TransferItemResponse prototype) {
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
                implements BagHandler.TransferItemResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_TransferItemResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_TransferItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.TransferItemResponse.class, Builder.class);
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
                if (BagHandler.TransferItemResponse.alwaysUseFieldBuilders) ;
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
                return BagHandler.internal_static_pomelo_area_TransferItemResponse_descriptor;
            }


            public BagHandler.TransferItemResponse getDefaultInstanceForType() {
                return BagHandler.TransferItemResponse.getDefaultInstance();
            }


            public BagHandler.TransferItemResponse build() {
                BagHandler.TransferItemResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.TransferItemResponse buildPartial() {
                BagHandler.TransferItemResponse result = new BagHandler.TransferItemResponse(this);
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
                if (other instanceof BagHandler.TransferItemResponse) {
                    return mergeFrom((BagHandler.TransferItemResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.TransferItemResponse other) {
                if (other == BagHandler.TransferItemResponse.getDefaultInstance()) {
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
                BagHandler.TransferItemResponse parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.TransferItemResponse) BagHandler.TransferItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.TransferItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BagHandler.TransferItemResponse.getDefaultInstance().getS2CMsg();
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


    public static final class SellItemRequest
            extends GeneratedMessage
            implements SellItemRequestOrBuilder {
        private static final SellItemRequest defaultInstance = new SellItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private SellItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SellItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SellItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SellItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SellItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SGridIndex_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SNum_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_SellItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_SellItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SellItemRequest.class, Builder.class);
        }

        public static Parser<SellItemRequest> PARSER = (Parser<SellItemRequest>) new AbstractParser<SellItemRequest>() {
            public BagHandler.SellItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.SellItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_GRIDINDEX_FIELD_NUMBER = 1;
        private int c2SGridIndex_;
        public static final int C2S_NUM_FIELD_NUMBER = 2;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SellItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SGridIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SGridIndex() {
            return this.c2SGridIndex_;
        }

        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2SGridIndex_ = 0;
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SGridIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SellItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SellItemRequest) PARSER.parseFrom(data);
        }


        public static SellItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SellItemRequest) PARSER.parseFrom(data);
        }


        public static SellItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemRequest parseFrom(InputStream input) throws IOException {
            return (SellItemRequest) PARSER.parseFrom(input);
        }


        public static SellItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SellItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SellItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static SellItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SellItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (SellItemRequest) PARSER.parseFrom(input);
        }


        public static SellItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SellItemRequest prototype) {
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
                implements BagHandler.SellItemRequestOrBuilder {
            private int bitField0_;


            private int c2SGridIndex_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_SellItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_SellItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.SellItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.SellItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SGridIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_SellItemRequest_descriptor;
            }


            public BagHandler.SellItemRequest getDefaultInstanceForType() {
                return BagHandler.SellItemRequest.getDefaultInstance();
            }


            public BagHandler.SellItemRequest build() {
                BagHandler.SellItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.SellItemRequest buildPartial() {
                BagHandler.SellItemRequest result = new BagHandler.SellItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SGridIndex_ = this.c2SGridIndex_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.SellItemRequest) {
                    return mergeFrom((BagHandler.SellItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.SellItemRequest other) {
                if (other == BagHandler.SellItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SGridIndex()) {
                    setC2SGridIndex(other.getC2SGridIndex());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SGridIndex()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.SellItemRequest parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.SellItemRequest) BagHandler.SellItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.SellItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SGridIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SGridIndex() {
                return this.c2SGridIndex_;
            }


            public Builder setC2SGridIndex(int value) {
                this.bitField0_ |= 0x1;
                this.c2SGridIndex_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGridIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SGridIndex_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x2;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class SellItemResponse
            extends GeneratedMessage
            implements SellItemResponseOrBuilder {
        private static final SellItemResponse defaultInstance = new SellItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private SellItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SellItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SellItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SellItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SellItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BagHandler.internal_static_pomelo_area_SellItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_SellItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SellItemResponse.class, Builder.class);
        }

        public static Parser<SellItemResponse> PARSER = (Parser<SellItemResponse>) new AbstractParser<SellItemResponse>() {
            public BagHandler.SellItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.SellItemResponse(input, extensionRegistry);
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

        public Parser<SellItemResponse> getParserForType() {
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


        public static SellItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SellItemResponse) PARSER.parseFrom(data);
        }


        public static SellItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SellItemResponse) PARSER.parseFrom(data);
        }


        public static SellItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemResponse parseFrom(InputStream input) throws IOException {
            return (SellItemResponse) PARSER.parseFrom(input);
        }


        public static SellItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SellItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SellItemResponse) PARSER.parseDelimitedFrom(input);
        }


        public static SellItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SellItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (SellItemResponse) PARSER.parseFrom(input);
        }


        public static SellItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SellItemResponse prototype) {
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
                implements BagHandler.SellItemResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_SellItemResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_SellItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.SellItemResponse.class, Builder.class);
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
                if (BagHandler.SellItemResponse.alwaysUseFieldBuilders) ;
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
                return BagHandler.internal_static_pomelo_area_SellItemResponse_descriptor;
            }


            public BagHandler.SellItemResponse getDefaultInstanceForType() {
                return BagHandler.SellItemResponse.getDefaultInstance();
            }


            public BagHandler.SellItemResponse build() {
                BagHandler.SellItemResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.SellItemResponse buildPartial() {
                BagHandler.SellItemResponse result = new BagHandler.SellItemResponse(this);
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
                if (other instanceof BagHandler.SellItemResponse) {
                    return mergeFrom((BagHandler.SellItemResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.SellItemResponse other) {
                if (other == BagHandler.SellItemResponse.getDefaultInstance()) {
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
                BagHandler.SellItemResponse parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.SellItemResponse) BagHandler.SellItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.SellItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BagHandler.SellItemResponse.getDefaultInstance().getS2CMsg();
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


    public static final class UseItemRequest
            extends GeneratedMessage
            implements UseItemRequestOrBuilder {
        private static final UseItemRequest defaultInstance = new UseItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private UseItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UseItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UseItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UseItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UseItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SGridIndex_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SNum_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_UseItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_UseItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemRequest.class, Builder.class);
        }

        public static Parser<UseItemRequest> PARSER = (Parser<UseItemRequest>) new AbstractParser<UseItemRequest>() {
            public BagHandler.UseItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.UseItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_GRIDINDEX_FIELD_NUMBER = 1;
        private int c2SGridIndex_;
        public static final int C2S_NUM_FIELD_NUMBER = 2;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UseItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SGridIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SGridIndex() {
            return this.c2SGridIndex_;
        }

        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2SGridIndex_ = 0;
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SGridIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UseItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UseItemRequest) PARSER.parseFrom(data);
        }


        public static UseItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UseItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UseItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UseItemRequest) PARSER.parseFrom(data);
        }


        public static UseItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UseItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UseItemRequest parseFrom(InputStream input) throws IOException {
            return (UseItemRequest) PARSER.parseFrom(input);
        }


        public static UseItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UseItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UseItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static UseItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UseItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (UseItemRequest) PARSER.parseFrom(input);
        }


        public static UseItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UseItemRequest prototype) {
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
                implements BagHandler.UseItemRequestOrBuilder {
            private int bitField0_;


            private int c2SGridIndex_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_UseItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_UseItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.UseItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.UseItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SGridIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_UseItemRequest_descriptor;
            }


            public BagHandler.UseItemRequest getDefaultInstanceForType() {
                return BagHandler.UseItemRequest.getDefaultInstance();
            }


            public BagHandler.UseItemRequest build() {
                BagHandler.UseItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.UseItemRequest buildPartial() {
                BagHandler.UseItemRequest result = new BagHandler.UseItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SGridIndex_ = this.c2SGridIndex_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.UseItemRequest) {
                    return mergeFrom((BagHandler.UseItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.UseItemRequest other) {
                if (other == BagHandler.UseItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SGridIndex()) {
                    setC2SGridIndex(other.getC2SGridIndex());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SGridIndex()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.UseItemRequest parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.UseItemRequest) BagHandler.UseItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.UseItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SGridIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SGridIndex() {
                return this.c2SGridIndex_;
            }


            public Builder setC2SGridIndex(int value) {
                this.bitField0_ |= 0x1;
                this.c2SGridIndex_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGridIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SGridIndex_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x2;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class UseItemResponse
            extends GeneratedMessage
            implements UseItemResponseOrBuilder {
        private static final UseItemResponse defaultInstance = new UseItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private UseItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UseItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UseItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UseItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UseItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CChest_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CChest_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.isGain_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CChest_ = Collections.unmodifiableList(this.s2CChest_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_UseItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_UseItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UseItemResponse.class, Builder.class);
        }

        public static Parser<UseItemResponse> PARSER = (Parser<UseItemResponse>) new AbstractParser<UseItemResponse>() {
            public BagHandler.UseItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.UseItemResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_CHEST_FIELD_NUMBER = 3;
        private List<ItemOuterClass.MiniItem> s2CChest_;
        public static final int IS_GAIN_FIELD_NUMBER = 4;
        private int isGain_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UseItemResponse> getParserForType() {
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


        public List<ItemOuterClass.MiniItem> getS2CChestList() {
            return this.s2CChest_;
        }


        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestOrBuilderList() {
            return (List) this.s2CChest_;
        }


        public int getS2CChestCount() {
            return this.s2CChest_.size();
        }


        public ItemOuterClass.MiniItem getS2CChest(int index) {
            return this.s2CChest_.get(index);
        }


        public ItemOuterClass.MiniItemOrBuilder getS2CChestOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CChest_.get(index);
        }


        public boolean hasIsGain() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getIsGain() {
            return this.isGain_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CChest_ = Collections.emptyList();
            this.isGain_ = 0;
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
            for (int i = 0; i < getS2CChestCount(); i++) {
                if (!getS2CChest(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CChest_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CChest_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.isGain_);
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
            for (int i = 0; i < this.s2CChest_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CChest_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.isGain_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UseItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UseItemResponse) PARSER.parseFrom(data);
        }


        public static UseItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UseItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UseItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UseItemResponse) PARSER.parseFrom(data);
        }


        public static UseItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UseItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UseItemResponse parseFrom(InputStream input) throws IOException {
            return (UseItemResponse) PARSER.parseFrom(input);
        }


        public static UseItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UseItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UseItemResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UseItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UseItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (UseItemResponse) PARSER.parseFrom(input);
        }


        public static UseItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UseItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UseItemResponse prototype) {
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
                implements BagHandler.UseItemResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private List<ItemOuterClass.MiniItem> s2CChest_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CChestBuilder_;


            private int isGain_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_UseItemResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_UseItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.UseItemResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CChest_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CChest_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.UseItemResponse.alwaysUseFieldBuilders) {
                    getS2CChestFieldBuilder();
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
                if (this.s2CChestBuilder_ == null) {
                    this.s2CChest_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CChestBuilder_.clear();
                }
                this.isGain_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_UseItemResponse_descriptor;
            }


            public BagHandler.UseItemResponse getDefaultInstanceForType() {
                return BagHandler.UseItemResponse.getDefaultInstance();
            }


            public BagHandler.UseItemResponse build() {
                BagHandler.UseItemResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.UseItemResponse buildPartial() {
                BagHandler.UseItemResponse result = new BagHandler.UseItemResponse(this);
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
                if (this.s2CChestBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CChest_ = Collections.unmodifiableList(this.s2CChest_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CChest_ = this.s2CChest_;
                } else {
                    result.s2CChest_ = this.s2CChestBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.isGain_ = this.isGain_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.UseItemResponse) {
                    return mergeFrom((BagHandler.UseItemResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.UseItemResponse other) {
                if (other == BagHandler.UseItemResponse.getDefaultInstance()) {
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
                if (this.s2CChestBuilder_ == null) {
                    if (!other.s2CChest_.isEmpty()) {
                        if (this.s2CChest_.isEmpty()) {
                            this.s2CChest_ = other.s2CChest_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CChestIsMutable();
                            this.s2CChest_.addAll(other.s2CChest_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CChest_.isEmpty()) {
                    if (this.s2CChestBuilder_.isEmpty()) {
                        this.s2CChestBuilder_.dispose();
                        this.s2CChestBuilder_ = null;
                        this.s2CChest_ = other.s2CChest_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CChestBuilder_ = BagHandler.UseItemResponse.alwaysUseFieldBuilders ? getS2CChestFieldBuilder() : null;
                    } else {
                        this.s2CChestBuilder_.addAllMessages(other.s2CChest_);
                    }
                }
                if (other.hasIsGain()) {
                    setIsGain(other.getIsGain());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CChestCount(); i++) {
                    if (!getS2CChest(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.UseItemResponse parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.UseItemResponse) BagHandler.UseItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.UseItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BagHandler.UseItemResponse.getDefaultInstance().getS2CMsg();
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


            private void ensureS2CChestIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CChest_ = new ArrayList<>(this.s2CChest_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<ItemOuterClass.MiniItem> getS2CChestList() {
                if (this.s2CChestBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CChest_);
                }
                return this.s2CChestBuilder_.getMessageList();
            }


            public int getS2CChestCount() {
                if (this.s2CChestBuilder_ == null) {
                    return this.s2CChest_.size();
                }
                return this.s2CChestBuilder_.getCount();
            }


            public ItemOuterClass.MiniItem getS2CChest(int index) {
                if (this.s2CChestBuilder_ == null) {
                    return this.s2CChest_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.s2CChestBuilder_.getMessage(index);
            }


            public Builder setS2CChest(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CChestBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CChestIsMutable();
                    this.s2CChest_.set(index, value);
                    onChanged();
                } else {
                    this.s2CChestBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setS2CChest(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestBuilder_ == null) {
                    ensureS2CChestIsMutable();
                    this.s2CChest_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CChest(ItemOuterClass.MiniItem value) {
                if (this.s2CChestBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CChestIsMutable();
                    this.s2CChest_.add(value);
                    onChanged();
                } else {
                    this.s2CChestBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CChest(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CChestBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CChestIsMutable();
                    this.s2CChest_.add(index, value);
                    onChanged();
                } else {
                    this.s2CChestBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CChest(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestBuilder_ == null) {
                    ensureS2CChestIsMutable();
                    this.s2CChest_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CChest(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestBuilder_ == null) {
                    ensureS2CChestIsMutable();
                    this.s2CChest_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CChest(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.s2CChestBuilder_ == null) {
                    ensureS2CChestIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CChest_);
                    onChanged();
                } else {
                    this.s2CChestBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearS2CChest() {
                if (this.s2CChestBuilder_ == null) {
                    this.s2CChest_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CChestBuilder_.clear();
                }
                return this;
            }


            public Builder removeS2CChest(int index) {
                if (this.s2CChestBuilder_ == null) {
                    ensureS2CChestIsMutable();
                    this.s2CChest_.remove(index);
                    onChanged();
                } else {
                    this.s2CChestBuilder_.remove(index);
                }
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getS2CChestBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getS2CChestOrBuilder(int index) {
                if (this.s2CChestBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CChest_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CChestBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestOrBuilderList() {
                if (this.s2CChestBuilder_ != null) {
                    return this.s2CChestBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CChest_);
            }


            public ItemOuterClass.MiniItem.Builder addS2CChestBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addS2CChestBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getS2CChestBuilderList() {
                return getS2CChestFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CChestFieldBuilder() {
                if (this.s2CChestBuilder_ == null) {
                    this.s2CChestBuilder_ = new RepeatedFieldBuilder(this.s2CChest_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CChest_ = null;
                }
                return this.s2CChestBuilder_;
            }


            public boolean hasIsGain() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getIsGain() {
                return this.isGain_;
            }


            public Builder setIsGain(int value) {
                this.bitField0_ |= 0x8;
                this.isGain_ = value;
                onChanged();
                return this;
            }


            public Builder clearIsGain() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.isGain_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BagItemUpdatePush
            extends GeneratedMessage
            implements BagItemUpdatePushOrBuilder {
        private static final BagItemUpdatePush defaultInstance = new BagItemUpdatePush(true);
        private final UnknownFieldSet unknownFields;

        private BagItemUpdatePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BagItemUpdatePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BagItemUpdatePush getDefaultInstance() {
            return defaultInstance;
        }

        public BagItemUpdatePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BagItemUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x1;
                            this.s2CType_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CData_.add(input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_BagItemUpdatePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagItemUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagItemUpdatePush.class, Builder.class);
        }

        public static Parser<BagItemUpdatePush> PARSER = (Parser<BagItemUpdatePush>) new AbstractParser<BagItemUpdatePush>() {
            public BagHandler.BagItemUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagItemUpdatePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_TYPE_FIELD_NUMBER = 2;
        private int s2CType_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private List<ItemOuterClass.Grid> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BagItemUpdatePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CType() {
            return this.s2CType_;
        }

        public List<ItemOuterClass.Grid> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends ItemOuterClass.GridOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getS2CDataCount() {
            return this.s2CData_.size();
        }


        public ItemOuterClass.Grid getS2CData(int index) {
            return this.s2CData_.get(index);
        }


        public ItemOuterClass.GridOrBuilder getS2CDataOrBuilder(int index) {
            return (ItemOuterClass.GridOrBuilder) this.s2CData_.get(index);
        }


        private void initFields() {
            this.s2CType_ = 0;
            this.s2CData_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasS2CType()) {
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
                output.writeInt32(2, this.s2CType_);
            }
            for (int i = 0; i < this.s2CData_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CData_.get(i));
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
                size += CodedOutputStream.computeInt32Size(2, this.s2CType_);
            }
            for (int i = 0; i < this.s2CData_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BagItemUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagItemUpdatePush) PARSER.parseFrom(data);
        }


        public static BagItemUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagItemUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagItemUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagItemUpdatePush) PARSER.parseFrom(data);
        }


        public static BagItemUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagItemUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagItemUpdatePush parseFrom(InputStream input) throws IOException {
            return (BagItemUpdatePush) PARSER.parseFrom(input);
        }


        public static BagItemUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagItemUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BagItemUpdatePush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagItemUpdatePush) PARSER.parseDelimitedFrom(input);
        }


        public static BagItemUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagItemUpdatePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BagItemUpdatePush parseFrom(CodedInputStream input) throws IOException {
            return (BagItemUpdatePush) PARSER.parseFrom(input);
        }


        public static BagItemUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagItemUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BagItemUpdatePush prototype) {
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
                implements BagHandler.BagItemUpdatePushOrBuilder {
            private int bitField0_;


            private int s2CType_;


            private List<ItemOuterClass.Grid> s2CData_;


            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagItemUpdatePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagItemUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagItemUpdatePush.class, Builder.class);
            }


            private Builder() {
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagItemUpdatePush.alwaysUseFieldBuilders) {
                    getS2CDataFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagItemUpdatePush_descriptor;
            }


            public BagHandler.BagItemUpdatePush getDefaultInstanceForType() {
                return BagHandler.BagItemUpdatePush.getDefaultInstance();
            }


            public BagHandler.BagItemUpdatePush build() {
                BagHandler.BagItemUpdatePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.BagItemUpdatePush buildPartial() {
                BagHandler.BagItemUpdatePush result = new BagHandler.BagItemUpdatePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CType_ = this.s2CType_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagItemUpdatePush) {
                    return mergeFrom((BagHandler.BagItemUpdatePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.BagItemUpdatePush other) {
                if (other == BagHandler.BagItemUpdatePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CType()) {
                    setS2CType(other.getS2CType());
                }
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.s2CDataBuilder_ = BagHandler.BagItemUpdatePush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CType()) {
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
                BagHandler.BagItemUpdatePush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagItemUpdatePush) BagHandler.BagItemUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagItemUpdatePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasS2CType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getS2CType() {
                return this.s2CType_;
            }


            public Builder setS2CType(int value) {
                this.bitField0_ |= 0x1;
                this.s2CType_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CType_ = 0;
                onChanged();
                return this;
            }


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<ItemOuterClass.Grid> getS2CDataList() {
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


            public ItemOuterClass.Grid getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (ItemOuterClass.Grid) this.s2CDataBuilder_.getMessage(index);
            }


            public Builder setS2CData(int index, ItemOuterClass.Grid value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setS2CData(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.Grid value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.Grid value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CData(Iterable<? extends ItemOuterClass.Grid> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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


            public ItemOuterClass.Grid.Builder getS2CDataBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.GridOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return (ItemOuterClass.GridOrBuilder) this.s2CData_.get(index);
                }
                return (ItemOuterClass.GridOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.GridOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CData_);
            }


            public ItemOuterClass.Grid.Builder addS2CDataBuilder() {
                return (ItemOuterClass.Grid.Builder) getS2CDataFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }


            public ItemOuterClass.Grid.Builder addS2CDataBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }


            public List<ItemOuterClass.Grid.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class BagNewItemPush
            extends GeneratedMessage
            implements BagNewItemPushOrBuilder {
        private static final BagNewItemPush defaultInstance = new BagNewItemPush(true);
        private final UnknownFieldSet unknownFields;

        private BagNewItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BagNewItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BagNewItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public BagNewItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BagNewItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.s2CData_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_BagNewItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagNewItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagNewItemPush.class, Builder.class);
        }

        public static Parser<BagNewItemPush> PARSER = (Parser<BagNewItemPush>) new AbstractParser<BagNewItemPush>() {
            public BagHandler.BagNewItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagNewItemPush(input, extensionRegistry);
            }
        };
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private List<ItemOuterClass.MiniItem> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BagNewItemPush> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.MiniItem> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public ItemOuterClass.MiniItem getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CData_.get(index);
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.s2CData_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
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
            for (int i = 0; i < this.s2CData_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.s2CData_.get(i));
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.s2CData_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CData_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BagNewItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagNewItemPush) PARSER.parseFrom(data);
        }


        public static BagNewItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagNewItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagNewItemPush) PARSER.parseFrom(data);
        }


        public static BagNewItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagNewItemPush parseFrom(InputStream input) throws IOException {
            return (BagNewItemPush) PARSER.parseFrom(input);
        }


        public static BagNewItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BagNewItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagNewItemPush) PARSER.parseDelimitedFrom(input);
        }


        public static BagNewItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BagNewItemPush parseFrom(CodedInputStream input) throws IOException {
            return (BagNewItemPush) PARSER.parseFrom(input);
        }


        public static BagNewItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BagNewItemPush prototype) {
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
                implements BagHandler.BagNewItemPushOrBuilder {
            private int bitField0_;


            private List<ItemOuterClass.MiniItem> s2CData_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagNewItemPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagNewItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagNewItemPush.class, Builder.class);
            }


            private Builder() {
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagNewItemPush.alwaysUseFieldBuilders) {
                    getS2CDataFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagNewItemPush_descriptor;
            }


            public BagHandler.BagNewItemPush getDefaultInstanceForType() {
                return BagHandler.BagNewItemPush.getDefaultInstance();
            }


            public BagHandler.BagNewItemPush build() {
                BagHandler.BagNewItemPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.BagNewItemPush buildPartial() {
                BagHandler.BagNewItemPush result = new BagHandler.BagNewItemPush(this);
                int from_bitField0_ = this.bitField0_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = this.s2CDataBuilder_.build();
                }
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagNewItemPush) {
                    return mergeFrom((BagHandler.BagNewItemPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.BagNewItemPush other) {
                if (other == BagHandler.BagNewItemPush.getDefaultInstance()) {
                    return this;
                }
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFE;
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
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.s2CDataBuilder_ = BagHandler.BagNewItemPush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                for (int i = 0; i < getS2CDataCount(); i++) {
                    if (!getS2CData(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.BagNewItemPush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagNewItemPush) BagHandler.BagNewItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagNewItemPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x1;
                }
            }


            public List<ItemOuterClass.MiniItem> getS2CDataList() {
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


            public ItemOuterClass.MiniItem getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.s2CDataBuilder_.getMessage(index);
            }


            public Builder setS2CData(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setS2CData(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CData(Iterable<? extends ItemOuterClass.MiniItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFFE;
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


            public ItemOuterClass.MiniItem.Builder getS2CDataBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CData_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CData_);
            }


            public ItemOuterClass.MiniItem.Builder addS2CDataBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addS2CDataBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class BagNewEquipPush
            extends GeneratedMessage
            implements BagNewEquipPushOrBuilder {
        private static final BagNewEquipPush defaultInstance = new BagNewEquipPush(true);
        private final UnknownFieldSet unknownFields;

        private BagNewEquipPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BagNewEquipPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BagNewEquipPush getDefaultInstance() {
            return defaultInstance;
        }

        public BagNewEquipPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BagNewEquipPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.s2CData_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.s2CData_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.s2CData_ = this.s2CData_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_BagNewEquipPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagNewEquipPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagNewEquipPush.class, Builder.class);
        }

        public static Parser<BagNewEquipPush> PARSER = (Parser<BagNewEquipPush>) new AbstractParser<BagNewEquipPush>() {
            public BagHandler.BagNewEquipPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagNewEquipPush(input, extensionRegistry);
            }
        };
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private LazyStringList s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BagNewEquipPush> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getS2CDataList() {
            return (ProtocolStringList) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public String getS2CData(int index) {
            return (String) this.s2CData_.get(index);
        }

        public ByteString getS2CDataBytes(int index) {
            return this.s2CData_.getByteString(index);
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.s2CData_ = LazyStringArrayList.EMPTY;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.s2CData_.size(); i++) {
                output.writeBytes(2, this.s2CData_.getByteString(i));
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            int dataSize = 0;
            for (int i = 0; i < this.s2CData_.size(); i++) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.s2CData_.getByteString(i));
            }
            size += dataSize;
            size += 1 * getS2CDataList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BagNewEquipPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagNewEquipPush) PARSER.parseFrom(data);
        }


        public static BagNewEquipPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewEquipPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagNewEquipPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagNewEquipPush) PARSER.parseFrom(data);
        }


        public static BagNewEquipPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewEquipPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagNewEquipPush parseFrom(InputStream input) throws IOException {
            return (BagNewEquipPush) PARSER.parseFrom(input);
        }


        public static BagNewEquipPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewEquipPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BagNewEquipPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagNewEquipPush) PARSER.parseDelimitedFrom(input);
        }


        public static BagNewEquipPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewEquipPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BagNewEquipPush parseFrom(CodedInputStream input) throws IOException {
            return (BagNewEquipPush) PARSER.parseFrom(input);
        }


        public static BagNewEquipPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewEquipPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BagNewEquipPush prototype) {
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
                implements BagHandler.BagNewEquipPushOrBuilder {
            private int bitField0_;


            private LazyStringList s2CData_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagNewEquipPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagNewEquipPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagNewEquipPush.class, Builder.class);
            }


            private Builder() {
                this.s2CData_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagNewEquipPush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CData_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagNewEquipPush_descriptor;
            }


            public BagHandler.BagNewEquipPush getDefaultInstanceForType() {
                return BagHandler.BagNewEquipPush.getDefaultInstance();
            }


            public BagHandler.BagNewEquipPush build() {
                BagHandler.BagNewEquipPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.BagNewEquipPush buildPartial() {
                BagHandler.BagNewEquipPush result = new BagHandler.BagNewEquipPush(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 0x1) == 1) {
                    this.s2CData_ = this.s2CData_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.s2CData_ = this.s2CData_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagNewEquipPush) {
                    return mergeFrom((BagHandler.BagNewEquipPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.BagNewEquipPush other) {
                if (other == BagHandler.BagNewEquipPush.getDefaultInstance()) {
                    return this;
                }
                if (!other.s2CData_.isEmpty()) {
                    if (this.s2CData_.isEmpty()) {
                        this.s2CData_ = other.s2CData_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        ensureS2CDataIsMutable();
                        this.s2CData_.addAll((Collection) other.s2CData_);
                    }
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.BagNewEquipPush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagNewEquipPush) BagHandler.BagNewEquipPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagNewEquipPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.s2CData_ = (LazyStringList) new LazyStringArrayList(this.s2CData_);
                    this.bitField0_ |= 0x1;
                }
            }


            public ProtocolStringList getS2CDataList() {
                return (ProtocolStringList) this.s2CData_.getUnmodifiableView();
            }


            public int getS2CDataCount() {
                return this.s2CData_.size();
            }


            public String getS2CData(int index) {
                return (String) this.s2CData_.get(index);
            }


            public ByteString getS2CDataBytes(int index) {
                return this.s2CData_.getByteString(index);
            }


            public Builder setS2CData(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureS2CDataIsMutable();
                this.s2CData_.set(index, value);
                onChanged();
                return this;
            }


            public Builder addS2CData(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureS2CDataIsMutable();
                this.s2CData_.add(value);
                onChanged();
                return this;
            }


            public Builder addAllS2CData(Iterable<String> values) {
                ensureS2CDataIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.s2CData_);
                onChanged();
                return this;
            }


            public Builder clearS2CData() {
                this.s2CData_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                onChanged();
                return this;
            }


            public Builder addS2CDataBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureS2CDataIsMutable();
                this.s2CData_.add(value);
                onChanged();
                return this;
            }
        }
    }


    public static final class BagGridFullPush
            extends GeneratedMessage
            implements BagGridFullPushOrBuilder {
        private static final BagGridFullPush defaultInstance = new BagGridFullPush(true);
        private final UnknownFieldSet unknownFields;

        private BagGridFullPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BagGridFullPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BagGridFullPush getDefaultInstance() {
            return defaultInstance;
        }

        public BagGridFullPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BagGridFullPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BagHandler.internal_static_pomelo_area_BagGridFullPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagGridFullPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagGridFullPush.class, Builder.class);
        }

        public static Parser<BagGridFullPush> PARSER = (Parser<BagGridFullPush>) new AbstractParser<BagGridFullPush>() {
            public BagHandler.BagGridFullPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagGridFullPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BagGridFullPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BagGridFullPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagGridFullPush) PARSER.parseFrom(data);
        }


        public static BagGridFullPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagGridFullPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagGridFullPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagGridFullPush) PARSER.parseFrom(data);
        }


        public static BagGridFullPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagGridFullPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagGridFullPush parseFrom(InputStream input) throws IOException {
            return (BagGridFullPush) PARSER.parseFrom(input);
        }


        public static BagGridFullPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridFullPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BagGridFullPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagGridFullPush) PARSER.parseDelimitedFrom(input);
        }


        public static BagGridFullPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridFullPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BagGridFullPush parseFrom(CodedInputStream input) throws IOException {
            return (BagGridFullPush) PARSER.parseFrom(input);
        }


        public static BagGridFullPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridFullPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BagGridFullPush prototype) {
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
                implements BagHandler.BagGridFullPushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagGridFullPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagGridFullPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagGridFullPush.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagGridFullPush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagGridFullPush_descriptor;
            }


            public BagHandler.BagGridFullPush getDefaultInstanceForType() {
                return BagHandler.BagGridFullPush.getDefaultInstance();
            }


            public BagHandler.BagGridFullPush build() {
                BagHandler.BagGridFullPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BagHandler.BagGridFullPush buildPartial() {
                BagHandler.BagGridFullPush result = new BagHandler.BagGridFullPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagGridFullPush) {
                    return mergeFrom((BagHandler.BagGridFullPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BagHandler.BagGridFullPush other) {
                if (other == BagHandler.BagGridFullPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
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
                BagHandler.BagGridFullPush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagGridFullPush) BagHandler.BagGridFullPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagGridFullPush) e.getUnfinishedMessage();
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
        }
    }


    public static final class BagGridNumPush
            extends GeneratedMessage
            implements BagGridNumPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private BagGridNumPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private BagGridNumPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static BagGridNumPush getDefaultInstance() {
            return defaultInstance;
        }


        public BagGridNumPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private BagGridNumPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CType_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.gridNum_ = input.readInt32();
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
            return BagHandler.internal_static_pomelo_area_BagGridNumPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagGridNumPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagGridNumPush.class, Builder.class);
        }


        public static Parser<BagGridNumPush> PARSER = (Parser<BagGridNumPush>) new AbstractParser<BagGridNumPush>() {
            public BagHandler.BagGridNumPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagGridNumPush(input, extensionRegistry);
            }
        };


        private int bitField0_;

        public static final int S2C_TYPE_FIELD_NUMBER = 1;

        private int s2CType_;

        public static final int GRID_NUM_FIELD_NUMBER = 2;

        private int gridNum_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<BagGridNumPush> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CType() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getS2CType() {
            return this.s2CType_;
        }


        public boolean hasGridNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getGridNum() {
            return this.gridNum_;
        }


        private void initFields() {
            this.s2CType_ = 0;
            this.gridNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasS2CType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGridNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.gridNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.s2CType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.gridNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BagGridNumPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagGridNumPush) PARSER.parseFrom(data);
        }


        public static BagGridNumPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagGridNumPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagGridNumPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagGridNumPush) PARSER.parseFrom(data);
        }


        public static BagGridNumPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagGridNumPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BagGridNumPush parseFrom(InputStream input) throws IOException {
            return (BagGridNumPush) PARSER.parseFrom(input);
        }


        private static final BagGridNumPush defaultInstance = new BagGridNumPush(true);

        public static BagGridNumPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridNumPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BagGridNumPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagGridNumPush) PARSER.parseDelimitedFrom(input);
        }

        public static BagGridNumPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridNumPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BagGridNumPush parseFrom(CodedInputStream input) throws IOException {
            return (BagGridNumPush) PARSER.parseFrom(input);
        }

        public static BagGridNumPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagGridNumPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BagGridNumPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BagHandler.BagGridNumPushOrBuilder {
            private int bitField0_;
            private int s2CType_;
            private int gridNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagGridNumPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagGridNumPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagGridNumPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagGridNumPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.gridNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagGridNumPush_descriptor;
            }

            public BagHandler.BagGridNumPush getDefaultInstanceForType() {
                return BagHandler.BagGridNumPush.getDefaultInstance();
            }

            public BagHandler.BagGridNumPush build() {
                BagHandler.BagGridNumPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public BagHandler.BagGridNumPush buildPartial() {
                BagHandler.BagGridNumPush result = new BagHandler.BagGridNumPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CType_ = this.s2CType_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.gridNum_ = this.gridNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagGridNumPush) return mergeFrom((BagHandler.BagGridNumPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BagHandler.BagGridNumPush other) {
                if (other == BagHandler.BagGridNumPush.getDefaultInstance()) return this;
                if (other.hasS2CType()) setS2CType(other.getS2CType());
                if (other.hasGridNum()) setGridNum(other.getGridNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CType()) return false;
                if (!hasGridNum()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.BagGridNumPush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagGridNumPush) BagHandler.BagGridNumPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagGridNumPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasS2CType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getS2CType() {
                return this.s2CType_;
            }

            public Builder setS2CType(int value) {
                this.bitField0_ |= 0x1;
                this.s2CType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGridNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getGridNum() {
                return this.gridNum_;
            }

            public Builder setGridNum(int value) {
                this.bitField0_ |= 0x2;
                this.gridNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearGridNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.gridNum_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BagNewItemFromResFubenPush
            extends GeneratedMessage
            implements BagNewItemFromResFubenPushOrBuilder {
        private static final BagNewItemFromResFubenPush defaultInstance = new BagNewItemFromResFubenPush(true);
        private final UnknownFieldSet unknownFields;

        private BagNewItemFromResFubenPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BagNewItemFromResFubenPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BagNewItemFromResFubenPush getDefaultInstance() {
            return defaultInstance;
        }

        public BagNewItemFromResFubenPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BagNewItemFromResFubenPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.s2CData_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BagHandler.internal_static_pomelo_area_BagNewItemFromResFubenPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BagHandler.internal_static_pomelo_area_BagNewItemFromResFubenPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagNewItemFromResFubenPush.class, Builder.class);
        }

        public static Parser<BagNewItemFromResFubenPush> PARSER = (Parser<BagNewItemFromResFubenPush>) new AbstractParser<BagNewItemFromResFubenPush>() {
            public BagHandler.BagNewItemFromResFubenPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BagHandler.BagNewItemFromResFubenPush(input, extensionRegistry);
            }
        };
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private List<ItemOuterClass.MiniItem> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BagNewItemFromResFubenPush> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.MiniItem> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public ItemOuterClass.MiniItem getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CData_.get(index);
        }

        private void initFields() {
            this.s2CData_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(2, (MessageLite) this.s2CData_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.s2CData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CData_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BagNewItemFromResFubenPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(data);
        }

        public static BagNewItemFromResFubenPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BagNewItemFromResFubenPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(data);
        }

        public static BagNewItemFromResFubenPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BagNewItemFromResFubenPush parseFrom(InputStream input) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(input);
        }

        public static BagNewItemFromResFubenPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BagNewItemFromResFubenPush parseDelimitedFrom(InputStream input) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseDelimitedFrom(input);
        }

        public static BagNewItemFromResFubenPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BagNewItemFromResFubenPush parseFrom(CodedInputStream input) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(input);
        }

        public static BagNewItemFromResFubenPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BagNewItemFromResFubenPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        static {
            defaultInstance.initFields();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BagNewItemFromResFubenPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BagHandler.BagNewItemFromResFubenPushOrBuilder {
            private int bitField0_;
            private List<ItemOuterClass.MiniItem> s2CData_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BagHandler.internal_static_pomelo_area_BagNewItemFromResFubenPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BagHandler.internal_static_pomelo_area_BagNewItemFromResFubenPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BagHandler.BagNewItemFromResFubenPush.class, Builder.class);
            }

            private Builder() {
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BagHandler.BagNewItemFromResFubenPush.alwaysUseFieldBuilders)
                    getS2CDataFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BagHandler.internal_static_pomelo_area_BagNewItemFromResFubenPush_descriptor;
            }

            public BagHandler.BagNewItemFromResFubenPush getDefaultInstanceForType() {
                return BagHandler.BagNewItemFromResFubenPush.getDefaultInstance();
            }

            public BagHandler.BagNewItemFromResFubenPush build() {
                BagHandler.BagNewItemFromResFubenPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BagHandler.BagNewItemFromResFubenPush buildPartial() {
                BagHandler.BagNewItemFromResFubenPush result = new BagHandler.BagNewItemFromResFubenPush(this);
                int from_bitField0_ = this.bitField0_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = this.s2CDataBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BagHandler.BagNewItemFromResFubenPush)
                    return mergeFrom((BagHandler.BagNewItemFromResFubenPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BagHandler.BagNewItemFromResFubenPush other) {
                if (other == BagHandler.BagNewItemFromResFubenPush.getDefaultInstance())
                    return this;
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFE;
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
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.s2CDataBuilder_ = BagHandler.BagNewItemFromResFubenPush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getS2CDataCount(); i++) {
                    if (!getS2CData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BagHandler.BagNewItemFromResFubenPush parsedMessage = null;
                try {
                    parsedMessage = (BagHandler.BagNewItemFromResFubenPush) BagHandler.BagNewItemFromResFubenPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BagHandler.BagNewItemFromResFubenPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<ItemOuterClass.MiniItem> getS2CDataList() {
                if (this.s2CDataBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CData_);
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.size();
                return this.s2CDataBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getS2CData(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (ItemOuterClass.MiniItem) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CData(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CData(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CData(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends ItemOuterClass.MiniItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFFE;
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

            public ItemOuterClass.MiniItem.Builder getS2CDataBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CData_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null)
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CData_);
            }

            public ItemOuterClass.MiniItem.Builder addS2CDataBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addS2CDataBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
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
        String[] descriptorData = {"\n\020bagHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"$\n\020PackUpBagRequest\022\020\n\bc2s_type\030\001 \002(\005\"q\n\021PackUpBagResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_type\030\003 \001(\005\022'\n\fs2c_bagGrids\030\004 \003(\0132\021.pomelo.item.Grid\":\n\022OpenBagGridRequest\022\020\n\bc2s_type\030\001 \002(\005\022\022\n\nc2s_number\030\002 \002(\005\"d\n\023OpenBagGridResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\020\n\bs2c_type\030\003 \001(\005\022\030\n\020s2c_bagGridCount\030\004 \001(\005\"\026\n\024AddBagItemTestNotify\"g\n\023", "TransferItemRequest\022\024\n\fc2s_fromType\030\001 \002(\005\022\025\n\rc2s_fromIndex\030\002 \002(\005\022\022\n\nc2s_toType\030\003 \002(\005\022\017\n\007c2s_num\030\004 \002(\005\"9\n\024TransferItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"9\n\017SellItemRequest\022\025\n\rc2s_gridIndex\030\001 \002(\005\022\017\n\007c2s_num\030\002 \002(\005\"5\n\020SellItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"8\n\016UseItemRequest\022\025\n\rc2s_gridIndex\030\001 \002(\005\022\017\n\007c2s_num\030\002 \002(\005\"o\n\017UseItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\ts2c_chest\030", "\003 \003(\0132\025.pomelo.item.MiniItem\022\017\n\007is_gain\030\004 \001(\005\"J\n\021BagItemUpdatePush\022\020\n\bs2c_type\030\002 \002(\005\022#\n\bs2c_data\030\003 \003(\0132\021.pomelo.item.Grid\"9\n\016BagNewItemPush\022'\n\bs2c_data\030\002 \003(\0132\025.pomelo.item.MiniItem\"#\n\017BagNewEquipPush\022\020\n\bs2c_data\030\002 \003(\t\"#\n\017BagGridFullPush\022\020\n\bs2c_code\030\001 \002(\005\"4\n\016BagGridNumPush\022\020\n\bs2c_type\030\001 \002(\005\022\020\n\bgrid_num\030\002 \002(\005\"E\n\032BagNewItemFromResFubenPush\022'\n\bs2c_data\030\002 \003(\0132\025.pomelo.item.MiniItem2ú\003\n\nbagHandler\022G\n\024ad", "dBagItemTestNotify\022!.pomelo.area.AddBagItemTestNotify\032\f.pomelo.Void\022Q\n\020packUpBagRequest\022\035.pomelo.area.PackUpBagRequest\032\036.pomelo.area.PackUpBagResponse\022W\n\022openBagGridRequest\022\037.pomelo.area.OpenBagGridRequest\032 .pomelo.area.OpenBagGridResponse\022Z\n\023transferItemRequest\022 .pomelo.area.TransferItemRequest\032!.pomelo.area.TransferItemResponse\022N\n\017sellItemRequest\022\034.pomelo.area.SellItemRequest\032\035.pomelo.area.SellI", "temResponse\022K\n\016useItemRequest\022\033.pomelo.area.UseItemRequest\032\034.pomelo.area.UseItemResponse2\003\n\007bagPush\022A\n\021bagItemUpdatePush\022\036.pomelo.area.BagItemUpdatePush\032\f.pomelo.Void\022;\n\016bagNewItemPush\022\033.pomelo.area.BagNewItemPush\032\f.pomelo.Void\022=\n\017bagNewEquipPush\022\034.pomelo.area.BagNewEquipPush\032\f.pomelo.Void\022=\n\017bagGridFullPush\022\034.pomelo.area.BagGridFullPush\032\f.pomelo.Void\022;\n\016bagGridNumPush\022\033.pomelo.area.BagGridNumPus", "h\032\f.pomelo.Void\022S\n\032bagNewItemFromResFubenPush\022'.pomelo.area.BagNewItemFromResFubenPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                BagHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_PackUpBagRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PackUpBagRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PackUpBagRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PackUpBagResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PackUpBagResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PackUpBagResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CType", "S2CBagGrids"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OpenBagGridRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OpenBagGridRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OpenBagGridRequest_descriptor, new String[]{"C2SType", "C2SNumber"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OpenBagGridResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OpenBagGridResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OpenBagGridResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CType", "S2CBagGridCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AddBagItemTestNotify_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddBagItemTestNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddBagItemTestNotify_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_TransferItemRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TransferItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TransferItemRequest_descriptor, new String[]{"C2SFromType", "C2SFromIndex", "C2SToType", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TransferItemResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TransferItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TransferItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SellItemRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SellItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SellItemRequest_descriptor, new String[]{"C2SGridIndex", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SellItemResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SellItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SellItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UseItemRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UseItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UseItemRequest_descriptor, new String[]{"C2SGridIndex", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UseItemResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UseItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UseItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CChest", "IsGain"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagItemUpdatePush_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagItemUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagItemUpdatePush_descriptor, new String[]{"S2CType", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagNewItemPush_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagNewItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagNewItemPush_descriptor, new String[]{"S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagNewEquipPush_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagNewEquipPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagNewEquipPush_descriptor, new String[]{"S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagGridFullPush_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagGridFullPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagGridFullPush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagGridNumPush_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagGridNumPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagGridNumPush_descriptor, new String[]{"S2CType", "GridNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BagNewItemFromResFubenPush_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BagNewItemFromResFubenPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BagNewItemFromResFubenPush_descriptor, new String[]{"S2CData"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface BagNewItemFromResFubenPushOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.MiniItem> getS2CDataList();

        ItemOuterClass.MiniItem getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface BagGridNumPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CType();

        int getS2CType();

        boolean hasGridNum();

        int getGridNum();
    }

    public static interface BagGridFullPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface BagNewEquipPushOrBuilder extends MessageOrBuilder {
        ProtocolStringList getS2CDataList();

        int getS2CDataCount();

        String getS2CData(int param1Int);

        ByteString getS2CDataBytes(int param1Int);
    }

    public static interface BagNewItemPushOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.MiniItem> getS2CDataList();

        ItemOuterClass.MiniItem getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CDataOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface BagItemUpdatePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CType();

        int getS2CType();

        List<ItemOuterClass.Grid> getS2CDataList();

        ItemOuterClass.Grid getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends ItemOuterClass.GridOrBuilder> getS2CDataOrBuilderList();

        ItemOuterClass.GridOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface UseItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ItemOuterClass.MiniItem> getS2CChestList();

        ItemOuterClass.MiniItem getS2CChest(int param1Int);

        int getS2CChestCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CChestOrBuilder(int param1Int);

        boolean hasIsGain();

        int getIsGain();
    }

    public static interface UseItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SGridIndex();

        int getC2SGridIndex();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface SellItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SellItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SGridIndex();

        int getC2SGridIndex();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface TransferItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface TransferItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SFromType();

        int getC2SFromType();

        boolean hasC2SFromIndex();

        int getC2SFromIndex();

        boolean hasC2SToType();

        int getC2SToType();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface AddBagItemTestNotifyOrBuilder extends MessageOrBuilder {
    }

    public static interface OpenBagGridResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CType();

        int getS2CType();

        boolean hasS2CBagGridCount();

        int getS2CBagGridCount();
    }

    public static interface OpenBagGridRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();

        boolean hasC2SNumber();

        int getC2SNumber();
    }

    public static interface PackUpBagResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CType();

        int getS2CType();

        List<ItemOuterClass.Grid> getS2CBagGridsList();

        ItemOuterClass.Grid getS2CBagGrids(int param1Int);

        int getS2CBagGridsCount();

        List<? extends ItemOuterClass.GridOrBuilder> getS2CBagGridsOrBuilderList();

        ItemOuterClass.GridOrBuilder getS2CBagGridsOrBuilder(int param1Int);
    }

    public static interface PackUpBagRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }
}


