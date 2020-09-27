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
import pomelo.item.ItemOuterClass;


public final class ItemHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class QueryItemStatusUpdateNotify
            extends GeneratedMessage
            implements QueryItemStatusUpdateNotifyOrBuilder {
        private static final QueryItemStatusUpdateNotify defaultInstance = new QueryItemStatusUpdateNotify(true);
        private final UnknownFieldSet unknownFields;

        private QueryItemStatusUpdateNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QueryItemStatusUpdateNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QueryItemStatusUpdateNotify getDefaultInstance() {
            return defaultInstance;
        }

        public QueryItemStatusUpdateNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryItemStatusUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ItemHandler.internal_static_pomelo_area_QueryItemStatusUpdateNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_QueryItemStatusUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryItemStatusUpdateNotify.class, Builder.class);
        }

        public static Parser<QueryItemStatusUpdateNotify> PARSER = (Parser<QueryItemStatusUpdateNotify>) new AbstractParser<QueryItemStatusUpdateNotify>() {
            public ItemHandler.QueryItemStatusUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.QueryItemStatusUpdateNotify(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INDEX_FIELD_NUMBER = 1;
        private int index_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QueryItemStatusUpdateNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getIndex() {
            return this.index_;
        }

        private void initFields() {
            this.index_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.index_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.index_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static QueryItemStatusUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(data);
        }

        public static QueryItemStatusUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryItemStatusUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(data);
        }

        public static QueryItemStatusUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryItemStatusUpdateNotify parseFrom(InputStream input) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(input);
        }

        public static QueryItemStatusUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QueryItemStatusUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseDelimitedFrom(input);
        }

        public static QueryItemStatusUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QueryItemStatusUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(input);
        }

        public static QueryItemStatusUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryItemStatusUpdateNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QueryItemStatusUpdateNotify prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ItemHandler.QueryItemStatusUpdateNotifyOrBuilder {
            private int bitField0_;
            private int index_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_QueryItemStatusUpdateNotify_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_QueryItemStatusUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.QueryItemStatusUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemHandler.QueryItemStatusUpdateNotify.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.index_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_QueryItemStatusUpdateNotify_descriptor;
            }

            public ItemHandler.QueryItemStatusUpdateNotify getDefaultInstanceForType() {
                return ItemHandler.QueryItemStatusUpdateNotify.getDefaultInstance();
            }

            public ItemHandler.QueryItemStatusUpdateNotify build() {
                ItemHandler.QueryItemStatusUpdateNotify result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ItemHandler.QueryItemStatusUpdateNotify buildPartial() {
                ItemHandler.QueryItemStatusUpdateNotify result = new ItemHandler.QueryItemStatusUpdateNotify(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.index_ = this.index_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.QueryItemStatusUpdateNotify)
                    return mergeFrom((ItemHandler.QueryItemStatusUpdateNotify) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHandler.QueryItemStatusUpdateNotify other) {
                if (other == ItemHandler.QueryItemStatusUpdateNotify.getDefaultInstance()) return this;
                if (other.hasIndex()) setIndex(other.getIndex());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIndex()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.QueryItemStatusUpdateNotify parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.QueryItemStatusUpdateNotify) ItemHandler.QueryItemStatusUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.QueryItemStatusUpdateNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.bitField0_ |= 0x1;
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.index_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetAllEquipDetailsRequest
            extends GeneratedMessage
            implements GetAllEquipDetailsRequestOrBuilder {
        private static final GetAllEquipDetailsRequest defaultInstance = new GetAllEquipDetailsRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetAllEquipDetailsRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAllEquipDetailsRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAllEquipDetailsRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetAllEquipDetailsRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllEquipDetailsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllEquipDetailsRequest.class, Builder.class);
        }

        public static Parser<GetAllEquipDetailsRequest> PARSER = (Parser<GetAllEquipDetailsRequest>) new AbstractParser<GetAllEquipDetailsRequest>() {
            public ItemHandler.GetAllEquipDetailsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.GetAllEquipDetailsRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAllEquipDetailsRequest> getParserForType() {
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

        public static GetAllEquipDetailsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(data);
        }

        public static GetAllEquipDetailsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllEquipDetailsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(data);
        }

        public static GetAllEquipDetailsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllEquipDetailsRequest parseFrom(InputStream input) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(input);
        }

        public static GetAllEquipDetailsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAllEquipDetailsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetAllEquipDetailsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAllEquipDetailsRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(input);
        }

        public static GetAllEquipDetailsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAllEquipDetailsRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ItemHandler.GetAllEquipDetailsRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.GetAllEquipDetailsRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemHandler.GetAllEquipDetailsRequest.alwaysUseFieldBuilders) ;
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
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsRequest_descriptor;
            }

            public ItemHandler.GetAllEquipDetailsRequest getDefaultInstanceForType() {
                return ItemHandler.GetAllEquipDetailsRequest.getDefaultInstance();
            }

            public ItemHandler.GetAllEquipDetailsRequest build() {
                ItemHandler.GetAllEquipDetailsRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ItemHandler.GetAllEquipDetailsRequest buildPartial() {
                ItemHandler.GetAllEquipDetailsRequest result = new ItemHandler.GetAllEquipDetailsRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.GetAllEquipDetailsRequest)
                    return mergeFrom((ItemHandler.GetAllEquipDetailsRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHandler.GetAllEquipDetailsRequest other) {
                if (other == ItemHandler.GetAllEquipDetailsRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.GetAllEquipDetailsRequest parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.GetAllEquipDetailsRequest) ItemHandler.GetAllEquipDetailsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.GetAllEquipDetailsRequest) e.getUnfinishedMessage();
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


    public static final class GetAllEquipDetailsResponse
            extends GeneratedMessage
            implements GetAllEquipDetailsResponseOrBuilder {
        private static final GetAllEquipDetailsResponse defaultInstance = new GetAllEquipDetailsResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetAllEquipDetailsResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAllEquipDetailsResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAllEquipDetailsResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetAllEquipDetailsResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllEquipDetailsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CItems_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllEquipDetailsResponse.class, Builder.class);
        }

        public static Parser<GetAllEquipDetailsResponse> PARSER = (Parser<GetAllEquipDetailsResponse>) new AbstractParser<GetAllEquipDetailsResponse>() {
            public ItemHandler.GetAllEquipDetailsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.GetAllEquipDetailsResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ITEMS_FIELD_NUMBER = 3;
        private List<ItemOuterClass.ItemDetail> s2CItems_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAllEquipDetailsResponse> getParserForType() {
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

        public List<ItemOuterClass.ItemDetail> getS2CItemsList() {
            return this.s2CItems_;
        }

        public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CItemsOrBuilderList() {
            return (List) this.s2CItems_;
        }

        public int getS2CItemsCount() {
            return this.s2CItems_.size();
        }

        public ItemOuterClass.ItemDetail getS2CItems(int index) {
            return this.s2CItems_.get(index);
        }

        public ItemOuterClass.ItemDetailOrBuilder getS2CItemsOrBuilder(int index) {
            return (ItemOuterClass.ItemDetailOrBuilder) this.s2CItems_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CItems_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CItemsCount(); i++) {
                if (!getS2CItems(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CItems_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CItems_.get(i));
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
            for (int i = 0; i < this.s2CItems_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CItems_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetAllEquipDetailsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(data);
        }

        public static GetAllEquipDetailsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllEquipDetailsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(data);
        }

        public static GetAllEquipDetailsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllEquipDetailsResponse parseFrom(InputStream input) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(input);
        }

        public static GetAllEquipDetailsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAllEquipDetailsResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetAllEquipDetailsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAllEquipDetailsResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(input);
        }

        public static GetAllEquipDetailsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllEquipDetailsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAllEquipDetailsResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ItemHandler.GetAllEquipDetailsResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<ItemOuterClass.ItemDetail> s2CItems_;
            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> s2CItemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.GetAllEquipDetailsResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemHandler.GetAllEquipDetailsResponse.alwaysUseFieldBuilders)
                    getS2CItemsFieldBuilder();
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
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CItemsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_GetAllEquipDetailsResponse_descriptor;
            }

            public ItemHandler.GetAllEquipDetailsResponse getDefaultInstanceForType() {
                return ItemHandler.GetAllEquipDetailsResponse.getDefaultInstance();
            }

            public ItemHandler.GetAllEquipDetailsResponse build() {
                ItemHandler.GetAllEquipDetailsResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ItemHandler.GetAllEquipDetailsResponse buildPartial() {
                ItemHandler.GetAllEquipDetailsResponse result = new ItemHandler.GetAllEquipDetailsResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CItems_ = this.s2CItems_;
                } else {
                    result.s2CItems_ = this.s2CItemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.GetAllEquipDetailsResponse)
                    return mergeFrom((ItemHandler.GetAllEquipDetailsResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHandler.GetAllEquipDetailsResponse other) {
                if (other == ItemHandler.GetAllEquipDetailsResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CItemsBuilder_ == null) {
                    if (!other.s2CItems_.isEmpty()) {
                        if (this.s2CItems_.isEmpty()) {
                            this.s2CItems_ = other.s2CItems_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CItemsIsMutable();
                            this.s2CItems_.addAll(other.s2CItems_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CItems_.isEmpty()) {
                    if (this.s2CItemsBuilder_.isEmpty()) {
                        this.s2CItemsBuilder_.dispose();
                        this.s2CItemsBuilder_ = null;
                        this.s2CItems_ = other.s2CItems_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CItemsBuilder_ = ItemHandler.GetAllEquipDetailsResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
                    } else {
                        this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CItemsCount(); i++) {
                    if (!getS2CItems(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.GetAllEquipDetailsResponse parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.GetAllEquipDetailsResponse) ItemHandler.GetAllEquipDetailsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.GetAllEquipDetailsResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ItemHandler.GetAllEquipDetailsResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CItems_ = new ArrayList<>(this.s2CItems_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<ItemOuterClass.ItemDetail> getS2CItemsList() {
                if (this.s2CItemsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CItems_);
                return this.s2CItemsBuilder_.getMessageList();
            }

            public int getS2CItemsCount() {
                if (this.s2CItemsBuilder_ == null)
                    return this.s2CItems_.size();
                return this.s2CItemsBuilder_.getCount();
            }

            public ItemOuterClass.ItemDetail getS2CItems(int index) {
                if (this.s2CItemsBuilder_ == null)
                    return this.s2CItems_.get(index);
                return (ItemOuterClass.ItemDetail) this.s2CItemsBuilder_.getMessage(index);
            }

            public Builder setS2CItems(int index, ItemOuterClass.ItemDetail value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CItems(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItems(ItemOuterClass.ItemDetail value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CItems(int index, ItemOuterClass.ItemDetail value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CItems(ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItems(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CItems(Iterable<? extends ItemOuterClass.ItemDetail> values) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CItems_);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CItems() {
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CItems(int index) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.remove(index);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.ItemDetail.Builder getS2CItemsBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getS2CItemsFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.ItemDetailOrBuilder getS2CItemsOrBuilder(int index) {
                if (this.s2CItemsBuilder_ == null)
                    return (ItemOuterClass.ItemDetailOrBuilder) this.s2CItems_.get(index);
                return (ItemOuterClass.ItemDetailOrBuilder) this.s2CItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CItemsOrBuilderList() {
                if (this.s2CItemsBuilder_ != null)
                    return this.s2CItemsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CItems_);
            }

            public ItemOuterClass.ItemDetail.Builder addS2CItemsBuilder() {
                return (ItemOuterClass.ItemDetail.Builder) getS2CItemsFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public ItemOuterClass.ItemDetail.Builder addS2CItemsBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getS2CItemsFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public List<ItemOuterClass.ItemDetail.Builder> getS2CItemsBuilderList() {
                return getS2CItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getS2CItemsFieldBuilder() {
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CItems_ = null;
                }
                return this.s2CItemsBuilder_;
            }
        }
    }

    public static final class GetCombineFormulaRequest extends GeneratedMessage implements GetCombineFormulaRequestOrBuilder {
        private static final GetCombineFormulaRequest defaultInstance = new GetCombineFormulaRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetCombineFormulaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetCombineFormulaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetCombineFormulaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetCombineFormulaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetCombineFormulaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SDestID_ = input.readInt32();
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
            return ItemHandler.internal_static_pomelo_area_GetCombineFormulaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_GetCombineFormulaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCombineFormulaRequest.class, Builder.class);
        }

        public static Parser<GetCombineFormulaRequest> PARSER = (Parser<GetCombineFormulaRequest>) new AbstractParser<GetCombineFormulaRequest>() {
            public ItemHandler.GetCombineFormulaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.GetCombineFormulaRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_DESTID_FIELD_NUMBER = 1;
        private int c2SDestID_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetCombineFormulaRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SDestID() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SDestID() {
            return this.c2SDestID_;
        }

        private void initFields() {
            this.c2SDestID_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SDestID()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SDestID_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SDestID_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetCombineFormulaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(data);
        }

        public static GetCombineFormulaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetCombineFormulaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(data);
        }

        public static GetCombineFormulaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetCombineFormulaRequest parseFrom(InputStream input) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(input);
        }

        public static GetCombineFormulaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetCombineFormulaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetCombineFormulaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetCombineFormulaRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(input);
        }

        public static GetCombineFormulaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetCombineFormulaRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ItemHandler.GetCombineFormulaRequestOrBuilder {
            private int bitField0_;
            private int c2SDestID_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.GetCombineFormulaRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemHandler.GetCombineFormulaRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SDestID_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaRequest_descriptor;
            }

            public ItemHandler.GetCombineFormulaRequest getDefaultInstanceForType() {
                return ItemHandler.GetCombineFormulaRequest.getDefaultInstance();
            }

            public ItemHandler.GetCombineFormulaRequest build() {
                ItemHandler.GetCombineFormulaRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ItemHandler.GetCombineFormulaRequest buildPartial() {
                ItemHandler.GetCombineFormulaRequest result = new ItemHandler.GetCombineFormulaRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SDestID_ = this.c2SDestID_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.GetCombineFormulaRequest)
                    return mergeFrom((ItemHandler.GetCombineFormulaRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHandler.GetCombineFormulaRequest other) {
                if (other == ItemHandler.GetCombineFormulaRequest.getDefaultInstance()) return this;
                if (other.hasC2SDestID()) setC2SDestID(other.getC2SDestID());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SDestID()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.GetCombineFormulaRequest parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.GetCombineFormulaRequest) ItemHandler.GetCombineFormulaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.GetCombineFormulaRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SDestID() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SDestID() {
                return this.c2SDestID_;
            }

            public Builder setC2SDestID(int value) {
                this.bitField0_ |= 0x1;
                this.c2SDestID_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SDestID() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SDestID_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class GetCombineFormulaResponse
            extends GeneratedMessage
            implements GetCombineFormulaResponseOrBuilder {
        private static final GetCombineFormulaResponse defaultInstance = new GetCombineFormulaResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetCombineFormulaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetCombineFormulaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetCombineFormulaResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetCombineFormulaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetCombineFormulaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ItemOuterClass.Combine.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();
                            this.s2CData_ = (ItemOuterClass.Combine) input.readMessage(ItemOuterClass.Combine.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CData_);
                                this.s2CData_ = subBuilder.buildPartial();
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
            return ItemHandler.internal_static_pomelo_area_GetCombineFormulaResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_GetCombineFormulaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCombineFormulaResponse.class, Builder.class);
        }

        public static Parser<GetCombineFormulaResponse> PARSER = (Parser<GetCombineFormulaResponse>) new AbstractParser<GetCombineFormulaResponse>() {
            public ItemHandler.GetCombineFormulaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.GetCombineFormulaResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private ItemOuterClass.Combine s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetCombineFormulaResponse> getParserForType() {
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


        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public ItemOuterClass.Combine getS2CData() {
            return this.s2CData_;
        }


        public ItemOuterClass.CombineOrBuilder getS2CDataOrBuilder() {
            return (ItemOuterClass.CombineOrBuilder) this.s2CData_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = ItemOuterClass.Combine.getDefaultInstance();
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
            if (hasS2CData() && !getS2CData().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetCombineFormulaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(data);
        }


        public static GetCombineFormulaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCombineFormulaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(data);
        }


        public static GetCombineFormulaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCombineFormulaResponse parseFrom(InputStream input) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(input);
        }


        public static GetCombineFormulaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetCombineFormulaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetCombineFormulaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetCombineFormulaResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(input);
        }


        public static GetCombineFormulaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCombineFormulaResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetCombineFormulaResponse prototype) {
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
                implements ItemHandler.GetCombineFormulaResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private ItemOuterClass.Combine s2CData_;


            private SingleFieldBuilder<ItemOuterClass.Combine, ItemOuterClass.Combine.Builder, ItemOuterClass.CombineOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.GetCombineFormulaResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = ItemOuterClass.Combine.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = ItemOuterClass.Combine.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ItemHandler.GetCombineFormulaResponse.alwaysUseFieldBuilders) {
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
                    this.s2CData_ = ItemOuterClass.Combine.getDefaultInstance();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_GetCombineFormulaResponse_descriptor;
            }


            public ItemHandler.GetCombineFormulaResponse getDefaultInstanceForType() {
                return ItemHandler.GetCombineFormulaResponse.getDefaultInstance();
            }


            public ItemHandler.GetCombineFormulaResponse build() {
                ItemHandler.GetCombineFormulaResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.GetCombineFormulaResponse buildPartial() {
                ItemHandler.GetCombineFormulaResponse result = new ItemHandler.GetCombineFormulaResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (ItemOuterClass.Combine) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.GetCombineFormulaResponse) {
                    return mergeFrom((ItemHandler.GetCombineFormulaResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.GetCombineFormulaResponse other) {
                if (other == ItemHandler.GetCombineFormulaResponse.getDefaultInstance()) {
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
                if (other.hasS2CData()) {
                    mergeS2CData(other.getS2CData());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CData() && !getS2CData().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.GetCombineFormulaResponse parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.GetCombineFormulaResponse) ItemHandler.GetCombineFormulaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.GetCombineFormulaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ItemHandler.GetCombineFormulaResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public ItemOuterClass.Combine getS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_;
                }
                return (ItemOuterClass.Combine) this.s2CDataBuilder_.getMessage();
            }


            public Builder setS2CData(ItemOuterClass.Combine value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CData(ItemOuterClass.Combine.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CData(ItemOuterClass.Combine value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != ItemOuterClass.Combine.getDefaultInstance()) {
                        this.s2CData_ = ItemOuterClass.Combine.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = ItemOuterClass.Combine.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public ItemOuterClass.Combine.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ItemOuterClass.Combine.Builder) getS2CDataFieldBuilder().getBuilder();
            }


            public ItemOuterClass.CombineOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null) {
                    return (ItemOuterClass.CombineOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.CombineOrBuilder) this.s2CData_;
            }


            private SingleFieldBuilder<ItemOuterClass.Combine, ItemOuterClass.Combine.Builder, ItemOuterClass.CombineOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder((GeneratedMessage) getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class CombineRequest
            extends GeneratedMessage
            implements CombineRequestOrBuilder {
        private static final CombineRequest defaultInstance = new CombineRequest(true);
        private final UnknownFieldSet unknownFields;

        private CombineRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CombineRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CombineRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CombineRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombineRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SDestID_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SNum_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SGridIndex_ = input.readInt32();
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
            return ItemHandler.internal_static_pomelo_area_CombineRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_CombineRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineRequest.class, Builder.class);
        }

        public static Parser<CombineRequest> PARSER = (Parser<CombineRequest>) new AbstractParser<CombineRequest>() {
            public ItemHandler.CombineRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.CombineRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_DESTID_FIELD_NUMBER = 1;
        private int c2SDestID_;
        public static final int C2S_NUM_FIELD_NUMBER = 2;
        private int c2SNum_;
        public static final int C2S_GRIDINDEX_FIELD_NUMBER = 3;
        private int c2SGridIndex_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CombineRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SDestID() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SDestID() {
            return this.c2SDestID_;
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


        public boolean hasC2SGridIndex() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SGridIndex() {
            return this.c2SGridIndex_;
        }


        private void initFields() {
            this.c2SDestID_ = 0;
            this.c2SNum_ = 0;
            this.c2SGridIndex_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SDestID()) {
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
                output.writeInt32(1, this.c2SDestID_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SNum_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SGridIndex_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SDestID_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SNum_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SGridIndex_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static CombineRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CombineRequest) PARSER.parseFrom(data);
        }


        public static CombineRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CombineRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CombineRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CombineRequest) PARSER.parseFrom(data);
        }


        public static CombineRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CombineRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CombineRequest parseFrom(InputStream input) throws IOException {
            return (CombineRequest) PARSER.parseFrom(input);
        }


        public static CombineRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CombineRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineRequest) PARSER.parseDelimitedFrom(input);
        }


        public static CombineRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CombineRequest parseFrom(CodedInputStream input) throws IOException {
            return (CombineRequest) PARSER.parseFrom(input);
        }


        public static CombineRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CombineRequest prototype) {
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
                implements ItemHandler.CombineRequestOrBuilder {
            private int bitField0_;


            private int c2SDestID_;


            private int c2SNum_;


            private int c2SGridIndex_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_CombineRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_CombineRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.CombineRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ItemHandler.CombineRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SDestID_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SGridIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_CombineRequest_descriptor;
            }


            public ItemHandler.CombineRequest getDefaultInstanceForType() {
                return ItemHandler.CombineRequest.getDefaultInstance();
            }


            public ItemHandler.CombineRequest build() {
                ItemHandler.CombineRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.CombineRequest buildPartial() {
                ItemHandler.CombineRequest result = new ItemHandler.CombineRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SDestID_ = this.c2SDestID_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNum_ = this.c2SNum_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SGridIndex_ = this.c2SGridIndex_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.CombineRequest) {
                    return mergeFrom((ItemHandler.CombineRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.CombineRequest other) {
                if (other == ItemHandler.CombineRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SDestID()) {
                    setC2SDestID(other.getC2SDestID());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                if (other.hasC2SGridIndex()) {
                    setC2SGridIndex(other.getC2SGridIndex());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SDestID()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.CombineRequest parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.CombineRequest) ItemHandler.CombineRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.CombineRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SDestID() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SDestID() {
                return this.c2SDestID_;
            }


            public Builder setC2SDestID(int value) {
                this.bitField0_ |= 0x1;
                this.c2SDestID_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SDestID() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SDestID_ = 0;
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


            public boolean hasC2SGridIndex() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SGridIndex() {
                return this.c2SGridIndex_;
            }


            public Builder setC2SGridIndex(int value) {
                this.bitField0_ |= 0x4;
                this.c2SGridIndex_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGridIndex() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SGridIndex_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class CombineResponse
            extends GeneratedMessage
            implements CombineResponseOrBuilder {
        private static final CombineResponse defaultInstance = new CombineResponse(true);
        private final UnknownFieldSet unknownFields;

        private CombineResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CombineResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CombineResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CombineResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombineResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ItemHandler.internal_static_pomelo_area_CombineResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_CombineResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineResponse.class, Builder.class);
        }

        public static Parser<CombineResponse> PARSER = (Parser<CombineResponse>) new AbstractParser<CombineResponse>() {
            public ItemHandler.CombineResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.CombineResponse(input, extensionRegistry);
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

        public Parser<CombineResponse> getParserForType() {
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


        public static CombineResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CombineResponse) PARSER.parseFrom(data);
        }


        public static CombineResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CombineResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CombineResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CombineResponse) PARSER.parseFrom(data);
        }


        public static CombineResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CombineResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CombineResponse parseFrom(InputStream input) throws IOException {
            return (CombineResponse) PARSER.parseFrom(input);
        }


        public static CombineResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CombineResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineResponse) PARSER.parseDelimitedFrom(input);
        }


        public static CombineResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CombineResponse parseFrom(CodedInputStream input) throws IOException {
            return (CombineResponse) PARSER.parseFrom(input);
        }


        public static CombineResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CombineResponse prototype) {
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
                implements ItemHandler.CombineResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_CombineResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_CombineResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.CombineResponse.class, Builder.class);
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
                if (ItemHandler.CombineResponse.alwaysUseFieldBuilders) ;
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
                return ItemHandler.internal_static_pomelo_area_CombineResponse_descriptor;
            }


            public ItemHandler.CombineResponse getDefaultInstanceForType() {
                return ItemHandler.CombineResponse.getDefaultInstance();
            }


            public ItemHandler.CombineResponse build() {
                ItemHandler.CombineResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.CombineResponse buildPartial() {
                ItemHandler.CombineResponse result = new ItemHandler.CombineResponse(this);
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
                if (other instanceof ItemHandler.CombineResponse) {
                    return mergeFrom((ItemHandler.CombineResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.CombineResponse other) {
                if (other == ItemHandler.CombineResponse.getDefaultInstance()) {
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
                ItemHandler.CombineResponse parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.CombineResponse) ItemHandler.CombineResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.CombineResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ItemHandler.CombineResponse.getDefaultInstance().getS2CMsg();
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


    public static final class ItemDetailPush
            extends GeneratedMessage
            implements ItemDetailPushOrBuilder {
        private static final ItemDetailPush defaultInstance = new ItemDetailPush(true);
        private final UnknownFieldSet unknownFields;

        private ItemDetailPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ItemDetailPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ItemDetailPush getDefaultInstance() {
            return defaultInstance;
        }

        public ItemDetailPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemDetailPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CData_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry));
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
            return ItemHandler.internal_static_pomelo_area_ItemDetailPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_ItemDetailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemDetailPush.class, Builder.class);
        }

        public static Parser<ItemDetailPush> PARSER = (Parser<ItemDetailPush>) new AbstractParser<ItemDetailPush>() {
            public ItemHandler.ItemDetailPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.ItemDetailPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private List<ItemOuterClass.ItemDetail> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ItemDetailPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<ItemOuterClass.ItemDetail> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getS2CDataCount() {
            return this.s2CData_.size();
        }


        public ItemOuterClass.ItemDetail getS2CData(int index) {
            return this.s2CData_.get(index);
        }


        public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) {
            return (ItemOuterClass.ItemDetailOrBuilder) this.s2CData_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            }
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


        public static ItemDetailPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ItemDetailPush) PARSER.parseFrom(data);
        }


        public static ItemDetailPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDetailPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemDetailPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ItemDetailPush) PARSER.parseFrom(data);
        }


        public static ItemDetailPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDetailPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemDetailPush parseFrom(InputStream input) throws IOException {
            return (ItemDetailPush) PARSER.parseFrom(input);
        }


        public static ItemDetailPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDetailPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ItemDetailPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemDetailPush) PARSER.parseDelimitedFrom(input);
        }


        public static ItemDetailPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDetailPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ItemDetailPush parseFrom(CodedInputStream input) throws IOException {
            return (ItemDetailPush) PARSER.parseFrom(input);
        }


        public static ItemDetailPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDetailPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ItemDetailPush prototype) {
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
                implements ItemHandler.ItemDetailPushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private List<ItemOuterClass.ItemDetail> s2CData_;


            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_ItemDetailPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_ItemDetailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.ItemDetailPush.class, Builder.class);
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
                if (ItemHandler.ItemDetailPush.alwaysUseFieldBuilders) {
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
                return ItemHandler.internal_static_pomelo_area_ItemDetailPush_descriptor;
            }


            public ItemHandler.ItemDetailPush getDefaultInstanceForType() {
                return ItemHandler.ItemDetailPush.getDefaultInstance();
            }


            public ItemHandler.ItemDetailPush build() {
                ItemHandler.ItemDetailPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.ItemDetailPush buildPartial() {
                ItemHandler.ItemDetailPush result = new ItemHandler.ItemDetailPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
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
                if (other instanceof ItemHandler.ItemDetailPush) {
                    return mergeFrom((ItemHandler.ItemDetailPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.ItemDetailPush other) {
                if (other == ItemHandler.ItemDetailPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
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
                        this.s2CDataBuilder_ = ItemHandler.ItemDetailPush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
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
                ItemHandler.ItemDetailPush parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.ItemDetailPush) ItemHandler.ItemDetailPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.ItemDetailPush) e.getUnfinishedMessage();
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


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<ItemOuterClass.ItemDetail> getS2CDataList() {
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


            public ItemOuterClass.ItemDetail getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (ItemOuterClass.ItemDetail) this.s2CDataBuilder_.getMessage(index);
            }


            public Builder setS2CData(int index, ItemOuterClass.ItemDetail value) {
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


            public Builder setS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.ItemDetail value) {
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


            public Builder addS2CData(int index, ItemOuterClass.ItemDetail value) {
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


            public Builder addS2CData(ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CData(Iterable<? extends ItemOuterClass.ItemDetail> values) {
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


            public ItemOuterClass.ItemDetail.Builder getS2CDataBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return (ItemOuterClass.ItemDetailOrBuilder) this.s2CData_.get(index);
                }
                return (ItemOuterClass.ItemDetailOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CData_);
            }


            public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder() {
                return (ItemOuterClass.ItemDetail.Builder) getS2CDataFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }


            public ItemOuterClass.ItemDetail.Builder addS2CDataBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }


            public List<ItemOuterClass.ItemDetail.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class CountItemChangePush
            extends GeneratedMessage
            implements CountItemChangePushOrBuilder {
        private static final CountItemChangePush defaultInstance = new CountItemChangePush(true);
        private final UnknownFieldSet unknownFields;

        private CountItemChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CountItemChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CountItemChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public CountItemChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CountItemChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CData_.add(input.readMessage(ItemOuterClass.CountItem.PARSER, extensionRegistry));
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
            return ItemHandler.internal_static_pomelo_area_CountItemChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_CountItemChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(CountItemChangePush.class, Builder.class);
        }

        public static Parser<CountItemChangePush> PARSER = (Parser<CountItemChangePush>) new AbstractParser<CountItemChangePush>() {
            public ItemHandler.CountItemChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.CountItemChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private List<ItemOuterClass.CountItem> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CountItemChangePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<ItemOuterClass.CountItem> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends ItemOuterClass.CountItemOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getS2CDataCount() {
            return this.s2CData_.size();
        }


        public ItemOuterClass.CountItem getS2CData(int index) {
            return this.s2CData_.get(index);
        }


        public ItemOuterClass.CountItemOrBuilder getS2CDataOrBuilder(int index) {
            return (ItemOuterClass.CountItemOrBuilder) this.s2CData_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            }
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


        public static CountItemChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CountItemChangePush) PARSER.parseFrom(data);
        }


        public static CountItemChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CountItemChangePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CountItemChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CountItemChangePush) PARSER.parseFrom(data);
        }


        public static CountItemChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CountItemChangePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CountItemChangePush parseFrom(InputStream input) throws IOException {
            return (CountItemChangePush) PARSER.parseFrom(input);
        }


        public static CountItemChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CountItemChangePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CountItemChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (CountItemChangePush) PARSER.parseDelimitedFrom(input);
        }


        public static CountItemChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CountItemChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CountItemChangePush parseFrom(CodedInputStream input) throws IOException {
            return (CountItemChangePush) PARSER.parseFrom(input);
        }


        public static CountItemChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CountItemChangePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CountItemChangePush prototype) {
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
                implements ItemHandler.CountItemChangePushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private List<ItemOuterClass.CountItem> s2CData_;


            private RepeatedFieldBuilder<ItemOuterClass.CountItem, ItemOuterClass.CountItem.Builder, ItemOuterClass.CountItemOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_CountItemChangePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_CountItemChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.CountItemChangePush.class, Builder.class);
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
                if (ItemHandler.CountItemChangePush.alwaysUseFieldBuilders) {
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
                return ItemHandler.internal_static_pomelo_area_CountItemChangePush_descriptor;
            }


            public ItemHandler.CountItemChangePush getDefaultInstanceForType() {
                return ItemHandler.CountItemChangePush.getDefaultInstance();
            }


            public ItemHandler.CountItemChangePush build() {
                ItemHandler.CountItemChangePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.CountItemChangePush buildPartial() {
                ItemHandler.CountItemChangePush result = new ItemHandler.CountItemChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
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
                if (other instanceof ItemHandler.CountItemChangePush) {
                    return mergeFrom((ItemHandler.CountItemChangePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.CountItemChangePush other) {
                if (other == ItemHandler.CountItemChangePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
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
                        this.s2CDataBuilder_ = ItemHandler.CountItemChangePush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
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
                ItemHandler.CountItemChangePush parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.CountItemChangePush) ItemHandler.CountItemChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.CountItemChangePush) e.getUnfinishedMessage();
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


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<ItemOuterClass.CountItem> getS2CDataList() {
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


            public ItemOuterClass.CountItem getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (ItemOuterClass.CountItem) this.s2CDataBuilder_.getMessage(index);
            }


            public Builder setS2CData(int index, ItemOuterClass.CountItem value) {
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


            public Builder setS2CData(int index, ItemOuterClass.CountItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(ItemOuterClass.CountItem value) {
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


            public Builder addS2CData(int index, ItemOuterClass.CountItem value) {
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


            public Builder addS2CData(ItemOuterClass.CountItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(int index, ItemOuterClass.CountItem.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CData(Iterable<? extends ItemOuterClass.CountItem> values) {
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


            public ItemOuterClass.CountItem.Builder getS2CDataBuilder(int index) {
                return (ItemOuterClass.CountItem.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.CountItemOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return (ItemOuterClass.CountItemOrBuilder) this.s2CData_.get(index);
                }
                return (ItemOuterClass.CountItemOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.CountItemOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CData_);
            }


            public ItemOuterClass.CountItem.Builder addS2CDataBuilder() {
                return (ItemOuterClass.CountItem.Builder) getS2CDataFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.CountItem.getDefaultInstance());
            }


            public ItemOuterClass.CountItem.Builder addS2CDataBuilder(int index) {
                return (ItemOuterClass.CountItem.Builder) getS2CDataFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.CountItem.getDefaultInstance());
            }


            public List<ItemOuterClass.CountItem.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.CountItem, ItemOuterClass.CountItem.Builder, ItemOuterClass.CountItemOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class FishItemPush
            extends GeneratedMessage
            implements FishItemPushOrBuilder {
        private static final FishItemPush defaultInstance = new FishItemPush(true);
        private final UnknownFieldSet unknownFields;

        private FishItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FishItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FishItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public FishItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FishItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.s2CItem_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CItem_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ItemHandler.internal_static_pomelo_area_FishItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_FishItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FishItemPush.class, Builder.class);
        }

        public static Parser<FishItemPush> PARSER = (Parser<FishItemPush>) new AbstractParser<FishItemPush>() {
            public ItemHandler.FishItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.FishItemPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_ITEM_FIELD_NUMBER = 2;
        private List<ItemOuterClass.MiniItem> s2CItem_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FishItemPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<ItemOuterClass.MiniItem> getS2CItemList() {
            return this.s2CItem_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList() {
            return (List) this.s2CItem_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getS2CItemCount() {
            return this.s2CItem_.size();
        }


        public ItemOuterClass.MiniItem getS2CItem(int index) {
            return this.s2CItem_.get(index);
        }


        public ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CItem_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CItem_ = Collections.emptyList();
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CCode_);
            }
            for (int i = 0; i < this.s2CItem_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.s2CItem_.get(i));
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
            for (int i = 0; i < this.s2CItem_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CItem_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static FishItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FishItemPush) PARSER.parseFrom(data);
        }


        public static FishItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FishItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FishItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FishItemPush) PARSER.parseFrom(data);
        }


        public static FishItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FishItemPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FishItemPush parseFrom(InputStream input) throws IOException {
            return (FishItemPush) PARSER.parseFrom(input);
        }


        public static FishItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static FishItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (FishItemPush) PARSER.parseDelimitedFrom(input);
        }


        public static FishItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static FishItemPush parseFrom(CodedInputStream input) throws IOException {
            return (FishItemPush) PARSER.parseFrom(input);
        }


        public static FishItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FishItemPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(FishItemPush prototype) {
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
                implements ItemHandler.FishItemPushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private List<ItemOuterClass.MiniItem> s2CItem_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CItemBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_FishItemPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_FishItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.FishItemPush.class, Builder.class);
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
                if (ItemHandler.FishItemPush.alwaysUseFieldBuilders) {
                    getS2CItemFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.s2CItemBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_FishItemPush_descriptor;
            }


            public ItemHandler.FishItemPush getDefaultInstanceForType() {
                return ItemHandler.FishItemPush.getDefaultInstance();
            }


            public ItemHandler.FishItemPush build() {
                ItemHandler.FishItemPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ItemHandler.FishItemPush buildPartial() {
                ItemHandler.FishItemPush result = new ItemHandler.FishItemPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if (this.s2CItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.s2CItem_ = this.s2CItem_;
                } else {
                    result.s2CItem_ = this.s2CItemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.FishItemPush) {
                    return mergeFrom((ItemHandler.FishItemPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ItemHandler.FishItemPush other) {
                if (other == ItemHandler.FishItemPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (this.s2CItemBuilder_ == null) {
                    if (!other.s2CItem_.isEmpty()) {
                        if (this.s2CItem_.isEmpty()) {
                            this.s2CItem_ = other.s2CItem_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.s2CItemBuilder_ = ItemHandler.FishItemPush.alwaysUseFieldBuilders ? getS2CItemFieldBuilder() : null;
                    } else {
                        this.s2CItemBuilder_.addAllMessages(other.s2CItem_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CItemCount(); i++) {
                    if (!getS2CItem(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.FishItemPush parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.FishItemPush) ItemHandler.FishItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.FishItemPush) e.getUnfinishedMessage();
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


            private void ensureS2CItemIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CItem_ = new ArrayList<>(this.s2CItem_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<ItemOuterClass.MiniItem> getS2CItemList() {
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


            public ItemOuterClass.MiniItem getS2CItem(int index) {
                if (this.s2CItemBuilder_ == null) {
                    return this.s2CItem_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.s2CItemBuilder_.getMessage(index);
            }


            public Builder setS2CItem(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setS2CItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CItem(ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CItem(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CItem(Iterable<? extends ItemOuterClass.MiniItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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


            public ItemOuterClass.MiniItem.Builder getS2CItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int index) {
                if (this.s2CItemBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CItem_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CItemBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList() {
                if (this.s2CItemBuilder_ != null) {
                    return this.s2CItemBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CItem_);
            }


            public ItemOuterClass.MiniItem.Builder addS2CItemBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addS2CItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getS2CItemBuilderList() {
                return getS2CItemFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CItemFieldBuilder() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItemBuilder_ = new RepeatedFieldBuilder(this.s2CItem_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CItem_ = null;
                }
                return this.s2CItemBuilder_;
            }
        }
    }


    public static final class RewardItemPush
            extends GeneratedMessage
            implements RewardItemPushOrBuilder {
        private static final RewardItemPush defaultInstance = new RewardItemPush(true);
        private final UnknownFieldSet unknownFields;

        private RewardItemPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardItemPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardItemPush getDefaultInstance() {
            return defaultInstance;
        }

        public RewardItemPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardItemPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.s2CItem_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CItem_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ItemHandler.internal_static_pomelo_area_RewardItemPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHandler.internal_static_pomelo_area_RewardItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardItemPush.class, Builder.class);
        }

        public static Parser<RewardItemPush> PARSER = (Parser<RewardItemPush>) new AbstractParser<RewardItemPush>() {
            public ItemHandler.RewardItemPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHandler.RewardItemPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_ITEM_FIELD_NUMBER = 2;
        private List<ItemOuterClass.MiniItem> s2CItem_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardItemPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<ItemOuterClass.MiniItem> getS2CItemList() {
            return this.s2CItem_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList() {
            return (List) this.s2CItem_;
        }

        public int getS2CItemCount() {
            return this.s2CItem_.size();
        }

        public ItemOuterClass.MiniItem getS2CItem(int index) {
            return this.s2CItem_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CItem_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CItem_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            for (int i = 0; i < this.s2CItem_.size(); i++) output.writeMessage(2, (MessageLite) this.s2CItem_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            for (int i = 0; i < this.s2CItem_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CItem_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RewardItemPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardItemPush) PARSER.parseFrom(data);
        }

        public static RewardItemPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardItemPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardItemPush) PARSER.parseFrom(data);
        }

        public static RewardItemPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardItemPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardItemPush parseFrom(InputStream input) throws IOException {
            return (RewardItemPush) PARSER.parseFrom(input);
        }

        public static RewardItemPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardItemPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RewardItemPush parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardItemPush) PARSER.parseDelimitedFrom(input);
        }

        public static RewardItemPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardItemPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RewardItemPush parseFrom(CodedInputStream input) throws IOException {
            return (RewardItemPush) PARSER.parseFrom(input);
        }

        public static RewardItemPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardItemPush) PARSER.parseFrom(input, extensionRegistry);
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

        public static Builder newBuilder(RewardItemPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ItemHandler.RewardItemPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<ItemOuterClass.MiniItem> s2CItem_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CItemBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHandler.internal_static_pomelo_area_RewardItemPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHandler.internal_static_pomelo_area_RewardItemPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHandler.RewardItemPush.class, Builder.class);
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
                if (ItemHandler.RewardItemPush.alwaysUseFieldBuilders)
                    getS2CItemFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.s2CItemBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHandler.internal_static_pomelo_area_RewardItemPush_descriptor;
            }

            public ItemHandler.RewardItemPush getDefaultInstanceForType() {
                return ItemHandler.RewardItemPush.getDefaultInstance();
            }

            public ItemHandler.RewardItemPush build() {
                ItemHandler.RewardItemPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ItemHandler.RewardItemPush buildPartial() {
                ItemHandler.RewardItemPush result = new ItemHandler.RewardItemPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.s2CItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.s2CItem_ = Collections.unmodifiableList(this.s2CItem_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.s2CItem_ = this.s2CItem_;
                } else {
                    result.s2CItem_ = this.s2CItemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ItemHandler.RewardItemPush)
                    return mergeFrom((ItemHandler.RewardItemPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHandler.RewardItemPush other) {
                if (other == ItemHandler.RewardItemPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (this.s2CItemBuilder_ == null) {
                    if (!other.s2CItem_.isEmpty()) {
                        if (this.s2CItem_.isEmpty()) {
                            this.s2CItem_ = other.s2CItem_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.s2CItemBuilder_ = ItemHandler.RewardItemPush.alwaysUseFieldBuilders ? getS2CItemFieldBuilder() : null;
                    } else {
                        this.s2CItemBuilder_.addAllMessages(other.s2CItem_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CItemCount(); i++) {
                    if (!getS2CItem(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ItemHandler.RewardItemPush parsedMessage = null;
                try {
                    parsedMessage = (ItemHandler.RewardItemPush) ItemHandler.RewardItemPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ItemHandler.RewardItemPush) e.getUnfinishedMessage();
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

            private void ensureS2CItemIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CItem_ = new ArrayList<>(this.s2CItem_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<ItemOuterClass.MiniItem> getS2CItemList() {
                if (this.s2CItemBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CItem_);
                return this.s2CItemBuilder_.getMessageList();
            }

            public int getS2CItemCount() {
                if (this.s2CItemBuilder_ == null)
                    return this.s2CItem_.size();
                return this.s2CItemBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getS2CItem(int index) {
                if (this.s2CItemBuilder_ == null)
                    return this.s2CItem_.get(index);
                return (ItemOuterClass.MiniItem) this.s2CItemBuilder_.getMessage(index);
            }

            public Builder setS2CItem(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItem(ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CItem(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CItemBuilder_ == null) {
                    ensureS2CItemIsMutable();
                    this.s2CItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CItem(Iterable<? extends ItemOuterClass.MiniItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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

            public ItemOuterClass.MiniItem.Builder getS2CItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int index) {
                if (this.s2CItemBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CItem_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList() {
                if (this.s2CItemBuilder_ != null)
                    return this.s2CItemBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CItem_);
            }

            public ItemOuterClass.MiniItem.Builder addS2CItemBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addS2CItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CItemFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getS2CItemBuilderList() {
                return getS2CItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CItemFieldBuilder() {
                if (this.s2CItemBuilder_ == null) {
                    this.s2CItemBuilder_ = new RepeatedFieldBuilder(this.s2CItem_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CItem_ = null;
                }
                return this.s2CItemBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021itemHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\",\n\033QueryItemStatusUpdateNotify\022\r\n\005index\030\001 \002(\005\"\033\n\031GetAllEquipDetailsRequest\"k\n\032GetAllEquipDetailsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\ts2c_items\030\003 \003(\0132\027.pomelo.item.ItemDetail\".\n\030GetCombineFormulaRequest\022\022\n\nc2s_destID\030\001 \002(\005\"f\n\031GetCombineFormulaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022&\n\bs2c_data\030\003 \001(\0132\024.pomelo.item.Combine\"L\n\016Co", "mbineRequest\022\022\n\nc2s_destID\030\001 \002(\005\022\017\n\007c2s_num\030\002 \002(\005\022\025\n\rc2s_gridIndex\030\003 \001(\005\"4\n\017CombineResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"M\n\016ItemDetailPush\022\020\n\bs2c_code\030\001 \002(\005\022)\n\bs2c_data\030\002 \003(\0132\027.pomelo.item.ItemDetail\"Q\n\023CountItemChangePush\022\020\n\bs2c_code\030\001 \002(\005\022(\n\bs2c_data\030\002 \003(\0132\026.pomelo.item.CountItem\"I\n\fFishItemPush\022\020\n\bs2c_code\030\001 \002(\005\022'\n\bs2c_item\030\002 \003(\0132\025.pomelo.item.MiniItem\"K\n\016RewardItemPush\022\020\n\bs2c_code\030\001 \002(\005\022", "'\n\bs2c_item\030\002 \003(\0132\025.pomelo.item.MiniItem2\003\n\013itemHandler\022l\n\031getAllEquipDetailsRequest\022&.pomelo.area.GetAllEquipDetailsRequest\032'.pomelo.area.GetAllEquipDetailsResponse\022U\n\033queryItemStatusUpdateNotify\022(.pomelo.area.QueryItemStatusUpdateNotify\032\f.pomelo.Void\022i\n\030getCombineFormulaRequest\022%.pomelo.area.GetCombineFormulaRequest\032&.pomelo.area.GetCombineFormulaResponse\022K\n\016combineRequest\022\033.pomelo.area.Combine", "Request\032\034.pomelo.area.CombineResponse2\002\n\bitemPush\0227\n\ffishItemPush\022\031.pomelo.area.FishItemPush\032\f.pomelo.Void\022E\n\023countItemChangePush\022 .pomelo.area.CountItemChangePush\032\f.pomelo.Void\022;\n\016itemDetailPush\022\033.pomelo.area.ItemDetailPush\032\f.pomelo.Void\022;\n\016rewardItemPush\022\033.pomelo.area.RewardItemPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ItemHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_QueryItemStatusUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryItemStatusUpdateNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryItemStatusUpdateNotify_descriptor, new String[]{"Index"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllEquipDetailsRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllEquipDetailsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllEquipDetailsRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllEquipDetailsResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllEquipDetailsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllEquipDetailsResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CItems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetCombineFormulaRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCombineFormulaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCombineFormulaRequest_descriptor, new String[]{"C2SDestID"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetCombineFormulaResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCombineFormulaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCombineFormulaResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CombineRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CombineRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CombineRequest_descriptor, new String[]{"C2SDestID", "C2SNum", "C2SGridIndex"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CombineResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CombineResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CombineResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ItemDetailPush_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ItemDetailPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ItemDetailPush_descriptor, new String[]{"S2CCode", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CountItemChangePush_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CountItemChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CountItemChangePush_descriptor, new String[]{"S2CCode", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_FishItemPush_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FishItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FishItemPush_descriptor, new String[]{"S2CCode", "S2CItem"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardItemPush_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardItemPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardItemPush_descriptor, new String[]{"S2CCode", "S2CItem"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface RewardItemPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<ItemOuterClass.MiniItem> getS2CItemList();

        ItemOuterClass.MiniItem getS2CItem(int param1Int);

        int getS2CItemCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int param1Int);
    }

    public static interface FishItemPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<ItemOuterClass.MiniItem> getS2CItemList();

        ItemOuterClass.MiniItem getS2CItem(int param1Int);

        int getS2CItemCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CItemOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CItemOrBuilder(int param1Int);
    }

    public static interface CountItemChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<ItemOuterClass.CountItem> getS2CDataList();

        ItemOuterClass.CountItem getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends ItemOuterClass.CountItemOrBuilder> getS2CDataOrBuilderList();

        ItemOuterClass.CountItemOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface ItemDetailPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<ItemOuterClass.ItemDetail> getS2CDataList();

        ItemOuterClass.ItemDetail getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CDataOrBuilderList();

        ItemOuterClass.ItemDetailOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface CombineResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface CombineRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SDestID();

        int getC2SDestID();

        boolean hasC2SNum();

        int getC2SNum();

        boolean hasC2SGridIndex();

        int getC2SGridIndex();
    }

    public static interface GetCombineFormulaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        ItemOuterClass.Combine getS2CData();

        ItemOuterClass.CombineOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetCombineFormulaRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SDestID();

        int getC2SDestID();
    }

    public static interface GetAllEquipDetailsResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ItemOuterClass.ItemDetail> getS2CItemsList();

        ItemOuterClass.ItemDetail getS2CItems(int param1Int);

        int getS2CItemsCount();

        List<? extends ItemOuterClass.ItemDetailOrBuilder> getS2CItemsOrBuilderList();

        ItemOuterClass.ItemDetailOrBuilder getS2CItemsOrBuilder(int param1Int);
    }

    public static interface GetAllEquipDetailsRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface QueryItemStatusUpdateNotifyOrBuilder extends MessageOrBuilder {
        boolean hasIndex();

        int getIndex();
    }
}


